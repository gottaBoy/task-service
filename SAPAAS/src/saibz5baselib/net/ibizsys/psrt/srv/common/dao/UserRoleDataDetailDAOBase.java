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
import net.ibizsys.psrt.srv.common.demodel.UserRoleDataDetailDEModel;
import net.ibizsys.psrt.srv.common.entity.UserRoleDataDetail;

public abstract class UserRoleDataDetailDAOBase
extends PSRuntimeSysDAOBase<UserRoleDataDetail> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserRoleDataDetailDEModel userRoleDataDetailDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserRoleDataDetailDAO";
    }

    public UserRoleDataDetailDEModel getUserRoleDataDetailDEModel() {
        if (this.userRoleDataDetailDEModel == null) {
            try {
                this.userRoleDataDetailDEModel = (UserRoleDataDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleDataDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleDataDetailDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserRoleDataDetailDEModel();
    }
}

