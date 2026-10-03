/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdeploy.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnUser;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnUserServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDepSlnUserService
extends PSDepSlnUserServiceBase {
    private static final Log log = LogFactory.getLog(PSDepSlnUserService.class);

    public PSDepSlnUser getPSDepSlnUser(PSDepSlnSys pSDepSlnSys, String string) throws Exception {
        PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
        PSDepSln pSDepSln = new PSDepSln();
        pSDepSln.setPSDepSlnId(pSDepSlnSys.getPSDepSlnId());
        pSDepSlnService.get(pSDepSln);
        if (StringHelper.compare((String)pSDepSln.getAdminPSDevUserId(), (String)string, (boolean)false) == 0) {
            PSDepSlnUser pSDepSlnUser = new PSDepSlnUser();
            pSDepSlnUser.setPSDepSlnUserId(KeyValueHelper.genUniqueId((String)pSDepSlnSys.getPSDepSlnSysId(), (String)string));
            pSDepSlnUser.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
            pSDepSlnUser.setAccMode(3);
            return pSDepSlnUser;
        }
        ArrayList<PSDepSlnUser> arrayList = this.selectByPSDepSln(pSDepSlnSys.getPSDepSln());
        for (PSDepSlnUser pSDepSlnUser : arrayList) {
            if (DataObject.getBoolValue((Integer)pSDepSlnUser.getAllSysFlag(), (boolean)false) || StringHelper.compare((String)pSDepSlnUser.getPSDepSlnSysId(), (String)pSDepSlnSys.getPSDepSlnSysId(), (boolean)true) != 0 || StringHelper.compare((String)pSDepSlnUser.getPSDevUserObjId(), (String)string, (boolean)true) != 0) continue;
            return pSDepSlnUser;
        }
        for (PSDepSlnUser pSDepSlnUser : arrayList) {
            if (!DataObject.getBoolValue((Integer)pSDepSlnUser.getAllSysFlag(), (boolean)false) || StringHelper.compare((String)pSDepSlnUser.getPSDevUserObjId(), (String)string, (boolean)true) != 0) continue;
            return pSDepSlnUser;
        }
        return null;
    }
}

