/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpSession
 */
package org.jasig.cas.client.session;

import javax.servlet.http.HttpSession;

public interface SessionMappingStorage {
    public HttpSession removeSessionByMappingId(String var1);

    public void removeBySessionById(String var1);

    public void addSessionById(String var1, HttpSession var2);
}

