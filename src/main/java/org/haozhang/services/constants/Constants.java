package org.haozhang.services.constants;

/**
 * This interface serves as the base for other constant interfaces by intentionally creating a compilation clash with
 *   {@link Object}.
 */
public interface Constants {
    /**
     * @deprecated Do not implement this constant interface.
     */
    @Deprecated(forRemoval = true)
    Constants clone() throws Throwable;
}
