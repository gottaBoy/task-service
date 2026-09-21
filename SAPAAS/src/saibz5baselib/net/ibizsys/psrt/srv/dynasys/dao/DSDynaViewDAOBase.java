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
import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaViewDEModel;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaView;

public abstract class DSDynaViewDAOBase
extends PSRuntimeSysDAOBase<DSDynaView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DSDynaViewDEModel dSDynaViewDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.dynasys.dao.DSDynaViewDAO";
    }

    public DSDynaViewDEModel getDSDynaViewDEModel() {
        if (this.dSDynaViewDEModel == null) {
            try {
                this.dSDynaViewDEModel = (DSDynaViewDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.dynasys.demodel.DSDynaViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dSDynaViewDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDSDynaViewDEModel();
    }
}

