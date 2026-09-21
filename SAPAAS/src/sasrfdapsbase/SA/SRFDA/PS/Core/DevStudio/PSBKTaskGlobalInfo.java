/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevStudio;

public class PSBKTaskGlobalInfo {
    private int nSessionCount = 0;
    private int nRunningCount = 0;
    private int nQueueCount = 0;
    private String strInfo = null;

    public int getSessionCount() {
        return this.nSessionCount;
    }

    public int getRunningCount() {
        return this.nRunningCount;
    }

    public int getQueueCount() {
        return this.nQueueCount;
    }

    public void setSessionCount(int nSessionCount) {
        this.nSessionCount = nSessionCount;
    }

    public void setRunningCount(int nRunningCount) {
        this.nRunningCount = nRunningCount;
    }

    public void setQueueCount(int nQueueCount) {
        this.nQueueCount = nQueueCount;
    }

    public String getInfo() {
        return this.strInfo;
    }

    public void setInfo(String strInfo) {
        this.strInfo = strInfo;
    }
}

