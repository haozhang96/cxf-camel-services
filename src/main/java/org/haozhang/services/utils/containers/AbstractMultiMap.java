package org.haozhang.services.utils.containers;

import jakarta.annotation.Nonnull;
import org.haozhang.services.support.esoteric.Unchecked;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

import java.util.List;
import java.util.Map;

public abstract class AbstractMultiMap<K, V> extends MultiValueMapAdapter<K, V> implements MultiMap<K, V> {
    protected AbstractMultiMap(@Nonnull Map<? extends K, ? extends List<? extends V>> delegate) {
        super(Unchecked.cast(delegate));
    }

    protected static <K, V> Map<K, List<V>> adapt(@Nonnull Map<? extends K, ? extends V> map) {
        return MultiValueMap.fromSingleValue(Unchecked.cast(map));
    }
}
