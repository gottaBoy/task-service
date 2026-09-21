/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpSession
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.session;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.session.SessionMappingStorage;

public final class HashMapBackedSessionMappingStorage
implements SessionMappingStorage {
    private final Map MANAGED_SESSIONS = new HashMap();
    private final Map ID_TO_SESSION_KEY_MAPPING = new HashMap();
    private final Log log = LogFactory.getLog(this.getClass());

    @Override
    public synchronized void addSessionById(String mappingId, HttpSession session) {
        this.ID_TO_SESSION_KEY_MAPPING.put(session.getId(), mappingId);
        this.MANAGED_SESSIONS.put(mappingId, session);
    }

    @Override
    public synchronized void removeBySessionById(String sessionId) {
        if (this.log.isDebugEnabled()) {
            this.log.debug((Object)("Attempting to remove Session=[" + sessionId + "]"));
        }
        String key = (String)this.ID_TO_SESSION_KEY_MAPPING.get(sessionId);
        if (this.log.isDebugEnabled()) {
            if (key != null) {
                this.log.debug((Object)"Found mapping for session.  Session Removed.");
            } else {
                this.log.debug((Object)"No mapping for session found.  Ignoring.");
            }
        }
        this.MANAGED_SESSIONS.remove(key);
        this.ID_TO_SESSION_KEY_MAPPING.remove(sessionId);
    }

    @Override
    public synchronized HttpSession removeSessionByMappingId(String mappingId) {
        HttpSession session = (HttpSession)this.MANAGED_SESSIONS.get(mappingId);
        if (session != null) {
            this.removeBySessionById(session.getId());
        }
        return session;
    }
}

