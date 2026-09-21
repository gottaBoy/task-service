/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;

public class SearchResult
extends DBResult {
    protected int nTotalRow = 0;
    protected int nItemPerPage = 10;
    protected DataSet searchDataSet = null;
    protected int nPageNo = 0;
    protected int nDataTableIndex = 0;

    public DataSet getSearchData() {
        return this.searchDataSet;
    }

    public void setSearchData(DataSet value) {
        this.searchDataSet = value;
    }

    public int getTotalRow() {
        return this.nTotalRow;
    }

    public void setTotalRow(int value) {
        this.nTotalRow = value;
    }

    public int getItemPerPage() {
        return this.nItemPerPage;
    }

    public void setItemPerPage(int value) {
        this.nItemPerPage = value;
    }

    public int getTotalPage() {
        if (this.nItemPerPage == 0) {
            return 0;
        }
        int nTemp1 = this.nTotalRow % this.nItemPerPage;
        int nTemp2 = this.nTotalRow / this.nItemPerPage;
        if (nTemp1 != 0) {
            ++nTemp2;
        }
        return nTemp2;
    }

    public int getPageNo() {
        return this.nPageNo;
    }

    public void setPageNo(int value) {
        this.nPageNo = value;
    }

    public int getDataTableIndex() {
        return this.nDataTableIndex;
    }

    public void setDataTableIndex(int value) {
        this.nDataTableIndex = value;
    }

    public DataTable getMainTable() {
        return this.searchDataSet.getTable(this.nDataTableIndex);
    }
}

