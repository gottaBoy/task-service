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
import net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldDEModel;
import net.ibizsys.psrt.srv.common.entity.UserRoleDEField;

public abstract class UserRoleDEFieldDAOBase
extends PSRuntimeSysDAOBase<UserRoleDEField> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserRoleDEFieldDEModel userRoleDEFieldDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldDAO";
    }

    public UserRoleDEFieldDEModel getUserRoleDEFieldDEModel() {
        if (this.userRoleDEFieldDEModel == null) {
            try {
                this.userRoleDEFieldDEModel = (UserRoleDEFieldDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleDEFieldDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserRoleDEFieldDEModel();
    }
}

