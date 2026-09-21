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
import net.ibizsys.psrt.srv.wf.demodel.WFAssistWorkDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFAssistWork;

public abstract class WFAssistWorkDAOBase
extends PSRuntimeSysDAOBase<WFAssistWork> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURUSERASSISTWORK = "CurUserAssistWork";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFAssistWorkDEModel wFAssistWorkDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFAssistWorkDAO";
    }

    public WFAssistWorkDEModel getWFAssistWorkDEModel() {
        if (this.wFAssistWorkDEModel == null) {
            try {
                this.wFAssistWorkDEModel = (WFAssistWorkDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFAssistWorkDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFAssistWorkDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFAssistWorkDEModel();
    }
}

