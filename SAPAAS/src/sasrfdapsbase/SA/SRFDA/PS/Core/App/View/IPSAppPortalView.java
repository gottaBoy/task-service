/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.View.IPSAppMobView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5e94\u7528\u6570\u636e\u770b\u677f\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"APPPORTALVIEW"}, model="PSAppPortalView")
public interface IPSAppPortalView
extends IPSAppView,
IPSAppMobView {
    @Override
    public Iterator<IPSAppFunc> getPSAppFuncs();

    public boolean isDefaultPage();
}

