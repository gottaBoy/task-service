/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Button;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Button.SRFExAjaxButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebContext;

public class SRFExButtonActionHelper {
    protected SRFExPage page = null;
    protected String strButtonId = "";
    protected String strAction = "";
    public static final String ACTION_CLICK = "click";

    public boolean Process(SRFExPage page, String strButtonId, String strAction) {
        this.page = page;
        this.strButtonId = strButtonId;
        this.strAction = strAction;
        if (!this.OnBeforeProcess()) {
            return false;
        }
        return this.OnProcess(strButtonId, strAction);
    }

    protected boolean OnBeforeProcess() {
        return true;
    }

    protected boolean OnProcess(String strButtonId, String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_CLICK, (boolean)true) == 0) {
            return this.OnClickAction();
        }
        return this.OnCustomAction(strAction);
    }

    protected boolean OnClickAction() {
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

    protected SRFExAjaxButton getButton() {
        SRFExControl obj = this.getPage().LookForControlByUniqueId(this.strButtonId);
        if (obj == null) {
            return null;
        }
        if (obj instanceof SRFExAjaxButton) {
            return (SRFExAjaxButton)obj;
        }
        return null;
    }
}

