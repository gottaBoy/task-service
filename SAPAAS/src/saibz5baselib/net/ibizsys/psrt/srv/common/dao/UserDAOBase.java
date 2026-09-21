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
import net.ibizsys.psrt.srv.common.demodel.UserDEModel;
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.entity.UserObjectBase;

public abstract class UserDAOBase
extends PSRuntimeSysDAOBase<User> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private UserDEModel userDEModel;
    private UserObjectDAO userObjectDAO;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserDAO";
    }

    public UserDEModel getUserDEModel() {
        if (this.userDEModel == null) {
            try {
                this.userDEModel = (UserDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserDEModel();
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
    protected void fillInheritEntity(User et) throws Exception {
        super.fillInheritEntity(et);
        User userObject = et;
        userObject.setUserObjectId(et.getUserId());
        if (et.isUserNameDirty()) {
            userObject.setUserObjectName(et.getUserName());
        }
        ((UserObjectBase)userObject).set("USEROBJECTTYPE", "USER");
    }
}

