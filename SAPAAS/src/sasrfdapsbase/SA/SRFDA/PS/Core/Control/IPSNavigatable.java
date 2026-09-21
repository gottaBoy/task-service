/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u652f\u6301\u5bfc\u822a\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSNavigatable
extends IPSNavigateParamContainer {
    public String getNavDataType();

    public String getNavFilter();

    public String getNavPSDEViewId();

    public IPSAppView getNavPSAppView();

    public JSONObject getNavViewParamJO();

    public String getNavPSDERId();

    public IPSDERBase getNavPSDER();

    public String getNavEmbeddedViewId();

    public String getName();

    public String getLogicName();
}

