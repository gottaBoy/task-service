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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSSysPolicyDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSysPolicy;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysPolicyDAO
extends PSCoreSysDAOBase<PSSysPolicy> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysPolicyDEModel pSSysPolicyDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSysPolicyDAO";
    }

    public PSSysPolicyDEModel getPSSysPolicyDEModel() {
        if (this.pSSysPolicyDEModel == null) {
            try {
                this.pSSysPolicyDEModel = (PSSysPolicyDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysPolicyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPolicyDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysPolicyDEModel();
    }
}

