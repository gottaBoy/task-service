/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.Oracle.OraDBProcCaller
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx.DB2;

import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.Oracle.OraDBProcCaller;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class DB2DBProcCallerEx
extends OraDBProcCaller {
    protected static Hashtable<String, String> sqlToDB2Table = null;
    public static final String DATABASE = "DB2";
    public static final String GOTOTARGET = "SRF_RT";

    static {
        sqlToDB2Table = new Hashtable();
        sqlToDB2Table.put("bigint", "NUMBERPS");
        sqlToDB2Table.put("binary", "RAW");
        sqlToDB2Table.put("bit", "CHAR");
        sqlToDB2Table.put("char", "CHAR");
        sqlToDB2Table.put("datetime", "DATE");
        sqlToDB2Table.put("decimal", "NUMBERPS");
        sqlToDB2Table.put("float", "NUMBER");
        sqlToDB2Table.put("image", "BLOB");
        sqlToDB2Table.put("int", "NUMBER");
        sqlToDB2Table.put("money", "NUMBERPS");
        sqlToDB2Table.put("nchar", "CHAR");
        sqlToDB2Table.put("ntext", "CLOB");
        sqlToDB2Table.put("nvarchar", "VARCHAR");
        sqlToDB2Table.put("numeric", "NUMBERPS");
        sqlToDB2Table.put("real", "NUMBER");
        sqlToDB2Table.put("smalldatetime", "DATE");
        sqlToDB2Table.put("smallint", "NUMBERPS");
        sqlToDB2Table.put("smallmoney", "NUMBERPS");
        sqlToDB2Table.put("sysname", "VARCHAR");
        sqlToDB2Table.put("text", "CLOB");
        sqlToDB2Table.put("timestamp", "DATE");
        sqlToDB2Table.put("tinyint", "NUMBERPS");
        sqlToDB2Table.put("varbinary", "RAW");
        sqlToDB2Table.put("varchar", "VARCHAR");
        sqlToDB2Table.put("uniqueidentifier", "LONG RAW");
    }

    protected static String GetDB2DataType(DBCallerParam param) {
        String strDataType = param.getDataType();
        if (sqlToDB2Table.containsKey(strDataType = strDataType.toLowerCase())) {
            return sqlToDB2Table.get(strDataType);
        }
        return "";
    }

    protected static String GetDB2DataType(String strDataType) {
        if (sqlToDB2Table.containsKey(strDataType = strDataType.toLowerCase())) {
            return sqlToDB2Table.get(strDataType);
        }
        return "";
    }

    protected boolean AppendProcParam(StringBuilderEx stringBuilder, boolean bDefaultNull, boolean bValidFlag) {
        boolean bFirstParam = true;
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (!(param.getDirection() != 1 && param.getDirection() != 2 && param.getDirection() != 3 || param.getRawValue() || StringHelper.Length((String)param.getDatabase()) != 0 && StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) != 0)) {
                String strExt;
                if (bFirstParam) {
                    bFirstParam = false;
                } else {
                    stringBuilder.Append(",\n");
                }
                if (bValidFlag) {
                    stringBuilder.Append("var%1$sVF integer default 1", param.getID());
                    stringBuilder.Append(",\n");
                }
                if (StringHelper.Length((String)(strExt = param.getDataTypeExt())) == 0) {
                    stringBuilder.Append("var%1$s %2$s %3$s", param.getID(), DB2DBProcCallerEx.GetParamDirection(param), DB2DBProcCallerEx.GetDB2DataType(param));
                } else {
                    stringBuilder.Append("var%1$s %2$s %3$s", param.getID(), DB2DBProcCallerEx.GetParamDirection(param), DB2DBProcCallerEx.GetDB2DataType(param));
                }
                if (bDefaultNull) {
                    stringBuilder.Append(" default null ");
                }
            }
            ++i;
        }
        return !bFirstParam;
    }

    protected static String GetParamDirection(DBCallerParam param) {
        switch (param.getDirection()) {
            case 1: {
                return "";
            }
            case 2: {
                return "out";
            }
            case 3: {
                return "in out";
            }
        }
        return "";
    }

    protected void AppendInsertParamValue(StringBuilderEx stringBuilder) {
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (param.getDeclareParam() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0)) {
                if (param.getRawValue()) {
                    stringBuilder.Append("set @%1$s = %2$s\n", param.getID(), param.getParamValue());
                } else if (StringHelper.Compare((String)param.getValueMode(), (String)"IDENTITY", (boolean)true) != 0) {
                    stringBuilder.Append("set @%1$s = ?\n", param.getID());
                }
            }
            ++i;
        }
    }

    protected void AppendUpdateParamValue(StringBuilderEx stringBuilder) {
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (param.getDeclareParam() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0)) {
                if (param.getRawValue()) {
                    stringBuilder.Append("set @%1$s = %2$s\n", param.getID(), param.getParamValue());
                } else {
                    stringBuilder.Append("set @%1$s = ?\n", param.getID());
                }
            }
            ++i;
        }
    }

    protected String GetInsertKeyCondition() {
        String strKeyCondition = "";
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0) {
                if (!param.getKey()) break;
                if (StringHelper.Compare((String)param.getValueMode(), (String)"IDENTITY", (boolean)true) != 0) {
                    if (StringHelper.Length((String)strKeyCondition) != 0) {
                        strKeyCondition = String.valueOf(strKeyCondition) + " AND ";
                    }
                    strKeyCondition = String.valueOf(strKeyCondition) + StringHelper.Format((String)"([%1$s] = @%1$s)", (Object)param.getID());
                }
            }
            ++i;
        }
        return strKeyCondition;
    }

    protected void AppendGetKeyCode(StringBuilderEx stringBuilder) {
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0) {
                if (!param.getKey()) break;
                if (StringHelper.Compare((String)param.getValueMode(), (String)"IDENTITY", (boolean)true) == 0) {
                    stringBuilder.Append("select @%1$s=@@identity from %2$s\n", param.getID(), this.dbCallerConfig.getProcName());
                }
            }
            ++i;
        }
    }

    protected String GetUpdateKeyCondition() {
        String strKeyCondition = "";
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0) {
                if (!param.getKey()) break;
                if (StringHelper.Length((String)strKeyCondition) != 0) {
                    strKeyCondition = String.valueOf(strKeyCondition) + " AND ";
                }
                strKeyCondition = String.valueOf(strKeyCondition) + StringHelper.Format((String)"([%1$s] = @%1$s)", (Object)param.getID());
            }
            ++i;
        }
        return strKeyCondition;
    }

    protected void AppendCreateProc(StringBuilderEx stringBuilder, String strProcName) {
        stringBuilder.Append("create or replace procedure %1$s   -- %2$s", strProcName, new Date().toString());
    }

    protected void AppendProcEnd(StringBuilderEx stringBuilder, String strProcName) {
        stringBuilder.Append("end %1$s;", strProcName);
    }

    protected DBResult ExecCreateProcSQL(Connection connection, String strSql) throws SQLException {
        DBResult dbResult = new DBResult();
        dbResult.setRetCode(1);
        dbResult.setDatabase(1);
        CallableStatement cstmt = null;
        try {
            try {
                String strProc = this.FormatProcCall("pkg_SRF2.sp_executeSQL", 1);
                cstmt = connection.prepareCall(strProc);
                int nParamIndex = 1;
                cstmt.setObject(nParamIndex, strSql, 12);
                boolean bRet = cstmt.execute();
                if (cstmt.getWarnings() != null) {
                    String strInfo = cstmt.getWarnings().toString();
                    strInfo = "";
                }
                dbResult.setRetCode(0);
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                dbResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                if (cstmt != null) {
                    cstmt.close();
                }
            }
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
        }
        return dbResult;
    }

    protected ArrayList GetProcParams() {
        ArrayList<DBCallerParam> params = new ArrayList<DBCallerParam>();
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (!(param.getDirection() != 1 && param.getDirection() != 2 && param.getDirection() != 3 || param.getRawValue() || StringHelper.Length((String)param.getDatabase()) != 0 && StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) != 0)) {
                params.add(param);
            }
            ++i;
        }
        return params;
    }

    protected void AppendCondSqlPreFix(StringBuilderEx stringBuilder, String strConditionParam, String strTab) {
        stringBuilder.Append("%2$sif  %1$s IS NULL OR %1$s = ''  THEN\n", strConditionParam, strTab);
        stringBuilder.Append("%2$s\t%1$s := %1$s || ' WHERE ';\n", strConditionParam, strTab);
        stringBuilder.Append("%1$sELSE\n", strTab);
        stringBuilder.Append("%2$s\t%1$s := %1$s || ' AND ';\n", strConditionParam, strTab);
        stringBuilder.Append("%1$sEND IF;\n", strTab);
    }

    protected void AppendKeyCondSql(StringBuilderEx stringBuilder, String strCondSQL, boolean bIgnoreAutoValueParam) {
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (!(StringHelper.Length((String)param.getDatabase()) != 0 && StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) != 0 || !param.getKey() || bIgnoreAutoValueParam && StringHelper.Compare((String)param.getValueMode(), (String)"SEQUENCE", (boolean)true) == 0)) {
                stringBuilder.Append("if var%1$sVF = 1 THEN\n", param.getID());
                this.AppendCondSqlPreFix(stringBuilder, strCondSQL, "\t");
                stringBuilder.Append("\tif var%1$s  IS NULL THEN\n", param.getID());
                stringBuilder.Append("\t\t%2$s := %2$s || ' (%1$s IS NULL)';\n", param.getParamName(), strCondSQL);
                stringBuilder.Append("\tELSE\n");
                if (DataTypeHelper.IsStringType((int)param.getDBType())) {
                    stringBuilder.Append("\t\t%4$s := %4$s || ' (%1$s %2$s '''|| var%3$s ||''')';\n", param.getParamName(), param.getMatchAction(), param.getID(), strCondSQL);
                } else {
                    String strCastFunc = param.getCastFunc();
                    if (StringHelper.Length((String)strCastFunc) == 0) {
                        strCastFunc = "to_char(var%1$s)";
                    }
                    String strCastParam = StringHelper.Format((String)strCastFunc, (Object)param.getID());
                    if (DataTypeHelper.IsDateTimeType((int)param.getDBType())) {
                        stringBuilder.Append("\t\t%4$s := %4$s || ' (%1$s %2$s '''|| %3$s ||''')';\n", param.getParamName(), param.getMatchAction(), strCastParam, strCondSQL);
                    } else {
                        stringBuilder.Append("\t\t%4$s := %4$s || ' (%1$s %2$s '|| %3$s ||')';\n", param.getParamName(), param.getMatchAction(), strCastParam, strCondSQL);
                    }
                }
                stringBuilder.Append("\tEND IF;\n");
                stringBuilder.Append("END IF;\n");
            }
            ++i;
        }
    }

    protected void AppendRawKeyCond(StringBuilderEx stringBuilder, boolean bIgnoreAutoValueParam) {
        boolean bFirstParam = true;
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (!(StringHelper.Length((String)param.getDatabase()) != 0 && StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) != 0 || !param.getKey() || bIgnoreAutoValueParam && StringHelper.Compare((String)param.getValueMode(), (String)"SEQUENCE", (boolean)true) == 0)) {
                if (bFirstParam) {
                    bFirstParam = false;
                } else {
                    stringBuilder.Append(" AND ");
                }
                stringBuilder.Append("((var%1$sVF = 1) AND (( var%1$s IS NULL  AND  %2$s IS NULL) OR (var%1$s IS NOT NULL  AND  %2$s  = var%1$s)))", param.getID(), param.getParamName());
            }
            ++i;
        }
    }

    protected String GetRawKeyCond(boolean bIgnoreAutoValueParam) {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.AppendRawKeyCond(stringBuilder, bIgnoreAutoValueParam);
        return stringBuilder.toString();
    }

    protected String GetKeyCondSql(boolean bIgnoreAutoValueParam) {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        boolean bFirst = true;
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (!(StringHelper.Length((String)param.getDatabase()) != 0 && StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) != 0 || !param.getKey() || bIgnoreAutoValueParam && StringHelper.Compare((String)param.getValueMode(), (String)"SEQUENCE", (boolean)true) == 0)) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    stringBuilder.Append(" AND ");
                }
                stringBuilder.Append("(%1$s = var%2$s )", param.getParamName(), param.getID());
            }
            ++i;
        }
        return stringBuilder.toString();
    }

    protected void AppendDeclareParam(StringBuilderEx stringBuilder) {
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (param.getDirection() == 5 && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0)) {
                String strExt = param.getDataTypeExt();
                if (StringHelper.Length((String)strExt) == 0) {
                    stringBuilder.Append("var%1$s %2$s;\n", param.getID(), DB2DBProcCallerEx.GetDB2DataType(param));
                } else {
                    stringBuilder.Append("var%1$s %2$s(%3$s);\n", param.getID(), DB2DBProcCallerEx.GetDB2DataType(param), strExt);
                }
            }
            ++i;
        }
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction(DATABASE, "DECLAREPARAM"));
    }

    protected void AppendRawValueParamInit(StringBuilderEx stringBuilder) {
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (param.getDirection() == 5 && param.getRawValue() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0) && StringHelper.Length((String)param.getOriginParamValue()) != 0) {
                String strFormat = param.getRawValueFormat();
                if (StringHelper.Length((String)strFormat) == 0) {
                    strFormat = "%1$s := %2$s;";
                }
                stringBuilder.Append(strFormat, "var" + param.getID(), param.getOriginParamValue());
                stringBuilder.Append("\n");
            }
            ++i;
        }
    }

    protected String GetFullOracleDataType(String strOraDataType, String strExt, int nLength) {
        if (StringHelper.Compare((String)strOraDataType, (String)"VARCHAR", (boolean)true) == 0) {
            if (nLength == 0) {
                nLength = 200;
            }
            return StringHelper.Format((String)"%1$s(%2$s)", (Object)strOraDataType, (Object)nLength);
        }
        if (StringHelper.Compare((String)strOraDataType, (String)"DATE", (boolean)true) == 0) {
            return strOraDataType;
        }
        if (StringHelper.IsNullOrEmpty((String)strExt)) {
            return strOraDataType;
        }
        return StringHelper.Format((String)"%1$s(%2$s)", (Object)strOraDataType, (Object)strExt);
    }
}

