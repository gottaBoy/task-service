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
import net.ibizsys.psrt.srv.common.demodel.TSSDTaskLogDEModel;
import net.ibizsys.psrt.srv.common.entity.TSSDTaskLog;

public abstract class TSSDTaskLogDAOBase
extends PSRuntimeSysDAOBase<TSSDTaskLog> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private TSSDTaskLogDEModel tSSDTaskLogDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.TSSDTaskLogDAO";
    }

    public TSSDTaskLogDEModel getTSSDTaskLogDEModel() {
        if (this.tSSDTaskLogDEModel == null) {
            try {
                this.tSSDTaskLogDEModel = (TSSDTaskLogDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDTaskLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDTaskLogDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getTSSDTaskLogDEModel();
    }
}

