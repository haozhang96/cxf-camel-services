package org.haozhang.services.constants;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface SharedObjects extends Constants {
    StackWalker STACK_WALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
    ClassLoader CLASS_LOADER = STACK_WALKER.getCallerClass().getClassLoader();
    ObjectMapper OBJECT_MAPPER = new ObjectMapper().findAndRegisterModules();
}
