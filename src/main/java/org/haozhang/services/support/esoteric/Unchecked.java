package org.haozhang.services.support.esoteric;

import org.haozhang.services.support.diagnostics.CodeWarnings;

@SuppressWarnings({CodeWarnings.Compiler.UNCHECKED_TYPE_USAGE, CodeWarnings.Compiler.RAW_TYPE_USAGE})
public interface Unchecked {
    static <T, U extends T> U cast(T object) {
        return (U) object;
    }

    static <T, U extends T> U[] cast(T... objects) {
        return (U[]) objects;
    }

    static <E extends Enum<?>> E cast(Enum enumeration) {
        return (E) enumeration;
    }
}
