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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserRoleData;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleDataServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysUserRoleDataService
extends PSSysUserRoleDataServiceBase {
    private static final Log log = LogFactory.getLog(PSSysUserRoleDataService.class);

    @Override
    protected void onBeforeCreate(PSSysUserRoleData pSSysUserRoleData) throws Exception {
        if (!PSSysUserRoleDataService.isImpSysModelNowEx()) {
            String string = StringHelper.format((String)"%1$s-%2$s[%3$s]", (Object)pSSysUserRoleData.getPSSysOPPrivName(), (Object)pSSysUserRoleData.getPSDEName(), (Object)pSSysUserRoleData.getPSDEUserRoleName());
            pSSysUserRoleData.setPSSysUserRoleDataName(string);
        }
        super.onBeforeCreate(pSSysUserRoleData);
    }

    @Override
    protected void onBeforeUpdate(PSSysUserRoleData pSSysUserRoleData) throws Exception {
        if (!PSSysUserRoleDataService.isImpSysModelNowEx()) {
            String string = StringHelper.format((String)"%1$s-%2$s[%3$s]", (Object)pSSysUserRoleData.getPSSysOPPrivName(), (Object)pSSysUserRoleData.getPSDEName(), (Object)pSSysUserRoleData.getPSDEUserRoleName());
            pSSysUserRoleData.setPSSysUserRoleDataName(string);
        }
        super.onBeforeUpdate(pSSysUserRoleData);
    }
}

