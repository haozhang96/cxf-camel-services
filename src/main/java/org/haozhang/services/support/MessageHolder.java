package org.haozhang.services.support;

import java.util.Optional;

public interface MessageHolder<M> {
    Optional<M> getMessage();
}
