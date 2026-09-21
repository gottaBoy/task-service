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
import net.ibizsys.psrt.srv.common.demodel.DataSyncIn2DEModel;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn2;

public abstract class DataSyncIn2DAOBase
extends PSRuntimeSysDAOBase<DataSyncIn2> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DataSyncIn2DEModel dataSyncIn2DEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.DataSyncIn2DAO";
    }

    public DataSyncIn2DEModel getDataSyncIn2DEModel() {
        if (this.dataSyncIn2DEModel == null) {
            try {
                this.dataSyncIn2DEModel = (DataSyncIn2DEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DataSyncIn2DEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dataSyncIn2DEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDataSyncIn2DEModel();
    }
}

