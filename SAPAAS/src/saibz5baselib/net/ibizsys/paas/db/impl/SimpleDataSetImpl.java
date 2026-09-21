/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;

public class SimpleDataSetImpl
implements IDataSet {
    protected ArrayList<IDataTable> dataTableList = new ArrayList();

    public void addDataTable(IDataTable iDataTable) throws SQLException {
        this.dataTableList.add(iDataTable);
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

    @Override
    public void close() {
        for (IDataTable iDataTable : this.dataTableList) {
            iDataTable.close();
        }
        this.dataTableList.clear();
    }

    @Override
    public void cacheDataRow() throws SQLException {
        for (IDataTable iDataTable : this.dataTableList) {
            if (iDataTable.getCachedRowCount() != -1) continue;
            iDataTable.cacheRows(-1);
        }
    }

    @Override
    public String getSqlInfo() {
        return null;
    }
}

