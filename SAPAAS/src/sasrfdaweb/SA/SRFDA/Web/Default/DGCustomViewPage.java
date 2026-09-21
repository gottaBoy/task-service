/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.Default.ViewModel.DGCustomViewModel;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class DGCustomViewPage
extends SRFDAPageEx {
    protected DGCustomViewModel dgCustomViewModel = null;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u52a0\u8f7d\u9875\u9762\u5b9e\u4f53\u5931\u8d25"));
            return false;
        }
        return true;
    }

    @Override
    protected void OnInit() {
        super.OnInit();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        return super.OnFillPageModel(jsonObject);
    }

    @Override
    protected PageModel CreatePageModel() {
        return new DGCustomViewModel();
    }

    @Override
    protected void PreparePageModel() {
        this.dgCustomViewModel = (DGCustomViewModel)this.pageModel;
    }
}

