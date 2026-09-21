/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.config.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.service.PSDBValueOPServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDBValueOPService
extends PSDBValueOPServiceBase {
    private static final Log log = LogFactory.getLog(PSDBValueOPService.class);

    @Override
    protected CallResult internalGet(PSDBValueOP pSDBValueOP, boolean bl, int n) throws Exception {
        if (!PSDBValueOPService.isMajorSessionFactory(this.getSessionFactory()) && !bl) {
            CallResult callResult = super.internalGet(pSDBValueOP, true, n);
            if (callResult.isOk()) {
                return callResult;
            }
            PSDBValueOPService pSDBValueOPService = (PSDBValueOPService)ServiceGlobal.getService(PSDBValueOPService.class, (SessionFactory)PSDBValueOPService.getCurMajorSessionFactory());
            PSDBValueOP pSDBValueOP2 = new PSDBValueOP();
            pSDBValueOP2.setPSDBValueOPId(pSDBValueOP.getPSDBValueOPId());
            pSDBValueOPService.get((IEntity)pSDBValueOP2);
            this.create(pSDBValueOP2, false);
        }
        return super.internalGet(pSDBValueOP, bl, n);
    }
}

