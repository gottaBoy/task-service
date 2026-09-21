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
import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFVerDEModel;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;

public abstract class DSDynaWFVerDAOBase
extends PSRuntimeSysDAOBase<DSDynaWFVer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VIEW0 = "View0";
    private DSDynaWFVerDEModel dSDynaWFVerDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFVerDAO";
    }

    public DSDynaWFVerDEModel getDSDynaWFVerDEModel() {
        if (this.dSDynaWFVerDEModel == null) {
            try {
                this.dSDynaWFVerDEModel = (DSDynaWFVerDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dSDynaWFVerDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDSDynaWFVerDEModel();
    }
}

