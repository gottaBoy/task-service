/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.App.Func;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.IPSSubAppRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.SubSys.IPSSubApp;
import SA.SRFDA.PS.Core.SubSys.IPSSubAppView;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Data.PSAppFunc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u5e94\u7528\u529f\u80fd\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppFunc")
public interface IPSAppFunc
extends IPSApplicationObject,
IPSNavigateParamContainer {
    public static final String UIACTIONTYPE_APPFUNC = "APPFUNC";
    public static final String APPFUNCTYPE_APPVIEW = "APPVIEW";
    public static final String APPFUNCTYPE_SUBAPPVIEW = "SUBAPPVIEW";
    public static final String APPFUNCTYPE_OPENHTMLPAGE = "OPENHTMLPAGE";
    public static final String APPFUNCTYPE_UIACTION = "UIACTION";
    public static final String APPFUNCTYPE_CUSTOM = "CUSTOM";
    public static final String APPFUNCTYPE_PDTAPPFUNC = "PDTAPPFUNC";
    public static final String APPFUNCTYPE_JAVASCRIPT = "JAVASCRIPT";
    public static final String APPFUNCTYPE_SEARCH = "SEARCH";
    public static final String OPENMODE_INDEXVIEWTAB = "INDEXVIEWTAB";
    public static final String OPENMODE_INDEXVIEWPOPUP = "INDEXVIEWPOPUP";
    public static final String OPENMODE_INDEXVIEWPOPUPMODAL = "INDEXVIEWPOPUPMODAL";
    public static final String OPENMODE_HTMLPOPUP = "HTMLPOPUP";

    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppFunc var3) throws Exception;

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public IPSSubAppView getPSSubAppView() throws Exception;

    public IPSSubAppRef getPSSubAppRef() throws Exception;

    public IPSSubApp getPSSubApp() throws Exception;

    public String getFuncSN();

    public String getAppFuncType();

    public IPSAppView getPSAppView() throws Exception;

    public String getOpenMode();

    public String getUserData();

    public String getUserData2();

    public int getViewWidth();

    public int getViewHeight();

    public String getViewTitle();

    public JSONObject getOpenViewParam();

    public int getAccUserMode();

    public String getAccessKey();

    public String getPSPDTAppFuncId();

    public String getHtmlPageUrl();

    public String getJSCode();

    public IPSLanguageRes getNamePSLanguageRes();

    public String getTooltip();

    public IPSLanguageRes getTooltipPSLanguageRes();

    @Override
    public String getCodeName();

    public String getPSAppViewId();

    public boolean isSystemReserved();

    public IPSUIAction getPSUIAction() throws Exception;

    public IPSAppDataEntity getPSAppDataEntity() throws Exception;

    public IPSAppDEACMode getPSAppDEACMode() throws Exception;

    public String getPredefinedType();

    public String getPredefinedTypeParam();
}

