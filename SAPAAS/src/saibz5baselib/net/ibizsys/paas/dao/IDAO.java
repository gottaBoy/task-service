/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Session
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.dao;

import java.util.ArrayList;
import net.ibizsys.paas.core.IDEDBCallContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.web.IWebContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface IDAO<ET extends IEntity> {
    public IDataEntityModel getDEModel();

    public ISystemModel getSystemModel();

    public IWebContext getWebContext();

    public String getDSLink();

    public void setDSLink(String var1);

    public void setSessionFactory(SessionFactory var1);

    public SessionFactory getSessionFactory();

    public void setDBDialect(IDBDialect var1);

    public Session getCurrentSession() throws Exception;

    public DBCallResult executeGetSql(IDEDBCallContext var1, ET var2, boolean var3) throws Exception;

    public DBCallResult executeGetSql(IDEDBCallContext var1, ET var2, int var3, boolean var4) throws Exception;

    public DBCallResult executeCreateSql(IDEDBCallContext var1, ET var2, boolean var3) throws Exception;

    public DBCallResult executeUpdateSql(IDEDBCallContext var1, ET var2, boolean var3) throws Exception;

    public DBCallResult executeSysUpdateSql(IDEDBCallContext var1, ET var2, boolean var3) throws Exception;

    public DBCallResult executeRemoveSql(IDEDBCallContext var1, ET var2, boolean var3) throws Exception;

    public DBCallResult executeRemoveSql(IDEDBCallContext var1, ISelectCond var2, boolean var3) throws Exception;

    public DBCallResult executeSelectSql(IDEDBCallContext var1, ISelectCond var2, boolean var3) throws Exception;

    public DBCallResult executeCheckKeySql(IDEDBCallContext var1, ET var2, boolean var3) throws Exception;

    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext var1, String var2, boolean var3) throws Exception;

    public DBCallResult executeRawSql(IDEDBCallContext var1, String var2, SqlParamList var3) throws Exception;

    public DBCallResult executeRawSqlBatch(IDEDBCallContext var1, String[] var2, SqlParamList[] var3, int var4) throws Exception;

    public DBFetchResult fetchDEDataQuery(IDEDataSetFetchContext var1, String var2, boolean var3) throws Exception;

    public ArrayList<IEntity> executeRawSelectSql(IDEDBCallContext var1, String var2, SqlParamList var3) throws Exception;

    public ArrayList<ET> executeSelectSql(IDEDBCallContext var1, String var2, SqlParamList var3) throws Exception;

    public IEntity executeRawSelectOneSql(IDEDBCallContext var1, String var2, SqlParamList var3) throws Exception;

    public DBCallResult callProc(IDEDBCallContext var1, String var2, SqlParamList var3) throws Exception;

    public IDBDialect getRealDBDialect();

    public DBCallResult fetchDEDataQuery(ISelectContext var1, boolean var2) throws Exception;
}

