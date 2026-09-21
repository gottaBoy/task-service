/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.dynasys.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaCodeListDEModel;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList;

public abstract class DSDynaCodeListDAOBase
extends PSRuntimeSysDAOBase<DSDynaCodeList> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DSDynaCodeListDEModel dSDynaCodeListDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.dynasys.dao.DSDynaCodeListDAO";
    }

    public DSDynaCodeListDEModel getDSDynaCodeListDEModel() {
        if (this.dSDynaCodeListDEModel == null) {
            try {
                this.dSDynaCodeListDEModel = (DSDynaCodeListDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.dynasys.demodel.DSDynaCodeListDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dSDynaCodeListDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDSDynaCodeListDEModel();
    }
}

