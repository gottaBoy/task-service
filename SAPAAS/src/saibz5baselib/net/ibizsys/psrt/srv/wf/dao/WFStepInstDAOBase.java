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
import net.ibizsys.psrt.srv.wf.demodel.WFStepInstDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFStepInst;

public abstract class WFStepInstDAOBase
extends PSRuntimeSysDAOBase<WFStepInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFStepInstDEModel wFStepInstDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFStepInstDAO";
    }

    public WFStepInstDEModel getWFStepInstDEModel() {
        if (this.wFStepInstDEModel == null) {
            try {
                this.wFStepInstDEModel = (WFStepInstDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFStepInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFStepInstDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFStepInstDEModel();
    }
}

