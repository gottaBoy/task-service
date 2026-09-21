/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.search.service;

import net.ibizsys.pscore.srv.search.entity.PSSysSearchDE;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysSearchDEService
extends PSSysSearchDEServiceBase {
    private static final Log log = LogFactory.getLog(PSSysSearchDEService.class);

    @Override
    protected void onBeforeCreate(PSSysSearchDE pSSysSearchDE) throws Exception {
        pSSysSearchDE.setPSSysSearchDEName(pSSysSearchDE.getPSDEName());
        super.onBeforeCreate(pSSysSearchDE);
    }

    @Override
    protected void onBuildSearchDEFields(PSSysSearchDE pSSysSearchDE) throws Exception {
    }
}

