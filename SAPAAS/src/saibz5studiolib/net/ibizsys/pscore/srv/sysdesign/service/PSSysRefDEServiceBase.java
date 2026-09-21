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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysRefDEDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysRefDEDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRefBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRefDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysRefDEServiceBase
extends PSCoreSysServiceBase<PSSysRefDE> {
    private static final Log log = LogFactory.getLog(PSSysRefDEServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysRefDEDEModel pSSysRefDEDEModel;
    private PSSysRefDEDAO pSSysRefDEDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysRefDEService";
    }

    public PSSysRefDEDEModel getPSSysRefDEDEModel() {
        if (this.pSSysRefDEDEModel == null) {
            try {
                this.pSSysRefDEDEModel = (PSSysRefDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysRefDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysRefDEDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysRefDEDEModel();
    }

    public PSSysRefDEDAO getPSSysRefDEDAO() {
        if (this.pSSysRefDEDAO == null) {
            try {
                this.pSSysRefDEDAO = (PSSysRefDEDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysRefDEDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysRefDEDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysRefDEDAO();
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

    protected void onFillParentInfo(PSSysRefDE pSSysRefDE, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREFDE_PSSYSREF_PSSYSREFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService", (SessionFactory)this.getSessionFactory());
            PSSysRef pSSysRef = (PSSysRef)iService.getDEModel().createEntity();
            pSSysRef.set("PSSYSREFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysRef);
            } else {
                iService.get((IEntity)pSSysRef);
            }
            this.onFillParentInfo_PSSysRef(pSSysRefDE, pSSysRef);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysRefDE, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysRef(PSSysRefDE pSSysRefDE, PSSysRef pSSysRef) throws Exception {
        pSSysRefDE.setPSSysRefId(pSSysRef.getPSSysRefId());
        pSSysRefDE.setPSSysRefName(pSSysRef.getPSSysRefName());
    }

    protected boolean onFillEntityKeyValue(PSSysRefDE pSSysRefDE, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysRefDE.get("PSSYSREFID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysRefDE.get("ORIPSDEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSysRefDE.set(this.getPSSysRefDEDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysRefDE pSSysRefDE, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysRefDE, bl);
        this.onFillEntityFullInfo_PSSysRef(pSSysRefDE, bl);
    }

    protected void onFillEntityFullInfo_PSSysRef(PSSysRefDE pSSysRefDE, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysRefDE pSSysRefDE, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysRefDE, bl);
    }

    public ArrayList<PSSysRefDE> selectByPSSysRef(PSSysRefBase pSSysRefBase) throws Exception {
        return this.selectByPSSysRef(pSSysRefBase, "", -1);
    }

    public ArrayList<PSSysRefDE> selectByPSSysRef(PSSysRefBase pSSysRefBase, String string) throws Exception {
        return this.selectByPSSysRef(pSSysRefBase, string, -1);
    }

    public ArrayList<PSSysRefDE> selectByPSSysRef(PSSysRefBase pSSysRefBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSREFID", (Object)pSSysRefBase.getPSSysRefId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysRefCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysRefCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysRef(PSSysRef pSSysRef) throws Exception {
    }

    public void resetPSSysRef(PSSysRef pSSysRef) throws Exception {
        ArrayList<PSSysRefDE> arrayList = this.selectByPSSysRef(pSSysRef);
        for (PSSysRefDE pSSysRefDE : arrayList) {
            PSSysRefDE pSSysRefDE2 = (PSSysRefDE)this.getDEModel().createEntity();
            pSSysRefDE2.setPSSysRefDEId(pSSysRefDE.getPSSysRefDEId());
            pSSysRefDE2.setPSSysRefId(null);
            this.update(pSSysRefDE2);
        }
    }

    public void removeByPSSysRef(PSSysRef pSSysRef) throws Exception {
        final PSSysRef pSSysRef2 = pSSysRef;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRefDEServiceBase.this.onBeforeRemoveByPSSysRef(pSSysRef2);
                PSSysRefDEServiceBase.this.internalRemoveByPSSysRef(pSSysRef2);
                PSSysRefDEServiceBase.this.onAfterRemoveByPSSysRef(pSSysRef2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysRef(PSSysRef pSSysRef) throws Exception {
    }

    protected void internalRemoveByPSSysRef(PSSysRef pSSysRef) throws Exception {
        ArrayList<PSSysRefDE> arrayList = this.selectByPSSysRef(pSSysRef);
        this.onBeforeRemoveByPSSysRef(pSSysRef, arrayList);
        for (PSSysRefDE pSSysRefDE : arrayList) {
            this.remove((IEntity)pSSysRefDE);
        }
        this.onAfterRemoveByPSSysRef(pSSysRef, arrayList);
    }

    protected void onAfterRemoveByPSSysRef(PSSysRef pSSysRef) throws Exception {
    }

    protected void onBeforeRemoveByPSSysRef(PSSysRef pSSysRef, ArrayList<PSSysRefDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysRef(PSSysRef pSSysRef, ArrayList<PSSysRefDE> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysRefDE pSSysRefDE) throws Exception {
        PSDEMapService pSDEMapService = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        pSDEMapService.testRemoveByDstPSSysRefDE(pSSysRefDE);
        super.onBeforeRemove(pSSysRefDE);
    }

    protected void replaceParentInfo(PSSysRefDE pSSysRefDE, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysRefDE, cloneSession);
        if (pSSysRefDE.getPSSysRefId() != null && (iEntity = cloneSession.getEntity("PSSYSREF", (Object)pSSysRefDE.getPSSysRefId())) != null) {
            this.onFillParentInfo_PSSysRef(pSSysRefDE, (PSSysRef)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysRefDE pSSysRefDE, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysRefDE, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysRefDE pSSysRefDE, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogicName(bl, pSSysRefDE, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysRefDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OriPSDEId(bl, pSSysRefDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysRefDEId(bl, pSSysRefDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysRefDEName(bl, pSSysRefDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysRefId(bl, pSSysRefDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCls(bl, pSSysRefDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysRefDE, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysRefDE pSSysRefDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRefDE.isLogicNameDirty() : !pSSysRefDE.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysRefDE.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSSysRefDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysRefDE pSSysRefDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRefDE.isMemoDirty() : !pSSysRefDE.isMemoDirty()) {
            return null;
        }
        String string = pSSysRefDE.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysRefDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_OriPSDEId(boolean bl, PSSysRefDE pSSysRefDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRefDE.isOriPSDEIdDirty() && !bl2 : !pSSysRefDE.isOriPSDEIdDirty()) {
            return null;
        }
        String string = pSSysRefDE.getOriPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORIPSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_OriPSDEId_Default((IEntity)pSSysRefDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORIPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysRefDEId(boolean bl, PSSysRefDE pSSysRefDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRefDE.isPSSysRefDEIdDirty() && !bl2 : !pSSysRefDE.isPSSysRefDEIdDirty()) {
            return null;
        }
        String string = pSSysRefDE.getPSSysRefDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREFDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysRefDEId_Default((IEntity)pSSysRefDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREFDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysRefDEName(boolean bl, PSSysRefDE pSSysRefDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRefDE.isPSSysRefDENameDirty() && !bl2 : !pSSysRefDE.isPSSysRefDENameDirty()) {
            return null;
        }
        String string = pSSysRefDE.getPSSysRefDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREFDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysRefDEName_Default((IEntity)pSSysRefDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREFDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysRefId(boolean bl, PSSysRefDE pSSysRefDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRefDE.isPSSysRefIdDirty() : !pSSysRefDE.isPSSysRefIdDirty()) {
            return null;
        }
        String string = pSSysRefDE.getPSSysRefId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysRefId_Default((IEntity)pSSysRefDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceCls(boolean bl, PSSysRefDE pSSysRefDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRefDE.isServiceClsDirty() : !pSSysRefDE.isServiceClsDirty()) {
            return null;
        }
        String string = pSSysRefDE.getServiceCls();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCls_Default((IEntity)pSSysRefDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICECLS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysRefDE pSSysRefDE, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysRefDE, bl);
    }

    protected void onSyncIndexEntities(PSSysRefDE pSSysRefDE, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysRefDE, bl);
    }

    public Object getDataContextValue(PSSysRefDE pSSysRefDE, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysRefDE, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysRef pSSysRef = pSSysRefDE.getPSSysRef();
        if (pSSysRef != null && pSSysRef.contains(string)) {
            return pSSysRef.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysRefDE pSSysRefDE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysRefDE, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORIPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OriPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREFDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRefDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREFDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRefDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECLS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceCls_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_OriPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORIPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysRefDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREFDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysRefDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREFDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceCls_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICECLS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected boolean onMergeChild(String string, String string2, PSSysRefDE pSSysRefDE) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysRefDE)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysRefDE pSSysRefDE) throws Exception {
        super.onUpdateParent((IEntity)pSSysRefDE);
    }

    @Override
    protected void exportCurXmlModel(PSSysRefDE pSSysRefDE, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSREFDE");
        if (!bl) {
            super.exportCurXmlModel(pSSysRefDE, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysRefDE pSSysRefDE, PSSystem pSSystem) throws Exception {
        PSSysRefDE pSSysRefDE2 = new PSSysRefDE();
        pSSysRefDE2.setPSSysRefId(pSSysRefDE.getPSSysRefId());
        pSSysRefDE2.setOriPSDEId(pSSysRefDE.getOriPSDEId());
        if (this.selectOne((IEntity)pSSysRefDE2, true)) {
            return pSSysRefDE2.getPSSysRefDEId();
        }
        return super.getEntityFolderKeyValue(pSSysRefDE, pSSystem);
    }
}

