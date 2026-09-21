/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.systest.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrj;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysTestPrjService
extends PSSysTestPrjServiceBase {
    private static final Log log = LogFactory.getLog(PSSysTestPrjService.class);

    @Override
    public void getDraft(PSSysTestPrj pSSysTestPrj) throws Exception {
        super.getDraft(pSSysTestPrj);
        if (!StringHelper.isNullOrEmpty((String)pSSysTestPrj.getPSSysServiceAPIId())) {
            pSSysTestPrj.setPrjType("SYSSERVICEAPI");
        } else if (!StringHelper.isNullOrEmpty((String)pSSysTestPrj.getPSSysAppId())) {
            pSSysTestPrj.setPrjType("SYSAPP");
        }
    }
}

