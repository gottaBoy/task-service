/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public class PSDevSlnSysAPIClientHelper {
    private SessionFactory srcSessionFactory = null;
    private PSSysServiceAPI srcPSSysServiceAPI = new PSSysServiceAPI();
    private PSDevSlnSysAPI psDevSlnSysAPI = null;
    private SessionFactory dstSessionFactory = null;
    private PSDevSlnSys dstPSDevSlnSys;
    private Map<String, PSDataEntity> dstPSDataEntityMap = new HashMap<String, PSDataEntity>();
    private Map<String, PSDataEntity> srcPSDataEntityMap = new HashMap<String, PSDataEntity>();
    private Map<String, PSDEField> srcPSDEFieldMap = new HashMap<String, PSDEField>();
    private Map<String, PSDEField> dstPSDEFieldMap = new HashMap<String, PSDEField>();
    private Map<String, PSDER> srcPSDERMap = new HashMap<String, PSDER>();
    private Map<String, PSDER> dstPSDERMap = new HashMap<String, PSDER>();

    public void init(PSDevSlnSysAPI pSDevSlnSysAPI, PSDevSlnSys pSDevSlnSys) throws Exception {
        this.psDevSlnSysAPI = pSDevSlnSysAPI;
        this.srcSessionFactory = PSSysModelInstGlobal.getSessionFactory(pSDevSlnSysAPI.getPSDevSlnSys().getPSSysModelInstId());
        PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.srcSessionFactory);
        this.srcPSSysServiceAPI.setPSSysServiceAPIId(pSDevSlnSysAPI.getPSSysServiceAPIId());
        pSSysServiceAPIService.get((IEntity)this.srcPSSysServiceAPI);
        this.dstPSDevSlnSys = pSDevSlnSys;
        this.dstSessionFactory = PSSysModelInstGlobal.getSessionFactory(pSDevSlnSys.getPSSysModelInstId());
    }

    public void sync() throws Exception {
        PSDataEntity pSDataEntity;
        Object object2;
        Object object3;
        PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.dstSessionFactory);
        PSModule pSModule = new PSModule();
        pSModule.setPSModuleId(this.psDevSlnSysAPI.getPSDevSlnSysAPIId());
        if (!pSModuleService.get((IEntity)pSModule, true)) {
            object3 = StringHelper.format((String)"%1$s%2$s", (Object)this.srcPSSysServiceAPI.getServiceCodeName(), (Object)"Client");
            pSModule.setPSModuleName((String)object3);
            pSModule.setCodeName((String)object3);
            pSModule.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
            pSModule.setPSSystemName(this.dstPSDevSlnSys.getPSDevSlnSysName());
            pSModuleService.create(pSModule);
        }
        object3 = (PSSysModelGroupService)ServiceGlobal.getService(PSSysModelGroupService.class, (SessionFactory)this.dstSessionFactory);
        PSSysModelGroup pSSysModelGroup = new PSSysModelGroup();
        pSSysModelGroup.setPSSysModelGroupId(this.psDevSlnSysAPI.getPSDevSlnSysAPIId());
        if (!object3.get((IEntity)pSSysModelGroup, true)) {
            object2 = StringHelper.format((String)"%1$s%2$s", (Object)this.srcPSSysServiceAPI.getServiceCodeName(), (Object)"Client");
            pSSysModelGroup.setPSSysModelGroupName((String)object2);
            pSSysModelGroup.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
            pSSysModelGroup.setPSSystemName(this.dstPSDevSlnSys.getPSDevSlnSysName());
            ((PSCoreSysServiceBaseBase)((Object)object3)).create(pSSysModelGroup);
        }
        object2 = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.dstSessionFactory);
        PSSubSysServiceAPI pSSubSysServiceAPI = new PSSubSysServiceAPI();
        pSSubSysServiceAPI.setPSSubSysServiceAPIId(this.psDevSlnSysAPI.getPSSysServiceAPIId());
        if (!object2.get((IEntity)pSSubSysServiceAPI, true)) {
            pSSubSysServiceAPI.setPSSubSysServiceAPIName(this.srcPSSysServiceAPI.getPSSysServiceAPIName());
            pSSubSysServiceAPI.setCodeName(this.srcPSSysServiceAPI.getCodeName());
            pSSubSysServiceAPI.setServiceCodeName(this.srcPSSysServiceAPI.getServiceCodeName());
            pSSubSysServiceAPI.setServiceParam(StringHelper.format((String)"/%1$s/api/%2$s/v%3$s", (Object)this.psDevSlnSysAPI.getPSDevSlnSys().getPubCode(), (Object)this.srcPSSysServiceAPI.getCodeName().toLowerCase(), (Object)this.srcPSSysServiceAPI.getVer()));
            pSSubSysServiceAPI.setAPISource("NONE");
            pSSubSysServiceAPI.setPSModuleId(pSModule.getPSModuleId());
            pSSubSysServiceAPI.setPSModuleName(pSModule.getPSModuleName());
            pSSubSysServiceAPI.setAPIType(this.srcPSSysServiceAPI.getAPIType());
            pSSubSysServiceAPI.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
            pSSubSysServiceAPI.setPSSystemName(this.dstPSDevSlnSys.getPSDevSlnSysName());
            pSSubSysServiceAPI.setVer(this.srcPSSysServiceAPI.getVer());
            ((PSCoreSysServiceBaseBase)((Object)object2)).create(pSSubSysServiceAPI);
        }
        ArrayList<PSDEServiceAPI> arrayList = this.srcPSSysServiceAPI.getPSDEServiceAPIs();
        for (PSDEServiceAPI iterator : arrayList) {
            this.syncPSDEServiceAPI(iterator, pSModule, pSSysModelGroup);
        }
        this.syncPSDERs();
        for (String string : this.srcPSDataEntityMap.keySet()) {
            PSDataEntity pSDataEntity2 = this.srcPSDataEntityMap.get(string);
            pSDataEntity = this.dstPSDataEntityMap.get(string);
            this.syncPSDEActions(pSDataEntity2, pSDataEntity);
        }
        for (String string : this.srcPSDataEntityMap.keySet()) {
            PSDataEntity pSDataEntity3 = this.srcPSDataEntityMap.get(string);
            pSDataEntity = this.dstPSDataEntityMap.get(string);
            this.syncPSDEDataSets(pSDataEntity3, pSDataEntity);
        }
        this.syncPSSysSFPub();
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.dstSessionFactory);
        for (String string : this.dstPSDataEntityMap.keySet()) {
            pSDataEntity = this.dstPSDataEntityMap.get(string);
            pSDataEntityService.initModel(pSDataEntity);
        }
    }

    protected PSDataEntity syncPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, PSModule pSModule, PSSysModelGroup pSSysModelGroup) throws Exception {
        PSDataEntity pSDataEntity = pSDEServiceAPI.getPSDE();
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.dstSessionFactory);
        PSDataEntity pSDataEntity2 = new PSDataEntity();
        String string = null;
        string = pSDataEntity.getCodeName();
        if (!StringHelper.isNullOrEmpty((String)pSDataEntity.getServiceCodeName())) {
            string = pSDataEntity.getServiceCodeName();
            pSDataEntity2.setCodeName(pSDataEntity.getServiceCodeName());
        } else {
            pSDataEntity2.setCodeName(pSDataEntity.getCodeName());
        }
        pSDataEntity2.setServiceCodeName(pSDataEntity.getServiceCodeName());
        pSDataEntity2.setPSDataEntityName(string.toUpperCase());
        pSDataEntity2.setLogicName(pSDataEntity.getLogicName());
        pSDataEntity2.setDEType(pSDataEntity.getDEType());
        pSDataEntity2.setLogicValid(pSDataEntity.getLogicValid());
        pSDataEntity2.setValidFlag(pSDataEntity.getValidFlag());
        pSDataEntity2.setTableName(pSDataEntity.getTableName());
        pSDataEntity2.setViewName(pSDataEntity.getViewName());
        pSDataEntity2.setIndexDEType(pSDataEntity.getIndexDEType());
        pSDataEntity2.setPSModuleId(pSModule.getPSModuleId());
        pSDataEntity2.setPSModuleName(pSModule.getPSModuleName());
        pSDataEntity2.setPSSubSysServiceAPIId(this.srcPSSysServiceAPI.getPSSysServiceAPIId());
        pSDataEntity2.setPSSubSysServiceAPIName(this.srcPSSysServiceAPI.getPSSysServiceAPIName());
        pSDataEntity2.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
        pSDataEntity2.setPSSystemName(this.dstPSDevSlnSys.getPSDevSlnSysName());
        pSDataEntity2.setStorageMode(4);
        pSDataEntity2.setNoViewMode(1);
        pSDataEntity2.setExistingModel(1);
        pSDataEntity2.setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
        pSDataEntity2.setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
        pSDataEntityService.save((IEntity)pSDataEntity2);
        this.srcPSDataEntityMap.put(pSDataEntity.getPSDataEntityId(), pSDataEntity);
        this.dstPSDataEntityMap.put(pSDataEntity.getPSDataEntityId(), pSDataEntity2);
        this.syncPSDEFields(pSDataEntity, pSDataEntity2);
        return pSDataEntity2;
    }

    protected void syncPSDEFields(PSDataEntity pSDataEntity, PSDataEntity pSDataEntity2) throws Exception {
        ArrayList<PSDEField> arrayList = pSDataEntity.getPSDEFields();
        for (PSDEField pSDEField : arrayList) {
            if (!StringHelper.isNullOrEmpty((String)pSDEField.getPSDERId())) continue;
            this.syncPSDEField(pSDEField, pSDataEntity2);
        }
    }

    protected void syncPSDEField(PSDEField pSDEField, PSDataEntity pSDataEntity) throws Exception {
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.dstSessionFactory);
        PSDEField pSDEField2 = new PSDEField();
        pSDEField2.setPSDEFieldName(pSDEField.getCodeName().toUpperCase());
        pSDEField2.setCodeName(pSDEField.getCodeName());
        pSDEField2.setTableName(pSDEField.getTableName());
        pSDEField2.setLogicName(pSDEField.getLogicName());
        pSDEField2.setDEFType(pSDEField.getDEFType());
        pSDEField2.setPSDataTypeId(pSDEField.getPSDataTypeId());
        pSDEField2.setPSDataTypeName(pSDEField.getPSDataTypeName());
        pSDEField2.setLength(pSDEField.getLength());
        pSDEField2.setStrLength(pSDEField.getStrLength());
        pSDEField2.setAllowEmpty(pSDEField.getAllowEmpty());
        pSDEField2.setPKey(pSDEField.getPKey());
        pSDEField2.setMajorField(pSDEField.getMajorField());
        pSDEField2.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEField2.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)pSDEField.getPSDERId())) {
            if (this.srcPSDERMap.containsKey(pSDEField.getPSDERId())) {
                PSDER pSDER = this.srcPSDERMap.get(pSDEField.getPSDERId());
                PSDEField pSDEField3 = this.srcPSDEFieldMap.get(pSDEField.getDERPSDEFId());
                String string = this.dstPSDataEntityMap.get(pSDER.getMajorPSDEId()).getPSDataEntityId();
                String string2 = this.dstPSDataEntityMap.get(pSDER.getMinorPSDEId()).getPSDataEntityId();
                pSDEField2.setPSDERId(KeyValueHelper.genUniqueId((String)this.dstPSDevSlnSys.getPSSystemId(), (String)string, (String)string2));
                pSDEField2.setDERPSDEFId(this.dstPSDEFieldMap.get(pSDEField3.getPSDEFieldId()).getPSDEFieldId());
            } else {
                pSDEField2.setDEFType(1);
                PSDEField pSDEField4 = this.srcPSDEFieldMap.get(pSDEField.getDERPSDEFId());
                if (pSDEField4 != null) {
                    pSDEField2.setPSDataTypeId(pSDEField4.getPSDataTypeId());
                    pSDEField2.setPSDataTypeName(pSDEField4.getPSDataTypeName());
                } else {
                    pSDEField2.setPSDataTypeId("TEXT");
                    pSDEField2.setPSDataTypeName("\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6");
                }
            }
        }
        pSDEFieldService.save((IEntity)pSDEField2);
        this.srcPSDEFieldMap.put(pSDEField.getPSDEFieldId(), pSDEField);
        this.dstPSDEFieldMap.put(pSDEField.getPSDEFieldId(), pSDEField2);
    }

    protected void syncPSDERs() throws Exception {
        PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.srcSessionFactory);
        PSDERService pSDERService2 = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.dstSessionFactory);
        ArrayList arrayList = pSDERService.select((ISelectCond)new SelectCond());
        for (PSDER pSDER : arrayList) {
            if (this.srcPSDataEntityMap.containsKey(pSDER.getMajorPSDEId()) && this.srcPSDataEntityMap.containsKey(pSDER.getMinorPSDEId())) {
                PSDER pSDER2 = new PSDER();
                String string = this.dstPSDataEntityMap.get(pSDER.getMajorPSDEId()).getPSDataEntityId();
                String string2 = this.dstPSDataEntityMap.get(pSDER.getMinorPSDEId()).getPSDataEntityId();
                pSDER2.setPSDERId(KeyValueHelper.genUniqueId((String)this.dstPSDevSlnSys.getPSSystemId(), (String)string, (String)string2));
                pSDER2.setMajorPSDEId(string);
                pSDER2.setDERFieldName(pSDER.getDERFieldName());
                pSDER2.setDERFieldLName(pSDER.getDERFieldLName());
                pSDER2.setMajorPSDEName(this.dstPSDataEntityMap.get(pSDER.getMajorPSDEId()).getPSDataEntityName());
                pSDER2.setMinorPSDEId(string2);
                pSDER2.setMinorPSDEName(this.dstPSDataEntityMap.get(pSDER.getMinorPSDEId()).getPSDataEntityName());
                pSDER2.setDERType(pSDER.getDERType());
                pSDER2.setLogicName(pSDER.getLogicName());
                pSDER2.setCodeName(pSDER.getCodeName());
                pSDER2.setMinorCodeName(pSDER.getMinorCodeName());
                pSDER2.setMasterRS(pSDER.getMasterRS());
                pSDER2.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
                pSDER2.setPSSystemName(this.dstPSDevSlnSys.getPSDevSlnSysName());
                pSDER2.resetPSDERName();
                pSDERService2.save((IEntity)pSDER2);
                this.srcPSDERMap.put(pSDER.getPSDERId(), pSDER);
                this.dstPSDERMap.put(pSDER.getPSDERId(), pSDER2);
            }
            if (!this.srcPSDataEntityMap.containsKey(pSDER.getMinorPSDEId())) continue;
            for (PSDEField pSDEField : pSDER.getPSDEFields()) {
                this.syncPSDEField(pSDEField, this.dstPSDataEntityMap.get(pSDER.getMinorPSDEId()));
            }
        }
    }

    protected void syncPSDEActions(PSDataEntity pSDataEntity, PSDataEntity pSDataEntity2) throws Exception {
        PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.dstSessionFactory);
        ArrayList<PSDEAction> arrayList = pSDataEntity.getPSDEActions();
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = new PSDEAction();
            pSDEAction2.setPSDEActionId(KeyValueHelper.genUniqueId((String)this.psDevSlnSysAPI.getPSDevSlnSysAPIId(), (String)pSDEAction.getPSDEActionId()));
            pSDEAction2.setPSDEId(this.dstPSDataEntityMap.get(pSDataEntity.getPSDataEntityId()).getPSDataEntityId());
            pSDEAction2.setPSDEName(this.dstPSDataEntityMap.get(pSDataEntity.getPSDataEntityId()).getPSDataEntityName());
            pSDEAction2.setActionType(pSDEAction.getActionType());
            pSDEAction2.setCodeName(pSDEAction.getCodeName());
            pSDEAction2.setPSDEActionName(pSDEAction.getPSDEActionName());
            pSDEAction2.setPubMode(pSDEAction.getPubMode());
            pSDEAction2.setRequestField(pSDEAction.getRequestField());
            pSDEAction2.setRequestMethod(pSDEAction.getRequestMethod());
            pSDEAction2.setRequestParamType(pSDEAction.getRequestParamType());
            pSDEAction2.setRequestPath(pSDEAction.getRequestPath());
            pSDEActionService.save((IEntity)pSDEAction2);
        }
    }

    protected void syncPSDEDataSets(PSDataEntity pSDataEntity, PSDataEntity pSDataEntity2) throws Exception {
        PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.dstSessionFactory);
        ArrayList<PSDEDataSet> arrayList = pSDataEntity.getPSDEDataSets();
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = new PSDEDataSet();
            if (StringHelper.compare((String)pSDEDataSet.getPSDEDataSetId(), (String)pSDataEntity.getPSDataEntityId(), (boolean)true) == 0) {
                pSDEDataSet2.setPSDEDataSetId(pSDataEntity2.getPSDataEntityId());
            } else {
                pSDEDataSet2.setPSDEDataSetId(KeyValueHelper.genUniqueId((String)this.psDevSlnSysAPI.getPSDevSlnSysAPIId(), (String)pSDEDataSet.getPSDEDataSetId()));
            }
            pSDEDataSet2.setPSDEId(this.dstPSDataEntityMap.get(pSDataEntity.getPSDataEntityId()).getPSDataEntityId());
            pSDEDataSet2.setPSDEName(this.dstPSDataEntityMap.get(pSDataEntity.getPSDataEntityId()).getPSDataEntityName());
            pSDEDataSet2.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
            pSDEDataSet2.setCodeName(pSDEDataSet.getCodeName());
            pSDEDataSet2.setLogicName(pSDEDataSet.getLogicName());
            pSDEDataSet2.setPubMode(pSDEDataSet.getPubMode());
            pSDEDataSet2.setRequestPath(pSDEDataSet.getRequestPath());
            pSDEDataSet2.setRequestMethod(pSDEDataSet.getRequestMethod());
            pSDEDataSetService.save((IEntity)pSDEDataSet2);
        }
    }

    protected void syncPSSysSFPub() throws Exception {
        PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.srcSessionFactory);
        PSSysSFPubService pSSysSFPubService2 = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.dstSessionFactory);
        PSSysSFPub pSSysSFPub = new PSSysSFPub();
        pSSysSFPub.setDefaultPub(1);
        if (pSSysSFPubService.select(pSSysSFPub, true)) {
            PSSysSFPub pSSysSFPub2 = new PSSysSFPub();
            pSSysSFPub2.setPSSysSFPubId(KeyValueHelper.genUniqueId((String)this.psDevSlnSysAPI.getPSDevSlnSysAPIId(), (String)pSSysSFPub.getPSSysSFPubId()));
            if (!pSSysSFPubService2.get((IEntity)pSSysSFPub2, true)) {
                pSSysSFPub2.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
                pSSysSFPub2.setCodeName(StringHelper.format((String)"%1$s%2$s", (Object)this.srcPSSysServiceAPI.getServiceCodeName(), (Object)"Client"));
                pSSysSFPub2.setPKGCodeName(pSSysSFPub.getPKGCodeName());
                pSSysSFPub2.setPSSFStyleId(pSSysSFPub.getPSSFStyleId());
                pSSysSFPub2.setPSSFStyleName(pSSysSFPub.getPSSFStyleName());
                pSSysSFPub2.setDefaultPub(pSSysSFPub.getDefaultPub());
                pSSysSFPub2.setPSSFStyleParamId(pSSysSFPub.getPSSFStyleParamId());
                pSSysSFPub2.setPSSFStyleParamName(pSSysSFPub.getPSSFStyleParamName());
                pSSysSFPub2.setPSSFStyleVerId(pSSysSFPub.getPSSFStyleVerId());
                pSSysSFPub2.setPSSFStyleVerName(pSSysSFPub.getPSSFStyleVerName());
                pSSysSFPub2.setPSSystemId(this.dstPSDevSlnSys.getPSSystemId());
                pSSysSFPub2.setPSSystemName(this.dstPSDevSlnSys.getPSSystemId());
                pSSysSFPubService2.create(pSSysSFPub2);
            }
        }
    }
}

