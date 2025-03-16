package org.haozhang.services.utils;

import jakarta.annotation.Nonnull;
import jakarta.ws.rs.core.Response;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionUtils {
    @Nonnull
    public Response.Status inferStatus(@Nonnull Throwable cause) {
        return switch (cause) {
            default -> Response.Status.INTERNAL_SERVER_ERROR;
        };
    }
}
