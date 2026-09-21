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
import net.ibizsys.psrt.srv.common.demodel.RegistryDEModel;
import net.ibizsys.psrt.srv.common.entity.Registry;

public abstract class RegistryDAOBase
extends PSRuntimeSysDAOBase<Registry> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private RegistryDEModel registryDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.RegistryDAO";
    }

    public RegistryDEModel getRegistryDEModel() {
        if (this.registryDEModel == null) {
            try {
                this.registryDEModel = (RegistryDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.RegistryDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.registryDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getRegistryDEModel();
    }
}

