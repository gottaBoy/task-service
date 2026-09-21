/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkRole;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkRoleServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWFLinkRoleService
extends PSWFLinkRoleServiceBase {
    private static final Log log = LogFactory.getLog(PSWFLinkRoleService.class);

    @Override
    protected void onFillParentInfo_PSWFLink(PSWFLinkRole pSWFLinkRole, PSWFLink pSWFLink) throws Exception {
        super.onFillParentInfo_PSWFLink(pSWFLinkRole, pSWFLink);
    }

    @Override
    protected void onBeforeCreateTemp(PSWFLinkRole pSWFLinkRole) throws Exception {
        super.onBeforeCreateTemp(pSWFLinkRole);
        if (StringHelper.isNullOrEmpty((String)pSWFLinkRole.getPSWFLinkRoleName())) {
            pSWFLinkRole.setPSWFLinkRoleName(this.calcWFLinkRoleName(pSWFLinkRole));
        }
    }

    @Override
    protected void onBeforeUpdateTemp(PSWFLinkRole pSWFLinkRole) throws Exception {
        super.onBeforeUpdateTemp(pSWFLinkRole);
        if (StringHelper.isNullOrEmpty((String)pSWFLinkRole.getPSWFLinkRoleName())) {
            pSWFLinkRole.setPSWFLinkRoleName(this.calcWFLinkRoleName(pSWFLinkRole));
        }
    }

    protected String calcWFLinkRoleName(PSWFLinkRole pSWFLinkRole) throws Exception {
        return pSWFLinkRole.getPSWFProcRoleName();
    }
}

