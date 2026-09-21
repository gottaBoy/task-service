/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DataTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DataSet {
    private Vector tableVector = new Vector();

    public void AddResultSet(ResultSet rs) throws SQLException {
        DataTable dataTable = this.CreateDataTable(rs, false);
        this.tableVector.add(dataTable);
    }

    public void AddResultSet(ResultSet rs, boolean bDelayRead) throws SQLException {
        DataTable dataTable = this.CreateDataTable(rs, bDelayRead);
        this.tableVector.add(dataTable);
    }

    public void InsertResultSet(int nPos, ResultSet rs) throws SQLException {
        DataTable dataTable = this.CreateDataTable(rs, false);
        this.tableVector.add(nPos, dataTable);
    }

    public void InsertResultSet(int nPos, ResultSet rs, boolean bDelayRead) throws SQLException {
        DataTable dataTable = this.CreateDataTable(rs, bDelayRead);
        this.tableVector.add(nPos, dataTable);
    }

    public int getTableCount() {
        return this.tableVector.size();
    }

    public DataTable getTable(int nIndex) {
        if (nIndex < 0) {
            return null;
        }
        if (nIndex > this.tableVector.size() - 1) {
            return null;
        }
        return (DataTable)this.tableVector.get(nIndex);
    }

    protected DataTable CreateDataTable(ResultSet rs, boolean bDelayRead) throws SQLException {
        return new DataTable(this, rs, bDelayRead);
    }

    public void Reset() {
        if (this.tableVector != null) {
            this.tableVector.clear();
            this.tableVector = null;
        }
    }
}

