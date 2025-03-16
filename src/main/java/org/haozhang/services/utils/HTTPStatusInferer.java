package org.haozhang.services.utils;

import jakarta.annotation.Nonnull;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HTTPStatusInferer {
    @Nonnull
    public Response.Status from(@Nonnull Throwable cause) {
        return switch (cause) {
            case jakarta.ws.rs.WebApplicationException exception ->
            default -> Response.Status.INTERNAL_SERVER_ERROR;
        };
    }

    @Nonnull
    public Response.Status from(@Nonnull WebApplicationException exception) {
        return exception
            .getResponse()
            .getStatusInfo()
            .toEnum();
    }
}
