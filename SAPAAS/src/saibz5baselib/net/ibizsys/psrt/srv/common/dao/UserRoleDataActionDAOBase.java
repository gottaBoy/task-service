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
import net.ibizsys.psrt.srv.common.demodel.UserRoleDataActionDEModel;
import net.ibizsys.psrt.srv.common.entity.UserRoleDataAction;

public abstract class UserRoleDataActionDAOBase
extends PSRuntimeSysDAOBase<UserRoleDataAction> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserRoleDataActionDEModel userRoleDataActionDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserRoleDataActionDAO";
    }

    public UserRoleDataActionDEModel getUserRoleDataActionDEModel() {
        if (this.userRoleDataActionDEModel == null) {
            try {
                this.userRoleDataActionDEModel = (UserRoleDataActionDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleDataActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleDataActionDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserRoleDataActionDEModel();
    }
}

