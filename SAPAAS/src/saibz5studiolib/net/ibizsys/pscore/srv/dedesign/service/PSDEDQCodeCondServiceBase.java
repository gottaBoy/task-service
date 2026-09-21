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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDQCodeCondDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDQCodeCondDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeCond;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDQCodeCondServiceBase
extends PSCoreSysServiceBase<PSDEDQCodeCond> {
    private static final Log log = LogFactory.getLog(PSDEDQCodeCondServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEDQCodeCondDEModel pSDEDQCodeCondDEModel;
    private PSDEDQCodeCondDAO pSDEDQCodeCondDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeCondService";
    }

    public PSDEDQCodeCondDEModel getPSDEDQCodeCondDEModel() {
        if (this.pSDEDQCodeCondDEModel == null) {
            try {
                this.pSDEDQCodeCondDEModel = (PSDEDQCodeCondDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDQCodeCondDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDQCodeCondDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDQCodeCondDEModel();
    }

    public PSDEDQCodeCondDAO getPSDEDQCodeCondDAO() {
        if (this.pSDEDQCodeCondDAO == null) {
            try {
                this.pSDEDQCodeCondDAO = (PSDEDQCodeCondDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDQCodeCondDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDQCodeCondDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDQCodeCondDAO();
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

    protected void onFillParentInfo(PSDEDQCodeCond pSDEDQCodeCond, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQCODECOND_PSDEDQCODE_PSDEDQCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService", (SessionFactory)this.getSessionFactory());
            PSDEDQCode pSDEDQCode = (PSDEDQCode)iService.getDEModel().createEntity();
            pSDEDQCode.set("PSDEDQCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDQCode);
            } else {
                iService.get((IEntity)pSDEDQCode);
            }
            this.onFillParentInfo_PSDEDQCode(pSDEDQCodeCond, pSDEDQCode);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEDQCodeCond, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDQCODECOND_PSDEDQCODE_PSDEDQCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService", (SessionFactory)this.getSessionFactory());
            PSDEDQCode pSDEDQCode = (PSDEDQCode)iService.getDEModel().createEntity();
            pSDEDQCode.set("PSDEDQCODEID", string2);
            return this.onSyncDER1NData_PSDEDQCode(pSDEDQCode, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEDQCode(PSDEDQCodeCond pSDEDQCodeCond, PSDEDQCode pSDEDQCode) throws Exception {
        pSDEDQCodeCond.setPSDEDQCodeId(pSDEDQCode.getPSDEDQCodeId());
        pSDEDQCodeCond.setPSDEDQCodeName(pSDEDQCode.getPSDEDQCodeName());
    }

    protected String onSyncDER1NData_PSDEDQCode(PSDEDQCode pSDEDQCode, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEDQCode(pSDEDQCode);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEDQCodeCond> arrayList = this.selectByPSDEDQCode(pSDEDQCode);
            for (PSDEDQCodeCond pSDEDQCodeCond : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEDQCodeCond, (String)"PSDEDQCODECONDID", (String)""))) continue;
                this.remove((IEntity)pSDEDQCodeCond);
            }
        }
        return null;
    }

    protected void onFillEntityFullInfo(PSDEDQCodeCond pSDEDQCodeCond, boolean bl) throws Exception {
        if (bl && pSDEDQCodeCond.getPSDEDQCodeCondName() == null) {
            pSDEDQCodeCond.setPSDEDQCodeCondName((String)this.getDefaultValue(this.getWebContext(), "", "\u67e5\u8be2\u6761\u4ef6", 25));
        }
        super.onFillEntityFullInfo((IEntity)pSDEDQCodeCond, bl);
        this.onFillEntityFullInfo_PSDEDQCode(pSDEDQCodeCond, bl);
    }

    protected void onFillEntityFullInfo_PSDEDQCode(PSDEDQCodeCond pSDEDQCodeCond, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDQCodeCond pSDEDQCodeCond, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDQCodeCond, bl);
    }

    public ArrayList<PSDEDQCodeCond> selectByPSDEDQCode(PSDEDQCodeBase pSDEDQCodeBase) throws Exception {
        return this.selectByPSDEDQCode(pSDEDQCodeBase, "", -1);
    }

    public ArrayList<PSDEDQCodeCond> selectByPSDEDQCode(PSDEDQCodeBase pSDEDQCodeBase, String string) throws Exception {
        return this.selectByPSDEDQCode(pSDEDQCodeBase, string, -1);
    }

    public ArrayList<PSDEDQCodeCond> selectByPSDEDQCode(PSDEDQCodeBase pSDEDQCodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQCODEID", (Object)pSDEDQCodeBase.getPSDEDQCodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDQCodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDQCodeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEDQCode(PSDEDQCode pSDEDQCode) throws Exception {
    }

    public void resetPSDEDQCode(PSDEDQCode pSDEDQCode) throws Exception {
        ArrayList<PSDEDQCodeCond> arrayList = this.selectByPSDEDQCode(pSDEDQCode);
        for (PSDEDQCodeCond pSDEDQCodeCond : arrayList) {
            PSDEDQCodeCond pSDEDQCodeCond2 = (PSDEDQCodeCond)this.getDEModel().createEntity();
            pSDEDQCodeCond2.setPSDEDQCodeCondId(pSDEDQCodeCond.getPSDEDQCodeCondId());
            pSDEDQCodeCond2.setPSDEDQCodeId(null);
            this.update(pSDEDQCodeCond2);
        }
    }

    public void removeByPSDEDQCode(PSDEDQCode pSDEDQCode) throws Exception {
        final PSDEDQCode pSDEDQCode2 = pSDEDQCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCodeCondServiceBase.this.onBeforeRemoveByPSDEDQCode(pSDEDQCode2);
                PSDEDQCodeCondServiceBase.this.internalRemoveByPSDEDQCode(pSDEDQCode2);
                PSDEDQCodeCondServiceBase.this.onAfterRemoveByPSDEDQCode(pSDEDQCode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQCode(PSDEDQCode pSDEDQCode) throws Exception {
    }

    protected void internalRemoveByPSDEDQCode(PSDEDQCode pSDEDQCode) throws Exception {
        ArrayList<PSDEDQCodeCond> arrayList = this.selectByPSDEDQCode(pSDEDQCode);
        this.onBeforeRemoveByPSDEDQCode(pSDEDQCode, arrayList);
        for (PSDEDQCodeCond pSDEDQCodeCond : arrayList) {
            this.remove((IEntity)pSDEDQCodeCond);
        }
        this.onAfterRemoveByPSDEDQCode(pSDEDQCode, arrayList);
    }

    protected void onAfterRemoveByPSDEDQCode(PSDEDQCode pSDEDQCode) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQCode(PSDEDQCode pSDEDQCode, ArrayList<PSDEDQCodeCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQCode(PSDEDQCode pSDEDQCode, ArrayList<PSDEDQCodeCond> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDQCodeCond pSDEDQCodeCond) throws Exception {
        super.onBeforeRemove(pSDEDQCodeCond);
    }

    protected void replaceParentInfo(PSDEDQCodeCond pSDEDQCodeCond, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEDQCodeCond, cloneSession);
        if (pSDEDQCodeCond.getPSDEDQCodeId() != null && (iEntity = cloneSession.getEntity("PSDEDQCODE", (Object)pSDEDQCodeCond.getPSDEDQCodeId())) != null) {
            this.onFillParentInfo_PSDEDQCode(pSDEDQCodeCond, (PSDEDQCode)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDQCodeCond pSDEDQCodeCond, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDQCodeCond, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CondCode(bl, pSDEDQCodeCond, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondTag(bl, pSDEDQCodeCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondTag2(bl, pSDEDQCodeCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldName(bl, pSDEDQCodeCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreEmpty(bl, pSDEDQCodeCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDQCodeCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEDQCodeCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQCodeCondId(bl, pSDEDQCodeCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQCodeCondName(bl, pSDEDQCodeCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQCodeId(bl, pSDEDQCodeCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVarTypeId(bl, pSDEDQCodeCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDQCodeCond, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CondCode(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeCond.isCondCodeDirty() && !bl2 : !pSDEDQCodeCond.isCondCodeDirty()) {
            return null;
        }
        String string = pSDEDQCodeCond.getCondCode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDCODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondCode_Default((IEntity)pSDEDQCodeCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondTag(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeCond.isCondTagDirty() : !pSDEDQCodeCond.isCondTagDirty()) {
            return null;
        }
        String string = pSDEDQCodeCond.getCondTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondTag_Default((IEntity)pSDEDQCodeCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondTag2(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeCond.isCondTag2Dirty() : !pSDEDQCodeCond.isCondTag2Dirty()) {
            return null;
        }
        String string = pSDEDQCodeCond.getCondTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondTag2_Default((IEntity)pSDEDQCodeCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldName(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeCond.isFieldNameDirty() : !pSDEDQCodeCond.isFieldNameDirty()) {
            return null;
        }
        String string = pSDEDQCodeCond.getFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldName_Default((IEntity)pSDEDQCodeCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreEmpty(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeCond.isIgnoreEmptyDirty() : !pSDEDQCodeCond.isIgnoreEmptyDirty()) {
            return null;
        }
        Integer n = pSDEDQCodeCond.getIgnoreEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreEmpty_Default((IEntity)pSDEDQCodeCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeCond.isMemoDirty() : !pSDEDQCodeCond.isMemoDirty()) {
            return null;
        }
        String string = pSDEDQCodeCond.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEDQCodeCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeCond.isOrderValueDirty() && !bl2 : !pSDEDQCodeCond.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEDQCodeCond.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEDQCodeCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDQCodeCondId(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeCond.isPSDEDQCodeCondIdDirty() && !bl2 : !pSDEDQCodeCond.isPSDEDQCodeCondIdDirty()) {
            return null;
        }
        String string = pSDEDQCodeCond.getPSDEDQCodeCondId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODECONDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQCodeCondId_Default((IEntity)pSDEDQCodeCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODECONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQCodeCondName(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeCond.isPSDEDQCodeCondNameDirty() && !bl2 : !pSDEDQCodeCond.isPSDEDQCodeCondNameDirty()) {
            return null;
        }
        String string = pSDEDQCodeCond.getPSDEDQCodeCondName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODECONDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQCodeCondName_Default((IEntity)pSDEDQCodeCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODECONDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQCodeId(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeCond.isPSDEDQCodeIdDirty() && !bl2 : !pSDEDQCodeCond.isPSDEDQCodeIdDirty()) {
            return null;
        }
        String string = pSDEDQCodeCond.getPSDEDQCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQCodeId_Default((IEntity)pSDEDQCodeCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSVarTypeId(boolean bl, PSDEDQCodeCond pSDEDQCodeCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeCond.isPSVarTypeIdDirty() : !pSDEDQCodeCond.isPSVarTypeIdDirty()) {
            return null;
        }
        String string = pSDEDQCodeCond.getPSVarTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVarTypeId_Default((IEntity)pSDEDQCodeCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVARTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEDQCodeCond pSDEDQCodeCond, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDQCodeCond, bl);
    }

    protected void onSyncIndexEntities(PSDEDQCodeCond pSDEDQCodeCond, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDQCodeCond, bl);
    }

    public Object getDataContextValue(PSDEDQCodeCond pSDEDQCodeCond, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEDQCodeCond, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEDQCode pSDEDQCode = pSDEDQCodeCond.getPSDEDQCode();
        if (pSDEDQCode != null && pSDEDQCode.contains(string)) {
            return pSDEDQCode.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDQCodeCond pSDEDQCodeCond, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEDQCodeCond, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONDCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCODECONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCodeCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCODECONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCodeCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVARTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVarTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CondCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDCODE", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_FieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IgnoreEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDEDQCodeCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQCODECONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQCodeCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQCODECONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSVarTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVARTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSDEDQCodeCond pSDEDQCodeCond) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDQCodeCond)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDQCodeCond pSDEDQCodeCond) throws Exception {
        super.onUpdateParent((IEntity)pSDEDQCodeCond);
    }

    @Override
    protected void exportCurXmlModel(PSDEDQCodeCond pSDEDQCodeCond, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDQCODECOND");
        if (!bl) {
            super.exportCurXmlModel(pSDEDQCodeCond, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDQCodeCond pSDEDQCodeCond, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDQCodeCond, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQCODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEDQCODE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQCODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDQCODECOND_PSDEDQCODE_PSDEDQCODEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQCODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQCODENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEDQCODE", (boolean)true) == 0) {
            iEntity.set("PSDEDQCODEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEDQCODEID"};
    }

    @Override
    public String getModelV2Tag(PSDEDQCodeCond pSDEDQCodeCond) {
        return super.getModelV2Tag(pSDEDQCodeCond);
    }

    @Override
    public boolean setModelV2Tag(PSDEDQCodeCond pSDEDQCodeCond, String string) {
        return super.setModelV2Tag(pSDEDQCodeCond, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEDQCODEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDQCodeCond pSDEDQCodeCond, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDQCodeCond.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDQCodeCond, true);
        return super.getModelV2Entity(pSDEDQCodeCond, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDQCodeCond pSDEDQCodeCond, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEDQCodeCond, objectNode, string, string2, n);
    }
}

