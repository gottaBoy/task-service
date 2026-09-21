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
import net.ibizsys.psrt.srv.common.demodel.DataSyncOutDEModel;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut;

public abstract class DataSyncOutDAOBase
extends PSRuntimeSysDAOBase<DataSyncOut> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DataSyncOutDEModel dataSyncOutDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.DataSyncOutDAO";
    }

    public DataSyncOutDEModel getDataSyncOutDEModel() {
        if (this.dataSyncOutDEModel == null) {
            try {
                this.dataSyncOutDEModel = (DataSyncOutDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DataSyncOutDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dataSyncOutDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDataSyncOutDEModel();
    }
}

