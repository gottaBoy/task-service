/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.IDBRawProcCaller2
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Data.SqlServer.SqlDBProcCaller
 */
package SA.SRFramework.Data.SqlServer;

import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.IDBRawProcCaller2;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.SqlServer.SqlDBProcCaller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlServerRawProcCaller2_1
extends SqlDBProcCaller
implements IDBRawProcCaller2 {
    public SelectResult Invoke(String strCommand, int nTimeOut) throws SQLException {
        SelectResult dbResult = new SelectResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(2);
        Connection conn = this.CreateConnection();
        if (conn == null) {
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        PreparedStatement cstmt = null;
        try {
            try {
                cstmt = conn.prepareStatement(strCommand);
                cstmt.execute();
                DataSet dataSet = new DataSet();
                while (true) {
                    int updateCount;
                    if ((updateCount = cstmt.getUpdateCount()) < 0) {
                        ResultSet rs = cstmt.getResultSet();
                        if (rs == null) break;
                        dataSet.AddResultSet(rs);
                        rs.close();
                        break;
                    }
                    cstmt.getMoreResults();
                }
                Integer nRetCode = 0;
                dbResult.setRetCode(nRetCode.intValue());
                dbResult.setSelectData(dataSet);
                dbResult.setDataTableIndex(0);
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                dbResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                if (cstmt != null) {
                    cstmt.close();
                }
                this.ReleaseConnection(conn);
            }
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            this.ReleaseConnection(conn);
        }
        return dbResult;
    }

    public SelectResult Invoke(String strCommand) throws SQLException {
        return this.Invoke(strCommand, -1);
    }
}

