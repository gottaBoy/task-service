/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
package org.jasig.cas.client.authentication;

import javax.servlet.http.HttpServletRequest;

public interface GatewayResolver {
    public boolean hasGatewayedAlready(HttpServletRequest var1, String var2);

    public String storeGatewayInformation(HttpServletRequest var1, String var2);
}

