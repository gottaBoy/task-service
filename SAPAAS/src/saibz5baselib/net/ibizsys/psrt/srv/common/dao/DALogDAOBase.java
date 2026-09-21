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
import net.ibizsys.psrt.srv.common.demodel.DALogDEModel;
import net.ibizsys.psrt.srv.common.entity.DALog;

public abstract class DALogDAOBase
extends PSRuntimeSysDAOBase<DALog> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DALogDEModel dALogDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.DALogDAO";
    }

    public DALogDEModel getDALogDEModel() {
        if (this.dALogDEModel == null) {
            try {
                this.dALogDEModel = (DALogDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DALogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dALogDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDALogDEModel();
    }
}

