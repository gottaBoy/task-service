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
import net.ibizsys.psrt.srv.wf.demodel.WFUserCandidateDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFUserCandidate;

public abstract class WFUserCandidateDAOBase
extends PSRuntimeSysDAOBase<WFUserCandidate> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFUserCandidateDEModel wFUserCandidateDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFUserCandidateDAO";
    }

    public WFUserCandidateDEModel getWFUserCandidateDEModel() {
        if (this.wFUserCandidateDEModel == null) {
            try {
                this.wFUserCandidateDEModel = (WFUserCandidateDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFUserCandidateDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFUserCandidateDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFUserCandidateDEModel();
    }
}

