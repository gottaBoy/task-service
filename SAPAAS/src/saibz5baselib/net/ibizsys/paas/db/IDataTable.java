/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import net.ibizsys.paas.db.IDataColumn;
import net.ibizsys.paas.db.IDataRow;

public interface IDataTable {
    public int getColumnCount();

    public int getColumnIndex(String var1);

    public IDataColumn getDataColumn(int var1);

    public IDataRow next() throws SQLException;

    public ResultSet getResultSet();

    public void close();

    public int cacheRows(int var1) throws SQLException;

    public IDataRow getCachedRow(int var1) throws Exception;

    public int getCachedRowCount();

    public int cacheAllRows() throws SQLException;
}

