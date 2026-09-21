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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCWorkspaceActionDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceAction;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCWorkspaceActionDAO
extends PSCoreSysDAOBase<PSDCWorkspaceAction> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCWorkspaceActionDEModel pSDCWorkspaceActionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCWorkspaceActionDAO";
    }

    public PSDCWorkspaceActionDEModel getPSDCWorkspaceActionDEModel() {
        if (this.pSDCWorkspaceActionDEModel == null) {
            try {
                this.pSDCWorkspaceActionDEModel = (PSDCWorkspaceActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCWorkspaceActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCWorkspaceActionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCWorkspaceActionDEModel();
    }
}

