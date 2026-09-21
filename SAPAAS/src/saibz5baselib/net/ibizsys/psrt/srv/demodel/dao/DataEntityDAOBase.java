/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.demodel.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.demodel.demodel.DataEntityDEModel;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;

public abstract class DataEntityDAOBase
extends PSRuntimeSysDAOBase<DataEntity> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DataEntityDEModel dataEntityDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.demodel.dao.DataEntityDAO";
    }

    public DataEntityDEModel getDataEntityDEModel() {
        if (this.dataEntityDEModel == null) {
            try {
                this.dataEntityDEModel = (DataEntityDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.demodel.demodel.DataEntityDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dataEntityDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDataEntityDEModel();
    }
}

