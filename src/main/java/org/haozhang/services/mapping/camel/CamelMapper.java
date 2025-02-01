package org.haozhang.services.mapping.camel;

import jakarta.annotation.Nonnull;
import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.haozhang.services.annotations.Adapter;
import org.haozhang.services.mapping.Mapper;

@Adapter({"apply(I)", "apply(Exchange, I)"})
public interface CamelMapper<I, O> extends Mapper<I, O> {
    @Nonnull
    @Override
    @Adapter.Method("apply(Exchange, I)")
    default O apply(@Nonnull @Body I input) {
        return apply(null, input);
    }

    @Nonnull
    @Adapter.Method("apply(I)")
    default O apply(Exchange exchange, @Nonnull @Body I input) {
        return apply(input);
    }
}
