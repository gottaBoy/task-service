/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.wf.IPSWFLink
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.model.wf.uiaction.IPSWFUIAction
 *  net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFParallelSubWFProcessModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 */
package net.ibizsys.model.wf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSWFLink;
import net.ibizsys.model.entity.PSWFLinkCond;
import net.ibizsys.model.entity.PSWFProcParam;
import net.ibizsys.model.entity.PSWFProcRole;
import net.ibizsys.model.entity.PSWFProcSubWF;
import net.ibizsys.model.entity.PSWFProcess;
import net.ibizsys.model.entity.PSWFVersion;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessRuntime;
import net.ibizsys.model.wf.IPSWFProcessType;
import net.ibizsys.model.wf.IPSWFVersionRuntime;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup;
import net.ibizsys.model.wf.uiaction.PSWFUIActionGlobalModel;
import net.ibizsys.model.wf.uiaction.PSWFUIActionGroupGlobalModel;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFParallelSubWFProcessModel;
import net.ibizsys.pswf.core.IWFProcessModel;

public class PSWFVersionImpl
extends PSObjectImpl
implements IPSWFVersionRuntime {
    protected PSWFVersion psWFVersion;
    protected HashMap<String, IPSWFProcess> psWFProcessMap = new HashMap();
    protected ArrayList<IPSWFLink> psWFLinkList = new ArrayList();
    private String strCodeName = "";
    private IPSWFProcess startPSWFProcess = null;
    private IPSWorkflow iPSWorkflow = null;
    private String strWFMode = null;
    protected PSWFUIActionGlobalModel psWFUIActionGlobalModel = new PSWFUIActionGlobalModel();
    protected PSWFUIActionGroupGlobalModel psWFUIActionGroupGlobalModel = new PSWFUIActionGroupGlobalModel();
    private boolean bWFParallelSubWFProcessModel = false;
    private boolean bValidFlag = true;
    private String strBPMNModel = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWorkflow iPSWorkflow, PSWFVersion psWFVersion) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSWorkflow(iPSWorkflow);
        this.psWFVersion = psWFVersion;
        this.setId(this.psWFVersion.getPSWFVERSIONID());
        this.setName(this.psWFVersion.getPSWFVERSIONNAME());
        this.setPSObjectData(this.psWFVersion);
        this.strCodeName = StringHelper.format((String)"%1$sv%2$s", (Object)iPSWorkflow.getCodeName(), (Object)this.getWFVersion());
        this.psWFUIActionGlobalModel.init(iPSModelStorageContext, this);
        this.psWFUIActionGroupGlobalModel.init(iPSModelStorageContext, this);
        if (!this.psWFVersion.isVALIDFLAGNull()) {
            this.bValidFlag = this.psWFVersion.getVALIDFLAG();
        }
        if (!iPSWorkflow.isValid()) {
            this.bValidFlag = false;
        }
        if (!this.psWFVersion.isWFMODENull()) {
            this.strWFMode = this.psWFVersion.getWFMODE();
        }
        this.strBPMNModel = this.psWFVersion.getBPMNMODEL();
        this.onInit();
    }

    @PSModelRTMeta(description="\u5f00\u59cb\u5904\u7406")
    public IPSWFProcess getStartPSWFProcess() {
        return this.startPSWFProcess;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSWFProcesses();
    }

    protected void onPreparePSWFProcesses() throws Exception {
        this.psWFProcessMap.clear();
        Vector<PSWFProcess> psWFProcessList = new Vector<PSWFProcess>();
        CallResult callResult = this.getPSModelQueryHelper().getPSWFProcesses(this.getId(), psWFProcessList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSWFProcess> psWFProcessMap = new HashMap<String, PSWFProcess>();
        for (PSWFProcess psWFProcess : psWFProcessList) {
            psWFProcessMap.put(psWFProcess.getPSWFPROCESSID(), psWFProcess);
        }
        this.psWFLinkList.clear();
        Vector<PSWFLink> psWFLinkList = new Vector<PSWFLink>();
        callResult = this.getPSModelQueryHelper().getPSWFLinks(this.getId(), psWFLinkList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSWFLink> psWFLinkMap = new HashMap<String, PSWFLink>();
        for (PSWFLink psWFLink : psWFLinkList) {
            psWFLinkMap.put(psWFLink.getPSWFLINKID(), psWFLink);
            PSWFProcess psWFProcess = (PSWFProcess)((Object)psWFProcessMap.get(psWFLink.getFROMPSWFPROCID()));
            if (psWFProcess == null) {
                throw new Exception(StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u8fde\u63a5[%2$s]\u65e0\u6cd5\u5b9a\u4f4d\u6e90\u5904\u7406[%3$s]", (Object)this.getName(), (Object)psWFLink.getLOGICNAME(), (Object)psWFLink.getFROMPSWFPROCID()));
            }
            psWFProcess.getPSWFLinks(true).add(psWFLink);
        }
        Vector<PSWFProcParam> psWFProcParamList = new Vector<PSWFProcParam>();
        callResult = this.getPSModelQueryHelper().getPSWFProcParams(this.getId(), psWFProcParamList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWFProcParam psWFProcParam : psWFProcParamList) {
            PSWFProcess psWFProcess = psWFProcessMap.get(psWFProcParam.getPSWFPROCESSID());
            if (psWFProcess == null) {
                throw new Exception(StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u8fc7\u7a0b\u53c2\u6570[%2$s]\u65e0\u6cd5\u5b9a\u4f4d\u5904\u7406[%3$s]", (Object)this.getName(), (Object)psWFProcParam.getPSWFPROCPARAMNAME(), (Object)psWFProcParam.getPSWFPROCESSID()));
            }
            psWFProcess.getPSWFProcParams(true).add(psWFProcParam);
        }
        Vector<PSWFProcSubWF> psWFProcSubWFList = new Vector<PSWFProcSubWF>();
        callResult = this.getPSModelQueryHelper().getPSWFProcSubWFs(this.getId(), psWFProcSubWFList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u5b50\u6d41\u7a0b\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWFProcSubWF psWFProcSubWF : psWFProcSubWFList) {
            PSWFProcess psWFProcess = psWFProcessMap.get(psWFProcSubWF.getPSWFPROCESSID());
            if (psWFProcess == null) {
                throw new Exception(StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u5904\u7406\u5b50\u6d41\u7a0b[%2$s]\u65e0\u6cd5\u5b9a\u4f4d\u5904\u7406[%3$s]", (Object)this.getName(), (Object)psWFProcSubWF.getPSWFPROCSUBWFNAME(), (Object)psWFProcSubWF.getPSWFPROCESSID()));
            }
            psWFProcess.getPSWFProcSubWFs(true).add(psWFProcSubWF);
        }
        Vector<PSWFProcRole> psWFProcRoleList = new Vector<PSWFProcRole>();
        callResult = this.getPSModelQueryHelper().getPSWFProcRoles(this.getId(), psWFProcRoleList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u89d2\u8272\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWFProcRole psWFProcRole : psWFProcRoleList) {
            PSWFProcess psWFProcess = (PSWFProcess)((Object)psWFProcessMap.get(psWFProcRole.getPSWFPROCESSID()));
            if (psWFProcess == null) {
                throw new Exception(StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u5904\u7406\u89d2\u8272[%2$s]\u65e0\u6cd5\u5b9a\u4f4d\u5904\u7406[%3$s]", (Object)this.getName(), (Object)psWFProcRole.getPSWFPROCROLENAME(), (Object)psWFProcRole.getPSWFPROCESSID()));
            }
            psWFProcess.getPSWFProcRoles(true).add(psWFProcRole);
        }
        Vector<PSWFLinkCond> psWFLinkCondList = new Vector<PSWFLinkCond>();
        callResult = this.getPSModelQueryHelper().getPSWFLinkConds(this.getId(), psWFLinkCondList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u8fde\u63a5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSWFLinkCond> psWFLinkCondMap = new HashMap<String, PSWFLinkCond>();
        for (PSWFLinkCond psWFLinkCond : psWFLinkCondList) {
            psWFLinkCondMap.put(psWFLinkCond.getPSWFLINKCONDID(), psWFLinkCond);
        }
        for (PSWFLinkCond psWFLinkCond : psWFLinkCondList) {
            if (StringHelper.isNullOrEmpty((String)psWFLinkCond.getPPSWFLINKCONDID())) continue;
            PSWFLinkCond parentPSWFLinkCond = (PSWFLinkCond)((Object)psWFLinkCondMap.get(psWFLinkCond.getPPSWFLINKCONDID()));
            parentPSWFLinkCond.getChildPSWFLinkConds(true).add(psWFLinkCond);
        }
        for (PSWFLinkCond psWFLinkCond : psWFLinkCondList) {
            if (!StringHelper.isNullOrEmpty((String)psWFLinkCond.getPPSWFLINKCONDID())) continue;
            PSWFLink psWFLink = (PSWFLink)((Object)psWFLinkMap.get(psWFLinkCond.getPSWFLINKID()));
            psWFLink.getPSWFLinkConds(true).add(psWFLinkCond);
        }
        for (PSWFProcess psWFProcess : psWFProcessList) {
            Iterator psWFLinks;
            IPSWFProcessType iPSWFProcessType = this.getPSModelStorageContext().getPSWFProcessType(psWFProcess.getWFPROCESSTYPE());
            IPSWFProcess iPSWFProcess = iPSWFProcessType.createPSWFProcess(psWFProcess);
            ((IPSWFProcessRuntime)iPSWFProcess).init(this.getPSModelStorageContext(), this, psWFProcess);
            this.psWFProcessMap.put(iPSWFProcess.getId(), iPSWFProcess);
            if (StringHelper.compare((String)iPSWFProcess.getWFProcessType(), (String)"START", (boolean)true) == 0) {
                this.startPSWFProcess = iPSWFProcess;
            }
            if (!this.bWFParallelSubWFProcessModel && iPSWFProcess instanceof IWFParallelSubWFProcessModel) {
                this.bWFParallelSubWFProcessModel = true;
            }
            if ((psWFLinks = iPSWFProcess.getPSWFLinks()) == null) continue;
            while (psWFLinks.hasNext()) {
                IPSWFLink iPSWFLink = (IPSWFLink)psWFLinks.next();
                this.psWFLinkList.add(iPSWFLink);
            }
        }
        this.psWFUIActionGlobalModel.getAllModelHelpers();
        this.psWFUIActionGroupGlobalModel.getAllModelHelpers();
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u5904\u7406\u96c6\u5408")
    public Iterator<IPSWFProcess> getPSWFProcesses() {
        return this.psWFProcessMap.values().iterator();
    }

    public IPSWFProcess getPSWFProcess(String strPSWFProcessId, boolean bTryMode) throws Exception {
        IPSWFProcess iPSWFProcess = this.psWFProcessMap.get(strPSWFProcessId);
        if (iPSWFProcess != null) {
            return iPSWFProcess;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.format((String)"\u6d41\u7a0b[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u5904\u7406[%2$s]", (Object)this.getName(), (Object)strPSWFProcessId));
    }

    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    protected void setPSWorkflow(IPSWorkflow iPSWorkflow) {
        this.iPSWorkflow = iPSWorkflow;
    }

    @PSModelRTMeta(description="\u7248\u672c\u53f7")
    public int getWFVersion() {
        return this.psWFVersion.getWFVERSION();
    }

    public int getVersion() {
        return this.getWFVersion();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u8fde\u63a5\u96c6\u5408")
    public Iterator<IPSWFLink> getPSWFLinks() {
        return this.psWFLinkList.iterator();
    }

    public IPSWFProcess getPSWFProcessByWFStepValue(String strWFStepValue, boolean bTryMode) throws Exception {
        for (IPSWFProcess iPSWFProcess : this.psWFProcessMap.values()) {
            if (StringHelper.compare((String)iPSWFProcess.getWFStepValue(), (String)strWFStepValue, (boolean)true) != 0) continue;
            return iPSWFProcess;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.format((String)"\u6d41\u7a0b[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u5904\u7406\uff0c\u6b65\u9aa4\u503c\u4e3a[%2$s]", (Object)this.getName(), (Object)strWFStepValue));
    }

    public IPSWFUIAction getPSWFUIAction(String strDEUIActionId) throws Exception {
        return (IPSWFUIAction)this.psWFUIActionGlobalModel.findModelHelper(strDEUIActionId);
    }

    public IPSWFUIAction getPSWFUIAction(String strDEUIActionId, boolean bTryMode) throws Exception {
        return (IPSWFUIAction)this.psWFUIActionGlobalModel.findModelHelper(strDEUIActionId, bTryMode);
    }

    public Iterator<IPSWFUIAction> getAllPSWFUIActions() throws Exception {
        return this.psWFUIActionGlobalModel.getAllModelHelpers();
    }

    public IPSWFUIActionGroup getPSWFUIActionGroup(String strDEUIActionGroupId) throws Exception {
        return (IPSWFUIActionGroup)this.psWFUIActionGroupGlobalModel.findModelHelper(strDEUIActionGroupId);
    }

    public IPSWFUIActionGroup getPSWFUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception {
        return (IPSWFUIActionGroup)this.psWFUIActionGroupGlobalModel.findModelHelper(strDEUIActionGroupId, bTryMode);
    }

    public void init(IWFModel iWFModel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public IWFModel getWFModel() {
        return this.getPSWorkflow();
    }

    public Iterator<IWFProcessModel> getWFProcessModels() {
        return null;
    }

    public Iterator<IWFLinkModel> getWFLinkModels() {
        return null;
    }

    public IWFProcessModel getWFProcessModel(String strWFProcessModelName, boolean bTryMode) throws Exception {
        return this.getPSWFProcess(strWFProcessModelName, bTryMode);
    }

    public IWFProcessModel getWFProcessModelByWFStepValue(String strWFStepValue, boolean bTryMode) throws Exception {
        return this.getPSWFProcessByWFStepValue(strWFStepValue, bTryMode);
    }

    public IWFProcessModel getStartWFProcessModel() {
        return this.getStartPSWFProcess();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.getPSWorkflow());
    }

    public boolean hasWFParallelSubWFProcessModel() {
        return this.bWFParallelSubWFProcessModel;
    }

    @PSModelRTMeta(description="\u662f\u5426\u542f\u7528")
    public boolean isValid() {
        return this.bValidFlag;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u6a21\u5f0f")
    public String getWFMode() {
        return this.strWFMode;
    }

    public String getBPMNModel() {
        return this.strBPMNModel;
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a\u96c6\u5408")
    public Iterator<IPSWFUIAction> getPSWFUIActions() throws Exception {
        return this.psWFUIActionGlobalModel.getAllModelHelpers();
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a\u7ec4\u96c6\u5408")
    public Iterator<IPSWFUIActionGroup> getPSWFUIActionGroups() throws Exception {
        return this.psWFUIActionGroupGlobalModel.getAllModelHelpers();
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u6b65\u9aa4\u4ee3\u7801\u8868")
    public IPSCodeList getWFStepPSCodeList() {
        return this.getPSWorkflow().getWFStepPSCodeList();
    }

    public ICodeList getWFStepCodeList() {
        return this.getWFStepPSCodeList();
    }
}
