/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppStartPage;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppStartPageServiceBase;
import net.ibizsys.pscore.srv.codelist.MobAppResTypeCodeListModel;
import net.ibizsys.pscore.srv.codelist.MobSceenResolutionCodeListModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSMobAppStartPageService
extends PSMobAppStartPageServiceBase {
    private static final Log log = LogFactory.getLog(PSMobAppStartPageService.class);

    @Override
    protected void onBeforeCreate(PSMobAppStartPage pSMobAppStartPage) throws Exception {
        MobAppResTypeCodeListModel mobAppResTypeCodeListModel = (MobAppResTypeCodeListModel)CodeListGlobal.getCodeList(MobAppResTypeCodeListModel.class);
        MobSceenResolutionCodeListModel mobSceenResolutionCodeListModel = (MobSceenResolutionCodeListModel)CodeListGlobal.getCodeList(MobSceenResolutionCodeListModel.class);
        if (StringHelper.isNullOrEmpty((String)pSMobAppStartPage.getResSpec())) {
            pSMobAppStartPage.setPSMobAppStartPageName(StringHelper.format((String)"%1$s", (Object)mobAppResTypeCodeListModel.getCodeListText(pSMobAppStartPage.getResType(), true)));
        } else {
            pSMobAppStartPage.setPSMobAppStartPageName(StringHelper.format((String)"%1$s[%2$s]", (Object)mobAppResTypeCodeListModel.getCodeListText(pSMobAppStartPage.getResType(), true), (Object)mobSceenResolutionCodeListModel.getCodeListText(pSMobAppStartPage.getResSpec(), true)));
        }
        super.onBeforeCreate(pSMobAppStartPage);
    }

    @Override
    protected void onBeforeUpdate(PSMobAppStartPage pSMobAppStartPage) throws Exception {
        MobAppResTypeCodeListModel mobAppResTypeCodeListModel = (MobAppResTypeCodeListModel)CodeListGlobal.getCodeList(MobAppResTypeCodeListModel.class);
        MobSceenResolutionCodeListModel mobSceenResolutionCodeListModel = (MobSceenResolutionCodeListModel)CodeListGlobal.getCodeList(MobSceenResolutionCodeListModel.class);
        if (StringHelper.isNullOrEmpty((String)pSMobAppStartPage.getResSpec())) {
            pSMobAppStartPage.setPSMobAppStartPageName(StringHelper.format((String)"%1$s", (Object)mobAppResTypeCodeListModel.getCodeListText(pSMobAppStartPage.getResType(), true)));
        } else {
            pSMobAppStartPage.setPSMobAppStartPageName(StringHelper.format((String)"%1$s[%2$s]", (Object)mobAppResTypeCodeListModel.getCodeListText(pSMobAppStartPage.getResType(), true), (Object)mobSceenResolutionCodeListModel.getCodeListText(pSMobAppStartPage.getResSpec(), true)));
        }
        super.onBeforeUpdate(pSMobAppStartPage);
    }
}

