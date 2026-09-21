/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.proxy;

public interface ProxyGrantingTicketStorage {
    public void save(String var1, String var2);

    public String retrieve(String var1);

    public void cleanUp();
}

