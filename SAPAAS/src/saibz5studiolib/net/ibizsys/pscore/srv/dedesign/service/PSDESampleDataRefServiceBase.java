/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDESampleDataRefDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDESampleDataRefDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleDataBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleDataRef;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESampleDataRefServiceBase
extends PSCoreSysServiceBase<PSDESampleDataRef> {
    private static final Log log = LogFactory.getLog(PSDESampleDataRefServiceBase.class);
    private PSDESampleDataRefDEModel pSDESampleDataRefDEModel;
    private PSDESampleDataRefDAO pSDESampleDataRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataRefService";
    }

    public PSDESampleDataRefDEModel getPSDESampleDataRefDEModel() {
        if (this.pSDESampleDataRefDEModel == null) {
            try {
                this.pSDESampleDataRefDEModel = (PSDESampleDataRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDESampleDataRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESampleDataRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDESampleDataRefDEModel();
    }

    public PSDESampleDataRefDAO getPSDESampleDataRefDAO() {
        if (this.pSDESampleDataRefDAO == null) {
            try {
                this.pSDESampleDataRefDAO = (PSDESampleDataRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDESampleDataRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESampleDataRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDESampleDataRefDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSDESampleDataRef pSDESampleDataRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESAMPLEDATAREF_PSDESAMPLEDATA_PSDESAMPLEDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService", (SessionFactory)this.getSessionFactory());
            PSDESampleData pSDESampleData = (PSDESampleData)iService.getDEModel().createEntity();
            pSDESampleData.set("PSDESAMPLEDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDESampleData);
            } else {
                iService.get((IEntity)pSDESampleData);
            }
            this.onFillParentInfo_PSDESampleData(pSDESampleDataRef, pSDESampleData);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESAMPLEDATAREF_PSDESAMPLEDATA_REFPSDESAMPLEDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService", (SessionFactory)this.getSessionFactory());
            PSDESampleData pSDESampleData = (PSDESampleData)iService.getDEModel().createEntity();
            pSDESampleData.set("PSDESAMPLEDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDESampleData);
            } else {
                iService.get((IEntity)pSDESampleData);
            }
            this.onFillParentInfo_RefPSDESampleData(pSDESampleDataRef, pSDESampleData);
            return;
        }
        super.onFillParentInfo((IEntity)pSDESampleDataRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDESampleData(PSDESampleDataRef pSDESampleDataRef, PSDESampleData pSDESampleData) throws Exception {
        pSDESampleDataRef.setPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
        pSDESampleDataRef.setPSDESampleDataName(pSDESampleData.getPSDESampleDataName());
    }

    protected void onFillParentInfo_RefPSDESampleData(PSDESampleDataRef pSDESampleDataRef, PSDESampleData pSDESampleData) throws Exception {
        pSDESampleDataRef.setRefPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
        pSDESampleDataRef.setRefPSDESampleDataName(pSDESampleData.getPSDESampleDataName());
    }

    protected void onFillEntityFullInfo(PSDESampleDataRef pSDESampleDataRef, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDESampleDataRef, bl);
        this.onFillEntityFullInfo_PSDESampleData(pSDESampleDataRef, bl);
        this.onFillEntityFullInfo_RefPSDESampleData(pSDESampleDataRef, bl);
    }

    protected void onFillEntityFullInfo_PSDESampleData(PSDESampleDataRef pSDESampleDataRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDESampleData(PSDESampleDataRef pSDESampleDataRef, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDESampleDataRef pSDESampleDataRef, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDESampleDataRef, bl);
    }

    public ArrayList<PSDESampleDataRef> selectByPSDESampleData(PSDESampleDataBase pSDESampleDataBase) throws Exception {
        return this.selectByPSDESampleData(pSDESampleDataBase, "", -1);
    }

    public ArrayList<PSDESampleDataRef> selectByPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string) throws Exception {
        return this.selectByPSDESampleData(pSDESampleDataBase, string, -1);
    }

    public ArrayList<PSDESampleDataRef> selectByPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESAMPLEDATAID", (Object)pSDESampleDataBase.getPSDESampleDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDESampleDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDESampleDataCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESampleDataRef> selectByRefPSDESampleData(PSDESampleDataBase pSDESampleDataBase) throws Exception {
        return this.selectByRefPSDESampleData(pSDESampleDataBase, "", -1);
    }

    public ArrayList<PSDESampleDataRef> selectByRefPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string) throws Exception {
        return this.selectByRefPSDESampleData(pSDESampleDataBase, string, -1);
    }

    public ArrayList<PSDESampleDataRef> selectByRefPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDESAMPLEDATAID", (Object)pSDESampleDataBase.getPSDESampleDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDESampleDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDESampleDataCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    public void resetPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDESampleDataRef> arrayList = this.selectByPSDESampleData(pSDESampleData);
        for (PSDESampleDataRef pSDESampleDataRef : arrayList) {
            PSDESampleDataRef pSDESampleDataRef2 = (PSDESampleDataRef)this.getDEModel().createEntity();
            pSDESampleDataRef2.setPSDESampleDataRefId(pSDESampleDataRef.getPSDESampleDataRefId());
            pSDESampleDataRef2.setPSDESampleDataId(null);
            this.update(pSDESampleDataRef2);
        }
    }

    public void removeByPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        final PSDESampleData pSDESampleData2 = pSDESampleData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESampleDataRefServiceBase.this.onBeforeRemoveByPSDESampleData(pSDESampleData2);
                PSDESampleDataRefServiceBase.this.internalRemoveByPSDESampleData(pSDESampleData2);
                PSDESampleDataRefServiceBase.this.onAfterRemoveByPSDESampleData(pSDESampleData2);
            }
        });
    }

    protected void onBeforeRemoveByPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void internalRemoveByPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDESampleDataRef> arrayList = this.selectByPSDESampleData(pSDESampleData);
        this.onBeforeRemoveByPSDESampleData(pSDESampleData, arrayList);
        for (PSDESampleDataRef pSDESampleDataRef : arrayList) {
            this.remove((IEntity)pSDESampleDataRef);
        }
        this.onAfterRemoveByPSDESampleData(pSDESampleData, arrayList);
    }

    protected void onAfterRemoveByPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void onBeforeRemoveByPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDESampleDataRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDESampleDataRef> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDESampleDataRef> arrayList = this.selectByRefPSDESampleData(pSDESampleData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESAMPLEDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDESampleData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESAMPLEDATAREF_PSDESAMPLEDATA_REFPSDESAMPLEDATAID", "", iDataEntityModel.getName(), "PSDESAMPLEDATAREF", iDataEntityModel.getDataInfo((IEntity)pSDESampleData), arrayList.get(0)));
        }
    }

    public void resetRefPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDESampleDataRef> arrayList = this.selectByRefPSDESampleData(pSDESampleData);
        for (PSDESampleDataRef pSDESampleDataRef : arrayList) {
            PSDESampleDataRef pSDESampleDataRef2 = (PSDESampleDataRef)this.getDEModel().createEntity();
            pSDESampleDataRef2.setPSDESampleDataRefId(pSDESampleDataRef.getPSDESampleDataRefId());
            pSDESampleDataRef2.setRefPSDESampleDataId(null);
            this.update(pSDESampleDataRef2);
        }
    }

    public void removeByRefPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        final PSDESampleData pSDESampleData2 = pSDESampleData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESampleDataRefServiceBase.this.onBeforeRemoveByRefPSDESampleData(pSDESampleData2);
                PSDESampleDataRefServiceBase.this.internalRemoveByRefPSDESampleData(pSDESampleData2);
                PSDESampleDataRefServiceBase.this.onAfterRemoveByRefPSDESampleData(pSDESampleData2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void internalRemoveByRefPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDESampleDataRef> arrayList = this.selectByRefPSDESampleData(pSDESampleData);
        this.onBeforeRemoveByRefPSDESampleData(pSDESampleData, arrayList);
        for (PSDESampleDataRef pSDESampleDataRef : arrayList) {
            this.remove((IEntity)pSDESampleDataRef);
        }
        this.onAfterRemoveByRefPSDESampleData(pSDESampleData, arrayList);
    }

    protected void onAfterRemoveByRefPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDESampleDataRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDESampleDataRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDESampleDataRef pSDESampleDataRef) throws Exception {
        super.onBeforeRemove(pSDESampleDataRef);
    }

    protected void replaceParentInfo(PSDESampleDataRef pSDESampleDataRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDESampleDataRef, cloneSession);
        if (pSDESampleDataRef.getPSDESampleDataId() != null && (iEntity = cloneSession.getEntity("PSDESAMPLEDATA", (Object)pSDESampleDataRef.getPSDESampleDataId())) != null) {
            this.onFillParentInfo_PSDESampleData(pSDESampleDataRef, (PSDESampleData)iEntity);
        }
        if (pSDESampleDataRef.getRefPSDESampleDataId() != null && (iEntity = cloneSession.getEntity("PSDESAMPLEDATA", (Object)pSDESampleDataRef.getRefPSDESampleDataId())) != null) {
            this.onFillParentInfo_RefPSDESampleData(pSDESampleDataRef, (PSDESampleData)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDESampleDataRef pSDESampleDataRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDESampleDataRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSDESampleDataRef pSDESampleDataRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDESampleDataId(bl, pSDESampleDataRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESampleDataRefId(bl, pSDESampleDataRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESampleDataRefName(bl, pSDESampleDataRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDESampleDataId(bl, pSDESampleDataRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDESampleDataRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDESampleDataId(boolean bl, PSDESampleDataRef pSDESampleDataRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleDataRef.isPSDESampleDataIdDirty() : !pSDESampleDataRef.isPSDESampleDataIdDirty()) {
            return null;
        }
        String string = pSDESampleDataRef.getPSDESampleDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESampleDataId_Default((IEntity)pSDESampleDataRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAMPLEDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESampleDataRefId(boolean bl, PSDESampleDataRef pSDESampleDataRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleDataRef.isPSDESampleDataRefIdDirty() && !bl2 : !pSDESampleDataRef.isPSDESampleDataRefIdDirty()) {
            return null;
        }
        String string = pSDESampleDataRef.getPSDESampleDataRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAMPLEDATAREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESampleDataRefId_Default((IEntity)pSDESampleDataRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAMPLEDATAREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESampleDataRefName(boolean bl, PSDESampleDataRef pSDESampleDataRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleDataRef.isPSDESampleDataRefNameDirty() && !bl2 : !pSDESampleDataRef.isPSDESampleDataRefNameDirty()) {
            return null;
        }
        String string = pSDESampleDataRef.getPSDESampleDataRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAMPLEDATAREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESampleDataRefName_Default((IEntity)pSDESampleDataRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAMPLEDATAREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDESampleDataId(boolean bl, PSDESampleDataRef pSDESampleDataRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleDataRef.isRefPSDESampleDataIdDirty() && !bl2 : !pSDESampleDataRef.isRefPSDESampleDataIdDirty()) {
            return null;
        }
        String string = pSDESampleDataRef.getRefPSDESampleDataId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDESAMPLEDATAID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDESampleDataId_Default((IEntity)pSDESampleDataRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDESAMPLEDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDESampleDataRef pSDESampleDataRef, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDESampleDataRef, bl);
    }

    protected void onSyncIndexEntities(PSDESampleDataRef pSDESampleDataRef, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDESampleDataRef, bl);
    }

    public Object getDataContextValue(PSDESampleDataRef pSDESampleDataRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDESampleDataRef, string, iDataContextParam)) != null) {
            return object;
        }
        PSDESampleData pSDESampleData = pSDESampleDataRef.getPSDESampleData();
        if (pSDESampleData != null && pSDESampleData.contains(string)) {
            return pSDESampleData.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDESampleDataRef pSDESampleDataRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDESampleDataRef, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESAMPLEDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDESampleDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESAMPLEDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDESampleDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESAMPLEDATAREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDESampleDataRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESAMPLEDATAREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDESampleDataRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDESAMPLEDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDESampleDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDESAMPLEDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDESampleDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDESampleDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESAMPLEDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESampleDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESAMPLEDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESampleDataRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESAMPLEDATAREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESampleDataRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESAMPLEDATAREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDESampleDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDESAMPLEDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDESampleDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDESAMPLEDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSDESampleDataRef pSDESampleDataRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDESampleDataRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDESampleDataRef pSDESampleDataRef) throws Exception {
        super.onUpdateParent((IEntity)pSDESampleDataRef);
    }

    @Override
    protected void exportCurXmlModel(PSDESampleDataRef pSDESampleDataRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDESAMPLEDATAREF");
        if (!bl) {
            pSDESampleDataRef.setCreateDate(null);
            pSDESampleDataRef.setCreateMan(null);
            pSDESampleDataRef.setPSDESampleDataName(null);
            pSDESampleDataRef.setPSDESampleDataRefId(null);
            pSDESampleDataRef.setUpdateDate(null);
            pSDESampleDataRef.setUpdateMan(null);
            super.exportCurXmlModel(pSDESampleDataRef, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDESampleDataRef pSDESampleDataRef, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDESampleDataRef, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESAMPLEDATAID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDESAMPLEDATA#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESAMPLEDATAID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDESAMPLEDATAREF_PSDESAMPLEDATA_PSDESAMPLEDATAID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESAMPLEDATAID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESAMPLEDATANAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDESAMPLEDATA", (boolean)true) == 0) {
            iEntity.set("PSDESAMPLEDATAID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDESAMPLEDATAID"};
    }

    @Override
    public String getModelV2Tag(PSDESampleDataRef pSDESampleDataRef) {
        return super.getModelV2Tag(pSDESampleDataRef);
    }

    @Override
    public boolean setModelV2Tag(PSDESampleDataRef pSDESampleDataRef, String string) {
        return super.setModelV2Tag(pSDESampleDataRef, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDESAMPLEDATAID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDESampleDataRef pSDESampleDataRef, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDESampleDataRef.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDESampleDataRef, true);
        return super.getModelV2Entity(pSDESampleDataRef, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDESampleDataRef pSDESampleDataRef, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDESampleDataRef, objectNode, string, string2, n);
    }
}

