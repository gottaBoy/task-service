/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRuntime;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIVR;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIException;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIFieldImpl;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIMethodImpl;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIVRImpl;
import SA.SRFDA.PS.Core.DataEntity.Util.IPSDEUtil;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Service.IPSDEActionRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Data.PSDESADetail;
import SA.SRFDA.PS.Data.PSDESARS;
import SA.SRFDA.PS.Data.PSDESAVR;
import SA.SRFDA.PS.Data.PSDEServiceAPI;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEServiceAPIImpl
extends PSDataEntityObjectImpl
implements IPSDEServiceAPI,
IPSDEServiceAPIRuntime,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIImpl.class);
    private PSDEServiceAPI psDEServiceAPI;
    private ArrayList<IPSDEServiceAPIMethod> psDEServiceAPIMethodList = new ArrayList();
    private Map<String, IPSDEServiceAPIMethod> psDEServiceAPIMethodMap = new LinkedHashMap<String, IPSDEServiceAPIMethod>();
    private ArrayList<IPSDEServiceAPIField> psDEServiceAPIFieldList = new ArrayList();
    private Map<String, IPSDEServiceAPIField> psDEServiceAPIFieldMap = new LinkedHashMap<String, IPSDEServiceAPIField>();
    private ArrayList<IPSDEServiceAPIVR> psDEServiceAPIVRList = new ArrayList();
    protected String strCodeName = "";
    private String strCodeName2 = "";
    private IPSSysServiceAPI iPSSysServiceAPI = null;
    private boolean bEnableDEAction = false;
    private boolean bEnableSelect = false;
    private boolean bEnableDEDataSet = false;
    private boolean bEnableTempData = false;
    private IPSDEFGroup iPSDEFGroup = null;
    private String strDEFGroupMode = "";
    private int nAPIMode = 1;
    private ArrayList<IPSDEServiceAPIRS> majorPSDEServiceAPIRSList = null;
    private ArrayList<IPSDEServiceAPIRS> minorPSDEServiceAPIRSList = null;
    private Map<Integer, ArrayList<IPSDEServiceAPIRS>> psDEServiceAPIRSPathMap = null;
    private int nDataAccCtrlArch = 0;
    private int nDataAccCtrlMode = 0;
    private IPSDEServiceAPIField keyPSDEServiceAPIField = null;
    private IPSDEServiceAPIField majorPSDEServiceAPIField = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private String strLogicName = "";
    private IPSLanguageRes lnPSLanguageRes = null;
    private boolean bEnableDataImport = true;
    private boolean bEnableDataExport = true;
    private String strServiceParam = null;
    private String strServiceParam2 = null;
    private IPSSysTranslator outPSSysTranslator = null;
    private IPSSysUniRes iPSSysUniRes = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysServiceAPI iPSSysServiceAPI, IPSDataEntity iPSDataEntity, PSDEServiceAPI psDEServiceAPI) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysServiceAPI = iPSSysServiceAPI;
            this.psDEServiceAPI = psDEServiceAPI;
            this.setId(psDEServiceAPI.getPSDESERVICEAPIID());
            this.setName(psDEServiceAPI.getPSDESERVICEAPINAME());
            this.setPSObjectData(this.psDEServiceAPI);
            this.nDataAccCtrlMode = !this.psDEServiceAPI.isDATAACCMODENull() ? this.psDEServiceAPI.getDATAACCMODE() : this.getPSDataEntity().getDataAccCtrlMode();
            this.nDataAccCtrlArch = !this.psDEServiceAPI.isACCCTRLARCHNull() ? this.psDEServiceAPI.getACCCTRLARCH() : this.getPSDataEntity().getDataAccCtrlArch();
            this.strLogicName = psDEServiceAPI.getLOGICNAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLogicName)) {
                this.strLogicName = iPSDataEntity.getLogicName();
            }
            this.lnPSLanguageRes = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEServiceAPI.getLNPSLANRESID()) ? this.getPSSystem().getPSLanguageRes(psDEServiceAPI.getLNPSLANRESID()) : iPSDataEntity.getLNPSLanguageRes();
            this.strCodeName = psDEServiceAPI.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getPSSysServiceAPI().getAPICodeName(null, iPSDataEntity.getServiceCodeName(), null);
            }
            this.strCodeName2 = psDEServiceAPI.getCODENAME2();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName2)) {
                this.strCodeName2 = Inflector.getInstance().pluralize((Object)this.strCodeName);
                this.strCodeName2 = this.getPSSysServiceAPI().getAPICodeName(null, this.strCodeName2, null);
            }
            this.bEnableDEAction = !this.psDEServiceAPI.isENABLEDEACTIONNull() ? this.psDEServiceAPI.getENABLEDEACTION() : iPSDataEntity.isEnableSADEAction();
            this.bEnableSelect = !this.psDEServiceAPI.isENABLESELECTNull() ? this.psDEServiceAPI.getENABLESELECT() : iPSDataEntity.isEnableSASelect();
            this.bEnableDEDataSet = !this.psDEServiceAPI.isENABLEDEDATASETNull() ? this.psDEServiceAPI.getENABLEDEDATASET() : iPSDataEntity.isEnableSADEDataSet();
            if (!this.psDEServiceAPI.isENABLEDATAIMPORTNull()) {
                this.bEnableDataImport = this.psDEServiceAPI.getENABLEDATAIMPORT();
            }
            if (!this.psDEServiceAPI.isENABLEDATAEXPORTNull()) {
                this.bEnableDataExport = this.psDEServiceAPI.getENABLEDATAEXPORT();
            }
            this.bEnableTempData = this.getPSDataEntity().isEnableTempDataBackend();
            if (this.bEnableTempData && !this.psDEServiceAPI.isENATEMPDATANull()) {
                this.bEnableTempData = this.psDEServiceAPI.getENATEMPDATA();
            }
            if (!this.psDEServiceAPI.isMAJORFLAGNull()) {
                this.nAPIMode = this.psDEServiceAPI.getMAJORFLAG();
            } else if (this.getPSSysServiceAPI().isEnableAPIModelEx() && this.getPSDataEntity().getDataAccCtrlMode() == 2) {
                this.nAPIMode = 0;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEServiceAPI.getPSDEFGROUPID())) {
                this.iPSDEFGroup = this.getPSDataEntity().getPSDEFGroup(this.psDEServiceAPI.getPSDEFGROUPID());
                this.strDEFGroupMode = this.psDEServiceAPI.getDEFGROUPMODE();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDEFGroupMode)) {
                    this.strDEFGroupMode = "REPLACE";
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEServiceAPI.getOUTPSSYSTRANSLATORID())) {
                this.outPSSysTranslator = this.getPSSystem().getPSSysTranslator(this.psDEServiceAPI.getOUTPSSYSTRANSLATORID());
            }
            this.iPSSysUniRes = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEServiceAPI.getPSSYSUNIRESID()) ? this.getPSSystem().getPSSysUniRes(this.psDEServiceAPI.getPSSYSUNIRESID()) : this.getPSDataEntity().getPSSysUniRes();
            this.strServiceParam = this.psDEServiceAPI.getSERVICEPARAM();
            this.strServiceParam2 = this.psDEServiceAPI.getSERVICEPARAM2();
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
        super.onInit();
        this.onPreparePSDEServiceAPIFields();
        this.onPreparePSDEServiceAPIMethods();
        this.onPreparePSDEServiceAPIVRs();
    }

    protected void onPreparePSDEServiceAPIMethods() throws Exception {
        PSDEServiceAPIMethodImpl iPSDEServiceAPIMethod;
        String strRequestPath;
        PSDESADetail psDESADetail;
        String strUniqueTag;
        PSDEServiceAPIMethodImpl iPSDEServiceAPIMethod2;
        this.psDEServiceAPIMethodList.clear();
        this.psDEServiceAPIMethodMap.clear();
        if (this.isNested()) {
            return;
        }
        Vector<PSDESADetail> psDEServiceAPIMethodList = new Vector<PSDESADetail>();
        CallResult callResult = this.getPSModelHelper().getPSDESADetails(this.getId(), psDEServiceAPIMethodList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u670d\u52a1API\u65b9\u6cd5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDESADetail psDEServiceAPIMethod : psDEServiceAPIMethodList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEServiceAPIMethod.getPSDESARSID())) continue;
            if (psDEServiceAPIMethod.GetParamIntValue("VALIDFLAG", 1) == 0) {
                this.psDEServiceAPIMethodMap.put(psDEServiceAPIMethod.getUNIQUETAG(), null);
                continue;
            }
            iPSDEServiceAPIMethod2 = new PSDEServiceAPIMethodImpl();
            iPSDEServiceAPIMethod2.init(this.getDAGlobalHelper(), this, psDEServiceAPIMethod);
            this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod2);
            this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod2.getId(), iPSDEServiceAPIMethod2);
            this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod2.getUniqueTag(), iPSDEServiceAPIMethod2);
        }
        if (this.isEnableSelect()) {
            PSDESADetail psDESADetail2;
            String strUniqueTag2 = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s__SELECT", (Object)this.getCodeName()).toUpperCase();
            if (!this.psDEServiceAPIMethodMap.containsKey(strUniqueTag2)) {
                psDESADetail2 = new PSDESADetail();
                psDESADetail2.setPSDESADETAILID(strUniqueTag2);
                psDESADetail2.setDETAILTYPE("SELECT");
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysServiceAPI().getDefaultSelectReqMethod())) {
                    psDESADetail2.setREQUESTMETHOD(this.getPSSysServiceAPI().getDefaultSelectReqMethod());
                } else {
                    psDESADetail2.setREQUESTMETHOD("POST");
                }
                psDESADetail2.setPSDESERVICEAPIID(this.getId());
                psDESADetail2.setMETHODTAG("SELECT");
                psDESADetail2.setCODENAME("Select");
                psDESADetail2.setPSDESADETAILNAME("Select");
                psDESADetail2.set("AUTOMODEL", 1);
                if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail2.getREQUESTMETHOD(), (String)"GET", (boolean)true) == 0) {
                    psDESADetail2.setREQUESTPARAMTYPE("URIPARAM");
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail2.getREQUESTMETHOD(), (String)"POST", (boolean)true) == 0) {
                    psDESADetail2.setREQUESTPARAMTYPE("ENTITY");
                }
                iPSDEServiceAPIMethod2 = new PSDEServiceAPIMethodImpl();
                iPSDEServiceAPIMethod2.init(this.getDAGlobalHelper(), this, psDESADetail2);
                this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod2);
                this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod2.getId(), iPSDEServiceAPIMethod2);
            }
            if (this.isEnableTempData() && !this.psDEServiceAPIMethodMap.containsKey(strUniqueTag2 = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s__SELECTTEMP", (Object)this.getCodeName()).toUpperCase())) {
                psDESADetail2 = new PSDESADetail();
                psDESADetail2.setPSDESADETAILID(strUniqueTag2);
                psDESADetail2.setDETAILTYPE("SELECTTEMP");
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysServiceAPI().getDefaultSelectReqMethod())) {
                    psDESADetail2.setREQUESTMETHOD(this.getPSSysServiceAPI().getDefaultSelectReqMethod());
                } else {
                    psDESADetail2.setREQUESTMETHOD("POST");
                }
                psDESADetail2.setPSDESERVICEAPIID(this.getId());
                psDESADetail2.setMETHODTAG("SELECTTEMP");
                psDESADetail2.setCODENAME("SelectTemp");
                psDESADetail2.setPSDESADETAILNAME("SelectTemp");
                psDESADetail2.set("AUTOMODEL", 1);
                if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail2.getREQUESTMETHOD(), (String)"GET", (boolean)true) == 0) {
                    psDESADetail2.setREQUESTPARAMTYPE("URIPARAM");
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail2.getREQUESTMETHOD(), (String)"POST", (boolean)true) == 0) {
                    psDESADetail2.setREQUESTPARAMTYPE("ENTITY");
                }
                iPSDEServiceAPIMethod2 = new PSDEServiceAPIMethodImpl();
                iPSDEServiceAPIMethod2.init(this.getDAGlobalHelper(), this, psDESADetail2);
                this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod2);
                this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod2.getId(), iPSDEServiceAPIMethod2);
            }
        }
        if (this.isEnableDEAction()) {
            Iterator<IPSDEAction> psDEActions = this.getPSDataEntity().getAllPSDEActions();
            while (psDEActions.hasNext()) {
                IPSDEAction iPSDEAction = psDEActions.next();
                if (!iPSDEAction.isEnableBackend() || !iPSDEAction.isPubServiceDefault() || this.psDEServiceAPIMethodMap.containsKey(strUniqueTag = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s__DEACTION__%2$s", (Object)this.getCodeName(), (Object)iPSDEAction.getName()).toUpperCase())) continue;
                psDESADetail = new PSDESADetail();
                psDESADetail.setPSDESADETAILID(strUniqueTag);
                psDESADetail.setDETAILTYPE("DEACTION");
                psDESADetail.setPSDEACTIONID(iPSDEAction.getId());
                psDESADetail.setPSDEACTIONNAME(iPSDEAction.getName());
                psDESADetail.setPSDESADETAILNAME(iPSDEAction.getCodeName());
                psDESADetail.set("AUTOMODEL", 1);
                strRequestPath = iPSDEAction.getPSRESTfulAPI().getRequestPath();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strRequestPath)) {
                    strRequestPath = strRequestPath.trim();
                    strRequestPath = strRequestPath.replace("/", "");
                    psDESADetail.setCODENAME(strRequestPath);
                } else if (this.getPSSystem().isEnableModelRT() || this.getPSSysServiceAPI().isEnableAPIModelEx()) {
                    if (this.getPSSysServiceAPI().isResetDefaultActionCodeName()) {
                        if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"CREATE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"UPDATE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"REMOVE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"GET", (boolean)true) != 0) {
                            psDESADetail.setCODENAME(iPSDEAction.getServiceCodeName());
                        } else {
                            psDESADetail.setNOSERVICECODENAME(true);
                        }
                    } else {
                        psDESADetail.setCODENAME(iPSDEAction.getServiceCodeName());
                    }
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"CREATE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"UPDATE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"REMOVE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"GET", (boolean)true) != 0) {
                    psDESADetail.setCODENAME(iPSDEAction.getServiceCodeName());
                } else {
                    psDESADetail.setNOSERVICECODENAME(true);
                }
                if (iPSDEAction.getPSRESTfulAPI() instanceof IPSDEActionRESTfulAPI) {
                    IPSDEActionRESTfulAPI iPSDEActionRESTfulAPI = (IPSDEActionRESTfulAPI)iPSDEAction.getPSRESTfulAPI();
                    psDESADetail.setREQUESTPARAMTYPE(iPSDEActionRESTfulAPI.getRequestParamType());
                    psDESADetail.setREQUESTFIELD(iPSDEActionRESTfulAPI.getRequestField());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEAction.getPSRESTfulAPI().getRequestMethod())) {
                    psDESADetail.setREQUESTMETHOD(iPSDEAction.getPSRESTfulAPI().getRequestMethod());
                } else {
                    String strPSDEActionName;
                    String strPSDEActionName2;
                    String strActionMode;
                    String strRequestMethod = null;
                    strRequestMethod = this.getPSSysServiceAPI().isEnableAPIModelEx() ? ("CREATE".equals(strActionMode = iPSDEAction.getActionMode()) ? this.getPSSysServiceAPI().getCreateReqMethod("POST") : ("UPDATE".equals(strActionMode) ? this.getPSSysServiceAPI().getUpdateReqMethod("PUT") : ("READ".equals(strActionMode) ? this.getPSSysServiceAPI().getGetReqMethod("GET") : ("DELETE".equals(strActionMode) ? this.getPSSysServiceAPI().getDeleteReqMethod("DELETE") : ((strPSDEActionName2 = iPSDEAction.getName().toUpperCase()).indexOf("CREATE") != -1 ? this.getPSSysServiceAPI().getCreateReqMethod("POST") : (strPSDEActionName2.indexOf("UPDATE") != -1 ? this.getPSSysServiceAPI().getUpdateReqMethod("PUT") : (strPSDEActionName2.indexOf("GET") != -1 ? this.getPSSysServiceAPI().getGetReqMethod("GET") : (strPSDEActionName2.indexOf("REMOVE") != -1 ? this.getPSSysServiceAPI().getDeleteReqMethod("DELETE") : (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysServiceAPI().getDefaultDEActionReqMethod()) ? this.getPSSysServiceAPI().getDefaultDEActionReqMethod() : "POST"))))))))) : ((strPSDEActionName = iPSDEAction.getName().toUpperCase()).indexOf("CREATE") != -1 ? this.getPSSysServiceAPI().getCreateReqMethod("POST") : (strPSDEActionName.indexOf("UPDATE") != -1 ? this.getPSSysServiceAPI().getUpdateReqMethod("PUT") : (strPSDEActionName.indexOf("GET") != -1 ? this.getPSSysServiceAPI().getGetReqMethod("GET") : (strPSDEActionName.indexOf("REMOVE") != -1 ? this.getPSSysServiceAPI().getDeleteReqMethod("DELETE") : (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysServiceAPI().getDefaultDEActionReqMethod()) ? this.getPSSysServiceAPI().getDefaultDEActionReqMethod() : "POST")))));
                    psDESADetail.setREQUESTMETHOD(strRequestMethod);
                }
                psDESADetail.setPSDESERVICEAPIID(this.getId());
                psDESADetail.setMETHODTAG(SA.SRFramework.Utility.StringHelper.Format((String)"DEACTION__%1$s", (Object)iPSDEAction.getName()).toUpperCase());
                iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
                iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), this, psDESADetail);
                this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod);
                this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getId(), iPSDEServiceAPIMethod);
            }
        }
        if (this.isEnableDEDataSet()) {
            Iterator<IPSDEDataSet> psDEDataSets = this.getPSDataEntity().getAllPSDEDataSets();
            while (psDEDataSets.hasNext()) {
                IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
                if (!iPSDEDataSet.isEnableBackend() || !iPSDEDataSet.isPubServiceDefault()) continue;
                strUniqueTag = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s__FETCH__%2$s", (Object)this.getCodeName(), (Object)iPSDEDataSet.getName()).toUpperCase();
                if (!this.psDEServiceAPIMethodMap.containsKey(strUniqueTag)) {
                    psDESADetail = new PSDESADetail();
                    psDESADetail.setPSDESADETAILID(strUniqueTag);
                    psDESADetail.setDETAILTYPE("FETCH");
                    psDESADetail.setPSDEDSID(iPSDEDataSet.getId());
                    psDESADetail.setPSDEDSNAME(iPSDEDataSet.getName());
                    psDESADetail.set("AUTOMODEL", 1);
                    strRequestPath = iPSDEDataSet.getPSRESTfulAPI().getRequestPath();
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strRequestPath)) {
                        strRequestPath = strRequestPath.trim();
                        strRequestPath = strRequestPath.replace("/", "");
                        psDESADetail.setCODENAME(strRequestPath);
                    } else {
                        psDESADetail.setCODENAME(iPSDEDataSet.getServiceCodeName());
                    }
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEDataSet.getPSRESTfulAPI().getRequestMethod())) {
                        psDESADetail.setREQUESTMETHOD(iPSDEDataSet.getPSRESTfulAPI().getRequestMethod());
                    } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysServiceAPI().getDefaultDEDataSetReqMethod())) {
                        psDESADetail.setREQUESTMETHOD(this.getPSSysServiceAPI().getDefaultDEDataSetReqMethod());
                    } else {
                        psDESADetail.setREQUESTMETHOD("POST");
                    }
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail.getREQUESTMETHOD(), (String)"GET", (boolean)true) == 0) {
                        psDESADetail.setREQUESTPARAMTYPE("URIPARAM");
                    } else if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail.getREQUESTMETHOD(), (String)"POST", (boolean)true) == 0) {
                        psDESADetail.setREQUESTPARAMTYPE("ENTITY");
                    }
                    psDESADetail.setPSDESADETAILNAME(psDESADetail.getCODENAME());
                    psDESADetail.setPSDESERVICEAPIID(this.getId());
                    psDESADetail.setMETHODTAG(SA.SRFramework.Utility.StringHelper.Format((String)"FETCH__%1$s", (Object)iPSDEDataSet.getName()).toUpperCase());
                    iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
                    iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), this, psDESADetail);
                    this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod);
                    this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getId(), iPSDEServiceAPIMethod);
                }
                if (!this.isEnableTempData() || !iPSDEDataSet.isEnableTempData() || this.psDEServiceAPIMethodMap.containsKey(strUniqueTag = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s__FETCHTEMP__%2$s", (Object)this.getCodeName(), (Object)iPSDEDataSet.getName()).toUpperCase())) continue;
                psDESADetail = new PSDESADetail();
                psDESADetail.setPSDESADETAILID(strUniqueTag);
                psDESADetail.setDETAILTYPE("FETCHTEMP");
                psDESADetail.setPSDEDSID(iPSDEDataSet.getId());
                psDESADetail.setPSDEDSNAME(iPSDEDataSet.getName());
                psDESADetail.set("AUTOMODEL", 1);
                strRequestPath = iPSDEDataSet.getPSRESTfulAPI().getRequestPath();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strRequestPath)) {
                    strRequestPath = strRequestPath.trim();
                    strRequestPath = strRequestPath.replace("/", "");
                    psDESADetail.setCODENAME(strRequestPath);
                } else {
                    psDESADetail.setCODENAME(String.format("%1$s%2$s", "FetchTemp", PSModelCodeNameUtils.capitalize(iPSDEDataSet.getCodeName())));
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEDataSet.getPSRESTfulAPI().getRequestMethod())) {
                    psDESADetail.setREQUESTMETHOD(iPSDEDataSet.getPSRESTfulAPI().getRequestMethod());
                } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysServiceAPI().getDefaultDEDataSetReqMethod())) {
                    psDESADetail.setREQUESTMETHOD(this.getPSSysServiceAPI().getDefaultDEDataSetReqMethod());
                } else {
                    psDESADetail.setREQUESTMETHOD("POST");
                }
                if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail.getREQUESTMETHOD(), (String)"GET", (boolean)true) == 0) {
                    psDESADetail.setREQUESTPARAMTYPE("URIPARAM");
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail.getREQUESTMETHOD(), (String)"POST", (boolean)true) == 0) {
                    psDESADetail.setREQUESTPARAMTYPE("ENTITY");
                }
                psDESADetail.setPSDESADETAILNAME(psDESADetail.getCODENAME());
                psDESADetail.setPSDESERVICEAPIID(this.getId());
                psDESADetail.setMETHODTAG(SA.SRFramework.Utility.StringHelper.Format((String)"FETCHTEMP__%1$s", (Object)iPSDEDataSet.getName()).toUpperCase());
                iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
                iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), this, psDESADetail);
                this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod);
                this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getId(), iPSDEServiceAPIMethod);
            }
        }
        if (this.psDEServiceAPIMethodList != null && this.psDEServiceAPIMethodList.size() != 0) {
            Collections.sort(this.psDEServiceAPIMethodList, new Comparator<IPSDEServiceAPIMethod>(){

                @Override
                public int compare(IPSDEServiceAPIMethod o1, IPSDEServiceAPIMethod o2) {
                    int nRet = o1.getMethodType().compareTo(o2.getMethodType());
                    if (nRet != 0) {
                        return nRet;
                    }
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)o1.getCodeName()) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)o2.getCodeName()) && o1.getPSDEAction() != null && o2.getPSDEAction() != null) {
                        return StringHelper.compare((String)o1.getPSDEAction().getCodeName(), (String)o2.getPSDEAction().getCodeName(), (boolean)false);
                    }
                    return StringHelper.compare((String)o1.getCodeName(), (String)o2.getCodeName(), (boolean)false);
                }
            });
        }
    }

    protected void onPreparePSDEServiceAPIFields() throws Exception {
        PSDEServiceAPIFieldImpl psDEServiceAPIFieldImpl;
        this.psDEServiceAPIFieldList.clear();
        this.psDEServiceAPIFieldMap.clear();
        if (this.getPSDEFGroup() != null) {
            Iterator<IPSDEFGroupDetail> psDEFGroupDetails = this.getPSDEFGroup().getPSDEFGroupDetails();
            if (psDEFGroupDetails != null) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getDEFGroupMode(), (String)"REPLACE", (boolean)true) == 0) {
                    while (psDEFGroupDetails.hasNext()) {
                        IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
                        psDEServiceAPIFieldImpl = new PSDEServiceAPIFieldImpl();
                        psDEServiceAPIFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEFGroupDetail);
                        this.psDEServiceAPIFieldList.add(psDEServiceAPIFieldImpl);
                    }
                } else {
                    LinkedHashMap<String, IPSDEFGroupDetail> psDEFGroupDetailMap = new LinkedHashMap<String, IPSDEFGroupDetail>();
                    while (psDEFGroupDetails.hasNext()) {
                        IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
                        psDEFGroupDetailMap.put(iPSDEFGroupDetail.getPSDEField().getId(), iPSDEFGroupDetail);
                    }
                    Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getAllPSDEFields();
                    if (psDEFields != null) {
                        boolean bOverwrite = false;
                        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getDEFGroupMode(), (String)"OVERWRITE", (boolean)true) == 0) {
                            bOverwrite = true;
                        }
                        while (psDEFields.hasNext()) {
                            PSDEServiceAPIFieldImpl psDEServiceAPIFieldImpl2;
                            IPSDEField iPSDEField = psDEFields.next();
                            IPSDEFGroupDetail iPSDEFGroupDetail = (IPSDEFGroupDetail)psDEFGroupDetailMap.get(iPSDEField.getId());
                            if (iPSDEFGroupDetail != null) {
                                if (!bOverwrite) continue;
                                psDEServiceAPIFieldImpl2 = new PSDEServiceAPIFieldImpl();
                                psDEServiceAPIFieldImpl2.init(this.getDAGlobalHelper(), this, iPSDEFGroupDetail);
                                this.psDEServiceAPIFieldList.add(psDEServiceAPIFieldImpl2);
                                continue;
                            }
                            psDEServiceAPIFieldImpl2 = new PSDEServiceAPIFieldImpl();
                            psDEServiceAPIFieldImpl2.init(this.getDAGlobalHelper(), this, iPSDEField);
                            this.psDEServiceAPIFieldList.add(psDEServiceAPIFieldImpl2);
                        }
                    }
                }
                Collections.sort(this.psDEServiceAPIFieldList, new Comparator<IPSDEServiceAPIField>(){

                    @Override
                    public int compare(IPSDEServiceAPIField arg0, IPSDEServiceAPIField arg1) {
                        int nValue = arg0.getOrderValue() - arg1.getOrderValue();
                        if (nValue == 0) {
                            return arg0.getName().compareTo(arg1.getName());
                        }
                        return new Integer(arg0.getOrderValue()).compareTo(arg1.getOrderValue());
                    }
                });
            }
        } else {
            Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    IPSDEField iPSDEField = psDEFields.next();
                    psDEServiceAPIFieldImpl = new PSDEServiceAPIFieldImpl();
                    psDEServiceAPIFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEField);
                    this.psDEServiceAPIFieldList.add(psDEServiceAPIFieldImpl);
                }
            }
        }
        for (IPSDEServiceAPIField iPSDEServiceAPIField : this.psDEServiceAPIFieldList) {
            if (iPSDEServiceAPIField.isMajorField()) {
                this.majorPSDEServiceAPIField = iPSDEServiceAPIField;
            }
            if (iPSDEServiceAPIField.isKeyField()) {
                this.keyPSDEServiceAPIField = iPSDEServiceAPIField;
            }
            this.psDEServiceAPIFieldMap.put(iPSDEServiceAPIField.getId(), iPSDEServiceAPIField);
            this.psDEServiceAPIFieldMap.put(iPSDEServiceAPIField.getName(), iPSDEServiceAPIField);
        }
    }

    protected void onPreparePSDEServiceAPIVRs() throws Exception {
        this.psDEServiceAPIVRList.clear();
        Vector<PSDESAVR> psDEServiceAPIVRList = new Vector<PSDESAVR>();
        CallResult callResult = this.getPSModelHelper().getPSDESAVRs(this.getId(), psDEServiceAPIVRList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u670d\u52a1API\u503c\u89c4\u5219\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDESAVR psDEServiceAPIVR : psDEServiceAPIVRList) {
            PSDEServiceAPIVRImpl iPSDEServiceAPIVR = new PSDEServiceAPIVRImpl();
            iPSDEServiceAPIVR.init(this.getDAGlobalHelper(), this, psDEServiceAPIVR);
            this.psDEServiceAPIVRList.add(iPSDEServiceAPIVR);
        }
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u65b9\u6cd5\u96c6\u5408", child=true, group="\u903b\u8f91", order=330)
    public Iterator<IPSDEServiceAPIMethod> getPSDEServiceAPIMethods() {
        return this.psDEServiceAPIMethodList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc62\uff08\u590d\u6570\uff09")
    public String getCodeName2() {
        return this.strCodeName2;
    }

    @Override
    public String getModelType() {
        return "PSDESERVICEAPI";
    }

    @Override
    public String getModelId() {
        try {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysServiceAPI().getModelId(), (Object)super.getModelId());
        }
        catch (Exception ex) {
            return "";
        }
    }

    @Override
    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod(String strPSDEServiceAPIMethodId) throws Exception {
        return this.getPSDEServiceAPIMethod(strPSDEServiceAPIMethodId, false);
    }

    @Override
    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod(String strPSDEServiceAPIMethodId, boolean bTryMode) throws Exception {
        IPSDEServiceAPIMethod iPSDEServiceAPIMethod = this.psDEServiceAPIMethodMap.get(strPSDEServiceAPIMethodId);
        if (iPSDEServiceAPIMethod != null || bTryMode) {
            return iPSDEServiceAPIMethod;
        }
        throw PSDEServiceAPIException.create(this, 20020, (Object)strPSDEServiceAPIMethodId);
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3")
    public IPSSysServiceAPI getPSSysServiceAPI() throws Exception {
        if (this.iPSSysServiceAPI == null) {
            this.iPSSysServiceAPI = this.getPSDataEntity().getPSSystem().getPSSysServiceAPI(this.psDEServiceAPI.getPSSYSSERVICEAPIID());
        }
        return this.iPSSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u652f\u6301\u5b9e\u4f53\u884c\u4e3a", dump=false)
    public boolean isEnableDEAction() {
        return !this.isNested() && this.bEnableDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u652f\u6301\u7b80\u5355\u67e5\u8be2", dump=false)
    public boolean isEnableSelect() {
        try {
            return !this.isNested() && this.bEnableSelect && !this.getPSSysServiceAPI().isEnableAPIModelEx();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return false;
        }
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u652f\u6301\u7ed3\u679c\u96c6\u67e5\u8be2", dump=false)
    public boolean isEnableDEDataSet() {
        return !this.isNested() && this.bEnableDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4e34\u65f6\u6570\u636e", ignoredumpvalues="false", dump=false)
    public boolean isEnableTempData() {
        try {
            return this.bEnableTempData && !this.getPSSysServiceAPI().isEnableAPIModelEx();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return false;
        }
    }

    @Override
    public String getHandler() {
        try {
            return this.getPSSysServiceAPI().getHandler();
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage());
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u5c5e\u6027\u96c6\u5408", child=true, dynamodelmode=8, outputdoc="false")
    public Iterator<? extends IPSDEServiceAPIField> getPSDEServiceAPIFields() {
        return this.psDEServiceAPIFieldList.iterator();
    }

    @Override
    public IPSDEServiceAPIField getPSDEServiceAPIField(String strPSDEFieldId) throws Exception {
        return this.getPSDEServiceAPIField(strPSDEFieldId, false);
    }

    @Override
    public IPSDEServiceAPIField getPSDEServiceAPIField(String strPSDEFieldId, boolean bTryMode) throws Exception {
        IPSDEServiceAPIField iPSDEServiceAPIField = this.psDEServiceAPIFieldMap.get(strPSDEFieldId);
        if (iPSDEServiceAPIField != null || bTryMode) {
            return iPSDEServiceAPIField;
        }
        throw PSDEServiceAPIException.create(this, 20023, (Object)strPSDEFieldId);
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u5bf9\u8c61")
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u63a5\u53e3")
    public boolean isMajor() {
        return this.nAPIMode == 1;
    }

    @Override
    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSs(boolean bMajor) {
        Iterator<IPSDEServiceAPIRS> psDEServiceAPIRSs;
        block10: {
            psDEServiceAPIRSs = this.getPSSysServiceAPI().getPSDEServiceAPIRSs();
            if (psDEServiceAPIRSs != null) break block10;
            return null;
        }
        try {
            if (bMajor) {
                if (this.majorPSDEServiceAPIRSList == null) {
                    ArrayList<IPSDEServiceAPIRS> list = new ArrayList<IPSDEServiceAPIRS>();
                    while (psDEServiceAPIRSs.hasNext()) {
                        IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                        if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEServiceAPIRS.getPPSDEServiceAPIId(), (String)this.getId(), (boolean)true) != 0) continue;
                        list.add(iPSDEServiceAPIRS);
                    }
                    if (this.majorPSDEServiceAPIRSList == null) {
                        PSModelUtil.sort(list);
                        this.majorPSDEServiceAPIRSList = list;
                    }
                }
                return this.majorPSDEServiceAPIRSList.iterator();
            }
            if (this.minorPSDEServiceAPIRSList == null) {
                ArrayList<IPSDEServiceAPIRS> list = new ArrayList<IPSDEServiceAPIRS>();
                while (psDEServiceAPIRSs.hasNext()) {
                    IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEServiceAPIRS.getCPSDEServiceAPIId(), (String)this.getId(), (boolean)true) != 0) continue;
                    list.add(iPSDEServiceAPIRS);
                }
                if (this.minorPSDEServiceAPIRSList == null) {
                    PSModelUtil.sort(list);
                    this.minorPSDEServiceAPIRSList = list;
                }
            }
            return this.minorPSDEServiceAPIRSList.iterator();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSs() {
        return this.getPSDEServiceAPIRSs(true);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u4e3b\u5173\u7cfb\u96c6\u5408", child=true, dumpref=true, ignorert=3, dynamodelmode=8, from="IPSSysServiceAPI", group="\u903b\u8f91", order=332)
    public Iterator<? extends IPSDEServiceAPIRS> getMajorPSDEServiceAPIRSs() {
        return this.getPSDEServiceAPIRSs(true);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u4ece\u5173\u7cfb\u96c6\u5408", child=true, dumpref=true, rtdump=2, dynamodelmode=8, from="IPSSysServiceAPI", group="\u903b\u8f91", order=334)
    public Iterator<? extends IPSDEServiceAPIRS> getMinorPSDEServiceAPIRSs() {
        return this.getPSDEServiceAPIRSs(false);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84\u6570\u91cf", dump=false, outputdoc="false")
    public int getPSDEServiceAPIRSPathCount() throws Exception {
        this.preparePSDEServiceAPIRSPaths();
        if (this.psDEServiceAPIRSPathMap == null) {
            return 0;
        }
        return this.psDEServiceAPIRSPathMap.size();
    }

    @Override
    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath(int nPathIndex) throws Exception {
        this.preparePSDEServiceAPIRSPaths();
        if (this.psDEServiceAPIRSPathMap == null) {
            return null;
        }
        ArrayList<IPSDEServiceAPIRS> list = this.psDEServiceAPIRSPathMap.get(nPathIndex);
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    protected synchronized void preparePSDEServiceAPIRSPaths() throws Exception {
        var1_1 = this;
        synchronized (var1_1) {
            if (this.psDEServiceAPIRSPathMap != null) {
                return;
            }
            this.psDEServiceAPIRSPathMap = new LinkedHashMap<Integer, ArrayList<IPSDEServiceAPIRS>>();
            if (this.isNested()) {
                return;
            }
            psDEServiceAPIRSs = this.getPSDEServiceAPIRSs(false);
            if (psDEServiceAPIRSs != null) ** GOTO lbl19
            return;
lbl-1000:
            // 1 sources

            {
                iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEServiceAPIRS.getPPSDEServiceAPIId(), (String)iPSDEServiceAPIRS.getCPSDEServiceAPIId(), (boolean)false) == 0) continue;
                list = new ArrayList<IPSDEServiceAPIRS>();
                nIndex = this.psDEServiceAPIRSPathMap.size();
                this.psDEServiceAPIRSPathMap.put(nIndex, list);
                this.fillPSDEServiceAPIRSPath(iPSDEServiceAPIRS, list);
lbl19:
                // 3 sources

                ** while (psDEServiceAPIRSs.hasNext())
            }
lbl20:
            // 1 sources

            if (this.psDEServiceAPIRSPathMap.size() > 1) {
                list = new ArrayList<ArrayList<IPSDEServiceAPIRS>>();
                list.addAll(this.psDEServiceAPIRSPathMap.values());
                Collections.sort(list, new Comparator<ArrayList<IPSDEServiceAPIRS>>(){

                    @Override
                    public int compare(ArrayList<IPSDEServiceAPIRS> arg0, ArrayList<IPSDEServiceAPIRS> arg1) {
                        if (arg0.size() != arg1.size()) {
                            return Integer.valueOf(arg0.size()).compareTo(arg1.size());
                        }
                        int i = 0;
                        while (i < arg0.size()) {
                            int nRet = arg0.get(i).getName().compareTo(arg1.get(i).getName());
                            if (nRet != 0) {
                                return nRet;
                            }
                            ++i;
                        }
                        return 0;
                    }
                });
                this.psDEServiceAPIRSPathMap.clear();
                i = 0;
                while (i < list.size()) {
                    this.psDEServiceAPIRSPathMap.put(i, (ArrayList)list.get(i));
                    ++i;
                }
            }
        }
    }

    protected synchronized void fillPSDEServiceAPIRSPath(IPSDEServiceAPIRS iPSDEServiceAPIRS, ArrayList<IPSDEServiceAPIRS> list) throws Exception {
        for (IPSDEServiceAPIRS tempPSDEServiceAPIRS : list) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEServiceAPIRS.getId(), (String)tempPSDEServiceAPIRS.getId(), (boolean)false) != 0) continue;
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%1$s]\u5b58\u5728\u9012\u5f52\u5f15\u7528\u5173\u7cfb[%2$s]", (Object)this.getName(), (Object)iPSDEServiceAPIRS.getName()));
        }
        list.add(0, iPSDEServiceAPIRS);
        Iterator<? extends IPSDEServiceAPIRS> majorList = iPSDEServiceAPIRS.getMajorPSDEServiceAPI().getPSDEServiceAPIRSs(false);
        if (majorList == null) {
            return;
        }
        ArrayList<IPSDEServiceAPIRS> srcList = new ArrayList<IPSDEServiceAPIRS>();
        srcList.addAll(list);
        int nIndex = 0;
        while (majorList.hasNext()) {
            int nIndex2;
            ArrayList<IPSDEServiceAPIRS> list2;
            IPSDEServiceAPIRS tempPSDEServiceAPIRS = majorList.next();
            if (SA.SRFramework.Utility.StringHelper.Compare((String)tempPSDEServiceAPIRS.getPPSDEServiceAPIId(), (String)tempPSDEServiceAPIRS.getCPSDEServiceAPIId(), (boolean)false) == 0) continue;
            if (nIndex == 0) {
                if (iPSDEServiceAPIRS.getMajorPSDEServiceAPI().isMajor()) {
                    list2 = new ArrayList();
                    list2.addAll(srcList);
                    nIndex2 = this.psDEServiceAPIRSPathMap.size();
                    this.psDEServiceAPIRSPathMap.put(nIndex2, list2);
                }
                this.fillPSDEServiceAPIRSPath(tempPSDEServiceAPIRS, list);
            } else {
                list2 = new ArrayList<IPSDEServiceAPIRS>();
                list2.addAll(srcList);
                nIndex2 = this.psDEServiceAPIRSPathMap.size();
                this.psDEServiceAPIRSPathMap.put(nIndex2, list2);
                this.fillPSDEServiceAPIRSPath(tempPSDEServiceAPIRS, list2);
            }
            ++nIndex;
        }
    }

    @Override
    public int check() throws Exception {
        return super.check();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSDEServiceAPIRSPathCount();
        int nRet = 0;
        Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods = this.getPSDEServiceAPIMethods();
        if (psDEServiceAPIMethods != null) {
            while (psDEServiceAPIMethods.hasNext()) {
                IPSDEServiceAPIMethod iPSDEServiceAPIMethod = psDEServiceAPIMethods.next();
                nRet += iPSDEServiceAPIMethod.check();
            }
        }
        return nRet + super.onCheck();
    }

    @Override
    public IPSDEServiceAPIRS getPSDEServiceAPIRSPathFirst(int nPathIndex) throws Exception {
        this.preparePSDEServiceAPIRSPaths();
        if (this.psDEServiceAPIRSPathMap == null) {
            return null;
        }
        ArrayList<IPSDEServiceAPIRS> list = this.psDEServiceAPIRSPathMap.get(nPathIndex);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public IPSDEServiceAPIRS getPSDEServiceAPIRSPathLast(int nPathIndex) throws Exception {
        this.preparePSDEServiceAPIRSPaths();
        if (this.psDEServiceAPIRSPathMap == null) {
            return null;
        }
        ArrayList<IPSDEServiceAPIRS> list = this.psDEServiceAPIRSPathMap.get(nPathIndex);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u4f7f\u7528\u6a21\u5f0f", codelist="DESADEFGroupMode", hideempty2=true, dump=false)
    public String getDEFGroupMode() {
        return this.strDEFGroupMode;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u503c\u89c4\u5219\u96c6\u5408", outputdoc="false")
    public Iterator<? extends IPSDEServiceAPIVR> getPSDEServiceAPIVRs() {
        return this.psDEServiceAPIVRList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[0]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath0() throws Exception {
        return this.getPSDEServiceAPIRSPath(0);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[1]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath1() throws Exception {
        return this.getPSDEServiceAPIRSPath(1);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[2]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath2() throws Exception {
        return this.getPSDEServiceAPIRSPath(2);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[3]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath3() throws Exception {
        return this.getPSDEServiceAPIRSPath(3);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[4]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath4() throws Exception {
        return this.getPSDEServiceAPIRSPath(4);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8bbf\u95ee\u63a7\u5236\u4f53\u7cfb", codelist="AccCtrlArch", dump=false)
    public int getDataAccCtrlArch() {
        return this.nDataAccCtrlArch;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u65b9\u5f0f", codelist="DEDataAccCtrlMode", dump=false)
    public int getDataAccCtrlMode() {
        return this.nDataAccCtrlMode;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e\u5c5e\u6027")
    public IPSDEServiceAPIField getKeyPSDEServiceAPIField() {
        return this.keyPSDEServiceAPIField;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u4fe1\u606f\u5c5e\u6027")
    public IPSDEServiceAPIField getMajorPSDEServiceAPIField() {
        return this.majorPSDEServiceAPIField;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u6a21\u5f0f", codelist="DESAMode", group="\u57fa\u672c", order=125, fields={"MAJORFLAG"})
    public int getAPIMode() {
        return this.nAPIMode;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6210\u5458", ignoredumpvalues="false")
    public boolean isNested() {
        return this.nAPIMode == 9;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.iPSSysSFPlugin == null) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEServiceAPI.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psDEServiceAPI.getPSSYSSFPLUGINID());
            } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysServiceAPI().getDEPSSysSFPluginId())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.getPSSysServiceAPI().getDEPSSysSFPluginId());
            }
        }
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() throws Exception {
        if (this.iPSSFXCodeObject == null && this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.strLogicName;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getLNPSLanguageRes() {
        return this.lnPSLanguageRes;
    }

    @Override
    public List<PSDESARS> getAutoPSDESARSs() throws Exception {
        String strDEBizTag = this.getPSDataEntity().getBizTag();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strDEBizTag)) {
            return null;
        }
        ArrayList<PSDESARS> list = new ArrayList<PSDESARS>();
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strDEBizTag, (String)"DATAAUDIT", (boolean)false) == 0) {
            Iterator<IPSDEServiceAPI> psDEServceAPIs = this.getPSSysServiceAPI().getPSDEServiceAPIs();
            if (psDEServceAPIs != null) {
                while (psDEServceAPIs.hasNext()) {
                    IPSDEUtil iPSDEUtil;
                    IPSDEServiceAPI iPSDEServiceAPI = psDEServceAPIs.next();
                    if (iPSDEServiceAPI.getAPIMode() == 9 || iPSDEServiceAPI.getPSDataEntity().getAuditMode() == 0 || (iPSDEUtil = iPSDEServiceAPI.getPSDataEntity().getPSDEUtil("DATAAUDIT", true)) == null || SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEUtil.getUtilPSDEId(), (String)this.getPSDataEntity().getId(), (boolean)false) != 0) continue;
                    PSDESARS psDESARS = new PSDESARS();
                    psDESARS.setPSDESARSID(KeyValueHelper.genUniqueId((String)"DATAAUDIT", (String)iPSDEServiceAPI.getId(), (String)this.getId()));
                    psDESARS.setPSDESARSNAME(SA.SRFramework.Utility.StringHelper.Format((String)"DATAAUDIT__%1$s__%2$s", (Object)iPSDEServiceAPI.getName(), (Object)this.getName()));
                    psDESARS.setPPSDESERVICEAPIID(iPSDEServiceAPI.getId());
                    psDESARS.setPPSDESERVICEAPINAME(iPSDEServiceAPI.getName());
                    psDESARS.setCPSDESERVICEAPIID(this.getId());
                    psDESARS.setCPSDESERVICEAPINAME(this.getName());
                    psDESARS.setVALIDFLAG(true);
                    psDESARS.set("AUTOMODEL", 1);
                    list.add(psDESARS);
                }
            }
            if (list.size() != 0) {
                return list;
            }
            return null;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u5bfc\u5165", ignoredumpvalues="false")
    public boolean isEnableDataImport() {
        return this.bEnableDataImport;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u5bfc\u51fa", ignoredumpvalues="false")
    public boolean isEnableDataExport() {
        return this.bEnableDataExport;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u5b9a\u5411\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, doc="\u6307\u5411\u5b9e\u9645\u7684\u670d\u52a1\u5bf9\u8c61")
    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() throws Exception {
        return this.getPSDataEntity().getPSSubSysServiceAPIDE();
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
    @PSModelRTMeta(description="\u8f93\u51fa\u503c\u8f6c\u6362\u5668", dumpref=true, ignorepf=true, fields={"OUTPSSYSTRANSLATORID"})
    public IPSSysTranslator getOutPSSysTranslator() {
        return this.outPSSysTranslator;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u7edf\u4e00\u8d44\u6e90", dumpref=true, ignorepf=true, fields={"PSSYSUNIRESID"})
    public IPSSysUniRes getPSSysUniRes() {
        return this.iPSSysUniRes;
    }

    @Override
    public int getOrderValue() {
        if (!this.psDEServiceAPI.isORDERVALUENull() && this.psDEServiceAPI.getORDERVALUE() >= 0) {
            return this.psDEServiceAPI.getORDERVALUE();
        }
        return 99999;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        try {
            return this.getPSSysServiceAPI();
        }
        catch (Exception e) {
            return super.onGetParentModel();
        }
    }
}

