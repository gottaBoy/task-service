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
import net.ibizsys.psrt.srv.common.demodel.DataAuditDEModel;
import net.ibizsys.psrt.srv.common.entity.DataAudit;

public abstract class DataAuditDAOBase
extends PSRuntimeSysDAOBase<DataAudit> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DataAuditDEModel dataAuditDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.DataAuditDAO";
    }

    public DataAuditDEModel getDataAuditDEModel() {
        if (this.dataAuditDEModel == null) {
            try {
                this.dataAuditDEModel = (DataAuditDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DataAuditDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dataAuditDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDataAuditDEModel();
    }
}

