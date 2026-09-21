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
import java.util.HashMap;
import java.util.Properties;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
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
        String string;
        Object object;
        Object object22;
        this.get((IEntity)pSSysBDModule);
        if (StringHelper.isNullOrEmpty((String)pSSysBDModule.getPSModuleId())) {
            return;
        }
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("STORAGEMODE", (Object)DEStorageTypeCodeListModel.NOSQL);
        selectCond.set("PSMODULEID", (Object)pSSysBDModule.getPSModuleId());
        ArrayList arrayList = pSDataEntityService.select((ISelectCond)selectCond);
        if (arrayList.size() == 0) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (!StringHelper.isNullOrEmpty((String)pSSysBDModule.getDENames()) && (object22 = ((Properties)(object = PropertiesHelper.load((String)(string = pSSysBDModule.getDENames().replace(";", "\r\n"))))).keys()) != null) {
            while (object22.hasMoreElements()) {
                hashMap.put((String)object22.nextElement(), "");
            }
        }
        boolean bl = pSSysBDModule.getImpDEMode() == SysBDModuleDEImpModeCodeListModel.EXCLUDE;
        for (Object object22 : arrayList) {
            if (bl ? hashMap.containsKey(((PSDataEntityBase)object22).getPSDataEntityName()) : !hashMap.containsKey(((PSDataEntityBase)object22).getPSDataEntityName())) continue;
            this.initPSSysBDTable((PSDataEntity)object22, pSSysBDModule);
        }
    }

    protected void initPSSysBDTable(PSDataEntity pSDataEntity, PSSysBDModule pSSysBDModule) throws Exception {
        Object object;
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
                object = new PSDER();
                ((PSDERBase)object).setDERType("DERINHERIT");
                ((PSDERBase)object).setMinorPSDEId(pSDataEntity.getPSDataEntityId());
                if (pSDERService.select(object, true)) {
                    pSSysBDTable.setBDTableType(9);
                    pSSysBDTable.setInheritPSDEId(((PSDERBase)object).getMajorPSDEId());
                    pSSysBDTable.setInheritPSDEName(((PSDERBase)object).getMajorPSDEName());
                    pSSysBDTable.setTypeValue(((PSDERBase)object).getIndexValue());
                } else {
                    pSSysBDTable.setBDTableType(1);
                }
            } else {
                pSSysBDTable.setBDTableType(1);
            }
            pSSysBDTableService.create(pSSysBDTable);
        }
        pSSysBDTable = new SelectCond();
        pSSysBDTable.set("MAJORPSDEID", pSDataEntity.getPSDataEntityId());
        pSSysBDTable.set("DERTYPE", "DER1N");
        object = "BDRS%1$04d";
        ArrayList arrayList = pSDERService.select((ISelectCond)pSSysBDTable);
        for (PSDER pSDER : arrayList) {
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
                string = StringHelper.format((String)object, (Object)(++n));
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

