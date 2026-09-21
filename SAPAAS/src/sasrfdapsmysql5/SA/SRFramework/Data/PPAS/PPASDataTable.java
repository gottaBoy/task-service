/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 */
package SA.SRFramework.Data.PPAS;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.PPAS.PPASDataRow;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PPASDataTable
extends DataTable {
    public PPASDataTable(DataSet ds, ResultSet rs, boolean bDelayRead) throws SQLException {
        super(ds, rs, bDelayRead);
    }

    public PPASDataTable(DataSet ds, ResultSet rs) throws SQLException {
        super(ds, rs);
    }

    protected DataRow CreateRow(ResultSet rs) throws SQLException {
        return new PPASDataRow(this, rs);
    }
}

