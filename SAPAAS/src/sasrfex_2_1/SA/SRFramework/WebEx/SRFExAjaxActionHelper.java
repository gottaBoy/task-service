/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebContext;

public class SRFExAjaxActionHelper {
    protected SRFExPage page = null;
    protected String strAction = "";

    public boolean Process(SRFExPage page, String strAction) {
        this.page = page;
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

