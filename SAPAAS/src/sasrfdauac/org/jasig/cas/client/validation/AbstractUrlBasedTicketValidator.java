/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.validation;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;

public abstract class AbstractUrlBasedTicketValidator
implements TicketValidator {
    protected final Log log = LogFactory.getLog(this.getClass());
    private final String casServerUrlPrefix;
    private boolean renew;
    private Map customParameters;

    protected AbstractUrlBasedTicketValidator(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
        CommonUtils.assertNotNull(this.casServerUrlPrefix, "casServerUrlPrefix cannot be null.");
    }

    protected void populateUrlAttributeMap(Map urlParameters) {
    }

    protected abstract String getUrlSuffix();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final String constructValidationUrl(String ticket, String serviceUrl) {
        HashMap<String, String> urlParameters = new HashMap<String, String>();
        this.log.debug((Object)"Placing URL parameters in map.");
        urlParameters.put("ticket", ticket);
        urlParameters.put("service", this.encodeUrl(serviceUrl));
        if (this.renew) {
            urlParameters.put("renew", "true");
        }
        this.log.debug((Object)"Calling template URL attribute map.");
        this.populateUrlAttributeMap(urlParameters);
        this.log.debug((Object)"Loading custom parameters from configuration.");
        if (this.customParameters != null) {
            urlParameters.putAll(this.customParameters);
        }
        String suffix = this.getUrlSuffix();
        StringBuffer buffer = new StringBuffer(urlParameters.size() * 10 + this.casServerUrlPrefix.length() + suffix.length() + 1);
        int i = 0;
        StringBuffer stringBuffer = buffer;
        synchronized (stringBuffer) {
            buffer.append(this.casServerUrlPrefix);
            if (!this.casServerUrlPrefix.endsWith("/")) {
                buffer.append("/");
            }
            buffer.append(suffix);
            for (Map.Entry entry : urlParameters.entrySet()) {
                String key = (String)entry.getKey();
                String value = (String)entry.getValue();
                if (value == null) continue;
                buffer.append(i++ == 0 ? "?" : "&");
                buffer.append(key);
                buffer.append("=");
                buffer.append(value);
            }
            return buffer.toString();
        }
    }

    protected final String encodeUrl(String url) {
        if (url == null) {
            return null;
        }
        try {
            return URLEncoder.encode(url, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            return url;
        }
    }

    protected abstract Assertion parseResponseFromServer(String var1) throws TicketValidationException;

    protected abstract String retrieveResponseFromServer(URL var1, String var2);

    @Override
    public Assertion validate(String ticket, String service) throws TicketValidationException {
        String validationUrl = this.constructValidationUrl(ticket, service);
        if (this.log.isDebugEnabled()) {
            this.log.debug((Object)("Constructing validation url: " + validationUrl));
        }
        try {
            this.log.debug((Object)"Retrieving response from server.");
            String serverResponse = this.retrieveResponseFromServer(new URL(validationUrl), ticket);
            if (serverResponse == null) {
                throw new TicketValidationException("The CAS server returned no response.");
            }
            if (this.log.isDebugEnabled()) {
                this.log.debug((Object)("Server response: " + serverResponse));
            }
            return this.parseResponseFromServer(serverResponse);
        }
        catch (MalformedURLException e) {
            throw new TicketValidationException(e);
        }
    }

    public void setRenew(boolean renew) {
        this.renew = renew;
    }

    public void setCustomParameters(Map customParameters) {
        this.customParameters = customParameters;
    }
}

