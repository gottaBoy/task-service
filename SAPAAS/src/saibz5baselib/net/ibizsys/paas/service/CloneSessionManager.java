/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.service.CloneSession;

public class CloneSessionManager {
    static ThreadLocal<CloneSession> cloneSession = new ThreadLocal();

    public static CloneSession openSession() {
        CloneSession curentSession = cloneSession.get();
        if (curentSession == null) {
            curentSession = new CloneSession();
            cloneSession.set(curentSession);
        }
        return curentSession;
    }

    public static void closeSession() {
        cloneSession.set(null);
    }

    public static CloneSession getCurrentSession() {
        return cloneSession.get();
    }
}

