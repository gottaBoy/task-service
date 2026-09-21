/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExDataGridRowActionList
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.GridViewPage;
import SA.SRFDA.Web.JSGear.DataGridNewEditJSGear;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDataGridRowActionList;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;

public class PopupGridViewPage
extends BaseMainPage {
    protected String strGridViewId = "";
    protected DataGrid gridView = new DataGrid();
    protected SRFExDataGrid dataGrid = null;
    protected SRFExDataGridRowActionList dataGridRowActionList = null;
    protected SRFExToolbar toolbar = null;
    protected boolean bEnableDGEdit = true;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (!this.OnGetDataGrid()) {
            return false;
        }
        this.bEnableDGEdit = this.OnGetDataGridEditable();
        this.setPageParam("GRIDVIEW", this.gridView);
        return true;
    }

    protected boolean OnGetDataGrid() {
        this.strGridViewId = this.getWebContext().getSRFGridView();
        if (!StringHelper.IsNullOrEmpty((String)this.strGridViewId)) {
            this.gridView = this.getWebContext().GetConfigCache().GetUserDEDataGrid(this.getWebContext(), this.strGridViewId);
            if (this.gridView == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe[%1$s]", (Object)this.strGridViewId));
                return false;
            }
            this.strPageDataEntityId = this.gridView.getDEID();
        } else {
            CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetDefaultDEDataGrid(this.strPageDataEntityId, this.gridView);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog(this, "\u83b7\u53d6\u5b9e\u4f53\u9ed8\u8ba4\u8868\u683c\u89c6\u56fe\u5931\u8d25", callResult);
                return false;
            }
            this.strGridViewId = this.gridView.getDATAGRIDID();
            this.getWebContext().SetParamValue("SRFGRIDVIEW", this.strGridViewId);
        }
        return true;
    }

    protected boolean OnGetDataGridEditable() {
        this.bEnableDGEdit = this.getWebContext().getWebExConfig().GetValue("SRFDA", "DGEDITABLEDEFAULT", true);
        return this.getPageParam("PAGE.DATAGRID.EDITABLE", this.bEnableDGEdit);
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

    @Override
    protected void OnInit() {
        super.OnInit();
        DataGridNewEditJSGear.Load(this, this.dataGrid);
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

    protected void LoadDataGridRowActionList() {
        this.dataGridRowActionList = PopupGridViewPage.CreateDataGridRowActionList(this, "dataGridRowActionList", 50);
        if (this.dataGridRowActionList != null && this.dataGrid != null) {
            this.dataGridRowActionList.getDataGridRowActionListConfig().setDataGridId(this.dataGrid.getUniqueID());
        }
    }

    protected void LoadToolbar() {
        String strToolbarConfigId = "";
        if (!this.IsBackEndMode() && StringHelper.IsNullOrEmpty((String)(strToolbarConfigId = this.OnGetGridViewToolbarConfigId()))) {
            return;
        }
        this.toolbar = PopupGridViewPage.CreateToolbar(this, "toolBar", 0.0, 0.0, strToolbarConfigId);
        if (this.toolbar != null && !this.IsBackEndMode()) {
            this.toolbar.getToolbarConfig().setCssClass("sx-toolbarnobg");
            if (this.dataGrid != null) {
                this.toolbar.setToolbarObject("DATAGRID", (Object)this.dataGrid);
                this.toolbar.setToolbarObject("", (Object)this.dataGrid);
            }
        }
    }

    protected String OnGetGridViewToolbarConfigId() {
        return this.getDAConfigHelper().GetGridViewToolbarConfigId(this.getDEHelper(), this.page, this.gridView, false, false, this.bEnableDGEdit, false, false, null);
    }

    protected void LoadDataGrid() {
        String strDataGridConfigId = this.getDAConfigHelper().GetGridViewDGConfigId(this.getDEHelper(), this.page, this.gridView, this.getWebContext().getSRFDERID());
        if (StringHelper.IsNullOrEmpty((String)strDataGridConfigId)) {
            return;
        }
        this.dataGrid = PopupGridViewPage.CreateDataGrid(this, "dataGrid", 0.0, 0.0, strDataGridConfigId);
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

    @Override
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

