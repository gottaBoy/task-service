/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.common.service;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.OrgSecUser;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.ibizsys.psrt.srv.common.service.OrgSecUserService;
import net.ibizsys.psrt.srv.common.service.OrgUserServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class OrgUserService
extends OrgUserServiceBase {
    private static final Log log = LogFactory.getLog(OrgUserService.class);

    @Override
    protected void onAfterCreate(OrgUser et) throws Exception {
        this.createDefaultOrgSecUser(et);
        super.onAfterCreate(et);
    }

    @Override
    protected void onAfterUpdate(OrgUser et) throws Exception {
        this.createDefaultOrgSecUser(et);
        super.onAfterUpdate(et);
    }

    protected void createDefaultOrgSecUser(OrgUser et) throws Exception {
        OrgSecUser orgSecUser = new OrgSecUser();
        OrgSecUserService orgSecUserService = (OrgSecUserService)ServiceGlobal.getService(OrgSecUserService.class, this.getSessionFactory());
        OrgUser lastEt = (OrgUser)this.getLast(et);
        if (lastEt != null && StringHelper.compare(lastEt.getOrgSectorId(), et.getOrgSectorId(), true) != 0) {
            String strKey = KeyValueHelper.genUniqueId(lastEt.getOrgSectorId(), et.getOrgUserId());
            orgSecUser.setOrgSecUserId(strKey);
            orgSecUser.setDefaultFlag(0);
            orgSecUserService.remove(orgSecUser);
        }
        et.copyTo(orgSecUser, true);
        if (orgSecUserService.checkKey(orgSecUser) == 1) {
            orgSecUser.setOrgSecUserName(et.getOrgUserName());
            orgSecUser.setDefaultFlag(1);
            orgSecUserService.update(orgSecUser);
        } else {
            orgSecUser.setOrgSecUserName(et.getOrgUserName());
            orgSecUser.setDefaultFlag(1);
            orgSecUserService.create(orgSecUser);
        }
    }

    protected void removeDefaultOrgSecUser(OrgUser et) throws Exception {
        OrgUser lastEt = (OrgUser)this.getLast(et);
        OrgSecUser orgSecUser = new OrgSecUser();
        OrgSecUserService orgSecUserService = (OrgSecUserService)ServiceGlobal.getService(OrgSecUserService.class, this.getSessionFactory());
        String strKey = KeyValueHelper.genUniqueId(lastEt.getOrgSectorId(), et.getOrgUserId());
        orgSecUser.setOrgSecUserId(strKey);
        orgSecUser.setDefaultFlag(0);
        orgSecUserService.remove(orgSecUser);
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    protected void onBeforeRemove(OrgUser et) throws Exception {
        this.removeDefaultOrgSecUser(et);
        super.onBeforeRemove(et);
    }
}

