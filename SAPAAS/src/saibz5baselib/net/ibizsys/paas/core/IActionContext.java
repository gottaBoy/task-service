/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.web.IWebContext;
import org.hibernate.SessionFactory;

public interface IActionContext {
    public IWebContext getWebContext();

    public SessionFactory getSessionFactory();

    public Object getParam(String var1);

    public void setParam(String var1, Object var2);

    public String getOperator();

    public String getOperatorName();

    public String getRemoteAddr();
}

