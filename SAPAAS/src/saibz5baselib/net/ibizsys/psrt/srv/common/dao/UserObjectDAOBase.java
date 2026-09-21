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
import net.ibizsys.psrt.srv.common.demodel.UserObjectDEModel;
import net.ibizsys.psrt.srv.common.entity.UserObject;

public abstract class UserObjectDAOBase
extends PSRuntimeSysDAOBase<UserObject> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserObjectDEModel userObjectDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserObjectDAO";
    }

    public UserObjectDEModel getUserObjectDEModel() {
        if (this.userObjectDEModel == null) {
            try {
                this.userObjectDEModel = (UserObjectDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserObjectDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userObjectDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserObjectDEModel();
    }
}

