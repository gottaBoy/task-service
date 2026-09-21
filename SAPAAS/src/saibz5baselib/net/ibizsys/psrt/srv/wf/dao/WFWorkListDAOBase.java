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
import net.ibizsys.psrt.srv.wf.demodel.WFWorkListDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFWorkList;

public abstract class WFWorkListDAOBase
extends PSRuntimeSysDAOBase<WFWorkList> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFWorkListDEModel wFWorkListDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFWorkListDAO";
    }

    public WFWorkListDEModel getWFWorkListDEModel() {
        if (this.wFWorkListDEModel == null) {
            try {
                this.wFWorkListDEModel = (WFWorkListDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFWorkListDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFWorkListDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFWorkListDEModel();
    }
}

