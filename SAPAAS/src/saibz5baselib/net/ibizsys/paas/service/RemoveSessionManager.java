/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.service.RemoveSession;

@Deprecated
public class RemoveSessionManager {
    static ThreadLocal<RemoveSession> removeSession = new ThreadLocal();

    public static RemoveSession openSession() {
        RemoveSession curentSession = removeSession.get();
        if (curentSession == null) {
            curentSession = new RemoveSession();
            removeSession.set(curentSession);
        }
        return curentSession;
    }

    public static void closeSession() {
        removeSession.set(null);
    }

    public static RemoveSession getCurrentSession() {
        return removeSession.get();
    }
}

