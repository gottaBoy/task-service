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
import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFDEModel;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF;

public abstract class DSDynaWFDAOBase
extends PSRuntimeSysDAOBase<DSDynaWF> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DSDynaWFDEModel dSDynaWFDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFDAO";
    }

    public DSDynaWFDEModel getDSDynaWFDEModel() {
        if (this.dSDynaWFDEModel == null) {
            try {
                this.dSDynaWFDEModel = (DSDynaWFDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dSDynaWFDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDSDynaWFDEModel();
    }
}

