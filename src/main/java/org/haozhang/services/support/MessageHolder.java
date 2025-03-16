package org.haozhang.services.support;

import java.util.Optional;

/**
 * This interface defines an object which may hold a stateful message.
 *
 * @param <M> The type of message held by this {@link MessageHolder}
 */
public interface MessageHolder<M> {
    Optional<? extends M> getMessage();
}
