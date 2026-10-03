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
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.util.CommonUtils;

public final class DelegatingFilter
implements Filter {
    private final Log log = LogFactory.getLog(this.getClass());
    private final String requestParameterName;
    private final Map<String, Filter> delegators;
    private final Filter defaultFilter;
    private final boolean exactMatch;

    public DelegatingFilter(String requestParameterName, Map delegators, boolean exactMatch) {
        this(requestParameterName, delegators, exactMatch, null);
    }

    public DelegatingFilter(String requestParameterName, Map delegators, boolean exactMatch, Filter defaultFilter) {
        CommonUtils.assertNotNull(requestParameterName, "requestParameterName cannot be null.");
        CommonUtils.assertTrue(!delegators.isEmpty(), "delegators cannot be empty.");
        Iterator iter = delegators.keySet().iterator();
        while (iter.hasNext()) {
            Object object = delegators.get(iter.next());
            if (Filter.class.isAssignableFrom(object.getClass())) continue;
            throw new IllegalArgumentException("All value objects in the delegators map must be filters.");
        }
        this.requestParameterName = requestParameterName;
        this.delegators = delegators;
        this.defaultFilter = defaultFilter;
        this.exactMatch = exactMatch;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String parameter = CommonUtils.safeGetParameter((HttpServletRequest)request, this.requestParameterName);
        if (CommonUtils.isNotEmpty(parameter)) {
            for (String key : this.delegators.keySet()) {
                if ((!parameter.equals(key) || !this.exactMatch) && (!parameter.matches(key) || this.exactMatch)) continue;
                Filter filter = (Filter)this.delegators.get(key);
                if (this.log.isDebugEnabled()) {
                    this.log.debug((Object)("Match found for parameter [" + this.requestParameterName + "] with value [" + parameter + "]. Delegating to filter [" + filter.getClass().getName() + "]"));
                }
                filter.doFilter(request, response, filterChain);
                return;
            }
        }
        this.log.debug((Object)("No match found for parameter [" + this.requestParameterName + "] with value [" + parameter + "]"));
        if (this.defaultFilter != null) {
            this.defaultFilter.doFilter(request, response, filterChain);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }
}

