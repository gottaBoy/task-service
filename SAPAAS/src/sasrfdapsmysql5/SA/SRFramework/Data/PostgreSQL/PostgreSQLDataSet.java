/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 */
package SA.SRFramework.Data.PostgreSQL;

import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.PostgreSQL.PostgreSQLDataTable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSQLDataSet
extends DataSet {
    protected DataTable CreateDataTable(ResultSet rs, boolean bDelayRead) throws SQLException {
        return new PostgreSQLDataTable(this, rs, bDelayRead);
    }
}

