/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFParallelSubWFProcessModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl3;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCond;
import SA.SRFDA.PS.Core.WF.IPSWFLinkGroupCond;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessType;
import SA.SRFDA.PS.Core.WF.IPSWFStartProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroup;
import SA.SRFDA.PS.Core.WF.UIAction.PSWFUIActionGlobalModel;
import SA.SRFDA.PS.Core.WF.UIAction.PSWFUIActionGroupGlobalModel;
import SA.SRFDA.PS.Data.PSWFLink;
import SA.SRFDA.PS.Data.PSWFLinkCond;
import SA.SRFDA.PS.Data.PSWFLinkRole;
import SA.SRFDA.PS.Data.PSWFProcParam;
import SA.SRFDA.PS.Data.PSWFProcRole;
import SA.SRFDA.PS.Data.PSWFProcSubWF;
import SA.SRFDA.PS.Data.PSWFProcess;
import SA.SRFDA.PS.Data.PSWFVersion;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFParallelSubWFProcessModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFVersionImpl
extends PSObjectImpl3
implements IPSWFVersion {
    private static final Log log = LogFactory.getLog(PSWFVersionImpl.class);
    protected PSWFVersion psWFVersion;
    private Map<String, IPSWFProcess> psWFProcessMap = new LinkedHashMap<String, IPSWFProcess>();
    protected ArrayList<IPSWFLink> psWFLinkList = new ArrayList();
    private String strCodeName = "";
    private IPSWFStartProcess startPSWFProcess = null;
    private IPSWorkflow iPSWorkflow = null;
    private String strWFMode = null;
    protected PSWFUIActionGlobalModel psWFUIActionGlobalModel = new PSWFUIActionGlobalModel();
    protected PSWFUIActionGroupGlobalModel psWFUIActionGroupGlobalModel = new PSWFUIActionGroupGlobalModel();
    private boolean bWFParallelSubWFProcessModel = false;
    private boolean bValidFlag = true;
    private String strBPMNModel = null;
    private ArrayList<IPSWFLinkCond> allPSWFLinkCondList = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWorkflow iPSWorkflow, PSWFVersion psWFVersion) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSWorkflow(iPSWorkflow);
            this.psWFVersion = psWFVersion;
            this.setId(this.psWFVersion.getPSWFVERSIONID());
            this.setName(this.psWFVersion.getPSWFVERSIONNAME());
            this.setPSObjectData(this.psWFVersion);
            this.strCodeName = SA.SRFramework.Utility.StringHelper.Format((String)"%1$sv%2$s", (Object)iPSWorkflow.getCodeName(), (Object)this.getWFVersion());
            this.psWFUIActionGlobalModel.Init(iDAGlobalHelper, this);
            this.psWFUIActionGroupGlobalModel.Init(iDAGlobalHelper, this);
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
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSWFVersionImpl.this.getModelType()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSWFVersionImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSWFVersionImpl.this.getModelType(), (Object)PSWFVersionImpl.this.getId())) {
                            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        try {
                            PSWFVersionImpl.this.onInit();
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSWFVersionImpl.this.getModelType(), (Object)PSWFVersionImpl.this.getId());
                        }
                        catch (Exception ex) {
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSWFVersionImpl.this.getModelType(), (Object)PSWFVersionImpl.this.getId());
                            throw ex;
                        }
                    } else {
                        PSWFVersionImpl.this.onInit();
                    }
                }
            });
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
    @PSModelRTMeta(description="\u5f00\u59cb\u5904\u7406", dumpref=true, from="__self__")
    public IPSWFProcess getStartPSWFProcess() {
        return this.startPSWFProcess;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSWFProcesses();
    }

    protected void onPreparePSWFProcesses() throws Exception {
        this.allPSWFLinkCondList = null;
        this.psWFProcessMap.clear();
        Vector<PSWFProcess> psWFProcessList = new Vector<PSWFProcess>();
        CallResult callResult = this.getPSModelHelper().getPSWFProcesses(this.getId(), psWFProcessList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        LinkedHashMap<String, PSWFProcess> psWFProcessMap = new LinkedHashMap<String, PSWFProcess>();
        for (PSWFProcess psWFProcess : psWFProcessList) {
            psWFProcessMap.put(psWFProcess.getPSWFPROCESSID(), psWFProcess);
        }
        this.psWFLinkList.clear();
        Vector<PSWFLink> psWFLinkList = new Vector<PSWFLink>();
        callResult = this.getPSModelHelper().getPSWFLinks(this.getId(), psWFLinkList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        LinkedHashMap<String, PSWFLink> psWFLinkMap = new LinkedHashMap<String, PSWFLink>();
        for (PSWFLink psWFLink : psWFLinkList) {
            psWFLinkMap.put(psWFLink.getPSWFLINKID(), psWFLink);
            PSWFProcess psWFProcess = (PSWFProcess)((Object)psWFProcessMap.get(psWFLink.getFROMPSWFPROCID()));
            if (psWFProcess == null) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u8fde\u63a5[%2$s]\u65e0\u6cd5\u5b9a\u4f4d\u6e90\u5904\u7406[%3$s]", (Object)this.getName(), (Object)psWFLink.getLOGICNAME(), (Object)psWFLink.getFROMPSWFPROCID()));
            }
            psWFProcess.getPSWFLinks(true).add(psWFLink);
        }
        Vector<PSWFProcParam> psWFProcParamList = new Vector<PSWFProcParam>();
        callResult = this.getPSModelHelper().getPSWFProcParams(this.getId(), psWFProcParamList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWFProcParam psWFProcParam : psWFProcParamList) {
            PSWFProcess psWFProcess = (PSWFProcess)((Object)psWFProcessMap.get(psWFProcParam.getPSWFPROCESSID()));
            if (psWFProcess == null) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u8fc7\u7a0b\u53c2\u6570[%2$s]\u65e0\u6cd5\u5b9a\u4f4d\u5904\u7406[%3$s]", (Object)this.getName(), (Object)psWFProcParam.getPSWFPROCPARAMNAME(), (Object)psWFProcParam.getPSWFPROCESSID()));
            }
            psWFProcess.getPSWFProcParams(true).add(psWFProcParam);
        }
        Vector<PSWFProcSubWF> psWFProcSubWFList = new Vector<PSWFProcSubWF>();
        callResult = this.getPSModelHelper().getPSWFProcSubWFs(this.getId(), psWFProcSubWFList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u5b50\u6d41\u7a0b\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWFProcSubWF psWFProcSubWF : psWFProcSubWFList) {
            PSWFProcess psWFProcess = (PSWFProcess)((Object)psWFProcessMap.get(psWFProcSubWF.getPSWFPROCESSID()));
            if (psWFProcess == null) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u5904\u7406\u5b50\u6d41\u7a0b[%2$s]\u65e0\u6cd5\u5b9a\u4f4d\u5904\u7406[%3$s]", (Object)this.getName(), (Object)psWFProcSubWF.getPSWFPROCSUBWFNAME(), (Object)psWFProcSubWF.getPSWFPROCESSID()));
            }
            psWFProcess.getPSWFProcSubWFs(true).add(psWFProcSubWF);
        }
        Vector<PSWFProcRole> psWFProcRoleList = new Vector<PSWFProcRole>();
        callResult = this.getPSModelHelper().getPSWFProcRoles(this.getId(), psWFProcRoleList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u89d2\u8272\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWFProcRole psWFProcRole : psWFProcRoleList) {
            PSWFProcess psWFProcess = (PSWFProcess)((Object)psWFProcessMap.get(psWFProcRole.getPSWFPROCESSID()));
            if (psWFProcess == null) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u5904\u7406\u89d2\u8272[%2$s]\u65e0\u6cd5\u5b9a\u4f4d\u5904\u7406[%3$s]", (Object)this.getName(), (Object)psWFProcRole.getPSWFPROCROLENAME(), (Object)psWFProcRole.getPSWFPROCESSID()));
            }
            psWFProcess.getPSWFProcRoles(true).add(psWFProcRole);
        }
        Vector<PSWFLinkRole> psWFLinkRoleList = new Vector<PSWFLinkRole>();
        callResult = this.getPSModelHelper().getPSWFLinkRoles(this.getId(), psWFLinkRoleList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u8fde\u63a5\u89d2\u8272\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWFLinkRole psWFLinkRole : psWFLinkRoleList) {
            PSWFLink psWFLink = (PSWFLink)((Object)psWFLinkMap.get(psWFLinkRole.getPSWFLINKID()));
            if (psWFLink == null) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u8fde\u63a5\u89d2\u8272[%2$s]\u65e0\u6cd5\u5b9a\u4f4d\u8fde\u63a5[%3$s]", (Object)this.getName(), (Object)psWFLinkRole.getPSWFPROCROLENAME(), (Object)psWFLinkRole.getPSWFLINKID()));
            }
            psWFLink.getPSWFLinkRoles(true).add(psWFLinkRole);
        }
        Vector<PSWFLinkCond> psWFLinkCondList = new Vector<PSWFLinkCond>();
        callResult = this.getPSModelHelper().getPSWFLinkConds(this.getId(), psWFLinkCondList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u8fde\u63a5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        LinkedHashMap<String, PSWFLinkCond> psWFLinkCondMap = new LinkedHashMap<String, PSWFLinkCond>();
        for (PSWFLinkCond psWFLinkCond : psWFLinkCondList) {
            psWFLinkCondMap.put(psWFLinkCond.getPSWFLINKCONDID(), psWFLinkCond);
        }
        for (PSWFLinkCond psWFLinkCond : psWFLinkCondList) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psWFLinkCond.getPPSWFLINKCONDID())) continue;
            PSWFLinkCond parentPSWFLinkCond = (PSWFLinkCond)((Object)psWFLinkCondMap.get(psWFLinkCond.getPPSWFLINKCONDID()));
            parentPSWFLinkCond.getChildPSWFLinkConds(true).add(psWFLinkCond);
        }
        for (PSWFLinkCond psWFLinkCond : psWFLinkCondList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psWFLinkCond.getPPSWFLINKCONDID())) continue;
            PSWFLink psWFLink = (PSWFLink)((Object)psWFLinkMap.get(psWFLinkCond.getPSWFLINKID()));
            psWFLink.getPSWFLinkConds(true).add(psWFLinkCond);
        }
        ArrayList<IPSWFProcess> list = new ArrayList<IPSWFProcess>();
        for (PSWFProcess psWFProcess : psWFProcessList) {
            IPSWFProcessType iPSWFProcessType = this.getPSModelStorage().getPSWFProcessType(psWFProcess.getWFPROCESSTYPE());
            IPSWFProcess iPSWFProcess = iPSWFProcessType.createPSWFProcess(psWFProcess);
            iPSWFProcess.init(this.getDAGlobalHelper(), this, psWFProcess);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSWFProcess.getWFProcessType(), (String)"START", (boolean)true) == 0) {
                this.startPSWFProcess = (IPSWFStartProcess)iPSWFProcess;
                list.add(0, iPSWFProcess);
            } else {
                list.add(iPSWFProcess);
            }
            if (this.bWFParallelSubWFProcessModel || !(iPSWFProcess instanceof IWFParallelSubWFProcessModel)) continue;
            this.bWFParallelSubWFProcessModel = true;
        }
        for (IPSWFProcess iPSWFProcess : list) {
            this.psWFProcessMap.put(iPSWFProcess.getId(), iPSWFProcess);
            Iterator<IPSWFLink> psWFLinks = iPSWFProcess.getPSWFLinks();
            if (psWFLinks == null) continue;
            while (psWFLinks.hasNext()) {
                IPSWFLink iPSWFLink = psWFLinks.next();
                this.psWFLinkList.add(iPSWFLink);
            }
        }
        if (this.psWFLinkList != null && this.psWFLinkList.size() > 0) {
            for (IPSWFLink iPSWFLink : this.psWFLinkList) {
                this.fillAllPSWFLinkCond(iPSWFLink.getPSWFLinkGroupCond());
            }
        }
        this.psWFUIActionGlobalModel.getAllModelHelpers();
        this.psWFUIActionGroupGlobalModel.getAllModelHelpers();
    }

    protected void fillAllPSWFLinkCond(IPSWFLinkCond iPSWFLinkCond) throws Exception {
        IPSWFLinkGroupCond iPSWFLinkGroupCond;
        Iterator<IPSWFLinkCond> psWFLinkConds;
        if (iPSWFLinkCond == null) {
            return;
        }
        if (this.allPSWFLinkCondList == null) {
            this.allPSWFLinkCondList = new ArrayList();
        }
        this.allPSWFLinkCondList.add(iPSWFLinkCond);
        if (iPSWFLinkCond instanceof IPSWFLinkGroupCond && (psWFLinkConds = (iPSWFLinkGroupCond = (IPSWFLinkGroupCond)iPSWFLinkCond).getPSWFLinkConds()) != null) {
            while (psWFLinkConds.hasNext()) {
                this.fillAllPSWFLinkCond(psWFLinkConds.next());
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5904\u7406\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<IPSWFProcess> getPSWFProcesses() {
        return this.psWFProcessMap.values().iterator();
    }

    @Override
    public IPSWFProcess getPSWFProcess(String strPSWFProcessId, boolean bTryMode) throws Exception {
        IPSWFProcess iPSWFProcess = this.psWFProcessMap.get(strPSWFProcessId);
        if (iPSWFProcess != null) {
            return iPSWFProcess;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6d41\u7a0b[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u5904\u7406[%2$s]", (Object)this.getName(), (Object)strPSWFProcessId));
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41", from="__parent__", fields={"PSWFID"})
    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    protected void setPSWorkflow(IPSWorkflow iPSWorkflow) {
        this.iPSWorkflow = iPSWorkflow;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c", rtname="getVersion", group="\u57fa\u672c", order=105, fields={"WFVERSION"})
    public int getWFVersion() {
        return this.psWFVersion.getWFVERSION();
    }

    @Override
    public int getVersion() {
        return this.getWFVersion();
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
    @PSModelRTMeta(description="\u6d41\u7a0b\u8fde\u63a5\u96c6\u5408", child=true, ignorert=3, group="\u903b\u8f91", order=217)
    public Iterator<IPSWFLink> getPSWFLinks() {
        return this.psWFLinkList.iterator();
    }

    @Override
    public IPSWFProcess getPSWFProcessByWFStepValue(String strWFStepValue, boolean bTryMode) throws Exception {
        for (IPSWFProcess iPSWFProcess : this.psWFProcessMap.values()) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSWFProcess.getWFStepValue(), (String)strWFStepValue, (boolean)true) != 0) continue;
            return iPSWFProcess;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6d41\u7a0b[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u5904\u7406\uff0c\u6b65\u9aa4\u503c\u4e3a[%2$s]", (Object)this.getName(), (Object)strWFStepValue));
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
        return this.getPSWorkflow().getPSSysModelInstId();
    }

    public boolean hasWFParallelSubWFProcessModel() {
        return this.bWFParallelSubWFProcessModel;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u542f\u7528", fields={"VALIDFLAG"})
    public boolean isValid() {
        return this.bValidFlag;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u6a21\u5f0f", ignorert=3)
    public String getWFMode() {
        return this.strWFMode;
    }

    public String getBPMNModel() {
        return this.strBPMNModel;
    }

    @Override
    public String getModelType() {
        return "PSWFVERSION";
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a\u96c6\u5408", outputdoc="false")
    public Iterator<IPSWFUIAction> getPSWFUIActions() throws Exception {
        return this.psWFUIActionGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a\u7ec4\u96c6\u5408", outputdoc="false")
    public Iterator<IPSWFUIActionGroup> getPSWFUIActionGroups() throws Exception {
        return this.psWFUIActionGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u6b65\u9aa4\u4ee3\u7801\u8868")
    public IPSCodeList getWFStepPSCodeList() {
        return this.getPSWorkflow().getWFStepPSCodeList();
    }

    public ICodeList getWFStepCodeList() {
        return this.getWFStepPSCodeList();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSWorkflow().getPSSystem());
    }

    @Override
    public IPSWFLink getPSWFLink(String strPSWFLinkId, boolean bTryMode) throws Exception {
        for (IPSWFLink iPSWFLink : this.psWFLinkList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSWFLink.getId(), (String)strPSWFLinkId, (boolean)false) != 0) continue;
            return iPSWFLink;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6d41\u7a0b[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u5904\u7406\u8fde\u63a5[%2$s]", (Object)this.getName(), (Object)strPSWFLinkId));
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        String strRootDeployId = this.getPSWorkflow().getDeployId();
        String strOrgId = this.getPSSystemUtil().getDeploySysOrgId();
        String strOrgSectorId = this.getPSSystemUtil().getDeploySysOrgSectorId();
        return KeyValueHelper.genUniqueId((String)strRootDeployId, (String)strOrgId, (String)strOrgSectorId, (String)this.getCodeName());
    }

    @Override
    public Iterator<IPSWFLinkCond> getAllPSWFLinkConds() {
        if (this.allPSWFLinkCondList == null || this.allPSWFLinkCondList.size() == 0) {
            return null;
        }
        return this.allPSWFLinkCondList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6709\u6d41\u7a0b\u542f\u52a8\u89c6\u56fe")
    public boolean hasStartView() {
        if (this.getStartPSWFProcess() != null) {
            return !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)((IPSWFStartProcess)this.getStartPSWFProcess()).getStartPSDEViewId());
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6709\u79fb\u52a8\u7aef\u6d41\u7a0b\u542f\u52a8\u89c6\u56fe")
    public boolean hasMobStartView() {
        if (this.getStartPSWFProcess() != null) {
            return !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)((IPSWFStartProcess)this.getStartPSWFProcess()).getMobStartPSDEViewId());
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u4ee3\u7801\u6807\u8bc6")
    public String getWFCodeName() {
        return this.getPSWorkflow().getCodeName();
    }

    @Override
    protected int onGetDynaInstMode() {
        if (this.getPSWorkflow() != null) {
            return this.getPSWorkflow().getDynaInstMode();
        }
        return super.onGetDynaInstMode();
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        if (this.getPSWorkflow() != null) {
            return this.getPSWorkflow().isEnableDynaModel();
        }
        return super.onGetEnableDynaModel();
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSWorkflow() == null) {
            return null;
        }
        return String.format("%1$s/%2$s/%3$s", this.getPSWorkflow().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSWorkflow() != null) {
            return String.format("%1$s/%2$s", this.getPSWorkflow().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSWorkflow() != null) {
            return String.format("%1$s/%2$s", this.getPSWorkflow().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

