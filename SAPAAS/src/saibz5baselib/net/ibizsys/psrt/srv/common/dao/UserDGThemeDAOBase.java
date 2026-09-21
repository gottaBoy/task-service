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
import net.ibizsys.psrt.srv.common.demodel.UserDGThemeDEModel;
import net.ibizsys.psrt.srv.common.entity.UserDGTheme;

public abstract class UserDGThemeDAOBase
extends PSRuntimeSysDAOBase<UserDGTheme> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserDGThemeDEModel userDGThemeDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserDGThemeDAO";
    }

    public UserDGThemeDEModel getUserDGThemeDEModel() {
        if (this.userDGThemeDEModel == null) {
            try {
                this.userDGThemeDEModel = (UserDGThemeDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserDGThemeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userDGThemeDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserDGThemeDEModel();
    }
}

