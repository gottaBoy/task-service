/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.core;

import net.ibizsys.pscore.srv.core.IPSViewMsgFilter;
import org.hibernate.SessionFactory;

public class PSViewMsgFilter
implements IPSViewMsgFilter {
    private String strAppViewName = null;
    private String strViewMsgGroupId = null;
    private String strDEName = null;
    private String strKey = null;
    private String strParentDEName = null;
    private String strParentKey = null;
    private String strParentMode = null;
    private SessionFactory sessionFactory = null;

    @Override
    public String getAppViewName() {
        return this.strAppViewName;
    }

    @Override
    public String getViewMsgGroupId() {
        return this.strViewMsgGroupId;
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    @Override
    public String getKey() {
        return this.strKey;
    }

    @Override
    public String getParentDEName() {
        return this.strParentDEName;
    }

    @Override
    public String getParentKey() {
        return this.strParentKey;
    }

    @Override
    public String getParentMode() {
        return this.strParentMode;
    }

    public void setAppViewName(String string) {
        this.strAppViewName = string;
    }

    public void setViewMsgGroupId(String string) {
        this.strViewMsgGroupId = string;
    }

    public void setDEName(String string) {
        this.strDEName = string;
    }

    public void setKey(String string) {
        this.strKey = string;
    }

    public void setParentDEName(String string) {
        this.strParentDEName = string;
    }

    public void setParentKey(String string) {
        this.strParentKey = string;
    }

    public void setParentMode(String string) {
        this.strParentMode = string;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

