package org.haozhang.services.enums;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.Optional;

/**
 * This interface represents the overall contract for {@link java.lang.Enum} and is meant to be implemented by actual
 *   {@link java.lang.Enum} implementations. Other interfaces simply extend this method to ensure
 *
 * @param <E> The {@link java.lang.Enum} type represented by this {@link Enum}
 */
public interface Enum<E extends java.lang.Enum<E> & Enum<E>> extends Constable, Comparable<E>, Serializable {
    //==================================================================================================================
    // Enum Implementation Methods
    //==================================================================================================================

    /**
     * @see java.lang.Enum#ordinal()
     */
    int ordinal();

    /**
     * @see java.lang.Enum#name()
     */
    @Nonnull
    String name();

    /**
     * @see java.lang.Enum#getDeclaringClass()
     */
    @Nonnull
    Class<E> getDeclaringClass();

    //==================================================================================================================
    // Constable Implementation Methods
    //==================================================================================================================

    /**
     * @see java.lang.Enum#describeConstable()
     */
    @Override
    Optional<java.lang.Enum.EnumDesc<E>> describeConstable();

    //==================================================================================================================
    // Comparable Implementation Methods
    //==================================================================================================================

    /**
     * @see java.lang.Enum#compareTo(E)
     */
    @Override
    int compareTo(@Nonnull E other);

    //==================================================================================================================
    // Object Implementation Methods
    //==================================================================================================================

    /**
     * @see java.lang.Enum#equals(Object)
     */
    boolean equals(@Nullable Object other);

    /**
     * @see java.lang.Enum#hashCode()
     */
    int hashCode();

    /**
     * @see java.lang.Enum#toString()
     */
    String toString();
}
