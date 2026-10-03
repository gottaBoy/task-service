/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEActionGroupDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionGroupDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAGDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAGDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionGroupServiceBase
extends PSCoreSysServiceBase<PSDEActionGroup> {
    private static final Log log = LogFactory.getLog(PSDEActionGroupServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEActionGroupDEModel pSDEActionGroupDEModel;
    private PSDEActionGroupDAO pSDEActionGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEActionGroupService";
    }

    public PSDEActionGroupDEModel getPSDEActionGroupDEModel() {
        if (this.pSDEActionGroupDEModel == null) {
            try {
                this.pSDEActionGroupDEModel = (PSDEActionGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEActionGroupDEModel();
    }

    public PSDEActionGroupDAO getPSDEActionGroupDAO() {
        if (this.pSDEActionGroupDAO == null) {
            try {
                this.pSDEActionGroupDAO = (PSDEActionGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEActionGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEActionGroupDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEActionGroup pSDEActionGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONGROUP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEActionGroup, pSDataEntity);
            return;
        }
        super.onFillParentInfo(pSDEActionGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEActionGroup pSDEActionGroup, PSDataEntity pSDataEntity) throws Exception {
        pSDEActionGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEActionGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillEntityFullInfo(PSDEActionGroup pSDEActionGroup, boolean bl) throws Exception {
        if (bl) {
            if (pSDEActionGroup.getCodeName() == null) {
                pSDEActionGroup.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "ActionGroup", 25));
            }
            if (pSDEActionGroup.getValidFlag() == null) {
                pSDEActionGroup.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDEActionGroup, bl);
        this.onFillEntityFullInfo_PSDE(pSDEActionGroup, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEActionGroup pSDEActionGroup, boolean bl) throws Exception {
        if (pSDEActionGroup.isPSDEIdDirty()) {
            if (pSDEActionGroup.getPSDEId() != null) {
                if (pSDEActionGroup.getPSDEId() == null || pSDEActionGroup.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEActionGroup.getPSDE();
                    pSDEActionGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEActionGroup.setPSDEName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEActionGroup pSDEActionGroup, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEActionGroup, bl);
    }

    public ArrayList<PSDEActionGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEActionGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEActionGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionGroup> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONGROUP_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDEACTIONGROUP", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionGroup> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEActionGroup pSDEActionGroup : arrayList) {
            PSDEActionGroup pSDEActionGroup2 = (PSDEActionGroup)this.getDEModel().createEntity();
            pSDEActionGroup2.setPSDEActionGroupId(pSDEActionGroup.getPSDEActionGroupId());
            pSDEActionGroup2.setPSDEId(null);
            this.update(pSDEActionGroup2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionGroupServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEActionGroupServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEActionGroupServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionGroup> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEActionGroup pSDEActionGroup : arrayList) {
            this.remove(pSDEActionGroup);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEActionGroup pSDEActionGroup) throws Exception {
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        pSDEAGDetailService.testRemoveByPSDEActionGroup(pSDEActionGroup);
        pSDEAGDetailService.removeByPSDEActionGroup(pSDEActionGroup);
        super.onBeforeRemove(pSDEActionGroup);
    }

    protected void onBeforeRemoveTemp(PSDEActionGroup pSDEActionGroup) throws Exception {
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        pSDEAGDetailService.removeTempByPSDEActionGroup(pSDEActionGroup);
        super.onBeforeRemoveTemp(pSDEActionGroup);
    }

    protected void getRelatedDataTempMajor(PSDEActionGroup pSDEActionGroup) throws Exception {
        this.getRelatedDataTempMajor_PSDEAGDetail(pSDEActionGroup);
        super.getRelatedDataTempMajor(pSDEActionGroup);
    }

    protected void getRelatedDataTempMajor_PSDEAGDetail(PSDEActionGroup pSDEActionGroup) throws Exception {
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAGDetail> arrayList = null;
        String string = pSDEActionGroup.getPSDEActionGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEAGDetailService.selectByPSDEActionGroup(pSDEActionGroup) : pSDEAGDetailService.selectTempByPSDEActionGroup(pSDEActionGroup);
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            pSDEAGDetailService.getTempMajor(pSDEAGDetail);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEActionGroup pSDEActionGroup, PSDEActionGroup pSDEActionGroup2) throws Exception {
        ArrayList<PSDEAGDetail> arrayList = this.updateRelatedDataTempMajor_removePSDEAGDetail(pSDEActionGroup, pSDEActionGroup2);
        this.updateRelatedDataTempMajor_updatePSDEAGDetail(pSDEActionGroup, pSDEActionGroup2, arrayList);
        super.updateRelatedDataTempMajor(pSDEActionGroup, pSDEActionGroup2);
    }

    protected ArrayList<PSDEAGDetail> updateRelatedDataTempMajor_removePSDEAGDetail(PSDEActionGroup pSDEActionGroup, PSDEActionGroup pSDEActionGroup2) throws Exception {
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAGDetail> arrayList = pSDEAGDetailService.selectTempByPSDEActionGroup(pSDEActionGroup);
        ArrayList<PSDEAGDetail> arrayList2 = pSDEAGDetailService.selectByPSDEActionGroup(pSDEActionGroup2);
        HashMap<String, PSDEAGDetail> hashMap = new HashMap<String, PSDEAGDetail>();
        for (PSDEAGDetail pSDEAGDetail : arrayList2) {
            hashMap.put(pSDEAGDetail.getPSDEAGDetailId(), pSDEAGDetail);
        }
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            Object object = pSDEAGDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEAGDetail pSDEAGDetail : hashMap.values()) {
            pSDEAGDetailService.remove(pSDEAGDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEAGDetail(PSDEActionGroup pSDEActionGroup, PSDEActionGroup pSDEActionGroup2, ArrayList<PSDEAGDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            pSDEAGDetailService.updateTempMajor(pSDEAGDetail);
        }
    }

    protected void replaceParentInfo(PSDEActionGroup pSDEActionGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEActionGroup, cloneSession);
        if (pSDEActionGroup.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEActionGroup.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEActionGroup, (PSDataEntity)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEActionGroup pSDEActionGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEActionGroup, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEActionGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag2(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionGroupId(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionGroupName(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEActionGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEActionGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isCodeNameDirty() && !bl2 : !pSDEActionGroup.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEActionGroup.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEActionGroupDEModel(), "CODENAME", string3, pSDEActionGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isCodeName2Dirty() : !pSDEActionGroup.isCodeName2Dirty()) {
            return null;
        }
        String string = pSDEActionGroup.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEActionGroupDEModel(), "CODENAME2", string3, pSDEActionGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME2");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTag(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isGroupTagDirty() : !pSDEActionGroup.isGroupTagDirty()) {
            return null;
        }
        String string = pSDEActionGroup.getGroupTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTag2(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isGroupTag2Dirty() : !pSDEActionGroup.isGroupTag2Dirty()) {
            return null;
        }
        String string = pSDEActionGroup.getGroupTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag2_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isMemoDirty() : !pSDEActionGroup.isMemoDirty()) {
            return null;
        }
        String string = pSDEActionGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionGroupId(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isPSDEActionGroupIdDirty() && !bl2 : !pSDEActionGroup.isPSDEActionGroupIdDirty()) {
            return null;
        }
        String string = pSDEActionGroup.getPSDEActionGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionGroupId_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionGroupName(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isPSDEActionGroupNameDirty() && !bl2 : !pSDEActionGroup.isPSDEActionGroupNameDirty()) {
            return null;
        }
        String string = pSDEActionGroup.getPSDEActionGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONGROUPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionGroupName_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEActionGroupDEModel(), "PSDEACTIONGROUPNAME", string3, pSDEActionGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEACTIONGROUPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isPSDEIdDirty() && !bl2 : !pSDEActionGroup.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEActionGroup.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isPSDENameDirty() && !bl2 : !pSDEActionGroup.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEActionGroup.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isUserCatDirty() : !pSDEActionGroup.isUserCatDirty()) {
            return null;
        }
        String string = pSDEActionGroup.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isUserTagDirty() : !pSDEActionGroup.isUserTagDirty()) {
            return null;
        }
        String string = pSDEActionGroup.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isUserTag2Dirty() : !pSDEActionGroup.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEActionGroup.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isUserTag3Dirty() : !pSDEActionGroup.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEActionGroup.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isUserTag4Dirty() : !pSDEActionGroup.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEActionGroup.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEActionGroup pSDEActionGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionGroup.isValidFlagDirty() && !bl2 : !pSDEActionGroup.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEActionGroup.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEActionGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEActionGroup pSDEActionGroup, boolean bl) throws Exception {
        super.onSyncEntity(pSDEActionGroup, bl);
    }

    protected void onSyncIndexEntities(PSDEActionGroup pSDEActionGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEActionGroup, bl);
    }

    public Object getDataContextValue(PSDEActionGroup pSDEActionGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEActionGroup, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEActionGroup.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEActionGroup pSDEActionGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEActionGroup, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEActionGroup pSDEActionGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEActionGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEActionGroup pSDEActionGroup) throws Exception {
        super.onUpdateParent(pSDEActionGroup);
    }

    protected void onCopyDetails(PSDEActionGroup pSDEActionGroup, Object object) throws Exception {
        PSDEActionGroup pSDEActionGroup2 = new PSDEActionGroup();
        pSDEActionGroup2.set("PSDEACTIONGROUPID", object);
        String string = DataObject.getStringValue((Object)pSDEActionGroup.get("PSDEACTIONGROUPID"));
        super.onCopyDetails(pSDEActionGroup, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEActionGroup pSDEActionGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEACTIONGROUP");
        if (!bl) {
            pSDEActionGroup.setCreateDate(null);
            pSDEActionGroup.setCreateMan(null);
            pSDEActionGroup.setPSDEActionGroupId(null);
            pSDEActionGroup.setUpdateDate(null);
            pSDEActionGroup.setUpdateMan(null);
            super.exportCurXmlModel(pSDEActionGroup, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEActionGroup pSDEActionGroup, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEAGDetail(pSDEActionGroup, xmlNode);
        super.onExportRelatedXmlModel(pSDEActionGroup, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEAGDetail(PSDEActionGroup pSDEActionGroup, XmlNode xmlNode) throws Exception {
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAGDetail> arrayList = null;
        String string = pSDEActionGroup.getPSDEActionGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEAGDetailService.selectByPSDEActionGroup(pSDEActionGroup, "ORDER BY ORDERVALUE ASC") : pSDEAGDetailService.selectTempByPSDEActionGroup(pSDEActionGroup, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEAGDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDEAGDetail pSDEAGDetail : arrayList) {
                pSDEAGDetail.set("ORDERVALUE", null);
                pSDEAGDetailService.exportXmlModel(pSDEAGDetail, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEActionGroup pSDEActionGroup, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEAGDETAILS");
        this.importRelatedXmlModel_PSDEAGDetail(pSDEActionGroup, xmlNode2);
        super.onImportRelatedXmlModel(pSDEActionGroup, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEAGDetail(PSDEActionGroup pSDEActionGroup, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEActionGroup.getPSDEActionGroupId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEAGDetailService.removeByPSDEActionGroup(pSDEActionGroup);
        } else {
            pSDEAGDetailService.removeTempByPSDEActionGroup(pSDEActionGroup);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEAGDetail pSDEAGDetail = new PSDEAGDetail();
                pSDEAGDetail.setOrderValue(n);
                n += 100;
                pSDEAGDetailService.fillParentInfo(pSDEAGDetail, "DER1N", "DER1N_PSDEAGDETAIL_PSDEACTIONGROUP_PSDEACTIONGROUPID", pSDEActionGroup.getPSDEActionGroupId());
                pSDEAGDetailService.importXmlModel(pSDEAGDetail, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEActionGroup pSDEActionGroup, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEActionGroup, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEACTIONGROUP_PSDATAENTITY_PSDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDEActionGroup pSDEActionGroup) {
        if (!StringHelper.isNullOrEmpty((String)pSDEActionGroup.getCodeName())) {
            return pSDEActionGroup.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEActionGroup.getPSDEActionGroupName())) {
            return pSDEActionGroup.getPSDEActionGroupName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEActionGroup.getCodeName())) {
            return pSDEActionGroup.getCodeName();
        }
        return super.getModelV2Tag(pSDEActionGroup);
    }

    @Override
    public boolean setModelV2Tag(PSDEActionGroup pSDEActionGroup, String string) {
        pSDEActionGroup.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEACTIONGROUPNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME2", "");
        map.put("PSDEACTIONGROUPNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEActionGroup pSDEActionGroup, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEActionGroup.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEActionGroup, true);
        pSDEActionGroup.set("CODENAME", string);
        if (this.select(pSDEActionGroup, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEActionGroup, true);
        return super.getModelV2Entity(pSDEActionGroup, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEActionGroup pSDEActionGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEActionGroup, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEAGDETAIL_PSDEACTIONGROUP_PSDEACTIONGROUPID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEActionGroup pSDEActionGroup, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEActionGroup, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEActionGroup pSDEActionGroup, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEAGDETAIL_PSDEACTIONGROUP_PSDEACTIONGROUPID")) {
            PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEACTIONGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEAGDETAIL", (Object)pSDEActionGroup.getPSDEActionGroupId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEACTIONGROUP#%1$s", (Object)pSDEActionGroup.getPSDEActionGroupId());
                for (PSDEAGDetail detail : pSDEAGDetailService.selectByPSDEActionGroup(pSDEActionGroup)) {
                    String detailScope = pSDEAGDetailService.getModelV2ResScope(detail);
                    if (StringHelper.compare((String)scope, (String)detailScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(detail, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSDEAGDetailService.getModelV2Name(false).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdeagdetailname")) {
                            string = objectNode.get("psdeagdetailname").asText();
                        }
                        if (objectNode2.has("psdeagdetailname")) {
                            string2 = objectNode2.get("psdeagdetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode detailNode : arrayList) {
                    PSDEAGDetail detail = new PSDEAGDetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)detail, detailNode, false);
                    output.add((JsonNode)pSDEAGDetailService.exportModelV2(detail, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEActionGroup, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEActionGroup pSDEActionGroup) throws Exception {
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAGDetail> arrayList = pSDEAGDetailService.selectByPSDEActionGroup(pSDEActionGroup);
        String string = StringHelper.format((String)"PSDEACTIONGROUP#%1$s", (Object)pSDEActionGroup.getPSDEActionGroupId());
        for (PSDEAGDetail pSDEAGDetail : arrayList) {
            String string2 = pSDEAGDetailService.getModelV2ResScope(pSDEAGDetail);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEAGDetailService.emptyModelV2(pSDEAGDetail);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEActionGroup.getPSDEActionGroupId());
        pSDEAGDetailService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEAGDetailService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEAGDETAIL WHERE PSDEACTIONGROUPID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEActionGroup);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEAGDetailService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEActionGroup pSDEActionGroup, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEAGDetail pSDEAGDetail = new PSDEAGDetail();
        pSDEAGDetail.set("PSDEACTIONGROUPID", pSDEActionGroup.getPSDEActionGroupId());
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEAGDetailService.getModelV2Entity(pSDEAGDetail, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEActionGroup, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEActionGroup pSDEActionGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEAGDetailService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEAGDetail pSDEAGDetail = new PSDEAGDetail();
                pSDEAGDetail.setPSDEActionGroupId(pSDEActionGroup.getPSDEActionGroupId());
                pSDEAGDetail.setPSDEActionGroupName(pSDEActionGroup.getPSDEActionGroupName());
                pSDEAGDetail.setPSDEId(pSDEActionGroup.getPSDEId());
                pSDEAGDetailService.compileModelV2(pSDEAGDetail, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEAGDetail pSDEAGDetail = new PSDEAGDetail();
                    pSDEAGDetail.setPSDEActionGroupId(pSDEActionGroup.getPSDEActionGroupId());
                    pSDEAGDetail.setPSDEActionGroupName(pSDEActionGroup.getPSDEActionGroupName());
                    pSDEAGDetail.setPSDEId(pSDEActionGroup.getPSDEId());
                    pSDEAGDetailService.compileModelV2(pSDEAGDetail, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEActionGroup, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEActionGroup pSDEActionGroup, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEAGDETAIL_PSDEACTIONGROUP_PSDEACTIONGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEAGDetails(pSDEActionGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEActionGroup, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEAGDetails(PSDEActionGroup pSDEActionGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEAGDETAIL", true), (boolean)false) == 0) {
            PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEAGDetail pSDEAGDetail = new PSDEAGDetail();
            pSDEAGDetail.setPSDEAGDetailId(pSMOSFile.getPSModelId());
            if (!pSDEAGDetailService.get(pSDEAGDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEAGDetail.getPSDEActionGroupId(), (String)pSDEActionGroup.getPSDEActionGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEAGDetailService.exportModelV2(pSDEAGDetail);
            pSDEAGDetail.reset();
            if (!pSDEAGDetailService.setModelV2ResScope(pSDEAGDetail, "PSDEACTIONGROUP", pSDEActionGroup.getPSDEActionGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEAGDetailService.importModelV2(pSDEAGDetail, objectNode);
            SessionFactoryManager.commit();
            return pSDEAGDetailService.getFile(pSDEAGDetail);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEACTION", true), (boolean)false) == 0) {
            PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = new PSDEAction();
            pSDEAction.setPSDEActionId(pSMOSFile.getPSModelId());
            if (!pSDEActionService.get(pSDEAction, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEAGDetail pSDEAGDetail = new PSDEAGDetail();
            pSDEAGDetail.setPSDEActionGroupId(pSDEActionGroup.getPSDEActionGroupId());
            pSDEAGDetail.setPSDEActionId(pSDEAction.getPSDEActionId());
            this.fillPasteEntity(pSDEAGDetail, "PASTETAG|DETAILTYPE:DEACTION");
            pSDEAGDetailService.create(pSDEAGDetail);
            if (StringHelper.compare((String)pSDEAction.getPSDEId(), (String)pSDEAGDetail.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u5b9e\u4f53]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEAGDetailService.getFile(pSDEAGDetail);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEDATASET", true), (boolean)false) == 0) {
            PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = new PSDEDataSet();
            pSDEDataSet.setPSDEDataSetId(pSMOSFile.getPSModelId());
            if (!pSDEDataSetService.get(pSDEDataSet, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEAGDetail pSDEAGDetail = new PSDEAGDetail();
            pSDEAGDetail.setPSDEActionGroupId(pSDEActionGroup.getPSDEActionGroupId());
            pSDEAGDetail.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            this.fillPasteEntity(pSDEAGDetail, "PASTETAG|DETAILTYPE:DEDATASET");
            pSDEAGDetailService.create(pSDEAGDetail);
            if (StringHelper.compare((String)pSDEDataSet.getPSDEId(), (String)pSDEAGDetail.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u5b9e\u4f53]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEAGDetailService.getFile(pSDEAGDetail);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEActionGroup pSDEActionGroup, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEAGDetails(pSDEActionGroup, list);
        super.onFillPasteHelps(pSDEActionGroup, list);
    }

    protected void onFillPasteHelps_PSDEAGDetails(PSDEActionGroup pSDEActionGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEAGDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEAGDETAIL_PSDEACTIONGROUP_PSDEACTIONGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u884c\u4e3a\u7ec4]\u7684[\u5b9e\u4f53\u884c\u4e3a\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEAGDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEAGDETAIL_PSDEACTIONGROUP_PSDEACTIONGROUPID");
        pSHelpSection.setUserTag("DER1N_PSDEAGDETAIL_PSDEACTION_PSDEACTIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u7684[\u5b9e\u4f53\u884c\u4e3a]\u6784\u5efa[\u5b9e\u4f53\u884c\u4e3a\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEAGDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEAGDETAIL_PSDEACTIONGROUP_PSDEACTIONGROUPID");
        pSHelpSection.setUserTag("DER1N_PSDEAGDETAIL_PSDEDATASET_PSDEDATASETID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u7684[\u5b9e\u4f53\u6570\u636e\u96c6\u5408]\u6784\u5efa[\u5b9e\u4f53\u884c\u4e3a\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEActionGroup pSDEActionGroup, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "ActionGroup");
    }
}
