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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysVerService
extends PSDevSlnSysVerServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnSysVerService.class);

    @Override
    protected void onBeforeCreate(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSysVer.getPSDevSlnSysVerName())) {
            pSDevSlnSysVer.setPSDevSlnSysVerName(StringHelper.format((String)"%1$s %2$s", (Object)pSDevSlnSysVer.getPSDevSlnSysName(), (Object)pSDevSlnSysVer.getVersion()));
        }
        super.onBeforeCreate(pSDevSlnSysVer);
    }
}

