/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFDA.Web.ViewModel.SPExModel
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.IS.Web;

import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.IS.Web.ViewModel.SearchFrameViewModel;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFDA.Web.ViewModel.SPExModel;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.Utility.URLHelper;
import net.sf.json.JSONObject;

public class SearchFramePage
extends SRFDAPageEx {
    protected SRFExSPEx spEx = null;
    protected SRFExIFrame iFrame = null;
    protected SearchFrameViewModel searchFrameViewModel = null;
    protected SRFExDropDownList ddlReportType = null;

    protected boolean PreparePageEnv() {
        return super.PreparePageEnv();
    }

    protected PageModel CreatePageModel() {
        return new SearchFrameViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.searchFrameViewModel = (SearchFrameViewModel)this.pageModel;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        return super.OnFillPageModel(jsonObject);
    }

    public String OutputPageCaption() {
        return "\u5168\u6587\u68c0\u7d22";
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadSPEx();
        this.LoadIFrame();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
    }

    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("$P.object['%1$s']={};\r\n", (Object)this.spEx.getUniqueID());
        this.RegisterOnReadyScript(3, script.toString());
        String strSearchResultUrl = this.getWebContext().getWebExConfig().GetValue("SRFIS", "SEARCHRESULTURL", "../srfis/searchresult.jsp");
        strSearchResultUrl = URLHelper.AppendURLSeperator((String)strSearchResultUrl);
        this.spEx.getSearchForm().setUserParamsName(StringHelper.Format((String)"$P.object['%1$s']", (Object)this.spEx.getUniqueID()));
        this.spEx.getSearchForm().getSearchAction().getSuccessAction().RegisterProcessCode(0, StringHelper.Format((String)"Ext.getDom('%1$s').contentWindow.location.href='%3$s'+ Ext.urlEncode($P.object['%2$s']);", (Object)this.iFrame.getUniqueID(), (Object)this.spEx.getUniqueID(), (Object)strSearchResultUrl));
    }

    protected String GetSearchFormActionHelper() {
        return BaseDASearchFormActionHelper.class.getName();
    }

    protected void LoadSPEx() {
        this.spEx = SearchFramePage.CreateSPEx((SRFDAPage)this, (String)"spEx", (String)this.OnGetSPExId());
        if (this.spEx != null) {
            this.spEx.getSPExConfig().setWidth(1024);
            this.IsBackEndMode();
            if (this.searchFrameViewModel != null && this.searchFrameViewModel.getSPExModel() != null) {
                SPExModel spExModel = this.searchFrameViewModel.getSPExModel();
                spExModel.setCtrlId("spEx");
                spExModel.setConfigId(this.spEx.getSearchForm().getSearchPanelId());
                spExModel.setRemoteCtrlId(this.spEx.getUniqueID());
                spExModel.setItemPrivilege(false);
                spExModel.setCustomSearch(false);
            }
            if (this.searchFrameViewModel != null && this.searchFrameViewModel.getSearchFormModel() != null) {
                this.searchFrameViewModel.getSearchFormModel().setRemoteCtrlId(this.getDefaultFormId());
            }
        }
    }

    protected String OnGetSPExId() {
        return this.getWebContext().getWebExConfig().GetValue("SRFIS", "SEARCHPANEL", "SRFIS.SPEX_DEFAULT");
    }

    public int GetCaptionWidth() {
        return this.OnGetCaptionWidth();
    }

    protected int OnGetCaptionWidth() {
        return this.getPageParam("PAGE.CAPTIONWIDTH", 60);
    }

    protected void LoadIFrame() {
        if (this.iFrame != null) {
            return;
        }
        this.iFrame = new SRFExIFrame();
        this.iFrame.InitConfig();
        this.iFrame.setID("iframe");
        this.iFrame.getIFrameConfig().setWidth(0);
        this.iFrame.getIFrameConfig().setHeight(0);
        this.iFrame.getIFrameConfig().setScroll("auto");
        this.AddControl((SRFExControl)this.iFrame);
    }
}

