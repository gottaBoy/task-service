/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.bdscheme.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDModule;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDModuleServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService;
import net.ibizsys.pscore.srv.codelist.DEStorageTypeCodeListModel;
import net.ibizsys.pscore.srv.codelist.SysBDModuleDEImpModeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysBDModuleService
extends PSSysBDModuleServiceBase {
    private static final Log log = LogFactory.getLog(PSSysBDModuleService.class);

    @Override
    protected void onInitBDTables(PSSysBDModule pSSysBDModule) throws Exception {
        this.get(pSSysBDModule);
        if (StringHelper.isNullOrEmpty((String)pSSysBDModule.getPSModuleId())) {
            return;
        }
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("STORAGEMODE", (Object)DEStorageTypeCodeListModel.NOSQL);
        selectCond.set("PSMODULEID", (Object)pSSysBDModule.getPSModuleId());
        ArrayList<PSDataEntity> dataEntities = pSDataEntityService.select((ISelectCond)selectCond);
        if (dataEntities.size() == 0) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (!StringHelper.isNullOrEmpty(pSSysBDModule.getDENames())) {
            Properties names = PropertiesHelper.load(pSSysBDModule.getDENames().replace(";", "\r\n"));
            Enumeration<?> keys = names.keys();
            while (keys.hasMoreElements()) {
                hashMap.put((String)keys.nextElement(), "");
            }
        }
        boolean bl = pSSysBDModule.getImpDEMode() == SysBDModuleDEImpModeCodeListModel.EXCLUDE;
        for (PSDataEntity entity : dataEntities) {
            if (bl ? hashMap.containsKey(entity.getPSDataEntityName()) : !hashMap.containsKey(entity.getPSDataEntityName())) continue;
            this.initPSSysBDTable(entity, pSSysBDModule);
        }
    }

    protected void initPSSysBDTable(PSDataEntity pSDataEntity, PSSysBDModule pSSysBDModule) throws Exception {
        PSSysBDTableService pSSysBDTableService = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
        PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        PSSysBDColumnService pSSysBDColumnService = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        PSSysBDTable pSSysBDTable = new PSSysBDTable();
        pSSysBDTable.setPSSysBDTableName(pSDataEntity.getPSDataEntityName());
        pSSysBDTable.setPSSysBDSchemeId(pSSysBDModule.getPSSysBDSchemeId());
        if (!pSSysBDTableService.select(pSSysBDTable, true)) {
            pSSysBDTable.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSSysBDTable.setPSDEName(pSDataEntity.getPSDataEntityName());
            pSSysBDTable.setPSSysBDModuleId(pSSysBDModule.getPSSysBDModuleId());
            pSSysBDTable.setPSSysBDModuleName(pSSysBDModule.getPSSysBDModuleName());
            pSSysBDTable.setPSSysBDSchemeName(pSSysBDModule.getPSSysBDSchemeName());
            pSSysBDTable.setValidFlag(1);
            pSSysBDTable.setLogicName(pSDataEntity.getLogicName());
            pSSysBDTable.setCodeName(pSDataEntity.getCodeName());
            if (StringHelper.isNullOrEmpty((String)pSDataEntity.getIndexDEType())) {
                PSDER relation = new PSDER();
                relation.setDERType("DERINHERIT");
                relation.setMinorPSDEId(pSDataEntity.getPSDataEntityId());
                if (pSDERService.select(relation, true)) {
                    pSSysBDTable.setBDTableType(9);
                    pSSysBDTable.setInheritPSDEId(relation.getMajorPSDEId());
                    pSSysBDTable.setInheritPSDEName(relation.getMajorPSDEName());
                    pSSysBDTable.setTypeValue(relation.getIndexValue());
                } else {
                    pSSysBDTable.setBDTableType(1);
                }
            } else {
                pSSysBDTable.setBDTableType(1);
            }
            pSSysBDTableService.create(pSSysBDTable);
        }
        SelectCond relationCond = new SelectCond();
        relationCond.set("MAJORPSDEID", pSDataEntity.getPSDataEntityId());
        relationCond.set("DERTYPE", "DER1N");
        ArrayList<PSDER> relations = pSDERService.select((ISelectCond)relationCond);
        for (PSDER pSDER : relations) {
            PSSysBDTable pSSysBDTable2;
            if (StringHelper.isNullOrEmpty((String)pSDER.getMinorCodeName())) continue;
            PSSysBDTable pSSysBDTable3 = new PSSysBDTable();
            pSSysBDTable3.setPSSysBDSchemeId(pSSysBDModule.getPSSysBDSchemeId());
            pSSysBDTable3.setPSDEId(pSDER.getMajorPSDEId());
            pSSysBDTable3.setMinorPSDEId(pSDER.getMinorPSDEId());
            pSSysBDTable3.setPickupDEFName(pSDER.getDERFieldName());
            if (pSSysBDTableService.select(pSSysBDTable3, true)) continue;
            String string = "";
            int n = 0;
            do {
                string = StringHelper.format("BDRS%1$04d", ++n);
                pSSysBDTable2 = new PSSysBDTable();
                pSSysBDTable2.setPSSysBDSchemeId(pSSysBDModule.getPSSysBDSchemeId());
                pSSysBDTable2.setPSSysBDTableName(string);
            } while (pSSysBDTableService.checkKey(pSSysBDTable2) != 0);
            pSSysBDTable3.setPSSysBDModuleId(pSSysBDModule.getPSSysBDModuleId());
            pSSysBDTable3.setPSSysBDModuleName(pSSysBDModule.getPSSysBDModuleName());
            pSSysBDTable3.setPSSysBDTableName(string);
            pSSysBDTable3.setBDTableType(3);
            pSSysBDTable3.setPSDEName(pSDER.getMajorPSDEName());
            pSSysBDTable3.setMinorPSDEName(pSDER.getMinorPSDEName());
            pSSysBDTable3.setPSSysBDSchemeName(pSSysBDModule.getPSSysBDSchemeName());
            pSSysBDTable3.setValidFlag(1);
            pSSysBDTable3.setLogicName(StringHelper.format((String)"%1$s-%2$s[%3$s]", (Object)pSDER.getMajorPSDE().getLogicName(), (Object)pSDER.getMinorPSDE().getLogicName(), (Object)pSDER.getDERFieldName()));
            pSSysBDTable3.setCodeName(string);
            pSSysBDTable3.setUserTag(pSDER.getPSDERId());
            pSSysBDTableService.create(pSSysBDTable3);
        }
    }
}
