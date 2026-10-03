/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DBUserError
 *  SA.SRFramework.Data.IDBUpdateProcCaller
 *  SA.SRFramework.Data.SqlServer.SqlDBProcCaller
 */
package SA.SRFramework.DataEx.SqlServer;

import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Data.IDBUpdateProcCaller;
import SA.SRFramework.Data.SqlServer.SqlDBProcCaller;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.Enumeration;
import java.util.Hashtable;

public class SqlUpdateProcCallerEx
extends SqlDBProcCaller
implements IDBUpdateProcCaller {
    public DBResult Invoke(Hashtable paramList, String strOpPersonId) throws SQLException {
        Hashtable outputParamList = new Hashtable();
        DBResult dbResult = new DBResult();
        dbResult.setRetCode(1);
        dbResult.setDatabase(2);
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
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
                String strProc = SqlUpdateProcCallerEx.FormatProcCall((String)this.dbCallerConfig.getProcName(), (int)(++nCallParamCount), (boolean)true);
                cstmt = SqlConn.prepareCall(strProc);
                int nParamIndex = 1;
                int nParamReturnIndex = nParamIndex++;
                cstmt.registerOutParameter(nParamReturnIndex, SqlUpdateProcCallerEx.GetJDBCType((int)9));
                int i = 0;
                while (i < nParamCount) {
                    DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
                    String strParamValue = param.getParamValue().toUpperCase();
                    if (param.getEndOfDay()) {
                        this.SetParamEndOfDay(paramList, strParamValue);
                    }
                    if (param.getDirection() == 1) {
                        cstmt.setObject(nParamIndex, paramList.get(strParamValue), SqlUpdateProcCallerEx.GetJDBCType((int)param.getDBType()));
                    } else if (param.getDirection() == 2) {
                        cstmt.registerOutParameter(nParamIndex, SqlUpdateProcCallerEx.GetJDBCType((int)param.getDBType()));
                        outputParamList.put(nParamIndex, paramList.get(strParamValue));
                    } else if (param.getDirection() == 3) {
                        cstmt.setObject(nParamIndex, paramList.get(strParamValue), SqlUpdateProcCallerEx.GetJDBCType((int)param.getDBType()));
                        cstmt.registerOutParameter(nParamIndex, SqlUpdateProcCallerEx.GetJDBCType((int)param.getDBType()));
                        outputParamList.put(nParamIndex, param.getParamValue());
                    }
                    ++nParamIndex;
                    ++i;
                }
                if (this.dbCallerConfig.getLogDBOperator()) {
                    int nParamOPPersonIndex = nParamIndex++;
                    cstmt.setObject(nParamOPPersonIndex, strOpPersonId, SqlUpdateProcCallerEx.GetJDBCType((int)25));
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

