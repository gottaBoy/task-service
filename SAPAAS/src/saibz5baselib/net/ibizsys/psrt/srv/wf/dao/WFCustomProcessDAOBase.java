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
import net.ibizsys.psrt.srv.wf.demodel.WFCustomProcessDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFCustomProcess;

public abstract class WFCustomProcessDAOBase
extends PSRuntimeSysDAOBase<WFCustomProcess> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFCustomProcessDEModel wFCustomProcessDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFCustomProcessDAO";
    }

    public WFCustomProcessDEModel getWFCustomProcessDEModel() {
        if (this.wFCustomProcessDEModel == null) {
            try {
                this.wFCustomProcessDEModel = (WFCustomProcessDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFCustomProcessDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFCustomProcessDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFCustomProcessDEModel();
    }
}

