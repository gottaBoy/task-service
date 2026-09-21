/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.GridViewPage;
import SA.SRFDA.Web.JSGear.DataGridNewEditJSGear;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;

public class PickupPage
extends BaseMainPage {
    protected String strGridViewId = "";
    protected DataGrid gridView = new DataGrid();
    protected SRFExSPEx spEx = null;
    protected SRFExDataGrid dataGrid = null;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        CallResult callResult = this.getDAModelHelper().GetDefaultPickupDEDataGrid(this.strPageDataEntityId, this.gridView, "DEFAULT");
        if (callResult == null || callResult.getRetCode() != 0) {
            this.PageLog(this, "\u83b7\u53d6\u5b9e\u4f53\u62fe\u53d6\u8868\u683c\u89c6\u56fe\u5931\u8d25", callResult);
            return false;
        }
        this.setPageParam("GRIDVIEW", this.gridView);
        this.setPageParam("PICKUPMODE", true);
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadSPEx();
        this.LoadDataGrid();
        this.LoadButton();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
        this.RegisterDataGridActionHelper(this.dataGrid.getUniqueID(), this.GetDataGridActionHelper());
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        DataGridNewEditJSGear.Load(this, this.dataGrid, true, false, false);
    }

    protected String GetSearchFormActionHelper() {
        return BaseDASearchFormActionHelper.class.getName();
    }

    protected String GetDataGridActionHelper() {
        if (!StringHelper.IsNullOrEmpty((String)this.gridView.getBACKENDCTRL())) {
            return this.gridView.getBACKENDCTRL();
        }
        String strDGActionHelper = this.getPageParam("PAGE.DGACTIONHELPER", "");
        if (!StringHelper.IsNullOrEmpty((String)strDGActionHelper)) {
            return strDGActionHelper;
        }
        return GridViewPage.GetDefaultDataGridActionHelper(this.getDEHelper(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }

    protected void LoadDataGrid() {
        String strDataGridConfigId = this.getDAConfigHelper().GetGridViewDGConfigId(this.getDEHelper(), this.page, this.gridView, this.getWebContext().getSRFDERID());
        if (StringHelper.IsNullOrEmpty((String)strDataGridConfigId)) {
            return;
        }
        this.dataGrid = PickupPage.CreateDataGrid(this, "dataGrid", 0.0, 0.0, strDataGridConfigId);
        if (this.dataGrid != null) {
            this.dataGrid.getDataGridConfig().setSelectColumn(false);
            if (!this.IsBackEndMode()) {
                this.spEx.getSearchForm().setUserParamsName(StringHelper.Format((String)"$P.store['%1$s'].userparams", (Object)this.dataGrid.getUniqueID()));
                this.spEx.getSearchForm().getSearchAction().getSuccessAction().RegisterProcessCode(0, StringHelper.Format((String)"$P.store['%1$s'].loaddefault();", (Object)this.dataGrid.getUniqueID()));
                this.RegisterOnReadyScript(3, StringHelper.Format((String)"$P.maingrid=$P.grid['%1$s'];$P.maingrid.gridmgr.seteditable(false);$P.store['%1$s'].loaddefault();", (Object)this.dataGrid.getUniqueID()));
            }
        }
    }

    protected void LoadSPEx() {
        String strSPExConfigId = this.getDAConfigHelper().GetGridViewSPExConfigId(this.getDEHelper(), this.gridView);
        if (StringHelper.IsNullOrEmpty((String)strSPExConfigId)) {
            return;
        }
        this.spEx = PickupPage.CreateSPEx(this, "spEx", strSPExConfigId);
        if (this.spEx != null) {
            this.spEx.getSPExConfig().setWidth(1024);
        }
    }

    @Override
    public String OutputPageCaption() {
        return String.valueOf(super.OutputPageCaption()) + "\u9009\u62e9";
    }

    protected void LoadButton() {
        StringBuilderEx script;
        SRFExButton OkButton = new SRFExButton();
        OkButton.InitConfig();
        OkButton.setID("OkButton");
        OkButton.getButtonConfig().setText("\u786e\u5b9a\u9009\u62e9");
        OkButton.getButtonConfig().setTips("\u786e\u5b9a\u9009\u62e9");
        OkButton.setResourceId("");
        this.AddControl((SRFExControl)OkButton);
        if (!this.IsBackEndMode()) {
            script = new StringBuilderEx();
            script.Append("var _1= %1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecord((String)this.dataGrid.getUniqueID()));
            script.Append("if(_1==null){alert('\u6ca1\u6709\u9009\u62e9\u6570\u636e!');return;}\r\n");
            if (StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFVDEF().toUpperCase())) {
                script.Append("var _v = _1.get('%1$s');\r\n", (Object)this.getDEHelper().GetKeyDEFHelper().getName().toUpperCase());
            } else {
                script.Append("var _v = _1.get('%1$s');\r\n", (Object)this.getWebContext().getSRFVDEF().toUpperCase());
            }
            script.Append("var _t = _1.get('%1$s');\r\n", (Object)"srfmajortext");
            script.Append("if(_t == null){_t = _1.get('%1$s'); }\r\n", (Object)"SRFMAJORTEXT");
            script.Append(BrowserJSHelper.getResetDialogReturnValue());
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"text", (String)"_t"));
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"value", (String)"_v"));
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
            script.Append(BrowserJSHelper.getCloseWindowScript());
            OkButton.getButtonConfig().setJSCode(script.toString());
            this.RegisterOnReadyScript(3, DataGridJSHelper.getOnRowDbClickedEventScript((String)this.dataGrid.getUniqueID(), (String)script.toString()));
        }
        SRFExButton CancelButton = new SRFExButton();
        CancelButton.InitConfig();
        CancelButton.setID("CancelButton");
        CancelButton.getButtonConfig().setText("\u53d6\u6d88\u64cd\u4f5c");
        CancelButton.getButtonConfig().setTips("\u53d6\u6d88\u64cd\u4f5c");
        CancelButton.setResourceId("");
        this.AddControl((SRFExControl)CancelButton);
        script = new StringBuilderEx();
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'cancel'"));
        script.Append(BrowserJSHelper.getCloseWindowScript());
        CancelButton.getButtonConfig().setJSCode(script.toString());
        SRFExButton ResetButton = new SRFExButton();
        ResetButton.InitConfig();
        ResetButton.setID("ResetButton");
        ResetButton.getButtonConfig().setText("\u6e05\u7a7a\u9009\u62e9");
        ResetButton.getButtonConfig().setTips("\u6e05\u7a7a\u9009\u62e9");
        ResetButton.setResourceId("");
        this.AddControl((SRFExControl)ResetButton);
        script = new StringBuilderEx();
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"text", (String)"''"));
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"value", (String)"''"));
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
        script.Append(BrowserJSHelper.getCloseWindowScript());
        ResetButton.getButtonConfig().setJSCode(script.toString());
        SRFExButton NewButton = new SRFExButton();
        NewButton.InitConfig();
        NewButton.setID("NewButton");
        NewButton.getButtonConfig().setText("\u65b0\u5efa" + this.getDEHelper().getDataEntity().getDELOGICNAME());
        NewButton.getButtonConfig().setTips("\u65b0\u5efa" + this.getDEHelper().getDataEntity().getDELOGICNAME());
        NewButton.setResourceId("");
        this.AddControl((SRFExControl)NewButton);
        if (!this.IsBackEndMode()) {
            NewButton.getButtonConfig().setJSCode(StringHelper.Format((String)"$P.grid['%1$s']._new();", (Object)this.dataGrid.getUniqueID()));
        }
    }
}

