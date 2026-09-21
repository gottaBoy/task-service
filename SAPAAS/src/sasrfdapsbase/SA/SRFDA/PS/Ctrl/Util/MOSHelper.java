/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle
 *  net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection
 *  net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService
 *  net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.Util;

import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class MOSHelper {
    private static final Log log = LogFactory.getLog(MOSHelper.class);
    private String strV5SystemId = "86E2A266-4D1E-49F0-A12D-D636905457A3";
    private SessionFactory v6sessionFactory = null;

    public MOSHelper(SessionFactory v6sessionFactory) {
        this.v6sessionFactory = v6sessionFactory;
    }

    public void init() throws Exception {
        try {
            PSSystem psSystem = new PSSystem();
            psSystem.setPSSystemId(this.strV5SystemId);
            PSCoreSysServiceBase.setEnableMergeCount((boolean)false);
            PSCoreSysServiceBase.beginImpSysModel((PSSystem)psSystem);
            HashMap<String, PSDataEntity> modelV2Map = new HashMap<String, PSDataEntity>();
            Iterator modelV2s = PSModelV2Helper.getExportModelV2s();
            while (modelV2s.hasNext()) {
                modelV2Map.put((String)modelV2s.next(), null);
            }
            modelV2Map.put("PSAPPVIEW", null);
            PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class);
            ArrayList psDataEntityList = psDataEntityService.selectByPSSystem((PSSystemBase)psSystem);
            for (PSDataEntity psDataEntity : psDataEntityList) {
                if (!modelV2Map.containsKey(psDataEntity.getPSDataEntityName())) continue;
                modelV2Map.put(psDataEntity.getPSDataEntityName(), psDataEntity);
            }
            this.onInitModelV2UAHelpArticles(modelV2Map);
            this.onInitModelV2UAHelpArticleContents(modelV2Map);
            PSCoreSysServiceBase.endImpSysModel();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            PSCoreSysServiceBase.endImpSysModel();
        }
    }

    protected void onInitModelV2UAHelpArticles(Map<String, PSDataEntity> modelV2Map) throws Exception {
        PSHelpArticleService psHelpArticleService = (PSHelpArticleService)ServiceGlobal.getService(PSHelpArticleService.class);
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            if (psDataEntity == null) continue;
            PSHelpArticle psHelpArticle = new PSHelpArticle();
            psHelpArticle.setPSHelpArticleId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"DEUIACTION"));
            if (psHelpArticleService.checkKey((IEntity)psHelpArticle) == 1) continue;
            psHelpArticle.setPSHelpArticleName(StringHelper.Format((String)"%1$s\u754c\u9762\u884c\u4e3a\u5e2e\u52a9\u6587\u6863", (Object)psDataEntity.getLogicName()));
            psHelpArticle.setArticleType("MANUAL");
            psHelpArticle.setCodeName("DEUIAction");
            psHelpArticle.setPSDEId(psDataEntity.getPSDataEntityId());
            psHelpArticle.setPSDEName(psDataEntity.getPSDataEntityName());
            psHelpArticle.setPSSystemId(psDataEntity.getPSSystemId());
            psHelpArticle.setPSSystemName(psDataEntity.getPSSystemName());
            psHelpArticleService.create((IEntity)psHelpArticle, false);
        }
    }

    protected void onInitModelV2UAHelpArticleContents(Map<String, PSDataEntity> modelV2Map) throws Exception {
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.v6sessionFactory);
        SelectCond selectCond = new SelectCond();
        ArrayList psDEUIActionList = psDEUIActionService.select((ISelectCond)selectCond);
        PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.v6sessionFactory);
        SelectContext selectCond2 = new SelectContext();
        selectCond2.addSelectField("TITLE");
        selectCond2.addSelectField("CAPTION");
        selectCond2.addSelectField("CODENAME");
        selectCond2.addSelectField("PSDEVIEWBASEID");
        ArrayList psDEViewBaseList = psDEViewBaseService.select((ISelectCond)selectCond2);
        HashMap<String, PSDEViewBase> psDEViewBaseMap = new HashMap<String, PSDEViewBase>();
        for (PSDEViewBase psDEViewBase : psDEViewBaseList) {
            psDEViewBaseMap.put(psDEViewBase.getPSDEViewBaseId(), psDEViewBase);
        }
        PSHelpArticleService psHelpArticleService = (PSHelpArticleService)ServiceGlobal.getService(PSHelpArticleService.class);
        PSHelpSectionService psHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class);
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            PSDataEntity psDataEntity = modelV2Map.get(psDEUIAction.getPSDEName());
            if (psDataEntity == null) continue;
            PSHelpArticle psHelpArticle = new PSHelpArticle();
            psHelpArticle.setPSHelpArticleId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"DEUIACTION"));
            if (psHelpArticleService.checkKey((IEntity)psHelpArticle) != 1) continue;
            PSHelpSection psHelpSection = new PSHelpSection();
            psHelpSection.setPSHelpSectionId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)psDEUIAction.getCodeName().toUpperCase()));
            if (psHelpSectionService.checkKey((IEntity)psHelpSection) == 1) continue;
            psHelpSection.setPSHelpSectionName(psDEUIAction.getPSDEUIActionName());
            psHelpSection.setSectionType("USER");
            psHelpSection.setCodeName(psDEUIAction.getCodeName());
            psHelpSection.setPSHelpArticleId(psHelpArticle.getPSHelpArticleId());
            psHelpSection.setOrderValue(Integer.valueOf(1000));
            psHelpSection.setSectionParam(psDEUIAction.getPSDEActionId());
            psHelpSection.setSectionParam2(psDEUIAction.getCaption());
            if (StringHelper.Compare((String)psDEUIAction.getUIActionType(), (String)"FRONT", (boolean)false) == 0) {
                if (!StringHelper.IsNullOrEmpty((String)psDEUIAction.getPSDEViewBaseId())) {
                    PSDEViewBase psDEViewBase = (PSDEViewBase)psDEViewBaseMap.get(psDEUIAction.getPSDEViewBaseId());
                    String strName = null;
                    if (psDEViewBase != null) {
                        psHelpSection.setUserTag3(psDEViewBase.getCodeName());
                        strName = !StringHelper.IsNullOrEmpty((String)psDEViewBase.getTitle()) ? psDEViewBase.getTitle() : psDEViewBase.getCaption();
                    }
                    if (StringHelper.IsNullOrEmpty(strName)) {
                        strName = psDEUIAction.getPSDEViewBaseName();
                    }
                    psHelpSection.setContent(StringHelper.Format((String)"\u6253\u5f00[%1$s]\u8fdb\u884c[%2$s]\u64cd\u4f5c", (Object)strName, (Object)psDEUIAction.getCaption()));
                    psHelpSection.setUserTag(psDEUIAction.getPSDEViewBaseId());
                    psHelpSection.setUserTag2(psDEUIAction.getPSDEViewBaseName());
                }
            } else if (StringHelper.Compare((String)psDEUIAction.getUIActionType(), (String)"BACKEND", (boolean)false) == 0) {
                psHelpSection.setContent(StringHelper.Format((String)"\u8c03\u7528\u540e\u53f0\u8fdb\u884c[%1$s]\u64cd\u4f5c", (Object)psDEUIAction.getCaption()));
                psHelpSection.setUserTag(psDEUIAction.getPSDEActionId());
                psHelpSection.setUserTag2(psDEUIAction.getPSDEActionName());
            }
            psHelpSection.setBottomContent(psDEUIAction.getTooltipInfo());
            psHelpSection.setMemo(psDEUIAction.getMemo());
            psHelpSectionService.create((IEntity)psHelpSection, false);
        }
    }
}

