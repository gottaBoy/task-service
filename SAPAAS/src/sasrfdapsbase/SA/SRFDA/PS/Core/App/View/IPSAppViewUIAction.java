/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u754c\u9762\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSAppViewUIAction
extends IPSModelObject {
    public IPSUIAction getPSUIAction();

    public IPSAppView getPSAppView();

    public JSONObject getUIActionParamJO();

    public String getXDataControlName();

    public IPSControl getXDataPSControl() throws Exception;

    public IPSControlContainer getPSControlContainer();

    public boolean isSaveTargetFirst();

    public IPSAppCounterRef getPSAppCounterRef();

    public String getUIActionTarget();
}

