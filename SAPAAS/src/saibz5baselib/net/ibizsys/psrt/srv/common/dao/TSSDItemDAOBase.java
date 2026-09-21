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
import net.ibizsys.psrt.srv.common.demodel.TSSDItemDEModel;
import net.ibizsys.psrt.srv.common.entity.TSSDItem;

public abstract class TSSDItemDAOBase
extends PSRuntimeSysDAOBase<TSSDItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private TSSDItemDEModel tSSDItemDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.TSSDItemDAO";
    }

    public TSSDItemDEModel getTSSDItemDEModel() {
        if (this.tSSDItemDEModel == null) {
            try {
                this.tSSDItemDEModel = (TSSDItemDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDItemDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getTSSDItemDEModel();
    }
}

