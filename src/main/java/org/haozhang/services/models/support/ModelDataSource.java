package org.haozhang.services.models.support;

import jakarta.activation.DataSource;
import jakarta.annotation.Nonnull;
import org.haozhang.services.models.Model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface ModelDataSource extends DataSource {
    @Nonnull
    Model.Context.Type getType();

    @Override
    default String getContentType() {
        return getType().toMediaType().toString();
    }

    @Override
    default String getName() {

    }

    @Override
    default InputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    default OutputStream getOutputStream() throws IOException {
        return null;
    }
}
