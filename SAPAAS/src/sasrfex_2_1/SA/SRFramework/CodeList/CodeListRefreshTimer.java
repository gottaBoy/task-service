/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.CodeList;

import SA.SRFramework.CodeList.CodeListMgr;
import java.util.Timer;
import java.util.TimerTask;

public class CodeListRefreshTimer
extends TimerTask {
    private Timer refreshTimer = null;
    protected CodeListMgr codeListMgr = null;

    public CodeListRefreshTimer(CodeListMgr codeListMgr, int nSeconds) {
        this.codeListMgr = codeListMgr;
        if (this.refreshTimer == null) {
            this.refreshTimer = new Timer("CodeListRefreshTimer");
            this.refreshTimer.schedule((TimerTask)this, nSeconds, (long)nSeconds);
        }
    }

    @Override
    public synchronized void run() {
        if (this.codeListMgr != null) {
            this.codeListMgr.ResetAllCodeList();
        }
    }
}

