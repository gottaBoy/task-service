/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Button;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Button.SRFExButtonSystemAction;

public class SRFExButtonAjaxAction
extends SRFExButtonSystemAction {
    protected String strRemotePath = "";
    protected int nTimeout = 30000;

    public String getRemotePath() {
        if (StringHelper.Length((String)this.strRemotePath) == 0) {
            return this.getAjaxButton().getRemotePath();
        }
        return this.strRemotePath;
    }

    public void setRemotePath(String strRemotePath) {
        this.strRemotePath = strRemotePath;
    }

    public int getTimeout() {
        return this.nTimeout;
    }

    public void setTimeout(int nTimeout) {
        this.nTimeout = nTimeout;
    }
}

