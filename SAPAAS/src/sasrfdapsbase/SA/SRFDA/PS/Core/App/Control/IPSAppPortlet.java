/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppPortletCat;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;
import SA.SRFDA.PS.Data.PSAppPortlet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5e94\u7528\u95e8\u6237\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppPortlet")
public interface IPSAppPortlet
extends IPSApplicationObject {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppPortlet var3) throws Exception;

    public IPSSysPortlet getPSSysPortlet();

    @Override
    public String getCodeName();

    public IPSControl getPSControl();

    public IPSAppPortletCat getPSAppPortletCat();

    public IPSAppDataEntity getPSAppDataEntity();

    public boolean isEnableAppDashboard();

    public boolean isEnableDEDashboard();

    public Properties getPortletParams();
}

