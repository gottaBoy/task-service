/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.Oracle;

import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.Oracle.OracleDataTable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleDataSet
extends DataSet {
    @Override
    protected DataTable CreateDataTable(ResultSet rs, boolean bDelayRead) throws SQLException {
        return new OracleDataTable(this, rs, bDelayRead);
    }
}

