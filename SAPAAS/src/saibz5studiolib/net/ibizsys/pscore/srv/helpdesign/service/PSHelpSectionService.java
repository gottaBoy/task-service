/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.helpdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSHelpSectionService
extends PSHelpSectionServiceBase {
    private static final Log log = LogFactory.getLog(PSHelpSectionService.class);
    private static final Map<String, String> PREDEFINEDFIELDS = new HashMap<String, String>();

    @Override
    protected void onBatDisable(PSHelpSection pSHelpSection) throws Exception {
        pSHelpSection.setValidFlag(0);
        this.update(pSHelpSection);
    }

    @Override
    protected void onBatEnable(PSHelpSection pSHelpSection) throws Exception {
        pSHelpSection.setValidFlag(1);
        this.update(pSHelpSection);
    }

    @Override
    protected void onToggleExpand(PSHelpSection pSHelpSection) throws Exception {
        this.get(pSHelpSection);
        if (DataObject.getBoolValue((Integer)pSHelpSection.getExpandMode(), (boolean)false)) {
            pSHelpSection.setExpandMode(0);
        } else {
            pSHelpSection.setExpandMode(1);
        }
        this.update(pSHelpSection);
    }

    @Override
    protected void onToggleValid(PSHelpSection pSHelpSection) throws Exception {
        this.get(pSHelpSection);
        if (DataObject.getBoolValue((Integer)pSHelpSection.getValidFlag(), (boolean)false)) {
            pSHelpSection.setValidFlag(0);
        } else {
            pSHelpSection.setValidFlag(1);
        }
        this.update(pSHelpSection);
    }

    @Override
    protected void onInitModel(PSHelpSection pSHelpSection) throws Exception {
        if (!pSHelpSection.isFullEntity()) {
            this.get(pSHelpSection);
        }
        super.onInitModel(pSHelpSection);
        if (StringHelper.compare((String)pSHelpSection.getSectionType(), (String)"DECONCEPTS", (boolean)true) == 0) {
            this.onInitDEConcepts(pSHelpSection);
            return;
        }
        if (StringHelper.compare((String)pSHelpSection.getSectionType(), (String)"DEFDESCS", (boolean)true) == 0) {
            this.onInitDEFDescs(pSHelpSection);
            return;
        }
        if (StringHelper.compare((String)pSHelpSection.getSectionType(), (String)"DEUIACTIONS", (boolean)true) == 0) {
            this.onInitDEUIActions(pSHelpSection);
            return;
        }
    }

    protected void onInitDEConcepts(PSHelpSection pSHelpSection) throws Exception {
        PSHelpArticle pSHelpArticle = pSHelpSection.getPSHelpArticle();
        if (pSHelpArticle == null || pSHelpArticle.getPSDE() == null) {
            return;
        }
        ArrayList<PSHelpSection> arrayList = pSHelpSection.getPSHelpSections();
        int n = 100;
        HashMap<String, PSHelpSection> hashMap = new HashMap<String, PSHelpSection>();
        for (PSHelpSection object2 : arrayList) {
            hashMap.put(object2.getPSHelpSectionId(), object2);
            if (DataObject.getIntegerValue((Object)object2.getOrderValue(), (Integer)100) > n) {
                n = DataObject.getIntegerValue((Object)object2.getOrderValue(), (Integer)100);
            }
            if (StringHelper.compare((String)object2.getSectionType(), (String)"DEFDESC", (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)object2.getPSDEFieldId())) continue;
            hashMap.put(object2.getPSDEFieldId(), object2);
        }
        ArrayList<PSDEField> arrayList2 = this.getPSDEFields(pSHelpSection);
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            PSDEField pSDEField = (PSDEField)iterator.next();
            if (hashMap.containsKey(pSDEField.getPSDEFieldId()) || StringHelper.isNullOrEmpty((String)pSDEField.getPSCodeListId())) continue;
            PSHelpSection pSHelpSection2 = new PSHelpSection();
            pSHelpSection2.setPPSHelpSectorId(pSHelpSection.getPSHelpSectionId());
            pSHelpSection2.setPPSHelpSectorName(pSHelpSection.getPSHelpSectionName());
            pSHelpSection2.setPSHelpArticleId(pSHelpSection.getPSHelpArticleId());
            pSHelpSection2.setPSHelpArticleName(pSHelpSection.getPSHelpArticleName());
            pSHelpSection2.setSectionType("DECONCEPT");
            pSHelpSection2.setOrderValue(n);
            pSHelpSection2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSHelpSection2.setPSDEFieldName(pSDEField.getPSDEFieldName());
            pSHelpSection2.setPSHelpSectionName(pSDEField.getLogicName());
            pSHelpSection2.setPSCodeListId(pSDEField.getPSCodeListId());
            pSHelpSection2.setPSCodeListName(pSDEField.getPSCodeListName());
            this.create(pSHelpSection2, false);
            n += 100;
            hashMap.put(pSHelpSection2.getPSDEFieldId(), pSHelpSection2);
        }
    }

    protected void onInitDEFDescs(PSHelpSection pSHelpSection) throws Exception {
        PSHelpArticle pSHelpArticle = pSHelpSection.getPSHelpArticle();
        if (pSHelpArticle == null || pSHelpArticle.getPSDE() == null) {
            return;
        }
        ArrayList<PSHelpSection> arrayList = pSHelpSection.getPSHelpSections();
        int n = 100;
        HashMap<String, PSHelpSection> hashMap = new HashMap<String, PSHelpSection>();
        for (PSHelpSection object2 : arrayList) {
            hashMap.put(object2.getPSHelpSectionId(), object2);
            if (DataObject.getIntegerValue((Object)object2.getOrderValue(), (Integer)100) > n) {
                n = DataObject.getIntegerValue((Object)object2.getOrderValue(), (Integer)100);
            }
            if (StringHelper.compare((String)object2.getSectionType(), (String)"DEFDESC", (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)object2.getPSDEFieldId())) continue;
            hashMap.put(object2.getPSDEFieldId(), object2);
        }
        ArrayList<PSDEField> arrayList2 = this.getPSDEFields(pSHelpSection);
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            PSDEField pSDEField = (PSDEField)iterator.next();
            if (hashMap.containsKey(pSDEField.getPSDEFieldId())) continue;
            PSHelpSection pSHelpSection2 = new PSHelpSection();
            pSHelpSection2.setPPSHelpSectorId(pSHelpSection.getPSHelpSectionId());
            pSHelpSection2.setPPSHelpSectorName(pSHelpSection.getPSHelpSectionName());
            pSHelpSection2.setPSHelpArticleId(pSHelpSection.getPSHelpArticleId());
            pSHelpSection2.setPSHelpArticleName(pSHelpSection.getPSHelpArticleName());
            pSHelpSection2.setSectionType("DEFDESC");
            pSHelpSection2.setOrderValue(n);
            pSHelpSection2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSHelpSection2.setPSDEFieldName(pSDEField.getPSDEFieldName());
            pSHelpSection2.setPSHelpSectionName(pSDEField.getLogicName());
            this.create(pSHelpSection2, false);
            n += 100;
            hashMap.put(pSHelpSection2.getPSDEFieldId(), pSHelpSection2);
        }
    }

    protected void onInitDEUIActions(PSHelpSection pSHelpSection) throws Exception {
        PSHelpArticle pSHelpArticle = pSHelpSection.getPSHelpArticle();
        if (pSHelpArticle == null || pSHelpArticle.getPSDE() == null) {
            return;
        }
        ArrayList<PSHelpSection> arrayList = pSHelpSection.getPSHelpSections();
        int n = 100;
        HashMap<String, PSHelpSection> hashMap = new HashMap<String, PSHelpSection>();
        for (PSHelpSection object2 : arrayList) {
            hashMap.put(object2.getPSHelpSectionId(), object2);
            if (DataObject.getIntegerValue((Object)object2.getOrderValue(), (Integer)100) > n) {
                n = DataObject.getIntegerValue((Object)object2.getOrderValue(), (Integer)100);
            }
            if (StringHelper.compare((String)object2.getSectionType(), (String)"DEUIACTION", (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)object2.getPSDEUIActionId())) continue;
            hashMap.put(object2.getPSDEUIActionId(), object2);
        }
        ArrayList<PSDEUIAction> arrayList2 = pSHelpArticle.getPSDE().getPSDEUIActions();
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iterator.next();
            if (hashMap.containsKey(pSDEUIAction.getPSDEUIActionId())) continue;
            PSHelpSection pSHelpSection2 = new PSHelpSection();
            pSHelpSection2.setPPSHelpSectorId(pSHelpSection.getPSHelpSectionId());
            pSHelpSection2.setPPSHelpSectorName(pSHelpSection.getPSHelpSectionName());
            pSHelpSection2.setPSHelpArticleId(pSHelpSection.getPSHelpArticleId());
            pSHelpSection2.setPSHelpArticleName(pSHelpSection.getPSHelpArticleName());
            pSHelpSection2.setSectionType("DEUIACTION");
            pSHelpSection2.setOrderValue(n);
            pSHelpSection2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSHelpSection2.setPSDEFieldName(pSDEUIAction.getPSDEUIActionName());
            pSHelpSection2.setPSHelpSectionName(pSDEUIAction.getCaption());
            if (StringHelper.isNullOrEmpty((String)pSHelpSection2.getPSHelpSectionName())) {
                pSHelpSection2.setPSHelpSectionName(pSDEUIAction.getPSDEUIActionName());
            }
            this.create(pSHelpSection2, false);
            n += 100;
            hashMap.put(pSHelpSection2.getPSDEFieldId(), pSHelpSection2);
        }
    }

    protected ArrayList<PSDEField> getPSDEFields(PSHelpSection pSHelpSection) throws Exception {
        ArrayList<PSDEField> arrayList = new ArrayList<PSDEField>();
        PSHelpArticle pSHelpArticle = pSHelpSection.getPSHelpArticle();
        ArrayList<PSDEField> arrayList2 = pSHelpArticle.getPSDE().getPSDEFields();
        boolean bl = DataObject.getBoolValue((Integer)pSHelpArticle.getPSDE().getLogicValid(), (boolean)false);
        for (PSDEField pSDEField : arrayList2) {
            String string = pSDEField.getPreDefineType();
            if (StringHelper.isNullOrEmpty((String)string)) {
                string = PREDEFINEDFIELDS.get(pSDEField.getPSDEFieldName().toUpperCase());
            }
            if (!StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string, (String)"NONE", (boolean)false) != 0 && (StringHelper.compare((String)string, (String)"LOGICVALID", (boolean)true) != 0 || bl)) continue;
            arrayList.add(pSDEField);
        }
        return arrayList;
    }

    static {
        PREDEFINEDFIELDS.put("CREATEMAN", "CREATEMAN");
        PREDEFINEDFIELDS.put("CREATEMANNAME", "CREATEMANNAME");
        PREDEFINEDFIELDS.put("CREATEDATE", "CREATEDATE");
        PREDEFINEDFIELDS.put("UPDATEMAN", "UPDATEMAN");
        PREDEFINEDFIELDS.put("UPDATEMANNAME", "UPDATEMANNAME");
        PREDEFINEDFIELDS.put("ENABLE", "LOGICVALID");
        PREDEFINEDFIELDS.put("ORGID", "ORGID");
        PREDEFINEDFIELDS.put("ORGSECTORID", "ORGSECTORID");
        PREDEFINEDFIELDS.put("ORGNAME", "ORGNAME");
        PREDEFINEDFIELDS.put("ORGSECTORNAME", "ORGSECTORNAME");
    }
}

