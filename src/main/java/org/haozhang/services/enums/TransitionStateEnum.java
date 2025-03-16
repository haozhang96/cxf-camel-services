package org.haozhang.services.enums;

import jakarta.annotation.Nonnull;
import org.haozhang.services.support.esoteric.Unchecked;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface TransitionStateEnum<E extends java.lang.Enum<E> & TransitionStateEnum<E>> extends Enum, Iterator<E> {
    default boolean canTransitionTo(@Nonnull E state) {
        return Math.abs(state.ordinal() - ordinal()) <= 1;
    }

    @Override
    default boolean hasNext() {
        return ordinal() < getDeclaringClass().getEnumConstants().length - 1;
    }

    @Nonnull
    @Override
    default E next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no more transition states after this: " + this);
        }

        return Unchecked.cast(getDeclaringClass().getEnumConstants()[ordinal() + 1]);
    }

    default boolean hasPrevious() {
        return ordinal() > 0;
    }

    @Nonnull
    default E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException("There are no more transition states before this: " + this);
        }

        return Unchecked.cast(getDeclaringClass().getEnumConstants()[ordinal() - 1]);
    }
}
