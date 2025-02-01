package org.haozhang.services.utils.containers;

import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.Map;

public class DelegatingMultiMap<K, V> extends AbstractMultiMap<K, V> {
    public DelegatingMultiMap(@Nonnull Map<? extends K, ? extends List<? extends V>> delegate) {
        super(delegate);
    }
}
