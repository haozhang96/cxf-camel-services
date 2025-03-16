package org.haozhang.services.support;

import jakarta.annotation.Nonnull;
import org.haozhang.services.support.esoteric.Unchecked;

public interface Castable {
    @Nonnull
    default <T extends Castable> T as() {
        return Unchecked.cast(this);
    }

    @Nonnull
    default <T> T as(@Nonnull Class<T> type) {
        return type.cast(this);
    }
}
