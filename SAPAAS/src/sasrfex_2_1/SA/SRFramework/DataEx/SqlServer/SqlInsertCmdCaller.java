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
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.InsertResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx.SqlServer;

import SA.SRFramework.Data.DBCallerCheck;
import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.DataEx.IDBInsertCmdCaller;
import SA.SRFramework.DataEx.SqlServer.SqlDBProcCallerEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

public class SqlInsertCmdCaller
extends SqlDBProcCallerEx
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
        InsertResult insertResult;
        block64: {
            String strParamValue;
            DBCallerParam param;
            ArrayList checks;
            String strExtCondition;
            StringBuilderEx stringBuilder = new StringBuilderEx();
            this.AppendSystemParam(stringBuilder);
            stringBuilder.Append("\r\n");
            this.AppendCommonParam(stringBuilder);
            stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "PREPARE"));
            stringBuilder.Append("set @srf_retcode = 0 \r\n");
            stringBuilder.Append("set @srf_opman = '%1$s' \r\n", strOpPersonId);
            this.AppendInsertParamValue(stringBuilder);
            String strkeyCondition = this.GetInsertKeyCondition();
            String strCondition = "";
            if (this.dbCallerConfig.getLogicEnable()) {
                if (StringHelper.Length((String)strCondition) != 0) {
                    strCondition = String.valueOf(strCondition) + " AND ";
                }
                strCondition = String.valueOf(strCondition) + "([enable] = 1)";
            }
            if (StringHelper.Length((String)(strExtCondition = this.dbCallerConfig.FindCustomAction("MSSQL", "CONDITION"))) > 0) {
                if (StringHelper.Length((String)strCondition) != 0) {
                    strCondition = String.valueOf(strCondition) + " AND ";
                }
                strCondition = String.valueOf(strCondition) + strExtCondition;
            }
            if (this.dbCallerConfig.getCheckExist() && StringHelper.Length((String)strkeyCondition) > 0) {
                stringBuilder.Append("if exists (select * from %1$s where %2$s )\r\n", this.dbCallerConfig.getProcName(), strkeyCondition);
                stringBuilder.Append("begin\r\n");
                stringBuilder.Append("\tset @srf_retcode= %1$s\r\n", 3);
                stringBuilder.Append("\tGOTO %1$s\r\n", "SRF_RT");
                stringBuilder.Append("end\r\n");
                stringBuilder.Append("\r\n");
            }
            if ((checks = this.dbCallerConfig.getChecks()) != null) {
                int nCount = checks.size();
                int i = 0;
                while (i < nCount) {
                    String strParams;
                    DBCallerCheck check = (DBCallerCheck)checks.get(i);
                    if ((StringHelper.Length((String)check.getDatabase()) == 0 || StringHelper.Compare((String)check.getDatabase(), (String)"MSSQL", (boolean)true) == 0) && StringHelper.Length((String)(strParams = check.getParams())) != 0) {
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
                            strCheckFields = String.valueOf(strCheckFields) + StringHelper.Format((String)"[%1$s] = @%1$s", (Object)strParam);
                            if (StringHelper.Length((String)strCheckParams) > 0) {
                                strCheckParams = String.valueOf(strCheckParams) + " AND ";
                            }
                            strCheckParams = String.valueOf(strCheckParams) + StringHelper.Format((String)"@%1$s IS NOT NULL", (Object)strParam);
                            ++j;
                        }
                        stringBuilder.Append("if %1$s\r\n", strCheckParams);
                        String strCheckCondition = check.getCondition();
                        if (StringHelper.Length((String)strCondition) > 0) {
                            if (StringHelper.Length((String)strCheckCondition) > 0) {
                                stringBuilder.Append("if exists (select * from %1$s where (%3$s) AND %4$s AND  ( %2$s ) )\r\n", this.dbCallerConfig.getProcName(), strCondition, strCheckFields, strCheckCondition);
                            } else {
                                stringBuilder.Append("if exists (select * from %1$s where (%3$s) AND  ( %2$s ) )\r\n", this.dbCallerConfig.getProcName(), strCondition, strCheckFields);
                            }
                        } else if (StringHelper.Length((String)strCheckCondition) > 0) {
                            stringBuilder.Append("if exists (select * from %1$s where (%2$s) AND %3$s  )\r\n", this.dbCallerConfig.getProcName(), strCheckFields, strCheckCondition);
                        } else {
                            stringBuilder.Append("if exists (select * from %1$s where (%2$s)  )\r\n", this.dbCallerConfig.getProcName(), strCheckFields);
                        }
                        stringBuilder.Append("begin\r\n");
                        stringBuilder.Append("\tset @srf_retcode= %1$s\r\n", check.getRetCode());
                        if (StringHelper.Length((String)check.getMessage()) > 0) {
                            stringBuilder.Append("\tset @srf_message= '%1$s'\r\n", check.getMessage());
                        }
                        stringBuilder.Append("\tset @srf_tag= '%1$s'\r\n", check.getFormItems());
                        stringBuilder.Append("\tGOTO %1$s\r\n", "SRF_RT");
                        stringBuilder.Append("end\r\n");
                    }
                    ++i;
                }
            }
            stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "BEFORE"));
            stringBuilder.Append("INSERT INTO %1$s (\r\n", this.dbCallerConfig.getProcName());
            boolean bFirstUpdate = true;
            int nCount = this.dbCallerConfig.getParams().size();
            int i = 0;
            while (i < nCount) {
                block65: {
                    block66: {
                        param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
                        if (StringHelper.Length((String)param.getDatabase()) != 0 && StringHelper.Compare((String)param.getDatabase(), (String)"MSSQL", (boolean)true) != 0 || !param.getUpdate() || param.getKey() && StringHelper.Compare((String)param.getValueMode(), (String)"IDENTITY", (boolean)true) == 0) break block65;
                        if (param.getRawValue()) break block66;
                        strParamValue = param.getParamValue().toUpperCase();
                        if (!paramList.containsKey(strParamValue = strParamValue.toUpperCase())) break block65;
                    }
                    if (!bFirstUpdate) {
                        stringBuilder.Append(",");
                    } else {
                        bFirstUpdate = false;
                    }
                    stringBuilder.Append("[%1$s]\r\n", param.getID());
                }
                ++i;
            }
            if (this.dbCallerConfig.getLogDBOperator()) {
                if (!bFirstUpdate) {
                    stringBuilder.Append(",");
                } else {
                    bFirstUpdate = false;
                }
                stringBuilder.Append("[CreateMan]\r\n");
                stringBuilder.Append(",[CreateDate]\r\n");
                stringBuilder.Append(",[UpdateMan]\r\n");
                stringBuilder.Append(",[UpdateDate]\r\n");
            }
            stringBuilder.Append(")\r\n");
            stringBuilder.Append("VALUES(\r\n");
            bFirstUpdate = true;
            nCount = this.dbCallerConfig.getParams().size();
            i = 0;
            while (i < nCount) {
                block67: {
                    block68: {
                        param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
                        if (StringHelper.Length((String)param.getDatabase()) != 0 && StringHelper.Compare((String)param.getDatabase(), (String)"MSSQL", (boolean)true) != 0 || !param.getUpdate() || param.getKey() && StringHelper.Compare((String)param.getValueMode(), (String)"IDENTITY", (boolean)true) == 0) break block67;
                        if (param.getRawValue()) break block68;
                        strParamValue = param.getParamValue().toUpperCase();
                        if (!paramList.containsKey(strParamValue = strParamValue.toUpperCase())) break block67;
                    }
                    if (!bFirstUpdate) {
                        stringBuilder.Append(",");
                    } else {
                        bFirstUpdate = false;
                    }
                    if (param.getDeclareParam()) {
                        stringBuilder.Append("@%1$s\r\n", param.getID());
                    } else {
                        stringBuilder.Append("? \r\n", param.getID());
                    }
                }
                ++i;
            }
            if (this.dbCallerConfig.getLogDBOperator()) {
                if (!bFirstUpdate) {
                    stringBuilder.Append(",");
                } else {
                    bFirstUpdate = false;
                }
                stringBuilder.Append("@srf_opman\r\n");
                stringBuilder.Append(",getdate()\r\n");
                stringBuilder.Append(",@srf_opman\r\n");
                stringBuilder.Append(",getdate()\r\n");
            }
            stringBuilder.Append(")\r\n");
            this.AppendGetKeyCode(stringBuilder);
            stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "AFTER"));
            strCondition = this.GetUpdateKeyCondition();
            if (StringHelper.Length((String)this.dbCallerConfig.getUserReturn()) > 0) {
                stringBuilder.Append("select %3$s,* from %1$s where %2$s\r\n", this.dbCallerConfig.getViewName(), strCondition, this.dbCallerConfig.getUserReturn());
            } else {
                stringBuilder.Append("select * from %1$s where %2$s\r\n", this.dbCallerConfig.getViewName(), strCondition);
            }
            stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "END"));
            stringBuilder.Append("%1$s:\r\n", "SRF_RT");
            if (StringHelper.Length((String)this.dbCallerConfig.getSystemReturn()) > 0) {
                stringBuilder.Append("select @srf_retcode as RETCODE,@srf_message as MESSAGE,@srf_tag as USERTAG,@srf_tag2 AS USERTAG2,%1$s\r\n", this.dbCallerConfig.getSystemReturn());
            } else {
                stringBuilder.Append("select @srf_retcode as RETCODE,@srf_message as MESSAGE,@srf_tag as USERTAG,@srf_tag2 AS USERTAG2\r\n");
            }
            if (this.dbCallerConfig.getDebug()) {
                System.out.print(stringBuilder.toString());
            }
            insertResult = new InsertResult();
            insertResult.setRetCode(1);
            insertResult.setDatabase(2);
            Statement cstmt = null;
            try {
                try {
                    DataTable dt;
                    Object objTemp;
                    String strParamValue2;
                    DBCallerParam param2;
                    cstmt = connection.prepareStatement(stringBuilder.toString());
                    int nParamIndex = 1;
                    int nCount2 = this.dbCallerConfig.getParams().size();
                    int i2 = 0;
                    while (i2 < nCount2) {
                        param2 = (DBCallerParam)this.dbCallerConfig.getParams().get(i2);
                        if (!(!param2.getDeclareParam() || StringHelper.Length((String)param2.getDatabase()) != 0 && StringHelper.Compare((String)param2.getDatabase(), (String)"MSSQL", (boolean)true) != 0 || param2.getKey() && StringHelper.Compare((String)param2.getValueMode(), (String)"IDENTITY", (boolean)true) == 0 || param2.getRawValue())) {
                            strParamValue2 = param2.getParamValue().toUpperCase();
                            objTemp = paramList.get(strParamValue2);
                            if (objTemp != null && objTemp instanceof String && objTemp.toString().length() == 0) {
                                objTemp = null;
                            }
                            cstmt.setObject(nParamIndex, objTemp, SqlInsertCmdCaller.GetJDBCType((int)param2.getDBType()));
                            ++nParamIndex;
                        }
                        ++i2;
                    }
                    i2 = 0;
                    while (i2 < nCount2) {
                        param2 = (DBCallerParam)this.dbCallerConfig.getParams().get(i2);
                        if (!param2.getDeclareParam() && param2.getUpdate()) {
                            strParamValue2 = param2.getParamValue().toUpperCase();
                            if (paramList.containsKey(strParamValue2 = strParamValue2.toUpperCase())) {
                                objTemp = paramList.get(strParamValue2);
                                if (objTemp != null && objTemp instanceof String && objTemp.toString().length() == 0) {
                                    objTemp = null;
                                }
                                cstmt.setObject(nParamIndex, objTemp, SqlInsertCmdCaller.GetJDBCType((int)param2.getDBType()));
                                ++nParamIndex;
                            }
                        }
                        ++i2;
                    }
                    cstmt.execute();
                    DataSet dataSet = new DataSet();
                    while (true) {
                        int updateCount;
                        if ((updateCount = cstmt.getUpdateCount()) < 0) {
                            ResultSet rs = cstmt.getResultSet();
                            if (rs == null) break;
                            dataSet.AddResultSet(rs);
                            rs.close();
                        }
                        cstmt.getMoreResults();
                    }
                    if (dataSet.getTableCount() <= 0 || (dt = dataSet.getTable(dataSet.getTableCount() - 1)).GetRowCount() != 1) break block64;
                    DataRow dr = dt.GetRow(0);
                    Integer nRetCode = Integer.parseInt(dr.Get("RETCODE").toString());
                    insertResult.setRetCode(nRetCode.intValue());
                    insertResult.setInsertData(dataSet);
                    insertResult.setDataTableIndex(0);
                    if (!dr.IsDBNull("USERTAG")) {
                        insertResult.getOutValues().put("USERTAG", dr.Get("USERTAG"));
                    }
                    if (!dr.IsDBNull("USERTAG2")) {
                        insertResult.getOutValues().put("USERTAG2", dr.Get("USERTAG2"));
                    }
                    if (nRetCode == 0) break block64;
                    String strError = dr.Get("MESSAGE").toString();
                    if (StringHelper.Length((String)strError) == 0) {
                        DBUserError dbUserError = this.dbCallerConfig.GetUserError(nRetCode.toString());
                        if (dbUserError != null) {
                            insertResult.setErrorInfo(dbUserError.getMessage());
                        } else {
                            nRetCode.intValue();
                            insertResult.setErrorInfo("\u4e0d\u660e\u7684\u9519\u8bef");
                        }
                        break block64;
                    }
                    insertResult.setErrorInfo(strError);
                }
                catch (Exception ex) {
                    this.LogErrorInfo(ex.toString());
                    insertResult.setErrorInfo(ex.toString());
                    ex.printStackTrace(System.out);
                    cstmt.close();
                }
            }
            finally {
                cstmt.close();
            }
        }
        return insertResult;
    }

    @Override
    public DBResult CreateProc() throws SQLException {
        return null;
    }
}

