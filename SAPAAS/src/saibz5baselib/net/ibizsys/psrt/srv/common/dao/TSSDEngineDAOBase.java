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
import net.ibizsys.psrt.srv.common.demodel.TSSDEngineDEModel;
import net.ibizsys.psrt.srv.common.entity.TSSDEngine;

public abstract class TSSDEngineDAOBase
extends PSRuntimeSysDAOBase<TSSDEngine> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private TSSDEngineDEModel tSSDEngineDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.TSSDEngineDAO";
    }

    public TSSDEngineDEModel getTSSDEngineDEModel() {
        if (this.tSSDEngineDEModel == null) {
            try {
                this.tSSDEngineDEModel = (TSSDEngineDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDEngineDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDEngineDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getTSSDEngineDEModel();
    }
}

