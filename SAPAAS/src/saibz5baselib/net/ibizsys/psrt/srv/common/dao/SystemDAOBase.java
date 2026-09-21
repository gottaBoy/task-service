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
import net.ibizsys.psrt.srv.common.demodel.SystemDEModel;
import net.ibizsys.psrt.srv.common.entity.System;

public abstract class SystemDAOBase
extends PSRuntimeSysDAOBase<System> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private SystemDEModel systemDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.SystemDAO";
    }

    public SystemDEModel getSystemDEModel() {
        if (this.systemDEModel == null) {
            try {
                this.systemDEModel = (SystemDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.SystemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.systemDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getSystemDEModel();
    }
}

