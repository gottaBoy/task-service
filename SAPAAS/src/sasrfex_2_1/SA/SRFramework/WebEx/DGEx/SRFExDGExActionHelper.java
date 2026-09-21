/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.SRFExDGEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebContext;

public class SRFExDGExActionHelper {
    protected SRFExPage page = null;
    protected String strDGExId = "";
    protected String strAction = "";
    public static final String ACTION_FETCH = "fetch";
    public static final String ACTION_NEWROW = "newrow";
    public static final String ACTION_SAVEROW = "saverow";
    public static final String ACTION_REMOVE = "remove";

    public boolean Process(SRFExPage page, String strDataGridExId, String strAction) {
        this.page = page;
        this.strDGExId = strDataGridExId;
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
        return this.OnCustomAction(strAction);
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

    protected SRFExPage getPage() {
        return this.page;
    }

    protected SRFExWebContext getWebContext() {
        if (this.page == null) {
            return null;
        }
        return this.page.getWebContext();
    }

    protected SRFExDGEx getDGEx() {
        SRFExControl obj = this.getPage().LookForControlByUniqueId(this.strDGExId);
        if (obj == null) {
            return null;
        }
        if (obj instanceof SRFExDGEx) {
            return (SRFExDGEx)obj;
        }
        return null;
    }
}

