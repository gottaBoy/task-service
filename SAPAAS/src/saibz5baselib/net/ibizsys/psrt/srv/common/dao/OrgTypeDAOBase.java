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
import net.ibizsys.psrt.srv.common.demodel.OrgTypeDEModel;
import net.ibizsys.psrt.srv.common.entity.OrgType;

public abstract class OrgTypeDAOBase
extends PSRuntimeSysDAOBase<OrgType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private OrgTypeDEModel orgTypeDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.OrgTypeDAO";
    }

    public OrgTypeDEModel getOrgTypeDEModel() {
        if (this.orgTypeDEModel == null) {
            try {
                this.orgTypeDEModel = (OrgTypeDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.orgTypeDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getOrgTypeDEModel();
    }
}

