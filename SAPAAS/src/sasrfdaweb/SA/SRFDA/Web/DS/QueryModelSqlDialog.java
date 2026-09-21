/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 */
package SA.SRFDA.Web.DS;

import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;

public class QueryModelSqlDialog
extends SRFDAPageEx {
    protected SRFExToolbar toolbar = null;
    public static final String TAG_TOOLBARID = "SRFDA.TB_DIALOG_CLOSE";

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadToolbar();
    }

    protected void LoadToolbar() {
        this.toolbar = QueryModelSqlDialog.CreateToolbar(this, "toolBar", 0.0, 0.0, TAG_TOOLBARID);
    }
}

