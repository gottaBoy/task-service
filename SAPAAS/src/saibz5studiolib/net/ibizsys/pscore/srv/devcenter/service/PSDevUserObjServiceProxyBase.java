/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IInheritDEServiceProxy
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IInheritDEServiceProxy;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserGroup;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserObj;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserGroupService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserObjService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevUserObjServiceProxyBase
extends PSDevUserObjService<PSDevUserObj>
implements IInheritDEServiceProxy<PSDevUserObj> {
    private static final Log log = LogFactory.getLog(PSDevUserObjServiceProxyBase.class);

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
        ServiceGlobal.registerService((String)(this.getServiceId() + "Proxy"), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDevUserObjService";
    }

    public void remove(PSDevUserObj pSDevUserObj) throws Exception {
        if (pSDevUserObj.getPSDevUserObjType() == null) {
            this.get(pSDevUserObj);
        }
        if (StringHelper.compare((String)pSDevUserObj.getPSDevUserObjType(), (String)"USERGROUP", (boolean)true) == 0) {
            PSDevUserGroupService pSDevUserGroupService = (PSDevUserGroupService)ServiceGlobal.getService(PSDevUserGroupService.class, (SessionFactory)this.getSessionFactory());
            PSDevUserGroup pSDevUserGroup = new PSDevUserGroup();
            pSDevUserGroup.setPSDevUserGroupId(pSDevUserObj.getPSDevUserObjectId());
            pSDevUserGroupService.remove(pSDevUserGroup);
            return;
        }
        if (StringHelper.compare((String)pSDevUserObj.getPSDevUserObjType(), (String)"USER", (boolean)true) == 0) {
            PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = new PSDevUser();
            pSDevUser.setPSDevUserId(pSDevUserObj.getPSDevUserObjectId());
            pSDevUserService.remove(pSDevUser);
            return;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSDevUserObj.getPSDevUserObjType()));
    }

    public PSDevUserObj getReal(PSDevUserObj pSDevUserObj, boolean bl) throws Exception {
        if (pSDevUserObj.getPSDevUserObjType() == null && !this.get(pSDevUserObj, bl)) {
            return null;
        }
        if (StringHelper.compare((String)pSDevUserObj.getPSDevUserObjType(), (String)"USERGROUP", (boolean)true) == 0) {
            PSDevUserGroupService pSDevUserGroupService = (PSDevUserGroupService)ServiceGlobal.getService(PSDevUserGroupService.class, (SessionFactory)this.getSessionFactory());
            PSDevUserGroup pSDevUserGroup = new PSDevUserGroup();
            pSDevUserGroup.setPSDevUserGroupId(pSDevUserObj.getPSDevUserObjectId());
            if (!pSDevUserGroupService.get(pSDevUserGroup, bl)) {
                return null;
            }
            return pSDevUserGroup;
        }
        if (StringHelper.compare((String)pSDevUserObj.getPSDevUserObjType(), (String)"USER", (boolean)true) == 0) {
            PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = new PSDevUser();
            pSDevUser.setPSDevUserId(pSDevUserObj.getPSDevUserObjectId());
            if (!pSDevUserService.get(pSDevUser, bl)) {
                return null;
            }
            return pSDevUser;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSDevUserObj.getPSDevUserObjType()));
    }

    public IService getRealService(PSDevUserObj pSDevUserObj) throws Exception {
        if (pSDevUserObj.getPSDevUserObjType() == null) {
            this.get(pSDevUserObj);
        }
        if (StringHelper.compare((String)pSDevUserObj.getPSDevUserObjType(), (String)"USERGROUP", (boolean)true) == 0) {
            PSDevUserGroupService pSDevUserGroupService = (PSDevUserGroupService)ServiceGlobal.getService(PSDevUserGroupService.class, (SessionFactory)this.getSessionFactory());
            return pSDevUserGroupService;
        }
        if (StringHelper.compare((String)pSDevUserObj.getPSDevUserObjType(), (String)"USER", (boolean)true) == 0) {
            PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
            return pSDevUserService;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSDevUserObj.getPSDevUserObjType()));
    }

    protected void onExportCurModel(PSDevUserObj pSDevUserObj, ArrayList<JSONObject> arrayList) throws Exception {
        if (StringHelper.compare((String)pSDevUserObj.getPSDevUserObjType(), (String)"USERGROUP", (boolean)true) == 0) {
            PSDevUserGroupService pSDevUserGroupService = (PSDevUserGroupService)ServiceGlobal.getService(PSDevUserGroupService.class, (SessionFactory)this.getSessionFactory());
            PSDevUserGroup pSDevUserGroup = new PSDevUserGroup();
            pSDevUserGroup.setPSDevUserGroupId(pSDevUserObj.getPSDevUserObjectId());
            pSDevUserGroupService.exportModel(pSDevUserGroup, arrayList);
            return;
        }
        if (StringHelper.compare((String)pSDevUserObj.getPSDevUserObjType(), (String)"USER", (boolean)true) == 0) {
            PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = new PSDevUser();
            pSDevUser.setPSDevUserId(pSDevUserObj.getPSDevUserObjectId());
            pSDevUserService.exportModel(pSDevUser, arrayList);
            return;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSDevUserObj.getPSDevUserObjType()));
    }
}

