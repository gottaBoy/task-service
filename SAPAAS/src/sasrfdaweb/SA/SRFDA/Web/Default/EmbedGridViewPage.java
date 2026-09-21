/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.UserDGTheme
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.UIGear.IUIGear
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExDataGridRowActionList
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  SA.SRFramework.WebEx.UI.DataGridColumnConfig
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Config.GridViewToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.UserDGTheme;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.BaseGridViewPage;
import SA.SRFDA.Web.Default.ViewModel.GridViewModel;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.JSGear.DataGridNewEditJSGear;
import SA.SRFDA.Web.JSGear.IDataGridNewEditJSUIGear;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.UIGear.IUIGear;
import SA.SRFDA.Web.Utility.DataGridNewEditPageHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.ViewModel.DGModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDataGridRowActionList;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.UI.DataGridColumnConfig;
import java.util.TreeMap;
import net.sf.json.JSONObject;

public class EmbedGridViewPage
extends BaseGridViewPage {
    protected String strGridViewId = "";
    protected SRFExToolbar toolbar = null;
    protected DataGrid gridView = null;
    protected SRFExDataGridRowActionList dataGridRowActionList = null;
    protected SRFExDataGrid dataGrid = null;
    protected boolean bIfGridView = false;
    protected boolean bEnableDGEdit = true;
    protected String strDGMode = "";
    protected boolean bEmbedMode = true;
    protected String strDGHideDERColumnName = "";
    protected String strDataGridConfigId = "";
    protected String strToolbarConfigId = "";
    private TreeMap<String, String> tbAblilityMap = new TreeMap();
    protected JSONObject newPageInfo = null;
    protected JSONObject editPageInfo = null;
    protected boolean bInfoMode = false;
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
        this.getWebContext().SetParamValue("SRFDEID", this.strPageDataEntityId);
        this.setPageParam("GRIDVIEW", this.gridView);
        this.setPageParam("DATAGRID", this.gridView);
        this.bInfoMode = this.OnGetGridViewInfoMode();
        String strTBAblility = this.getWebContext().GetParamValue("TBABILITY");
        if (!StringHelper.IsNullOrEmpty((String)strTBAblility)) {
            String[] tbAblilitys = strTBAblility.split("[;]");
            int i = 0;
            while (i < tbAblilitys.length) {
                this.tbAblilityMap.put(tbAblilitys[i].toUpperCase(), "");
                ++i;
            }
        }
        this.bIfGridView = true;
        this.bEmbedMode = true;
        this.bEnableDGEdit = this.OnGetDataGridEditable();
        return true;
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

    protected boolean OnGetDataGrid() {
        this.strGridViewId = this.OnGetGridView();
        this.gridView = this.getWebContext().GetConfigCache().GetUserDEDataGrid(this.getWebContext(), this.strGridViewId);
        if (this.gridView == null) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe[%1$s]", (Object)this.strGridViewId));
            return false;
        }
        this.strPageDataEntityId = this.gridView.getDEID();
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

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadDataGrid();
        this.LoadToolbar();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterDataGridActionHelper(this.dataGrid.getUniqueID(), this.GetDataGridActionHelper());
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        JSONObject params = new JSONObject();
        params.put("deid", (Object)this.getPageDataEntityId());
        params.put("dgmode", (Object)this.strDGMode);
        script.Append("$P.mainview=new SRFDA.GridView(%1$s);", (Object)params.toString());
        this.RegisterOnReadyScript(3, script.toString());
        if (this.IsLoadDataGridNewEditJSGear()) {
            boolean bDGNew = true;
            boolean bDGEdit = true;
            boolean bDGDBClkEdit = true;
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
        return EmbedGridViewPage.GetDefaultDataGridActionHelper(this.getDEHelper(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }

    public static String GetDefaultDataGridActionHelper(IDEHelper iDEHelper, ISRFDAGlobalHelper globalHelper) {
        String strDGActionHelper;
        if (iDEHelper != null && !StringHelper.IsNullOrEmpty((String)iDEHelper.GetDBStorage()) && !StringHelper.IsNullOrEmpty((String)(strDGActionHelper = globalHelper.getDAModelStorage().FindDBStorage(iDEHelper.GetDBStorage()).GetProperty("DGACTIONHELPER")))) {
            return strDGActionHelper;
        }
        return globalHelper.getWebExConfig().GetValue("SRFDA", "DGACTIONHELPER", "");
    }

    protected void LoadDataGridRowActionList() {
        this.dataGridRowActionList = EmbedGridViewPage.CreateDataGridRowActionList(this, "dataGridRowActionList", 50);
        if (this.dataGridRowActionList != null && this.dataGrid != null) {
            this.dataGridRowActionList.getDataGridRowActionListConfig().setDataGridId(this.dataGrid.getUniqueID());
        }
    }

    protected void LoadDataGrid() {
        this.strDataGridConfigId = this.OnGetDataGridConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strDataGridConfigId)) {
            return;
        }
        this.dataGrid = EmbedGridViewPage.CreateDataGrid(this, "dataGrid", 0.0, 0.0, this.strDataGridConfigId);
        if (this.dataGrid != null) {
            boolean bDGHideDERColumn = true;
            this.dataGrid.setEnableItemPrivilege(this.OnGetDGItemPrivilege());
            if (!this.IsBackEndMode()) {
                this.dataGrid.getDataGridConfig().setTempData(SRFDAWebCTXHelper.IsTempDataMode((ISRFDAWebContext)this.getWebContext(), (boolean)false));
            }
            if (!this.OnGetDataGridCheckMode()) {
                this.dataGrid.getDataGridConfig().setSelectColumn(false);
            } else {
                this.LoadDataGridRowActionList();
            }
            if (!this.IsIfGridView()) {
                this.dataGrid.getDataGridConfig().setBorder(false);
            }
            if (this.bEnableDGEdit) {
                this.dataGrid.getDataGridConfig().setEditable(true);
                if (!this.IsBackEndMode()) {
                    int nClickCount = this.getPageParam("PAGE.DATAGRID.CLICKSTOEDIT", 1);
                    if (nClickCount <= 0 || nClickCount > 2) {
                        nClickCount = 1;
                    }
                    this.dataGrid.getDataGridConfig().setClicksToEdit(nClickCount);
                }
            }
            if (!this.IsBackEndMode()) {
                String strDGRowClassHelper;
                this.dataGrid.getDataGridConfig().setDeferEmptyText(false);
                int nSummaryHeight = this.OnGetDataGridSummaryHeight();
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
                StringBuilderEx script = new StringBuilderEx();
                script.Append("$P.maingrid=$P.grid['%1$s'];", (Object)this.dataGrid.getUniqueID());
                if (this.bEnableDGEdit) {
                    script.Append("$P.grid['%1$s'].on('beforeedit',function(e){if(!%2$s){e.cancel=true;}});", (Object)this.dataGrid.getUniqueID(), (Object)DataGridJSHelper.getGetDataGridEditable((String)this.dataGrid.getUniqueID()));
                }
                script.Append(DataGridJSHelper.getSetDataGridEditable((String)this.dataGrid.getUniqueID(), (boolean)this.OnGetDataGridEditableDefault()));
                String strBeforeLoadDefault = this.getPageParam("PAGE.BEFORELOADDEFAULT", "");
                if (!StringHelper.IsNullOrEmpty((String)strBeforeLoadDefault)) {
                    script.Append(strBeforeLoadDefault);
                }
                if (this.OnGetDataGridAutoLoad()) {
                    script.Append("$P.store['%1$s'].loaddefault();", (Object)this.dataGrid.getUniqueID());
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

    protected void LoadToolbar() {
        if (!this.IsBackEndMode()) {
            this.strToolbarConfigId = this.OnGetGridViewToolbarConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strToolbarConfigId)) {
                return;
            }
        }
        this.toolbar = EmbedGridViewPage.CreateToolbar(this, "toolBar", 0.0, 0.0, this.strToolbarConfigId);
        if (this.toolbar != null && !this.IsBackEndMode()) {
            this.toolbar.getToolbarConfig().setCssClass("sx-toolbarnobg");
            if (this.dataGrid != null) {
                this.toolbar.setToolbarObject("DATAGRID", (Object)this.dataGrid);
                this.toolbar.setToolbarObject("", (Object)this.dataGrid);
            }
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
                configPublishContext.setPickupMode(false);
                configPublishContext.setMiniMode(this.IsIfGridView());
                configPublishContext.setEmbedMode(this.bEmbedMode);
                configPublishContext.setReadOnlyMode(this.bInfoMode);
                configPublishContext.setEnableRowEdit(this.bEnableDGEdit);
                return this.getDAConfigHelper().GetConfigId("TOOLBAR", (IDAConfigPublishContext)configPublishContext);
            }
            return this.getDAConfigHelper().GetGridViewToolbarConfigId(this.getDEHelper(), this.page, this.gridView, false, this.IsIfGridView(), this.bEnableDGEdit, this.bInfoMode, this.bEmbedMode, null);
        }
        catch (Exception ex) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u5177\u680f\u89c6\u56fe\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return "";
        }
    }

    protected boolean OnGetDataGridEditable() {
        this.bEnableDGEdit = this.getWebContext().getWebExConfig().GetValue("SRFDA", "DGEDITABLEDEFAULT", true);
        if (!this.getDEHelper().getDataEntity().IsParamNull("ISDGROWEDIT")) {
            this.bEnableDGEdit = this.getDEHelper().getDataEntity().getISDGROWEDIT();
        }
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("ENABLEROWEDIT")) {
            this.bEnableDGEdit = this.ppGridView.getENABLEROWEDIT();
        }
        return this.getPageParam("PAGE.DATAGRID.EDITABLE", this.bEnableDGEdit);
    }

    public boolean IsIfGridView() {
        return this.bIfGridView;
    }

    public String GetLoadGridCode() {
        StringBuilderEx script = new StringBuilderEx();
        String strSummaryKey = this.getWebContext().GetParamValue("SRFSUMMARYKEY");
        if (StringHelper.IsNullOrEmpty((String)strSummaryKey)) {
            return "";
        }
        script.Append("var _UF=$V(_1._UF,false);var _TD=true;if(_UF==true||_UF=='true'){_TD=false;}");
        script.Append("$P.maingrid.gridmgr.settempdata(_TD);");
        script.Append("var _V=$V(_1.%1$s,'');", (Object)strSummaryKey);
        script.Append("var _2={'%1$s':_V};", (Object)strSummaryKey.toLowerCase());
        script.Append("if(_TD){_2['srftempdata']='TRUE';_2['%1$s']=$V(_1.SRFDATEMPKEYID,'');}", (Object)strSummaryKey.toLowerCase());
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

    protected boolean OnGetDataGridCheckMode() {
        boolean bDGCheckMode = true;
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("SELECTCOLUMN")) {
            bDGCheckMode = this.ppDataGrid.getSELECTCOLUMN();
        }
        return this.getPageParam("PAGE.DATAGRID.CHECKMODE", bDGCheckMode);
    }

    public boolean IsRenderRowActionList() {
        return this.OnGetRenderRowActionList();
    }

    protected boolean OnGetRenderRowActionList() {
        boolean bRender = true;
        return this.getPageParam("PAGE.ROWACTIONLIST.RENDER", bRender);
    }

    protected boolean OnGetDGItemPrivilege() {
        boolean bDGItemPriv = this.getDEHelper().IsEnableDEFieldPriv();
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("ITEMPRIVILEGE")) {
            bDGItemPriv = this.ppDataGrid.getITEMPRIVILEGE();
        }
        return this.getPageParam("PAGE.DATAGRID.ITEMPRIVILEGE", bDGItemPriv);
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

    protected boolean IsLoadDataGridNewEditJSGear() {
        return this.getPageParam("PAGE.LOADDGNEWEDITJSGEAR", true);
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.gridViewModel.setDGMode(this.strDGMode);
        this.gridViewModel.setGridViewId(this.strGridViewId);
        this.gridViewModel.setQuickSearch(this.OnGetQuickSearch());
        this.gridViewModel.setRowActionList(this.IsRenderRowActionList());
        this.gridViewModel.setDGEditDefault(this.OnGetDataGridEditableDefault());
        if (this.newPageInfo != null) {
            this.gridViewModel.setNewDataConfig(this.newPageInfo);
        }
        if (this.editPageInfo != null) {
            this.gridViewModel.setEditDataConfig(this.editPageInfo);
        }
        return true;
    }

    protected boolean OnGetQuickSearch() {
        return this.getPageParam("PAGE.QUICKSEARCH", false);
    }

    protected String OnGetDGFIUpdateMode() {
        return this.getPageParam("PAGE.DATAGRID.FIUPDATEMODE", "");
    }

    protected boolean OnGetDataGridHideDERColumns() {
        boolean bDGHideDERColumn = true;
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("HIDEDERCOLUMN")) {
            bDGHideDERColumn = this.ppDataGrid.getHIDEDERCOLUMN();
        }
        return this.getPageParam("PAGE.DATAGRID.HIDEDERCOLUMN", bDGHideDERColumn);
    }
}

