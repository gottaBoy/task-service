/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.DB2;

import SA.SRFramework.Data.DB2.DB2DBProcCaller;
import SA.SRFramework.Data.DB2.DB2DataSet;
import SA.SRFramework.Data.IDBRawProcCaller2;
import SA.SRFramework.Data.SelectResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB2RawProcCaller2
extends DB2DBProcCaller
implements IDBRawProcCaller2 {
    @Override
    public SelectResult Invoke(String strCommand, int nTimeOut) throws SQLException {
        SelectResult dbResult = new SelectResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(4);
        Connection DB2Conn = this.CreateConnection();
        if (DB2Conn == null) {
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        PreparedStatement cstmt = null;
        try {
            try {
                cstmt = DB2Conn.prepareStatement(strCommand);
                cstmt.execute();
                DB2DataSet dataSet = new DB2DataSet();
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
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                dbResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                if (cstmt != null) {
                    cstmt.close();
                }
                this.ReleaseConnection(DB2Conn);
            }
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            this.ReleaseConnection(DB2Conn);
        }
        return dbResult;
    }

    @Override
    public SelectResult Invoke(String strCommand) throws SQLException {
        return this.Invoke(strCommand, -1);
    }
}

