/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.common.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.common.demodel.PPModelDEModel;
import net.ibizsys.psrt.srv.common.entity.PPModel;

public abstract class PPModelDAOBase
extends PSRuntimeSysDAOBase<PPModel> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PPModelDEModel pPModelDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.PPModelDAO";
    }

    public PPModelDEModel getPPModelDEModel() {
        if (this.pPModelDEModel == null) {
            try {
                this.pPModelDEModel = (PPModelDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.PPModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pPModelDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getPPModelDEModel();
    }
}

