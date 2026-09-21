/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSubSysSADEFieldService
extends PSSubSysSADEFieldServiceBase {
    private static final Log log = LogFactory.getLog(PSSubSysSADEFieldService.class);

    @Override
    protected void onBeforeCreate(PSSubSysSADEField pSSubSysSADEField) throws Exception {
        super.onBeforeCreate(pSSubSysSADEField);
    }

    @Override
    protected void onBeforeUpdate(PSSubSysSADEField pSSubSysSADEField) throws Exception {
        super.onBeforeUpdate(pSSubSysSADEField);
    }
}

