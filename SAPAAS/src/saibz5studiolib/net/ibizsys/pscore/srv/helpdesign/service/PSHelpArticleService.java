/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.helpdesign.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSHelpArtSec;
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleType;
import net.ibizsys.pscore.srv.config.service.PSHelpArticleTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleServiceBase;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSHelpArticleService
extends PSHelpArticleServiceBase
implements IPSModelService<PSHelpArticle> {
    private static final Log log = LogFactory.getLog(PSHelpArticleService.class);

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDataEntity.getPSDataEntityId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreExtModel(), (boolean)false)) {
                return;
            }
            PSHelpArticle pSHelpArticle = new PSHelpArticle();
            pSHelpArticle.setPSHelpArticleId(pSDataEntity.getPSDataEntityId());
            if (!this.get((IEntity)pSHelpArticle, true)) {
                pSHelpArticle.setArticleType("DEMODEL");
                pSHelpArticle.setPSHelpArticleName(StringHelper.format((String)"[%1$s]\u6a21\u578b\u8bf4\u660e", (Object)pSDataEntity.getPSDataEntityName()));
                pSHelpArticle.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSHelpArticle.setPSDEName(pSDataEntity.getPSDataEntityName());
                pSHelpArticle.setPSSystemId(pSDataEntity.getPSSystemId());
                pSHelpArticle.setPSSystemName(pSDataEntity.getPSSystemName());
                this.create(pSHelpArticle);
            }
        }
    }

    @Override
    protected void onAfterCreate(PSHelpArticle pSHelpArticle) throws Exception {
        super.onAfterCreate(pSHelpArticle);
        PSHelpArticleTypeService pSHelpArticleTypeService = (PSHelpArticleTypeService)ServiceGlobal.getService(PSHelpArticleTypeService.class);
        PSHelpArticleType pSHelpArticleType = new PSHelpArticleType();
        pSHelpArticleType.setPSHelpArticleTypeId(pSHelpArticle.getArticleType());
        pSHelpArticleTypeService.get((IEntity)pSHelpArticleType);
        PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSHelpArtSec> arrayList = pSHelpArticleType.getPSHelpArtSecs();
        for (PSHelpArtSec pSHelpArtSec : arrayList) {
            PSHelpSection pSHelpSection = new PSHelpSection();
            pSHelpSection.setPSHelpArticleId(pSHelpArticle.getPSHelpArticleId());
            pSHelpSection.setPSHelpArticleName(pSHelpArticle.getPSHelpArticleName());
            pSHelpSection.setSectionType(pSHelpArtSec.getPSHelpSectionTypeId());
            pSHelpSection.setOrderValue(pSHelpArtSec.getOrderValue());
            pSHelpSection.setValidFlag(1);
            pSHelpSection.setPSHelpSectionName(pSHelpArtSec.getPSHelpArtSecName());
            pSHelpSection.setPSHelpSectionId(KeyValueHelper.genUniqueId((String)pSHelpArticle.getPSHelpArticleId(), (String)pSHelpArtSec.getPSHelpArtSecId()));
            pSHelpSectionService.create(pSHelpSection);
        }
    }

    @Override
    protected void onInitModel(PSHelpArticle pSHelpArticle) throws Exception {
        if (!pSHelpArticle.isFullEntity()) {
            this.get((IEntity)pSHelpArticle);
        }
        super.onInitModel(pSHelpArticle);
        PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSHelpSection> arrayList = pSHelpArticle.getPSHelpSections();
        for (PSHelpSection pSHelpSection : arrayList) {
            pSHelpSectionService.initModel(pSHelpSection);
        }
    }
}

