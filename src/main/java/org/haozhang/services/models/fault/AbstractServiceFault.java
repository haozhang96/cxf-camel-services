package org.haozhang.services.models.fault;

import jakarta.xml.ws.WebFault;
import org.haozhang.services.exceptions.ServiceException;

@WebFault
public abstract class AbstractServiceFault extends ServiceException implements ServiceFault {
}
