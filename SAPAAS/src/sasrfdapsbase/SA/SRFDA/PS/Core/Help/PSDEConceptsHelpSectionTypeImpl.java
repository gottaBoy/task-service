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
 *  net.ibizsys.pscore.srv.config.entity.PSModelBase
 *  net.ibizsys.pscore.srv.config.entity.PSModelField
 *  net.ibizsys.pscore.srv.config.entity.PSModelFieldBase
 *  net.ibizsys.pscore.srv.config.entity.PSModelFieldValue
 *  net.ibizsys.pscore.srv.config.entity.PSModelValueGroup
 *  net.ibizsys.pscore.srv.config.entity.PSModelValueGroupBase
 *  net.ibizsys.pscore.srv.config.service.PSModelFieldService
 *  net.ibizsys.pscore.srv.config.service.PSModelFieldValueService
 *  net.ibizsys.pscore.srv.config.service.PSModelService
 *  net.ibizsys.pscore.srv.config.service.PSModelValueGroupService
 *  net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection
 *  net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Help.PSHelpSectionTypeImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.entity.PSModelField;
import net.ibizsys.pscore.srv.config.entity.PSModelFieldBase;
import net.ibizsys.pscore.srv.config.entity.PSModelFieldValue;
import net.ibizsys.pscore.srv.config.entity.PSModelValueGroup;
import net.ibizsys.pscore.srv.config.entity.PSModelValueGroupBase;
import net.ibizsys.pscore.srv.config.service.PSModelFieldService;
import net.ibizsys.pscore.srv.config.service.PSModelFieldValueService;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.ibizsys.pscore.srv.config.service.PSModelValueGroupService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public class PSDEConceptsHelpSectionTypeImpl
extends PSHelpSectionTypeImpl {
    @Override
    protected void onInitModel(IPSSystem iPSSystem, PSHelpSection psHelpSection) throws Exception {
        String strPSDEId = psHelpSection.getPSHelpArticle().getPSDEId();
        if (StringHelper.isNullOrEmpty((String)strPSDEId)) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u6982\u5ff5\u96c6\u5408\u5e2e\u52a9\u7ae0\u8282\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53"));
        }
        IPSDataEntity iPSDataEntity = iPSSystem.getPSDataEntity2(strPSDEId);
        SelectCond selectCond = new SelectCond();
        selectCond.set("PPSHELPSECTIONID", (Object)psHelpSection.getPSHelpSectionId());
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)iPSSystem.getPSSysModelInstId());
        int nMaxOrderValue = 100;
        PSHelpSectionService psHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)sessionFactory);
        ArrayList psHelpSectionList = psHelpSectionService.select((ISelectCond)selectCond);
        HashMap<String, PSHelpSection> psHelpSectionMap = new HashMap<String, PSHelpSection>();
        for (PSHelpSection psHelpSection2 : psHelpSectionList) {
            psHelpSectionMap.put(psHelpSection2.getPSHelpSectionId(), psHelpSection2);
            if (DataObject.getIntegerValue((Object)psHelpSection2.getOrderValue(), (Integer)100) <= nMaxOrderValue) continue;
            nMaxOrderValue = DataObject.getIntegerValue((Object)psHelpSection2.getOrderValue(), (Integer)100);
        }
        PSModelService psModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class);
        PSModelFieldService psModelFieldService = (PSModelFieldService)ServiceGlobal.getService(PSModelFieldService.class);
        PSModelValueGroupService psModelValueGroupService = (PSModelValueGroupService)ServiceGlobal.getService(PSModelValueGroupService.class);
        PSModelFieldValueService psModelFieldValueService = (PSModelFieldValueService)ServiceGlobal.getService(PSModelFieldValueService.class);
        boolean bExtend = false;
        PSModel psModel = new PSModel();
        String strPSModelId = psHelpSection.getPSHelpArticle().getPSDEName();
        if (!StringHelper.isNullOrEmpty((String)psHelpSection.getPSHelpArticle().getUserTag())) {
            strPSModelId = StringHelper.format((String)"%1$s_%2$s", (Object)psHelpSection.getPSHelpArticle().getPSDEName(), (Object)psHelpSection.getPSHelpArticle().getUserTag());
            bExtend = true;
        }
        psModel.setPSModelId(strPSModelId);
        if (psModelService.get((IEntity)psModel, true)) {
            ArrayList psModelFieldList = psModelFieldService.selectByPSModel((PSModelBase)psModel, "ORDER BY CONCEPTORDERVALUE");
            for (PSModelField psModelField : psModelFieldList) {
                PSHelpSection psHelpSection2;
                String strKeyValue = KeyValueHelper.genUniqueId((String)psHelpSection.getPSHelpSectionId(), (String)"DECONCEPT", (String)psModelField.getPSModelFieldId());
                if (!DataObject.getBoolValue((Integer)psModelField.getValidFlag(), (boolean)false) || !DataObject.getBoolValue((Integer)psModelField.getConceptFlag(), (boolean)false)) {
                    if (!psHelpSectionMap.containsKey(strKeyValue)) continue;
                    psHelpSection2 = new PSHelpSection();
                    psHelpSection2.setPSHelpSectionId(strKeyValue);
                    psHelpSection2.setValidFlag(Integer.valueOf(0));
                    psHelpSectionService.update((IEntity)psHelpSection2);
                    continue;
                }
                psHelpSection2 = new PSHelpSection();
                psHelpSection2.setPPSHelpSectorId(psHelpSection.getPSHelpSectionId());
                psHelpSection2.setPPSHelpSectorName(psHelpSection.getPSHelpSectionName());
                psHelpSection2.setPSHelpArticleId(psHelpSection.getPSHelpArticleId());
                psHelpSection2.setPSHelpArticleName(psHelpSection.getPSHelpArticleName());
                psHelpSection2.setSectionType("DECONCEPT");
                if (bExtend) {
                    IPSDEField iPSDEField = iPSDataEntity.getPSDEField(psModelField.getPSModelFieldName());
                    psHelpSection2.setPSDEFieldId(iPSDEField.getId());
                    psHelpSection2.setPSDEFieldName(psModelField.getPSModelFieldName());
                } else {
                    psHelpSection2.setPSDEFieldId(psModelField.getPSModelFieldId());
                    psHelpSection2.setPSDEFieldName(psModelField.getPSModelFieldName());
                }
                String strConceptTitle = psModelField.getConceptTitle();
                if (StringHelper.isNullOrEmpty((String)strConceptTitle)) {
                    strConceptTitle = psModelField.getMemo();
                }
                psHelpSection2.setPSHelpSectionName(strConceptTitle);
                psHelpSection2.setPSHelpSectionId(strKeyValue);
                if (StringHelper.isNullOrEmpty((String)psModelField.getConceptContent())) {
                    psHelpSection2.setContent(psModelField.getFieldDesc());
                } else {
                    psHelpSection2.setContent(psModelField.getConceptContent());
                }
                psHelpSection2.setOrderValue(psModelField.getConceptOrderValue());
                psHelpSection2.setValidFlag(Integer.valueOf(1));
                if (!psHelpSectionMap.containsKey(strKeyValue)) {
                    psHelpSectionService.create((IEntity)psHelpSection2);
                } else {
                    psHelpSectionService.update((IEntity)psHelpSection2);
                }
                ArrayList psModelValueGroupList = psModelValueGroupService.selectByPSModelField((PSModelFieldBase)psModelField);
                if (psModelValueGroupList.size() == 0) continue;
                PSModelValueGroup psModelValueGroup = null;
                if (StringHelper.isNullOrEmpty((String)psHelpSection2.getPSCodeListId())) {
                    for (PSModelValueGroup psModelValueGroup2 : psModelValueGroupList) {
                        if (StringHelper.isNullOrEmpty((String)psModelValueGroup2.getPSCodeListId())) continue;
                        psModelValueGroup = psModelValueGroup2;
                        psHelpSection2.setPSCodeListId(psModelValueGroup.getPSCodeListId());
                        psHelpSection2.setPSCodeListName(psModelValueGroup.getPSCodeListName());
                        psHelpSectionService.update((IEntity)psHelpSection2);
                        break;
                    }
                } else {
                    for (PSModelValueGroup psModelValueGroup2 : psModelValueGroupList) {
                        if (StringHelper.compare((String)psModelValueGroup2.getPSCodeListId(), (String)psHelpSection2.getPSCodeListId(), (boolean)false) != 0) continue;
                        psModelValueGroup = psModelValueGroup2;
                        break;
                    }
                }
                if (psModelValueGroup == null) {
                    psModelValueGroup = (PSModelValueGroup)psModelValueGroupList.get(0);
                }
                if (psModelValueGroup == null) continue;
                ArrayList psModelFieldValueList = psModelFieldValueService.selectByPSModelValueGroup((PSModelValueGroupBase)psModelValueGroup, "ORDER BY ORDERVALUE");
                for (PSModelFieldValue psModelFieldValue : psModelFieldValueList) {
                    PSHelpSection psHelpSection3 = new PSHelpSection();
                    String strKeyValue2 = KeyValueHelper.genUniqueId((String)psHelpSection2.getPSHelpSectionId(), (String)psModelFieldValue.getPSModelFieldValueId());
                    psHelpSection3.setPSHelpSectionId(strKeyValue2);
                    if (!DataObject.getBoolValue((Integer)psModelFieldValue.getValidFlag(), (boolean)false) || !DataObject.getBoolValue((Integer)psModelFieldValue.getConceptFlag(), (boolean)false)) {
                        if (psHelpSectionService.checkKey((IEntity)psHelpSection3) != 1) continue;
                        psHelpSection3.setValidFlag(Integer.valueOf(0));
                        psHelpSectionService.update((IEntity)psHelpSection3);
                        continue;
                    }
                    psHelpSection3.setPPSHelpSectorId(psHelpSection2.getPSHelpSectionId());
                    psHelpSection3.setPPSHelpSectorName(psHelpSection2.getPSHelpSectionName());
                    psHelpSection3.setPSHelpArticleId(psHelpSection.getPSHelpArticleId());
                    psHelpSection3.setPSHelpArticleName(psHelpSection.getPSHelpArticleName());
                    psHelpSection3.setSectionType("USER");
                    String strTitle = psModelFieldValue.getConceptTitle();
                    if (StringHelper.isNullOrEmpty((String)strTitle)) {
                        strTitle = psModelFieldValue.getPSModelFieldValueName();
                    }
                    psHelpSection3.setPSHelpSectionName(strTitle);
                    psHelpSection3.setContent(psModelFieldValue.getConceptContent());
                    psHelpSection3.setHeaderContent(psModelFieldValue.getValue());
                    psHelpSection3.setOrderValue(psModelFieldValue.getOrderValue());
                    psHelpSection3.setOutputDir(Integer.valueOf(0));
                    if (psHelpSectionService.checkKey((IEntity)psHelpSection3) == 0) {
                        psHelpSection3.setOutputDir(Integer.valueOf(0));
                        psHelpSectionService.create((IEntity)psHelpSection3);
                        continue;
                    }
                    psHelpSectionService.update((IEntity)psHelpSection3);
                }
            }
        } else {
            Iterator<IPSDEField> psDEFields = iPSDataEntity.getPSDEFields();
            while (psDEFields.hasNext()) {
                IPSDEField iPSDEField = psDEFields.next();
                String strKeyValue = KeyValueHelper.genUniqueId((String)psHelpSection.getPSHelpSectionId(), (String)"DECONCEPT", (String)iPSDEField.getId());
                if (psHelpSectionMap.containsKey(strKeyValue) || !StringHelper.isNullOrEmpty((String)iPSDEField.getPreDefinedType()) || iPSDEField.getPSCodeList() == null) continue;
                PSHelpSection psHelpSection2 = new PSHelpSection();
                psHelpSection2.setPPSHelpSectorId(psHelpSection.getPSHelpSectionId());
                psHelpSection2.setPPSHelpSectorName(psHelpSection.getPSHelpSectionName());
                psHelpSection2.setPSHelpArticleId(psHelpSection.getPSHelpArticleId());
                psHelpSection2.setPSHelpArticleName(psHelpSection.getPSHelpArticleName());
                psHelpSection2.setSectionType("DECONCEPT");
                psHelpSection2.setOrderValue(Integer.valueOf(nMaxOrderValue));
                psHelpSection2.setPSDEFieldId(iPSDEField.getId());
                psHelpSection2.setPSDEFieldName(iPSDEField.getName());
                psHelpSection2.setPSCodeListId(iPSDEField.getPSCodeList().getId());
                psHelpSection2.setPSCodeListName(iPSDEField.getPSCodeList().getName());
                psHelpSection2.setPSHelpSectionName(iPSDEField.getLogicName());
                psHelpSection2.setPSHelpSectionId(strKeyValue);
                psHelpSectionService.create((IEntity)psHelpSection2);
                nMaxOrderValue += 100;
            }
        }
        super.onInitModel(iPSSystem, psHelpSection);
    }
}

