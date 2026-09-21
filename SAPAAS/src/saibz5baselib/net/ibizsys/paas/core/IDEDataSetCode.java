/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.ArrayList;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.web.IWebContext;

public interface IDEDataSetCode
extends IModelBase {
    public String getDBType();

    public String getQueryCode();

    public String getDeclareScript();

    public String getConditionSQL(IDEDataSetFetchContext var1, IDEField var2, String var3, String var4, String var5) throws Exception;

    public String getConditionSQL(IDEDataSetFetchContext var1, IDEFSearchMode var2, String var3) throws Exception;

    public String replaceURLParamMacro(String var1, IWebContext var2, boolean var3) throws Exception;

    public String replaceURLParamMacro(String var1, IWebContext var2) throws Exception;

    public String replaceDynamicTableMacro(String var1, ArrayList<String> var2) throws Exception;

    public void fillDeclareParams(SqlParamList var1, IWebContext var2, IDataObject var3) throws Exception;

    public void fillSqlParams(SqlParamList var1, IWebContext var2, IDataObject var3) throws Exception;

    public void fillSqlParams(SqlParamList var1, IWebContext var2) throws Exception;

    public String getDEFieldExp(IDEField var1) throws Exception;
}

