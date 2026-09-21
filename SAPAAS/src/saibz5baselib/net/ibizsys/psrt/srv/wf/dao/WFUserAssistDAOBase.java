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
import net.ibizsys.psrt.srv.wf.demodel.WFUserAssistDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFUserAssist;

public abstract class WFUserAssistDAOBase
extends PSRuntimeSysDAOBase<WFUserAssist> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFUserAssistDEModel wFUserAssistDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFUserAssistDAO";
    }

    public WFUserAssistDEModel getWFUserAssistDEModel() {
        if (this.wFUserAssistDEModel == null) {
            try {
                this.wFUserAssistDEModel = (WFUserAssistDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFUserAssistDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFUserAssistDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFUserAssistDEModel();
    }
}

