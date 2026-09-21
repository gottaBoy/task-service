/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Workspace;

import java.sql.Timestamp;

public class PSWorkspacePeriod {
    private Timestamp beginTime = null;
    private Timestamp endTime = null;
    private boolean bNextMode = false;

    public Timestamp getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public boolean isNextMode() {
        return this.bNextMode;
    }

    public void setNextMode(boolean bNextMode) {
        this.bNextMode = bNextMode;
    }
}

