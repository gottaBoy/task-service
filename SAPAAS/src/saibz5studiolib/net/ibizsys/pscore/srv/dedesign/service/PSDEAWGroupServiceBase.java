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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEAWGroupDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEAWGroupDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWGrpDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWGrpDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWGrpDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEAWGroupServiceBase
extends PSCoreSysServiceBase<PSDEAWGroup> {
    private static final Log log = LogFactory.getLog(PSDEAWGroupServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEAWGroupDEModel pSDEAWGroupDEModel;
    private PSDEAWGroupDAO pSDEAWGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEAWGroupService";
    }

    public PSDEAWGroupDEModel getPSDEAWGroupDEModel() {
        if (this.pSDEAWGroupDEModel == null) {
            try {
                this.pSDEAWGroupDEModel = (PSDEAWGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEAWGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEAWGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEAWGroupDEModel();
    }

    public PSDEAWGroupDAO getPSDEAWGroupDAO() {
        if (this.pSDEAWGroupDAO == null) {
            try {
                this.pSDEAWGroupDAO = (PSDEAWGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEAWGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEAWGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEAWGroupDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEAWGroup pSDEAWGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEAWGROUP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEAWGroup, pSDataEntity);
            return;
        }
        super.onFillParentInfo(pSDEAWGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEAWGroup pSDEAWGroup, PSDataEntity pSDataEntity) throws Exception {
        pSDEAWGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEAWGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillEntityFullInfo(PSDEAWGroup pSDEAWGroup, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDEAWGroup, bl);
        this.onFillEntityFullInfo_PSDE(pSDEAWGroup, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEAWGroup pSDEAWGroup, boolean bl) throws Exception {
        if (pSDEAWGroup.isPSDEIdDirty()) {
            if (pSDEAWGroup.getPSDEId() != null) {
                if (pSDEAWGroup.getPSDEId() == null || pSDEAWGroup.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEAWGroup.getPSDE();
                    pSDEAWGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEAWGroup.setPSDEName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEAWGroup pSDEAWGroup, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEAWGroup, bl);
    }

    public ArrayList<PSDEAWGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEAWGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEAWGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEAWGroup> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEAWGroup pSDEAWGroup : arrayList) {
            PSDEAWGroup pSDEAWGroup2 = (PSDEAWGroup)this.getDEModel().createEntity();
            pSDEAWGroup2.setPSDEAWGroupId(pSDEAWGroup.getPSDEAWGroupId());
            pSDEAWGroup2.setPSDEId(null);
            this.update(pSDEAWGroup2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEAWGroupServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEAWGroupServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEAWGroupServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEAWGroup> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEAWGroup pSDEAWGroup : arrayList) {
            this.remove(pSDEAWGroup);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEAWGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEAWGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEAWGroup pSDEAWGroup) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEAWGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAWGroup(pSDEAWGroup);
        ((PSDEAWGrpDetailServiceBase)pSCoreSysServiceBase).removeByPSDEAWGroup(pSDEAWGroup);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAWGroup(pSDEAWGroup);
        super.onBeforeRemove(pSDEAWGroup);
    }

    protected void onBeforeRemoveTemp(PSDEAWGroup pSDEAWGroup) throws Exception {
        PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        pSDEAWGrpDetailService.removeTempByPSDEAWGroup(pSDEAWGroup);
        super.onBeforeRemoveTemp(pSDEAWGroup);
    }

    protected void getRelatedDataTempMajor(PSDEAWGroup pSDEAWGroup) throws Exception {
        this.getRelatedDataTempMajor_PSDEAWGrpDetail(pSDEAWGroup);
        super.getRelatedDataTempMajor(pSDEAWGroup);
    }

    protected void getRelatedDataTempMajor_PSDEAWGrpDetail(PSDEAWGroup pSDEAWGroup) throws Exception {
        PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAWGrpDetail> arrayList = null;
        String string = pSDEAWGroup.getPSDEAWGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEAWGrpDetailService.selectByPSDEAWGroup(pSDEAWGroup) : pSDEAWGrpDetailService.selectTempByPSDEAWGroup(pSDEAWGroup);
        for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList) {
            pSDEAWGrpDetailService.getTempMajor(pSDEAWGrpDetail);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEAWGroup pSDEAWGroup, PSDEAWGroup pSDEAWGroup2) throws Exception {
        ArrayList<PSDEAWGrpDetail> arrayList = this.updateRelatedDataTempMajor_removePSDEAWGrpDetail(pSDEAWGroup, pSDEAWGroup2);
        this.updateRelatedDataTempMajor_updatePSDEAWGrpDetail(pSDEAWGroup, pSDEAWGroup2, arrayList);
        super.updateRelatedDataTempMajor(pSDEAWGroup, pSDEAWGroup2);
    }

    protected ArrayList<PSDEAWGrpDetail> updateRelatedDataTempMajor_removePSDEAWGrpDetail(PSDEAWGroup pSDEAWGroup, PSDEAWGroup pSDEAWGroup2) throws Exception {
        PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAWGrpDetail> arrayList = pSDEAWGrpDetailService.selectTempByPSDEAWGroup(pSDEAWGroup);
        ArrayList<PSDEAWGrpDetail> arrayList2 = pSDEAWGrpDetailService.selectByPSDEAWGroup(pSDEAWGroup2);
        HashMap<String, PSDEAWGrpDetail> hashMap = new HashMap<String, PSDEAWGrpDetail>();
        for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList2) {
            hashMap.put(pSDEAWGrpDetail.getPSDEAWGrpDetailId(), pSDEAWGrpDetail);
        }
        for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList) {
            Object object = pSDEAWGrpDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEAWGrpDetail pSDEAWGrpDetail : hashMap.values()) {
            pSDEAWGrpDetailService.remove(pSDEAWGrpDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEAWGrpDetail(PSDEAWGroup pSDEAWGroup, PSDEAWGroup pSDEAWGroup2, ArrayList<PSDEAWGrpDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList) {
            pSDEAWGrpDetailService.updateTempMajor(pSDEAWGrpDetail);
        }
    }

    protected void replaceParentInfo(PSDEAWGroup pSDEAWGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEAWGroup, cloneSession);
        if (pSDEAWGroup.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEAWGroup.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEAWGroup, (PSDataEntity)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEAWGroup pSDEAWGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEAWGroup, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEAWGroup pSDEAWGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEAWGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEAWGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEAWGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEAWGroupId(bl, pSDEAWGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEAWGroupName(bl, pSDEAWGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEAWGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEAWGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEAWGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEAWGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEAWGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEAWGroup pSDEAWGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGroup.isCodeNameDirty() && !bl2 : !pSDEAWGroup.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEAWGroup.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEAWGroup, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEAWGroupDEModel(), "CODENAME", string3, pSDEAWGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEAWGroup pSDEAWGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGroup.isLockFlagDirty() : !pSDEAWGroup.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEAWGroup.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEAWGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEAWGroup pSDEAWGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGroup.isMemoDirty() : !pSDEAWGroup.isMemoDirty()) {
            return null;
        }
        String string = pSDEAWGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEAWGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEAWGroupId(boolean bl, PSDEAWGroup pSDEAWGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGroup.isPSDEAWGroupIdDirty() && !bl2 : !pSDEAWGroup.isPSDEAWGroupIdDirty()) {
            return null;
        }
        String string = pSDEAWGroup.getPSDEAWGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEAWGroupId_Default(pSDEAWGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEAWGroupName(boolean bl, PSDEAWGroup pSDEAWGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGroup.isPSDEAWGroupNameDirty() && !bl2 : !pSDEAWGroup.isPSDEAWGroupNameDirty()) {
            return null;
        }
        String string = pSDEAWGroup.getPSDEAWGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWGROUPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEAWGroupName_Default(pSDEAWGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEAWGroup pSDEAWGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGroup.isPSDEIdDirty() && !bl2 : !pSDEAWGroup.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEAWGroup.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEAWGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEAWGroup pSDEAWGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGroup.isPSDENameDirty() && !bl2 : !pSDEAWGroup.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEAWGroup.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEAWGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEAWGroup pSDEAWGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGroup.isUserTagDirty() : !pSDEAWGroup.isUserTagDirty()) {
            return null;
        }
        String string = pSDEAWGroup.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEAWGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEAWGroup pSDEAWGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWGroup.isUserTag2Dirty() : !pSDEAWGroup.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEAWGroup.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEAWGroup, bl2, bl3);
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

    protected void onSyncEntity(PSDEAWGroup pSDEAWGroup, boolean bl) throws Exception {
        super.onSyncEntity(pSDEAWGroup, bl);
    }

    protected void onSyncIndexEntities(PSDEAWGroup pSDEAWGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEAWGroup, bl);
    }

    public Object getDataContextValue(PSDEAWGroup pSDEAWGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEAWGroup, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEAWGroup pSDEAWGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEAWGroup, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAWGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAWGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAWGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAWGroupName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEAWGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAWGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEAWGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAWGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEAWGroup pSDEAWGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEAWGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEAWGroup pSDEAWGroup) throws Exception {
        Object object = pSDEAWGroup.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEAWGROUP_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEAWGroup);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEAWGroup pSDEAWGroup, Object object) throws Exception {
        PSDEAWGroup pSDEAWGroup2 = new PSDEAWGroup();
        pSDEAWGroup2.set("PSDEAWGROUPID", object);
        String string = DataObject.getStringValue((Object)pSDEAWGroup.get("PSDEAWGROUPID"));
        super.onCopyDetails(pSDEAWGroup, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEAWGroup pSDEAWGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEAWGROUP");
        if (!bl) {
            pSDEAWGroup.setCreateDate(null);
            pSDEAWGroup.setCreateMan(null);
            pSDEAWGroup.setPSDEAWGroupId(null);
            pSDEAWGroup.setUpdateDate(null);
            pSDEAWGroup.setUpdateMan(null);
            super.exportCurXmlModel(pSDEAWGroup, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEAWGroup pSDEAWGroup, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEAWGrpDetail(pSDEAWGroup, xmlNode);
        super.onExportRelatedXmlModel(pSDEAWGroup, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEAWGrpDetail(PSDEAWGroup pSDEAWGroup, XmlNode xmlNode) throws Exception {
        PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAWGrpDetail> arrayList = null;
        String string = pSDEAWGroup.getPSDEAWGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEAWGrpDetailService.selectByPSDEAWGroup(pSDEAWGroup, "ORDER BY ORDERVALUE ASC") : pSDEAWGrpDetailService.selectTempByPSDEAWGroup(pSDEAWGroup, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEAWGRPDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList) {
                pSDEAWGrpDetail.set("ORDERVALUE", null);
                pSDEAWGrpDetailService.exportXmlModel(pSDEAWGrpDetail, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEAWGroup pSDEAWGroup, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEAWGRPDETAILS");
        this.importRelatedXmlModel_PSDEAWGrpDetail(pSDEAWGroup, xmlNode2);
        super.onImportRelatedXmlModel(pSDEAWGroup, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEAWGrpDetail(PSDEAWGroup pSDEAWGroup, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEAWGroup.getPSDEAWGroupId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEAWGrpDetailService.removeByPSDEAWGroup(pSDEAWGroup);
        } else {
            pSDEAWGrpDetailService.removeTempByPSDEAWGroup(pSDEAWGroup);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEAWGrpDetail pSDEAWGrpDetail = new PSDEAWGrpDetail();
                pSDEAWGrpDetail.setOrderValue(n);
                n += 100;
                pSDEAWGrpDetailService.fillParentInfo(pSDEAWGrpDetail, "DER1N", "DER1N_PSDEAWGRPDETAIL_PSDEAWGROUP_PSDEAWGROUPID", pSDEAWGroup.getPSDEAWGroupId());
                pSDEAWGrpDetailService.importXmlModel(pSDEAWGrpDetail, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEAWGroup pSDEAWGroup, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEAWGroup, string);
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
            return "DER1N_PSDEAWGROUP_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEAWGroup pSDEAWGroup) {
        if (!StringHelper.isNullOrEmpty((String)pSDEAWGroup.getCodeName())) {
            return pSDEAWGroup.getCodeName();
        }
        return super.getModelV2Tag(pSDEAWGroup);
    }

    @Override
    public boolean setModelV2Tag(PSDEAWGroup pSDEAWGroup, String string) {
        return super.setModelV2Tag(pSDEAWGroup, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEAWGroup pSDEAWGroup, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEAWGroup.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEAWGroup, true);
        pSDEAWGroup.set("CODENAME", string);
        if (this.select(pSDEAWGroup, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEAWGroup, true);
        return super.getModelV2Entity(pSDEAWGroup, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEAWGroup pSDEAWGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEAWGroup, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEAWGRPDETAIL_PSDEAWGROUP_PSDEAWGROUPID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEAWGroup pSDEAWGroup, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEAWGroup, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEAWGroup pSDEAWGroup, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEAWGRPDETAIL_PSDEAWGROUP_PSDEAWGROUPID")) {
            PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEAWGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEAWGRPDETAIL", (Object)pSDEAWGroup.getPSDEAWGroupId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEAWGROUP#%1$s", (Object)pSDEAWGroup.getPSDEAWGroupId());
                for (PSDEAWGrpDetail detail : pSDEAWGrpDetailService.selectByPSDEAWGroup(pSDEAWGroup)) {
                    String detailScope = pSDEAWGrpDetailService.getModelV2ResScope(detail);
                    if (StringHelper.compare((String)scope, (String)detailScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(detail, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                String modelName = pSDEAWGrpDetailService.getModelV2Name(false);
                ArrayNode arrayNode = objectNode.putArray(modelName.toLowerCase());
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
                        if (objectNode.has("psdeawgrpdetailname")) {
                            string = objectNode.get("psdeawgrpdetailname").asText();
                        }
                        if (objectNode2.has("psdeawgrpdetailname")) {
                            string2 = objectNode2.get("psdeawgrpdetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode detailNode : arrayList) {
                    PSDEAWGrpDetail detail = new PSDEAWGrpDetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)detail, detailNode, false);
                    arrayNode.add((JsonNode)pSDEAWGrpDetailService.exportModelV2(detail, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEAWGroup, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEAWGroup pSDEAWGroup) throws Exception {
        PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAWGrpDetail> arrayList = pSDEAWGrpDetailService.selectByPSDEAWGroup(pSDEAWGroup);
        String string = StringHelper.format((String)"PSDEAWGROUP#%1$s", (Object)pSDEAWGroup.getPSDEAWGroupId());
        for (PSDEAWGrpDetail pSDEAWGrpDetail : arrayList) {
            String string2 = pSDEAWGrpDetailService.getModelV2ResScope(pSDEAWGrpDetail);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEAWGrpDetailService.emptyModelV2(pSDEAWGrpDetail);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEAWGroup.getPSDEAWGroupId());
        pSDEAWGrpDetailService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEAWGrpDetailService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEAWGRPDETAIL WHERE PSDEAWGROUPID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEAWGroup);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEAWGrpDetailService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEAWGroup pSDEAWGroup, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEAWGrpDetail pSDEAWGrpDetail = new PSDEAWGrpDetail();
        pSDEAWGrpDetail.set("PSDEAWGROUPID", pSDEAWGroup.getPSDEAWGroupId());
        PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEAWGrpDetailService.getModelV2Entity(pSDEAWGrpDetail, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEAWGroup, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEAWGroup pSDEAWGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEAWGrpDetailService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEAWGrpDetail pSDEAWGrpDetail = new PSDEAWGrpDetail();
                pSDEAWGrpDetail.setPSDEAWGroupId(pSDEAWGroup.getPSDEAWGroupId());
                pSDEAWGrpDetail.setPSDEAWGroupName(pSDEAWGroup.getPSDEAWGroupName());
                pSDEAWGrpDetailService.compileModelV2(pSDEAWGrpDetail, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEAWGrpDetail pSDEAWGrpDetail = new PSDEAWGrpDetail();
                    pSDEAWGrpDetail.setPSDEAWGroupId(pSDEAWGroup.getPSDEAWGroupId());
                    pSDEAWGrpDetail.setPSDEAWGroupName(pSDEAWGroup.getPSDEAWGroupName());
                    pSDEAWGrpDetailService.compileModelV2(pSDEAWGrpDetail, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEAWGroup, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEAWGroup pSDEAWGroup, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEAWGRPDETAIL_PSDEAWGROUP_PSDEAWGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEAWGrpDetails(pSDEAWGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEAWGroup, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEAWGrpDetails(PSDEAWGroup pSDEAWGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEAWGRPDETAIL", true), (boolean)false) == 0) {
            PSDEAWGrpDetailService pSDEAWGrpDetailService = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEAWGrpDetail pSDEAWGrpDetail = new PSDEAWGrpDetail();
            pSDEAWGrpDetail.setPSDEAWGrpDetailId(pSMOSFile.getPSModelId());
            if (!pSDEAWGrpDetailService.get(pSDEAWGrpDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEAWGrpDetail.getPSDEAWGroupId(), (String)pSDEAWGroup.getPSDEAWGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEAWGrpDetailService.exportModelV2(pSDEAWGrpDetail);
            pSDEAWGrpDetail.reset();
            if (!pSDEAWGrpDetailService.setModelV2ResScope(pSDEAWGrpDetail, "PSDEAWGROUP", pSDEAWGroup.getPSDEAWGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEAWGrpDetailService.importModelV2(pSDEAWGrpDetail, objectNode);
            SessionFactoryManager.commit();
            return pSDEAWGrpDetailService.getFile(pSDEAWGrpDetail);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEAWGroup pSDEAWGroup, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEAWGrpDetails(pSDEAWGroup, list);
        super.onFillPasteHelps(pSDEAWGroup, list);
    }

    protected void onFillPasteHelps_PSDEAWGrpDetails(PSDEAWGroup pSDEAWGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEAWGRPDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEAWGRPDETAIL_PSDEAWGROUP_PSDEAWGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4]\u7684[\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
    }
}
