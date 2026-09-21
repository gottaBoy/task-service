/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.core;

import org.hibernate.SessionFactory;

public interface IPSViewMsgFilter {
    public String getAppViewName();

    public String getViewMsgGroupId();

    public String getDEName();

    public String getKey();

    public String getParentDEName();

    public String getParentKey();

    public String getParentMode();

    public SessionFactory getSessionFactory();
}

