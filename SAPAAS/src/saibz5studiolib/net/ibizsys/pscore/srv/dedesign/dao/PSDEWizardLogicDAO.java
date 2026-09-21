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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardLogicDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardLogic;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEWizardLogicDAO
extends PSCoreSysDAOBase<PSDEWizardLogic> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEWizardLogicDEModel pSDEWizardLogicDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardLogicDAO";
    }

    public PSDEWizardLogicDEModel getPSDEWizardLogicDEModel() {
        if (this.pSDEWizardLogicDEModel == null) {
            try {
                this.pSDEWizardLogicDEModel = (PSDEWizardLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardLogicDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEWizardLogicDEModel();
    }
}

