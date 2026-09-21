/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDataGrid
 */
package SA.SRFDA.Web.App;

import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDataGrid;
import java.util.Iterator;
import java.util.Vector;

public class DGBackendPage
extends SRFDAPageEx {
    protected String strGridViewId = "";
    protected DataGrid gridView = null;
    protected String strDGMode = "";
    protected String strDataGridConfigId = "";
    protected SRFExDataGrid dataGrid = null;

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
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadDataGrid();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.getWebContext().SetParamValue("srfgridid", this.dataGrid.getUniqueID());
        this.getWebContext().SetParamValue("srfactiontype", "gridaction");
        this.RegisterDataGridActionHelper(this.dataGrid.getUniqueID(), this.GetDataGridActionHelper());
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
            Vector list = new Vector();
            CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetUserDEDataGrids(this.getWebContext().getCurUserId(), this.getPageDataEntityId(), this.strDGMode, list);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog((Object)this, "\u83b7\u53d6\u5b9e\u4f53\u9ed8\u8ba4\u8868\u683c\u89c6\u56fe\u5931\u8d25", callResult);
                return false;
            }
            Iterator iterator = list.iterator();
            if (iterator.hasNext()) {
                DataGrid dataGrid;
                this.gridView = dataGrid = (DataGrid)iterator.next();
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

    protected String OnGetDataGridMode() {
        return this.getPageParam("PAGE.DGMODE", "DEFAULT");
    }

    protected void LoadDataGrid() {
        this.strDataGridConfigId = this.OnGetDataGridConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strDataGridConfigId)) {
            return;
        }
        this.dataGrid = DGBackendPage.CreateDataGrid(this, "dataGrid", 0.0, 0.0, this.strDataGridConfigId);
        if (this.dataGrid != null) {
            this.dataGrid.setEnableItemPrivilege(this.OnGetDGItemPrivilege());
        }
    }

    protected String OnGetDataGridConfigId() {
        String strDGConfig = this.getPageParam("PAGE.DATAGRID", "");
        if (!StringHelper.IsNullOrEmpty((String)strDGConfig)) {
            return strDGConfig;
        }
        return this.getDAConfigHelper().GetGridViewDGConfigId(this.getDEHelper(), this.page, this.gridView, this.getWebContext().getSRFDERID());
    }

    protected boolean OnGetDGItemPrivilege() {
        return this.getPageParam("PAGE.DATAGRID.ITEMPRIVILEGE", this.getDEHelper().IsEnableDEFieldPriv());
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
        return DGBackendPage.GetDefaultDataGridActionHelper(this.getDEHelper(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }

    public static String GetDefaultDataGridActionHelper(IDEHelper iDEHelper, ISRFDAGlobalHelper globalHelper) {
        String strDGActionHelper;
        if (iDEHelper != null && !StringHelper.IsNullOrEmpty((String)iDEHelper.GetDBStorage()) && !StringHelper.IsNullOrEmpty((String)(strDGActionHelper = globalHelper.getDAModelStorage().FindDBStorage(iDEHelper.GetDBStorage()).GetProperty("DGACTIONHELPER")))) {
            return strDGActionHelper;
        }
        return globalHelper.getWebExConfig().GetValue("SRFDA", "DGACTIONHELPER", "");
    }
}

