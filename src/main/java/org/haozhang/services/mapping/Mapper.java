package org.haozhang.services.mapping;

import jakarta.annotation.Nonnull;

import java.util.function.Function;

@FunctionalInterface
public interface Mapper<I, O> extends Function<I, O> {
    @Nonnull
    @Override
    default <V> Mapper<V, O> compose(@Nonnull Function<? super V, ? extends I> before) {
        return Function.super.compose(before)::apply;
    }

    @Nonnull
    @Override
    default <V> Mapper<I, V> andThen(@Nonnull Function<? super O, ? extends V> after) {
        return Function.super.andThen(after)::apply;
    }
}
