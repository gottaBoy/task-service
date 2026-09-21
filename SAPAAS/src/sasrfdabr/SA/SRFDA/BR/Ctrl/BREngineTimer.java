/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BR.Ctrl;

import SA.SRFDA.BR.Ctrl.ISRFBREngineContext;
import SA.SRFramework.DataEx.CallResult;
import java.util.Timer;
import java.util.TimerTask;

public class BREngineTimer
extends TimerTask {
    public static final int TSTIMER = 1000;
    private Timer tsTimer = null;
    protected ISRFBREngineContext engineContext = null;
    protected Boolean bRun = false;

    public CallResult Start(ISRFBREngineContext engineContext, int nCounter) {
        this.bRun = false;
        this.engineContext = engineContext;
        if (this.tsTimer == null) {
            this.tsTimer = new Timer("BREngineTimer");
            this.tsTimer.schedule((TimerTask)this, 1000L, (long)(1000 * nCounter));
        }
        return new CallResult();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Boolean bl = this.bRun;
        synchronized (bl) {
            if (this.bRun.booleanValue()) {
                return;
            }
            this.bRun = true;
        }
        this.engineContext.Schedule();
        bl = this.bRun;
        synchronized (bl) {
            this.bRun = false;
        }
    }

    public void Quit() {
        if (this.tsTimer != null) {
            this.tsTimer.cancel();
            this.tsTimer = null;
        }
        this.bRun = false;
    }
}

