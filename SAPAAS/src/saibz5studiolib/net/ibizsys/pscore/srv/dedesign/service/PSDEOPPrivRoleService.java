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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivRole;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEOPPrivRoleService
extends PSDEOPPrivRoleServiceBase {
    private static final Log log = LogFactory.getLog(PSDEOPPrivRoleService.class);

    @Override
    public void getDraft(PSDEOPPrivRole pSDEOPPrivRole) throws Exception {
        super.getDraft(pSDEOPPrivRole);
        if (!StringHelper.isNullOrEmpty((String)pSDEOPPrivRole.getPSSysOPPrivId())) {
            pSDEOPPrivRole.setRoleType("SYSROLE");
        }
    }
}

