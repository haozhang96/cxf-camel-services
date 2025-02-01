package org.haozhang.services.mapping;

import jakarta.annotation.Nonnull;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

@FunctionalInterface
public interface WebServiceExceptionMapper<I extends Exception, O> extends Mapper<I, O>, ExceptionMapper<I> {
    @Override
    default Response toResponse(@Nonnull I exception) {
        return null;
    }
}
