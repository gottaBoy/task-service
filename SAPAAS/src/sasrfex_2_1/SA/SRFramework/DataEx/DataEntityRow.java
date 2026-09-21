/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.SQLException;

public class DataEntityRow
extends DataRow {
    protected BaseDataEntity dataEntity = null;

    public DataEntityRow(DataTable dt, BaseDataEntity dataEntity) throws SQLException {
        super(null, null);
        this.dataEntity = dataEntity;
        this.dataTable = dt;
    }

    public Object Get(int nIndex) {
        return null;
    }

    public Object Get(String strColumnName) throws Exception {
        return this.dataEntity.GetParamValue(strColumnName);
    }

    public boolean IsDBNull(int nIndex) {
        return false;
    }

    public boolean IsDBNull(String strColumnName) throws Exception {
        return this.dataEntity.GetParamValue(strColumnName) == null;
    }
}

