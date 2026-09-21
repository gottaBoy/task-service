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
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGrpDetail;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGrpDetailServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSViewMsgGrpDetailService
extends PSViewMsgGrpDetailServiceBase {
    private static final Log log = LogFactory.getLog(PSViewMsgGrpDetailService.class);

    @Override
    protected void onBeforeCreate(PSViewMsgGrpDetail pSViewMsgGrpDetail) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSViewMsgGrpDetail.getPSViewMsgName())) {
            if (pSViewMsgGrpDetail.getPSViewMsg() != null) {
                pSViewMsgGrpDetail.setPSViewMsgGrpDetailName(pSViewMsgGrpDetail.getPSViewMsg().getPSViewMsgName());
            }
        } else {
            pSViewMsgGrpDetail.setPSViewMsgGrpDetailName(pSViewMsgGrpDetail.getPSViewMsgName());
        }
        super.onBeforeCreate(pSViewMsgGrpDetail);
    }

    @Override
    protected void onBeforeUpdate(PSViewMsgGrpDetail pSViewMsgGrpDetail) throws Exception {
        super.onBeforeUpdate(pSViewMsgGrpDetail);
    }

    @Override
    protected void onBeforeCreateTemp(PSViewMsgGrpDetail pSViewMsgGrpDetail) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSViewMsgGrpDetail.getPSViewMsgName())) {
            if (pSViewMsgGrpDetail.getPSViewMsg() != null) {
                pSViewMsgGrpDetail.setPSViewMsgGrpDetailName(pSViewMsgGrpDetail.getPSViewMsg().getPSViewMsgName());
            }
        } else {
            pSViewMsgGrpDetail.setPSViewMsgGrpDetailName(pSViewMsgGrpDetail.getPSViewMsgName());
        }
        super.onBeforeCreateTemp(pSViewMsgGrpDetail);
    }

    @Override
    protected void onBeforeUpdateTemp(PSViewMsgGrpDetail pSViewMsgGrpDetail) throws Exception {
        super.onBeforeUpdateTemp(pSViewMsgGrpDetail);
    }
}

