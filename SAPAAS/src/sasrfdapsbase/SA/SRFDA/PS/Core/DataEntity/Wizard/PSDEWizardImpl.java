/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicNode;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardForm;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardLogic;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardStep;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEWizardException;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEWizardFormImpl;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEWizardLogicImpl;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEWizardStepImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Data.PSDEWizard;
import SA.SRFDA.PS.Data.PSDEWizardForm;
import SA.SRFDA.PS.Data.PSDEWizardLogic;
import SA.SRFDA.PS.Data.PSDEWizardStep;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEWizardImpl
extends PSDataEntityObjectImpl
implements IPSDEWizard,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEWizardImpl.class);
    protected PSDEWizard psDEWizard;
    protected ArrayList<IPSDEWizardStep> psDEWizardStepList = new ArrayList();
    protected Map<String, IPSDEWizardStep> psDEWizardStepMap = new LinkedHashMap<String, IPSDEWizardStep>();
    protected ArrayList<IPSDEWizardForm> psDEWizardFormList = new ArrayList();
    protected String strCodeName = "";
    private IPSDEAction initPSDEAction = null;
    private IPSDEAction finishPSDEAction = null;
    private String strPrevCaption = "";
    private String strNextCaption = "";
    private String strFinishCaption = "";
    private IPSLanguageRes prevCapPSLanguageRes = null;
    private IPSLanguageRes nextCapPSLanguageRes = null;
    private IPSLanguageRes finishCapPSLanguageRes = null;
    private String strWizardStyle = "DEFAULT";
    private IPSDEField statePSDEField = null;
    private boolean bStateWizard = false;
    private boolean bEnableMainStateLogic = false;
    private IPSDEMSLogic iPSDEMSLogic = null;
    protected List<PSDEWizardLogicImpl> psDEWizardLogicList = new ArrayList<PSDEWizardLogicImpl>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEWizard psDEWizard) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEWizard = psDEWizard;
            this.setId(psDEWizard.getPSDEWIZARDID());
            this.setName(psDEWizard.getPSDEWIZARDNAME());
            this.setPSObjectData(this.psDEWizard);
            this.strCodeName = this.psDEWizard.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEWizard.getPREVCAPTION())) {
                this.strPrevCaption = this.psDEWizard.getPREVCAPTION();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEWizard.getNEXTCAPTION())) {
                this.strNextCaption = this.psDEWizard.getNEXTCAPTION();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEWizard.getFINISHCAPTION())) {
                this.strFinishCaption = this.psDEWizard.getFINISHCAPTION();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEWizard.getPREVPSLANRESID())) {
                this.prevCapPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psDEWizard.getPREVPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEWizard.getNEXTPSLANRESID())) {
                this.nextCapPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psDEWizard.getNEXTPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEWizard.getFINISHPSLANRESID())) {
                this.finishCapPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psDEWizard.getFINISHPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEWizard.getWIZARDSTYLE())) {
                this.strWizardStyle = this.psDEWizard.getWIZARDSTYLE();
            }
            if (!this.psDEWizard.isSTATEWIZARDFLAGNull()) {
                this.bStateWizard = this.psDEWizard.getSTATEWIZARDFLAG();
            }
            if (this.isStateWizard() && !this.psDEWizard.isENABLEMSLOGICNull()) {
                this.bEnableMainStateLogic = this.psDEWizard.getENABLEMSLOGIC();
            }
            if (this.isEnableMainStateLogic() && this.getPSDEMSLogic() == null) {
                this.iPSDEMSLogic = this.getPSDataEntity().getDefaultPSDEMSLogic();
                if (this.getPSDEMSLogic() == null) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u4e3b\u72b6\u6001\u8fc1\u79fb\u903b\u8f91 ");
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEWizard.getINITPSDEACTIONID())) {
            this.initPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEWizard.getINITPSDEACTIONID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEWizard.getFINISHPSDEACTIONID())) {
            this.finishPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEWizard.getFINISHPSDEACTIONID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEWizard.getSTATEPSDEFID())) {
            this.statePSDEField = this.getPSDataEntity().getPSDEField(this.psDEWizard.getSTATEPSDEFID());
        }
        super.onInit();
        if (this.isEnableMainStateLogic()) {
            this.onPrepareMainStateLogicWizard();
        } else {
            this.onPreparePSDEWizardSteps();
            this.onPreparePSDEWizardForms();
            this.onPreparePSDEWizardLogics();
        }
    }

    protected void onPreparePSDEWizardSteps() throws Exception {
        this.psDEWizardStepList.clear();
        this.psDEWizardStepMap.clear();
        Vector<PSDEWizardStep> psDEWizardStepList = new Vector<PSDEWizardStep>();
        CallResult callResult = this.getPSModelHelper().getPSDEWizardSteps(this.getId(), psDEWizardStepList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEWizardStep psDEWizardStep : psDEWizardStepList) {
            PSDEWizardStepImpl iPSDEWizardStep = new PSDEWizardStepImpl();
            iPSDEWizardStep.init(this.getDAGlobalHelper(), this, psDEWizardStep);
            this.psDEWizardStepList.add(iPSDEWizardStep);
            this.psDEWizardStepMap.put(iPSDEWizardStep.getId(), iPSDEWizardStep);
        }
    }

    protected void onPreparePSDEWizardForms() throws Exception {
        this.psDEWizardFormList.clear();
        Vector<PSDEWizardForm> psDEWizardFormList = new Vector<PSDEWizardForm>();
        CallResult callResult = this.getPSModelHelper().getPSDEWizardForms(this.getId(), psDEWizardFormList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5411\u5bfc\u8868\u5355\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEWizardForm psDEWizardForm : psDEWizardFormList) {
            PSDEWizardFormImpl iPSDEWizardForm = new PSDEWizardFormImpl();
            iPSDEWizardForm.init(this.getDAGlobalHelper(), this, psDEWizardForm);
            this.psDEWizardFormList.add(iPSDEWizardForm);
        }
    }

    protected void onPreparePSDEWizardLogics() throws Exception {
        this.psDEWizardLogicList.clear();
        this.onPreparePSDEWizardLogics(this.getId());
    }

    protected void onPreparePSDEWizardLogics(String strPSDEWizardId) throws Exception {
        Vector<PSDEWizardLogic> psDEWizardLogicList = new Vector<PSDEWizardLogic>();
        CallResult callResult = this.getPSModelHelper().getPSDEWizardLogics(strPSDEWizardId, psDEWizardLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5411\u5bfc\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEWizardLogic psDEWizardLogic : psDEWizardLogicList) {
            PSDEWizardLogicImpl psDEWizardLogicImpl = new PSDEWizardLogicImpl();
            psDEWizardLogicImpl.init(this.getDAGlobalHelper(), this, psDEWizardLogic);
            this.psDEWizardLogicList.add(psDEWizardLogicImpl);
        }
    }

    protected void onPrepareMainStateLogicWizard() throws Exception {
        if (this.getPSDEMSLogic() == null || this.getPSDEMSLogic().getDefaultPSDEMSLogicNode() == null) {
            return;
        }
        this.psDEWizardStepList.clear();
        this.psDEWizardStepMap.clear();
        this.psDEWizardFormList.clear();
        IPSDEMainState firstPSDEMainState = this.getPSDEMSLogic().getDefaultPSDEMSLogicNode().getPSDEMainState();
        LinkedHashMap<String, IPSDEMainState> psDEMainStateMap = new LinkedHashMap<String, IPSDEMainState>();
        ArrayList<IPSDEMainState> psDEMainStateList = new ArrayList<IPSDEMainState>();
        Iterator<? extends IPSDEMSLogicNode> psDEMSLogicNodes = this.getPSDEMSLogic().getPSDEMSLogicNodes();
        if (psDEMSLogicNodes != null) {
            while (psDEMSLogicNodes.hasNext()) {
                IPSDEMSLogicNode iPSDEMSLogicNode = psDEMSLogicNodes.next();
                psDEMainStateMap.put(iPSDEMSLogicNode.getPSDEMainState().getId(), iPSDEMSLogicNode.getPSDEMainState());
            }
        }
        psDEMainStateMap.remove(firstPSDEMainState.getId());
        psDEMainStateList.addAll(psDEMainStateMap.values());
        PSModelUtil.sort(psDEMainStateList);
        psDEMainStateList.add(0, firstPSDEMainState);
        Vector<PSDEWizardStep> psDEWizardStepList = new Vector<PSDEWizardStep>();
        Vector<PSDEWizardForm> psDEWizardFormList = new Vector<PSDEWizardForm>();
        int nOrderValue = 100;
        for (IPSDEMainState iPSDEMainState : psDEMainStateList) {
            nOrderValue += 100;
            PSDEWizardStep psDEWizardStep = new PSDEWizardStep();
            psDEWizardStep.setPSDEWIZARDID(this.getId());
            psDEWizardStep.setPSDEWIZARDNAME(this.getName());
            psDEWizardStep.setPSDEWIZARDSTEPID(iPSDEMainState.getCodeName());
            psDEWizardStep.setSTEPTAG(iPSDEMainState.getCodeName());
            psDEWizardStep.setPSDEWIZARDSTEPNAME(iPSDEMainState.getName());
            psDEWizardStep.setORDERVALUE(nOrderValue);
            psDEWizardStepList.add(psDEWizardStep);
        }
        nOrderValue = 100;
        for (IPSDEMainState iPSDEMainState : psDEMainStateList) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEMainState.getQuickPSDEFormId())) continue;
            nOrderValue += 100;
            PSDEWizardForm psDEWizardForm = new PSDEWizardForm();
            psDEWizardForm.setPSDEWIZARDID(this.getId());
            psDEWizardForm.setPSDEWIZARDNAME(this.getName());
            psDEWizardForm.setPSDEWIZARDSTEPID(iPSDEMainState.getCodeName());
            psDEWizardForm.setPSDEWIZARDSTEPNAME(iPSDEMainState.getName());
            psDEWizardForm.setPSDEWIZARDFORMID(iPSDEMainState.getCodeName());
            psDEWizardForm.setPSDEWIZARDFORMNAME(iPSDEMainState.getName());
            psDEWizardForm.setPSDEFORMID(iPSDEMainState.getQuickPSDEFormId());
            psDEWizardForm.setMOBPSDEFORMID(iPSDEMainState.getMobQuickPSDEFormId());
            psDEWizardForm.setFORMTAG(iPSDEMainState.getCodeName());
            psDEWizardFormList.add(psDEWizardForm);
        }
        for (PSDEWizardStep pSDEWizardStep : psDEWizardStepList) {
            PSDEWizardStepImpl iPSDEWizardStep = new PSDEWizardStepImpl();
            iPSDEWizardStep.init(this.getDAGlobalHelper(), this, pSDEWizardStep);
            this.psDEWizardStepList.add(iPSDEWizardStep);
            this.psDEWizardStepMap.put(iPSDEWizardStep.getId(), iPSDEWizardStep);
        }
        for (PSDEWizardForm pSDEWizardForm : psDEWizardFormList) {
            PSDEWizardFormImpl iPSDEWizardForm = new PSDEWizardFormImpl();
            iPSDEWizardForm.init(this.getDAGlobalHelper(), this, pSDEWizardForm);
            this.psDEWizardFormList.add(iPSDEWizardForm);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4\u96c6\u5408", child=true)
    public Iterator<IPSDEWizardStep> getPSDEWizardSteps() {
        return this.psDEWizardStepList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSDEWIZARD";
    }

    @Override
    @PSModelRTMeta(description="\u521d\u59cb\u5316\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61")
    public IPSDEAction getInitPSDEAction() {
        return this.initPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u6210\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61")
    public IPSDEAction getFinishPSDEAction() {
        return this.finishPSDEAction;
    }

    @Override
    public IPSDEWizardStep getPSDEWizardStep(String strPSDEWizardStepId) throws Exception {
        IPSDEWizardStep iPSDEWizardStep = this.psDEWizardStepMap.get(strPSDEWizardStepId);
        if (iPSDEWizardStep != null) {
            return iPSDEWizardStep;
        }
        throw PSDEWizardException.create(this, 20010, (Object)strPSDEWizardStepId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5411\u5bfc\u8868\u5355\u96c6\u5408", child=true)
    public Iterator<IPSDEWizardForm> getPSDEWizardForms() {
        return this.psDEWizardFormList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e00\u6b65\u6807\u9898", fields={"PREVCAPTION"})
    public String getPrevCaption() {
        return this.strPrevCaption;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u6807\u9898", fields={"NEXTCAPTION"})
    public String getNextCaption() {
        return this.strNextCaption;
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u6210\u6807\u9898", fields={"FINISHCAPTION"})
    public String getFinishCaption() {
        return this.strFinishCaption;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e00\u6b65\u6807\u9898\u8bed\u8a00\u8d44\u6e90", hideempty=true, fields={"PREVPSLANRESID"})
    public IPSLanguageRes getPrevCapPSLanguageRes() {
        return this.prevCapPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u6807\u9898\u8bed\u8a00\u8d44\u6e90", hideempty=true, fields={"NEXTPSLANRESID"})
    public IPSLanguageRes getNextCapPSLanguageRes() {
        return this.nextCapPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u6210\u6807\u9898\u8bed\u8a00\u8d44\u6e90", hideempty=true, fields={"FINISHPSLANRESID"})
    public IPSLanguageRes getFinishCapPSLanguageRes() {
        return this.finishCapPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e00\u6b65\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u6807\u8bc6", hideempty2=true)
    public String getPrevCapLanResTag() {
        if (this.getPrevCapPSLanguageRes() != null) {
            return this.getPrevCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u6807\u8bc6", hideempty2=true)
    public String getNextCapLanResTag() {
        if (this.getNextCapPSLanguageRes() != null) {
            return this.getNextCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u6210\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u6807\u8bc6", hideempty2=true)
    public String getFinishCapLanResTag() {
        if (this.getFinishCapPSLanguageRes() != null) {
            return this.getFinishCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9996\u5411\u5bfc\u8868\u5355", dumpref=true, from="__self__")
    public IPSDEWizardForm getFirstPSDEWizardForm() {
        if (this.psDEWizardFormList != null) {
            for (IPSDEWizardForm iPSDEWizardForm : this.psDEWizardFormList) {
                if (!iPSDEWizardForm.isFirstForm()) continue;
                return iPSDEWizardForm;
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u6837\u5f0f", codelist="DEWizardStyle", fields={"WIZARDSTYLE"})
    public String getWizardStyle() {
        return this.strWizardStyle;
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u6001\u5c5e\u6027", fields={"STATEPSDEFID"})
    public IPSDEField getStatePSDEField() {
        return this.statePSDEField;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u6001\u5411\u5bfc", fields={"STATEWIZARDFLAG"})
    public boolean isStateWizard() {
        return this.bStateWizard;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u4e3b\u72b6\u6001\u8fc1\u79fb\u903b\u8f91", ignoredumpvalues="false")
    public boolean isEnableMainStateLogic() {
        return this.bEnableMainStateLogic;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u8fc1\u79fb\u903b\u8f91")
    public IPSDEMSLogic getPSDEMSLogic() {
        return this.iPSDEMSLogic;
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u903b\u8f91\u96c6\u5408")
    public Iterator<? extends IPSDEWizardLogic> getPSDEWizardLogics() {
        if (this.psDEWizardLogicList == null || this.psDEWizardLogicList.size() == 0) {
            return null;
        }
        return this.psDEWizardLogicList.iterator();
    }
}
