/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DBUserError
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx.SqlServer;

import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.IDBSelectCmdCaller;
import SA.SRFramework.DataEx.SqlServer.SqlDBProcCallerEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Hashtable;

public class SqlSelectCmdCaller
extends SqlDBProcCallerEx
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
        SelectResult selectResult;
        block22: {
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
            stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "BEFORE"));
            if (StringHelper.Length((String)this.dbCallerConfig.getUserReturn()) > 0) {
                stringBuilder.Append("select %3$s,* from %1$s where %2$s\r\n", this.dbCallerConfig.getViewName(), strCondition, this.dbCallerConfig.getUserReturn());
            } else {
                stringBuilder.Append("select * from %1$s where %2$s\r\n", this.dbCallerConfig.getViewName(), strCondition);
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
            selectResult = new SelectResult();
            selectResult.setRetCode(1);
            selectResult.setDatabase(2);
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
                            cstmt.setObject(nParamIndex, objTemp, SqlSelectCmdCaller.GetJDBCType((int)param.getDBType()));
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
                    if (dataSet.getTableCount() <= 0 || (dt = dataSet.getTable(dataSet.getTableCount() - 1)).GetRowCount() != 1) break block22;
                    DataRow dr = dt.GetRow(0);
                    Integer nRetCode = Integer.parseInt(dr.Get("RETCODE").toString());
                    selectResult.setRetCode(nRetCode.intValue());
                    selectResult.setSelectData(dataSet);
                    selectResult.setDataTableIndex(0);
                    if (nRetCode == 0) break block22;
                    String strError = dr.Get("MESSAGE").toString();
                    if (StringHelper.Length((String)strError) == 0) {
                        DBUserError dbUserError = this.dbCallerConfig.GetUserError(nRetCode.toString());
                        if (dbUserError != null) {
                            selectResult.setErrorInfo(dbUserError.getMessage());
                        } else {
                            nRetCode.intValue();
                            selectResult.setErrorInfo("\u4e0d\u660e\u7684\u9519\u8bef");
                        }
                        break block22;
                    }
                    selectResult.setErrorInfo(strError);
                }
                catch (Exception ex) {
                    this.LogErrorInfo(ex.toString());
                    selectResult.setErrorInfo(ex.toString());
                    ex.printStackTrace(System.out);
                    cstmt.close();
                }
            }
            finally {
                cstmt.close();
            }
        }
        return selectResult;
    }

    @Override
    public DBResult CreateProc() throws SQLException {
        return null;
    }
}

