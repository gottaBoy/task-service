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
import net.ibizsys.psrt.srv.common.demodel.TSSDTaskPolicyDEModel;
import net.ibizsys.psrt.srv.common.entity.TSSDTaskPolicy;

public abstract class TSSDTaskPolicyDAOBase
extends PSRuntimeSysDAOBase<TSSDTaskPolicy> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private TSSDTaskPolicyDEModel tSSDTaskPolicyDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.TSSDTaskPolicyDAO";
    }

    public TSSDTaskPolicyDEModel getTSSDTaskPolicyDEModel() {
        if (this.tSSDTaskPolicyDEModel == null) {
            try {
                this.tSSDTaskPolicyDEModel = (TSSDTaskPolicyDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDTaskPolicyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDTaskPolicyDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getTSSDTaskPolicyDEModel();
    }
}

