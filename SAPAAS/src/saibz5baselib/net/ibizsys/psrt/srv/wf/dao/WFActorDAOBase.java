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
import net.ibizsys.psrt.srv.wf.demodel.WFActorDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFActor;

public abstract class WFActorDAOBase
extends PSRuntimeSysDAOBase<WFActor> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFActorDEModel wFActorDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFActorDAO";
    }

    public WFActorDEModel getWFActorDEModel() {
        if (this.wFActorDEModel == null) {
            try {
                this.wFActorDEModel = (WFActorDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFActorDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFActorDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFActorDEModel();
    }
}

