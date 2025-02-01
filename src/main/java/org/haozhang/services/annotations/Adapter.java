package org.haozhang.services.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Adapter {
    String[] value();

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @Documented
    @interface Method {
        String[] value();
    }
}
