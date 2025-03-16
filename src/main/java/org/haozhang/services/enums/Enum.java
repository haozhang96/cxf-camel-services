package org.haozhang.services.enums;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.Optional;

/**
 * This interface represents the overall contract for {@link java.lang.Enum} and is meant to be implemented by actual
 *   {@link java.lang.Enum} implementations. Other interfaces simply extend this interface to encourage actual
 *   {@link java.lang.Enum} implementations.
 */
public interface Enum extends Constable, Serializable {
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
    Class<? extends java.lang.Enum<? extends Enum>> getDeclaringClass();

    //==================================================================================================================
    // Constable Implementation Methods
    //==================================================================================================================

    /**
     * @see java.lang.Enum#describeConstable()
     */
    @Override
    Optional<? extends java.lang.Enum.EnumDesc<? extends Enum>> describeConstable();

    //==================================================================================================================
    // Object Implementation Methods
    //==================================================================================================================

    /**
     * @see java.lang.Enum#equals(Object)
     */
    @Override
    boolean equals(@Nullable Object other);

    /**
     * @see java.lang.Enum#hashCode()
     */
    @Override
    int hashCode();

    /**
     * @see java.lang.Enum#toString()
     */
    @Override
    String toString();
}
