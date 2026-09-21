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
import net.ibizsys.psrt.srv.common.demodel.TSSDPolicyOwnerDEModel;
import net.ibizsys.psrt.srv.common.entity.TSSDPolicyOwner;

public abstract class TSSDPolicyOwnerDAOBase
extends PSRuntimeSysDAOBase<TSSDPolicyOwner> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private TSSDPolicyOwnerDEModel tSSDPolicyOwnerDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.TSSDPolicyOwnerDAO";
    }

    public TSSDPolicyOwnerDEModel getTSSDPolicyOwnerDEModel() {
        if (this.tSSDPolicyOwnerDEModel == null) {
            try {
                this.tSSDPolicyOwnerDEModel = (TSSDPolicyOwnerDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDPolicyOwnerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDPolicyOwnerDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getTSSDPolicyOwnerDEModel();
    }
}

