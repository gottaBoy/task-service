/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.bdscheme.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableRS;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableRSServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysBDTableRSService
extends PSSysBDTableRSServiceBase {
    private static final Log log = LogFactory.getLog(PSSysBDTableRSService.class);

    @Override
    protected void onBeforeCreate(PSSysBDTableRS pSSysBDTableRS) throws Exception {
        String string = StringHelper.format((String)"%1$s_%2$s", (Object)pSSysBDTableRS.getMajorPSSysBDTableName(), (Object)pSSysBDTableRS.getMinorPSSysBDTableName());
        pSSysBDTableRS.setPSSysBDTableRSName(string.toUpperCase());
        super.onBeforeCreate(pSSysBDTableRS);
    }
}

