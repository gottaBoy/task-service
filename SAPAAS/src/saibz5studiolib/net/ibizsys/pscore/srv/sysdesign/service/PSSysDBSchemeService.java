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
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETable;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDETableService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysDBSchemeService
extends PSSysDBSchemeServiceBase {
    private static final Log log = LogFactory.getLog(PSSysDBSchemeService.class);

    @Override
    protected void onRebuildScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        this.get(pSSysDBScheme);
        boolean bl = true;
        PSSystem pSSystem = new PSSystem();
        pSSystem.setPSSystemId(pSSysDBScheme.getPSSystemId());
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        PSSysDBTableService pSSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, (SessionFactory)this.getSessionFactory());
        PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSModule> arrayList = pSModuleService.selectByPSSystem(pSSystem);
        for (PSModule pSModule : arrayList) {
            if (DataObject.getBoolValue((Integer)pSModule.getSubSysModule(), (boolean)false)) continue;
            ArrayList<PSDataEntity> arrayList2 = pSDataEntityService.selectByPSModule(pSModule);
            for (PSDataEntity pSDataEntity : arrayList2) {
                String string;
                String string2 = pSDataEntity.getDSLink();
                if (StringHelper.isNullOrEmpty((String)string2)) {
                    string2 = "DEFAULT";
                }
                if (StringHelper.compare((String)string2, (String)pSSysDBScheme.getDSLink(), (boolean)false) != 0 || pSDataEntity.getStorageMode() != null && pSDataEntity.getStorageMode() != 1 || StringHelper.isNullOrEmpty((String)(string = pSDataEntity.getTableName()))) continue;
                PSSysDBTable pSSysDBTable = new PSSysDBTable();
                pSSysDBTable.setPSSysDBSchemeId(pSSysDBScheme.getPSSysDBSchemeId());
                if (bl) {
                    pSSysDBTable.setPSSysDBTableName(string.toUpperCase());
                } else {
                    pSSysDBTable.setPSSysDBTableName(string);
                }
                pSSysDBTableService.fillEntityKeyValue(pSSysDBTable);
                pSSysDBTable.setLogicName(pSDataEntity.getLogicName());
                if (pSSysDBTableService.checkKey(pSSysDBTable) == 0) {
                    pSSysDBTable.setTableType("TABLE");
                    pSSysDBTable.setCodeName(string);
                    pSSysDBTable.setPSSystemId(pSSysDBScheme.getPSSystemId());
                    pSSysDBTable.setPSSystemName(pSSysDBScheme.getPSSystemName());
                    pSSysDBTableService.create(pSSysDBTable);
                } else {
                    pSSysDBTableService.get(pSSysDBTable);
                }
                this.rebuildPSDETable(pSSysDBTable, pSDataEntity, "MAIN", bl);
                this.rebuildPSSysDBColumns(pSSysDBTable, pSDataEntity, "MAIN", bl);
            }
        }
    }

    protected void rebuildPSDETable(PSSysDBTable pSSysDBTable, PSDataEntity pSDataEntity, String string, boolean bl) throws Exception {
        PSDETableService pSDETableService = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, (SessionFactory)this.getSessionFactory());
        PSDETable pSDETable = new PSDETable();
        pSDETable.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
        pSDETable.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDETable.setTableType(string);
        pSDETableService.fillEntityKeyValue(pSDETable);
        if (pSDETableService.checkKey(pSDETable) == 0) {
            pSDETable.setPSDEName(pSDataEntity.getPSDataEntityName());
            pSDETable.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
            pSDETable.setPSDETableName(StringHelper.format((String)"%1$s-%2$s", (Object)pSSysDBTable.getPSSysDBTableName(), (Object)pSDataEntity.getPSDataEntityName()));
            pSDETableService.create(pSDETable);
        }
        boolean bl2 = StringHelper.compare((String)string, (String)"MAIN", (boolean)true) == 0;
        ArrayList<PSDEField> arrayList = pSDataEntity.getPSDEFields();
        for (PSDEField pSDEField : arrayList) {
            if (bl2 && DataObject.getIntegerValue((Object)pSDEField.getDEFType(), (Integer)0) == 1) continue;
        }
    }

    protected void rebuildPSSysDBColumns(PSSysDBTable pSSysDBTable, PSDataEntity pSDataEntity, String string, boolean bl) throws Exception {
        PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
        boolean bl2 = StringHelper.compare((String)string, (String)"MAIN", (boolean)true) == 0;
        ArrayList<PSDEField> arrayList = pSDataEntity.getPSDEFields();
        for (PSDEField pSDEField : arrayList) {
            if (bl2 && DataObject.getIntegerValue((Object)pSDEField.getDEFType(), (Integer)0) != 1) continue;
            PSSysDBColumn pSSysDBColumn = new PSSysDBColumn();
            pSSysDBColumn.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
            pSSysDBColumn.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
            if (bl) {
                pSSysDBColumn.setPSSysDBColumnName(pSDEField.getPSDEFieldName().toUpperCase());
            } else {
                pSSysDBColumn.setPSSysDBColumnName(pSDEField.getPSDEFieldName());
            }
            pSSysDBColumnService.fillEntityKeyValue(pSSysDBColumn);
            if (pSSysDBColumnService.checkKey(pSSysDBColumn) != 0) continue;
            pSSysDBColumn.setCodeName(pSDEField.getCodeName());
            if (StringHelper.isNullOrEmpty((String)pSSysDBColumn.getCodeName())) {
                pSSysDBColumn.setCodeName(pSSysDBColumn.getPSSysDBColumnName());
            }
            if (DataObject.getBoolValue((Integer)pSDEField.getPKey(), (boolean)false)) {
                pSSysDBColumn.setPKey(1);
            }
            pSSysDBColumnService.create(pSSysDBColumn);
        }
    }
}

