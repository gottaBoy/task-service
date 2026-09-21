/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.systest.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysTestCaseService
extends PSSysTestCaseServiceBase {
    private static final Log log = LogFactory.getLog(PSSysTestCaseService.class);

    public void getDraftTempMajor(PSSysTestCase pSSysTestCase) throws Exception {
        super.getDraftTempMajor((IEntity)pSSysTestCase);
        if (pSSysTestCase.getPSDEServiceAPI() != null) {
            pSSysTestCase.setPSSysServiceAPIId(pSSysTestCase.getPSDEServiceAPI().getPSSysServiceAPIId());
        } else if (pSSysTestCase.getPSAppView() != null) {
            pSSysTestCase.setPSSysAppId(pSSysTestCase.getPSAppView().getPSSysAppId());
        }
    }

    @Override
    public void getDraft(PSSysTestCase pSSysTestCase) throws Exception {
        super.getDraft(pSSysTestCase);
        if (pSSysTestCase.getPSDEServiceAPI() != null) {
            pSSysTestCase.setPSSysServiceAPIId(pSSysTestCase.getPSDEServiceAPI().getPSSysServiceAPIId());
        } else if (pSSysTestCase.getPSAppView() != null) {
            pSSysTestCase.setPSSysAppId(pSSysTestCase.getPSAppView().getPSSysAppId());
        }
    }

    @Override
    public Object getDataContextValue(PSSysTestCase pSSysTestCase, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = super.getDataContextValue(pSSysTestCase, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSSYSSERVICEAPI", (boolean)true) == 0 && StringHelper.compare((String)string, (String)"pssysserviceapiid", (boolean)true) == 0) {
                if (pSSysTestCase.getPSDEServiceAPI() != null) {
                    return pSSysTestCase.getPSDEServiceAPI().getPSSysServiceAPIId();
                }
                return null;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSSYSAPP", (boolean)true) == 0 && StringHelper.compare((String)string, (String)"pssysappid", (boolean)true) == 0) {
                if (pSSysTestCase.getPSAppView() != null) {
                    return pSSysTestCase.getPSAppView().getPSSysAppId();
                }
                return null;
            }
        }
        return null;
    }
}

