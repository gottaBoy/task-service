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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysRefService
extends PSSysRefServiceBase {
    private static final Log log = LogFactory.getLog(PSSysRefService.class);

    @Override
    protected boolean onFillEntityKeyValue(PSSysRef pSSysRef, boolean bl) throws Exception {
        if (!bl && StringHelper.compare((String)pSSysRef.getSysRefType(), (String)"SUBSYS", (boolean)true) == 0) {
            pSSysRef.setRealSysId(pSSysRef.getPSSubSysId());
        }
        return super.onFillEntityKeyValue(pSSysRef, bl);
    }

    @Override
    protected void onBeforeCreate(PSSysRef pSSysRef) throws Exception {
        if (StringHelper.compare((String)pSSysRef.getSysRefType(), (String)"SUBSYS", (boolean)true) == 0) {
            pSSysRef.setRealSysId(pSSysRef.getPSSubSysId());
        }
        super.onBeforeCreate(pSSysRef);
    }

    @Override
    protected void onBeforeUpdate(PSSysRef pSSysRef) throws Exception {
        if (StringHelper.compare((String)pSSysRef.getSysRefType(), (String)"SUBSYS", (boolean)true) == 0) {
            pSSysRef.setRealSysId(pSSysRef.getPSSubSysId());
        }
        super.onBeforeUpdate(pSSysRef);
    }

    @Override
    protected void onAfterCreate(PSSysRef pSSysRef) throws Exception {
        super.onAfterCreate(pSSysRef);
        this.extractPSSysRef(pSSysRef);
    }

    protected void extractPSSysRef(PSSysRef pSSysRef) {
    }
}

