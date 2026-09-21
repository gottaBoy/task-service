/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.wf.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.wf.demodel.WFUIWizardDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFUIWizard;

public abstract class WFUIWizardDAOBase
extends PSRuntimeSysDAOBase<WFUIWizard> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFUIWizardDEModel wFUIWizardDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFUIWizardDAO";
    }

    public WFUIWizardDEModel getWFUIWizardDEModel() {
        if (this.wFUIWizardDEModel == null) {
            try {
                this.wFUIWizardDEModel = (WFUIWizardDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFUIWizardDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFUIWizardDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFUIWizardDEModel();
    }
}

