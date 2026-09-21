/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SearchResult
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SearchResult;
import SA.SRFramework.DataEx.CallResult;

public class SearchCallResult
extends CallResult {
    protected int nTotalRow = 0;
    protected DataTable dataTable = null;

    public void From(SearchResult searchResult) {
        super.From((DBResult)searchResult);
        if (this.getRetCode() == 0) {
            this.nTotalRow = searchResult.getTotalRow();
            this.dataTable = searchResult.getMainTable();
        }
    }

    public int getTotalRow() {
        return this.nTotalRow;
    }

    public DataTable getDataTable() {
        return this.dataTable;
    }
}

