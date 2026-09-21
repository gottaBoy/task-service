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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroupDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupDetailServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEGroupDetailService
extends PSDEGroupDetailServiceBase {
    private static final Log log = LogFactory.getLog(PSDEGroupDetailService.class);

    protected void fillDefaultValue(PSDEGroupDetail pSDEGroupDetail) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEGroupDetail.getPSDEGroupDetailName())) {
            pSDEGroupDetail.setPSDEGroupDetailName(pSDEGroupDetail.getPSDEName());
        }
    }

    @Override
    protected void onAfterGetDraft(PSDEGroupDetail pSDEGroupDetail) throws Exception {
        super.onAfterGetDraft(pSDEGroupDetail);
        this.fillDefaultValue(pSDEGroupDetail);
    }

    @Override
    protected void onAfterGetDraftTemp(PSDEGroupDetail pSDEGroupDetail) throws Exception {
        super.onAfterGetDraftTemp(pSDEGroupDetail);
        this.fillDefaultValue(pSDEGroupDetail);
    }

    @Override
    protected void onBeforeCreateTemp(PSDEGroupDetail pSDEGroupDetail) throws Exception {
        super.onBeforeCreateTemp(pSDEGroupDetail);
        this.fillDefaultValue(pSDEGroupDetail);
    }

    @Override
    protected void onBeforeCreate(PSDEGroupDetail pSDEGroupDetail) throws Exception {
        super.onBeforeCreate(pSDEGroupDetail);
        this.fillDefaultValue(pSDEGroupDetail);
    }
}

