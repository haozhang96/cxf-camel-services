package org.haozhang.services.support.esoteric;

@SuppressWarnings("unchecked")
public interface Unchecked {
    static <T, U extends T> U cast(T object) {
        return (U) object;
    }

    static <T, U extends T> U[] cast(T... objects) {
        return (U[]) objects;
    }
}
