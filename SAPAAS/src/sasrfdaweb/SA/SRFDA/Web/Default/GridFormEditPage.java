/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.EditViewPage2;
import SA.SRFDA.Web.Default.ViewModel.GridFormEditPageModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.ViewModel.DGModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import java.util.Iterator;
import java.util.Vector;

public class GridFormEditPage
extends EditViewPage2 {
    protected SRFExDataGrid dataGrid = null;
    protected DataGrid gridView = null;
    protected String strDGMode = "";
    protected String strGridViewId = "";
    protected String strDataGridActionHelper = "";
    protected GridFormEditPageModel gridFormEditPageModel = null;
    private String strDataGridConfigId = "";

    @Override
    protected boolean PreparePageEnv() {
        boolean bPrepared = super.PreparePageEnv();
        if (!bPrepared) {
            return bPrepared;
        }
        this.strDGMode = this.OnGetDataGridMode();
        if (!this.OnGetDataGrid()) {
            return false;
        }
        this.setPageParam("GRIDVIEW", this.gridView);
        this.getWebContext().SetParamValue("SRFGRIDVIEW", this.strGridViewId);
        this.setPageParam(this.strGridViewId, this.gridView);
        return true;
    }

    @Override
    protected PageModel CreatePageModel() {
        return new GridFormEditPageModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.gridFormEditPageModel = (GridFormEditPageModel)this.pageModel;
    }

    @Override
    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadDataGrid();
    }

    @Override
    protected void LoadToolbar() {
    }

    protected void LoadDataGrid() {
        this.strDataGridConfigId = this.OnGetDataGridConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strDataGridConfigId)) {
            return;
        }
        this.dataGrid = GridFormEditPage.CreateDataGrid(this, "dataGrid", 200.0, 300.0, this.strDataGridConfigId);
        if (this.dataGrid != null) {
            this.dataGrid.getDataGridConfig().setLoadDefault(false);
            this.dataGrid.getDataGridConfig().setSelectColumn(false);
            this.dataGrid.getDataGridConfig().setBorder(false);
            if (this.gridFormEditPageModel != null && this.gridFormEditPageModel.getDGModel() != null) {
                DGModel dgModel = this.gridFormEditPageModel.getDGModel();
                dgModel.setCtrlId("dataGrid");
                dgModel.setConfigId(this.strDataGridConfigId);
                dgModel.setRemoteCtrlId(this.dataGrid.getUniqueID());
                dgModel.setItemPrivilege(this.OnGetDGItemPrivilege());
            }
        }
        if (!this.IsBackEndMode()) {
            SRFExForm form = (SRFExForm)this.getDefaultForm();
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.maingrid=$P.grid['%1$s'];", (Object)this.dataGrid.getUniqueID());
            this.getPage().RegisterOnReadyScript(3, script.toString());
            script.Reset();
            script.Append("%1$s;", (Object)DataGridJSHelper.getDataLoadDefaultScript((String)this.dataGrid.getUniqueID()));
            form.getLoadAction().getSuccessAction().RegisterProcessCode(0, script.toString());
        }
    }

    protected boolean OnGetDataGrid() {
        this.strGridViewId = this.OnGetGridView();
        if (!StringHelper.IsNullOrEmpty((String)this.strGridViewId)) {
            this.gridView = this.getWebContext().GetConfigCache().GetUserDEDataGrid(this.getWebContext(), this.strGridViewId);
            if (this.gridView == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe[%1$s]", (Object)this.strGridViewId));
                return false;
            }
        } else {
            Vector list = new Vector();
            CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetUserDEDataGrids(this.getWebContext().getCurUserId(), this.getPageDataEntityId(), this.strDGMode, list);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog(this, "\u83b7\u53d6\u5b9e\u4f53\u9ed8\u8ba4\u8868\u683c\u89c6\u56fe\u5931\u8d25", callResult);
                return false;
            }
            Iterator iterator = list.iterator();
            if (iterator.hasNext()) {
                DataGrid dataGrid;
                this.gridView = dataGrid = (DataGrid)iterator.next();
            }
            if (this.gridView == null) {
                this.PageLog(this, "\u6ca1\u6709\u83b7\u53d6\u5230\u7b26\u5408\u8981\u6c42\u7684\u6570\u636e\u8868\u683c", callResult);
                return false;
            }
        }
        this.strGridViewId = this.gridView.getDATAGRIDID();
        this.getWebContext().SetParamValue("SRFGRIDVIEW", this.strGridViewId);
        return true;
    }

    protected boolean OnGetDGItemPrivilege() {
        boolean bDGItemPriv = this.getDEHelper().IsEnableDEFieldPriv();
        return this.getPageParam("PAGE.DATAGRID.ITEMPRIVILEGE", bDGItemPriv);
    }

    protected String OnGetDataGridMode() {
        return this.getPageParam("PAGE.DGMODE", "DEFAULT");
    }

    protected String OnGetGridView() {
        return this.getWebContext().getSRFGridView();
    }

    protected String OnGetDataGridConfigId() {
        String strDGConfig = this.getPageParam("PAGE.DATAGRID", "");
        if (!StringHelper.IsNullOrEmpty((String)strDGConfig)) {
            return strDGConfig;
        }
        return this.getDAConfigHelper().GetGridViewDGConfigId(this.getDEHelper(), this.page, this.gridView, this.getWebContext().getSRFDERID());
    }

    @Override
    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterDataGridActionHelper(this.dataGrid.getUniqueID(), this.GetDataGridActionHelper());
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
        return GridFormEditPage.GetDefaultDataGridActionHelper(this.getDEHelper(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }

    public static String GetDefaultDataGridActionHelper(IDEHelper iDEHelper, ISRFDAGlobalHelper globalHelper) {
        String strDGActionHelper;
        if (iDEHelper != null && !StringHelper.IsNullOrEmpty((String)iDEHelper.GetDBStorage()) && !StringHelper.IsNullOrEmpty((String)(strDGActionHelper = globalHelper.getDAModelStorage().FindDBStorage(iDEHelper.GetDBStorage()).GetProperty("DGACTIONHELPER")))) {
            return strDGActionHelper;
        }
        return globalHelper.getWebExConfig().GetValue("SRFDA", "DGACTIONHELPER", "");
    }

    @Override
    public String RenderErrorPanel() {
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<div class=\"sx-errorpanel\" id=\"%1$s_errorindicator\" style=\"width:100%%;height:100%%;display:none;overflow:auto;\"></div>", (Object)this.getDefaultFormId());
        }
        return strOutput;
    }
}

