/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView;
import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView2;
import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView3;
import SA.SRFDA.PS.Core.App.View.IPSAppDEXDataView;
import SA.SRFDA.PS.Core.Control.IPSControlMDataContainer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u591a\u9879\u6570\u636e\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSDEViewBase")
public interface IPSAppDEMultiDataView
extends IPSAppDEXDataView,
IPSAppDESearchView,
IPSControlMDataContainer,
IPSAppDESearchView2,
IPSAppDESearchView3 {
    public static final String VIEWPARAM_UI_ENABLEQUICKSEARCH = "UI.ENABLEQUICKSEARCH";
    public static final String VIEWPARAM_UI_ENABLESEARCH = "UI.ENABLESEARCH";
}

