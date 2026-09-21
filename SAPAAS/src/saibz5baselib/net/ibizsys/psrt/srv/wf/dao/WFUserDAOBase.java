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
import net.ibizsys.psrt.srv.wf.demodel.WFUserDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFUser;

public abstract class WFUserDAOBase
extends PSRuntimeSysDAOBase<WFUser> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFUserDEModel wFUserDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFUserDAO";
    }

    public WFUserDEModel getWFUserDEModel() {
        if (this.wFUserDEModel == null) {
            try {
                this.wFUserDEModel = (WFUserDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFUserDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFUserDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFUserDEModel();
    }
}

