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
 *  SA.SRFramework.Data.UpdateResult
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
import SA.SRFramework.Data.UpdateResult;
import SA.SRFramework.DataEx.IDBUpdateCmdCaller;
import SA.SRFramework.DataEx.SqlServer.SqlDBProcCallerEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Hashtable;

public class SqlUpdateCmdCaller
extends SqlDBProcCallerEx
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
        UpdateResult updateResult;
        block53: {
            ArrayList checks;
            String strExtCondition;
            String strkeyCondition;
            StringBuilderEx stringBuilder = new StringBuilderEx();
            this.AppendSystemParam(stringBuilder);
            stringBuilder.Append("\r\n");
            this.AppendCommonParam(stringBuilder);
            stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "PREPARE"));
            stringBuilder.Append("set @srf_retcode = 0 \r\n");
            stringBuilder.Append("set @srf_opman = '%1$s' \r\n", strOpPersonId);
            this.AppendUpdateParamValue(stringBuilder);
            String strCondition = strkeyCondition = this.GetUpdateKeyCondition();
            String strCondition2 = strkeyCondition;
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
                if (StringHelper.Length((String)strCondition2) != 0) {
                    strCondition2 = String.valueOf(strCondition2) + " AND ";
                }
                strCondition2 = String.valueOf(strCondition2) + strExtCondition;
            }
            if (StringHelper.Length((String)strCondition) > 0 && this.dbCallerConfig.getCheckExist()) {
                stringBuilder.Append("if not exists (select * from %1$s where %2$s)\r\n", this.dbCallerConfig.getProcName(), strCondition);
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
                        if (this.dbCallerConfig.getLogicEnable()) {
                            if (StringHelper.Length((String)strCheckCondition) > 0) {
                                strCheckCondition = String.valueOf(strCheckCondition) + " AND ";
                            }
                            strCheckCondition = String.valueOf(strCheckCondition) + "[enable] = 1";
                        }
                        if (StringHelper.Length((String)strCheckCondition) > 0) {
                            stringBuilder.Append("if exists (select * from %1$s where (%3$s) AND %4$s AND NOT ( %2$s ) )\r\n", this.dbCallerConfig.getProcName(), strCondition2, strCheckFields, strCheckCondition);
                        } else {
                            stringBuilder.Append("if exists (select * from %1$s where (%3$s) AND NOT ( %2$s ) )\r\n", this.dbCallerConfig.getProcName(), strCondition2, strCheckFields);
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
            stringBuilder.Append("update %1$s set \r\n", this.dbCallerConfig.getProcName());
            boolean bFirstUpdate = true;
            int nCount = this.dbCallerConfig.getParams().size();
            int i = 0;
            while (i < nCount) {
                block54: {
                    DBCallerParam param;
                    block55: {
                        param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
                        if (StringHelper.Length((String)param.getDatabase()) != 0 && StringHelper.Compare((String)param.getDatabase(), (String)"MSSQL", (boolean)true) != 0 || !param.getUpdate()) break block54;
                        if (param.getRawValue()) break block55;
                        String strParamValue = param.getParamValue().toUpperCase();
                        if (!paramList.containsKey(strParamValue = strParamValue.toUpperCase())) break block54;
                    }
                    if (!bFirstUpdate) {
                        stringBuilder.Append(",");
                    } else {
                        bFirstUpdate = false;
                    }
                    if (param.getDeclareParam()) {
                        stringBuilder.Append("[%1$s] = @%1$s \r\n", param.getID());
                    } else {
                        stringBuilder.Append("[%1$s] = ? \r\n", param.getID());
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
                stringBuilder.Append("[UpdateMan] = @srf_opman \r\n");
                stringBuilder.Append(",[UpdateDate] = getdate() \r\n");
            }
            stringBuilder.Append("where %1$s\r\n", strCondition);
            stringBuilder.Append("\r\n");
            stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "AFTER"));
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
            updateResult = new UpdateResult();
            updateResult.setRetCode(1);
            updateResult.setDatabase(2);
            PreparedStatement cstmt = null;
            try {
                try {
                    DataTable dt;
                    Object objTemp;
                    String strParamValue;
                    DBCallerParam param;
                    cstmt = connection.prepareStatement(stringBuilder.toString());
                    int nParamIndex = 1;
                    nCount = this.dbCallerConfig.getParams().size();
                    int i2 = 0;
                    while (i2 < nCount) {
                        param = (DBCallerParam)this.dbCallerConfig.getParams().get(i2);
                        if (param.getDeclareParam() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"MSSQL", (boolean)true) == 0) && !param.getRawValue()) {
                            strParamValue = param.getParamValue().toUpperCase();
                            objTemp = paramList.get(strParamValue);
                            if (objTemp != null && objTemp instanceof String && objTemp.toString().length() == 0) {
                                objTemp = null;
                            }
                            cstmt.setObject(nParamIndex, objTemp, SqlUpdateCmdCaller.GetJDBCType((int)param.getDBType()));
                            ++nParamIndex;
                        }
                        ++i2;
                    }
                    i2 = 0;
                    while (i2 < nCount) {
                        param = (DBCallerParam)this.dbCallerConfig.getParams().get(i2);
                        if (!param.getDeclareParam() && param.getUpdate()) {
                            strParamValue = param.getParamValue().toUpperCase();
                            if (paramList.containsKey(strParamValue = strParamValue.toUpperCase())) {
                                objTemp = paramList.get(strParamValue);
                                if (objTemp != null && objTemp instanceof String && objTemp.toString().length() == 0) {
                                    objTemp = null;
                                }
                                cstmt.setObject(nParamIndex, objTemp, SqlUpdateCmdCaller.GetJDBCType((int)param.getDBType()));
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
                    if (dataSet.getTableCount() <= 0 || (dt = dataSet.getTable(dataSet.getTableCount() - 1)).GetRowCount() != 1) break block53;
                    DataRow dr = dt.GetRow(0);
                    Integer nRetCode = Integer.parseInt(dr.Get("RETCODE").toString());
                    updateResult.setRetCode(nRetCode.intValue());
                    updateResult.setUpdateData(dataSet);
                    updateResult.setDataTableIndex(0);
                    if (!dr.IsDBNull("USERTAG")) {
                        updateResult.getOutValues().put("USERTAG", dr.Get("USERTAG"));
                    }
                    if (!dr.IsDBNull("USERTAG2")) {
                        updateResult.getOutValues().put("USERTAG2", dr.Get("USERTAG2"));
                    }
                    if (nRetCode == 0) break block53;
                    String strError = dr.Get("MESSAGE").toString();
                    if (StringHelper.Length((String)strError) == 0) {
                        DBUserError dbUserError = this.dbCallerConfig.GetUserError(nRetCode.toString());
                        if (dbUserError != null) {
                            updateResult.setErrorInfo(dbUserError.getMessage());
                        } else {
                            nRetCode.intValue();
                            updateResult.setErrorInfo("\u4e0d\u660e\u7684\u9519\u8bef");
                        }
                        break block53;
                    }
                    updateResult.setErrorInfo(strError);
                }
                catch (Exception ex) {
                    this.LogErrorInfo(ex.toString());
                    updateResult.setErrorInfo(ex.toString());
                    ex.printStackTrace(System.out);
                    cstmt.close();
                }
            }
            finally {
                cstmt.close();
            }
        }
        return updateResult;
    }

    @Override
    public DBResult CreateProc() throws SQLException {
        return null;
    }
}

