/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionRuntime;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetRuntime;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFCodeObjectHelper;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Service.IPSDEActionRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTO;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethodInput;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethodReturn;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPIHandler;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Schema;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIDEGlobalModel;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIDERSGlobalModel;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIDTOImpl;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIMethodImpl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.PS.Data.PSSubSysSADetail;
import SA.SRFDA.PS.Data.PSSubSysServiceAPI;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysServiceAPIImpl
extends PSSystemObjectImpl
implements IPSSubSysServiceAPI,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIImpl.class);
    protected PSSubSysServiceAPI psSubSysServiceAPI = null;
    private String strCodeName = null;
    private ArrayList<IPSSubSysServiceAPIMethod> psSubSysServiceAPIMethodList = new ArrayList();
    private Map<String, IPSSubSysServiceAPIMethod> psSubSysServiceAPIMethodMap = new LinkedHashMap<String, IPSSubSysServiceAPIMethod>();
    private String strAPIType = "RESTFUL";
    private IPSSysServiceAPI iPSSysServiceAPI = null;
    private String strServicePath = null;
    private String strServiceParam = null;
    private String strServiceParam2 = null;
    private Map<String, String> deNameMap = new LinkedHashMap<String, String>();
    private String strServiceCodeName = null;
    private String strAuthMode = "NONE";
    private String strAuthClientId = null;
    private String strAuthAccessTokenUrl = null;
    private String strAuthClientSecret = null;
    private IPSSystemModule iPSSystemModule = null;
    private String strHandler = null;
    private IPSSysServiceAPIHandler iPSSysServiceAPIHandler = null;
    private PSSubSysServiceAPIDEGlobalModel psSubSysServiceAPIDEGlobalModel = new PSSubSysServiceAPIDEGlobalModel();
    private PSSubSysServiceAPIDERSGlobalModel psSubSysServiceAPIDERSGlobalModel = new PSSubSysServiceAPIDERSGlobalModel();
    private String strAPISource = "NONE";
    private String strPredefinedType = "";
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private String strServiceType = "DEFAULT";
    private Properties headerParams = null;
    private boolean bEnableServiceAPIDTO = false;
    private boolean bFromDEModel = true;
    private TreeMap<String, IPSSubSysServiceAPIDTO> psSubSysServiceAPIDTOMap = new TreeMap();
    private int nAuthTimeout = -1;
    private String strDefaultCreateReqMethod = null;
    private String strDefaultUpdateReqMethod = null;
    private String strDefaultGetReqMethod = null;
    private String strDefaultDeleteReqMethod = null;
    private String strDefaultGetDraftReqMethod = null;
    private Properties serviceParams = null;
    private boolean bResetDefaultActionCodeName = false;
    private boolean bEnableAPIModelEx = false;
    private IPSSysResource iPSSysResource = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSubSysServiceAPI psSubSysServiceAPI) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSubSysServiceAPI = psSubSysServiceAPI;
            this.setId(this.psSubSysServiceAPI.getPSSUBSYSSERVICEAPIID());
            this.setName(this.psSubSysServiceAPI.getPSSUBSYSSERVICEAPINAME());
            this.setPSObjectData(this.psSubSysServiceAPI);
            this.bEnableAPIModelEx = !this.psSubSysServiceAPI.isENABLEAPIMODELEXNull() ? this.psSubSysServiceAPI.getENABLEAPIMODELEX() : this.getPSSystemSetting().isEnableServiceAPIModelEx();
            if (!this.psSubSysServiceAPI.isSERVICEDTOFLAGNull()) {
                this.bEnableServiceAPIDTO = this.psSubSysServiceAPI.getSERVICEDTOFLAG();
            } else if (this.getPSSystem().isEnableModelRT()) {
                this.bEnableServiceAPIDTO = true;
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysServiceAPI.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSubSysServiceAPI.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysServiceAPI.getAPITYPE())) {
                this.strAPIType = this.psSubSysServiceAPI.getAPITYPE();
            }
            this.strCodeName = this.psSubSysServiceAPI.getCODENAME();
            this.strServiceCodeName = this.psSubSysServiceAPI.getSERVICECODENAME();
            if (!this.psSubSysServiceAPI.isVERNull()) {
                this.setVersion(this.psSubSysServiceAPI.getVER());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysServiceAPI.getAUTHMODE())) {
                this.strAuthMode = this.psSubSysServiceAPI.getAUTHMODE();
            }
            if (!this.psSubSysServiceAPI.isAUTHTIMEOUTNull() && this.psSubSysServiceAPI.getAUTHTIMEOUT() > 0) {
                this.nAuthTimeout = this.psSubSysServiceAPI.getAUTHTIMEOUT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysServiceAPI.getAPISOURCE())) {
                this.strAPISource = this.psSubSysServiceAPI.getAPISOURCE();
            }
            if (StringHelper.compare((String)this.getAPISource(), (String)"SYSAPI", (boolean)false) == 0 && !StringHelper.isNullOrEmpty((String)psSubSysServiceAPI.getPSSYSSERVICEAPIID())) {
                this.iPSSysServiceAPI = this.getPSSystem().getPSSysServiceAPI(psSubSysServiceAPI.getPSSYSSERVICEAPIID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysServiceAPI.getSERVICETYPE())) {
                this.strServiceType = this.psSubSysServiceAPI.getSERVICETYPE();
            }
            this.strAuthClientId = this.psSubSysServiceAPI.getAUTHCLIENTID();
            this.strAuthAccessTokenUrl = this.psSubSysServiceAPI.getAUTHACCESSTOKENURI();
            this.strAuthClientSecret = this.psSubSysServiceAPI.getAUTHCLIENTSECRET();
            this.strServicePath = this.psSubSysServiceAPI.getSERVICEPATH();
            this.strServiceParam = this.psSubSysServiceAPI.getSERVICEPARAM();
            this.strServiceParam2 = this.psSubSysServiceAPI.getSERVICEPARAM2();
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysServiceAPI.getHEADERPARAMS())) {
                this.headerParams = PropertiesHelper.load((String)this.psSubSysServiceAPI.getHEADERPARAMS());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysServiceAPI.getPSSYSSAHANDLERID())) {
                this.iPSSysServiceAPIHandler = this.getPSSystem().getPSSysServiceAPIHandler(this.psSubSysServiceAPI.getPSSYSSAHANDLERID());
                if (StringHelper.compare((String)this.psSubSysServiceAPI.getAPISOURCE(), (String)"PREDEFINED", (boolean)false) == 0 && StringHelper.isNullOrEmpty((String)this.psSubSysServiceAPI.getPREDEFINEDTYPE())) {
                    throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u4e3a\u5916\u90e8\u670d\u52a1\u63a5\u53e3[%1$s]\u6307\u5b9a\u9884\u5b9a\u4e49\u7c7b\u578b", (Object)this.getName()));
                }
            } else if (StringHelper.compare((String)this.psSubSysServiceAPI.getAPISOURCE(), (String)"PREDEFINED", (boolean)false) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psSubSysServiceAPI.getPREDEFINEDTYPE())) {
                    throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u4e3a\u5916\u90e8\u670d\u52a1\u63a5\u53e3[%1$s]\u6307\u5b9a\u9884\u5b9a\u4e49\u7c7b\u578b", (Object)this.getName()));
                }
                this.iPSSysServiceAPIHandler = this.getPSSystem().getPSSysServiceAPIHandlerByPredefinedType(this.psSubSysServiceAPI.getPREDEFINEDTYPE(), true);
                if (this.iPSSysServiceAPIHandler == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5916\u90e8\u670d\u52a1\u63a5\u53e3[%1$s]\u9884\u5b9a\u4e49\u7c7b\u578b[%2$s]\u5904\u7406\u5bf9\u8c61", (Object)this.getName(), (Object)this.psSubSysServiceAPI.getPREDEFINEDTYPE()));
                }
            }
            if (this.iPSSysServiceAPIHandler != null) {
                this.strHandler = this.iPSSysServiceAPIHandler.getClientHandler(this.getAPIType());
            }
            if (StringHelper.isNullOrEmpty((String)this.strHandler)) {
                this.strHandler = null;
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysServiceAPI.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSubSysServiceAPI.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                }
            }
            if (!this.psSubSysServiceAPI.isFROMDEMODELFLAGNull()) {
                this.bFromDEModel = this.psSubSysServiceAPI.getFROMDEMODELFLAG();
            }
            if (!this.psSubSysServiceAPI.isRESETDEFACTIONCODENAMENull()) {
                this.bResetDefaultActionCodeName = this.psSubSysServiceAPI.getRESETDEFACTIONCODENAME();
            } else if ("RESTFUL".equals(this.getAPIType()) && this.isEnableAPIModelEx()) {
                this.bResetDefaultActionCodeName = true;
            }
            this.serviceParams = PropertiesHelper.load((String)this.psSubSysServiceAPI.getSERVICEPARAMS());
            this.strDefaultCreateReqMethod = this.psSubSysServiceAPI.getDEFCREATEREQMETHOD();
            this.strDefaultUpdateReqMethod = this.psSubSysServiceAPI.getDEFUPDATEREQMETHOD();
            this.strDefaultGetReqMethod = this.psSubSysServiceAPI.getDEFGETREQMETHOD();
            this.strDefaultDeleteReqMethod = this.psSubSysServiceAPI.getDEFDELETEREQMETHOD();
            this.strDefaultGetDraftReqMethod = this.psSubSysServiceAPI.getDEFGETDRAFTREQMETHOD();
            if (StringHelper.isNullOrEmpty((String)this.strDefaultCreateReqMethod)) {
                this.strDefaultCreateReqMethod = PropertiesHelper.getProperty((Properties)this.getServiceParams(), (String)"DEFAULTREQMETHOD.CREATE");
            }
            if (StringHelper.isNullOrEmpty((String)this.strDefaultUpdateReqMethod)) {
                this.strDefaultUpdateReqMethod = PropertiesHelper.getProperty((Properties)this.getServiceParams(), (String)"DEFAULTREQMETHOD.UPDATE");
            }
            if (StringHelper.isNullOrEmpty((String)this.strDefaultGetReqMethod)) {
                this.strDefaultGetReqMethod = PropertiesHelper.getProperty((Properties)this.getServiceParams(), (String)"DEFAULTREQMETHOD.GET");
            }
            if (StringHelper.isNullOrEmpty((String)this.strDefaultDeleteReqMethod)) {
                this.strDefaultDeleteReqMethod = PropertiesHelper.getProperty((Properties)this.getServiceParams(), (String)"DEFAULTREQMETHOD.DELETE");
            }
            if (StringHelper.isNullOrEmpty((String)this.strDefaultGetDraftReqMethod)) {
                this.strDefaultGetDraftReqMethod = PropertiesHelper.getProperty((Properties)this.getServiceParams(), (String)"DEFAULTREQMETHOD.GETDRAFT");
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysServiceAPI.getPSSYSRESOURCEID())) {
                this.iPSSysResource = this.getPSSystem().getPSSysResource(this.psSubSysServiceAPI.getPSSYSRESOURCEID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.psSubSysServiceAPIDEGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSubSysServiceAPIDERSGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSubSysServiceAPIDEGlobalModel.getAllModelHelpers();
        this.psSubSysServiceAPIDERSGlobalModel.getAllModelHelpers();
        this.onPreparePSSubSysServiceAPIMethods();
        super.onInit();
    }

    @Override
    public int check() throws Exception {
        Iterator<IPSSubSysServiceAPIDERS> psSubSysServiceAPIDERSs;
        int nRet = 0;
        Iterator<IPSSubSysServiceAPIDE> psSubSysServiceAPIDEs = this.getAllPSSubSysServiceAPIDEs();
        if (psSubSysServiceAPIDEs != null) {
            while (psSubSysServiceAPIDEs.hasNext()) {
                IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = psSubSysServiceAPIDEs.next();
                nRet += iPSSubSysServiceAPIDE.check();
            }
        }
        if ((psSubSysServiceAPIDERSs = this.getAllPSSubSysServiceAPIDERSs()) != null) {
            while (psSubSysServiceAPIDERSs.hasNext()) {
                IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS = psSubSysServiceAPIDERSs.next();
                nRet += iPSSubSysServiceAPIDERS.check();
            }
        }
        return nRet + super.check();
    }

    protected void onPreparePSSubSysServiceAPIMethods() throws Exception {
        this.psSubSysServiceAPIMethodList.clear();
        this.deNameMap.clear();
        Vector<PSSubSysSADetail> psSubSysServiceAPIMethodList = new Vector<PSSubSysSADetail>();
        CallResult callResult = this.getPSModelHelper().getPSSubSysSADetails(this.getId(), psSubSysServiceAPIMethodList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u6240\u6709\u65b9\u6cd5\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSubSysSADetail psSubSysServiceAPIMethod : psSubSysServiceAPIMethodList) {
            if (!psSubSysServiceAPIMethod.isVALIDFLAGNull() && !psSubSysServiceAPIMethod.getVALIDFLAG()) continue;
            PSSubSysServiceAPIMethodImpl psSubSysServiceAPIMethodImpl = new PSSubSysServiceAPIMethodImpl();
            psSubSysServiceAPIMethodImpl.init(this.getDAGlobalHelper(), this, null, psSubSysServiceAPIMethod, null);
            this.psSubSysServiceAPIMethodList.add(psSubSysServiceAPIMethodImpl);
            this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl.getId(), psSubSysServiceAPIMethodImpl);
            this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl.getUniqueTag(), psSubSysServiceAPIMethodImpl);
        }
        if (this.getPSSysServiceAPI() != null) {
            Iterator<IPSDEServiceAPI> psDEServiceAPIs = this.getPSSysServiceAPI().getPSDEServiceAPIs();
            if (psDEServiceAPIs != null) {
                while (psDEServiceAPIs.hasNext()) {
                    IPSDEServiceAPI iPSDEServiceAPI = psDEServiceAPIs.next();
                    Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods = iPSDEServiceAPI.getPSDEServiceAPIMethods();
                    if (psDEServiceAPIMethods == null) continue;
                    while (psDEServiceAPIMethods.hasNext()) {
                        IPSDEServiceAPIMethod iPSDEServiceAPIMethod = psDEServiceAPIMethods.next();
                        PSSubSysSADetail psSubSysServiceAPIMethod = new PSSubSysSADetail();
                        psSubSysServiceAPIMethod.setPSSUBSYSSADETAILID(iPSDEServiceAPIMethod.getId());
                        psSubSysServiceAPIMethod.setPSSUBSYSSADETAILNAME(iPSDEServiceAPIMethod.getName());
                        psSubSysServiceAPIMethod.setPSSUBSYSSERVICEAPIID(this.getId());
                        psSubSysServiceAPIMethod.setPSSUBSYSSERVICEAPINAME(this.getName());
                        psSubSysServiceAPIMethod.setDETAILTYPE(iPSDEServiceAPIMethod.getActionType());
                        psSubSysServiceAPIMethod.setUNIQUETAG(iPSDEServiceAPIMethod.getUniqueTag());
                        psSubSysServiceAPIMethod.setREQUESTMETHOD(iPSDEServiceAPIMethod.getPSRESTfulAPI().getRequestMethod());
                        psSubSysServiceAPIMethod.set("AUTOMODEL", 1);
                        if (StringHelper.isNullOrEmpty((String)iPSDEServiceAPIMethod.getPSRESTfulAPI().getRequestPath())) {
                            psSubSysServiceAPIMethod.setSERVICEURL(StringHelper.format((String)"/%1$s", (Object)iPSDEServiceAPI.getCodeName().toLowerCase()));
                        } else {
                            psSubSysServiceAPIMethod.setSERVICEURL(StringHelper.format((String)"/%1$s%2$s", (Object)iPSDEServiceAPI.getCodeName().toLowerCase(), (Object)iPSDEServiceAPIMethod.getPSRESTfulAPI().getRequestPath()));
                        }
                        if (StringHelper.compare((String)iPSDEServiceAPIMethod.getActionType(), (String)"DEACTION", (boolean)false) == 0) {
                            IPSDEActionRESTfulAPI iPSDEActionRESTfulAPI = (IPSDEActionRESTfulAPI)iPSDEServiceAPIMethod.getPSRESTfulAPI();
                            psSubSysServiceAPIMethod.setREQUESTPARAMTYPE(iPSDEActionRESTfulAPI.getRequestParamType());
                            psSubSysServiceAPIMethod.setKEYFIELDNAME(iPSDEActionRESTfulAPI.getRequestField());
                        }
                        if (this.isEnableAPIModelEx()) {
                            psSubSysServiceAPIMethod.setNOSERVICECODENAME(iPSDEServiceAPIMethod.isNoServiceCodeName());
                            psSubSysServiceAPIMethod.setNEEDRESOURCEKEY(iPSDEServiceAPIMethod.isNeedResourceKey());
                        }
                        PSSubSysServiceAPIMethodImpl psSubSysServiceAPIMethodImpl = new PSSubSysServiceAPIMethodImpl();
                        psSubSysServiceAPIMethodImpl.init(this.getDAGlobalHelper(), this, iPSDEServiceAPI.getPSDataEntity(), psSubSysServiceAPIMethod, iPSDEServiceAPIMethod);
                        this.psSubSysServiceAPIMethodList.add(psSubSysServiceAPIMethodImpl);
                        this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl.getId(), psSubSysServiceAPIMethodImpl);
                        this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl.getUniqueTag(), psSubSysServiceAPIMethodImpl);
                    }
                }
            }
        } else if (this.isFromDEModel()) {
            Iterator<IPSDataEntity> psDataEntities = this.getPSSystem().getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                PSSubSysServiceAPIMethodImpl psSubSysServiceAPIMethodImpl;
                String strRequestPath;
                PSSubSysSADetail psSubSysServiceAPIMethod;
                String strUniqueTag;
                IPSDataEntity iPSDataEntity = psDataEntities.next();
                if (iPSDataEntity.isSubSysDE() || StringHelper.compare((String)iPSDataEntity.getServiceAPIClientId(), (String)this.getId(), (boolean)false) != 0 || !iPSDataEntity.isEnableAPIStorage()) continue;
                if (iPSDataEntity.isEnableSASelect() && !this.isEnableAPIModelEx()) {
                    String strUniqueTag2 = StringHelper.format((String)"%1$s__SELECT", (Object)iPSDataEntity.getName()).toUpperCase();
                    PSSubSysSADetail psSubSysServiceAPIMethod2 = new PSSubSysSADetail();
                    psSubSysServiceAPIMethod2.setPSSUBSYSSADETAILID(strUniqueTag2);
                    psSubSysServiceAPIMethod2.setPSSUBSYSSADETAILNAME("Select");
                    psSubSysServiceAPIMethod2.setPSSUBSYSSERVICEAPIID(this.getId());
                    psSubSysServiceAPIMethod2.setPSSUBSYSSERVICEAPINAME(this.getName());
                    psSubSysServiceAPIMethod2.setDETAILTYPE("SELECT");
                    psSubSysServiceAPIMethod2.setUNIQUETAG(strUniqueTag2);
                    psSubSysServiceAPIMethod2.setCODENAME("Select");
                    psSubSysServiceAPIMethod2.setPSSUBSYSSADEID(iPSDataEntity.getPSSubSysSADEId());
                    if (StringHelper.isNullOrEmpty((String)this.getDefaultSelectReqMethod())) {
                        psSubSysServiceAPIMethod2.setREQUESTMETHOD("POST");
                    } else {
                        psSubSysServiceAPIMethod2.setREQUESTMETHOD(this.getDefaultSelectReqMethod());
                    }
                    psSubSysServiceAPIMethod2.setSERVICEURL(StringHelper.format((String)"/%1$s/%2$s", (Object)iPSDataEntity.getServiceCodeName().toLowerCase(), (Object)"select"));
                    psSubSysServiceAPIMethod2.set("AUTOMODEL", 1);
                    psSubSysServiceAPIMethod2.set("AUTOPATH", 1);
                    PSSubSysServiceAPIMethodImpl psSubSysServiceAPIMethodImpl2 = new PSSubSysServiceAPIMethodImpl();
                    psSubSysServiceAPIMethodImpl2.init(this.getDAGlobalHelper(), this, iPSDataEntity, psSubSysServiceAPIMethod2, null);
                    this.psSubSysServiceAPIMethodList.add(psSubSysServiceAPIMethodImpl2);
                    this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl2.getId(), psSubSysServiceAPIMethodImpl2);
                    this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl2.getUniqueTag(), psSubSysServiceAPIMethodImpl2);
                    if (iPSDataEntity.isEnableTempDataBackend()) {
                        strUniqueTag2 = StringHelper.format((String)"%1$s__SELECTTEMP", (Object)iPSDataEntity.getName()).toUpperCase();
                        psSubSysServiceAPIMethod2 = new PSSubSysSADetail();
                        psSubSysServiceAPIMethod2.setPSSUBSYSSADETAILID(strUniqueTag2);
                        psSubSysServiceAPIMethod2.setPSSUBSYSSADETAILNAME("SelectTemp");
                        psSubSysServiceAPIMethod2.setPSSUBSYSSERVICEAPIID(this.getId());
                        psSubSysServiceAPIMethod2.setPSSUBSYSSERVICEAPINAME(this.getName());
                        psSubSysServiceAPIMethod2.setDETAILTYPE("SELECTTEMP");
                        psSubSysServiceAPIMethod2.setUNIQUETAG(strUniqueTag2);
                        psSubSysServiceAPIMethod2.setCODENAME("SelectTemp");
                        psSubSysServiceAPIMethod2.setPSSUBSYSSADEID(iPSDataEntity.getPSSubSysSADEId());
                        if (StringHelper.isNullOrEmpty((String)this.getDefaultSelectReqMethod())) {
                            psSubSysServiceAPIMethod2.setREQUESTMETHOD("POST");
                        } else {
                            psSubSysServiceAPIMethod2.setREQUESTMETHOD(this.getDefaultSelectReqMethod());
                        }
                        psSubSysServiceAPIMethod2.setSERVICEURL(StringHelper.format((String)"/%1$s/%2$s", (Object)iPSDataEntity.getServiceCodeName().toLowerCase(), (Object)"selecttemp"));
                        psSubSysServiceAPIMethod2.set("AUTOMODEL", 1);
                        psSubSysServiceAPIMethod2.set("AUTOPATH", 1);
                        psSubSysServiceAPIMethodImpl2 = new PSSubSysServiceAPIMethodImpl();
                        psSubSysServiceAPIMethodImpl2.init(this.getDAGlobalHelper(), this, iPSDataEntity, psSubSysServiceAPIMethod2, null);
                        this.psSubSysServiceAPIMethodList.add(psSubSysServiceAPIMethodImpl2);
                        this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl2.getId(), psSubSysServiceAPIMethodImpl2);
                        this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl2.getUniqueTag(), psSubSysServiceAPIMethodImpl2);
                    }
                }
                Iterator<IPSDEAction> psDEActions = iPSDataEntity.getAllPSDEActions();
                while (psDEActions.hasNext()) {
                    IPSDEAction iPSDEAction = psDEActions.next();
                    if (!StringHelper.isNullOrEmpty((String)iPSDEAction.getPSSubSysServiceAPIDEMethodId()) || !iPSDEAction.isEnableBackend() || iPSDEAction.getSubSysServiceAPIDEMethodBindingMode() != 2) continue;
                    strUniqueTag = StringHelper.format((String)"%1$s__DEACTION__%2$s", (Object)iPSDataEntity.getName(), (Object)iPSDEAction.getName()).toUpperCase();
                    psSubSysServiceAPIMethod = new PSSubSysSADetail();
                    psSubSysServiceAPIMethod.setPSSUBSYSSADETAILID(strUniqueTag);
                    psSubSysServiceAPIMethod.setPSSUBSYSSADETAILNAME(iPSDEAction.getName());
                    psSubSysServiceAPIMethod.setPSSUBSYSSERVICEAPIID(this.getId());
                    psSubSysServiceAPIMethod.setPSSUBSYSSERVICEAPINAME(this.getName());
                    psSubSysServiceAPIMethod.setDETAILTYPE("DEACTION");
                    psSubSysServiceAPIMethod.setUNIQUETAG(strUniqueTag);
                    psSubSysServiceAPIMethod.set("AUTOMODEL", 1);
                    psSubSysServiceAPIMethod.setCODENAME(iPSDEAction.getServiceCodeName());
                    psSubSysServiceAPIMethod.setPSSUBSYSSADEID(iPSDataEntity.getPSSubSysSADEId());
                    psSubSysServiceAPIMethod.setPSDEACTIONID(iPSDEAction.getId());
                    if (!StringHelper.isNullOrEmpty((String)iPSDEAction.getPSRESTfulAPI().getRequestMethod())) {
                        psSubSysServiceAPIMethod.setREQUESTMETHOD(iPSDEAction.getPSRESTfulAPI().getRequestMethod());
                    } else {
                        String strPSDEActionName;
                        String strPSDEActionName2;
                        String strActionMode;
                        String strRequestMethod = null;
                        strRequestMethod = this.isEnableAPIModelEx() ? ("CREATE".equals(strActionMode = iPSDEAction.getActionMode()) ? this.getCreateReqMethod("POST") : ("UPDATE".equals(strActionMode) ? this.getUpdateReqMethod("PUT") : ("READ".equals(strActionMode) ? this.getGetReqMethod("GET") : ("DELETE".equals(strActionMode) ? this.getDeleteReqMethod("DELETE") : ((strPSDEActionName2 = iPSDEAction.getName().toUpperCase()).indexOf("CREATE") != -1 ? this.getCreateReqMethod("POST") : (strPSDEActionName2.indexOf("UPDATE") != -1 ? this.getUpdateReqMethod("PUT") : (strPSDEActionName2.indexOf("GET") != -1 ? this.getGetReqMethod("GET") : (strPSDEActionName2.indexOf("REMOVE") != -1 ? this.getDeleteReqMethod("DELETE") : (!StringHelper.isNullOrEmpty((String)this.getDefaultDEActionReqMethod()) ? this.getDefaultDEActionReqMethod() : "POST"))))))))) : ((strPSDEActionName = iPSDEAction.getName().toUpperCase()).indexOf("CREATE") != -1 ? this.getCreateReqMethod("POST") : (strPSDEActionName.indexOf("UPDATE") != -1 ? this.getUpdateReqMethod("PUT") : (strPSDEActionName.indexOf("GET") != -1 ? this.getGetReqMethod("GET") : (strPSDEActionName.indexOf("REMOVE") != -1 ? this.getDeleteReqMethod("DELETE") : (!StringHelper.isNullOrEmpty((String)this.getDefaultDEActionReqMethod()) ? this.getDefaultDEActionReqMethod() : "POST")))));
                        psSubSysServiceAPIMethod.setREQUESTMETHOD(strRequestMethod);
                    }
                    strRequestPath = iPSDEAction.getPSRESTfulAPI().getRequestPath();
                    if (!StringHelper.isNullOrEmpty((String)strRequestPath)) {
                        psSubSysServiceAPIMethod.setSERVICEURL(StringHelper.format((String)"/%1$s%2$s", (Object)iPSDataEntity.getServiceCodeName().toLowerCase(), (Object)strRequestPath));
                    } else {
                        if (this.isEnableAPIModelEx()) {
                            if (this.isResetDefaultActionCodeName()) {
                                if (StringHelper.compare((String)iPSDEAction.getName(), (String)"CREATE", (boolean)true) == 0 || StringHelper.compare((String)iPSDEAction.getName(), (String)"UPDATE", (boolean)true) == 0 || StringHelper.compare((String)iPSDEAction.getName(), (String)"REMOVE", (boolean)true) == 0 || StringHelper.compare((String)iPSDEAction.getName(), (String)"GET", (boolean)true) == 0) {
                                    psSubSysServiceAPIMethod.setNOSERVICECODENAME(true);
                                }
                            } else {
                                psSubSysServiceAPIMethod.setSERVICEURL(StringHelper.format((String)"/%1$s/%2$s", (Object)iPSDataEntity.getServiceCodeName().toLowerCase(), (Object)iPSDEAction.getCodeName().toLowerCase()));
                            }
                        } else if (StringHelper.compare((String)iPSDEAction.getName(), (String)"CREATE", (boolean)true) != 0 && StringHelper.compare((String)iPSDEAction.getName(), (String)"UPDATE", (boolean)true) != 0 && StringHelper.compare((String)iPSDEAction.getName(), (String)"REMOVE", (boolean)true) != 0 && StringHelper.compare((String)iPSDEAction.getName(), (String)"GET", (boolean)true) != 0) {
                            psSubSysServiceAPIMethod.setSERVICEURL(StringHelper.format((String)"/%1$s/%2$s", (Object)iPSDataEntity.getServiceCodeName().toLowerCase(), (Object)iPSDEAction.getCodeName().toLowerCase()));
                        } else {
                            psSubSysServiceAPIMethod.setSERVICEURL(StringHelper.format((String)"/%1$s", (Object)iPSDataEntity.getServiceCodeName().toLowerCase()));
                            psSubSysServiceAPIMethod.setNOSERVICECODENAME(true);
                        }
                        psSubSysServiceAPIMethod.set("AUTOPATH", 1);
                    }
                    IPSDEActionRESTfulAPI iPSDEActionRESTfulAPI = (IPSDEActionRESTfulAPI)iPSDEAction.getPSRESTfulAPI();
                    psSubSysServiceAPIMethod.setREQUESTPARAMTYPE(iPSDEActionRESTfulAPI.getRequestParamType());
                    psSubSysServiceAPIMethod.setKEYFIELDNAME(iPSDEActionRESTfulAPI.getRequestField());
                    psSubSysServiceAPIMethodImpl = new PSSubSysServiceAPIMethodImpl();
                    psSubSysServiceAPIMethodImpl.init(this.getDAGlobalHelper(), this, iPSDataEntity, psSubSysServiceAPIMethod, iPSDEAction);
                    this.psSubSysServiceAPIMethodList.add(psSubSysServiceAPIMethodImpl);
                    this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl.getId(), psSubSysServiceAPIMethodImpl);
                    this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl.getUniqueTag(), psSubSysServiceAPIMethodImpl);
                    if (!(iPSDEAction instanceof IPSDEActionRuntime)) continue;
                    ((IPSDEActionRuntime)((Object)iPSDEAction)).setPSSubSysServiceAPIDEMethod(psSubSysServiceAPIMethodImpl);
                }
                Iterator<IPSDEDataSet> psDEDataSets = iPSDataEntity.getAllPSDEDataSets();
                while (psDEDataSets.hasNext()) {
                    IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
                    if (!StringHelper.isNullOrEmpty((String)iPSDEDataSet.getPSSubSysServiceAPIDEMethodId()) || !iPSDEDataSet.isEnableBackend() || iPSDEDataSet.getSubSysServiceAPIDEMethodBindingMode() != 2) continue;
                    strUniqueTag = StringHelper.format((String)"%1$s__FETCH__%2$s", (Object)iPSDataEntity.getName(), (Object)iPSDEDataSet.getName()).toUpperCase();
                    psSubSysServiceAPIMethod = new PSSubSysSADetail();
                    psSubSysServiceAPIMethod.setPSSUBSYSSADETAILID(strUniqueTag);
                    psSubSysServiceAPIMethod.setPSSUBSYSSADETAILNAME(iPSDEDataSet.getName());
                    psSubSysServiceAPIMethod.setPSSUBSYSSERVICEAPIID(this.getId());
                    psSubSysServiceAPIMethod.setPSSUBSYSSERVICEAPINAME(this.getName());
                    psSubSysServiceAPIMethod.setDETAILTYPE("FETCH");
                    psSubSysServiceAPIMethod.setUNIQUETAG(strUniqueTag);
                    psSubSysServiceAPIMethod.set("AUTOMODEL", 1);
                    psSubSysServiceAPIMethod.setCODENAME(iPSDEDataSet.getServiceCodeName());
                    psSubSysServiceAPIMethod.setPSSUBSYSSADEID(iPSDataEntity.getPSSubSysSADEId());
                    psSubSysServiceAPIMethod.setPSDEDSID(iPSDEDataSet.getId());
                    if (!StringHelper.isNullOrEmpty((String)iPSDEDataSet.getPSRESTfulAPI().getRequestMethod())) {
                        psSubSysServiceAPIMethod.setREQUESTMETHOD(iPSDEDataSet.getPSRESTfulAPI().getRequestMethod());
                    } else if (StringHelper.isNullOrEmpty((String)this.getDefaultDEDataSetReqMethod())) {
                        psSubSysServiceAPIMethod.setREQUESTMETHOD("POST");
                    } else {
                        psSubSysServiceAPIMethod.setREQUESTMETHOD(this.getDefaultDEDataSetReqMethod());
                    }
                    strRequestPath = iPSDEDataSet.getPSRESTfulAPI().getRequestPath();
                    if (!StringHelper.isNullOrEmpty((String)strRequestPath)) {
                        psSubSysServiceAPIMethod.setSERVICEURL(StringHelper.format((String)"/%1$s%2$s", (Object)iPSDataEntity.getServiceCodeName().toLowerCase(), (Object)strRequestPath));
                    } else {
                        psSubSysServiceAPIMethod.setSERVICEURL(StringHelper.format((String)"/%1$s/fetch%2$s", (Object)iPSDataEntity.getServiceCodeName().toLowerCase(), (Object)iPSDEDataSet.getCodeName().toLowerCase()));
                        psSubSysServiceAPIMethod.set("AUTOPATH", 1);
                    }
                    psSubSysServiceAPIMethodImpl = new PSSubSysServiceAPIMethodImpl();
                    psSubSysServiceAPIMethodImpl.init(this.getDAGlobalHelper(), this, iPSDataEntity, psSubSysServiceAPIMethod, iPSDEDataSet);
                    this.psSubSysServiceAPIMethodList.add(psSubSysServiceAPIMethodImpl);
                    this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl.getId(), psSubSysServiceAPIMethodImpl);
                    this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl.getUniqueTag(), psSubSysServiceAPIMethodImpl);
                    if (iPSDEDataSet instanceof IPSDEDataSetRuntime) {
                        ((IPSDEDataSetRuntime)((Object)iPSDEDataSet)).setPSSubSysServiceAPIDEMethod(psSubSysServiceAPIMethodImpl);
                    }
                    if (!iPSDataEntity.isEnableTempDataBackend() || this.isEnableAPIModelEx()) continue;
                    strUniqueTag = StringHelper.format((String)"%1$s__FETCHTEMP__%2$s", (Object)iPSDataEntity.getName(), (Object)iPSDEDataSet.getName()).toUpperCase();
                    psSubSysServiceAPIMethod = new PSSubSysSADetail();
                    psSubSysServiceAPIMethod.setPSSUBSYSSADETAILID(strUniqueTag);
                    psSubSysServiceAPIMethod.setPSSUBSYSSADETAILNAME(iPSDEDataSet.getName());
                    psSubSysServiceAPIMethod.setPSSUBSYSSERVICEAPIID(this.getId());
                    psSubSysServiceAPIMethod.setPSSUBSYSSERVICEAPINAME(this.getName());
                    psSubSysServiceAPIMethod.setDETAILTYPE("FETCHTEMP");
                    psSubSysServiceAPIMethod.setUNIQUETAG(strUniqueTag);
                    psSubSysServiceAPIMethod.setCODENAME(StringHelper.format((String)"FetchTemp%1$s", (Object)PSModelCodeNameUtils.capitalize(iPSDEDataSet.getCodeName())));
                    psSubSysServiceAPIMethod.setPSSUBSYSSADEID(iPSDataEntity.getPSSubSysSADEId());
                    psSubSysServiceAPIMethod.set("AUTOMODEL", 1);
                    if (!StringHelper.isNullOrEmpty((String)iPSDEDataSet.getPSRESTfulAPI().getRequestMethod())) {
                        psSubSysServiceAPIMethod.setREQUESTMETHOD(iPSDEDataSet.getPSRESTfulAPI().getRequestMethod());
                    } else if (StringHelper.isNullOrEmpty((String)this.getDefaultDEDataSetReqMethod())) {
                        psSubSysServiceAPIMethod.setREQUESTMETHOD("POST");
                    } else {
                        psSubSysServiceAPIMethod.setREQUESTMETHOD(this.getDefaultDEDataSetReqMethod());
                    }
                    strRequestPath = iPSDEDataSet.getPSRESTfulAPI().getRequestPath();
                    if (!StringHelper.isNullOrEmpty((String)strRequestPath)) {
                        psSubSysServiceAPIMethod.setSERVICEURL(StringHelper.format((String)"/%1$s%2$s", (Object)iPSDataEntity.getServiceCodeName().toLowerCase(), (Object)strRequestPath));
                    } else {
                        psSubSysServiceAPIMethod.setSERVICEURL(StringHelper.format((String)"/%1$s/fetchtemp%2$s", (Object)iPSDataEntity.getServiceCodeName().toLowerCase(), (Object)iPSDEDataSet.getCodeName().toLowerCase()));
                        psSubSysServiceAPIMethod.set("AUTOPATH", 1);
                    }
                    psSubSysServiceAPIMethodImpl = new PSSubSysServiceAPIMethodImpl();
                    psSubSysServiceAPIMethodImpl.init(this.getDAGlobalHelper(), this, iPSDataEntity, psSubSysServiceAPIMethod, iPSDEDataSet);
                    this.psSubSysServiceAPIMethodList.add(psSubSysServiceAPIMethodImpl);
                    this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl.getId(), psSubSysServiceAPIMethodImpl);
                    this.psSubSysServiceAPIMethodMap.put(psSubSysServiceAPIMethodImpl.getUniqueTag(), psSubSysServiceAPIMethodImpl);
                }
            }
        }
        Collections.sort(this.psSubSysServiceAPIMethodList, new Comparator<IPSSubSysServiceAPIMethod>(){

            @Override
            public int compare(IPSSubSysServiceAPIMethod o1, IPSSubSysServiceAPIMethod o2) {
                int nRet = StringHelper.compare((String)o1.getRequestPath(), (String)o2.getRequestPath(), (boolean)false);
                if (nRet != 0) {
                    return nRet;
                }
                return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
            }
        });
        for (IPSSubSysServiceAPIMethod iPSSubSysServiceAPIMethod : this.psSubSysServiceAPIMethodList) {
            String strDEName = iPSSubSysServiceAPIMethod.getDEName();
            if (strDEName == null) {
                strDEName = "";
            }
            this.deNameMap.put(strDEName, "");
            if (!this.isEnableServiceAPIDTO() || !(iPSSubSysServiceAPIMethod instanceof IPSSubSysServiceAPIDEMethod)) continue;
            IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = (IPSSubSysServiceAPIDEMethod)iPSSubSysServiceAPIMethod;
            iPSSubSysServiceAPIDEMethod.getPSSubSysServiceAPIMethodInput();
            iPSSubSysServiceAPIDEMethod.getPSSubSysServiceAPIMethodReturn();
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSSUBSYSSERVICEAPI";
    }

    @Override
    public Iterator<IPSSubSysServiceAPIMethod> getPSSubSysServiceAPIMethods() {
        if (this.psSubSysServiceAPIMethodList.size() == 0) {
            return null;
        }
        return this.psSubSysServiceAPIMethodList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u7c7b\u578b", codelist="SubSysAPIType", fields={"APITYPE"})
    public String getAPIType() {
        if (this.getPSSysServiceAPI() != null) {
            return this.getPSSysServiceAPI().getAPIType();
        }
        return this.strAPIType;
    }

    @Override
    public IPSSysServiceAPI getPSSysServiceAPI() {
        return this.iPSSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u8def\u5f84", fields={"SERVICEPATH"})
    public String getServicePath() {
        return this.strServicePath;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u6570", fields={"SERVICEPARAM"})
    public String getServiceParam() {
        return this.strServiceParam;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u65702", fields={"SERVICEPARAM2"})
    public String getServiceParam2() {
        return this.strServiceParam2;
    }

    @Override
    public Iterator<String> getDENames() {
        if (this.deNameMap.size() > 0) {
            return this.deNameMap.keySet().iterator();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u4ee3\u7801\u540d\u79f0", fields={"SERVICECODENAME"})
    public String getServiceCodeName() {
        if (StringHelper.isNullOrEmpty((String)this.strServiceCodeName)) {
            return this.getCodeName();
        }
        return this.strServiceCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u6a21\u5f0f", codelist="APIAuthMode", fields={"AUTHMODE"})
    public String getAuthMode() {
        return this.strAuthMode;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1token\u8def\u5f84", fields={"AUTHACCESSTOKENURI"})
    public String getAuthAccessTokenUrl() {
        return this.strAuthAccessTokenUrl;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u6807\u8bc6", fields={"AUTHCLIENTID"})
    public String getAuthClientId() {
        return this.strAuthClientId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u5bc6\u7801", fields={"AUTHCLIENTSECRET"})
    public String getAuthClientSecret() {
        return this.strAuthClientSecret;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, outputdoc="false")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        String strPKGName = PSSFCodeObjectHelper.getClassOrPkgName(this, this.iPSSystemModule, null, "PKG", iPSSysSFPub);
        if (StringHelper.compare((String)strCodeType, (String)"PKG", (boolean)true) == 0) {
            return strPKGName;
        }
        String strNameFormat = PSSFCodeObjectHelper.getClassOrPkgName(this, this.iPSSystemModule, null, strCodeType, iPSSysSFPub);
        if (StringHelper.isNullOrEmpty((String)strNameFormat)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u670d\u52a1\u5ba2\u6237\u7aef[%1$s]\u4ee3\u7801\u7c7b\u578b[%2$s]\u4ee3\u7801\u540d\u79f0", (Object)this.getName(), (Object)strCodeType));
        }
        if (StringHelper.isNullOrEmpty((String)strPKGName)) {
            strPKGName = iPSSysSFPub.getPKGCodeName();
        }
        String strModuleName = "";
        if (this.getPSSystemModule() != null) {
            strModuleName = this.getPSSystemModule().getCodeName();
        }
        if (StringHelper.isNullOrEmpty((String)strPKGName)) {
            strPKGName = iPSSysSFPub.getPKGCodeName();
        }
        if (iPSSysSFPub.getPSSFStyle().getPSSF().isPkgLowercase()) {
            strModuleName = strModuleName.toLowerCase();
        }
        return StringHelper.format((String)strNameFormat, (Object)strPKGName, (Object)strModuleName, (Object)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u5bf9\u8c61")
    public String getHandler() {
        return this.strHandler;
    }

    @Override
    public IPSSubSysServiceAPIDERS getPSSubSysServiceAPIDERS(String strPSSubSysServiceAPIDERSId, boolean bTryMode) throws Exception {
        return (IPSSubSysServiceAPIDERS)this.psSubSysServiceAPIDERSGlobalModel.FindModelHelper(strPSSubSysServiceAPIDERSId, bTryMode);
    }

    @Override
    public void resetPSSubSysServiceAPIDERS(String strPSSubSysServiceAPIDERSId) {
        this.psSubSysServiceAPIDERSGlobalModel.ResetModel(strPSSubSysServiceAPIDERSId);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb\u96c6\u5408", child=true, group="\u903b\u8f91", order=232)
    public Iterator<IPSSubSysServiceAPIDERS> getAllPSSubSysServiceAPIDERSs() throws Exception {
        return this.psSubSysServiceAPIDERSGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE(String strPSSubSysServiceAPIDEId, boolean bTryMode) throws Exception {
        return (IPSSubSysServiceAPIDE)this.psSubSysServiceAPIDEGlobalModel.FindModelHelper(strPSSubSysServiceAPIDEId, bTryMode);
    }

    @Override
    public void resetPSSubSysServiceAPIDE(String strPSSubSysServiceAPIDEId) {
        this.psSubSysServiceAPIDEGlobalModel.ResetModel(strPSSubSysServiceAPIDEId);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5b9e\u4f53\u96c6\u5408", child=true, group="\u903b\u8f91", order=230)
    public Iterator<IPSSubSysServiceAPIDE> getAllPSSubSysServiceAPIDEs() throws Exception {
        return this.psSubSysServiceAPIDEGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u65b9\u6cd5\u96c6\u5408", group="\u903b\u8f91", order=234)
    public Iterator<IPSSubSysServiceAPIMethod> getAllPSSubSysServiceAPIMethods() {
        return this.psSubSysServiceAPIMethodList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u65703", hideempty2=true, fields={"SERVICEPARAM3"})
    public String getServiceParam3() {
        return this.psSubSysServiceAPI.getSERVICEPARAM3();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u65704", hideempty2=true, fields={"SERVICEPARAM4"})
    public String getServiceParam4() {
        return this.psSubSysServiceAPI.getSERVICEPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u6570", fields={"AUTHPARAM"})
    public String getAuthParam() {
        return this.psSubSysServiceAPI.getAUTHPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65702", fields={"AUTHPARAM2"})
    public String getAuthParam2() {
        return this.psSubSysServiceAPI.getAUTHPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65703", hideempty2=true, fields={"AUTHPARAM3"})
    public String getAuthParam3() {
        return this.psSubSysServiceAPI.getAUTHPARAM3();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65704", hideempty2=true, fields={"AUTHPARAM4"})
    public String getAuthParam4() {
        return this.psSubSysServiceAPI.getAUTHPARAM4();
    }

    @Override
    public IPSSubSysServiceAPIMethod getPSSubSysServiceAPIMethod(String strPSSubSysServiceAPIMethodId, boolean bTryMode) throws Exception {
        IPSSubSysServiceAPIMethod iPSSubSysServiceAPIMethod = this.psSubSysServiceAPIMethodMap.get(strPSSubSysServiceAPIMethodId);
        if (iPSSubSysServiceAPIMethod != null || bTryMode) {
            return iPSSubSysServiceAPIMethod;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5[%1$s]", (Object)strPSSubSysServiceAPIMethodId));
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u6765\u6e90", codelist="SubSysAPISource", fields={"APISOURCE"})
    public String getAPISource() {
        return this.strAPISource;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u9ed8\u8ba4\u8bf7\u6c42\u65b9\u5f0f", hideempty2=true, dump=false)
    public String getDefaultDEActionReqMethod() {
        return this.psSubSysServiceAPI.getDEFDEACTIONREQMETHOD();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u67e5\u8be2\u9ed8\u8ba4\u8bf7\u6c42\u65b9\u5f0f", hideempty2=true, dump=false)
    public String getDefaultSelectReqMethod() {
        return this.psSubSysServiceAPI.getDEFSELECTREQMETHOD();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5408\u9ed8\u8ba4\u8bf7\u6c42\u65b9\u5f0f", hideempty2=true, dump=false)
    public String getDefaultDEDataSetReqMethod() {
        return this.psSubSysServiceAPI.getDEFDEDATASETREQMETHOD();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u63a5\u53e3\u7c7b\u578b", hideempty2=true, codelist="PredefinedServiceAPIClient", fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return this.strPredefinedType;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u6807\u8bb0", hideempty2=true, fields={"APITAG"})
    public String getAPITag() {
        return this.psSubSysServiceAPI.getAPITAG();
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u6807\u8bb02", hideempty2=true, fields={"APITAG2"})
    public String getAPITag2() {
        return this.psSubSysServiceAPI.getAPITAG2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    public String getDEPSSysSFPluginId() {
        return this.psSubSysServiceAPI.getDEPSSYSSFPLUGINID();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u7c7b\u578b", group="\u57fa\u672c", order=125, codelist="ServiceType", fields={"SERVICETYPE"})
    public String getServiceType() {
        return this.strServiceType;
    }

    @Override
    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIInputDTO(IPSSubSysServiceAPIMethodInput iPSSubSysServiceAPIMethodInput) throws Exception {
        IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIMethod = iPSSubSysServiceAPIMethodInput.getPSSubSysServiceAPIMethod();
        String strMethodType = iPSSubSysServiceAPIMethod.getMethodType();
        if (StringHelper.compare((String)strMethodType, (String)"DEACTION", (boolean)false) == 0) {
            if (StringHelper.compare((String)iPSSubSysServiceAPIMethodInput.getType(), (String)"DTO", (boolean)false) == 0 || StringHelper.compare((String)iPSSubSysServiceAPIMethodInput.getType(), (String)"DTOS", (boolean)false) == 0) {
                IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = iPSSubSysServiceAPIMethodInput.getPSSubSysServiceAPIDE();
                if (iPSSubSysServiceAPIDE == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5bf9\u8c61", new Object[0]));
                }
                return this.getPSSubSysServiceAPIDTO(iPSSubSysServiceAPIDE);
            }
        } else if (StringHelper.compare((String)strMethodType, (String)"DEDATASET", (boolean)false) == 0 && StringHelper.compare((String)iPSSubSysServiceAPIMethodInput.getType(), (String)"DTO", (boolean)false) == 0) {
            IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = iPSSubSysServiceAPIMethodInput.getPSSubSysServiceAPIDE();
            if (iPSSubSysServiceAPIDE == null) {
                throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5bf9\u8c61", new Object[0]));
            }
            return this.getPSSubSysServiceAPIDTO(iPSSubSysServiceAPIDE);
        }
        return null;
    }

    @Override
    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIReturnDTO(IPSSubSysServiceAPIMethodReturn iPSSubSysServiceAPIMethodReturn) throws Exception {
        IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIMethod = iPSSubSysServiceAPIMethodReturn.getPSSubSysServiceAPIMethod();
        String strMethodType = iPSSubSysServiceAPIMethod.getMethodType();
        if (StringHelper.compare((String)strMethodType, (String)"DEACTION", (boolean)false) == 0) {
            if (StringHelper.compare((String)iPSSubSysServiceAPIMethodReturn.getType(), (String)"DTO", (boolean)false) == 0 || StringHelper.compare((String)iPSSubSysServiceAPIMethodReturn.getType(), (String)"DTOS", (boolean)false) == 0) {
                IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = iPSSubSysServiceAPIMethodReturn.getPSSubSysServiceAPIDE();
                if (iPSSubSysServiceAPIDE == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5bf9\u8c61", new Object[0]));
                }
                return this.getPSSubSysServiceAPIDTO(iPSSubSysServiceAPIDE);
            }
        } else if (StringHelper.compare((String)strMethodType, (String)"DEDATASET", (boolean)false) == 0 && (StringHelper.compare((String)iPSSubSysServiceAPIMethodReturn.getType(), (String)"DTO", (boolean)false) == 0 || StringHelper.compare((String)iPSSubSysServiceAPIMethodReturn.getType(), (String)"DTOS", (boolean)false) == 0 || StringHelper.compare((String)iPSSubSysServiceAPIMethodReturn.getType(), (String)"PAGE", (boolean)false) == 0)) {
            IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = iPSSubSysServiceAPIMethodReturn.getPSSubSysServiceAPIDE();
            if (iPSSubSysServiceAPIDE == null) {
                throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5bf9\u8c61", new Object[0]));
            }
            return this.getPSSubSysServiceAPIDTO(iPSSubSysServiceAPIDE);
        }
        return null;
    }

    @Override
    public String getDTOCodeName(IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
        return iPSDEMethodDTO.getCodeName();
    }

    @Override
    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIDTO(IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
        String strCodeName = this.getDTOCodeName(iPSDEMethodDTO);
        IPSSubSysServiceAPIDTO iPSSubSysServiceAPIDTO = this.psSubSysServiceAPIDTOMap.get(strCodeName);
        if (iPSSubSysServiceAPIDTO == null) {
            PSSubSysServiceAPIDTOImpl psSubSysServiceAPIDTOImpl = new PSSubSysServiceAPIDTOImpl();
            psSubSysServiceAPIDTOImpl.init(this.getDAGlobalHelper(), (IPSSubSysServiceAPI)this, iPSDEMethodDTO);
            this.psSubSysServiceAPIDTOMap.put(strCodeName, psSubSysServiceAPIDTOImpl);
            iPSSubSysServiceAPIDTO = psSubSysServiceAPIDTOImpl;
        } else if (iPSSubSysServiceAPIDTO.getPSDEMethodDTO() == null || StringHelper.compare((String)iPSDEMethodDTO.getId(), (String)iPSSubSysServiceAPIDTO.getPSDEMethodDTO().getId(), (boolean)false) != 0) {
            throw new Exception(String.format("\u4ee3\u7801\u6807\u8bc6[%1$s]\u5df2\u7ecf\u88ab\u5176\u5b83DTO\u5bf9\u8c61\u4f7f\u7528", strCodeName));
        }
        return iPSSubSysServiceAPIDTO;
    }

    @Override
    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIDTO(IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE) throws Exception {
        String strCodeName = this.getDTOCodeName(iPSSubSysServiceAPIDE);
        IPSSubSysServiceAPIDTO iPSSubSysServiceAPIDTO = this.psSubSysServiceAPIDTOMap.get(strCodeName);
        if (iPSSubSysServiceAPIDTO == null) {
            PSSubSysServiceAPIDTOImpl psSubSysServiceAPIDTOImpl = new PSSubSysServiceAPIDTOImpl();
            psSubSysServiceAPIDTOImpl.init(this.getDAGlobalHelper(), (IPSSubSysServiceAPI)this, iPSSubSysServiceAPIDE);
            this.psSubSysServiceAPIDTOMap.put(strCodeName, psSubSysServiceAPIDTOImpl);
            iPSSubSysServiceAPIDTO = psSubSysServiceAPIDTOImpl;
        } else if (iPSSubSysServiceAPIDTO.getPSSubSysServiceAPIDE() == null || StringHelper.compare((String)iPSSubSysServiceAPIDE.getId(), (String)iPSSubSysServiceAPIDTO.getPSSubSysServiceAPIDE().getId(), (boolean)false) != 0) {
            throw new Exception(String.format("\u4ee3\u7801\u6807\u8bc6[%1$s]\u5df2\u7ecf\u88ab\u5176\u5b83DTO\u5bf9\u8c61\u4f7f\u7528", strCodeName));
        }
        return iPSSubSysServiceAPIDTO;
    }

    public String getDTOCodeNameFormat() {
        return "%1$sDTO";
    }

    @Override
    public String getDTOCodeName(IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE) throws Exception {
        if (iPSSubSysServiceAPIDE.getAPIMode() == 9) {
            return iPSSubSysServiceAPIDE.getCodeName();
        }
        String strDTOCodeNameFormat = this.getDTOCodeNameFormat();
        String strCodeName = null;
        strCodeName = StringHelper.isNullOrEmpty((String)strDTOCodeNameFormat) ? iPSSubSysServiceAPIDE.getCodeName() : String.format(strDTOCodeNameFormat, iPSSubSysServiceAPIDE.getCodeName());
        return strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u670d\u52a1\u63a5\u53e3DTO", ignoredumpvalues="false", fields={"SERVICEDTOFLAG"})
    public boolean isEnableServiceAPIDTO() {
        if (this.getPSOpenAPI3Schema() != null) {
            return false;
        }
        return this.bEnableServiceAPIDTO;
    }

    protected void setEnableServiceAPIDTO(boolean bEnableServiceAPIDTO) {
        this.bEnableServiceAPIDTO = bEnableServiceAPIDTO;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3DTO\u96c6\u5408", child=true, group="\u903b\u8f91", order=236)
    public Iterator<IPSSubSysServiceAPIDTO> getAllPSSubSysServiceAPIDTOs() {
        if (this.psSubSysServiceAPIDTOMap == null || this.psSubSysServiceAPIDTOMap.size() == 0) {
            return null;
        }
        return this.psSubSysServiceAPIDTOMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5b9e\u4f53\u6a21\u578b\u6784\u5efa", dump=false)
    public boolean isFromDEModel() {
        return this.bFromDEModel;
    }

    @Override
    @PSModelRTMeta(description="OpenAPI3 Schema", dumpref=true, dynamodelmode=8)
    public IPSOpenAPI3Schema getPSOpenAPI3Schema() {
        if (this.getPSDynaModel() != null && this.getPSDynaModel() instanceof IPSOpenAPI3Schema) {
            return (IPSOpenAPI3Schema)((Object)this.getPSDynaModel());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u8d85\u65f6\u65f6\u957f", ignoredumpvalues="-1", fields={"AUTHTIMEOUT"})
    public int getAuthTimeout() {
        return this.nAuthTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"AUTHCODE"})
    public String getAuthScriptCode() {
        return this.psSubSysServiceAPI.getAUTHCODE();
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u5934\u96c6\u5408", hideempty=true, fields={"HEADERPARAMS"})
    public Properties getHeaderParams() {
        return this.headerParams;
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u8c03\u7528\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"METHODCODE"})
    public String getMethodScriptCode() {
        return this.psSubSysServiceAPI.getMETHODCODE();
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u884c\u4e3a\u9ed8\u8ba4\u8bf7\u6c42\u65b9\u5f0f", hideempty2=true, dump=false)
    public String getDefaultCreateReqMethod() {
        return this.strDefaultCreateReqMethod;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u884c\u4e3a\u9ed8\u8ba4\u8bf7\u6c42\u65b9\u5f0f", hideempty2=true, dump=false)
    public String getDefaultUpdateReqMethod() {
        return this.strDefaultUpdateReqMethod;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u884c\u4e3a\u9ed8\u8ba4\u8bf7\u6c42\u65b9\u5f0f", hideempty2=true, dump=false)
    public String getDefaultGetReqMethod() {
        return this.strDefaultGetReqMethod;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u884c\u4e3a\u9ed8\u8ba4\u8bf7\u6c42\u65b9\u5f0f", hideempty2=true, dump=false)
    public String getDefaultDeleteReqMethod() {
        return this.strDefaultDeleteReqMethod;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u8349\u7a3f\u884c\u4e3a\u9ed8\u8ba4\u8bf7\u6c42\u65b9\u5f0f", hideempty2=true, dump=false)
    public String getDefaultGetDraftReqMethod() {
        return this.strDefaultGetDraftReqMethod;
    }

    @Override
    public String getCreateReqMethod(String strDefault) {
        if (StringHelper.isNullOrEmpty((String)this.getDefaultCreateReqMethod())) {
            return strDefault;
        }
        return this.getDefaultCreateReqMethod();
    }

    @Override
    public String getUpdateReqMethod(String strDefault) {
        if (StringHelper.isNullOrEmpty((String)this.getDefaultUpdateReqMethod())) {
            return strDefault;
        }
        return this.getDefaultUpdateReqMethod();
    }

    @Override
    public String getGetReqMethod(String strDefault) {
        if (StringHelper.isNullOrEmpty((String)this.getDefaultGetReqMethod())) {
            return strDefault;
        }
        return this.getDefaultGetReqMethod();
    }

    @Override
    public String getDeleteReqMethod(String strDefault) {
        if (StringHelper.isNullOrEmpty((String)this.getDefaultDeleteReqMethod())) {
            return strDefault;
        }
        return this.getDefaultDeleteReqMethod();
    }

    @Override
    public String getGetDraftReqMethod(String strDefault) {
        if (StringHelper.isNullOrEmpty((String)this.getDefaultGetDraftReqMethod())) {
            return strDefault;
        }
        return this.getDefaultGetDraftReqMethod();
    }

    public Properties getServiceParams() {
        return this.serviceParams;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9ed8\u8ba4\u884c\u4e3a\u65b9\u6cd5\u4ee3\u7801\u540d\u79f0", dump=false)
    public boolean isResetDefaultActionCodeName() {
        return this.bResetDefaultActionCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u4ee3\u7801\u6807\u8bc6\u6a21\u5f0f", codelist="CodeNameMode", fields={"CODENAMEMODE"})
    public String getAPICodeNameMode() {
        return this.psSubSysServiceAPI.getCODENAMEMODE();
    }

    @Override
    public String getAPICodeName(String strPrefix, String strCodeName, String strSuffix) {
        return PSModelCodeNameUtils.to(this.getAPICodeNameMode(), strPrefix, strCodeName, strSuffix);
    }

    @Override
    public boolean isEnableAPIModelEx() {
        return this.bEnableAPIModelEx;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8d44\u6e90\u5bf9\u8c61", dumpref=true, fields={"PSSYSRESOURCEID"})
    public IPSSysResource getPSSysResource() {
        return this.iPSSysResource;
    }

    @Override
    public int getOrderValue() {
        if (!this.psSubSysServiceAPI.isORDERVALUENull() && this.psSubSysServiceAPI.getORDERVALUE() >= 0) {
            return this.psSubSysServiceAPI.getORDERVALUE();
        }
        return 99999;
    }

    @Override
    public void loadAll() throws Exception {
        this.check();
    }
}

