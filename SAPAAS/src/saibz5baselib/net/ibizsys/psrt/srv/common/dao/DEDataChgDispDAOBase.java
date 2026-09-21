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
import net.ibizsys.psrt.srv.common.demodel.DEDataChgDispDEModel;
import net.ibizsys.psrt.srv.common.entity.DEDataChgDisp;

public abstract class DEDataChgDispDAOBase
extends PSRuntimeSysDAOBase<DEDataChgDisp> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DEDataChgDispDEModel dEDataChgDispDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.DEDataChgDispDAO";
    }

    public DEDataChgDispDEModel getDEDataChgDispDEModel() {
        if (this.dEDataChgDispDEModel == null) {
            try {
                this.dEDataChgDispDEModel = (DEDataChgDispDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DEDataChgDispDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dEDataChgDispDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDEDataChgDispDEModel();
    }
}

