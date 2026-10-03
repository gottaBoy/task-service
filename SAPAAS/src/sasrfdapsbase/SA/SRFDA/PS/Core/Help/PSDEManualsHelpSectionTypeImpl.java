/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.config.entity.PSModel
 *  net.ibizsys.pscore.srv.config.entity.PSModelExample
 *  net.ibizsys.pscore.srv.config.service.PSModelExampleService
 *  net.ibizsys.pscore.srv.config.service.PSModelService
 *  net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection
 *  net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.PSHelpSectionTypeImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelExample;
import net.ibizsys.pscore.srv.config.service.PSModelExampleService;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public class PSDEManualsHelpSectionTypeImpl
extends PSHelpSectionTypeImpl {
    @Override
    protected void onInitModel(IPSSystem iPSSystem, PSHelpSection psHelpSection) throws Exception {
        String strPSDEId = psHelpSection.getPSHelpArticle().getPSDEId();
        if (StringHelper.isNullOrEmpty((String)strPSDEId)) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u64cd\u4f5c\u96c6\u5408\u5e2e\u52a9\u7ae0\u8282\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53"));
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PPSHELPSECTIONID", (Object)psHelpSection.getPSHelpSectionId());
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)iPSSystem.getPSSysModelInstId());
        int nMaxOrderValue = 100;
        PSHelpSectionService psHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)sessionFactory);
        ArrayList<PSHelpSection> psHelpSectionList = psHelpSectionService.select((ISelectCond)selectCond);
        HashMap<String, PSHelpSection> psHelpSectionMap = new HashMap<String, PSHelpSection>();
        for (PSHelpSection psHelpSection2 : psHelpSectionList) {
            psHelpSectionMap.put(psHelpSection2.getPSHelpSectionId(), psHelpSection2);
            if (DataObject.getIntegerValue((Object)psHelpSection2.getOrderValue(), (Integer)100) <= nMaxOrderValue) continue;
            nMaxOrderValue = DataObject.getIntegerValue((Object)psHelpSection2.getOrderValue(), (Integer)100);
        }
        PSModelService psModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class);
        PSModelExampleService psModelExampleService = (PSModelExampleService)ServiceGlobal.getService(PSModelExampleService.class);
        PSModel psModel = new PSModel();
        String strPSModelId = psHelpSection.getPSHelpArticle().getPSDEName();
        if (!StringHelper.isNullOrEmpty((String)psHelpSection.getPSHelpArticle().getUserTag())) {
            strPSModelId = StringHelper.format((String)"%1$s_%2$s", (Object)psHelpSection.getPSHelpArticle().getPSDEName(), (Object)psHelpSection.getPSHelpArticle().getUserTag());
        }
        psModel.setPSModelId(strPSModelId);
        if (psModelService.get(psModel, true)) {
            int nOrderValue = 1000;
            selectCond.reset();
            selectCond.set("PSMODELID", (Object)strPSModelId);
            selectCond.set("EXAMPLETYPE", (Object)"MANUAL");
            selectCond.setOrderInfo("ORDER BY CATORDERVALUE,ORDERVALUE");
            ArrayList<PSModelExample> psModelExampleList = psModelExampleService.select((ISelectCond)selectCond);
            for (PSModelExample psModelExample : psModelExampleList) {
                PSHelpSection psHelpSection2;
                String strKeyValue = KeyValueHelper.genUniqueId((String)psHelpSection.getPSHelpSectionId(), (String)"DEMANUAL", (String)psModelExample.getPSModelExampleId());
                if (!DataObject.getBoolValue((Integer)psModelExample.getValidFlag(), (boolean)false)) {
                    if (!psHelpSectionMap.containsKey(strKeyValue)) continue;
                    psHelpSection2 = new PSHelpSection();
                    psHelpSection2.setPSHelpSectionId(strKeyValue);
                    psHelpSection2.setValidFlag(Integer.valueOf(0));
                    psHelpSectionService.update(psHelpSection2);
                    continue;
                }
                psHelpSection2 = new PSHelpSection();
                psHelpSection2.setPPSHelpSectorId(psHelpSection.getPSHelpSectionId());
                psHelpSection2.setPPSHelpSectorName(psHelpSection.getPSHelpSectionName());
                psHelpSection2.setPSHelpArticleId(psHelpSection.getPSHelpArticleId());
                psHelpSection2.setPSHelpArticleName(psHelpSection.getPSHelpArticleName());
                psHelpSection2.setSectionType("DEMANUAL");
                psHelpSection2.setPSHelpSectionName(psModelExample.getTitle());
                psHelpSection2.setPSHelpSectionId(strKeyValue);
                psHelpSection2.setHeaderContent(psModelExample.getPSModelExampleCatName());
                psHelpSection2.setContent(psModelExample.getContent());
                psHelpSection2.setBottomContent(psModelExample.getDocUrl());
                psHelpSection2.setOrderValue(Integer.valueOf(nOrderValue += 100));
                psHelpSection2.setValidFlag(Integer.valueOf(1));
                if (!psHelpSectionMap.containsKey(strKeyValue)) {
                    psHelpSectionService.create(psHelpSection2);
                    continue;
                }
                psHelpSectionService.update(psHelpSection2);
            }
        }
        super.onInitModel(iPSSystem, psHelpSection);
    }
}
