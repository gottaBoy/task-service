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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysDBVFService
extends PSSysDBVFServiceBase {
    private static final Log log = LogFactory.getLog(PSSysDBVFService.class);

    @Override
    protected void onBeforeCreate(PSSysDBVF pSSysDBVF) throws Exception {
        String string;
        if (StringHelper.compare((String)"UX", (String)pSSysDBVF.getVFType(), (boolean)false) == 0 && !StringHelper.isNullOrEmpty((String)(string = pSSysDBVF.getCodeName())) && string.indexOf("UX") != 0) {
            pSSysDBVF.setCodeName("UX" + string);
        }
        super.onBeforeCreate(pSSysDBVF);
    }

    @Override
    protected void onBeforeUpdate(PSSysDBVF pSSysDBVF) throws Exception {
        String string;
        if (StringHelper.compare((String)"UX", (String)pSSysDBVF.getVFType(), (boolean)false) == 0 && !StringHelper.isNullOrEmpty((String)(string = pSSysDBVF.getCodeName())) && string.indexOf("UX") != 0) {
            pSSysDBVF.setCodeName("UX" + string);
        }
        super.onBeforeUpdate(pSSysDBVF);
    }
}

