/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEEditFormParam;
import SA.SRFDA.PS.Core.Control.Form.IPSDEWizardEditFormParam;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardForm;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEEditFormParamImpl
extends PSDEFormParamImpl
implements IPSDEEditFormParam,
IPSDEWizardEditFormParam {
    private IPSDEWizardForm iPSDEWizardForm = null;
    private Boolean bEnableAutoSave = null;
    private Boolean bActiveDataMode = null;
    private String strActiveDataField = "";
    private String strPSSysCounterId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psDEViewCtrl.isCTRLPARAM5Null()) {
            this.setEnableAutoSave(this.psDEViewCtrl.getCTRLPARAM5());
        }
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u8868\u5355", hideempty=true, dumpref=true)
    public IPSDEWizardForm getPSDEWizardForm() {
        return this.iPSDEWizardForm;
    }

    public void setPSDEWizardForm(IPSDEWizardForm iPSDEWizardForm) {
        this.iPSDEWizardForm = iPSDEWizardForm;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEEditFormParam) {
            IPSDEEditFormParam iPSDEEditFormParam = (IPSDEEditFormParam)iPSControlParam;
            if (iPSDEEditFormParam.isEnableAutoSave() != null) {
                this.setEnableAutoSave(iPSDEEditFormParam.isEnableAutoSave());
            }
            if (iPSDEEditFormParam.isActiveDataMode() != null) {
                this.setActiveDataMode(iPSDEEditFormParam.isActiveDataMode());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEEditFormParam.getActiveDataField())) {
                this.setActiveDataField(iPSDEEditFormParam.getActiveDataField());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEEditFormParam.getPSSysCounterId())) {
                this.setPSSysCounterId(iPSDEEditFormParam.getPSSysCounterId());
            }
        }
        if (iPSControlParam instanceof IPSDEWizardEditFormParam) {
            IPSDEWizardEditFormParam iPSDEFormParam = (IPSDEWizardEditFormParam)iPSControlParam;
            if (this.getPSDEWizardForm() == null) {
                this.setPSDEWizardForm(iPSDEFormParam.getPSDEWizardForm());
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u4fdd\u5b58", hideempty=true)
    public Boolean isEnableAutoSave() {
        if (this.bEnableAutoSave == null) {
            return null;
        }
        return this.bEnableAutoSave;
    }

    public void setEnableAutoSave(Boolean bEnableAutoSave) {
        this.bEnableAutoSave = bEnableAutoSave;
    }

    @Override
    public Boolean isActiveDataMode() {
        return this.bActiveDataMode;
    }

    public void setActiveDataMode(Boolean bActiveDataMode) {
        this.bActiveDataMode = bActiveDataMode;
    }

    @Override
    public String getActiveDataField() {
        return this.strActiveDataField;
    }

    public void setActiveDataField(String strActiveDataField) {
        this.strActiveDataField = strActiveDataField;
    }

    @Override
    public String getPSSysCounterId() {
        return this.strPSSysCounterId;
    }

    public void setPSSysCounterId(String strPSSysCounterId) {
        this.strPSSysCounterId = strPSSysCounterId;
    }
}

