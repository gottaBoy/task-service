/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
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
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
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
import net.ibizsys.pscore.srv.sysdesign.dao.PSModelMemoDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSModelMemoDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelMemo;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelMemoBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSModelMemoService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelMemoServiceBase
extends PSCoreSysServiceBase<PSModelMemo> {
    private static final Log log = LogFactory.getLog(PSModelMemoServiceBase.class);
    public static final String DATASET_CURMODEL = "CurModel";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelMemoDEModel pSModelMemoDEModel;
    private PSModelMemoDAO pSModelMemoDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSModelMemoService";
    }

    public PSModelMemoDEModel getPSModelMemoDEModel() {
        if (this.pSModelMemoDEModel == null) {
            try {
                this.pSModelMemoDEModel = (PSModelMemoDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSModelMemoDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelMemoDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelMemoDEModel();
    }

    public PSModelMemoDAO getPSModelMemoDAO() {
        if (this.pSModelMemoDAO == null) {
            try {
                this.pSModelMemoDAO = (PSModelMemoDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSModelMemoDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelMemoDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelMemoDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURMODEL, (boolean)true) == 0) {
            return this.fetchCurModel(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurModel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMODEL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSModelMemo pSModelMemo, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELMEMO_PSMODELMEMO_PPSMODELMEMOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModelMemoService", (SessionFactory)this.getSessionFactory());
            PSModelMemo pSModelMemo2 = (PSModelMemo)iService.getDEModel().createEntity();
            pSModelMemo2.set("PSMODELMEMOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModelMemo2);
            } else {
                iService.get(pSModelMemo2);
            }
            this.onFillParentInfo_PPSModelMemo(pSModelMemo, pSModelMemo2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELMEMO_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSModelMemo, pSSystem);
            return;
        }
        super.onFillParentInfo(pSModelMemo, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSModelMemo(PSModelMemo pSModelMemo, PSModelMemo pSModelMemo2) throws Exception {
        pSModelMemo.setPPSModelMemoId(pSModelMemo2.getPSModelMemoId());
    }

    protected void onFillParentInfo_PSSystem(PSModelMemo pSModelMemo, PSSystem pSSystem) throws Exception {
        pSModelMemo.setPSSystemId(pSSystem.getPSSystemId());
        pSModelMemo.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSModelMemo pSModelMemo, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSModelMemo, bl);
        this.onFillEntityFullInfo_PPSModelMemo(pSModelMemo, bl);
        this.onFillEntityFullInfo_PSSystem(pSModelMemo, bl);
    }

    protected void onFillEntityFullInfo_PPSModelMemo(PSModelMemo pSModelMemo, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSModelMemo pSModelMemo, boolean bl) throws Exception {
        if (pSModelMemo.isPSSystemIdDirty()) {
            if (pSModelMemo.getPSSystemId() != null) {
                if (pSModelMemo.getPSSystemId() == null || pSModelMemo.getPSSystemName() == null) {
                    PSSystem pSSystem = pSModelMemo.getPSSystem();
                    pSModelMemo.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSModelMemo.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSModelMemo pSModelMemo, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelMemo, bl);
    }

    public ArrayList<PSModelMemo> selectByPPSModelMemo(PSModelMemoBase pSModelMemoBase) throws Exception {
        return this.selectByPPSModelMemo(pSModelMemoBase, "", -1);
    }

    public ArrayList<PSModelMemo> selectByPPSModelMemo(PSModelMemoBase pSModelMemoBase, String string) throws Exception {
        return this.selectByPPSModelMemo(pSModelMemoBase, string, -1);
    }

    public ArrayList<PSModelMemo> selectByPPSModelMemo(PSModelMemoBase pSModelMemoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSMODELMEMOID", (Object)pSModelMemoBase.getPSModelMemoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSModelMemoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSModelMemoCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelMemo> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSModelMemo> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSModelMemo> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSModelMemo(PSModelMemo pSModelMemo) throws Exception {
        ArrayList<PSModelMemo> arrayList = this.selectByPPSModelMemo(pSModelMemo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELMEMO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModelMemo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELMEMO_PSMODELMEMO_PPSMODELMEMOID", "", iDataEntityModel.getName(), "PSMODELMEMO", iDataEntityModel.getDataInfo(pSModelMemo), arrayList.get(0)));
        }
    }

    public void resetPPSModelMemo(PSModelMemo pSModelMemo) throws Exception {
        ArrayList<PSModelMemo> arrayList = this.selectByPPSModelMemo(pSModelMemo);
        for (PSModelMemo pSModelMemo2 : arrayList) {
            PSModelMemo pSModelMemo3 = (PSModelMemo)this.getDEModel().createEntity();
            pSModelMemo3.setPSModelMemoId(pSModelMemo2.getPSModelMemoId());
            pSModelMemo3.setPPSModelMemoId(null);
            this.update(pSModelMemo3);
        }
    }

    public void removeByPPSModelMemo(PSModelMemo pSModelMemo) throws Exception {
        final PSModelMemo pSModelMemo2 = pSModelMemo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelMemoServiceBase.this.onBeforeRemoveByPPSModelMemo(pSModelMemo2);
                PSModelMemoServiceBase.this.internalRemoveByPPSModelMemo(pSModelMemo2);
                PSModelMemoServiceBase.this.onAfterRemoveByPPSModelMemo(pSModelMemo2);
            }
        });
    }

    protected void onBeforeRemoveByPPSModelMemo(PSModelMemo pSModelMemo) throws Exception {
    }

    protected void internalRemoveByPPSModelMemo(PSModelMemo pSModelMemo) throws Exception {
        ArrayList<PSModelMemo> arrayList = this.selectByPPSModelMemo(pSModelMemo);
        this.onBeforeRemoveByPPSModelMemo(pSModelMemo, arrayList);
        for (PSModelMemo pSModelMemo2 : arrayList) {
            this.remove(pSModelMemo2);
        }
        this.onAfterRemoveByPPSModelMemo(pSModelMemo, arrayList);
    }

    protected void onAfterRemoveByPPSModelMemo(PSModelMemo pSModelMemo) throws Exception {
    }

    protected void onBeforeRemoveByPPSModelMemo(PSModelMemo pSModelMemo, ArrayList<PSModelMemo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSModelMemo(PSModelMemo pSModelMemo, ArrayList<PSModelMemo> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSModelMemo> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELMEMO_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSMODELMEMO", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSModelMemo> arrayList = this.selectByPSSystem(pSSystem);
        for (PSModelMemo pSModelMemo : arrayList) {
            PSModelMemo pSModelMemo2 = (PSModelMemo)this.getDEModel().createEntity();
            pSModelMemo2.setPSModelMemoId(pSModelMemo.getPSModelMemoId());
            pSModelMemo2.setPSSystemId(null);
            this.update(pSModelMemo2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelMemoServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSModelMemoServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSModelMemoServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSModelMemo> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSModelMemo pSModelMemo : arrayList) {
            this.remove(pSModelMemo);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSModelMemo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSModelMemo> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelMemo pSModelMemo) throws Exception {
        PSModelMemoService pSModelMemoService = (PSModelMemoService)ServiceGlobal.getService(PSModelMemoService.class, (SessionFactory)this.getSessionFactory());
        pSModelMemoService.testRemoveByPPSModelMemo(pSModelMemo);
        super.onBeforeRemove(pSModelMemo);
    }

    protected void replaceParentInfo(PSModelMemo pSModelMemo, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelMemo, cloneSession);
        if (pSModelMemo.getPPSModelMemoId() != null && (iEntity = cloneSession.getEntity("PSMODELMEMO", (Object)pSModelMemo.getPPSModelMemoId())) != null) {
            this.onFillParentInfo_PPSModelMemo(pSModelMemo, (PSModelMemo)iEntity);
        }
        if (pSModelMemo.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSModelMemo.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSModelMemo, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelMemo pSModelMemo, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelMemo, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSModelMemo, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSModelMemoId(bl, pSModelMemo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSModelMemo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSModelMemo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelMemoId(bl, pSModelMemo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelMemoName(bl, pSModelMemo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjId(bl, pSModelMemo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjName(bl, pSModelMemo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjType(bl, pSModelMemo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjTypeName(bl, pSModelMemo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSModelMemo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSModelMemo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelMemo, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isMemoDirty() : !pSModelMemo.isMemoDirty()) {
            return null;
        }
        String string = pSModelMemo.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelMemo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSModelMemoId(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isPPSModelMemoIdDirty() : !pSModelMemo.isPPSModelMemoIdDirty()) {
            return null;
        }
        String string = pSModelMemo.getPPSModelMemoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSModelMemoId_Default(pSModelMemo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSMODELMEMOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isPSDEFIdDirty() : !pSModelMemo.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSModelMemo.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSModelMemo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isPSDEFNameDirty() : !pSModelMemo.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSModelMemo.getPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSModelMemo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelMemoId(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isPSModelMemoIdDirty() && !bl2 : !pSModelMemo.isPSModelMemoIdDirty()) {
            return null;
        }
        String string = pSModelMemo.getPSModelMemoId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELMEMOID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelMemoId_Default(pSModelMemo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELMEMOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelMemoName(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isPSModelMemoNameDirty() && !bl2 : !pSModelMemo.isPSModelMemoNameDirty()) {
            return null;
        }
        String string = pSModelMemo.getPSModelMemoName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELMEMONAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelMemoName_Default(pSModelMemo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELMEMONAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjId(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isPSObjIdDirty() : !pSModelMemo.isPSObjIdDirty()) {
            return null;
        }
        String string = pSModelMemo.getPSObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjId_Default(pSModelMemo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjName(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isPSObjNameDirty() : !pSModelMemo.isPSObjNameDirty()) {
            return null;
        }
        String string = pSModelMemo.getPSObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjName_Default(pSModelMemo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjType(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isPSObjTypeDirty() : !pSModelMemo.isPSObjTypeDirty()) {
            return null;
        }
        String string = pSModelMemo.getPSObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjType_Default(pSModelMemo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjTypeName(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isPSObjTypeNameDirty() : !pSModelMemo.isPSObjTypeNameDirty()) {
            return null;
        }
        String string = pSModelMemo.getPSObjTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjTypeName_Default(pSModelMemo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isPSSystemIdDirty() : !pSModelMemo.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSModelMemo.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSModelMemo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSModelMemo pSModelMemo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelMemo.isPSSystemNameDirty() : !pSModelMemo.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSModelMemo.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSModelMemo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelMemo pSModelMemo, boolean bl) throws Exception {
        super.onSyncEntity(pSModelMemo, bl);
    }

    protected void onSyncIndexEntities(PSModelMemo pSModelMemo, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelMemo, bl);
    }

    public Object getDataContextValue(PSModelMemo pSModelMemo, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelMemo, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelMemo pSModelMemo, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelMemo, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMODELMEMOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSModelMemoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELMEMOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelMemoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELMEMONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelMemoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
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

    protected String onTestValueRule_PPSModelMemoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMODELMEMOID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelMemoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELMEMOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelMemoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELMEMONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSModelMemo pSModelMemo) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelMemo)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelMemo pSModelMemo) throws Exception {
        super.onUpdateParent(pSModelMemo);
    }

    @Override
    protected void exportCurXmlModel(PSModelMemo pSModelMemo, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELMEMO");
        if (!bl) {
            pSModelMemo.setCreateDate(null);
            pSModelMemo.setCreateMan(null);
            pSModelMemo.setPSModelMemoId(null);
            pSModelMemo.setUpdateDate(null);
            pSModelMemo.setUpdateMan(null);
            super.exportCurXmlModel(pSModelMemo, xmlNode, bl);
        }
    }
}

