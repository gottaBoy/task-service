/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.codelist.DEStorageTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDESARS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnSysAPIClientHelper2 {
    private static final Log log = LogFactory.getLog(PSDevSlnSysAPIClientHelper2.class);
    private SessionFactory srcSessionFactory = null;
    private PSSysServiceAPI srcPSSysServiceAPI = new PSSysServiceAPI();
    private PSDevSlnSysAPI psDevSlnSysAPI = null;
    private SessionFactory dstSessionFactory = null;
    private PSDevSlnSys dstPSDevSlnSys;
    private PSDevSlnSys srcPSDevSlnSys;
    private Map<String, PSDataEntity> srcPSDataEntityMap = new HashMap<String, PSDataEntity>();
    private Map<String, PSDEField> srcPSDEFieldMap = new HashMap<String, PSDEField>();
    private Map<String, PSDataEntity> dstPSDataEntityMap = new HashMap<String, PSDataEntity>();
    private Map<String, PSDEField> dstPSDEFieldMap = new HashMap<String, PSDEField>();
    private Map<String, PSModule> srcPSModuleMap = new HashMap<String, PSModule>();
    private Map<String, PSModule> dstPSModuleMap = new HashMap<String, PSModule>();
    private Map<String, PSCodeList> srcPSCodeListMap = new HashMap<String, PSCodeList>();
    private Map<String, PSCodeList> dstPSCodeListMap = new HashMap<String, PSCodeList>();
    private Map<String, PSDEServiceAPI> srcPSDEServiceAPIMap = new HashMap<String, PSDEServiceAPI>();
    private Map<String, PSDEServiceAPI> dstPSDEServiceAPIMap = new HashMap<String, PSDEServiceAPI>();
    private Map<String, PSDER> srcPSDERMap = new HashMap<String, PSDER>();
    private Map<String, PSDER> dstPSDERMap = new HashMap<String, PSDER>();
    private Map<String, PSDEAction> psDEActionMap = new HashMap<String, PSDEAction>();
    private Map<String, PSDEDataSet> psDEDataSetMap = new HashMap<String, PSDEDataSet>();
    private Map<String, PSDEFGroup> psDEFGroupMap = new HashMap<String, PSDEFGroup>();
    private Map<String, PSDEField> psDEFieldMap = new HashMap<String, PSDEField>();
    private Map<String, PSDEFGroup> srcPSDEFGroupMap = new HashMap<String, PSDEFGroup>();
    private Map<String, PSDESARS> srcPSDESARSMap = new HashMap<String, PSDESARS>();
    private Map<String, PSDESARS> dstPSDESARSMap = new HashMap<String, PSDESARS>();
    private String strSrcPSSysModelInstId = null;
    private String strDstPSSysModelInstId = null;
    private PSSubSysServiceAPI dstPSSubSysServiceAPI = null;
    private PSSysServiceAPI dstPSSysServiceAPI = null;

    public void init(PSDevSlnSysAPI pSDevSlnSysAPI, PSDevSlnSys pSDevSlnSys) throws Exception {
        this.psDevSlnSysAPI = pSDevSlnSysAPI;
        this.strSrcPSSysModelInstId = pSDevSlnSysAPI.getPSDevSlnSys().getPSSysModelInstId();
        this.strDstPSSysModelInstId = pSDevSlnSys.getPSSysModelInstId();
        this.srcSessionFactory = PSSysModelInstGlobal.getSessionFactory(pSDevSlnSysAPI.getPSDevSlnSys().getPSSysModelInstId());
        PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.srcSessionFactory);
        this.srcPSSysServiceAPI.setPSSysServiceAPIId(pSDevSlnSysAPI.getPSSysServiceAPIId());
        pSSysServiceAPIService.get((IEntity)this.srcPSSysServiceAPI);
        this.srcPSDevSlnSys = pSDevSlnSysAPI.getPSDevSlnSys();
        this.dstPSDevSlnSys = pSDevSlnSys;
        this.dstSessionFactory = PSSysModelInstGlobal.getSessionFactory(pSDevSlnSys.getPSSysModelInstId());
    }

    public void sync() throws Exception {
        EntityBase entityBase;
        Serializable serializable;
        Serializable serializable222;
        Object object422;
        Object object522;
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.dstSessionFactory);
        PSSysServiceAPI pSSysServiceAPI = new PSSysServiceAPI();
        pSSysServiceAPI.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
        pSSysServiceAPI.setCodeName(this.srcPSSysServiceAPI.getCodeName());
        if (!pSSysServiceAPIService.select(pSSysServiceAPI, true)) {
            try {
                pSSysServiceAPI.setPSSysServiceAPIName(this.srcPSSysServiceAPI.getPSSysServiceAPIName());
                pSSysServiceAPI.setCodeName(this.srcPSSysServiceAPI.getCodeName());
                pSSysServiceAPI.setServiceCodeName(this.srcPSSysServiceAPI.getServiceCodeName());
                pSSysServiceAPI.setAPIType(this.srcPSSysServiceAPI.getAPIType());
                pSSysServiceAPI.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
                pSSysServiceAPI.setPSSystemName(this.dstPSDevSlnSys.getPSDevSlnSysName());
                pSSysServiceAPI.setVer(this.srcPSSysServiceAPI.getVer());
                pSSysServiceAPIService.create(pSSysServiceAPI);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        this.dstPSSysServiceAPI = pSSysServiceAPI;
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.dstSessionFactory);
        PSSubSysServiceAPI pSSubSysServiceAPI = new PSSubSysServiceAPI();
        pSSubSysServiceAPI.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
        pSSubSysServiceAPI.setCodeName(this.srcPSSysServiceAPI.getCodeName());
        if (!pSSubSysServiceAPIService.select(pSSubSysServiceAPI, true)) {
            try {
                pSSubSysServiceAPI.setPSSubSysServiceAPIName(this.srcPSSysServiceAPI.getPSSysServiceAPIName());
                pSSubSysServiceAPI.setCodeName(this.srcPSSysServiceAPI.getCodeName());
                pSSubSysServiceAPI.setServiceCodeName(this.srcPSSysServiceAPI.getServiceCodeName());
                pSSubSysServiceAPI.setAPISource("SYSAPI");
                pSSubSysServiceAPI.setPSSysServiceAPIId(this.dstPSSysServiceAPI.getPSSysServiceAPIId());
                pSSubSysServiceAPI.setPSSysServiceAPIName(this.dstPSSysServiceAPI.getPSSysServiceAPIName());
                pSSubSysServiceAPI.setAPIType(this.srcPSSysServiceAPI.getAPIType());
                pSSubSysServiceAPI.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
                pSSubSysServiceAPI.setPSSystemName(this.dstPSDevSlnSys.getPSDevSlnSysName());
                pSSubSysServiceAPI.setVer(this.srcPSSysServiceAPI.getVer());
                pSSubSysServiceAPIService.create(pSSubSysServiceAPI);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        this.dstPSSubSysServiceAPI = pSSubSysServiceAPI;
        PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.srcSessionFactory);
        PSModuleService pSModuleService2 = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.dstSessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.reset();
        selectCond.set("PSSYSTEMID", (Object)this.srcPSDevSlnSys.getPSSystemId());
        PSSysModelInstGlobal.getSessionFactory(this.srcPSDevSlnSys.getPSSysModelInstId());
        ArrayList arrayList = pSModuleService.select((ISelectCond)selectCond);
        for (Object object522 : arrayList) {
            this.srcPSModuleMap.put(((PSModuleBase)object522).getPSModuleId(), (PSModule)object522);
        }
        selectCond.reset();
        selectCond.set("PSSYSTEMID", (Object)this.dstPSDevSlnSys.getPSSystemId());
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        arrayList = pSModuleService2.select((ISelectCond)selectCond);
        for (Object object522 : arrayList) {
            this.dstPSModuleMap.put(((PSModuleBase)object522).getCodeName(), (PSModule)object522);
        }
        PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.srcSessionFactory);
        object522 = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.dstSessionFactory);
        selectCond.reset();
        selectCond.set("PSSYSTEMID", (Object)this.srcPSDevSlnSys.getPSSystemId());
        PSSysModelInstGlobal.getSessionFactory(this.srcPSDevSlnSys.getPSSysModelInstId());
        ArrayList arrayList2 = pSCodeListService.select((ISelectCond)selectCond);
        for (Object object422 : arrayList2) {
            this.srcPSCodeListMap.put(((PSCodeListBase)object422).getPSCodeListId(), (PSCodeList)object422);
        }
        selectCond.reset();
        selectCond.set("PSSYSTEMID", (Object)this.dstPSDevSlnSys.getPSSystemId());
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        arrayList2 = object522.select((ISelectCond)selectCond);
        for (Object object422 : arrayList2) {
            this.dstPSCodeListMap.put(((PSCodeListBase)object422).getCodeName(), (PSCodeList)object422);
        }
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.srcSessionFactory);
        object422 = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.dstSessionFactory);
        selectCond.reset();
        selectCond.set("PSSYSTEMID", (Object)this.srcPSDevSlnSys.getPSSystemId());
        PSSysModelInstGlobal.getSessionFactory(this.srcPSDevSlnSys.getPSSysModelInstId());
        ArrayList arrayList3 = pSDataEntityService.select((ISelectCond)selectCond);
        for (Serializable serializable222 : arrayList3) {
            this.srcPSDataEntityMap.put(((PSDataEntityBase)serializable222).getPSDataEntityId(), (PSDataEntity)serializable222);
        }
        selectCond.reset();
        selectCond.set("PSSYSTEMID", (Object)this.dstPSDevSlnSys.getPSSystemId());
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        arrayList3 = object422.select((ISelectCond)selectCond);
        for (Serializable serializable222 : arrayList3) {
            this.dstPSDataEntityMap.put(((PSDataEntityBase)serializable222).getPSDataEntityName(), (PSDataEntity)serializable222);
        }
        HashMap hashMap = new HashMap();
        PSSysModelInstGlobal.getSessionFactory(this.srcPSDevSlnSys.getPSSysModelInstId());
        serializable222 = this.srcPSSysServiceAPI.getPSDEServiceAPIs();
        Object object6 = ((ArrayList)serializable222).iterator();
        while (object6.hasNext()) {
            PSDEServiceAPI object32 = (PSDEServiceAPI)object6.next();
            this.srcPSDEServiceAPIMap.put(object32.getPSDEServiceAPIName(), object32);
            serializable = this.srcPSDataEntityMap.get(object32.getPSDEId());
            if (serializable == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6e90\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%1$s]\u76f8\u5173\u5b9e\u4f53", (Object)object32.getPSDEServiceAPIName()));
            }
            hashMap.put(((PSDataEntityBase)serializable).getPSDataEntityId(), serializable);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            serializable = this.dstPSDataEntityMap.get(((PSDataEntity)entry.getValue()).getPSDataEntityName());
            if (serializable != null) continue;
            serializable = this.getDstPSDataEntity((PSDataEntity)entry.getValue());
        }
        object6 = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.srcSessionFactory);
        PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.dstSessionFactory);
        selectCond.reset();
        selectCond.set("PSSYSTEMID", (Object)this.srcPSDevSlnSys.getPSSystemId());
        PSSysModelInstGlobal.getSessionFactory(this.srcPSDevSlnSys.getPSSysModelInstId());
        serializable = object6.select((ISelectCond)selectCond);
        ArrayList<PSDESARS> arrayList4 = ((ArrayList)serializable).iterator();
        while (arrayList4.hasNext()) {
            PSDER pSDER = (PSDER)arrayList4.next();
            if (!this.srcPSDataEntityMap.containsKey(pSDER.getMajorPSDEId()) || !this.srcPSDataEntityMap.containsKey(pSDER.getMinorPSDEId())) continue;
            this.srcPSDERMap.put(pSDER.getPSDERId(), pSDER);
        }
        selectCond.reset();
        selectCond.set("PSSYSTEMID", (Object)this.dstPSDevSlnSys.getPSSystemId());
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        serializable = pSDERService.select((ISelectCond)selectCond);
        arrayList4 = ((ArrayList)serializable).iterator();
        while (arrayList4.hasNext()) {
            PSDER pSDER = (PSDER)arrayList4.next();
            this.dstPSDERMap.put(pSDER.getPSDERName(), pSDER);
        }
        for (Map.Entry entry : this.srcPSDERMap.entrySet()) {
            PSDER pSDER = this.dstPSDERMap.get(((PSDER)entry.getValue()).getPSDERName());
            if (pSDER != null) continue;
            entityBase = this.dstPSDataEntityMap.get(((PSDER)entry.getValue()).getMajorPSDEName());
            PSDataEntity pSDataEntity = this.dstPSDataEntityMap.get(((PSDER)entry.getValue()).getMinorPSDEName());
            if (entityBase == null || pSDataEntity == null) continue;
            PSDER pSDER2 = this.getDstPSDER((PSDER)entry.getValue());
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            PSDataEntity pSDataEntity = this.dstPSDataEntityMap.get(((PSDataEntity)entry.getValue()).getPSDataEntityName());
            this.syncPSDataEntity((PSDataEntity)entry.getValue(), pSDataEntity);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            PSDataEntity pSDataEntity = this.dstPSDataEntityMap.get(((PSDataEntity)entry.getValue()).getPSDataEntityName());
            this.syncPSDataEntity2((PSDataEntity)entry.getValue(), pSDataEntity);
        }
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        serializable222 = this.dstPSSysServiceAPI.getPSDEServiceAPIs();
        arrayList4 = ((ArrayList)serializable222).iterator();
        while (arrayList4.hasNext()) {
            PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)arrayList4.next();
            this.dstPSDEServiceAPIMap.put(pSDEServiceAPI.getPSDEServiceAPIName(), pSDEServiceAPI);
        }
        for (Map.Entry entry : this.srcPSDEServiceAPIMap.entrySet()) {
            PSDEServiceAPI pSDEServiceAPI = this.dstPSDEServiceAPIMap.get(entry.getKey());
            if (pSDEServiceAPI != null) continue;
            PSDEServiceAPI pSDEServiceAPI2 = this.getDstPSDEServiceAPI((PSDEServiceAPI)entry.getValue());
        }
        PSSysModelInstGlobal.getSessionFactory(this.srcPSDevSlnSys.getPSSysModelInstId());
        arrayList4 = this.srcPSSysServiceAPI.getPSDESARSes();
        for (PSDESARS pSDESARS : arrayList4) {
            this.srcPSDESARSMap.put(pSDESARS.getPSDESARSName(), pSDESARS);
        }
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        arrayList4 = this.dstPSSysServiceAPI.getPSDESARSes();
        for (PSDESARS pSDESARS : arrayList4) {
            this.dstPSDESARSMap.put(pSDESARS.getPSDESARSName(), pSDESARS);
        }
        for (Map.Entry<String, PSDESARS> entry : this.srcPSDESARSMap.entrySet()) {
            entityBase = this.dstPSDESARSMap.get(entry.getKey());
            if (entityBase != null) continue;
            entityBase = this.getDstPSDESARS(entry.getValue());
        }
        for (Map.Entry<String, PSDEServiceAPI> entry : this.srcPSDEServiceAPIMap.entrySet()) {
            entityBase = this.dstPSDEServiceAPIMap.get(entry.getKey());
            this.syncPSDEServiceAPI(entry.getValue(), (PSDEServiceAPI)entityBase);
        }
    }

    protected PSModule getDstPSModule(PSModule pSModule) throws Exception {
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.dstSessionFactory);
        PSModule pSModule2 = this.dstPSModuleMap.get(pSModule.getCodeName());
        if (pSModule2 == null) {
            try {
                pSModule2 = new PSModule();
                pSModule2.setPSModuleName(pSModule.getPSModuleName());
                pSModule2.setCodeName(pSModule.getCodeName());
                pSModule2.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
                pSModule2.setPSSystemName(this.dstPSDevSlnSys.getPSDevSlnSysName());
                pSModuleService.create(pSModule2);
                this.dstPSModuleMap.put(pSModule2.getCodeName(), pSModule2);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u7cfb\u7edf\u6a21\u5757\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u7cfb\u7edf\u6a21\u5757\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        return pSModule2;
    }

    protected PSDataEntity getDstPSDataEntity(PSDataEntity pSDataEntity) throws Exception {
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.dstSessionFactory);
        PSDataEntity pSDataEntity2 = this.dstPSDataEntityMap.get(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity2 == null) {
            try {
                pSDataEntity2 = new PSDataEntity();
                pSDataEntity2.setPSDataEntityName(pSDataEntity.getPSDataEntityName());
                pSDataEntity2.setCodeName(pSDataEntity.getCodeName());
                pSDataEntity2.setLogicName(pSDataEntity.getLogicName());
                pSDataEntity2.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
                pSDataEntity2.setPSSystemName(this.dstPSDevSlnSys.getPSDevSlnSysName());
                PSModule pSModule = this.getDstPSModule(this.srcPSModuleMap.get(pSDataEntity.getPSModuleId()));
                pSDataEntity2.setPSModuleId(pSModule.getPSModuleId());
                pSDataEntity2.setPSModuleName(pSModule.getPSModuleName());
                pSDataEntity2.setStorageMode(DEStorageTypeCodeListModel.SERVICEAPI);
                pSDataEntity2.setPSSubSysServiceAPIId(this.dstPSSubSysServiceAPI.getPSSubSysServiceAPIId());
                pSDataEntity2.setPSSubSysServiceAPIName(this.dstPSSubSysServiceAPI.getPSSubSysServiceAPIName());
                pSDataEntityService.create(pSDataEntity2);
                this.dstPSDataEntityMap.put(pSDataEntity2.getPSDataEntityName(), pSDataEntity2);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u7cfb\u7edf\u5b9e\u4f53[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDataEntity.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u7cfb\u7edf\u5b9e\u4f53[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDataEntity.getCodeName(), (Object)exception.getMessage()), exception);
            }
        }
        return pSDataEntity2;
    }

    protected PSDEServiceAPI getDstPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.dstSessionFactory);
        PSDEServiceAPI pSDEServiceAPI2 = this.dstPSDEServiceAPIMap.get(pSDEServiceAPI.getPSDEServiceAPIName());
        if (pSDEServiceAPI2 == null) {
            try {
                EntityBase entityBase;
                pSDEServiceAPI2 = new PSDEServiceAPI();
                pSDEServiceAPI2.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
                pSDEServiceAPI2.setCodeName(pSDEServiceAPI.getCodeName());
                pSDEServiceAPI2.setPSSysServiceAPIId(this.dstPSSysServiceAPI.getPSSysServiceAPIId());
                pSDEServiceAPI2.setPSSysServiceAPIName(this.dstPSSysServiceAPI.getPSSysServiceAPIName());
                pSDEServiceAPI2.setMajorFlag(pSDEServiceAPI.getMajorFlag());
                pSDEServiceAPI2.setValidFlag(pSDEServiceAPI.getValidFlag());
                pSDEServiceAPI2.setDEFGroupMode(pSDEServiceAPI.getDEFGroupMode());
                if (!StringHelper.isNullOrEmpty((String)pSDEServiceAPI.getPSDEFGroupId()) && (entityBase = this.psDEFGroupMap.get(pSDEServiceAPI.getPSDEFGroupId())) != null) {
                    pSDEServiceAPI2.setPSDEFGroupId(entityBase.getPSDEFGroupId());
                    pSDEServiceAPI2.setPSDEFGroupName(entityBase.getPSDEFGroupName());
                }
                pSDEServiceAPI2.setEnableDEAction(pSDEServiceAPI.getEnableDEAction());
                pSDEServiceAPI2.setEnableDEDataSet(pSDEServiceAPI.getEnableDEDataSet());
                pSDEServiceAPI2.setEnableSelect(pSDEServiceAPI.getEnableSelect());
                pSDEServiceAPI2.setAccCtrlArch(pSDEServiceAPI.getAccCtrlArch());
                pSDEServiceAPI2.setDataAccMode(pSDEServiceAPI.getDataAccMode());
                pSDEServiceAPI2.setEnaTempData(pSDEServiceAPI.getEnaTempData());
                entityBase = this.getDstPSDataEntity(this.srcPSDataEntityMap.get(pSDEServiceAPI.getPSDEId()));
                pSDEServiceAPI2.setPSDEId(entityBase.getPSDataEntityId());
                pSDEServiceAPI2.setPSDEName(entityBase.getPSDataEntityName());
                pSDEServiceAPIService.create(pSDEServiceAPI2);
                this.dstPSDEServiceAPIMap.put(pSDEServiceAPI2.getPSDEServiceAPIName(), pSDEServiceAPI2);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEServiceAPI.getPSDEServiceAPIName(), (Object)pSDEServiceAPI.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEServiceAPI.getPSDEServiceAPIName(), (Object)pSDEServiceAPI.getCodeName(), (Object)exception.getMessage()), exception);
            }
        }
        return pSDEServiceAPI2;
    }

    protected PSDESARS getDstPSDESARS(PSDESARS pSDESARS) throws Exception {
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSDESARSService pSDESARSService = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.dstSessionFactory);
        PSDESARS pSDESARS2 = this.dstPSDESARSMap.get(pSDESARS.getPSDESARSName());
        if (pSDESARS2 == null) {
            try {
                pSDESARS2 = new PSDESARS();
                pSDESARS2.setPSDESARSName(pSDESARS.getPSDESARSName());
                pSDESARS2.setCodeName(pSDESARS.getCodeName());
                pSDESARS2.setCodeName2(pSDESARS.getCodeName2());
                pSDESARS2.setPSSysServiceAPIId(this.dstPSSysServiceAPI.getPSSysServiceAPIId());
                pSDESARS2.setPSSysServiceAPIName(this.dstPSSysServiceAPI.getPSSysServiceAPIName());
                PSDEServiceAPI pSDEServiceAPI = this.dstPSDEServiceAPIMap.get(pSDESARS.getPPSDEServiceAPIName());
                PSDEServiceAPI pSDEServiceAPI2 = this.dstPSDEServiceAPIMap.get(pSDESARS.getCPSDEServiceAPIName());
                if (pSDEServiceAPI == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u4e3b\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%1$s]", (Object)pSDESARS.getPPSDEServiceAPIName()));
                }
                if (pSDEServiceAPI2 == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u4e3b\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%1$s]", (Object)pSDESARS.getCPSDEServiceAPIName()));
                }
                pSDESARS2.setPPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                pSDESARS2.setPPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
                pSDESARS2.setCPSDEServiceAPIId(pSDEServiceAPI2.getPSDEServiceAPIId());
                pSDESARS2.setCPSDEServiceAPIName(pSDEServiceAPI2.getPSDEServiceAPIName());
                pSDESARS2.setValidFlag(pSDESARS.getValidFlag());
                pSDESARS2.setEnableDEAction(pSDESARS.getEnableDEAction());
                pSDESARS2.setEnableDEDataSet(pSDESARS.getEnableDEDataSet());
                pSDESARS2.setEnableSelect(pSDESARS.getEnableSelect());
                pSDESARS2.setDataAccMode(pSDESARS.getDataAccMode());
                pSDESARS2.setDataRSMode(pSDESARS.getDataRSMode());
                pSDESARS2.setActionRSMode(pSDESARS.getActionRSMode());
                pSDESARS2.setChildFilter(pSDESARS.getChildFilter());
                pSDESARS2.setOrderValue(pSDESARS.getOrderValue());
                PSDER pSDER = this.srcPSDERMap.get(pSDESARS.getPSDERId());
                if (pSDER != null) {
                    pSDER = this.dstPSDERMap.get(pSDER.getPSDERName());
                }
                if (pSDER != null) {
                    pSDESARS2.setPSDERId(pSDER.getPSDERId());
                    pSDESARS2.setPSDERName(pSDER.getPSDERName());
                }
                pSDESARSService.create(pSDESARS2);
                this.dstPSDESARSMap.put(pSDESARS2.getPSDESARSName(), pSDESARS2);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5173\u7cfb[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDESARS.getPSDESARSName(), (Object)pSDESARS.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5173\u7cfb[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDESARS.getPSDESARSName(), (Object)pSDESARS.getCodeName(), (Object)exception.getMessage()), exception);
            }
        }
        return pSDESARS2;
    }

    protected PSDER getDstPSDER(PSDER pSDER) throws Exception {
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.dstSessionFactory);
        PSDER pSDER2 = this.dstPSDERMap.get(pSDER.getPSDERName());
        if (pSDER2 == null) {
            try {
                pSDER2 = new PSDER();
                pSDER2.setPSDERName(pSDER.getPSDERName());
                pSDER2.setCodeName(pSDER.getCodeName());
                pSDER2.setMinorCodeName(pSDER.getMinorCodeName());
                pSDER2.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
                pSDER2.setPSSystemName(this.dstPSDevSlnSys.getPSDevSlnSysName());
                pSDER2.setDERType(pSDER.getDERType());
                pSDER2.setDERFieldName(pSDER.getDERFieldName());
                PSDataEntity pSDataEntity = this.getDstPSDataEntity(this.srcPSDataEntityMap.get(pSDER.getMajorPSDEId()));
                PSDataEntity pSDataEntity2 = this.getDstPSDataEntity(this.srcPSDataEntityMap.get(pSDER.getMinorPSDEId()));
                pSDER2.setValidFlag(pSDER.getValidFlag());
                pSDER2.setMajorPSDEId(pSDataEntity.getPSDataEntityId());
                pSDER2.setMajorPSDEName(pSDataEntity.getPSDataEntityName());
                pSDER2.setMinorPSDEId(pSDataEntity2.getPSDataEntityId());
                pSDER2.setMinorPSDEName(pSDataEntity2.getPSDataEntityName());
                pSDER2.setRemoveActionType(pSDER.getRemoveActionType());
                pSDER2.setEnaDEFieldWriteBack(pSDER.getEnaDEFieldWriteBack());
                pSDERService.create(pSDER2);
                this.dstPSDERMap.put(pSDER2.getPSDERName(), pSDER2);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u5173\u7cfb[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDER.getPSDERName(), (Object)pSDER.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u5173\u7cfb[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDER.getPSDERName(), (Object)pSDER.getCodeName(), (Object)exception.getMessage()), exception);
            }
        }
        return pSDER2;
    }

    protected void syncPSDataEntity(PSDataEntity pSDataEntity, PSDataEntity pSDataEntity2) throws Exception {
        try {
            Serializable serializable;
            this.activeSessionFactory();
            PSSysModelInstGlobal.getSessionFactory(this.srcPSDevSlnSys.getPSSysModelInstId());
            ArrayList<PSDEAction> arrayList = pSDataEntity.getPSDEActions();
            ArrayList<PSDEDataSet> arrayList2 = pSDataEntity.getPSDEDataSets();
            ArrayList<PSDEField> arrayList3 = pSDataEntity.getPSDEFields();
            PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
            ArrayList<PSDEAction> arrayList4 = pSDataEntity2.getPSDEActions();
            HashMap<String, PSDEAction> hashMap = new HashMap<String, PSDEAction>();
            for (PSDEAction serializable32 : arrayList4) {
                hashMap.put(serializable32.getPSDEActionName(), serializable32);
            }
            for (PSDEAction pSDEAction : arrayList) {
                serializable = (PSDEAction)hashMap.get(pSDEAction.getPSDEActionName());
                if (serializable == null) {
                    serializable = this.getDstPSDEAction(pSDataEntity2, pSDEAction);
                }
                this.psDEActionMap.put(pSDEAction.getPSDEActionId(), (PSDEAction)serializable);
            }
            ArrayList<PSDEDataSet> arrayList5 = pSDataEntity2.getPSDEDataSets();
            HashMap<String, PSDEDataSet> hashMap2 = new HashMap<String, PSDEDataSet>();
            serializable = arrayList5.iterator();
            while (serializable.hasNext()) {
                PSDEDataSet pSDEDataSet = (PSDEDataSet)serializable.next();
                hashMap2.put(pSDEDataSet.getPSDEDataSetName(), pSDEDataSet);
            }
            for (PSDEDataSet pSDEDataSet : arrayList2) {
                Object object = (PSDEDataSet)hashMap2.get(pSDEDataSet.getPSDEDataSetName());
                if (object == null) {
                    object = this.getDstPSDEDataSet(pSDataEntity2, pSDEDataSet);
                }
                this.psDEDataSetMap.put(pSDEDataSet.getPSDEDataSetId(), (PSDEDataSet)object);
            }
            serializable = pSDataEntity2.getPSDEFields();
            HashMap<String, PSDEField> hashMap3 = new HashMap<String, PSDEField>();
            for (PSDEField pSDEField : serializable) {
                hashMap3.put(pSDEField.getPSDEFieldName(), pSDEField);
            }
            for (PSDEField pSDEField : arrayList3) {
                this.srcPSDEFieldMap.put(pSDEField.getPSDEFieldId(), pSDEField);
                if (!StringHelper.isNullOrEmpty((String)pSDEField.getPSDERId()) || !StringHelper.isNullOrEmpty((String)pSDEField.getO2MPSDERId())) continue;
                PSDEField pSDEField2 = (PSDEField)hashMap3.get(pSDEField.getPSDEFieldName());
                if (pSDEField2 == null) {
                    pSDEField2 = this.getDstPSDEField(pSDataEntity2, pSDEField);
                }
                this.psDEFieldMap.put(pSDEField.getPSDEFieldId(), pSDEField2);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u7cfb\u7edf\u5b9e\u4f53[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity2.getPSDataEntityName(), (Object)pSDataEntity2.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u7cfb\u7edf\u5b9e\u4f53[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity2.getPSDataEntityName(), (Object)pSDataEntity2.getCodeName(), (Object)exception.getMessage()), exception);
        }
    }

    protected void syncPSDataEntity2(PSDataEntity pSDataEntity, PSDataEntity pSDataEntity2) throws Exception {
        try {
            Object object;
            this.activeSessionFactory();
            PSSysModelInstGlobal.getSessionFactory(this.srcPSDevSlnSys.getPSSysModelInstId());
            ArrayList<PSDEFGroup> arrayList = pSDataEntity.getPSDEFGroups();
            ArrayList<PSDEField> arrayList2 = pSDataEntity.getPSDEFields();
            PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
            ArrayList<PSDEField> arrayList3 = pSDataEntity2.getPSDEFields();
            HashMap<String, PSDEField> hashMap = new HashMap<String, PSDEField>();
            for (PSDEField serializable2 : arrayList3) {
                hashMap.put(serializable2.getPSDEFieldName(), serializable2);
            }
            for (PSDEField pSDEField : arrayList2) {
                this.srcPSDEFieldMap.put(pSDEField.getPSDEFieldId(), pSDEField);
                if (StringHelper.isNullOrEmpty((String)pSDEField.getPSDERId()) && StringHelper.isNullOrEmpty((String)pSDEField.getO2MPSDERId())) continue;
                object = (PSDEField)hashMap.get(pSDEField.getPSDEFieldName());
                if (object == null) {
                    object = this.getDstPSDEField(pSDataEntity2, pSDEField);
                }
                this.psDEFieldMap.put(pSDEField.getPSDEFieldId(), (PSDEField)object);
            }
            ArrayList<PSDEFGroup> arrayList4 = pSDataEntity2.getPSDEFGroups();
            HashMap<String, PSDEFGroup> hashMap2 = new HashMap<String, PSDEFGroup>();
            object = arrayList4.iterator();
            while (object.hasNext()) {
                PSDEFGroup pSDEFGroup = (PSDEFGroup)object.next();
                hashMap2.put(pSDEFGroup.getCodeName(), pSDEFGroup);
            }
            for (PSDEFGroup pSDEFGroup : arrayList) {
                this.srcPSDEFGroupMap.put(pSDEFGroup.getPSDEFGroupId(), pSDEFGroup);
                PSDEFGroup pSDEFGroup2 = (PSDEFGroup)hashMap2.get(pSDEFGroup.getCodeName());
                if (pSDEFGroup2 == null) {
                    pSDEFGroup2 = this.getDstPSDEFGroup(pSDataEntity2, pSDEFGroup);
                }
                this.psDEFGroupMap.put(pSDEFGroup.getPSDEFGroupId(), pSDEFGroup2);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u7cfb\u7edf\u5b9e\u4f53[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity2.getPSDataEntityName(), (Object)pSDataEntity2.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u7cfb\u7edf\u5b9e\u4f53[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity2.getPSDataEntityName(), (Object)pSDataEntity2.getCodeName(), (Object)exception.getMessage()), exception);
        }
    }

    protected PSDEAction getDstPSDEAction(PSDataEntity pSDataEntity, PSDEAction pSDEAction) throws Exception {
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.dstSessionFactory);
        PSDEAction pSDEAction2 = new PSDEAction();
        try {
            pSDEAction2.setPSDEActionName(pSDEAction.getPSDEActionName());
            pSDEAction2.setCodeName(pSDEAction.getCodeName());
            pSDEAction2.setLogicName(pSDEAction.getLogicName());
            pSDEAction2.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEAction2.setPSDEName(pSDataEntity.getPSDataEntityName());
            pSDEAction2.setActionType("BUILTIN");
            pSDEAction2.setPubMode(pSDEAction.getPubMode());
            pSDEAction2.setRequestField(pSDEAction.getRequestField());
            pSDEAction2.setRequestMethod(pSDEAction.getRequestMethod());
            pSDEAction2.setRequestParamType(pSDEAction.getRequestParamType());
            pSDEAction2.setRequestPath(pSDEAction.getRequestPath());
            pSDEActionService.create(pSDEAction2);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u884c\u4e3a[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEAction.getPSDEActionName(), (Object)pSDEAction.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u884c\u4e3a[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEAction.getPSDEActionName(), (Object)pSDEAction.getCodeName(), (Object)exception.getMessage()), exception);
        }
        return pSDEAction2;
    }

    protected PSDEDataSet getDstPSDEDataSet(PSDataEntity pSDataEntity, PSDEDataSet pSDEDataSet) throws Exception {
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.dstSessionFactory);
        PSDEDataSet pSDEDataSet2 = new PSDEDataSet();
        try {
            pSDEDataSet2.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
            pSDEDataSet2.setCodeName(pSDEDataSet.getCodeName());
            pSDEDataSet2.setLogicName(pSDEDataSet.getLogicName());
            pSDEDataSet2.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEDataSet2.setPSDEName(pSDataEntity.getPSDataEntityName());
            pSDEDataSet2.setPubMode(pSDEDataSet.getPubMode());
            pSDEDataSet2.setRequestMethod(pSDEDataSet.getRequestMethod());
            pSDEDataSet2.setRequestPath(pSDEDataSet.getRequestPath());
            pSDEDataSetService.create(pSDEDataSet2);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u6570\u636e\u96c6[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEDataSet.getPSDEDataSetName(), (Object)pSDEDataSet.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u6570\u636e\u96c6[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEDataSet.getPSDEDataSetName(), (Object)pSDEDataSet.getCodeName(), (Object)exception.getMessage()), exception);
        }
        return pSDEDataSet2;
    }

    protected PSDEFGroup getDstPSDEFGroup(PSDataEntity pSDataEntity, PSDEFGroup pSDEFGroup) throws Exception {
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.dstSessionFactory);
        PSDEFGroup pSDEFGroup2 = new PSDEFGroup();
        try {
            pSDEFGroup2.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
            pSDEFGroup2.setCodeName(pSDEFGroup.getCodeName());
            pSDEFGroup2.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEFGroup2.setPSDEName(pSDataEntity.getPSDataEntityName());
            pSDEFGroup2.setValidFlag(pSDEFGroup.getValidFlag());
            pSDEFGroup2.setOrderValue(pSDEFGroup.getOrderValue());
            pSDEFGroup2.setGroupType(pSDEFGroup.getGroupType());
            pSDEFGroupService.create(pSDEFGroup2);
            PSSysModelInstGlobal.getSessionFactory(this.srcPSDevSlnSys.getPSSysModelInstId());
            ArrayList<PSDEFGroupDetail> arrayList = pSDEFGroup.getPSDEFGroupDetails();
            PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
            PSDEFGroupDetailService pSDEFGroupDetailService = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.dstSessionFactory);
            for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
                PSDEField pSDEField = this.psDEFieldMap.get(pSDEFGroupDetail.getPSDEFId());
                if (pSDEField == null) continue;
                PSDEFGroupDetail pSDEFGroupDetail2 = new PSDEFGroupDetail();
                pSDEFGroupDetail2.setPSDEFGroupDetailName(pSDEFGroupDetail.getPSDEFGroupDetailName());
                pSDEFGroupDetail2.setPSDEFGroupId(pSDEFGroup2.getPSDEFGroupId());
                pSDEFGroupDetail2.setPSDEFGroupName(pSDEFGroup2.getPSDEFGroupName());
                pSDEFGroupDetail2.setCodeName(pSDEFGroupDetail.getCodeName());
                pSDEFGroupDetail2.setOrderValue(pSDEFGroupDetail.getOrderValue());
                pSDEFGroupDetail2.setValidFlag(pSDEFGroupDetail.getValidFlag());
                pSDEFGroupDetail2.setPSDEFId(pSDEField.getPSDEFieldId());
                pSDEFGroupDetail2.setPSDEFName(pSDEField.getPSDEFieldName());
                if (!StringHelper.isNullOrEmpty((String)pSDEFGroupDetail.getPSCodeListId())) {
                    PSCodeList pSCodeList = this.getDstPSCodeList(this.srcPSCodeListMap.get(pSDEFGroupDetail.getPSCodeListId()));
                    pSDEFGroupDetail2.setPSCodeListId(pSCodeList.getPSCodeListId());
                    pSDEFGroupDetail2.setPSCodeListName(pSCodeList.getPSCodeListName());
                }
                pSDEFGroupDetail2.setCodeName2(pSDEFGroupDetail.getCodeName2());
                pSDEFGroupDetail2.setModifyUserInput(pSDEFGroupDetail.getModifyUserInput());
                pSDEFGroupDetail2.setStrLength(pSDEFGroupDetail.getStrLength());
                pSDEFGroupDetail2.setAllowEmpty(pSDEFGroupDetail.getAllowEmpty());
                pSDEFGroupDetailService.create(pSDEFGroupDetail2);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u5c5e\u6027\u7ec4[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEFGroup.getPSDEFGroupName(), (Object)pSDEFGroup.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u5c5e\u6027\u7ec4[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEFGroup.getPSDEFGroupName(), (Object)pSDEFGroup.getCodeName(), (Object)exception.getMessage()), exception);
        }
        return pSDEFGroup2;
    }

    protected PSDEField getDstPSDEField(PSDataEntity pSDataEntity, PSDEField pSDEField) throws Exception {
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.dstSessionFactory);
        PSDEField pSDEField2 = new PSDEField();
        try {
            EntityBase entityBase;
            pSDEField2.setPSDEFieldName(pSDEField.getPSDEFieldName());
            pSDEField2.setCodeName(pSDEField.getCodeName());
            pSDEField2.setLogicName(pSDEField.getLogicName());
            pSDEField2.setPKey(pSDEField.getPKey());
            pSDEField2.setMajorField(pSDEField.getMajorField());
            pSDEField2.setAllowEmpty(pSDEField.getAllowEmpty());
            pSDEField2.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEField2.setPSDEName(pSDataEntity.getPSDataEntityName());
            pSDEField2.setDEFType(pSDEField.getDEFType());
            pSDEField2.setPSDataTypeId(pSDEField.getPSDataTypeId());
            pSDEField2.setPSDataTypeName(pSDEField.getPSDataTypeName());
            pSDEField2.setLength(pSDEField.getLength());
            pSDEField2.setPrecision2(pSDEField.getPrecision2());
            pSDEField2.setPreDefineType(pSDEField.getPreDefineType());
            pSDEField2.setDefaultValueType(pSDEField.getDefaultValueType());
            pSDEField2.setDefaultValue(pSDEField.getDefaultValue());
            pSDEField2.setMaxValue(pSDEField.getMaxValue());
            pSDEField2.setMinValue(pSDEField.getMinValue());
            pSDEField2.setStrLength(pSDEField.getStrLength());
            pSDEField2.setPreDefineType(pSDEField.getPreDefineType());
            pSDEField2.setBizTag(pSDEField.getBizTag());
            pSDEField2.setEnaWriteBack(pSDEField.getEnaWriteBack());
            pSDEField2.setEnableUserInput(pSDEField.getEnableUserInput());
            pSDEField2.setEnableColPriv(pSDEField.getEnableColPriv());
            pSDEField2.setOrderValue(pSDEField.getOrderValue());
            if (!StringHelper.isNullOrEmpty((String)pSDEField.getPSCodeListId())) {
                entityBase = this.getDstPSCodeList(this.srcPSCodeListMap.get(pSDEField.getPSCodeListId()));
                pSDEField2.setPSCodeListId(entityBase.getPSCodeListId());
                pSDEField2.setPSCodeListName(entityBase.getPSCodeListName());
            }
            if (pSDEField2.getDEFType() == 2) {
                pSDEField2.setDEFType(5);
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEField.getPSDERId())) {
                entityBase = this.srcPSDERMap.get(pSDEField.getPSDERId());
                if (entityBase != null) {
                    entityBase = this.dstPSDERMap.get(entityBase.getPSDERName());
                }
                PSDEField pSDEField3 = this.psDEFieldMap.get(pSDEField.getDERPSDEFId());
                if (entityBase != null && pSDEField3 != null) {
                    pSDEField2.setPSDERId(entityBase.getPSDERId());
                    pSDEField2.setPSDERName(entityBase.getPSDERName());
                    pSDEField2.setDERPSDEFId(pSDEField3.getPSDEFieldId());
                    pSDEField2.setDERPSDEFName(pSDEField3.getPSDEFieldName());
                } else {
                    pSDEField2.setPSDERId(null);
                    pSDEField2.setPSDERName(null);
                    pSDEField2.setDERPSDEFId(null);
                    pSDEField2.setDERPSDEFName(null);
                    pSDEField2.setPSDataTypeId("TEXT");
                    pSDEField2.setPSDataTypeName("\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6");
                    if (pSDEField2.getDEFType() == 3) {
                        pSDEField2.setDEFType(5);
                    }
                }
            } else if (!StringHelper.isNullOrEmpty((String)pSDEField.getO2MPSDERId())) {
                entityBase = this.srcPSDERMap.get(pSDEField.getO2MPSDERId());
                if (entityBase != null) {
                    entityBase = this.dstPSDERMap.get(entityBase.getPSDERName());
                }
                if (entityBase != null) {
                    pSDEField2.setO2MPSDERId(entityBase.getPSDERId());
                    pSDEField2.setO2MPSDERName(entityBase.getPSDERName());
                } else {
                    pSDEField2.setO2MPSDERId(null);
                    pSDEField2.setO2MPSDERName(null);
                    pSDEField2.setPSDataTypeId("LONGTEXT");
                    pSDEField2.setPSDataTypeName("\u957f\u6587\u672c\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236");
                }
            }
            pSDEFieldService.create(pSDEField2);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u5c5e\u6027[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEField.getPSDEFieldName(), (Object)pSDEField.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u5c5e\u6027[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEField.getPSDEFieldName(), (Object)pSDEField.getCodeName(), (Object)exception.getMessage()), exception);
        }
        return pSDEField2;
    }

    protected PSCodeList getDstPSCodeList(PSCodeList pSCodeList) throws Exception {
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.dstSessionFactory);
        PSCodeList pSCodeList2 = this.dstPSCodeListMap.get(pSCodeList.getCodeName());
        if (pSCodeList2 == null) {
            try {
                Object object;
                Serializable serializable;
                pSCodeList2 = new PSCodeList();
                pSCodeList2.setPSCodeListName(pSCodeList.getPSCodeListName());
                pSCodeList2.setCodeName(pSCodeList.getCodeName());
                pSCodeList2.setCLType(pSCodeList.getCLType());
                pSCodeList2.setNumberItem(pSCodeList.getNumberItem());
                pSCodeList2.setCLModel(pSCodeList.getCLModel());
                pSCodeList2.setCodeListSN(pSCodeList.getCodeListSN());
                pSCodeList2.setEmptyText(pSCodeList.getEmptyText());
                pSCodeList2.setNoValueEmpty(pSCodeList.getNoValueEmpty());
                pSCodeList2.setOrMode(pSCodeList.getOrMode());
                pSCodeList2.setPredefinedType(pSCodeList.getPredefinedType());
                pSCodeList2.setSeperator(pSCodeList.getSeperator());
                pSCodeList2.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
                pSCodeList2.setPSSystemName(this.dstPSDevSlnSys.getPSDevSlnSysName());
                if (!StringHelper.isNullOrEmpty((String)pSCodeList.getPSModuleId())) {
                    serializable = this.getDstPSModule(this.srcPSModuleMap.get(pSCodeList.getPSModuleId()));
                    pSCodeList2.setPSModuleId(((PSModuleBase)serializable).getPSModuleId());
                    pSCodeList2.setPSModuleName(((PSModuleBase)serializable).getPSModuleName());
                }
                if (!StringHelper.isNullOrEmpty((String)pSCodeList.getPSDEName())) {
                    serializable = this.dstPSDataEntityMap.get(pSCodeList.getPSDEName());
                    if (serializable != null) {
                        pSCodeList2.setPSDEId(((PSDataEntityBase)serializable).getPSDataEntityId());
                        pSCodeList2.setPSDEName(((PSDataEntityBase)serializable).getPSDataEntityName());
                    }
                    if (!StringHelper.isNullOrEmpty((String)pSCodeList.getPSDEDSId()) && (object = this.psDEDataSetMap.get(pSCodeList.getPSDEDSId())) != null) {
                        pSCodeList2.setPSDEDSId(((PSDEDataSetBase)object).getPSDEDataSetId());
                        pSCodeList2.setPSDEDSName(((PSDEDataSetBase)object).getPSDEDataSetName());
                    }
                }
                pSCodeListService.create(pSCodeList2);
                this.dstPSCodeListMap.put(pSCodeList2.getCodeName(), pSCodeList2);
                PSSysModelInstGlobal.getSessionFactory(this.srcPSDevSlnSys.getPSSysModelInstId());
                serializable = pSCodeList.getPSCodeItems();
                PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
                object = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.dstSessionFactory);
                Iterator iterator = ((ArrayList)serializable).iterator();
                while (iterator.hasNext()) {
                    PSCodeItem pSCodeItem = (PSCodeItem)iterator.next();
                    PSCodeItem pSCodeItem2 = new PSCodeItem();
                    pSCodeItem2.setPSCodeItemName(pSCodeItem.getPSCodeItemName());
                    pSCodeItem2.setPSCodeListId(pSCodeList2.getPSCodeListId());
                    pSCodeItem2.setPSCodeListName(pSCodeList2.getPSCodeListName());
                    pSCodeItem2.setCodeItemValue(pSCodeItem.getCodeItemValue());
                    pSCodeItem2.setCodeName(pSCodeItem.getCodeName());
                    pSCodeItem2.setOrderValue(pSCodeItem.getOrderValue());
                    pSCodeItem2.setData(pSCodeItem.getData());
                    pSCodeItem2.setDefaultFlag(pSCodeItem.getDefaultFlag());
                    pSCodeItem2.setValidFlag(pSCodeItem.getValidFlag());
                    pSCodeItem2.setDisableSelect(pSCodeItem.getDisableSelect());
                    pSCodeItem2.setColor(pSCodeItem.getColor());
                    ((PSCoreSysServiceBaseBase)((Object)object)).create(pSCodeItem2);
                }
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u7cfb\u7edf\u4ee3\u7801\u8868[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSCodeList.getPSCodeListName(), (Object)pSCodeList.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u7cfb\u7edf\u4ee3\u7801\u8868[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSCodeList.getPSCodeListName(), (Object)pSCodeList.getCodeName(), (Object)exception.getMessage()), exception);
            }
        }
        return pSCodeList2;
    }

    protected void syncPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, PSDEServiceAPI pSDEServiceAPI2) throws Exception {
        try {
            String string;
            this.activeSessionFactory();
            PSSysModelInstGlobal.getSessionFactory(this.srcPSDevSlnSys.getPSSysModelInstId());
            ArrayList<PSDESADetail> arrayList = pSDEServiceAPI.getPSDESADetails();
            PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
            ArrayList<PSDESADetail> arrayList2 = pSDEServiceAPI2.getPSDESADetails();
            HashMap<String, PSDESADetail> hashMap = new HashMap<String, PSDESADetail>();
            for (PSDESADetail pSDESADetail : arrayList2) {
                string = "";
                string = StringHelper.isNullOrEmpty((String)pSDESADetail.getPSDESARSName()) ? pSDESADetail.getMethodTag() : StringHelper.format((String)"%1$s#%2$s", (Object)pSDESADetail.getPSDESARSName(), (Object)pSDESADetail.getMethodTag());
                hashMap.put(string, pSDESADetail);
            }
            for (PSDESADetail pSDESADetail : arrayList) {
                string = "";
                string = StringHelper.isNullOrEmpty((String)pSDESADetail.getPSDESARSName()) ? pSDESADetail.getMethodTag() : StringHelper.format((String)"%1$s#%2$s", (Object)pSDESADetail.getPSDESARSName(), (Object)pSDESADetail.getMethodTag());
                PSDESADetail pSDESADetail2 = (PSDESADetail)hashMap.get(string);
                if (pSDESADetail2 != null) continue;
                pSDESADetail2 = this.getDstPSDESADetail(pSDEServiceAPI2, pSDESADetail);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEServiceAPI2.getPSDEServiceAPIName(), (Object)pSDEServiceAPI2.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEServiceAPI2.getPSDEServiceAPIName(), (Object)pSDEServiceAPI2.getCodeName(), (Object)exception.getMessage()), exception);
        }
    }

    protected PSDESADetail getDstPSDESADetail(PSDEServiceAPI pSDEServiceAPI, PSDESADetail pSDESADetail) throws Exception {
        this.activeSessionFactory();
        PSSysModelInstGlobal.getSessionFactory(this.dstPSDevSlnSys.getPSSysModelInstId());
        PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.dstSessionFactory);
        PSDESADetail pSDESADetail2 = new PSDESADetail();
        try {
            EntityBase entityBase;
            pSDESADetail2.setPSDESADetailName(pSDESADetail.getPSDESADetailName());
            pSDESADetail2.setCodeName(pSDESADetail.getCodeName());
            pSDESADetail2.setCodeName2(pSDESADetail.getCodeName2());
            pSDESADetail2.setDetailParam(pSDESADetail.getDetailParam());
            pSDESADetail2.setDetailParam2(pSDESADetail.getDetailParam2());
            pSDESADetail2.setCodeName(pSDESADetail.getCodeName());
            pSDESADetail2.setDetailType(pSDESADetail.getDetailType());
            pSDESADetail2.setMethodTag(pSDESADetail.getMethodTag());
            pSDESADetail2.setOrderValue(pSDESADetail.getOrderValue());
            pSDESADetail2.setParentKeyMode(pSDESADetail.getParentKeyMode());
            if (!StringHelper.isNullOrEmpty((String)pSDESADetail.getPSDESARSName())) {
                entityBase = this.dstPSDESARSMap.get(pSDESADetail.getPSDESARSName());
                if (entityBase == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5173\u7cfb[%1$s]", (Object)pSDESADetail.getPSDESARSName()));
                }
                pSDESADetail2.setPSDESARSId(entityBase.getPSDESARSId());
                pSDESADetail2.setPSDESARSName(entityBase.getPSDESARSName());
            }
            if (!StringHelper.isNullOrEmpty((String)pSDESADetail.getPSDEActionName())) {
                entityBase = this.psDEActionMap.get(pSDESADetail.getPSDEActionId());
                if (entityBase == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a[%1$s]", (Object)pSDESADetail.getPSDEActionName()));
                }
                pSDESADetail2.setPSDEActionId(entityBase.getPSDEActionId());
                pSDESADetail2.setPSDEActionName(entityBase.getPSDEActionName());
            }
            if (!StringHelper.isNullOrEmpty((String)pSDESADetail.getPSDEDSName())) {
                entityBase = this.psDEDataSetMap.get(pSDESADetail.getPSDEDSId());
                if (entityBase == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u96c6[%1$s]", (Object)pSDESADetail.getPSDEDSName()));
                }
                pSDESADetail2.setPSDEDSId(entityBase.getPSDEDataSetId());
                pSDESADetail2.setPSDEDSName(entityBase.getPSDEDataSetName());
            }
            pSDESADetail2.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDESADetail2.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
            pSDESADetail2.setRequestField(pSDESADetail.getRequestField());
            pSDESADetail2.setRequestMethod(pSDESADetail.getRequestMethod());
            pSDESADetail2.setRequestParamType(pSDESADetail.getRequestParamType());
            pSDESADetail2.setRetValType(pSDESADetail.getRetValType());
            pSDESADetailService.create(pSDESADetail2);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6210\u5458[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDESADetail.getPSDESADetailName(), (Object)pSDESADetail.getCodeName(), (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5ba2\u6237\u7aef\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6210\u5458[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDESADetail.getPSDESADetailName(), (Object)pSDESADetail.getCodeName(), (Object)exception.getMessage()), exception);
        }
        return pSDESADetail2;
    }

    protected String getSrcPSysModelInstId() {
        return this.strSrcPSSysModelInstId;
    }

    protected String getDstPSysModelInstId() {
        return this.strDstPSSysModelInstId;
    }

    protected void activeSessionFactory() {
        PSSysModelInstGlobal.active(this.getSrcPSysModelInstId());
        PSSysModelInstGlobal.active(this.getDstPSysModelInstId());
    }
}

