/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DER11
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERGroup
 *  SA.SRFDA.Ctrl.Data.DERGroupDetail
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.PP.PPGridView
 *  SA.SRFDA.Ctrl.Data.PP.PPSearchForm
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.SearchForm
 *  SA.SRFDA.Ctrl.Data.SummaryPage
 *  SA.SRFDA.Ctrl.Data.UserDGTheme
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Security.UniResHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.UIGear.IUIGear
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExDataGridRowActionList
 *  SA.SRFramework.WebEx.SRFExDataGridRowCountList
 *  SA.SRFramework.WebEx.SRFExDataGridThemeList
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.Script.StoreJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig
 *  SA.SRFramework.WebEx.UI.DataGridColumnConfig
 *  SA.SRFramework.WebEx.UI.DataGridThemeConfig
 *  SA.SRFramework.WebEx.UI.DataGridThemeGroupConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Config.GridViewToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERGroup;
import SA.SRFDA.Ctrl.Data.DERGroupDetail;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.PP.PPGridView;
import SA.SRFDA.Ctrl.Data.PP.PPSearchForm;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.Data.SummaryPage;
import SA.SRFDA.Ctrl.Data.UserDGTheme;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Security.UniResHelper;
import SA.SRFDA.Web.Default.BaseGridViewPage;
import SA.SRFDA.Web.Default.ViewModel.GridViewModel;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.JSGear.DataGridNewEditJSGear;
import SA.SRFDA.Web.JSGear.IDataGridNewEditJSUIGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.UIGear.IUIGear;
import SA.SRFDA.Web.Utility.DataGridNewEditPageHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.ViewModel.DGModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFDA.Web.ViewModel.SPExModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDataGridRowActionList;
import SA.SRFramework.WebEx.SRFExDataGridRowCountList;
import SA.SRFramework.WebEx.SRFExDataGridThemeList;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.Script.StoreJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnConfig;
import SA.SRFramework.WebEx.UI.DataGridThemeConfig;
import SA.SRFramework.WebEx.UI.DataGridThemeGroupConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;

