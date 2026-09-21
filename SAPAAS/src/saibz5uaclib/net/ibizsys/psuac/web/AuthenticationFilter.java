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
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  net.ibizsys.paas.util.StringHelper
 *  org.jasig.cas.client.authentication.DefaultGatewayResolverImpl
 *  org.jasig.cas.client.authentication.GatewayResolver
 *  org.jasig.cas.client.util.AbstractCasFilter
 *  org.jasig.cas.client.util.CommonUtils
 *  org.jasig.cas.client.validation.Assertion
 */
package net.ibizsys.psuac.web;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.ibizsys.paas.util.StringHelper;
import org.jasig.cas.client.authentication.DefaultGatewayResolverImpl;
import org.jasig.cas.client.authentication.GatewayResolver;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;

public class AuthenticationFilter
extends AbstractCasFilter {
    private String casServerLoginUrl;
    private boolean renew = false;
    private boolean gateway = false;
    private GatewayResolver gatewayStorage = new DefaultGatewayResolverImpl();
    private String strServerName = "";
    private String strUACLoginUrl = "";
    private boolean bDynamicName = false;

    protected void initInternal(FilterConfig filterConfig) throws ServletException {
        if (!this.isIgnoreInitConfiguration()) {
            super.initInternal(filterConfig);
            this.strUACLoginUrl = this.getPropertyFromInitParams(filterConfig, "UACLOGINURL", null);
            this.setUACLoginUrl(this.strUACLoginUrl);
            this.strServerName = this.getPropertyFromInitParams(filterConfig, "SERVERNAME", null);
            this.setServerName(this.strServerName);
            if (StringHelper.compare((String)this.getPropertyFromInitParams(filterConfig, "DYNAMICNAME", null), (String)"TRUE", (boolean)true) == 0) {
                this.bDynamicName = true;
            }
            this.log.trace((Object)("Loaded UAC Login URL parameter: " + this.casServerLoginUrl));
            this.setRenew(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "RENEW", "false")));
            this.log.trace((Object)("Loaded RENEW parameter: " + this.renew));
            this.setGateway(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "GATEWAY", "false")));
            this.log.trace((Object)("Loaded GATEWAY parameter: " + this.gateway));
            String gatewayStorageClass = this.getPropertyFromInitParams(filterConfig, "gatewayStorageClass", null);
            if (gatewayStorageClass != null) {
                try {
                    this.gatewayStorage = (GatewayResolver)Class.forName(gatewayStorageClass).newInstance();
                }
                catch (Exception e) {
                    this.log.error((Object)e, (Throwable)e);
                    throw new ServletException((Throwable)e);
                }
            }
        }
    }

    public void init() {
        super.init();
        CommonUtils.assertNotNull((Object)this.casServerLoginUrl, (String)"UACLOGINURL cannot be null.");
    }

    public final void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String modifiedServiceUrl;
        Assertion assertion;
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession(false);
        Assertion assertion2 = assertion = session != null ? (Assertion)session.getAttribute("_const_cas_assertion_") : null;
        if (assertion != null) {
            filterChain.doFilter((ServletRequest)request, (ServletResponse)response);
            return;
        }
        String serviceUrl = this.constructServiceUrl(request, response);
        String ticket = CommonUtils.safeGetParameter((HttpServletRequest)request, (String)this.getArtifactParameterName());
        boolean wasGatewayed = this.gatewayStorage.hasGatewayedAlready(request, serviceUrl);
        if (CommonUtils.isNotBlank((String)ticket) || wasGatewayed) {
            filterChain.doFilter((ServletRequest)request, (ServletResponse)response);
            return;
        }
        this.log.debug((Object)"no ticket and no assertion found");
        if (this.gateway) {
            this.log.debug((Object)"setting gateway attribute in session");
            modifiedServiceUrl = this.gatewayStorage.storeGatewayInformation(request, serviceUrl);
        } else {
            modifiedServiceUrl = serviceUrl;
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug((Object)("Constructed service url: " + modifiedServiceUrl));
        }
        String urlToRedirectTo = CommonUtils.constructRedirectUrl((String)this.casServerLoginUrl, (String)this.getServiceParameterName(), (String)modifiedServiceUrl, (boolean)this.renew, (boolean)this.gateway);
        if (this.log.isDebugEnabled()) {
            this.log.debug((Object)("redirecting to \"" + urlToRedirectTo + "\""));
        }
        response.sendRedirect(urlToRedirectTo);
    }

    public final void setRenew(boolean renew) {
        this.renew = renew;
    }

    public final void setGateway(boolean gateway) {
        this.gateway = gateway;
    }

    public final void setUACLoginUrl(String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }

    public final void setGatewayStorage(GatewayResolver gatewayStorage) {
        this.gatewayStorage = gatewayStorage;
    }
}

