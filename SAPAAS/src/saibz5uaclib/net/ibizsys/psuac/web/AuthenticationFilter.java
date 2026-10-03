/*
 * Copyright 2007 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.ja-sig.org/products/cas/overview/license/index.html
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

/**
 * Filter implementation to intercept all requests and attempt to authenticate
 * the user by redirecting them to CAS (unless the user has a ticket).
 * <p>
 * This filter allows you to specify the following parameters (at either the context-level or the filter-level):
 * <ul>
 * <li><code>casServerLoginUrl</code> - the url to log into CAS, i.e. https://cas.rutgers.edu/login</li>
 * <li><code>renew</code> - true/false on whether to use renew or not.</li>
 * <li><code>gateway</code> - true/false on whether to use gateway or not.</li>
 * </ul>
 *
 * <p>Please see AbstractCasFilter for additional properties.</p>
 *
 * @author Scott Battaglia
 * @version $Revision: 11768 $ $Date: 2007-02-07 15:44:16 -0500 (Wed, 07 Feb 2007) $
 * @since 3.0
 */
public class AuthenticationFilter extends AbstractCasFilter {

    /**
     * The URL to the CAS Server login.
     */
    private String casServerLoginUrl;

    /**
     * Whether to send the renew request or not.
     */
    private boolean renew = false;

    /**
     * Whether to send the gateway request or not.
     */
    private boolean gateway = false;
    
    private GatewayResolver gatewayStorage = new DefaultGatewayResolverImpl();
    
    private String strServerName = "";
    private String strUACLoginUrl = "";
    private boolean bDynamicName = false;
    

    protected void initInternal(final FilterConfig filterConfig) throws ServletException {
        if (!isIgnoreInitConfiguration()) {
        	
        	super.initInternal(filterConfig);
        	
        	strUACLoginUrl = getPropertyFromInitParams(filterConfig, "UACLOGINURL", null);
            setUACLoginUrl(strUACLoginUrl);
            
            strServerName = getPropertyFromInitParams(filterConfig, "SERVERNAME", null);
            this.setServerName(strServerName);
            
            
            if(StringHelper.compare(getPropertyFromInitParams(filterConfig, "DYNAMICNAME", null), "TRUE", true) == 0)
            {
            	bDynamicName = true;
            }
            
            log.trace("Loaded UAC Login URL parameter: " + this.casServerLoginUrl);
            setRenew(parseBoolean(getPropertyFromInitParams(filterConfig, "RENEW", "false")));
            log.trace("Loaded RENEW parameter: " + this.renew);
            setGateway(parseBoolean(getPropertyFromInitParams(filterConfig, "GATEWAY", "false")));
            log.trace("Loaded GATEWAY parameter: " + this.gateway);

            final String gatewayStorageClass = getPropertyFromInitParams(filterConfig, "gatewayStorageClass", null);

            if (gatewayStorageClass != null) {
                try {
                    this.gatewayStorage = (GatewayResolver) Class.forName(gatewayStorageClass).newInstance();
                } catch (final Exception e) {
                    log.error(e,e);
                    throw new ServletException(e);
                }
            }
        }
    }

    public void init() {
        super.init();
        CommonUtils.assertNotNull(this.casServerLoginUrl, "UACLOGINURL cannot be null.");
    }

    public final void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final HttpSession session = request.getSession(false);
        final Assertion assertion = session != null ? (Assertion) session.getAttribute(CONST_CAS_ASSERTION) : null;

        if (assertion != null) {
            filterChain.doFilter(request, response);
            return;
        }

        String serviceUrl = constructServiceUrl(request, response);
//        if(bDynamicName)
//        {
//        //获取当前主机名
//        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
//  //      String strRequestURI = httpServletRequest.getRequestURI();
// //       String strRequestServletPath = httpServletRequest.getServletPath();
//        String strRequestServerName = httpServletRequest.getServerName();
//        int nRequestServerPort = httpServletRequest.getServerPort();
// //       String strRequestProtocol = httpServletRequest.getProtocol();
//        boolean bSecurity = httpServletRequest.isSecure();
//        
//        String strNewServerName = bSecurity?"https://":"http://";
//        strNewServerName+= strRequestServerName;
//        if(bSecurity && nRequestServerPort!=443)
//        {
//        	strNewServerName += StringHelper.Format(":%1$s",nRequestServerPort);
//        }
//        else
//        	 if(!bSecurity && nRequestServerPort!=80)
//             {
//             	strNewServerName += StringHelper.Format(":%1$s",nRequestServerPort);
//             }
//   
//        serviceUrl = serviceUrl.substring(strServerName.length());
//        serviceUrl = strNewServerName + serviceUrl;
//        }
        
        final String ticket = CommonUtils.safeGetParameter(request,getArtifactParameterName());
        final boolean wasGatewayed = this.gatewayStorage.hasGatewayedAlready(request, serviceUrl);

        if (CommonUtils.isNotBlank(ticket) || wasGatewayed) {
            filterChain.doFilter(request, response);
            return;
        }

        final String modifiedServiceUrl;

        log.debug("no ticket and no assertion found");
        if (this.gateway) {
            log.debug("setting gateway attribute in session");
            modifiedServiceUrl = this.gatewayStorage.storeGatewayInformation(request, serviceUrl);
        } else {
            modifiedServiceUrl = serviceUrl;
        }

        if (log.isDebugEnabled()) {
            log.debug("Constructed service url: " + modifiedServiceUrl);
        }

        final String urlToRedirectTo = CommonUtils.constructRedirectUrl(this.casServerLoginUrl, getServiceParameterName(), modifiedServiceUrl, this.renew, this.gateway);

        if (log.isDebugEnabled()) {
            log.debug("redirecting to \"" + urlToRedirectTo + "\"");
        }

        response.sendRedirect(urlToRedirectTo);
    }

    public final void setRenew(final boolean renew) {
        this.renew = renew;
    }

    public final void setGateway(final boolean gateway) {
        this.gateway = gateway;
    }

    public final void setUACLoginUrl(final String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }
    
    public final void setGatewayStorage(final GatewayResolver gatewayStorage) {
    	this.gatewayStorage = gatewayStorage;
    }
    
    
   
}
