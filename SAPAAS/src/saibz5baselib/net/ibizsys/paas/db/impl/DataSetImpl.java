/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import net.ibizsys.paas.db.DataSetCache;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.DataTableImpl;

public class DataSetImpl
implements IDataSet {
    protected ArrayList<IDataTable> dataTableList = new ArrayList();
    protected Connection conn;
    protected PreparedStatement cstmt;
    private String strSqlInfo = null;

    public DataSetImpl(Connection conn, PreparedStatement cstmt) {
        this.conn = conn;
        this.cstmt = cstmt;
        DataSetCache.register(this);
    }

    public void addResultSet(ResultSet rs) throws SQLException {
        IDataTable dataTable = this.createDataTable(rs);
        this.dataTableList.add(dataTable);
    }

    @Override
    public int getDataTableCount() {
        return this.dataTableList.size();
    }

    @Override
    public IDataTable getDataTable(int nIndex) {
        if (nIndex < 0) {
            return null;
        }
        if (nIndex > this.dataTableList.size() - 1) {
            return null;
        }
        return this.dataTableList.get(nIndex);
    }

    protected IDataTable createDataTable(ResultSet rs) throws SQLException {
        return new DataTableImpl(this, rs);
    }

    @Override
    public void close() {
        for (IDataTable iDataTable : this.dataTableList) {
            iDataTable.close();
        }
        this.dataTableList.clear();
        this.closeDBLink();
        DataSetCache.unregister(this);
    }

    @Override
    public void cacheDataRow() throws SQLException {
        for (IDataTable iDataTable : this.dataTableList) {
            if (iDataTable.getCachedRowCount() != -1) continue;
            iDataTable.cacheRows(-1);
        }
        this.closeDBLink();
        DataSetCache.unregister(this);
    }

    protected void closeDBLink() {
        try {
            if (this.cstmt != null) {
                this.cstmt.close();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.cstmt = null;
        this.conn = null;
    }

    @Override
    public String getSqlInfo() {
        return this.strSqlInfo;
    }

    public void setSqlInfo(String strSqlInfo) {
        this.strSqlInfo = strSqlInfo;
    }
}

