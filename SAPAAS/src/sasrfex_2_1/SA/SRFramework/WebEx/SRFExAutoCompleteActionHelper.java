/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebContext;

public class SRFExAutoCompleteActionHelper {
    protected SRFExPage page = null;
    protected String strACMode = "";
    protected String strAction = "";
    public static final String ACTION_FETCH = "fetch";

    public boolean Process(SRFExPage page, String strACMode, String strAction) {
        this.page = page;
        this.strACMode = strACMode;
        this.strAction = strAction;
        if (!this.OnBeforeProcess()) {
            return false;
        }
        return this.OnProcess(strAction);
    }

    protected boolean OnBeforeProcess() {
        return true;
    }

    protected boolean OnProcess(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_FETCH, (boolean)true) == 0) {
            return this.OnFetchAction();
        }
        return this.OnCustomAction(strAction);
    }

    protected boolean OnFetchAction() {
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
}

