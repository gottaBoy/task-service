/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpSession
 *  javax.servlet.http.HttpSessionEvent
 *  javax.servlet.http.HttpSessionListener
 */
package org.jasig.cas.client.session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.jasig.cas.client.session.SessionMappingStorage;
import org.jasig.cas.client.session.SingleSignOutFilter;

public final class SingleSignOutHttpSessionListener
implements HttpSessionListener {
    private SessionMappingStorage SESSION_MAPPING_STORAGE;

    public void sessionCreated(HttpSessionEvent event) {
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        if (this.SESSION_MAPPING_STORAGE == null) {
            this.SESSION_MAPPING_STORAGE = SingleSignOutHttpSessionListener.getSessionMappingStorage();
        }
        HttpSession session = event.getSession();
        this.SESSION_MAPPING_STORAGE.removeBySessionById(session.getId());
    }

    protected static SessionMappingStorage getSessionMappingStorage() {
        return SingleSignOutFilter.getSessionMappingStorage();
    }
}

