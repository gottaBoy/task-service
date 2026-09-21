/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.DEStorageTypeCodeListModel
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEAction
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDER
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADERS
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Util.IPSDevSlnSysModelStorage;
import SA.SRFDA.PS.Core.Util.PSDevSlnSysModelStorage3;
import SA.SRFDA.PS.Core.Util.PSDevSlnSysModelStorage3Ref;
import SA.SRFDA.PS.Core.Util.PSModelSyncHelperBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.DEStorageTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADERS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import org.hibernate.SessionFactory;

public class PSModelSyncHelper3
extends PSModelSyncHelperBase {
    public PSModelSyncHelper3(PSDevSlnSys psDevSlnSys, SessionFactory sessionFactory) {
        super(psDevSlnSys, sessionFactory);
    }

    @Override
    protected IPSDevSlnSysModelStorage getPSDevSlnSysModelStorage(PSDevSlnSys psDevSlnSys, boolean bRef) throws Exception {
        if (bRef) {
            return new PSDevSlnSysModelStorage3Ref(psDevSlnSys);
        }
        return new PSDevSlnSysModelStorage3(psDevSlnSys);
    }

    @Override
    protected String onSync(PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        PSSysServiceAPI srcPSSysServiceAPI;
        PSSysModelGroup defaultPSSysModelGroup = this.getPSDevSlnSysModelStorage().getByCodeName("PSSYSMODELGROUP", null, "CLOUD_" + psDevSlnSysRef.getRefMode(), PSSysModelGroup.class);
        if (defaultPSSysModelGroup == null) {
            defaultPSSysModelGroup = new PSSysModelGroup();
            defaultPSSysModelGroup.setPSSysModelGroupName(refPSDevSlnSysModelStorage.getPSDevSlnSys().getPSDevSlnSysName());
            defaultPSSysModelGroup.setCodeName("CLOUD_" + psDevSlnSysRef.getRefMode());
            defaultPSSysModelGroup.setGroupTag("DEVSYSCLOUD");
            defaultPSSysModelGroup.setGroupTag2(psDevSlnSysRef.getRefMode());
            this.getPSDevSlnSysModelStorage().create("PSSYSMODELGROUP", (IEntity)defaultPSSysModelGroup);
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("pssysmodelgroupid", (Object)defaultPSSysModelGroup.getPSSysModelGroupId());
        PSModule defaultPSModule = this.getPSDevSlnSysModelStorage().getByCodeName("PSMODULE", (ISelectCond)selectCond, "Client_Common", PSModule.class);
        if (defaultPSModule == null) {
            defaultPSModule = new PSModule();
            defaultPSModule.setPSModuleName("\u5916\u90e8\u63a5\u53e3\u9ed8\u8ba4\u6a21\u5757");
            defaultPSModule.setCodeName("Client_Common");
            defaultPSModule.setSubSysModule(Integer.valueOf(1));
            defaultPSModule.setSysRefType("DEVSYSCLOUD");
            defaultPSModule.setDefaultFlag(Integer.valueOf(0));
            defaultPSModule.setPSSysModelGroupId(defaultPSSysModelGroup.getPSSysModelGroupId());
            this.getPSDevSlnSysModelStorage().create("PSMODULE", (IEntity)defaultPSModule);
        }
        if ((srcPSSysServiceAPI = refPSDevSlnSysModelStorage.getByCodeName("PSSYSSERVICEAPI", null, psDevSlnSysRef.getPSDevSlnSysRefName(), PSSysServiceAPI.class)) == null) {
            throw new Exception("\u672a\u6307\u5b9a\u5f15\u7528\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3");
        }
        selectCond.reset();
        selectCond.set("psmoduleid", (Object)defaultPSModule.getPSModuleId());
        PSSubSysServiceAPI dstPSSubSysServiceAPI = this.getPSDevSlnSysModelStorage().getByCodeName("PSSUBSYSSERVICEAPI", (ISelectCond)selectCond, "ServiceAPIClient", PSSubSysServiceAPI.class);
        if (dstPSSubSysServiceAPI == null) {
            dstPSSubSysServiceAPI = new PSSubSysServiceAPI();
            dstPSSubSysServiceAPI.setPSSubSysServiceAPIName(srcPSSysServiceAPI.getPSSysServiceAPIName());
            dstPSSubSysServiceAPI.setPSModuleId(defaultPSModule.getPSModuleId());
            dstPSSubSysServiceAPI.setCodeName("ServiceAPIClient");
            if (!StringHelper.isNullOrEmpty((String)srcPSSysServiceAPI.getServiceCodeName())) {
                dstPSSubSysServiceAPI.setServiceCodeName(srcPSSysServiceAPI.getServiceCodeName());
            } else {
                dstPSSubSysServiceAPI.setServiceCodeName(srcPSSysServiceAPI.getCodeName());
            }
            dstPSSubSysServiceAPI.setAPIType(srcPSSysServiceAPI.getAPIType());
            dstPSSubSysServiceAPI.setServiceDTOFlag(srcPSSysServiceAPI.getServiceDTOFlag());
            this.getPSDevSlnSysModelStorage().create("PSSUBSYSSERVICEAPI", (IEntity)dstPSSubSysServiceAPI);
        } else {
            boolean bUpdate = false;
            String strServiceCodeName = srcPSSysServiceAPI.getServiceCodeName();
            if (StringHelper.isNullOrEmpty((String)strServiceCodeName)) {
                strServiceCodeName = srcPSSysServiceAPI.getCodeName();
            }
            if (StringHelper.compare((String)dstPSSubSysServiceAPI.getServiceCodeName(), (String)strServiceCodeName, (boolean)false) != 0) {
                dstPSSubSysServiceAPI.setServiceCodeName(strServiceCodeName);
                bUpdate = true;
            }
            if (bUpdate) {
                this.getPSDevSlnSysModelStorage().update("PSSUBSYSSERVICEAPI", (IEntity)dstPSSubSysServiceAPI);
            }
        }
        this.syncPSSubSysSADEs(dstPSSubSysServiceAPI, srcPSSysServiceAPI, defaultPSSysModelGroup, defaultPSModule, psDevSlnSysRef, refPSDevSlnSysModelStorage);
        return super.onSync(psDevSlnSysRef, refPSDevSlnSysModelStorage);
    }

    protected String syncPSSubSysSADEs(PSSubSysServiceAPI dstPSSubSysServiceAPI, PSSysServiceAPI srcPSSysServiceAPI, PSSysModelGroup defaultPSSysModelGroup, PSModule defaultPSModule, PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        PSModule psModule;
        PSDataEntity psDataEntity;
        Iterator<IPSDEServiceAPIRS> psDEServiceAPIRSs;
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSSUBSYSSERVICEAPIID", (Object)dstPSSubSysServiceAPI.getPSSubSysServiceAPIId());
        List<PSSubSysSADE> dstPSSubSysSADEList = this.getPSDevSlnSysModelStorage().select("PSSUBSYSSADE", (ISelectCond)selectCond, PSSubSysSADE.class);
        HashMap<String, PSSubSysSADE> psSubSysSADEMap = new HashMap<String, PSSubSysSADE>();
        HashMap<String, PSSubSysSADE> psSubSysSADEMap2 = new HashMap<String, PSSubSysSADE>();
        if (dstPSSubSysSADEList != null) {
            for (PSSubSysSADE psSubSysSADE : dstPSSubSysSADEList) {
                psSubSysSADEMap.put(psSubSysSADE.getPSSubSysSADEName(), psSubSysSADE);
            }
        }
        IPSSysServiceAPI iPSSysServiceAPI = refPSDevSlnSysModelStorage.getPSSystem().getPSSysServiceAPI(srcPSSysServiceAPI.getPSSysServiceAPIId());
        HashMap<String, Integer> syncPSDataEntityMap = new HashMap<String, Integer>();
        Iterator<IPSDEServiceAPI> psDEServiceAPIs = iPSSysServiceAPI.getPSDEServiceAPIs();
        if (psDEServiceAPIs != null) {
            while (psDEServiceAPIs.hasNext()) {
                IPSDEServiceAPI iPSDEServiceAPI = psDEServiceAPIs.next();
                PSDataEntity psDataEntity2 = refPSDevSlnSysModelStorage.getByTag("PSDATAENTITY", iPSDEServiceAPI.getPSDataEntity().getId(), PSDataEntity.class);
                if (psDataEntity2 == null) continue;
                PSSubSysSADE psSubSysSADE = (PSSubSysSADE)psSubSysSADEMap.get(iPSDEServiceAPI.getName());
                if (psSubSysSADE == null) {
                    psSubSysSADE = new PSSubSysSADE();
                    psSubSysSADE.setPSSubSysServiceAPIId(dstPSSubSysServiceAPI.getPSSubSysServiceAPIId());
                    psSubSysSADE.setPSSubSysServiceAPIName(dstPSSubSysServiceAPI.getPSSubSysServiceAPIName());
                    psSubSysSADE.setPSSubSysSADEName(iPSDEServiceAPI.getName());
                    psSubSysSADE.setCodeName(iPSDEServiceAPI.getCodeName());
                    psSubSysSADE.setMajorFlag(Integer.valueOf(iPSDEServiceAPI.getAPIMode()));
                    try {
                        this.getPSDevSlnSysModelStorage().create("PSSUBSYSSADE", (IEntity)psSubSysSADE);
                        psSubSysSADEMap.put(iPSDEServiceAPI.getName(), psSubSysSADE);
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u540c\u6b65\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iPSDEServiceAPI.getName(), ex.getMessage()), ex);
                    }
                }
                boolean bUpdate = false;
                if (StringHelper.compare((String)iPSDEServiceAPI.getCodeName(), (String)psSubSysSADE.getCodeName(), (boolean)false) != 0) {
                    psSubSysSADE.setCodeName(iPSDEServiceAPI.getCodeName());
                    bUpdate = true;
                }
                if (DataTypeHelper.compare((int)9, (Object)psSubSysSADE.getMajorFlag(), (Object)iPSDEServiceAPI.getAPIMode()) != 0L) {
                    psSubSysSADE.setMajorFlag(Integer.valueOf(iPSDEServiceAPI.getAPIMode()));
                }
                if (bUpdate) {
                    try {
                        this.getPSDevSlnSysModelStorage().update("PSSUBSYSSADE", (IEntity)psSubSysSADE);
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u540c\u6b65\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iPSDEServiceAPI.getName(), ex.getMessage()), ex);
                    }
                }
                psSubSysSADEMap2.put(iPSDEServiceAPI.getPSDataEntity().getId(), psSubSysSADE);
            }
        }
        if ((psDEServiceAPIRSs = iPSSysServiceAPI.getPSDEServiceAPIRSs()) != null) {
            selectCond.reset();
            selectCond.set("PSSUBSYSSERVICEAPIID", (Object)dstPSSubSysServiceAPI.getPSSubSysServiceAPIId());
            List<PSSubSysSADERS> dstPSSubSysSADERSList = this.getPSDevSlnSysModelStorage().select("PSSUBSYSSADERS", (ISelectCond)selectCond, PSSubSysSADERS.class);
            HashMap<String, PSSubSysSADERS> psSubSysSADERSMap = new HashMap<String, PSSubSysSADERS>();
            if (dstPSSubSysSADERSList != null) {
                for (PSSubSysSADERS psSubSysSADERS : dstPSSubSysSADERSList) {
                    String string = String.format("%1$s|%2$s", psSubSysSADERS.getPPSSubSysSADEName(), psSubSysSADERS.getCPSSubSysSADEName());
                    psSubSysSADERSMap.put(string, psSubSysSADERS);
                }
            }
            while (psDEServiceAPIRSs.hasNext()) {
                IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                String strTag = String.format("%1$s|%2$s", iPSDEServiceAPIRS.getMajorPSDEServiceAPI().getName(), iPSDEServiceAPIRS.getMinorPSDEServiceAPI().getName());
                PSSubSysSADERS pSSubSysSADERS = (PSSubSysSADERS)psSubSysSADERSMap.get(strTag);
                if (pSSubSysSADERS != null) continue;
                PSSubSysSADERS pSSubSysSADERS2 = new PSSubSysSADERS();
                pSSubSysSADERS2.setPSSubSysServiceAPIId(dstPSSubSysServiceAPI.getPSSubSysServiceAPIId());
                pSSubSysSADERS2.setPSSubSysServiceAPIName(dstPSSubSysServiceAPI.getPSSubSysServiceAPIName());
                pSSubSysSADERS2.setPSSubSysSADERSName(iPSDEServiceAPIRS.getName());
                pSSubSysSADERS2.setCodeName(iPSDEServiceAPIRS.getCodeName());
                pSSubSysSADERS2.setCodeName2(iPSDEServiceAPIRS.getCodeName2());
                pSSubSysSADERS2.setChildFilter(iPSDEServiceAPIRS.getParentFilter());
                pSSubSysSADERS2.setArrayFlag(Integer.valueOf(iPSDEServiceAPIRS.isArray() ? 1 : 0));
                pSSubSysSADERS2.setTypeFilter(iPSDEServiceAPIRS.getParentTypeFilter());
                pSSubSysSADERS2.setOrderValue(Integer.valueOf(iPSDEServiceAPIRS.getOrderValue()));
                pSSubSysSADERS2.setValidFlag(Integer.valueOf(1));
                Iterator<Object> parentPSSubSysSADE = (PSSubSysSADE)psSubSysSADEMap.get(iPSDEServiceAPIRS.getMajorPSDEServiceAPI().getName());
                Iterator<Object> childPSSubSysSADE = (PSSubSysSADE)psSubSysSADEMap.get(iPSDEServiceAPIRS.getMinorPSDEServiceAPI().getName());
                if (parentPSSubSysSADE == null) {
                    throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53[%1$s]\u5bf9\u5e94\u7684\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53", iPSDEServiceAPIRS.getMajorPSDEServiceAPI().getName()));
                }
                if (childPSSubSysSADE == null) {
                    throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53[%1$s]\u5bf9\u5e94\u7684\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53", iPSDEServiceAPIRS.getMinorPSDEServiceAPI().getName()));
                }
                pSSubSysSADERS2.setPPSSubSysSADEId(parentPSSubSysSADE.getPSSubSysSADEId());
                pSSubSysSADERS2.setPPSSubSysSADEName(parentPSSubSysSADE.getPSSubSysSADEName());
                pSSubSysSADERS2.setCPSSubSysSADEId(childPSSubSysSADE.getPSSubSysSADEId());
                pSSubSysSADERS2.setCPSSubSysSADEName(childPSSubSysSADE.getPSSubSysSADEName());
                try {
                    this.getPSDevSlnSysModelStorage().create("PSSUBSYSSADERS", (IEntity)pSSubSysSADERS2);
                }
                catch (Exception ex) {
                    throw new Exception(String.format("\u540c\u6b65\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iPSDEServiceAPIRS.getName(), ex.getMessage()), ex);
                }
            }
        }
        ArrayList<Object> list = new ArrayList<Object>();
        list.addAll(syncPSDataEntityMap.keySet());
        while (list.size() > 0) {
            String strPSDEId = (String)list.remove(0);
            selectCond.reset();
            selectCond.set("MAJORPSDEID", (Object)strPSDEId);
            List<PSDER> srcPSDERList = refPSDevSlnSysModelStorage.select("PSDER", (ISelectCond)selectCond, PSDER.class);
            if (srcPSDERList == null) continue;
            for (PSDER psDER : srcPSDERList) {
                if (syncPSDataEntityMap.containsKey(psDER.getMinorPSDEId()) || psDER.getMasterRS() == null || (psDER.getMasterRS() & 8) != 8) continue;
                syncPSDataEntityMap.put(psDER.getMinorPSDEId(), 1);
                list.add(psDER.getMinorPSDEId());
            }
        }
        HashMap<String, PSCodeList> srcPSCodeListMap = new HashMap<String, PSCodeList>();
        HashMap<String, PSDEField> srcPSDEFieldMap = new HashMap<String, PSDEField>();
        List<PSDEField> srcPSDEFieldList = refPSDevSlnSysModelStorage.select("PSDEFIELD", null, PSDEField.class);
        if (srcPSDEFieldList != null) {
            for (PSDEField pSDEField : srcPSDEFieldList) {
                if (!syncPSDataEntityMap.containsKey(pSDEField.getPSDEId()) || srcPSDEFieldMap.containsKey(pSDEField.getPSDEFieldId())) continue;
                srcPSDEFieldMap.put(pSDEField.getPSDEFieldId(), pSDEField);
                this.calcPSDEField(pSDEField, srcPSDEFieldMap, srcPSCodeListMap, refPSDevSlnSysModelStorage);
            }
        }
        for (Map.Entry entry : srcPSDEFieldMap.entrySet()) {
            if (syncPSDataEntityMap.containsKey(((PSDEField)entry.getValue()).getPSDEId())) continue;
            syncPSDataEntityMap.put(((PSDEField)entry.getValue()).getPSDEId(), 0);
        }
        HashMap<String, PSModule> hashMap = new HashMap<String, PSModule>();
        for (String strPSDEId : syncPSDataEntityMap.keySet()) {
            psDataEntity = refPSDevSlnSysModelStorage.getByTag("PSDATAENTITY", strPSDEId, PSDataEntity.class);
            if (psDataEntity == null || hashMap.containsKey(psDataEntity.getPSModuleId()) || (psModule = refPSDevSlnSysModelStorage.getByTag("PSMODULE", psDataEntity.getPSModuleId(), PSModule.class)) == null) continue;
            hashMap.put(psDataEntity.getPSModuleId(), psModule);
        }
        for (String strPSDEId : syncPSDataEntityMap.keySet()) {
            psDataEntity = refPSDevSlnSysModelStorage.getByTag("PSDATAENTITY", strPSDEId, PSDataEntity.class);
            if (psDataEntity == null || hashMap.containsKey(psDataEntity.getPSModuleId()) || (psModule = refPSDevSlnSysModelStorage.getByTag("PSMODULE", psDataEntity.getPSModuleId(), PSModule.class)) == null) continue;
            hashMap.put(psDataEntity.getPSModuleId(), psModule);
        }
        for (PSCodeList srcPSCodeList : srcPSCodeListMap.values()) {
            PSModule psModule2;
            if (StringHelper.isNullOrEmpty((String)srcPSCodeList.getPSModuleId()) || hashMap.containsKey(srcPSCodeList.getPSModuleId()) || (psModule2 = refPSDevSlnSysModelStorage.getByTag("PSMODULE", srcPSCodeList.getPSModuleId(), PSModule.class)) == null) continue;
            hashMap.put(srcPSCodeList.getPSModuleId(), psModule2);
        }
        for (PSModule srcPSModule : hashMap.values()) {
            selectCond.reset();
            selectCond.set("pssysmodelgroupid", (Object)defaultPSSysModelGroup.getPSSysModelGroupId());
            PSModule dstPSModule = this.getPSDevSlnSysModelStorage().getByCodeName("PSMODULE", (ISelectCond)selectCond, srcPSModule.getCodeName(), PSModule.class);
            if (dstPSModule == null) {
                dstPSModule = new PSModule();
                dstPSModule.setPSModuleName(srcPSModule.getPSModuleName());
                dstPSModule.setCodeName(srcPSModule.getCodeName());
                dstPSModule.setPSSysModelGroupId(defaultPSSysModelGroup.getPSSysModelGroupId());
                dstPSModule.setDefaultFlag(Integer.valueOf(0));
                dstPSModule.setSubSysModule(Integer.valueOf(1));
                dstPSModule.setSysRefType("DEVSYSCLOUD");
                try {
                    this.getPSDevSlnSysModelStorage().create("PSMODULE", (IEntity)dstPSModule);
                }
                catch (Exception ex) {
                    throw new Exception(String.format("\u540c\u6b65\u7cfb\u7edf\u6a21\u5757[%1$s][%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", srcPSModule.getPSModuleName(), srcPSModule.getCodeName(), ex.getMessage()), ex);
                }
            }
            this.mapPSModel("PSMODULE", srcPSModule.getPSModuleId(), dstPSModule);
        }
        for (String strPSDEId : syncPSDataEntityMap.keySet()) {
            PSDataEntity srcPSDataEntity = refPSDevSlnSysModelStorage.getByTag("PSDATAENTITY", strPSDEId, PSDataEntity.class);
            if (srcPSDataEntity == null) continue;
            this.syncPSDataEntity(srcPSDataEntity, (PSSubSysSADE)psSubSysSADEMap2.get(strPSDEId), (Integer)syncPSDataEntityMap.get(strPSDEId), psDevSlnSysRef, refPSDevSlnSysModelStorage);
        }
        HashMap<String, PSDEDataSet> srcPSDEDataSetMap = new HashMap<String, PSDEDataSet>();
        List<PSDEDataSet> srcPSDEDataSetList = refPSDevSlnSysModelStorage.select("PSDEDATASET", null, PSDEDataSet.class);
        if (srcPSDEDataSetList != null) {
            for (PSDEDataSet srcPSDEDataSet : srcPSDEDataSetList) {
                if (!syncPSDataEntityMap.containsKey(srcPSDEDataSet.getPSDEId()) || srcPSDEDataSetMap.containsKey(srcPSDEDataSet.getPSDEDataSetId())) continue;
                srcPSDEDataSetMap.put(srcPSDEDataSet.getPSDEDataSetId(), srcPSDEDataSet);
                this.syncPSDEDataSet(srcPSDEDataSet, (Integer)syncPSDataEntityMap.get(srcPSDEDataSet.getPSDEId()), psDevSlnSysRef, refPSDevSlnSysModelStorage);
            }
        }
        HashMap<String, PSDEAction> srcPSDEActionMap = new HashMap<String, PSDEAction>();
        List<PSDEAction> srcPSDEActionList = refPSDevSlnSysModelStorage.select("PSDEACTION", null, PSDEAction.class);
        if (srcPSDEActionList != null) {
            for (PSDEAction srcPSDEAction : srcPSDEActionList) {
                if (!syncPSDataEntityMap.containsKey(srcPSDEAction.getPSDEId()) || srcPSDEActionMap.containsKey(srcPSDEAction.getPSDEActionId())) continue;
                srcPSDEActionMap.put(srcPSDEAction.getPSDEActionId(), srcPSDEAction);
                this.syncPSDEAction(srcPSDEAction, (Integer)syncPSDataEntityMap.get(srcPSDEAction.getPSDEId()), psDevSlnSysRef, refPSDevSlnSysModelStorage);
            }
        }
        this.syncPSDERs(psDevSlnSysRef, refPSDevSlnSysModelStorage);
        this.syncPSCodeLists(srcPSCodeListMap.values(), defaultPSModule, psDevSlnSysRef, refPSDevSlnSysModelStorage);
        this.syncPSCodeItems(psDevSlnSysRef, refPSDevSlnSysModelStorage);
        this.syncPSDEFields(srcPSDEFieldMap.values(), psDevSlnSysRef, refPSDevSlnSysModelStorage);
        return null;
    }

    protected void calcPSDEField(PSDEField srcPSDEField, Map<String, PSDEField> srcPSDEFieldMap, Map<String, PSCodeList> srcPSCodeListMap, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        PSDEField derPSDEField;
        String strDERPSDEFId;
        PSCodeList srcPSCodeList;
        if (!StringHelper.isNullOrEmpty((String)srcPSDEField.getPSCodeListId()) && !srcPSCodeListMap.containsKey(srcPSDEField.getPSCodeListId()) && (srcPSCodeList = refPSDevSlnSysModelStorage.getByTag("PSCODELIST", srcPSDEField.getPSCodeListId(), PSCodeList.class)) != null) {
            srcPSCodeListMap.put(srcPSDEField.getPSCodeListId(), srcPSCodeList);
        }
        if (!StringHelper.isNullOrEmpty((String)(strDERPSDEFId = srcPSDEField.getDERPSDEFId())) && !srcPSDEFieldMap.containsKey(strDERPSDEFId) && (derPSDEField = refPSDevSlnSysModelStorage.getByTag("PSDEFIELD", strDERPSDEFId, PSDEField.class)) != null) {
            srcPSDEFieldMap.put(derPSDEField.getPSDEFieldId(), derPSDEField);
            this.calcPSDEField(derPSDEField, srcPSDEFieldMap, srcPSCodeListMap, refPSDevSlnSysModelStorage);
        }
    }

    protected String syncPSCodeLists(PSModule defaultDstPSModule, PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        List<PSDEField> srcPSDEFieldList = refPSDevSlnSysModelStorage.select("PSDEFIELD", null, PSDEField.class);
        HashMap<String, String> psCodeListMap = new HashMap<String, String>();
        for (PSDEField srcPSDEField : srcPSDEFieldList) {
            PSDataEntity dstPSDataEntity;
            if (StringHelper.isNullOrEmpty((String)srcPSDEField.getPSCodeListId()) || (dstPSDataEntity = this.getDstPSModel("PSDATAENTITY", srcPSDEField.getPSDEId(), PSDataEntity.class)) == null) continue;
            psCodeListMap.put(srcPSDEField.getPSCodeListId(), "");
        }
        List<PSCodeList> srcPSCodeListList = refPSDevSlnSysModelStorage.select("PSCODELIST", null, PSCodeList.class);
        if (srcPSCodeListList != null) {
            for (PSCodeList srcPSCodeList : srcPSCodeListList) {
                if (!psCodeListMap.containsKey(srcPSCodeList.getPSCodeListId())) continue;
                PSModule dstPSModule = null;
                SelectCond selectCond = new SelectCond();
                if (StringHelper.isNullOrEmpty((String)srcPSCodeList.getPSModuleId())) {
                    dstPSModule = defaultDstPSModule;
                } else {
                    dstPSModule = this.getDstPSModel("PSMODULE", srcPSCodeList.getPSModuleId(), PSModule.class);
                    if (dstPSModule == null) {
                        dstPSModule = defaultDstPSModule;
                    }
                }
                selectCond.set("psmoduleid", (Object)dstPSModule.getPSModuleId());
                PSCodeList dstPSCodeList = this.getPSDevSlnSysModelStorage().getByCodeName("PSCODELIST", (ISelectCond)selectCond, srcPSCodeList.getCodeName(), PSCodeList.class);
                if (dstPSCodeList == null) {
                    dstPSCodeList = new PSCodeList();
                    dstPSCodeList.setPSCodeListName(srcPSCodeList.getPSCodeListName());
                    dstPSCodeList.setCodeName(srcPSCodeList.getCodeName());
                    dstPSCodeList.setCodeListSN(srcPSCodeList.getCodeListSN());
                    dstPSCodeList.setCLType(srcPSCodeList.getCLType());
                    dstPSCodeList.setPSModuleId(dstPSModule.getPSModuleId());
                    dstPSCodeList.setPSModuleName(dstPSModule.getPSModuleName());
                    dstPSCodeList.setOrMode(srcPSCodeList.getOrMode());
                    dstPSCodeList.setNumberItem(srcPSCodeList.getNumberItem());
                    try {
                        this.getPSDevSlnSysModelStorage().create("PSCODELIST", (IEntity)dstPSCodeList);
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u540c\u6b65\u4ee3\u7801\u8868[%1$s][%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", srcPSCodeList.getPSCodeListName(), srcPSCodeList.getCodeName(), ex.getMessage()), ex);
                    }
                }
                this.mapPSModel("PSCODELIST", srcPSCodeList.getPSCodeListId(), dstPSCodeList);
            }
        }
        return null;
    }

    protected String syncPSDataEntity(PSDataEntity srcPSDataEntity, PSSubSysSADE psSubSysSADE, int nMainFlag, PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        PSModule dstPSModule = this.getDstPSModel("PSMODULE", srcPSDataEntity.getPSModuleId(), PSModule.class);
        SelectCond selectCond = new SelectCond();
        selectCond.set("psmoduleid", (Object)dstPSModule.getPSModuleId());
        PSDataEntity dstPSDataEntity = this.getPSDevSlnSysModelStorage().getByName("PSDATAENTITY", (ISelectCond)selectCond, srcPSDataEntity.getPSDataEntityName(), PSDataEntity.class);
        if (dstPSDataEntity == null) {
            dstPSDataEntity = new PSDataEntity();
            dstPSDataEntity.setPSDataEntityName(srcPSDataEntity.getPSDataEntityName());
            dstPSDataEntity.setCodeName(srcPSDataEntity.getCodeName());
            dstPSDataEntity.setLogicName(srcPSDataEntity.getLogicName());
            dstPSDataEntity.setDEType(srcPSDataEntity.getDEType());
            dstPSDataEntity.setPSModuleId(dstPSModule.getPSModuleId());
            dstPSDataEntity.setPSSysModelGroupId(dstPSModule.getPSSysModelGroupId());
            dstPSDataEntity.setTableName(srcPSDataEntity.getTableName());
            if (!StringHelper.isNullOrEmpty((String)srcPSDataEntity.getTableName())) {
                dstPSDataEntity.setExistingModel(Integer.valueOf(1));
            }
            dstPSDataEntity.setNoViewMode(Integer.valueOf(1));
            if (nMainFlag == 1) {
                dstPSDataEntity.setVirtualFlag(srcPSDataEntity.getVirtualFlag());
                dstPSDataEntity.setIndexDEType(srcPSDataEntity.getIndexDEType());
            }
            if (psSubSysSADE != null) {
                dstPSDataEntity.setStorageMode(DEStorageTypeCodeListModel.SERVICEAPI);
                dstPSDataEntity.setPSSubSysServiceAPIId(psSubSysSADE.getPSSubSysServiceAPIId());
                dstPSDataEntity.setPSSubSysSADEId(psSubSysSADE.getPSSubSysSADEId());
            } else {
                dstPSDataEntity.setStorageMode(DEStorageTypeCodeListModel.NONE);
            }
            try {
                this.getPSDevSlnSysModelStorage().create("PSDATAENTITY", (IEntity)dstPSDataEntity);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u540c\u6b65\u5b9e\u4f53[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", srcPSDataEntity.getPSDataEntityName(), ex.getMessage()), ex);
            }
        }
        boolean bUpdate = false;
        if (StringHelper.compare((String)srcPSDataEntity.getCodeName(), (String)dstPSDataEntity.getCodeName(), (boolean)false) != 0) {
            dstPSDataEntity.setCodeName(srcPSDataEntity.getCodeName());
            bUpdate = true;
        }
        if (StringHelper.isNullOrEmpty((String)dstPSDataEntity.getPSSubSysSADEId()) && psSubSysSADE != null) {
            dstPSDataEntity.setStorageMode(DEStorageTypeCodeListModel.SERVICEAPI);
            dstPSDataEntity.setPSSubSysServiceAPIId(psSubSysSADE.getPSSubSysServiceAPIId());
            dstPSDataEntity.setPSSubSysSADEId(psSubSysSADE.getPSSubSysSADEId());
            dstPSDataEntity.setVirtualFlag(srcPSDataEntity.getVirtualFlag());
            dstPSDataEntity.setIndexDEType(srcPSDataEntity.getIndexDEType());
            bUpdate = true;
        }
        if (bUpdate) {
            try {
                this.getPSDevSlnSysModelStorage().update("PSDATAENTITY", (IEntity)dstPSDataEntity);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u540c\u6b65\u5b9e\u4f53[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", srcPSDataEntity.getPSDataEntityName(), ex.getMessage()), ex);
            }
        }
        this.mapPSModel("PSDATAENTITY", srcPSDataEntity.getPSDataEntityId(), dstPSDataEntity);
        return null;
    }

    protected String syncPSDEDataSet(PSDEDataSet srcPSDEDataSet, Integer nMainFlag, PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        PSDataEntity dstPSDataEntity = this.getDstPSModel("PSDATAENTITY", srcPSDEDataSet.getPSDEId(), PSDataEntity.class);
        SelectCond selectCond = new SelectCond();
        selectCond.set("psdeid", (Object)dstPSDataEntity.getPSDataEntityId());
        PSDEDataSet dstPSDEDataSet = this.getPSDevSlnSysModelStorage().getByName("PSDEDATASET", (ISelectCond)selectCond, srcPSDEDataSet.getPSDEDataSetName(), PSDEDataSet.class);
        if (dstPSDEDataSet == null) {
            dstPSDEDataSet = new PSDEDataSet();
            dstPSDEDataSet.setPSDEDataSetName(srcPSDEDataSet.getPSDEDataSetName());
            dstPSDEDataSet.setCodeName(srcPSDEDataSet.getCodeName());
            dstPSDEDataSet.setLogicName(srcPSDEDataSet.getLogicName());
            dstPSDEDataSet.setPSDEId(dstPSDataEntity.getPSDataEntityId());
            dstPSDEDataSet.setPSDEName(dstPSDataEntity.getPSDataEntityName());
            try {
                this.getPSDevSlnSysModelStorage().create("PSDEDATASET", (IEntity)dstPSDEDataSet);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u540c\u6b65\u5b9e\u4f53\u6570\u636e\u96c6[%1$s][%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", dstPSDataEntity.getPSDataEntityName(), srcPSDEDataSet.getPSDEDataSetName(), ex.getMessage()), ex);
            }
        }
        boolean bUpdate = false;
        if (StringHelper.compare((String)srcPSDEDataSet.getCodeName(), (String)dstPSDEDataSet.getCodeName(), (boolean)false) != 0) {
            dstPSDEDataSet.setCodeName(srcPSDEDataSet.getCodeName());
            bUpdate = true;
        }
        if (bUpdate) {
            try {
                this.getPSDevSlnSysModelStorage().update("PSDEDATASET", (IEntity)dstPSDEDataSet);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u540c\u6b65\u5b9e\u4f53\u6570\u636e\u96c6[%1$s][%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", dstPSDataEntity.getPSDataEntityName(), srcPSDEDataSet.getPSDEDataSetName(), ex.getMessage()), ex);
            }
        }
        this.mapPSModel("PSDEDATASET", srcPSDEDataSet.getPSDEDataSetId(), dstPSDEDataSet);
        return null;
    }

    protected String syncPSDEAction(PSDEAction srcPSDEAction, Integer nMainFlag, PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        PSDataEntity dstPSDataEntity = this.getDstPSModel("PSDATAENTITY", srcPSDEAction.getPSDEId(), PSDataEntity.class);
        SelectCond selectCond = new SelectCond();
        selectCond.set("psdeid", (Object)dstPSDataEntity.getPSDataEntityId());
        PSDEAction dstPSDEAction = this.getPSDevSlnSysModelStorage().getByName("PSDEACTION", (ISelectCond)selectCond, srcPSDEAction.getPSDEActionName(), PSDEAction.class);
        if (dstPSDEAction == null) {
            dstPSDEAction = new PSDEAction();
            dstPSDEAction.setPSDEActionName(srcPSDEAction.getPSDEActionName());
            dstPSDEAction.setCodeName(srcPSDEAction.getCodeName());
            dstPSDEAction.setLogicName(srcPSDEAction.getLogicName());
            dstPSDEAction.setPSDEId(dstPSDataEntity.getPSDataEntityId());
            dstPSDEAction.setPSDEName(dstPSDataEntity.getPSDataEntityName());
            dstPSDEAction.setActionType("BUILTIN");
            dstPSDEAction.setActionMode(srcPSDEAction.getActionMode());
            try {
                this.getPSDevSlnSysModelStorage().create("PSDEACTION", (IEntity)dstPSDEAction);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u540c\u6b65\u5b9e\u4f53\u884c\u4e3a[%1$s][%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", dstPSDataEntity.getPSDataEntityName(), srcPSDEAction.getPSDEActionName(), ex.getMessage()), ex);
            }
        }
        boolean bUpdate = false;
        if (StringHelper.compare((String)srcPSDEAction.getCodeName(), (String)dstPSDEAction.getCodeName(), (boolean)false) != 0) {
            dstPSDEAction.setCodeName(srcPSDEAction.getCodeName());
            bUpdate = true;
        }
        if (bUpdate) {
            try {
                this.getPSDevSlnSysModelStorage().update("PSDEACTION", (IEntity)dstPSDEAction);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u540c\u6b65\u5b9e\u4f53\u884c\u4e3a[%1$s][%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", dstPSDataEntity.getPSDataEntityName(), srcPSDEAction.getPSDEActionName(), ex.getMessage()), ex);
            }
        }
        this.mapPSModel("PSDEACTION", srcPSDEAction.getPSDEActionId(), dstPSDEAction);
        return null;
    }
}

