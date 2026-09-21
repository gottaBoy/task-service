/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.wf.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.wf.demodel.WFSystemUserDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFSystemUser;

public abstract class WFSystemUserDAOBase
extends PSRuntimeSysDAOBase<WFSystemUser> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFSystemUserDEModel wFSystemUserDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFSystemUserDAO";
    }

    public WFSystemUserDEModel getWFSystemUserDEModel() {
        if (this.wFSystemUserDEModel == null) {
            try {
                this.wFSystemUserDEModel = (WFSystemUserDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFSystemUserDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFSystemUserDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFSystemUserDEModel();
    }
}

