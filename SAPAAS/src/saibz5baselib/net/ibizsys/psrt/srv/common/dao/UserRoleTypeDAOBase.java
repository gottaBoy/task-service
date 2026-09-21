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
import net.ibizsys.psrt.srv.common.demodel.UserRoleTypeDEModel;
import net.ibizsys.psrt.srv.common.entity.UserRoleType;

public abstract class UserRoleTypeDAOBase
extends PSRuntimeSysDAOBase<UserRoleType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserRoleTypeDEModel userRoleTypeDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserRoleTypeDAO";
    }

    public UserRoleTypeDEModel getUserRoleTypeDEModel() {
        if (this.userRoleTypeDEModel == null) {
            try {
                this.userRoleTypeDEModel = (UserRoleTypeDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleTypeDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserRoleTypeDEModel();
    }
}

