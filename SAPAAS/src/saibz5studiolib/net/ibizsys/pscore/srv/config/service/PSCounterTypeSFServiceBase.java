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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSCounterTypeSFDAO;
import net.ibizsys.pscore.srv.config.demodel.PSCounterTypeSFDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCounterType;
import net.ibizsys.pscore.srv.config.entity.PSCounterTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSCounterTypeSF;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCounterTypeSFServiceBase
extends PSCoreSysServiceBase<PSCounterTypeSF> {
    private static final Log log = LogFactory.getLog(PSCounterTypeSFServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCounterTypeSFDEModel pSCounterTypeSFDEModel;
    private PSCounterTypeSFDAO pSCounterTypeSFDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSCounterTypeSFService";
    }

    public PSCounterTypeSFDEModel getPSCounterTypeSFDEModel() {
        if (this.pSCounterTypeSFDEModel == null) {
            try {
                this.pSCounterTypeSFDEModel = (PSCounterTypeSFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSCounterTypeSFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCounterTypeSFDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCounterTypeSFDEModel();
    }

    public PSCounterTypeSFDAO getPSCounterTypeSFDAO() {
        if (this.pSCounterTypeSFDAO == null) {
            try {
                this.pSCounterTypeSFDAO = (PSCounterTypeSFDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSCounterTypeSFDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCounterTypeSFDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCounterTypeSFDAO();
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

    protected void onFillParentInfo(PSCounterTypeSF pSCounterTypeSF, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOUNTERTYPESF_PSCOUNTERTYPE_PSCOUNTERTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCounterTypeService", (SessionFactory)this.getSessionFactory());
            PSCounterType pSCounterType = (PSCounterType)iService.getDEModel().createEntity();
            pSCounterType.set("PSCOUNTERTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCounterType);
            } else {
                iService.get(pSCounterType);
            }
            this.onFillParentInfo_PSCounterType(pSCounterTypeSF, pSCounterType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOUNTERTYPESF_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_PSSF(pSCounterTypeSF, pSSF);
            return;
        }
        super.onFillParentInfo(pSCounterTypeSF, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCounterType(PSCounterTypeSF pSCounterTypeSF, PSCounterType pSCounterType) throws Exception {
        pSCounterTypeSF.setPSCounterTypeId(pSCounterType.getPSCounterTypeId());
        pSCounterTypeSF.setPSCounterTypeName(pSCounterType.getPSCounterTypeName());
    }

    protected void onFillParentInfo_PSSF(PSCounterTypeSF pSCounterTypeSF, PSSF pSSF) throws Exception {
        pSCounterTypeSF.setPSSFId(pSSF.getPSSFId());
        pSCounterTypeSF.setPSSFName(pSSF.getPSSFName());
    }

    protected boolean onFillEntityKeyValue(PSCounterTypeSF pSCounterTypeSF, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSCounterTypeSF.get("PSCOUNTERTYPEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSCounterTypeSF.get("PSSFID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSCounterTypeSF.set(this.getPSCounterTypeSFDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSCounterTypeSF pSCounterTypeSF, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSCounterTypeSF, bl);
        this.onFillEntityFullInfo_PSCounterType(pSCounterTypeSF, bl);
        this.onFillEntityFullInfo_PSSF(pSCounterTypeSF, bl);
    }

    protected void onFillEntityFullInfo_PSCounterType(PSCounterTypeSF pSCounterTypeSF, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSF(PSCounterTypeSF pSCounterTypeSF, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSCounterTypeSF pSCounterTypeSF, boolean bl) throws Exception {
        super.onWriteBackParent(pSCounterTypeSF, bl);
    }

    public ArrayList<PSCounterTypeSF> selectByPSCounterType(PSCounterTypeBase pSCounterTypeBase) throws Exception {
        return this.selectByPSCounterType(pSCounterTypeBase, "", -1);
    }

    public ArrayList<PSCounterTypeSF> selectByPSCounterType(PSCounterTypeBase pSCounterTypeBase, String string) throws Exception {
        return this.selectByPSCounterType(pSCounterTypeBase, string, -1);
    }

    public ArrayList<PSCounterTypeSF> selectByPSCounterType(PSCounterTypeBase pSCounterTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOUNTERTYPEID", (Object)pSCounterTypeBase.getPSCounterTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCounterTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCounterTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCounterTypeSF> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSCounterTypeSF> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSCounterTypeSF> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCounterType(PSCounterType pSCounterType) throws Exception {
    }

    public void resetPSCounterType(PSCounterType pSCounterType) throws Exception {
        ArrayList<PSCounterTypeSF> arrayList = this.selectByPSCounterType(pSCounterType);
        for (PSCounterTypeSF pSCounterTypeSF : arrayList) {
            PSCounterTypeSF pSCounterTypeSF2 = (PSCounterTypeSF)this.getDEModel().createEntity();
            pSCounterTypeSF2.setPSCounterTypeSFId(pSCounterTypeSF.getPSCounterTypeSFId());
            pSCounterTypeSF2.setPSCounterTypeId(null);
            this.update(pSCounterTypeSF2);
        }
    }

    public void removeByPSCounterType(PSCounterType pSCounterType) throws Exception {
        final PSCounterType pSCounterType2 = pSCounterType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCounterTypeSFServiceBase.this.onBeforeRemoveByPSCounterType(pSCounterType2);
                PSCounterTypeSFServiceBase.this.internalRemoveByPSCounterType(pSCounterType2);
                PSCounterTypeSFServiceBase.this.onAfterRemoveByPSCounterType(pSCounterType2);
            }
        });
    }

    protected void onBeforeRemoveByPSCounterType(PSCounterType pSCounterType) throws Exception {
    }

    protected void internalRemoveByPSCounterType(PSCounterType pSCounterType) throws Exception {
        ArrayList<PSCounterTypeSF> arrayList = this.selectByPSCounterType(pSCounterType);
        this.onBeforeRemoveByPSCounterType(pSCounterType, arrayList);
        for (PSCounterTypeSF pSCounterTypeSF : arrayList) {
            this.remove(pSCounterTypeSF);
        }
        this.onAfterRemoveByPSCounterType(pSCounterType, arrayList);
    }

    protected void onAfterRemoveByPSCounterType(PSCounterType pSCounterType) throws Exception {
    }

    protected void onBeforeRemoveByPSCounterType(PSCounterType pSCounterType, ArrayList<PSCounterTypeSF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCounterType(PSCounterType pSCounterType, ArrayList<PSCounterTypeSF> arrayList) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSCounterTypeSF> arrayList = this.selectByPSSF(pSSF);
        for (PSCounterTypeSF pSCounterTypeSF : arrayList) {
            PSCounterTypeSF pSCounterTypeSF2 = (PSCounterTypeSF)this.getDEModel().createEntity();
            pSCounterTypeSF2.setPSCounterTypeSFId(pSCounterTypeSF.getPSCounterTypeSFId());
            pSCounterTypeSF2.setPSSFId(null);
            this.update(pSCounterTypeSF2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCounterTypeSFServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSCounterTypeSFServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSCounterTypeSFServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSCounterTypeSF> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSCounterTypeSF pSCounterTypeSF : arrayList) {
            this.remove(pSCounterTypeSF);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSCounterTypeSF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSCounterTypeSF> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCounterTypeSF pSCounterTypeSF) throws Exception {
        super.onBeforeRemove(pSCounterTypeSF);
    }

    protected void replaceParentInfo(PSCounterTypeSF pSCounterTypeSF, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCounterTypeSF, cloneSession);
        if (pSCounterTypeSF.getPSCounterTypeId() != null && (iEntity = cloneSession.getEntity("PSCOUNTERTYPE", (Object)pSCounterTypeSF.getPSCounterTypeId())) != null) {
            this.onFillParentInfo_PSCounterType(pSCounterTypeSF, (PSCounterType)iEntity);
        }
        if (pSCounterTypeSF.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSCounterTypeSF.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSCounterTypeSF, (PSSF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCounterTypeSF pSCounterTypeSF, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCounterTypeSF, bl);
    }

    protected void onCheckEntity(boolean bl, PSCounterTypeSF pSCounterTypeSF, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BaseObj(bl, pSCounterTypeSF, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCounterTypeSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCounterTypeId(bl, pSCounterTypeSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCounterTypeSFId(bl, pSCounterTypeSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCounterTypeSFName(bl, pSCounterTypeSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSCounterTypeSF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCounterTypeSF, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BaseObj(boolean bl, PSCounterTypeSF pSCounterTypeSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCounterTypeSF.isBaseObjDirty() && !bl2 : !pSCounterTypeSF.isBaseObjDirty()) {
            return null;
        }
        String string = pSCounterTypeSF.getBaseObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BASEOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BaseObj_Default(pSCounterTypeSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BASEOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCounterTypeSF pSCounterTypeSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCounterTypeSF.isMemoDirty() : !pSCounterTypeSF.isMemoDirty()) {
            return null;
        }
        String string = pSCounterTypeSF.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCounterTypeSF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCounterTypeId(boolean bl, PSCounterTypeSF pSCounterTypeSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCounterTypeSF.isPSCounterTypeIdDirty() && !bl2 : !pSCounterTypeSF.isPSCounterTypeIdDirty()) {
            return null;
        }
        String string = pSCounterTypeSF.getPSCounterTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOUNTERTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCounterTypeId_Default(pSCounterTypeSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOUNTERTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCounterTypeSFId(boolean bl, PSCounterTypeSF pSCounterTypeSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCounterTypeSF.isPSCounterTypeSFIdDirty() && !bl2 : !pSCounterTypeSF.isPSCounterTypeSFIdDirty()) {
            return null;
        }
        String string = pSCounterTypeSF.getPSCounterTypeSFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOUNTERTYPESFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCounterTypeSFId_Default(pSCounterTypeSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOUNTERTYPESFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCounterTypeSFName(boolean bl, PSCounterTypeSF pSCounterTypeSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCounterTypeSF.isPSCounterTypeSFNameDirty() && !bl2 : !pSCounterTypeSF.isPSCounterTypeSFNameDirty()) {
            return null;
        }
        String string = pSCounterTypeSF.getPSCounterTypeSFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOUNTERTYPESFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCounterTypeSFName_Default(pSCounterTypeSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOUNTERTYPESFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSCounterTypeSF pSCounterTypeSF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCounterTypeSF.isPSSFIdDirty() && !bl2 : !pSCounterTypeSF.isPSSFIdDirty()) {
            return null;
        }
        String string = pSCounterTypeSF.getPSSFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSCounterTypeSF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCounterTypeSF pSCounterTypeSF, boolean bl) throws Exception {
        super.onSyncEntity(pSCounterTypeSF, bl);
    }

    protected void onSyncIndexEntities(PSCounterTypeSF pSCounterTypeSF, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCounterTypeSF, bl);
    }

    public Object getDataContextValue(PSCounterTypeSF pSCounterTypeSF, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCounterTypeSF, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSCounterTypeSF pSCounterTypeSF, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCounterTypeSF, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BASEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BaseObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOUNTERTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCounterTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOUNTERTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCounterTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOUNTERTYPESFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCounterTypeSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOUNTERTYPESFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCounterTypeSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BaseObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BASEOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_PSCounterTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOUNTERTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCounterTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOUNTERTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCounterTypeSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOUNTERTYPESFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCounterTypeSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOUNTERTYPESFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSCounterTypeSF pSCounterTypeSF) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCounterTypeSF)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCounterTypeSF pSCounterTypeSF) throws Exception {
        super.onUpdateParent(pSCounterTypeSF);
    }

    @Override
    protected void exportCurXmlModel(PSCounterTypeSF pSCounterTypeSF, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCOUNTERTYPESF");
        if (!bl) {
            super.exportCurXmlModel(pSCounterTypeSF, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSCounterTypeSF pSCounterTypeSF, PSSystem pSSystem) throws Exception {
        PSCounterTypeSF pSCounterTypeSF2 = new PSCounterTypeSF();
        pSCounterTypeSF2.setPSCounterTypeId(pSCounterTypeSF.getPSCounterTypeId());
        pSCounterTypeSF2.setPSSFId(pSCounterTypeSF.getPSSFId());
        if (this.selectOne(pSCounterTypeSF2, true)) {
            return pSCounterTypeSF2.getPSCounterTypeSFId();
        }
        return super.getEntityFolderKeyValue(pSCounterTypeSF, pSSystem);
    }
}

