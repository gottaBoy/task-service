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
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.Oracle.OracleDataSet
 *  SA.SRFramework.Data.UpdateResult
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
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.Oracle.OracleDataSet;
import SA.SRFramework.Data.UpdateResult;
import SA.SRFramework.DataEx.DB2.DB2DBProcCallerEx;
import SA.SRFramework.DataEx.IDBUpdateCmdCaller;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class DB2UpdateCmdCaller
extends DB2DBProcCallerEx
implements IDBUpdateCmdCaller {
    @Override
    public UpdateResult Invoke(Hashtable paramList, String strOpPersonId) throws SQLException {
        UpdateResult updateResult = null;
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            updateResult = new UpdateResult();
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            updateResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return updateResult;
        }
        try {
            try {
                updateResult = this.Invoke(SqlConn, paramList, strOpPersonId);
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                this.ReleaseConnection(SqlConn);
            }
        }
        finally {
            this.ReleaseConnection(SqlConn);
        }
        return updateResult;
    }

    @Override
    public UpdateResult Invoke(Connection connection, Hashtable paramList, String strOpPersonId) throws SQLException {
        UpdateResult updateResult = new UpdateResult();
        updateResult.setRetCode(1);
        updateResult.setDatabase(1);
        if (this.dbCallerConfig.getAutoGenProc() && !this.dbCallerConfig.getGenProcFinish()) {
            DBResult dbResult = this.GenUpdateProc(connection);
            if (dbResult == null) {
                return updateResult;
            }
            if (dbResult.getRetCode() != 0) {
                updateResult.setRetCode(dbResult.getRetCode());
                updateResult.setErrorInfo(dbResult.getErrorInfo());
                return updateResult;
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
                        updateResult.setErrorInfo(objMessage.toString());
                    }
                    if (!dr.IsDBNull("USERTAG")) {
                        updateResult.getOutValues().put("USERTAG", dr.Get("USERTAG"));
                    }
                    if (!dr.IsDBNull("USERTAG2")) {
                        updateResult.getOutValues().put("USERTAG2", dr.Get("USERTAG2"));
                    }
                }
                if (nRetCode == 0) {
                    ResultSet rs = (ResultSet)cstmt.getObject(nParamReturnRS);
                    dataSet.InsertResultSet(0, rs);
                    rs.close();
                }
                updateResult.setRetCode(nRetCode.intValue());
                updateResult.setInsertData((DataSet)dataSet);
                updateResult.setDataTableIndex(0);
                if (nRetCode != 0) {
                    DBUserError dbUserError = this.dbCallerConfig.GetUserError(nRetCode.toString());
                    if (dbUserError != null) {
                        updateResult.setErrorInfo(dbUserError.getMessage());
                    } else if (StringHelper.IsNullOrEmpty((String)updateResult.getErrorInfo()) && !Errors.IsUserError(nRetCode)) {
                        updateResult.setErrorInfo(Errors.GetErrorInfo(nRetCode));
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
                updateResult.setErrorInfo(ex.toString());
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
        return updateResult;
    }

    protected DBResult GenUpdateProc(Connection connection) {
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
        stringBuilder.Append("varRdSystem out PKG_SRF2.recordset, --\u7cfb\u7edf\u6267\u884c\u7ed3\u679c\n");
        if (this.AppendProcParam(stringBuilder, true, true)) {
            stringBuilder.Append(",\n");
        }
        stringBuilder.Append("varOPPersonId VARCHAR2\n");
        stringBuilder.Append(")\n");
        stringBuilder.Append("IS\n");
        stringBuilder.Append("strSql VARCHAR2(4000):='';\n");
        stringBuilder.Append("strUpdateSql VARCHAR2(4000):='';\n");
        stringBuilder.Append("strConSql VARCHAR2(4000):='';\n");
        stringBuilder.Append("nRetCode int:=0;\n");
        stringBuilder.Append("strErrorInfo VARCHAR2(2000):='';\n");
        stringBuilder.Append("strSRFTag VARCHAR2(4000):='';\n");
        stringBuilder.Append("strSRFTag2 VARCHAR2(4000):='';\n");
        stringBuilder.Append("nTemp int:=0;\n");
        this.AppendDeclareParam(stringBuilder);
        stringBuilder.Append("BEGIN\n");
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("DB2", "PREPARE"));
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
                            stringBuilder.Append("select count(*) INTO nTemp from %1$s where (%3$s) AND %4$s AND NOT ( %2$s );\n", this.dbCallerConfig.getProcName(), strCondition, strCheckFields, strCheckCondition);
                        } else {
                            stringBuilder.Append("select count(*) INTO nTemp from %1$s where (%3$s) AND NOT ( %2$s );\n", this.dbCallerConfig.getProcName(), strCondition, strCheckFields);
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
        stringBuilder.Append("strSql := 'UPDATE  %1$s SET ';\n", this.dbCallerConfig.getProcName());
        stringBuilder.Append("strUpdateSql:= '';\n");
        boolean bFirstUpdate = true;
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (!(StringHelper.Length((String)param.getDatabase()) != 0 && StringHelper.Compare((String)param.getDatabase(), (String)"DB2", (boolean)true) != 0 || !param.getUpdate() || param.getKey() || DataTypeHelper.IsLongStringType((int)param.getDBType()))) {
                stringBuilder.Append("if var%1$sVF = 1 THEN\n", param.getID());
                stringBuilder.Append("if  strUpdateSql IS NOT NULL OR strUpdateSql <> ''  THEN\n");
                stringBuilder.Append("\t\tstrUpdateSql := strUpdateSql || ' , ';\n");
                stringBuilder.Append("\tEND IF;\n");
                stringBuilder.Append("\tif var%1$s  IS NULL THEN\n", param.getID());
                stringBuilder.Append("\t\tstrUpdateSql := strUpdateSql || ' %1$s = NULL';\n", param.getParamName());
                stringBuilder.Append("\tELSE\n");
                if (DataTypeHelper.IsStringType((int)param.getDBType())) {
                    stringBuilder.Append("if  var%1$s IS NULL OR  LENGTH(var%1$s)<500 THEN\n", param.getID());
                    stringBuilder.Append("\t\tstrUpdateSql := strUpdateSql || '%1$s = '''|| REPLACE( var%2$s,'''','''''') ||'''';\n", param.getParamName(), param.getID());
                    stringBuilder.Append("ELSE\n");
                    stringBuilder.Append("\t\tstrUpdateSql := strUpdateSql || '%1$s = %1$s';\n", param.getParamName(), param.getID());
                    stringBuilder.Append("END IF;\n");
                } else {
                    String strCastParam;
                    String strCastFunc = param.getCastFunc();
                    if (DataTypeHelper.IsDateTimeType((int)param.getDBType())) {
                        if (StringHelper.Length((String)strCastFunc) == 0) {
                            strCastFunc = "fn_FormatDate(var%1$s)";
                        }
                        strCastParam = StringHelper.Format((String)strCastFunc, (Object)param.getID());
                        stringBuilder.Append("\t\tstrUpdateSql := strUpdateSql || ' %1$s = '|| %2$s ;\n", param.getParamName(), strCastParam);
                    } else {
                        if (StringHelper.Length((String)strCastFunc) == 0) {
                            strCastFunc = "to_char(var%1$s)";
                        }
                        strCastParam = StringHelper.Format((String)strCastFunc, (Object)param.getID());
                        stringBuilder.Append("\t\tstrUpdateSql := strUpdateSql || ' %1$s = '|| %2$s ;\n", param.getParamName(), strCastParam);
                    }
                }
                stringBuilder.Append("\tEND IF;\n");
                stringBuilder.Append("END IF;\n");
            }
            ++i;
        }
        if (this.dbCallerConfig.getLogDBOperator()) {
            stringBuilder.Append("if  strUpdateSql IS NOT NULL OR strUpdateSql <> ''  THEN\n");
            stringBuilder.Append("\t\tstrUpdateSql := strUpdateSql || ' , ';\n");
            stringBuilder.Append("\tEND IF;\n");
            stringBuilder.Append("\tstrUpdateSql := strUpdateSql || ' UpdateMan='''|| varOPPersonId || ''', UpdateDate=sysdate  ';\n");
        }
        stringBuilder.Append("strConSql:='';\n");
        this.AppendKeyCondSql(stringBuilder, "strConSql", false);
        stringBuilder.Append("strSql:=strSql || strUpdateSql || strConSql;\n");
        stringBuilder.Append("execute immediate strSql;\n");
        i = 0;
        while (i < nCount) {
            param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if ((StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"DB2", (boolean)true) == 0) && param.getUpdate() && !param.getKey()) {
                if (DataTypeHelper.IsLongStringType((int)param.getDBType())) {
                    stringBuilder.Append("if var%1$sVF = 1 THEN\n", param.getID());
                    stringBuilder.Append("\tif var%1$s  IS NULL THEN\n", param.getID());
                    stringBuilder.Append("\t\t update %1$s set %2$s = NULL where %3$s;\n", this.dbCallerConfig.getProcName(), param.getParamName(), this.GetRawKeyCond(false));
                    stringBuilder.Append("\tELSE\n");
                    stringBuilder.Append("\t\t update %1$s set %2$s = var%4$s where %3$s;\n", this.dbCallerConfig.getProcName(), param.getParamName(), this.GetRawKeyCond(false), param.getID());
                    stringBuilder.Append("\tEND IF;\n");
                    stringBuilder.Append("END IF;\n");
                } else if (DataTypeHelper.IsStringType((int)param.getDBType())) {
                    stringBuilder.Append("if var%1$sVF = 1 THEN\n", param.getID());
                    stringBuilder.Append("if  var%1$s IS NOT NULL AND LENGTH(var%1$s)>=500 THEN\n", param.getID());
                    stringBuilder.Append("\t\t update %1$s set %2$s = var%4$s where %3$s;\n", this.dbCallerConfig.getProcName(), param.getParamName(), this.GetRawKeyCond(false), param.getID());
                    stringBuilder.Append("END IF;\n");
                    stringBuilder.Append("END IF;\n");
                }
            }
            ++i;
        }
        String strExtCondition = this.dbCallerConfig.FindCustomAction("DB2", "CONDITION");
        if (StringHelper.Length((String)strExtCondition) > 0) {
            if (StringHelper.Length((String)strCondition) > 0) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            strCondition = String.valueOf(strCondition) + strExtCondition;
        }
        if (StringHelper.Length((String)this.dbCallerConfig.getUserReturn()) > 0) {
            stringBuilder.Append("open varRd for  select %2$s,* from %1$s ", this.dbCallerConfig.getViewName(), this.dbCallerConfig.getUserReturn());
        } else {
            stringBuilder.Append("open varRd for select * from %1$s ", this.dbCallerConfig.getViewName());
        }
        stringBuilder.Append(" where %1$s;\n", strCondition);
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
            dbResult = this.GenUpdateProc(SqlConn);
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

