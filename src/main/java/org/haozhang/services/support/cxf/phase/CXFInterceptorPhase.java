package org.haozhang.services.support.cxf.phase;

import org.haozhang.services.enums.TransitionStateEnum;

import java.util.Iterator;

public interface CXFInterceptorPhase<E extends java.lang.Enum<E> & CXFInterceptorPhase<E>> extends TransitionStateEnum<E>, Iterator<E> {
}
