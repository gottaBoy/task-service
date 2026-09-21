/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSAppUtilPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5e94\u7528\u529f\u80fd\u9875\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppUtilPage")
public interface IPSAppUtilPage
extends IPSApplicationObject {
    public static final String TARGETTYPE_PAGEURL = "PAGEURL";
    public static final String TARGETTYPE_APPVIEW = "APPVIEW";
    public static final String TARGETTYPE_LAYOUTPANEL = "LAYOUTPANEL";

    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppUtilPage var3) throws Exception;

    public String getPageUrl();

    public String getTargetType();

    public IPSAppView getPSAppView() throws Exception;

    public String getUtilType();

    public String getUtilTag();

    public Properties getUtilParams();
}

