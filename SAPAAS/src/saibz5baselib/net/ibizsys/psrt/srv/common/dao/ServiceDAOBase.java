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
import net.ibizsys.psrt.srv.common.demodel.ServiceDEModel;
import net.ibizsys.psrt.srv.common.entity.Service;

public abstract class ServiceDAOBase
extends PSRuntimeSysDAOBase<Service> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private ServiceDEModel serviceDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.ServiceDAO";
    }

    public ServiceDEModel getServiceDEModel() {
        if (this.serviceDEModel == null) {
            try {
                this.serviceDEModel = (ServiceDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.ServiceDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.serviceDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getServiceDEModel();
    }
}

