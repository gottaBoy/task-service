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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAGDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAGDetailServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEAGDetailService
extends PSDEAGDetailServiceBase {
    private static final Log log = LogFactory.getLog(PSDEAGDetailService.class);

    protected void fillDefaultValue(PSDEAGDetail pSDEAGDetail) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEAGDetail.getPSDEAGDetailName())) {
            if (StringHelper.compare((String)pSDEAGDetail.getDetailType(), (String)"DEACTION", (boolean)true) == 0) {
                pSDEAGDetail.setPSDEAGDetailName(pSDEAGDetail.getPSDEActionName());
            } else if (StringHelper.compare((String)pSDEAGDetail.getDetailType(), (String)"DEDATASET", (boolean)true) == 0) {
                pSDEAGDetail.setPSDEAGDetailName(pSDEAGDetail.getPSDEDataSetName());
            }
        }
    }

    @Override
    protected void onAfterGetDraft(PSDEAGDetail pSDEAGDetail) throws Exception {
        super.onAfterGetDraft(pSDEAGDetail);
        this.fillDefaultValue(pSDEAGDetail);
    }

    @Override
    protected void onAfterGetDraftTemp(PSDEAGDetail pSDEAGDetail) throws Exception {
        super.onAfterGetDraftTemp(pSDEAGDetail);
        this.fillDefaultValue(pSDEAGDetail);
    }

    @Override
    protected void onBeforeCreateTemp(PSDEAGDetail pSDEAGDetail) throws Exception {
        super.onBeforeCreateTemp(pSDEAGDetail);
        this.fillDefaultValue(pSDEAGDetail);
    }

    @Override
    protected void onBeforeCreate(PSDEAGDetail pSDEAGDetail) throws Exception {
        super.onBeforeCreate(pSDEAGDetail);
        this.fillDefaultValue(pSDEAGDetail);
    }
}

