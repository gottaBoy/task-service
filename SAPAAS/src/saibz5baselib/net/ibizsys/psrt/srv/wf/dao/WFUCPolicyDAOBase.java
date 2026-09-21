/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.wf.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.wf.demodel.WFUCPolicyDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFUCPolicy;

public abstract class WFUCPolicyDAOBase
extends PSRuntimeSysDAOBase<WFUCPolicy> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFUCPolicyDEModel wFUCPolicyDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFUCPolicyDAO";
    }

    public WFUCPolicyDEModel getWFUCPolicyDEModel() {
        if (this.wFUCPolicyDEModel == null) {
            try {
                this.wFUCPolicyDEModel = (WFUCPolicyDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFUCPolicyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFUCPolicyDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFUCPolicyDEModel();
    }
}

