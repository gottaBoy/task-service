/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewPlugin;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSAppDEViewPlugin
extends IPSAppViewPlugin {
    public boolean preparePSDEViewCtrls(IPSAppDEView var1) throws Exception;

    public boolean preparePSDEViewLogics(IPSAppDEView var1) throws Exception;
}

