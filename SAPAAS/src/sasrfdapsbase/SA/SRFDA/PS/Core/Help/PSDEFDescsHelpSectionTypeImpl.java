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
 *  net.ibizsys.pscore.srv.config.service.PSModelFieldService
 *  net.ibizsys.pscore.srv.config.service.PSModelService
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
import net.ibizsys.pscore.srv.config.service.PSModelFieldService;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public class PSDEFDescsHelpSectionTypeImpl
extends PSHelpSectionTypeImpl {
    @Override
    protected void onInitModel(IPSSystem iPSSystem, PSHelpSection psHelpSection) throws Exception {
        String strPSDEId = psHelpSection.getPSHelpArticle().getPSDEId();
        if (StringHelper.isNullOrEmpty((String)strPSDEId)) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u5c5e\u6027\u8bf4\u660e\u96c6\u5408\u5e2e\u52a9\u7ae0\u8282\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53"));
        }
        IPSDataEntity iPSDataEntity = iPSSystem.getPSDataEntity2(strPSDEId);
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
        PSModelFieldService psModelFieldService = (PSModelFieldService)ServiceGlobal.getService(PSModelFieldService.class);
        boolean bExtend = false;
        PSModel psModel = new PSModel();
        String strPSModelId = psHelpSection.getPSHelpArticle().getPSDEName();
        if (!StringHelper.isNullOrEmpty((String)psHelpSection.getPSHelpArticle().getUserTag())) {
            strPSModelId = StringHelper.format((String)"%1$s_%2$s", (Object)psHelpSection.getPSHelpArticle().getPSDEName(), (Object)psHelpSection.getPSHelpArticle().getUserTag());
            bExtend = true;
        }
        psModel.setPSModelId(strPSModelId);
        if (psModelService.get(psModel, true)) {
            ArrayList<PSModelField> psModelFieldList = psModelFieldService.selectByPSModel((PSModelBase)psModel);
            for (PSModelField psModelField : psModelFieldList) {
                PSHelpSection psHelpSection2;
                String strKeyValue = KeyValueHelper.genUniqueId((String)psHelpSection.getPSHelpSectionId(), (String)"DEFDESC", (String)psModelField.getPSModelFieldId());
                if (!DataObject.getBoolValue((Integer)psModelField.getValidFlag(), (boolean)false)) {
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
                psHelpSection2.setSectionType("DEFDESC");
                if (bExtend) {
                    IPSDEField iPSDEField = iPSDataEntity.getPSDEField(psModelField.getPSModelFieldName());
                    psHelpSection2.setPSDEFieldId(iPSDEField.getId());
                    psHelpSection2.setPSDEFieldName(psModelField.getPSModelFieldName());
                } else {
                    psHelpSection2.setPSDEFieldId(psModelField.getPSModelFieldId());
                    psHelpSection2.setPSDEFieldName(psModelField.getPSModelFieldName());
                }
                psHelpSection2.setPSHelpSectionName(psModelField.getPSModelFieldName());
                psHelpSection2.setPSHelpSectionId(strKeyValue);
                psHelpSection2.setHeaderContent(psModelField.getDataTypeDesc());
                String strContent = psModelField.getMemo();
                if (!StringHelper.isNullOrEmpty((String)psModelField.getFieldDesc())) {
                    if (!StringHelper.isNullOrEmpty((String)strContent)) {
                        strContent = String.valueOf(strContent) + "\uff0c";
                    }
                    strContent = String.valueOf(strContent) + psModelField.getFieldDesc();
                }
                psHelpSection2.setContent(strContent);
                psHelpSection2.setValidFlag(Integer.valueOf(1));
                if (!psHelpSectionMap.containsKey(strKeyValue)) {
                    psHelpSection2.setOrderValue(Integer.valueOf(nMaxOrderValue += 100));
                    psHelpSectionService.create(psHelpSection2);
                    continue;
                }
                psHelpSectionService.update(psHelpSection2);
            }
        } else {
            Iterator<IPSDEField> psDEFields = iPSDataEntity.getPSDEFields();
            while (psDEFields.hasNext()) {
                IPSDEField iPSDEField = psDEFields.next();
                String strKeyValue = KeyValueHelper.genUniqueId((String)psHelpSection.getPSHelpSectionId(), (String)"DEFDESC", (String)iPSDEField.getId());
                if (psHelpSectionMap.containsKey(strKeyValue) || !StringHelper.isNullOrEmpty((String)iPSDEField.getPreDefinedType())) continue;
                PSHelpSection psHelpSection2 = new PSHelpSection();
                psHelpSection2.setPPSHelpSectorId(psHelpSection.getPSHelpSectionId());
                psHelpSection2.setPPSHelpSectorName(psHelpSection.getPSHelpSectionName());
                psHelpSection2.setPSHelpArticleId(psHelpSection.getPSHelpArticleId());
                psHelpSection2.setPSHelpArticleName(psHelpSection.getPSHelpArticleName());
                psHelpSection2.setSectionType("DEFDESC");
                psHelpSection2.setOrderValue(Integer.valueOf(nMaxOrderValue));
                psHelpSection2.setPSDEFieldId(iPSDEField.getId());
                psHelpSection2.setPSDEFieldName(iPSDEField.getName());
                psHelpSection2.setPSHelpSectionName(iPSDEField.getLogicName());
                psHelpSection2.setPSHelpSectionId(strKeyValue);
                psHelpSectionService.create(psHelpSection2);
                nMaxOrderValue += 100;
            }
        }
        super.onInitModel(iPSSystem, psHelpSection);
    }
}
