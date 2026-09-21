/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.IPSApplicationUI;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppUIStyle;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5e94\u7528\u754c\u9762\u6a21\u5f0f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppUIStyle")
public interface IPSAppUIStyle
extends IPSApplicationObject,
IPSApplicationUI {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppUIStyle var3) throws Exception;

    @Override
    public String getUIStyle();

    public String getStyleCode();

    public String getAppFolder();

    public IPSAppView getDefaultPSAppView() throws Exception;

    public IPSAppIndexView getDefaultPSAppIndexView() throws Exception;
}

