/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.IDBRawProcCaller2
 *  SA.SRFramework.Data.SelectResult
 */
package SA.SRFramework.Data.MySQL;

import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.IDBRawProcCaller2;
import SA.SRFramework.Data.MySQL.MySQLDBProcCallerEx;
import SA.SRFramework.Data.SelectResult;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLRawProcCaller2
extends MySQLDBProcCallerEx
implements IDBRawProcCaller2 {
    public SelectResult Invoke(String strCommand, int nTimeOut) throws SQLException {
        SelectResult dbResult = new SelectResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(3);
        Connection MySQLConn = this.CreateConnection();
        if (MySQLConn == null) {
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        Statement cstmt = null;
        try {
            try {
                cstmt = MySQLConn.createStatement();
                cstmt.execute(strCommand);
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
                dbResult.setRetCode(nRetCode.intValue());
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                dbResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                if (cstmt != null) {
                    cstmt.close();
                }
                this.ReleaseConnection(MySQLConn);
            }
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            this.ReleaseConnection(MySQLConn);
        }
        return dbResult;
    }

    public SelectResult Invoke(String strCommand) throws SQLException {
        return this.Invoke(strCommand, -1);
    }
}