public class GridViewPage
extends BaseGridViewPage {
    protected String strGridViewId = "";
    protected SRFExDataGridThemeList dataGridThemeList = null;
    protected SRFExToolbar toolbar = null;
    protected DataGrid gridView = null;
    protected SRFExSPEx spEx = null;
    protected SRFExDataGridRowActionList dataGridRowActionList = null;
    protected SRFExDataGridRowCountList dataGridRowCountList = null;
    protected SRFExDataGrid dataGrid = null;
    protected boolean bIfGridView = false;
    protected boolean bGVTheme = true;
    protected String strSummaryMode = "";
    protected Vector<DataGrid> list = null;
    protected boolean bSPCustomSearch = false;
    protected boolean bRenderSP = true;
    protected SRFExDropDownList ddlSummaryArea = null;
    protected SRFExDropDownList ddlSummaryPage = null;
    protected boolean bEnableDGEdit = true;
    protected boolean bInfoMode = false;
    protected boolean bPickupMode = false;
    protected String strDGMode = "";
    protected boolean bCustomTheme = true;
    protected boolean bEmbedMode = false;
    protected String strSummaryURL = "";
    private String strToolbarConfigId = "";
    private String strSPExConfigId = "";
    private String strDataGridConfigId = "";
    protected JSONObject newPageInfo = null;
    protected JSONObject editPageInfo = null;
    protected String strDGHideDERColumnName = "";
    protected String strFormTag = "";
    protected SearchForm searchForm = null;
    public static final String PPCTRLID_SPEX = "SPEX";
    protected PPSearchForm ppSearchForm = null;
    protected GridViewModel gridViewModel = null;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.GetDefaultPageDataEntityId();
        this.strDGMode = this.OnGetDataGridMode();
        if (!this.OnGetDataGrid()) {
            return false;
        }
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        this.setPageParam("GRIDVIEW", this.gridView);
        this.setPageParam("DATAGRID", this.gridView);
        this.bEmbedMode = this.OnGetEmbedMode();
        this.bInfoMode = this.OnGetGridViewInfoMode();
        boolean bl = this.bIfGridView = StringHelper.Compare((String)this.getWebContext().GetParamValue("SRFIFVIEW"), (String)"TRUE", (boolean)true) == 0;
        if (!this.bEmbedMode) {
            this.strSummaryMode = this.OnGetSummaryMode();
            this.bGVTheme = this.OnGetGVTheme();
            this.bRenderSP = this.OnGetRenderSP();
            this.bSPCustomSearch = !this.bRenderSP ? false : this.OnGetSPExCustomSearch();
            this.bCustomTheme = this.OnGetDataGridCustomTheme();
        } else {
            this.bRenderSP = false;
            this.strSummaryMode = "";
            this.bGVTheme = false;
            this.bSPCustomSearch = false;
            this.bSPCustomSearch = false;
        }
        this.bEnableDGEdit = this.OnGetDataGridEditable();
        this.bPickupMode = this.OnGetPickupMode();
        this.setPageParam("PICKUPMODE", this.bPickupMode);
        return true;
    }

    @Override
    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam(PPCTRLID_SPEX, "PP_SEARCHFORM")) != null && pageParam instanceof PPSearchForm) {
            this.ppSearchForm = (PPSearchForm)pageParam;
        }
    }

    @Override
    protected PageModel CreatePageModel() {
        return new GridViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.gridViewModel = (GridViewModel)this.pageModel;
    }

    protected boolean OnGetRenderSP() {
        boolean bRenderSP = true;
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("RENDERSP")) {
            bRenderSP = this.ppGridView.getRENDERSP();
        }
        return this.getPageParam("PAGE.SP.RENDER", bRenderSP);
    }

    protected String OnGetSummaryMode() {
        String strSummaryMode = this.getWebContext().getSRFGVSMode();
        if (StringHelper.IsNullOrEmpty((String)strSummaryMode)) {
            if (this.ppGridView != null) {
                strSummaryMode = this.ppGridView.getSUMMARYAREA();
            }
            strSummaryMode = this.getPageParam("PAGE.SUMMARY", strSummaryMode);
        }
        return strSummaryMode;
    }

    protected boolean OnGetDataGridEditable() {
        boolean bEnableDGEdit = this.getWebContext().getWebExConfig().GetValue("SRFDA", "DGEDITABLEDEFAULT", true);
        if (!this.getDEHelper().getDataEntity().IsParamNull("ISDGROWEDIT")) {
            bEnableDGEdit = this.getDEHelper().getDataEntity().getISDGROWEDIT();
        }
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("ENABLEROWEDIT")) {
            bEnableDGEdit = this.ppGridView.getENABLEROWEDIT();
        }
        return this.getPageParam("PAGE.DATAGRID.EDITABLE", bEnableDGEdit);
    }

    protected boolean OnGetEmbedMode() {
        return SRFDAWebCTXHelper.IsEmbedMode((ISRFDAWebContext)this.getWebContext(), (boolean)this.bEmbedMode);
    }

    protected boolean OnGetQuickSearch() {
        return this.getPageParam("PAGE.QUICKSEARCH", !this.bPickupMode && this.getDEHelper().IsEnableQuickSearch());
    }

    protected boolean OnGetDataGrid() {
        this.strGridViewId = this.OnGetGridView();
        if (!StringHelper.IsNullOrEmpty((String)this.strGridViewId)) {
            this.gridView = this.getWebContext().GetConfigCache().GetUserDEDataGrid(this.getWebContext(), this.strGridViewId);
            if (this.gridView == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe[%1$s]", (Object)this.strGridViewId));
                return false;
            }
            this.strPageDataEntityId = this.gridView.getDEID();
        } else {
            if (this.bPickupMode) {
                CallResult callResult = this.getDAModelHelper().GetDefaultPickupDEDataGrid(this.strPageDataEntityId, this.gridView, this.strDGMode);
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.PageLog(this, "\u83b7\u53d6\u5b9e\u4f53\u62fe\u53d6\u8868\u683c\u89c6\u56fe\u5931\u8d25", callResult);
                    return false;
                }
            } else {
                this.list = new Vector();
                CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetUserDEDataGrids(this.getWebContext().getCurUserId(), this.getPageDataEntityId(), this.strDGMode, this.list);
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.PageLog(this, "\u83b7\u53d6\u5b9e\u4f53\u9ed8\u8ba4\u8868\u683c\u89c6\u56fe\u5931\u8d25", callResult);
                    return false;
                }
                Iterator<DataGrid> iterator = this.list.iterator();
                if (iterator.hasNext()) {
                    DataGrid dataGrid;
                    this.gridView = dataGrid = iterator.next();
                }
                if (this.gridView == null) {
                    this.PageLog(this, "\u6ca1\u6709\u83b7\u53d6\u5230\u7b26\u5408\u8981\u6c42\u7684\u6570\u636e\u8868\u683c", callResult);
                    return false;
                }
            }
            this.strGridViewId = this.gridView.getDATAGRIDID();
            this.getWebContext().SetParamValue("SRFGRIDVIEW", this.strGridViewId);
        }
        return true;
    }

    protected String OnGetGridView() {
        String strDataGridId = this.getWebContext().getSRFGridView();
        if (!StringHelper.IsNullOrEmpty((String)strDataGridId)) {
            return strDataGridId;
        }
        if (this.ppDataGrid != null) {
            return this.ppDataGrid.getDATAGRIDID();
        }
        return "";
    }

    protected boolean OnGetGVTheme() {
        String strParamValue = this.getWebContext().GetParamValue("SRFGVTHEME");
        if (!StringHelper.IsNullOrEmpty((String)strParamValue)) {
            return StringHelper.Compare((String)this.getWebContext().GetParamValue("SRFGVTHEME"), (String)"FALSE", (boolean)true) != 0;
        }
        boolean bDGTheme = true;
        bDGTheme = this.getWebContext().getWebExConfig().GetValue("SRFDA.GRIDVIEW", "DGTHEME", bDGTheme);
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("CUSTOMTHEME")) {
            bDGTheme = this.ppGridView.getCUSTOMTHEME();
        }
        return this.getPageParam("PAGE.DGTHEME", bDGTheme);
    }

    @Override
    protected String OnGetPageCaption() {
        String strGridCaption = this.getWebContext().GetParamValue("SRFCAPTION");
        if (!StringHelper.IsNullOrEmpty((String)strGridCaption)) {
            return strGridCaption;
        }
        if (this.ppGridView != null && !StringHelper.IsNullOrEmpty((String)(strGridCaption = this.ppGridView.getCAPTION()))) {
            return strGridCaption;
        }
        return super.OnGetPageCaption();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadDataGridThemeList();
        this.LoadSPEx();
        this.LoadDataGrid();
        this.LoadToolbar();
        if (this.IsRenderCustomSummaryArea()) {
            this.LoadSummaryAreaList();
        }
        if (this.IsRightSummary() || this.IsBottomSummary()) {
            if (this.IsRenderSummaryPageList()) {
                this.LoadSummaryPageList();
            } else if (!this.IsBackEndMode()) {
                this.strSummaryURL = this.OnGetSummaryURL();
                if (!StringHelper.IsNullOrEmpty((String)this.strSummaryURL)) {
                    StringBuilderEx script = new StringBuilderEx();
                    script.Append("Ext.getDom('if_summary').src ='%1$s';", (Object)this.strSummaryURL);
                    this.RegisterOnReadyScript(3, script.toString());
                }
            }
        }
    }

    protected String OnGetSummaryURL() {
        String strSummaryURL = this.getPageParam("PAGE.SUMMARYURL", "");
        if (StringHelper.IsNullOrEmpty((String)strSummaryURL)) {
            String strPage;
            String strSummaryPageId = "";
            if (this.ppGridView != null) {
                strSummaryPageId = this.ppGridView.getSUMMARYPAGEID();
            }
            if (!StringHelper.IsNullOrEmpty((String)(strPage = this.getPageParam("PAGE.SUMMARYPAGE", strSummaryPageId)))) {
                Page page = this.getDAModelStorage().FindPage(strPage);
                if (page == null) {
                    String strErrorInfo = StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u914d\u7f6e\u4fe1\u606f");
                    this.PageLog(this, 1, strErrorInfo);
                    return "";
                }
                strSummaryURL = page.GetTotalPagePath();
            }
        }
        return strSummaryURL;
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
        this.RegisterDataGridActionHelper(this.dataGrid.getUniqueID(), this.GetDataGridActionHelper());
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        JSONObject params = new JSONObject();
        params.put("deid", (Object)this.getPageDataEntityId());
        params.put("dgmode", (Object)this.strDGMode);
        if (this.spEx != null) {
            params.put("spid", (Object)this.spEx.getUniqueID());
            params.put("spcs", this.bSPCustomSearch);
        }
        script.Append("$P.mainview=new SRFDA.GridView(%1$s);", (Object)params.toString());
        this.RegisterOnReadyScript(3, script.toString());
        if (this.IsLoadDataGridNewEditJSGear()) {
            boolean bDGNew = true;
            boolean bDGEdit = true;
            boolean bDGDBClkEdit = true;
            if (this.isEnableDEMainState()) {
                bDGNew = this.getDEMainState().isEnableUserCreate();
                boolean bl = bDGEdit = this.getDEMainState().isEnableUserUpdate() || this.getDEMainState().isEnableUserView();
                if (!bDGEdit) {
                    bDGDBClkEdit = bDGEdit;
                }
            }
            this.LoadDataGridNewEditGear(bDGNew, bDGEdit, bDGDBClkEdit);
        }
        if (this.ddlSummaryPage != null || !StringHelper.IsNullOrEmpty((String)this.strSummaryURL)) {
            script.Reset();
            script.Append("$P.summarykey=%1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)this.dataGrid.getUniqueID()));
            script.Append("var ifr=Ext.getDom('if_summary');\r\n");
            script.Append("if(ifr==null)return;");
            if (this.ddlSummaryPage != null) {
                script.Append("var _URL=Ext.getDom('%1$s').value;\r\n", (Object)this.ddlSummaryPage.getUniqueID());
            } else {
                script.Append("var _URL='%1$s';\r\n", (Object)this.strSummaryURL);
            }
            script.Append("if(_URL=='')return;");
            script.Append("ifr.style.display='';");
            script.Append("var _W=ifr.contentWindow;");
            script.Append("if(_W.$P.maskhelper){_W.$P.maskhelper.unmask();}");
            script.Append("if(_W.setsummarykey){_W.setsummarykey(%1$s);}\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)this.dataGrid.getUniqueID()));
            String strScript = script.toString();
            script.Reset();
            script.Append(DataGridJSHelper.getOnRowSelectedEventScript((String)this.dataGrid.getUniqueID(), (String)strScript));
            this.RegisterOnReadyScript(3, script.toString());
            script.Reset();
            script.Append("$P.summarykey=null;\r\n");
            script.Append("var ifr=Ext.getDom('if_summary');\r\n");
            script.Append("if(ifr==null)return;");
            script.Append("var _W=ifr.contentWindow;if(_W==null)return;");
            script.Append("if(_W.$P&&_W.$P.maskhelper){_W.$P.maskhelper.maskinfo('%1$s');}else{ifr.style.display='none';}", (Object)this.GetLocalization("PAGE.COMMON.GRIDVIEW.SUMMARY.UNSELECTINFO", "\u8bf7\u9009\u4e2d\u8868\u683c\u6570\u636e"));
            strScript = script.toString();
            script.Append(DataGridJSHelper.getOnRowSelectedCancelEventScript((String)this.dataGrid.getUniqueID(), (String)strScript));
            this.RegisterOnReadyScript(3, script.toString());
        }
        if (this.getDefaultForm() != null) {
            this.RegisterOnReadyScript(3, FormJSHelper.getLoadDefaultScript((SRFExForm)((SRFExSearchForm)this.getDefaultForm())));
        }
        if (this.IsRefreshPWFTree()) {
            script.Reset();
            script.Append("if(parent&&parent.refreshwftree){parent.refreshwftree();}");
            this.RegisterOnReadyScript(3, StoreJSHelper.getOnLoadEventScript((String)this.dataGrid.getUniqueID(), (String)script.toString()));
        }
        String strStoreLoadCode = "";
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("AFTERLDCODE")) {
            strStoreLoadCode = this.ppDataGrid.getAFTERLDCODE();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strStoreLoadCode = this.getPageParam("PAGE.DATAGRID.LOADEDCODE", strStoreLoadCode)))) {
            this.RegisterOnReadyScript(3, StoreJSHelper.getOnLoadEventScript((String)this.dataGrid.getUniqueID(), (String)strStoreLoadCode));
        }
    }

    protected void LoadDataGridNewEditGear(boolean bDGNew, boolean bDGEdit, boolean bDGDBClkEdit) {
        if (this.ppDataGrid != null) {
            if (!this.ppDataGrid.IsParamNull("ENABLENEW")) {
                bDGNew = this.ppDataGrid.getENABLENEW();
            }
            if (!this.ppDataGrid.IsParamNull("ENABLEEDIT")) {
                bDGEdit = this.ppDataGrid.getENABLEEDIT();
            }
            if (!this.ppDataGrid.IsParamNull("DGDBCLKEDIT")) {
                bDGDBClkEdit = this.ppDataGrid.getDGDBCLKEDIT();
            }
        }
        bDGNew = this.getPageParam("PAGE.DATAGRID.NEW", bDGNew);
        bDGEdit = this.getPageParam("PAGE.DATAGRID.EDIT", bDGEdit);
        bDGDBClkEdit = this.getPageParam("PAGE.DATAGRID.DBCLKEDIT", bDGDBClkEdit);
        if (this.bInfoMode) {
            bDGNew = false;
        }
        if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            if (this.ppDataGrid != null && !StringHelper.IsNullOrEmpty((String)this.ppDataGrid.getDGNEWEDITGEARID())) {
                IUIGear uiGear = this.getDAModelStorage().FindUIGear(this.ppDataGrid.getDGNEWEDITGEARID());
                if (uiGear == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u754c\u9762\u9a71\u52a8\u5f15\u64ce[%1$s]", (Object)this.ppDataGrid.getDGNEWEDITGEARID()));
                    return;
                }
                IDataGridNewEditJSUIGear jsUIGear = (IDataGridNewEditJSUIGear)uiGear;
                jsUIGear.Load(this, this.dataGrid, bDGNew, bDGEdit, bDGDBClkEdit, this.bInfoMode);
            } else {
                DataGridNewEditJSGear.Load(this, this.dataGrid, bDGNew, bDGEdit, bDGDBClkEdit, this.bInfoMode);
            }
        } else {
            if (bDGNew) {
                this.newPageInfo = new JSONObject();
            }
            if (bDGEdit) {
                this.editPageInfo = new JSONObject();
                this.editPageInfo.put("dbclkedit", bDGDBClkEdit);
            }
            DataGridNewEditPageHelper.Calc(this, this.dataGrid, this.newPageInfo, this.editPageInfo, this.bInfoMode);
        }
    }

    protected boolean IsRefreshPWFTree() {
        boolean bRefreshPTree = false;
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("REFRESHPTREE")) {
            bRefreshPTree = this.ppGridView.getREFRESHPTREE();
        }
        return this.getPageParam("PAGE.REFRESHPWFTREE", bRefreshPTree);
    }

    protected boolean IsLoadDataGridNewEditJSGear() {
        return this.getPageParam("PAGE.LOADDGNEWEDITJSGEAR", true);
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

    protected String GetDataGridActionHelper() {
        if (!StringHelper.IsNullOrEmpty((String)this.gridView.getBACKENDCTRL())) {
            return this.gridView.getBACKENDCTRL();
        }
        String strDGActionHelper = this.getPageParam("PAGE.DGACTIONHELPER", "");
        if (!StringHelper.IsNullOrEmpty((String)strDGActionHelper)) {
            return strDGActionHelper;
        }
        return this.GetDefaultDataGridActionHelper();
    }

    protected String GetDefaultDataGridActionHelper() {
        return GridViewPage.GetDefaultDataGridActionHelper(this.getDEHelper(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }

    public static String GetDefaultDataGridActionHelper(IDEHelper iDEHelper, ISRFDAGlobalHelper globalHelper) {
        String strDGActionHelper;
        if (iDEHelper != null && !StringHelper.IsNullOrEmpty((String)iDEHelper.GetDBStorage()) && !StringHelper.IsNullOrEmpty((String)(strDGActionHelper = globalHelper.getDAModelStorage().FindDBStorage(iDEHelper.GetDBStorage()).GetProperty("DGACTIONHELPER")))) {
            return strDGActionHelper;
        }
        return globalHelper.getWebExConfig().GetValue("SRFDA", "DGACTIONHELPER", "");
    }

    public String RenderDataGridTheme() {
        return this.OnRenderDataGridTheme();
    }

    protected String OnRenderDataGridTheme() {
        if (this.dataGridThemeList != null) {
            return this.Render("dataGridThemeList");
        }
        return "<span style='white-space: nowrap;' class='sx-bartext' >" + this.gridView.getDATAGRIDNAME() + "</span>";
    }

    protected void LoadDataGridThemeList() {
        if (this.bGVTheme) {
            this.dataGridThemeList = GridViewPage.CreateDataGridThemeList(this, "dataGridThemeList", 1);
            if (!this.IsBackEndMode()) {
                this.dataGridThemeList.getDataGridThemeListConfig().setCustomTheme(this.bCustomTheme);
                try {
                    if (this.list == null) {
                        this.list = new Vector();
                        CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetUserDEDataGrids(this.getWebContext().getCurUserId(), this.getPageDataEntityId(), this.strDGMode, this.list);
                        if ((callResult = CallResult.ToCallResult((CallResult)callResult)).IsError()) {
                            this.PageLog(this, 1, StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u5b9e\u4f53[%1$s]\u8868\u683c\u5931\u8d25\uff0c%2$s", (Object)this.getPageDataEntityId(), (Object)callResult.getErrorInfo()));
                            return;
                        }
                    }
                    DataGridThemeGroupConfig systemGroupConfig = new DataGridThemeGroupConfig();
                    systemGroupConfig.setGroupName(this.GetLocalization("PAGE.COMMON.GRIDVIEW.THEMELIST.SYSTEMVIEW", "\u7cfb\u7edf\u89c6\u56fe"));
                    this.dataGridThemeList.getDataGridThemeListConfig().GetDataGridThemeGroupsConfig().add((Object)systemGroupConfig);
                    DataGridThemeGroupConfig userGroupConfig = new DataGridThemeGroupConfig();
                    userGroupConfig.setGroupName(this.GetLocalization("PAGE.COMMON.GRIDVIEW.THEMELIST.USERVIEW", "\u6211\u7684\u89c6\u56fe"));
                    if (this.bCustomTheme) {
                        this.dataGridThemeList.getDataGridThemeListConfig().GetDataGridThemeGroupsConfig().add((Object)userGroupConfig);
                    }
                    for (DataGrid dataGrid : this.list) {
                        String strDataGridId = dataGrid.getDATAGRIDID();
                        DataGridThemeConfig dataGridThemeConfig = new DataGridThemeConfig();
                        dataGridThemeConfig.setThemeName(dataGrid.getDATAGRIDNAME());
                        String strURL = StringHelper.Format((String)"%1$s?%2$s&SRFGRIDVIEW=%3$s", (Object)this.getWebContext().getCurPageName(), (Object)this.getWebContext().GetQueryStringWithout("SRFGRIDVIEW"), (Object)dataGrid.getDATAGRIDID());
                        dataGridThemeConfig.setURL(strURL);
                        if (StringHelper.Compare((String)strDataGridId, (String)this.strGridViewId, (boolean)true) == 0) {
                            dataGridThemeConfig.setActive(true);
                        } else {
                            dataGridThemeConfig.setActive(false);
                        }
                        if (StringHelper.IsNullOrEmpty((String)dataGrid.getOWNERID())) {
                            systemGroupConfig.add((Object)dataGridThemeConfig);
                            continue;
                        }
                        if (this.bCustomTheme) {
                            userGroupConfig.add((Object)dataGridThemeConfig);
                            continue;
                        }
                        systemGroupConfig.add((Object)dataGridThemeConfig);
                    }
                    this.dataGridThemeList.getDataGridThemeListConfig().setMgrJSCode("$P.mainview.dgthememgr();");
                }
                catch (Exception ex) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u52a0\u8f7d\u7528\u6237\u8868\u683c\u4e3b\u9898\u5217\u8868\u53d1\u751f\u5f02\u5e38"), ex);
                }
            }
        }
    }

    protected void LoadSummaryAreaList() {
        this.ddlSummaryArea = new SRFExDropDownList();
        this.ddlSummaryArea.InitConfig();
        this.ddlSummaryArea.setID("ddlSummaryArea");
        this.ddlSummaryArea.getDropDownListConfig().setWidth(60);
        this.ddlSummaryArea.getDropDownListConfig().getListFillerConfig().setCodeList("SRFWEB.CODELIST_SUMMARYAREA");
        this.ddlSummaryArea.getDropDownListConfig().setSelectedValue(this.strSummaryMode);
        this.AddControl((SRFExControl)this.ddlSummaryArea);
        if (!this.IsBackEndMode()) {
            try {
                StringBuilderEx script = new StringBuilderEx();
                String strURL = StringHelper.Format((String)"%1$s?%2$s&SRFGVSMODE=", (Object)this.getWebContext().getCurPageName(), (Object)this.getWebContext().GetQueryStringWithout("SRFGVSMODE"));
                script.Append("var _1=Ext.getDom('%1$s').value;\r\n", (Object)this.ddlSummaryArea.getUniqueID());
                script.Append("window.location.href='%1$s'+_1;", (Object)strURL);
                this.getPage().RegisterOnReadyScript(3, StringHelper.Format((String)"Ext.get('%1$s').on('change',function(){%2$s});", (Object)this.ddlSummaryArea.getUniqueID(), (Object)script.toString()));
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void LoadSummaryPageList() {
        this.ddlSummaryPage = new SRFExDropDownList();
        this.ddlSummaryPage.InitConfig();
        this.ddlSummaryPage.setID("ddlSummaryPage");
        this.ddlSummaryPage.getDropDownListConfig().setWidth(250);
        this.ddlSummaryPage.getDropDownListConfig().setContainer(false);
        this.AddControl((SRFExControl)this.ddlSummaryPage);
        if (!this.IsBackEndMode()) {
            GridViewPage.BuildSummaryPageList(this, this.ddlSummaryPage, this.bInfoMode, this.ppGridView);
        }
    }

    /*
     * Enabled aggressive exception aggregation
     */
    protected static boolean BuildSummaryPageList(SRFDAPage page, SRFExDropDownList ddlSummaryPage, boolean bInfoMode, PPGridView ppGridView) {
        try {
            CallResult callResult;
            IDEHelper iDEHelper = page.getDEHelper();
            ddlSummaryPage.getDropDownListConfig().getListItems().Add(new ListItem(page.GetLocalization("PAGE.COMMON.GRIDVIEW.SUMMARYLIST.SELECTINFO", "--\u8bf7\u9009\u62e9--"), ""));
            boolean bIncludeDF = true;
            String strDERGroupId = "";
            if (ppGridView != null) {
                strDERGroupId = ppGridView.getDERGROUPID();
            }
            strDERGroupId = page.getPageParam("PAGE.DERGROUP", strDERGroupId);
            String strSelectPath = "";
            if (!StringHelper.IsNullOrEmpty((String)strDERGroupId)) {
                DERGroup derGroup = new DERGroup();
                callResult = page.getWebContext().getGlobalHelper().getDAModelHelper().GetDERGroup(strDERGroupId, derGroup);
                if (callResult.getRetCode() != 0) {
                    page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5206\u7ec4[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERGroupId, (Object)callResult.getErrorInfo()));
                    return false;
                }
                bIncludeDF = derGroup.isINCLUDEDF();
            }
            if (bIncludeDF) {
                String strURL = StringHelper.Format((String)"../srfpage/embededitview.jsp?SRFDEID=%1$s&SRFSUMMARYKEY=%2$s", (Object)iDEHelper.getId(), (Object)iDEHelper.GetKeyDEFHelper().getName());
                if (bInfoMode) {
                    strURL = String.valueOf(strURL) + "&SRFINFOMODE=TRUE";
                }
                ddlSummaryPage.getDropDownListConfig().getListItems().Add(new ListItem(iDEHelper.getLogicName(page.getLanguage()), strURL));
                strSelectPath = strURL;
                ddlSummaryPage.getDropDownListConfig().setSelectedValue(strSelectPath);
            }
            if (StringHelper.IsNullOrEmpty((String)strDERGroupId)) {
                Vector der11List = iDEHelper.GetDER11s(true);
                for (DER11 der11 : der11List) {
                    if (der11.getSHOWORDER() < 0) continue;
                    String strResourceId = UniResHelper.GetDEDataResId((String)der11.getMINORDEID());
                    if (!page.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)page.getWebContext(), strResourceId)) continue;
                    String strURL = StringHelper.Format((String)"../srfpage/embededitview.jsp?SRFDEID=%1$s&SRFSUMMARYKEY=%2$s", (Object)der11.getMINORDEID(), (Object)iDEHelper.GetKeyDEFHelper().getName());
                    ddlSummaryPage.getDropDownListConfig().getListItems().Add(new ListItem(der11.getMINORDELOGICNAME(), strURL));
                }
                Vector derList = iDEHelper.GetDER1Ns(true);
                for (DER1N der1n : derList) {
                    if (der1n.getSHOWORDER() < 0) continue;
                    String strDefaultPage = "../srfpage/gridview.jsp?";
                    String strPageId = der1n.getRELATEDPAGEID();
                    String strResourceId = UniResHelper.GetDEDataResId((String)der1n.getMINORDEID());
                    if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                        Page relatedPage = page.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strPageId);
                        if (relatedPage == null) {
                            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                            return false;
                        }
                        strDefaultPage = relatedPage.GetTotalPagePath();
                        strResourceId = relatedPage.getRESOURCEID(der1n.getMINORDEID());
                    }
                    if (!page.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)page.getWebContext(), strResourceId)) continue;
                    TreeMap<String, String> urlParams = new TreeMap<String, String>();
                    urlParams.put("SRFPDEID", der1n.getMAJORDEID());
                    urlParams.put("SRFDEID", der1n.getMINORDEID());
                    urlParams.put("SRFDERID", der1n.getDERID());
                    urlParams.put("SRFCAPTION", page.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(page.getLanguage(), der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                    urlParams.put("SRFSUMMARYKEY", iDEHelper.GetKeyDEFHelper().getName());
                    urlParams.put("SRFIFVIEW", "TRUE");
                    urlParams.put("SRFDGAL", "TRUE");
                    if ((der1n.getDERSUBTYPE() & 0x10) != 0) {
                        urlParams.put("SRFINFOMODE", "TRUE");
                    }
                    if ((der1n.getDERSUBTYPE() & 0x20) != 0) {
                        urlParams.put("SRFFEWDATAMODE", "TRUE");
                    }
                    strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
                    String strURL = StringHelper.Format((String)"%1$s%2$s", (Object)strDefaultPage, (Object)URLHelper.GetQueryString(urlParams));
                    ddlSummaryPage.getDropDownListConfig().getListItems().Add(new ListItem(page.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(page.getLanguage(), der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()), strURL));
                }
                Vector list = new Vector();
                CallResult callResult2 = page.getWebContext().getGlobalHelper().getDAModelHelper().GetSummaryPages(page.getPageDataEntityId(), "SUM", list);
                if (callResult2 == null || callResult2.getRetCode() != 0) {
                    page.PageLog((Object)page, 1, StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u7f29\u7565\u754c\u9762\u5931\u8d25\uff0c%1$s", (Object)callResult2.getErrorInfo()));
                    return false;
                }
                for (SummaryPage summaryPage : list) {
                    String strSPType = summaryPage.getSPTYPE();
                    if (StringHelper.Compare((String)strSPType, (String)"FORM", (boolean)true) == 0) {
                        String strURL = StringHelper.Format((String)"../srfpage/summaryformview.jsp?SRFFORMVIEW=%1$s&SRFDGAL=FALSE&", (Object)summaryPage.getFORMID());
                        ddlSummaryPage.getDropDownListConfig().getListItems().Add(new ListItem(page.GetLocalization(summaryPage.getNAMELANRESID(), summaryPage.getSUMMARYPAGENAME()), strURL));
                        continue;
                    }
                    if (StringHelper.Compare((String)strSPType, (String)"PAGE", (boolean)true) != 0) continue;
                    String strDefaultPage = "../srfpage/ifgridview.jsp?";
                    String strPageId = summaryPage.getPAGEID();
                    String strResourceId = "";
                    if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                        Page relatedPage = page.getDAModelStorage().FindPage(strPageId);
                        if (relatedPage == null) {
                            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                            return false;
                        }
                        strDefaultPage = relatedPage.GetTotalPagePath();
                        strResourceId = relatedPage.getRESOURCEID("");
                    }
                    if (!page.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)page.getWebContext(), strResourceId)) continue;
                    if (!StringHelper.IsNullOrEmpty((String)summaryPage.getAPPENDPARAM())) {
                        strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
                        strDefaultPage = String.valueOf(strDefaultPage) + summaryPage.getAPPENDPARAM();
                        strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
                    }
                    strDefaultPage = String.valueOf(strDefaultPage) + "&SRFDGAL=FALSE";
                    strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
                    ddlSummaryPage.getDropDownListConfig().getListItems().Add(new ListItem(page.GetLocalization(summaryPage.getNAMELANRESID(), summaryPage.getSUMMARYPAGENAME()), strDefaultPage));
                }
            } else {
                Vector derGroupDetails = new Vector();
                callResult = page.getDAModelHelper().GetDERGroupDetails(strDERGroupId, derGroupDetails);
                if (callResult == null || callResult.getRetCode() != 0) {
                    page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5206\u7ec4\u5173\u7cfb\u660e\u7ec6\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    return false;
                }
                int nActiveShowOrder = -1;
                if (ppGridView != null && !ppGridView.IsParamNull("ACTIVEDERGROUPITEM")) {
                    nActiveShowOrder = ppGridView.getACTIVEDERGROUPITEM();
                }
                nActiveShowOrder = page.getPageParam("PAGE.DERGROUP.ACTIVE", nActiveShowOrder);
                for (DERGroupDetail derGroupDetail : derGroupDetails) {
                    IDEHelper iMinorDEHelper;
                    String strPageId = "";
                    String strPagePath = "";
                    String strDefaultPageParam = "";
                    String strCurDEId = "";
                    if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"PAGE", (boolean)true) == 0) {
                        strPageId = derGroupDetail.getPAGEID();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"PAGEPATH", (boolean)true) == 0) {
                        strPagePath = derGroupDetail.getPAGEPATH();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"WFSTEP", (boolean)true) == 0) {
                        strPageId = "PAGE_00010";
                        strCurDEId = iDEHelper.getId();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"WFSTEPACTOR", (boolean)true) == 0) {
                        strPageId = page.getWebContext().getWebExConfig().GetValue("SRFDA.WF", "WFSTEPACTORGRIDPAGE", "PAGE_WF0006_G001");
                        strCurDEId = iDEHelper.getId();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"FILELIST", (boolean)true) == 0) {
                        strPageId = "PAGE_00015";
                        strCurDEId = iDEHelper.getId();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"DER1N", (boolean)true) == 0) {
                        DER1N der1n = new DER1N();
                        callResult = page.getDAModelHelper().GetDER1N(derGroupDetail.getDER1NID(), der1n);
                        if (callResult.getRetCode() != 0) {
                            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f531N\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)derGroupDetail.getDER1NID(), (Object)callResult.getErrorInfo()));
                            return false;
                        }
                        strPageId = der1n.getRELATEDPAGEID();
                        if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                            iMinorDEHelper = page.getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
                            if (iMinorDEHelper == null) {
                                page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der1n.getMINORDEID()));
                                return false;
                            }
                            strPageId = iMinorDEHelper.GetGridPageId();
                        }
                        TreeMap<String, String> urlParams = new TreeMap<String, String>();
                        urlParams.put("SRFDEID", der1n.getMINORDEID());
                        urlParams.put("SRFDERID", der1n.getDERID());
                        if ((der1n.getDERSUBTYPE() & 0x10) != 0) {
                            urlParams.put("SRFINFOMODE", "TRUE");
                        }
                        if ((der1n.getDERSUBTYPE() & 0x20) != 0) {
                            urlParams.put("SRFFEWDATAMODE", "TRUE");
                        }
                        strDefaultPageParam = URLHelper.GetQueryString(urlParams);
                        strCurDEId = der1n.getMINORDEID();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"DER11", (boolean)true) == 0) {
                        DER11 der11 = new DER11();
                        callResult = page.getDAModelHelper().GetDER11(derGroupDetail.getDER11ID(), der11);
                        if (callResult.getRetCode() != 0) {
                            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f5311\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)derGroupDetail.getDER11ID(), (Object)callResult.getErrorInfo()));
                            return false;
                        }
                        strPageId = der11.getEDITPAGEID();
                        if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                            iMinorDEHelper = page.getDAModelStorage().FindDEHelper(der11.getMINORDEID());
                            if (iMinorDEHelper == null) {
                                page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der11.getMINORDEID()));
                                return false;
                            }
                            strPageId = iMinorDEHelper.GetEditPageId();
                        }
                        strDefaultPageParam = StringHelper.Format((String)"SRFDEID=%1$s&SRFDERID=%2$s", (Object)der11.getMINORDEID(), (Object)der11.getDERID());
                        strCurDEId = der11.getMINORDEID();
                    }
                    String strResourceId = "NONE";
                    if (!StringHelper.IsNullOrEmpty((String)strCurDEId)) {
                        strResourceId = UniResHelper.GetDEDataResId((String)strCurDEId);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                        Page relatedPage = page.getDAModelStorage().FindPage(strPageId);
                        if (relatedPage == null) {
                            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                            return false;
                        }
                        strPagePath = relatedPage.GetTotalPagePath();
                        strResourceId = relatedPage.getRESOURCEID(strCurDEId);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)derGroupDetail.getRESOURCEID())) {
                        strResourceId = derGroupDetail.getRESOURCEID();
                    }
                    if (!page.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)page.getWebContext(), strResourceId)) continue;
                    if (StringHelper.IsNullOrEmpty((String)strPagePath)) {
                        strPagePath = "../srfpage/gridview.jsp";
                    }
                    strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                    strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFPDEID=%1$s&SRFCAPTION=%2$s&SRFSUMMARYKEY=%3$s&SRFDGAL=FALSE", (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)derGroupDetail.getDERGROUPDETAILNAME()), (Object)iDEHelper.GetKeyDEFHelper().getName());
                    if (!StringHelper.IsNullOrEmpty((String)strDefaultPageParam)) {
                        strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                        strPagePath = String.valueOf(strPagePath) + strDefaultPageParam;
                    }
                    if (!StringHelper.IsNullOrEmpty((String)derGroupDetail.getURLPARAM())) {
                        strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                        strPagePath = String.valueOf(strPagePath) + derGroupDetail.getURLPARAM();
                    }
                    ddlSummaryPage.getDropDownListConfig().getListItems().Add(new ListItem(derGroupDetail.getDERGROUPDETAILNAME(), strPagePath));
                    if (nActiveShowOrder == -1 || derGroupDetail.getSHOWORDER() != nActiveShowOrder) continue;
                    ddlSummaryPage.getDropDownListConfig().setSelectedValue(strPagePath);
                    strSelectPath = strPagePath;
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strSelectPath)) {
                page.getPage().RegisterOnReadyScript(3, StringHelper.Format((String)"Ext.getDom('if_summary').src = '%1$s';\r\n", (Object)strSelectPath));
            }
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var _URL=Ext.getDom('%1$s').value;\r\n", (Object)ddlSummaryPage.getUniqueID());
            script.Append("if(_URL==''){Ext.getDom('if_summary').src='';return;}");
            script.Append("Ext.getDom('if_summary').src = _URL;\r\n");
            page.getPage().RegisterOnReadyScript(3, StringHelper.Format((String)"Ext.get('%1$s').on('change',function(){%2$s});", (Object)ddlSummaryPage.getUniqueID(), (Object)script.toString()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    protected void LoadDataGridRowActionList() {
        this.dataGridRowActionList = GridViewPage.CreateDataGridRowActionList(this, "dataGridRowActionList", 50);
        if (this.dataGridRowActionList != null && this.dataGrid != null) {
            this.dataGridRowActionList.getDataGridRowActionListConfig().setDataGridId(this.dataGrid.getUniqueID());
        }
    }

    protected void LoadDataGridRowCountList() {
        this.dataGridRowCountList = GridViewPage.CreateDataGridRowCountList(this, "dataGridRowCountList", 50);
        if (this.dataGridRowCountList != null && this.dataGrid != null) {
            this.dataGridRowCountList.getDataGridRowCountListConfig().setDataGridId(this.dataGrid.getUniqueID());
            this.dataGridRowCountList.getDataGridRowCountListConfig().setActivePageSize(this.dataGrid.getDataGridConfig().getDataGridPagingConfig().getPageSize());
        }
    }

    protected void LoadDataGrid() {
        this.strDataGridConfigId = this.OnGetDataGridConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strDataGridConfigId)) {
            return;
        }
        this.dataGrid = GridViewPage.CreateDataGrid(this, "dataGrid", 0.0, 0.0, this.strDataGridConfigId);
        if (this.dataGrid != null) {
            this.dataGrid.setEnableItemPrivilege(this.OnGetDGItemPrivilege());
            if (!this.IsBackEndMode()) {
                this.dataGrid.getDataGridConfig().setTempData(SRFDAWebCTXHelper.IsTempDataMode((ISRFDAWebContext)this.getWebContext(), (boolean)false));
            }
            this.LoadDataGridRowActionList();
            this.LoadDataGridRowCountList();
            if (!this.OnGetDataGridCheckMode()) {
                this.dataGrid.getDataGridConfig().setSelectColumn(false);
            }
            if (!this.IsIfGridView()) {
                this.dataGrid.getDataGridConfig().setBorder(false);
            }
            if (this.bEnableDGEdit) {
                this.dataGrid.getDataGridConfig().setEditable(true);
                if (!this.IsBackEndMode()) {
                    int nClickCount = 1;
                    if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("CLICKSTOEDIT")) {
                        nClickCount = this.ppDataGrid.getCLICKSTOEDIT();
                    }
                    if ((nClickCount = this.getPageParam("PAGE.DATAGRID.CLICKSTOEDIT", nClickCount)) <= 0 || nClickCount > 2) {
                        nClickCount = 1;
                    }
                    this.dataGrid.getDataGridConfig().setClicksToEdit(nClickCount);
                }
            }
            boolean bDGHideDERColumn = true;
            int nSummaryHeight = 0;
            if (!this.IsBackEndMode()) {
                int nInterval;
                String strDGRowClassHelper;
                this.dataGrid.getDataGridConfig().setDeferEmptyText(this.OnGetDataGridDeferEmptyText());
                nSummaryHeight = this.OnGetDataGridSummaryHeight();
                if (nSummaryHeight != -1) {
                    this.dataGrid.getDataGridConfig().setSummaryHeight(nSummaryHeight);
                }
                if ((strDGRowClassHelper = this.OnGetDataGridRowClassHelper()) != null) {
                    this.dataGrid.getDataGridConfig().setRowClassHelper(strDGRowClassHelper);
                }
                if (bDGHideDERColumn = this.OnGetDataGridHideDERColumns()) {
                    String strFilter;
                    String strDERID = this.getWebContext().getSRFDERID();
                    if (!StringHelper.IsNullOrEmpty((String)strDERID)) {
                        for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                            DataGridColumnConfig dgColumnConfig;
                            ILinkDEFHelper iLinkDEFHelper;
                            if (!iDEFHelper.IsLinkDEField() || !(iDEFHelper instanceof ILinkDEFHelper) || StringHelper.Compare((String)(iLinkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetDERId(), (String)strDERID, (boolean)true) != 0 || (dgColumnConfig = this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().FindDataGridColumnConfigById(iLinkDEFHelper.getName())) == null) continue;
                            if (!StringHelper.IsNullOrEmpty((String)this.strDGHideDERColumnName)) {
                                this.strDGHideDERColumnName = String.valueOf(this.strDGHideDERColumnName) + ";";
                            }
                            this.strDGHideDERColumnName = String.valueOf(this.strDGHideDERColumnName) + iLinkDEFHelper.getName();
                            dgColumnConfig.setHidden(true);
                        }
                    }
                    if (!StringHelper.IsNullOrEmpty((String)(strFilter = this.getWebContext().getSRFFILTER()))) {
                        String[] parts = strFilter.split("[;]");
                        int i = 0;
                        while (i < parts.length) {
                            DataGridColumnConfig dgColumnConfig;
                            String[] params;
                            String strPart = parts[i];
                            if (!StringHelper.IsNullOrEmpty((String)strPart) && (params = strPart.split("[|]")).length == 3 && (dgColumnConfig = this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().FindDataGridColumnConfigById(params[2])) != null) {
                                if (!StringHelper.IsNullOrEmpty((String)this.strDGHideDERColumnName)) {
                                    this.strDGHideDERColumnName = String.valueOf(this.strDGHideDERColumnName) + ";";
                                }
                                this.strDGHideDERColumnName = String.valueOf(this.strDGHideDERColumnName) + params[2];
                                dgColumnConfig.setHidden(true);
                            }
                            ++i;
                        }
                    }
                }
                if (this.bRenderSP) {
                    this.spEx.getSearchForm().setUserParamsName(StringHelper.Format((String)"$P.store['%1$s'].userparams", (Object)this.dataGrid.getUniqueID()));
                    this.spEx.getSearchForm().getSearchAction().getSuccessAction().RegisterProcessCode(0, StringHelper.Format((String)"$P.store['%1$s'].loaddefault();", (Object)this.dataGrid.getUniqueID()));
                }
                StringBuilderEx script = new StringBuilderEx();
                script.Append("$P.maingrid=$P.grid['%1$s'];", (Object)this.dataGrid.getUniqueID());
                if (this.bEnableDGEdit) {
                    script.Append("$P.grid['%1$s'].on('beforeedit',function(e){if(!%2$s){e.cancel=true;}});", (Object)this.dataGrid.getUniqueID(), (Object)DataGridJSHelper.getGetDataGridEditable((String)this.dataGrid.getUniqueID()));
                }
                script.Append(DataGridJSHelper.getSetDataGridEditable((String)this.dataGrid.getUniqueID(), (boolean)this.OnGetDataGridEditableDefault()));
                String strBeforeLoadDefault = "";
                if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("BEFORELDCODE")) {
                    strBeforeLoadDefault = this.ppDataGrid.getBEFORELDCODE();
                }
                if (!StringHelper.IsNullOrEmpty((String)(strBeforeLoadDefault = this.getPageParam("PAGE.BEFORELOADDEFAULT", strBeforeLoadDefault)))) {
                    script.Append(strBeforeLoadDefault);
                }
                if (this.OnGetDataGridAutoLoad()) {
                    if (this.spEx == null) {
                        script.Append("$P.store['%1$s'].loaddefault();", (Object)this.dataGrid.getUniqueID());
                    } else {
                        this.spEx.getSearchForm().getLoadAction().getSuccessAction().RegisterProcessCode(0, StringHelper.Format((String)"_F.search();", (Object)this.dataGrid.getUniqueID()));
                    }
                }
                if ((nInterval = this.OnGetDataGridRefresh()) > 0) {
                    script.Append("$P.grid['%1$s'].gridmgr._INTERVAL=window.setInterval(\"$P.store['%1$s'].reload();\",%2$s);", (Object)this.dataGrid.getUniqueID(), (Object)nInterval);
                }
                this.RegisterOnReadyScript(3, script.toString());
            }
            if (this.gridViewModel != null && this.gridViewModel.getDGModel() != null) {
                DGModel dgModel = this.gridViewModel.getDGModel();
                dgModel.setCtrlId("dataGrid");
                dgModel.setConfigId(this.strDataGridConfigId);
                dgModel.setRemoteCtrlId(this.dataGrid.getUniqueID());
                dgModel.setItemPrivilege(this.OnGetDGItemPrivilege());
                dgModel.setHideDERColumn(bDGHideDERColumn);
                dgModel.setDERColumnName(this.strDGHideDERColumnName);
                dgModel.setSummaryHeight(nSummaryHeight);
                dgModel.setFIUpdateMode(this.OnGetDGFIUpdateMode());
                dgModel.setEditable(this.bEnableDGEdit);
                String strDGThemeId = String.valueOf(this.webContext.getCurPageName()) + this.strDataGridConfigId.toUpperCase();
                strDGThemeId = strDGThemeId.toUpperCase();
                dgModel.setThemeId(strDGThemeId);
                UserDGTheme userDGTheme = new UserDGTheme();
                CallResult callResult = this.getDAModelHelper().GetUserDGTheme(this.getWebContext().getCurUserId(), strDGThemeId, userDGTheme);
                if (callResult.IsOk()) {
                    dgModel.setThemeModel(userDGTheme.getDGTHEMEMODEL());
                }
            }
        }
    }

    protected String OnGetDataGridConfigId() {
        String strDGConfig = this.getPageParam("PAGE.DATAGRID", "");
        if (!StringHelper.IsNullOrEmpty((String)strDGConfig)) {
            return strDGConfig;
        }
        return this.getDAConfigHelper().GetGridViewDGConfigId(this.getDEHelper(), this.page, this.gridView, this.getWebContext().getSRFDERID());
    }

    protected boolean OnGetDataGridEditableDefault() {
        if (this.bEnableDGEdit) {
            boolean bEditableDefault = false;
            if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("EDITABLEDEFAULT")) {
                bEditableDefault = this.ppDataGrid.getEDITABLEDEFAULT();
            }
            return this.getPageParam("PAGE.DATAGRID.EDITABLEDEFAULT", bEditableDefault);
        }
        return false;
    }

    protected int OnGetDataGridSummaryHeight() {
        int nSummaryHeight = -1;
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("SUMMARYHEIGHT")) {
            nSummaryHeight = this.ppDataGrid.getSUMMARYHEIGHT();
        }
        return this.getPageParam("PAGE.DATAGRID.SUMMARYHEIGHT", nSummaryHeight);
    }

    protected String OnGetDataGridRowClassHelper() {
        return this.getPageParam("PAGE.DATAGRID.ROWCLASSHELPER", null);
    }

    protected boolean OnGetDGItemPrivilege() {
        boolean bDGItemPriv = this.getDEHelper().IsEnableDEFieldPriv();
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("ITEMPRIVILEGE")) {
            bDGItemPriv = this.ppDataGrid.getITEMPRIVILEGE();
        }
        return this.getPageParam("PAGE.DATAGRID.ITEMPRIVILEGE", bDGItemPriv);
    }

    protected String OnGetDGFIUpdateMode() {
        return this.getPageParam("PAGE.DATAGRID.FIUPDATEMODE", "");
    }

    protected void LoadToolbar() {
        if (!this.IsBackEndMode()) {
            this.strToolbarConfigId = this.OnGetGridViewToolbarConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strToolbarConfigId)) {
                return;
            }
        }
        this.toolbar = GridViewPage.CreateToolbar(this, "toolBar", 0.0, 0.0, this.strToolbarConfigId);
        if (this.toolbar != null && !this.IsBackEndMode()) {
            this.toolbar.getToolbarConfig().setCssClass("sx-toolbarnobg");
            if (this.dataGrid != null) {
                this.toolbar.setToolbarObject("DATAGRID", (Object)this.dataGrid);
                this.toolbar.setToolbarObject("", (Object)this.dataGrid);
            }
            this.toolbar.setToolbarObject(PPCTRLID_SPEX, (Object)this.spEx);
        }
        if (this.gridViewModel != null && this.gridViewModel.getToolbarModel() != null) {
            this.gridViewModel.getToolbarModel().setCtrlId("toolBar");
            this.gridViewModel.getToolbarModel().setConfigId(this.strToolbarConfigId);
            this.gridViewModel.getToolbarModel().setRemoteCtrlId(this.toolbar.getUniqueID());
        }
    }

    protected String OnGetGridViewToolbarConfigId() {
        try {
            if (this.IsContainPageParam("PAGE.TOOLBAR")) {
                return this.getPageParam("PAGE.TOOLBAR", "");
            }
            if (this.isEnableDAConfigV2("TOOLBAR")) {
                GridViewToolbarConfigPublishContext configPublishContext = new GridViewToolbarConfigPublishContext();
                this.FillDAConfigPublishContext(configPublishContext);
                configPublishContext.setDataGrid(this.gridView);
                configPublishContext.setPickupMode(this.bPickupMode);
                configPublishContext.setMiniMode(this.IsIfGridView());
                configPublishContext.setEmbedMode(this.bEmbedMode);
                configPublishContext.setReadOnlyMode(this.bInfoMode);
                configPublishContext.setEnableRowEdit(this.bEnableDGEdit);
                return this.getDAConfigHelper().GetConfigId("TOOLBAR", (IDAConfigPublishContext)configPublishContext);
            }
            return this.getDAConfigHelper().GetGridViewToolbarConfigId(this.getDEHelper(), this.page, this.gridView, this.bPickupMode, this.IsIfGridView(), this.bEnableDGEdit, this.bInfoMode, this.bEmbedMode, null);
        }
        catch (Exception ex) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u5177\u680f\u89c6\u56fe\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return "";
        }
    }

    protected void LoadSPEx() {
        if (this.bRenderSP) {
            this.strSPExConfigId = this.OnGetSPExConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strSPExConfigId)) {
                return;
            }
            this.spEx = GridViewPage.CreateSPEx(this, "spEx", this.strSPExConfigId);
            if (this.spEx != null) {
                boolean bEnableItemPrivilege = this.OnGetDGItemPrivilege();
                this.spEx.setEnableItemPrivilege(bEnableItemPrivilege);
                this.spEx.getSearchForm().setEnableItemPrivilege(bEnableItemPrivilege);
                if (this.bSPCustomSearch) {
                    this.spEx.getSPExConfig().setCustomSearch(true);
                    this.spEx.getSPExConfig().setCustomSearchJSFunc(StringHelper.Format((String)"spcustomsearch", (Object)this.OnGetDGItemPrivilege()));
                }
                this.spEx.getSearchForm().setFormTag(this.strFormTag);
                this.spEx.getSPExConfig().setSaveLoad(this.OnGetSPSaveLoad());
                this.spEx.getSPExConfig().setWidth(1024);
                if (this.gridViewModel != null && this.gridViewModel.getSPExModel() != null) {
                    SPExModel spExModel = this.gridViewModel.getSPExModel();
                    spExModel.setCtrlId("spEx");
                    spExModel.setConfigId(this.strSPExConfigId);
                    spExModel.setRemoteCtrlId(this.spEx.getUniqueID());
                    spExModel.setItemPrivilege(bEnableItemPrivilege);
                    spExModel.setCustomSearch(this.bSPCustomSearch);
                    spExModel.setSaveLoad(this.OnGetSPSaveLoad());
                    spExModel.setSaveLoadTag(this.strFormTag);
                }
                if (this.gridViewModel != null && this.gridViewModel.getSearchFormModel() != null) {
                    this.gridViewModel.getSearchFormModel().setRemoteCtrlId(this.getDefaultFormId());
                }
            }
        }
    }

    protected boolean OnGetSPExCustomSearch() {
        boolean bSPCustomSearch = this.getWebContext().getWebExConfig().GetValue("SRFDA", "SPCUSTOMSEARCH", false);
        if (this.ppSearchForm != null && !this.ppSearchForm.isSPCUSTOMSEARCHNull()) {
            bSPCustomSearch = this.ppSearchForm.getSPCUSTOMSEARCH();
        }
        return this.getPageParam("PAGE.SP.CUSTOMSEARCH", bSPCustomSearch);
    }

    protected String OnGetSPExConfigId() {
        String strSPExConfigId = this.getPageParam("PAGE.SP", "");
        if (!StringHelper.IsNullOrEmpty((String)strSPExConfigId)) {
            this.strFormTag = strSPExConfigId;
            return strSPExConfigId;
        }
        boolean bDefaultSF = false;
        String strSearchformId = "";
        if (this.ppSearchForm != null && !this.ppSearchForm.isSEARCHFORMIDNull()) {
            strSearchformId = this.ppSearchForm.getSEARCHFORMID();
        }
        if (StringHelper.IsNullOrEmpty((String)(strSearchformId = this.getPageParam("PAGE.SEARCHFORM", strSearchformId))) && this.getWebContext().getWebExConfig().GetValue("SRFDA", "DEFAULTSEARCHFORM", false)) {
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
        return this.getDAConfigHelper().GetGridViewSPExConfigId(this.getDEHelper(), this.gridView);
    }

    public boolean IsIfGridView() {
        return this.bIfGridView;
    }

    public boolean IsRenderDataGridTheme() {
        if (this.bEmbedMode) {
            return false;
        }
        if (this.bPickupMode) {
            return false;
        }
        return this.bGVTheme;
    }

    public boolean IsRenderRowActionList() {
        return this.OnGetRenderRowActionList();
    }

    protected boolean OnGetRenderRowActionList() {
        boolean bRender = true;
        return this.getPageParam("PAGE.ROWACTIONLIST.RENDER", bRender);
    }

    public boolean IsRenderRowCountList() {
        return this.getPageParam("PAGE.ROWCOUNTLIST", true);
    }

    public int GetCaptionWidth() {
        return this.OnGetCaptionWidth();
    }

    protected int OnGetCaptionWidth() {
        int nCaptionWidth = 60;
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("CAPTIONWIDTH")) {
            nCaptionWidth = this.ppGridView.getCAPTIONWIDTH();
        }
        return this.getPageParam("PAGE.CAPTIONWIDTH", nCaptionWidth);
    }

    public boolean IsRenderCaption() {
        if (this.IsContainPageParam("PAGE.CAPTION")) {
            return this.getPageParam("PAGE.CAPTION", false);
        }
        if (this.bEmbedMode || this.bIfGridView) {
            return false;
        }
        String strShowCap = this.getWebContext().GetParamValue("SRFSHOWCAP");
        if (!StringHelper.IsNullOrEmpty((String)strShowCap)) {
            return StringHelper.Compare((String)strShowCap, (String)"TRUE", (boolean)true) == 0;
        }
        return !StringHelper.IsNullOrEmpty((String)this.getWebContext().GetParamValue("SRFCAPTION"));
    }

    public boolean IsRightSummary() {
        return StringHelper.Compare((String)this.strSummaryMode, (String)"RIGHT", (boolean)true) == 0;
    }

    public boolean IsBottomSummary() {
        return StringHelper.Compare((String)this.strSummaryMode, (String)"BOTTOM", (boolean)true) == 0;
    }

    public boolean IsRenderCustomSummaryArea() {
        if (this.bEmbedMode) {
            return false;
        }
        boolean bSummaryArea = true;
        bSummaryArea = this.getWebContext().getWebExConfig().GetValue("SRFDA.GRIDVIEW", "CUSTOMSUMMARYAREA", bSummaryArea);
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("CUSTOMSUMMARYAREA")) {
            bSummaryArea = this.ppGridView.getCUSTOMSUMMARYAREA();
        }
        return this.getPageParam("PAGE.CUSTOMSUMMARYAREA", bSummaryArea);
    }

    public boolean IsRenderSummaryPageList() {
        if (this.bEmbedMode) {
            return false;
        }
        boolean bSummaryPageList = true;
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("SUMMARYLIST")) {
            bSummaryPageList = this.ppGridView.getSUMMARYLIST();
        }
        return this.getPageParam("PAGE.SUMMARYLIST", bSummaryPageList);
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

    protected String OnGetDataGridMode() {
        String strDGMode = "";
        if (this.ppGridView != null) {
            strDGMode = this.ppGridView.getDGMODE();
        }
        if (StringHelper.IsNullOrEmpty((String)strDGMode)) {
            strDGMode = "DEFAULT";
        }
        return this.getPageParam("PAGE.DGMODE", strDGMode);
    }

    protected boolean OnGetDataGridAutoLoad() {
        boolean bDGAutoLoad = true;
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("LOADDEFAULT")) {
            bDGAutoLoad = this.ppDataGrid.getLOADDEFAULT();
            return this.getPageParam("PAGE.DATAGRID.AUTOLOAD", bDGAutoLoad);
        }
        if (this.IsContainPageParam("PAGE.DATAGRID.AUTOLOAD")) {
            return StringHelper.Compare((String)this.getPageParam("PAGE.DATAGRID.AUTOLOAD", "TRUE"), (String)"TRUE", (boolean)true) == 0;
        }
        return this.getWebContext().GetSRFDGAutoLoad();
    }

    protected int OnGetDataGridRefresh() {
        int nDGRefreshTimer = 0;
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("REFRESHTIMER")) {
            nDGRefreshTimer = this.ppDataGrid.getREFRESHTIMER();
        }
        return this.getPageParam("PAGE.DATAGRID.REFRESH", nDGRefreshTimer);
    }

    protected boolean OnGetDataGridDeferEmptyText() {
        return false;
    }

    protected boolean OnGetSPAutoExpand() {
        boolean bSPAutoExpand = false;
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("SPAUTOEXPAND")) {
            bSPAutoExpand = this.ppGridView.getSPAUTOEXPAND();
        }
        return this.getPageParam("PAGE.SP.AUTOEXPAND", bSPAutoExpand);
    }

    protected boolean OnGetSPSaveLoad() {
        boolean bSPSaveLoad = true;
        bSPSaveLoad = this.getWebContext().getWebExConfig().GetValue("SRFDA.GRIDVIEW", "SPSAVELOAD", bSPSaveLoad);
        if (this.ppSearchForm != null && !this.ppSearchForm.isSPSAVELOADNull()) {
            bSPSaveLoad = this.ppSearchForm.getSPSAVELOAD();
        }
        return this.getPageParam("PAGE.SP.SAVELOAD", bSPSaveLoad);
    }

    protected boolean OnGetDataGridHideDERColumns() {
        boolean bDGHideDERColumn = true;
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("HIDEDERCOLUMN")) {
            bDGHideDERColumn = this.ppDataGrid.getHIDEDERCOLUMN();
        }
        return this.getPageParam("PAGE.DATAGRID.HIDEDERCOLUMN", bDGHideDERColumn);
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

    protected boolean OnGetDataGridCheckMode() {
        if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            return false;
        }
        boolean bDGCheckMode = true;
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("SELECTCOLUMN")) {
            bDGCheckMode = this.ppDataGrid.getSELECTCOLUMN();
        }
        return this.getPageParam("PAGE.DATAGRID.CHECKMODE", bDGCheckMode);
    }

    public int GetSummaryWidth() {
        int nWidth = 500;
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("SUMMARYWIDTH")) {
            nWidth = this.ppGridView.getSUMMARYWIDTH();
        }
        return this.getPageParam("PAGE.SUMMARY.WIDTH", nWidth);
    }

    public int GetSummaryHeight() {
        int nHeight = 300;
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("SUMMARYHEIGHT")) {
            nHeight = this.ppGridView.getSUMMARYHEIGHT();
        }
        return this.getPageParam("PAGE.SUMMARY.HEIGHT", nHeight);
    }

    public String GetSPExDPUniqueId() {
        return this.spEx.getPanel().getUniqueID();
    }

    protected boolean OnGetDataGridCustomTheme() {
        boolean bDGCustomTheme = this.getWebContext().getWebExConfig().GetValue("SRFDA", "DGCUSTOMTHEME", true);
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("CUSTOMTHEME")) {
            bDGCustomTheme = this.ppGridView.getCUSTOMTHEME();
        }
        bDGCustomTheme = this.getPageParam("PAGE.DATAGRID.CUSTOMTHEME", bDGCustomTheme);
        return bDGCustomTheme;
    }

    public boolean IsRenderSP() {
        return this.bRenderSP;
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.gridViewModel.setPickupMode(this.bPickupMode);
        this.gridViewModel.setDGMode(this.strDGMode);
        this.gridViewModel.setGridViewId(this.strGridViewId);
        this.gridViewModel.setCustomSummaryArea(this.IsRenderCustomSummaryArea());
        this.gridViewModel.setRowActionList(this.IsRenderRowActionList());
        this.gridViewModel.setQuickSearch(this.OnGetQuickSearch());
        this.gridViewModel.setQuickSearchMask(this.getDEHelper().GetQuickSearchMask(this.getLanguage()));
        this.gridViewModel.setDGEditDefault(this.OnGetDataGridEditableDefault());
        if (this.IsRightSummary()) {
            this.gridViewModel.setSummaryArea("RIGHT");
        } else if (this.IsBottomSummary()) {
            this.gridViewModel.setSummaryArea("BOTTOM");
        }
        if (this.IsRightSummary() || this.IsBottomSummary()) {
            this.gridViewModel.setSummaryWidth(this.GetSummaryWidth());
            this.gridViewModel.setSummaryHeight(this.GetSummaryHeight());
        }
        this.gridViewModel.setGridViewTheme(this.IsRenderDataGridTheme());
        this.gridViewModel.setCustomTheme(this.bCustomTheme);
        this.gridViewModel.setSPExpand(this.OnGetSPAutoExpand());
        if (!this.bRenderSP) {
            this.gridViewModel.getSPExModel().setVisible(false);
        }
        if (this.list != null) {
            Vector<JSONObject> dataGridList = new Vector<JSONObject>();
            for (DataGrid dataGrid : this.list) {
                dataGrid.RemoveParam("DGMODEL");
                JSONObject temp = new JSONObject();
                dataGrid.FillJSONObject(temp, false);
                dataGridList.add(temp);
            }
            this.gridViewModel.setThemeList(dataGridList);
        }
        if (this.IsRenderSummaryPageList()) {
            GridViewPage.BuildSummaryPageListModel(this, this.gridViewModel, this.bInfoMode, this.ppGridView);
        } else {
            this.gridViewModel.setSummaryPage(this.OnGetSummaryURL());
        }
        this.gridViewModel.setDGAutoLoad(this.OnGetDataGridAutoLoad());
        if (this.newPageInfo != null) {
            this.gridViewModel.setNewDataConfig(this.newPageInfo);
        }
        if (this.editPageInfo != null) {
            this.gridViewModel.setEditDataConfig(this.editPageInfo);
        }
        return true;
    }

    /*
     * Enabled aggressive exception aggregation
     */
    protected static boolean BuildSummaryPageListModel(SRFDAPage page, GridViewModel gridViewModel, boolean bInfoMode, PPGridView ppGridView) {
        try {
            CallResult callResult;
            String strSelectPath = "";
            IDEHelper iDEHelper = page.getDEHelper();
            Vector<JSONObject> summaryList = new Vector<JSONObject>();
            String strDERGroupId = "";
            if (ppGridView != null) {
                strDERGroupId = ppGridView.getDERGROUPID();
            }
            strDERGroupId = page.getPageParam("PAGE.DERGROUP", strDERGroupId);
            boolean bIncludeDF = true;
            if (!StringHelper.IsNullOrEmpty((String)strDERGroupId)) {
                DERGroup derGroup = new DERGroup();
                callResult = page.getWebContext().getGlobalHelper().getDAModelHelper().GetDERGroup(strDERGroupId, derGroup);
                if (callResult.getRetCode() != 0) {
                    page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5206\u7ec4[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERGroupId, (Object)callResult.getErrorInfo()));
                    return false;
                }
                bIncludeDF = derGroup.isINCLUDEDF();
            }
            if (bIncludeDF) {
                String strURL = StringHelper.Format((String)"../srfpage/embededitview.jsp?SRFDEID=%1$s&SRFSUMMARYKEY=%2$s", (Object)iDEHelper.getId(), (Object)iDEHelper.GetKeyDEFHelper().getName());
                if (bInfoMode) {
                    strURL = String.valueOf(strURL) + "&SRFINFOMODE=TRUE";
                }
                JSONObject item = new JSONObject();
                item.put("text", (Object)(String.valueOf(iDEHelper.getLogicName(page.getLanguage())) + "\u8be6\u7ec6\u4fe1\u606f"));
                item.put("value", (Object)strURL);
                summaryList.add(item);
            }
            if (StringHelper.IsNullOrEmpty((String)strDERGroupId)) {
                Vector der11List = iDEHelper.GetDER11s(true);
                for (DER11 der11 : der11List) {
                    if (der11.getSHOWORDER() < 0) continue;
                    String strResourceId = UniResHelper.GetDEDataResId((String)der11.getMINORDEID());
                    if (!page.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)page.getWebContext(), strResourceId)) continue;
                    String strURL = StringHelper.Format((String)"../srfpage/embededitview.jsp?SRFDEID=%1$s&SRFSUMMARYKEY=%2$s", (Object)der11.getMINORDEID(), (Object)iDEHelper.GetKeyDEFHelper().getName());
                    JSONObject item = new JSONObject();
                    item.put("text", (Object)(String.valueOf(der11.getMINORDELOGICNAME()) + "\u8be6\u7ec6\u4fe1\u606f"));
                    item.put("value", (Object)strURL);
                    summaryList.add(item);
                }
                Vector derList = iDEHelper.GetDER1Ns(true);
                for (DER1N der1n : derList) {
                    if (der1n.getSHOWORDER() < 0) continue;
                    String strDefaultPage = "../srfpage/gridview.jsp?";
                    String strPageId = der1n.getRELATEDPAGEID();
                    String strResourceId = UniResHelper.GetDEDataResId((String)der1n.getMINORDEID());
                    if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                        Page relatedPage = page.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strPageId);
                        if (relatedPage == null) {
                            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                            return false;
                        }
                        strDefaultPage = relatedPage.GetTotalPagePath();
                        strResourceId = relatedPage.getRESOURCEID(der1n.getMINORDEID());
                    }
                    if (!page.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)page.getWebContext(), strResourceId)) continue;
                    TreeMap<String, String> urlParams = new TreeMap<String, String>();
                    urlParams.put("SRFPDEID", der1n.getMAJORDEID());
                    urlParams.put("SRFDEID", der1n.getMINORDEID());
                    urlParams.put("SRFDERID", der1n.getDERID());
                    urlParams.put("SRFCAPTION", page.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(page.getLanguage(), der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                    urlParams.put("SRFSUMMARYKEY", iDEHelper.GetKeyDEFHelper().getName());
                    urlParams.put("SRFIFVIEW", "TRUE");
                    urlParams.put("SRFDGAL", "TRUE");
                    if ((der1n.getDERSUBTYPE() & 0x10) != 0) {
                        urlParams.put("SRFINFOMODE", "TRUE");
                    }
                    if ((der1n.getDERSUBTYPE() & 0x20) != 0) {
                        urlParams.put("SRFFEWDATAMODE", "TRUE");
                    }
                    strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
                    String strURL = StringHelper.Format((String)"%1$s%2$s", (Object)strDefaultPage, (Object)URLHelper.GetQueryString(urlParams));
                    JSONObject item = new JSONObject();
                    item.put("text", (Object)page.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(page.getLanguage(), der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                    item.put("value", (Object)strURL);
                    summaryList.add(item);
                }
                Vector list = new Vector();
                CallResult callResult2 = page.getWebContext().getGlobalHelper().getDAModelHelper().GetSummaryPages(page.getPageDataEntityId(), "SUM", list);
                if (callResult2 == null || callResult2.getRetCode() != 0) {
                    page.PageLog((Object)page, 1, StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u7f29\u7565\u754c\u9762\u5931\u8d25\uff0c%1$s", (Object)callResult2.getErrorInfo()));
                    return false;
                }
                for (SummaryPage summaryPage : list) {
                    String strSPType = summaryPage.getSPTYPE();
                    if (StringHelper.Compare((String)strSPType, (String)"FORM", (boolean)true) == 0) {
                        String strURL = StringHelper.Format((String)"../srfpage/summaryformview.jsp?SRFFORMVIEW=%1$s&SRFDGAL=FALSE&", (Object)summaryPage.getFORMID());
                        JSONObject item = new JSONObject();
                        item.put("text", (Object)page.GetLocalization(summaryPage.getNAMELANRESID(), summaryPage.getSUMMARYPAGENAME()));
                        item.put("value", (Object)strURL);
                        summaryList.add(item);
                        continue;
                    }
                    if (StringHelper.Compare((String)strSPType, (String)"PAGE", (boolean)true) != 0) continue;
                    String strDefaultPage = "../srfpage/ifgridview.jsp?";
                    String strPageId = summaryPage.getPAGEID();
                    String strResourceId = "";
                    if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                        Page relatedPage = page.getDAModelStorage().FindPage(strPageId);
                        if (relatedPage == null) {
                            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                            return false;
                        }
                        strDefaultPage = relatedPage.GetTotalPagePath();
                        strResourceId = relatedPage.getRESOURCEID("");
                    }
                    if (!page.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)page.getWebContext(), strResourceId)) continue;
                    if (!StringHelper.IsNullOrEmpty((String)summaryPage.getAPPENDPARAM())) {
                        strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
                        strDefaultPage = String.valueOf(strDefaultPage) + summaryPage.getAPPENDPARAM();
                        strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
                    }
                    strDefaultPage = String.valueOf(strDefaultPage) + "&SRFDGAL=FALSE";
                    strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
                    JSONObject item = new JSONObject();
                    item.put("text", (Object)page.GetLocalization(summaryPage.getNAMELANRESID(), summaryPage.getSUMMARYPAGENAME()));
                    item.put("value", (Object)strDefaultPage);
                    summaryList.add(item);
                }
            } else {
                Vector derGroupDetails = new Vector();
                callResult = page.getDAModelHelper().GetDERGroupDetails(strDERGroupId, derGroupDetails);
                if (callResult == null || callResult.getRetCode() != 0) {
                    page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5206\u7ec4\u5173\u7cfb\u660e\u7ec6\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    return false;
                }
                int nActiveShowOrder = -1;
                if (ppGridView != null && !ppGridView.IsParamNull("ACTIVEDERGROUPITEM")) {
                    nActiveShowOrder = ppGridView.getACTIVEDERGROUPITEM();
                }
                nActiveShowOrder = page.getPageParam("PAGE.DERGROUP.ACTIVE", nActiveShowOrder);
                for (DERGroupDetail derGroupDetail : derGroupDetails) {
                    IDEHelper iMinorDEHelper;
                    String strPageId = "";
                    String strPagePath = "";
                    String strDefaultPageParam = "";
                    String strCurDEId = "";
                    if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"PAGE", (boolean)true) == 0) {
                        strPageId = derGroupDetail.getPAGEID();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"PAGEPATH", (boolean)true) == 0) {
                        strPagePath = derGroupDetail.getPAGEPATH();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"WFSTEP", (boolean)true) == 0) {
                        strPageId = "PAGE_00010";
                        strCurDEId = iDEHelper.getId();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"WFSTEPACTOR", (boolean)true) == 0) {
                        strPageId = page.getWebContext().getWebExConfig().GetValue("SRFDA.WF", "WFSTEPACTORGRIDPAGE", "PAGE_WF0006_G001");
                        strCurDEId = iDEHelper.getId();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"FILELIST", (boolean)true) == 0) {
                        strPageId = "PAGE_00015";
                        strCurDEId = iDEHelper.getId();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"DER1N", (boolean)true) == 0) {
                        DER1N der1n = new DER1N();
                        callResult = page.getDAModelHelper().GetDER1N(derGroupDetail.getDER1NID(), der1n);
                        if (callResult.getRetCode() != 0) {
                            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f531N\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)derGroupDetail.getDER1NID(), (Object)callResult.getErrorInfo()));
                            return false;
                        }
                        strPageId = der1n.getRELATEDPAGEID();
                        if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                            iMinorDEHelper = page.getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
                            if (iMinorDEHelper == null) {
                                page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der1n.getMINORDEID()));
                                return false;
                            }
                            strPageId = iMinorDEHelper.GetGridPageId();
                        }
                        TreeMap<String, String> urlParams = new TreeMap<String, String>();
                        urlParams.put("SRFDEID", der1n.getMINORDEID());
                        urlParams.put("SRFDERID", der1n.getDERID());
                        if ((der1n.getDERSUBTYPE() & 0x10) != 0) {
                            urlParams.put("SRFINFOMODE", "TRUE");
                        }
                        if ((der1n.getDERSUBTYPE() & 0x20) != 0) {
                            urlParams.put("SRFFEWDATAMODE", "TRUE");
                        }
                        strDefaultPageParam = URLHelper.GetQueryString(urlParams);
                        strCurDEId = der1n.getMINORDEID();
                    } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"DER11", (boolean)true) == 0) {
                        DER11 der11 = new DER11();
                        callResult = page.getDAModelHelper().GetDER11(derGroupDetail.getDER11ID(), der11);
                        if (callResult.getRetCode() != 0) {
                            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f5311\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)derGroupDetail.getDER11ID(), (Object)callResult.getErrorInfo()));
                            return false;
                        }
                        strPageId = der11.getEDITPAGEID();
                        if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                            iMinorDEHelper = page.getDAModelStorage().FindDEHelper(der11.getMINORDEID());
                            if (iMinorDEHelper == null) {
                                page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der11.getMINORDEID()));
                                return false;
                            }
                            strPageId = iMinorDEHelper.GetEditPageId();
                        }
                        strDefaultPageParam = StringHelper.Format((String)"SRFDEID=%1$s&SRFDERID=%2$s", (Object)der11.getMINORDEID(), (Object)der11.getDERID());
                        strCurDEId = der11.getMINORDEID();
                    }
                    String strResourceId = "NONE";
                    if (!StringHelper.IsNullOrEmpty((String)strCurDEId)) {
                        strResourceId = UniResHelper.GetDEDataResId((String)strCurDEId);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                        Page relatedPage = page.getDAModelStorage().FindPage(strPageId);
                        if (relatedPage == null) {
                            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                            return false;
                        }
                        strPagePath = relatedPage.GetTotalPagePath();
                        strResourceId = relatedPage.getRESOURCEID(strCurDEId);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)derGroupDetail.getRESOURCEID())) {
                        strResourceId = derGroupDetail.getRESOURCEID();
                    }
                    if (!page.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)page.getWebContext(), strResourceId)) continue;
                    if (StringHelper.IsNullOrEmpty((String)strPagePath)) {
                        strPagePath = "../srfpage/gridview.jsp";
                    }
                    strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                    strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFPDEID=%1$s&SRFCAPTION=%2$s&SRFSUMMARYKEY=%3$s&SRFDGAL=FALSE", (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)derGroupDetail.getDERGROUPDETAILNAME()), (Object)iDEHelper.GetKeyDEFHelper().getName());
                    if (!StringHelper.IsNullOrEmpty((String)strDefaultPageParam)) {
                        strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                        strPagePath = String.valueOf(strPagePath) + strDefaultPageParam;
                    }
                    if (!StringHelper.IsNullOrEmpty((String)derGroupDetail.getURLPARAM())) {
                        strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                        strPagePath = String.valueOf(strPagePath) + derGroupDetail.getURLPARAM();
                    }
                    JSONObject item = new JSONObject();
                    item.put("text", (Object)derGroupDetail.getDERGROUPDETAILNAME());
                    item.put("value", (Object)strPagePath);
                    summaryList.add(item);
                    if (nActiveShowOrder == -1 || derGroupDetail.getSHOWORDER() != nActiveShowOrder) continue;
                    strSelectPath = strPagePath;
                }
            }
            gridViewModel.setSummaryList(summaryList);
            if (!StringHelper.IsNullOrEmpty((String)strSelectPath)) {
                gridViewModel.setSummaryPage(strSelectPath);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.GRIDVIEW", "\u8868\u683c\u89c6\u56fe");
    }

    @Override
    protected String OnGetPageType() {
        return "GRIDVIEW";
    }
}

