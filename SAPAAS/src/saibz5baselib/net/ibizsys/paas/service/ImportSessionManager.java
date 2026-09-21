/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.service.ImportSession;

public class ImportSessionManager {
    static ThreadLocal<ImportSession> importSession = new ThreadLocal();

    public static ImportSession openSession() {
        ImportSession curentSession = importSession.get();
        if (curentSession == null) {
            curentSession = new ImportSession();
            importSession.set(curentSession);
        }
        return curentSession;
    }

    public static void closeSession() {
        importSession.set(null);
    }

    public static ImportSession getCurrentSession() {
        return importSession.get();
    }
}

