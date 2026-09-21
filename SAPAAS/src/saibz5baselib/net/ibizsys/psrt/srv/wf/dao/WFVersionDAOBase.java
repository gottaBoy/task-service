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
import net.ibizsys.psrt.srv.wf.demodel.WFVersionDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFVersion;

public abstract class WFVersionDAOBase
extends PSRuntimeSysDAOBase<WFVersion> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFVersionDEModel wFVersionDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFVersionDAO";
    }

    public WFVersionDEModel getWFVersionDEModel() {
        if (this.wFVersionDEModel == null) {
            try {
                this.wFVersionDEModel = (WFVersionDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFVersionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFVersionDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFVersionDEModel();
    }
}

