/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DBUserError
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.Oracle.OracleDataSet
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx.Oracle;

import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.Oracle.OracleDataSet;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.IDBSelectCmdCaller;
import SA.SRFramework.DataEx.Oracle.OraDBProcCallerEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class OraSelectCmdCaller
extends OraDBProcCallerEx
implements IDBSelectCmdCaller {
    @Override
    public SelectResult Invoke(Hashtable paramList, String strOpPersonId) throws SQLException {
        SelectResult selectResult = null;
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            selectResult = new SelectResult();
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            selectResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return selectResult;
        }
        try {
            try {
                selectResult = this.Invoke(SqlConn, paramList, strOpPersonId);
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                this.ReleaseConnection(SqlConn);
            }
        }
        finally {
            this.ReleaseConnection(SqlConn);
        }
        return selectResult;
    }

    @Override
    public SelectResult Invoke(Connection connection, Hashtable paramList, String strOpPersonId) throws SQLException {
        SelectResult selectResult = new SelectResult();
        selectResult.setRetCode(1);
        selectResult.setDatabase(1);
        if (this.dbCallerConfig.getAutoGenProc() && !this.dbCallerConfig.getGenProcFinish()) {
            DBResult dbResult = this.GenSelectProc(connection);
            if (dbResult == null) {
                return selectResult;
            }
            if (dbResult.getRetCode() != 0) {
                selectResult.setRetCode(dbResult.getRetCode());
                selectResult.setErrorInfo(dbResult.getErrorInfo());
                return selectResult;
            }
        }
        CallableStatement cstmt = null;
        Hashtable<Integer, String> outputParamList = new Hashtable<Integer, String>();
        try {
            try {
                ArrayList procParams = this.GetProcParams();
                int nParamCount = procParams.size();
                int nCallParamCount = nParamCount * 2 + 3;
                String strProc = this.FormatProcCall(this.dbCallerConfig.getGenProcName(), nCallParamCount);
                cstmt = connection.prepareCall(strProc);
                int nParamIndex = 1;
                int nParamReturnRS = nParamIndex++;
                cstmt.registerOutParameter(nParamReturnRS, -10);
                int nParamReturnSystemRS = nParamIndex++;
                cstmt.registerOutParameter(nParamReturnSystemRS, -10);
                int i = 0;
                while (i < nParamCount) {
                    DBCallerParam param = (DBCallerParam)procParams.get(i);
                    String strParamValue = param.getParamValue().toUpperCase();
                    Object objTemp = paramList.get(strParamValue);
                    if (objTemp == null) {
                        cstmt.setObject(nParamIndex, 0, 2);
                        ++nParamIndex;
                        if (param.getDirection() == 1) {
                            cstmt.setObject(nParamIndex, objTemp, this.GetJDBCType(param.getDBType()));
                        } else if (param.getDirection() == 2) {
                            cstmt.registerOutParameter(nParamIndex, this.GetJDBCType(param.getDBType()));
                            outputParamList.put(nParamIndex, strParamValue);
                        } else if (param.getDirection() == 3) {
                            cstmt.setObject(nParamIndex, objTemp, this.GetJDBCType(param.getDBType()));
                            cstmt.registerOutParameter(nParamIndex, this.GetJDBCType(param.getDBType()));
                            outputParamList.put(nParamIndex, strParamValue);
                        }
                        ++nParamIndex;
                    } else {
                        cstmt.setObject(nParamIndex, 1, 2);
                        ++nParamIndex;
                        if (param.getEndOfDay()) {
                            this.SetParamEndOfDay(paramList, strParamValue);
                        }
                        if (objTemp instanceof String && objTemp.toString().length() == 0) {
                            objTemp = null;
                        }
                        if (param.getDirection() == 1) {
                            cstmt.setObject(nParamIndex, objTemp, this.GetJDBCType(param.getDBType()));
                        } else if (param.getDirection() == 2) {
                            cstmt.registerOutParameter(nParamIndex, this.GetJDBCType(param.getDBType()));
                            outputParamList.put(nParamIndex, strParamValue);
                        } else if (param.getDirection() == 3) {
                            cstmt.setObject(nParamIndex, objTemp, this.GetJDBCType(param.getDBType()));
                            cstmt.registerOutParameter(nParamIndex, this.GetJDBCType(param.getDBType()));
                            outputParamList.put(nParamIndex, strParamValue);
                        }
                        ++nParamIndex;
                    }
                    ++i;
                }
                int nParamOPPersonIndex = nParamIndex++;
                cstmt.setObject(nParamOPPersonIndex, strOpPersonId, this.GetJDBCType(25));
                cstmt.execute();
                OracleDataSet dataSet = new OracleDataSet();
                ResultSet rsSystem = (ResultSet)cstmt.getObject(nParamReturnSystemRS);
                dataSet.AddResultSet(rsSystem);
                rsSystem.close();
                Integer nRetCode = 1;
                if (dataSet.getTable(0).GetRowCount() > 0) {
                    DataRow dr = dataSet.getTable(0).GetRow(0);
                    nRetCode = Integer.parseInt(dr.Get("RETCODE").toString());
                    Object objMessage = dr.Get("MESSAGE");
                    if (objMessage != null) {
                        selectResult.setErrorInfo(objMessage.toString());
                    }
                    if (!dr.IsDBNull("USERTAG")) {
                        selectResult.getOutValues().put("USERTAG", dr.Get("USERTAG"));
                    }
                    if (!dr.IsDBNull("USERTAG2")) {
                        selectResult.getOutValues().put("USERTAG2", dr.Get("USERTAG2"));
                    }
                }
                if (nRetCode == 0) {
                    ResultSet rs = (ResultSet)cstmt.getObject(nParamReturnRS);
                    dataSet.InsertResultSet(0, rs);
                    rs.close();
                }
                selectResult.setRetCode(nRetCode.intValue());
                selectResult.setSelectData((DataSet)dataSet);
                selectResult.setDataTableIndex(0);
                if (nRetCode != 0) {
                    DBUserError dbUserError = this.dbCallerConfig.GetUserError(nRetCode.toString());
                    if (dbUserError != null) {
                        selectResult.setErrorInfo(dbUserError.getMessage());
                    } else if (!Errors.IsUserError(nRetCode)) {
                        selectResult.setErrorInfo(Errors.GetErrorInfo(nRetCode));
                    }
                }
                Enumeration enumeration = outputParamList.keys();
                while (enumeration.hasMoreElements()) {
                    int nIndex = (Integer)enumeration.nextElement();
                    String strParamValue = (String)outputParamList.get(nIndex);
                    if (cstmt.getObject(nIndex) == null) continue;
                    paramList.put(strParamValue, cstmt.getObject(nIndex));
                }
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                selectResult.setErrorInfo(ex.toString());
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
        return selectResult;
    }

    protected DBResult GenSelectProc(Connection connection) {
        DBResult dbResult = new DBResult();
        dbResult.setRetCode(1);
        dbResult.setDatabase(1);
        String strGenProcName = this.dbCallerConfig.getGenProcName();
        if (StringHelper.Length((String)strGenProcName) == 0) {
            dbResult.setErrorInfo("\u6ca1\u6709\u5b9a\u4e49\u4ea7\u751f\u7684\u8fc7\u7a0b\u540d\u79f0");
            return dbResult;
        }
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.AppendCreateProc(stringBuilder, strGenProcName);
        stringBuilder.Append("\n(\n");
        stringBuilder.Append("varRd out PKG_SRF2.recordset,\n");
        stringBuilder.Append("varRdSystem out PKG_SRF2.recordset, --\u7cfb\u7edf\u6267\u884c\u7ed3\u679c\n");
        if (this.AppendProcParam(stringBuilder, true, true)) {
            stringBuilder.Append(",\n");
        }
        stringBuilder.Append("varOPPersonId VARCHAR2");
        stringBuilder.Append("\n)\n");
        stringBuilder.Append("IS\n");
        stringBuilder.Append("strSql VARCHAR2(4000):='';\n");
        stringBuilder.Append("strConSql VARCHAR2(4000):='';\n");
        stringBuilder.Append("nRetCode int:=0;\n");
        stringBuilder.Append("strErrorInfo VARCHAR2(2000):='';\n");
        stringBuilder.Append("strSRFTag VARCHAR2(4000):='';\n");
        stringBuilder.Append("strSRFTag2 VARCHAR2(4000):='';\n");
        stringBuilder.Append("BEGIN\n");
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("ORACLE", "PREPARE"));
        if (StringHelper.Length((String)this.dbCallerConfig.getUserReturn()) > 0) {
            stringBuilder.Append("strSql:= 'select %2$s,* from %1$s' ;\n", this.dbCallerConfig.getViewName(), this.dbCallerConfig.getUserReturn());
        } else {
            stringBuilder.Append("strSql:= 'select * from %1$s';\n", this.dbCallerConfig.getViewName());
        }
        if (this.dbCallerConfig.getLogicEnable()) {
            stringBuilder.Append("strConSql := ' where enable = 1 ';\n");
        } else {
            stringBuilder.Append("strConSql := '';\n");
        }
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"ORACLE", (boolean)true) == 0) {
                if (!param.getRawValue()) {
                    stringBuilder.Append("if var%1$sVF = 1 THEN\n", param.getID());
                    stringBuilder.Append("if  strConSql IS NULL OR strConSql = ''  THEN\n");
                    stringBuilder.Append("\t\tstrConSql := strConSql || ' WHERE ';\n");
                    stringBuilder.Append("\tELSE\n");
                    stringBuilder.Append("\t\tstrConSql := strConSql || ' AND ';\n");
                    stringBuilder.Append("\tEND IF;\n");
                    stringBuilder.Append("\tif var%1$s  IS NULL THEN\n", param.getID());
                    stringBuilder.Append("\t\tstrConSql := strConSql || ' (%1$s IS NULL)';\n", param.getParamName());
                    stringBuilder.Append("\tELSE\n");
                    if (DataTypeHelper.IsStringType((int)param.getDBType())) {
                        stringBuilder.Append("\t\tstrConSql := strConSql || ' (%1$s %2$s '''|| var%3$s ||''')';\n", param.getParamName(), param.getMatchAction(), param.getID());
                    } else {
                        String strCastFunc = param.getCastFunc();
                        if (StringHelper.Length((String)strCastFunc) == 0) {
                            strCastFunc = "to_char(var%1$s)";
                        }
                        String strCastParam = StringHelper.Format((String)strCastFunc, (Object)param.getID());
                        if (DataTypeHelper.IsDateTimeType((int)param.getDBType())) {
                            stringBuilder.Append("\t\tstrConSql := strConSql || ' (%1$s %2$s '''|| %3$s ||''')';\n", param.getParamName(), param.getMatchAction(), strCastParam);
                        } else {
                            stringBuilder.Append("\t\tstrConSql := strConSql || ' (%1$s %2$s '|| %3$s ||')';\n", param.getParamName(), param.getMatchAction(), strCastParam);
                        }
                    }
                    stringBuilder.Append("\tEND IF;\n");
                    stringBuilder.Append("END IF;\n");
                } else {
                    stringBuilder.Append("if  strConSql IS NULL OR strConSql = ''  THEN\n");
                    stringBuilder.Append("\tstrConSql := strConSql || ' WHERE ';\n");
                    stringBuilder.Append("ELSE\n");
                    stringBuilder.Append("\tstrConSql := strConSql || ' AND ';\n");
                    stringBuilder.Append("END IF;\n");
                    stringBuilder.Append("\tstrConSql := strConSql || ' (%1$s %2$s %3$s)';\n", param.getParamName(), param.getMatchAction(), param.getParamValue());
                }
            }
            ++i;
        }
        String strExtCondition = this.dbCallerConfig.FindCustomAction("ORACLE", "CONDITION");
        if (StringHelper.Length((String)strExtCondition) > 0) {
            stringBuilder.Append("if  strConSql IS NULL OR strConSql = ''  THEN\n");
            stringBuilder.Append("\tstrConSql := strConSql || ' WHERE ';\n");
            stringBuilder.Append("ELSE\n");
            stringBuilder.Append("\tstrConSql := strConSql || ' AND ';\n");
            stringBuilder.Append("END IF;\n");
            stringBuilder.Append("strConSql := strConSql || ' %1$s ';\n", strExtCondition);
        }
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("ORACLE", "BEFORE"));
        stringBuilder.Append(" strSql := strSql || strConSql ;\n");
        String strOrderByAction = this.dbCallerConfig.FindCustomActionOne("ORACLE", "DEFAULTORDER");
        if (!StringHelper.IsNullOrEmpty((String)strOrderByAction)) {
            stringBuilder.Append(" strSql := strSql || '%1$s'   ;\n", strOrderByAction);
        }
        stringBuilder.Append("PKG_SRF2.sp_execute(strSql,varRd);\n");
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("ORACLE", "AFTER"));
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("ORACLE", "END"));
        stringBuilder.Append("\n<<%1$s>>\n", "SRF_RT");
        if (StringHelper.Length((String)this.dbCallerConfig.getSystemReturn()) > 0) {
            stringBuilder.Append("open varRdSystem for select nRetCode as RETCODE,strErrorInfo as MESSAGE, strSRFTag as USERTAG ,strSRFTag2 as USERTAG2,%1$s from dual;\n", this.dbCallerConfig.getSystemReturn());
        } else {
            stringBuilder.Append("open varRdSystem for select nRetCode as RETCODE,strErrorInfo as MESSAGE , strSRFTag as USERTAG ,strSRFTag2 as USERTAG2 from dual;\n");
        }
        this.AppendProcEnd(stringBuilder, strGenProcName);
        try {
            DBResult dbResult2 = this.ExecCreateProcSQL(connection, stringBuilder.toString());
            if (dbResult2 != null && dbResult2.getRetCode() == 0) {
                this.dbCallerConfig.setGenProcFinish(true);
            }
            return dbResult2;
        }
        catch (Exception ex) {
            this.LogErrorInfo(ex.toString());
            dbResult.setErrorInfo(ex.toString());
            ex.printStackTrace(System.out);
            return dbResult;
        }
    }

    @Override
    public DBResult CreateProc() throws SQLException {
        DBResult dbResult = null;
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            dbResult = new DBResult();
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        try {
            dbResult = this.GenSelectProc(SqlConn);
            if (dbResult == null) {
                DBResult dBResult = dbResult;
                return dBResult;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            this.ReleaseConnection(SqlConn);
        }
        return dbResult;
    }
}

