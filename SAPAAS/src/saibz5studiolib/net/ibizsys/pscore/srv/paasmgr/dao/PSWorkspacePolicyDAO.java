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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSWorkspacePolicyDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspacePolicy;
import org.springframework.stereotype.Repository;

@Repository
public class PSWorkspacePolicyDAO
extends PSCoreSysDAOBase<PSWorkspacePolicy> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWorkspacePolicyDEModel pSWorkspacePolicyDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSWorkspacePolicyDAO";
    }

    public PSWorkspacePolicyDEModel getPSWorkspacePolicyDEModel() {
        if (this.pSWorkspacePolicyDEModel == null) {
            try {
                this.pSWorkspacePolicyDEModel = (PSWorkspacePolicyDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSWorkspacePolicyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWorkspacePolicyDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWorkspacePolicyDEModel();
    }
}

