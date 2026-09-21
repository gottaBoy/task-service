/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Web.PDA;

import SA.SRFDA.Web.PDA.ListPage;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class SimpleListPage
extends ListPage {
    @Override
    protected String OnGetDataEntityId() {
        return "DE0001";
    }

    @Override
    protected void FillListContent(DataTable dataTable) {
        try {
            StringBuilderEx html = new StringBuilderEx();
            int nRowCount = dataTable.GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                DataRow dr = dataTable.GetRow(i);
                html.Append("<TR>");
                html.Append("<TD>%1$s</TD>", dr.Get("DENAME"));
                html.Append("<TD>%1$s</TD>", dr.Get("DELOGICNAME"));
                html.Append("</TR>");
                ++i;
            }
            this.strListContent = html.toString();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected String OnGetGridViewId() {
        return "DG_DE0001_001";
    }
}

