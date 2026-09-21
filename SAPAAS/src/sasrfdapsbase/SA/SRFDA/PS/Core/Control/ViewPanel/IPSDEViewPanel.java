/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ViewPanel;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u89c6\u56fe\u9762\u677f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEViewPanel
extends IPSControl,
IPSNavigateParamContainer {
    @Deprecated
    public IPSAppDEView getPSAppDEView();

    public IPSAppDEView getEmbeddedPSAppDEView();

    public String getEmbeddedViewId();

    @Deprecated
    public String getEmbedViewId();

    public String getCaption();

    public IPSLanguageRes getCapPSLanguageRes();

    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception;
}

