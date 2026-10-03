/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.IDBSearchProcCaller2
 *  SA.SRFramework.Data.Oracle.OraDBProcCaller
 *  SA.SRFramework.Data.Oracle.OracleDataSet
 *  SA.SRFramework.Data.SearchResult2
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx.Oracle;

import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.IDBSearchProcCaller2;
import SA.SRFramework.Data.Oracle.OraDBProcCaller;
import SA.SRFramework.Data.Oracle.OracleDataSet;
import SA.SRFramework.Data.SearchResult2;
import SA.SRFramework.Utility.StringHelper;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

public class OraSearchProcCallerEx2
extends OraDBProcCaller
implements IDBSearchProcCaller2 {
    public SearchResult2 Invoke(int nCountPerPage, int nPageNO, String strSortParam, int nSortDirect, Hashtable paramList, String strOpPersonId) throws SQLException {
        SearchResult2 dbResult;
        block20: {
            Hashtable<Integer, String> outputParamList = new Hashtable<Integer, String>();
            dbResult = new SearchResult2();
            dbResult.setRetCode(1);
            dbResult.setDatabase(1);
            Connection OraConn = this.CreateConnection();
            if (OraConn == null) {
                this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
                dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
                return dbResult;
            }
            CallableStatement cstmt = null;
            try {
                try {
                    int nParamCount;
                    int nCallParamCount = nParamCount = this.dbCallerConfig.getParams().size();
                    if (this.dbCallerConfig.getLogDBOperator()) {
                        ++nCallParamCount;
                    }
                    String strProc = this.FormatProcCall(this.dbCallerConfig.getProcName(), nCallParamCount += 6);
                    cstmt = OraConn.prepareCall(strProc);
                    int nParamIndex = 1;
                    int nParamReturnRS = nParamIndex++;
                    cstmt.registerOutParameter(nParamReturnRS, -10);
                    int nParamReturnTotalRow = nParamIndex++;
                    cstmt.registerOutParameter(nParamReturnTotalRow, -10);
                    int nParamCountPerPageIndex = nParamIndex++;
                    cstmt.setObject(nParamCountPerPageIndex, nCountPerPage, 2);
                    int nParamPageNOIndex = nParamIndex++;
                    cstmt.setObject(nParamPageNOIndex, nPageNO, 2);
                    int i = 0;
                    while (i < nParamCount) {
                        DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
                        String strParamValue = param.getParamValue().toUpperCase();
                        if (param.getEndOfDay()) {
                            this.SetParamEndOfDay(paramList, strParamValue);
                        }
                        if (param.getDirection() == 1) {
                            cstmt.setObject(nParamIndex, paramList.get(strParamValue), this.GetJDBCType(param.getDBType()));
                        } else if (param.getDirection() == 2) {
                            cstmt.registerOutParameter(nParamIndex, this.GetJDBCType(param.getDBType()));
                            outputParamList.put(nParamIndex, strParamValue);
                        } else if (param.getDirection() == 3) {
                            cstmt.setObject(nParamIndex, paramList.get(strParamValue), this.GetJDBCType(param.getDBType()));
                            cstmt.registerOutParameter(nParamIndex, this.GetJDBCType(param.getDBType()));
                            outputParamList.put(nParamIndex, strParamValue);
                        }
                        ++nParamIndex;
                        ++i;
                    }
                    int nParamSortParamIndex = nParamIndex++;
                    cstmt.setObject(nParamSortParamIndex, strSortParam, 12);
                    String strDefaultSort = this.dbCallerConfig.getDefaultSort();
                    if (StringHelper.IsNullOrEmpty((String)strDefaultSort) && this.dbCallerConfig.isAutoDefaultSort()) {
                        strDefaultSort = ",rowid asc";
                    }
                    int nParamSortDirectIndex = nParamIndex++;
                    cstmt.setObject(nParamSortDirectIndex, nSortDirect == 0 ? "ASC" + strDefaultSort : "DESC" + strDefaultSort, 12);
                    if (this.dbCallerConfig.getLogDBOperator()) {
                        int nParamOPPersonIndex = nParamIndex++;
                        cstmt.setObject(nParamOPPersonIndex, strOpPersonId, 12);
                    }
                    cstmt.execute();
                    dbResult.setRetCode(0);
                    OracleDataSet dataSet = new OracleDataSet();
                    ResultSet rs = (ResultSet)cstmt.getObject(nParamReturnRS);
                    dbResult.setSearchData(rs);
                    ResultSet rsTotal = (ResultSet)cstmt.getObject(nParamReturnTotalRow);
                    dataSet.AddResultSet(rsTotal);
                    rsTotal.close();
                    dbResult.setTotalRow(Integer.parseInt(dataSet.getTable(0).GetRow(0).Get("TOTALROW").toString()));
                    dbResult.setItemPerPage(nCountPerPage);
                    dbResult.setPageNo(nPageNO);
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
                    dbResult.setErrorInfo(ex.toString());
                    ex.printStackTrace(System.out);
                    if (dbResult.getRetCode() == 0) {
                        dbResult.setCallableStatement((CallableStatement)cstmt);
                        dbResult.setConnection(OraConn);
                        break block20;
                    }
                    cstmt.close();
                    this.ReleaseConnection(OraConn);
                }
            }
            finally {
                if (dbResult.getRetCode() == 0) {
                    dbResult.setCallableStatement((CallableStatement)cstmt);
                    dbResult.setConnection(OraConn);
                } else {
                    cstmt.close();
                    this.ReleaseConnection(OraConn);
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

