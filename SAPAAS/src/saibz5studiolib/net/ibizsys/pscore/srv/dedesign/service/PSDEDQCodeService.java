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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDQCodeService
extends PSDEDQCodeServiceBase {
    private static final Log log = LogFactory.getLog(PSDEDQCodeService.class);

    @Override
    protected void onBeforeCreate(PSDEDQCode pSDEDQCode) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEDQCode.getPSDEDQCodeName())) {
            pSDEDQCode.setPSDEDQCodeName(pSDEDQCode.getDBType());
        }
        super.onBeforeCreate(pSDEDQCode);
    }

    @Override
    public String getModelV2Tag(PSDEDQCode pSDEDQCode) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDQCode.getDBType())) {
            return pSDEDQCode.getDBType();
        }
        return super.getModelV2Tag(pSDEDQCode);
    }
}

