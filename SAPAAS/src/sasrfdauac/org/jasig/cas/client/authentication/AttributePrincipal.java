/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.authentication;

import java.io.Serializable;
import java.security.Principal;
import java.util.Map;

public interface AttributePrincipal
extends Principal,
Serializable {
    public String getProxyTicketFor(String var1);

    public Map getAttributes();
}

