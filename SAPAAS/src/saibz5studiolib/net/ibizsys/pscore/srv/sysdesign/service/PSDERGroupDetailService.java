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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroupDetail;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupDetailServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDERGroupDetailService
extends PSDERGroupDetailServiceBase {
    private static final Log log = LogFactory.getLog(PSDERGroupDetailService.class);

    protected void fillDefaultValue(PSDERGroupDetail pSDERGroupDetail) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDERGroupDetail.getPSDERGroupDetailName())) {
            pSDERGroupDetail.setPSDERGroupDetailName(pSDERGroupDetail.getPSDERName());
        }
    }

    @Override
    protected void onAfterGetDraft(PSDERGroupDetail pSDERGroupDetail) throws Exception {
        super.onAfterGetDraft(pSDERGroupDetail);
        this.fillDefaultValue(pSDERGroupDetail);
    }

    @Override
    protected void onAfterGetDraftTemp(PSDERGroupDetail pSDERGroupDetail) throws Exception {
        super.onAfterGetDraftTemp(pSDERGroupDetail);
        this.fillDefaultValue(pSDERGroupDetail);
    }

    @Override
    protected void onBeforeCreateTemp(PSDERGroupDetail pSDERGroupDetail) throws Exception {
        super.onBeforeCreateTemp(pSDERGroupDetail);
        this.fillDefaultValue(pSDERGroupDetail);
    }

    @Override
    protected void onBeforeCreate(PSDERGroupDetail pSDERGroupDetail) throws Exception {
        super.onBeforeCreate(pSDERGroupDetail);
        this.fillDefaultValue(pSDERGroupDetail);
    }
}

