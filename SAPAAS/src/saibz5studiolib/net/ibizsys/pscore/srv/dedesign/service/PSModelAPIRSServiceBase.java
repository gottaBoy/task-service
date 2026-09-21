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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.config.entity.PSModelAPIMethod;
import net.ibizsys.pscore.srv.config.entity.PSModelAPIMethodBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSModelAPIRSDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSModelAPIRSDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSModelAPIRS;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelAPIRSServiceBase
extends PSCoreSysServiceBase<PSModelAPIRS> {
    private static final Log log = LogFactory.getLog(PSModelAPIRSServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelAPIRSDEModel pSModelAPIRSDEModel;
    private PSModelAPIRSDAO pSModelAPIRSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSModelAPIRSService";
    }

    public PSModelAPIRSDEModel getPSModelAPIRSDEModel() {
        if (this.pSModelAPIRSDEModel == null) {
            try {
                this.pSModelAPIRSDEModel = (PSModelAPIRSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSModelAPIRSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelAPIRSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelAPIRSDEModel();
    }

    public PSModelAPIRSDAO getPSModelAPIRSDAO() {
        if (this.pSModelAPIRSDAO == null) {
            try {
                this.pSModelAPIRSDAO = (PSModelAPIRSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSModelAPIRSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelAPIRSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelAPIRSDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSModelAPIRS pSModelAPIRS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELAPIRS_PSDEFFORMITEM_PSDEFFORMITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService", (SessionFactory)this.getSessionFactory());
            PSDEFUIMode pSDEFUIMode = (PSDEFUIMode)iService.getDEModel().createEntity();
            pSDEFUIMode.set("PSDEFFORMITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFUIMode);
            } else {
                iService.get((IEntity)pSDEFUIMode);
            }
            this.onFillParentInfo_PSDEFUIMode(pSModelAPIRS, pSDEFUIMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELAPIRS_PSMODELAPIMETHOD_PSMODELAPIMETHODID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelAPIMethodService", (SessionFactory)this.getSessionFactory());
            PSModelAPIMethod pSModelAPIMethod = (PSModelAPIMethod)iService.getDEModel().createEntity();
            pSModelAPIMethod.set("PSMODELAPIMETHODID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModelAPIMethod);
            } else {
                iService.get((IEntity)pSModelAPIMethod);
            }
            this.onFillParentInfo_PSModelAPIMethod(pSModelAPIRS, pSModelAPIMethod);
            return;
        }
        super.onFillParentInfo((IEntity)pSModelAPIRS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEFUIMode(PSModelAPIRS pSModelAPIRS, PSDEFUIMode pSDEFUIMode) throws Exception {
        pSModelAPIRS.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
        pSModelAPIRS.setPSDEFUIModeName(pSDEFUIMode.getPSDEFUIModeName());
    }

    protected void onFillParentInfo_PSModelAPIMethod(PSModelAPIRS pSModelAPIRS, PSModelAPIMethod pSModelAPIMethod) throws Exception {
        pSModelAPIRS.setPSModelAPIIntName(pSModelAPIMethod.getPSModelAPIIntName());
        pSModelAPIRS.setPSModelAPIMethodId(pSModelAPIMethod.getPSModelAPIMethodId());
        pSModelAPIRS.setPSModelAPIMethodName(pSModelAPIMethod.getPSModelAPIMethodName());
        pSModelAPIRS.setPSModelAPIName(pSModelAPIMethod.getPSModelAPIName());
    }

    protected void onFillEntityFullInfo(PSModelAPIRS pSModelAPIRS, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSModelAPIRS, bl);
        this.onFillEntityFullInfo_PSDEFUIMode(pSModelAPIRS, bl);
        this.onFillEntityFullInfo_PSModelAPIMethod(pSModelAPIRS, bl);
    }

    protected void onFillEntityFullInfo_PSDEFUIMode(PSModelAPIRS pSModelAPIRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModelAPIMethod(PSModelAPIRS pSModelAPIRS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSModelAPIRS pSModelAPIRS, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSModelAPIRS, bl);
    }

    public ArrayList<PSModelAPIRS> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase) throws Exception {
        return this.selectByPSDEFUIMode(pSDEFUIModeBase, "", -1);
    }

    public ArrayList<PSModelAPIRS> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase, String string) throws Exception {
        return this.selectByPSDEFUIMode(pSDEFUIModeBase, string, -1);
    }

    public ArrayList<PSModelAPIRS> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFFORMITEMID", (Object)pSDEFUIModeBase.getPSDEFUIModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFUIModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFUIModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelAPIRS> selectByPSModelAPIMethod(PSModelAPIMethodBase pSModelAPIMethodBase) throws Exception {
        return this.selectByPSModelAPIMethod(pSModelAPIMethodBase, "", -1);
    }

    public ArrayList<PSModelAPIRS> selectByPSModelAPIMethod(PSModelAPIMethodBase pSModelAPIMethodBase, String string) throws Exception {
        return this.selectByPSModelAPIMethod(pSModelAPIMethodBase, string, -1);
    }

    public ArrayList<PSModelAPIRS> selectByPSModelAPIMethod(PSModelAPIMethodBase pSModelAPIMethodBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELAPIMETHODID", (Object)pSModelAPIMethodBase.getPSModelAPIMethodId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelAPIMethodCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelAPIMethodCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
    }

    public void resetPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSModelAPIRS> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode);
        for (PSModelAPIRS pSModelAPIRS : arrayList) {
            PSModelAPIRS pSModelAPIRS2 = (PSModelAPIRS)this.getDEModel().createEntity();
            pSModelAPIRS2.setPSModelAPIRSId(pSModelAPIRS.getPSModelAPIRSId());
            pSModelAPIRS2.setPSDEFUIModeId(null);
            this.update(pSModelAPIRS2);
        }
    }

    public void removeByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        final PSDEFUIMode pSDEFUIMode2 = pSDEFUIMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelAPIRSServiceBase.this.onBeforeRemoveByPSDEFUIMode(pSDEFUIMode2);
                PSModelAPIRSServiceBase.this.internalRemoveByPSDEFUIMode(pSDEFUIMode2);
                PSModelAPIRSServiceBase.this.onAfterRemoveByPSDEFUIMode(pSDEFUIMode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
    }

    protected void internalRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSModelAPIRS> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode);
        this.onBeforeRemoveByPSDEFUIMode(pSDEFUIMode, arrayList);
        for (PSModelAPIRS pSModelAPIRS : arrayList) {
            this.remove((IEntity)pSModelAPIRS);
        }
        this.onAfterRemoveByPSDEFUIMode(pSDEFUIMode, arrayList);
    }

    protected void onAfterRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode, ArrayList<PSModelAPIRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode, ArrayList<PSModelAPIRS> arrayList) throws Exception {
    }

    public void testRemoveByPSModelAPIMethod(PSModelAPIMethod pSModelAPIMethod) throws Exception {
        ArrayList<PSModelAPIRS> arrayList = this.selectByPSModelAPIMethod(pSModelAPIMethod, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELAPIMETHOD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModelAPIMethod);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELAPIRS_PSMODELAPIMETHOD_PSMODELAPIMETHODID", "", iDataEntityModel.getName(), "PSMODELAPIRS", iDataEntityModel.getDataInfo((IEntity)pSModelAPIMethod), arrayList.get(0)));
        }
    }

    public void resetPSModelAPIMethod(PSModelAPIMethod pSModelAPIMethod) throws Exception {
        ArrayList<PSModelAPIRS> arrayList = this.selectByPSModelAPIMethod(pSModelAPIMethod);
        for (PSModelAPIRS pSModelAPIRS : arrayList) {
            PSModelAPIRS pSModelAPIRS2 = (PSModelAPIRS)this.getDEModel().createEntity();
            pSModelAPIRS2.setPSModelAPIRSId(pSModelAPIRS.getPSModelAPIRSId());
            pSModelAPIRS2.setPSModelAPIMethodId(null);
            this.update(pSModelAPIRS2);
        }
    }

    public void removeByPSModelAPIMethod(PSModelAPIMethod pSModelAPIMethod) throws Exception {
        final PSModelAPIMethod pSModelAPIMethod2 = pSModelAPIMethod;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelAPIRSServiceBase.this.onBeforeRemoveByPSModelAPIMethod(pSModelAPIMethod2);
                PSModelAPIRSServiceBase.this.internalRemoveByPSModelAPIMethod(pSModelAPIMethod2);
                PSModelAPIRSServiceBase.this.onAfterRemoveByPSModelAPIMethod(pSModelAPIMethod2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelAPIMethod(PSModelAPIMethod pSModelAPIMethod) throws Exception {
    }

    protected void internalRemoveByPSModelAPIMethod(PSModelAPIMethod pSModelAPIMethod) throws Exception {
        ArrayList<PSModelAPIRS> arrayList = this.selectByPSModelAPIMethod(pSModelAPIMethod);
        this.onBeforeRemoveByPSModelAPIMethod(pSModelAPIMethod, arrayList);
        for (PSModelAPIRS pSModelAPIRS : arrayList) {
            this.remove((IEntity)pSModelAPIRS);
        }
        this.onAfterRemoveByPSModelAPIMethod(pSModelAPIMethod, arrayList);
    }

    protected void onAfterRemoveByPSModelAPIMethod(PSModelAPIMethod pSModelAPIMethod) throws Exception {
    }

    protected void onBeforeRemoveByPSModelAPIMethod(PSModelAPIMethod pSModelAPIMethod, ArrayList<PSModelAPIRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelAPIMethod(PSModelAPIMethod pSModelAPIMethod, ArrayList<PSModelAPIRS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelAPIRS pSModelAPIRS) throws Exception {
        super.onBeforeRemove(pSModelAPIRS);
    }

    protected void replaceParentInfo(PSModelAPIRS pSModelAPIRS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSModelAPIRS, cloneSession);
        if (pSModelAPIRS.getPSDEFUIModeId() != null && (iEntity = cloneSession.getEntity("PSDEFFORMITEM", (Object)pSModelAPIRS.getPSDEFUIModeId())) != null) {
            this.onFillParentInfo_PSDEFUIMode(pSModelAPIRS, (PSDEFUIMode)iEntity);
        }
        if (pSModelAPIRS.getPSModelAPIMethodId() != null && (iEntity = cloneSession.getEntity("PSMODELAPIMETHOD", (Object)pSModelAPIRS.getPSModelAPIMethodId())) != null) {
            this.onFillParentInfo_PSModelAPIMethod(pSModelAPIRS, (PSModelAPIMethod)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelAPIRS pSModelAPIRS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSModelAPIRS, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelAPIRS pSModelAPIRS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSModelAPIRS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFUIModeId(bl, pSModelAPIRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelAPIMethodId(bl, pSModelAPIRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelAPIRSId(bl, pSModelAPIRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelAPIRSName(bl, pSModelAPIRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSModelAPIRS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelAPIRS pSModelAPIRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIRS.isMemoDirty() : !pSModelAPIRS.isMemoDirty()) {
            return null;
        }
        String string = pSModelAPIRS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSModelAPIRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFUIModeId(boolean bl, PSModelAPIRS pSModelAPIRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIRS.isPSDEFUIModeIdDirty() : !pSModelAPIRS.isPSDEFUIModeIdDirty()) {
            return null;
        }
        String string = pSModelAPIRS.getPSDEFUIModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFUIModeId_Default((IEntity)pSModelAPIRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFFORMITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelAPIMethodId(boolean bl, PSModelAPIRS pSModelAPIRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIRS.isPSModelAPIMethodIdDirty() : !pSModelAPIRS.isPSModelAPIMethodIdDirty()) {
            return null;
        }
        String string = pSModelAPIRS.getPSModelAPIMethodId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelAPIMethodId_Default((IEntity)pSModelAPIRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIMETHODID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelAPIRSId(boolean bl, PSModelAPIRS pSModelAPIRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIRS.isPSModelAPIRSIdDirty() && !bl2 : !pSModelAPIRS.isPSModelAPIRSIdDirty()) {
            return null;
        }
        String string = pSModelAPIRS.getPSModelAPIRSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIRSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelAPIRSId_Default((IEntity)pSModelAPIRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIRSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelAPIRSName(boolean bl, PSModelAPIRS pSModelAPIRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIRS.isPSModelAPIRSNameDirty() && !bl2 : !pSModelAPIRS.isPSModelAPIRSNameDirty()) {
            return null;
        }
        String string = pSModelAPIRS.getPSModelAPIRSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIRSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelAPIRSName_Default((IEntity)pSModelAPIRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIRSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelAPIRS pSModelAPIRS, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSModelAPIRS, bl);
    }

    protected void onSyncIndexEntities(PSModelAPIRS pSModelAPIRS, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSModelAPIRS, bl);
    }

    public Object getDataContextValue(PSModelAPIRS pSModelAPIRS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSModelAPIRS, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelAPIRS pSModelAPIRS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSModelAPIRS, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEFFORMITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFFORMITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIINTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIIntName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIMETHODID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIMethodId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIMETHODNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIMethodName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIRSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIRSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIRSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIRSName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEFUIModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFFORMITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFUIModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFFORMITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIIntName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIINTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIMethodId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIMETHODID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIMethodName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIMETHODNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIRSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIRSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIRSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIRSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSModelAPIRS pSModelAPIRS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSModelAPIRS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelAPIRS pSModelAPIRS) throws Exception {
        super.onUpdateParent((IEntity)pSModelAPIRS);
    }

    @Override
    protected void exportCurXmlModel(PSModelAPIRS pSModelAPIRS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELAPIRS");
        if (!bl) {
            pSModelAPIRS.setCreateDate(null);
            pSModelAPIRS.setCreateMan(null);
            pSModelAPIRS.setPSDEFUIModeName(null);
            pSModelAPIRS.setPSModelAPIMethodName(null);
            pSModelAPIRS.setPSModelAPIRSId(null);
            pSModelAPIRS.setUpdateDate(null);
            pSModelAPIRS.setUpdateMan(null);
            super.exportCurXmlModel(pSModelAPIRS, xmlNode, bl);
        }
    }
}

