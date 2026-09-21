/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.service.IInheritDEServiceProxy;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.entity.UserGroup;
import net.ibizsys.psrt.srv.common.entity.UserObject;
import net.ibizsys.psrt.srv.common.service.UserGroupService;
import net.ibizsys.psrt.srv.common.service.UserObjectService;
import net.ibizsys.psrt.srv.common.service.UserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserObjectServiceProxyBase
extends UserObjectService<UserObject>
implements IInheritDEServiceProxy<UserObject> {
    private static final Log log = LogFactory.getLog(UserObjectServiceProxyBase.class);

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
        ServiceGlobal.registerService(String.valueOf(this.getServiceId()) + "Proxy", this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.UserObjectService";
    }

    @Override
    public void remove(UserObject entity) throws Exception {
        if (entity.getUserObjectType() == null) {
            this.get(entity);
        }
        if (StringHelper.compare(entity.getUserObjectType(), "USERGROUP", true) == 0) {
            UserGroupService realService = (UserGroupService)ServiceGlobal.getService(UserGroupService.class, this.getSessionFactory());
            UserGroup realEntity = new UserGroup();
            realEntity.setUserGroupId(entity.getUserObjectId());
            realService.remove(realEntity);
            return;
        }
        if (StringHelper.compare(entity.getUserObjectType(), "USER", true) == 0) {
            UserService realService = (UserService)ServiceGlobal.getService(UserService.class, this.getSessionFactory());
            User realEntity = new User();
            realEntity.setUserId(entity.getUserObjectId());
            realService.remove(realEntity);
            return;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", entity.getUserObjectType()));
    }

    @Override
    public UserObject getReal(UserObject entity, boolean bTryMode) throws Exception {
        if (entity.getUserObjectType() == null && !this.get(entity, bTryMode)) {
            return null;
        }
        if (StringHelper.compare(entity.getUserObjectType(), "USERGROUP", true) == 0) {
            UserGroupService realService = (UserGroupService)ServiceGlobal.getService(UserGroupService.class, this.getSessionFactory());
            UserGroup realEntity = new UserGroup();
            realEntity.setUserGroupId(entity.getUserObjectId());
            if (!realService.get(realEntity, bTryMode)) {
                return null;
            }
            return realEntity;
        }
        if (StringHelper.compare(entity.getUserObjectType(), "USER", true) == 0) {
            UserService realService = (UserService)ServiceGlobal.getService(UserService.class, this.getSessionFactory());
            User realEntity = new User();
            realEntity.setUserId(entity.getUserObjectId());
            if (!realService.get(realEntity, bTryMode)) {
                return null;
            }
            return realEntity;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", entity.getUserObjectType()));
    }

    @Override
    public IService getRealService(UserObject entity) throws Exception {
        if (entity.getUserObjectType() == null) {
            this.get(entity);
        }
        if (StringHelper.compare(entity.getUserObjectType(), "USERGROUP", true) == 0) {
            UserGroupService realService = (UserGroupService)ServiceGlobal.getService(UserGroupService.class, this.getSessionFactory());
            return realService;
        }
        if (StringHelper.compare(entity.getUserObjectType(), "USER", true) == 0) {
            UserService realService = (UserService)ServiceGlobal.getService(UserService.class, this.getSessionFactory());
            return realService;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", entity.getUserObjectType()));
    }

    @Override
    protected void onExportCurModel(UserObject entity, ArrayList<JSONObject> list) throws Exception {
        if (StringHelper.compare(entity.getUserObjectType(), "USERGROUP", true) == 0) {
            UserGroupService realService = (UserGroupService)ServiceGlobal.getService(UserGroupService.class, this.getSessionFactory());
            UserGroup realEntity = new UserGroup();
            realEntity.setUserGroupId(entity.getUserObjectId());
            realService.exportModel(realEntity, list);
            return;
        }
        if (StringHelper.compare(entity.getUserObjectType(), "USER", true) == 0) {
            UserService realService = (UserService)ServiceGlobal.getService(UserService.class, this.getSessionFactory());
            User realEntity = new User();
            realEntity.setUserId(entity.getUserObjectId());
            realService.exportModel(realEntity, list);
            return;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", entity.getUserObjectType()));
    }
}

