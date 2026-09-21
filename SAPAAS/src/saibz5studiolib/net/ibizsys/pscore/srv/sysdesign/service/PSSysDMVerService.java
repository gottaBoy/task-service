/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysDMVerService
extends PSSysDMVerServiceBase {
    private static final Log log = LogFactory.getLog(PSSysDMVerService.class);

    @Override
    public String getModelV2Tag(PSSysDMVer pSSysDMVer) {
        if (pSSysDMVer.getDMVer() != null) {
            return pSSysDMVer.getDMVer().toString();
        }
        return super.getModelV2Tag(pSSysDMVer);
    }
}

