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
import net.ibizsys.psrt.srv.wf.demodel.WFStepDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFStep;

public abstract class WFStepDAOBase
extends PSRuntimeSysDAOBase<WFStep> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFStepDEModel wFStepDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFStepDAO";
    }

    public WFStepDEModel getWFStepDEModel() {
        if (this.wFStepDEModel == null) {
            try {
                this.wFStepDEModel = (WFStepDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFStepDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFStepDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFStepDEModel();
    }
}

