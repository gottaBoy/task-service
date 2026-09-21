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
package net.ibizsys.pscore.srv.paasmgr.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSDCServerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDCServer;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCServerDAO
extends PSCoreSysDAOBase<PSDCServer> {
    private static final long serialVersionUID = -1L;
    private PSDCServerDEModel pSDCServerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSDCServerDAO";
    }

    public PSDCServerDEModel getPSDCServerDEModel() {
        if (this.pSDCServerDEModel == null) {
            try {
                this.pSDCServerDEModel = (PSDCServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSDCServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCServerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCServerDEModel();
    }
}

