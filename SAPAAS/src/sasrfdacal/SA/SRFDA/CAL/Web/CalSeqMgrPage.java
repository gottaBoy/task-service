/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.Default.GridViewPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.JSGear.DataGridNewEditJSGear
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExDataGridRowActionList
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 */
package SA.SRFDA.CAL.Web;

import SA.SRFDA.CAL.Ctrl.Data.Calendar;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.GridViewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.JSGear.DataGridNewEditJSGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDataGridRowActionList;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;

public class CalSeqMgrPage
extends BaseMainPage {
    protected String strGridViewId = "";
    protected DataGrid gridView = null;
    protected SRFExDataGrid dataGrid = null;
    protected SRFExDataGridRowActionList dataGridRowActionList = null;
    protected SRFExToolbar toolbar = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.getWebContext().SetParamValue("SRFDEID", "DE0120");
        this.strPageDataEntityId = "DE0120";
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        this.gridView = this.getWebContext().GetConfigCache().GetUserDEDataGrid(this.getWebContext(), "DE0120_DATAGRID_002");
        if (this.gridView == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe[%1$s]", (Object)"DE0120_DATAGRID_002"));
            return false;
        }
        this.setPageParam("GRIDVIEW", this.gridView);
        String strCalendarId = this.getWebContext().GetParamValue("CALENDARID");
        if (StringHelper.IsNullOrEmpty((String)strCalendarId)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u65e5\u5386\u7f16\u53f7");
            return false;
        }
        Calendar calendar = new Calendar();
        calendar.setCALENDARID(strCalendarId);
        IDEDataCtrl iCalendarDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0050", (ISRFDAWebContext)this.getWebContext());
        if (iCalendarDataCtrl == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0050"));
            return false;
        }
        CallResult callResult = iCalendarDataCtrl.Get((BaseDataEntity)calendar);
        if (callResult.IsError()) {
            this.PageLog((Object)this, "\u83b7\u53d6\u6307\u5b9a\u65e5\u5386\u6570\u636e\u5931\u8d25", callResult);
            return false;
        }
        String strCalSeqId = calendar.getCALSEQID();
        if (StringHelper.IsNullOrEmpty((String)strCalSeqId)) {
            strCalSeqId = Helper.GenGuidEx();
            Calendar calseq = new Calendar();
            calendar.CopyTo(calseq, true);
            calseq.setCALENDARID(strCalSeqId);
            calseq.setCALSEQID(strCalSeqId);
            callResult = iCalendarDataCtrl.Save(true, (BaseDataEntity)calseq);
            if (callResult.IsError()) {
                this.PageLog((Object)this, "\u5efa\u7acb\u5e8f\u5217\u65e5\u5386\u6570\u636e\u5931\u8d25", callResult);
                return false;
            }
            calendar.setCALSEQID(strCalSeqId);
            callResult = iCalendarDataCtrl.Save(false, (BaseDataEntity)calendar);
            if (callResult.IsError()) {
                this.PageLog((Object)this, "\u66f4\u65b0\u65e5\u5386\u6570\u636e\u5931\u8d25", callResult);
                return false;
            }
        }
        this.getWebContext().SetParamValue("CALENDARID", strCalSeqId);
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadDataGrid();
        this.LoadToolbar();
        this.LoadButton();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterDataGridActionHelper(this.dataGrid.getUniqueID(), this.GetDataGridActionHelper());
    }

    protected void OnInit() {
        super.OnInit();
        DataGridNewEditJSGear.Load((SRFDAPage)this, (SRFExDataGrid)this.dataGrid);
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
        return GridViewPage.GetDefaultDataGridActionHelper((IDEHelper)this.getDEHelper(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }

    protected void LoadDataGridRowActionList() {
        this.dataGridRowActionList = CalSeqMgrPage.CreateDataGridRowActionList((SRFDAPage)this, (String)"dataGridRowActionList", (int)50);
        if (this.dataGridRowActionList != null && this.dataGrid != null) {
            this.dataGridRowActionList.getDataGridRowActionListConfig().setDataGridId(this.dataGrid.getUniqueID());
        }
    }

    protected void LoadToolbar() {
        this.toolbar = CalSeqMgrPage.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)"SRFCAL.TB_CALSEQMGR");
        if (this.toolbar != null && !this.IsBackEndMode()) {
            this.toolbar.getToolbarConfig().setCssClass("sx-toolbarnobg");
            if (this.dataGrid != null) {
                this.toolbar.setToolbarObject("DATAGRID", (Object)this.dataGrid);
                this.toolbar.setToolbarObject("", (Object)this.dataGrid);
            }
        }
    }

    protected void LoadDataGrid() {
        String strDataGridConfigId = this.getDAConfigHelper().GetGridViewDGConfigId(this.getDEHelper(), this.page, this.gridView);
        if (StringHelper.IsNullOrEmpty((String)strDataGridConfigId)) {
            return;
        }
        this.dataGrid = CalSeqMgrPage.CreateDataGrid((SRFDAPage)this, (String)"dataGrid", (double)0.0, (double)0.0, (String)strDataGridConfigId);
        if (this.dataGrid != null) {
            this.dataGrid.getDataGridConfig().setSelectColumn(true);
            this.dataGrid.getDataGridConfig().setEditable(false);
            this.LoadDataGridRowActionList();
            if (!this.IsBackEndMode()) {
                this.dataGrid.getDataGridConfig().setLoadDefault(true);
            }
            if (!this.IsBackEndMode()) {
                StringBuilderEx script = new StringBuilderEx();
                script.Append("$P.maingrid=$P.grid['%1$s'];", (Object)this.dataGrid.getUniqueID());
                script.Append("$P.store['%1$s'].loaddefault();", (Object)this.dataGrid.getUniqueID());
                this.RegisterOnReadyScript(3, script.toString());
            }
        }
    }

    public String OutputPageCaption() {
        return String.valueOf(super.OutputPageCaption()) + "\u9009\u62e9";
    }

    protected void LoadButton() {
        SRFExButton CancelButton = new SRFExButton();
        CancelButton.InitConfig();
        CancelButton.setID("CancelButton");
        CancelButton.getButtonConfig().setText("\u5173\u95ed\u7a97\u53e3");
        CancelButton.getButtonConfig().setTips("\u5173\u95ed\u7a97\u53e3");
        CancelButton.setResourceId("");
        this.AddControl((SRFExControl)CancelButton);
        StringBuilderEx script = new StringBuilderEx();
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'cancel'"));
        script.Append(BrowserJSHelper.getCloseWindowScript());
        CancelButton.getButtonConfig().setJSCode(script.toString());
    }
}

