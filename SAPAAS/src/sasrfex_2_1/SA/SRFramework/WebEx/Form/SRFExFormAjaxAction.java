/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.WebEx.Form.SRFExFormSystemAction;

public class SRFExFormAjaxAction
extends SRFExFormSystemAction {
    protected String strRemotePath = "";
    protected int nTimeout = 30000;
    protected boolean bSyncMode = false;

    public String getRemotePath() {
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

    public boolean isSyncMode() {
        return this.bSyncMode;
    }

    public void setSyncMode(boolean bSyncMode) {
        this.bSyncMode = bSyncMode;
    }
}

