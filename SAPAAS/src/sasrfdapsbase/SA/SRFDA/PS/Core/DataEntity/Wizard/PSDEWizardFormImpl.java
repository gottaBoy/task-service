/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardForm;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardStep;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEWizardForm;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEWizardFormImpl
extends PSObjectImpl
implements IPSDEWizardForm {
    private static final Log log = LogFactory.getLog(PSDEWizardFormImpl.class);
    private IPSDEWizard iPSDEWizard = null;
    private PSDEWizardForm psDEWizardForm = null;
    private String[] stepActions = null;
    private IPSDEAction loadPSDEAction = null;
    private IPSDEAction savePSDEAction = null;
    private IPSDEAction prevPSDEAction = null;
    private String strPSDEFormId = null;
    private String strPSDEFormName = null;
    private String strMobPSDEFormId = null;
    private String strMobPSDEFormName = null;
    private String strFormTag = null;
    private boolean bFirstForm = false;
    private IPSDEWizardStep iPSDEWizardStep = null;
    private IPSLanguageRes cmPSLanguageRes = null;
    private IPSLanguageRes cm2PSLanguageRes = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEWizard iPSDEWizard, PSDEWizardForm psDEWizardForm) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEWizard(iPSDEWizard);
            this.setPSDEWizardFormData(psDEWizardForm);
            this.setId(this.psDEWizardForm.getPSDEWIZARDFORMID());
            this.setName(this.psDEWizardForm.getPSDEWIZARDFORMNAME());
            this.setPSObjectData(this.psDEWizardForm);
            this.strPSDEFormId = psDEWizardForm.getPSDEFORMID();
            this.strPSDEFormName = this.psDEWizardForm.getPSDEFORMNAME();
            this.strMobPSDEFormId = psDEWizardForm.getMOBPSDEFORMID();
            this.strMobPSDEFormName = this.psDEWizardForm.getMOBPSDEFORMNAME();
            if (StringHelper.isNullOrEmpty((String)this.strMobPSDEFormId)) {
                this.strMobPSDEFormId = this.strPSDEFormId;
                this.strMobPSDEFormName = this.strPSDEFormName;
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEWizardForm.getSTEPACTIONS())) {
                this.stepActions = this.psDEWizardForm.getSTEPACTIONS().split("[;]");
            }
            this.strFormTag = this.psDEWizardForm.getFORMTAG();
            if (!this.psDEWizardForm.isFIRSTFORMNull()) {
                this.bFirstForm = this.psDEWizardForm.getFIRSTFORM();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEWizardForm.getCMPSLANRESID())) {
                this.cmPSLanguageRes = this.getPSDEWizard().getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEWizardForm.getCMPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEWizardForm.getCMPSLANRESID2())) {
                this.cm2PSLanguageRes = this.getPSDEWizard().getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEWizardForm.getCMPSLANRESID2());
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
        if (!StringHelper.isNullOrEmpty((String)this.psDEWizardForm.getLOADPSDEACTIONID())) {
            this.loadPSDEAction = this.getPSDEWizard().getPSDataEntity().getPSDEAction(this.psDEWizardForm.getLOADPSDEACTIONID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEWizardForm.getSAVEPSDEACTIONID())) {
            this.savePSDEAction = this.getPSDEWizard().getPSDataEntity().getPSDEAction(this.psDEWizardForm.getSAVEPSDEACTIONID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEWizardForm.getPREVPSDEACTIONID())) {
            this.prevPSDEAction = this.getPSDEWizard().getPSDataEntity().getPSDEAction(this.psDEWizardForm.getPREVPSDEACTIONID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEWizardForm.getPSDEWIZARDSTEPID())) {
            this.iPSDEWizardStep = this.getPSDEWizard().getPSDEWizardStep(this.psDEWizardForm.getPSDEWIZARDSTEPID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5411\u5bfc\u5bf9\u8c61")
    public IPSDEWizard getPSDEWizard() {
        return this.iPSDEWizard;
    }

    protected void setPSDEWizard(IPSDEWizard iPSDEWizard) {
        this.iPSDEWizard = iPSDEWizard;
    }

    public PSDEWizardForm getPSDEWizardFormData() {
        return this.psDEWizardForm;
    }

    protected void setPSDEWizardFormData(PSDEWizardForm psDEWizardForm) {
        this.psDEWizardForm = psDEWizardForm;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEWizard.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u52a0\u8f7d\u6570\u636e\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getLoadPSDEAction() {
        return this.loadPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u4fdd\u5b58\u6570\u636e\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getSavePSDEAction() {
        return this.savePSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u56de\u9000\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getGoBackPSDEAction() {
        return this.prevPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u6b65\u9aa4\u884c\u4e3a", child=true, fields={"STEPACTIONS"})
    public String[] getStepActions() {
        return this.stepActions;
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u8868\u5355\u6807\u8bb0", fields={"FORMTAG"})
    public String getFormTag() {
        return this.strFormTag;
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u6b65\u9aa4\u5bf9\u8c61", dumpref=true, from="IPSDEWizard", fields={"PSDEWIZARDSTEPID"})
    public IPSDEWizardStep getPSDEWizardStep() {
        return this.iPSDEWizardStep;
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u6b65\u9aa4\u6807\u8bb0")
    public String getStepTag() {
        if (this.getPSDEWizardStep() != null) {
            return this.getPSDEWizardStep().getStepTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9996\u8868\u5355", fields={"FIRSTFORM"})
    public boolean isFirstForm() {
        return this.bFirstForm;
    }

    @Override
    public String getPSDEFormId() {
        return this.strPSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8868\u5355\u540d\u79f0", fields={"PSDEFORMNAME"})
    public String getPSDEFormName() {
        return this.strPSDEFormName;
    }

    @Override
    public String getMobPSDEFormId() {
        return this.strMobPSDEFormId;
    }

    @Override
    public String getMobPSDEFormName() {
        return this.strMobPSDEFormName;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u786e\u8ba4\u4fe1\u606f", fields={"CONFIRMINFO"})
    public String getConfirmMsg() {
        return this.psDEWizardForm.getCONFIRMINFO();
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u786e\u8ba4\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90", hideempty2=true, fields={"CMPSLANRESID"})
    public IPSLanguageRes getCMPSLanguageRes() {
        return this.cmPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u786e\u8ba4\u4fe1\u606f2", fields={"CONFIRMINFO2"})
    public String getConfirmMsg2() {
        return this.psDEWizardForm.getCONFIRMINFO2();
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u786e\u8ba4\u4fe1\u606f2\u8bed\u8a00\u8d44\u6e90", hideempty2=true, fields={"CMPSLANRESID2"})
    public IPSLanguageRes getCM2PSLanguageRes() {
        return this.cm2PSLanguageRes;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEWizard().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEWizard().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDEWIZARDFORM";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEWizard().getModelId(), (Object)this.getFormTag());
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u6210\u542f\u7528\u811a\u672c\u4ee3\u7801", fields={"FINISHENABLELOGIC"})
    public String getGoFinishEnableScriptCode() {
        return this.psDEWizardForm.getFINISHENABLELOGIC();
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e00\u6b65\u542f\u7528\u811a\u672c\u4ee3\u7801", fields={"PREVENABLELOGIC"})
    public String getGoPrevEnableScriptCode() {
        return this.psDEWizardForm.getPREVENABLELOGIC();
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u542f\u7528\u811a\u672c\u4ee3\u7801", fields={"NEXTENABLELOGIC"})
    public String getGoNextEnableScriptCode() {
        return this.psDEWizardForm.getNEXTENABLELOGIC();
    }
}

