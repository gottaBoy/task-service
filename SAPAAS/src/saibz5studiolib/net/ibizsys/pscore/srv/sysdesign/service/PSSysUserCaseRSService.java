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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseRS;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseRSServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysUserCaseRSService
extends PSSysUserCaseRSServiceBase {
    private static final Log log = LogFactory.getLog(PSSysUserCaseRSService.class);

    @Override
    public void getDraft(PSSysUserCaseRS pSSysUserCaseRS) throws Exception {
        super.getDraft(pSSysUserCaseRS);
        if (StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getRSMode())) {
            if (!StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getPPSSysActorId())) {
                if (!StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getPSSysActorId())) {
                    pSSysUserCaseRS.setRSMode("ACTOR2ACTOR");
                } else if (!StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getPSSysUserCaseId())) {
                    pSSysUserCaseRS.setRSMode("ACTOR2USECASE");
                }
            } else if (!StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getPPSSysUserCaseId())) {
                if (!StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getPSSysUserCaseId())) {
                    pSSysUserCaseRS.setRSMode("USECASE2USECASE");
                } else if (!StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getPSSysActorId())) {
                    pSSysUserCaseRS.setRSMode("USECASE2ACTOR");
                }
            }
        }
    }
}

