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
import net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldsDEModel;
import net.ibizsys.psrt.srv.common.entity.UserRoleDEFields;

public abstract class UserRoleDEFieldsDAOBase
extends PSRuntimeSysDAOBase<UserRoleDEFields> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserRoleDEFieldsDEModel userRoleDEFieldsDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldsDAO";
    }

    public UserRoleDEFieldsDEModel getUserRoleDEFieldsDEModel() {
        if (this.userRoleDEFieldsDEModel == null) {
            try {
                this.userRoleDEFieldsDEModel = (UserRoleDEFieldsDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldsDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleDEFieldsDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserRoleDEFieldsDEModel();
    }
}

