/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.DB2;

import SA.SRFramework.Data.DB2.DB2DBProcCaller;
import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Data.IDBUpdateProcCaller;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;

public class DB2UpdateProcCaller
extends DB2DBProcCaller
implements IDBUpdateProcCaller {
    @Override
    public DBResult Invoke(Hashtable paramList, String strOpPersonId) throws SQLException {
        Hashtable<Integer, String> outputParamList = new Hashtable<Integer, String>();
        DBResult dbResult = new DBResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(4);
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
                String strProc = DB2UpdateProcCaller.FormatProcCall(this.dbCallerConfig.getProcName(), nCallParamCount);
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
                        cstmt.setObject(nParamIndex, paramList.get(strParamValue), DB2UpdateProcCaller.GetJDBCType(param.getDBType()));
                    } else if (param.getDirection() == 2) {
                        cstmt.registerOutParameter(nParamIndex, DB2UpdateProcCaller.GetJDBCType(param.getDBType()));
                        outputParamList.put(nParamIndex, strParamValue);
                    } else if (param.getDirection() == 3) {
                        cstmt.setObject(nParamIndex, paramList.get(strParamValue), DB2UpdateProcCaller.GetJDBCType(param.getDBType()));
                        cstmt.registerOutParameter(nParamIndex, DB2UpdateProcCaller.GetJDBCType(param.getDBType()));
                        outputParamList.put(nParamIndex, strParamValue);
                    }
                    ++nParamIndex;
                    ++i;
                }
                if (this.dbCallerConfig.getLogDBOperator()) {
                    int nParamOPPersonIndex = nParamIndex++;
                    cstmt.setObject(nParamOPPersonIndex, strOpPersonId, DB2UpdateProcCaller.GetJDBCType(25));
                }
                cstmt.execute();
                Integer nRetCode = 0;
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
                            }
                        }
                    }
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

