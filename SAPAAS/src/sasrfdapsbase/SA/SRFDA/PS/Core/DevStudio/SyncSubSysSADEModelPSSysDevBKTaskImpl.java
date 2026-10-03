/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DataTypes
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEAction
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEActionService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPIBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonObjectSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonProperties;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonProperty;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonSimpleSchema;
import SA.SRFDA.PS.Core.DynaModel.PSOpenAPI3SchemaModelImpl;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3JsonNodeSchemas;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Operation;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Path;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Paths;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Schema;
import SA.SRFDA.PS.Data.PSSysDynaModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SyncSubSysSADEModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SyncSubSysSADEModelPSSysDevBKTaskImpl.class);
    public static final String CONTENTTYPE_JSON = "application/json";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getTASKPARAM())) {
            return "\u6ca1\u6709\u6307\u5b9a\u540c\u6b65\u5b50\u7cfb\u7edf\u63a5\u53e3";
        }
        PSSubSysServiceAPIService psSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSubSysServiceAPI psSubSysServiceAPI2 = new PSSubSysServiceAPI();
        psSubSysServiceAPI2.setPSSubSysServiceAPIId(this.psSysDevBKTask.getTASKPARAM());
        psSubSysServiceAPIService.get(psSubSysServiceAPI2);
        PSOpenAPI3SchemaModelImpl iPSOpenAPI3Schema = null;
        if (psSubSysServiceAPI2.getPSSysDynaModel() != null && StringHelper.compare((String)psSubSysServiceAPI2.getPSSysDynaModel().getDynaModelUsage(), (String)"OPENAPI3SCHEMA", (boolean)false) == 0) {
            IPSDevSlnSys iPSDevSlnSys = PSObjectFactory.getPSModelStorage().getPSDevSlnSys(this.getPSDevSlnSysId());
            IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
            PSSysDynaModel psSysDynaModel = new PSSysDynaModel();
            psSysDynaModel.setPSSYSDYNAMODELID(psSubSysServiceAPI2.getPSSysDynaModel().getPSSysDynaModelId());
            psSysDynaModel.setPSSYSDYNAMODELNAME(psSubSysServiceAPI2.getPSSysDynaModel().getPSSysDynaModelName());
            psSysDynaModel.setDYNAMODELUSAGE("OPENAPI3SCHEMA");
            psSysDynaModel.setDYNAMODEL(psSubSysServiceAPI2.getPSSysDynaModel().getDynaModel());
            psSysDynaModel.setDYNAMODEL2(psSubSysServiceAPI2.getPSSysDynaModel().getDynaModel2());
            PSOpenAPI3SchemaModelImpl psOpenAPI3SchemaImpl = new PSOpenAPI3SchemaModelImpl();
            psOpenAPI3SchemaImpl.init(this.getDAGlobalHelper(), iPSSystem, psSysDynaModel);
            iPSOpenAPI3Schema = psOpenAPI3SchemaImpl;
        }
        try {
            String strRet2;
            PSCoreSysServiceBase.setCurrentPSSystemId((String)psSubSysServiceAPI2.getPSSystemId());
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)this.getPSDevSlnSysId());
            String strRet = "";
            if (iPSOpenAPI3Schema != null) {
                strRet = this.syncSADEModel(psSubSysServiceAPI2, iPSOpenAPI3Schema);
            }
            if (!StringHelper.isNullOrEmpty((String)(strRet2 = this.syncSADEModel(psSubSysServiceAPI2)))) {
                strRet = !StringHelper.isNullOrEmpty((String)strRet) ? String.valueOf(strRet) + strRet2 : strRet2;
            }
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            return strRet;
        }
        catch (Exception ex) {
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            throw ex;
        }
    }

    protected String syncSADEModel(PSSubSysServiceAPI psSubSysServiceAPI) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(psSubSysServiceAPI.getPSSystemId());
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)sessionFactory);
        PSSubSysSADEService psSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)sessionFactory);
        ArrayList<PSDataEntity> psDataEntityList = psDataEntityService.selectByPSSubSysServiceAPI((PSSubSysServiceAPIBase)psSubSysServiceAPI);
        ArrayList<PSSubSysSADE> psSubSysSADEList = psSubSysSADEService.selectByPSSubSysServiceAPI((PSSubSysServiceAPIBase)psSubSysServiceAPI);
        for (PSSubSysSADE psSubSysSADE : psSubSysSADEList) {
            String strSyncMode = psSubSysSADE.getSyncModelMode();
            if (StringHelper.compare((String)strSyncMode, (String)"FROMDE", (boolean)true) == 0 || StringHelper.compare((String)strSyncMode, (String)"TODE", (boolean)true) != 0) continue;
            for (PSDataEntity psDataEntity : psDataEntityList) {
                String strRet;
                if (StringHelper.compare((String)psDataEntity.getPSSubSysSADEId(), (String)psSubSysSADE.getPSSubSysSADEId(), (boolean)false) != 0 || StringHelper.isNullOrEmpty((String)(strRet = this.syncToDEModel(psSubSysServiceAPI, psSubSysSADE, psDataEntity)))) continue;
                sBuilderEx.append(strRet);
                sBuilderEx.append("\r\n");
            }
        }
        return sBuilderEx.toString();
    }

    protected String syncFromDEModel(PSSubSysServiceAPI psSubSysServiceAPI, PSDataEntity psDataEntity, PSSubSysSADE psSubSysSADE) throws Exception {
        return null;
    }

    protected String syncToDEModel(PSSubSysServiceAPI psSubSysServiceAPI, PSSubSysSADE psSubSysSADE, PSDataEntity psDataEntity) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)sessionFactory);
        PSDEActionService psDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)sessionFactory);
        PSDEDataSetService psDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)sessionFactory);
        ArrayList<PSSubSysSADEField> psSubSysSADEFieldList = psSubSysSADE.getPSSubSysSADEFields();
        ArrayList<PSDEField> psDEFieldList = psDataEntity.getPSDEFields();
        for (PSSubSysSADEField psSubSysSADEField : psSubSysSADEFieldList) {
            PSDEField psDEField2;
            if (!DataObject.getBoolValue((Integer)psSubSysSADEField.getValidFlag(), (boolean)true)) continue;
            boolean bCreate = true;
            for (PSDEField psExistingDEField : psDEFieldList) {
                if (StringHelper.isNullOrEmpty((String)psExistingDEField.getPSSubSysSADEFieldId()) || StringHelper.compare((String)psExistingDEField.getPSSubSysSADEFieldId(), (String)psSubSysSADEField.getPSSubSysSADEFieldId(), (boolean)false) != 0) continue;
                bCreate = false;
                break;
            }
            if (!bCreate) continue;
            for (PSDEField psExistingDEField : psDEFieldList) {
                if (!StringHelper.isNullOrEmpty((String)psExistingDEField.getPSSubSysSADEFieldId()) || StringHelper.compare((String)psExistingDEField.getPSDEFieldName(), (String)psSubSysSADEField.getPSSubSysSADEFieldName(), (boolean)true) != 0) continue;
                PSDEField psDEField22 = new PSDEField();
                psDEField22.setPSDEFieldId(psExistingDEField.getPSDEFieldId());
                psDEField22.setPSSubSysSADEFieldId(psSubSysSADEField.getPSSubSysSADEFieldId());
                psDEFieldService.sysUpdate(psDEField22, false);
                sBuilderEx.append(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u7ed1\u5b9a\u5c5e\u6027[%2$s]\r\n", (Object)psDataEntity.getPSDataEntityName(), (Object)psExistingDEField.getPSDEFieldName()));
                bCreate = false;
                break;
            }
            if (!bCreate) continue;
            psDEField2 = new PSDEField();
            psDEField2.setPSDEFieldName(psSubSysSADEField.getPSSubSysSADEFieldName().toUpperCase());
            psDEField2.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEField2.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEField2.setPKey(psSubSysSADEField.getPKey());
            psDEField2.setMajorField(psSubSysSADEField.getMajorField());
            psDEField2.setAllowEmpty(psSubSysSADEField.getAllowEmpty());
            if (psDEField2.getAllowEmpty() == null) {
                psDEField2.setAllowEmpty(Integer.valueOf(1));
            }
            psDEField2.setDEFType(Integer.valueOf(1));
            psDEField2.setLogicName(psSubSysSADEField.getLogicName());
            if (StringHelper.isNullOrEmpty((String)psDEField2.getLogicName())) {
                psDEField2.setLogicName(psSubSysSADEField.getPSSubSysSADEFieldName());
            }
            psDEField2.setCodeName(psSubSysSADEField.getCodeName());
            psDEField2.setPSDataTypeId(psSubSysSADEField.getPSDataTypeId());
            psDEField2.setPSDataTypeName(psSubSysSADEField.getPSDataTypeName());
            if (StringHelper.isNullOrEmpty((String)psDEField2.getPSDataTypeId())) {
                if (psSubSysSADEField.getStdDataType() != null) {
                    psDEField2.setPSDataTypeId(DataTypes.toString((int)psSubSysSADEField.getStdDataType()));
                }
                if (StringHelper.isNullOrEmpty((String)psDEField2.getPSDataTypeId())) {
                    psDEField2.setPSDataTypeId("TEXT");
                }
            }
            psDEField2.setLength(psSubSysSADEField.getLength());
            psDEField2.setPrecision2(psSubSysSADEField.getPrecision2());
            psDEField2.setOrderValue(psSubSysSADEField.getOrderValue());
            psDEFieldService.create(psDEField2, false);
            sBuilderEx.append(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u5c5e\u6027[%2$s]\r\n", (Object)psDataEntity.getPSDataEntityName(), (Object)psDEField2.getPSDEFieldName()));
            PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
        }
        ArrayList<PSSubSysSADetail> psSubSysSADetailList = psSubSysSADE.getPSSubSysSADetails();
        ArrayList<PSDEAction> psDEActionList = psDataEntity.getPSDEActions();
        ArrayList<PSDEDataSet> psDEDataSetList = psDataEntity.getPSDEDataSets();
        for (PSSubSysSADetail psSubSysSADetail : psSubSysSADetailList) {
            PSDEAction psDEAction2;
            if (!DataObject.getBoolValue((Integer)psSubSysSADetail.getValidFlag(), (boolean)true) || StringHelper.compare((String)psSubSysSADetail.getDetailType(), (String)"DEACTION", (boolean)false) != 0) continue;
            boolean bCreate = true;
            for (PSDEAction psExistingDEAction : psDEActionList) {
                if (StringHelper.isNullOrEmpty((String)psExistingDEAction.getPSSubSysSADetailId()) || StringHelper.compare((String)psExistingDEAction.getPSSubSysSADetailId(), (String)psSubSysSADetail.getPSSubSysSADetailId(), (boolean)false) != 0) continue;
                bCreate = false;
                break;
            }
            if (!bCreate) continue;
            for (PSDEAction psExistingDEAction : psDEActionList) {
                if (!StringHelper.isNullOrEmpty((String)psExistingDEAction.getPSSubSysSADetailId()) || StringHelper.compare((String)psExistingDEAction.getCodeName(), (String)psSubSysSADetail.getCodeName(), (boolean)true) != 0) continue;
                PSDEAction psDEAction22 = new PSDEAction();
                psDEAction22.setPSDEActionId(psExistingDEAction.getPSDEActionId());
                psDEAction22.setPSSubSysSADetailId(psSubSysSADetail.getPSSubSysSADetailId());
                psDEActionService.sysUpdate(psDEAction22, false);
                sBuilderEx.append(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u7ed1\u5b9a\u884c\u4e3a[%2$s]\r\n", (Object)psDataEntity.getPSDataEntityName(), (Object)psExistingDEAction.getPSDEActionName()));
                bCreate = false;
                break;
            }
            if (!bCreate) continue;
            psDEAction2 = new PSDEAction();
            psDEAction2.setPSDEActionName(psSubSysSADetail.getCodeName().toUpperCase());
            psDEAction2.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEAction2.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEAction2.setLogicName(psSubSysSADetail.getPSSubSysSADetailName());
            psDEAction2.setCodeName(psSubSysSADetail.getCodeName());
            psDEAction2.setPSSubSysSADetailId(psSubSysSADetail.getPSSubSysSADetailId());
            psDEAction2.setActionType("USERCUSTOM");
            psDEActionService.create(psDEAction2, false);
            sBuilderEx.append(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u884c\u4e3a[%2$s]\r\n", (Object)psDataEntity.getPSDataEntityName(), (Object)psDEAction2.getPSDEActionName()));
            PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
        }
        for (PSSubSysSADetail psSubSysSADetail : psSubSysSADetailList) {
            PSDEDataSet psDEDataSet2;
            if (!DataObject.getBoolValue((Integer)psSubSysSADetail.getValidFlag(), (boolean)true) || StringHelper.compare((String)psSubSysSADetail.getDetailType(), (String)"FETCH", (boolean)false) != 0 || StringHelper.isNullOrEmpty((String)psSubSysSADetail.getCodeName2())) continue;
            boolean bCreate = true;
            for (PSDEDataSet psExistingDEDataSet : psDEDataSetList) {
                if (StringHelper.isNullOrEmpty((String)psExistingDEDataSet.getPSSubSysSADetailId()) || StringHelper.compare((String)psExistingDEDataSet.getPSSubSysSADetailId(), (String)psSubSysSADetail.getPSSubSysSADetailId(), (boolean)false) != 0) continue;
                bCreate = false;
                break;
            }
            if (!bCreate) continue;
            for (PSDEDataSet psExistingDEDataSet : psDEDataSetList) {
                if (!StringHelper.isNullOrEmpty((String)psExistingDEDataSet.getPSSubSysSADetailId()) || StringHelper.compare((String)psExistingDEDataSet.getCodeName(), (String)psSubSysSADetail.getCodeName2(), (boolean)true) != 0) continue;
                PSDEDataSet psDEDataSet22 = new PSDEDataSet();
                psDEDataSet22.setPSDEDataSetId(psExistingDEDataSet.getPSDEDataSetId());
                psDEDataSet22.setPSSubSysSADetailId(psSubSysSADetail.getPSSubSysSADetailId());
                psDEDataSetService.sysUpdate(psDEDataSet22, false);
                sBuilderEx.append(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u7ed1\u5b9a\u6570\u636e\u96c6[%2$s]\r\n", (Object)psDataEntity.getPSDataEntityName(), (Object)psExistingDEDataSet.getPSDEDataSetName()));
                bCreate = false;
                break;
            }
            if (!bCreate) continue;
            psDEDataSet2 = new PSDEDataSet();
            psDEDataSet2.setPSDEDataSetName(psSubSysSADetail.getCodeName2().toUpperCase());
            psDEDataSet2.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEDataSet2.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEDataSet2.setLogicName(psSubSysSADetail.getPSSubSysSADetailName());
            psDEDataSet2.setCodeName(psSubSysSADetail.getCodeName2());
            psDEDataSet2.setPSSubSysSADetailId(psSubSysSADetail.getPSSubSysSADetailId());
            psDEDataSetService.create(psDEDataSet2, false);
            sBuilderEx.append(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u6570\u636e\u96c6[%2$s]\r\n", (Object)psDataEntity.getPSDataEntityName(), (Object)psDEDataSet2.getPSDEDataSetName()));
            PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
        }
        return sBuilderEx.toString();
    }

    protected String syncSADEModel(PSSubSysServiceAPI psSubSysServiceAPI, IPSOpenAPI3Schema iPSOpenAPI3Schema) throws Exception {
        IPSOpenAPI3Paths iPSOpenAPI3Paths;
        StringBuilderEx sb = new StringBuilderEx();
        IPSOpenAPI3JsonNodeSchemas iPSOpenAPI3JsonNodeSchemas = null;
        if (iPSOpenAPI3Schema.getPSOpenAPI3Components() != null) {
            iPSOpenAPI3JsonNodeSchemas = iPSOpenAPI3Schema.getPSOpenAPI3Components().getPSOpenAPI3JsonNodeSchemas();
        }
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        PSSubSysSADEService psSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)sessionFactory);
        ArrayList<PSSubSysSADE> psSubSysSADEList = psSubSysSADEService.selectByPSSubSysServiceAPI((PSSubSysServiceAPIBase)psSubSysServiceAPI);
        HashMap<String, PSSubSysSADE> psSubSysSADEMap = new HashMap<String, PSSubSysSADE>();
        for (PSSubSysSADE psSubSysSADE : psSubSysSADEList) {
            psSubSysSADEMap.put(psSubSysSADE.getPSSubSysSADEName().toUpperCase(), psSubSysSADE);
        }
        PSSubSysSADEFieldService psSubSysSADEFieldService = (PSSubSysSADEFieldService)ServiceGlobal.getService(PSSubSysSADEFieldService.class, (SessionFactory)sessionFactory);
        ArrayList<PSSubSysSADEField> psSubSysSADEFieldList = psSubSysSADEFieldService.select((ISelectCond)new SelectCond());
        if (iPSOpenAPI3JsonNodeSchemas != null && iPSOpenAPI3JsonNodeSchemas.getItemNames() != null) {
            IPSJsonObjectSchema iPSJsonObjectSchema;
            IPSJsonNodeSchema iPSJsonNodeSchema;
            String strName;
            Iterator<String> names = iPSOpenAPI3JsonNodeSchemas.getItemNames();
            while (names.hasNext()) {
                strName = names.next();
                iPSJsonNodeSchema = (IPSJsonNodeSchema)iPSOpenAPI3JsonNodeSchemas.getItem(strName, false);
                if (!(iPSJsonNodeSchema instanceof IPSJsonObjectSchema)) continue;
                iPSJsonObjectSchema = (IPSJsonObjectSchema)iPSJsonNodeSchema;
                PSSubSysSADE psSubSysSADE = (PSSubSysSADE)psSubSysSADEMap.get(strName.toUpperCase());
                if (psSubSysSADE != null) continue;
                PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
                psSubSysSADE = new PSSubSysSADE();
                psSubSysSADE.setPSSubSysSADEName(strName);
                psSubSysSADE.setCodeName(strName);
                psSubSysSADE.setMemo(iPSJsonObjectSchema.getDescription());
                psSubSysSADE.setSyncModelMode("TODE");
                psSubSysSADE.setPSSubSysServiceAPIId(psSubSysServiceAPI.getPSSubSysServiceAPIId());
                try {
                    psSubSysSADEService.create(psSubSysSADE);
                    psSubSysSADEMap.put(psSubSysSADE.getPSSubSysSADEName().toUpperCase(), psSubSysSADE);
                    sb.append(StringHelper.format((String)"\u5efa\u7acb\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53[%1$s]\r\n", (Object)strName));
                }
                catch (Exception ex) {
                    throw new Exception(String.format("\u5efa\u7acb\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", strName, ex.getMessage()), ex);
                }
            }
            names = iPSOpenAPI3JsonNodeSchemas.getItemNames();
            while (names.hasNext()) {
                PSSubSysSADE psSubSysSADE;
                IPSJsonProperties iPSJsonProperties;
                strName = names.next();
                iPSJsonNodeSchema = (IPSJsonNodeSchema)iPSOpenAPI3JsonNodeSchemas.getItem(strName, false);
                if (!(iPSJsonNodeSchema instanceof IPSJsonObjectSchema) || (iPSJsonProperties = (iPSJsonObjectSchema = (IPSJsonObjectSchema)iPSJsonNodeSchema).getPSJsonProperties()) == null || (psSubSysSADE = (PSSubSysSADE)psSubSysSADEMap.get(strName.toUpperCase())) == null) continue;
                HashMap psSubSysSADEFieldMap = new HashMap();
                for (PSSubSysSADEField psSubSysSADEField : psSubSysSADEFieldList) {
                    if (StringHelper.compare((String)psSubSysSADE.getPSSubSysSADEId(), (String)psSubSysSADEField.getPSSubSysSADEId(), (boolean)false) != 0) continue;
                    psSubSysSADEFieldMap.put(psSubSysSADEField.getPSSubSysSADEFieldName().toUpperCase(), psSubSysSADEField);
                }
                Iterator<String> fields = iPSJsonProperties.getItemNames();
                while (fields.hasNext()) {
                    IPSJsonProperty iPSJsonProperty;
                    IPSJsonNodeSchema iPSJsonPropertyType;
                    String strField = fields.next();
                    PSSubSysSADEField psSubSysSADEField = (PSSubSysSADEField)psSubSysSADEFieldMap.get(strField.toUpperCase());
                    if (psSubSysSADEField != null || (iPSJsonPropertyType = (iPSJsonProperty = (IPSJsonProperty)iPSJsonProperties.getItem(strField, false)).getPSJsonNodeSchema()) == null) continue;
                    PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
                    String strType = iPSJsonPropertyType.getType();
                    psSubSysSADEField = new PSSubSysSADEField();
                    psSubSysSADEField.setPSSubSysSADEFieldName(strField.toUpperCase());
                    psSubSysSADEField.setCodeName(strField);
                    psSubSysSADEField.setPSSubSysSADEId(psSubSysSADE.getPSSubSysSADEId());
                    psSubSysSADEField.setPSSubSysSADEName(psSubSysSADE.getPSSubSysSADEName());
                    psSubSysSADEField.setMajorField(Integer.valueOf(0));
                    if (iPSJsonPropertyType instanceof IPSJsonSimpleSchema) {
                        psSubSysSADEField.setStdDataType(Integer.valueOf(((IPSJsonSimpleSchema)iPSJsonPropertyType).getStdDataType()));
                    } else if (StringHelper.compare((String)strType, (String)"array", (boolean)false) == 0) {
                        psSubSysSADEField.setArrayFlag(Integer.valueOf(1));
                    } else {
                        StringHelper.compare((String)strType, (String)"object", (boolean)false);
                    }
                    try {
                        psSubSysSADEFieldService.create(psSubSysSADEField);
                        sb.append(StringHelper.format((String)"\u5efa\u7acb\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\r\n", (Object)strName, (Object)strField));
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u5efa\u7acb\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", strName, strField, ex.getMessage()), ex);
                    }
                }
            }
        }
        if ((iPSOpenAPI3Paths = iPSOpenAPI3Schema.getPSOpenAPI3Paths()) != null && iPSOpenAPI3Paths.getItemNames() != null) {
            PSSubSysSADetailService psSubSysSADetailService = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)sessionFactory);
            ArrayList<PSSubSysSADetail> psSubSysSADetailList = psSubSysSADetailService.selectByPSSubSysServiceAPI((PSSubSysServiceAPIBase)psSubSysServiceAPI);
            HashMap<String, PSSubSysSADetail> psSubSysSADetailMap = new HashMap<String, PSSubSysSADetail>();
            HashMap psCodeNameMap = new HashMap();
            for (PSSubSysSADetail psSubSysSADetail : psSubSysSADetailList) {
                if (StringHelper.isNullOrEmpty((String)psSubSysSADetail.getServiceUrl()) || StringHelper.isNullOrEmpty((String)psSubSysSADetail.getRequestMethod())) continue;
                psSubSysSADetailMap.put(String.format("%1$s#%2$s", psSubSysSADetail.getServiceUrl(), psSubSysSADetail.getRequestMethod()).toUpperCase(), psSubSysSADetail);
                if (StringHelper.isNullOrEmpty((String)psSubSysSADetail.getCodeName())) continue;
                psCodeNameMap.put(psSubSysSADetail.getCodeName().toUpperCase(), null);
            }
            Iterator<String> names = iPSOpenAPI3Paths.getItemNames();
            while (names.hasNext()) {
                String strName = names.next();
                IPSOpenAPI3Path iPSOpenAPI3Path = (IPSOpenAPI3Path)iPSOpenAPI3Paths.getItem(strName, false);
                Iterator psOpenAPI3Operations = iPSOpenAPI3Path.getPSOpenAPI3Operations();
                if (psOpenAPI3Operations == null) continue;
                IPSOpenAPI3Operation iPSOpenAPI3Operation = null;
                while (psOpenAPI3Operations.hasNext()) {
                    String strNewCodeName;
                    iPSOpenAPI3Operation = (IPSOpenAPI3Operation)psOpenAPI3Operations.next();
                    String strKey = String.format("%1$s#%2$s", strName, iPSOpenAPI3Operation.getName().toUpperCase());
                    PSSubSysSADetail psSubSysSADetail = (PSSubSysSADetail)psSubSysSADetailMap.get(strKey.toUpperCase());
                    if (psSubSysSADetail != null) continue;
                    psSubSysSADetail = new PSSubSysSADetail();
                    psSubSysSADetail.setPSSubSysSADetailName(strKey);
                    psSubSysSADetail.setPSSubSysServiceAPIId(psSubSysServiceAPI.getPSSubSysServiceAPIId());
                    psSubSysSADetail.setDetailType("DEACTION");
                    psSubSysSADetail.setServiceUrl(strName);
                    psSubSysSADetail.setRequestMethod(iPSOpenAPI3Operation.getName().toUpperCase());
                    Iterator<String> tags = iPSOpenAPI3Operation.getTags();
                    if (tags != null && tags.hasNext()) {
                        psSubSysSADetail.setDetailTag(tags.next());
                    }
                    String strCodeName = null;
                    if (!StringHelper.isNullOrEmpty((String)iPSOpenAPI3Operation.getOperationId())) {
                        psSubSysSADetail.setDetailTag2(iPSOpenAPI3Operation.getOperationId());
                        strCodeName = iPSOpenAPI3Operation.getOperationId();
                        psSubSysSADetail.setCodeName2(strCodeName);
                    } else {
                        strCodeName = "Auto";
                    }
                    int nIndex = 1;
                    while (true) {
                        if (!psCodeNameMap.containsKey((strNewCodeName = String.format("%1$s%2$s", strCodeName, nIndex == 1 ? "" : Integer.valueOf(nIndex))).toUpperCase())) break;
                        ++nIndex;
                    }
                    strCodeName = strNewCodeName;
                    psSubSysSADetail.setCodeName(strCodeName);
                    if (iPSOpenAPI3Operation.getJsonNode() != null) {
                        psSubSysSADetail.setDetailParam(iPSOpenAPI3Operation.getJsonNode().toString());
                    }
                    PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
                    psSubSysSADetail.setMemo(iPSOpenAPI3Path.getDescription());
                    psSubSysSADetail.setPSSubSysServiceAPIId(psSubSysServiceAPI.getPSSubSysServiceAPIId());
                    try {
                        psSubSysSADetailService.create(psSubSysSADetail);
                        psSubSysSADetailMap.put(strKey.toUpperCase(), psSubSysSADetail);
                        if (!StringHelper.isNullOrEmpty((String)psSubSysSADetail.getCodeName())) {
                            psCodeNameMap.put(psSubSysSADetail.getCodeName().toUpperCase(), null);
                        }
                        sb.append(StringHelper.format((String)"\u5efa\u7acb\u5916\u90e8\u63a5\u53e3\u6210\u5458[%1$s]\r\n", (Object)strKey));
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u5efa\u7acb\u5916\u90e8\u63a5\u53e3\u6210\u5458[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", strKey, ex.getMessage()), ex);
                    }
                }
            }
        }
        return sb.toString();
    }
}

