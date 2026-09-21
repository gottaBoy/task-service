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
import net.ibizsys.psrt.srv.common.demodel.DataSyncOut2DEModel;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut2;

public abstract class DataSyncOut2DAOBase
extends PSRuntimeSysDAOBase<DataSyncOut2> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DataSyncOut2DEModel dataSyncOut2DEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.DataSyncOut2DAO";
    }

    public DataSyncOut2DEModel getDataSyncOut2DEModel() {
        if (this.dataSyncOut2DEModel == null) {
            try {
                this.dataSyncOut2DEModel = (DataSyncOut2DEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DataSyncOut2DEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dataSyncOut2DEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDataSyncOut2DEModel();
    }
}

