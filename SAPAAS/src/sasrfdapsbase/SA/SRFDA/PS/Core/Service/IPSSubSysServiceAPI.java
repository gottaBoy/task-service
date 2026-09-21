/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.api.IServiceAPIClient
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIBase;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTO;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethodInput;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethodReturn;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Schema;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSubSysServiceAPI;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.api.IServiceAPIClient;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5916\u90e8\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSubSysServiceAPI")
public interface IPSSubSysServiceAPI
extends IPSSystemObject,
IPSSubSysServiceAPIBase,
IServiceAPIClient,
IPSSysSFPubObject,
IPSSFCodeObject {
    public static final String APISOURCE_NONE = "NONE";
    public static final String APISOURCE_SYSAPI = "SYSAPI";
    public static final String APISOURCE_DEVSYSAPI = "DEVSYSAPI";
    public static final String APISOURCE_PREDEFINED = "PREDEFINED";
    public static final String APITYPE_RESTFUL = "RESTFUL";
    public static final String APITYPE_JAXRS = "JAXRS";
    public static final String APITYPE_WEBSERVICE = "WEBSERVICE";
    public static final String SERVICETYPE_DEFAULT = "DEFAULT";
    public static final String SERVICETYPE_MIDDLEPLATFORM = "MIDDLEPLATFORM";
    public static final String SERVICETYPE_MASA = "MASA";
    public static final String SERVICETYPE_USER = "USER";
    public static final String SERVICETYPE_USER2 = "USER2";
    public static final String SERVICETYPE_IBIZCLOUD = "IBIZCLOUD";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSubSysServiceAPI var3) throws Exception;

    @Override
    public String getCodeName();

    public String getAPIType();

    public Iterator<IPSSubSysServiceAPIMethod> getPSSubSysServiceAPIMethods();

    public Iterator<IPSSubSysServiceAPIMethod> getAllPSSubSysServiceAPIMethods();

    public IPSSysServiceAPI getPSSysServiceAPI();

    public Iterator<String> getDENames();

    public String getServiceCodeName();

    public String getAuthScriptCode();

    public IPSSystemModule getPSSystemModule();

    public String getHandler();

    public IPSSubSysServiceAPIDERS getPSSubSysServiceAPIDERS(String var1, boolean var2) throws Exception;

    public void resetPSSubSysServiceAPIDERS(String var1);

    public Iterator<IPSSubSysServiceAPIDERS> getAllPSSubSysServiceAPIDERSs() throws Exception;

    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE(String var1, boolean var2) throws Exception;

    public void resetPSSubSysServiceAPIDE(String var1);

    public Iterator<IPSSubSysServiceAPIDE> getAllPSSubSysServiceAPIDEs() throws Exception;

    public String getServiceParam3();

    public String getServiceParam4();

    public String getAuthParam3();

    public String getAuthParam4();

    public IPSSubSysServiceAPIMethod getPSSubSysServiceAPIMethod(String var1, boolean var2) throws Exception;

    public String getAPISource();

    public String getDefaultDEActionReqMethod();

    public String getDefaultSelectReqMethod();

    public String getDefaultDEDataSetReqMethod();

    public String getPredefinedType();

    public String getAPITag();

    public String getAPITag2();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public String getDEPSSysSFPluginId();

    public String getServiceType();

    public Iterator<IPSSubSysServiceAPIDTO> getAllPSSubSysServiceAPIDTOs();

    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIInputDTO(IPSSubSysServiceAPIMethodInput var1) throws Exception;

    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIReturnDTO(IPSSubSysServiceAPIMethodReturn var1) throws Exception;

    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIDTO(IPSSubSysServiceAPIDE var1) throws Exception;

    public String getDTOCodeName(IPSSubSysServiceAPIDE var1) throws Exception;

    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIDTO(IPSDEMethodDTO var1) throws Exception;

    public String getDTOCodeName(IPSDEMethodDTO var1) throws Exception;

    public boolean isEnableServiceAPIDTO();

    public IPSOpenAPI3Schema getPSOpenAPI3Schema();

    public boolean isFromDEModel();

    public Properties getHeaderParams();

    public String getMethodScriptCode();

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

    public boolean isResetDefaultActionCodeName();

    public String getAPICodeNameMode();

    public String getAPICodeName(String var1, String var2, String var3);

    public boolean isEnableAPIModelEx();

    public void loadAll() throws Exception;

    public IPSSysResource getPSSysResource();
}

