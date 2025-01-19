package org.haozhang.services.support;

import jakarta.annotation.Nonnull;

import java.util.Map;
import java.util.Optional;

/**
 * This interface defines an object that can hold arbitrary properties.
 */
public interface PropertyHolder {
    //==================================================================================================================
    // Implementation Methods
    //==================================================================================================================

    /**
     * Retrieve the property with a given name from this {@link PropertyHolder}, if available.
     *
     * @param name The name of the property to retrieve from this {@link PropertyHolder}, if available
     * @return An {@link Optional} holding
     */
    @Nonnull
    Optional<Object> getProperty(@Nonnull String name);

    //==================================================================================================================
    // Enumerable Property Holder
    //==================================================================================================================

    /**
     * This interface is an extension of {@link PropertyHolder} that can enumerate all of its available properties.
     */
    interface Enumerable extends PropertyHolder {
        //==============================================================================================================
        // Implementation Methods
        //==============================================================================================================

        /**
         * Retrieve all the available properties of this {@link Enumerable} as a {@link Map}.
         */
        @Nonnull
        Map<String, Object> getProperties();

        //==============================================================================================================
        // PropertyHolder Implementation Methods
        //==============================================================================================================

        @Nonnull
        @Override
        default Optional<Object> getProperty(@Nonnull String name) {
            return Optional.ofNullable(getProperties().get(name));
        }
    }
}
