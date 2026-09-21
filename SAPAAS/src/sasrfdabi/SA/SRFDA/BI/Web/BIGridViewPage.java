/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.SearchForm
 *  SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExDataGridRowActionList
 *  SA.SRFramework.WebEx.SRFExDataGridRowCountList
 *  SA.SRFramework.WebEx.SRFExDataGridThemeList
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.Script.StoreJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig
 *  SA.SRFramework.WebEx.UI.DataGridColumnConfig
 *  SA.SRFramework.WebEx.UI.DataGridThemeConfig
 *  SA.SRFramework.WebEx.UI.DataGridThemeGroupConfig
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Ctrl.Data.BICubeSrc;
import SA.SRFDA.BI.Web.JSGear.BIDataGridDrillJSGear;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDataGridRowActionList;
import SA.SRFramework.WebEx.SRFExDataGridRowCountList;
import SA.SRFramework.WebEx.SRFExDataGridThemeList;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.Script.StoreJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnConfig;
import SA.SRFramework.WebEx.UI.DataGridThemeConfig;
import SA.SRFramework.WebEx.UI.DataGridThemeGroupConfig;
import java.util.Iterator;
import java.util.Vector;
import net.sf.json.JSONObject;

public class BIGridViewPage
extends BaseMainPage {
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
    protected boolean bRenderSP = true;
    protected boolean bEnableDGEdit = true;
    protected boolean bInfoMode = false;
    protected String strDGMode = "";
    protected boolean bCustomTheme = true;
    protected boolean bEmbedMode = false;
    private String strToolbarConfigId = "";
    private String strSPExConfigId = "";
    private String strDataGridConfigId = "";
    protected JSONObject newPageInfo = null;
    protected JSONObject editPageInfo = null;
    protected String strDGHideDERColumnName = "";
    protected boolean bHasCubeSrc = false;

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
        this.bEmbedMode = this.OnGetEmbedMode();
        this.bInfoMode = this.OnGetGridViewInfoMode();
        boolean bl = this.bIfGridView = StringHelper.Compare((String)this.getWebContext().GetParamValue("SRFIFVIEW"), (String)"TRUE", (boolean)true) == 0;
        if (!this.bEmbedMode) {
            this.strSummaryMode = this.getWebContext().getSRFGVSMode();
            if (StringHelper.IsNullOrEmpty((String)this.strSummaryMode)) {
                this.strSummaryMode = this.getPageParam("PAGE.SUMMARY", "");
            }
            this.bGVTheme = this.OnGetGVTheme();
            this.bRenderSP = this.OnGetRenderSP();
            this.bCustomTheme = this.OnGetDataGridCustomTheme();
        } else {
            this.bRenderSP = false;
            this.strSummaryMode = "";
            this.bGVTheme = false;
        }
        this.bEnableDGEdit = this.OnGetDataGridEditable();
        return true;
    }

    protected boolean OnGetRenderSP() {
        return this.getPageParam("PAGE.SP.RENDER", true);
    }

    protected boolean OnGetDataGridEditable() {
        return false;
    }

    protected boolean OnGetEmbedMode() {
        return SRFDAWebCTXHelper.IsEmbedMode((ISRFDAWebContext)this.getWebContext(), (boolean)this.bEmbedMode);
    }

    protected boolean OnGetGridViewInfoMode() {
        return true;
    }

    protected boolean OnGetDataGrid() {
        this.strGridViewId = this.OnGetGridView();
        if (!StringHelper.IsNullOrEmpty((String)this.strGridViewId)) {
            this.gridView = this.getWebContext().GetConfigCache().GetUserDEDataGrid(this.getWebContext(), this.strGridViewId);
            if (this.gridView == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe[%1$s]", (Object)this.strGridViewId));
                return false;
            }
            this.strPageDataEntityId = this.gridView.getDEID();
        } else {
            this.list = new Vector();
            CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetUserDEDataGrids(this.getWebContext().getCurUserId(), this.getPageDataEntityId(), this.strDGMode, this.list);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog((Object)this, "\u83b7\u53d6\u5b9e\u4f53\u9ed8\u8ba4\u8868\u683c\u89c6\u56fe\u5931\u8d25", callResult);
                return false;
            }
            Iterator<DataGrid> iterator = this.list.iterator();
            if (iterator.hasNext()) {
                DataGrid dataGrid;
                this.gridView = dataGrid = iterator.next();
            }
            if (this.gridView == null) {
                this.PageLog((Object)this, "\u6ca1\u6709\u83b7\u53d6\u5230\u7b26\u5408\u8981\u6c42\u7684\u6570\u636e\u8868\u683c", callResult);
                return false;
            }
            this.strGridViewId = this.gridView.getDATAGRIDID();
            this.getWebContext().SetParamValue("SRFGRIDVIEW", this.strGridViewId);
        }
        return true;
    }

    protected String OnGetGridView() {
        return this.getWebContext().getSRFGridView();
    }

    protected boolean OnGetGVTheme() {
        String strParamValue = this.getWebContext().GetParamValue("SRFGVTHEME");
        if (!StringHelper.IsNullOrEmpty((String)strParamValue)) {
            return StringHelper.Compare((String)this.getWebContext().GetParamValue("SRFGVTHEME"), (String)"FALSE", (boolean)true) != 0;
        }
        return this.getPageParam("PAGE.DGTHEME", true);
    }

    protected String OnGetPageCaption() {
        String strGridCaption = this.getWebContext().GetParamValue("SRFCAPTION");
        if (!StringHelper.IsNullOrEmpty((String)strGridCaption)) {
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
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
        this.RegisterDataGridActionHelper(this.dataGrid.getUniqueID(), this.GetDataGridActionHelper());
    }

    protected void OnInit() {
        String strStoreLoadCode;
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        JSONObject params = new JSONObject();
        params.put("deid", (Object)this.getPageDataEntityId());
        params.put("dgmode", (Object)this.strDGMode);
        if (this.spEx != null) {
            params.put("spid", (Object)this.spEx.getUniqueID());
            params.put("spcs", false);
        }
        script.Append("$P.mainview=new SRFDA.GridView(%1$s);", (Object)params.toString());
        this.RegisterOnReadyScript(3, script.toString());
        String strSQL = "";
        strSQL = String.valueOf(strSQL) + " select t1.* from t_SRFBICUBESRC t1 ";
        strSQL = String.valueOf(strSQL) + " LEFT JOIN T_SRFBICUBE t2 ON t1.BICUBEID = t2.BICUBEID ";
        strSQL = String.valueOf(strSQL) + " LEFT JOIN T_SRFDATAENTITY t3 ON t2.DEID = t3.DEID where t2.DEID='%1$s' ";
        strSQL = StringHelper.Format((String)strSQL, (Object)this.strPageDataEntityId);
        Vector cubeSrcList = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, cubeSrcList, (String)BICubeSrc.class.getName());
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]\u76f8\u5173\u5206\u6790\u6e90\u6570\u636e\u5931\u8d25\uff0c%2$s", (Object)this.strPageDataEntityId, (Object)callResult.getErrorInfo()));
            this.OutputAlertMsg("\u67e5\u8be2\u5b9e\u4f53\u76f8\u5173\u5206\u6790\u6e90\u6570\u636e\u5931\u8d25\uff01", true);
            return;
        }
        this.setPageParam("BICUBESRCCNT", cubeSrcList.size());
        if (cubeSrcList.size() == 1) {
            this.setPageParam("BICUBESRCID", ((BICubeSrc)((Object)cubeSrcList.get(0))).getBICUBESRCID());
        }
        this.setPageParam("BICUBESRCLIST", cubeSrcList);
        this.bHasCubeSrc = cubeSrcList.size() != 0;
        BIDataGridDrillJSGear.Load((SRFDAPage)this, this.dataGrid);
        if (this.getDefaultForm() != null) {
            this.RegisterOnReadyScript(3, FormJSHelper.getLoadDefaultScript((SRFExForm)((SRFExSearchForm)this.getDefaultForm())));
        }
        if (!StringHelper.IsNullOrEmpty((String)(strStoreLoadCode = this.getPageParam("PAGE.DATAGRID.LOADEDCODE", "")))) {
            this.RegisterOnReadyScript(3, StoreJSHelper.getOnLoadEventScript((String)this.dataGrid.getUniqueID(), (String)strStoreLoadCode));
        }
    }

    protected String GetSearchFormActionHelper() {
        String strSearchFormActionHelper = this.getPageParam("PAGE.SPACTIONHELPER", "");
        if (StringHelper.IsNullOrEmpty((String)strSearchFormActionHelper)) {
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
        return "SA.SRFDA.BI.Ctrl.DataGrid.BIDataGridActionHelper";
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
            this.dataGridThemeList = BIGridViewPage.CreateDataGridThemeList((SRFExPage)this, (String)"dataGridThemeList", (int)1);
            if (!this.IsBackEndMode()) {
                this.dataGridThemeList.getDataGridThemeListConfig().setCustomTheme(this.bCustomTheme);
                try {
                    if (this.list == null) {
                        this.list = new Vector();
                        CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetUserDEDataGrids(this.getWebContext().getCurUserId(), this.getPageDataEntityId(), this.strDGMode, this.list);
                        if ((callResult = CallResult.ToCallResult((CallResult)callResult)).IsError()) {
                            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u5b9e\u4f53[%1$s]\u8868\u683c\u5931\u8d25\uff0c%2$s", (Object)this.getPageDataEntityId(), (Object)callResult.getErrorInfo()));
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
                    ex.printStackTrace();
                }
            }
        }
    }

    protected void LoadDataGridRowActionList() {
        this.dataGridRowActionList = BIGridViewPage.CreateDataGridRowActionList((SRFDAPage)this, (String)"dataGridRowActionList", (int)50);
        if (this.dataGridRowActionList != null && this.dataGrid != null) {
            this.dataGridRowActionList.getDataGridRowActionListConfig().setDataGridId(this.dataGrid.getUniqueID());
        }
    }

    protected void LoadDataGridRowCountList() {
        this.dataGridRowCountList = BIGridViewPage.CreateDataGridRowCountList((SRFDAPage)this, (String)"dataGridRowCountList", (int)50);
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
        this.dataGrid = BIGridViewPage.CreateDataGrid((SRFDAPage)this, (String)"dataGrid", (double)0.0, (double)0.0, (String)this.strDataGridConfigId);
        if (this.dataGrid != null) {
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
                    int nClickCount = this.getPageParam("PAGE.DATAGRID.CLICKSTOEDIT", 1);
                    if (nClickCount <= 0 || nClickCount > 2) {
                        nClickCount = 1;
                    }
                    this.dataGrid.getDataGridConfig().setClicksToEdit(nClickCount);
                }
            }
            if (!this.IsBackEndMode()) {
                this.dataGrid.getDataGridConfig().setDeferEmptyText(this.OnGetDataGridDeferEmptyText());
                String strDGRowClassHelper = this.OnGetDataGridRowClassHelper();
                if (strDGRowClassHelper != null) {
                    this.dataGrid.getDataGridConfig().setRowClassHelper(strDGRowClassHelper);
                }
                if (this.getPageParam("PAGE.DATAGRID.HIDEDERCOLUMN", true)) {
                    String strFilter;
                    String strDERID = this.getWebContext().getSRFDERID();
                    if (!StringHelper.IsNullOrEmpty((String)strDERID)) {
                        IPickupDEFHelper pickupDEFHelper = null;
                        for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                            IPickupDEFHelper linkDEFHelper;
                            if (!iDEFHelper.IsLinkDEField() || !(iDEFHelper instanceof IPickupDEFHelper) || StringHelper.Compare((String)(linkDEFHelper = (IPickupDEFHelper)iDEFHelper).GetDERId(), (String)strDERID, (boolean)true) != 0 || StringHelper.Compare((String)linkDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) != 0) continue;
                            pickupDEFHelper = linkDEFHelper;
                            break;
                        }
                        if (pickupDEFHelper != null) {
                            DataGridColumnConfig dgColumnConfig = this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().FindDataGridColumnConfigById(pickupDEFHelper.getName());
                            if (dgColumnConfig != null) {
                                this.strDGHideDERColumnName = pickupDEFHelper.getName();
                                dgColumnConfig.setHidden(true);
                            }
                            if ((dgColumnConfig = this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().FindDataGridColumnConfigById(pickupDEFHelper.GetPickupTextDEFHelper().getName())) != null) {
                                this.strDGHideDERColumnName = pickupDEFHelper.GetPickupTextDEFHelper().getName();
                                dgColumnConfig.setHidden(true);
                            }
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
                String strBeforeLoadDefault = this.getPageParam("PAGE.BEFORELOADDEFAULT", "");
                if (!StringHelper.IsNullOrEmpty((String)strBeforeLoadDefault)) {
                    script.Append(strBeforeLoadDefault);
                }
                if (this.OnGetDataGridAutoLoad()) {
                    script.Append("$P.store['%1$s'].loaddefault();", (Object)this.dataGrid.getUniqueID());
                }
                this.RegisterOnReadyScript(3, script.toString());
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
        this.toolbar = BIGridViewPage.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)this.strToolbarConfigId);
        if (this.toolbar != null && !this.IsBackEndMode()) {
            this.toolbar.getToolbarConfig().setCssClass("sx-toolbarnobg");
            if (this.dataGrid != null) {
                this.toolbar.setToolbarObject("DATAGRID", (Object)this.dataGrid);
                this.toolbar.setToolbarObject("", (Object)this.dataGrid);
            }
            this.toolbar.setToolbarObject("SPEX", (Object)this.spEx);
        }
    }

    protected String OnGetGridViewToolbarConfigId() {
        if (this.IsContainPageParam("PAGE.TOOLBAR")) {
            return this.getPageParam("PAGE.TOOLBAR", "");
        }
        return this.getDAConfigHelper().GetGridViewToolbarConfigId(this.getDEHelper(), this.page, this.gridView, false, this.IsIfGridView(), this.bEnableDGEdit, this.bInfoMode, this.bEmbedMode, null);
    }

    protected void LoadSPEx() {
        if (this.bRenderSP) {
            this.strSPExConfigId = this.OnGetSPExConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strSPExConfigId)) {
                return;
            }
            this.spEx = BIGridViewPage.CreateSPEx((SRFDAPage)this, (String)"spEx", (String)this.strSPExConfigId);
            if (this.spEx != null) {
                this.spEx.getSPExConfig().setWidth(1024);
            }
        }
    }

    protected String OnGetSPExConfigId() {
        String strSPExConfigId = this.getPageParam("PAGE.SP", "");
        if (!StringHelper.IsNullOrEmpty((String)strSPExConfigId)) {
            return strSPExConfigId;
        }
        boolean bDefaultSF = false;
        String strSearchformId = this.getPageParam("PAGE.SEARCHFORM", "");
        if (StringHelper.IsNullOrEmpty((String)strSearchformId) && this.getWebContext().getWebExConfig().GetValue("SRFDA", "DEFAULTSEARCHFORM", false)) {
            bDefaultSF = true;
            strSearchformId = StringHelper.Format((String)"%1$s_DEFAULTSF", (Object)this.getDEHelper().getId());
        }
        if (!StringHelper.IsNullOrEmpty((String)strSearchformId)) {
            SearchForm searchForm = this.getWebContext().GetConfigCache().GetDESearchForm(this.getWebContext(), strSearchformId, bDefaultSF);
            if (searchForm != null) {
                return this.getDAConfigHelper().GetSPExId(this.getDEHelper(), searchForm);
            }
            if (!bDefaultSF) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u641c\u7d22\u8868\u5355[%1$s]", (Object)strSearchformId));
                return "";
            }
        }
        return this.getDAConfigHelper().GetGridViewSPExConfigId(this.getDEHelper(), this.gridView);
    }

    public boolean IsIfGridView() {
        return this.bIfGridView;
    }

    public boolean IsRenderDataGridTheme() {
        if (this.bEmbedMode) {
            return false;
        }
        return this.bGVTheme;
    }

    public int GetCaptionWidth() {
        return this.OnGetCaptionWidth();
    }

    protected int OnGetCaptionWidth() {
        return this.getPageParam("PAGE.CAPTIONWIDTH", 60);
    }

    public boolean IsRenderCaption() {
        if (this.bEmbedMode || this.bIfGridView) {
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

    protected String OnGetDataGridMode() {
        return this.getPageParam("PAGE.DGMODE", "DEFAULT");
    }

    protected boolean OnGetDataGridAutoLoad() {
        if (this.IsContainPageParam("PAGE.DATAGRID.AUTOLOAD")) {
            return StringHelper.Compare((String)this.getPageParam("PAGE.DATAGRID.AUTOLOAD", "TRUE"), (String)"TRUE", (boolean)true) == 0;
        }
        return this.getWebContext().GetSRFDGAutoLoad();
    }

    protected boolean OnGetDataGridDeferEmptyText() {
        return false;
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

    protected boolean OnGetDataGridCheckMode() {
        return this.getPageParam("PAGE.DATAGRID.CHECKMODE", false);
    }

    public String GetSPExDPUniqueId() {
        return this.spEx.getPanel().getUniqueID();
    }

    protected boolean OnGetDataGridCustomTheme() {
        boolean bDGCustomTheme = this.getWebContext().getWebExConfig().GetValue("SRFDA", "DGCUSTOMTHEME", true);
        bDGCustomTheme = this.getPageParam("PAGE.DATAGRID.CUSTOMTHEME", bDGCustomTheme);
        return bDGCustomTheme;
    }

    public boolean IsRenderSP() {
        return this.bRenderSP;
    }

    protected String OnGetPageHeader() {
        if (this.bHasCubeSrc) {
            String strMeasure = this.getWebContext().GetParamValue("SRFBIMEASURE");
            if (!StringHelper.IsNullOrEmpty((String)strMeasure)) {
                strMeasure = strMeasure.replace("[Measures].[", "");
                strMeasure = strMeasure.substring(0, strMeasure.length() - 1);
                return StringHelper.Format((String)"\u53cc\u51fb\u94bb\u53d6\u6307\u6807\u3010%1$s\u3011\u539f\u59cb\u6570\u636e", (Object)strMeasure);
            }
            return StringHelper.Format((String)"\u53cc\u51fb\u94bb\u53d6\u539f\u59cb\u6570\u636e", (Object)strMeasure);
        }
        return StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49\u7acb\u65b9\u4f53\u6e90\u6570\u636e\uff0c\u65e0\u6cd5\u94bb\u53d6\u539f\u59cb\u6570\u636e");
    }
}

