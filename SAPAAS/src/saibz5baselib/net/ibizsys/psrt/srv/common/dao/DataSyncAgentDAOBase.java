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
import net.ibizsys.psrt.srv.common.demodel.DataSyncAgentDEModel;
import net.ibizsys.psrt.srv.common.entity.DataSyncAgent;

public abstract class DataSyncAgentDAOBase
extends PSRuntimeSysDAOBase<DataSyncAgent> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DataSyncAgentDEModel dataSyncAgentDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.DataSyncAgentDAO";
    }

    public DataSyncAgentDEModel getDataSyncAgentDEModel() {
        if (this.dataSyncAgentDEModel == null) {
            try {
                this.dataSyncAgentDEModel = (DataSyncAgentDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DataSyncAgentDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dataSyncAgentDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDataSyncAgentDEModel();
    }
}

