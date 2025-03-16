package org.haozhang.services.models.support;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.function.Supplier;

public interface ModelMapperSelector<M extends ObjectMapper> extends Supplier<M> {

}
