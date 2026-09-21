/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.DB2;

import SA.SRFramework.Data.DB2.DB2DataTable;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB2DataSet
extends DataSet {
    @Override
    protected DataTable CreateDataTable(ResultSet rs, boolean bDelayRead) throws SQLException {
        return new DB2DataTable(this, rs, bDelayRead);
    }
}

