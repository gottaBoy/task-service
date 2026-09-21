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
 *  javax.servlet.http.HttpServletRequestWrapper
 *  javax.servlet.http.HttpSession
 */
package org.jasig.cas.client.util;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractConfigurationFilter;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;

public final class HttpServletRequestWrapperFilter
extends AbstractConfigurationFilter {
    private String roleAttribute;
    private boolean ignoreCase;

    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        AttributePrincipal principal = this.retrievePrincipalFromSessionOrRequest(servletRequest);
        filterChain.doFilter((ServletRequest)new CasHttpServletRequestWrapper((HttpServletRequest)servletRequest, principal), servletResponse);
    }

    protected AttributePrincipal retrievePrincipalFromSessionOrRequest(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpSession session = request.getSession(false);
        Assertion assertion = (Assertion)(session == null ? request.getAttribute("_const_cas_assertion_") : session.getAttribute("_const_cas_assertion_"));
        return assertion == null ? null : assertion.getPrincipal();
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.roleAttribute = this.getPropertyFromInitParams(filterConfig, "roleAttribute", null);
        this.ignoreCase = Boolean.parseBoolean(this.getPropertyFromInitParams(filterConfig, "ignoreCase", "false"));
    }

    final class CasHttpServletRequestWrapper
    extends HttpServletRequestWrapper {
        private final AttributePrincipal principal;

        CasHttpServletRequestWrapper(HttpServletRequest request, AttributePrincipal principal) {
            super(request);
            this.principal = principal;
        }

        public Principal getUserPrincipal() {
            return this.principal;
        }

        public String getRemoteUser() {
            return this.principal != null ? this.principal.getName() : null;
        }

        public boolean isUserInRole(String role) {
            if (CommonUtils.isBlank(role)) {
                HttpServletRequestWrapperFilter.this.log.debug((Object)"No valid role provided.  Returning false.");
                return false;
            }
            if (this.principal == null) {
                HttpServletRequestWrapperFilter.this.log.debug((Object)"No Principal in Request.  Returning false.");
                return false;
            }
            if (CommonUtils.isBlank(HttpServletRequestWrapperFilter.this.roleAttribute)) {
                HttpServletRequestWrapperFilter.this.log.debug((Object)"No Role Attribute Configured. Returning false.");
                return false;
            }
            Object value = this.principal.getAttributes().get(HttpServletRequestWrapperFilter.this.roleAttribute);
            if (value instanceof Collection) {
                Iterator iter = ((Collection)value).iterator();
                while (iter.hasNext()) {
                    if (!this.rolesEqual(role, iter.next())) continue;
                    HttpServletRequestWrapperFilter.this.log.debug((Object)("User [" + this.getRemoteUser() + "] is in role [" + role + "]: " + true));
                    return true;
                }
            }
            boolean isMember = this.rolesEqual(role, value);
            HttpServletRequestWrapperFilter.this.log.debug((Object)("User [" + this.getRemoteUser() + "] is in role [" + role + "]: " + isMember));
            return isMember;
        }

        private boolean rolesEqual(String given, Object candidate) {
            return HttpServletRequestWrapperFilter.this.ignoreCase ? given.equalsIgnoreCase(candidate.toString()) : given.equals(candidate);
        }
    }
}

