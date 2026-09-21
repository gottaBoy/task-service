/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import java.sql.Connection;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.SqlParamList;

public interface IDatabase
extends IModelBase {
    public String getDBType();

    public Connection getConnection() throws Exception;

    public String getCountSQL(String var1);

    public String getPagingSQL(String var1, int var2, int var3, String var4, String var5, String var6, String var7);

    public int getJDBCType(int var1);

    public DBCallResult callSql(Connection var1, String var2, SqlParamList var3, int var4) throws Exception;

    public DBCallResult callProc(Connection var1, String var2, SqlParamList var3, int var4) throws Exception;

    public String getConditionSQL(String var1, int var2, String var3, String var4, boolean var5, SqlParamList var6) throws Exception;

    public String getDBObjStandardName(String var1);
}

