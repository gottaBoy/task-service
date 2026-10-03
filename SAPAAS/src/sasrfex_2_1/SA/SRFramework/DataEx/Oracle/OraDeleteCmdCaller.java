/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerCheck
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DBUserError
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.Oracle.OracleDataSet
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx.Oracle;

import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.Data.DBCallerCheck;
import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.Oracle.OracleDataSet;
import SA.SRFramework.DataEx.IDBDeleteCmdCaller;
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

public class OraDeleteCmdCaller
extends OraDBProcCallerEx
implements IDBDeleteCmdCaller {
    @Override
    public DBResult Invoke(Hashtable paramList, String strOpPersonId) throws SQLException {
        DBResult deleteResult = null;
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            deleteResult = new DBResult();
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            deleteResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return deleteResult;
        }
        try {
            try {
                deleteResult = this.Invoke(SqlConn, paramList, strOpPersonId);
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                this.ReleaseConnection(SqlConn);
            }
        }
        finally {
            this.ReleaseConnection(SqlConn);
        }
        return deleteResult;
    }

    @Override
    public DBResult Invoke(Connection connection, Hashtable paramList, String strOpPersonId) throws SQLException {
        DBResult deleteResult = new DBResult();
        deleteResult.setRetCode(1);
        deleteResult.setDatabase(1);
        if (this.dbCallerConfig.getAutoGenProc() && !this.dbCallerConfig.getGenProcFinish()) {
            DBResult dbResult = this.GenDeleteProc(connection);
            if (dbResult == null) {
                return deleteResult;
            }
            if (dbResult.getRetCode() != 0) {
                deleteResult.setRetCode(dbResult.getRetCode());
                deleteResult.setErrorInfo(dbResult.getErrorInfo());
                return deleteResult;
            }
        }
        CallableStatement cstmt = null;
        Hashtable<Integer, String> outputParamList = new Hashtable<Integer, String>();
        try {
            try {
                ArrayList procParams = this.GetProcParams();
                int nParamCount = procParams.size();
                int nCallParamCount = nParamCount + 2;
                String strProc = this.FormatProcCall(this.dbCallerConfig.getGenProcName(), nCallParamCount);
                cstmt = connection.prepareCall(strProc);
                int nParamIndex = 1;
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
                        deleteResult.setErrorInfo(objMessage.toString());
                    }
                    if (!dr.IsDBNull("USERTAG")) {
                        deleteResult.getOutValues().put("USERTAG", dr.Get("USERTAG"));
                    }
                    if (!dr.IsDBNull("USERTAG2")) {
                        deleteResult.getOutValues().put("USERTAG2", dr.Get("USERTAG2"));
                    }
                }
                deleteResult.setRetCode(nRetCode.intValue());
                if (nRetCode != 0) {
                    DBUserError dbUserError = this.dbCallerConfig.GetUserError(nRetCode.toString());
                    if (dbUserError != null) {
                        deleteResult.setErrorInfo(dbUserError.getMessage());
                    } else if (StringHelper.IsNullOrEmpty((String)deleteResult.getErrorInfo()) && !Errors.IsUserError(nRetCode)) {
                        deleteResult.setErrorInfo(Errors.GetErrorInfo(nRetCode));
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
                deleteResult.setErrorInfo(ex.toString());
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
        return deleteResult;
    }

    protected DBResult GenDeleteProc(Connection connection) {
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
        stringBuilder.Append("varRdSystem out PKG_SRF2.recordset, --\u7cfb\u7edf\u6267\u884c\u7ed3\u679c\n");
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
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("ORACLE", "PREPARE"));
        String strCondition = this.GetKeyCondSql(true);
        if (this.dbCallerConfig.getLogicEnable()) {
            if (StringHelper.Length((String)strCondition) != 0) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            strCondition = String.valueOf(strCondition) + "(enable = 1)";
        }
        if (StringHelper.Length((String)strCondition) > 0 && this.dbCallerConfig.getCheckExist()) {
            stringBuilder.Append("select count(*) INTO nTemp from %1$s where %2$s ;\n", this.dbCallerConfig.getProcName(), strCondition);
            stringBuilder.Append("if nTemp = 0 then\n");
            stringBuilder.Append("\tnRetCode := %1$s;\n", 3);
            stringBuilder.Append("\tGOTO %1$s;\n", "SRF_RT");
            stringBuilder.Append("end if;\n");
            stringBuilder.Append("\n");
        }
        if ((checks = this.dbCallerConfig.getChecks()) != null) {
            int nCount = checks.size();
            int i = 0;
            while (i < nCount) {
                String strCustomCmd;
                DBCallerCheck check = (DBCallerCheck)checks.get(i);
                if ((StringHelper.Length((String)check.getDatabase()) == 0 || StringHelper.Compare((String)check.getDatabase(), (String)"ORACLE", (boolean)true) == 0) && StringHelper.Length((String)(strCustomCmd = check.getCustomCmd())) != 0) {
                    stringBuilder.Append("\t%1$s\n", strCustomCmd);
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
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("ORACLE", "BEFORE"));
        String strExtCondition = this.dbCallerConfig.FindCustomAction("ORACLE", "CONDITION");
        if (StringHelper.Length((String)strExtCondition) > 0) {
            if (StringHelper.Length((String)strCondition) > 0) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            strCondition = String.valueOf(strCondition) + strExtCondition;
        }
        if (this.dbCallerConfig.getLogicEnable()) {
            stringBuilder.Append("Update %1$s SET Enable = 0 ,UpdateMan = varOPPersonId,UpdateDate = sysdate ", this.dbCallerConfig.getProcName());
        } else {
            stringBuilder.Append("DELETE %1$s  ", this.dbCallerConfig.getProcName());
        }
        stringBuilder.Append(" where %1$s;\n", strCondition);
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("ORACLE", "AFTER"));
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("ORACLE", "END"));
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
        DBResult deleteResult = null;
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            deleteResult = new DBResult();
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            deleteResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return deleteResult;
        }
        try {
            deleteResult = this.GenDeleteProc(SqlConn);
            if (deleteResult == null) {
                DBResult dBResult = deleteResult;
                return dBResult;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            this.ReleaseConnection(SqlConn);
        }
        return deleteResult;
    }
}

