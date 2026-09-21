/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEWizardService
extends PSDEWizardServiceBase {
    private static final Log log = LogFactory.getLog(PSDEWizardService.class);

    @Override
    protected void onInitFinishAction(PSDEWizard pSDEWizard) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDEWizard.getFinishPSDEActionId())) {
            throw new Exception("\u5f53\u524d\u5df2\u6307\u5b9a\u5b8c\u6210\u5411\u5bfc\u64cd\u4f5c\u884c\u4e3a");
        }
        if (StringHelper.isNullOrEmpty((String)pSDEWizard.getPSDEId())) {
            throw new Exception("\u5b9e\u4f53\u5411\u5bfc\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
        }
        PSDEAction pSDEAction = new PSDEAction();
        pSDEAction.setSessionFactory(this.getSessionFactory());
        pSDEAction.setPSDEId(pSDEWizard.getPSDEId());
        pSDEAction.setCodeName("FinishWizard");
        if (!pSDEAction.select(true)) {
            pSDEAction.resetCodeName();
            pSDEAction.setPSDEActionName("FinishWizard");
            if (!pSDEAction.select(true)) {
                pSDEAction.setCodeName("FinishWizard");
                pSDEAction.setActionType("USERCUSTOM");
                pSDEAction.setMemo("\u5411\u5bfc\u5b8c\u6210\u8c03\u7528\u884c\u4e3a");
                pSDEAction.create();
            }
        }
        pSDEWizard.setFinishPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEWizard.setFinishPSDEActionName(pSDEAction.getPSDEActionName());
    }
}

