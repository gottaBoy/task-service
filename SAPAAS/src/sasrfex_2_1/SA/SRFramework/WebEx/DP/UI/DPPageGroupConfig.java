/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.WebEx.DP.UI.DPBaseGroupConfig;
import SA.SRFramework.WebEx.DP.UI.DPConfig;

public class DPPageGroupConfig
extends DPBaseGroupConfig {
    public static final String TAG_DPPAGEGROUP = "SRFEXDPPAGEGROUP";
    protected DPConfig dpConfig = null;

    public DPConfig getDPConfig() {
        return this.dpConfig;
    }

    public void setDPConfig(DPConfig dpConfig) {
        this.dpConfig = dpConfig;
    }
}

