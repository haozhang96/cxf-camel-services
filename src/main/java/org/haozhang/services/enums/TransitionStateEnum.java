package org.haozhang.services.enums;

import jakarta.annotation.Nonnull;

import java.util.Iterator;

public interface TransitionStateEnum<E extends java.lang.Enum<E> & Enum<E>> extends Enum<E>, Iterator<E> {
    default boolean canTransitionTo(@Nonnull E state) {
        return Math.abs(state.ordinal() - ordinal()) <= 1;
    }

    @Override
    default boolean hasNext() {
        return ordinal() < getDeclaringClass().getEnumConstants().length - 1;
    }

    @Override
    default E next() {

    }

    default boolean hasPrevious() {

    }

    E previous();
}
