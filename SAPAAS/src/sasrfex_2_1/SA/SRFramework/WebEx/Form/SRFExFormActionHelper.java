/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebContext;

public class SRFExFormActionHelper {
    protected SRFExPage page = null;
    protected String strFormId = "";
    protected String strAction = "";
    protected String strFormTag = "";
    public static final String ACTION_LOAD = "load";
    public static final String ACTION_LOADDEFAULT = "loaddefault";
    public static final String ACTION_SAVE = "save";
    public static final String ACTION_REMOVE = "remove";
    public static final String ACTION_ITEMUPDATE = "itemupdate";

    public boolean Process(SRFExPage page, String strFormId, String strAction) {
        this.page = page;
        this.strFormId = strFormId;
        this.strAction = strAction;
        this.strFormTag = page.getWebContext().GetPostValue("srfformtag");
        if (!this.OnBeforeProcess()) {
            return false;
        }
        return this.OnProcess(strAction);
    }

    protected boolean OnBeforeProcess() {
        return true;
    }

    protected boolean OnProcess(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_LOAD, (boolean)true) == 0) {
            return this.OnLoadAction();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_LOADDEFAULT, (boolean)true) == 0) {
            return this.OnLoadDefaultAction();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_SAVE, (boolean)true) == 0) {
            return this.OnSaveAction();
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

    protected boolean OnLoadDefaultAction() {
        return false;
    }

    protected boolean OnLoadAction() {
        return false;
    }

    protected boolean OnSaveAction() {
        return false;
    }

    protected boolean OnRemoveAction() {
        return false;
    }

    protected boolean OnItemUpdateAction(String strAction) {
        return false;
    }

    protected boolean OnCustomAction(String strAction) {
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

    protected SRFExForm getForm() {
        SRFExBaseForm form = this.getPage().getForms().FindForm(this.strFormId);
        if (form == null) {
            return null;
        }
        if (form instanceof SRFExForm) {
            return (SRFExForm)form;
        }
        return null;
    }

    public String getAction() {
        return this.strAction;
    }
}

