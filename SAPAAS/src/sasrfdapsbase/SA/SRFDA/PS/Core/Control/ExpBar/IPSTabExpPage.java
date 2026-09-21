/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u5206\u9875\u5bfc\u822a\u5206\u9875\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDETabViewPanelImpl")
public interface IPSTabExpPage
extends IPSControl,
IPSNavigateParamContainer {
    public String getCaption();

    public IPSLanguageRes getCapPSLanguageRes();

    public IPSSysCounterRef getPSSysCounterRef();

    public IPSAppCounterRef getPSAppCounterRef();

    public String getCounterId();

    public String getNavPSDERId();

    public IPSDERBase getNavPSDER();

    public IPSSysImage getPSSysImage();

    public JSONObject getParentDataJO();

    public JSONObject getParentDataJO(boolean var1);

    public String getParamJOString();

    public String getContextJOString();
}

