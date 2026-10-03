/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDERBase
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDER1NModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSModuleService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDER1NModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelCloneHelperBak {
    private static final Log log = LogFactory.getLog(PSModelCloneHelperBak.class);
    private PSSystem psSystem = null;
    private SessionFactory srcSessionFactory = null;
    private SessionFactory dstSessionFactory = null;
    private String strDstPSSysModelInstId = null;
    private String strSrcPSSysModelInstId = null;
    private HashMap<String, Integer> existsDEDataMap = new HashMap();
    private HashMap<String, String> cloneDEDataMap = new HashMap();
    private HashMap<String, Integer> cloneDEMap = new HashMap();
    private HashMap<String, Integer> tempDERMap = new HashMap();
    private HashMap<String, Integer> noFKeyDERMap = new HashMap();
    private HashMap<String, Integer> tempDEMap = new HashMap();
    private HashMap<String, String> exportDEMap = new HashMap();
    private HashMap<String, String> cloneDERMap = new HashMap();
    private HashMap<String, String> ignoreDEFMap = new HashMap();
    private long nLastActiveTime = 0L;
    private ArrayList<JSONObject> exportModelList = new ArrayList();
    private HashMap<String, PSModule> exportPSModuleMap = new HashMap();

    public PSModelCloneHelperBak(PSSystem psSystem, SessionFactory srcSessionFactory, SessionFactory dstSessionFactory, String strSrcPSSysModelInstId, String strDstPSSysModelInstId) {
        this.psSystem = psSystem;
        this.srcSessionFactory = srcSessionFactory;
        this.dstSessionFactory = dstSessionFactory;
        this.strSrcPSSysModelInstId = strSrcPSSysModelInstId;
        this.strDstPSSysModelInstId = strDstPSSysModelInstId;
        this.initTempDERMap();
        this.initCloneDEMap();
        this.initCloneDERMap();
    }

    public String cloneSysRef(PSSysRef psSysRef, PSSysSFPub psSysSFPub) throws Exception {
        PSModuleService psModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.srcSessionFactory);
        PSModuleService psModuleService2 = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.dstSessionFactory);
        HashMap<String, PSSysSFPub> psSysSFPubMap = new HashMap<String, PSSysSFPub>();
        boolean bDefaultSysSFPub = false;
        if (psSysSFPub != null) {
            bDefaultSysSFPub = DataObject.getBoolValue((Integer)psSysSFPub.getDefaultPub(), (boolean)true);
            psSysSFPubMap.put(psSysSFPub.getPSSysSFPubId(), psSysSFPub);
            PSSysSFPubService psSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.srcSessionFactory);
            ArrayList<PSSysSFPub> partPSSysSFPubList = psSysSFPubService.selectByPPSSysSFPub((PSSysSFPubBase)psSysSFPub);
            for (PSSysSFPub partPSSysSFPub : partPSSysSFPubList) {
                psSysSFPubMap.put(partPSSysSFPub.getPSSysSFPubId(), psSysSFPub);
            }
        }
        ArrayList<PSModule> psModuleList = psModuleService.selectByPSSystem((PSSystemBase)this.psSystem);
        ArrayList<PSModule> psModuleList2 = psModuleService2.selectByPSSystem((PSSystemBase)this.psSystem);
        HashMap<String, PSModule> psModuleMap = new HashMap<String, PSModule>();
        HashMap<String, PSModule> psModuleMap2 = new HashMap<String, PSModule>();
        for (PSModule psModule2 : psModuleList2) {
            psModuleMap2.put(psModule2.getPSModuleId(), psModule2);
        }
        ArrayList<PSModule> psModuleList3 = new ArrayList<PSModule>();
        for (PSModule psModule : psModuleList) {
            if (DataObject.getBoolValue((Integer)psModule.getSubSysModule(), (boolean)false) || psSysSFPub != null && (StringHelper.isNullOrEmpty((String)psModule.getPSSysSFPubId()) ? !bDefaultSysSFPub : !psSysSFPubMap.containsKey(psModule.getPSSysSFPubId()))) continue;
            psModuleMap.put(psModule.getPSModuleId(), psModule);
            boolean bExists = false;
            if (psModuleMap2.containsKey(psModule.getPSModuleId())) {
                bExists = true;
            }
            psModule.setPSSysSFPubId(null);
            psModule.setPSSysSFPubName(null);
            psModule.setSubSysModule(Integer.valueOf(1));
            psModule.setPSSysRefId(psSysRef.getPSSysRefId());
            psModule.setPSSysRefName(psSysRef.getPSSysRefName());
            psModule.setLockFlag(Integer.valueOf(1));
            if (bExists) {
                psModuleService2.update(psModule, false);
            } else {
                psModuleService2.create(psModule, false);
            }
            psModuleList3.add(psModule);
        }
        String strTag = StringHelper.format((String)"%1$s||%2$s", (Object)"PSSYSTEM", (Object)this.psSystem.getPSSystemId());
        this.existsDEDataMap.put(strTag, 2);
        for (PSModule psModule : psModuleList3) {
            String strTag2 = StringHelper.format((String)"%1$s||%2$s", (Object)"PSMODULE", (Object)psModule.getPSModuleId());
            this.existsDEDataMap.put(strTag2, 0);
            this.exportPSModuleMap.put(psModule.getPSModuleId(), psModule);
        }
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)"PSMODULE");
        PSSysServiceAPIService psSysServiceAPIService2 = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.dstSessionFactory);
        for (PSModule psModule : psModuleList3) {
            for (PSSysServiceAPI psSysServiceAPI : psModule.getPSSysServiceAPIs()) {
                String strTag3 = StringHelper.format((String)"%1$s||%2$s", (Object)"PSSYSSERVICEAPI", (Object)psSysServiceAPI.getPSSysServiceAPIId());
                this.existsDEDataMap.put(strTag3, 1);
                psSysServiceAPIService2.save(psSysServiceAPI);
            }
        }
        PSDataEntityService psDataEntityService2 = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.dstSessionFactory);
        for (PSModule psModule : psModuleList3) {
            ArrayList<PSDataEntity> deList = psModule.getPSDataEntities();
            for (PSDataEntity psDataEntity : deList) {
                String strTag4 = StringHelper.format((String)"%1$s||%2$s", (Object)"PSDATAENTITY", (Object)psDataEntity.getPSDataEntityId());
                if (psDataEntityService2.checkKey(psDataEntity) != 0) continue;
                psDataEntity.resetLNPSLanResId();
                psDataEntity.setDEType(Integer.valueOf(1));
                psDataEntityService2.create(psDataEntity, false);
                this.existsDEDataMap.put(strTag4, 0);
            }
        }
        for (PSModule psModule : psModuleList3) {
            this.cloneDEData(iDataEntityModel, (IEntity)psModule, null, 0, false);
        }
        int nSize = this.exportModelList.size();
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        boolean bError = false;
        DBCallResult dbCallResult = psModuleService2.executeRaw("SET FOREIGN_KEY_CHECKS=0;", null);
        if (dbCallResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u7981\u7528\u6a21\u578b\u5e93\u5916\u952e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)dbCallResult.getErrorInfo()));
        }
        ArrayList<JSONObject> allJsonList = new ArrayList<JSONObject>();
        int nLoopCount = 0;
        while (nLoopCount <= 10 && this.exportModelList.size() > 0) {
            ++nLoopCount;
            allJsonList.addAll(this.exportModelList);
            this.exportModelList.clear();
            while (allJsonList.size() > 0) {
                JSONObject item = (JSONObject)allJsonList.remove(0);
                String strDEId = item.optString("srfdename", "");
                if (StringHelper.isNullOrEmpty((String)strDEId)) {
                    sBuilderEx.append("\u6ca1\u6709\u6307\u5b9a\u5bf9\u5e94\u7684\u6570\u636e\u5bf9\u8c61\r\n");
                    continue;
                }
                this.activePSSysModelInst();
                IService iService = null;
                try {
                    iService = DEModelGlobal.getDEModel((String)strDEId).getService(this.dstSessionFactory);
                    JSONObject joValue = item.optJSONObject("srfvalue");
                    if (joValue != null) {
                        String strCreateOnly = joValue.optString("srfcreateonly", "");
                        IEntity srcEntity = iService.getDEModel().createEntity();
                        IEntity dstEntity = iService.getDEModel().createEntity();
                        DataObject.fromJSONObject((IDataObject)srcEntity, (JSONObject)joValue);
                        boolean bCreateOnly = StringHelper.compare((String)strCreateOnly, (String)"TRUE", (boolean)true) == 0;
                        String strKeyFieldName = iService.getDEModel().getKeyDEField().getName();
                        dstEntity.set(strKeyFieldName, srcEntity.get(strKeyFieldName));
                        if (!iService.get(dstEntity, true)) {
                            dstEntity = null;
                        }
                        if (bCreateOnly && dstEntity != null) continue;
                        this.cloneDEData(iService.getDEModel(), srcEntity, dstEntity, bCreateOnly ? 1 : 3, true, true);
                        continue;
                    }
                    String string = iService.importModel(item);
                }
                catch (Exception ex) {
                    bError = true;
                    if (iService != null) {
                        sBuilderEx.append("[%2$s:%3$s]\u5bfc\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff1a%4$s\r\n%5$s\r\n", (Object)0, (Object)iService.getDEModel().getName(), (Object)iService.getDEModel().getLogicName(), (Object)ex.getMessage(), (Object)item.toString());
                        continue;
                    }
                    sBuilderEx.append("\u5bfc\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff1a%2$s\r\n", (Object)0, (Object)ex.getMessage());
                }
            }
        }
        psModuleService2.executeRaw("SET FOREIGN_KEY_CHECKS=1;", null);
        if (dbCallResult.isError()) {
            sBuilderEx.append("\u542f\u7528\u6a21\u578b\u5e93\u5916\u952e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)dbCallResult.getErrorInfo());
        }
        String strRet = sBuilderEx.toString();
        this.appendLog(strRet);
        return strRet;
    }

    protected void cloneDERData(IDataEntityModel majorDEModel, IDERBase iDER, IEntity majorEntity) throws Exception {
        if (!(iDER instanceof IDER1NModel)) {
            return;
        }
        IDER1NModel iDER1NModel = (IDER1NModel)iDER;
        IDataEntityModel minorDEModel = iDER1NModel.getMinorDEModel();
        if (this.isIgnoreDEModel(minorDEModel)) {
            return;
        }
        SelectContext selectCond = new SelectContext();
        selectCond.set(iDER1NModel.getPickupDEFName(), majorEntity.get(majorDEModel.getKeyDEField().getName()));
        if (!this.fillSelectContext(majorDEModel, iDER1NModel, majorEntity, selectCond)) {
            return;
        }
        IService srcMinorService = minorDEModel.getService(this.srcSessionFactory);
        IService dstMinorService = minorDEModel.getService(this.dstSessionFactory);
        ArrayList<IEntity> srcList = srcMinorService.selectEx((ISelectContext)selectCond);
        ArrayList<IEntity> dstList = dstMinorService.selectEx((ISelectContext)selectCond);
        String strMinorDEKeyName = minorDEModel.getKeyDEField().getName();
        HashMap<String, IEntity> dstEntityMap = new HashMap<String, IEntity>();
        for (IEntity dstEntity : dstList) {
            dstEntityMap.put(DataObject.getStringValue((Object)dstEntity.get(strMinorDEKeyName)), dstEntity);
        }
        for (IEntity srcEntity : srcList) {
            IEntity dstEntity = (IEntity)dstEntityMap.get(DataObject.getStringValue((Object)srcEntity.get(strMinorDEKeyName)));
            if (dstEntity == null) {
                dstEntity = minorDEModel.createEntity();
                dstEntity.set(strMinorDEKeyName, srcEntity.get(strMinorDEKeyName));
                if (!dstMinorService.get(dstEntity, true)) {
                    dstEntity = null;
                }
            }
            this.cloneDEData(minorDEModel, srcEntity, dstEntity, false);
        }
    }

    protected boolean fillSelectContext(IDataEntityModel majorDEModel, IDER1NModel iDER1NModel, IEntity majorEntity, SelectContext selectContext) throws Exception {
        if (StringHelper.compare((String)iDER1NModel.getMinorDEName(), (String)"PSDEUIACTION", (boolean)true) == 0) {
            if (StringHelper.compare((String)iDER1NModel.getMajorDEName(), (String)"PSMODULE", (boolean)true) == 0) {
                selectContext.set("PSWFID", SelectContext.ISNULL);
                selectContext.set("PSDEID", SelectContext.ISNULL);
            }
            return true;
        }
        if (StringHelper.compare((String)iDER1NModel.getMinorDEName(), (String)"PSDEOPPRIV", (boolean)true) == 0) {
            if (StringHelper.compare((String)iDER1NModel.getMajorDEName(), (String)"PSMODULE", (boolean)true) == 0) {
                selectContext.set("PSDEID", SelectContext.ISNULL);
                return true;
            }
            return StringHelper.compare((String)iDER1NModel.getMajorDEName(), (String)"PSDATAENTITY", (boolean)true) == 0;
        }
        if (StringHelper.compare((String)iDER1NModel.getMinorDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0) {
            return StringHelper.compare((String)iDER1NModel.getMajorDEName(), (String)"PSDATAENTITY", (boolean)true) == 0;
        }
        if (StringHelper.compare((String)iDER1NModel.getMinorDEName(), (String)"PSDATAENTITY", (boolean)true) == 0) {
            return StringHelper.compare((String)iDER1NModel.getMajorDEName(), (String)"PSMODULE", (boolean)true) == 0;
        }
        if (StringHelper.compare((String)iDER1NModel.getMinorDEName(), (String)"PSDEFIELD", (boolean)true) == 0) {
            return StringHelper.compare((String)iDER1NModel.getMajorDEName(), (String)"PSDATAENTITY", (boolean)true) == 0;
        }
        return StringHelper.compare((String)iDER1NModel.getMajorDEName(), (String)iDER1NModel.getMinorDEName(), (boolean)true) != 0;
    }

    protected void cloneDEData(IDataEntityModel iDEModel, IEntity srcEntity, IEntity dstEntity, boolean bMust) throws Exception {
        Integer nExportMode = this.cloneDEMap.get(iDEModel.getName());
        if (nExportMode == null) {
            log.error((Object)StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u5bfc\u51fa\u5b9e\u4f53[%1$s]", (Object)iDEModel.getName()));
            this.cloneDEData(iDEModel, srcEntity, dstEntity, 3, bMust);
        } else {
            this.cloneDEData(iDEModel, srcEntity, dstEntity, nExportMode, bMust);
        }
    }

    protected int testCloneDEData(IDataEntityModel iDEModel, IEntity srcEntity, IEntity dstEntity, int nImportMode, boolean bMust) throws Exception {
        if (StringHelper.compare((String)iDEModel.getName(), (String)"PSDATAENTITY", (boolean)true) == 0 && !bMust && dstEntity != null && DataObject.getBoolValue((Object)dstEntity.get("DELOCKFLAG"), (boolean)false)) {
            return -1;
        }
        StringHelper.compare((String)iDEModel.getName(), (String)"PSDEVIEWBASE", (boolean)true);
        if (StringHelper.compare((String)iDEModel.getName(), (String)"PSCODELIST", (boolean)true) == 0) {
            String strSrcPSModuleId;
            if (!bMust && !StringHelper.isNullOrEmpty((String)(strSrcPSModuleId = DataObject.getStringValue((Object)srcEntity.get("PSMODULEID"))))) {
                String strDstPSModuleId = null;
                if (dstEntity != null) {
                    strDstPSModuleId = DataObject.getStringValue((Object)dstEntity.get("PSMODULEID"));
                    if (StringHelper.compare((String)strSrcPSModuleId, (String)strDstPSModuleId, (boolean)true) == 0) {
                        return 3;
                    }
                } else {
                    return nImportMode;
                }
            }
            return nImportMode;
        }
        return nImportMode;
    }

    protected void cloneDEData(IDataEntityModel iDEModel, IEntity srcEntity, IEntity dstEntity, int nImportMode, boolean bMust) throws Exception {
        this.cloneDEData(iDEModel, srcEntity, dstEntity, nImportMode, bMust, false);
    }

    protected void cloneDEData(IDataEntityModel iDEModel, IEntity srcEntity, IEntity dstEntity, int nImportMode, boolean bMust, boolean bImportDataMode) throws Exception {
        boolean bChild = !bMust;
        Object objSrcKey = srcEntity.get(iDEModel.getKeyDEField().getName());
        String strTag = StringHelper.format((String)"%1$s||%2$s", (Object)iDEModel.getName(), (Object)objSrcKey);
        Integer nLastValue = this.existsDEDataMap.get(strTag);
        if (nLastValue != null) {
            if (!bChild && nLastValue >= 1) {
                return;
            }
            if (bChild && nLastValue == 2) {
                return;
            }
        }
        if (this.cloneDEDataMap.containsKey(strTag)) {
            if (bMust) {
                this.appendLog(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6b63\u5728\u514b\u9686[%2$s][%3$s]\uff0c\u5b58\u5728\u9012\u5f52", (Object)iDEModel.getName(), (Object)objSrcKey, (Object)iDEModel.getDataInfo(srcEntity)));
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6b63\u5728\u514b\u9686[%2$s][%3$s]\uff0c\u5b58\u5728\u9012\u5f52", (Object)iDEModel.getName(), (Object)objSrcKey, (Object)iDEModel.getDataInfo(srcEntity)));
            }
            return;
        }
        if ((nImportMode = this.testCloneDEData(iDEModel, srcEntity, dstEntity, nImportMode, bMust)) == -1) {
            return;
        }
        if (nLastValue == null || nLastValue == 0) {
            this.cloneDEDataMap.put(strTag, new Date().toString());
            int nModeLockFlag = -1;
            if (dstEntity != null) {
                nModeLockFlag = DataObject.getIntegerValue((Object)dstEntity.get("LOCKFLAG"), Integer.valueOf(-1));
            }
            if (nModeLockFlag == -1 || (nModeLockFlag & 2) == 0) {
                log.debug((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5f00\u59cb\u8fc1\u79fb[%2$s][%3$s]", (Object)iDEModel.getName(), (Object)objSrcKey, (Object)iDEModel.getDataInfo(srcEntity)));
                this.appendLog(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5f00\u59cb\u8fc1\u79fb[%2$s][%3$s]", (Object)iDEModel.getName(), (Object)objSrcKey, (Object)iDEModel.getDataInfo(srcEntity)));
                boolean bExportMode = false;
                if (nImportMode > 0) {
                    Iterator ders = iDEModel.getDERs(false);
                    if (ders != null) {
                        while (ders.hasNext()) {
                            Object dstFKey;
                            IDER1NModel iDER1NModel;
                            Object srcFKey;
                            Integer nTempDEMode;
                            int nTempOrder;
                            IDERBase iDER = (IDERBase)ders.next();
                            if (!(iDER instanceof IDER1NModel) || (nTempOrder = this.getDERTempOrder(iDER.getId())) >= 0 || this.noFKeyDERMap.containsKey(iDER.getId()) || bImportDataMode && (nTempDEMode = this.tempDEMap.get(iDER.getMajorDEName())) != null && nTempDEMode == 0 || (srcFKey = srcEntity.get((iDER1NModel = (IDER1NModel)iDER).getPickupDEFName())) == null) continue;
                            if (dstEntity != null && (dstFKey = dstEntity.get(iDER1NModel.getPickupDEFName())) != null && DataTypeHelper.compare((int)iDEModel.getDEField(iDER1NModel.getPickupDEFName(), false).getStdDataType(), (Object)srcFKey, (Object)dstFKey) == 0L) {
                                this.markDEDataExists(iDER1NModel.getMajorDEModel(), srcFKey, 0);
                                continue;
                            }
                            if (this.testDEDataExists(iDER1NModel.getMajorDEModel(), srcFKey)) continue;
                            this.cloneDEData(iDER1NModel.getMajorDEModel(), srcFKey, true);
                        }
                    }
                    srcEntity.set("LOCKFLAG", (Object)1);
                    this.activePSSysModelInst();
                    IService dstService = iDEModel.getService(this.dstSessionFactory);
                    if (dstEntity == null) {
                        if ((nImportMode & 1) > 0) {
                            this.appendLog(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6b63\u5728\u5efa\u7acb[%2$s][%3$s]", (Object)iDEModel.getName(), (Object)objSrcKey, (Object)iDEModel.getDataInfo(srcEntity)));
                            EntityBase.setIgnoreCheck((IEntity)srcEntity, (boolean)true);
                            EntityBase.setIgnoreCheckKey((IEntity)srcEntity, (boolean)true);
                            this.removeDEDataIgnoreFields(iDEModel, srcEntity);
                            dstService.create(srcEntity, false);
                            bExportMode = true;
                        }
                    } else if ((nImportMode & 2) > 0) {
                        if (!this.testDEDataSame(iDEModel, srcEntity, dstEntity)) {
                            this.appendLog(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6b63\u5728\u66f4\u65b0[%2$s][%3$s]", (Object)iDEModel.getName(), (Object)objSrcKey, (Object)iDEModel.getDataInfo(srcEntity)));
                            EntityBase.setIgnoreCheck((IEntity)srcEntity, (boolean)true);
                            this.removeDEDataIgnoreFields(iDEModel, srcEntity);
                            dstService.update(srcEntity, false);
                        }
                        bExportMode = true;
                    }
                }
                this.existsDEDataMap.put(strTag, 1);
                this.cloneDEDataMap.remove(strTag);
                if (bExportMode && this.isDEModelExportModel(iDEModel) && (dstEntity == null || !this.testDEDataModelSame(iDEModel, srcEntity, dstEntity))) {
                    IService srcService = iDEModel.getService(this.srcSessionFactory);
                    srcService.exportModel(srcEntity, this.exportModelList, PSCoreSysServiceBase.PSMODEL_EXPORTMODE | 0x10000 | 8 | 0x20);
                }
            } else {
                this.existsDEDataMap.put(strTag, 1);
                this.cloneDEDataMap.remove(strTag);
            }
        }
        if (bChild && !bImportDataMode) {
            this.existsDEDataMap.put(strTag, 2);
            Iterator ders = iDEModel.getDERs(true);
            if (ders != null) {
                while (ders.hasNext()) {
                    IDERBase iDER = (IDERBase)ders.next();
                    if (this.getDERTempOrder(iDER.getId()) != -1 || !this.cloneDERMap.containsKey(iDER.getId())) continue;
                    this.cloneDERData(iDEModel, iDER, srcEntity);
                }
            }
        }
    }

    protected void cloneDEData(IDataEntityModel iDEModel, Object objKey, boolean bMust) throws Exception {
        this.activePSSysModelInst();
        IService srcService = iDEModel.getService(this.srcSessionFactory);
        IEntity srcEntity = iDEModel.createEntity();
        srcEntity.set(iDEModel.getKeyDEField().getName(), objKey);
        srcService.get(srcEntity);
        String strPSModuleId = DataObject.getStringValue((Object)srcEntity.get("psmoduleid"));
        if (!StringHelper.isNullOrEmpty((String)strPSModuleId) && !this.exportPSModuleMap.containsKey(strPSModuleId)) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s][%2$s]\u6307\u5b9a\u4e86\u6ca1\u6709\u540c\u6b65\u7684\u6a21\u5757", (Object)iDEModel.getName(), (Object)iDEModel.getDataInfo(srcEntity)));
        }
        this.cloneDEData(iDEModel, srcEntity, null, bMust);
    }

    protected void markDEDataExists(IDataEntityModel iDEModel, Object objKey, int nExistValue) {
        String strTag = StringHelper.format((String)"%1$s||%2$s", (Object)iDEModel.getName(), (Object)objKey);
        Integer nLastValue = this.existsDEDataMap.get(strTag);
        if (nLastValue != null && nExistValue < nLastValue) {
            return;
        }
        this.existsDEDataMap.put(strTag, nExistValue);
    }

    protected boolean testDEDataExists(IDataEntityModel iDEModel, Object objKey) throws Exception {
        String strTag = StringHelper.format((String)"%1$s||%2$s", (Object)iDEModel.getName(), (Object)objKey);
        if (this.existsDEDataMap.containsKey(strTag)) {
            return true;
        }
        this.activePSSysModelInst();
        IService dstService = iDEModel.getService(this.dstSessionFactory);
        IEntity dstEntity = iDEModel.createEntity();
        dstEntity.set(iDEModel.getKeyDEField().getName(), objKey);
        if (dstService.checkKey(dstEntity) == 1) {
            this.markDEDataExists(iDEModel, objKey, 0);
            return true;
        }
        if (this.isIgnoreDEModel(iDEModel)) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5ffd\u7565\u8fc1\u79fb\uff0c\u4f46\u9700\u8981\u6570\u636e[%2$s]", (Object)iDEModel.getName(), (Object)objKey));
        }
        return false;
    }

    protected boolean testDEDataSame(IDataEntityModel iDEModel, IEntity srcEntity, IEntity dstEntity) throws Exception {
        this.activePSSysModelInst();
        Iterator deFields = iDEModel.getDEFields();
        if (deFields != null) {
            while (deFields.hasNext()) {
                IDEField iDEField = (IDEField)deFields.next();
                if (!iDEField.isPhisicalDEField() || this.ignoreDEFMap.containsKey(iDEField.getId()) || StringHelper.compare((String)iDEField.getName(), (String)"CREATEMAN", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getName(), (String)"CREATEDATE", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getName(), (String)"UPDATEMAN", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getName(), (String)"UPDATEDATE", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getName(), (String)"MODELSTATE", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getName(), (String)"PSSYSTEMNAME", (boolean)true) == 0) continue;
                Object objValue1 = srcEntity.get(iDEField.getName());
                Object objValue2 = dstEntity.get(iDEField.getName());
                if (objValue1 == null && objValue2 == null) continue;
                if (StringHelper.compare((String)iDEField.getName(), (String)"VALIDFLAG", (boolean)true) == 0) {
                    if (objValue1 == null) {
                        objValue1 = 1;
                    }
                    if (objValue2 == null) {
                        objValue2 = 1;
                    }
                }
                if (DataTypeHelper.compare((int)iDEField.getStdDataType(), (Object)objValue1, (Object)objValue2) == 0L) continue;
                return false;
            }
        }
        return true;
    }

    protected void removeDEDataIgnoreFields(IDataEntityModel iDEModel, IEntity srcEntity) throws Exception {
        Iterator deFields = iDEModel.getDEFields();
        if (deFields != null) {
            while (deFields.hasNext()) {
                IDEField iDEField = (IDEField)deFields.next();
                if (!this.ignoreDEFMap.containsKey(iDEField.getId())) continue;
                srcEntity.remove(iDEField.getName());
            }
        }
    }

    protected boolean testDEDataModelSame(IDataEntityModel iDEModel, IEntity srcEntity, IEntity dstEntity) throws Exception {
        this.activePSSysModelInst();
        int nExportMode = PSCoreSysServiceBase.PSMODEL_EXPORTMODE | 0x40 | 0x10000 | 8 | 0x20 | 0x80;
        ActionSessionManager.openSession(null, (boolean)false);
        ArrayList<JSONObject> list2 = new ArrayList<JSONObject>();
        iDEModel.getService(this.srcSessionFactory).exportModel(srcEntity, list2, nExportMode);
        ActionSessionManager.closeSession((boolean)false);
        ActionSessionManager.openSession(null, (boolean)false);
        ArrayList<JSONObject> list3 = new ArrayList<JSONObject>();
        iDEModel.getService(this.dstSessionFactory).exportModel(dstEntity, list3, nExportMode);
        ActionSessionManager.closeSession((boolean)false);
        return this.testPSModel(list2, list3);
    }

    protected boolean testPSModel(ArrayList<JSONObject> list2, ArrayList<JSONObject> list3) {
        if (list2.size() != list3.size()) {
            return false;
        }
        int i = 0;
        while (i < list2.size()) {
            JSONObject jo2 = list2.get(i);
            JSONObject jo3 = list3.get(i);
            if (StringHelper.compare((String)jo2.toString(), (String)jo3.toString(), (boolean)false) != 0) {
                return false;
            }
            ++i;
        }
        return true;
    }

    protected boolean isDEModelExportModel(IDataEntityModel iDEModel) {
        return this.exportDEMap.containsKey(iDEModel.getName());
    }

    protected boolean isIgnoreDEModel(IDataEntityModel iDEModel) {
        return !this.cloneDEMap.containsKey(iDEModel.getName());
    }

    protected int getDERTempOrder(String strDERId) {
        Integer nOrder = this.tempDERMap.get(strDERId);
        if (nOrder == null) {
            return -1;
        }
        return nOrder;
    }

    protected void activePSSysModelInst() {
        if (this.nLastActiveTime == 0L || System.currentTimeMillis() - this.nLastActiveTime >= 5000L) {
            PSSysModelInstGlobal.active((String)this.strSrcPSSysModelInstId);
            PSSysModelInstGlobal.active((String)this.strDstPSSysModelInstId);
            this.nLastActiveTime = System.currentTimeMillis();
        }
    }

    protected void appendLog(String strInfo) {
    }

    protected void initCloneDEMap() {
        this.cloneDEMap.put("PSDATAENTITY", 3);
        this.cloneDEMap.put("PSCODELIST", 3);
        this.cloneDEMap.put("PSSYSCOUNTER", 3);
        this.cloneDEMap.put("PSSYSPFPLUGIN", 3);
        this.cloneDEMap.put("PSACHANDLER", 3);
        this.cloneDEMap.put("PSSUBVIEWTYPE", 3);
        this.cloneDEMap.put("PSSYSVIEWLOGIC", 3);
        this.cloneDEMap.put("PSSUBSYSSERVICEAPI", 3);
        this.cloneDEMap.put("PSSYSDYNAMODEL", 3);
        this.cloneDEMap.put("PSWORKFLOW", 3);
        this.cloneDEMap.put("PSSYSSERVICEAPI", 3);
        this.cloneDEMap.put("PSWFROLE", 3);
        this.cloneDEMap.put("PSSYSERMAP", 3);
        this.cloneDEMap.put("PSSYSBDSCHEME", 3);
        this.cloneDEMap.put("PSWXACCOUNT", 3);
        this.cloneDEMap.put("PSDEUAGROUP", 3);
        this.cloneDEMap.put("PSDEUIACTION", 3);
        this.cloneDEMap.put("PSLANGUAGERES", 1);
        this.cloneDEMap.put("PSLANGUAGEITEM", 1);
        this.cloneDEMap.put("PSSYSPDTVIEW", 3);
        this.cloneDEMap.put("PSDETOOLBAR", 3);
        this.cloneDEMap.put("PSSYSPORTLET", 3);
        this.cloneDEMap.put("PSSYSDASHBOARD", 3);
        this.cloneDEMap.put("PSSYSSFPLUGIN", 3);
        this.cloneDEMap.put("PSSYSEDITORSTYLE", 3);
        this.cloneDEMap.put("PSSYSIMAGE", 3);
        this.cloneDEMap.put("PSSYSCSSCAT", 3);
        this.cloneDEMap.put("PSSYSCSS", 3);
        this.cloneDEMap.put("PSDEOPPRIV", 3);
        this.cloneDEMap.put("PSSYSUNISTATE", 3);
        this.cloneDEMap.put("PSSYSUNIT", 3);
        this.cloneDEMap.put("PSSYSUNIRES", 3);
        this.cloneDEMap.put("PSDEACTIONTEMPL", 3);
        this.cloneDEMap.put("PSDEFINPUTTIPSET", 3);
        this.cloneDEMap.put("PSDEFINPUTTIP", 3);
        this.cloneDEMap.put("PSSYSDELOGICNODE", 3);
        this.cloneDEMap.put("PSCODELIST", 3);
        this.cloneDEMap.put("PSDER", 3);
        this.cloneDEMap.put("PSDEDBCFG", 3);
        this.cloneDEMap.put("PSDEFIELD", 3);
        this.cloneDEMap.put("PSACHANDLER", 3);
        this.cloneDEMap.put("PSDEDATAQUERY", 3);
        this.cloneDEMap.put("PSDEACTION", 3);
        this.cloneDEMap.put("PSDEUIACTION", 3);
        this.cloneDEMap.put("PSDELOGIC", 3);
        this.cloneDEMap.put("PSDEFSFITEM", 3);
        this.cloneDEMap.put("PSDEDATAEXP", 3);
        this.cloneDEMap.put("PSDEDATASET", 3);
        this.cloneDEMap.put("PSDEDRGROUP", 3);
        this.cloneDEMap.put("PSDEACMODE", 3);
        this.cloneDEMap.put("PSDEUAGROUP", 3);
        this.cloneDEMap.put("PSDEFVALUERULE", 3);
        this.cloneDEMap.put("PSDEMAINSTATE", 3);
        this.cloneDEMap.put("PSDEACTIONLOGIC", 3);
        this.cloneDEMap.put("PSDEDRITEM", 3);
        this.cloneDEMap.put("PSDEFORM", 3);
        this.cloneDEMap.put("PSDEGRID", 3);
        this.cloneDEMap.put("PSDEDATAVIEW", 3);
        this.cloneDEMap.put("PSWFDE", 3);
        this.cloneDEMap.put("PSDETREEVIEW", 3);
        this.cloneDEMap.put("PSDECHART", 3);
        this.cloneDEMap.put("PSDELIST", 3);
        this.cloneDEMap.put("PSDEDATARELATION", 3);
        this.cloneDEMap.put("PSDEOPPRIV", 3);
        this.cloneDEMap.put("PSDEVIEWBASE", 3);
        this.exportDEMap.put("PSDEDATAQUERY", "");
        this.exportDEMap.put("PSDEDATASET", "");
        this.exportDEMap.put("PSDEGRID", "");
        this.exportDEMap.put("PSDEFORM", "");
        this.exportDEMap.put("PSDELIST", "");
        this.exportDEMap.put("PSDETREEVIEW", "");
        this.exportDEMap.put("PSDEDATAVIEW", "");
        this.exportDEMap.put("PSDEWIZARD", "");
        this.exportDEMap.put("PSWFVERSION", "");
        this.exportDEMap.put("PSCODELIST", "");
        this.exportDEMap.put("PSDEUAGROUP", "");
        this.exportDEMap.put("PSDEDATARELATION", "");
        this.exportDEMap.put("PSDELOGIC", "");
        this.exportDEMap.put("PSSYSERMAP", "");
        this.exportDEMap.put("PSDEFVALUERULE", "");
        this.exportDEMap.put("PSDETOOLBAR", "");
        this.exportDEMap.put("PSDEVIEWBASE", "");
        this.exportDEMap.put("PSDECHART", "");
        this.exportDEMap.put("PSDEACMODE", "");
        this.exportDEMap.put("PSDEMAINSTATE", "");
        this.exportDEMap.put("PSDEDBINDEX", "");
        this.exportDEMap.put("PSDEREPORT", "");
        this.exportDEMap.put("PSSYSTESTCASE", "");
        this.exportDEMap.put("PSSYSTESTDATA", "");
        this.exportDEMap.put("PSVIEWMSGGROUP", "");
        this.exportDEMap.put("PSCTRLMSG", "");
        this.exportDEMap.put("PSDEACTIONWIZARD", "");
        this.exportDEMap.put("PSDEAWGROUP", "");
        this.exportDEMap.put("PSWXMENU", "");
        this.exportDEMap.put("PSDERTAW", "");
        this.exportDEMap.put("PSSYSVIEWPANEL", "");
        this.exportDEMap.put("PSSYSSEARCHBAR", "");
        this.exportDEMap.put("PSSYSDASHBOARD", "");
        this.exportDEMap.put("PSDEDATAIMP", "");
        this.exportDEMap.put("PSDEACTION", "");
        this.exportDEMap.put("PSSYSPFPLUGIN", "");
        this.exportDEMap.put("PSSYSSFPLUGIN", "");
        this.cloneDEMap.put("PSCODELIST", 1);
        this.cloneDEMap.put("PSWORKFLOW", 3);
        this.cloneDEMap.put("PSWFVERSION", 3);
        this.cloneDEMap.put("PSDYNAWFVER", 3);
        this.cloneDEMap.put("PSDYNAWF", 3);
        this.cloneDEMap.put("PSDYNASYS", 3);
        this.cloneDEMap.put("PSDYNAINST", 3);
        this.cloneDEMap.put("PSDYNACODELIST", 3);
        this.cloneDEMap.put("PSSYSVALUERULE", 3);
        this.cloneDEMap.put("PSDEWIZARD", 3);
        this.cloneDEMap.put("PSDEFFORMITEM", 3);
        this.cloneDEMap.put("PSSYSMSGTEMPL", 3);
        this.cloneDEMap.put("PSDEREPORT", 3);
        this.cloneDEMap.put("PSDEPRINT", 3);
        this.cloneDEMap.put("PSSYSDICTCAT", 3);
        this.cloneDEMap.put("PSDEFDTCOL", 3);
        this.cloneDEMap.put("PSSYSDYNAMODEL", 3);
        this.cloneDEMap.put("PSSYSUSERDR", 3);
        this.cloneDEMap.put("PSSYSUSERMODE", 3);
        this.cloneDEMap.put("PSSYSOPPRIV", 3);
        this.cloneDEMap.put("PSSYSWFMODE", 3);
    }

    protected void initCloneDERMap() {
        this.cloneDERMap.put("c0b07d9ee7f3f312e9beca5cd9116f99", "PSPFCTDetails");
        this.cloneDERMap.put("aa1b48cf2088e3600947003c3005b63e", "PSPFCtrlTempls");
        this.cloneDERMap.put("927908535e90a1f7da30d75f6ab39fd2", "PSPFPubCodes");
        this.cloneDERMap.put("0b3b3c378b3e06773910d8994bc6cc9e", "PSPFStyleCodes");
        this.cloneDERMap.put("aa3625eaee88165e9c45c84f41cd2de1", "PSPFUATempls");
        this.cloneDERMap.put("56938180335de454edfa61562ca7de10", "PSPFViewTempls");
        this.cloneDERMap.put("8120824ecfc7ba66cf60c9e2935bb2d3", "PSSFCodeTempls");
        this.cloneDERMap.put("93fb71aef563fb827827627d00c729d7", "PSSFStyles");
        this.cloneDERMap.put("2b450b115e9ea1ce1ac7953b3592a640", "PSViewTypeLogics");
        this.cloneDERMap.put("177d1ec2a5ccfebc1f674fd3b1e380e1", "PSVTCtrls");
        this.cloneDERMap.put("fc3a21d22a958f7dc4fa0c60c4394895", "PSVTRVs");
        this.cloneDERMap.put("aad3b5bba699e298f8bb410cb0aa37f3", "PSACHandlers");
        this.cloneDERMap.put("b5aaf7870a1523c0e501ffcf8c1a62be", "PSCodeLists");
        this.cloneDERMap.put("bf54aae966df530deca94435f3940f40", "PSCodeItems");
        this.cloneDERMap.put("a59eda0aa3fc04754faef6c19165ab72", "PSCodeItems");
        this.cloneDERMap.put("8f3f152d4628a6d65908c70c1c91d07c", "PSDataEntities");
        this.cloneDERMap.put("05e2e0fba1fc871885a620123f45f8ee", "PSDEFields");
        this.cloneDERMap.put("f2235f6295a508d4b4d7e03c2c230c0d", "PSDEFields");
        this.cloneDERMap.put("5d3d677fddd6715016044774f4c48e14", "PSDEFields");
        this.cloneDERMap.put("c645660668957b44ef9928a980f1c998", "MinorPSDERs");
        this.cloneDERMap.put("f4a2e208f556f71f3800dcb284d6def4", "MajorPSDERs");
        this.cloneDERMap.put("57d9285e5dfafc9fa43072a38e592bdb", "PSDEDBCfgs");
        this.cloneDERMap.put("ca3e1ef2b1a01356741ae71ad346ca9a", "PSDEDataSets");
        this.cloneDERMap.put("b4dad0520ab7c5761a0acbf3699239f2", "PSDEDataQuerys");
        this.cloneDERMap.put("7049f941c7126449197b6996593122a6", "PSDEFDTCols");
        this.cloneDERMap.put("968ebeec119a7a74fb5a49ad7e8a96f8", "PSDEDSDQs");
        this.cloneDERMap.put("5e13fb82f92c9c6c273736f5783c8dee", "PSDEOPPrivs");
        this.cloneDERMap.put("30038b27ba99fa5aef4791a22935026e", "PSDCSyncDatas");
        this.cloneDERMap.put("9630767360e31314739e43ee8624e819", "PSDEFValueRules");
        this.cloneDERMap.put("88b3772409142b3b6f3e8ab957f13e7f", "PSDEFVRConds");
        this.cloneDERMap.put("c4aa8337c015c15c51ad06cb04e42042", "PSDEFVRConds");
        this.cloneDERMap.put("1932eba8aa9e00845d69f11043599241", "PSDEActions");
        this.cloneDERMap.put("c08abdb2e9802f2785affb39fe9903ec", "PSDEUIActions");
        this.cloneDERMap.put("5fad628b9b8e6481569b0ab10908af61", "PSDEDataRelations");
        this.cloneDERMap.put("642540d22524d9f0390c7a2f34e338d4", "PSDEDRItems");
        this.cloneDERMap.put("be8ed2213ae7649e9e977e4c244af90a", "PSDEDRItems");
        this.cloneDERMap.put("b244fabe5b0be49031d9d7f2189efcd9", "PSDELogicNodes");
        this.cloneDERMap.put("f0913472520e0daa49ec784e9e5ec160", "PSDELogicLinks");
        this.cloneDERMap.put("146ac0c160ea893ef88845a656fa79b9", "PSDEActionLogics");
        this.cloneDERMap.put("e0fc7594e8afe12dda1d60b7756ed284", "PSDEDRGroups");
        this.cloneDERMap.put("31f65ffb0590572ba043f849ff638a03", "PSDEDRDetails");
        this.cloneDERMap.put("cb03d572d83d85b1b506a2e66616107b", "PSDEForms");
        this.cloneDERMap.put("cab3e8085cc701406d1a110919407eec", "PSDEFormDetails");
        this.cloneDERMap.put("7d30e9782a125fec8be8c4ec53f5aff7", "PSDEFormDetails");
        this.cloneDERMap.put("3ca7018d91cfcf9716f432ff199efd25", "PSDEFUIModes");
        this.cloneDERMap.put("255cd329d4de15c68eefaf4840fced36", "PSDEFSFItems");
        this.cloneDERMap.put("184d4db7f04cc7815a2c7f4d9e93b6a1", "PSDEToolbars");
        this.cloneDERMap.put("685daa0b0f0f5dfbf418cc8cb637904e", "PSDETBItems");
        this.cloneDERMap.put("a10dcb71c14c90f4d39812f266ede604", "PSDETBItems");
        this.cloneDERMap.put("aa053f2771d668b4b86f29e79ac593aa", "PSDEGrids");
        this.cloneDERMap.put("9581642336ea3b518070c0d7aec80694", "PSDEGridCols");
        this.cloneDERMap.put("fd7474752223f39d5c6570dce8fcf063", "PSDEACModes");
        this.cloneDERMap.put("e4d10b18600318eabac2bf35a72b6360", "PSDEViewBases");
        this.cloneDERMap.put("997691c3f441a97448c59c92d9a00e41", "PSDEListItems");
        this.cloneDERMap.put("fed06ace7c963deecc3c306794606c92", "PSDEViewCtrls");
        this.cloneDERMap.put("ef23b1e790118ce1667b3d229aee161d", "PSSysApps");
        this.cloneDERMap.put("581fb196fe5071265ff10b93749ef751", "PSAppModules");
        this.cloneDERMap.put("e20198a6bf48305a07851bc0b1551d58", "PSAppViews");
        this.cloneDERMap.put("f27d6f6b603e0b7c97bba255f53967d8", "PSAppViews");
        this.cloneDERMap.put("238f6b4af67ae1a78fb4576238a14ecc", "PSAppFuncs");
        this.cloneDERMap.put("2d043f69fa09949b00b8cd4e18d11366", "PSAppMenus");
        this.cloneDERMap.put("bacff9a9a013435f76d82c54594761eb", "PSAppMenuItems");
        this.cloneDERMap.put("c0619852a5cf1846f55c83979bfd7f73", "PSAppMenuItems");
        this.cloneDERMap.put("f29bf03ed9f49d5daf1fd60aa4d820a2", "PSAppEditorTempls");
        this.cloneDERMap.put("963250fc46559e75c0cfb73ab7426f11", "PSAppViewCodes");
        this.cloneDERMap.put("9880b0c41542ab4009265a5d61d5d1a6", "PSSysSFPubs");
        this.cloneDERMap.put("084f4a51e7783ce35c51dc41c3f475a5", "PSSysSFCodes");
        this.cloneDERMap.put("0d1967ef6b28b64042ab3de829522102", "PSDEFDLogics");
        this.cloneDERMap.put("2a6b622d4efa8bcb0a3573b7c269c457", "PSDEFDLogics");
        this.cloneDERMap.put("94ab233ca60b50ab4e8bed7281b09fc7", "UserRoleDetails");
        this.cloneDERMap.put("69dd4938ca5d156b83ad800325f667fb", "PSDELogics");
        this.cloneDERMap.put("8972cac830827cf4e43e172ceb236ffd", "PSDELogicParams");
        this.cloneDERMap.put("53346b39fd5d2b53828e8583b7061ad0", "PSDELLConds");
        this.cloneDERMap.put("d8062c4478202541faf15e16389c5acf", "PSDELLConds");
        this.cloneDERMap.put("0628c1e44041b3b1fc37becd5dcfd725", "PSDELNParams");
        this.cloneDERMap.put("331c09fe8fbffabfccd5fdb1c078241a", "PSDEFIUpdates");
        this.cloneDERMap.put("e7fbf2b27129c05721de8110d6530be5", "PSDEFIDetails");
        this.cloneDERMap.put("117310544bc0f139144381a93e3ff60e", "PSDEUAGroups");
        this.cloneDERMap.put("67673cf1f9b0ed2efe60a22eb1bfca1d", "PSDEUAGrpDetails");
        this.cloneDERMap.put("d5f06221fddd8b63e4634c2e30d75779", "PSSysModelChgLogs");
        this.cloneDERMap.put("b2a24885df8b7571c2086089013acebe", "PSDEDataViews");
        this.cloneDERMap.put("db6f388455c1287f26b1f9a98a6a2582", "SrcPSDEMaps");
        this.cloneDERMap.put("30fbbce69efb661e63af2f76d82da392", "PSDEMaps");
        this.cloneDERMap.put("868e682017b7197e1bf33b0e9640294f", "PSDEMaps");
        this.cloneDERMap.put("a6a22267e01727cc96f1da67a673d51b", "PSDEMaps");
        this.cloneDERMap.put("9dfc57cef71b334b3a50a36d13df68e5", "PSDEMapDetails");
        this.cloneDERMap.put("3d7add6660597f13aca979ef62d744b8", "PSSysIssues");
        this.cloneDERMap.put("3fbd73d1811108c5631936a65761b473", "PSWFLinks");
        this.cloneDERMap.put("31e9fa582d8b7a6b56d7f4e698d9dbf8", "PSWFLinkConds");
        this.cloneDERMap.put("3f992286ba153e4b6047230dd5c52b11", "PSWFLinkConds");
        this.cloneDERMap.put("f404066b3f5ec4c98f84ecf04ca566bb", "PSWFDEs");
        this.cloneDERMap.put("f74f2fb95dafaccc1fdfcd87db40b66c", "PSWFProcesses");
        this.cloneDERMap.put("840eed7556a855ee912abf9a48b451a6", "PSWFProcSubWFs");
        this.cloneDERMap.put("50760c080ef1dbc9b792899b0ca1feaf", "PSWorkflows");
        this.cloneDERMap.put("542ac9d7816274c8376ea9a4ef5f5905", "PSWFVersions");
        this.cloneDERMap.put("953246ccf34995d60914dba8ffa71642", "PSWFDEs");
        this.cloneDERMap.put("f124a5698ff64827635172abbff02a58", "PSWFProcRoles");
        this.cloneDERMap.put("7cd4018187709c9774b25f1528270e5b", "PSWFLinkRoles");
        this.cloneDERMap.put("9b04b646798228f7400d7c0f040d03f8", "PSWFProcParams");
        this.cloneDERMap.put("6c36114b79d453184b7384d7c9e771d5", "PSDETreeViews");
        this.cloneDERMap.put("bac8becb9aa731d643ae8f4d30669320", "PSDETreeNodes");
        this.cloneDERMap.put("f1d3c680d7e916388f7a9bbbc4426886", "PSDEViewBases");
        this.cloneDERMap.put("f3161804db8043e7d28005b205beb2d3", "PSDEUAGroups");
        this.cloneDERMap.put("488cdfe3eb915229626c7e336e7854ab", "PSDEUIActions");
        this.cloneDERMap.put("4d134b5820322e294d2ecfed6fd24a85", "PSDEPrints");
        this.cloneDERMap.put("479c9c7ef215824c64fe436041604d2b", "PSDECharts");
        this.cloneDERMap.put("19e3dfc8d54c24715fe5537d809a14aa", "PSSysUtilDEs");
        this.cloneDERMap.put("232ec21da0825c1235e3958500e0ba67", "PSDELists");
        this.cloneDERMap.put("2c4007d1bb8584356ce9b4c3ce425cc7", "PSDEFSFItems");
        this.cloneDERMap.put("447aa4e53b9b61c6e184f75823ca7f50", "PSPFEditorTempls");
        this.cloneDERMap.put("f83cf7139f56bb141e1558bad4b8f18f", "PSAppUserModes");
        this.cloneDERMap.put("4386cd0d4bf6771928d9dd7c32287853", "PSSubSysSFs");
        this.cloneDERMap.put("8a005259438563b19841fe51b5bee1af", "PSSubApps");
        this.cloneDERMap.put("7005865287b8ca4578a65638a66d77ab", "PSDevSlnSyss");
        this.cloneDERMap.put("c06eda010f695b827b1fdd654400b16a", "PSSysDMItems");
        this.cloneDERMap.put("3a495d1648bf5af28c81902b2ebee167", "PSSysDevBKTasks");
        this.cloneDERMap.put("04dfb27d5cadf18f12d7cec5dee43a64", "PSDevSlnUsers");
        this.cloneDERMap.put("eec8c7470fa3a220924caf9a81758606", "PSDepSlns");
        this.cloneDERMap.put("2ecb2de79b02cc6bf57002c59509b5c9", "PSDEACModeItems");
        this.cloneDERMap.put("390acbe746000ad7b44e375375d14054", "PSDEFValueRules");
        this.cloneDERMap.put("78f5e8ce117439c97ab4088fd102f189", "PSDEMainStates");
        this.cloneDERMap.put("101b8644ef38fc76698a0d9b9dd40ebc", "PSDEMSActions");
        this.cloneDERMap.put("ae9efdbea9e3f84a85cb2f85acd70599", "PSSysPFPITempls");
        this.cloneDERMap.put("09981b31bb5e1979f90c2bda60e4abf1", "PSCodeLists");
        this.cloneDERMap.put("261dc528f22be749a2d901eb4eb68a85", "PSSysCounters");
        this.cloneDERMap.put("7bdc5fe0a29571a6dd7a8153b69345f0", "PSSysPFPlugins");
        this.cloneDERMap.put("abcef273470617f7d1eb21531a8a8977", "PSACHandlers");
        this.cloneDERMap.put("5ced1ffd8982dd5b1adb13f383f4bfa2", "PSAppUtilPages");
        this.cloneDERMap.put("f8d83f112cc2496684b3d9f6ee492d1e", "PSSubViewTypes");
        this.cloneDERMap.put("4f6c715081d8c1af99a51538af1d8d2d", "PSAppUIThemes");
        this.cloneDERMap.put("0e11cc5a37e78f0c654d053d629ad09f", "PSDEActionLogics");
        this.cloneDERMap.put("424e5ed5119e3b6e3f06e4ff6c5fa738", "DstPSDEActionLogics");
        this.cloneDERMap.put("8d45afedc414a6308a9a020629449204", "PSDEDataExps");
        this.cloneDERMap.put("34af8d5feaa7d9b1701df011b121baef", "PSDEDataImps");
        this.cloneDERMap.put("9dd9bdc9c1bcaf06082b75223adf20db", "PSDEDBIndexs");
        this.cloneDERMap.put("76db4a5e50d896617743a85e7f3bc0ac", "PSDEReports");
        this.cloneDERMap.put("ba2d14b989573b7e3f6433372bf6b32c", "PSDEOPPrivs");
        this.cloneDERMap.put("0146dd9688efab56a4028484671b6927", "PSSysViewLogics");
        this.cloneDERMap.put("fe70205f264fdebbeaec94858e1bbe10", "PSDEListItem");
        this.cloneDERMap.put("c9548aa3fab5f81ff66cd9125daa1f40", "PSSysTestCases");
        this.cloneDERMap.put("7097cf0b71dc90cea69e1b56e61f95fc", "PSSysTestCases");
        this.cloneDERMap.put("7df7a18f42ef99e0b1ccb13b6a1f756b", "PSSysTestCases");
        this.cloneDERMap.put("ba6385e2a1ef289cacc2403e0b6f99b0", "PSSysTestDatas");
        this.cloneDERMap.put("8d980bdd54170a84622fee388afeae55", "PSSFVerCodeItems");
        this.cloneDERMap.put("ff31864fbf99f316310e7bdcd9560e69", "PSSFVerCodes");
        this.cloneDERMap.put("91860e5e82a462eb117688d8f84a2976", "PSDERDEFMaps");
        this.cloneDERMap.put("c38c7bdf6fdc01a7a553deb5d6a51288", "PSDCMTDEFs");
        this.cloneDERMap.put("6c85b606643bc5e39ec5492c6bd10846", "PSSysERMapNodes");
        this.cloneDERMap.put("68997303d914c9b63a73ffe0520005bf", "PSSysCounters");
        this.cloneDERMap.put("694d9e64a8f851a05507c856cc367b03", "PSSFStylePrjs");
        this.cloneDERMap.put("f3f8ddf28f6945048187c043b9f64419", "PSPFStylePrjs");
        this.cloneDERMap.put("1ba0a2fbc8ce063d90c11913482f685c", "PSDEGEIUpdates");
        this.cloneDERMap.put("4f201bc2830257138f0d4d5095b4fe43", "PSDEGEIDetails");
        this.cloneDERMap.put("3557e4284f3dd71ff85bf8fea3949978", "PSDataEntities");
        this.cloneDERMap.put("deb02cf71855d3221f9331614d431cc5", "PSDEDataSyncs");
        this.cloneDERMap.put("cc38df389f595a174c094e8375c95166", "PSSysReqItems");
        this.cloneDERMap.put("1e5d0bdb89b3122b11a3392917c1729c", "PSDEWizards");
        this.cloneDERMap.put("fb8eb0acb8a0e82f7451dff964505550", "PSDEWizardSteps");
        this.cloneDERMap.put("49c24078f038666c2c725ffcb1904d2d", "PSLanguageItems");
        this.cloneDERMap.put("ef66309d7f46d5981e1e40b397eb1307", "PSViewMsgGrpDetails");
        this.cloneDERMap.put("6543cef4779914c22e5bfd313ad7dcef", "PSSysBDTableDEs");
        this.cloneDERMap.put("c2ffcdb3ba6963c66ff4f7a3ec0d090c", "PSSysBDColumns");
        this.cloneDERMap.put("1957aff4d86e6104506745ac24ed16f6", "PSSysBDColSets");
        this.cloneDERMap.put("15f29316c9970ab8ea44abe58782b9d2", "PSSysBDTables");
        this.cloneDERMap.put("1869542748c8d8de7b1879e0c05cbf7c", "PSSysBDTables");
        this.cloneDERMap.put("2fe7e8bb22830c8ed5024a974f18a9e6", "PSSysBDParts");
        this.cloneDERMap.put("4b1a26f0ec10d1b328243ee7316049fb", "PSSysTasks");
        this.cloneDERMap.put("75b5e23f705c37868554a3f94b2d30cf", "PSSysTasks");
        this.cloneDERMap.put("88d5a3daeb6afe6ff33e8c0f9fdb6623", "PSSysTasks");
        this.cloneDERMap.put("b177a534d26e140992351571d680322d", "PSSysReqItemHises");
        this.cloneDERMap.put("313f1ab8602b217b7958cbad1614e0b3", "PSSysReqItemDatas");
        this.cloneDERMap.put("218ac5a0d3478488d475d3a2d7b25e0b", "PSSysTaskDatas");
        this.cloneDERMap.put("5178f71b2300ce736f8c06c4ab595010", "PSCtrlMsgItems");
        this.cloneDERMap.put("b70f56be5925acc9e4a72de2ebb8988b", "PSDEFInputTips");
        this.cloneDERMap.put("13d13e771095f5b2c0f4d51226d58a78", "PSDEAWs");
        this.cloneDERMap.put("e01bbbd39dad3074f4e0b8ef0a7327df", "PSDEAWItems");
        this.cloneDERMap.put("4078a72ef6b29b7b7bf3a9b314e9d5cb", "PSDEAWGrpDetails");
        this.cloneDERMap.put("d90b6643c32db5960627226f41862f07", "PSDEAWGroups");
        this.cloneDERMap.put("8e7f5ff2952112d82612010095fbdb72", "PSSysPolicyModels");
        this.cloneDERMap.put("fa2823220594638370b4929517e371a0", "PSWXLogics");
        this.cloneDERMap.put("ab2acda92dbeba8336472186d12c0cc2", "PSWXMenuFuncs");
        this.cloneDERMap.put("12f4f9818313cc5959673313f5d7723b", "PSWXMenus");
        this.cloneDERMap.put("dd37f1ce068a48ae4830e3f0def995bd", "PSWXEntApps");
        this.cloneDERMap.put("d70d6ac86c3cc2c34940eeef73d9c1ed", "PSWXLogics");
        this.cloneDERMap.put("781e5440767415fe3ffb0d763035b3b0", "PSWXMenuFuncs");
        this.cloneDERMap.put("7e7ee641819884b8dd17b9ab552a7457", "PSWXMenus");
        this.cloneDERMap.put("1bafc28580978dea10ec07085f3bb1bc", "PSVTSamples");
        this.cloneDERMap.put("e13b5813ae09047edcb0b0e7ac0fd9fa", "PSHelpSections");
        this.cloneDERMap.put("c84014abf5654ebcd17b08be42d7c631", "PSHelpSections");
        this.cloneDERMap.put("11b672379f5c6a643bf638abde8cd76f", "PSHelpArtSecs");
        this.cloneDERMap.put("c9867245d17c72be1031ca2e815da928", "PSModelUIActions");
        this.cloneDERMap.put("af886e38d984f5657bb56f03c1de320f", "PSModelExampleSteps");
        this.cloneDERMap.put("34cf762cf794a6b12de33be70f34e038", "PSModelExampleCats");
        this.cloneDERMap.put("0ccf74506898b431d21775a60d7d556b", "PSModelExamples");
        this.cloneDERMap.put("f37c16692628c00befc02a9449860564", "PSDevSlnSyses");
        this.cloneDERMap.put("61a9e5842f74d441de63492b44c15df3", "PSDCSVNBKs");
        this.cloneDERMap.put("e7b685c8a4882efec000caa7f713cad0", "PSDCDBInstBKs");
        this.cloneDERMap.put("3f14a06c69b4262c90f19f50d4fa614a", "PSDepSlnSysAses");
        this.cloneDERMap.put("f46860d0d9f7c217cf79b81ee053dbb2", "PSSaaSSysVers");
        this.cloneDERMap.put("d3a2e743a0ec1aa4fa933adeb578152e", "PSSaaSSysApps");
        this.cloneDERMap.put("ea799c2127591fb6aa2a00c15078fa70", "PSAppServers");
        this.cloneDERMap.put("9add9659fa628e4abe82a105545f2d05", "PSSaaSSysDBs");
        this.cloneDERMap.put("81a0058e762338bf19b8c5d92e8cdc6a", "PSDepSlnPacks");
        this.cloneDERMap.put("bb50e1abb6efd898a44beaade49e8a67", "PSSysBDTableDERs");
        this.cloneDERMap.put("99e14bc49f4fe5cbace84dc69dc88abe", "PSDevPrdSysSyncItems");
        this.cloneDERMap.put("05a2a1e5c0c0811e5e6b2c7421b175f9", "PSDevPrds");
        this.cloneDERMap.put("06844c0c8ff3743e662160a67db715bd", "PSDevPrdSpecPlans");
        this.cloneDERMap.put("87e6b9f39f721a5611ee923d168dfea3", "PSDevPrdSpecPlans");
        this.cloneDERMap.put("7e187e08568a53cbfa4999c97fca5f5b", "PSRobotTypeAbilities");
        this.cloneDERMap.put("40d9902c63f7003b8ea8d3e156f79cde", "PSDCRobotAbilities");
        this.cloneDERMap.put("a14bd1c2bb5b00691ca33655e698a23c", "PSDCRobotAbilities");
        this.cloneDERMap.put("bd61a0078ca60b394e26fadca6d3b7e1", "PSSysBDTableRSes");
        this.cloneDERMap.put("4764c3a84d1356e25892a546505e8a9f", "PSDERTAWIs");
        this.cloneDERMap.put("b2167ad310d7fd5818544f802a9346f0", "PSDBDevInsts");
        this.cloneDERMap.put("0b7e7204bd366f24fa6bebf75d358c80", "PSDBServers");
        this.cloneDERMap.put("3637535608e4a729d23ea7963aafe7e0", "PSDEMSOPPrivs");
        this.cloneDERMap.put("8fe9c934b75a57d03a7e0a955ec21415", "PSDCMobAppTDRefs");
        this.cloneDERMap.put("7c664e7c71e01948445eae2d04308737", "PSDCPFPITempls");
        this.cloneDERMap.put("b78fd251d84fd0293f069f9dfed4d96d", "PSMobAppPackTDs");
        this.cloneDERMap.put("f40124da2faa9cfa0b44d94ce0643af0", "PSDevPrdIssuePlans");
        this.cloneDERMap.put("807e5a77a2ef6035d58257344387e330", "PSSysViewPanels");
        this.cloneDERMap.put("9d8000acd285ca08d8b242304eb74dcf", "PSSysViewPanels");
        this.cloneDERMap.put("f258ad9608e7f2a639f4a820024b6db5", "PSSysViewPanelItems");
        this.cloneDERMap.put("24c1fe70222ce34d147c9628df7371cc", "PSSysViewPanelItems");
        this.cloneDERMap.put("23bf56511af00a088285e854e0b749dd", "PSSysSearchBarItems");
        this.cloneDERMap.put("f1e30b3900097bccde0b7dcf3408dba5", "PSCorePrdInstLogs");
        this.cloneDERMap.put("f120d9905edcd5143c41b883a7085f82", "PSCorePrdInstLogs");
        this.cloneDERMap.put("beea322f48bf76b0ed76cf317bbd4378", "PSROSServers");
        this.cloneDERMap.put("0d32944f707248b5775718b137c95830", "PSSysServiceAPIs");
        this.cloneDERMap.put("739201c9411362a1d77a9b35f2cd76a9", "PSDEServiceAPIs");
        this.cloneDERMap.put("33c835bb4e5549df40068cf58dfeea68", "PSDESADetails");
        this.cloneDERMap.put("75c7588bed5bb34310f2266e0a217eeb", "PSSubSysSADetails");
        this.cloneDERMap.put("0c085dec0fd265dd8ac10b525ffb11a6", "PSSubSysServiceAPIs");
        this.cloneDERMap.put("1d822d6b865a7bd735e375589d27d5ed", "PSDERGroups");
        this.cloneDERMap.put("26a544910a9ed2c92c2510d367b06cd6", "PSDEFGroupDetails");
        this.cloneDERMap.put("b1260388ce9a255137aacf77e2507f7b", "PSDEFGroups");
        this.cloneDERMap.put("f9cf6f3b7c9950f96a9b780ed6fa593d", "PSDERGroupDetails");
        this.cloneDERMap.put("3ba0d29ef64b79d6f554458701e5d6dd", "PSDERGroup");
        this.cloneDERMap.put("7ca31dcf8193470ba3b886faf1259da9", "PSDTSQueues");
        this.cloneDERMap.put("fffabece1aaa9fffab00830f00dfe0b6", "PSDeployServers");
        this.cloneDERMap.put("4e65d5776bfbbb3e940e1361031dea73", "PSDCDeployServer");
        this.cloneDERMap.put("f5996f83998ea2c761257ddb9bec4f7c", "PSSysProjects");
        this.cloneDERMap.put("518f9b38454cad862b7b63d5f889beb2", "PSSysProjects");
        this.cloneDERMap.put("259480541b801281359ad145b1702961", "PSSysProjects");
        this.cloneDERMap.put("f822e0fd349e0d9fd33d2581923ad49b", "PSDEOPPrivRoles");
        this.cloneDERMap.put("e8f2a5df4b7b8cf9612ae8812b61183c", "PSDEUserRoles");
        this.cloneDERMap.put("255d8e524a64b900d16714b0c7146c1a", "PSDEOPPrivRoles");
        this.cloneDERMap.put("872ec2075cc0b7193283b025d1c0fc4f", "PSSysDBParts");
        this.cloneDERMap.put("9b1965c66a82c159fe206e133138a9a7", "PSSysDashboards");
        this.cloneDERMap.put("2e6973de8408b2d4eeeeed95c62b4127", "PSAppLocalDEs");
        this.cloneDERMap.put("928cb5c09db4d12fb78cc273b70bff7c", "PSDEUtilDE");
        this.cloneDERMap.put("e1eea595cc7e30162d29252a44eaaf27", "PSSysUserRoleReses");
        this.cloneDERMap.put("ccb879123c6d9dce5a4c4526a5cc50d1", "PSSFPluginTempls");
        this.cloneDERMap.put("c5ec07a6a9eef5553d125fbba6e73093", "PSSysSFPITempls");
        this.cloneDERMap.put("071fba2dc7cfe5e9b84f5c5038d72711", "PSAppUtils");
        this.cloneDERMap.put("901230ee859b11e8b145b1311b4c0343", "PSDEViewGrpDetails");
        this.cloneDERMap.put("0cd1fc820176a8b4919fc288c371eeaa", "PSDEViewGroups");
        this.cloneDERMap.put("d0de797aea668191c6d990bbc0c74a50", "PSDCCodeSnippetRef");
        this.cloneDERMap.put("fb5ec221e8be16edf2e44ff53716377c", "PSDCCodeSnippets");
        this.cloneDERMap.put("95a4073201616bc224aaaaed9cc68b61", "PSSysCodeSnippets");
        this.cloneDERMap.put("390d69a1f6c87afc8dbf48292335153e", "PSMSPlatformFuncs");
        this.cloneDERMap.put("2a1a714778fa8ed1355ccbb25e8f909e", "PSDCMSPlatform");
        this.cloneDERMap.put("1cc0b41193a36d7d7a03d0fc11d238ae", "PSDCMSPlatforms");
        this.cloneDERMap.put("649693fe5de83381bf1de6417c20868c", "PSDCMSPlatformFuncs");
        this.cloneDERMap.put("4485764748042abfdf72a9b170eb9286", "PSDCMSPlatformNodes");
        this.cloneDERMap.put("cc18c3b6e401f04819486733d1254dfb", "PSDevSlnMSDeploys");
        this.cloneDERMap.put("95c47712871d720fbaa72507e5e16a99", "PSDevSlnMSDepApps");
        this.cloneDERMap.put("5c0fbb77b2bffd5009d34412cf8dec38", "PSDevSlnSysApps");
        this.cloneDERMap.put("453cfdbd2100c51d236f4f7bfd000476", "PSDevSlnSysAPIs");
        this.cloneDERMap.put("8d65391bfa6c8e12d893dd6724b86dab", "PSDevSlnMSDepAPIs");
        this.cloneDERMap.put("69a63aecd11d2788d1e1f5e7c2771026", "PSMSPlatforms");
        this.cloneDERMap.put("a67427b3d3dee063d257a3a171c7a3ab", "PSDeployCenters");
        this.cloneDERMap.put("2ca208b043dd4a7a1abe2bf597b04271", "PSDCDeployServers");
        this.cloneDERMap.put("91757de63533e1190e3b01944229cc9c", "PSDCWorkshopServers");
        this.cloneDERMap.put("b395b18883736479221926dca83a266e", "PSMSPlatformNodes");
        this.cloneDERMap.put("610953cfc0fcfe0e51739aa8c6a07121", "PSAppDEViewRefs");
        this.cloneDERMap.put("3bf7da0222e6472d44066a48baea59b1", "PSDevSlnSysWSGit");
        this.cloneDERMap.put("ae23256684e557e761e835c842a4c65f", "PSDEDataImpItems");
        this.cloneDERMap.put("d03fc924231bf618e9298774bed6fdff", "PSSysDynaModelAttrs");
        this.cloneDERMap.put("50c6a5c93f0e639ea46bb8cc4655f347", "PSSysTitleBars");
        this.cloneDERMap.put("b16eb9f089e0c0102eeffef953a8eecf", "PSAppTitleBars");
        this.cloneDERMap.put("6522eaa755ad3442d96cd08377989336", "PSACHandlerActions");
        this.cloneDERMap.put("2d4174c23ccf6aefca8b68232735d3ec", "PSDynaAppVCInsts");
        this.cloneDERMap.put("6cf7397628cc14879d97033da5683a32", "PSDynaAppViewInsts");
        this.cloneDERMap.put("5d1ad746a985d5753b92c4acf97e3169", "PSDynaDEFormInst");
        this.cloneDERMap.put("b9ad66632b2e41037340637ba4348f51", "PSDynaDEFormInsts");
        this.cloneDERMap.put("5330a0b7e987a6ccb996b70a0778169d", "PSDynaDEForms");
        this.cloneDERMap.put("4f16023f11823124515bb20780d5507b", "PSDynaWFVerInsts");
        this.cloneDERMap.put("ac2433586fc12fb3826baad87c7c1ffd", "PSDynaAppViewCtrls");
        this.cloneDERMap.put("512c2a951fb6c2194090d7026d3a4f34", "PSDynaDEs");
        this.cloneDERMap.put("6b22413837d18853cb175bb27b1ed857", "PSDynaWFVers");
        this.cloneDERMap.put("dd3cac5714ee27a4f17f03ad3e7c8a57", "PSDynaWFs");
        this.cloneDERMap.put("5f9b28ade1fb7d9aacbdf971d49d1ba3", "PSDynaAppViews");
        this.cloneDERMap.put("488ef47ebc407ebcfb2c562978b0376f", "PSDynaApps");
        this.cloneDERMap.put("37a712744b6a96e7f7c30e31a290ab88", "PSDynaInsts");
        this.cloneDERMap.put("2b9ac6aff04dfbf351ec47ba06e3a46d", "PSDevSlnSysSrvs");
        this.cloneDERMap.put("0ac6e8f84877ee506e794e0f00f38a4a", "PSDynaWFVers");
        this.cloneDERMap.put("d741e95d258fb37b00050c1ca9ac31b5", "PSDevSlnSysDynaInsts");
        this.cloneDERMap.put("c7f4b6bab443a687f9d6a4a0652775e4", "DSDynaViewInsts");
        this.cloneDERMap.put("2c3f7e899a996bc416cec3c73769220b", "DSDynaWFVers");
        this.cloneDERMap.put("e0e6be2809cb643e735166d0a7ea0646", "PSSysDMVerItems");
        this.cloneDERMap.put("4dd4685fe81e9a83ae302a41756d9192", "PSSubSysServiceAPIs");
        this.cloneDERMap.put("20949106ec0b31da26c9eb3f08900081", "PSSysDMVerItems");
        this.cloneDERMap.put("5318d9df4228641124beea7ad74272aa", "PSSysDMVers");
        this.cloneDERMap.put("748bf729e29b6e305a993904f7343633", "PSDevSlnSysRefs");
        this.cloneDERMap.put("910964342ef669fca84e6c08f97b5cc1", "PSDevSlnSysGroupDetails");
        this.cloneDERMap.put("3c09da7ff9ed6072f26c4b15d25a6435", "PSDevSlnSysGroups");
        this.cloneDERMap.put("3d4e350516e7e814b228645474443550", "PSCodeLists");
        this.cloneDERMap.put("cdaa9a83e114def9e413d630e362ea2d", "PSDevSlnSysBaks");
        this.cloneDERMap.put("1de4d00519fc9e4237985ee75964d99d", "PSDynaCodeLists");
        this.cloneDERMap.put("2cda7b09b19bf6cecb3cae32e8b10a7c", "PSDEActionTempls");
        this.cloneDERMap.put("1bfa8f830d9bbd08ebf61aa256b607ae", "PSDEActionParams");
        this.cloneDERMap.put("724fdeb2fe731f6e9ea08168441baff0", "PSSysDynaModels");
        this.cloneDERMap.put("c83186e3d074eeabf8b6ff0bb46141f5", "PSWorkflows");
        this.cloneDERMap.put("f8df7500492ab9e5dd55bc24d9a65186", "PSSysServiceAPIs");
        this.cloneDERMap.put("8cf00d89f63d551d6f97613f2a53a524", "PSSysSFPubRefs");
        this.cloneDERMap.put("386f41979c35f71379a7ac87f5825a5e", "PSWFRoles");
        this.cloneDERMap.put("e00a9a9ef0d294ecdfa9fc3c365f8de4", "PSSysERMaps");
        this.cloneDERMap.put("d64c434ad85886ba0fc2df1b1b746aef", "PSSysBDSchemes");
        this.cloneDERMap.put("793c45f49b590f8b9923d37226c8d24b", "PSWXAccounts");
        this.cloneDERMap.put("e9c931f71621af6548bd7964aa9a7855", "PSMavenRepos");
        this.cloneDERMap.put("809f1dd8d73813f9186194c9b5273cff", "PSDETreeCols");
        this.cloneDERMap.put("8d71d8e16a7ea179c549fd55cab7de16", "PSDEUAGroups");
        this.cloneDERMap.put("4f751a086da7e55b959986e380eae571", "PSDEUIActions");
        this.cloneDERMap.put("10354e773e4265e39d5779bef9428b4e", "PSLanguageReses");
        this.cloneDERMap.put("7a8151db7269ca4151fa6a7abd019990", "PSSysPDTViews");
        this.cloneDERMap.put("e5211bd8300f1974bac9824ad8048365", "PSDEToolbars");
        this.cloneDERMap.put("70f0719e59c8f47661e26b9c54bd5eca", "PSSysPortlets");
        this.cloneDERMap.put("d26cb90b307f58e0abec1a6d814385cc", "PSSydDashboards");
        this.cloneDERMap.put("466960c7f8018165caa86849e52a35fb", "PSSysSFPlugins");
        this.cloneDERMap.put("98318c42409885cc59b377d840cf071d", "PSSysEditorStyles");
        this.cloneDERMap.put("4fbb3d02d53150e76e1b96e1d4ae9b5b", "PSSysImages");
        this.cloneDERMap.put("7f2507be69d5d93bbd805cf266906b9c", "PSSysCssCats");
        this.cloneDERMap.put("c6532cf02c3a3cd8f09366f914ad6448", "PSSysCsses");
        this.cloneDERMap.put("5be79ae205feb477e16f5a88705bba14", "PSDEOPPrivs");
        this.cloneDERMap.put("0081724e6f966c7963ac8acff8dc73c7", "PSSysUniStates");
        this.cloneDERMap.put("6410e140bfa103c1bb71821b5637866e", "PSSysUnits");
        this.cloneDERMap.put("6b3773ccadb08cfa01f0e717bfc07f85", "PSSysUniReses");
        this.cloneDERMap.put("9f8efcdb54b08f33d4c91c4ed9eb0883", "PSDEActionTempls");
        this.cloneDERMap.put("9b4e39b40e4972acfe52fd8b625d7dd2", "PSDEFInputSets");
        this.cloneDERMap.put("c879d5962e45ab9385061ee46ed3905a", "PSDEFInputTips");
        this.cloneDERMap.put("cd6c4b4ed653ae841b034d0bf88253da", "PSSysDELogicNodes");
        this.cloneDERMap.put("1329d8dcb6a18bb68cc9f1150f2b6c8e", "PSSysValueRules");
        this.cloneDERMap.put("1e4a7738091607079986bcf2369f3504", "PSSysMsgTempls");
        this.cloneDERMap.put("84fa8ca40738f7ca56f90a4fdcd62158", "PSSysDictCats");
        this.cloneDERMap.put("2576ecbc9e2c4f08fbd7a0a080f6208a", "PSSysUserDRs");
        this.cloneDERMap.put("07d23cf3ce9f23861a249be19740f6da", "PSSysUserModes");
        this.cloneDERMap.put("350096a1976e42953d9f0f5ad0f0d003", "PSSysOPPrivs");
        this.cloneDERMap.put("0d8d96ec88b71825dfd1bc0a8c5c686b", "PSSysWFModes");
        this.cloneDERMap.put("5d5474f5164bee20762f27a70bdd6d20", "PSSysSFPubs");
        this.ignoreDEFMap.put("db1db9a2aabae0a3aef3adf4e067a1df", "PSDEVCENTER_MAXSYSCNT");
        this.ignoreDEFMap.put("763cf7244dd17f628ab3568633d1a621", "PSDEMODELCNT_DEDSCNT");
        this.ignoreDEFMap.put("f33768a764fceb6c3ea9f398af8363a4", "PSDEMODELCNT_DEMSCNT");
        this.ignoreDEFMap.put("243896aa39a86acc8922ac6e8804c86a", "PSDEVCENTER_SYSCNT");
        this.ignoreDEFMap.put("f5c86db58b4cc41c6f3175f0ef94e0b4", "PSSYSTEM_PSSFPUBSCNT");
        this.ignoreDEFMap.put("42585e3474993a52dbcd3d56a4c6320a", "PSDATAENTITY_PSDEUIACTIONSCNT");
        this.ignoreDEFMap.put("9ce1d9015eeddf2b1cd0dea76602a8d1", "PSDEACTION_PSDEACTIONLOGICSCNT");
        this.ignoreDEFMap.put("abb3a8dba2da98b3312c056998f105a5", "PSSYSAPP_PSAPPVIEWSCNT");
        this.ignoreDEFMap.put("61f9b89fc3c1b53eba1d4a8ac00ef7c6", "PSSYSAPP_PSAPPMENUSCNT");
        this.ignoreDEFMap.put("c724a7943d104770096f533d497cfaf9", "PSSYSAPP_PSAPPFUNCSCNT");
        this.ignoreDEFMap.put("d1c048caa8ba728d4307be8393329029", "PSDATAENTITY_PSDEDBCFGSCNT");
        this.ignoreDEFMap.put("5f7b6baf45fff8f0018f80d5e75389ff", "PSDATAENTITY_PSDEDATAQUERYSCNT");
        this.ignoreDEFMap.put("62f02ddebd898e3968b3b6bebad26a55", "PSDATAENTITY_PSDELOGICSCNT");
        this.ignoreDEFMap.put("f971e07568a0590d651864551627857c", "PSDATAENTITY_PSDEDRITEMSCNT");
        this.ignoreDEFMap.put("42ac879576642697c30ebb5e92639a85", "PSDATAENTITY_PSDEDRGROUPSCNT");
        this.ignoreDEFMap.put("9a588be256232e48927364fbbf9c7dce", "PSDEFIELD_PSDEFSFITEMSCNT");
        this.ignoreDEFMap.put("52dca5ad061bb05c29e6a25422594f2b", "PSDATAENTITY_PSDEACTIONSCNT");
        this.ignoreDEFMap.put("6e0e77a5377768de991aab41e50e72e0", "PSDATAENTITY_PSCODELISTSCNT");
        this.ignoreDEFMap.put("27cc7f97936e42bcc6a7ade443b183c4", "PSDATAENTITY_PSDEGRIDSCNT");
        this.ignoreDEFMap.put("5677a1d2897da3366cb42b3b4e3088c5", "PSDATAENTITY_MAJORPSDERSCNT");
        this.ignoreDEFMap.put("61f66caa587103378dc902459ed87bd6", "PSDATAENTITY_PSDEDATASETSCNT");
        this.ignoreDEFMap.put("5f7257db0d8533d5c0175650d40a2257", "PSDEFIELD_PSDEFIELDSCNT");
        this.ignoreDEFMap.put("5b81a10c86d39f29d9dc122310697711", "PSDATAENTITY_PSDEDATARELATIONSCNT");
        this.ignoreDEFMap.put("456f0eb7e4412e18c395a80ace747cab", "PSDATAENTITY_MINORPSDERSCNT");
        this.ignoreDEFMap.put("7226e9d839ea4b97d69db06ceadb0f80", "PSSYSAPP_PSAPPVIEWCODESCNT");
        this.ignoreDEFMap.put("c5ac9aa6a59299d273758b78e516f030", "PSSYSAPP_PSAPPEDITORTEMPLSCNT");
        this.ignoreDEFMap.put("b94b4232e7e320aca9d8f35b42bd2af2", "PSDEFIELD_PSDEFVALUERULESCNT");
        this.ignoreDEFMap.put("71011557f115f54f91f88384788d3c95", "PSDEFIELD_PSDEFDTCOLSCNT");
        this.ignoreDEFMap.put("3d1c7f842ca4e71e06fdf2f61159e2a6", "PSDATAENTITY_PSACHANDLERSCNT");
        this.ignoreDEFMap.put("00e369763214d9361f09077d05e16edf", "PSDEFIELD_PSDEFUIMODESCNT");
        this.ignoreDEFMap.put("9b401e1dbf77da7db18bd1fb9c7a8448", "PSDER_PSDEFIELDSCNT");
        this.ignoreDEFMap.put("d442ac5fc56f9c92b4edff52cf81ba1f", "PSDATAENTITY_PSDEFIELDSCNT");
        this.ignoreDEFMap.put("98fa4184ea69602873bd86bfb0cb97ad", "PSDATAENTITY_PSDEOPPRIVSCNT");
        this.ignoreDEFMap.put("9a7e763a57d7914c5e7e67a020148e6f", "PSDATAENTITY_PSDEVIEWBASESCNT");
        this.ignoreDEFMap.put("7ac0229f2fa47426e325810af6fa01d4", "PSDATAENTITY_PSDEACMODESCNT");
        this.ignoreDEFMap.put("429a9a8b2114e5c7d8d675f66c7fbfbb", "PSDEVIEWBASE_PSAPPVIEWSCNT");
        this.ignoreDEFMap.put("55a84ebde4a75867da034a4fd1eff7c1", "PSSYSAPP_PSAPPMODULESCNT");
        this.ignoreDEFMap.put("7d5b4a8b8dc7d14a8e5f3031499c64cd", "PSDATAENTITY_PSDEFORMSCNT");
        this.ignoreDEFMap.put("87b92b6b6028ec84b2d99f788e74e2b4", "PSDER_PSDEDRITEMSCNT");
        this.ignoreDEFMap.put("b55c0f004d1b3f0a68d086a56afb3a26", "PSDATAENTITY_PSWFDESCNT");
        this.ignoreDEFMap.put("7ccaa26fd91a234e17336600100597ad", "PSDCMODELTEMPL_PSDCMTDEFSCNT");
        this.ignoreDEFMap.put("d46dfaf9907062f9f23e1aca19cc9216", "PSSYSPFPLUGIN_PSSYSPFPITEMPLSCNT");
        this.ignoreDEFMap.put("071fc69682740a7991dd68f4ddf02e1b", "PSSYSAPP_PSAPPUITHEMESCNT");
        this.ignoreDEFMap.put("dadd81f639e22082042a8de5086cd445", "PSSYSAPP_PSAPPUTILPAGESCNT");
        this.ignoreDEFMap.put("0deff12cd1b09b2902407ac840908908", "PSDATAENTITY_PSDEDATAVIEWSCNT");
        this.ignoreDEFMap.put("d5a79e17c5a8abb23851cd960239aef3", "PSDEVSLN_PSDEVSLNSYSSCNT");
        this.ignoreDEFMap.put("a4005a973be978523c64e0744677819e", "PSWFVERSION_PSDEUIACTIONSCNT");
        this.ignoreDEFMap.put("5900e20dffb564f895614ac645ff28b2", "PSSYSAPP_PSAPPUSERMODESCNT");
        this.ignoreDEFMap.put("d86da820d73b90212f390b4ee76cd18f", "PSDATAENTITY_PSDEDBINDEXSCNT");
        this.ignoreDEFMap.put("90d4bbb3ba1bd9b05f788065b7bd8107", "PSDATAENTITY_PSDECHARTSCNT");
        this.ignoreDEFMap.put("3ae8c1ddc72fe69f9f3155a052c8be71", "PSDATAENTITY_PSSYSTESTCASESCNT");
        this.ignoreDEFMap.put("bd5fd6bcfb0081b560894d3d5f8be8ec", "PSDATAENTITY_PSDEDATAIMPSCNT");
        this.ignoreDEFMap.put("e3ee46b9b6042fa161e33d3798ea7066", "PSDER_PSDEOPPRIVSCNT");
        this.ignoreDEFMap.put("caa5831d112da532cb3ffe6f107f6ef3", "PSDATAENTITY_PSSYSCOUNTERSCNT");
        this.ignoreDEFMap.put("f0a8065d05d3d969901405afeac8d04a", "PSDEACTION_PSDEMSACTIONSCNT");
        this.ignoreDEFMap.put("360e901a7f536bcd69f634e32133c172", "PSWORKFLOW_PSWFDESCNT");
        this.ignoreDEFMap.put("c9f06d63766f7e6adfd99df4f53bff3b", "PSDATAENTITY_PSDEPRINTSCNT");
        this.ignoreDEFMap.put("73d1b5270bbb0a5b596009c8955edd02", "PSDER_PSDERDEFMAPSCNT");
        this.ignoreDEFMap.put("fadf19860f0bcd1dbd7cadca650d5c1a", "PSDATAENTITY_PSDEFVALUERULESCNT");
        this.ignoreDEFMap.put("511cab89c69d09e5d25035d426237fd5", "PSDATAENTITY_PSDEACTIONLOGICSCNT");
        this.ignoreDEFMap.put("0bcec3a5d410d2b3395e123a8757f7e9", "PSDATAENTITY_PSDEFSFITEMSCNT");
        this.ignoreDEFMap.put("3bddee60a6529dea2d6061562b42237b", "PSDATAENTITY_PSSYSDMITEMSCNT");
        this.ignoreDEFMap.put("5f2e11d3f1525c6b463179ac354349cf", "PSDATAENTITY_PSDEREPORTSCNT");
        this.ignoreDEFMap.put("41adce75c8bda99977476b29f398c764", "PSWFVERSION_PSDEUAGROUPSCNT");
        this.ignoreDEFMap.put("b1db3de4d9617b5a053422169983b679", "PSDATAENTITY_PSDETREEVIEWSCNT");
        this.ignoreDEFMap.put("cc5453128a65636407b10eba44431edf", "PSDEVSLN_PSDEVSLNUSERSCNT");
        this.ignoreDEFMap.put("7d13aaee67e506e42cc5151f9a6b1ac7", "PSDATAENTITY_PSSYSMODELCHGLOGSCNT");
        this.ignoreDEFMap.put("31f87a3bbf79610cf407e3dfb5fd2250", "PSDATAENTITY_PSSYSTESTDATASCNT");
        this.ignoreDEFMap.put("b38c7b4b7dd691fcb44a11c6362d119b", "PSDEFIELD_PSSYSTESTCASESCNT");
        this.ignoreDEFMap.put("52626f97d506fcb4ba344d7e6082f90b", "PSDATAENTITY_PSDEMAINSTATESCNT");
        this.ignoreDEFMap.put("6d414f514bebff045c966450190f42a6", "PSDATAENTITY_PSDEUAGROUPSCNT");
        this.ignoreDEFMap.put("69594edb7b6dc49027a66f3fbf2c207a", "PSDATAENTITY_PSDEDATAEXPSCNT");
        this.ignoreDEFMap.put("030302968020630b9a360abda770032d", "PSWORKFLOW_PSWFVERSIONSCNT");
        this.ignoreDEFMap.put("41b38019f010047f2e888a8fa580dec6", "PSDATAENTITY_PSDELISTSCNT");
        this.ignoreDEFMap.put("64a8a2e02bb1fc6053fb1886c5c13a44", "PSWFDE_PSDEVIEWBASESCNT");
        this.ignoreDEFMap.put("7218636cb4ef9fbc6dae1ae1eb002ad3", "PSDEACTION_PSSYSTESTCASESCNT");
        this.ignoreDEFMap.put("111cac26d49a8415fb4ec7de08c8ee0f", "PSDATAENTITY_SRCPSDEMAPSCNT");
        this.ignoreDEFMap.put("76ceca52a70cc371e0b12e2df048e336", "PSDATAENTITY_DSTPSDEACTIONLOGICSCNT");
        this.ignoreDEFMap.put("442e9b55458d7e1a292baad66d3af097", "PSSYSSFPUB_PSSYSSFPUBPKGSCNT");
        this.ignoreDEFMap.put("43cfcc41f04655abb47ec18408f647b0", "PSDATAENTITY_PSDEDATASYNCSCNT");
        this.ignoreDEFMap.put("c9b2a63e9a14c4cc40cadd9383893084", "PSDATAENTITY_PSDEWIZARDSCNT");
        this.ignoreDEFMap.put("35cd6a53328b705097f5634885d5dd95", "PSSYSSFPUB_PSSYSSFCODESCNT");
        this.ignoreDEFMap.put("c08baaae9c774dbb60677eb275290e72", "PSDATAENTITY_PSDETOOLBARSCNT");
        this.ignoreDEFMap.put("b9ce1d2df4ecb7d58caca286d7b2a555", "PSSYSBDSCHEME_PSSYSBDPARTSCNT");
        this.ignoreDEFMap.put("ac5da0d0ea3e5f54404e8c45ba3fd266", "PSSYSBDSCHEME_PSSYSBDTABLESCNT");
        this.ignoreDEFMap.put("57b3a79e5cb031bc2cab9a30ad0fa53f", "PSSYSBDTABLE_PSSYSBDCOLSETSCNT");
        this.ignoreDEFMap.put("d4347afdc89776abbaeed98e8732f44c", "PSSYSBDTABLE_PSSYSBDTABLEDESCNT");
        this.ignoreDEFMap.put("49a55525c9a5039dfb9f9ad76c715193", "PSSYSBDTABLE_PSSYSBDCOLUMNSCNT");
        this.ignoreDEFMap.put("5e2fb5b04459eb0f40be6f8f6caf230b", "PSDATAENTITY_PSSYSBDTABLESCNT");
        this.ignoreDEFMap.put("0d5da5c551d083e54e980f446b0a5040", "PSDATAENTITY_PSSYSTASKSCNT");
        this.ignoreDEFMap.put("b1e2c9fbe9632e7e39d9d0d38e5b09bb", "PSSYSAPP_PSSYSTASKSCNT");
        this.ignoreDEFMap.put("3c1d07ddbdb379d6824f76eca67dc5f4", "PSSYSREQITEM_PSSYSREQITEMDATASCNT");
        this.ignoreDEFMap.put("24ae73ad037890f1467b1a6af6fa0458", "PSSYSREQITEM_PSSYSREQITEMHISESCNT");
        this.ignoreDEFMap.put("14862772ad157d43722aefb595b3aba9", "PSSYSTASK_PSSYSTASKDATASCNT");
        this.ignoreDEFMap.put("0d96d8ee030ece387d75cd1b0d9ccd26", "PSDEFIELD_PSDEFINPUTTIPSCNT");
        this.ignoreDEFMap.put("734c8470c3b1b93504c8b88551dcb6d0", "PSSYSAPP_PSAPPPKGSCNT");
        this.ignoreDEFMap.put("e9cb21a4085b383125294e3ce756b0ee", "PSDATAENTITY_PSDEAWSCNT");
        this.ignoreDEFMap.put("a63e25b7ba5c9b31c398dc3a54ecfe47", "PSDATAENTITY_PSDEAWGRPSCNT");
        this.ignoreDEFMap.put("569b4363c05fdb07ff2d941fc850a161", "PSSYSTEM_PSSYSTASKSCNT");
        this.ignoreDEFMap.put("10a076d11cc15dca61a195df29220769", "PSSYSTEM_PSSYSDEVBKTASKSCNT");
        this.ignoreDEFMap.put("7723073789090ddddc8496310d0faf2e", "PSSYSTEM_PSSYSISSUESCNT");
        this.ignoreDEFMap.put("758a1f6cc02f38d4f9cee1e98236f479", "PSWXACCOUNT_PSWXENTAPPSCNT");
        this.ignoreDEFMap.put("3ce4f923455cc4adb12c4a6b0ffd7130", "PSWXACCOUNT_PSWXMENUSCNT");
        this.ignoreDEFMap.put("8aac0c99975405d6636a0df51e7bb447", "PSWXACCOUNT_PSWXMENUFUNCSCNT");
        this.ignoreDEFMap.put("9bccf859a1f487b89ae0b95fe5dade37", "PSWXACCOUNT_PSWXLOGICSCNT");
        this.ignoreDEFMap.put("1619d29af8aa0d71dece9463af88f7f4", "PSWXENTAPP_PSWXMENUSCNT");
        this.ignoreDEFMap.put("b49c60d12c617c4c6123be24261cbbb5", "PSWXENTAPP_PSWXMENUFUNCSCNT");
        this.ignoreDEFMap.put("95c42b40f44ec95a69a72f6277f7ee8d", "PSWXENTAPP_PSWXLOGICSCNT");
        this.ignoreDEFMap.put("e6319c45f365a847c68a62e324b58668", "PSDCSYSLIC_MAXACTIVESYSCNT");
        this.ignoreDEFMap.put("5e1ebb9d0782193297ad9f0582b5825e", "PSLANGUAGERES_PSLANITEMSCNT");
        this.ignoreDEFMap.put("0e3c6d3f0239b8d16a1b39ac6663c3e0", "PSDCSYSLIC_MAXSYSCNT");
        this.ignoreDEFMap.put("3f95246c42541c1892ec63e4f6ca6fe2", "PSDCSYSLIC_CURSYSCNT");
        this.ignoreDEFMap.put("15d228560c8d1cf53b9c430736756cf1", "PSSYSTEM_WEBPSAPPSCNT");
        this.ignoreDEFMap.put("693337e4743fe084776cec510f38f74a", "PSSYSTEM_MOBPSAPPSCNT");
        this.ignoreDEFMap.put("dca73bc072408f58645ae5f6d4f6d73e", "PSSYSTEM_PSWFSCNT");
        this.ignoreDEFMap.put("cc6615c6232fbd326cadd932ca4b2a2b", "PSDCSYSLIC_CURACTIVESYSCNT");
        this.ignoreDEFMap.put("13397b1078a044e072330367c789ef6d", "PSSYSBDTABLE_PSSYSBDTABLEDERSCNT");
        this.ignoreDEFMap.put("7373464e8c0882f491369d527d25af02", "PSDCRESREP_ASCNT");
        this.ignoreDEFMap.put("1ddc6727f328100b97a38e151ba9641a", "PSDCRESREP_USERASCNT");
        this.ignoreDEFMap.put("f60d817bd35efc27636eb821208537e9", "PSDCRESREP_EXPIREDASCNT");
        this.ignoreDEFMap.put("25258ef8480e676139483076deb46401", "PSTASKSERVERLOG_JITSYSCNT");
        this.ignoreDEFMap.put("761de994d66951a2f2f90b9ac46852f9", "PSDCRESREP_IDLEASCNT");
        this.ignoreDEFMap.put("e30dfd1eb4874dca7610601ba334e5cf", "PSDCRESREP_USEDASCNT");
        this.ignoreDEFMap.put("8200246dda3a6bf7cdef6dc535cf3cd2", "PSDATAENTITY_PSDESERVICEAPISCNT");
        this.ignoreDEFMap.put("968cb2db2c03e40ca2716d2759ad751b", "PSDATAENTITY_PSDEDTSQUEUESCNT");
        this.ignoreDEFMap.put("863ae24f5557b11ae64a2e905f872320", "PSSYSSFPLUGIN_PSSYSSFPITEMPLSCNT");
        this.ignoreDEFMap.put("87433b53dc6d3c9620beea4a6eba7c1c", "PSDATAENTITY_PSDEUSERROLESCNT");
        this.ignoreDEFMap.put("e2c02392456f3add40948a2b0baafdbd", "PSDATAENTITY_PSDEOPPRIVROLESCNT");
        this.ignoreDEFMap.put("4fae1fcfa83033b72f9fed1505b93331", "PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPAPPSCNT");
        this.ignoreDEFMap.put("f23280fcbf506bc49d31b46cc9622c0d", "PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPAPISCNT");
        this.ignoreDEFMap.put("acf9ab912391a849bfa952613ec07fc1", "PSDEVSLN_PSDEVSLNMSDEPLOYSCNT");
        this.ignoreDEFMap.put("bdf7e77e0a6ef20ae9ec5ebbeebbac6c", "PSSYSAPP_PSAPPTITLEBARSCNT");
        this.ignoreDEFMap.put("897979c3c8dbea93abd3c84e27145f7f", "PSDEVIEWBASE_PSAPPVIEWCNT");
    }

    protected void initTempDERMap() {
        this.tempDERMap.put("bf54aae966df530deca94435f3940f40", 10);
        this.tempDERMap.put("a59eda0aa3fc04754faef6c19165ab72", 0);
        this.tempDERMap.put("3bee956f1baa63f3cac41ab904e0da79", 10);
        this.tempDERMap.put("c21038cdc5f01a3c130659d459fb01b0", 0);
        this.tempDERMap.put("f58ab6c926c482258d188f86332ec512", 50);
        this.tempDERMap.put("ed8d0afdc183c01b74b8abcd27a4e0d9", 10);
        this.tempDERMap.put("e2def3aee26f3e7c5208e67754be8e78", 0);
        this.tempDERMap.put("968ebeec119a7a74fb5a49ad7e8a96f8", 10);
        this.tempDERMap.put("88b3772409142b3b6f3e8ab957f13e7f", 30);
        this.tempDERMap.put("c4aa8337c015c15c51ad06cb04e42042", 0);
        this.tempDERMap.put("b244fabe5b0be49031d9d7f2189efcd9", 20);
        this.tempDERMap.put("f0913472520e0daa49ec784e9e5ec160", 90);
        this.tempDERMap.put("40884e71f38454d7d2e7c18c4f364ddc", 0);
        this.tempDERMap.put("be9f14b11ab7af99e58ed4c2fd2dc407", 0);
        this.tempDERMap.put("31f65ffb0590572ba043f849ff638a03", 10);
        this.tempDERMap.put("cab3e8085cc701406d1a110919407eec", 30);
        this.tempDERMap.put("7d30e9782a125fec8be8c4ec53f5aff7", 0);
        this.tempDERMap.put("61eac0bce4c883ebc46810c2cb8cff98", 0);
        this.tempDERMap.put("685daa0b0f0f5dfbf418cc8cb637904e", 10);
        this.tempDERMap.put("a10dcb71c14c90f4d39812f266ede604", 0);
        this.tempDERMap.put("9581642336ea3b518070c0d7aec80694", 30);
        this.tempDERMap.put("997691c3f441a97448c59c92d9a00e41", 10);
        this.tempDERMap.put("6b2d07275f5aacb055dd5276e17943b9", 10);
        this.tempDERMap.put("fed06ace7c963deecc3c306794606c92", 10);
        this.tempDERMap.put("585c05e9a0bfe4f8930592a14ce00c61", 40);
        this.tempDERMap.put("bacff9a9a013435f76d82c54594761eb", 10);
        this.tempDERMap.put("c0619852a5cf1846f55c83979bfd7f73", 0);
        this.tempDERMap.put("0d1967ef6b28b64042ab3de829522102", 10);
        this.tempDERMap.put("2a6b622d4efa8bcb0a3573b7c269c457", 0);
        this.tempDERMap.put("c602b8988a712e7ba6262c019bd723d6", 0);
        this.tempDERMap.put("439a858d42e057a4c1bcdc5de925d64f", 0);
        this.tempDERMap.put("8972cac830827cf4e43e172ceb236ffd", 10);
        this.tempDERMap.put("29b99d2c28b3ee4319e41986826c90d6", 50);
        this.tempDERMap.put("53346b39fd5d2b53828e8583b7061ad0", 10);
        this.tempDERMap.put("b32ffa528badada73c7532600cf7c9d5", 0);
        this.tempDERMap.put("d8062c4478202541faf15e16389c5acf", 0);
        this.tempDERMap.put("0628c1e44041b3b1fc37becd5dcfd725", 20);
        this.tempDERMap.put("74e5b604b6901c0673786ef3240d3686", 0);
        this.tempDERMap.put("625bd7b74b99663fb01f91ec4c07d6a8", 0);
        this.tempDERMap.put("331c09fe8fbffabfccd5fdb1c078241a", 10);
        this.tempDERMap.put("432808f0344322358be2f2e7153b088f", 0);
        this.tempDERMap.put("e7fbf2b27129c05721de8110d6530be5", 10);
        this.tempDERMap.put("ca85a8fb6362a49a63e9a22cbc46a3d6", 0);
        this.tempDERMap.put("751d2e7a9c1d20349737de3a03c5b581", 50);
        this.tempDERMap.put("67673cf1f9b0ed2efe60a22eb1bfca1d", 10);
        this.tempDERMap.put("f800d5667bdf15e61c3daff832fa4151", 10);
        this.tempDERMap.put("fce07b991af06f85ba5bc1e5a21e4c05", 0);
        this.tempDERMap.put("9dfc57cef71b334b3a50a36d13df68e5", 10);
        this.tempDERMap.put("3fbd73d1811108c5631936a65761b473", 30);
        this.tempDERMap.put("6948d2ad81660dd2fde5c18082563fc4", 0);
        this.tempDERMap.put("44ef69feab53348f5db717b876d9343d", 0);
        this.tempDERMap.put("05d366087071bbb01f8023026e315612", 50);
        this.tempDERMap.put("31e9fa582d8b7a6b56d7f4e698d9dbf8", 30);
        this.tempDERMap.put("3f992286ba153e4b6047230dd5c52b11", 0);
        this.tempDERMap.put("f74f2fb95dafaccc1fdfcd87db40b66c", 10);
        this.tempDERMap.put("840eed7556a855ee912abf9a48b451a6", 50);
        this.tempDERMap.put("f124a5698ff64827635172abbff02a58", 50);
        this.tempDERMap.put("7cd4018187709c9774b25f1528270e5b", 30);
        this.tempDERMap.put("435d5e412d49e00923e35f2d10e85870", 0);
        this.tempDERMap.put("9b04b646798228f7400d7c0f040d03f8", 40);
        this.tempDERMap.put("bac8becb9aa731d643ae8f4d30669320", 20);
        this.tempDERMap.put("24ff09cc237095c602c5131b3a82c8f0", 50);
        this.tempDERMap.put("7473134bf0825d23250cedf6a2c471c0", 0);
        this.tempDERMap.put("774bb00350e73f6fd67039fcfa529508", 0);
        this.tempDERMap.put("6a0aad02a76cb7d422b9abb025e224a3", 20);
        this.tempDERMap.put("760e6c0e3bc022bd3ad97ec6612b9b86", 20);
        this.tempDERMap.put("0c20fa4720db83accde0811e52f2635b", 10);
        this.tempDERMap.put("82be408e338f2446dbf0d3279952a05f", 10);
        this.tempDERMap.put("de8dd35a181410615243fb8921181a22", 20);
        this.tempDERMap.put("2ecb2de79b02cc6bf57002c59509b5c9", 30);
        this.tempDERMap.put("859638bd908df49f53cba88e2d4185b4", 30);
        this.tempDERMap.put("a295adb53a39a511dea0d1801a64184b", 50);
        this.tempDERMap.put("7661fc075b10feed9007ee3a5e9eeff7", 0);
        this.tempDERMap.put("96b5f3e6934f3f8f7d0db732161533e1", 0);
        this.tempDERMap.put("9d5187d2aa0d032caf9e91a724c67199", 30);
        this.tempDERMap.put("cf26ab9eab862b5a04be5fed9b6bac19", 30);
        this.tempDERMap.put("bb67a2efba57d402acc4d08a69d82f78", 0);
        this.tempDERMap.put("fe70205f264fdebbeaec94858e1bbe10", 10);
        this.tempDERMap.put("ef5307fc69656b709df59c167f61a47b", 50);
        this.tempDERMap.put("c5a45c960287f425db8144e2257a4e75", 0);
        this.tempDERMap.put("643529bcf8d9732c285e959ede8d012c", 40);
        this.tempDERMap.put("8d71bf3b0c51a3d0b7d9688294221541", 40);
        this.tempDERMap.put("6c85b606643bc5e39ec5492c6bd10846", 10);
        this.tempDERMap.put("1ba0a2fbc8ce063d90c11913482f685c", 10);
        this.tempDERMap.put("892c238b185ff2f01d68367524131c19", 50);
        this.tempDERMap.put("fa6f985de95ba197584aa0b864e14670", 0);
        this.tempDERMap.put("4f201bc2830257138f0d4d5095b4fe43", 10);
        this.tempDERMap.put("51fcb6e58c74bc752fe948aa8fbfc025", 0);
        this.tempDERMap.put("fb8eb0acb8a0e82f7451dff964505550", 20);
        this.tempDERMap.put("2d4304601e6a2c2795ff5c53a139a692", 40);
        this.tempDERMap.put("147872752388a3eb61ee6fa509535a95", 0);
        this.tempDERMap.put("ef66309d7f46d5981e1e40b397eb1307", 20);
        this.tempDERMap.put("6db1ebd432ebbd32f3cffd47d42d0f54", 0);
        this.tempDERMap.put("5178f71b2300ce736f8c06c4ab595010", 20);
        this.tempDERMap.put("e01bbbd39dad3074f4e0b8ef0a7327df", 20);
        this.tempDERMap.put("4078a72ef6b29b7b7bf3a9b314e9d5cb", 20);
        this.tempDERMap.put("237e5169aad4783c886f951c31c171c8", 30);
        this.tempDERMap.put("2f67238a01113d43846a288a6f73b945", 20);
        this.tempDERMap.put("41c1d67aa61ece63f03ddf1525ba67c5", 0);
        this.tempDERMap.put("4764c3a84d1356e25892a546505e8a9f", 20);
        this.tempDERMap.put("3637535608e4a729d23ea7963aafe7e0", 30);
        this.tempDERMap.put("f258ad9608e7f2a639f4a820024b6db5", 30);
        this.tempDERMap.put("24c1fe70222ce34d147c9628df7371cc", 0);
        this.tempDERMap.put("23bf56511af00a088285e854e0b749dd", 20);
        this.tempDERMap.put("872ec2075cc0b7193283b025d1c0fc4f", 20);
        this.tempDERMap.put("ae23256684e557e761e835c842a4c65f", 20);
        this.tempDERMap.put("1bfa8f830d9bbd08ebf61aa256b607ae", 30);
        this.tempDERMap.put("378ec75d77d63ce1136dcdb18c97fb56", 60);
        this.tempDERMap.put("5bf8550e42525cde8a5bcabf9c7d405f", 0);
        this.tempDERMap.put("809f1dd8d73813f9186194c9b5273cff", 30);
        this.tempDERMap.put("36dffad149349dfd36afd66744ea4ff0", 0);
        this.noFKeyDERMap.put("b8672c012f6f32409c5e98173f3920b1", 0);
        this.noFKeyDERMap.put("c9ac1cfb6a27d9be060ad14b1389768c", 0);
        this.noFKeyDERMap.put("7ebb9e4f94e90d8125b9e979b3416607", 0);
        this.noFKeyDERMap.put("a59eda0aa3fc04754faef6c19165ab72", 0);
        this.noFKeyDERMap.put("a1f2e87051416a8df9b0dac8e6070e10", 0);
        this.noFKeyDERMap.put("3bee956f1baa63f3cac41ab904e0da79", 0);
        this.noFKeyDERMap.put("c21038cdc5f01a3c130659d459fb01b0", 0);
        this.noFKeyDERMap.put("f58ab6c926c482258d188f86332ec512", 0);
        this.noFKeyDERMap.put("ed8d0afdc183c01b74b8abcd27a4e0d9", 0);
        this.noFKeyDERMap.put("e2def3aee26f3e7c5208e67754be8e78", 0);
        this.noFKeyDERMap.put("b244fabe5b0be49031d9d7f2189efcd9", 0);
        this.noFKeyDERMap.put("f0913472520e0daa49ec784e9e5ec160", 0);
        this.noFKeyDERMap.put("40884e71f38454d7d2e7c18c4f364ddc", 0);
        this.noFKeyDERMap.put("be9f14b11ab7af99e58ed4c2fd2dc407", 0);
        this.noFKeyDERMap.put("267b88ba4b6a31163f7dedf7028e9c4b", 0);
        this.noFKeyDERMap.put("7d30e9782a125fec8be8c4ec53f5aff7", 0);
        this.noFKeyDERMap.put("61eac0bce4c883ebc46810c2cb8cff98", 0);
        this.noFKeyDERMap.put("997691c3f441a97448c59c92d9a00e41", 0);
        this.noFKeyDERMap.put("0d1967ef6b28b64042ab3de829522102", 0);
        this.noFKeyDERMap.put("1c8b8fc418cbacb13c5386ead04249ae", 0);
        this.noFKeyDERMap.put("2e8021c40ea9c9fb13fe934c0cd361ad", 0);
        this.noFKeyDERMap.put("db9d5cfb826be9c22cc20046bc0868f2", 0);
        this.noFKeyDERMap.put("c602b8988a712e7ba6262c019bd723d6", 0);
        this.noFKeyDERMap.put("439a858d42e057a4c1bcdc5de925d64f", 0);
        this.noFKeyDERMap.put("8972cac830827cf4e43e172ceb236ffd", 0);
        this.noFKeyDERMap.put("53346b39fd5d2b53828e8583b7061ad0", 0);
        this.noFKeyDERMap.put("b32ffa528badada73c7532600cf7c9d5", 0);
        this.noFKeyDERMap.put("d8062c4478202541faf15e16389c5acf", 0);
        this.noFKeyDERMap.put("0628c1e44041b3b1fc37becd5dcfd725", 0);
        this.noFKeyDERMap.put("74e5b604b6901c0673786ef3240d3686", 0);
        this.noFKeyDERMap.put("625bd7b74b99663fb01f91ec4c07d6a8", 0);
        this.noFKeyDERMap.put("432808f0344322358be2f2e7153b088f", 0);
        this.noFKeyDERMap.put("e7fbf2b27129c05721de8110d6530be5", 0);
        this.noFKeyDERMap.put("751d2e7a9c1d20349737de3a03c5b581", 0);
        this.noFKeyDERMap.put("271884f1ccbafe33c93991ee6d6ebd66", 0);
        this.noFKeyDERMap.put("d5f06221fddd8b63e4634c2e30d75779", 0);
        this.noFKeyDERMap.put("fdf115b309d4799641ed7e691d61a631", 0);
        this.noFKeyDERMap.put("83f367a14c29c3aaf9a326f8fd8b22d8", 0);
        this.noFKeyDERMap.put("df958687a02982a4cd68af51ad5732ef", 0);
        this.noFKeyDERMap.put("a0a110c3f3c7328f10e027bc9cbad882", 0);
        this.noFKeyDERMap.put("c63d3e12576fa39727d412500b8987f4", 0);
        this.noFKeyDERMap.put("ab31530b21b9769706f6a2fbeeb9f9a7", 0);
        this.noFKeyDERMap.put("7ce85a077bb668e95b95f5a9da239008", 0);
        this.noFKeyDERMap.put("b5e7541bd72872e393d39bdd5d06c603", 0);
        this.noFKeyDERMap.put("2dac86bb08a02a7b87a693ee967b924a", 0);
        this.noFKeyDERMap.put("2300f8b5c9b1fb4c9ce5691b56dd7ced", 0);
        this.noFKeyDERMap.put("e0bc5eb836303c9185b1ad6330e47a79", 0);
        this.noFKeyDERMap.put("6515a8655a2ca412399576662556a07d", 0);
        this.noFKeyDERMap.put("3a495d1648bf5af28c81902b2ebee167", 0);
        this.noFKeyDERMap.put("dda29339238999b1f46b3a8593c3cf2c", 0);
        this.noFKeyDERMap.put("17e6f9c584ba83b0cd1163709242073e", 0);
        this.noFKeyDERMap.put("6335ac94a05ec87ef6d7cf24a131aca2", 0);
        this.noFKeyDERMap.put("930419caf3325e2819f03aabcd283566", 0);
        this.noFKeyDERMap.put("67c4c9d3afb4c960bbe271fa351ce05e", 0);
        this.noFKeyDERMap.put("b7d303b5152650f365ed24605ba86aa2", 0);
        this.noFKeyDERMap.put("a68f3d524aa7c0a1951f5d5d3c0efc83", 0);
        this.noFKeyDERMap.put("24fdbcee29179817a56d2f12252217c4", 0);
        this.noFKeyDERMap.put("ae98d5da27ae1b905aa9267cb5f25a2f", 0);
        this.noFKeyDERMap.put("8bb2d5fef5e2928788fd47fff3af47c1", 0);
        this.noFKeyDERMap.put("d26058e5f6bedf33d866bc5338803ebd", 0);
        this.noFKeyDERMap.put("61869abf086e28ff0ac8789f10e9f415", 0);
        this.noFKeyDERMap.put("c5a0f02b98c7bdcd25c444a721df88c5", 0);
        this.noFKeyDERMap.put("f8a9ec4eceb0d12828793bca5e8f289d", 0);
        this.noFKeyDERMap.put("4b2a289206a372bbd0ba2ac7a27751c6", 0);
        this.noFKeyDERMap.put("479fc17e936293df0cfe2670970e57b5", 0);
        this.noFKeyDERMap.put("e523aae69386f31f28bc2ac4f0b0e058", 0);
        this.noFKeyDERMap.put("534032d54d81a1c9ef438767706e5c00", 0);
        this.noFKeyDERMap.put("a70762adb4bb9e12f7772d5134a92302", 0);
        this.noFKeyDERMap.put("1d4e81885e5044c1d422c759ac4a48b2", 0);
        this.noFKeyDERMap.put("7ab87fe55543d6b92d0a569716b982de", 0);
        this.noFKeyDERMap.put("4b83df8e7a31058949b2c010289d81d6", 0);
        this.noFKeyDERMap.put("a295adb53a39a511dea0d1801a64184b", 0);
        this.noFKeyDERMap.put("a18041f3a967c4d588adf3ed5682e436", 0);
        this.noFKeyDERMap.put("1e2d9fdba388047e02ad8b2e4cb8ea39", 0);
        this.noFKeyDERMap.put("eb751ef3ced5b2f39136c706a1cf8ac5", 0);
        this.noFKeyDERMap.put("9147ed7184373dfae772ea5db9afa2ec", 0);
        this.noFKeyDERMap.put("77D64820-2DC9-4828-87F7-2B3D20F78C2D", 0);
        this.noFKeyDERMap.put("CD16E202-1010-4C47-BBED-77DED600D88F", 0);
        this.noFKeyDERMap.put("0546BC6D-55EF-4035-A387-9ADDC5BAE305", 0);
        this.noFKeyDERMap.put("44B29146-69C1-4ADF-841D-287AD281BB1B", 0);
        this.noFKeyDERMap.put("BA8ECEB3-7D9A-496D-B667-4FA9377EAE61", 0);
        this.noFKeyDERMap.put("F3FE8428-161F-4FFE-B2C9-78418B5ED714", 0);
        this.noFKeyDERMap.put("D848A57B-A529-482F-AC73-977043C3FDAC", 0);
        this.noFKeyDERMap.put("1FA00E9F-A266-433E-8C95-9AA615F10D35", 0);
        this.noFKeyDERMap.put("168133AE-E7F2-4ECA-AEE7-6024461A186F", 0);
        this.noFKeyDERMap.put("90A67CD5-A745-49F6-B5A0-5761278A8C49", 0);
        this.noFKeyDERMap.put("F28672F2-1292-47FA-8AE4-172B90EE2DC3", 0);
        this.noFKeyDERMap.put("6245CA0A-5D44-4C18-99EF-2831C221858C", 0);
        this.noFKeyDERMap.put("ef1587d6f5d540e00e6e437d9316c58c", 0);
        this.noFKeyDERMap.put("3feea6298aae4e999a783d7561378a64", 0);
        this.noFKeyDERMap.put("a17a4a2ab57ea317cd7e738bf3831e68", 0);
        this.noFKeyDERMap.put("c17203ec07e1f96a2874e32845c3d7d5", 0);
        this.noFKeyDERMap.put("3fa3417d2d71c5ad22f8882c5d87d651", 0);
        this.noFKeyDERMap.put("224902d71445c0de37e5ee4ea533908c", 0);
        this.noFKeyDERMap.put("fe70205f264fdebbeaec94858e1bbe10", 0);
        this.noFKeyDERMap.put("005C8C79-8C7E-4A68-A7C3-1E8E0D09FCC4", 0);
        this.noFKeyDERMap.put("320BB681-03BC-4218-87F8-E425B288AE97", 0);
        this.noFKeyDERMap.put("A764D6F8-DCD8-4670-AE22-6984474CDD1C", 0);
        this.noFKeyDERMap.put("62982D23-52D6-46B4-86A3-A35358D31E3D", 0);
        this.noFKeyDERMap.put("875ac17b63d61a42fc2c10ea08bdb0b3", 0);
        this.noFKeyDERMap.put("6f9a0354fcb8c3bb46a1d3850b8a0c6b", 0);
        this.noFKeyDERMap.put("36bf01fc2b3ac83f69afd6da2796f402", 0);
        this.noFKeyDERMap.put("96260488e8bed85389b71c11a24f1a44", 0);
        this.noFKeyDERMap.put("61e6243931f832862076afaa844a977f", 0);
        this.noFKeyDERMap.put("7dcec06a38ff9564de13a605ee4823ee", 0);
        this.noFKeyDERMap.put("cb812b474a1c9bf7f2a8be256bb49055", 0);
        this.noFKeyDERMap.put("4c3d4b7182eec774d244f567a00afd1b", 0);
        this.noFKeyDERMap.put("daee18bc886a3a28c3d3b3d6e0596966", 0);
        this.noFKeyDERMap.put("97a5865275f36f0d0733c1c042bf24d4", 0);
        this.noFKeyDERMap.put("458668339a6b11998283585b2dd25d43", 0);
        this.noFKeyDERMap.put("7e50c97fca53fb6e409b9f74665b2085", 0);
        this.noFKeyDERMap.put("64da70c418bf9c4c6cce63ce79e24de6", 0);
        this.noFKeyDERMap.put("85c0e1204e7ac5e4fa1244c0746dfd14", 0);
        this.noFKeyDERMap.put("372f0158f1fa0a9ec894702996bad1ca", 0);
        this.noFKeyDERMap.put("a0db2656e218e1348af4941295593d49", 0);
        this.noFKeyDERMap.put("892c238b185ff2f01d68367524131c19", 0);
        this.noFKeyDERMap.put("4f201bc2830257138f0d4d5095b4fe43", 0);
        this.noFKeyDERMap.put("a1149c0cf281cf46f0ae70d7d1921522", 0);
        this.noFKeyDERMap.put("1bee3d42cc35ae68e2c216fd3450ace8", 0);
        this.noFKeyDERMap.put("a7ca173df623eafe0993ef8c1cb7ce56", 0);
        this.noFKeyDERMap.put("7e6e292c4bc8b87e33c746ce352b90f0", 0);
        this.noFKeyDERMap.put("dd5f14db2aeccd0eed9324a65fac48de", 0);
        this.noFKeyDERMap.put("3cae02ebc5bd30e35ddae8d16a3cd0c2", 0);
        this.noFKeyDERMap.put("7b453aaa66e868e643b1c9aca5693517", 0);
        this.noFKeyDERMap.put("bb94b6acab28ae9e1cf2f405e1c3264a", 0);
        this.noFKeyDERMap.put("1b25e755db35950ef32ae7cfddbd7faf", 0);
        this.noFKeyDERMap.put("d8c76c91fe392a2c0faf92062dd6c452", 0);
        this.noFKeyDERMap.put("0b044b27e25ee19cfe040cd81415cd47", 0);
        this.noFKeyDERMap.put("b8123e10420fe8980a775ac8c72dc53e", 0);
        this.noFKeyDERMap.put("0ac2095a17513e0c45e8197eeee36c74", 0);
        this.noFKeyDERMap.put("680db3b56b7848258f1a15207e32ff30", 0);
        this.noFKeyDERMap.put("7fa7874756b0fb58bd18e416f52f6875", 0);
        this.noFKeyDERMap.put("66e1e30e0bc4bfae89ce665de1964a45", 0);
        this.noFKeyDERMap.put("cf7c917a68307e36adca9c925a2c61e2", 0);
        this.noFKeyDERMap.put("c47882ff0eaf159c83e990c488fe0d37", 0);
        this.noFKeyDERMap.put("047f57d456c690f7980aaa1401df93e4", 0);
        this.noFKeyDERMap.put("7f406f8026b67851a280d4b7e1e857e2", 0);
        this.noFKeyDERMap.put("2c469d421154c8d8d75122ad4f730707", 0);
        this.noFKeyDERMap.put("1bafc28580978dea10ec07085f3bb1bc", 0);
        this.noFKeyDERMap.put("1ab40a1b4357755cca73b55fed1e54b0", 0);
        this.noFKeyDERMap.put("565f14dc9b5ddf1040712a6eb8930245", 0);
        this.noFKeyDERMap.put("306ececa7189fb847133b72331943844", 0);
        this.noFKeyDERMap.put("8234a761636256bbd8253d3e8c107ebe", 0);
        this.noFKeyDERMap.put("d0aba5c25e23babf16679c9958df34a8", 0);
        this.noFKeyDERMap.put("a493f16b07b8f307d8c0b1e19af4e40d", 0);
        this.noFKeyDERMap.put("a5fef7d3c3d83628026474cb89a84167", 0);
        this.noFKeyDERMap.put("7083cad47055980540527268a8ae7672", 0);
        this.noFKeyDERMap.put("f8d35a839733db879e6f7a493b656ec3", 0);
        this.noFKeyDERMap.put("aeb7bfbf73432a537c1eafdfaf9dc1d0", 0);
        this.noFKeyDERMap.put("886a3e81f3ada3a35a1ce0e38aa5f02b", 0);
        this.noFKeyDERMap.put("ae238f8abe9acf286ce3496ce0dad1ba", 0);
        this.noFKeyDERMap.put("a5417eca54d657bacb22335882fe7a2a", 0);
        this.noFKeyDERMap.put("c9867245d17c72be1031ca2e815da928", 0);
        this.noFKeyDERMap.put("0b37bf9545dab1f9fa6216477965c4b2", 0);
        this.noFKeyDERMap.put("59737e86216cd340167139f6e6a6d153", 0);
        this.noFKeyDERMap.put("ff94c1b6b22b3d4b364b80f249b7a7c6", 0);
        this.noFKeyDERMap.put("52871e1e9eb54ec78886e670bdb5e3b1", 0);
        this.noFKeyDERMap.put("44c5690d8d3c5229afd4a34575e0c9f2", 0);
        this.noFKeyDERMap.put("00d9c96b5551cce5d66f0769b52aa33d", 0);
        this.noFKeyDERMap.put("cec60d771a71e39dfdcc271c555fd95c", 0);
        this.noFKeyDERMap.put("76cadfb9069f1e6e2950ff5ca6486c11", 0);
        this.noFKeyDERMap.put("1e6b3d2ed6c04d7cf7a2f909a1c893fe", 0);
        this.noFKeyDERMap.put("28a3ebeb21746b416d5d79d55ab69a99", 0);
        this.noFKeyDERMap.put("2579d24f651e621f70b0cceae76d16e3", 0);
        this.noFKeyDERMap.put("4348d6a9e7d26511133fcd5a67836e00", 0);
        this.noFKeyDERMap.put("bc00fe40691a4e8085afbb600fd55962", 0);
        this.noFKeyDERMap.put("52121b3425bfad3c438997aaefbd14d9", 0);
        this.noFKeyDERMap.put("de031e4448028217dd148e73e4b01aeb", 0);
        this.noFKeyDERMap.put("5b9c340821037f0bad8d7049c7838352", 0);
        this.noFKeyDERMap.put("87f3bd6b8093e089f072f42bdc44b83a", 0);
        this.noFKeyDERMap.put("e9cb213ec08b977fd814edc88d43d971", 0);
        this.noFKeyDERMap.put("e906aa101507398e69eda987fe025ee8", 0);
        this.noFKeyDERMap.put("e54c863b8e1cce768924bca026ea3817", 0);
        this.noFKeyDERMap.put("ea799c2127591fb6aa2a00c15078fa70", 0);
        this.noFKeyDERMap.put("dc8715f09a380534effa458507fd7fe1", 0);
        this.noFKeyDERMap.put("344b2b844178e9fbe91b03a960af0b18", 0);
        this.noFKeyDERMap.put("cbacc1c3b0f40280a045e99d66626f39", 0);
        this.noFKeyDERMap.put("70a0d8e4132ddad9b1b54bd2ddb6987d", 0);
        this.noFKeyDERMap.put("148ebe7e91243486860b30c79c29a2a8", 0);
        this.noFKeyDERMap.put("c145efe206fc522cda5437a9f93e9b70", 0);
        this.noFKeyDERMap.put("1552e3ee7b2e2ceaf331ad17fd361d01", 0);
        this.noFKeyDERMap.put("82fe89783086afbfd8b4d54a5fce8ae7", 0);
        this.noFKeyDERMap.put("676667c10979d7e34ba6d638eb06e0fc", 0);
        this.noFKeyDERMap.put("89b33522e88a7244e64276aa6f871ec6", 0);
        this.noFKeyDERMap.put("68fcce994a19e4146aebe5901be09e5d", 0);
        this.noFKeyDERMap.put("3eb49b501b5225cc8fd63bd7c0a14f5d", 0);
        this.noFKeyDERMap.put("3e726c12994f8b09aa294c7199ef85a7", 0);
        this.noFKeyDERMap.put("f010f7f0314143c04f875ee1dbb86c47", 0);
        this.noFKeyDERMap.put("191f55822cebd7174fb74d23687454f8", 0);
        this.noFKeyDERMap.put("a1b5bf347a7c02b0ab49517f04e79328", 0);
        this.noFKeyDERMap.put("08587a30b90ad86d30ef3152df8235e9", 0);
        this.noFKeyDERMap.put("db33c4eab208a86ff80d286dcf8db956", 0);
        this.noFKeyDERMap.put("9dd57bfd6ede603c48420cf171492f85", 0);
        this.noFKeyDERMap.put("4e8cd8becc651c95b5efe11f1ee9341d", 0);
        this.noFKeyDERMap.put("d7d37727d3013f4416293e8589cec289", 0);
        this.noFKeyDERMap.put("101e13fbc3ff36ed76163c400130c75f", 0);
        this.noFKeyDERMap.put("b04dc4cc3e0f05a790e78e6eddaf9a15", 0);
        this.noFKeyDERMap.put("1916227f271272c921d5c8bebaa87451", 0);
        this.noFKeyDERMap.put("7cb33cd6247d17279377c3caabbf17c5", 0);
        this.noFKeyDERMap.put("f3501f112a7f0f9962d1619f4c0d160d", 0);
        this.noFKeyDERMap.put("f8831c72c3f1cb5a4366e51dfb89b285", 0);
        this.noFKeyDERMap.put("5ccda2cb500e4846c43e8a12193007f1", 0);
        this.noFKeyDERMap.put("9e4133259ac5c5470d798a240d2b02c4", 0);
        this.noFKeyDERMap.put("be1a2a547c4f58a3e477b4b21b4d8e23", 0);
        this.noFKeyDERMap.put("09e160c03aa0252f1adc28afafbd6b26", 0);
        this.noFKeyDERMap.put("c7c02eb7a2ed501f3864023772ad8fbc", 0);
        this.noFKeyDERMap.put("758711063f599a3aee8804d10b57c3cf", 0);
        this.noFKeyDERMap.put("cbd7660c967c8482cc09290067912d68", 0);
        this.noFKeyDERMap.put("fb263ef509824f538760025061fa4965", 0);
        this.noFKeyDERMap.put("6bcf10132132b64e7cf67f035316d8e7", 0);
        this.noFKeyDERMap.put("6bb7800321d58a7e2bd7fe9d0d9797be", 0);
        this.noFKeyDERMap.put("0075a891b849d0deefb623ee1ad815ac", 0);
        this.noFKeyDERMap.put("d35c037d266c808f391da5f413193eb4", 0);
        this.noFKeyDERMap.put("6c061d725bcd919dc264833feecc7f28", 0);
        this.noFKeyDERMap.put("a8f156b1ce43664ba5ed30b45c36ec57", 0);
        this.noFKeyDERMap.put("ef37a297f2f12b0439f9e9201cca3259", 0);
        this.noFKeyDERMap.put("fb1d8016e4e7031605b4ff42a861e870", 0);
        this.noFKeyDERMap.put("e2d4a5a0bc0f7b2d4dbf260c1c671c42", 0);
        this.noFKeyDERMap.put("7a289964f82604d0393e5cb46d1f0bfe", 0);
        this.noFKeyDERMap.put("654445e3693a13fd23e6f9b1a5cd0a88", 0);
        this.noFKeyDERMap.put("b2167ad310d7fd5818544f802a9346f0", 0);
        this.noFKeyDERMap.put("8202103eb7f7597fbb1e32166a428927", 0);
        this.noFKeyDERMap.put("ade7dda497a8304182777f64d7240030", 0);
        this.noFKeyDERMap.put("35efbcbef01d22cc3f67903f69f3d3c5", 0);
        this.noFKeyDERMap.put("0cf061aca28387c0e31bf1240aa87f10", 0);
        this.noFKeyDERMap.put("b345f832ea6a098ac3abf43fa2c531b1", 0);
        this.noFKeyDERMap.put("4eec1388b517b3b6e65e04e8da7939e7", 0);
        this.noFKeyDERMap.put("8149547230e46262c01b8c71b8a90ca4", 0);
        this.noFKeyDERMap.put("f9f7f4ba5ddf8fd5da4696c7e9ba2946", 0);
        this.noFKeyDERMap.put("f48a62b176be075418de8ab0f8480cbd", 0);
        this.noFKeyDERMap.put("d466f4da08bdfad5b858604d53803eb1", 0);
        this.noFKeyDERMap.put("5e65ce33580ec181c20a0f3aeb01fa66", 0);
        this.noFKeyDERMap.put("281b754b1675f9b5a168b299f5da1d25", 0);
        this.noFKeyDERMap.put("3ded93bd5f63090b808661b390dbeb63", 0);
        this.noFKeyDERMap.put("fdfbe24d650e0e17a5be76400dc7081c", 0);
        this.noFKeyDERMap.put("f63cb35805f14277f5851641d6cb8578", 0);
        this.noFKeyDERMap.put("bd8aea9c24846153b56da2f1dc7d1676", 0);
        this.noFKeyDERMap.put("6094c23478e19bf64df57bccd66397e6", 0);
        this.noFKeyDERMap.put("6d8b9672a96f70d27e77dbe00d60a84e", 0);
        this.noFKeyDERMap.put("0dd8d445292d4fb614df37101a364689", 0);
        this.noFKeyDERMap.put("d0fd62d03b96a4493a595d8240be3363", 0);
        this.noFKeyDERMap.put("5eb782e25441c7ad826c06bbe01afda1", 0);
        this.noFKeyDERMap.put("168bcccc6ab2a9c86a4f3d7479f19a27", 0);
        this.noFKeyDERMap.put("479da50fae615952ba75f4715953f016", 0);
        this.noFKeyDERMap.put("a49c052989fb77e9c9d0259f093fdfca", 0);
        this.noFKeyDERMap.put("2c861de07608538ba7e493a01b31801f", 0);
        this.noFKeyDERMap.put("db090f2dcff9faa4ba6c5fbe0c218e56", 0);
        this.noFKeyDERMap.put("2bddd2716470672ea1067e31f521e882", 0);
        this.noFKeyDERMap.put("2d62b87b909df832a9249b270d6a27ad", 0);
        this.noFKeyDERMap.put("5996311bfd2e57b363a7e0b1212ede8d", 0);
        this.noFKeyDERMap.put("4b04edf5e4c9a0f967966f7780f54e73", 0);
        this.noFKeyDERMap.put("a1aeab8fc135b3f16d1837a8f3d71980", 0);
        this.noFKeyDERMap.put("27c9cf6e971a77d2b1ccf2c912a801ac", 0);
        this.noFKeyDERMap.put("f4dae444f5a1db376d47ec0b572f21e2", 0);
        this.noFKeyDERMap.put("f1e30b3900097bccde0b7dcf3408dba5", 0);
        this.noFKeyDERMap.put("f120d9905edcd5143c41b883a7085f82", 0);
        this.noFKeyDERMap.put("e69090473250e06dce5579a0a1192271", 0);
        this.noFKeyDERMap.put("cbaab45c53a061331e65e9e7800f9487", 0);
        this.noFKeyDERMap.put("b4ac7b26eb25e8c1b9feaeb7f42bcc7c", 0);
        this.noFKeyDERMap.put("09761f3d8ec18675407cf16001ad3d23", 0);
        this.noFKeyDERMap.put("238b05e3d4089bf5e8c858aa7ea6fda2", 0);
        this.noFKeyDERMap.put("41608deed51224ed59077041103df6bd", 0);
        this.noFKeyDERMap.put("e5e154215b3e74c010e08e4a289106fe", 0);
        this.noFKeyDERMap.put("e439ef7416ee4d8bb06a3842bee4124f", 0);
        this.noFKeyDERMap.put("5003ac8b52be202d64f9cb09bd4a1541", 0);
        this.noFKeyDERMap.put("64e3ec85d60584508075e705d0aa54de", 0);
        this.noFKeyDERMap.put("5db7959386bf595c9fdad8a184912197", 0);
        this.noFKeyDERMap.put("7c6581e92f71510f86a847397ba9725c", 0);
        this.noFKeyDERMap.put("4d2d24a910ff5910845da3cf96c4b7ae", 0);
        this.noFKeyDERMap.put("c08b870c190c76d3e36fe241e75a5a34", 0);
        this.noFKeyDERMap.put("dc23200fb98dcf3f531f5c0b910b6f4c", 0);
        this.noFKeyDERMap.put("0e8516cce4de4141f5b43da399b75e30", 0);
        this.noFKeyDERMap.put("9963361fc8e51dc3136dae87af147425", 0);
        this.noFKeyDERMap.put("e7cf445153dfdc370243e712abaf570b", 0);
        this.noFKeyDERMap.put("85501d41d0a8afcfcfb4613bb6fa7629", 0);
        this.noFKeyDERMap.put("b77e8006f42213421017089e14bde399", 0);
        this.noFKeyDERMap.put("c178a4964f65ddd42388b212d57caa19", 0);
        this.noFKeyDERMap.put("9ce2e0b41cd0279b6dd86bf3f3d084d5", 0);
        this.noFKeyDERMap.put("0e90186ebcf32fc187d3512ca2e23200", 0);
        this.noFKeyDERMap.put("29ce405825d6aed9ca69ab62cbbabcea", 0);
        this.noFKeyDERMap.put("53366e8c3ab69d8e6651bdc793fe2e07", 0);
        this.noFKeyDERMap.put("ecee0f341ef6245bc6e63aed0372cae4", 0);
        this.noFKeyDERMap.put("ee0a0186b96fac26ef92f99f43f3c6f3", 0);
        this.noFKeyDERMap.put("0ebd2a9607dbd25b3106629bda446ebd", 0);
        this.noFKeyDERMap.put("d26b4b41c54ccccac87ed277d496c822", 0);
        this.noFKeyDERMap.put("78b6175d68bea2323e882ecf577989cd", 0);
        this.noFKeyDERMap.put("a826417e3f7701eb27ef2f53c38da812", 0);
        this.noFKeyDERMap.put("d0f8ecec040533c9cf7163cef9c0b905", 0);
        this.noFKeyDERMap.put("c6a51aa656140d7c3b185f430b436609", 0);
        this.noFKeyDERMap.put("f4d8a5a9b544e5b07596a1a9bc42ee76", 0);
        this.noFKeyDERMap.put("667736E8-E0DE-4FEA-96CF-2EF9E04DB7A8", 0);
        this.noFKeyDERMap.put("e0e6be2809cb643e735166d0a7ea0646", 0);
        this.noFKeyDERMap.put("9c22eb287e6d37eb87d65d3afa449ab1", 0);
        this.noFKeyDERMap.put("49b7574fdf7ffabdbb2cc0f016da6026", 0);
        this.noFKeyDERMap.put("eba6203484b475366742267f049feeda", 0);
        this.noFKeyDERMap.put("026e9402b243cf92db2169c9aa0b9b92", 0);
        this.noFKeyDERMap.put("9931a8537a1ed3d7158e9a4fcde10c34", 0);
        this.noFKeyDERMap.put("fec65aca388360d64ce14c4bd62536b0", 0);
        this.noFKeyDERMap.put("3f37f3b2e31091d2b444c3b2d6092244", 0);
        this.noFKeyDERMap.put("409df22fdf3dcd8866c05cf4cf51c9f8", 0);
        this.noFKeyDERMap.put("932b947acd984b067d53650aae707ad3", 0);
        this.noFKeyDERMap.put("514833d6c2014a5964bda5b3206b34b3", 0);
        this.noFKeyDERMap.put("22749857599b931e5028c0d4f100f09d", 0);
        this.tempDEMap.put("PSAPPMENU", 1);
        this.tempDEMap.put("PSAPPMENUITEM", 0);
        this.tempDEMap.put("PSAPPPORTALVIEW", 1);
        this.tempDEMap.put("PSAPPVIEW", 1);
        this.tempDEMap.put("PSCODEITEM", 0);
        this.tempDEMap.put("PSCODELIST", 1);
        this.tempDEMap.put("PSDEACMODE", 1);
        this.tempDEMap.put("PSDEACTION", 1);
        this.tempDEMap.put("PSDEDATAQUERY", 1);
        this.tempDEMap.put("PSDEDATARELATION", 1);
        this.tempDEMap.put("PSDEDATASET", 1);
        this.tempDEMap.put("PSDEDQCOND", 0);
        this.tempDEMap.put("PSDEDQJOIN", 0);
        this.tempDEMap.put("PSDEDRDETAIL", 0);
        this.tempDEMap.put("PSDEDSDQ", 0);
        this.tempDEMap.put("PSDEFIVR", 0);
        this.tempDEMap.put("PSDEFORM", 1);
        this.tempDEMap.put("PSDEFORMDETAIL", 0);
        this.tempDEMap.put("PSDEFVALUERULE", 1);
        this.tempDEMap.put("PSDEFVRCOND", 0);
        this.tempDEMap.put("PSDEGRID", 1);
        this.tempDEMap.put("PSDEGRIDCOL", 0);
        this.tempDEMap.put("PSDELOGIC", 1);
        this.tempDEMap.put("PSDELOGICLINK", 0);
        this.tempDEMap.put("PSDELOGICNODE", 0);
        this.tempDEMap.put("PSDETBITEM", 0);
        this.tempDEMap.put("PSDETOOLBAR", 1);
        this.tempDEMap.put("PSDEVIEWBASE", 1);
        this.tempDEMap.put("PSDEVIEWCTRL", 0);
        this.tempDEMap.put("PSDEVIEWLOGIC", 0);
        this.tempDEMap.put("PSDEVIEWRV", 0);
        this.tempDEMap.put("PSDEFDLOGIC", 0);
        this.tempDEMap.put("PSDEFIUPDATE", 0);
        this.tempDEMap.put("PSDELOGICPARAM", 0);
        this.tempDEMap.put("PSDELLCOND", 0);
        this.tempDEMap.put("PSDELNPARAM", 0);
        this.tempDEMap.put("PSDEFIUDETAIL", 0);
        this.tempDEMap.put("PSDEUAGROUP", 1);
        this.tempDEMap.put("PSDEUAGRPDETAIL", 0);
        this.tempDEMap.put("PSDEFORMRF", 0);
        this.tempDEMap.put("PSDEDATAVIEW", 1);
        this.tempDEMap.put("PSDEMAPDETAIL", 0);
        this.tempDEMap.put("PSDEMAP", 1);
        this.tempDEMap.put("PSWFVERSION", 1);
        this.tempDEMap.put("PSWFPROCESS", 0);
        this.tempDEMap.put("PSWFLINK", 0);
        this.tempDEMap.put("PSWFPROCROLE", 0);
        this.tempDEMap.put("PSWFLINKCOND", 0);
        this.tempDEMap.put("PSWFPROCSUBWF", 0);
        this.tempDEMap.put("PSWFLINKROLE", 0);
        this.tempDEMap.put("PSWFPROCPARAM", 0);
        this.tempDEMap.put("PSDETREEVIEW", 1);
        this.tempDEMap.put("PSDETREENODE", 0);
        this.tempDEMap.put("PSDETREENODERS", 0);
        this.tempDEMap.put("PSDECHART", 1);
        this.tempDEMap.put("PSDECHARTPARAM", 0);
        this.tempDEMap.put("PSDEDSGRPPARAM", 0);
        this.tempDEMap.put("PSDECHARTAXES", 0);
        this.tempDEMap.put("PSAPPPVPART", 0);
        this.tempDEMap.put("PSDELISTITEM", 0);
        this.tempDEMap.put("PSDELIST", 1);
        this.tempDEMap.put("PSDEMAINSTATE", 1);
        this.tempDEMap.put("PSDEPSLNASGRP", 1);
        this.tempDEMap.put("PSDEPSLNASITEM", 0);
        this.tempDEMap.put("PSDEACMODEITEM", 0);
        this.tempDEMap.put("PSDEMSACTION", 0);
        this.tempDEMap.put("PSDEDATAIMP", 1);
        this.tempDEMap.put("PSDEDBINDEX", 1);
        this.tempDEMap.put("PSDEDBIDXFIELD", 0);
        this.tempDEMap.put("PSDEREPORT", 1);
        this.tempDEMap.put("PSDEREPITEM", 0);
        this.tempDEMap.put("PSSYSTCASSERT", 0);
        this.tempDEMap.put("PSSYSTCINPUT", 0);
        this.tempDEMap.put("PSSYSTESTCASE", 1);
        this.tempDEMap.put("PSSYSTESTDATA", 1);
        this.tempDEMap.put("PSSYSTDITEM", 0);
        this.tempDEMap.put("PSSYSERMAP", 1);
        this.tempDEMap.put("PSSYSERMAPNODE", 0);
        this.tempDEMap.put("PSDEGEIUPDATE", 0);
        this.tempDEMap.put("PSDEGEIUDETAIL", 0);
        this.tempDEMap.put("PSDEWIZARDSTEP", 0);
        this.tempDEMap.put("PSDEWIZARD", 1);
        this.tempDEMap.put("PSDEWIZARDFORM", 0);
        this.tempDEMap.put("PSVIEWMSGGRPDETAIL", 0);
        this.tempDEMap.put("PSVIEWMSGGROUP", 1);
        this.tempDEMap.put("PSCTRLMSG", 10);
        this.tempDEMap.put("PSCTRLMSGITEM", 0);
        this.tempDEMap.put("PSDEACTIONWIZARD", 1);
        this.tempDEMap.put("PSDEAWITEM", 0);
        this.tempDEMap.put("PSDEAWGROUP", 1);
        this.tempDEMap.put("PSDEAWGRPDETAIL", 0);
        this.tempDEMap.put("PSDETREENODERV", 0);
        this.tempDEMap.put("PSWXMENU", 1);
        this.tempDEMap.put("PSWXMENUITEM", 0);
        this.tempDEMap.put("PSSYSDBPART", 0);
        this.tempDEMap.put("PSDERTAW", 1);
        this.tempDEMap.put("PSDERTAWI", 0);
        this.tempDEMap.put("PSDEMSOPPRIV", 0);
        this.tempDEMap.put("PSSYSVIEWPANEL", 1);
        this.tempDEMap.put("PSSYSVIEWPANELITEM", 0);
        this.tempDEMap.put("PSSYSSEARCHBAR", 1);
        this.tempDEMap.put("PSSYSSEARCHBARITEM", 0);
        this.tempDEMap.put("PSSYSDASHBOARD", 1);
        this.tempDEMap.put("PSDEDATAIMPITEM", 0);
        this.tempDEMap.put("PSDEACTIONPARAM", 0);
        this.tempDEMap.put("PSDETREENODECOL", 0);
        this.tempDEMap.put("PSDETREECOL", 0);
    }
}

