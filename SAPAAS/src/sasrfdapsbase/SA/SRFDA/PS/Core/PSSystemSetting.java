/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;

public class PSSystemSetting {
    public static IPSSystemSetting getCurrent(IPSSystem iPSSystem) {
        return (IPSSystemSetting)((Object)iPSSystem);
    }

    public static IPSSysEngineConfig getPSSysEngineConfig(IPSSystem iPSSystem) {
        return PSSystemSetting.getCurrent(iPSSystem).getPSSysEngineConfig();
    }
}

