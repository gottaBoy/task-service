/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.systest.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTDItem;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.service.PSSysTDItemService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysTestDataService
extends PSSysTestDataServiceBase {
    private static final Log log = LogFactory.getLog(PSSysTestDataService.class);

    @Override
    protected void onAfterGetDraftTemp(PSSysTestData pSSysTestData) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSSysTestData.getPSDEId())) {
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.setPSDataEntityId(pSSysTestData.getPSDEId());
            ArrayList<PSDEField> arrayList = pSDEFieldService.selectByPSDE(pSDataEntity);
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("CREATEDATE", "CREATEDATE");
            hashMap.put("CREATEMAN", "CREATEMAN");
            hashMap.put("LOGICVALID", "ENABLE");
            hashMap.put("UPDATEDATE", "UPDATEDATE");
            hashMap.put("UPDATEMAN", "UPDATEMAN");
            for (PSDEField object : arrayList) {
                if (StringHelper.isNullOrEmpty((String)object.getPreDefineType())) continue;
                hashMap.put(object.getPreDefineType(), object.getPSDEFieldName());
            }
            HashMap hashMap2 = new HashMap();
            for (String string : hashMap.values()) {
                hashMap2.put(string, "");
            }
            for (PSDEField pSDEField : arrayList) {
                if (DataObject.getBoolValue((Integer)pSDEField.getPKey(), (boolean)false) || hashMap2.containsKey(pSDEField.getPSDEFieldName())) continue;
                PSSysTDItem pSSysTDItem = new PSSysTDItem();
                pSSysTDItem.setPSSysTDItemName(pSDEField.getPSDEFieldName());
                pSSysTDItem.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
                pSSysTDItem.setPSSysTestDataName(pSSysTestData.getPSSysTestDataName());
                pSSysTDItem.setValueType("VALUE");
                pSSysTDItem.setMemo(pSDEField.getLogicName());
                pSSysTDItemService.createTemp(pSSysTDItem);
            }
        }
        super.onAfterGetDraftTemp(pSSysTestData);
    }

    @Override
    protected void onInitModel(PSSysTestData pSSysTestData) throws Exception {
        if (!pSSysTestData.isFullEntity()) {
            this.get(pSSysTestData);
        }
        super.onInitModel(pSSysTestData);
        if (StringHelper.isNullOrEmpty((String)pSSysTestData.getPSDEId())) {
            return;
        }
        ArrayList<PSDEField> arrayList = pSSysTestData.getPSDE().getPSDEFields();
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysTDItem> arrayList2 = pSSysTDItemService.selectByPSSysTestData(pSSysTestData);
        HashMap<String, PSDEField> hashMap = new HashMap<String, PSDEField>();
        for (PSDEField entityBase : arrayList) {
            hashMap.put(entityBase.getPSDEFieldName().toLowerCase(), entityBase);
        }
        for (PSSysTDItem pSSysTDItem : arrayList2) {
            hashMap.remove(pSSysTDItem.getPSSysTDItemName().toLowerCase());
        }
        for (PSDEField pSDEField : hashMap.values()) {
            PSSysTDItem pSSysTDItem = new PSSysTDItem();
            pSSysTDItem.setPSSysTDItemName(pSDEField.getPSDEFieldName());
            pSSysTDItem.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
            pSSysTDItem.setPSSysTestDataName(pSSysTestData.getPSSysTestDataName());
            pSSysTDItem.setValueType("VALUE");
            pSSysTDItem.setMemo(pSDEField.getLogicName());
            pSSysTDItem.setValidFlag(1);
            pSSysTDItemService.create(pSSysTDItem, false);
        }
    }
}

