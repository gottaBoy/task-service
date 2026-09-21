/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.FilterChain
 *  javax.servlet.FilterConfig
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.session;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.session.HashMapBackedSessionMappingStorage;
import org.jasig.cas.client.session.SessionMappingStorage;
import org.jasig.cas.client.util.AbstractConfigurationFilter;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.util.XmlUtils;

public final class SingleSignOutFilter
extends AbstractConfigurationFilter {
    private String artifactParameterName = "ticket";
    private static SessionMappingStorage SESSION_MAPPING_STORAGE = new HashMapBackedSessionMappingStorage();
    private static Log log = LogFactory.getLog(SingleSignOutFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        if (!this.isIgnoreInitConfiguration()) {
            this.setArtifactParameterName(this.getPropertyFromInitParams(filterConfig, "artifactParameterName", "ticket"));
        }
        this.init();
    }

    public void init() {
        CommonUtils.assertNotNull(this.artifactParameterName, "artifactParameterName cannot be null.");
        CommonUtils.assertNotNull(SESSION_MAPPING_STORAGE, "sessionMappingStorage cannote be null.");
    }

    public void setArtifactParameterName(String artifactParameterName) {
        this.artifactParameterName = artifactParameterName;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        if ("POST".equals(request.getMethod())) {
            String logoutRequest = CommonUtils.safeGetParameter(request, "logoutRequest");
            if (CommonUtils.isNotBlank(logoutRequest)) {
                String sessionIdentifier;
                if (log.isTraceEnabled()) {
                    log.trace((Object)("Logout request=[" + logoutRequest + "]"));
                }
                if (CommonUtils.isNotBlank(sessionIdentifier = XmlUtils.getTextForElement(logoutRequest, "SessionIndex"))) {
                    HttpSession session = SESSION_MAPPING_STORAGE.removeSessionByMappingId(sessionIdentifier);
                    if (session != null) {
                        String sessionID = session.getId();
                        if (log.isDebugEnabled()) {
                            log.debug((Object)("Invalidating session [" + sessionID + "] for ST [" + sessionIdentifier + "]"));
                        }
                        try {
                            session.invalidate();
                        }
                        catch (IllegalStateException e) {
                            log.debug((Object)e, (Throwable)e);
                        }
                    }
                    return;
                }
            }
        } else {
            String artifact = CommonUtils.safeGetParameter(request, this.artifactParameterName);
            if (CommonUtils.isNotBlank(artifact)) {
                HttpSession session = request.getSession(true);
                if (log.isDebugEnabled()) {
                    log.debug((Object)("Storing session identifier for " + session.getId()));
                }
                try {
                    SESSION_MAPPING_STORAGE.removeBySessionById(session.getId());
                }
                catch (Exception exception) {
                    // empty catch block
                }
                SESSION_MAPPING_STORAGE.addSessionById(artifact, session);
            } else {
                log.debug((Object)"No Artifact Provided; no action taking place.");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void setSessionMappingStorage(SessionMappingStorage storage) {
        SESSION_MAPPING_STORAGE = storage;
    }

    public static SessionMappingStorage getSessionMappingStorage() {
        return SESSION_MAPPING_STORAGE;
    }

    public void destroy() {
    }
}

