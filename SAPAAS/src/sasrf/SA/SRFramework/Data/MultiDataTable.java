/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DataColumn;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MultiDataTable
extends DataTable {
    protected DataTable dataTable = null;

    public MultiDataTable() throws SQLException {
        super(null, null);
    }

    public MultiDataTable(DataSet ds, ResultSet rs) throws SQLException {
        super(ds, rs);
    }

    public void AddDataTable(DataTable dataTable2) {
        if (this.dataTable == null) {
            this.dataTable = dataTable2;
        }
        int i = 0;
        while (i < dataTable2.GetRowCount()) {
            DataRow dr = dataTable2.GetRow(i);
            this.rowVector.add(dr);
            ++i;
        }
    }

    public void AddDataTables(Vector<DataTable> dataTables) {
        for (DataTable dataTable : dataTables) {
            this.AddDataTable(dataTable);
        }
    }

    @Override
    public int GetColumnCount() {
        return this.dataTable.GetColumnCount();
    }

    @Override
    public int GetColumnIndex(String strColumnName) {
        return this.dataTable.GetColumnIndex(strColumnName);
    }

    @Override
    public DataColumn GetDataColumn(int nIndex) {
        return this.dataTable.GetDataColumn(nIndex);
    }
}

