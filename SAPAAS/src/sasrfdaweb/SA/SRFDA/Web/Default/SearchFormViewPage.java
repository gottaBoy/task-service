/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.SearchForm
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;

public class SearchFormViewPage
extends BaseMainPage {
    protected SRFExSPEx spEx = null;
    protected String strSPExConfigId = "";

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadSPEx();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
    }

    protected String GetSearchFormActionHelper() {
        String strSearchFormActionHelper = this.getPageParam("PAGE.SPACTIONHELPER", "");
        if (StringHelper.IsNullOrEmpty((String)strSearchFormActionHelper)) {
            strSearchFormActionHelper = BaseDASearchFormActionHelper.class.getName();
        }
        return strSearchFormActionHelper;
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        if (this.spEx != null) {
            this.spEx.getSearchForm().setUserParamsName(StringHelper.Format((String)"varSearchParam"));
            this.spEx.getSearchForm().getSearchAction().getSuccessAction().RegisterProcessCode(0, StringHelper.Format((String)"spsearchback();"));
        }
        if (this.getDefaultForm() != null) {
            this.RegisterOnReadyScript(3, FormJSHelper.getLoadDefaultScript((SRFExForm)((SRFExSearchForm)this.getDefaultForm())));
        }
    }

    public String RenderPanel() {
        String strOutput = "";
        if (this.spEx != null) {
            strOutput = String.valueOf(strOutput) + PageRender.RenderLoadingIndicator(String.valueOf(this.getDefaultFormId()) + "_indicator");
            strOutput = String.valueOf(strOutput) + this.Render("spEx");
        }
        return strOutput;
    }

    protected String OnGetSPExConfigId() {
        String strSPExConfigId = this.getPageParam("PAGE.SP", "");
        if (!StringHelper.IsNullOrEmpty((String)strSPExConfigId)) {
            return strSPExConfigId;
        }
        String strSearchformId = this.getPageParam("PAGE.SEARCHFORM", "");
        if (StringHelper.IsNullOrEmpty((String)strSearchformId)) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u5f53\u524d\u9875\u9762\u6ca1\u6709\u6307\u5b9a\u641c\u7d22\u8868\u5355]", (Object)strSearchformId));
            return "";
        }
        SearchForm searchForm = this.getWebContext().GetConfigCache().GetDESearchForm(this.getWebContext(), strSearchformId, false);
        if (searchForm != null) {
            return this.getDAConfigHelper().GetSPExConfigId(this.getDEHelper(), searchForm);
        }
        this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u641c\u7d22\u8868\u5355[%1$s]", (Object)strSearchformId));
        return "";
    }

    public String RenderErrorPanel() {
        String strOutput = "";
        if (this.spEx != null) {
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<div class=\"sx-errorpanel\" id=\"%1$s_errorindicator\" style=\"width:100%%;height:150px;display:none;overflow:auto;\"></div>", (Object)this.getDefaultFormId());
        }
        return strOutput;
    }

    protected void LoadSPEx() {
        this.strSPExConfigId = this.OnGetSPExConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strSPExConfigId)) {
            this.PageLog(this, 1, "\u6ca1\u6709\u6307\u5b9a\u641c\u7d22\u9762\u677f\u914d\u7f6e");
            return;
        }
        this.spEx = SearchFormViewPage.CreateSPEx(this, "spEx", this.strSPExConfigId);
        if (this.spEx != null) {
            this.spEx.getSPExConfig().setWidth(1024);
        }
    }

    public String GetSearchRedirectPage() {
        String strSearchRedirectPage = this.OnGetSearchRedirectPage();
        if (StringHelper.IsNullOrEmpty((String)strSearchRedirectPage)) {
            return "";
        }
        strSearchRedirectPage = URLHelper.AppendURLSeperator((String)strSearchRedirectPage);
        strSearchRedirectPage = String.valueOf(strSearchRedirectPage) + this.getWebContext().GetQueryStringWithout(SRFDAWebContext.getDAParams());
        return strSearchRedirectPage;
    }

    protected String OnGetSearchRedirectPage() {
        String strSearchRedirectPage = this.getPageParam("PAGE.SEARCHREDIRECTPAGE", "");
        if (StringHelper.IsNullOrEmpty((String)strSearchRedirectPage)) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49\u641c\u7d22\u91cd\u5b9a\u5411\u9875\u9762", (Object)strSearchRedirectPage));
            return "";
        }
        Page page = this.getDAModelStorage().FindPage(strSearchRedirectPage);
        if (page == null) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]", (Object)strSearchRedirectPage));
            return "";
        }
        return page.GetTotalPagePath();
    }
}

