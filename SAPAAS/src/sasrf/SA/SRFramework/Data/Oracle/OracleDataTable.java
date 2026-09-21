/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.Oracle;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.Oracle.OracleDataRow;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleDataTable
extends DataTable {
    public OracleDataTable(DataSet ds, ResultSet rs, boolean bDelayRead) throws SQLException {
        super(ds, rs, bDelayRead);
    }

    public OracleDataTable(DataSet ds, ResultSet rs) throws SQLException {
        super(ds, rs);
    }

    @Override
    protected DataRow CreateRow(ResultSet rs) throws SQLException {
        return new OracleDataRow(this, rs);
    }
}

