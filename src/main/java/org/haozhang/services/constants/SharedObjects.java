package org.haozhang.services.constants;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface SharedObjects {
    StackWalker STACK_WALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
    ClassLoader CLASS_LOADER = STACK_WALKER.getCallerClass().getClassLoader();
    ObjectMapper JSON = new ObjectMapper().findAndRegisterModules();
}
