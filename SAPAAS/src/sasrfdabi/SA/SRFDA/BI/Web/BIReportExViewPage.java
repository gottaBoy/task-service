/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFDA.Web.ViewModel.SPExModel
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Ctrl.BIModelStorageFactory;
import SA.SRFDA.BI.Ctrl.DABIConfigHelperFactory;
import SA.SRFDA.BI.Ctrl.IBIModelStorage;
import SA.SRFDA.BI.Ctrl.IBIReportExActionHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.BI.Ctrl.IDABIConfigHelper;
import SA.SRFDA.BI.Ctrl.SRFDABIActionResult;
import SA.SRFDA.BI.Ctrl.SearchForm.BIRepExSearchFormActionHelper;
import SA.SRFDA.BI.Web.SRFDABIWebCTXHelper;
import SA.SRFDA.BI.Web.ViewModel.BIReportExViewModel;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFDA.Web.ViewModel.SPExModel;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import net.sf.json.JSONObject;

public class BIReportExViewPage
extends BaseMainPage {
    protected SRFExSPEx spEx = null;
    protected BIReportExViewModel biReportExViewModel = null;
    protected IBIReportExHelper iBIReportExHelper = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strBIReportExId = SRFDABIWebCTXHelper.GetBIReportExId((ISRFDAWebContext)this.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strBIReportExId)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u62a5\u8868\u7f16\u53f7");
            return false;
        }
        try {
            IBIModelStorage iBIModelStorage = BIModelStorageFactory.Create((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
            this.iBIReportExHelper = iBIModelStorage.FindBIReportEx(strBIReportExId);
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, ex.getMessage(), ex);
            return false;
        }
        return true;
    }

    protected PageModel CreatePageModel() {
        return new BIReportExViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.biReportExViewModel = (BIReportExViewModel)this.pageModel;
    }

    protected String OnGetPageCaption() {
        return this.iBIReportExHelper.getLogicName(this.getLanguage());
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            this.LoadSPEx();
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u754c\u9762\u90e8\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
        }
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
    }

    protected String GetSearchFormActionHelper() {
        return BIRepExSearchFormActionHelper.class.getName();
    }

    protected void LoadSPEx() throws Exception {
        String strSPConfigId = this.OnGetSPExConfigId();
        if (StringHelper.IsNullOrEmpty((String)strSPConfigId)) {
            return;
        }
        this.spEx = BIReportExViewPage.CreateSPEx((SRFDAPage)this, (String)"spEx", (String)strSPConfigId, (boolean)false);
        if (this.spEx != null) {
            this.spEx.getSPExConfig().setWidth(1024);
            if (!this.IsBackEndMode()) {
                if (this.biReportExViewModel != null && this.biReportExViewModel.getSPExModel() != null) {
                    SPExModel spExModel = this.biReportExViewModel.getSPExModel();
                    spExModel.setCtrlId("spEx");
                    spExModel.setConfigId(strSPConfigId);
                    spExModel.setRemoteCtrlId(this.spEx.getUniqueID());
                    spExModel.setItemPrivilege(false);
                    spExModel.setCustomSearch(false);
                }
                if (this.biReportExViewModel != null && this.biReportExViewModel.getSearchFormModel() != null) {
                    this.biReportExViewModel.getSearchFormModel().setRemoteCtrlId(this.getDefaultFormId());
                }
            }
        }
    }

    protected String OnGetSPExConfigId() throws Exception {
        IDABIConfigHelper iDABIConfigHelper = DABIConfigHelperFactory.GetDABIConfigHelper((SRFDAPageEx)this);
        return iDABIConfigHelper.GetBIReportExSPExConfigId(this.iBIReportExHelper);
    }

    public int GetCaptionWidth() {
        return this.OnGetCaptionWidth();
    }

    protected int OnGetCaptionWidth() {
        return this.getPageParam("PAGE.CAPTIONWIDTH", 60);
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        try {
            this.biReportExViewModel.setReportDesc(this.iBIReportExHelper.getDescription(this.getLanguage()));
            this.biReportExViewModel.setReportModel(this.iBIReportExHelper.getBIReportExModel());
            return true;
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u586b\u5145\u9875\u9762\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return false;
        }
    }

    protected void OnLoadBackEnd() {
        String strActionType = this.webContext.getActionType();
        if (StringHelper.Compare((String)strActionType, (String)"BIREPORTACTION", (boolean)true) == 0) {
            String strAction = this.webContext.getAction();
            IBIReportExActionHelper biReportExActionHelper = this.OnCreateBIReportExActionHelper();
            try {
                biReportExActionHelper.Process(this.iBIReportExHelper, (SRFDAPageEx)this, strAction);
            }
            catch (Exception ex) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"BI\u62a5\u8868\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                SRFDABIActionResult actionResult = new SRFDABIActionResult();
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"BI\u62a5\u8868\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                this.Output(actionResult.ToJSONString());
            }
            return;
        }
        super.OnLoadBackEnd();
    }

    protected IBIReportExActionHelper OnCreateBIReportExActionHelper() {
        return (IBIReportExActionHelper)ObjectHelper.Create((String)"SA.SRFDA.BI.Ctrl.BIReportExActionHelper");
    }
}

