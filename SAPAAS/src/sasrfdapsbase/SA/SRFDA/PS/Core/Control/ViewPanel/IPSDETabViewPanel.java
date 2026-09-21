/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ViewPanel;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTabExpPage;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanel;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysImage;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5206\u9875\u89c6\u56fe\u9762\u677f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDETabViewPanel
extends IPSDEViewPanel,
IPSTabExpPage {
    @Override
    public IPSSysCounterRef getPSSysCounterRef();

    @Override
    public IPSAppCounterRef getPSAppCounterRef();

    @Override
    public String getCounterId();

    @Override
    public String getNavPSDERId();

    @Override
    public IPSDERBase getNavPSDER();

    @Override
    public IPSSysImage getPSSysImage();

    public String getNavFilter();

    public IPSDEOPPriv getPSDEOPPriv();

    public int getIndex();
}

