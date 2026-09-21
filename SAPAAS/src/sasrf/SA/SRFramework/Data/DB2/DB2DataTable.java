/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.DB2;

import SA.SRFramework.Data.DB2.DB2DataRow;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB2DataTable
extends DataTable {
    public DB2DataTable(DataSet ds, ResultSet rs, boolean bDelayRead) throws SQLException {
        super(ds, rs, bDelayRead);
    }

    public DB2DataTable(DataSet ds, ResultSet rs) throws SQLException {
        super(ds, rs);
    }

    @Override
    protected DataRow CreateRow(ResultSet rs) throws SQLException {
        return new DB2DataRow(this, rs);
    }
}

