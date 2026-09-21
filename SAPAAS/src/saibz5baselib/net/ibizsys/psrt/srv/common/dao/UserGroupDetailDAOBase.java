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
import net.ibizsys.psrt.srv.common.demodel.UserGroupDetailDEModel;
import net.ibizsys.psrt.srv.common.entity.UserGroupDetail;

public abstract class UserGroupDetailDAOBase
extends PSRuntimeSysDAOBase<UserGroupDetail> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserGroupDetailDEModel userGroupDetailDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserGroupDetailDAO";
    }

    public UserGroupDetailDEModel getUserGroupDetailDEModel() {
        if (this.userGroupDetailDEModel == null) {
            try {
                this.userGroupDetailDEModel = (UserGroupDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserGroupDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userGroupDetailDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserGroupDetailDEModel();
    }
}

