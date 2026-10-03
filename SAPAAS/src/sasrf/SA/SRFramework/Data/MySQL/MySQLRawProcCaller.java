/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.MySQL;

import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.IDBRawProcCaller;
import SA.SRFramework.Data.MySQL.MySQLDBProcCaller;
import SA.SRFramework.Data.SelectResult;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

public class MySQLRawProcCaller
extends MySQLDBProcCaller
implements IDBRawProcCaller {
    @Override
    public SelectResult Invoke(Hashtable paramList) throws SQLException {
        Hashtable outputParamList = new Hashtable();
        SelectResult dbResult = new SelectResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(3);
        Connection MySQLConn = this.CreateConnection();
        if (MySQLConn == null) {
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        CallableStatement cstmt = null;
        try {
            try {
                int nParamCount;
                int nCallParamCount = nParamCount = this.dbCallerConfig.getParams().size();
                String strProc = this.dbCallerConfig.getProcName();
                cstmt = MySQLConn.prepareCall(strProc);
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
                        outputParamList.put(nParamIndex, paramList.get(strParamValue));
                    } else if (param.getDirection() == 3) {
                        cstmt.setObject(nParamIndex, paramList.get(strParamValue), this.GetJDBCType(param.getDBType()));
                        cstmt.registerOutParameter(nParamIndex, this.GetJDBCType(param.getDBType()));
                        outputParamList.put(nParamIndex, param.getParamValue());
                    }
                    ++nParamIndex;
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
                Integer nRetCode = 0;
                dbResult.setRetCode(nRetCode);
                dbResult.setSelectData(dataSet);
                dbResult.setDataTableIndex(0);
                if (nRetCode != 0) {
                    DBUserError dbUserError = this.dbCallerConfig.GetUserError(nRetCode.toString());
                    if (dbUserError != null) {
                        dbResult.setErrorInfo(dbUserError.getMessage());
                    } else {
                        nRetCode.intValue();
                        dbResult.setErrorInfo("\u4e0d\u660e\u7684\u9519\u8bef");
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
                this.ReleaseConnection(MySQLConn);
            }
        }
        finally {
            cstmt.close();
            this.ReleaseConnection(MySQLConn);
        }
        return dbResult;
    }
}
