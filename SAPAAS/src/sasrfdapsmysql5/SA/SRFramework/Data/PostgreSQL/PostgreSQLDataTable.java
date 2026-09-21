/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 */
package SA.SRFramework.Data.PostgreSQL;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.PostgreSQL.PostgreSQLDataRow;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSQLDataTable
extends DataTable {
    public PostgreSQLDataTable(DataSet ds, ResultSet rs, boolean bDelayRead) throws SQLException {
        super(ds, rs, bDelayRead);
    }

    public PostgreSQLDataTable(DataSet ds, ResultSet rs) throws SQLException {
        super(ds, rs);
    }

    protected DataRow CreateRow(ResultSet rs) throws SQLException {
        return new PostgreSQLDataRow(this, rs);
    }
}

