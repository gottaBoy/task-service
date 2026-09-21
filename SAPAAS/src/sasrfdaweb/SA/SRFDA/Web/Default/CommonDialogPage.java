/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;

public class CommonDialogPage
extends SRFDAPage {
    protected SRFExToolbar toolbar = null;
    public static final String TAG_TOOLBARID = "SRFDA.TB_DIALOG";

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadToolbar();
    }

    protected void LoadToolbar() {
        this.toolbar = CommonDialogPage.CreateToolbar(this, "toolBar", 0.0, 0.0, TAG_TOOLBARID);
    }
}

