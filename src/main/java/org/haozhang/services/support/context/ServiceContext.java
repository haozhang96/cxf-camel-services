package org.haozhang.services.support.context;

import org.haozhang.services.support.PropertyHolder;
import org.springframework.http.HttpMethod;

import java.util.Optional;

public interface ServiceContext extends PropertyHolder.Enumerable {
    interface Request extends DirectionalServiceContext {
        Optional<HttpMethod> getMethod();
    }

    interface Response extends DirectionalServiceContext {

    }
}
