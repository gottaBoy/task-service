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
import net.ibizsys.psrt.srv.common.demodel.UserDictDEModel;
import net.ibizsys.psrt.srv.common.entity.UserDict;

public abstract class UserDictDAOBase
extends PSRuntimeSysDAOBase<UserDict> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserDictDEModel userDictDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserDictDAO";
    }

    public UserDictDEModel getUserDictDEModel() {
        if (this.userDictDEModel == null) {
            try {
                this.userDictDEModel = (UserDictDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserDictDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userDictDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserDictDEModel();
    }
}

