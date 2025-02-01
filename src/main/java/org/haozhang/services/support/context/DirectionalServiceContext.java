package org.haozhang.services.support.context;

import jakarta.activation.DataHandler;
import org.haozhang.services.support.PropertyHolder;
import org.haozhang.services.utils.containers.MultiMap;

import java.net.HttpCookie;
import java.util.Map;

public interface DirectionalServiceContext extends PropertyHolder.Enumerable {
    MultiMap<String, String> getHeaders();

    Map<String, HttpCookie> getCookies();

    Map<String, DataHandler> getAttachments();
}
