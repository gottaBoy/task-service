/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 */
package SA.SRFramework.Data.MySQL;

import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.MySQL.MySQLDataTable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLDataSet
extends DataSet {
    protected DataTable CreateDataTable(ResultSet rs, boolean bDelayRead) throws SQLException {
        return new MySQLDataTable(this, rs, bDelayRead);
    }
}

