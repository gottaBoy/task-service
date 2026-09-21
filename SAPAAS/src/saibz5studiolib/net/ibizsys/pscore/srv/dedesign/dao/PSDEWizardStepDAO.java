/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  org.springframework.stereotype.Repository
 */
package net.ibizsys.pscore.srv.dedesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardStepDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStep;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEWizardStepDAO
extends PSCoreSysDAOBase<PSDEWizardStep> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDEWIZARD = "CurDEWizard";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEWizardStepDEModel pSDEWizardStepDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardStepDAO";
    }

    public PSDEWizardStepDEModel getPSDEWizardStepDEModel() {
        if (this.pSDEWizardStepDEModel == null) {
            try {
                this.pSDEWizardStepDEModel = (PSDEWizardStepDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardStepDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardStepDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEWizardStepDEModel();
    }
}

