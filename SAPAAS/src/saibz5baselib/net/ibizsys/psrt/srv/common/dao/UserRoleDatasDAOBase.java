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
import net.ibizsys.psrt.srv.common.demodel.UserRoleDatasDEModel;
import net.ibizsys.psrt.srv.common.entity.UserRoleDatas;

public abstract class UserRoleDatasDAOBase
extends PSRuntimeSysDAOBase<UserRoleDatas> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserRoleDatasDEModel userRoleDatasDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserRoleDatasDAO";
    }

    public UserRoleDatasDEModel getUserRoleDatasDEModel() {
        if (this.userRoleDatasDEModel == null) {
            try {
                this.userRoleDatasDEModel = (UserRoleDatasDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleDatasDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleDatasDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserRoleDatasDEModel();
    }
}

