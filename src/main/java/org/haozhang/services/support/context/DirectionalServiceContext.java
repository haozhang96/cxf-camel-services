package org.haozhang.services.support.context;

import jakarta.activation.DataHandler;
import org.haozhang.services.support.PropertyHolder;

import java.net.HttpCookie;
import java.util.Map;

public interface DirectionalServiceContext extends PropertyHolder.Enumerable {
    Map<String, Object> getHeaders();

    Map<String, HttpCookie> getCookies();

    Map<String, DataHandler> getAttachments();
}
