/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.SearchResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx.SqlServer;

import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.SearchResult;
import SA.SRFramework.DataEx.IDBSearchCmdCaller;
import SA.SRFramework.DataEx.SqlServer.SqlDBProcCallerEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Hashtable;

public class SqlSearchCmdCaller
extends SqlDBProcCallerEx
implements IDBSearchCmdCaller {
    @Override
    public SearchResult Invoke(int nCountPerPage, int nPageNO, String strSortParam, int nSortDirect, Hashtable paramList, String strOpPersonId) throws SQLException {
        SearchResult searchResult = null;
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            searchResult = new SearchResult();
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            searchResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return searchResult;
        }
        try {
            try {
                searchResult = this.Invoke(SqlConn, nCountPerPage, nPageNO, strSortParam, nSortDirect, paramList, strOpPersonId);
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                this.ReleaseConnection(SqlConn);
            }
        }
        finally {
            this.ReleaseConnection(SqlConn);
        }
        return searchResult;
    }

    @Override
    public SearchResult Invoke(Connection connection, int nCountPerPage, int nPageNO, String strSortParam, int nSortDirect, Hashtable paramList, String strOpPersonId) throws SQLException {
        String strGroupBy;
        StringBuilderEx stringBuilder = new StringBuilderEx();
        boolean bPaging = nPageNO >= 1;
        this.AppendSystemParam(stringBuilder);
        this.AppendSearchSystemParam(stringBuilder, bPaging);
        stringBuilder.Append("\r\n");
        this.AppendCommonParam(stringBuilder);
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "PREPARE"));
        stringBuilder.Append("set @srf_retcode = 0 \r\n");
        stringBuilder.Append("set @srf_opman = '%1$s' \r\n", strOpPersonId);
        this.AppendUpdateParamValue(stringBuilder);
        stringBuilder.Append(this.dbCallerConfig.FindCustomAction("MSSQL", "BEFORE"));
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            block48: {
                DBCallerParam param;
                block49: {
                    Object objTemp;
                    param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
                    if (StringHelper.Length((String)param.getDatabase()) != 0 && StringHelper.Compare((String)param.getDatabase(), (String)"MSSQL", (boolean)true) != 0 || !DataTypeHelper.IsStringType((int)param.getDBType()) || StringHelper.Compare((String)param.getMatchAction(), (String)"LIKE", (boolean)true) != 0) break block48;
                    if (param.getRawValue()) break block49;
                    String strParamValue = param.getParamValue().toUpperCase();
                    if (!paramList.containsKey(strParamValue = strParamValue.toUpperCase()) || (objTemp = paramList.get(strParamValue)) instanceof String && objTemp.toString().length() == 0) break block48;
                }
                stringBuilder.Append("set @%1$s = '%%'+ @%1$s +'%%'  \r\n", param.getID());
            }
            ++i;
        }
        if (StringHelper.Length((String)this.dbCallerConfig.getUserReturn()) > 0) {
            stringBuilder.Append("set @srf_sql = 'select %2$s,* from %1$s' \r\n", this.dbCallerConfig.getViewName(), this.dbCallerConfig.getUserReturn());
        } else {
            stringBuilder.Append("set @srf_sql = 'select * from %1$s'\r\n", this.dbCallerConfig.getViewName());
        }
        if (bPaging) {
            stringBuilder.Append("set @srf_countsql = 'select count(*) as TOTALROW from %1$s'\r\n", this.dbCallerConfig.getViewName());
        }
        boolean bFirstCondition = true;
        if (this.dbCallerConfig.getLogicEnable()) {
            stringBuilder.Append("select @srf_condSql = ' where ([enable] = 1) '\r\n");
            bFirstCondition = false;
        } else {
            stringBuilder.Append("select @srf_condSql = ''\r\n");
        }
        nCount = this.dbCallerConfig.getParams().size();
        int i2 = 0;
        while (i2 < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i2);
            if ((StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"MSSQL", (boolean)true) == 0) && param.getSearch() && StringHelper.Length((String)param.getMatchAction()) != 0 && !param.getRawValue()) {
                String strParamValue = param.getParamValue().toUpperCase();
                if (paramList.containsKey(strParamValue = strParamValue.toUpperCase())) {
                    Object objTemp = paramList.get(strParamValue);
                    if (objTemp instanceof String && objTemp.toString().length() == 0) {
                        if (bFirstCondition) {
                            stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' WHERE '\r\n");
                            bFirstCondition = false;
                        } else {
                            stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' AND '\r\n");
                        }
                        stringBuilder.Append("select @srf_condSql = @srf_condSql +  '(%1$s IS NULL)'\r\n", param.getParamName());
                    } else {
                        if (bFirstCondition) {
                            stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' WHERE '\r\n");
                            bFirstCondition = false;
                        } else {
                            stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' AND '\r\n");
                        }
                        if (DataTypeHelper.IsStringType((int)param.getDBType())) {
                            stringBuilder.Append("select @srf_condSql = @srf_condSql +  '( %1$s %2$s ''' + @%3$s + ''')'\r\n", param.getParamName(), param.getMatchAction(), param.getID());
                        } else {
                            String strCastFunc = param.getCastFunc();
                            if (StringHelper.Length((String)strCastFunc) == 0) {
                                strCastFunc = "cast(@%1$s as varchar)";
                            }
                            String strCastParam = StringHelper.Format((String)strCastFunc, (Object)param.getID());
                            if (DataTypeHelper.IsDateTimeType((int)param.getDBType())) {
                                stringBuilder.Append("select @srf_condSql = @srf_condSql +  '( %1$s %2$s ''' + @%3$s + ''')'\r\n", param.getParamName(), param.getMatchAction(), strCastParam);
                            } else {
                                stringBuilder.Append("select @srf_condSql = @srf_condSql +  '( %1$s %2$s ' + @%3$s + ')'\r\n", param.getParamName(), param.getMatchAction(), strCastParam);
                            }
                        }
                    }
                }
            }
            ++i2;
        }
        String strExtCondition = this.dbCallerConfig.FindCustomAction("MSSQL", "CONDITION");
        if (StringHelper.Length((String)strExtCondition) > 0) {
            if (bFirstCondition) {
                stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' WHERE '\r\n");
                bFirstCondition = false;
            } else {
                stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' AND '\r\n");
            }
            stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' %1$s '\r\n", strExtCondition);
        }
        if (StringHelper.Length((String)(strGroupBy = this.dbCallerConfig.FindCustomAction("MSSQL", "GROUPBY"))) > 0) {
            stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' %1$s '\r\n", strGroupBy);
        }
        stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' order by '\r\n");
        if (StringHelper.Length((String)strSortParam) > 0) {
            stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' %1$s '\r\n", strSortParam);
        } else {
            stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' %1$s '\r\n", this.dbCallerConfig.getSortParam());
        }
        stringBuilder.Append("select @srf_condSql = @srf_condSql +  ' %1$s '\r\n", nSortDirect == 0 ? "ASC" : "DESC");
        String strExtSort = this.dbCallerConfig.FindCustomAction("MSSQL", "DEFAULTORDER");
        if (StringHelper.Length((String)strExtSort) > 0) {
            stringBuilder.Append("select @srf_condSql = @srf_condSql +  ',%1$s '\r\n", strExtSort);
        }
        stringBuilder.Append("select @srf_Sql = @srf_Sql + @srf_condSql \r\n");
        if (bPaging) {
            stringBuilder.Append("EXEC Sp_PageFunc  @srf_Sql ,%1$s ,%2$s \r\n", nPageNO, nCountPerPage);
        } else {
            stringBuilder.Append("EXEC SP_EXECUTESQL  @srf_Sql \r\n");
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
        SearchResult searchResult = new SearchResult();
        searchResult.setRetCode(1);
        searchResult.setDatabase(2);
        PreparedStatement cstmt = null;
        try {
            try {
                cstmt = connection.prepareStatement(stringBuilder.toString());
                int nParamIndex = 1;
                nCount = this.dbCallerConfig.getParams().size();
                int i3 = 0;
                while (i3 < nCount) {
                    DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i3);
                    if (param.getDeclareParam() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"MSSQL", (boolean)true) == 0) && !param.getRawValue()) {
                        String strParamValue = param.getParamValue().toUpperCase();
                        Object objTemp = paramList.get(strParamValue);
                        if (objTemp != null && objTemp instanceof String && objTemp.toString().length() == 0) {
                            objTemp = null;
                        }
                        cstmt.setObject(nParamIndex, objTemp, SqlSearchCmdCaller.GetJDBCType((int)param.getDBType()));
                        ++nParamIndex;
                    }
                    ++i3;
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
                if (dataSet.getTableCount() >= 3) {
                    searchResult.setSearchData(dataSet);
                    searchResult.setDataTableIndex(3);
                    searchResult.setTotalRow(Integer.parseInt(dataSet.getTable(2).GetRow(0).Get("TOTALROW").toString()));
                    searchResult.setItemPerPage(nCountPerPage);
                    searchResult.setPageNo(nPageNO);
                    searchResult.setRetCode(0);
                }
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                searchResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                cstmt.close();
            }
        }
        finally {
            cstmt.close();
        }
        return searchResult;
    }

    @Override
    public DBResult CreateProc() throws SQLException {
        return null;
    }
}

