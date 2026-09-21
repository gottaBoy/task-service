/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.freemarker.DataContextMethod
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.freemarker.DataContextMethod;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDEInitCfgServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEInitCfgService
extends PSDEInitCfgServiceBase {
    private static final Log log = LogFactory.getLog(PSDEInitCfgService.class);

    @Override
    protected void onInitList(PSDEInitCfg pSDEInitCfg) throws Exception {
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        Object object = DataContextMethod.getValue((String)"pssystemid", (SessionFactory)this.getSessionFactory());
        if (object != null) {
            selectCond.set("PSSYSTEMID", object);
        }
        ArrayList arrayList = pSDataEntityService.select((ISelectCond)selectCond);
        ArrayList arrayList2 = this.select((ISelectCond)selectCond);
        HashMap<String, PSDEInitCfg> hashMap = new HashMap<String, PSDEInitCfg>();
        for (EntityBase entityBase : arrayList2) {
            hashMap.put(entityBase.getPSDEInitCfgId(), (PSDEInitCfg)entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            PSDEInitCfg pSDEInitCfg2 = (PSDEInitCfg)hashMap.remove(entityBase.getPSDataEntityId());
            if (pSDEInitCfg2 != null) continue;
            pSDEInitCfg2 = new PSDEInitCfg();
            pSDEInitCfg2.setPSDEInitCfgId(entityBase.getPSDataEntityId());
            pSDEInitCfg2.setPSDEInitCfgName(entityBase.getPSDataEntityName());
            pSDEInitCfg2.setPSSystemId(entityBase.getPSSystemId());
            pSDEInitCfg2.setMemo(entityBase.getLogicName());
            this.create(pSDEInitCfg2, false);
        }
        for (EntityBase entityBase : hashMap.values()) {
            this.remove((IEntity)entityBase);
        }
    }

    @Override
    protected void onInitList2(PSDEInitCfg pSDEInitCfg) throws Exception {
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        Object object = DataContextMethod.getValue((String)"pssystemid", (SessionFactory)this.getSessionFactory());
        if (object != null) {
            selectCond.set("PSSYSTEMID", object);
        }
        ArrayList arrayList = pSDataEntityService.select((ISelectCond)selectCond);
        ArrayList arrayList2 = this.select((ISelectCond)selectCond);
        HashMap<String, PSDEInitCfg> hashMap = new HashMap<String, PSDEInitCfg>();
        for (EntityBase entityBase : arrayList2) {
            hashMap.put(entityBase.getPSDEInitCfgId(), (PSDEInitCfg)entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            PSDEInitCfg pSDEInitCfg2 = (PSDEInitCfg)hashMap.remove(entityBase.getPSDataEntityId());
            if (pSDEInitCfg2 != null) continue;
            pSDEInitCfg2 = new PSDEInitCfg();
            pSDEInitCfg2.setPSDEInitCfgId(entityBase.getPSDataEntityId());
            pSDEInitCfg2.setPSDEInitCfgName(entityBase.getPSDataEntityName());
            pSDEInitCfg2.setPSSystemId(entityBase.getPSSystemId());
            pSDEInitCfg2.setIgnoreDBModel(1);
            pSDEInitCfg2.setIgnoreExtModel(1);
            pSDEInitCfg2.setIgnoreMgrModel(1);
            pSDEInitCfg2.setIgnoreUIModel(1);
            pSDEInitCfg2.setMemo(entityBase.getLogicName());
            this.create(pSDEInitCfg2, false);
        }
        for (EntityBase entityBase : hashMap.values()) {
            this.remove((IEntity)entityBase);
        }
    }
}

