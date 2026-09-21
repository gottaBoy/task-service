/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.common.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.common.dao.UserObjectDAO;
import net.ibizsys.psrt.srv.common.demodel.UserGroupDEModel;
import net.ibizsys.psrt.srv.common.entity.UserGroup;
import net.ibizsys.psrt.srv.common.entity.UserObjectBase;

public abstract class UserGroupDAOBase
extends PSRuntimeSysDAOBase<UserGroup> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserGroupDEModel userGroupDEModel;
    private UserObjectDAO userObjectDAO;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserGroupDAO";
    }

    public UserGroupDEModel getUserGroupDEModel() {
        if (this.userGroupDEModel == null) {
            try {
                this.userGroupDEModel = (UserGroupDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userGroupDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserGroupDEModel();
    }

    @Override
    protected IDAO getInheritDEDAO() {
        if (this.userObjectDAO == null) {
            try {
                this.userObjectDAO = (UserObjectDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.UserObjectDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userObjectDAO;
    }

    @Override
    protected void fillInheritEntity(UserGroup et) throws Exception {
        super.fillInheritEntity(et);
        UserGroup userObject = et;
        userObject.setUserObjectId(et.getUserGroupId());
        if (et.isUserGroupNameDirty()) {
            userObject.setUserObjectName(et.getUserGroupName());
        }
        ((UserObjectBase)userObject).set("USEROBJECTTYPE", "USERGROUP");
    }
}

