/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Report.Web.Storage;

import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

public class ChartClearTaskTimer
extends TimerTask {
    private Timer checkTimer = null;
    private Hashtable chartHashtable;
    private Hashtable chartTimeHashtable;
    private boolean bTimer = false;

    public ChartClearTaskTimer(Hashtable chartHashtable, Hashtable chartTimeHashtable) {
        this.chartTimeHashtable = chartTimeHashtable;
        this.chartHashtable = chartHashtable;
        if (!this.bTimer) {
            this.checkTimer = null;
            this.checkTimer = new Timer("ChartClearTaskTimer");
            this.checkTimer.schedule((TimerTask)this, 30000L, 30000L);
            this.bTimer = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void run() {
        Hashtable hashtable = this.chartHashtable;
        synchronized (hashtable) {
            Date dt = new Date();
            long nCurTime = dt.getTime();
            Enumeration enumeration = this.chartTimeHashtable.keys();
            while (enumeration.hasMoreElements()) {
                String strKey = (String)enumeration.nextElement();
                Long nActiveTime = (Long)this.chartTimeHashtable.get(strKey);
                if (nCurTime - nActiveTime < 120000L || !this.chartHashtable.containsKey(strKey)) continue;
                this.chartHashtable.remove(strKey);
                this.chartTimeHashtable.remove(strKey);
            }
            if (this.chartHashtable.size() == 0 && this.checkTimer != null) {
                this.checkTimer.cancel();
                this.bTimer = false;
            }
        }
    }

    public synchronized boolean IsTimer() {
        return this.bTimer;
    }
}

