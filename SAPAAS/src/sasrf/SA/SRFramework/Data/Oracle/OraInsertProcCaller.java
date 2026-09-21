/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.Oracle;

import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Data.IDBInsertProcCaller;
import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.Data.Oracle.OraDBProcCaller;
import SA.SRFramework.Data.Oracle.OracleDataSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;

public class OraInsertProcCaller
extends OraDBProcCaller
implements IDBInsertProcCaller {
    @Override
    public InsertResult Invoke(Hashtable paramList, String strOpPersonId) throws SQLException {
        Hashtable<Integer, String> outputParamList = new Hashtable<Integer, String>();
        InsertResult dbResult = new InsertResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(1);
        Connection OraConn = this.CreateConnection();
        if (OraConn == null) {
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
                String strProc = this.FormatProcCall(this.dbCallerConfig.getProcName(), nCallParamCount += 2);
                cstmt = OraConn.prepareCall(strProc);
                int nParamIndex = 1;
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
                int nParamReturnIndex = nParamIndex++;
                cstmt.registerOutParameter(nParamReturnIndex, 2);
                int nParamReturnRS = nParamIndex++;
                cstmt.registerOutParameter(nParamReturnRS, -10);
                if (this.dbCallerConfig.getLogDBOperator()) {
                    int nParamOPPersonIndex = nParamIndex++;
                    cstmt.setObject(nParamOPPersonIndex, strOpPersonId, this.GetJDBCType(25));
                }
                cstmt.execute();
                Integer nRetCode = Integer.parseInt(cstmt.getObject(nParamReturnIndex).toString());
                dbResult.setRetCode(nRetCode);
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
                                break;
                            }
                        }
                    }
                } else {
                    OracleDataSet dataSet = new OracleDataSet();
                    ResultSet rs = (ResultSet)cstmt.getObject(nParamReturnRS);
                    dataSet.AddResultSet(rs);
                    rs.close();
                    dbResult.setInsertData(dataSet);
                    dbResult.setDataTableIndex(0);
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
                dbResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                if (cstmt != null) {
                    cstmt.close();
                }
                this.ReleaseConnection(OraConn);
            }
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            this.ReleaseConnection(OraConn);
        }
        return dbResult;
    }
}

