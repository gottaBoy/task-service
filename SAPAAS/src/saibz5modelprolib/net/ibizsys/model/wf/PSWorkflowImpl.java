/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.sys.IPSSystemModule
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.entity.PSWorkflow;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.sys.IPSSystemModule;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflowRuntime;
import net.ibizsys.model.wf.PSWFDEGlobalModel;
import net.ibizsys.model.wf.PSWFVersionGlobalModel;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkflowImpl
extends PSSystemObjectImpl
implements IPSWorkflowRuntime {
    private static final Log log = LogFactory.getLog(PSWorkflowImpl.class);
    protected PSWorkflow psWorkflow;
    private String strCodeName = "";
    private PSWFVersionGlobalModel psWFVersionGlobalModel = null;
    private PSWFDEGlobalModel psWFDEGlobalModel = null;
    private IPSCodeList wfStepPSCodeList = null;
    private IPSCodeList entityStatePSCodeList = null;
    private HashMap<String, String> entityWFStateMap = new HashMap();
    private IPSWFVersion lastPSWFVersion = null;
    private String strEntityWFState = "";
    private String strRemindMsgTemplId = null;
    private boolean bValidFlag = true;
    private String strWFEngineCat = "EMBEDDED";
    private String strWFEngineType = "EMBEDDED";
    private boolean bDynamicWorkflow = false;
    private IPSLanguageRes namePSLanguageRes = null;
    private IPSSystemModule iPSSystemModule = null;
    private boolean bUseRemoteEngine = false;
    private int nWFProxyMode = 0;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSWorkflow psWorkflow) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSSystem(iPSSystem);
        this.psWorkflow = psWorkflow;
        this.setId(this.psWorkflow.getPSWORKFLOWID());
        this.setName(this.psWorkflow.getPSWORKFLOWNAME());
        this.setPSObjectData(this.psWorkflow);
        this.strCodeName = this.psWorkflow.getCODENAME();
        if (!this.psWorkflow.isWFPROXYMODENull()) {
            this.nWFProxyMode = this.psWorkflow.getWFPROXYMODE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWorkflow.getWFSTEPCODELISTID())) {
            this.wfStepPSCodeList = iPSSystem.getPSCodeList(this.psWorkflow.getWFSTEPCODELISTID());
        }
        this.entityStatePSCodeList = iPSSystem.getPSCodeList(this.psWorkflow.getSTATECODELISTID());
        if (!StringHelper.isNullOrEmpty((String)this.psWorkflow.getREMINDPSSYSMSGTEMPLID())) {
            this.strRemindMsgTemplId = this.psWorkflow.getREMINDPSSYSMSGTEMPLID();
        }
        if (!this.psWorkflow.isVALIDFLAGNull()) {
            this.bValidFlag = this.psWorkflow.getVALIDFLAG();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWorkflow.getWFENGINETYPE())) {
            this.strWFEngineType = this.psWorkflow.getWFENGINETYPE();
        }
        this.strWFEngineCat = this.strWFEngineType;
        if (!this.psWorkflow.isENABLEDYNASYSNull()) {
            this.bDynamicWorkflow = this.psWorkflow.getENABLEDYNASYS();
        }
        if (!this.psWorkflow.isREMOTEENGINEFLAGNull()) {
            this.bUseRemoteEngine = this.psWorkflow.getREMOTEENGINEFLAG();
        }
        if (StringHelper.compare((String)this.getWFEngineCat(), (String)"ACTIVITI", (boolean)true) == 0 && this.isUseRemoteEngine()) {
            this.strWFEngineType = "ACTIVITI_REMOTE";
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!StringHelper.isNullOrEmpty((String)this.psWorkflow.getNAMEPSLANRESID())) {
            this.namePSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psWorkflow.getNAMEPSLANRESID());
        }
        this.strEntityWFState = this.psWorkflow.getWFSTATEVALUE();
        if (!StringHelper.isNullOrEmpty((String)this.strEntityWFState)) {
            String[] items;
            String[] stringArray = items = this.strEntityWFState.split("[;]");
            int n = items.length;
            int n2 = 0;
            while (n2 < n) {
                String strItem = stringArray[n2];
                if (!StringHelper.isNullOrEmpty((String)strItem)) {
                    this.entityWFStateMap.put(strItem, strItem);
                }
                ++n2;
            }
        }
        this.psWFVersionGlobalModel = new PSWFVersionGlobalModel();
        this.psWFVersionGlobalModel.init(this.getPSModelStorageContext(), this);
        this.psWFDEGlobalModel = new PSWFDEGlobalModel();
        this.psWFDEGlobalModel.init(this.getPSModelStorageContext(), this);
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.getName();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    public IPSWFVersion getPSWFVersion(String strWFVersionId) throws Exception {
        return (IPSWFVersion)this.psWFVersionGlobalModel.findModelHelper(strWFVersionId);
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u7248\u672c\u96c6\u5408")
    public Iterator<IPSWFVersion> getPSWFVersions() throws Exception {
        return this.psWFVersionGlobalModel.getAllModelHelpers();
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u5b9e\u4f53\u96c6\u5408")
    public Iterator<IPSDEWF> getPSWFDEs() throws Exception {
        return this.psWFDEGlobalModel.getAllModelHelpers();
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u6b65\u9aa4\u4ee3\u7801\u8868")
    public IPSCodeList getWFStepPSCodeList() {
        return this.wfStepPSCodeList;
    }

    @PSModelRTMeta(description="\u4e1a\u52a1\u72b6\u6001\u4ee3\u7801\u8868")
    public IPSCodeList getEntityStatePSCodeList() {
        return this.entityStatePSCodeList;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u4e2d\u4e1a\u52a1\u72b6\u6001\u96c6\u5408")
    public Iterator<String> getEntityWFStates() {
        return this.entityWFStateMap.keySet().iterator();
    }

    /*
     * Unable to fully structure code
     */
    @PSModelRTMeta(description="\u6700\u65b0\u6d41\u7a0b\u7248\u672c")
    public IPSWFVersion getLastPSWFVersion() throws Exception {
        if (this.lastPSWFVersion != null) {
            return this.lastPSWFVersion;
        }
        psWFVersions = this.getPSWFVersions();
        if (psWFVersions != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSWFVersion = psWFVersions.next();
            if (this.lastPSWFVersion != null && iPSWFVersion.getWFVersion() <= this.lastPSWFVersion.getWFVersion()) continue;
            this.lastPSWFVersion = iPSWFVersion;
lbl9:
            // 3 sources

            ** while (psWFVersions.hasNext())
        }
lbl10:
        // 1 sources

        return this.lastPSWFVersion;
    }

    public ISystemModel getSystemModel() {
        return null;
    }

    public IEntity createEntity(String strDEName) throws Exception {
        return null;
    }

    public ICodeList getWFStepCodeList() {
        return this.getWFStepPSCodeList();
    }

    public ICodeList getEntityStateCodeList() {
        return this.getEntityStatePSCodeList();
    }

    public IWFVersionModel getLastWFVersionModel() {
        return null;
    }

    public IWFVersionModel getLastWFVersionModel(String strWFMode) throws Exception {
        return null;
    }

    public IWFVersionModel getWFVersionModelByWFVersion(int nVersion) throws Exception {
        return null;
    }

    public boolean isEntityWFState(String strWFState) {
        return this.entityWFStateMap.containsKey(strWFState);
    }

    public IWFService getWFService() {
        return null;
    }

    public String getEntityWFState() {
        return this.strEntityWFState;
    }

    public IPSDEWF getPSDEWF(String strPSDEWFId) throws Exception {
        return (IPSDEWF)this.psWFDEGlobalModel.findModelHelper(strPSDEWFId);
    }

    public String getRemindMsgTemplId() {
        return this.strRemindMsgTemplId;
    }

    @PSModelRTMeta(description="\u662f\u5426\u542f\u7528")
    public boolean isValid() {
        return this.bValidFlag;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u7f16\u53f7")
    public String getWFSN() {
        return this.psWorkflow.getWFSN();
    }

    public Object getRuntimeId() {
        return this.getId();
    }

    public void setRuntimeId(Object objId) {
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u5f15\u64ce\u7c7b\u578b")
    public String getWFEngineType() {
        return this.strWFEngineType;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u5f15\u64ce\u7c7b\u522b")
    public String getWFEngineCat() {
        return this.strWFEngineCat;
    }

    public IWFVersionModel getWFVersionModel(String strWFVesionId) throws Exception {
        return null;
    }

    @PSModelRTMeta(description="\u662f\u5426\u652f\u6301\u52a8\u6001\u7cfb\u7edf\u8bbe\u8ba1")
    public boolean isDynamicWorkflow() {
        return this.bDynamicWorkflow;
    }

    @PSModelRTMeta(description="\u540d\u79f0\u8bed\u8a00\u8d44\u6e90", hideempty=true)
    public IPSLanguageRes getNamePSLanguageRes() {
        return this.namePSLanguageRes;
    }

    public String getNameLanResTag() {
        if (this.getNamePSLanguageRes() != null) {
            return this.getNamePSLanguageRes().getLanResTag();
        }
        return null;
    }

    @PSModelRTMeta(description="\u662f\u5426\u4f7f\u7528\u8fdc\u7a0b\u5f15\u64ce")
    public boolean isUseRemoteEngine() {
        return this.bUseRemoteEngine;
    }

    public String getWXAccountId() {
        return null;
    }

    public String getWXEntAppId() {
        return null;
    }

    public String getDefaultDEName() {
        try {
            Iterator<IPSDEWF> psDEWFs = this.getPSWFDEs();
            if (psDEWFs.hasNext()) {
                return psDEWFs.next().getPSDataEntity().getName();
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u9ed8\u8ba4\u5b9e\u4f53\u540d\u79f0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return null;
        }
    }

    public int getWFProxyMode() {
        return this.nWFProxyMode;
    }
}

