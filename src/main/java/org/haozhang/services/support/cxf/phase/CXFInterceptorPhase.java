package org.haozhang.services.support.cxf.phase;

import org.apache.cxf.phase.Phase;
import org.haozhang.services.enums.TransitionStateEnum;

import java.util.Iterator;

public interface CXFInterceptorPhase extends TransitionStateEnum, Iterator<Phase> {
    @Override
    default boolean hasNext() {
        return false;
    }

    @Override
    default Phase next() {
        return null;
    }
}
