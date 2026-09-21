/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.FilterConfig
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.util;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.util.AbstractConfigurationFilter;
import org.jasig.cas.client.util.CommonUtils;

public abstract class AbstractCasFilter
extends AbstractConfigurationFilter {
    public static final String CONST_CAS_ASSERTION = "_const_cas_assertion_";
    protected final Log log = LogFactory.getLog(this.getClass());
    private String artifactParameterName = "ticket";
    private String serviceParameterName = "service";
    private boolean encodeServiceUrl = true;
    private String serverName;
    private String service;

    public final void init(FilterConfig filterConfig) throws ServletException {
        if (!this.isIgnoreInitConfiguration()) {
            this.setServerName(this.getPropertyFromInitParams(filterConfig, "serverName", null));
            this.log.trace((Object)("Loading serverName property: " + this.serverName));
            this.setService(this.getPropertyFromInitParams(filterConfig, "service", null));
            this.log.trace((Object)("Loading service property: " + this.service));
            this.setArtifactParameterName(this.getPropertyFromInitParams(filterConfig, "artifactParameterName", "ticket"));
            this.log.trace((Object)("Loading artifact parameter name property: " + this.artifactParameterName));
            this.setServiceParameterName(this.getPropertyFromInitParams(filterConfig, "serviceParameterName", "service"));
            this.log.trace((Object)("Loading serviceParameterName property: " + this.serviceParameterName));
            this.setEncodeServiceUrl(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "encodeServiceUrl", "true")));
            this.log.trace((Object)("Loading encodeServiceUrl property: " + this.encodeServiceUrl));
            this.initInternal(filterConfig);
        }
        this.init();
    }

    protected void initInternal(FilterConfig filterConfig) throws ServletException {
    }

    public void init() {
        CommonUtils.assertNotNull(this.artifactParameterName, "artifactParameterName cannot be null.");
        CommonUtils.assertNotNull(this.serviceParameterName, "serviceParameterName cannot be null.");
        CommonUtils.assertTrue(CommonUtils.isNotEmpty(this.serverName) || CommonUtils.isNotEmpty(this.service), "serverName or service must be set.");
    }

    public void destroy() {
    }

    protected final String constructServiceUrl(HttpServletRequest request, HttpServletResponse response) {
        return CommonUtils.constructServiceUrl(request, response, this.service, this.serverName, this.artifactParameterName, this.encodeServiceUrl);
    }

    public final void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public final void setService(String service) {
        this.service = service;
    }

    public final void setArtifactParameterName(String artifactParameterName) {
        this.artifactParameterName = artifactParameterName;
    }

    public final void setServiceParameterName(String serviceParameterName) {
        this.serviceParameterName = serviceParameterName;
    }

    public final void setEncodeServiceUrl(boolean encodeServiceUrl) {
        this.encodeServiceUrl = encodeServiceUrl;
    }

    public final String getArtifactParameterName() {
        return this.artifactParameterName;
    }

    public final String getServiceParameterName() {
        return this.serviceParameterName;
    }
}

