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
import net.ibizsys.psrt.srv.wf.demodel.WFDynamicUserDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFDynamicUser;

public abstract class WFDynamicUserDAOBase
extends PSRuntimeSysDAOBase<WFDynamicUser> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFDynamicUserDEModel wFDynamicUserDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFDynamicUserDAO";
    }

    public WFDynamicUserDEModel getWFDynamicUserDEModel() {
        if (this.wFDynamicUserDEModel == null) {
            try {
                this.wFDynamicUserDEModel = (WFDynamicUserDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFDynamicUserDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFDynamicUserDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFDynamicUserDEModel();
    }
}

