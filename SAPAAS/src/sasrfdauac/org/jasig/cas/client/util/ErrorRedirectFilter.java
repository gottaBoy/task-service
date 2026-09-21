/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.Filter
 *  javax.servlet.FilterChain
 *  javax.servlet.FilterConfig
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class ErrorRedirectFilter
implements Filter {
    private final Log log = LogFactory.getLog(this.getClass());
    private final List errors = new ArrayList();
    private String defaultErrorRedirectPage;

    public void destroy() {
    }

    /*
     * Unable to fully structure code
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        block6: {
            httpResponse = (HttpServletResponse)response;
            try {
                filterChain.doFilter(request, response);
                break block6;
            }
            catch (ServletException e) {
                t = e.getCause();
                currentMatch = null;
                ** for (errorHolder : this.errors)
            }
lbl-1000:
            // 1 sources

            {
                if (errorHolder.exactMatch(t)) {
                    currentMatch = errorHolder;
                    break;
                }
                if (!errorHolder.inheritanceMatch(t)) continue;
                currentMatch = errorHolder;
                continue;
            }
lbl15:
            // 2 sources

            if (currentMatch != null) {
                httpResponse.sendRedirect(currentMatch.getUrl());
            } else {
                httpResponse.sendRedirect(this.defaultErrorRedirectPage);
            }
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.defaultErrorRedirectPage = filterConfig.getInitParameter("defaultErrorRedirectPage");
        Enumeration enumeration = filterConfig.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String className = (String)enumeration.nextElement();
            try {
                if (className.equals("defaultErrorRedirectPage")) continue;
                this.errors.add(new ErrorHolder(className, filterConfig.getInitParameter(className)));
            }
            catch (ClassNotFoundException e) {
                this.log.warn((Object)("Class [" + className + "] cannot be found in ClassLoader.  Ignoring."));
            }
        }
    }

    protected final class ErrorHolder {
        private Class className;
        private String url;

        protected ErrorHolder(String className, String url) throws ClassNotFoundException {
            this.className = Class.forName(className);
            this.url = url;
        }

        public boolean exactMatch(Throwable e) {
            return this.className.equals(e.getClass());
        }

        public boolean inheritanceMatch(Throwable e) {
            return this.className.isAssignableFrom(e.getClass());
        }

        public String getUrl() {
            return this.url;
        }
    }
}

