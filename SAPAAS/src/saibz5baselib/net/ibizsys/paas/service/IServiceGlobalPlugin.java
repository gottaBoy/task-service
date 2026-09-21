/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.service.IService;
import org.hibernate.SessionFactory;

public interface IServiceGlobalPlugin {
    public void registerService(String var1, IService var2);

    public IService getService(Class var1) throws Exception;

    public IService getService(String var1) throws Exception;

    public void registerService(String var1, String var2, IService var3);

    public IService getService(Class var1, String var2) throws Exception;

    public IService getService(String var1, String var2) throws Exception;

    public IService getService(Class var1, SessionFactory var2) throws Exception;

    public IService getService(String var1, SessionFactory var2) throws Exception;

    public void resetServices(SessionFactory var1) throws Exception;

    public void resetServiceCache(SessionFactory var1) throws Exception;
}

