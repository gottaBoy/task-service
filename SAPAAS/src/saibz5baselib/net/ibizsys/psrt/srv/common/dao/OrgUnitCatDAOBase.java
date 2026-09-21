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
import net.ibizsys.psrt.srv.common.demodel.OrgUnitCatDEModel;
import net.ibizsys.psrt.srv.common.entity.OrgUnitCat;

public abstract class OrgUnitCatDAOBase
extends PSRuntimeSysDAOBase<OrgUnitCat> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private OrgUnitCatDEModel orgUnitCatDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.OrgUnitCatDAO";
    }

    public OrgUnitCatDEModel getOrgUnitCatDEModel() {
        if (this.orgUnitCatDEModel == null) {
            try {
                this.orgUnitCatDEModel = (OrgUnitCatDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgUnitCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.orgUnitCatDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getOrgUnitCatDEModel();
    }
}

