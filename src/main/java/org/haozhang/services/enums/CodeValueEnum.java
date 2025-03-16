package org.haozhang.services.enums;

import jakarta.annotation.Nonnull;

public interface CodeValueEnum<C, V> extends Enum {
    @Nonnull
    C code();

    @Nonnull
    V value();
}
