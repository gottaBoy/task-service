/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerCheck
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DBUserError
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.InsertResult
 *  SA.SRFramework.Data.Oracle.OracleDataSet
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx.DB2;

import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.Data.DBCallerCheck;
import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.Data.Oracle.OracleDataSet;
import SA.SRFramework.DataEx.DB2.DB2DBProcCallerEx;
import SA.SRFramework.DataEx.IDBInsertCmdCaller;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class DB2InsertCmdCaller
extends DB2DBProcCallerEx
implements IDBInsertCmdCaller {
    @Override
    public InsertResult Invoke(Hashtable paramList, String strOpPersonId) throws SQLException {
        InsertResult insertResult = null;
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            insertResult = new InsertResult();
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            insertResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return insertResult;
        }
        try {
            try {
                insertResult = this.Invoke(SqlConn, paramList, strOpPersonId);
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                this.ReleaseConnection(SqlConn);
            }
        }
        finally {
            this.ReleaseConnection(SqlConn);
        }
        return insertResult;
    }

    @Override
    public InsertResult Invoke(Connection connection, Hashtable paramList, String strOpPersonId) throws SQLException {
        InsertResult insertResult = new InsertResult();
        insertResult.setRetCode(1);
        insertResult.setDatabase(1);
        if (this.dbCallerConfig.getAutoGenProc() && !this.dbCallerConfig.getGenProcFinish()) {
            DBResult dbResult = this.GenInsertProc(connection);
            if (dbResult == null) {
                return insertResult;
            }
            if (dbResult.getRetCode() != 0) {
                insertResult.setRetCode(dbResult.getRetCode());
                insertResult.setErrorInfo(dbResult.getErrorInfo());
                return insertResult;
            }
        }
        CallableStatement cstmt = null;
        Hashtable<Integer, String> outputParamList = new Hashtable<Integer, String>();
        try {
            try {
                ArrayList procParams = this.GetProcParams();
                int nParamCount = procParams.size();
                int nCallParamCount = nParamCount + 3;
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
                        insertResult.setErrorInfo(objMessage.toString());
                    }
                    if (!dr.IsDBNull("USERTAG")) {
                        insertResult.getOutValues().put("USERTAG", dr.Get("USERTAG"));
                    }
                    if (!dr.IsDBNull("USERTAG2")) {
                        insertResult.getOutValues().put("USERTAG2", dr.Get("USERTAG2"));
                    }
                }
                if (nRetCode == 0) {
                    ResultSet rs = (ResultSet)cstmt.getObject(nParamReturnRS);
                    dataSet.InsertResultSet(0, rs);
                    rs.close();
                }
                insertResult.setRetCode(nRetCode.intValue());
                insertResult.setInsertData((DataSet)dataSet);
                insertResult.setDataTableIndex(0);
                if (nRetCode != 0) {
                    DBUserError dbUserError = this.dbCallerConfig.GetUserError(nRetCode.toString());
                    if (dbUserError != null) {
                        insertResult.setErrorInfo(dbUserError.getMessage());
                    } else if (StringHelper.IsNullOrEmpty((String)insertResult.getErrorInfo()) && !Errors.IsUserError(nRetCode)) {
                        insertResult.setErrorInfo(Errors.GetErrorInfo(nRetCode));
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
                insertResult.setErrorInfo(ex.toString());
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
        return insertResult;
    }

    protected DBResult GenInsertProc(Connection connection) {
        String strExtCondition;
        DBCallerParam param;
        ArrayList checks;
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
        stringBuilder.Append("varRdSystem out PKG_SRF2.recordset,\n");
        if (this.AppendProcParam(stringBuilder, true, false)) {
            stringBuilder.Append(",\n");
        }
        stringBuilder.Append("varOPPersonId VARCHAR2\n");
        stringBuilder.Append(")\n");
        stringBuilder.Append("IS\n");
        stringBuilder.Append("nRetCode int:=0;\n");
        stringBuilder.Append("strErrorInfo VARCHAR2(2000):='';\n");
        stringBuilder.Append("strSRFTag VARCHAR2(4000):='';\n");
        stringBuilder.Append("strSRFTag2 VARCHAR2(4000):='';\n");
        stringBuilder.Append("nTemp int:=0;\n");
        this.AppendDeclareParam(stringBuilder);
        stringBuilder.Append("BEGIN\n");
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("DB2", "PREPARE"));
        if (this.dbCallerConfig.getCheckExist()) {
            String strkeyCondition = "";
            strkeyCondition = this.GetKeyCondSql(true);
            if (StringHelper.Length((String)strkeyCondition) > 0) {
                stringBuilder.Append("select count(*) INTO nTemp from %1$s where %2$s ;\n", this.dbCallerConfig.getProcName(), strkeyCondition);
                stringBuilder.Append("if nTemp <> 0 then\n");
                stringBuilder.Append("\tnRetCode := %1$s;\n", 3);
                stringBuilder.Append("\tGOTO %1$s;\n", "SRF_RT");
                stringBuilder.Append("end if;\n");
            }
            stringBuilder.Append("\n");
        }
        String strCondition = "";
        if (this.dbCallerConfig.getLogicEnable()) {
            if (StringHelper.Length((String)strCondition) != 0) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            strCondition = String.valueOf(strCondition) + "(enable = 1)";
        }
        if ((checks = this.dbCallerConfig.getChecks()) != null) {
            int nCount = checks.size();
            int i = 0;
            while (i < nCount) {
                String strParams;
                DBCallerCheck check = (DBCallerCheck)checks.get(i);
                if ((StringHelper.Length((String)check.getDatabase()) == 0 || StringHelper.Compare((String)check.getDatabase(), (String)"DB2", (boolean)true) == 0) && StringHelper.Length((String)(strParams = check.getParams())) != 0) {
                    String[] params = StringHelper.Split((String)strParams, (char)'|');
                    String strCheckFields = "";
                    String strCheckParams = "";
                    int j = 0;
                    while (j < params.length) {
                        String strParam = params[j];
                        strParam = strParam.trim();
                        if (StringHelper.Length((String)strCheckFields) > 0) {
                            strCheckFields = String.valueOf(strCheckFields) + " AND ";
                        }
                        strCheckFields = String.valueOf(strCheckFields) + StringHelper.Format((String)"%1$s = var%1$s", (Object)strParam);
                        if (StringHelper.Length((String)strCheckParams) > 0) {
                            strCheckParams = String.valueOf(strCheckParams) + " AND ";
                        }
                        strCheckParams = String.valueOf(strCheckParams) + StringHelper.Format((String)"var%1$s IS NOT NULL", (Object)strParam);
                        ++j;
                    }
                    stringBuilder.Append("if %1$s then\n", strCheckParams);
                    String strCheckCondition = check.getCondition();
                    if (StringHelper.Length((String)strCondition) > 0) {
                        if (StringHelper.Length((String)strCheckCondition) > 0) {
                            stringBuilder.Append("select count(*) INTO nTemp from %1$s where (%3$s) AND %4$s AND  ( %2$s );\n", this.dbCallerConfig.getProcName(), strCondition, strCheckFields, strCheckCondition);
                        } else {
                            stringBuilder.Append("select count(*) INTO nTemp from %1$s where (%3$s) AND  ( %2$s );\n", this.dbCallerConfig.getProcName(), strCondition, strCheckFields);
                        }
                    } else if (StringHelper.Length((String)strCheckCondition) > 0) {
                        stringBuilder.Append("select count(*) INTO nTemp from %1$s where (%2$s) AND %3$s;\n", this.dbCallerConfig.getProcName(), strCheckFields, strCheckCondition);
                    } else {
                        stringBuilder.Append("select count(*) INTO nTemp  from %1$s where (%2$s);\n", this.dbCallerConfig.getProcName(), strCheckFields);
                    }
                    stringBuilder.Append("\tif nTemp <> 0 then\n");
                    stringBuilder.Append("\t\tnRetCode:= %1$s;\n", check.getRetCode());
                    if (StringHelper.Length((String)check.getMessage()) > 0) {
                        stringBuilder.Append("\t\tstrErrorInfo:= '%1$s';\n", check.getMessage());
                    }
                    stringBuilder.Append("\t\tstrSRFTag := '%1$s';\n", check.getFormItems());
                    stringBuilder.Append("\t\tGOTO %1$s;\n", "SRF_RT");
                    stringBuilder.Append("\tend if;\n");
                    stringBuilder.Append("end if;\n");
                    stringBuilder.Append("\n");
                }
                ++i;
            }
        }
        this.AppendRawValueParamInit(stringBuilder);
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("DB2", "BEFORE"));
        stringBuilder.Append("INSERT INTO %1$s (\n", this.dbCallerConfig.getProcName());
        boolean bFirstUpdate = true;
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if ((StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"DB2", (boolean)true) == 0) && param.getUpdate()) {
                if (!bFirstUpdate) {
                    stringBuilder.Append(",");
                } else {
                    bFirstUpdate = false;
                }
                stringBuilder.Append("%1$s\n", param.getParamName());
            }
            ++i;
        }
        if (this.dbCallerConfig.getLogDBOperator()) {
            if (!bFirstUpdate) {
                stringBuilder.Append(",");
            } else {
                bFirstUpdate = false;
            }
            stringBuilder.Append("CreateMan\n");
            stringBuilder.Append(",CreateDate\n");
            stringBuilder.Append(",UpdateMan\n");
            stringBuilder.Append(",UpdateDate\n");
        }
        stringBuilder.Append(")\n");
        stringBuilder.Append("VALUES\n(\n");
        bFirstUpdate = true;
        nCount = this.dbCallerConfig.getParams().size();
        i = 0;
        while (i < nCount) {
            param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if ((StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"DB2", (boolean)true) == 0) && param.getUpdate()) {
                if (!bFirstUpdate) {
                    stringBuilder.Append(",");
                } else {
                    bFirstUpdate = false;
                }
                String strRawValueFormat = param.getRawValueFormat();
                if (StringHelper.IsNullOrEmpty((String)strRawValueFormat)) {
                    strRawValueFormat = "var%1$s";
                }
                stringBuilder.Append(strRawValueFormat, param.getID());
                stringBuilder.Append("\n");
            }
            ++i;
        }
        if (this.dbCallerConfig.getLogDBOperator()) {
            if (!bFirstUpdate) {
                stringBuilder.Append(",");
            } else {
                bFirstUpdate = false;
            }
            stringBuilder.Append("varOPPersonId\n");
            stringBuilder.Append(",sysdate\n");
            stringBuilder.Append(",varOPPersonId\n");
            stringBuilder.Append(",sysdate\n");
        }
        stringBuilder.Append(");\n");
        String strKeyCondition = this.GetKeyCondSql(false);
        if (StringHelper.Length((String)strKeyCondition) == 0) {
            dbResult.setErrorInfo("\u5fc5\u987b\u58f0\u660e\u67e5\u8be2\u7684\u952e\u503c\u6761\u4ef6");
            return dbResult;
        }
        if (StringHelper.Length((String)strCondition) > 0) {
            if (StringHelper.Length((String)strKeyCondition) > 0) {
                strKeyCondition = String.valueOf(strKeyCondition) + " AND ";
            }
            strKeyCondition = String.valueOf(strKeyCondition) + strCondition;
        }
        if (StringHelper.Length((String)(strExtCondition = this.dbCallerConfig.FindCustomAction("DB2", "CONDITION"))) > 0) {
            if (StringHelper.Length((String)strKeyCondition) > 0) {
                strKeyCondition = String.valueOf(strKeyCondition) + " AND ";
            }
            strKeyCondition = String.valueOf(strKeyCondition) + strExtCondition;
        }
        if (StringHelper.Length((String)this.dbCallerConfig.getUserReturn()) > 0) {
            stringBuilder.Append("open varRd for select %2$s,* from %1$s ", this.dbCallerConfig.getViewName(), this.dbCallerConfig.getUserReturn());
        } else {
            stringBuilder.Append("open varRd for select * from %1$s ", this.dbCallerConfig.getViewName());
        }
        stringBuilder.Append(" where %1$s;\n", strKeyCondition);
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("DB2", "AFTER"));
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("DB2", "END"));
        stringBuilder.Append("\n<<%1$s>>\n", "SRF_RT");
        if (StringHelper.Length((String)this.dbCallerConfig.getSystemReturn()) > 0) {
            stringBuilder.Append("open varRdSystem for select nRetCode as RETCODE,strErrorInfo as MESSAGE, strSRFTag as USERTAG ,strSRFTag2 as USERTAG2,%1$s from dual;\n", this.dbCallerConfig.getSystemReturn());
        } else {
            stringBuilder.Append("open varRdSystem for select nRetCode as RETCODE,strErrorInfo as MESSAGE, strSRFTag as USERTAG ,strSRFTag2 as USERTAG2 from dual;\n");
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
            dbResult = this.GenInsertProc(SqlConn);
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

