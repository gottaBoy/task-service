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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFCode;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysSFCodeService
extends PSSysSFCodeServiceBase {
    private static final Log log = LogFactory.getLog(PSSysSFCodeService.class);

    @Override
    public void create(PSSysSFCode pSSysSFCode, boolean bl) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSSysSFCode.getFullCodeName())) {
            pSSysSFCode.setFullCodeName(pSSysSFCode.getFullCodeName().replace("\\", "/"));
        }
        super.create(pSSysSFCode, bl);
    }
}

