/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.ListColumnConfig;

public class ListMgrColumnConfig
extends ListColumnConfig {
    protected static String FIRSTCOLUMN = "FIRSTCOLUMN";
    protected boolean bFirstColumn = true;

    public ListMgrColumnConfig() {
        this.nWidth = 80;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare(FIRSTCOLUMN, strName, true) == 0) {
            this.bFirstColumn = ListMgrColumnConfig.GetValue(strValue, this.bFirstColumn);
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean getFirstColumn() {
        return this.bFirstColumn;
    }
}

