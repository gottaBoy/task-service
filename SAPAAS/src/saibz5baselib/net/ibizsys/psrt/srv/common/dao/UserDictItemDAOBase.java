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
import net.ibizsys.psrt.srv.common.demodel.UserDictItemDEModel;
import net.ibizsys.psrt.srv.common.entity.UserDictItem;

public abstract class UserDictItemDAOBase
extends PSRuntimeSysDAOBase<UserDictItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserDictItemDEModel userDictItemDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserDictItemDAO";
    }

    public UserDictItemDEModel getUserDictItemDEModel() {
        if (this.userDictItemDEModel == null) {
            try {
                this.userDictItemDEModel = (UserDictItemDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserDictItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userDictItemDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserDictItemDEModel();
    }
}

