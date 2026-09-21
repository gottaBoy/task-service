/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.web.IWebContext;

public interface IDEDataQueryCode
extends IModelBase {
    public IDEDataQuery getDEDataQuery();

    public String getDBType();

    public String getQueryCode();

    public String getQueryCodeTemp();

    public String getDeclareCode();

    public String getQueryCode(IDEDataSetFetchContext var1, IDBDialect var2, SqlParamList var3) throws Exception;

    public String getQueryCodeTemp(IDEDataSetFetchContext var1, IDBDialect var2, SqlParamList var3) throws Exception;

    public String getDeclareCode(IDEDataSetFetchContext var1, IDBDialect var2, SqlParamList var3) throws Exception;

    public void fillDeclareParams(IWebContext var1, IDataObject var2, SqlParamList var3) throws Exception;

    public void fillQueryParams(IWebContext var1, IDataObject var2, SqlParamList var3) throws Exception;

    public String getConditionSQL(IDEDataSetFetchContext var1, IDEDataQueryCodeCond var2, IDBDialect var3, SqlParamList var4) throws Exception;

    public String getExtJoinSQL(IDEDataSetFetchContext var1, String var2, IDBDialect var3, SqlParamList var4) throws Exception;

    public Iterator<IDEDataQueryCodeCond> getDEDataQueryCodeConds();

    public String getDEFieldExp(String var1, boolean var2) throws Exception;

    public Iterator<IDEDataQueryCodeExp> getDEDataQueryCodeExps();
}

