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
import net.ibizsys.psrt.srv.common.demodel.UserRoleDetailDEModel;
import net.ibizsys.psrt.srv.common.entity.UserRoleDetail;

public abstract class UserRoleDetailDAOBase
extends PSRuntimeSysDAOBase<UserRoleDetail> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserRoleDetailDEModel userRoleDetailDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserRoleDetailDAO";
    }

    public UserRoleDetailDEModel getUserRoleDetailDEModel() {
        if (this.userRoleDetailDEModel == null) {
            try {
                this.userRoleDetailDEModel = (UserRoleDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleDetailDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserRoleDetailDEModel();
    }
}

