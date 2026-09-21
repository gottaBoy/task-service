/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFSetting;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIAction;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFSettingService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWFUtilUIActionService
extends PSWFUtilUIActionServiceBase {
    private static final Log log = LogFactory.getLog(PSWFUtilUIActionService.class);

    @Override
    public void getDraft(PSWFUtilUIAction pSWFUtilUIAction) throws Exception {
        super.getDraft(pSWFUtilUIAction);
        String string = pSWFUtilUIAction.getPSSysWFSettingId();
        if (StringHelper.isNullOrEmpty((String)string)) {
            string = this.getWebContext().getAppDataValue("pssystemid");
        }
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSSysWFSetting pSSysWFSetting = new PSSysWFSetting();
            pSSysWFSetting.setPSSysWFSettingId(string);
            PSSysWFSettingService pSSysWFSettingService = (PSSysWFSettingService)ServiceGlobal.getService(PSSysWFSettingService.class, (SessionFactory)this.getSessionFactory());
            if (!pSSysWFSettingService.get(pSSysWFSetting, true)) {
                String string2 = this.getWebContext().getAppDataValue("pssystemid");
                String string3 = this.getWebContext().getAppDataValue("pssystemname");
                if (!StringHelper.isNullOrEmpty((String)string2) && !StringHelper.isNullOrEmpty((String)string3)) {
                    pSSysWFSetting.setPSSysWFSettingId(string2);
                    pSSysWFSetting.setPSSysWFSettingName(string3);
                    pSSysWFSetting.setPSSystemId(string2);
                    pSSysWFSetting.setPSSystemName(string3);
                    pSSysWFSettingService.create(pSSysWFSetting);
                    pSWFUtilUIAction.setPSSysWFSettingId(string);
                }
            }
        }
    }

    @Override
    public Object getDataContextValue(PSWFUtilUIAction pSWFUtilUIAction, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && StringHelper.compare((String)string, (String)"pswfid", (boolean)true) == 0) {
            return pSWFUtilUIAction.getPSWorkflowId();
        }
        return super.getDataContextValue(pSWFUtilUIAction, string, iDataContextParam);
    }

    @Override
    public String getModelV2Tag(PSWFUtilUIAction pSWFUtilUIAction) {
        if (!StringHelper.isNullOrEmpty((String)pSWFUtilUIAction.getUtilType())) {
            return pSWFUtilUIAction.getUtilType();
        }
        return super.getModelV2Tag(pSWFUtilUIAction);
    }
}

