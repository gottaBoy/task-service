/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFDA.EAI.Ctrl.Data.EAIProcessConfig;

public class EAIJDBCProcess
extends EAIProcessConfig {
    public int getFREQUENCY() {
        return this.GetParamIntValue("PARAM1", 10000);
    }

    public String getSQLCMD() {
        return this.GetParamStringValue("PARAM3", "");
    }
}

