/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;

public class SelectResult
extends DBResult {
    protected DataSet selectDataSet = null;
    protected int nDataTableIndex = 0;

    public DataSet getSelectData() {
        return this.selectDataSet;
    }

    public void setSelectData(DataSet value) {
        this.selectDataSet = value;
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

