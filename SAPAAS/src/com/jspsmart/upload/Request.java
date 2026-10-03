package com.jspsmart.upload;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Multipart-aware request facade used by the legacy SmartUpload callers.
 */
public class Request {
    private final HttpServletRequest request;
    private final Map<String, String> multipartParameters = new HashMap<String, String>();

    Request(HttpServletRequest request) {
        this.request = request;
    }

    void setParameter(String name, String value) {
        if (name != null && !multipartParameters.containsKey(name)) {
            multipartParameters.put(name, value);
        }
    }

    public String getParameter(String name) {
        if (multipartParameters.containsKey(name)) {
            return multipartParameters.get(name);
        }
        return request == null ? null : request.getParameter(name);
    }

    public HttpServletRequest getHttpServletRequest() {
        return request;
    }
}
