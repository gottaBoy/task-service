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
import net.ibizsys.psrt.srv.common.demodel.TSSDGroupDetailDEModel;
import net.ibizsys.psrt.srv.common.entity.TSSDGroupDetail;

public abstract class TSSDGroupDetailDAOBase
extends PSRuntimeSysDAOBase<TSSDGroupDetail> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private TSSDGroupDetailDEModel tSSDGroupDetailDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.TSSDGroupDetailDAO";
    }

    public TSSDGroupDetailDEModel getTSSDGroupDetailDEModel() {
        if (this.tSSDGroupDetailDEModel == null) {
            try {
                this.tSSDGroupDetailDEModel = (TSSDGroupDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDGroupDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDGroupDetailDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getTSSDGroupDetailDEModel();
    }
}

