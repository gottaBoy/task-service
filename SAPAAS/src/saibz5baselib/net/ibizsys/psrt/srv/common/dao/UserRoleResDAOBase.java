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
import net.ibizsys.psrt.srv.common.demodel.UserRoleResDEModel;
import net.ibizsys.psrt.srv.common.entity.UserRoleRes;

public abstract class UserRoleResDAOBase
extends PSRuntimeSysDAOBase<UserRoleRes> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserRoleResDEModel userRoleResDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserRoleResDAO";
    }

    public UserRoleResDEModel getUserRoleResDEModel() {
        if (this.userRoleResDEModel == null) {
            try {
                this.userRoleResDEModel = (UserRoleResDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleResDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleResDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserRoleResDEModel();
    }
}

