/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jasig.cas.client.authentication.AttributePrincipalImpl;
import org.jasig.cas.client.proxy.Cas20ProxyRetriever;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorage;
import org.jasig.cas.client.proxy.ProxyRetriever;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.util.XmlUtils;
import org.jasig.cas.client.validation.AbstractCasProtocolUrlBasedTicketValidator;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.AssertionImpl;
import org.jasig.cas.client.validation.TicketValidationException;

public class Cas20ServiceTicketValidator
extends AbstractCasProtocolUrlBasedTicketValidator {
    private String proxyCallbackUrl;
    private ProxyGrantingTicketStorage proxyGrantingTicketStorage;
    private ProxyRetriever proxyRetriever;

    public Cas20ServiceTicketValidator(String casServerUrlPrefix) {
        super(casServerUrlPrefix);
        this.proxyRetriever = new Cas20ProxyRetriever(casServerUrlPrefix);
    }

    @Override
    protected final void populateUrlAttributeMap(Map urlParameters) {
        urlParameters.put("pgtUrl", this.encodeUrl(this.proxyCallbackUrl));
    }

    @Override
    protected String getUrlSuffix() {
        return "serviceValidate";
    }

    @Override
    protected final Assertion parseResponseFromServer(String response) throws TicketValidationException {
        AssertionImpl assertion;
        String proxyGrantingTicket;
        String error = XmlUtils.getTextForElement(response, "authenticationFailure");
        if (CommonUtils.isNotBlank(error)) {
            throw new TicketValidationException(error);
        }
        String principal = XmlUtils.getTextForElement(response, "user");
        String proxyGrantingTicketIou = XmlUtils.getTextForElement(response, "proxyGrantingTicket");
        String string = proxyGrantingTicket = this.proxyGrantingTicketStorage != null ? this.proxyGrantingTicketStorage.retrieve(proxyGrantingTicketIou) : null;
        if (CommonUtils.isEmpty(principal)) {
            throw new TicketValidationException("No principal was found in the response from the CAS server.");
        }
        Map attributes = this.extractCustomAttributes(response);
        if (CommonUtils.isNotBlank(proxyGrantingTicket)) {
            AttributePrincipalImpl attributePrincipal = new AttributePrincipalImpl(principal, attributes, proxyGrantingTicket, this.proxyRetriever);
            assertion = new AssertionImpl(attributePrincipal);
        } else {
            assertion = new AssertionImpl(new AttributePrincipalImpl(principal, attributes));
        }
        this.customParseResponse(response, assertion);
        return assertion;
    }

    protected Map extractCustomAttributes(String xml) {
        int pos1 = xml.indexOf("<cas:attributes>");
        int pos2 = xml.indexOf("</cas:attributes>");
        if (pos1 == -1) {
            return Collections.EMPTY_MAP;
        }
        String attributesText = xml.substring(pos1 + 16, pos2);
        HashMap<String, String> attributes = new HashMap<String, String>();
        BufferedReader br = new BufferedReader(new StringReader(attributesText));
        ArrayList<String> attributeNames = new ArrayList<String>();
        try {
            String line;
            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.length() <= 0) continue;
                int leftPos = trimmedLine.indexOf(":");
                int rightPos = trimmedLine.indexOf(">");
                attributeNames.add(trimmedLine.substring(leftPos + 1, rightPos));
            }
            br.close();
        }
        catch (IOException trimmedLine) {
            // empty catch block
        }
        for (String name : attributeNames) {
            attributes.put(name, XmlUtils.getTextForElement(xml, name));
        }
        return attributes;
    }

    protected void customParseResponse(String response, Assertion assertion) throws TicketValidationException {
    }

    public final void setProxyCallbackUrl(String proxyCallbackUrl) {
        this.proxyCallbackUrl = proxyCallbackUrl;
    }

    public final void setProxyGrantingTicketStorage(ProxyGrantingTicketStorage proxyGrantingTicketStorage) {
        this.proxyGrantingTicketStorage = proxyGrantingTicketStorage;
    }

    public final void setProxyRetriever(ProxyRetriever proxyRetriever) {
        this.proxyRetriever = proxyRetriever;
    }
}

