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
import net.ibizsys.psrt.srv.common.demodel.OrgUserLevelDEModel;
import net.ibizsys.psrt.srv.common.entity.OrgUserLevel;

public abstract class OrgUserLevelDAOBase
extends PSRuntimeSysDAOBase<OrgUserLevel> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private OrgUserLevelDEModel orgUserLevelDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.OrgUserLevelDAO";
    }

    public OrgUserLevelDEModel getOrgUserLevelDEModel() {
        if (this.orgUserLevelDEModel == null) {
            try {
                this.orgUserLevelDEModel = (OrgUserLevelDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgUserLevelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.orgUserLevelDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getOrgUserLevelDEModel();
    }
}

