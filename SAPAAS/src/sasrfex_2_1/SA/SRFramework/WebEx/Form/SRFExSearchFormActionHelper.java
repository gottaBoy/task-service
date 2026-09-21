/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExFormActionHelper;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;

public class SRFExSearchFormActionHelper
extends SRFExFormActionHelper {
    public static final String ACTION_SEARCH = "search";
    public static final String ACTION_LOADCONDITION = "loadcondition";
    public static final String ACTION_SAVECONDITION = "savecondition";
    public static final String ACTION_LISTCONDITION = "listcondition";
    public static final String ACTION_REMOVECONDITION = "removecondition";

    @Override
    protected boolean OnProcess(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_SEARCH, (boolean)true) == 0) {
            return this.OnSearchAction();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_LOADCONDITION, (boolean)true) == 0) {
            return this.OnLoadCondtionAction();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_SAVECONDITION, (boolean)true) == 0) {
            return this.OnSaveCondtionAction();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_LISTCONDITION, (boolean)true) == 0) {
            return this.OnListCondtionAction();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_REMOVECONDITION, (boolean)true) == 0) {
            return this.OnRemoveCondtionAction();
        }
        return super.OnProcess(strAction);
    }

    protected boolean OnSearchAction() {
        return false;
    }

    protected boolean OnLoadCondtionAction() {
        return false;
    }

    protected boolean OnSaveCondtionAction() {
        return false;
    }

    protected boolean OnListCondtionAction() {
        return false;
    }

    protected boolean OnRemoveCondtionAction() {
        return false;
    }

    protected SRFExSearchForm getSearchForm() {
        SRFExBaseForm form = this.getPage().getForms().FindForm(this.strFormId);
        if (form == null) {
            return null;
        }
        if (form instanceof SRFExSearchForm) {
            return (SRFExSearchForm)form;
        }
        return null;
    }
}

