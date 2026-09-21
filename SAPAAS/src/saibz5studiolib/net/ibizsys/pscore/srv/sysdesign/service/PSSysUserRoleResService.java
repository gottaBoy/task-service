/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserRoleRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleResServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysUserRoleResService
extends PSSysUserRoleResServiceBase {
    private static final Log log = LogFactory.getLog(PSSysUserRoleResService.class);

    @Override
    protected void onBeforeCreate(PSSysUserRoleRes pSSysUserRoleRes) throws Exception {
        if (!PSSysUserRoleResService.isImpSysModelNowEx()) {
            if (StringHelper.isNullOrEmpty((String)pSSysUserRoleRes.getPSSysUniResName())) {
                pSSysUserRoleRes.getPSSysUniRes();
                pSSysUserRoleRes.setPSSysUniResName(pSSysUserRoleRes.getPSSysUniRes().getPSSysUniResName());
            }
            String string = StringHelper.format((String)"%1$s-%2$s", (Object)pSSysUserRoleRes.getPSSysOPPrivName(), (Object)pSSysUserRoleRes.getPSSysUniResName());
            pSSysUserRoleRes.setPSSysUserRoleResName(string);
        }
        super.onBeforeCreate(pSSysUserRoleRes);
    }

    @Override
    protected void onBeforeUpdate(PSSysUserRoleRes pSSysUserRoleRes) throws Exception {
        if (!PSSysUserRoleResService.isImpSysModelNowEx()) {
            if (StringHelper.isNullOrEmpty((String)pSSysUserRoleRes.getPSSysUniResName())) {
                pSSysUserRoleRes.getPSSysUniRes();
                pSSysUserRoleRes.setPSSysUniResName(pSSysUserRoleRes.getPSSysUniRes().getPSSysUniResName());
            }
            String string = StringHelper.format((String)"%1$s-%2$s", (Object)pSSysUserRoleRes.getPSSysOPPrivName(), (Object)pSSysUserRoleRes.getPSSysUniResName());
            pSSysUserRoleRes.setPSSysUserRoleResName(string);
        }
        super.onBeforeUpdate(pSSysUserRoleRes);
    }
}

