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
import net.ibizsys.psrt.srv.common.demodel.OrgUserDEModel;
import net.ibizsys.psrt.srv.common.entity.OrgUser;

public abstract class OrgUserDAOBase
extends PSRuntimeSysDAOBase<OrgUser> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURORG = "CurOrg";
    public static final String DATAQUERY_CURORGSECTOR = "CurOrgSector";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_USERORG = "UserOrg";
    public static final String DATAQUERY_USERORGSECTOR = "UserOrgSector";
    private OrgUserDEModel orgUserDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.OrgUserDAO";
    }

    public OrgUserDEModel getOrgUserDEModel() {
        if (this.orgUserDEModel == null) {
            try {
                this.orgUserDEModel = (OrgUserDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgUserDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.orgUserDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getOrgUserDEModel();
    }
}

