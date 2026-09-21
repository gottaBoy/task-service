/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;

public class InsertResult
extends DBResult {
    protected int nDataTableIndex = 0;
    protected DataSet insertDataSet = null;

    public DataSet getInsertData() {
        return this.insertDataSet;
    }

    public void setInsertData(DataSet value) {
        this.insertDataSet = value;
    }

    public int getDataTableIndex() {
        return this.nDataTableIndex;
    }

    public void setDataTableIndex(int value) {
        this.nDataTableIndex = value;
    }

    public DataTable getMainTable() {
        return this.insertDataSet.getTable(this.nDataTableIndex);
    }
}

