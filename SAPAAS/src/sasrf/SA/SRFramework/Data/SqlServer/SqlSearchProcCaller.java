/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.SqlServer;

import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.IDBSearchProcCaller;
import SA.SRFramework.Data.SearchResult;
import SA.SRFramework.Data.SqlServer.SqlDBProcCaller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;

public class SqlSearchProcCaller
extends SqlDBProcCaller
implements IDBSearchProcCaller {
    @Override
    public SearchResult Invoke(int nCountPerPage, int nPageNO, String strSortParam, int nSortDirect, Hashtable paramList, String strOpPersonId) throws SQLException {
        Hashtable outputParamList = new Hashtable();
        SearchResult dbResult = new SearchResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(2);
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        Statement cstmt = null;
        try {
            try {
                int nParamCount;
                int nCallParamCount = nParamCount = this.dbCallerConfig.getParams().size();
                if (this.dbCallerConfig.getLogDBOperator()) {
                    ++nCallParamCount;
                }
                String strProc = SqlSearchProcCaller.FormatProcCall(this.dbCallerConfig.getProcName(), nCallParamCount += 4, false);
                cstmt = SqlConn.prepareCall(strProc);
                int nParamIndex = 1;
                int nParamCountPerPageIndex = nParamIndex++;
                cstmt.setObject(nParamCountPerPageIndex, nCountPerPage, SqlSearchProcCaller.GetJDBCType(9));
                int nParamPageNOIndex = nParamIndex++;
                cstmt.setObject(nParamPageNOIndex, nPageNO, SqlSearchProcCaller.GetJDBCType(9));
                int i = 0;
                while (i < nParamCount) {
                    DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
                    String strParamValue = param.getParamValue().toUpperCase();
                    if (param.getEndOfDay()) {
                        this.SetParamEndOfDay(paramList, strParamValue);
                    }
                    if (param.getDirection() == 1) {
                        cstmt.setObject(nParamIndex, paramList.get(strParamValue), SqlSearchProcCaller.GetJDBCType(param.getDBType()));
                    } else if (param.getDirection() == 2) {
                        cstmt.registerOutParameter(nParamIndex, SqlSearchProcCaller.GetJDBCType(param.getDBType()));
                        outputParamList.put(nParamIndex, paramList.get(strParamValue));
                    } else if (param.getDirection() == 3) {
                        cstmt.setObject(nParamIndex, paramList.get(strParamValue), SqlSearchProcCaller.GetJDBCType(param.getDBType()));
                        cstmt.registerOutParameter(nParamIndex, SqlSearchProcCaller.GetJDBCType(param.getDBType()));
                        outputParamList.put(nParamIndex, param.getParamValue());
                    }
                    ++nParamIndex;
                    ++i;
                }
                int nParamSortParamIndex = nParamIndex++;
                cstmt.setObject(nParamSortParamIndex, strSortParam, SqlSearchProcCaller.GetJDBCType(25));
                int nParamSortDirectIndex = nParamIndex++;
                cstmt.setObject(nParamSortDirectIndex, nSortDirect == 0 ? "ASC" : "DESC", SqlSearchProcCaller.GetJDBCType(25));
                if (this.dbCallerConfig.getLogDBOperator()) {
                    int nParamOPPersonIndex = nParamIndex++;
                    cstmt.setObject(nParamOPPersonIndex, strOpPersonId, SqlSearchProcCaller.GetJDBCType(25));
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
                    dbResult.setSearchData(dataSet);
                    dbResult.setDataTableIndex(3);
                    dbResult.setTotalRow(Integer.parseInt(dataSet.getTable(2).GetRow(0).Get("TOTALROW").toString()));
                    dbResult.setItemPerPage(nCountPerPage);
                    dbResult.setPageNo(nPageNO);
                    Enumeration enumeration = outputParamList.keys();
                    while (enumeration.hasMoreElements()) {
                        int nIndex = (Integer)enumeration.nextElement();
                        String strParamValue = (String)outputParamList.get(nIndex);
                        paramList.put(strParamValue, cstmt.getObject(nIndex));
                    }
                    dbResult.setRetCode(0);
                }
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                dbResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                cstmt.close();
                this.ReleaseConnection(SqlConn);
            }
        }
        finally {
            cstmt.close();
            this.ReleaseConnection(SqlConn);
        }
        return dbResult;
    }
}

