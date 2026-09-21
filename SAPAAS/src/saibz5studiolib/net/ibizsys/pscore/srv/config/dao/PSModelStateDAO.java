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
import net.ibizsys.pscore.srv.config.demodel.PSModelStateDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelState;
import org.springframework.stereotype.Repository;

@Repository
public class PSModelStateDAO
extends PSCoreSysDAOBase<PSModelState> {
    private static final long serialVersionUID = -1L;
    private PSModelStateDEModel pSModelStateDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSModelStateDAO";
    }

    public PSModelStateDEModel getPSModelStateDEModel() {
        if (this.pSModelStateDEModel == null) {
            try {
                this.pSModelStateDEModel = (PSModelStateDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelStateDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelStateDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModelStateDEModel();
    }
}

