/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebContext;

public class SRFExDataGridActionHelper {
    protected SRFExPage page = null;
    protected String strDataGridId = "";
    protected String strAction = "";
    public static final String ACTION_FETCH = "fetch";
    public static final String ACTION_NEWROW = "newrow";
    public static final String ACTION_SAVEROW = "saverow";
    public static final String ACTION_REMOVE = "remove";
    public static final String ACTION_ITEMUPDATE = "itemupdate";

    public boolean Process(SRFExPage page, String strDataGridId, String strAction) {
        this.page = page;
        this.strDataGridId = strDataGridId;
        this.strAction = strAction;
        if (!this.OnBeforeProcess()) {
            return false;
        }
        return this.OnProcess(strAction);
    }

    protected boolean OnBeforeProcess() {
        return true;
    }

    public void ExportExcel(SRFExPage page, String strExcelReport) {
        this.page = page;
        this.OnExportExcel(strExcelReport);
    }

    protected void OnExportExcel(String strExcelReport) {
    }

    protected boolean OnProcess(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_FETCH, (boolean)true) == 0) {
            String strValue = this.getPage().getRequest().getParameter("_RESET");
            if (StringHelper.Compare((String)strValue, (String)"true", (boolean)true) == 0) {
                return this.OutputEmptyDG();
            }
            return this.OnFetchAction();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_NEWROW, (boolean)true) == 0) {
            return this.OnNewRowAction();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_SAVEROW, (boolean)true) == 0) {
            return this.OnSaveRowAction();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_REMOVE, (boolean)true) == 0) {
            return this.OnRemoveAction();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_ITEMUPDATE, (boolean)true) == 0) {
            String strUpdateMode = this.getWebContext().GetPostValue("srfum");
            if (StringHelper.IsNullOrEmpty((String)strUpdateMode)) {
                return false;
            }
            return this.OnItemUpdateAction(strUpdateMode);
        }
        return this.OnCustomAction(strAction);
    }

    protected boolean OutputEmptyDG() {
        SRFExGridFetchResult fetchResult = new SRFExGridFetchResult();
        fetchResult.setRetCode(0);
        fetchResult.setTotalRow(0);
        this.getPage().Output(fetchResult.ToJSONString());
        return true;
    }

    protected boolean OnFetchAction() {
        return false;
    }

    protected boolean OnNewRowAction() {
        return false;
    }

    protected boolean OnSaveRowAction() {
        return false;
    }

    protected boolean OnCustomAction(String strAction) {
        return false;
    }

    protected boolean OnRemoveAction() {
        return false;
    }

    protected boolean OnItemUpdateAction(String strAction) {
        return false;
    }

    protected SRFExPage getPage() {
        return this.page;
    }

    protected SRFExWebContext getWebContext() {
        if (this.page == null) {
            return null;
        }
        return this.page.getWebContext();
    }

    protected SRFExDataGrid getDataGrid() {
        SRFExControl obj = this.getPage().LookForControlByUniqueId(this.strDataGridId);
        if (obj == null) {
            return null;
        }
        if (obj instanceof SRFExDataGrid) {
            return (SRFExDataGrid)obj;
        }
        return null;
    }
}

