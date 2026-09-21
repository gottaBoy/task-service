/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardStep;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSDEWizardStep;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEWizardStepImpl
extends PSObjectImpl
implements IPSDEWizardStep {
    private static final Log log = LogFactory.getLog(PSDEWizardStepImpl.class);
    private IPSDEWizard iPSDEWizard = null;
    private PSDEWizardStep psDEWizardStep = null;
    private String strStepTag = null;
    private boolean bEnableLink = false;
    private String strSubTitle = null;
    private IPSSysCss titlePSSysCss = null;
    private IPSLanguageRes titlePSLanguageRes = null;
    private IPSLanguageRes subTitlePSLanguageRes = null;
    private IPSSysImage iPSSysImage = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEWizard iPSDEWizard, PSDEWizardStep psDEWizardStep) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEWizard(iPSDEWizard);
            this.setPSDEWizardStepData(psDEWizardStep);
            this.setId(this.psDEWizardStep.getPSDEWIZARDSTEPID());
            this.setName(this.psDEWizardStep.getPSDEWIZARDSTEPNAME());
            this.setPSObjectData(this.psDEWizardStep);
            this.strStepTag = psDEWizardStep.getSTEPTAG();
            if (!this.psDEWizardStep.isENABLELINKNull()) {
                this.bEnableLink = this.psDEWizardStep.getENABLELINK();
            }
            this.strSubTitle = this.psDEWizardStep.getSUBTITLE();
            if (!StringHelper.isNullOrEmpty((String)this.psDEWizardStep.getPSSYSCSSID())) {
                this.titlePSSysCss = this.getPSDEWizard().getPSDataEntity().getPSSystem().getPSSysCss(this.psDEWizardStep.getPSSYSCSSID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEWizardStep.getLNPSLANRESID())) {
                this.titlePSLanguageRes = this.getPSDEWizard().getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEWizardStep.getLNPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEWizardStep.getSUBTITLEPSLANRESID())) {
                this.subTitlePSLanguageRes = this.getPSDEWizard().getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEWizardStep.getSUBTITLEPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEWizardStep.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSDEWizard().getPSDataEntity().getPSSystem().getPSSysImage(this.psDEWizardStep.getPSSYSIMAGEID());
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
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5411\u5bfc\u5bf9\u8c61")
    public IPSDEWizard getPSDEWizard() {
        return this.iPSDEWizard;
    }

    protected void setPSDEWizard(IPSDEWizard iPSDEWizard) {
        this.iPSDEWizard = iPSDEWizard;
    }

    public PSDEWizardStep getPSDEWizardStepData() {
        return this.psDEWizardStep;
    }

    protected void setPSDEWizardStepData(PSDEWizardStep psDEWizardStep) {
        this.psDEWizardStep = psDEWizardStep;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEWizard.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u6b65\u9aa4\u6807\u8bc6", fields={"STEPTAG"})
    public String getStepTag() {
        return this.strStepTag;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u94fe\u63a5", fields={"ENABLELINK"})
    public boolean isEnableLink() {
        return this.bEnableLink;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u62ac\u5934", fields={"SUBTITLE"})
    public String getSubTitle() {
        return this.strSubTitle;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u6837\u5f0f\u8868\u5bf9\u8c61", fields={"PSSYSCSSID"})
    public IPSSysCss getTitlePSSysCss() {
        return this.titlePSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934", fields={"PSDEWIZARDSTEPNAME"})
    public String getTitle() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"LNPSLANRESID"})
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.titlePSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u62ac\u5934\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"SUBTITLEPSLANRESID"})
    public IPSLanguageRes getSubTitlePSLanguageRes() {
        return this.subTitlePSLanguageRes;
    }

    @Override
    public String getModelType() {
        return "PSDEWIZARDSTEP";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEWizard().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEWizard().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEWizard().getModelId(), (Object)this.getId());
    }
}

