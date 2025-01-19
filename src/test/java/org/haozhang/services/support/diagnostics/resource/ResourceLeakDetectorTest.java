package org.haozhang.services.support.diagnostics.resource;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ResourceLeakDetectorTest {
    @Test
    void leak() throws InterruptedException {
        try {
            new Resource();
            log.info("Hi");
            System.gc();
        } finally {
            Thread.currentThread().join();
        }
    }

    @Test
    void noLeakInlined() {
        new Resource().close();
    }

    @Test
    void noLeakUsingTryWithResource() {
        try (var resource = new Resource()) {
            log.info("Closing resource: {}", resource);
        }
    }

    private static final class Resource implements AutoCloseable {
        private Resource() {
            ResourceLeakDetector.register(this);
        }

        @Override
        public void close() {
            ResourceLeakDetector.deregister(this);
        }
    }
}
