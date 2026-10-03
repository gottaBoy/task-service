/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DBUserError
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.IDBInsertProcCaller
 *  SA.SRFramework.Data.InsertResult
 *  SA.SRFramework.Data.Oracle.OraDBProcCaller
 *  SA.SRFramework.Data.Oracle.OracleDataSet
 */
package SA.SRFramework.DataEx.DB2;

import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.IDBInsertProcCaller;
import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.Data.Oracle.OraDBProcCaller;
import SA.SRFramework.Data.Oracle.OracleDataSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.Enumeration;
import java.util.Hashtable;

public class DB2InsertProcCallerEx
extends OraDBProcCaller
implements IDBInsertProcCaller {
    public InsertResult Invoke(Hashtable paramList, String strOpPersonId) throws SQLException {
        Hashtable<Integer, String> outputParamList = new Hashtable<Integer, String>();
        InsertResult dbResult = new InsertResult();
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
                dbResult.setRetCode(nRetCode.intValue());
                if (nRetCode != 0) {
                    DBUserError dbUserError = this.dbCallerConfig.GetUserError(nRetCode.toString());
                    if (dbUserError != null) {
                        dbResult.setErrorInfo(dbUserError.getMessage());
                    } else if (!Errors.IsUserError(nRetCode)) {
                        dbResult.setErrorInfo(Errors.GetErrorInfo(nRetCode));
                    }
                } else {
                    OracleDataSet dataSet = new OracleDataSet();
                    ResultSet rs = (ResultSet)cstmt.getObject(nParamReturnRS);
                    dataSet.AddResultSet(rs);
                    rs.close();
                    dbResult.setInsertData((DataSet)dataSet);
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

