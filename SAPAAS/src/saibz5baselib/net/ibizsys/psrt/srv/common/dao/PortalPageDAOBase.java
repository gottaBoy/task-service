/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.common.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.common.demodel.PortalPageDEModel;
import net.ibizsys.psrt.srv.common.entity.PortalPage;

public abstract class PortalPageDAOBase
extends PSRuntimeSysDAOBase<PortalPage> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PortalPageDEModel portalPageDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.PortalPageDAO";
    }

    public PortalPageDEModel getPortalPageDEModel() {
        if (this.portalPageDEModel == null) {
            try {
                this.portalPageDEModel = (PortalPageDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.PortalPageDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.portalPageDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getPortalPageDEModel();
    }
}

