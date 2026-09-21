/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.Theme;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSAppUITheme;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5e94\u7528\u754c\u9762\u4e3b\u9898\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppUITheme")
public interface IPSAppUITheme
extends IPSApplicationObject {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppUITheme var3) throws Exception;

    public String getThemeTag();

    public String getThemeDesc();

    public Object getThemeParam(String var1) throws Exception;

    public boolean getThemeParam(String var1, boolean var2) throws Exception;

    public String getThemeParam(String var1, String var2) throws Exception;

    public int getThemeParam(String var1, int var2) throws Exception;

    public double getThemeParam(String var1, double var2) throws Exception;

    public Properties getThemeParams();

    public String getCssStyle();

    public String getThemeUrl();
}

