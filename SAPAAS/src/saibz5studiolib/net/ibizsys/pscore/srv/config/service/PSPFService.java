/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.service.ServiceGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.config.service;

import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPFService
extends PSPFServiceBase {
    private static final Log log = LogFactory.getLog(PSPFService.class);

    @Override
    public DBFetchResult fetchValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSPFService.fetchValid(iDEDataSetFetchContext);
        }
        return super.fetchValid(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurAppTypeValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSPFService.fetchCurAppTypeValid(iDEDataSetFetchContext);
        }
        return super.fetchCurAppTypeValid(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurAppType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSPFService.fetchCurAppType(iDEDataSetFetchContext);
        }
        return super.fetchCurAppType(iDEDataSetFetchContext);
    }
}

