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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSStudioServerGrpDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerGrp;
import org.springframework.stereotype.Repository;

@Repository
public class PSStudioServerGrpDAO
extends PSCoreSysDAOBase<PSStudioServerGrp> {
    private static final long serialVersionUID = -1L;
    private PSStudioServerGrpDEModel pSStudioServerGrpDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSStudioServerGrpDAO";
    }

    public PSStudioServerGrpDEModel getPSStudioServerGrpDEModel() {
        if (this.pSStudioServerGrpDEModel == null) {
            try {
                this.pSStudioServerGrpDEModel = (PSStudioServerGrpDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSStudioServerGrpDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSStudioServerGrpDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSStudioServerGrpDEModel();
    }
}

