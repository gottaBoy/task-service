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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCMTDEFDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMTDEFDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDEF;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTemplBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMTDEFServiceBase
extends PSCoreSysServiceBase<PSDCMTDEF> {
    private static final Log log = LogFactory.getLog(PSDCMTDEFServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCMTDEFDEModel pSDCMTDEFDEModel;
    private PSDCMTDEFDAO pSDCMTDEFDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCMTDEFService";
    }

    public PSDCMTDEFDEModel getPSDCMTDEFDEModel() {
        if (this.pSDCMTDEFDEModel == null) {
            try {
                this.pSDCMTDEFDEModel = (PSDCMTDEFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMTDEFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMTDEFDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCMTDEFDEModel();
    }

    public PSDCMTDEFDAO getPSDCMTDEFDAO() {
        if (this.pSDCMTDEFDAO == null) {
            try {
                this.pSDCMTDEFDAO = (PSDCMTDEFDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCMTDEFDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMTDEFDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCMTDEFDAO();
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

    protected void onFillParentInfo(PSDCMTDEF pSDCMTDEF, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMTDEF_PSDCMODELTEMPL_PSDCMODELTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService", (SessionFactory)this.getSessionFactory());
            PSDCModelTempl pSDCModelTempl = (PSDCModelTempl)iService.getDEModel().createEntity();
            pSDCModelTempl.set("PSDCMODELTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCModelTempl);
            } else {
                iService.get((IEntity)pSDCModelTempl);
            }
            this.onFillParentInfo_PSDCModelTempl(pSDCMTDEF, pSDCModelTempl);
            return;
        }
        super.onFillParentInfo((IEntity)pSDCMTDEF, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCModelTempl(PSDCMTDEF pSDCMTDEF, PSDCModelTempl pSDCModelTempl) throws Exception {
        pSDCMTDEF.setPSDCModelTemplId(pSDCModelTempl.getPSDCModelTemplId());
        pSDCMTDEF.setPSDCModelTemplName(pSDCModelTempl.getPSDCModelTemplName());
    }

    protected void onFillEntityFullInfo(PSDCMTDEF pSDCMTDEF, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDCMTDEF, bl);
        this.onFillEntityFullInfo_PSDCModelTempl(pSDCMTDEF, bl);
    }

    protected void onFillEntityFullInfo_PSDCModelTempl(PSDCMTDEF pSDCMTDEF, boolean bl) throws Exception {
        if (pSDCMTDEF.isPSDCModelTemplIdDirty()) {
            if (pSDCMTDEF.getPSDCModelTemplId() != null) {
                if (pSDCMTDEF.getPSDCModelTemplId() == null || pSDCMTDEF.getPSDCModelTemplName() == null) {
                    PSDCModelTempl pSDCModelTempl = pSDCMTDEF.getPSDCModelTempl();
                    pSDCMTDEF.setPSDCModelTemplName(pSDCModelTempl.getPSDCModelTemplName());
                }
            } else {
                pSDCMTDEF.setPSDCModelTemplName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCMTDEF pSDCMTDEF, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDCMTDEF, bl);
    }

    public ArrayList<PSDCMTDEF> selectByPSDCModelTempl(PSDCModelTemplBase pSDCModelTemplBase) throws Exception {
        return this.selectByPSDCModelTempl(pSDCModelTemplBase, "", -1);
    }

    public ArrayList<PSDCMTDEF> selectByPSDCModelTempl(PSDCModelTemplBase pSDCModelTemplBase, String string) throws Exception {
        return this.selectByPSDCModelTempl(pSDCModelTemplBase, string, -1);
    }

    public ArrayList<PSDCMTDEF> selectByPSDCModelTempl(PSDCModelTemplBase pSDCModelTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMODELTEMPLID", (Object)pSDCModelTemplBase.getPSDCModelTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCModelTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCModelTemplCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
    }

    public void resetPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
        ArrayList<PSDCMTDEF> arrayList = this.selectByPSDCModelTempl(pSDCModelTempl);
        for (PSDCMTDEF pSDCMTDEF : arrayList) {
            PSDCMTDEF pSDCMTDEF2 = (PSDCMTDEF)this.getDEModel().createEntity();
            pSDCMTDEF2.setPSDCMTDEFId(pSDCMTDEF.getPSDCMTDEFId());
            pSDCMTDEF2.setPSDCModelTemplId(null);
            this.update(pSDCMTDEF2);
        }
    }

    public void removeByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
        final PSDCModelTempl pSDCModelTempl2 = pSDCModelTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMTDEFServiceBase.this.onBeforeRemoveByPSDCModelTempl(pSDCModelTempl2);
                PSDCMTDEFServiceBase.this.internalRemoveByPSDCModelTempl(pSDCModelTempl2);
                PSDCMTDEFServiceBase.this.onAfterRemoveByPSDCModelTempl(pSDCModelTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
    }

    protected void internalRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
        ArrayList<PSDCMTDEF> arrayList = this.selectByPSDCModelTempl(pSDCModelTempl);
        this.onBeforeRemoveByPSDCModelTempl(pSDCModelTempl, arrayList);
        for (PSDCMTDEF pSDCMTDEF : arrayList) {
            this.remove((IEntity)pSDCMTDEF);
        }
        this.onAfterRemoveByPSDCModelTempl(pSDCModelTempl, arrayList);
    }

    protected void onAfterRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl, ArrayList<PSDCMTDEF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl, ArrayList<PSDCMTDEF> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCMTDEF pSDCMTDEF) throws Exception {
        super.onBeforeRemove(pSDCMTDEF);
    }

    protected void replaceParentInfo(PSDCMTDEF pSDCMTDEF, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDCMTDEF, cloneSession);
        if (pSDCMTDEF.getPSDCModelTemplId() != null && (iEntity = cloneSession.getEntity("PSDCMODELTEMPL", (Object)pSDCMTDEF.getPSDCModelTemplId())) != null) {
            this.onFillParentInfo_PSDCModelTempl(pSDCMTDEF, (PSDCModelTempl)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCMTDEF pSDCMTDEF, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDCMTDEF, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSDCMTDEF, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFDataType(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Length(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorField(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PKey(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreDefinedType(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCModelTemplId(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCModelTemplName(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMTDEFId(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMTDEFName(bl, pSDCMTDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDCMTDEF, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isAllowEmptyDirty() : !pSDCMTDEF.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSDCMTDEF.getAllowEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isCodeNameDirty() : !pSDCMTDEF.isCodeNameDirty()) {
            return null;
        }
        String string = pSDCMTDEF.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDCMTDEF, bl2, bl3);
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
                string3 = "PSDCMODELTEMPLID";
                String string4 = this.checkFieldDupRule(this.getPSDCMTDEFDEModel(), "CODENAME", string3, pSDCMTDEF, bl2, bl3);
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

    protected EntityFieldError onCheckField_DEFDataType(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isDEFDataTypeDirty() && !bl2 : !pSDCMTDEF.isDEFDataTypeDirty()) {
            return null;
        }
        String string = pSDCMTDEF.getDEFDataType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFDATATYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEFDataType_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Length(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isLengthDirty() : !pSDCMTDEF.isLengthDirty()) {
            return null;
        }
        Integer n = pSDCMTDEF.getLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Length_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isLogicNameDirty() && !bl2 : !pSDCMTDEF.isLogicNameDirty()) {
            return null;
        }
        String string = pSDCMTDEF.getLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSDCMTDEF, bl2, bl3);
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

    protected EntityFieldError onCheckField_MajorField(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isMajorFieldDirty() && !bl2 : !pSDCMTDEF.isMajorFieldDirty()) {
            return null;
        }
        Integer n = pSDCMTDEF.getMajorField();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORFIELD");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_MajorField_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDCMODELTEMPLID";
                String string2 = this.checkFieldDupRule(this.getPSDCMTDEFDEModel(), "MAJORFIELD", string, pSDCMTDEF, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MAJORFIELD");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isMemoDirty() : !pSDCMTDEF.isMemoDirty()) {
            return null;
        }
        String string = pSDCMTDEF.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDCMTDEF, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isOrderValueDirty() : !pSDCMTDEF.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDCMTDEF.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PKey(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isPKeyDirty() && !bl2 : !pSDCMTDEF.isPKeyDirty()) {
            return null;
        }
        Integer n = pSDCMTDEF.getPKey();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKEY");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_PKey_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDCMODELTEMPLID";
                String string2 = this.checkFieldDupRule(this.getPSDCMTDEFDEModel(), "PKEY", string, pSDCMTDEF, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PKEY");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isPrecision2Dirty() : !pSDCMTDEF.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSDCMTDEF.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRECISION2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreDefinedType(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isPreDefinedTypeDirty() : !pSDCMTDEF.isPreDefinedTypeDirty()) {
            return null;
        }
        String string = pSDCMTDEF.getPreDefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreDefinedType_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCModelTemplId(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isPSDCModelTemplIdDirty() : !pSDCMTDEF.isPSDCModelTemplIdDirty()) {
            return null;
        }
        String string = pSDCMTDEF.getPSDCModelTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCModelTemplId_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMODELTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCModelTemplName(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isPSDCModelTemplNameDirty() : !pSDCMTDEF.isPSDCModelTemplNameDirty()) {
            return null;
        }
        String string = pSDCMTDEF.getPSDCModelTemplName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCModelTemplName_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMODELTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMTDEFId(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isPSDCMTDEFIdDirty() && !bl2 : !pSDCMTDEF.isPSDCMTDEFIdDirty()) {
            return null;
        }
        String string = pSDCMTDEF.getPSDCMTDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMTDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMTDEFId_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMTDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMTDEFName(boolean bl, PSDCMTDEF pSDCMTDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDEF.isPSDCMTDEFNameDirty() && !bl2 : !pSDCMTDEF.isPSDCMTDEFNameDirty()) {
            return null;
        }
        String string = pSDCMTDEF.getPSDCMTDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMTDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMTDEFName_Default((IEntity)pSDCMTDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMTDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDCMODELTEMPLID";
                String string4 = this.checkFieldDupRule(this.getPSDCMTDEFDEModel(), "PSDCMTDEFNAME", string3, pSDCMTDEF, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDCMTDEFNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCMTDEF pSDCMTDEF, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDCMTDEF, bl);
    }

    protected void onSyncIndexEntities(PSDCMTDEF pSDCMTDEF, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDCMTDEF, bl);
    }

    public Object getDataContextValue(PSDCMTDEF pSDCMTDEF, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDCMTDEF, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCModelTempl pSDCModelTempl = pSDCMTDEF.getPSDCModelTempl();
        if (pSDCModelTempl != null && pSDCModelTempl.contains(string)) {
            return pSDCModelTempl.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCMTDEF pSDCMTDEF, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDCMTDEF, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEFDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Length_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreDefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMODELTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCModelTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMODELTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCModelTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMTDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMTDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMTDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMTDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_DEFDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFDATATYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Length_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PreDefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCModelTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMODELTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCModelTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMODELTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMTDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMTDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMTDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMTDEFNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSDCMTDEFNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDCMTDEF pSDCMTDEF) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDCMTDEF)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCMTDEF pSDCMTDEF) throws Exception {
        Object object = pSDCMTDEF.get("PSDCMODELTEMPLID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDCMTDEF_PSDCMODELTEMPL_PSDCMODELTEMPLID", object);
        }
        super.onUpdateParent((IEntity)pSDCMTDEF);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDCMTDEF pSDCMTDEF, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCMTDEF");
        if (!bl) {
            pSDCMTDEF.setCreateDate(null);
            pSDCMTDEF.setCreateMan(null);
            pSDCMTDEF.setPSDCMTDEFId(null);
            pSDCMTDEF.setUpdateDate(null);
            pSDCMTDEF.setUpdateMan(null);
            super.exportCurXmlModel(pSDCMTDEF, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDCMTDEF pSDCMTDEF, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDCMTDEF, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDCMODELTEMPLID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDCMODELTEMPL#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDCMODELTEMPLID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDCMTDEF_PSDCMODELTEMPL_PSDCMODELTEMPLID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDCMODELTEMPLID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDCMODELTEMPLNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDCMODELTEMPL", (boolean)true) == 0) {
            iEntity.set("PSDCMODELTEMPLID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDCMODELTEMPLID"};
    }

    @Override
    public String getModelV2Tag(PSDCMTDEF pSDCMTDEF) {
        if (!StringHelper.isNullOrEmpty((String)pSDCMTDEF.getPSDCMTDEFName())) {
            return pSDCMTDEF.getPSDCMTDEFName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDCMTDEF.getCodeName())) {
            return pSDCMTDEF.getCodeName();
        }
        return super.getModelV2Tag(pSDCMTDEF);
    }

    @Override
    public boolean setModelV2Tag(PSDCMTDEF pSDCMTDEF, String string) {
        return super.setModelV2Tag(pSDCMTDEF, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDCMTDEFNAME", "");
        map.put("CODENAME", "");
        map.put("PSDCMODELTEMPLID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDCMTDEF pSDCMTDEF, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDCMTDEF.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDCMTDEF, true);
        pSDCMTDEF.set("PSDCMTDEFNAME", string);
        if (this.select(pSDCMTDEF, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDCMTDEF, true);
        return super.getModelV2Entity(pSDCMTDEF, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDCMTDEF pSDCMTDEF, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDCMTDEF, objectNode, string, string2, n);
    }
}

