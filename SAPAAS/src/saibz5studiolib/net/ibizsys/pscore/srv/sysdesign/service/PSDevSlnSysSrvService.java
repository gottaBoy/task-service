/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysSrvService
extends PSDevSlnSysSrvServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnSysSrvService.class);

    @Override
    protected void onGetWithToken(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        this.get(pSDevSlnSysSrv);
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSysSrv.getAccessToken())) {
            pSDevSlnSysSrv.setAccessToken(KeyValueHelper.genGuidEx());
            this.update(pSDevSlnSysSrv);
        }
    }

    @Override
    protected void onUpdateEnableLink(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        PSDevSlnSysSrv pSDevSlnSysSrv2 = new PSDevSlnSysSrv();
        pSDevSlnSysSrv2.setPSDevSlnSysSrvId(pSDevSlnSysSrv.getPSDevSlnSysSrvId());
        this.get(pSDevSlnSysSrv2);
        this.update(pSDevSlnSysSrv);
    }
}

