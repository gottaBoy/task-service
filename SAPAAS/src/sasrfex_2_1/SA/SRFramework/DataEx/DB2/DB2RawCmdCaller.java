/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.InsertResult
 */
package SA.SRFramework.DataEx.DB2;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.DataEx.DB2.DB2DBProcCallerEx;
import SA.SRFramework.DataEx.IDBRawCmdCaller;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB2RawCmdCaller
extends DB2DBProcCallerEx
implements IDBRawCmdCaller {
    @Override
    public DBResult Invoke(ArrayList paramList, String strOpPersonId) throws SQLException {
        DBResult dbResult = new DBResult();
        dbResult.setRetCode(1);
        dbResult.setDatabase(4);
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            dbResult = new InsertResult();
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        try {
            try {
                dbResult = this.Invoke(SqlConn, paramList, strOpPersonId);
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                this.ReleaseConnection(SqlConn);
            }
        }
        finally {
            this.ReleaseConnection(SqlConn);
        }
        return dbResult;
    }

    @Override
    public DBResult Invoke(Connection connection, ArrayList paramList, String strOpPersonId) throws SQLException {
        DBResult dbResult = new DBResult();
        dbResult.setRetCode(1);
        dbResult.setDatabase(4);
        Statement cstmt = null;
        try {
            try {
                connection.setAutoCommit(false);
                Statement stmt = connection.createStatement();
                int nCount = paramList.size();
                int i = 0;
                while (i < nCount) {
                    stmt.addBatch((String)paramList.get(i));
                    ++i;
                }
                int[] updateCounts = stmt.executeBatch();
                connection.commit();
                dbResult.setRetCode(0);
                dbResult.getOutValues().put("UPDATECOUNTS", updateCounts);
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                dbResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                if (cstmt != null) {
                    cstmt.close();
                }
            }
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
        }
        return dbResult;
    }
}

