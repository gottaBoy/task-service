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
import net.ibizsys.psrt.srv.common.demodel.TSSDGroupDEModel;
import net.ibizsys.psrt.srv.common.entity.TSSDGroup;

public abstract class TSSDGroupDAOBase
extends PSRuntimeSysDAOBase<TSSDGroup> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private TSSDGroupDEModel tSSDGroupDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.TSSDGroupDAO";
    }

    public TSSDGroupDEModel getTSSDGroupDEModel() {
        if (this.tSSDGroupDEModel == null) {
            try {
                this.tSSDGroupDEModel = (TSSDGroupDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDGroupDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getTSSDGroupDEModel();
    }
}

