/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.proxy;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.proxy.ProxyRetriever;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.util.XmlUtils;

public final class Cas20ProxyRetriever
implements ProxyRetriever {
    private static final long serialVersionUID = 560409469568911791L;
    private final Log log = LogFactory.getLog(this.getClass());
    private final String casServerUrl;

    public Cas20ProxyRetriever(String casServerUrl) {
        CommonUtils.assertNotNull(casServerUrl, "casServerUrl cannot be null.");
        this.casServerUrl = casServerUrl;
    }

    @Override
    public String getProxyTicketIdFor(String proxyGrantingTicketId, String targetService) {
        String url = this.constructUrl(proxyGrantingTicketId, targetService);
        String response = CommonUtils.getResponseFromServer(url);
        String error = XmlUtils.getTextForElement(response, "proxyFailure");
        if (CommonUtils.isNotEmpty(error)) {
            this.log.debug((Object)error);
            return null;
        }
        return XmlUtils.getTextForElement(response, "proxyTicket");
    }

    private String constructUrl(String proxyGrantingTicketId, String targetService) {
        try {
            return String.valueOf(this.casServerUrl) + (this.casServerUrl.endsWith("/") ? "" : "/") + "proxy" + "?pgt=" + proxyGrantingTicketId + "&targetService=" + URLEncoder.encode(targetService, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}

