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
import net.ibizsys.psrt.srv.common.demodel.OrgSectorDEModel;
import net.ibizsys.psrt.srv.common.entity.OrgSector;

public abstract class OrgSectorDAOBase
extends PSRuntimeSysDAOBase<OrgSector> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURCHILD = "CurChild";
    public static final String DATAQUERY_CURORG = "CurOrg";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_ORGROOT = "OrgRoot";
    public static final String DATAQUERY_USERORG = "UserOrg";
    public static final String DATAQUERY_USERORGSECTOR = "UserOrgSector";
    private OrgSectorDEModel orgSectorDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.OrgSectorDAO";
    }

    public OrgSectorDEModel getOrgSectorDEModel() {
        if (this.orgSectorDEModel == null) {
            try {
                this.orgSectorDEModel = (OrgSectorDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgSectorDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.orgSectorDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getOrgSectorDEModel();
    }
}

