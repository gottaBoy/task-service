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
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCWorkspaceUserDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceUser;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCWorkspaceUserDAO
extends PSCoreSysDAOBase<PSDCWorkspaceUser> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCWorkspaceUserDEModel pSDCWorkspaceUserDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCWorkspaceUserDAO";
    }

    public PSDCWorkspaceUserDEModel getPSDCWorkspaceUserDEModel() {
        if (this.pSDCWorkspaceUserDEModel == null) {
            try {
                this.pSDCWorkspaceUserDEModel = (PSDCWorkspaceUserDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCWorkspaceUserDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCWorkspaceUserDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCWorkspaceUserDEModel();
    }
}

