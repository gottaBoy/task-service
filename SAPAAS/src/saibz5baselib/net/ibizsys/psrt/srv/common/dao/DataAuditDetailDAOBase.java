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
import net.ibizsys.psrt.srv.common.demodel.DataAuditDetailDEModel;
import net.ibizsys.psrt.srv.common.entity.DataAuditDetail;

public abstract class DataAuditDetailDAOBase
extends PSRuntimeSysDAOBase<DataAuditDetail> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DataAuditDetailDEModel dataAuditDetailDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.DataAuditDetailDAO";
    }

    public DataAuditDetailDEModel getDataAuditDetailDEModel() {
        if (this.dataAuditDetailDEModel == null) {
            try {
                this.dataAuditDetailDEModel = (DataAuditDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DataAuditDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dataAuditDetailDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDataAuditDetailDEModel();
    }
}

