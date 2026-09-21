/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngineParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIEngine;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u754c\u9762\u5f15\u64ce\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSAppDEViewEngineImpl")
public interface IPSAppViewEngine
extends IPSUIEngine {
    public IPSAppView getPSAppView();

    public Iterator<? extends IPSAppViewEngineParam> getPSAppViewEngineParams();

    public String getEngineCat();

    public String getEngineType();
}

