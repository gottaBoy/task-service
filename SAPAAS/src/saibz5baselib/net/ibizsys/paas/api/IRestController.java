/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.sysmodel.ISystemModel;
import org.hibernate.SessionFactory;

public interface IRestController {
    public String getId();

    public ISystemModel getSystemModel();

    public void setSessionFactory(SessionFactory var1);

    public SessionFactory getSessionFactory();
}

