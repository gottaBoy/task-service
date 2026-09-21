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
import net.ibizsys.psrt.srv.common.demodel.TSSDTaskTypeDEModel;
import net.ibizsys.psrt.srv.common.entity.TSSDTaskType;

public abstract class TSSDTaskTypeDAOBase
extends PSRuntimeSysDAOBase<TSSDTaskType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private TSSDTaskTypeDEModel tSSDTaskTypeDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.TSSDTaskTypeDAO";
    }

    public TSSDTaskTypeDEModel getTSSDTaskTypeDEModel() {
        if (this.tSSDTaskTypeDEModel == null) {
            try {
                this.tSSDTaskTypeDEModel = (TSSDTaskTypeDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDTaskTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDTaskTypeDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getTSSDTaskTypeDEModel();
    }
}

