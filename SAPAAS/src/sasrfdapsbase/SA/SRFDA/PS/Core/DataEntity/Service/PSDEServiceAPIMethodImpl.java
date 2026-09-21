/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTO;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethodInput;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethodReturn;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIMethodInputImpl;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIMethodReturnImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Service.IPSDEActionRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSDESADetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEServiceAPIMethodImpl
extends PSObjectImpl
implements IPSDEServiceAPIMethod,
IPSRESTfulAPI,
IPSDEActionRESTfulAPI {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIMethodImpl.class);
    private IPSDEServiceAPI iPSDEServiceAPI = null;
    private PSDESADetail psDESADetail = null;
    private String strMethodType = null;
    private IPSDEAction iPSDEAction = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private String strCodeName = null;
    private String strRequestMethod = null;
    private String strUniqueTag = null;
    private String strRequestPath = null;
    private String strRequestParamType = null;
    private String strRequestField = null;
    private String strReturnValueType = null;
    private int nTempDataMode = 0;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private IPSDEServiceAPIRS iPSDEServiceAPIRS = null;
    private String strParentKeyMode = "DEFAULT";
    private IPSDEMethod iPSDEMethod = null;
    private IPSDEServiceAPIMethodInput iPSDEServiceAPIMethodInput = null;
    private IPSDEServiceAPIMethodReturn iPSDEServiceAPIMethodReturn = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEServiceAPI iPSDEServiceAPI, IPSDEServiceAPIRS iPSDEServiceAPIRS, PSDESADetail psDESADetail) throws Exception {
        this.iPSDEServiceAPIRS = iPSDEServiceAPIRS;
        this.init(iDAGlobalHelper, iPSDEServiceAPI, psDESADetail);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEServiceAPI iPSDEServiceAPI, PSDESADetail psDESADetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEServiceAPI(iPSDEServiceAPI);
            this.psDESADetail = psDESADetail;
            this.setId(this.psDESADetail.getPSDESADETAILID());
            this.setName(this.psDESADetail.getPSDESADETAILNAME());
            this.setPSObjectData(this.psDESADetail);
            this.strReturnValueType = psDESADetail.getRETVALTYPE();
            this.strMethodType = psDESADetail.getDETAILTYPE();
            this.strRequestMethod = this.psDESADetail.getREQUESTMETHOD();
            if (!StringHelper.isNullOrEmpty((String)this.psDESADetail.getCODENAME())) {
                this.strCodeName = this.psDESADetail.getCODENAME();
            }
            String strOriginCodeName = this.strCodeName;
            if (this.isAutoModel()) {
                this.strCodeName = this.getPSSysServiceAPI().getAPICodeName(null, this.strCodeName, null);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDESADetail.getPSDEOPPRIVID())) {
                this.iPSDEOPPriv = this.getPSDEServiceAPI().getPSDataEntity().getPSDEOPPriv(this.psDESADetail.getPSDEOPPRIVID());
            }
            if (StringHelper.compare((String)this.getMethodType(), (String)"DEACTION", (boolean)true) == 0) {
                String strPSDEActionName;
                if (!StringHelper.isNullOrEmpty((String)psDESADetail.getREQUESTPARAMTYPE())) {
                    this.strRequestParamType = psDESADetail.getREQUESTPARAMTYPE();
                }
                if (!StringHelper.isNullOrEmpty((String)psDESADetail.getREQUESTFIELD())) {
                    this.strRequestField = psDESADetail.getREQUESTFIELD();
                }
                if (!StringHelper.isNullOrEmpty((String)this.psDESADetail.getPSDEACTIONID())) {
                    this.iPSDEAction = this.getPSDEServiceAPI().getPSDataEntity().getPSDEAction(this.psDESADetail.getPSDEACTIONID());
                    this.nTempDataMode = this.getPSDEAction().getTempDataMode();
                    if (StringHelper.isNullOrEmpty((String)this.strRequestParamType)) {
                        this.strRequestParamType = ((IPSDEActionRESTfulAPI)this.iPSDEAction.getPSRESTfulAPI()).getRequestParamType();
                    }
                    if (StringHelper.isNullOrEmpty((String)this.strRequestField)) {
                        this.strRequestField = ((IPSDEActionRESTfulAPI)this.iPSDEAction.getPSRESTfulAPI()).getRequestField();
                    }
                    if (StringHelper.isNullOrEmpty((String)this.getRequestMethod())) {
                        String strPSDEActionName2;
                        String strActionMode;
                        this.strRequestMethod = !StringHelper.isNullOrEmpty((String)this.iPSDEAction.getPSRESTfulAPI().getRequestMethod()) ? this.iPSDEAction.getPSRESTfulAPI().getRequestMethod() : ("CREATE".equals(strActionMode = this.iPSDEAction.getActionMode()) ? this.getPSDEServiceAPI().getPSSysServiceAPI().getCreateReqMethod("POST") : ("UPDATE".equals(strActionMode) ? this.getPSDEServiceAPI().getPSSysServiceAPI().getUpdateReqMethod("PUT") : ("READ".equals(strActionMode) ? this.getPSDEServiceAPI().getPSSysServiceAPI().getGetReqMethod("GET") : ("DELETE".equals(strActionMode) ? this.getPSDEServiceAPI().getPSSysServiceAPI().getDeleteReqMethod("DELETE") : ((strPSDEActionName2 = this.iPSDEAction.getName().toUpperCase()).indexOf("CREATE") != -1 ? this.getPSDEServiceAPI().getPSSysServiceAPI().getCreateReqMethod("POST") : (strPSDEActionName2.indexOf("UPDATE") != -1 ? this.getPSDEServiceAPI().getPSSysServiceAPI().getUpdateReqMethod("PUT") : (strPSDEActionName2.indexOf("GET") != -1 ? this.getPSDEServiceAPI().getPSSysServiceAPI().getGetReqMethod("GET") : (strPSDEActionName2.indexOf("REMOVE") != -1 ? this.getPSDEServiceAPI().getPSSysServiceAPI().getDeleteReqMethod("DELETE") : (!StringHelper.isNullOrEmpty((String)this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultDEActionReqMethod()) ? this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultDEActionReqMethod() : "POST")))))))));
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)strOriginCodeName) && this.getPSDEServiceAPI().getPSSysServiceAPI().isResetDefaultActionCodeName() && ("CREATE".equals(strPSDEActionName = this.iPSDEAction.getName().toUpperCase()) || "UPDATE".equals(strPSDEActionName) || "GET".equals(strPSDEActionName) || "REMOVE".equals(strPSDEActionName)) && strOriginCodeName.equalsIgnoreCase(this.iPSDEAction.getServiceCodeName())) {
                    this.strCodeName = "";
                }
                if (this.getPSDEOPPriv() == null && this.getPSDEAction() != null) {
                    this.iPSDEOPPriv = this.getPSDEAction().getPSDEOPPriv();
                }
                if (this.getPSDEOPPriv() == null) {
                    this.iPSDEOPPriv = this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
                }
            }
            if (StringHelper.compare((String)this.getMethodType(), (String)"FETCH", (boolean)true) == 0 || StringHelper.compare((String)this.getMethodType(), (String)"FETCHTEMP", (boolean)true) == 0) {
                if (!StringHelper.isNullOrEmpty((String)this.psDESADetail.getPSDEDSID())) {
                    this.iPSDEDataSet = this.getPSDEServiceAPI().getPSDataEntity().getPSDEDataSet(this.psDESADetail.getPSDEDSID());
                    if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                        this.strCodeName = StringHelper.compare((String)this.getMethodType(), (String)"FETCH", (boolean)true) == 0 ? this.getPSSysServiceAPI().getAPICodeName(null, this.iPSDEDataSet.getServiceCodeName(), null) : this.getPSSysServiceAPI().getAPICodeName("FetchTemp", this.iPSDEDataSet.getCodeName(), null);
                    }
                    if (StringHelper.isNullOrEmpty((String)this.getRequestMethod())) {
                        this.strRequestMethod = !StringHelper.isNullOrEmpty((String)this.iPSDEDataSet.getPSRESTfulAPI().getRequestMethod()) ? this.iPSDEDataSet.getPSRESTfulAPI().getRequestMethod() : (!StringHelper.isNullOrEmpty((String)this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultDEDataSetReqMethod()) ? this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultDEDataSetReqMethod() : "POST");
                    }
                    if (StringHelper.isNullOrEmpty((String)this.getRequestParamType())) {
                        if (StringHelper.compare((String)this.getRequestMethod(), (String)"GET", (boolean)true) == 0) {
                            this.strRequestParamType = "URIPARAM";
                        } else if (StringHelper.compare((String)this.getRequestMethod(), (String)"POST", (boolean)true) == 0) {
                            this.strRequestParamType = "ENTITY";
                        }
                    }
                }
                if (StringHelper.compare((String)this.getMethodType(), (String)"FETCHTEMP", (boolean)true) == 0) {
                    this.nTempDataMode = 2;
                }
                if (this.getPSDEOPPriv() == null && this.getPSDEDataSet() != null) {
                    this.iPSDEOPPriv = this.getPSDEDataSet().getPSDEOPPriv();
                }
                if (this.getPSDEOPPriv() == null) {
                    this.iPSDEOPPriv = this.getPSDEServiceAPI().getPSDataEntity().getPSDEOPPriv("READ", true);
                }
            }
            if (StringHelper.compare((String)this.getMethodType(), (String)"SELECT", (boolean)true) == 0 || StringHelper.compare((String)this.getMethodType(), (String)"SELECTTEMP", (boolean)true) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                    this.strCodeName = StringHelper.compare((String)this.getMethodType(), (String)"SELECT", (boolean)true) == 0 ? this.getPSSysServiceAPI().getAPICodeName(null, "Select", null) : this.getPSSysServiceAPI().getAPICodeName(null, "SelectTemp", null);
                }
                if (StringHelper.isNullOrEmpty((String)this.getRequestMethod())) {
                    this.strRequestMethod = !StringHelper.isNullOrEmpty((String)this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultSelectReqMethod()) ? this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultSelectReqMethod() : "POST";
                }
                if (StringHelper.isNullOrEmpty((String)this.getRequestParamType())) {
                    if (StringHelper.compare((String)this.getRequestMethod(), (String)"GET", (boolean)true) == 0) {
                        this.strRequestParamType = "URIPARAM";
                    } else if (StringHelper.compare((String)this.getRequestMethod(), (String)"POST", (boolean)true) == 0) {
                        this.strRequestParamType = "ENTITY";
                    }
                }
                if (StringHelper.compare((String)this.getMethodType(), (String)"SELECTTEMP", (boolean)true) == 0) {
                    this.nTempDataMode = 2;
                }
                if (this.getPSDEOPPriv() == null) {
                    this.iPSDEOPPriv = this.getPSDEServiceAPI().getPSDataEntity().getPSDEOPPriv("READ", true);
                }
            }
            this.strUniqueTag = StringHelper.format((String)"%1$s__%2$s", (Object)iPSDEServiceAPI.getCodeName(), (Object)psDESADetail.getMETHODTAG()).toUpperCase();
            if (!StringHelper.isNullOrEmpty((String)this.getCodeName()) && !this.isNoServiceCodeName()) {
                this.strRequestPath = StringHelper.isNullOrEmpty((String)this.getPSSysServiceAPI().getAPICodeNameMode()) || "NONE".equals(this.getPSSysServiceAPI().getAPICodeNameMode()) ? StringHelper.format((String)"/%1$s", (Object)this.getCodeName()).toLowerCase() : StringHelper.format((String)"/%1$s", (Object)this.getCodeName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDESADetail.getPARENTKEYMODE())) {
                this.strParentKeyMode = this.psDESADetail.getPARENTKEYMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDESADetail.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSDEServiceAPI().getPSSysServiceAPI().getPSSystem().getPSSysSFPlugin(this.psDESADetail.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSDEServiceAPI().getPSSysServiceAPI().getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSDEServiceAPI().getPSSysServiceAPI().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                }
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
        if (this.getPSSysServiceAPI().isEnableServiceAPIDTO()) {
            this.iPSDEServiceAPIMethodInput = this.createPSDEServiceAPIMethodInput();
            this.iPSDEServiceAPIMethodReturn = this.createPSDEServiceAPIMethodReturn();
        }
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getPSSysServiceAPI().isEnableServiceAPIDTO()) {
            if (this.getPSDEServiceAPIMethodInput() != null) {
                this.getPSDEServiceAPIMethodInput().check();
            }
            if (this.getPSDEServiceAPIMethodReturn() != null) {
                this.getPSDEServiceAPIMethodReturn().check();
            }
        }
        return super.onCheck();
    }

    protected IPSDEServiceAPIMethodInput createPSDEServiceAPIMethodInput() throws Exception {
        PSDEServiceAPIMethodInputImpl psDEServiceAPIMethodInputImpl = new PSDEServiceAPIMethodInputImpl();
        psDEServiceAPIMethodInputImpl.init(this.getDAGlobalHelper(), this);
        return psDEServiceAPIMethodInputImpl;
    }

    protected IPSDEServiceAPIMethodReturn createPSDEServiceAPIMethodReturn() throws Exception {
        PSDEServiceAPIMethodReturnImpl psDEServiceAPIMethodReturnImpl = new PSDEServiceAPIMethodReturnImpl();
        psDEServiceAPIMethodReturnImpl.init(this.getDAGlobalHelper(), this);
        return psDEServiceAPIMethodReturnImpl;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3")
    public IPSDEServiceAPI getPSDEServiceAPI() {
        return this.iPSDEServiceAPI;
    }

    protected void setPSDEServiceAPI(IPSDEServiceAPI iPSDEServiceAPI) {
        this.iPSDEServiceAPI = iPSDEServiceAPI;
    }

    public IPSSysServiceAPI getPSSysServiceAPI() throws Exception {
        if (this.getPSDEServiceAPI() == null) {
            return null;
        }
        return this.getPSDEServiceAPI().getPSSysServiceAPI();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEServiceAPI.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u7c7b\u578b", codelist="DESADetailType", group="\u57fa\u672c", order=125, fields={"DETAILTYPE"})
    public String getMethodType() {
        return this.strMethodType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a", hideempty=true, dumpref=true, from="IPSDEServiceAPI", from_method="getPSDataEntityMust().getPSDEAction", fields={"PSDEACTIONID"})
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5408", hideempty=true, dumpref=true, from="IPSDEServiceAPI", from_method="getPSDataEntityMust().getPSDEDataSet", fields={"PSDEDSID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u65b9\u5f0f", codelist="RequestMethod", fields={"REQUESTMETHOD"})
    public String getRequestMethod() {
        return this.strRequestMethod;
    }

    @PSModelRTMeta(description="\u884c\u4e3a\u7c7b\u578b", dump=false)
    public String getActionType() {
        return this.getMethodType();
    }

    @PSModelRTMeta(description="\u63a5\u53e3\u6807\u8bb0", ignorepf=true, ignorert=3, dynamodelmode=8)
    public String getUniqueTag() {
        return this.strUniqueTag;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u8def\u5f84", ignorepf=true, dynamodelmode=8)
    public String getRequestPath() {
        return this.strRequestPath;
    }

    @Override
    public IPSRESTfulAPI getPSRESTfulAPI() {
        return this;
    }

    public String getDEName() {
        return this.getPSDEServiceAPI().getPSDataEntity().getName();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u7c7b\u578b", codelist="ServiceReqParamType", ignorepf=true, dynamodelmode=8)
    public String getRequestParamType() {
        return this.strRequestParamType;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u5c5e\u6027", ignorepf=true, dynamodelmode=8)
    public String getRequestField() {
        return this.strRequestField;
    }

    @Override
    public String getModelType() {
        if (this.getPSDEServiceAPIRS() != null) {
            return "PSDESARSDETAIL";
        }
        return "PSDESADETAIL";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEServiceAPIRS() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEServiceAPIRS().getModelId(), (Object)super.getModelId());
        }
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEServiceAPI().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getModelName() {
        return this.getUniqueTag();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEServiceAPI().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEServiceAPI().getPSDataEntity().getPSSystem());
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSDEServiceAPI().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psDESADetail.getCODENAME2();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u53c2\u6570", hideempty2=true, fields={"DETAILPARAM"})
    public String getMethodParam() {
        return this.psDESADetail.getDETAILPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u53c2\u65702", hideempty2=true, fields={"DETAILPARAM2"})
    public String getMethodParam2() {
        return this.psDESADetail.getDETAILPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7c7b\u578b", codelist="DEActionRetValType", dump=false)
    public String getReturnValueType() {
        return this.strReturnValueType;
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", codelist="TempDataMode", dump=false)
    public int getTempDataMode() {
        return this.nTempDataMode;
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
    @PSModelRTMeta(description="\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6", dump=false)
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @Override
    public IPSDEOPPriv getMapPSDEOPPriv(int nPathIndex) {
        try {
            if (this.getPSDEOPPriv() == null) {
                return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
            }
            if ("DENY".equals(this.getPSDEOPPriv().getName()) || "NONE".equals(this.getPSDEOPPriv().getName())) {
                return this.getPSDEOPPriv();
            }
            if (this.getPSDEServiceAPIRS() == null) {
                return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
            }
            if (this.getPSDEServiceAPIRS().getDataAccCtrlMode() == 1) {
                return this.getPSDEOPPriv();
            }
            Iterator<? extends IPSDEServiceAPIRS> psDEServiceAPIRSs = this.getPSDEServiceAPI().getPSDEServiceAPIRSPath(nPathIndex);
            if (psDEServiceAPIRSs == null) {
                return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
            }
            boolean bContains = false;
            ArrayList<IPSDEServiceAPIRS> list = new ArrayList<IPSDEServiceAPIRS>();
            while (psDEServiceAPIRSs.hasNext()) {
                IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                list.add(0, iPSDEServiceAPIRS);
                if (this.getPSDEServiceAPIRS() != iPSDEServiceAPIRS) continue;
                bContains = true;
                break;
            }
            if (!bContains || list.size() == 0) {
                return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
            }
            String strLastAction = this.getPSDEOPPriv().getName();
            IPSDataEntity lastPSDataEntity = this.getPSDEServiceAPI().getPSDataEntity();
            int i = 0;
            while (i < list.size()) {
                IPSDEServiceAPIRS iPSDEServiceAPIRS = (IPSDEServiceAPIRS)list.get(i);
                if (i != 0 && iPSDEServiceAPIRS.getDataAccCtrlMode() == 1) break;
                Iterator<IPSDEOPPriv> psDEOPPrivs = lastPSDataEntity.getAllPSDEOPPrivs();
                if (psDEOPPrivs == null) {
                    return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
                }
                IPSDEOPPriv mapPSDEOPPriv = null;
                while (psDEOPPrivs.hasNext()) {
                    IPSDEOPPriv iPSDEOPPriv = psDEOPPrivs.next();
                    if (StringHelper.compare((String)iPSDEOPPriv.getName(), (String)strLastAction, (boolean)false) != 0 || iPSDEOPPriv.getMapPSDataEntity() == null || !iPSDEOPPriv.getMapPSDataEntity().getId().equals(iPSDEServiceAPIRS.getMajorPSDEServiceAPI().getPSDataEntity().getId())) continue;
                    mapPSDEOPPriv = iPSDEOPPriv;
                    break;
                }
                if (mapPSDEOPPriv == null) {
                    return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
                }
                strLastAction = mapPSDEOPPriv.getMapPSDEOPPrivName();
                lastPSDataEntity = mapPSDEOPPriv.getMapPSDataEntity();
                ++i;
            }
            if (lastPSDataEntity == null || StringHelper.isNullOrEmpty((String)strLastAction)) {
                return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
            }
            Iterator<IPSDEOPPriv> psDEOPPrivs = lastPSDataEntity.getAllPSDEOPPrivs();
            while (psDEOPPrivs.hasNext()) {
                IPSDEOPPriv iPSDEOPPriv = psDEOPPrivs.next();
                if (StringHelper.compare((String)iPSDEOPPriv.getName(), (String)strLastAction, (boolean)false) != 0 || iPSDEOPPriv.getMapPSDataEntity() != null) continue;
                return iPSDEOPPriv;
            }
            return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u64cd\u4f5c\u6807\u8bc6\u8def\u5f84[0]", hideempty=true, dump=false, ignorepf=true, outputdoc="false")
    public IPSDEOPPriv getMapPSDEOPPrivPath0() {
        return this.getMapPSDEOPPriv(0);
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u64cd\u4f5c\u6807\u8bc6\u8def\u5f84[1]", hideempty=true, dump=false, ignorepf=true, outputdoc="false")
    public IPSDEOPPriv getMapPSDEOPPrivPath1() {
        return this.getMapPSDEOPPriv(1);
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u64cd\u4f5c\u6807\u8bc6\u8def\u5f84[2]", hideempty=true, dump=false, ignorepf=true, outputdoc="false")
    public IPSDEOPPriv getMapPSDEOPPrivPath2() {
        return this.getMapPSDEOPPriv(2);
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u64cd\u4f5c\u6807\u8bc6\u8def\u5f84[3]", hideempty=true, dump=false, ignorepf=true, outputdoc="false")
    public IPSDEOPPriv getMapPSDEOPPrivPath3() {
        return this.getMapPSDEOPPriv(3);
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u64cd\u4f5c\u6807\u8bc6\u8def\u5f84[4]", hideempty=true, dump=false, ignorepf=true, outputdoc="false")
    public IPSDEOPPriv getMapPSDEOPPrivPath4() {
        return this.getMapPSDEOPPriv(4);
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u5173\u7cfb", hideempty=true)
    public IPSDEServiceAPIRS getPSDEServiceAPIRS() {
        return this.iPSDEServiceAPIRS;
    }

    @Override
    public String getPSDEServiceAPIRSId() {
        return this.psDESADetail.getPSDESARSID();
    }

    @Override
    @PSModelRTMeta(description="\u7236\u503c\u5904\u7406\u6a21\u5f0f", codelist="DESAMethodParentKeyMode", ignoredumpvalues="DEFAULT")
    public String getParentKeyMode() {
        return this.strParentKeyMode;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u6267\u884c\u65b9\u6cd5", dump=false)
    public boolean isEnableTestMethod() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getTestActionMode() == 3;
        }
        return false;
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return this.getPSDEServiceAPI().getPSDataEntity();
    }

    @Override
    public int getExtendMode() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5\u5bf9\u8c61", outputdoc="false")
    public IPSDEMethod getPSDEMethod() throws Exception {
        if (this.getTempDataMode() != 0) {
            return null;
        }
        if (this.iPSDEMethod == null) {
            if (this.getPSDEAction() != null) {
                this.iPSDEMethod = this.getPSDataEntity().getPSDEActionMethod(this.getPSDEAction(), true);
            } else if (this.getPSDEDataSet() != null) {
                if (this.getPSDEServiceAPIRS() != null) {
                    if (this.getPSDEServiceAPIRS().getPSDER1N() != null) {
                        this.iPSDEMethod = this.getPSDataEntity().getPSDEDataSetMethod(this.getPSDEDataSet(), this.getPSDEServiceAPIRS().getPSDER1N(), this.getParentKeyMode(), true);
                    }
                } else {
                    this.iPSDEMethod = this.getPSDataEntity().getPSDEDataSetMethod(this.getPSDEDataSet(), true);
                }
            }
        }
        return this.iPSDEMethod;
    }

    @Override
    public IPSDEServiceAPI getInPSDEServiceAPI() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDESADetail.getINPSDESERVICEAPIID())) {
            return null;
        }
        if (this.getPSSysServiceAPI() != null) {
            return this.getPSSysServiceAPI().getPSDEServiceAPI(this.psDESADetail.getINPSDESERVICEAPIID());
        }
        return null;
    }

    @Override
    public IPSDEServiceAPI getOutPSDEServiceAPI() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDESADetail.getOUTPSDESERVICEAPIID())) {
            return null;
        }
        if (this.getPSSysServiceAPI() != null) {
            return this.getPSSysServiceAPI().getPSDEServiceAPI(this.psDESADetail.getOUTPSDESERVICEAPIID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u8f93\u5165\u5bf9\u8c61", hideempty=true, child=true, doctype="item", group="\u903b\u8f91", order=215)
    public IPSDEServiceAPIMethodInput getPSDEServiceAPIMethodInput() {
        return this.iPSDEServiceAPIMethodInput;
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u8fd4\u56de\u5bf9\u8c61", hideempty=true, child=true, doctype="item", group="\u903b\u8f91", order=216)
    public IPSDEServiceAPIMethodReturn getPSDEServiceAPIMethodReturn() {
        return this.iPSDEServiceAPIMethodReturn;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", ignoredumpvalues="false")
    public boolean isNoServiceCodeName() {
        if (!this.psDESADetail.isNOSERVICECODENAMENull()) {
            return this.psDESADetail.getNOSERVICECODENAME();
        }
        return StringHelper.isNullOrEmpty((String)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u6807\u8bc6", hideempty2=true)
    public String getDataAccessAction() {
        if (this.getPSDEOPPriv() == null) {
            return null;
        }
        return this.getPSDEOPPriv().getName();
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u63d0\u4f9b\u8d44\u6e90\u952e\u503c", ignoredumpvalues="false")
    public boolean isNeedResourceKey() {
        if (this.getPSDEAction() != null) {
            if (!this.psDESADetail.isNEEDRESOURCEKEYNull()) {
                return this.psDESADetail.getNEEDRESOURCEKEY();
            }
            if (this.getPSDEAction().isNeedResourceKeyDefined()) {
                return this.iPSDEAction.isNeedResourceKey();
            }
            if ("CREATE".equals(this.getPSDEAction().getActionMode()) || "GETDRAFT".equals(this.getPSDEAction().getActionMode()) || "CHECKKEY".equals(this.getPSDEAction().getActionMode()) || "SAVE".equals(this.getPSDEAction().getActionMode())) {
                return false;
            }
            if ("NONE".equals(this.getPSDEAction().getPSDEActionInput().getType())) {
                return false;
            }
            try {
                if (this.getPSSysServiceAPI().isEnableAPIModelEx() && "DTO".equals(this.getPSDEAction().getPSDEActionInput().getType()) && this.getPSDEAction().getPSDEActionInput().getPSDEMethodDTO() instanceof IPSDEActionInputDTO) {
                    IPSDEActionInputDTO iPSDEActionInputDTO = (IPSDEActionInputDTO)this.getPSDEAction().getPSDEActionInput().getPSDEMethodDTO();
                    return iPSDEActionInputDTO.containsKeyField();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            return true;
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u5b9a\u5411\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5", hideempty=true, dumpref=true, dynamodelmode=4, from="IPSDEServiceAPI", from_method="getPSDataEntityMust().getPSSubSysServiceAPIDEMust().getPSSubSysServiceAPIDEMethod")
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception {
        if (this.getPSDEDataSet() != null) {
            if (this.getPSDEDataSet().getExtendMode() == 0) {
                return this.getPSDEDataSet().getPSSubSysServiceAPIDEMethod();
            }
            return null;
        }
        if (this.getPSDEAction() != null) {
            if (this.getPSDEAction().getPSDEActionLogics() != null) {
                return null;
            }
            if (this.getPSDEAction().getExtendMode() == 0) {
                return this.getPSDEAction().getPSSubSysServiceAPIDEMethod();
            }
            return null;
        }
        return null;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSDEServiceAPIRS() != null) {
            return this.getPSDEServiceAPIRS();
        }
        return this.getPSDEServiceAPI();
    }

    @Override
    protected String onGetRTMOSFileName() {
        if (StringHelper.isNullOrEmpty((String)this.getCodeName())) {
            if (this.getPSDEAction() != null) {
                return this.getPSDEAction().getCodeName();
            }
            if (this.getPSDEDataSet() != null) {
                return this.getPSDEDataSet().getCodeName();
            }
        }
        return super.onGetRTMOSFileName();
    }
}

