/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.api.IServiceAPI
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Data.PSSysServiceAPI;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.api.IServiceAPI;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysServiceAPI")
public interface IPSSysServiceAPI
extends IPSSystemObject,
IServiceAPI,
IPSSysSFPubObject {
    public static final String AUTHMODE_NONE = "NONE";
    public static final String AUTHMODE_AUTHORIZATION_CODE = "AUTHORIZATION_CODE";
    public static final String AUTHMODE_PASSWORD = "PASSWORD";
    public static final String AUTHMODE_CLIENT_CREDENTIALS = "CLIENT_CREDENTIALS";
    public static final String AUTHMODE_IMPLICIT = "IMPLICIT";
    public static final String APITYPE_RESTFUL = "RESTFUL";
    public static final String APITYPE_JAXRS = "JAXRS";
    public static final String APITYPE_WEBSERVICE = "WEBSERVICE";
    public static final int APIMODE_COMMON = 0;
    public static final int APIMODE_ALLDE = 1;
    public static final int APIMODE_PREDEFINED = 2;
    public static final int APIMODE_CUSTOM = 10;
    public static final String SERVICETYPE_DEFAULT = "DEFAULT";
    public static final String SERVICETYPE_APPLICATION = "APPLICATION";
    public static final String SERVICETYPE_PROXY = "PROXY";
    public static final String SERVICETYPE_MIDDLEPLATFORM = "MIDDLEPLATFORM";
    public static final String SERVICETYPE_MASA = "MASA";
    public static final String SERVICETYPE_USER = "USER";
    public static final String SERVICETYPE_USER2 = "USER2";
    public static final int APILEVEL_CORE = 0;
    public static final int APILEVEL_CLOUDADMIN = 1;
    public static final int APILEVEL_DCADMIN = 2;
    public static final int APILEVEL_USER = 3;

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysServiceAPI var3) throws Exception;

    @Override
    public String getCodeName();

    public String getAPIType();

    public Iterator<IPSDEServiceAPI> getPSDEServiceAPIs();

    public IPSDEServiceAPI getPSDEServiceAPI(String var1, boolean var2) throws Exception;

    public IPSDEServiceAPI getPSDEServiceAPI(String var1) throws Exception;

    public int getAPIMode();

    public int getAPIVersion();

    public String getServiceCodeName();

    public String getAuthMode();

    public String getAuthCheckTokenUrl();

    public String getAuthClientId();

    public String getAuthClientSecret();

    public String getPSDevSlnSysAPIId();

    public IPSSystemModule getPSSystemModule();

    public String getHandler();

    public Iterator<IPSDEServiceAPIRS> getPSDEServiceAPIRSs();

    public Iterator<IPSDEServiceAPI> getMajorPSDEServiceAPIs();

    public String getServiceParam();

    public String getServiceParam2();

    public String getServiceParam3();

    public String getServiceParam4();

    public String getAuthParam();

    public String getAuthParam2();

    public String getAuthParam3();

    public String getAuthParam4();

    public String getDefaultDEActionReqMethod();

    public String getDefaultSelectReqMethod();

    public String getDefaultDEDataSetReqMethod();

    public String getPredefinedType();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public String getDEPSSysSFPluginId();

    public String getAPITag();

    public String getAPITag2();

    public String getServiceType();

    public int getHttpPort();

    public boolean isUserLevel();

    public boolean isCloudAdminLevel();

    public boolean isDCAdminLevel();

    public boolean isCoreLevel();

    public int getAPILevel();

    public boolean isResetDefaultActionCodeName();

    public IPSDEOPPriv getDefaultPSDEOPPriv();

    public boolean isEnableServiceAPIDTO();

    public Iterator<IPSSysTestPrj> getPSSysTestPrjs() throws Exception;

    public String getDefaultCreateReqMethod();

    public String getDefaultUpdateReqMethod();

    public String getDefaultGetReqMethod();

    public String getDefaultDeleteReqMethod();

    public String getDefaultGetDraftReqMethod();

    public String getCreateReqMethod(String var1);

    public String getUpdateReqMethod(String var1);

    public String getGetReqMethod(String var1);

    public String getDeleteReqMethod(String var1);

    public String getGetDraftReqMethod(String var1);

    public String getAPICodeNameMode();

    public String getNamingService();

    public String getAPICodeName(String var1, String var2, String var3);

    public boolean isEnableAPIModelEx();

    public boolean isEnableGateway();

    public void loadAll() throws Exception;

    public Iterator<String> getIgnoreAuthPatterns();

    public IPSSysTranslator getOutPSSysTranslator();

    public IPSSysResource getPSSysResource();
}

