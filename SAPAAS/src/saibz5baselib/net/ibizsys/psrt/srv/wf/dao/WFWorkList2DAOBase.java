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
import net.ibizsys.psrt.srv.wf.demodel.WFWorkList2DEModel;
import net.ibizsys.psrt.srv.wf.entity.WFWorkList2;

public abstract class WFWorkList2DAOBase
extends PSRuntimeSysDAOBase<WFWorkList2> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFWorkList2DEModel wFWorkList2DEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFWorkList2DAO";
    }

    public WFWorkList2DEModel getWFWorkList2DEModel() {
        if (this.wFWorkList2DEModel == null) {
            try {
                this.wFWorkList2DEModel = (WFWorkList2DEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFWorkList2DEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFWorkList2DEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFWorkList2DEModel();
    }
}

