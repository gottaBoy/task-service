/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSDEViewBase")
public interface IPSAppDEXDataView
extends IPSAppDEView,
IPSControlXDataContainer {
    public static final String VIEWREFMODE_PRINTWIZARD = "PRINTWIZARD";

    public IPSControl getXDataPSControl() throws Exception;

    public String getXDataControlName();
}

