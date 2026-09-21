/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  javax.servlet.http.HttpSession
 */
package net.ibizsys.paas.web;

import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class LocalSessionStorage {
    private HashMap<String, HashMap<String, Object>> sessionValueMapMap = new HashMap();
    public static final String LOCALSESSIONSTORAGE = "SRFLOCALSESSIONSTORAGE";

    public static LocalSessionStorage getCurrent(ServletContext servletContext) {
        Object objStorage = servletContext.getAttribute(LOCALSESSIONSTORAGE);
        if (objStorage == null) {
            objStorage = new LocalSessionStorage();
            servletContext.setAttribute(LOCALSESSIONSTORAGE, objStorage);
        }
        return (LocalSessionStorage)objStorage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setSessionValue(HttpSession session, String strKey, Object objValue) {
        HashMap<String, Object> sessionValueMap = null;
        HashMap<String, Object> hashMap = this.sessionValueMapMap;
        synchronized (hashMap) {
            sessionValueMap = this.sessionValueMapMap.get(session.getId());
            if (sessionValueMap == null) {
                sessionValueMap = new HashMap();
                this.sessionValueMapMap.put(session.getId(), sessionValueMap);
            }
        }
        hashMap = sessionValueMap;
        synchronized (hashMap) {
            if (objValue == null) {
                sessionValueMap.remove(strKey);
            } else {
                sessionValueMap.put(strKey, objValue);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object getSessionValue(HttpSession session, String strKey) {
        HashMap<String, Object> sessionValueMap = null;
        HashMap<String, HashMap<String, Object>> hashMap = this.sessionValueMapMap;
        synchronized (hashMap) {
            sessionValueMap = this.sessionValueMapMap.get(session.getId());
            if (sessionValueMap == null) {
                return null;
            }
        }
        HashMap<String, Object> hashMap2 = sessionValueMap;
        synchronized (hashMap2) {
            return sessionValueMap.get(strKey);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeSession(HttpSession session) {
        HashMap<String, HashMap<String, Object>> hashMap = this.sessionValueMapMap;
        synchronized (hashMap) {
            this.sessionValueMapMap.remove(session.getId());
        }
    }
}

