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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFGroupDetailService
extends PSDEFGroupDetailServiceBase {
    private static final Log log = LogFactory.getLog(PSDEFGroupDetailService.class);

    protected void fillDefaultValue(PSDEFGroupDetail pSDEFGroupDetail) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEFGroupDetail.getPSDEFGroupDetailName())) {
            pSDEFGroupDetail.setPSDEFGroupDetailName(pSDEFGroupDetail.getPSDEFName());
        }
    }

    @Override
    protected void onAfterGetDraft(PSDEFGroupDetail pSDEFGroupDetail) throws Exception {
        super.onAfterGetDraft(pSDEFGroupDetail);
        this.fillDefaultValue(pSDEFGroupDetail);
    }

    @Override
    protected void onAfterGetDraftTemp(PSDEFGroupDetail pSDEFGroupDetail) throws Exception {
        super.onAfterGetDraftTemp(pSDEFGroupDetail);
        this.fillDefaultValue(pSDEFGroupDetail);
    }

    @Override
    protected void onBeforeCreateTemp(PSDEFGroupDetail pSDEFGroupDetail) throws Exception {
        super.onBeforeCreateTemp(pSDEFGroupDetail);
        this.fillDefaultValue(pSDEFGroupDetail);
    }

    @Override
    protected void onBeforeCreate(PSDEFGroupDetail pSDEFGroupDetail) throws Exception {
        super.onBeforeCreate(pSDEFGroupDetail);
        this.fillDefaultValue(pSDEFGroupDetail);
    }
}

