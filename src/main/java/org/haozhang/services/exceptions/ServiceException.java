package org.haozhang.services.exceptions;

import jakarta.annotation.Nonnull;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.io.Serial;

public class ServiceException extends WebApplicationException {
    private static final @Serial long serialVersionUID = 1L;

    public ServiceException() {

    }

    @Nonnull
    @Override
    public Response getResponse() {
        return super.getResponse();
    }
}
