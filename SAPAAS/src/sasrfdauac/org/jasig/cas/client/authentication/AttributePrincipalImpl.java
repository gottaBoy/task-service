/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.authentication;

import java.util.Collections;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.proxy.ProxyRetriever;
import org.jasig.cas.client.util.CommonUtils;

public class AttributePrincipalImpl
implements AttributePrincipal {
    private static final Log LOG = LogFactory.getLog(AttributePrincipalImpl.class);
    private static final long serialVersionUID = -8810123156070148535L;
    private final String name;
    private final Map attributes;
    private final String proxyGrantingTicket;
    private final ProxyRetriever proxyRetriever;

    public AttributePrincipalImpl(String name) {
        this(name, Collections.EMPTY_MAP);
    }

    public AttributePrincipalImpl(String name, Map attributes) {
        this(name, attributes, null, null);
    }

    public AttributePrincipalImpl(String name, String proxyGrantingTicket, ProxyRetriever proxyRetriever) {
        this(name, Collections.EMPTY_MAP, proxyGrantingTicket, proxyRetriever);
    }

    public AttributePrincipalImpl(String name, Map attributes, String proxyGrantingTicket, ProxyRetriever proxyRetriever) {
        this.name = name;
        this.attributes = attributes;
        this.proxyGrantingTicket = proxyGrantingTicket;
        this.proxyRetriever = proxyRetriever;
        CommonUtils.assertNotNull(this.name, "name cannot be null.");
        CommonUtils.assertNotNull(this.attributes, "attributes cannot be null.");
    }

    @Override
    public Map getAttributes() {
        return this.attributes;
    }

    @Override
    public String getProxyTicketFor(String service) {
        if (this.proxyGrantingTicket != null) {
            return this.proxyRetriever.getProxyTicketIdFor(this.proxyGrantingTicket, service);
        }
        LOG.debug((Object)"No ProxyGrantingTicket was supplied, so no Proxy Ticket can be retrieved.");
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

