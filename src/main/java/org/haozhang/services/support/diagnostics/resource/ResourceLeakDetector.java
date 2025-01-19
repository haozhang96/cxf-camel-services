package org.haozhang.services.support.diagnostics.resource;

import jakarta.annotation.Nonnull;
import org.haozhang.services.constants.SharedObjects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.lang.ref.Cleaner;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class ResourceLeakDetector implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final Cleaner CLEANER = Cleaner.create();
    private static final ConcurrentMap<Integer, Cleaner.Cleanable> RESOURCES = new ConcurrentHashMap<>();
    private static final ReferenceQueue<AutoCloseable> QUEUE = new ReferenceQueue<>();

    @Nonnull
    private final WeakReference<AutoCloseable> resource;

    private final String toString;

    private final int hashCode;

    @Nonnull
    private final String stackTrace = getStackTrace();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    private ResourceLeakDetector(@Nonnull AutoCloseable resource) {
        this.resource = new WeakReference<>(resource, QUEUE);
        toString = Objects.toIdentityString(resource);
        hashCode = System.identityHashCode(resource);
    }

    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    @SuppressWarnings("CapturingCleaner")
    public static void register(@Nonnull AutoCloseable resource) {
        RESOURCES.put(System.identityHashCode(resource), CLEANER.register(resource, new ResourceLeakDetector(resource)));
    }

    public static void deregister(@Nonnull AutoCloseable resource) {
        try {
            RESOURCES.remove(System.identityHashCode(resource));
        } finally {
            Reference.reachabilityFence(resource);
        }
    }

    //==================================================================================================================
    // Runnable Implementation Methods
    //==================================================================================================================

    @Override
    public void run() {
        if (resource.refersTo(null) && RESOURCES.remove(hashCode) == null) {
            // The resource is no longer accessible to us.
            return;
        } else {
            LOGGER.warn("Potential resource leak detected: {}{}", toString, stackTrace);
        }

        final var deadline = System.currentTimeMillis() + 5L;
        Reference<? extends AutoCloseable> resourceReference = resource;
        do {
            try (var resource = resourceReference.get()) {
                if (resource != null) {
                    LOGGER.warn("Releasing resource: {}", resource);
                }
            } catch (Exception exception) {
                LOGGER.warn("Failed to release resource; ignoring", exception);
            }
        } while ((resourceReference = QUEUE.poll()) != null && System.currentTimeMillis() < deadline);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    @Nonnull
    private String getStackTrace() {
        return SharedObjects
            .STACK_WALKER
            .walk(stackFrames ->
                stackFrames
                    .dropWhile(stackFrame -> stackFrame.getDeclaringClass() == getClass())
                    .skip(1L)
                    .map(StackWalker.StackFrame::toString)
                    .collect(Collectors.joining(System.lineSeparator() + "\t", System.lineSeparator() + "\t", ""))
            );
    }
}
