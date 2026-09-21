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
import net.ibizsys.psrt.srv.common.demodel.LoginLogDEModel;
import net.ibizsys.psrt.srv.common.entity.LoginLog;

public abstract class LoginLogDAOBase
extends PSRuntimeSysDAOBase<LoginLog> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private LoginLogDEModel loginLogDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.LoginLogDAO";
    }

    public LoginLogDEModel getLoginLogDEModel() {
        if (this.loginLogDEModel == null) {
            try {
                this.loginLogDEModel = (LoginLogDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.LoginLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.loginLogDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getLoginLogDEModel();
    }
}

