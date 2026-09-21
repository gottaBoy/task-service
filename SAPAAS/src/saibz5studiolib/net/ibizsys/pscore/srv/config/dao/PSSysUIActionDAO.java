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
import net.ibizsys.pscore.srv.config.demodel.PSSysUIActionDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSysUIAction;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysUIActionDAO
extends PSCoreSysDAOBase<PSSysUIAction> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysUIActionDEModel pSSysUIActionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSysUIActionDAO";
    }

    public PSSysUIActionDEModel getPSSysUIActionDEModel() {
        if (this.pSSysUIActionDEModel == null) {
            try {
                this.pSSysUIActionDEModel = (PSSysUIActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysUIActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUIActionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysUIActionDEModel();
    }
}

