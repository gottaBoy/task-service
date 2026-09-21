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
import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaViewInstDEModel;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;

public abstract class DSDynaViewInstDAOBase
extends PSRuntimeSysDAOBase<DSDynaViewInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VIEW0 = "View0";
    private DSDynaViewInstDEModel dSDynaViewInstDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.dynasys.dao.DSDynaViewInstDAO";
    }

    public DSDynaViewInstDEModel getDSDynaViewInstDEModel() {
        if (this.dSDynaViewInstDEModel == null) {
            try {
                this.dSDynaViewInstDEModel = (DSDynaViewInstDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.dynasys.demodel.DSDynaViewInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dSDynaViewInstDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDSDynaViewInstDEModel();
    }
}

