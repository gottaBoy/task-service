/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.form.IPSDEEditFormParam
 *  net.ibizsys.model.control.form.IPSDEWizardEditFormParam
 *  net.ibizsys.model.dataentity.wizard.IPSDEWizardForm
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.form.IPSDEEditFormParam;
import net.ibizsys.model.control.form.IPSDEWizardEditFormParam;
import net.ibizsys.model.control.form.PSDEFormParamImpl;
import net.ibizsys.model.dataentity.wizard.IPSDEWizardForm;

public class PSDEEditFormParamImpl
extends PSDEFormParamImpl
implements IPSDEEditFormParam,
IPSDEWizardEditFormParam {
    private IPSDEWizardForm iPSDEWizardForm = null;

    public IPSDEWizardForm getPSDEWizardForm() {
        return this.iPSDEWizardForm;
    }

    public void setPSDEWizardForm(IPSDEWizardForm iPSDEWizardForm) {
        this.iPSDEWizardForm = iPSDEWizardForm;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEWizardEditFormParam) {
            IPSDEWizardEditFormParam iPSDEFormParam = (IPSDEWizardEditFormParam)iPSControlParam;
            if (this.getPSDEWizardForm() == null) {
                this.setPSDEWizardForm(iPSDEFormParam.getPSDEWizardForm());
            }
        }
    }
}

