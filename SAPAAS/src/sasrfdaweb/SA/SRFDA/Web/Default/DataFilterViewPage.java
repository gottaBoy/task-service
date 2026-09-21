/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Config.DataFilterConfigPublishContext;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Web.Default.ViewModel.DataFilterViewModel;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class DataFilterViewPage
extends SRFDAPageEx {
    protected String strDataFilterConfigId = "";
    protected DataFilterViewModel dataFilterViewModel = null;

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
        this.LoadDataFilter();
    }

    protected void LoadDataFilter() {
        this.strDataFilterConfigId = this.OnGetDataFilterConfigId();
        this.dataFilterViewModel.getDataFilterModel().setConfigId(this.strDataFilterConfigId);
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        return super.OnFillPageModel(jsonObject);
    }

    protected String OnGetDataFilterConfigId() {
        try {
            DataFilterConfigPublishContext dataFilterConfigPublishContext = new DataFilterConfigPublishContext();
            this.FillDAConfigPublishContext(dataFilterConfigPublishContext);
            String strDataFilterConfigId = this.getDAConfigHelper().GetConfigId("DATAFILTER", (IDAConfigPublishContext)dataFilterConfigPublishContext);
            return strDataFilterConfigId;
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u8fc7\u6ee4\u89c6\u56fe\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return "";
        }
    }

    @Override
    protected PageModel CreatePageModel() {
        return new DataFilterViewModel();
    }

    @Override
    protected void PreparePageModel() {
        this.dataFilterViewModel = (DataFilterViewModel)this.pageModel;
    }
}

