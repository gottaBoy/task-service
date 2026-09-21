/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DataGridEx
 *  SA.SRFDA.Ctrl.Data.SearchForm
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DGEx.SRFExDGEx
 *  SA.SRFramework.WebEx.DGEx.SRFExDGExRowCountList
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.DataGridEx;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.ViewModel.GridViewExModel;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.ViewModel.DGExModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFDA.Web.ViewModel.SPExModel;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DGEx.SRFExDGEx;
import SA.SRFramework.WebEx.DGEx.SRFExDGExRowCountList;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig;
import net.sf.json.JSONObject;

public class GridViewExPage
extends BaseMainPage {
    protected String strDataGridExId = "";
    protected SRFExToolbar toolbar = null;
    protected DataGridEx dataGridEx = null;
    protected SRFExDGExRowCountList dgExRowCountList = null;
    protected SRFExSPEx spEx = null;
    protected SRFExDGEx dgEx = null;
    protected boolean bIfView = false;
    protected boolean bSPCustomSearch = false;
    protected boolean bRenderSP = true;
    protected boolean bInfoMode = false;
    protected SearchForm searchForm = null;
    private String strToolbarConfigId = "";
    private String strSPExConfigId = "";
    private String strDGExConfigId = "";
    protected String strFormTag = "";
    protected GridViewExModel gridViewExModel = null;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.GetDefaultPageDataEntityId();
        if (!this.OnGetGridViewEx()) {
            return false;
        }
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        this.setPageParam("GRIDVIEWEX", this.dataGridEx);
        this.bIfView = StringHelper.Compare((String)this.getWebContext().GetParamValue("SRFIFVIEW"), (String)"TRUE", (boolean)true) == 0;
        this.bRenderSP = this.OnGetRenderSP();
        this.bSPCustomSearch = !this.bRenderSP ? false : this.OnGetSPExCustomSearch();
        return true;
    }

    @Override
    protected PageModel CreatePageModel() {
        return new GridViewExModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.gridViewExModel = (GridViewExModel)this.pageModel;
    }

    protected boolean OnGetRenderSP() {
        return this.getPageParam("PAGE.SP.RENDER", true);
    }

    protected boolean OnGetGridViewEx() {
        this.strDataGridExId = this.OnGetDataGridEx();
        if (!StringHelper.IsNullOrEmpty((String)this.strDataGridExId)) {
            this.dataGridEx = this.getWebContext().GetConfigCache().GetDEDataGridEx(this.getWebContext(), this.strDataGridExId);
            if (this.dataGridEx == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u6269\u5c55\u89c6\u56fe[%1$s]", (Object)this.strDataGridExId));
                return false;
            }
            this.strPageDataEntityId = this.dataGridEx.getDEID();
        }
        return true;
    }

    protected String OnGetDataGridEx() {
        return SRFDAWebCTXHelper.GetSRFGridViewEx((ISRFDAWebContext)this.getWebContext());
    }

    @Override
    protected String OnGetPageCaption() {
        String strGridCaption = this.getWebContext().GetParamValue("SRFCAPTION");
        if (!StringHelper.IsNullOrEmpty((String)strGridCaption)) {
            return strGridCaption;
        }
        return super.OnGetPageCaption();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadSPEx();
        this.LoadDGEx();
        this.LoadToolbar();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
        this.RegisterDGExActionHelper(this.dgEx.getUniqueID(), this.GetDGExActionHelper());
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        JSONObject params = new JSONObject();
        params.put("deid", (Object)this.getPageDataEntityId());
        if (this.spEx != null) {
            params.put("spid", (Object)this.spEx.getUniqueID());
            params.put("spcs", this.bSPCustomSearch);
        }
        script.Append("$P.mainview=new SRFDA.GridViewEx(%1$s);", (Object)params.toString());
        this.RegisterOnReadyScript(3, script.toString());
        if (this.getDefaultForm() != null) {
            this.RegisterOnReadyScript(3, FormJSHelper.getLoadDefaultScript((SRFExForm)((SRFExSearchForm)this.getDefaultForm())));
        }
    }

    protected String GetSearchFormActionHelper() {
        String strSearchFormActionHelper = this.getPageParam("PAGE.SPACTIONHELPER", "");
        if (StringHelper.IsNullOrEmpty((String)strSearchFormActionHelper)) {
            if (this.searchForm != null && !StringHelper.IsNullOrEmpty((String)(strSearchFormActionHelper = this.searchForm.getBACKENDCTRL()))) {
                return strSearchFormActionHelper;
            }
            strSearchFormActionHelper = BaseDASearchFormActionHelper.class.getName();
        }
        return strSearchFormActionHelper;
    }

    protected String GetDGExActionHelper() {
        if (!StringHelper.IsNullOrEmpty((String)this.dataGridEx.getBACKENDCTRL())) {
            return this.dataGridEx.getBACKENDCTRL();
        }
        String strDGActionHelper = this.getPageParam("PAGE.DGEXACTIONHELPER", "");
        if (!StringHelper.IsNullOrEmpty((String)strDGActionHelper)) {
            return strDGActionHelper;
        }
        return this.GetDefaultDGExActionHelper();
    }

    protected String GetDefaultDGExActionHelper() {
        return GridViewExPage.GetDefaultDGExActionHelper(this.getDEHelper(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }

    public static String GetDefaultDGExActionHelper(IDEHelper iDEHelper, ISRFDAGlobalHelper globalHelper) {
        String strDGActionHelper;
        if (iDEHelper != null && !StringHelper.IsNullOrEmpty((String)iDEHelper.GetDBStorage()) && !StringHelper.IsNullOrEmpty((String)(strDGActionHelper = globalHelper.getDAModelStorage().FindDBStorage(iDEHelper.GetDBStorage()).GetProperty("DGEXACTIONHELPER")))) {
            return strDGActionHelper;
        }
        return globalHelper.getWebExConfig().GetValue("SRFDA", "DGEXACTIONHELPER", "");
    }

    protected String OnGetDGExConfigId() {
        String strDGExConfig = this.getPageParam("PAGE.DATAGRIDEX", "");
        if (!StringHelper.IsNullOrEmpty((String)strDGExConfig)) {
            return strDGExConfig;
        }
        return this.getDAConfigHelper().GetGridViewExDGExId(this.getDEHelper(), this.page, this.dataGridEx);
    }

    protected void LoadToolbar() {
        if (!this.IsBackEndMode()) {
            this.strToolbarConfigId = this.OnGetDataGridExToolbarConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strToolbarConfigId)) {
                return;
            }
        }
        this.toolbar = GridViewExPage.CreateToolbar(this, "toolBar", 0.0, 0.0, this.strToolbarConfigId);
        if (this.toolbar != null && !this.IsBackEndMode()) {
            this.toolbar.getToolbarConfig().setCssClass("sx-toolbarnobg");
            if (this.dgEx != null) {
                this.toolbar.setToolbarObject("DGEX", (Object)this.dgEx);
                this.toolbar.setToolbarObject("", (Object)this.dgEx);
            }
            this.toolbar.setToolbarObject("SPEX", (Object)this.spEx);
        }
        if (this.gridViewExModel != null && this.gridViewExModel.getToolbarModel() != null) {
            this.gridViewExModel.getToolbarModel().setCtrlId("toolBar");
            this.gridViewExModel.getToolbarModel().setConfigId(this.strToolbarConfigId);
            this.gridViewExModel.getToolbarModel().setRemoteCtrlId(this.toolbar.getUniqueID());
        }
    }

    protected String OnGetDataGridExToolbarConfigId() {
        if (this.IsContainPageParam("PAGE.TOOLBAR")) {
            return this.getPageParam("PAGE.TOOLBAR", "");
        }
        return this.getDAConfigHelper().GetGridViewExToolbarConfigId(this.getDEHelper(), this.page, this.dataGridEx, null);
    }

    protected void LoadSPEx() {
        if (this.bRenderSP) {
            this.strSPExConfigId = this.OnGetSPExConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strSPExConfigId)) {
                return;
            }
            this.spEx = GridViewExPage.CreateSPEx(this, "spEx", this.strSPExConfigId);
            if (this.spEx != null) {
                if (this.bSPCustomSearch) {
                    this.spEx.getSPExConfig().setCustomSearch(true);
                    this.spEx.getSPExConfig().setCustomSearchJSFunc("spcustomsearch");
                }
                this.spEx.getSearchForm().setFormTag(this.strFormTag);
                this.spEx.getSPExConfig().setSaveLoad(true);
                this.spEx.getSPExConfig().setWidth(1024);
                if (this.gridViewExModel != null && this.gridViewExModel.getSPExModel() != null) {
                    SPExModel spExModel = this.gridViewExModel.getSPExModel();
                    spExModel.setCtrlId("spEx");
                    spExModel.setConfigId(this.strSPExConfigId);
                    spExModel.setRemoteCtrlId(this.spEx.getUniqueID());
                    spExModel.setItemPrivilege(false);
                    spExModel.setCustomSearch(this.bSPCustomSearch);
                    spExModel.setSaveLoadTag(this.strFormTag);
                }
                if (this.gridViewExModel != null && this.gridViewExModel.getSearchFormModel() != null) {
                    this.gridViewExModel.getSearchFormModel().setRemoteCtrlId(this.getDefaultFormId());
                }
            }
        }
    }

    protected void LoadDGEx() {
        this.strDGExConfigId = this.OnGetDGExConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strDGExConfigId)) {
            return;
        }
        this.dgEx = GridViewExPage.CreateDGEx(this, "dgEx", 0.0, 0.0, this.strDGExConfigId);
        if (this.dgEx != null) {
            this.LoadDGExRowCountList();
            if (!this.IsBackEndMode()) {
                int nInterval;
                if (this.bRenderSP) {
                    this.spEx.getSearchForm().setUserParamsName(StringHelper.Format((String)"$P.store['%1$s'].userparams", (Object)this.dgEx.getUniqueID()));
                    this.spEx.getSearchForm().getSearchAction().getSuccessAction().RegisterProcessCode(0, StringHelper.Format((String)"$P.store['%1$s'].loaddefault();", (Object)this.dgEx.getUniqueID()));
                }
                StringBuilderEx script = new StringBuilderEx();
                String strBeforeLoadDefault = this.getPageParam("PAGE.BEFORELOADDEFAULT", "");
                if (!StringHelper.IsNullOrEmpty((String)strBeforeLoadDefault)) {
                    script.Append(strBeforeLoadDefault);
                }
                if (this.OnGetDataGridAutoLoad()) {
                    script.Append("$P.store['%1$s'].loaddefault();", (Object)this.dgEx.getUniqueID());
                }
                if ((nInterval = this.OnGetDataGridRefresh()) > 0) {
                    script.Append("$P.grid['%1$s'].gridmgr._INTERVAL=window.setInterval(\"$P.store['%1$s'].reload();\",%2$s);", (Object)this.dgEx.getUniqueID(), (Object)nInterval);
                }
                this.RegisterOnReadyScript(3, script.toString());
            }
            if (this.gridViewExModel != null && this.gridViewExModel.getDGExModel() != null) {
                DGExModel dgExModel = this.gridViewExModel.getDGExModel();
                dgExModel.setCtrlId("dataGridEx");
                dgExModel.setConfigId(this.strDGExConfigId);
                dgExModel.setRemoteCtrlId(this.dgEx.getUniqueID());
            }
        }
    }

    protected void LoadDGExRowCountList() {
        this.dgExRowCountList = GridViewExPage.CreateDGExRowCountList(this, "dgExRowCountList", 50);
        if (this.dgExRowCountList != null && this.dgEx != null) {
            this.dgExRowCountList.getDGExRowCountListConfig().setDGExId(this.dgEx.getUniqueID());
            this.dgExRowCountList.getDGExRowCountListConfig().setActivePageSize(this.dgEx.getDGExConfig().getPagingToolbarConfig().getPageSize());
        }
    }

    protected boolean OnGetSPExCustomSearch() {
        if (this.IsContainPageParam("PAGE.SP.CUSTOMSEARCH")) {
            return StringHelper.Compare((String)this.getPageParam("PAGE.SP.CUSTOMSEARCH", "FALSE"), (String)"TRUE", (boolean)true) == 0;
        }
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "SPCUSTOMSEARCH", false);
    }

    protected String OnGetSPExConfigId() {
        String strSPExConfigId = this.getPageParam("PAGE.SP", "");
        if (!StringHelper.IsNullOrEmpty((String)strSPExConfigId)) {
            this.strFormTag = strSPExConfigId;
            return strSPExConfigId;
        }
        boolean bDefaultSF = false;
        String strSearchformId = this.getPageParam("PAGE.SEARCHFORM", "");
        if (StringHelper.IsNullOrEmpty((String)strSearchformId) && this.getWebContext().getWebExConfig().GetValue("SRFDA", "DEFAULTSEARCHFORM", false)) {
            bDefaultSF = true;
            strSearchformId = StringHelper.Format((String)"%1$s_DEFAULTSF", (Object)this.getDEHelper().getId());
        }
        if (!StringHelper.IsNullOrEmpty((String)strSearchformId)) {
            this.searchForm = this.getWebContext().GetConfigCache().GetDESearchForm(this.getWebContext(), strSearchformId, bDefaultSF);
            if (this.searchForm != null) {
                this.strFormTag = strSearchformId;
                return this.getDAConfigHelper().GetSPExConfigId(this.getDEHelper(), this.searchForm);
            }
            if (!bDefaultSF) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u641c\u7d22\u8868\u5355[%1$s]", (Object)strSearchformId));
                return "";
            }
        }
        this.strFormTag = "DEDEFAULT";
        return this.getDAConfigHelper().GetGridViewExSPExConfigId(this.getDEHelper(), this.dataGridEx);
    }

    public boolean IsIfView() {
        return this.bIfView;
    }

    public int GetCaptionWidth() {
        return this.OnGetCaptionWidth();
    }

    protected int OnGetCaptionWidth() {
        return this.getPageParam("PAGE.CAPTIONWIDTH", 60);
    }

    public boolean IsRenderCaption() {
        if (this.bIfView) {
            return false;
        }
        if (this.IsContainPageParam("PAGE.CAPTION")) {
            return this.getPageParam("PAGE.CAPTION", false);
        }
        String strShowCap = this.getWebContext().GetParamValue("SRFSHOWCAP");
        if (!StringHelper.IsNullOrEmpty((String)strShowCap)) {
            return StringHelper.Compare((String)strShowCap, (String)"TRUE", (boolean)true) == 0;
        }
        return !StringHelper.IsNullOrEmpty((String)this.getWebContext().GetParamValue("SRFCAPTION"));
    }

    public String GetLoadGridCode() {
        StringBuilderEx script = new StringBuilderEx();
        String strSummaryKey = this.getWebContext().GetParamValue("SRFSUMMARYKEY");
        if (StringHelper.IsNullOrEmpty((String)strSummaryKey)) {
            return "";
        }
        script.Append("var _V=$V(_1.%1$s,'');", (Object)strSummaryKey);
        script.Append("var _2={'%1$s':_V};", (Object)this.getWebContext().GetParamValue("SRFSUMMARYKEY").toLowerCase());
        script.Append("$P.maingrid._summarykey=_2;");
        script.Append("reloadgrid(_2);");
        return script.toString();
    }

    protected boolean OnGetDataGridAutoLoad() {
        if (this.IsContainPageParam("PAGE.DATAGRID.AUTOLOAD")) {
            return StringHelper.Compare((String)this.getPageParam("PAGE.DATAGRID.AUTOLOAD", "TRUE"), (String)"TRUE", (boolean)true) == 0;
        }
        return this.getWebContext().GetSRFDGAutoLoad();
    }

    protected int OnGetDataGridRefresh() {
        if (this.IsContainPageParam("PAGE.DATAGRID.REFRESH")) {
            return this.getPageParam("PAGE.DATAGRID.REFRESH", 0);
        }
        return 0;
    }

    protected boolean OnGetSPAutoExpand() {
        return StringHelper.Compare((String)this.getPageParam("PAGE.SP.AUTOEXPAND", "FALSE"), (String)"TRUE", (boolean)true) == 0;
    }

    public String GetAfterOnReadyCode() {
        StringBuilderEx script = new StringBuilderEx();
        this.OnGetAfterOnReadyCode(script);
        return script.toString();
    }

    protected void OnGetAfterOnReadyCode(StringBuilderEx script) {
        BaseToolbarItemConfig filterTBBConfig;
        if (this.bRenderSP & this.OnGetSPAutoExpand() && this.toolbar != null && (filterTBBConfig = this.toolbar.getToolbarConfig().getToolbarItemsConfig().FindToolbarItemConfig("TBB_FILTER")) != null) {
            script.Append(StringHelper.Format((String)"$P.toolbar['%1$s'].items.get('%2$s').toggle(showhidesp());", (Object)this.toolbar.getUniqueID(), (Object)"TBB_FILTER"));
        }
    }

    public String GetSPExDPUniqueId() {
        return this.spEx.getPanel().getUniqueID();
    }

    public boolean IsRenderSP() {
        return this.bRenderSP;
    }

    @Override
    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.GRIDVIEW", "\u8868\u683c\u89c6\u56fe");
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.gridViewExModel.setGridViewExId(this.strDataGridExId);
        this.gridViewExModel.setSPExpand(this.OnGetSPAutoExpand());
        this.gridViewExModel.setDGAutoLoad(this.OnGetDataGridAutoLoad());
        return true;
    }
}

