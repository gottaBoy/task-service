/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRole;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEUserRoleService
extends PSDEUserRoleServiceBase {
    private static final Log log = LogFactory.getLog(PSDEUserRoleService.class);

    @Override
    public String getModelV2Tag(PSDEUserRole pSDEUserRole) {
        if (!StringHelper.isNullOrEmpty((String)pSDEUserRole.getUserRoleTag())) {
            return pSDEUserRole.getUserRoleTag();
        }
        return super.getModelV2Tag(pSDEUserRole);
    }
}

