/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 */
package org.jasig.cas.client.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.jasig.cas.client.authentication.GatewayResolver;

public final class DefaultGatewayResolverImpl
implements GatewayResolver {
    public static final String CONST_CAS_GATEWAY = "_const_cas_gateway_";

    @Override
    public boolean hasGatewayedAlready(HttpServletRequest request, String serviceUrl) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        boolean result = session.getAttribute(CONST_CAS_GATEWAY) != null;
        session.removeAttribute(CONST_CAS_GATEWAY);
        return result;
    }

    @Override
    public String storeGatewayInformation(HttpServletRequest request, String serviceUrl) {
        request.getSession(true).setAttribute(CONST_CAS_GATEWAY, (Object)"yes");
        return serviceUrl;
    }
}

