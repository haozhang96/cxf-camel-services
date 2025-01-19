package org.haozhang.services.support;

import jakarta.annotation.Nonnull;

import java.nio.charset.Charset;
import java.util.Optional;

/**
 * TODO
 */
public interface PayloadHolder {
    /**
     * Retrieve the payload held
     */
    default Optional<byte[]> getPayload() {
        return getPayload(byte[].class);
    }

    default Optional<String> getPayload(@Nonnull Charset charset) {
        return getPayload(String.class)
            .or(() -> getPayload().map(payload -> new String(payload, charset)));
    }

    @Nonnull
    <T> Optional<T> getPayload(@Nonnull Class<T> type);
}
