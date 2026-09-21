/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorage;

public final class CommonUtils {
    private static final Log LOG = LogFactory.getLog(CommonUtils.class);
    private static final String PARAM_PROXY_GRANTING_TICKET_IOU = "pgtIou";
    private static final String PARAM_PROXY_GRANTING_TICKET = "pgtId";

    private CommonUtils() {
    }

    public static void assertNotNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void assertNotEmpty(Collection c, String message) {
        CommonUtils.assertNotNull(c, message);
        if (c.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void assertTrue(boolean cond, String message) {
        if (!cond) {
            throw new IllegalArgumentException(message);
        }
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static boolean isNotEmpty(String string) {
        return !CommonUtils.isEmpty(string);
    }

    public static boolean isBlank(String string) {
        return CommonUtils.isEmpty(string) || string.trim().length() == 0;
    }

    public static boolean isNotBlank(String string) {
        return !CommonUtils.isBlank(string);
    }

    public static String constructRedirectUrl(String casServerLoginUrl, String serviceParameterName, String serviceUrl, boolean renew, boolean gateway) {
        try {
            return String.valueOf(casServerLoginUrl) + (casServerLoginUrl.indexOf("?") != -1 ? "&" : "?") + serviceParameterName + "=" + URLEncoder.encode(serviceUrl, "UTF-8") + (renew ? "&renew=true" : "") + (gateway ? "&gateway=true" : "");
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readAndRespondToProxyReceptorRequest(HttpServletRequest request, HttpServletResponse response, ProxyGrantingTicketStorage proxyGrantingTicketStorage) throws IOException {
        String proxyGrantingTicketIou = request.getParameter(PARAM_PROXY_GRANTING_TICKET_IOU);
        String proxyGrantingTicket = request.getParameter(PARAM_PROXY_GRANTING_TICKET);
        if (CommonUtils.isBlank(proxyGrantingTicket) || CommonUtils.isBlank(proxyGrantingTicketIou)) {
            response.getWriter().write("");
            return;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug((Object)("Received proxyGrantingTicketId [" + proxyGrantingTicket + "] for proxyGrantingTicketIou [" + proxyGrantingTicketIou + "]"));
        }
        proxyGrantingTicketStorage.save(proxyGrantingTicketIou, proxyGrantingTicket);
        response.getWriter().write("<?xml version=\"1.0\"?>");
        response.getWriter().write("<casClient:proxySuccess xmlns:casClient=\"http://www.yale.edu/tp/casClient\" />");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String constructServiceUrl(HttpServletRequest request, HttpServletResponse response, String service, String serverName, String artifactParameterName, boolean encode) {
        String returnValue;
        StringBuffer buffer;
        if (CommonUtils.isNotBlank(service)) {
            return encode ? response.encodeURL(service) : service;
        }
        StringBuffer stringBuffer = buffer = new StringBuffer();
        synchronized (stringBuffer) {
            if (!serverName.startsWith("https://") && !serverName.startsWith("http://")) {
                buffer.append(request.isSecure() ? "https://" : "http://");
            }
            buffer.append(serverName);
            buffer.append(request.getRequestURI());
            if (CommonUtils.isNotBlank(request.getQueryString())) {
                int location = request.getQueryString().indexOf(String.valueOf(artifactParameterName) + "=");
                if (location == 0) {
                    String returnValue2;
                    String string = returnValue2 = encode ? response.encodeURL(buffer.toString()) : buffer.toString();
                    if (LOG.isDebugEnabled()) {
                        LOG.debug((Object)("serviceUrl generated: " + returnValue2));
                    }
                    return returnValue2;
                }
                buffer.append("?");
                if (location == -1) {
                    buffer.append(request.getQueryString());
                } else if (location > 0) {
                    int actualLocation = request.getQueryString().indexOf("&" + artifactParameterName + "=");
                    if (actualLocation == -1) {
                        buffer.append(request.getQueryString());
                    } else if (actualLocation > 0) {
                        buffer.append(request.getQueryString().substring(0, actualLocation));
                    }
                }
            }
        }
        String string = returnValue = encode ? response.encodeURL(buffer.toString()) : buffer.toString();
        if (LOG.isDebugEnabled()) {
            LOG.debug((Object)("serviceUrl generated: " + returnValue));
        }
        return returnValue;
    }

    public static String safeGetParameter(HttpServletRequest request, String parameter) {
        if ("POST".equals(request.getMethod()) && "logoutRequest".equals(parameter)) {
            LOG.warn((Object)"safeGetParameter called on a POST HttpServletRequest for LogoutRequest.  Cannot complete check safely.  Reverting to standard behavior for this Parameter");
            return request.getParameter(parameter);
        }
        return request.getQueryString() == null || request.getQueryString().indexOf(parameter) == -1 ? null : request.getParameter(parameter);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String getResponseFromServer(URL constructedUrl) {
        HttpURLConnection conn = null;
        try {
            StringBuffer stringBuffer;
            conn = (HttpURLConnection)constructedUrl.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer stringBuffer2 = stringBuffer = new StringBuffer(255);
            synchronized (stringBuffer2) {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        stringBuffer.append(line);
                        stringBuffer.append("\n");
                    }
                    String string = stringBuffer.toString();
                    return string;
                }
                catch (Throwable throwable) {
                    try {
                        throw throwable;
                    }
                    catch (Exception e) {
                        LOG.error((Object)e.getMessage(), (Throwable)e);
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public static String getResponseFromServer(String url) {
        try {
            return CommonUtils.getResponseFromServer(new URL(url));
        }
        catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

