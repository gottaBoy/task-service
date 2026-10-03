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
import SA.SRFramework.DataEx.IDBDeleteCmdCaller;
import SA.SRFramework.DataEx.SqlServer.SqlDBProcCallerEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Hashtable;

public class SqlDeleteCmdCaller
extends SqlDBProcCallerEx
implements IDBDeleteCmdCaller {
    @Override
    public DBResult Invoke(Hashtable paramList, String strOpPersonId) throws SQLException {
        DBResult updateResult = null;
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            updateResult = new DBResult();
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
    public DBResult Invoke(Connection connection, Hashtable paramList, String strOpPersonId) throws SQLException {
        DBResult dbResult;
        block30: {
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
                    String strCustomCmd;
                    DBCallerCheck check = (DBCallerCheck)checks.get(i);
                    if ((StringHelper.Length((String)check.getDatabase()) == 0 || StringHelper.Compare((String)check.getDatabase(), (String)"MSSQL", (boolean)true) == 0) && StringHelper.Length((String)(strCustomCmd = check.getCustomCmd())) != 0) {
                        stringBuilder.Append("if exists (%1$s )\r\n", strCustomCmd);
                        stringBuilder.Append("begin\r\n");
                        stringBuilder.Append("\tset @srf_retcode= %1$s\r\n", check.getRetCode());
                        if (StringHelper.Length((String)check.getMessage()) > 0) {
                            stringBuilder.Append("\tset @srf_message= '%1$s'\r\n", check.getMessage());
                        }
                        stringBuilder.Append("\tGOTO %1$s\r\n", "SRF_RT");
                        stringBuilder.Append("end\r\n");
                    }
                    ++i;
                }
            }
            stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "BEFORE"));
            if (this.dbCallerConfig.getLogicEnable()) {
                stringBuilder.Append("update %1$s set \r\n", this.dbCallerConfig.getProcName());
                boolean bFirstUpdate = false;
                stringBuilder.Append("[enable] = 0 \r\n");
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
            } else {
                stringBuilder.Append("delete from  %1$s where %2$s\r\n", this.dbCallerConfig.getProcName(), strCondition);
                stringBuilder.Append("\r\n");
            }
            stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "AFTER"));
            stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "END"));
            stringBuilder.Append("%1$s:\r\n", "SRF_RT");
            if (StringHelper.Length((String)this.dbCallerConfig.getSystemReturn()) > 0) {
                stringBuilder.Append("select @srf_retcode as RETCODE,@srf_message as MESSAGE,%1$s\r\n", this.dbCallerConfig.getSystemReturn());
            } else {
                stringBuilder.Append("select @srf_retcode as RETCODE,@srf_message as MESSAGE\r\n");
            }
            if (this.dbCallerConfig.getDebug()) {
                System.out.print(stringBuilder.toString());
            }
            dbResult = new DBResult();
            dbResult.setRetCode(1);
            dbResult.setDatabase(2);
            PreparedStatement cstmt = null;
            try {
                try {
                    DataTable dt;
                    cstmt = connection.prepareStatement(stringBuilder.toString());
                    int nParamIndex = 1;
                    int nCount = this.dbCallerConfig.getParams().size();
                    int i = 0;
                    while (i < nCount) {
                        DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
                        if (param.getDeclareParam() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"MSSQL", (boolean)true) == 0) && !param.getRawValue()) {
                            String strParamValue = param.getParamValue().toUpperCase();
                            Object objTemp = paramList.get(strParamValue);
                            if (objTemp != null && objTemp instanceof String && objTemp.toString().length() == 0) {
                                objTemp = null;
                            }
                            cstmt.setObject(nParamIndex, objTemp, SqlDeleteCmdCaller.GetJDBCType((int)param.getDBType()));
                            ++nParamIndex;
                        }
                        ++i;
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
                    if (dataSet.getTableCount() <= 0 || (dt = dataSet.getTable(dataSet.getTableCount() - 1)).GetRowCount() != 1) break block30;
                    DataRow dr = dt.GetRow(0);
                    Integer nRetCode = Integer.parseInt(dr.Get("RETCODE").toString());
                    dbResult.setRetCode(nRetCode.intValue());
                    if (nRetCode == 0) break block30;
                    String strError = dr.Get("MESSAGE").toString();
                    if (StringHelper.Length((String)strError) == 0) {
                        DBUserError dbUserError = this.dbCallerConfig.GetUserError(nRetCode.toString());
                        if (dbUserError != null) {
                            dbResult.setErrorInfo(dbUserError.getMessage());
                        } else {
                            nRetCode.intValue();
                            dbResult.setErrorInfo("\u4e0d\u660e\u7684\u9519\u8bef");
                        }
                        break block30;
                    }
                    dbResult.setErrorInfo(strError);
                }
                catch (Exception ex) {
                    this.LogErrorInfo(ex.toString());
                    dbResult.setErrorInfo(ex.toString());
                    ex.printStackTrace(System.out);
                    cstmt.close();
                }
            }
            finally {
                cstmt.close();
            }
        }
        return dbResult;
    }

    @Override
    public DBResult CreateProc() throws SQLException {
        return null;
    }
}

