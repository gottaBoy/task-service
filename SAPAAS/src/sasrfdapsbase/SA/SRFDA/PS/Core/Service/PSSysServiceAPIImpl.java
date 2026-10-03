/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModelStorage
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI
 *  net.ibizsys.pscore.srv.sysdesign.service.PSModelStorageService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService
 *  net.ibizsys.pscore.srv.util.Inflector
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRuntime;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIImpl;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIRSImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelExporter;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPIHandler;
import SA.SRFDA.PS.Core.Service.PSSysServiceAPIException;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Data.PSDESARS;
import SA.SRFDA.PS.Data.PSDEServiceAPI;
import SA.SRFDA.PS.Data.PSSysServiceAPI;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelStorage;
import net.ibizsys.pscore.srv.sysdesign.service.PSModelStorageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.util.Inflector;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysServiceAPIImpl
extends PSSystemObjectImpl
implements IPSSysServiceAPI,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSSysServiceAPIImpl.class);
    protected PSSysServiceAPI psSysServiceAPI = null;
    private String strCodeName = null;
    private ArrayList<IPSDEServiceAPI> psDEServiceAPIList = new ArrayList();
    private Map<String, IPSDEServiceAPI> psDEServiceAPIMap = new LinkedHashMap<String, IPSDEServiceAPI>();
    private ArrayList<IPSDEServiceAPI> majorPSDEServiceAPIList = new ArrayList();
    private ArrayList<IPSDEServiceAPIRS> psDEServiceAPIRSList = new ArrayList();
    private String strAPIType = "RESTFUL";
    private int nAPIMode = 0;
    private int nAPIVersion = 1;
    private String strServiceCodeName = null;
    private String strAuthMode = "NONE";
    private String strAuthClientId = null;
    private String strAuthCheckTokenUrl = null;
    private String strAuthClientSecret = null;
    private IPSSystemModule iPSSystemModule = null;
    private String strHandler = null;
    private IPSSysServiceAPIHandler iPSSysServiceAPIHandler = null;
    private String strPredefinedType = "";
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private String strServiceType = "DEFAULT";
    private int nHttpPort = 0;
    private int nAPILevel = 3;
    private boolean bResetDefaultActionCodeName = false;
    private IPSDEOPPriv defaultPSDEOPPriv = null;
    private boolean bEnableServiceAPIDTO = false;
    private ArrayList<IPSSysTestPrj> psSysTestPrjList = null;
    private String strDefaultCreateReqMethod = null;
    private String strDefaultUpdateReqMethod = null;
    private String strDefaultGetReqMethod = null;
    private String strDefaultDeleteReqMethod = null;
    private String strDefaultGetDraftReqMethod = null;
    private Properties serviceParams = null;
    private boolean bEnableGateway = false;
    private boolean bEnableAPIModelEx = false;
    private List<String> ignoreAuthPatternList = null;
    private IPSSysTranslator outPSSysTranslator = null;
    private IPSSysResource iPSSysResource = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysServiceAPI psSysServiceAPI) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysServiceAPI = psSysServiceAPI;
            this.setId(this.psSysServiceAPI.getPSSYSSERVICEAPIID());
            this.setName(this.psSysServiceAPI.getPSSYSSERVICEAPINAME());
            this.setPSObjectData(this.psSysServiceAPI);
            this.bEnableAPIModelEx = !this.psSysServiceAPI.isENABLEAPIMODELEXNull() ? this.psSysServiceAPI.getENABLEAPIMODELEX() : this.getPSSystemSetting().isEnableServiceAPIModelEx();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysServiceAPI.getPSMODULEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getAPITYPE())) {
                this.strAPIType = this.psSysServiceAPI.getAPITYPE();
            }
            this.strCodeName = this.psSysServiceAPI.getCODENAME();
            this.strServiceCodeName = this.psSysServiceAPI.getSERVICECODENAME();
            if (!this.psSysServiceAPI.isAPIMODENull()) {
                this.nAPIMode = this.psSysServiceAPI.getAPIMODE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getSERVICETYPE())) {
                this.strServiceType = this.psSysServiceAPI.getSERVICETYPE();
            }
            if (!this.psSysServiceAPI.isVERNull()) {
                this.nAPIVersion = this.psSysServiceAPI.getVER();
                if (this.nAPIVersion <= 0) {
                    this.nAPIVersion = 1;
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getAUTHMODE())) {
                this.strAuthMode = this.psSysServiceAPI.getAUTHMODE();
            }
            this.strAuthClientId = this.psSysServiceAPI.getAUTHCLIENTID();
            this.strAuthCheckTokenUrl = this.psSysServiceAPI.getAUTHCHECKTOKENURI();
            this.strAuthClientSecret = this.psSysServiceAPI.getAUTHCLIENTSECRET();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getPSSYSSAHANDLERID())) {
                this.iPSSysServiceAPIHandler = this.getPSSystem().getPSSysServiceAPIHandler(this.psSysServiceAPI.getPSSYSSAHANDLERID());
                if (this.getAPIMode() == 2) {
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getPREDEFINEDTYPE())) {
                        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u670d\u52a1\u63a5\u53e3[%1$s]\u6307\u5b9a\u9884\u5b9a\u4e49\u7c7b\u578b", (Object)this.getName()));
                    }
                    this.strPredefinedType = this.psSysServiceAPI.getPREDEFINEDTYPE();
                }
            } else if (this.getAPIMode() == 2) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getPREDEFINEDTYPE())) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u670d\u52a1\u63a5\u53e3[%1$s]\u6307\u5b9a\u9884\u5b9a\u4e49\u7c7b\u578b", (Object)this.getName()));
                }
                this.strPredefinedType = this.psSysServiceAPI.getPREDEFINEDTYPE();
                this.iPSSysServiceAPIHandler = this.getPSSystem().getPSSysServiceAPIHandlerByPredefinedType(this.psSysServiceAPI.getPREDEFINEDTYPE(), true);
                if (this.iPSSysServiceAPIHandler == null) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u670d\u52a1\u63a5\u53e3[%1$s]\u9884\u5b9a\u4e49\u7c7b\u578b[%2$s]\u5904\u7406\u5bf9\u8c61", (Object)this.getName(), (Object)this.psSysServiceAPI.getPREDEFINEDTYPE()));
                }
            }
            if (this.iPSSysServiceAPIHandler != null) {
                this.strHandler = this.iPSSysServiceAPIHandler.getServiceHandler(this.getAPIType());
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strHandler)) {
                this.strHandler = null;
            }
            this.nHttpPort = this.psSysServiceAPI.getDEFAULTPORT();
            if (this.nHttpPort <= 0 || this.nHttpPort > 65535) {
                this.nHttpPort = 0;
            }
            this.nAPILevel = !this.psSysServiceAPI.isAPILEVELNull() ? this.psSysServiceAPI.getAPILEVEL() : (SA.SRFramework.Utility.StringHelper.Compare((String)this.getServiceType(), (String)"DEFAULT", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getServiceType(), (String)"APPLICATION", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getServiceType(), (String)"USER", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getServiceType(), (String)"USER2", (boolean)false) == 0 ? 3 : 0);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysServiceAPI.getPSSYSSFPLUGINID());
            }
            if (!this.psSysServiceAPI.isRESETDEFACTIONCODENAMENull()) {
                this.bResetDefaultActionCodeName = this.psSysServiceAPI.getRESETDEFACTIONCODENAME();
            } else if ("RESTFUL".equals(this.getAPIType()) && (this.getPSSystem().isEnableModelRT() || this.isEnableAPIModelEx())) {
                this.bResetDefaultActionCodeName = true;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getDEFAULTPSDEOPPRIVID())) {
                this.defaultPSDEOPPriv = this.getPSSystem().getPSDEOPPriv(this.psSysServiceAPI.getDEFAULTPSDEOPPRIVID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                }
            }
            if (!this.psSysServiceAPI.isSERVICEDTOFLAGNull()) {
                this.bEnableServiceAPIDTO = this.psSysServiceAPI.getSERVICEDTOFLAG();
            } else if (this.getPSSystem().isEnableModelRT()) {
                this.bEnableServiceAPIDTO = true;
            }
            this.serviceParams = PropertiesHelper.load((String)this.psSysServiceAPI.getSERVICEPARAMS());
            this.strDefaultCreateReqMethod = this.psSysServiceAPI.getDEFCREATEREQMETHOD();
            this.strDefaultUpdateReqMethod = this.psSysServiceAPI.getDEFUPDATEREQMETHOD();
            this.strDefaultGetReqMethod = this.psSysServiceAPI.getDEFGETREQMETHOD();
            this.strDefaultDeleteReqMethod = this.psSysServiceAPI.getDEFDELETEREQMETHOD();
            this.strDefaultGetDraftReqMethod = this.psSysServiceAPI.getDEFGETDRAFTREQMETHOD();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDefaultCreateReqMethod)) {
                this.strDefaultCreateReqMethod = PropertiesHelper.getProperty((Properties)this.getServiceParams(), (String)"DEFAULTREQMETHOD.CREATE");
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDefaultUpdateReqMethod)) {
                this.strDefaultUpdateReqMethod = PropertiesHelper.getProperty((Properties)this.getServiceParams(), (String)"DEFAULTREQMETHOD.UPDATE");
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDefaultGetReqMethod)) {
                this.strDefaultGetReqMethod = PropertiesHelper.getProperty((Properties)this.getServiceParams(), (String)"DEFAULTREQMETHOD.GET");
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDefaultDeleteReqMethod)) {
                this.strDefaultDeleteReqMethod = PropertiesHelper.getProperty((Properties)this.getServiceParams(), (String)"DEFAULTREQMETHOD.DELETE");
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDefaultGetDraftReqMethod)) {
                this.strDefaultGetDraftReqMethod = PropertiesHelper.getProperty((Properties)this.getServiceParams(), (String)"DEFAULTREQMETHOD.GETDRAFT");
            }
            if (!this.psSysServiceAPI.isENABLEGATEWAYNull()) {
                this.bEnableGateway = this.psSysServiceAPI.getENABLEGATEWAY();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getIGNOREAUTHPATTERNS())) {
                String[] items;
                this.ignoreAuthPatternList = new ArrayList<String>();
                String strIgnoreAuthPatterns = this.psSysServiceAPI.getIGNOREAUTHPATTERNS().replace("\r\n", ";").replace("\r", ";").replace("\n", ";");
                String[] stringArray = items = strIgnoreAuthPatterns.replace(",", ";").split("[;]");
                int n = items.length;
                int n2 = 0;
                while (n2 < n) {
                    String item = stringArray[n2];
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)item) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(item = item.trim()))) {
                        this.ignoreAuthPatternList.add(item);
                    }
                    ++n2;
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getOUTPSSYSTRANSLATORID())) {
                this.outPSSysTranslator = this.getPSSystem().getPSSysTranslator(this.psSysServiceAPI.getOUTPSSYSTRANSLATORID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysServiceAPI.getPSSYSRESOURCEID())) {
                this.iPSSysResource = this.getPSSystem().getPSSysResource(this.psSysServiceAPI.getPSSYSRESOURCEID());
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

    protected void exportCfg() throws Exception {
        final String strPSDevSlnSysAPIId = KeyValueHelper.genUniqueId((String)this.iPSSystem.getPSDevSlnSysId(), (String)this.getId());
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psSysServiceAPI.getPSDEVSLNSYSAPIID(), (String)strPSDevSlnSysAPIId, (boolean)false) != 0) {
            return;
        }
        ObjectNode objectNode = PSModelExporter.toJsonObject(this, null);
        final String strConfigModel = objectNode.toString();
        final String strDigestCode = KeyValueHelper.genUniqueId((String)strConfigModel);
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psSysServiceAPI.getCFGTAG(), (String)strDigestCode, (boolean)false) == 0) {
            return;
        }
        final PSModelStorageService psModelStorageService = (PSModelStorageService)ServiceGlobal.getService((String)PSModelStorageService.class.getName(), (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSSysServiceAPIService psSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService((String)PSSysServiceAPIService.class.getName(), (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ServiceWorkHelper.getInstance().execute(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelStorage psModelStorage = new PSModelStorage();
                psModelStorage.setPSModelId(strPSDevSlnSysAPIId);
                psModelStorage.setPSModelName(PSSysServiceAPIImpl.this.getName());
                psModelStorage.setPSModelType("PSDEVSLNSYSAPI");
                psModelStorage.setStorageType("DEFAULT");
                psModelStorage.setPSModelStorageName(SA.SRFramework.Utility.StringHelper.Format((String)"\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u914d\u7f6e\u6587\u4ef6"));
                psModelStorage.setContent(strConfigModel);
                psModelStorageService.save(psModelStorage, false);
                net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI psSysServiceAPI = new net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI();
                psSysServiceAPI.setPSSysServiceAPIId(PSSysServiceAPIImpl.this.getId());
                psSysServiceAPI.setCfgTag(strDigestCode);
                psSysServiceAPIService.sysUpdate(psSysServiceAPI, false);
            }
        });
        this.getPSModelHelper().resetCache();
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSDEServiceAPIs();
        this.onPreparePSDEServiceAPIRSs();
        super.onInit();
        Iterator<IPSDEServiceAPI> psDEServiceAPIs = this.getPSDEServiceAPIs();
        if (psDEServiceAPIs != null) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            LinkedHashMap<String, IPSDEServiceAPI> codeNameMap = new LinkedHashMap<String, IPSDEServiceAPI>();
            while (psDEServiceAPIs.hasNext()) {
                IPSDEServiceAPI iPSDEServiceAPI = psDEServiceAPIs.next();
                String strCodeName = Inflector.getInstance().pluralize((Object)iPSDEServiceAPI.getCodeName());
                IPSDEServiceAPI lastPSDEServiceAPI = (IPSDEServiceAPI)codeNameMap.get(strCodeName.toUpperCase());
                if (lastPSDEServiceAPI != null) {
                    String strLogInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u5b9e\u4f53\u63a5\u53e3[%1$s]\u590d\u6570\u4ee3\u7801\u6807\u8bc6[%2$s]\u5df2\u7ecf\u88ab\u5176\u5b83\u63a5\u53e3\u4f7f\u7528[%3$s]", (Object)iPSDEServiceAPI.getName(), (Object)strCodeName, (Object)lastPSDEServiceAPI.getName());
                    this.getPSSystemUtil().getPSSysConsole().warn(strLogName, strLogInfo);
                    continue;
                }
                codeNameMap.put(strCodeName.toUpperCase(), iPSDEServiceAPI);
            }
        }
    }

    protected void onPreparePSDEServiceAPIs() throws Exception {
        IPSDEServiceAPI iPSDEServiceAPI;
        this.psDEServiceAPIList.clear();
        this.majorPSDEServiceAPIList.clear();
        Vector<PSDEServiceAPI> psDEServiceAPIList = new Vector<PSDEServiceAPI>();
        CallResult callResult = this.getPSModelHelper().getPSDEServiceAPIsBySSA(this.getId(), psDEServiceAPIList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u6240\u6709\u5b9e\u4f53\u63a5\u53e3\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEServiceAPI psDEServiceAPI : psDEServiceAPIList) {
            if (!psDEServiceAPI.isVALIDFLAGNull() && !psDEServiceAPI.getVALIDFLAG() || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEServiceAPI.getPSDEID())) continue;
            IPSDataEntity iPSDataEntity = this.getPSSystem().getPSDataEntity2(psDEServiceAPI.getPSDEID());
            iPSDEServiceAPI = iPSDataEntity.getPSDEServiceAPI(psDEServiceAPI.getPSDESERVICEAPIID());
            this.psDEServiceAPIList.add(iPSDEServiceAPI);
            this.psDEServiceAPIMap.put(iPSDEServiceAPI.getId(), iPSDEServiceAPI);
            if (this.psDEServiceAPIMap.containsKey(iPSDataEntity.getId()) && !iPSDEServiceAPI.isMajor()) continue;
            this.psDEServiceAPIMap.put(iPSDataEntity.getId(), iPSDEServiceAPI);
            this.psDEServiceAPIMap.put(iPSDataEntity.getName(), iPSDEServiceAPI);
        }
        if (this.getAPIMode() == 1) {
            Iterator<IPSDataEntity> psDataEntities = this.getPSSystem().getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                IPSDataEntity iPSDataEntity = psDataEntities.next();
                if (iPSDataEntity.isSubSysDE() || iPSDataEntity.getStorageMode() == 4 || this.psDEServiceAPIMap.containsKey(iPSDataEntity.getId()) || iPSDataEntity.getServiceAPIMode() != 1) continue;
                PSDEServiceAPI psDEServiceAPI = new PSDEServiceAPI();
                psDEServiceAPI.setPSDEID(iPSDataEntity.getId());
                psDEServiceAPI.setPSDENAME(iPSDataEntity.getName());
                psDEServiceAPI.setPSDESERVICEAPIID(iPSDataEntity.getId());
                psDEServiceAPI.setPSDESERVICEAPINAME(iPSDataEntity.getName());
                psDEServiceAPI.setPSSYSSERVICEAPIID(this.getId());
                psDEServiceAPI.setENABLEDEACTION(iPSDataEntity.isEnableSADEAction());
                psDEServiceAPI.setENABLEDEDATASET(iPSDataEntity.isEnableSADEDataSet());
                psDEServiceAPI.setENABLESELECT(iPSDataEntity.isEnableSASelect());
                psDEServiceAPI.set("AUTOMODEL", 1);
                iPSDEServiceAPI = new PSDEServiceAPIImpl();
                iPSDEServiceAPI.init(this.getDAGlobalHelper(), this, iPSDataEntity, psDEServiceAPI);
                this.psDEServiceAPIList.add(iPSDEServiceAPI);
                this.psDEServiceAPIMap.put(iPSDEServiceAPI.getId(), iPSDEServiceAPI);
                this.psDEServiceAPIMap.put(iPSDataEntity.getId(), iPSDEServiceAPI);
                this.psDEServiceAPIMap.put(iPSDataEntity.getName(), iPSDEServiceAPI);
            }
        }
        PSModelUtil.sort(this.psDEServiceAPIList);
        for (IPSDEServiceAPI iPSDEServiceAPI2 : this.psDEServiceAPIList) {
            if (!iPSDEServiceAPI2.isMajor()) continue;
            this.majorPSDEServiceAPIList.add(iPSDEServiceAPI2);
        }
        this.getPSSystemUtil().testPSModelLimit(this, "PSDESERVICEAPI", this.psDEServiceAPIList.size());
    }

    protected void onPreparePSDEServiceAPIRSs() throws Exception {
        this.psDEServiceAPIRSList.clear();
        Vector<PSDESARS> psDEServiceAPIRSList = new Vector<PSDESARS>();
        CallResult callResult = this.getPSModelHelper().getPSDEServiceAPIRSs(this.getId(), psDEServiceAPIRSList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u670d\u52a1API\u6240\u6709\u5b9e\u4f53API\u5173\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        LinkedHashMap<String, PSDESARS> psDESARSMap = new LinkedHashMap<String, PSDESARS>();
        for (PSDESARS psDESARS : psDEServiceAPIRSList) {
            String strDESARSId = String.format("%1$s__%2$s", psDESARS.getPPSDESERVICEAPIID(), psDESARS.getCPSDESERVICEAPIID());
            psDESARSMap.put(strDESARSId, psDESARS);
        }
        Iterator<IPSDEServiceAPI> psDEServiceAPIs = this.getPSDEServiceAPIs();
        if (psDEServiceAPIs != null) {
            while (psDEServiceAPIs.hasNext()) {
                IPSDEServiceAPIRuntime iPSDEServiceAPIRuntime;
                List<PSDESARS> list;
                IPSDEServiceAPI iPSDEServiceAPI = psDEServiceAPIs.next();
                if (!(iPSDEServiceAPI instanceof IPSDEServiceAPIRuntime) || (list = (iPSDEServiceAPIRuntime = (IPSDEServiceAPIRuntime)((Object)iPSDEServiceAPI)).getAutoPSDESARSs()) == null) continue;
                for (PSDESARS psDESARS : list) {
                    String strDESARSId = String.format("%1$s__%2$s", psDESARS.getPPSDESERVICEAPIID(), psDESARS.getCPSDESERVICEAPIID());
                    if (psDESARSMap.containsKey(strDESARSId)) continue;
                    psDESARSMap.put(strDESARSId, psDESARS);
                    psDEServiceAPIRSList.add(psDESARS);
                }
            }
        }
        for (PSDESARS psDESARS : psDEServiceAPIRSList) {
            if (!psDESARS.isVALIDFLAGNull() && !psDESARS.getVALIDFLAG()) continue;
            PSDEServiceAPIRSImpl psDEServiceAPIRSImpl = new PSDEServiceAPIRSImpl();
            psDEServiceAPIRSImpl.init(this.getDAGlobalHelper(), this, psDESARS);
            this.psDEServiceAPIRSList.add(psDEServiceAPIRSImpl);
        }
        PSModelUtil.sort(this.psDEServiceAPIRSList);
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSSYSSERVICEAPI";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8d44\u6e90\u96c6\u5408", child=true, group="\u57fa\u672c", order=240)
    public Iterator<IPSDEServiceAPI> getPSDEServiceAPIs() {
        if (this.psDEServiceAPIList.size() == 0) {
            return null;
        }
        return this.psDEServiceAPIList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8d44\u6e90\u5173\u7cfb\u96c6\u5408", child=true, group="\u57fa\u672c", order=242)
    public Iterator<IPSDEServiceAPIRS> getPSDEServiceAPIRSs() {
        if (this.psDEServiceAPIRSList.size() == 0) {
            return null;
        }
        return this.psDEServiceAPIRSList.iterator();
    }

    @Override
    public IPSDEServiceAPI getPSDEServiceAPI(String strPSDEServiceAPIId, boolean bTryMode) throws Exception {
        IPSDEServiceAPI iPSDEServiceAPI = this.psDEServiceAPIMap.get(strPSDEServiceAPIId);
        if (iPSDEServiceAPI == null) {
            if (bTryMode) {
                return null;
            }
            throw PSSysServiceAPIException.create(this, 12000, strPSDEServiceAPIId);
        }
        return iPSDEServiceAPI;
    }

    @Override
    public IPSDEServiceAPI getPSDEServiceAPI(String strPSDEServiceAPIId) throws Exception {
        return this.getPSDEServiceAPI(strPSDEServiceAPIId, false);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u7c7b\u578b", codelist="ServiceAPIType", fields={"APITYPE"})
    public String getAPIType() {
        return this.strAPIType;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u6a21\u5f0f", codelist="ServiceAPIMode", fields={"APIMODE"})
    public int getAPIMode() {
        return this.nAPIMode;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u7248\u672c", fields={"VER"})
    public int getAPIVersion() {
        return this.nAPIVersion;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u4ee3\u7801\u540d\u79f0", fields={"SERVICECODENAME"})
    public String getServiceCodeName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strServiceCodeName)) {
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
    @PSModelRTMeta(description="\u8ba4\u8bc1token\u8def\u5f84", fields={"AUTHCHECKTOKENURI"})
    public String getAuthCheckTokenUrl() {
        return this.strAuthCheckTokenUrl;
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
    public String getPSDevSlnSysAPIId() {
        return this.psSysServiceAPI.getPSDEVSLNSYSAPIID();
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
    @PSModelRTMeta(description="\u5904\u7406\u5bf9\u8c61")
    public String getHandler() {
        return this.strHandler;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEServiceAPI> getMajorPSDEServiceAPIs() {
        if (this.majorPSDEServiceAPIList.size() == 0) {
            return null;
        }
        return this.majorPSDEServiceAPIList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u6570", hideempty2=true, fields={"SERVICEPARAM"})
    public String getServiceParam() {
        return this.psSysServiceAPI.getSERVICEPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u65702", hideempty2=true, fields={"SERVICEPARAM2"})
    public String getServiceParam2() {
        return this.psSysServiceAPI.getSERVICEPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u65703", hideempty2=true, fields={"SERVICEPARAM3"})
    public String getServiceParam3() {
        return this.psSysServiceAPI.getSERVICEPARAM3();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u65704", hideempty2=true, fields={"SERVICEPARAM4"})
    public String getServiceParam4() {
        return this.psSysServiceAPI.getSERVICEPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u6570", fields={"AUTHPARAM"})
    public String getAuthParam() {
        return this.psSysServiceAPI.getAUTHPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65702", fields={"AUTHPARAM2"})
    public String getAuthParam2() {
        return this.psSysServiceAPI.getAUTHPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65703", hideempty2=true, fields={"AUTHPARAM3"})
    public String getAuthParam3() {
        return this.psSysServiceAPI.getAUTHPARAM3();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65704", hideempty2=true, fields={"AUTHPARAM4"})
    public String getAuthParam4() {
        return this.psSysServiceAPI.getAUTHPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u9ed8\u8ba4\u8bf7\u6c42\u65b9\u5f0f", hideempty2=true, dump=false)
    public String getDefaultDEActionReqMethod() {
        return this.psSysServiceAPI.getDEFDEACTIONREQMETHOD();
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
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getDefaultCreateReqMethod())) {
            return strDefault;
        }
        return this.getDefaultCreateReqMethod();
    }

    @Override
    public String getUpdateReqMethod(String strDefault) {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getDefaultUpdateReqMethod())) {
            return strDefault;
        }
        return this.getDefaultUpdateReqMethod();
    }

    @Override
    public String getGetReqMethod(String strDefault) {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getDefaultGetReqMethod())) {
            return strDefault;
        }
        return this.getDefaultGetReqMethod();
    }

    @Override
    public String getDeleteReqMethod(String strDefault) {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getDefaultDeleteReqMethod())) {
            return strDefault;
        }
        return this.getDefaultDeleteReqMethod();
    }

    @Override
    public String getGetDraftReqMethod(String strDefault) {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getDefaultGetDraftReqMethod())) {
            return strDefault;
        }
        return this.getDefaultGetDraftReqMethod();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u67e5\u8be2\u9ed8\u8ba4\u8bf7\u6c42\u65b9\u5f0f", hideempty2=true, dump=false)
    public String getDefaultSelectReqMethod() {
        return this.psSysServiceAPI.getDEFSELECTREQMETHOD();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5408\u9ed8\u8ba4\u8bf7\u6c42\u65b9\u5f0f", hideempty2=true, dump=false)
    public String getDefaultDEDataSetReqMethod() {
        return this.psSysServiceAPI.getDEFDEDATASETREQMETHOD();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u63a5\u53e3\u7c7b\u578b", hideempty2=true, codelist="PredefinedServiceAPI", fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return this.strPredefinedType;
    }

    @Override
    protected int onCheck() throws Exception {
        Iterator<IPSDEServiceAPIRS> psDEServiceAPIRSs;
        int nRet = 0;
        Iterator<IPSDEServiceAPI> psDEServiceAPIs = this.getPSDEServiceAPIs();
        if (psDEServiceAPIs != null) {
            while (psDEServiceAPIs.hasNext()) {
                IPSDEServiceAPI iPSDEServiceAPI = psDEServiceAPIs.next();
                nRet += iPSDEServiceAPI.check();
            }
        }
        if ((psDEServiceAPIRSs = this.getPSDEServiceAPIRSs()) != null) {
            while (psDEServiceAPIRSs.hasNext()) {
                IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                nRet += iPSDEServiceAPIRS.check();
            }
        }
        return nRet + super.onCheck();
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
        return this.psSysServiceAPI.getDEPSSYSSFPLUGINID();
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u6807\u8bb0", hideempty2=true, fields={"APITAG"})
    public String getAPITag() {
        return this.psSysServiceAPI.getAPITAG();
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u6807\u8bb02", hideempty2=true, fields={"APITAG2"})
    public String getAPITag2() {
        return this.psSysServiceAPI.getAPITAG2();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u7c7b\u578b", codelist="ServiceType", group="\u57fa\u672c", order=125, fields={"SERVICETYPE"})
    public String getServiceType() {
        return this.strServiceType;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7aef\u53e3")
    public int getHttpPort() {
        return this.nHttpPort;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u7ea7\u522b", codelist="APILevel", ignoredumpvalues="3", fields={"APILEVEL"})
    public int getAPILevel() {
        return this.nAPILevel;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u7ea7\u522b\u63a5\u53e3", ignoredumpvalues="false", doc="\u7b49\u540c{@link getAPILevel}\u8fd4\u56de\u7528\u6237\u7ea7(3)")
    public boolean isUserLevel() {
        return this.getAPILevel() == 3;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7ea7\u522b\u63a5\u53e3", ignoredumpvalues="false", doc="\u7b49\u540c{@link getAPILevel}\u8fd4\u56de\u6838\u5fc3\u7ea7(0)")
    public boolean isCoreLevel() {
        return this.getAPILevel() == 0;
    }

    @Override
    @PSModelRTMeta(description="\u5e73\u53f0\u7ba1\u7406\u5458\u7ea7\u522b\u63a5\u53e3", ignoredumpvalues="false", doc="\u7b49\u540c{@link getAPILevel}\u8fd4\u56de\u5e73\u53f0\u7ba1\u7406\u5458(1)")
    public boolean isCloudAdminLevel() {
        return this.getAPILevel() == 1;
    }

    @Override
    @PSModelRTMeta(description="\u673a\u6784\u7ba1\u7406\u5458\u7ea7\u522b\u63a5\u53e3", ignoredumpvalues="false", doc="\u7b49\u540c{@link getAPILevel}\u8fd4\u56de\u673a\u6784\u7ba1\u7406\u5458(2)")
    public boolean isDCAdminLevel() {
        return this.getAPILevel() == 2;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9ed8\u8ba4\u884c\u4e3a\u65b9\u6cd5\u4ee3\u7801\u540d\u79f0", dump=false)
    public boolean isResetDefaultActionCodeName() {
        return this.bResetDefaultActionCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u65b9\u6cd5\u64cd\u4f5c\u6807\u8bc6", dump=false)
    public IPSDEOPPriv getDefaultPSDEOPPriv() {
        return this.defaultPSDEOPPriv;
    }

    public String getDTOCodeNameFormat() {
        return "%1$sDTO";
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u670d\u52a1\u63a5\u53e3DTO", ignoredumpvalues="false", fields={"SERVICEDTOFLAG"})
    public boolean isEnableServiceAPIDTO() {
        return this.bEnableServiceAPIDTO;
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u9879\u76ee\u96c6\u5408", child=true, dumpref=true, ignorert=1, ignorepf=true, dynamodelmode=8)
    public Iterator<IPSSysTestPrj> getPSSysTestPrjs() throws Exception {
        if (this.psSysTestPrjList == null) {
            ArrayList<IPSSysTestPrj> psSysTestPrjList = new ArrayList<IPSSysTestPrj>();
            Iterator<IPSSysTestPrj> psSysTestPrjs = this.getPSSystem().getAllPSSysTestPrjs();
            if (psSysTestPrjs != null) {
                while (psSysTestPrjs.hasNext()) {
                    IPSSysTestPrj iPSSysTestPrj = psSysTestPrjs.next();
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSSysTestPrj.getPrjType(), (String)"SYSSERVICEAPI", (boolean)false) != 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getId(), (String)iPSSysTestPrj.getPSSysServiceAPI().getId(), (boolean)false) != 0) continue;
                    psSysTestPrjList.add(iPSSysTestPrj);
                }
            }
            if (this.psSysTestPrjList == null) {
                this.psSysTestPrjList = psSysTestPrjList;
            }
        }
        return this.psSysTestPrjList.iterator();
    }

    public Properties getServiceParams() {
        return this.serviceParams;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u4ee3\u7801\u6807\u8bc6\u6a21\u5f0f", codelist="CodeNameMode", fields={"CODENAMEMODE"})
    public String getAPICodeNameMode() {
        return this.psSysServiceAPI.getCODENAMEMODE();
    }

    @Override
    @PSModelRTMeta(description="\u547d\u540d\u670d\u52a1", fields={"NAMINGSERVICE"})
    public String getNamingService() {
        return this.psSysServiceAPI.getNAMINGSERVICE();
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
    @PSModelRTMeta(description="\u652f\u6301\u7f51\u5173", ignoredumpvalues="false", fields={"ENABLEGATEWAY"})
    public boolean isEnableGateway() {
        return this.bEnableGateway;
    }

    @Override
    public void loadAll() throws Exception {
        this.check();
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u8ba4\u8bc1\u6a21\u5f0f\u96c6\u5408", child=true, fields={"IGNOREAUTHPATTERNS"})
    public Iterator<String> getIgnoreAuthPatterns() {
        if (this.ignoreAuthPatternList == null || this.ignoreAuthPatternList.size() == 0) {
            return null;
        }
        return this.ignoreAuthPatternList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u503c\u8f6c\u6362\u5668", dumpref=true, ignorepf=true, fields={"OUTPSSYSTRANSLATORID"})
    public IPSSysTranslator getOutPSSysTranslator() {
        return this.outPSSysTranslator;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8d44\u6e90\u5bf9\u8c61", dumpref=true, ignorepf=true, fields={"PSSYSRESOURCEID"})
    public IPSSysResource getPSSysResource() {
        return this.iPSSysResource;
    }

    @Override
    public int getOrderValue() {
        if (!this.psSysServiceAPI.isORDERVALUENull() && this.psSysServiceAPI.getORDERVALUE() >= 0) {
            return this.psSysServiceAPI.getORDERVALUE();
        }
        return 99999;
    }
}
