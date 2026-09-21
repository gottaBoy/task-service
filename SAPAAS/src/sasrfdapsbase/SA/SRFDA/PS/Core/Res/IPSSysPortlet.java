/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPortletCat;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysPortlet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysPortlet")
public interface IPSSysPortlet
extends IPSSystemObject {
    public static final int DASHBOARDSCOPE_APP = 1;
    public static final int DASHBOARDSCOPE_DE = 2;
    public static final int DASHBOARDSCOPE_APPAndDE = 3;
    public static final String PORTLETSTYLE_DEFAULT = "DEFAULT";
    public static final String PORTLETSTYLE_STYLE2 = "STYLE2";
    public static final String PORTLETSTYLE_STYLE3 = "STYLE3";
    public static final String PORTLETSTYLE_STYLE4 = "STYLE4";
    public static final String TEMPLENGINE_DEFAULT = "DEFAULT";
    public static final String TEMPLENGINE_V2 = "V2";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysPortlet var3) throws Exception;

    public String getTitle();

    public String getPortletType();

    public int getReloadTimer();

    public boolean isShowTitleBar();

    public IPSSysPFPlugin getTitlePSSysPFPlugin();

    @Deprecated
    public IPSLanguageRes getTitlePSIpsLanguageRes();

    public IPSLanguageRes getTitlePSLanguageRes();

    public String getBaseClass(String var1) throws Exception;

    public int getHeight();

    public IPSPortletType getPSPortletType();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public String getEmptyText();

    public String getPSACHandlerId();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysUniRes getPSSysUniRes();

    public IPSSystemModule getPSSystemModule();

    @Override
    public String getCodeName();

    public IPSSysPortletCat getPSSysPortletCat();

    public String getPSDEUIActionGroupId();

    public boolean isEnableAppDashboard();

    public boolean isEnableDEDashboard();

    public int getDashboardScope();

    public String getActionGroupExtractMode();

    public String getPortletStyle();

    public IPSDataEntity getPSDataEntity();

    public String getTemplEngine();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getPSSysCss();

    public Properties getPortletParams();
}

