/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.SearchCallResult;

public class SelectCallResult
extends CallResult {
    protected int nTotalRow = 0;
    protected DataTable dataTable = null;

    public void From(SelectResult selectResult) {
        super.From((DBResult)selectResult);
        if (this.getRetCode() == 0) {
            this.dataTable = selectResult.getMainTable();
        }
    }

    public void From(SearchCallResult searchResult) {
        super.From(searchResult);
        if (this.getRetCode() == 0) {
            this.dataTable = searchResult.getDataTable();
        }
    }

    public DataTable getDataTable() {
        return this.dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }
}

