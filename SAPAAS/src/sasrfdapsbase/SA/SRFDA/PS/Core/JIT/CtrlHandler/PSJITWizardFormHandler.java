/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.Form.IPSDEWizardEditForm;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardForm;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.PSJITEditFormHandler;
import net.ibizsys.paas.entity.IEntity;

public class PSJITWizardFormHandler
extends PSJITEditFormHandler {
    private IPSDEWizardForm iPSDEWizardForm = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.iPSDEWizardForm = this.getPSDEWizardEditForm().getPSDEWizardForm();
    }

    public IPSDEWizardEditForm getPSDEWizardEditForm() {
        return (IPSDEWizardEditForm)this.getPSDEForm();
    }

    public IPSDEWizardForm getPSDEWizardForm() {
        return this.iPSDEWizardForm;
    }

    @Override
    protected IEntity getEntity(Object objKeyValue) throws Exception {
        if (this.getPSDEWizardForm() == null && this.getPSDEWizardForm().getLoadPSDEAction() == null) {
            return super.getEntity(objKeyValue);
        }
        IEntity entity = this.getDEModel().createEntity();
        entity.set(this.getDEModel().getKeyDEField().getName().toLowerCase(), objKeyValue);
        this.getService().executeAction(this.getPSDEWizardForm().getLoadPSDEAction().getName().toUpperCase(), entity);
        return entity;
    }

    @Override
    protected String getGetEntityAction() {
        if (this.getPSDEWizardForm() == null && this.getPSDEWizardForm().getLoadPSDEAction() == null) {
            return super.getGetEntityAction();
        }
        return this.getPSDEWizardForm().getLoadPSDEAction().getName().toUpperCase();
    }

    @Override
    protected IEntity updateEntity(IEntity iEntity) throws Exception {
        if (this.getPSDEWizardForm() == null && this.getPSDEWizardForm().getSavePSDEAction() == null) {
            return super.updateEntity(iEntity);
        }
        this.getService().executeAction(this.getPSDEWizardForm().getSavePSDEAction().getName().toUpperCase(), iEntity);
        return iEntity;
    }
}

