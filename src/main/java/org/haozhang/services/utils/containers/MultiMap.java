package org.haozhang.services.utils.containers;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import jakarta.annotation.Nonnull;
import jakarta.ws.rs.core.AbstractMultivaluedMap;
import jakarta.ws.rs.core.MultivaluedMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

/**
 * This interface is a {@link Map} which holds
 *
 * @param <K>
 * @param <V>
 */
public interface MultiMap<K, V> extends MultiValueMap<K, V> {
    static <K, V> MultiMap<K, V> of() {
        return of(Map.of());
    }

    static <K, V> MultiMap<K, V> adapt(@Nonnull Map<? extends K, ? extends V> map) {
        return of(AbstractMultiMap.adapt(map));
    }

    static <K, V> MultiMap<K, V> of(@Nonnull Map<? extends K, ? extends List<? extends V>> map) {
        return new DelegatingMultiMap<>(map);
    }

    @Nonnull
    default MultivaluedMap<K, V> toJAXRS() {
        return new AbstractMultivaluedMap<>(this) {};
    }

    default Multimap<K, V> toGuava() {
        return Multimaps.forMap(this);
    }

    default MultiValueMap<K, V> toSpring() {
        return this;
    }
}
