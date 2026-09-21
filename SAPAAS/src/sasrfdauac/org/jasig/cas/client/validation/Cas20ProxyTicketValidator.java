/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.validation;

import java.util.List;
import org.jasig.cas.client.util.XmlUtils;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.jasig.cas.client.validation.InvalidProxyChainTicketValidationException;
import org.jasig.cas.client.validation.ProxyList;
import org.jasig.cas.client.validation.TicketValidationException;

public class Cas20ProxyTicketValidator
extends Cas20ServiceTicketValidator {
    private boolean acceptAnyProxy;
    private ProxyList allowedProxyChains = new ProxyList();

    public Cas20ProxyTicketValidator(String casServerUrlPrefix) {
        super(casServerUrlPrefix);
    }

    public ProxyList getAllowedProxyChains() {
        return this.allowedProxyChains;
    }

    @Override
    protected String getUrlSuffix() {
        return "proxyValidate";
    }

    @Override
    protected void customParseResponse(String response, Assertion assertion) throws TicketValidationException {
        List proxies = XmlUtils.getTextForElements(response, "proxy");
        String[] proxiedList = proxies.toArray(new String[proxies.size()]);
        if (proxies == null || proxies.isEmpty() || this.acceptAnyProxy) {
            return;
        }
        if (this.allowedProxyChains.contains(proxiedList)) {
            return;
        }
        throw new InvalidProxyChainTicketValidationException("Invalid proxy chain: " + proxies.toString());
    }

    public void setAcceptAnyProxy(boolean acceptAnyProxy) {
        this.acceptAnyProxy = acceptAnyProxy;
    }

    public void setAllowedProxyChains(ProxyList allowedProxyChains) {
        this.allowedProxyChains = allowedProxyChains;
    }
}

