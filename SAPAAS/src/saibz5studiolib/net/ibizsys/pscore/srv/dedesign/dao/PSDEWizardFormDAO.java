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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardFormDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardForm;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEWizardFormDAO
extends PSCoreSysDAOBase<PSDEWizardForm> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEWizardFormDEModel pSDEWizardFormDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardFormDAO";
    }

    public PSDEWizardFormDEModel getPSDEWizardFormDEModel() {
        if (this.pSDEWizardFormDEModel == null) {
            try {
                this.pSDEWizardFormDEModel = (PSDEWizardFormDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardFormDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardFormDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEWizardFormDEModel();
    }
}

