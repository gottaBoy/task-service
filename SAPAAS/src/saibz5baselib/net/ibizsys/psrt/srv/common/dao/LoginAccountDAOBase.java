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
import net.ibizsys.psrt.srv.common.demodel.LoginAccountDEModel;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;

public abstract class LoginAccountDAOBase
extends PSRuntimeSysDAOBase<LoginAccount> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private LoginAccountDEModel loginAccountDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.LoginAccountDAO";
    }

    public LoginAccountDEModel getLoginAccountDEModel() {
        if (this.loginAccountDEModel == null) {
            try {
                this.loginAccountDEModel = (LoginAccountDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.LoginAccountDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.loginAccountDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getLoginAccountDEModel();
    }
}

