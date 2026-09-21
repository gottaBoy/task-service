/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.bidesign.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimension;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysBICubeDimensionService
extends PSSysBICubeDimensionServiceBase {
    private static final Log log = LogFactory.getLog(PSSysBICubeDimensionService.class);

    @Override
    protected CallResult internalGet(PSSysBICubeDimension pSSysBICubeDimension, boolean bl, int n) throws Exception {
        CallResult callResult = super.internalGet(pSSysBICubeDimension, bl, n);
        if (callResult.isOk() && StringHelper.isNullOrEmpty((String)pSSysBICubeDimension.getBIDimensionType())) {
            pSSysBICubeDimension.setBIDimensionType("COMMON");
        }
        return callResult;
    }
}

