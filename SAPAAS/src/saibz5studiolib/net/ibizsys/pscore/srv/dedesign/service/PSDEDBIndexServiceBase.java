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
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDBIndexDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDBIndexDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBIdxField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBIndex;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDBIdxFieldService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDBIndexServiceBase
extends PSCoreSysServiceBase<PSDEDBIndex> {
    private static final Log log = LogFactory.getLog(PSDEDBIndexServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEDBIndexDEModel pSDEDBIndexDEModel;
    private PSDEDBIndexDAO pSDEDBIndexDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDBIndexService";
    }

    public PSDEDBIndexDEModel getPSDEDBIndexDEModel() {
        if (this.pSDEDBIndexDEModel == null) {
            try {
                this.pSDEDBIndexDEModel = (PSDEDBIndexDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDBIndexDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDBIndexDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDBIndexDEModel();
    }

    public PSDEDBIndexDAO getPSDEDBIndexDAO() {
        if (this.pSDEDBIndexDAO == null) {
            try {
                this.pSDEDBIndexDAO = (PSDEDBIndexDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDBIndexDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDBIndexDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDBIndexDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEDBIndex pSDEDBIndex, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDBINDEX_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEDBIndex, pSDataEntity);
            return;
        }
        super.onFillParentInfo(pSDEDBIndex, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEDBIndex pSDEDBIndex, PSDataEntity pSDataEntity) throws Exception {
        pSDEDBIndex.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDBIndex.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillEntityFullInfo(PSDEDBIndex pSDEDBIndex, boolean bl) throws Exception {
        if (bl) {
            if (pSDEDBIndex.getAllowReverse() == null) {
                pSDEDBIndex.setAllowReverse((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDEDBIndex.getPSDEDBIndexName() == null) {
                pSDEDBIndex.setPSDEDBIndexName((String)this.getDefaultValue(this.getWebContext(), "USER", "DBINDEX", 25));
            }
        }
        super.onFillEntityFullInfo(pSDEDBIndex, bl);
        this.onFillEntityFullInfo_PSDE(pSDEDBIndex, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEDBIndex pSDEDBIndex, boolean bl) throws Exception {
        if (pSDEDBIndex.isPSDEIdDirty()) {
            if (pSDEDBIndex.getPSDEId() != null) {
                if (pSDEDBIndex.getPSDEId() == null || pSDEDBIndex.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEDBIndex.getPSDE();
                    pSDEDBIndex.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEDBIndex.setPSDEName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEDBIndex pSDEDBIndex, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEDBIndex, bl);
    }

    public ArrayList<PSDEDBIndex> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDBIndex> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDBIndex> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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
        ArrayList<PSDEDBIndex> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEDBIndex pSDEDBIndex : arrayList) {
            PSDEDBIndex pSDEDBIndex2 = (PSDEDBIndex)this.getDEModel().createEntity();
            pSDEDBIndex2.setPSDEDBIndexId(pSDEDBIndex.getPSDEDBIndexId());
            pSDEDBIndex2.setPSDEId(null);
            this.update(pSDEDBIndex2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDBIndexServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEDBIndexServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEDBIndexServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDBIndex> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEDBIndex pSDEDBIndex : arrayList) {
            this.remove(pSDEDBIndex);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDBIndex> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDBIndex> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDBIndex pSDEDBIndex) throws Exception {
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        pSDEDBIdxFieldService.testRemoveByPSDEDBIndex(pSDEDBIndex);
        pSDEDBIdxFieldService.removeByPSDEDBIndex(pSDEDBIndex);
        super.onBeforeRemove(pSDEDBIndex);
    }

    protected void onBeforeRemoveTemp(PSDEDBIndex pSDEDBIndex) throws Exception {
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        pSDEDBIdxFieldService.removeTempByPSDEDBIndex(pSDEDBIndex);
        super.onBeforeRemoveTemp(pSDEDBIndex);
    }

    protected void getRelatedDataTempMajor(PSDEDBIndex pSDEDBIndex) throws Exception {
        this.getRelatedDataTempMajor_PSDEDBIdxField(pSDEDBIndex);
        super.getRelatedDataTempMajor(pSDEDBIndex);
    }

    protected void getRelatedDataTempMajor_PSDEDBIdxField(PSDEDBIndex pSDEDBIndex) throws Exception {
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDBIdxField> arrayList = null;
        String string = pSDEDBIndex.getPSDEDBIndexId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDBIdxFieldService.selectByPSDEDBIndex(pSDEDBIndex) : pSDEDBIdxFieldService.selectTempByPSDEDBIndex(pSDEDBIndex);
        for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
            pSDEDBIdxFieldService.getTempMajor(pSDEDBIdxField);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEDBIndex pSDEDBIndex, PSDEDBIndex pSDEDBIndex2) throws Exception {
        ArrayList<PSDEDBIdxField> arrayList = this.updateRelatedDataTempMajor_removePSDEDBIdxField(pSDEDBIndex, pSDEDBIndex2);
        this.updateRelatedDataTempMajor_updatePSDEDBIdxField(pSDEDBIndex, pSDEDBIndex2, arrayList);
        super.updateRelatedDataTempMajor(pSDEDBIndex, pSDEDBIndex2);
    }

    protected ArrayList<PSDEDBIdxField> updateRelatedDataTempMajor_removePSDEDBIdxField(PSDEDBIndex pSDEDBIndex, PSDEDBIndex pSDEDBIndex2) throws Exception {
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDBIdxField> arrayList = pSDEDBIdxFieldService.selectTempByPSDEDBIndex(pSDEDBIndex);
        ArrayList<PSDEDBIdxField> arrayList2 = pSDEDBIdxFieldService.selectByPSDEDBIndex(pSDEDBIndex2);
        HashMap<String, PSDEDBIdxField> hashMap = new HashMap<String, PSDEDBIdxField>();
        for (PSDEDBIdxField pSDEDBIdxField : arrayList2) {
            hashMap.put(pSDEDBIdxField.getPSDEDBIdxFieldId(), pSDEDBIdxField);
        }
        for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
            Object object = pSDEDBIdxField.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEDBIdxField pSDEDBIdxField : hashMap.values()) {
            pSDEDBIdxFieldService.remove(pSDEDBIdxField);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEDBIdxField(PSDEDBIndex pSDEDBIndex, PSDEDBIndex pSDEDBIndex2, ArrayList<PSDEDBIdxField> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
            pSDEDBIdxFieldService.updateTempMajor(pSDEDBIdxField);
        }
    }

    protected void replaceParentInfo(PSDEDBIndex pSDEDBIndex, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEDBIndex, cloneSession);
        if (pSDEDBIndex.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDBIndex.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEDBIndex, (PSDataEntity)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDBIndex pSDEDBIndex, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEDBIndex, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowReverse(bl, pSDEDBIndex, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEDBIndex, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncFields(bl, pSDEDBIndex, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IndexFields(bl, pSDEDBIndex, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IndexType(bl, pSDEDBIndex, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDBIndex, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDBIndexId(bl, pSDEDBIndex, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDBIndexName(bl, pSDEDBIndex, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDBIndex, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEDBIndex, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoveFlag(bl, pSDEDBIndex, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEDBIndex, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEDBIndex, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowReverse(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isAllowReverseDirty() : !pSDEDBIndex.isAllowReverseDirty()) {
            return null;
        }
        Integer n = pSDEDBIndex.getAllowReverse();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllowReverse_Default(pSDEDBIndex, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWREVERSE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isCodeNameDirty() : !pSDEDBIndex.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEDBIndex.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEDBIndex, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEDBIndexDEModel(), "CODENAME", string3, pSDEDBIndex, bl2, bl3);
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

    protected EntityFieldError onCheckField_IncFields(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isIncFieldsDirty() : !pSDEDBIndex.isIncFieldsDirty()) {
            return null;
        }
        String string = pSDEDBIndex.getIncFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IncFields_Default(pSDEDBIndex, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IndexFields(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isIndexFieldsDirty() : !pSDEDBIndex.isIndexFieldsDirty()) {
            return null;
        }
        String string = pSDEDBIndex.getIndexFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IndexFields_Default(pSDEDBIndex, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INDEXFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IndexType(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isIndexTypeDirty() : !pSDEDBIndex.isIndexTypeDirty()) {
            return null;
        }
        String string = pSDEDBIndex.getIndexType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IndexType_Default(pSDEDBIndex, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INDEXTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isMemoDirty() : !pSDEDBIndex.isMemoDirty()) {
            return null;
        }
        String string = pSDEDBIndex.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEDBIndex, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDBIndexId(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isPSDEDBIndexIdDirty() && !bl2 : !pSDEDBIndex.isPSDEDBIndexIdDirty()) {
            return null;
        }
        String string = pSDEDBIndex.getPSDEDBIndexId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBINDEXID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDBIndexId_Default(pSDEDBIndex, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBINDEXID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDBIndexName(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isPSDEDBIndexNameDirty() && !bl2 : !pSDEDBIndex.isPSDEDBIndexNameDirty()) {
            return null;
        }
        String string = pSDEDBIndex.getPSDEDBIndexName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBINDEXNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDBIndexName_Default(pSDEDBIndex, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBINDEXNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEDBIndexDEModel(), "PSDEDBINDEXNAME", string3, pSDEDBIndex, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDBINDEXNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isPSDEIdDirty() && !bl2 : !pSDEDBIndex.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDBIndex.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEDBIndex, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isPSDENameDirty() && !bl2 : !pSDEDBIndex.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEDBIndex.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEDBIndex, bl2, bl3);
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

    protected EntityFieldError onCheckField_RemoveFlag(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isRemoveFlagDirty() : !pSDEDBIndex.isRemoveFlagDirty()) {
            return null;
        }
        Integer n = pSDEDBIndex.getRemoveFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RemoveFlag_Default(pSDEDBIndex, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEDBIndex pSDEDBIndex, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBIndex.isUserParamsDirty() : !pSDEDBIndex.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEDBIndex.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDEDBIndex, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEDBIndex pSDEDBIndex, boolean bl) throws Exception {
        super.onSyncEntity(pSDEDBIndex, bl);
    }

    protected void onSyncIndexEntities(PSDEDBIndex pSDEDBIndex, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEDBIndex, bl);
    }

    public Object getDataContextValue(PSDEDBIndex pSDEDBIndex, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEDBIndex, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEDBIndex.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEDBIndex pSDEDBIndex, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEDBIdxField_PSDEDBIndex(pSDEDBIndex, arrayList, n);
        super.onExportRelatedModel(pSDEDBIndex, arrayList, n);
    }

    /*
     * WARNING - void declaration
     */
    protected void onExportRelatedModel_PSDEDBIdxField_PSDEDBIndex(PSDEDBIndex pSDEDBIndex, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDBIdxField> arrayList2 = pSDEDBIdxFieldService.selectByPSDEDBIndex(pSDEDBIndex);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"e769f6f657b2f4a433f3661e9092421d");
            jSONObject.put("srfdename", (Object)"PSDEDBIDXFIELD");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDBIndex, (String)"PSDEDBINDEXID", (String)""));
            String object = "";
            for (PSDEDBIdxField pSDEDBIdxField : arrayList2) {
                if (!StringHelper.isNullOrEmpty((String)object)) {
                    object = object + ";";
                }
                object = object + DataObject.getStringValue((IDataObject)pSDEDBIdxField, (String)"PSDEDBIDXFIELDID", (String)"");
            }
            jSONObject.put("srfarg2", (Object)object);
            arrayList.add(jSONObject);
        }
        for (PSDEDBIdxField pSDEDBIdxField : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDBIdxField, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDBIdxFieldService.exportModel(pSDEDBIdxField, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEDBIndex pSDEDBIndex, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEDBIndex, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWREVERSE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowReverse_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncFields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INDEXFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IndexFields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INDEXTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IndexType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDBINDEXID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDBIndexId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDBINDEXNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDBIndexName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoveFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllowReverse_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_IncFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INCFIELDS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IndexFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INDEXFIELDS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IndexType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INDEXTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDEDBIndexId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDBINDEXID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDBIndexName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDBINDEXNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDEDBINDEXNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_RemoveFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEDBIndex pSDEDBIndex) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEDBIndex)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDBIndex pSDEDBIndex) throws Exception {
        Object object = pSDEDBIndex.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEDBINDEX_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEDBIndex);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEDBIndex pSDEDBIndex, Object object) throws Exception {
        PSDEDBIndex pSDEDBIndex2 = new PSDEDBIndex();
        pSDEDBIndex2.set("PSDEDBINDEXID", object);
        String string = DataObject.getStringValue((Object)pSDEDBIndex.get("PSDEDBINDEXID"));
        super.onCopyDetails(pSDEDBIndex, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEDBIndex pSDEDBIndex, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDBINDEX");
        if (!bl) {
            pSDEDBIndex.setCreateDate(null);
            pSDEDBIndex.setCreateMan(null);
            pSDEDBIndex.setPSDEDBIndexId(null);
            pSDEDBIndex.setUpdateDate(null);
            pSDEDBIndex.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDBIndex, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEDBIndex pSDEDBIndex, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEDBIndex, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEDBIndex pSDEDBIndex, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEDBIndex, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDBIndex pSDEDBIndex, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDBIndex, string);
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
            return "DER1N_PSDEDBINDEX_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEDBIndex pSDEDBIndex) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDBIndex.getPSDEDBIndexName())) {
            return pSDEDBIndex.getPSDEDBIndexName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEDBIndex.getCodeName())) {
            return pSDEDBIndex.getCodeName();
        }
        return super.getModelV2Tag(pSDEDBIndex);
    }

    @Override
    public boolean setModelV2Tag(PSDEDBIndex pSDEDBIndex, String string) {
        pSDEDBIndex.setPSDEDBIndexName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEDBINDEXNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEDBINDEXNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDBIndex pSDEDBIndex, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDBIndex.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDBIndex, true);
        pSDEDBIndex.set("PSDEDBINDEXNAME", string);
        if (this.select(pSDEDBIndex, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDBIndex, true);
        return super.getModelV2Entity(pSDEDBIndex, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDBIndex pSDEDBIndex, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDBIndex, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEDBIndex pSDEDBIndex, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEDBIndex, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEDBIndex pSDEDBIndex, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID")) {
            PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDBINDEX#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDBIDXFIELD", (Object)pSDEDBIndex.getPSDEDBIndexId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEDBINDEX#%1$s", (Object)pSDEDBIndex.getPSDEDBIndexId());
                for (PSDEDBIdxField field : pSDEDBIdxFieldService.selectByPSDEDBIndex(pSDEDBIndex)) {
                    String fieldScope = pSDEDBIdxFieldService.getModelV2ResScope(field);
                    if (StringHelper.compare((String)scope, (String)fieldScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(field, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSDEDBIdxFieldService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdedbidxfieldname")) {
                            string = objectNode.get("psdedbidxfieldname").asText();
                        }
                        if (objectNode2.has("psdedbidxfieldname")) {
                            string2 = objectNode2.get("psdedbidxfieldname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode fieldNode : arrayList) {
                    PSDEDBIdxField field = new PSDEDBIdxField();
                    PSModelV2Helper.fromJSONObject((IDataObject)field, fieldNode, false);
                    output.add((JsonNode)pSDEDBIdxFieldService.exportModelV2(field, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEDBIndex, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEDBIndex pSDEDBIndex) throws Exception {
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDBIdxField> arrayList = pSDEDBIdxFieldService.selectByPSDEDBIndex(pSDEDBIndex);
        String string = StringHelper.format((String)"PSDEDBINDEX#%1$s", (Object)pSDEDBIndex.getPSDEDBIndexId());
        for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
            String string2 = pSDEDBIdxFieldService.getModelV2ResScope(pSDEDBIdxField);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEDBIdxFieldService.emptyModelV2(pSDEDBIdxField);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEDBIndex.getPSDEDBIndexId());
        pSDEDBIdxFieldService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEDBIdxFieldService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDBIDXFIELD WHERE PSDEDBINDEXID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEDBIndex);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEDBIdxFieldService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEDBIndex pSDEDBIndex, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEDBIdxField pSDEDBIdxField = new PSDEDBIdxField();
        pSDEDBIdxField.set("PSDEDBINDEXID", pSDEDBIndex.getPSDEDBIndexId());
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEDBIdxFieldService.getModelV2Entity(pSDEDBIdxField, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEDBIndex, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEDBIndex pSDEDBIndex, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEDBIdxFieldService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEDBIdxField pSDEDBIdxField = new PSDEDBIdxField();
                pSDEDBIdxField.setPSDEDBIndexId(pSDEDBIndex.getPSDEDBIndexId());
                pSDEDBIdxField.setPSDEDBIndexName(pSDEDBIndex.getPSDEDBIndexName());
                pSDEDBIdxFieldService.compileModelV2(pSDEDBIdxField, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEDBIdxField pSDEDBIdxField = new PSDEDBIdxField();
                    pSDEDBIdxField.setPSDEDBIndexId(pSDEDBIndex.getPSDEDBIndexId());
                    pSDEDBIdxField.setPSDEDBIndexName(pSDEDBIndex.getPSDEDBIndexName());
                    pSDEDBIdxFieldService.compileModelV2(pSDEDBIdxField, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEDBIndex, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEDBIndex pSDEDBIndex, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSDEDBIndex, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSDEDBIndex pSDEDBIndex, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSDEDBIndex, list);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u7d22\u5f15\u5217>", "DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID", "PSDEDBINDEXID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSDEDBIndexServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u7d22\u5f15\u5217>");
            } else if (PSDEDBIndexServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdedbidxfields");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID|PSDEDBINDEXID");
            pSMOSFile2.setFileTag3("PSDEDBIDXFIELD");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID", "PSDEDBINDEXID", pSMOSFile.getPSModelId(), "", "")) {
                PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEDBIdxFieldService, "DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID", "PSDEDBINDEXID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSDEDBIdxFieldService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEDBIndexServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSDEDBIndexServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u7d22\u5f15\u5217>", (boolean)false) == 0 || PSDEDBIndexServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"psdedbidxfields", (boolean)true) == 0) {
            PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEDBIdxFieldService, "DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID", "PSDEDBINDEXID", pSMOSFile.getPSModelId(), "", "");
            ArrayList arrayList2 = pSDEDBIdxFieldService.selectEx((ISelectContext)selectContext);
            for (Object item : arrayList2) {
                PSDEDBIdxField pSDEDBIdxField = (PSDEDBIdxField)item;
                PSMOSFile pSMOSFile2 = pSDEDBIdxFieldService.getFile(pSMOSFile, pSDEDBIdxField, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDBIDXFIELD_PSDEDBINDEX_PSDEDBINDEXID", (boolean)false) == 0) {
            if (PSDEDBIndexServiceBase.getMOSVer() == 1) {
                return "<\u7d22\u5f15\u5217>";
            }
            if (PSDEDBIndexServiceBase.getMOSVer() == 2) {
                return "psdedbidxfields";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEDBIndex pSDEDBIndex, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("PSDEDBINDEXNAME", "DBINDEX");
    }
}
