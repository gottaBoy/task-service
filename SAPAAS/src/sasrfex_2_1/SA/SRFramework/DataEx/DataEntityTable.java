/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTable
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DataTable;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.DataEntityRow;
import java.sql.SQLException;
import java.util.Vector;

public class DataEntityTable
extends DataTable {
    public DataEntityTable(DataTable dataTable) throws Exception {
        super(null, null);
        Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
        int i = 0;
        while (i < dataTable.GetRowCount()) {
            BaseDataEntity baseDataEntity = new BaseDataEntity();
            baseDataEntity.FromDataRow(dataTable.GetRow(i));
            list.add(baseDataEntity);
            ++i;
        }
        this.InitRows(list);
    }

    public DataEntityTable(Vector<BaseDataEntity> list) throws SQLException {
        super(null, null);
        this.InitRows(list);
    }

    private void InitRows(Vector<BaseDataEntity> list) throws SQLException {
        for (BaseDataEntity dataEntity : list) {
            DataEntityRow row = new DataEntityRow(this, dataEntity);
            this.rowVector.add(row);
        }
    }
}

