/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUIStyle;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleServiceBase;
import net.ibizsys.pscore.srv.codelist.AppUIStyleCodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppUIStyleService
extends PSAppUIStyleServiceBase {
    private static final Log log = LogFactory.getLog(PSAppUIStyleService.class);

    @Override
    protected void onBeforeCreate(PSAppUIStyle pSAppUIStyle) throws Exception {
        this.calcPSAppUIStyleName(pSAppUIStyle);
        this.syncPSPFStyle(pSAppUIStyle);
        super.onBeforeCreate(pSAppUIStyle);
    }

    @Override
    protected void onBeforeUpdate(PSAppUIStyle pSAppUIStyle) throws Exception {
        this.calcPSAppUIStyleName(pSAppUIStyle);
        this.syncPSPFStyle(pSAppUIStyle);
        super.onBeforeUpdate(pSAppUIStyle);
    }

    protected void calcPSAppUIStyleName(PSAppUIStyle pSAppUIStyle) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppUIStyle.getUIStyle())) {
            return;
        }
        pSAppUIStyle.setPSAppUIStyleName(StringHelper.format((String)"%1$s[%2$s]", (Object)pSAppUIStyle.getPSSysAppName(), (Object)AppUIStyleCodeListModel.getInstance().getCodeListText(pSAppUIStyle.getUIStyle(), true)));
    }

    protected void syncPSPFStyle(PSAppUIStyle pSAppUIStyle) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppUIStyle.getPSPFStyleId())) {
            return;
        }
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
        PSPFStyle pSPFStyle = new PSPFStyle();
        pSPFStyle.setPSPFStyleId(pSAppUIStyle.getPSPFStyleId());
        if (pSPFStyleService.get((IEntity)pSPFStyle, true)) {
            return;
        }
        PSPFStyleService pSPFStyleService2 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSPFStyle pSPFStyle2 = new PSPFStyle();
        pSPFStyle2.setPSPFStyleId(pSAppUIStyle.getPSPFStyleId());
        if (!pSPFStyleService2.get((IEntity)pSPFStyle2, true)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f\u6837\u5f0f[%1$s]", (Object)pSAppUIStyle.getPSPFStyleId()));
        }
        PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
        PSPF pSPF = new PSPF();
        pSPF.setPSPFId(pSPFStyle2.getPSPFId());
        if (!pSPFService.get((IEntity)pSPF, true)) {
            PSPFService pSPFService2 = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSPF pSPF2 = new PSPF();
            pSPF2.setPSPFId(pSPFStyle2.getPSPFId());
            if (!pSPFService2.get((IEntity)pSPF2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f[%1$s]", (Object)pSPFStyle2.getPSPFId()));
            }
            PSAppTypeService pSAppTypeService = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSAppType pSAppType = new PSAppType();
            pSAppType.setPSAppTypeId(pSPF2.getPSAppTypeId());
            if (!pSAppTypeService.get((IEntity)pSAppType, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f[%1$s]", (Object)pSPFStyle2.getPSPFId()));
            }
            PSAppTypeService pSAppTypeService2 = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
            pSAppTypeService2.save((IEntity)pSAppType, false);
            pSPF.setPSAppTypeId(pSAppType.getPSAppTypeId());
            pSPF.setPSAppTypeName(pSAppType.getPSAppTypeName());
            pSPF.setPSPFId(pSPF2.getPSPFId());
            pSPF.setPSPFName(pSPF2.getPSPFName());
            pSPF.setValidFlag(1);
            pSPFService.create(pSPF);
        }
        pSPFStyle.setPSPFStyleId(pSPFStyle2.getPSPFStyleId());
        pSPFStyle.setPSPFStyleName(pSPFStyle2.getPSPFStyleName());
        pSPFStyle.setPSPFId(pSPFStyle2.getPSPFId());
        pSPFStyle.setPSPFName(pSPFStyle2.getPSPFName());
        pSPFStyle.setStyleCode(pSPFStyle2.getStyleCode());
        pSPFStyle.setStyleEngine(pSPFStyle2.getStyleEngine());
        pSPFStyleService.create(pSPFStyle);
    }
}

