/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIException;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIMethodImpl;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIMethodProxy;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Service.IPSDEActionRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.PS.Data.PSDESADetail;
import SA.SRFDA.PS.Data.PSDESARS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEServiceAPIRSImpl
extends PSObjectImpl
implements IPSDEServiceAPIRS,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIRSImpl.class);
    private IPSSysServiceAPI iPSSysServiceAPI = null;
    private ArrayList<IPSDEServiceAPIMethod> psDEServiceAPIMethodList = new ArrayList();
    private Map<String, IPSDEServiceAPIMethod> psDEServiceAPIMethodMap = new LinkedHashMap<String, IPSDEServiceAPIMethod>();
    protected PSDESARS psDEServiceAPIRS = null;
    private IPSDER1N pValuePSDER1N = null;
    private IPSDERBase pValuePSDERBase = null;
    private String strParentFilter = null;
    private String strParentTypeFilter = null;
    private int nDataRSMode = IPSDEServiceAPIRS.DATARSMODE_NONE;
    private int nActionRSMode = IPSDEServiceAPIRS.ACTIONRSMODE_INHERIT;
    private boolean bEnableDEAction = true;
    private boolean bEnableSelect = true;
    private boolean bEnableDEDataSet = true;
    private int nDataAccCtrlMode = -1;
    private String strCodeName = "";
    private int nOrderValue = 99999;
    private boolean bArray = true;
    private boolean bEnableDataImport = true;
    private boolean bEnableDataExport = true;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysServiceAPI iPSSysServiceAPI, PSDESARS psDEServiceAPIRS) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysServiceAPI(iPSSysServiceAPI);
            this.psDEServiceAPIRS = psDEServiceAPIRS;
            this.setId(this.psDEServiceAPIRS.getPSDESARSID());
            this.setName(this.psDEServiceAPIRS.getPSDESARSNAME());
            this.setPSObjectData(this.psDEServiceAPIRS);
            this.strCodeName = psDEServiceAPIRS.getCODENAME();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEServiceAPIRS.getPSDERID())) {
                IPSDERCustom iPSDERCustom;
                IPSDERBase iPSDERBase = this.getPSSysServiceAPI().getPSSystem().getPSDER(this.psDEServiceAPIRS.getPSDERID());
                if (iPSDERBase instanceof IPSDER1N) {
                    this.pValuePSDER1N = (IPSDER1N)iPSDERBase;
                    this.pValuePSDERBase = iPSDERBase;
                } else if (iPSDERBase instanceof IPSDERCustom && (SA.SRFramework.Utility.StringHelper.Compare((String)(iPSDERCustom = (IPSDERCustom)iPSDERBase).getDERSubType(), (String)"DER1N", (boolean)false) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)iPSDERCustom.getDERSubType(), (String)"DER11", (boolean)false) == 0)) {
                    this.pValuePSDERBase = iPSDERBase;
                }
                if (this.getPSDER() == null) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6307\u5b9a\u7236\u503c\u5173\u7cfb[%1$s]\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3a1:N\u30011:1\u6216\u81ea\u5b9a\u4e491:N\u30011:1\u5173\u7cfb", (Object)iPSDERBase.getName()));
                }
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) && this.getPSDER() != null) {
                    this.strCodeName = this.getPSSysServiceAPI().getAPICodeName(null, this.getPSDER().getMinorServiceCodeName(), null);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEServiceAPIRS.getCHILDFILTER())) {
                this.strParentFilter = this.psDEServiceAPIRS.getCHILDFILTER();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEServiceAPIRS.getTYPEFILTER())) {
                this.strParentTypeFilter = this.psDEServiceAPIRS.getTYPEFILTER();
            }
            if (!this.psDEServiceAPIRS.isDATARSMODENull()) {
                this.nDataRSMode = this.psDEServiceAPIRS.getDATARSMODE();
            }
            if (!this.psDEServiceAPIRS.isACTIONRSMODENull()) {
                this.nActionRSMode = this.psDEServiceAPIRS.getACTIONRSMODE();
            }
            if (!this.psDEServiceAPIRS.isDATAACCMODENull()) {
                this.nDataAccCtrlMode = this.psDEServiceAPIRS.getDATAACCMODE();
            }
            if (!this.psDEServiceAPIRS.isORDERVALUENull() && this.psDEServiceAPIRS.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psDEServiceAPIRS.getORDERVALUE();
            }
            if (this.getActionRSMode() == IPSDEServiceAPIRS.ACTIONRSMODE_NONE.intValue()) {
                this.bEnableDEAction = false;
                this.bEnableSelect = false;
                this.bEnableDEDataSet = false;
            }
            if (this.getActionRSMode() == IPSDEServiceAPIRS.ACTIONRSMODE_SOME.intValue()) {
                if (!this.psDEServiceAPIRS.isENABLEDEACTIONNull()) {
                    this.bEnableDEAction = this.psDEServiceAPIRS.getENABLEDEACTION();
                }
                if (!this.psDEServiceAPIRS.isENABLESELECTNull()) {
                    this.bEnableSelect = this.psDEServiceAPIRS.getENABLESELECT();
                }
                if (!this.psDEServiceAPIRS.isENABLEDEDATASETNull()) {
                    this.bEnableDEDataSet = this.psDEServiceAPIRS.getENABLEDEDATASET();
                }
            }
            if (!this.psDEServiceAPIRS.isARRAYFLAGNull()) {
                this.bArray = this.psDEServiceAPIRS.getARRAYFLAG();
            }
            if (!this.psDEServiceAPIRS.isENABLEDATAIMPORTNull()) {
                this.bEnableDataImport = this.psDEServiceAPIRS.getENABLEDATAIMPORT();
            }
            if (!this.psDEServiceAPIRS.isENABLEDATAEXPORTNull()) {
                this.bEnableDataExport = this.psDEServiceAPIRS.getENABLEDATAEXPORT();
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
        super.onInit();
        this.onPreparePSDEServiceAPIMethods();
    }

    @Override
    public int check() throws Exception {
        this.getMinorPSDEServiceAPI();
        return super.check();
    }

    protected void onPreparePSDEServiceAPIMethods() throws Exception {
        PSDEServiceAPIMethodImpl iPSDEServiceAPIMethod;
        String strRequestPath;
        PSDESADetail psDESADetail;
        String strUniqueTag;
        PSDEServiceAPIMethodImpl iPSDEServiceAPIMethod2;
        this.psDEServiceAPIMethodList.clear();
        this.psDEServiceAPIMethodMap.clear();
        IPSDEServiceAPI iPSDEServiceAPI = this.getMinorPSDEServiceAPI();
        if (iPSDEServiceAPI.isNested()) {
            return;
        }
        if (this.getActionRSMode() == IPSDEServiceAPIRS.ACTIONRSMODE_NONE.intValue()) {
            return;
        }
        if (this.getActionRSMode() == IPSDEServiceAPIRS.ACTIONRSMODE_INHERIT.intValue()) {
            Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods = iPSDEServiceAPI.getPSDEServiceAPIMethods();
            if (psDEServiceAPIMethods != null) {
                while (psDEServiceAPIMethods.hasNext()) {
                    IPSDEServiceAPIMethod iPSDEServiceAPIMethod3 = psDEServiceAPIMethods.next();
                    PSDEServiceAPIMethodProxy psDEServiceAPIMethodProxy = new PSDEServiceAPIMethodProxy();
                    psDEServiceAPIMethodProxy.init(this.getDAGlobalHelper(), this, iPSDEServiceAPIMethod3);
                    this.psDEServiceAPIMethodList.add(psDEServiceAPIMethodProxy);
                    this.psDEServiceAPIMethodMap.put(psDEServiceAPIMethodProxy.getId(), psDEServiceAPIMethodProxy);
                    this.psDEServiceAPIMethodMap.put(psDEServiceAPIMethodProxy.getUniqueTag(), psDEServiceAPIMethodProxy);
                }
            }
            return;
        }
        if (this.getActionRSMode() != IPSDEServiceAPIRS.ACTIONRSMODE_SOME.intValue()) {
            return;
        }
        Vector<PSDESADetail> psDEServiceAPIMethodList = new Vector<PSDESADetail>();
        CallResult callResult = this.getPSModelHelper().getPSDESADetails(iPSDEServiceAPI.getId(), psDEServiceAPIMethodList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u670d\u52a1API\u65b9\u6cd5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDESADetail psDEServiceAPIMethod : psDEServiceAPIMethodList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEServiceAPIMethod.getPSDESARSID(), (String)this.getId(), (boolean)true) != 0) continue;
            SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEServiceAPIMethod.getPSDESARSID());
            if (psDEServiceAPIMethod.GetParamIntValue("VALIDFLAG", 1) == 0) {
                this.psDEServiceAPIMethodMap.put(psDEServiceAPIMethod.getUNIQUETAG(), null);
                continue;
            }
            iPSDEServiceAPIMethod2 = new PSDEServiceAPIMethodImpl();
            iPSDEServiceAPIMethod2.init(this.getDAGlobalHelper(), iPSDEServiceAPI, this, psDEServiceAPIMethod);
            this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod2);
            this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod2.getId(), iPSDEServiceAPIMethod2);
            this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod2.getUniqueTag(), iPSDEServiceAPIMethod2);
        }
        if (this.isEnableSelect()) {
            PSDESADetail psDESADetail2;
            String strUniqueTag2 = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s__SELECT", (Object)iPSDEServiceAPI.getCodeName()).toUpperCase();
            if (!this.psDEServiceAPIMethodMap.containsKey(strUniqueTag2)) {
                psDESADetail2 = new PSDESADetail();
                psDESADetail2.setPSDESADETAILID(strUniqueTag2);
                psDESADetail2.setDETAILTYPE("SELECT");
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysServiceAPI().getDefaultSelectReqMethod())) {
                    psDESADetail2.setREQUESTMETHOD(this.getPSSysServiceAPI().getDefaultSelectReqMethod());
                } else {
                    psDESADetail2.setREQUESTMETHOD("POST");
                }
                psDESADetail2.setPSDESERVICEAPIID(iPSDEServiceAPI.getId());
                psDESADetail2.setMETHODTAG("SELECT");
                psDESADetail2.setCODENAME("Select");
                psDESADetail2.set("AUTOMODEL", 1);
                if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail2.getREQUESTMETHOD(), (String)"GET", (boolean)true) == 0) {
                    psDESADetail2.setREQUESTPARAMTYPE("URIPARAM");
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail2.getREQUESTMETHOD(), (String)"POST", (boolean)true) == 0) {
                    psDESADetail2.setREQUESTPARAMTYPE("ENTITY");
                }
                iPSDEServiceAPIMethod2 = new PSDEServiceAPIMethodImpl();
                iPSDEServiceAPIMethod2.init(this.getDAGlobalHelper(), iPSDEServiceAPI, this, psDESADetail2);
                this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod2);
                this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod2.getId(), iPSDEServiceAPIMethod2);
            }
            if (iPSDEServiceAPI.isEnableTempData() && !this.psDEServiceAPIMethodMap.containsKey(strUniqueTag2 = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s__SELECTTEMP", (Object)iPSDEServiceAPI.getCodeName()).toUpperCase())) {
                psDESADetail2 = new PSDESADetail();
                psDESADetail2.setPSDESADETAILID(strUniqueTag2);
                psDESADetail2.setDETAILTYPE("SELECTTEMP");
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysServiceAPI().getDefaultSelectReqMethod())) {
                    psDESADetail2.setREQUESTMETHOD(this.getPSSysServiceAPI().getDefaultSelectReqMethod());
                } else {
                    psDESADetail2.setREQUESTMETHOD("POST");
                }
                psDESADetail2.setPSDESERVICEAPIID(iPSDEServiceAPI.getId());
                psDESADetail2.setMETHODTAG("SELECTTEMP");
                psDESADetail2.setCODENAME("SelectTemp");
                psDESADetail2.set("AUTOMODEL", 1);
                if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail2.getREQUESTMETHOD(), (String)"GET", (boolean)true) == 0) {
                    psDESADetail2.setREQUESTPARAMTYPE("URIPARAM");
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)psDESADetail2.getREQUESTMETHOD(), (String)"POST", (boolean)true) == 0) {
                    psDESADetail2.setREQUESTPARAMTYPE("ENTITY");
                }
                iPSDEServiceAPIMethod2 = new PSDEServiceAPIMethodImpl();
                iPSDEServiceAPIMethod2.init(this.getDAGlobalHelper(), iPSDEServiceAPI, this, psDESADetail2);
                this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod2);
                this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod2.getId(), iPSDEServiceAPIMethod2);
            }
        }
        if (this.isEnableDEAction()) {
            Iterator<IPSDEAction> psDEActions = iPSDEServiceAPI.getPSDataEntity().getAllPSDEActions();
            while (psDEActions.hasNext()) {
                IPSDEAction iPSDEAction = psDEActions.next();
                if (!iPSDEAction.isEnableBackend() || !iPSDEAction.isPubServiceDefault() || this.psDEServiceAPIMethodMap.containsKey(strUniqueTag = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s__DEACTION__%2$s", (Object)iPSDEServiceAPI.getCodeName(), (Object)iPSDEAction.getName()).toUpperCase())) continue;
                psDESADetail = new PSDESADetail();
                psDESADetail.setPSDESADETAILID(strUniqueTag);
                psDESADetail.setDETAILTYPE("DEACTION");
                psDESADetail.setPSDEACTIONID(iPSDEAction.getId());
                psDESADetail.setPSDEACTIONNAME(iPSDEAction.getName());
                psDESADetail.set("AUTOMODEL", 1);
                strRequestPath = iPSDEAction.getPSRESTfulAPI().getRequestPath();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strRequestPath)) {
                    strRequestPath = strRequestPath.trim();
                    strRequestPath = strRequestPath.replace("/", "");
                    psDESADetail.setCODENAME(strRequestPath);
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"CREATE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"UPDATE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"REMOVE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction.getName(), (String)"GET", (boolean)true) != 0) {
                    psDESADetail.setCODENAME(iPSDEAction.getServiceCodeName());
                }
                if (iPSDEAction.getPSRESTfulAPI() instanceof IPSDEActionRESTfulAPI) {
                    IPSDEActionRESTfulAPI iPSDEActionRESTfulAPI = (IPSDEActionRESTfulAPI)iPSDEAction.getPSRESTfulAPI();
                    psDESADetail.setREQUESTPARAMTYPE(iPSDEActionRESTfulAPI.getRequestParamType());
                    psDESADetail.setREQUESTFIELD(iPSDEActionRESTfulAPI.getRequestField());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEAction.getPSRESTfulAPI().getRequestMethod())) {
                    psDESADetail.setREQUESTMETHOD(iPSDEAction.getPSRESTfulAPI().getRequestMethod());
                } else {
                    String strPSDEActionName = iPSDEAction.getName().toUpperCase();
                    if (strPSDEActionName.indexOf("CREATE") != -1) {
                        psDESADetail.setREQUESTMETHOD("POST");
                    } else if (strPSDEActionName.indexOf("UPDATE") != -1) {
                        psDESADetail.setREQUESTMETHOD("PUT");
                    } else if (strPSDEActionName.indexOf("GET") != -1) {
                        psDESADetail.setREQUESTMETHOD("GET");
                    } else if (strPSDEActionName.indexOf("REMOVE") != -1) {
                        psDESADetail.setREQUESTMETHOD("DELETE");
                    } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysServiceAPI().getDefaultDEActionReqMethod())) {
                        psDESADetail.setREQUESTMETHOD(this.getPSSysServiceAPI().getDefaultDEActionReqMethod());
                    } else {
                        psDESADetail.setREQUESTMETHOD("POST");
                    }
                }
                psDESADetail.setPSDESERVICEAPIID(iPSDEServiceAPI.getId());
                psDESADetail.setMETHODTAG(SA.SRFramework.Utility.StringHelper.Format((String)"DEACTION__%1$s", (Object)iPSDEAction.getName()).toUpperCase());
                iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
                iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), iPSDEServiceAPI, this, psDESADetail);
                this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod);
                this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getId(), iPSDEServiceAPIMethod);
            }
        }
        if (this.isEnableDEDataSet()) {
            Iterator<IPSDEDataSet> psDEDataSets = iPSDEServiceAPI.getPSDataEntity().getAllPSDEDataSets();
            while (psDEDataSets.hasNext()) {
                IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
                if (!iPSDEDataSet.isEnableBackend() || !iPSDEDataSet.isPubServiceDefault()) continue;
                strUniqueTag = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s__FETCH__%2$s", (Object)iPSDEServiceAPI.getCodeName(), (Object)iPSDEDataSet.getName()).toUpperCase();
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
                    psDESADetail.setPSDESERVICEAPIID(iPSDEServiceAPI.getId());
                    psDESADetail.setMETHODTAG(SA.SRFramework.Utility.StringHelper.Format((String)"FETCH__%1$s", (Object)iPSDEDataSet.getName()).toUpperCase());
                    iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
                    iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), iPSDEServiceAPI, this, psDESADetail);
                    this.psDEServiceAPIMethodList.add(iPSDEServiceAPIMethod);
                    this.psDEServiceAPIMethodMap.put(iPSDEServiceAPIMethod.getId(), iPSDEServiceAPIMethod);
                }
                if (!iPSDEServiceAPI.isEnableTempData() || !iPSDEDataSet.isEnableTempData() || this.psDEServiceAPIMethodMap.containsKey(strUniqueTag = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s__FETCHTEMP__%2$s", (Object)iPSDEServiceAPI.getCodeName(), (Object)iPSDEDataSet.getName()).toUpperCase())) continue;
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
                    psDESADetail.setCODENAME("FetchTemp" + PSModelCodeNameUtils.capitalize(iPSDEDataSet.getCodeName()));
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
                psDESADetail.setPSDESERVICEAPIID(iPSDEServiceAPI.getId());
                psDESADetail.setMETHODTAG(SA.SRFramework.Utility.StringHelper.Format((String)"FETCHTEMP__%1$s", (Object)iPSDEDataSet.getName()).toUpperCase());
                iPSDEServiceAPIMethod = new PSDEServiceAPIMethodImpl();
                iPSDEServiceAPIMethod.init(this.getDAGlobalHelper(), iPSDEServiceAPI, this, psDESADetail);
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

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u5bf9\u8c61")
    public IPSSysServiceAPI getPSSysServiceAPI() {
        return this.iPSSysServiceAPI;
    }

    protected void setPSSysServiceAPI(IPSSysServiceAPI iPSSysServiceAPI) {
        this.iPSSysServiceAPI = iPSSysServiceAPI;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSysServiceAPI.getPSSysModelInstId();
    }

    @Override
    public String getPPSDEServiceAPIId() {
        return this.psDEServiceAPIRS.getPPSDESERVICEAPIID();
    }

    @Override
    public String getCPSDEServiceAPIId() {
        return this.psDEServiceAPIRS.getCPSDESERVICEAPIID();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u63a5\u53e3\u5bf9\u8c61", dumpref=true, from="IPSSysServiceAPI", group="\u57fa\u672c", order=126, fields={"PPSDESERVICEAPIID"})
    public IPSDEServiceAPI getMajorPSDEServiceAPI() throws Exception {
        return this.getPSSysServiceAPI().getPSDEServiceAPI(this.getPPSDEServiceAPIId(), false);
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u63a5\u53e3\u5bf9\u8c61", dumpref=true, from="IPSSysServiceAPI", group="\u57fa\u672c", order=127, fields={"CPSDESERVICEAPIID"})
    public IPSDEServiceAPI getMinorPSDEServiceAPI() throws Exception {
        return this.getPSSysServiceAPI().getPSDEServiceAPI(this.getCPSDEServiceAPIId(), false);
    }

    @Override
    public String getModelType() {
        return "PSDESARS";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysServiceAPI().getPSSystem());
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysServiceAPI().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getModelName() {
        try {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s-%2$s", (Object)this.getMajorPSDEServiceAPI().getModelName(), (Object)this.getMinorPSDEServiceAPI().getModelName());
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return super.getModelName();
        }
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u9879", fields={"CHILDFILTER"})
    public String getParentFilter() {
        return this.strParentFilter;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u7c7b\u578b\u8fc7\u6ee4\u9879", fields={"TYPEFILTER"})
    public String getParentTypeFilter() {
        return this.strParentTypeFilter;
    }

    @Override
    @PSModelRTMeta(description="1:N\u5173\u7cfb\u5bf9\u8c61")
    public IPSDER1N getPSDER1N() {
        return this.pValuePSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5bf9\u8c61", dumpref=true, fields={"PSDERID"})
    public IPSDERBase getPSDER() {
        return this.pValuePSDERBase;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u6570\u636e\u6807\u8bc6\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="getMinorPSDEServiceAPIMust().getPSDataEntityMust()")
    public IPSDEField getParentIdPSDEField() {
        try {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getParentFilter())) {
                return this.getMinorPSDEServiceAPI().getPSDataEntity().getPSDEField(this.getParentFilter(), true);
            }
            if (this.getPSDER1N() != null) {
                return this.getPSDER1N().getPSPickupDEField();
            }
            if (this.getPSDER() != null && this.getPSDER() instanceof IPSDERCustom) {
                return ((IPSDERCustom)this.getPSDER()).getPickupPSDEField();
            }
            if (this.getMinorPSDEServiceAPI().getPSDataEntity().getDEType() == 4) {
                return this.getMinorPSDEServiceAPI().getPSDataEntity().getPSDEFieldByPDT("PARENTID", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u7236\u6570\u636e\u7c7b\u578b\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="getMinorPSDEServiceAPIMust().getPSDataEntityMust()")
    public IPSDEField getParentTypePSDEField() {
        try {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getParentTypeFilter())) {
                return this.getMinorPSDEServiceAPI().getPSDataEntity().getPSDEField(this.getParentTypeFilter(), true);
            }
            if (this.getMinorPSDEServiceAPI().getPSDataEntity().getDEType() == 4) {
                return this.getMinorPSDEServiceAPI().getPSDataEntity().getPSDEFieldByPDT("PARENTTYPE", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        try {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = Inflector.getInstance().pluralize((Object)this.getMinorPSDEServiceAPI().getCodeName());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psDEServiceAPIRS.getCODENAME2();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5b9e\u4f53\u884c\u4e3a", dump=false)
    public boolean isEnableDEAction() {
        return this.bEnableDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7b80\u5355\u67e5\u8be2", dump=false)
    public boolean isEnableSelect() {
        return this.bEnableSelect && !this.getPSSysServiceAPI().isEnableAPIModelEx();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u96c6\u5408", dump=false)
    public boolean isEnableDEDataSet() {
        return this.bEnableDEDataSet;
    }

    @Override
    public boolean testDataRSMode(int nDataRSMode) {
        return (this.getDataRSMode() & nDataRSMode) == nDataRSMode;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5173\u7cfb\u6a21\u5f0f", codelist="DESADataRSMode", dump=false)
    public int getDataRSMode() {
        return this.nDataRSMode;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u5173\u7cfb\u6a21\u5f0f", codelist="DESAActionRSMode", dump=false)
    public int getActionRSMode() {
        return this.nActionRSMode;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5efa\u7acb\u5173\u8054\u8f93\u51fa", dump=false)
    public boolean isEnableCreateDataRS() {
        return this.testDataRSMode(IPSDEServiceAPIRS.DATARSMODE_CREATE);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u66f4\u65b0\u5173\u8054\u8f93\u51fa", dump=false)
    public boolean isEnableUpdateDataRS() {
        return this.testDataRSMode(IPSDEServiceAPIRS.DATARSMODE_UPDATE);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u83b7\u53d6\u5173\u8054\u8f93\u51fa", dump=false)
    public boolean isEnableGetDataRS() {
        return this.testDataRSMode(IPSDEServiceAPIRS.DATARSMODE_GET);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u67e5\u8be2\u5173\u8054\u8f93\u51fa", dump=false)
    public boolean isEnableSelectDataRS() {
        return this.testDataRSMode(IPSDEServiceAPIRS.DATARSMODE_SELECT);
    }

    @Override
    public int getTempDataOrder() {
        if (this.getPSDER1N() != null) {
            return this.getPSDER1N().getTempDataOrder();
        }
        return -1;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5b9e\u4f53\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u65b9\u5f0f", codelist="DEDataAccCtrlMode", dump=false)
    public int getDataAccCtrlMode() throws Exception {
        if (this.nDataAccCtrlMode == -1) {
            return this.getMinorPSDEServiceAPI().getDataAccCtrlMode();
        }
        return this.nDataAccCtrlMode;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u65b9\u6cd5\u96c6\u5408", child=true)
    public Iterator<IPSDEServiceAPIMethod> getPSDEServiceAPIMethods() throws Exception {
        return this.psDEServiceAPIMethodList.iterator();
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
        throw PSDEServiceAPIException.create(this.getMinorPSDEServiceAPI(), 20020, (Object)strPSDEServiceAPIMethodId);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u7ec4\u6a21\u5f0f", ignoredumpvalues="true")
    public boolean isArray() {
        return this.bArray;
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
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysServiceAPI();
    }

    @Override
    public String getModelRefId() {
        return this.getName();
    }
}

