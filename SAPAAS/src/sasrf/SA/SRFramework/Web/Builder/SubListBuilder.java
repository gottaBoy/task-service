/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SearchResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Web.Builder.ListBuilder;
import SA.SRFramework.Web.UI.SubListConfig;

public class SubListBuilder
extends ListBuilder {
    protected SubListConfig subListConfig = null;
    protected String strMoreURL = "";
    protected String strMoreURLTarget = "";
    protected int nTotalRow = -1;
    protected DataTable dataTable = null;
    private SearchResult searchResult = null;

    public void setDataSource(SelectResult value) {
        this.nTotalRow = -1;
        if (value != null) {
            this.dataTable = value.getMainTable();
            this.nTotalRow = this.dataTable.GetRowCount();
        }
    }

    @Override
    public void setDataSource(SearchResult value) {
        this.nTotalRow = -1;
        if (value != null) {
            this.dataTable = value.getMainTable();
            this.nTotalRow = value.getTotalRow();
        }
    }

    public void setConfig(SubListConfig value) {
        this.subListConfig = value;
    }

    public void setMoreURL(String value) {
        this.strMoreURL = value;
    }

    public void setMoreURLTarget(String value) {
        this.strMoreURLTarget = value;
    }
}

