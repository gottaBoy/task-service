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
package net.ibizsys.pscore.srv.bdscheme.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSet;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColumn;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDE;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysBDTableService
extends PSSysBDTableServiceBase {
    private static final Log log = LogFactory.getLog(PSSysBDTableService.class);

    @Override
    public void getDraft(PSSysBDTable pSSysBDTable) throws Exception {
        super.getDraft(pSSysBDTable);
        PSDataEntity pSDataEntity = pSSysBDTable.getPSDE();
        if (pSDataEntity != null) {
            if (StringHelper.isNullOrEmpty((String)pSSysBDTable.getPSSysBDTableName())) {
                pSSysBDTable.setPSSysBDTableName(pSDataEntity.getPSDataEntityName());
            }
            if (StringHelper.isNullOrEmpty((String)pSSysBDTable.getCodeName())) {
                pSSysBDTable.setCodeName(pSDataEntity.getCodeName());
            }
        }
    }

    @Override
    protected void onAfterCreate(PSSysBDTable pSSysBDTable) throws Exception {
        if (!PSSysBDTableService.isImpSysModelNowEx()) {
            this.createDefaultPSSysBDColSet(pSSysBDTable);
            this.createDefaultPSSysBDTableDE(pSSysBDTable);
        }
        super.onAfterCreate(pSSysBDTable);
    }

    @Override
    protected void onAfterUpdate(PSSysBDTable pSSysBDTable) throws Exception {
        super.onAfterUpdate(pSSysBDTable);
    }

    protected void createDefaultPSSysBDTableDE(PSSysBDTable pSSysBDTable) throws Exception {
        PSSysBDTableDEService pSSysBDTableDEService = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysBDTable.getBDTableType() == 3) {
            PSSysBDTableDE pSSysBDTableDE = new PSSysBDTableDE();
            pSSysBDTable.copyTo((IDataObject)pSSysBDTableDE, true);
            pSSysBDTableDE.setPSSysBDTableDEId(KeyValueHelper.genUniqueId((String)pSSysBDTable.getPSSysBDTableId(), (String)pSSysBDTable.getPSDEId(), (String)"2"));
            if (pSSysBDTableDEService.checkKey(pSSysBDTableDE) == 1) {
                pSSysBDTableDE.setPSSysBDTableDEName(pSSysBDTable.getPSDEName());
                pSSysBDTableDE.setDefaultFlag(2);
                pSSysBDTableDEService.update(pSSysBDTableDE);
            } else {
                pSSysBDTableDE.setPSSysBDTableDEName(pSSysBDTable.getPSDEName());
                pSSysBDTableDE.setDefaultFlag(2);
                pSSysBDTableDEService.create(pSSysBDTableDE);
            }
            pSSysBDTableDE = new PSSysBDTableDE();
            pSSysBDTable.copyTo((IDataObject)pSSysBDTableDE, true);
            pSSysBDTableDE.setPSDEId(pSSysBDTable.getMinorPSDEId());
            pSSysBDTableDE.setPSDEName(pSSysBDTable.getMinorPSDEName());
            pSSysBDTableDE.setPSSysBDTableDEId(KeyValueHelper.genUniqueId((String)pSSysBDTable.getPSSysBDTableId(), (String)pSSysBDTable.getMinorPSDEId(), (String)"3"));
            if (pSSysBDTableDEService.checkKey(pSSysBDTableDE) == 1) {
                pSSysBDTableDE.setPSSysBDTableDEName(pSSysBDTable.getMinorPSDEName());
                pSSysBDTableDE.setDefaultFlag(3);
                pSSysBDTableDEService.update(pSSysBDTableDE);
            } else {
                pSSysBDTableDE.setPSSysBDTableDEName(pSSysBDTable.getMinorPSDEName());
                pSSysBDTableDE.setDefaultFlag(3);
                pSSysBDTableDEService.create(pSSysBDTableDE);
            }
            if (!StringHelper.isNullOrEmpty((String)pSSysBDTable.getUserTag())) {
                // empty if block
            }
        } else {
            PSSysBDColumn pSSysBDColumn;
            PSSysBDTableDE pSSysBDTableDE = new PSSysBDTableDE();
            pSSysBDTable.copyTo((IDataObject)pSSysBDTableDE, true);
            pSSysBDTableDE.setPSSysBDTableDEId(KeyValueHelper.genUniqueId((String)pSSysBDTable.getPSSysBDTableId(), (String)pSSysBDTable.getPSDEId(), (String)"1"));
            if (pSSysBDTableDEService.checkKey(pSSysBDTableDE) == 1) {
                pSSysBDTableDE.setPSSysBDTableDEName(pSSysBDTable.getPSDEName());
                pSSysBDTableDE.setDefaultFlag(1);
                pSSysBDTableDEService.update(pSSysBDTableDE);
            } else {
                pSSysBDTableDE.setPSSysBDTableDEName(pSSysBDTable.getPSDEName());
                pSSysBDTableDE.setDefaultFlag(1);
                pSSysBDTableDEService.create(pSSysBDTableDE);
            }
            PSSysBDColSetService pSSysBDColSetService = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSSysBDColumnService pSSysBDColumnService = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
            PSSysBDColSet pSSysBDColSet = new PSSysBDColSet();
            pSSysBDColSet.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
            pSSysBDColSet.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
            pSSysBDColSet.setPSSysBDColSetName("CREATEINFO");
            pSSysBDColSet.setCodeName("CreateInfo");
            pSSysBDColSet.setLogicName("\u521b\u5efa\u4fe1\u606f");
            pSSysBDColSet.setDefaultFlag(0);
            pSSysBDColSetService.create(pSSysBDColSet);
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEId(pSSysBDTable.getPSDEId());
            pSDEField.setPreDefineType("CREATEDATE");
            if (!pSDEFieldService.select(pSDEField, true)) {
                pSDEField.reset();
                pSDEField.setPSDEId(pSSysBDTable.getPSDEId());
                pSDEField.setPSDEFieldName("CREATEDATE");
                pSDEFieldService.select(pSDEField, true);
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEField.getPSDEFieldId())) {
                pSSysBDColumn = new PSSysBDColumn();
                pSSysBDColumn.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
                pSSysBDColumn.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                pSSysBDColumn.setPSDEId(pSDEField.getPSDEId());
                pSSysBDColumn.setPSDEName(pSDEField.getPSDEName());
                pSSysBDColumn.setPSDEFId(pSDEField.getPSDEFieldId());
                pSSysBDColumn.setPSDEFName(pSDEField.getPSDEFieldName());
                pSSysBDColumn.setPSSysBDTableDEId(pSSysBDTableDE.getPSSysBDTableDEId());
                pSSysBDColumn.setPSSysBDColumnName("SRFCREATEDATE");
                pSSysBDColumn.setCodeName("CreateDate");
                pSSysBDColumn.setPSSysBDColSetId(pSSysBDColSet.getPSSysBDColSetId());
                pSSysBDColumn.setPSSysBDColSetName(pSSysBDColSet.getPSSysBDColSetName());
                pSSysBDColumnService.create(pSSysBDColumn, false);
            }
            pSSysBDColSet = new PSSysBDColSet();
            pSSysBDColSet.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
            pSSysBDColSet.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
            pSSysBDColSet.setPSSysBDColSetName("UPDATEINFO");
            pSSysBDColSet.setCodeName("UpdateInfo");
            pSSysBDColSet.setLogicName("\u66f4\u65b0\u4fe1\u606f");
            pSSysBDColSet.setDefaultFlag(0);
            pSSysBDColSetService.create(pSSysBDColSet);
            pSDEField = new PSDEField();
            pSDEField.setPSDEId(pSSysBDTable.getPSDEId());
            pSDEField.setPreDefineType("UPDATEDATE");
            if (!pSDEFieldService.select(pSDEField, true)) {
                pSDEField.reset();
                pSDEField.setPSDEId(pSSysBDTable.getPSDEId());
                pSDEField.setPSDEFieldName("UPDATEDATE");
                pSDEFieldService.select(pSDEField, true);
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEField.getPSDEFieldId())) {
                pSSysBDColumn = new PSSysBDColumn();
                pSSysBDColumn.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
                pSSysBDColumn.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                pSSysBDColumn.setPSDEId(pSDEField.getPSDEId());
                pSSysBDColumn.setPSDEName(pSDEField.getPSDEName());
                pSSysBDColumn.setPSDEFId(pSDEField.getPSDEFieldId());
                pSSysBDColumn.setPSDEFName(pSDEField.getPSDEFieldName());
                pSSysBDColumn.setPSSysBDTableDEId(pSSysBDTableDE.getPSSysBDTableDEId());
                pSSysBDColumn.setPSSysBDColumnName("SRFUPDATEDATE");
                pSSysBDColumn.setCodeName("UpdateDate");
                pSSysBDColumn.setPSSysBDColSetId(pSSysBDColSet.getPSSysBDColSetId());
                pSSysBDColumn.setPSSysBDColSetName(pSSysBDColSet.getPSSysBDColSetName());
                pSSysBDColumnService.create(pSSysBDColumn, false);
            }
        }
    }

    protected void createDefaultPSSysBDColSet(PSSysBDTable pSSysBDTable) throws Exception {
        PSSysBDColSetService pSSysBDColSetService = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
        PSSysBDColSet pSSysBDColSet = new PSSysBDColSet();
        pSSysBDTable.copyTo((IDataObject)pSSysBDColSet, true);
        pSSysBDColSet.setPSSysBDColSetId(pSSysBDTable.getPSSysBDTableId());
        if (pSSysBDColSetService.checkKey(pSSysBDColSet) == 1) {
            pSSysBDColSet.setPSSysBDColSetName("DEF");
            pSSysBDColSet.setCodeName("Def");
            pSSysBDColSet.setLogicName("\u9ed8\u8ba4\u5217\u65cf");
            pSSysBDColSet.setDefaultFlag(1);
            pSSysBDColSetService.update(pSSysBDColSet);
        } else {
            pSSysBDColSet.setPSSysBDColSetName("DEF");
            pSSysBDColSet.setCodeName("Def");
            pSSysBDColSet.setLogicName("\u9ed8\u8ba4\u5217\u65cf");
            pSSysBDColSet.setDefaultFlag(1);
            pSSysBDColSetService.create(pSSysBDColSet);
        }
    }

    protected void resetDefaultPSSysBDTableDE(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDTableDE> arrayList = pSSysBDTable.getPSSysBDTableDEs();
        PSSysBDTableDEService pSSysBDTableDEService = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysBDTableDE pSSysBDTableDE : arrayList) {
            if (pSSysBDTableDE.getDefaultFlag() == 0) continue;
            pSSysBDTableDE.setDefaultFlag(0);
            pSSysBDTableDEService.update(pSSysBDTableDE, false);
        }
    }

    protected void resetDefaultPSSysBDColSet(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDColSet> arrayList = pSSysBDTable.getPSSysBDColSets();
        PSSysBDColSetService pSSysBDColSetService = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysBDColSet pSSysBDColSet : arrayList) {
            if (pSSysBDColSet.getDefaultFlag() == 0) continue;
            pSSysBDColSet.setDefaultFlag(0);
            pSSysBDColSetService.update(pSSysBDColSet, false);
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    protected void onBeforeRemove(PSSysBDTable pSSysBDTable) throws Exception {
        this.resetDefaultPSSysBDTableDE(pSSysBDTable);
        this.resetDefaultPSSysBDColSet(pSSysBDTable);
        super.onBeforeRemove(pSSysBDTable);
    }

    @Override
    protected void onSyncDEFields(PSSysBDTable pSSysBDTable) throws Exception {
        if (!pSSysBDTable.isFullEntity()) {
            this.get((IEntity)pSSysBDTable);
        }
        ArrayList<PSSysBDTableDE> arrayList = pSSysBDTable.getPSSysBDTableDEs();
        for (PSSysBDTableDE pSSysBDTableDE : arrayList) {
            String[] stringArray;
            if (DataObject.getIntegerValue((Object)pSSysBDTableDE.getAddColMode(), (Integer)0) == 0) continue;
            boolean bl = true;
            if (DataObject.getIntegerValue((Object)pSSysBDTableDE.getAddColMode(), (Integer)0) == 2) {
                bl = false;
            }
            ArrayList<PSDEField> arrayList2 = pSSysBDTableDE.getPSDE().getPSDEFields();
            String string = pSSysBDTableDE.getColFilter();
            HashMap<String, String> hashMap = new HashMap<String, String>();
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string.replace("\r\n", ";");
                string = string.replace("\r", ";");
                string = string.replace("\n", ";");
                for (String string2 : stringArray = string.toUpperCase().split("[;]")) {
                    if (StringHelper.isNullOrEmpty((String)string2)) continue;
                    hashMap.put(string2.trim(), "");
                }
            }
            stringArray = (String[])ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
            for (PSDEField pSDEField : arrayList2) {
                if (bl ? hashMap.containsKey(pSDEField.getPSDEFieldName()) : !hashMap.containsKey(pSDEField.getPSDEFieldName())) continue;
                PSSysBDColumn pSSysBDColumn = new PSSysBDColumn();
                pSSysBDColumn.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
                pSSysBDColumn.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                pSSysBDColumn.setPSDEId(pSSysBDTableDE.getPSDE().getPSDataEntityId());
                pSSysBDColumn.setPSDEName(pSSysBDTableDE.getPSDE().getPSDataEntityName());
                pSSysBDColumn.setPSDEFId(pSDEField.getPSDEFieldId());
                pSSysBDColumn.setPSDEFName(pSDEField.getPSDEFieldName());
                pSSysBDColumn.setPSSysBDTableDEId(pSSysBDTableDE.getPSSysBDTableDEId());
                pSSysBDColumn.setPSSysBDColumnName(pSDEField.getPSDEFieldName());
                pSSysBDColumn.setCodeName(pSDEField.getCodeName());
                pSSysBDColumn.setPSSysBDColSetId(pSSysBDTableDE.getPSSysBDColSetId());
                pSSysBDColumn.setPSSysBDColSetName(pSSysBDTableDE.getPSSysBDColSetName());
                if (stringArray.checkKey(pSSysBDColumn) != 0) continue;
                stringArray.create(pSSysBDColumn, false);
            }
        }
    }
}

