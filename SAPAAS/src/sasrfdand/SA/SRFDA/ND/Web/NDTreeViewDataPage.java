/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.TreeViewDataPage
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.ND.Web;

import SA.SRFDA.Web.Default.TreeViewDataPage;
import SA.SRFramework.Utility.StringHelper;

public class NDTreeViewDataPage
extends TreeViewDataPage {
    protected String OnGetTreeView() {
        String strTreeViewId = super.OnGetTreeView();
        if (!StringHelper.IsNullOrEmpty((String)strTreeViewId)) {
            return strTreeViewId;
        }
        return "TREEVIEW_ND0010_001";
    }
}

