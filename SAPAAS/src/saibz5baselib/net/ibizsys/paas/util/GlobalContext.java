/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 */
package net.ibizsys.paas.util;

import javax.servlet.ServletContext;
import net.ibizsys.paas.util.IGlobalContext;

public class GlobalContext
implements IGlobalContext {
    protected ServletContext servletContext = null;
    protected static IGlobalContext globalContext = null;

    public ServletContext getServletContext() {
        return this.servletContext;
    }

    public static IGlobalContext getCurrent() {
        return globalContext;
    }

    protected void onInit() throws Exception {
    }

    @Override
    public Object getValue(String strKey) {
        return this.servletContext.getAttribute(strKey);
    }

    @Override
    public void setValue(String strKey, Object objValue) {
        if (objValue == null) {
            this.servletContext.removeAttribute(strKey);
        } else {
            this.servletContext.setAttribute(strKey, objValue);
        }
    }
}

