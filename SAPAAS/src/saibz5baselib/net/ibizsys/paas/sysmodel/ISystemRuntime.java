/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import org.hibernate.SessionFactory;

public interface ISystemRuntime
extends ISystemModel {
    public IDBDialect getDBDialect();

    public SessionFactory getSessionFactory();

    public IDBDialect getDBDialect2();

    public SessionFactory getSessionFactory2();

    public IDBDialect getDBDialect3();

    public SessionFactory getSessionFactory3();

    public IDBDialect getDBDialect4();

    public SessionFactory getSessionFactory4();

    public IDBDialect getDBDialect5();

    public SessionFactory getSessionFactory5();

    public IDBDialect getDBDialect6();

    public SessionFactory getSessionFactory6();

    public IDBDialect getDBDialect7();

    public SessionFactory getSessionFactory7();

    public IDBDialect getDBDialect8();

    public SessionFactory getSessionFactory8();

    public IDBDialect getDBDialect9();

    public SessionFactory getSessionFactory9();

    public IDBDialect getDBDialect10();

    public SessionFactory getSessionFactory10();

    public IDBDialect getDBDialect11();

    public SessionFactory getSessionFactory11();

    public IDBDialect getDBDialect12();

    public SessionFactory getSessionFactory12();

    public IDBDialect getDBDialect(String var1);

    public SessionFactory getSessionFactory(String var1);

    @Override
    public void installRTDatas() throws Exception;

    public String getLocalization();

    public Object createObject(String var1) throws Exception;

    public SessionFactory getRealSessionFactory(IDataEntityModel var1, SessionFactory var2);

    public String getServiceAPIClientId();

    public boolean isUseServiceAPI();

    public boolean isDEUseServiceAPI(IDataEntityModel var1);

    public IServiceAPIClientModel getServiceAPIClientModel() throws Exception;

    public String getModuleId();
}

