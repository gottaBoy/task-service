/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.Filter
 *  javax.servlet.FilterConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.util.CommonUtils;

public abstract class AbstractConfigurationFilter
implements Filter {
    protected final Log log = LogFactory.getLog(this.getClass());
    private boolean ignoreInitConfiguration = false;

    protected final String getPropertyFromInitParams(FilterConfig filterConfig, String propertyName, String defaultValue) {
        String value = filterConfig.getInitParameter(propertyName);
        if (CommonUtils.isNotBlank(value)) {
            this.log.info((Object)("Property [" + propertyName + "] loaded from FilterConfig.getInitParameter with value [" + value + "]"));
            return value;
        }
        String value2 = filterConfig.getServletContext().getInitParameter(propertyName);
        if (CommonUtils.isNotBlank(value2)) {
            this.log.info((Object)("Property [" + propertyName + "] loaded from ServletContext.getInitParameter with value [" + value2 + "]"));
            return value2;
        }
        InitialContext context = null;
        try {
            context = new InitialContext();
        }
        catch (NamingException e) {
            this.log.warn((Object)e, (Throwable)e);
            return defaultValue;
        }
        String shortName = this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1);
        String value3 = this.loadFromContext(context, "java:comp/env/cas/" + shortName + "/" + propertyName);
        if (CommonUtils.isNotBlank(value3)) {
            this.log.info((Object)("Property [" + propertyName + "] loaded from JNDI Filter Specific Property with value [" + value3 + "]"));
            return value3;
        }
        String value4 = this.loadFromContext(context, "java:comp/env/cas/" + propertyName);
        if (CommonUtils.isNotBlank(value4)) {
            this.log.info((Object)("Property [" + propertyName + "] loaded from JNDI with value [" + value3 + "]"));
            return value4;
        }
        this.log.info((Object)("Property [" + propertyName + "] not found.  Using default value [" + defaultValue + "]"));
        return defaultValue;
    }

    protected final boolean parseBoolean(String value) {
        return value != null && value.equalsIgnoreCase("true");
    }

    protected final String loadFromContext(InitialContext context, String path) {
        try {
            return (String)context.lookup(path);
        }
        catch (NamingException e) {
            return null;
        }
    }

    public final void setIgnoreInitConfiguration(boolean ignoreInitConfiguration) {
        this.ignoreInitConfiguration = ignoreInitConfiguration;
    }

    protected final boolean isIgnoreInitConfiguration() {
        return this.ignoreInitConfiguration;
    }
}

