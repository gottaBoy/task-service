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
import net.ibizsys.psrt.srv.common.demodel.OrgSecUserDEModel;
import net.ibizsys.psrt.srv.common.entity.OrgSecUser;

public abstract class OrgSecUserDAOBase
extends PSRuntimeSysDAOBase<OrgSecUser> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private OrgSecUserDEModel orgSecUserDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.OrgSecUserDAO";
    }

    public OrgSecUserDEModel getOrgSecUserDEModel() {
        if (this.orgSecUserDEModel == null) {
            try {
                this.orgSecUserDEModel = (OrgSecUserDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgSecUserDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.orgSecUserDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getOrgSecUserDEModel();
    }
}

