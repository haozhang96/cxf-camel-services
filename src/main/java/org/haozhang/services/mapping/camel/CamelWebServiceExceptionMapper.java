package org.haozhang.services.mapping.camel;

import org.haozhang.services.mapping.WebServiceExceptionMapper;

public interface CamelWebServiceExceptionMapper<I extends Exception, O> extends CamelMapper<I, O>, WebServiceExceptionMapper<I, O> {
}
