/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.WF.IPSWFDE;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.PSWFDEGlobalModel;
import SA.SRFDA.PS.Core.WF.PSWFVersionGlobalModel;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroup;
import SA.SRFDA.PS.Core.WF.UIAction.PSWFUIActionGlobalModel;
import SA.SRFDA.PS.Core.WF.UIAction.PSWFUIActionGroupGlobalModel;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Data.PSWorkflow;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkflowImpl
extends PSSystemObjectImpl
implements IPSWorkflow {
    private static final Log log = LogFactory.getLog(PSWorkflowImpl.class);
    protected PSWorkflow psWorkflow;
    private String strCodeName = "";
    private PSWFVersionGlobalModel psWFVersionGlobalModel = null;
    private PSWFDEGlobalModel psWFDEGlobalModel = null;
    private IPSCodeList wfStepPSCodeList = null;
    private IPSCodeList entityStatePSCodeList = null;
    private Map<String, String> entityWFStateMap = new LinkedHashMap<String, String>();
    private IPSWFVersion lastPSWFVersion = null;
    private String strEntityWFState = "";
    private String strEntityWFFinishState = "";
    private String strEntityWFErrorState = "";
    private String strEntityWFCancelState = "";
    private String strRemindMsgTemplId = null;
    private boolean bValidFlag = true;
    private IPSWXAccount iPSWXAccount = null;
    private IPSWXEntApp iPSWXEntApp = null;
    private String strWFEngineCat = "EMBEDDED";
    private String strWFEngineType = "EMBEDDED";
    private boolean bDynamicWorkflow = false;
    private IPSLanguageRes namePSLanguageRes = null;
    private IPSSystemModule iPSSystemModule = null;
    private boolean bUseRemoteEngine = false;
    private boolean bUseWFProxyApp = false;
    private int nWFProxyMode = 0;
    protected PSWFUIActionGlobalModel psWFUIActionGlobalModel = new PSWFUIActionGlobalModel();
    protected PSWFUIActionGroupGlobalModel psWFUIActionGroupGlobalModel = new PSWFUIActionGroupGlobalModel();
    private ArrayList<IPSAppWF> psAppWFList = null;
    private String strWFType = "DEFAULT";
    private int nDynaInstMode = 0;
    private int nDynaSysMode = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSWorkflow psWorkflow) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psWorkflow = psWorkflow;
            this.setId(this.psWorkflow.getPSWORKFLOWID());
            this.setName(this.psWorkflow.getPSWORKFLOWNAME());
            this.setPSObjectData(this.psWorkflow);
            this.strCodeName = this.psWorkflow.getCODENAME();
            if (!this.psWorkflow.isWFPROXYMODENull()) {
                this.nWFProxyMode = this.psWorkflow.getWFPROXYMODE();
                boolean bl = this.bUseWFProxyApp = (this.getWFProxyMode() & 1) == 1;
            }
            if (!this.isUseWFProxyApp() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWorkflow.getWFSTEPCODELISTID())) {
                this.wfStepPSCodeList = iPSSystem.getPSCodeList(this.psWorkflow.getWFSTEPCODELISTID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWorkflow.getSTATECODELISTID())) {
                this.entityStatePSCodeList = iPSSystem.getPSCodeList(this.psWorkflow.getSTATECODELISTID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWorkflow.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psWorkflow.getPSMODULEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWorkflow.getREMINDPSSYSMSGTEMPLID())) {
                this.strRemindMsgTemplId = this.psWorkflow.getREMINDPSSYSMSGTEMPLID();
            }
            if (!this.psWorkflow.isVALIDFLAGNull()) {
                this.bValidFlag = this.psWorkflow.getVALIDFLAG();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWorkflow.getWFENGINETYPE())) {
                this.strWFEngineType = this.psWorkflow.getWFENGINETYPE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWorkflow.getWFTYPE())) {
                this.strWFType = this.psWorkflow.getWFTYPE();
            }
            this.strWFEngineCat = this.strWFEngineType;
            if (!this.psWorkflow.isENABLEDYNASYSNull()) {
                this.bDynamicWorkflow = this.psWorkflow.getENABLEDYNASYS();
                if (this.psWorkflow.getENABLEDYNASYS()) {
                    this.nDynaSysMode = 1;
                }
            }
            if (!this.psWorkflow.isREMOTEENGINEFLAGNull()) {
                this.bUseRemoteEngine = this.psWorkflow.getREMOTEENGINEFLAG();
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getWFEngineCat(), (String)"ACTIVITI", (boolean)true) == 0 && this.isUseRemoteEngine()) {
                this.strWFEngineType = "ACTIVITI_REMOTE";
            }
            if (this.getPSSystemModule() != null && this.getPSSystemModule().getDynaInstMode() != 0) {
                this.nDynaInstMode = this.getPSSystemModule().getDynaInstMode();
                if (!this.psWorkflow.isENABLEDYNASYSNull() && !this.psWorkflow.getENABLEDYNASYS()) {
                    this.nDynaInstMode = 0;
                }
            }
            this.psWFUIActionGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psWFUIActionGroupGlobalModel.Init(this.getDAGlobalHelper(), this);
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWorkflow.getNAMEPSLANRESID())) {
            this.namePSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psWorkflow.getNAMEPSLANRESID());
        }
        this.strEntityWFState = this.psWorkflow.getWFSTATEVALUE();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEntityWFState)) {
            String[] items;
            String[] stringArray = items = this.strEntityWFState.split("[;]");
            int n = items.length;
            int n2 = 0;
            while (n2 < n) {
                String strItem = stringArray[n2];
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strItem)) {
                    this.entityWFStateMap.put(strItem, strItem);
                }
                ++n2;
            }
        }
        this.strEntityWFErrorState = this.psWorkflow.getWFERRORVALUE();
        this.strEntityWFFinishState = this.psWorkflow.getWFFINISHEVALUE();
        this.strEntityWFCancelState = this.psWorkflow.getWFCANCELVALUE();
        this.psWFVersionGlobalModel = new PSWFVersionGlobalModel();
        this.psWFVersionGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psWFDEGlobalModel = new PSWFDEGlobalModel();
        this.psWFDEGlobalModel.Init(this.getDAGlobalHelper(), this);
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWorkflow.getPSWXACCOUNTID())) {
            this.iPSWXAccount = this.getPSSystem().getPSWXAccount(this.psWorkflow.getPSWXACCOUNTID());
        }
        if (this.getPSWXAccount() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWorkflow.getPSWXENTAPPID())) {
            this.iPSWXEntApp = this.getPSWXAccount().getPSWXEntApp(this.psWorkflow.getPSWXENTAPPID());
        }
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"PSWORKFLOWNAME"})
    public String getLogicName() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    @Override
    public IPSWFVersion getPSWFVersion(String strWFVersionId) throws Exception {
        return (IPSWFVersion)this.psWFVersionGlobalModel.FindModelHelper(strWFVersionId);
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u7248\u672c\u96c6\u5408", child=true, dumpref=true, rtdump=2, group="\u57fa\u672c", order=135)
    public Iterator<IPSWFVersion> getPSWFVersions() throws Exception {
        return this.psWFVersionGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5b9e\u4f53\u96c6\u5408", child=true, dynamodelmode=5, group="\u57fa\u672c", order=130)
    public Iterator<IPSWFDE> getPSWFDEs() throws Exception {
        return this.psWFDEGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u6b65\u9aa4\u4ee3\u7801\u8868", fields={"WFSTEPCODELISTID"})
    public IPSCodeList getWFStepPSCodeList() {
        return this.wfStepPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u4e1a\u52a1\u72b6\u6001\u4ee3\u7801\u8868", fields={"STATECODELISTID"})
    public IPSCodeList getEntityStatePSCodeList() {
        return this.entityStatePSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u4e2d\u4e1a\u52a1\u72b6\u6001\u96c6\u5408")
    public Iterator<String> getEntityWFStates() {
        return this.entityWFStateMap.keySet().iterator();
    }

    /*
     * Unable to fully structure code
     */
    @Override
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

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6d41\u7a0b\u4e2d\u72b6\u6001\u503c", fields={"WFSTATEVALUE"})
    public String getEntityWFState() {
        return this.strEntityWFState;
    }

    @Override
    public IPSDEWF getPSDEWF(String strPSDEWFId) throws Exception {
        return (IPSDEWF)this.psWFDEGlobalModel.FindModelHelper(strPSDEWFId);
    }

    @Override
    public IPSDEWF getPSDEWF(String strPSDEWFId, boolean bTryMode) throws Exception {
        return (IPSDEWF)this.psWFDEGlobalModel.FindModelHelper(strPSDEWFId, bTryMode);
    }

    public String getRemindMsgTemplId() {
        return this.strRemindMsgTemplId;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528")
    public boolean isValid() {
        return this.bValidFlag;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u7f16\u53f7", group="\u57fa\u672c", order=105, fields={"WFSN"})
    public String getWFSN() {
        return this.psWorkflow.getWFSN();
    }

    @Override
    public String getModelType() {
        return "PSWORKFLOW";
    }

    @Override
    public void loadAll() throws Exception {
        this.getPSWFVersions();
        this.getPSSystemUtil().testPSModelLimit(this, "PSWFVERSION", this.psWFVersionGlobalModel.getAllModelHelperCount());
        this.psWFDEGlobalModel.getAllModelHelpers();
        this.psWFUIActionGlobalModel.getAllModelHelpers();
        this.psWFUIActionGroupGlobalModel.getAllModelHelpers();
    }

    public String getWXAccountId() {
        if (this.getPSWXAccount() == null) {
            return null;
        }
        return this.getPSWXAccount().getId();
    }

    public String getWXEntAppId() {
        if (this.getPSWXEntApp() == null) {
            return null;
        }
        return this.getPSWXEntApp().getId();
    }

    @Override
    @PSModelRTMeta(description="\u901a\u77e5\u5fae\u4fe1\u4f01\u4e1a\u8d26\u53f7")
    public IPSWXAccount getPSWXAccount() {
        return this.iPSWXAccount;
    }

    @Override
    @PSModelRTMeta(description="\u901a\u77e5\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528")
    public IPSWXEntApp getPSWXEntApp() {
        return this.iPSWXEntApp;
    }

    public Object getRuntimeId() {
        return this.getId();
    }

    public void setRuntimeId(Object objId) {
    }

    @Override
    public boolean isEnableDynamicView() {
        return this.isDynamicWorkflow();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5f15\u64ce\u7c7b\u578b", fields={"WFENGINETYPE"})
    public String getWFEngineType() {
        return this.strWFEngineType;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5f15\u64ce\u7c7b\u522b")
    public String getWFEngineCat() {
        return this.strWFEngineCat;
    }

    public IWFVersionModel getWFVersionModel(String strWFVesionId) throws Exception {
        return null;
    }

    @Override
    public boolean isDynamicWorkflow() {
        return this.bDynamicWorkflow;
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0\u8bed\u8a00\u8d44\u6e90", hideempty=true, fields={"NAMEPSLANRESID"})
    public IPSLanguageRes getNamePSLanguageRes() {
        return this.namePSLanguageRes;
    }

    @Override
    public String getNameLanResTag() {
        if (this.getNamePSLanguageRes() != null) {
            return this.getNamePSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, hideempty=true, dynamodelmode=4, fields={"PSMODULEID"})
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
    @PSModelRTMeta(description="\u4f7f\u7528\u8fdc\u7a0b\u5f15\u64ce", fields={"REMOTEENGINEFLAG"})
    public boolean isUseRemoteEngine() {
        return this.bUseRemoteEngine;
    }

    @Override
    @PSModelRTMeta(description="\u4f7f\u7528\u5de5\u4f5c\u6d41\u4ee3\u7406\u5e94\u7528")
    public boolean isUseWFProxyApp() {
        return this.bUseWFProxyApp;
    }

    @Override
    public IPSWFUIAction getPSWFUIAction(String strDEUIActionId) throws Exception {
        return (IPSWFUIAction)this.psWFUIActionGlobalModel.FindModelHelper(strDEUIActionId);
    }

    @Override
    public IPSWFUIAction getPSWFUIAction(String strDEUIActionId, boolean bTryMode) throws Exception {
        return (IPSWFUIAction)this.psWFUIActionGlobalModel.FindModelHelper(strDEUIActionId, bTryMode);
    }

    @Override
    public void resetPSWFUIAction(String strDEUIActionId) throws Exception {
        this.psWFUIActionGlobalModel.ResetModel(strDEUIActionId);
    }

    @Override
    public Iterator<IPSWFUIAction> getAllPSWFUIActions() throws Exception {
        return this.psWFUIActionGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSWFUIActionGroup getPSWFUIActionGroup(String strDEUIActionGroupId) throws Exception {
        return (IPSWFUIActionGroup)this.psWFUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId);
    }

    @Override
    public IPSWFUIActionGroup getPSWFUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception {
        return (IPSWFUIActionGroup)this.psWFUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId, bTryMode);
    }

    @Override
    public void resetPSWFUIActionGroup(String strDEUIActionGroupId) throws Exception {
        this.psWFUIActionGroupGlobalModel.ResetModel(strDEUIActionGroupId);
    }

    @Override
    public String getDefaultDEName() {
        try {
            Iterator<IPSWFDE> psDEWFs = this.getPSWFDEs();
            if (psDEWFs.hasNext()) {
                return psDEWFs.next().getPSDataEntity().getName();
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u9ed8\u8ba4\u5b9e\u4f53\u540d\u79f0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u4ee3\u7406\u6a21\u5f0f", codelist="WFProxyMode", fields={"WFPROXYMODE"})
    public int getWFProxyMode() {
        return this.nWFProxyMode;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u96c6\u5408")
    public Iterator<IPSAppWF> getPSAppWFs() throws Exception {
        if (this.psAppWFList == null) {
            ArrayList<IPSAppWF> psAppWFList = new ArrayList<IPSAppWF>();
            Iterator<IPSApplication> psApplications = this.getPSSystem().getAllPSApps();
            if (psApplications != null) {
                while (psApplications.hasNext()) {
                    IPSApplication iPSApplication = psApplications.next();
                    Iterator<IPSAppWF> psAppWFs = iPSApplication.getAllPSAppWFs();
                    if (psAppWFs == null) continue;
                    while (psAppWFs.hasNext()) {
                        IPSAppWF iPSAppWF = psAppWFs.next();
                        if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSAppWF.getPSWorkflow().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                        psAppWFList.add(iPSAppWF);
                    }
                }
            }
            if (this.psAppWFList == null) {
                this.psAppWFList = psAppWFList;
            }
        }
        return this.psAppWFList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        if (this.getPSSystemModule() != null) {
            return KeyValueHelper.genUniqueId((String)this.getPSSystemModule().getDeployId(), (String)this.getCodeName());
        }
        return KeyValueHelper.genUniqueId((String)this.getPSSystem().getDeployId(), (String)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u7c7b\u578b", codelist="WFType", fields={"WFTYPE"})
    public String getWFType() {
        return this.strWFType;
    }

    @Override
    protected int onGetDynaInstMode() {
        return this.nDynaInstMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6d41\u7a0b\u7ed3\u675f\u72b6\u6001\u503c", fields={"WFFINISHEVALUE"})
    public String getEntityWFFinishState() {
        return this.strEntityWFFinishState;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6d41\u7a0b\u9519\u8bef\u72b6\u6001\u503c", fields={"WFERRORVALUE"})
    public String getEntityWFErrorState() {
        return this.strEntityWFErrorState;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6d41\u7a0b\u53d6\u6d88\u72b6\u6001\u503c", fields={"WFCANCELVALUE"})
    public String getEntityWFCancelState() {
        return this.strEntityWFCancelState;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", codelist="DynaSysMode", ignoredumpvalues="0", fields={"ENABLEDYNASYS"})
    public int getDynaSysMode() {
        return this.nDynaSysMode;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5206\u7c7b\u4ee3\u7801", fields={"WFCATCODE"})
    public String getWFCatCode() {
        return this.psWorkflow.getWFCATCODE();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSSystemModule() != null) {
            if (this.getPSSystemModule().getPSSysModelGroup() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            if (this.getPSSystemModule().getPSSysRef() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysRef().getSysRefTag(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            return String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), this.getCodeName());
        }
        return this.getCodeName();
    }
}

