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
import net.ibizsys.psrt.srv.common.demodel.DEDataChgDEModel;
import net.ibizsys.psrt.srv.common.entity.DEDataChg;

public abstract class DEDataChgDAOBase
extends PSRuntimeSysDAOBase<DEDataChg> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DEDataChgDEModel dEDataChgDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.DEDataChgDAO";
    }

    public DEDataChgDEModel getDEDataChgDEModel() {
        if (this.dEDataChgDEModel == null) {
            try {
                this.dEDataChgDEModel = (DEDataChgDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DEDataChgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dEDataChgDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDEDataChgDEModel();
    }
}

