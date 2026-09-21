/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.SqlServer;

import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.IDBInsertProcCaller;
import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.Data.SqlServer.SqlDBProcCaller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;

public class SqlInsertProcCaller
extends SqlDBProcCaller
implements IDBInsertProcCaller {
    @Override
    public InsertResult Invoke(Hashtable paramList, String strOpPersonId) throws SQLException {
        Hashtable outputParamList = new Hashtable();
        InsertResult dbResult = new InsertResult();
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
                String strProc = SqlInsertProcCaller.FormatProcCall(this.dbCallerConfig.getProcName(), ++nCallParamCount, true);
                cstmt = SqlConn.prepareCall(strProc);
                int nParamIndex = 1;
                int nParamReturnIndex = nParamIndex++;
                cstmt.registerOutParameter(nParamReturnIndex, SqlInsertProcCaller.GetJDBCType(9));
                int i = 0;
                while (i < nParamCount) {
                    DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
                    String strParamValue = param.getParamValue().toUpperCase();
                    if (param.getEndOfDay()) {
                        this.SetParamEndOfDay(paramList, strParamValue);
                    }
                    if (param.getDirection() == 1) {
                        cstmt.setObject(nParamIndex, paramList.get(strParamValue), SqlInsertProcCaller.GetJDBCType(param.getDBType()));
                    } else if (param.getDirection() == 2) {
                        cstmt.registerOutParameter(nParamIndex, SqlInsertProcCaller.GetJDBCType(param.getDBType()));
                        outputParamList.put(nParamIndex, paramList.get(strParamValue));
                    } else if (param.getDirection() == 3) {
                        cstmt.setObject(nParamIndex, paramList.get(strParamValue), SqlInsertProcCaller.GetJDBCType(param.getDBType()));
                        cstmt.registerOutParameter(nParamIndex, SqlInsertProcCaller.GetJDBCType(param.getDBType()));
                        outputParamList.put(nParamIndex, param.getParamValue());
                    }
                    ++nParamIndex;
                    ++i;
                }
                if (this.dbCallerConfig.getLogDBOperator()) {
                    int nParamOPPersonIndex = nParamIndex++;
                    cstmt.setObject(nParamOPPersonIndex, strOpPersonId, SqlInsertProcCaller.GetJDBCType(25));
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
                Integer nRetCode = Integer.parseInt(cstmt.getObject(nParamReturnIndex).toString());
                dbResult.setRetCode(nRetCode);
                dbResult.setInsertData(dataSet);
                dbResult.setDataTableIndex(0);
                if (nRetCode != 0) {
                    DBUserError dbUserError = this.dbCallerConfig.GetUserError(nRetCode.toString());
                    if (dbUserError != null) {
                        dbResult.setErrorInfo(dbUserError.getMessage());
                    } else {
                        switch (nRetCode) {
                            case -2: {
                                dbResult.setErrorInfo("\u60a8\u7684\u6570\u636e\u63d2\u5165\u4e86\u91cd\u590d\u952e");
                                break;
                            }
                            default: {
                                dbResult.setErrorInfo("\u4e0d\u660e\u7684\u9519\u8bef");
                            }
                        }
                    }
                }
                Enumeration enumeration = outputParamList.keys();
                while (enumeration.hasMoreElements()) {
                    int nIndex = (Integer)enumeration.nextElement();
                    String strParamValue = (String)outputParamList.get(nIndex);
                    paramList.put(strParamValue, cstmt.getObject(nIndex));
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

