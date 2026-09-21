/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;

public class CommonDialogEx
extends SRFDAPageEx {
    protected SRFExToolbar toolbar = null;
    public static final String TAG_TOOLBARID = "SRFDA.TB_DIALOG";
    public static final String TAG_DPEXID = "PAGE.DPEXID";
    public static final String TAG_FAHELPER = "PAGE.FAHELPER";

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadToolbar();
    }

    protected void LoadToolbar() {
        this.toolbar = CommonDialogEx.CreateToolbar(this, "toolBar", 0.0, 0.0, TAG_TOOLBARID);
    }

    public String GetOnOKCode() {
        return this.OnGetOnOKCode();
    }

    protected String OnGetOnOKCode() {
        String strCode = FormJSHelper.getSaveScript((SRFExForm)((SRFExForm)this.getDefaultForm()));
        strCode = String.valueOf(strCode) + "return false;";
        return strCode;
    }
}

