/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 */
package SA.SRFramework.Data.MySQL;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.MySQL.MySQLDataRow;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLDataTable
extends DataTable {
    public MySQLDataTable(DataSet ds, ResultSet rs, boolean bDelayRead) throws SQLException {
        super(ds, rs, bDelayRead);
    }

    public MySQLDataTable(DataSet ds, ResultSet rs) throws SQLException {
        super(ds, rs);
    }

    protected DataRow CreateRow(ResultSet rs) throws SQLException {
        return new MySQLDataRow(this, rs);
    }
}

