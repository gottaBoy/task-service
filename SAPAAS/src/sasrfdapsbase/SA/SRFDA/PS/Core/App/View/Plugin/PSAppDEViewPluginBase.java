/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View.Plugin;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEViewPlugin;
import SA.SRFDA.PS.Core.App.View.Plugin.PSAppViewPluginBase;

public abstract class PSAppDEViewPluginBase
extends PSAppViewPluginBase
implements IPSAppDEViewPlugin {
    @Override
    public boolean preparePSDEViewCtrls(IPSAppDEView iPSAppDEView) throws Exception {
        return false;
    }

    @Override
    public boolean preparePSDEViewLogics(IPSAppDEView iPSAppDEView) throws Exception {
        return false;
    }
}

