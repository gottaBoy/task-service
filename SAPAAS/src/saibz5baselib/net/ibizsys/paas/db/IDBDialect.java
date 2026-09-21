/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import java.sql.Connection;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataRange;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.db.ProcParamList;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;

public interface IDBDialect {
    public static final String DBTYPE_SQLSERVER = "SQLSERVER";
    public static final String DBTYPE_ORACLE = "ORACLE";
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String DBTYPE_DB2 = "DB2";
    public static final String DBTYPE_POSTGRESQL = "POSTGRESQL";
    public static final String DBTYPE_PPAS = "PPAS";
    public static final String FUNC_CURDATETIME = "CURDATETIME";
    public static final String FUNC_CURDATE = "CURDATE";
    public static final String FUNC_VERSION = "VERSION";
    public static final String FUNC_INSTR = "INSTR";
    public static final String VALUEFUNC_DATEDIFFNOW = "DATEDIFFNOW";
    public static final String VALUEFUNC_DATEDIFFNOW2 = "DATEDIFFNOW2";
    public static final String VALUEFUNC_STRLEN = "STRLEN";
    public static final String FUNC_MAX = "MAX";
    public static final String FUNC_MIN = "MIN";
    public static final String FUNC_AVG = "AVG";
    public static final String FUNC_COUNT = "COUNT";
    public static final String FUNC_SUM = "SUM";

    public String getDBType();

    public String getCountSQL(String var1);

    public String getPagingSQL(String var1, int var2, int var3, String var4, String var5, String var6, String var7);

    public String getPagingSQL(String var1, int var2, int var3, String var4, String var5, String var6, String var7, IDEDataQueryCode var8);

    public int getJDBCType(int var1);

    public DBCallResult callSql(Connection var1, String var2, SqlParamList var3, int var4) throws Exception;

    public DBCallResult callProc(Connection var1, String var2, SqlParamList var3, int var4) throws Exception;

    public DBCallResult getLastInsertId(Connection var1) throws Exception;

    public String getConditionSQL(String var1, int var2, String var3, String var4, boolean var5, SqlParamList var6) throws Exception;

    public String getFuncSQL(String var1, String[] var2) throws Exception;

    public String getFuncSQL(String var1, boolean var2, String[] var3) throws Exception;

    public String getDEFieldValueSQL(IDEField var1, IEntity var2, boolean var3, boolean var4) throws Exception;

    public IDBFunction getDBFunction(String var1) throws Exception;

    public String getTopRowSQL(String var1, int var2) throws Exception;

    public String getOrgDRCond(UserRoleData var1, Org var2, String var3) throws Exception;

    public String getOrgSecDRCond(UserRoleData var1, OrgSector var2, String var3) throws Exception;

    public String getOrgDRCond(IDEDataRange var1, Org var2, String var3) throws Exception;

    public String getOrgSecDRCond(IDEDataRange var1, OrgSector var2, String var3) throws Exception;

    public String getDBObjStandardName(String var1);

    public String getMergeSQL(IDataEntity var1, ProcParamList var2) throws Exception;

    public DBCallResult callSqlBatch(Connection var1, String[] var2, SqlParamList[] var3, int var4, int var5) throws Exception;
}

