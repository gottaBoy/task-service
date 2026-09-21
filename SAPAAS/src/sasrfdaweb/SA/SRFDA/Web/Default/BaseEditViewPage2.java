/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.SRFExTabView
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.Default.BaseFormViewPage;
import SA.SRFDA.Web.Default.ViewModel.EditView2Model;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import net.sf.json.JSONObject;

public class BaseEditViewPage2
extends BaseFormViewPage {
    protected SRFExToolbar toolbar = null;
    protected SRFExTabView tabView = null;
    private boolean bSimpleMode = false;
    protected String strTabViewConfigId = "";
    protected String strToolbarConfigId = "";
    protected boolean bContainKey = false;
    protected JSONObject keyJson = new JSONObject();
    protected EditView2Model editView2Model = null;

    public final void setSimpleMode(boolean bSimpleMode) {
        this.bSimpleMode = bSimpleMode;
    }

    public final boolean isSimpleMode() {
        return this.OnGetSimpleMode();
    }

    protected boolean OnGetSimpleMode() {
        return this.bSimpleMode;
    }

    @Override
    protected PageModel CreatePageModel() {
        return new EditView2Model();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.editView2Model = (EditView2Model)this.pageModel;
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.editView2Model.setContainKey(this.bContainKey);
        if (this.bContainKey) {
            this.editView2Model.setKeyData(this.keyJson);
        }
        return true;
    }
}

