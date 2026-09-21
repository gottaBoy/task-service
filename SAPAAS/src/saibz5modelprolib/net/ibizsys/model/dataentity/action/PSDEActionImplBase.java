/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.action.IPSDEActionLogic
 *  net.ibizsys.model.dataentity.action.IPSDEActionParam
 *  net.ibizsys.model.service.IPSDEActionRESTfulAPI
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDEActionCaller
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.action.IPSDEActionLogic;
import net.ibizsys.model.dataentity.action.IPSDEActionParam;
import net.ibizsys.model.dataentity.action.IPSDEActionRuntime;
import net.ibizsys.model.dataentity.action.PSDEActionLogicImpl;
import net.ibizsys.model.dataentity.action.PSDEActionParamImpl;
import net.ibizsys.model.entity.PSDEAction;
import net.ibizsys.model.entity.PSDEActionLogic;
import net.ibizsys.model.entity.PSDEActionParam;
import net.ibizsys.model.service.IPSDEActionRESTfulAPI;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEActionCaller;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEActionImplBase
extends PSDataEntityObjectImpl
implements IPSDEActionRuntime,
IPSDEActionRESTfulAPI {
    private static final Log log = LogFactory.getLog(PSDEActionImplBase.class);
    private static HashMap<String, String> internalServiceActionMap = new HashMap();
    protected PSDEAction psDEAction = null;
    private String strCallerObject = "";
    private int nTimeOut = -1;
    private String strCodeName = "";
    private HashMap<String, ArrayList<IPSDEActionLogic>> psDEActionLogicMap = new HashMap();
    private ArrayList<IPSDEActionLogic> psDEActionLogicList = new ArrayList();
    private ArrayList<IPSDEActionParam> psDEActionParamList = new ArrayList();
    private boolean bGenerateTestUnit = false;
    private boolean bPubFlag = true;
    private String strRequestPath = null;
    private String strRequestMethod = null;
    private String strRequestParamType = null;
    private String strRequestField = null;
    private int nParamMode = 1;
    private boolean bCustomParam = false;

    static {
        internalServiceActionMap.put("CREATE", "");
        internalServiceActionMap.put("GET", "");
        internalServiceActionMap.put("UPDATE", "");
        internalServiceActionMap.put("REMOVE", "");
    }

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, PSDEAction psDEAction) throws Exception {
        try {
            String strPSDEActionName;
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEAction = psDEAction;
            this.setId(this.psDEAction.getPSDEACTIONID());
            this.setName(this.psDEAction.getPSDEACTIONNAME());
            this.setPSObjectData(this.psDEAction);
            if (!this.psDEAction.isCALLTIMEOUTNull()) {
                this.nTimeOut = this.psDEAction.getCALLTIMEOUT();
            }
            this.setCallerObject(this.psDEAction.getCALLEROBJ());
            this.strCodeName = this.psDEAction.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psDEAction.getPSDEACTIONNAME().toLowerCase();
            }
            if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (internalServiceActionMap.containsKey(this.getName().toUpperCase())) {
                this.bGenerateTestUnit = true;
                if (!this.psDEAction.isTESTCASEFLAGNull()) {
                    this.bGenerateTestUnit = this.psDEAction.getTESTCASEFLAG();
                }
            }
            if (!this.psDEAction.isPUBMODENull()) {
                this.bPubFlag = this.psDEAction.getPUBMODE();
            } else if (this.getPSDataEntity().getStorageMode() == 4) {
                this.bPubFlag = true;
            }
            if (!this.psDEAction.isPARAMTYPENull()) {
                this.nParamMode = this.psDEAction.getPARAMTYPE();
                this.bCustomParam = true;
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEAction.getREQUESTPATH())) {
                this.strRequestPath = this.psDEAction.getREQUESTPATH();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEAction.getREQUESTMETHOD())) {
                this.strRequestMethod = this.psDEAction.getREQUESTMETHOD();
            }
            this.strRequestParamType = !StringHelper.isNullOrEmpty((String)this.psDEAction.getREQUESTPARAMTYPE()) ? this.psDEAction.getREQUESTPARAMTYPE() : ((strPSDEActionName = this.getName().toUpperCase()).indexOf("CREATE") != -1 ? "ENTITY" : (strPSDEActionName.indexOf("UPDATE") != -1 ? "ENTITY" : (strPSDEActionName.indexOf("GET") != -1 ? (StringHelper.compare((String)strPSDEActionName, (String)"GETDRAFT", (boolean)false) == 0 || StringHelper.compare((String)strPSDEActionName, (String)"GETDRAFTTEMP", (boolean)false) == 0 ? "NONE" : "FIELD") : (strPSDEActionName.indexOf("REMOVE") != -1 ? "FIELD" : "ENTITY"))));
            if (StringHelper.compare((String)this.getRequestParamType(), (String)"FIELD", (boolean)false) == 0) {
                if (!StringHelper.isNullOrEmpty((String)this.psDEAction.getREQUESTFIELD())) {
                    this.strRequestField = this.psDEAction.getREQUESTFIELD();
                } else if (this.getPSDataEntity().getKeyPSDEField() != null) {
                    this.strRequestField = this.getPSDataEntity().getKeyPSDEField().getName();
                }
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!StringHelper.isNullOrEmpty((String)PSDEActionImplBase.this.getModelType()) && !StringHelper.isNullOrEmpty((String)PSDEActionImplBase.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSDEActionImplBase.this.getModelType(), (Object)PSDEActionImplBase.this.getId())) {
                            throw new Exception(StringHelper.format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        PSDEActionImplBase.this.onInit();
                        ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEActionImplBase.this.getModelType(), (Object)PSDEActionImplBase.this.getId());
                    }
                }
            });
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.preparePSDEActionLogics();
        this.preparePSDEActionParams();
    }

    protected void preparePSDEActionLogics() throws Exception {
        this.psDEActionLogicMap.clear();
        this.psDEActionLogicList.clear();
        Vector<PSDEActionLogic> psDEActionLogicList = new Vector<PSDEActionLogic>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEActionLogics(this.getId(), psDEActionLogicList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u64cd\u4f5c\u9644\u52a0\u903b\u8f91\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEActionLogic psDEActionLogic : psDEActionLogicList) {
            PSDEActionLogicImpl iPSDEActionLogic = new PSDEActionLogicImpl();
            iPSDEActionLogic.init(this.getPSModelStorageContext(), this, psDEActionLogic);
            ArrayList<Object> attachList = this.psDEActionLogicMap.get(iPSDEActionLogic.getAttachMode());
            if (attachList == null) {
                attachList = new ArrayList();
                this.psDEActionLogicMap.put(iPSDEActionLogic.getAttachMode(), attachList);
            }
            attachList.add(iPSDEActionLogic);
            this.psDEActionLogicList.add(iPSDEActionLogic);
        }
    }

    protected void preparePSDEActionParams() throws Exception {
        Object iPSDEActionParam;
        this.psDEActionParamList.clear();
        Vector<PSDEActionParam> psDEActionParamList = new Vector<PSDEActionParam>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEActionParams(this.getId(), psDEActionParamList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEActionParam psDEActionParam : psDEActionParamList) {
            iPSDEActionParam = new PSDEActionParamImpl();
            ((PSDEActionParamImpl)iPSDEActionParam).init(this.getPSModelStorageContext(), this, psDEActionParam);
            this.psDEActionParamList.add((IPSDEActionParam)iPSDEActionParam);
        }
        if (this.getParamMode() == 2) {
            boolean bKeyField = false;
            for (IPSDEActionParam iPSDEActionParam2 : this.psDEActionParamList) {
                if (iPSDEActionParam2.getPSDEField() == null || !iPSDEActionParam2.getPSDEField().isKeyDEField()) continue;
                bKeyField = true;
                break;
            }
            if (!bKeyField) {
                PSDEActionParam psDEActionParam = new PSDEActionParam();
                psDEActionParam.setORDERVALUE(0);
                psDEActionParam.setPSDEACTIONID(this.getId());
                psDEActionParam.setPSDEACTIONNAME(this.getName());
                psDEActionParam.setPSDEACTIONPARAMID(this.getPSDataEntity().getKeyPSDEField().getName());
                psDEActionParam.setPSDEACTIONPARAMNAME(this.getPSDataEntity().getKeyPSDEField().getName());
                psDEActionParam.setPARAMDESC(this.getPSDataEntity().getKeyPSDEField().getLogicName());
                psDEActionParam.setVALUETYPE("INPUTVALUE");
                iPSDEActionParam = new PSDEActionParamImpl();
                ((PSDEActionParamImpl)iPSDEActionParam).init(this.getPSModelStorageContext(), this, psDEActionParam);
                this.psDEActionParamList.add(0, (IPSDEActionParam)iPSDEActionParam);
            }
        }
    }

    @PSModelRTMeta(description="\u884c\u4e3a\u7c7b\u578b", codelist="DEActionType2")
    public String getActionType() {
        return this.psDEAction.getACTIONTYPE();
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    public IDEActionCaller getDEActionCaller() throws Exception {
        return null;
    }

    public void releaseDEActionCaller(IDEActionCaller iDEActionCaller) {
    }

    public String getCallerObject() {
        return this.strCallerObject;
    }

    protected void setCallerObject(String strCallerObject) {
        this.strCallerObject = strCallerObject;
    }

    public int getTimeOut() {
        return this.nTimeOut;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.psDEAction.getLOGICNAME();
    }

    public Iterator<IPSDEActionLogic> getPSDEActionLogics(String strAttachMode) {
        ArrayList<IPSDEActionLogic> attachList = this.psDEActionLogicMap.get(strAttachMode);
        if (attachList == null) {
            return null;
        }
        return attachList.iterator();
    }

    @PSModelRTMeta(description="\u884c\u4e3a\u9644\u52a0\u903b\u8f91\u96c6\u5408")
    public Iterator<IPSDEActionLogic> getPSDEActionLogics() {
        if (this.psDEActionLogicList.size() == 0) {
            return null;
        }
        return this.psDEActionLogicList.iterator();
    }

    @PSModelRTMeta(description="\u884c\u4e3a\u53c2\u6570\u96c6\u5408")
    public Iterator<IPSDEActionParam> getPSDEActionParams() {
        if (this.psDEActionParamList.size() == 0) {
            return null;
        }
        return this.psDEActionParamList.iterator();
    }

    @PSModelRTMeta(description="\u662f\u5426\u4ea7\u751f\u6d4b\u8bd5\u5355\u5143")
    public boolean isGenerateTestUnit() {
        return this.bGenerateTestUnit;
    }

    public String getRequestPath() {
        return this.strRequestPath;
    }

    public String getRequestMethod() {
        return this.strRequestMethod;
    }

    @PSModelRTMeta(description="\u662f\u5426\u9ed8\u8ba4\u53d1\u5e03\u670d\u52a1")
    public boolean isPubServiceDefault() {
        return this.bPubFlag;
    }

    public String getRequestParamType() {
        return this.strRequestParamType;
    }

    public String getRequestField() {
        return this.strRequestField;
    }

    @PSModelRTMeta(description="\u884c\u4e3a\u53c2\u6570\u6a21\u5f0f", codelist="DEActionParamMode")
    public int getParamMode() {
        return this.nParamMode;
    }

    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u884c\u4e3a\u53c2\u6570")
    public boolean isCustomParam() {
        return this.bCustomParam;
    }
}

