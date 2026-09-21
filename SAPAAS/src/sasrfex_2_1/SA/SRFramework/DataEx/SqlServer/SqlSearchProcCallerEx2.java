/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.IDBSearchProcCaller2
 *  SA.SRFramework.Data.SearchResult2
 *  SA.SRFramework.Data.SqlServer.SqlDBProcCaller
 */
package SA.SRFramework.DataEx.SqlServer;

import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.IDBSearchProcCaller2;
import SA.SRFramework.Data.SearchResult2;
import SA.SRFramework.Data.SqlServer.SqlDBProcCaller;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;

public class SqlSearchProcCallerEx2
extends SqlDBProcCaller
implements IDBSearchProcCaller2 {
    public SearchResult2 Invoke(int nCountPerPage, int nPageNO, String strSortParam, int nSortDirect, Hashtable paramList, String strOpPersonId) throws SQLException {
        SearchResult2 dbResult;
        block23: {
            Hashtable outputParamList = new Hashtable();
            dbResult = new SearchResult2();
            dbResult.setRetCode(1);
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
                    String strProc = SqlSearchProcCallerEx2.FormatProcCall((String)this.dbCallerConfig.getProcName(), (int)(nCallParamCount += 4), (boolean)false);
                    cstmt = SqlConn.prepareCall(strProc);
                    int nParamIndex = 1;
                    int nParamCountPerPageIndex = nParamIndex++;
                    cstmt.setObject(nParamCountPerPageIndex, nCountPerPage, SqlSearchProcCallerEx2.GetJDBCType((int)9));
                    int nParamPageNOIndex = nParamIndex++;
                    cstmt.setObject(nParamPageNOIndex, nPageNO, SqlSearchProcCallerEx2.GetJDBCType((int)9));
                    int i = 0;
                    while (i < nParamCount) {
                        DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
                        String strParamValue = param.getParamValue().toUpperCase();
                        if (param.getEndOfDay()) {
                            this.SetParamEndOfDay(paramList, strParamValue);
                        }
                        if (param.getDirection() == 1) {
                            cstmt.setObject(nParamIndex, paramList.get(strParamValue), SqlSearchProcCallerEx2.GetJDBCType((int)param.getDBType()));
                        } else if (param.getDirection() == 2) {
                            cstmt.registerOutParameter(nParamIndex, SqlSearchProcCallerEx2.GetJDBCType((int)param.getDBType()));
                            outputParamList.put(nParamIndex, paramList.get(strParamValue));
                        } else if (param.getDirection() == 3) {
                            cstmt.setObject(nParamIndex, paramList.get(strParamValue), SqlSearchProcCallerEx2.GetJDBCType((int)param.getDBType()));
                            cstmt.registerOutParameter(nParamIndex, SqlSearchProcCallerEx2.GetJDBCType((int)param.getDBType()));
                            outputParamList.put(nParamIndex, param.getParamValue());
                        }
                        ++nParamIndex;
                        ++i;
                    }
                    int nParamSortParamIndex = nParamIndex++;
                    cstmt.setObject(nParamSortParamIndex, strSortParam, SqlSearchProcCallerEx2.GetJDBCType((int)25));
                    int nParamSortDirectIndex = nParamIndex++;
                    cstmt.setObject(nParamSortDirectIndex, nSortDirect == 0 ? "ASC" : "DESC", SqlSearchProcCallerEx2.GetJDBCType((int)25));
                    if (this.dbCallerConfig.getLogDBOperator()) {
                        int nParamOPPersonIndex = nParamIndex++;
                        cstmt.setObject(nParamOPPersonIndex, strOpPersonId, SqlSearchProcCallerEx2.GetJDBCType((int)25));
                    }
                    cstmt.execute();
                    DataSet dataSet = new DataSet();
                    int nRSIndex = 0;
                    while (true) {
                        int updateCount;
                        if ((updateCount = cstmt.getUpdateCount()) < 0) {
                            ResultSet rs = cstmt.getResultSet();
                            if (rs == null) break;
                            if (nRSIndex == 3) {
                                dbResult.setSearchData(rs);
                                break;
                            }
                            dataSet.AddResultSet(rs);
                            rs.close();
                            ++nRSIndex;
                        }
                        cstmt.getMoreResults();
                    }
                    if (dataSet.getTableCount() >= 3) {
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
                    if (dbResult.getRetCode() == 0) {
                        dbResult.setCallableStatement((CallableStatement)cstmt);
                        dbResult.setConnection(SqlConn);
                        break block23;
                    }
                    cstmt.close();
                    this.ReleaseConnection(SqlConn);
                }
            }
            finally {
                if (dbResult.getRetCode() == 0) {
                    dbResult.setCallableStatement((CallableStatement)cstmt);
                    dbResult.setConnection(SqlConn);
                } else {
                    cstmt.close();
                    this.ReleaseConnection(SqlConn);
                }
            }
        }
        return dbResult;
    }

    public void ReleaseSearchResult(SearchResult2 searchResult2) {
        try {
            if (searchResult2.getCallableStatement() != null) {
                searchResult2.getCallableStatement().close();
            }
            if (searchResult2.getConnection() != null) {
                this.ReleaseConnection(searchResult2.getConnection());
            }
            searchResult2.setCallableStatement(null);
            searchResult2.setConnection(null);
            searchResult2.setSearchData(null);
        }
        catch (Exception ex) {
            this.LogErrorInfo(ex.toString());
            ex.printStackTrace(System.out);
        }
    }
}

