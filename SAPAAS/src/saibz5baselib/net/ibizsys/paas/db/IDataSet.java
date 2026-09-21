/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import java.sql.SQLException;
import net.ibizsys.paas.db.IDataTable;

public interface IDataSet {
    public int getDataTableCount();

    public IDataTable getDataTable(int var1);

    public void close();

    public void cacheDataRow() throws SQLException;

    public String getSqlInfo();
}

