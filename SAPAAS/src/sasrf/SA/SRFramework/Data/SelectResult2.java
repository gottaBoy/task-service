/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.IDBRawProcCaller3;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SelectResult2
extends DBResult {
    protected Connection connection = null;
    protected PreparedStatement cstmt = null;
    protected DataSet selectDataSet = null;
    protected IDBRawProcCaller3 iDBRawProcCaller3 = null;
    protected int nDataTableIndex = 0;

    public SelectResult2(IDBRawProcCaller3 iDBRawProcCaller3) {
        this.iDBRawProcCaller3 = iDBRawProcCaller3;
    }

    public DataSet getSelectData() {
        return this.selectDataSet;
    }

    public void setSelectData(DataSet value) {
        this.selectDataSet = value;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void setPreparedStatement(PreparedStatement cstmt) {
        this.cstmt = cstmt;
    }

    public PreparedStatement getPreparedStatement() {
        return this.cstmt;
    }

    public void Close() {
        if (this.iDBRawProcCaller3 == null) {
            return;
        }
        this.iDBRawProcCaller3.ReleaseSelectResult(this);
        this.iDBRawProcCaller3 = null;
        this.selectDataSet = null;
    }

    public int getDataTableIndex() {
        return this.nDataTableIndex;
    }

    public void setDataTableIndex(int value) {
        this.nDataTableIndex = value;
    }

    public DataTable getMainTable() {
        return this.selectDataSet.getTable(this.nDataTableIndex);
    }
}

