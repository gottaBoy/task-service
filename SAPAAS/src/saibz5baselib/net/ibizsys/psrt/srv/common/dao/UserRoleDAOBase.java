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
import net.ibizsys.psrt.srv.common.demodel.UserRoleDEModel;
import net.ibizsys.psrt.srv.common.entity.UserRole;

public abstract class UserRoleDAOBase
extends PSRuntimeSysDAOBase<UserRole> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserRoleDEModel userRoleDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserRoleDAO";
    }

    public UserRoleDEModel getUserRoleDEModel() {
        if (this.userRoleDEModel == null) {
            try {
                this.userRoleDEModel = (UserRoleDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserRoleDEModel();
    }
}

