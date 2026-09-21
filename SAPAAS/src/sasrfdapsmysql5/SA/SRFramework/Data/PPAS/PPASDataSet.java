/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 */
package SA.SRFramework.Data.PPAS;

import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.PPAS.PPASDataTable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PPASDataSet
extends DataSet {
    protected DataTable CreateDataTable(ResultSet rs, boolean bDelayRead) throws SQLException {
        return new PPASDataTable(this, rs, bDelayRead);
    }
}

