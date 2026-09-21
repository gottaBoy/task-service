/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.core;

import java.util.HashMap;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import org.hibernate.SessionFactory;

public class ActionContext
implements IActionContext {
    private static ThreadLocal<IActionContext> actionContext = new ThreadLocal();
    protected IWebContext iWebContext = null;
    protected SessionFactory sessionFactory = null;
    protected HashMap<String, Object> paramMap = new HashMap();
    protected String strOperator = null;
    protected String strOperatorName = null;
    protected String strRemoteAddr = null;

    public ActionContext(IWebContext iWebContext) {
        this.iWebContext = iWebContext;
    }

    @Override
    public IWebContext getWebContext() {
        if (this.iWebContext == null) {
            return WebContext.getCurrent();
        }
        return this.iWebContext;
    }

    public void setWebContext(IWebContext iWebContext) {
        this.iWebContext = iWebContext;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Object getParam(String strParamName) {
        return this.paramMap.get(strParamName.toUpperCase());
    }

    @Override
    public void setParam(String strParamName, Object objValue) {
        if (objValue != null) {
            this.paramMap.put(strParamName.toUpperCase(), objValue);
        }
    }

    @Override
    public String getOperator() {
        if (StringHelper.isNullOrEmpty(this.strOperator) && this.getWebContext() != null) {
            return this.getWebContext().getCurUserId();
        }
        return this.strOperator;
    }

    public void setOperator(String strOperator) {
        this.strOperator = strOperator;
    }

    @Override
    public String getOperatorName() {
        if (StringHelper.isNullOrEmpty(this.strOperatorName) && this.getWebContext() != null) {
            return this.getWebContext().getCurUserName();
        }
        return this.strOperatorName;
    }

    public void setOperatorName(String strOperatorName) {
        this.strOperatorName = strOperatorName;
    }

    @Override
    public String getRemoteAddr() {
        if (StringHelper.isNullOrEmpty(this.strRemoteAddr) && this.getWebContext() != null) {
            return this.getWebContext().getRemoteAddr();
        }
        return this.strRemoteAddr;
    }

    public void setRemoteAddr(String strRemoteAddr) {
        this.strRemoteAddr = strRemoteAddr;
    }

    public static IActionContext getCurrent() {
        return actionContext.get();
    }

    public static void setCurrent(IActionContext value) {
        actionContext.set(value);
    }
}

