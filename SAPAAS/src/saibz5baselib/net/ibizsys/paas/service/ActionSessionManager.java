/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.service.ActionSession;

public class ActionSessionManager {
    static ThreadLocal<ActionSession> actionSession = new ThreadLocal();

    public static ActionSession openSession() {
        return ActionSessionManager.openSession("DEFAULT");
    }

    public static ActionSession openSession(String strName) {
        ActionSession currentSession = actionSession.get();
        if (currentSession == null) {
            currentSession = new ActionSession();
            currentSession.setName(strName);
            actionSession.set(currentSession);
        }
        return currentSession;
    }

    public static ActionSession openSession(String strName, boolean bTopSession) {
        ActionSession currentSession = actionSession.get();
        if (currentSession != null) {
            if (bTopSession) {
                return currentSession;
            }
            return currentSession.openChildSession(strName);
        }
        currentSession = new ActionSession();
        currentSession.setName(strName);
        actionSession.set(currentSession);
        return currentSession;
    }

    public static void closeSession() {
        actionSession.set(null);
    }

    public static void closeSession(boolean bTopSession) {
        if (bTopSession) {
            actionSession.set(null);
        } else {
            ActionSession currentSession = actionSession.get();
            if (currentSession != null && currentSession.closeChildSession() == -1) {
                actionSession.set(null);
            }
        }
    }

    public static ActionSession getCurrentSession() {
        ActionSession actionSession2 = actionSession.get();
        if (actionSession2 != null) {
            return actionSession2.getCurrentSession();
        }
        return null;
    }

    public static ActionSession getCurrentSession(boolean bCreateIfNotExists) {
        ActionSession actionSession2 = actionSession.get();
        if (actionSession2 == null && bCreateIfNotExists) {
            return ActionSessionManager.openSession();
        }
        if (actionSession2 == null) {
            return null;
        }
        return actionSession2.getCurrentSession();
    }

    public static void appendActionInfo(String strInfo) {
        if (ActionSessionManager.getCurrentSession() == null) {
            return;
        }
        ActionSessionManager.getCurrentSession().appendActionInfo(strInfo);
    }

    public static String getActionInfo() {
        if (ActionSessionManager.getCurrentSession() == null) {
            return null;
        }
        return ActionSessionManager.getCurrentSession().getActionInfo();
    }
}

