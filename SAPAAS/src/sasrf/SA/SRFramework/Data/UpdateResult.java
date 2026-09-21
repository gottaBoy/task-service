/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.InsertResult;

public class UpdateResult
extends InsertResult {
    public DataSet getUpdateData() {
        return this.insertDataSet;
    }

    public void setUpdateData(DataSet value) {
        this.insertDataSet = value;
    }
}

