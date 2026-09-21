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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDQCodeExpDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDQCodeExpDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeExp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDQCodeExpServiceBase
extends PSCoreSysServiceBase<PSDEDQCodeExp> {
    private static final Log log = LogFactory.getLog(PSDEDQCodeExpServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEDQCodeExpDEModel pSDEDQCodeExpDEModel;
    private PSDEDQCodeExpDAO pSDEDQCodeExpDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeExpService";
    }

    public PSDEDQCodeExpDEModel getPSDEDQCodeExpDEModel() {
        if (this.pSDEDQCodeExpDEModel == null) {
            try {
                this.pSDEDQCodeExpDEModel = (PSDEDQCodeExpDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDQCodeExpDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDQCodeExpDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDQCodeExpDEModel();
    }

    public PSDEDQCodeExpDAO getPSDEDQCodeExpDAO() {
        if (this.pSDEDQCodeExpDAO == null) {
            try {
                this.pSDEDQCodeExpDAO = (PSDEDQCodeExpDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDQCodeExpDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDQCodeExpDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDQCodeExpDAO();
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

    protected void onFillParentInfo(PSDEDQCodeExp pSDEDQCodeExp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQCODEEXP_PSDEDQCODE_PSDEDQCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService", (SessionFactory)this.getSessionFactory());
            PSDEDQCode pSDEDQCode = (PSDEDQCode)iService.getDEModel().createEntity();
            pSDEDQCode.set("PSDEDQCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDQCode);
            } else {
                iService.get((IEntity)pSDEDQCode);
            }
            this.onFillParentInfo_PSDEDQCode(pSDEDQCodeExp, pSDEDQCode);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEDQCodeExp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDQCODEEXP_PSDEDQCODE_PSDEDQCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService", (SessionFactory)this.getSessionFactory());
            PSDEDQCode pSDEDQCode = (PSDEDQCode)iService.getDEModel().createEntity();
            pSDEDQCode.set("PSDEDQCODEID", string2);
            return this.onSyncDER1NData_PSDEDQCode(pSDEDQCode, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEDQCode(PSDEDQCodeExp pSDEDQCodeExp, PSDEDQCode pSDEDQCode) throws Exception {
        pSDEDQCodeExp.setPSDEDQCodeId(pSDEDQCode.getPSDEDQCodeId());
        pSDEDQCodeExp.setPSDEDQCodeName(pSDEDQCode.getPSDEDQCodeName());
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
            ArrayList<PSDEDQCodeExp> arrayList = this.selectByPSDEDQCode(pSDEDQCode);
            for (PSDEDQCodeExp pSDEDQCodeExp : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEDQCodeExp, (String)"PSDEDQCODEEXPID", (String)""))) continue;
                this.remove((IEntity)pSDEDQCodeExp);
            }
        }
        return null;
    }

    protected boolean onFillEntityKeyValue(PSDEDQCodeExp pSDEDQCodeExp, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEDQCodeExp.get("PSDEDQCODEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEDQCodeExp.get("PSDEDQCODEEXPNAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEDQCodeExp.set(this.getPSDEDQCodeExpDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEDQCodeExp pSDEDQCodeExp, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEDQCodeExp, bl);
        this.onFillEntityFullInfo_PSDEDQCode(pSDEDQCodeExp, bl);
    }

    protected void onFillEntityFullInfo_PSDEDQCode(PSDEDQCodeExp pSDEDQCodeExp, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDQCodeExp pSDEDQCodeExp, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDQCodeExp, bl);
    }

    public ArrayList<PSDEDQCodeExp> selectByPSDEDQCode(PSDEDQCodeBase pSDEDQCodeBase) throws Exception {
        return this.selectByPSDEDQCode(pSDEDQCodeBase, "", -1);
    }

    public ArrayList<PSDEDQCodeExp> selectByPSDEDQCode(PSDEDQCodeBase pSDEDQCodeBase, String string) throws Exception {
        return this.selectByPSDEDQCode(pSDEDQCodeBase, string, -1);
    }

    public ArrayList<PSDEDQCodeExp> selectByPSDEDQCode(PSDEDQCodeBase pSDEDQCodeBase, String string, int n) throws Exception {
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
        ArrayList<PSDEDQCodeExp> arrayList = this.selectByPSDEDQCode(pSDEDQCode);
        for (PSDEDQCodeExp pSDEDQCodeExp : arrayList) {
            PSDEDQCodeExp pSDEDQCodeExp2 = (PSDEDQCodeExp)this.getDEModel().createEntity();
            pSDEDQCodeExp2.setPSDEDQCodeExpId(pSDEDQCodeExp.getPSDEDQCodeExpId());
            pSDEDQCodeExp2.setPSDEDQCodeId(null);
            this.update(pSDEDQCodeExp2);
        }
    }

    public void removeByPSDEDQCode(PSDEDQCode pSDEDQCode) throws Exception {
        final PSDEDQCode pSDEDQCode2 = pSDEDQCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCodeExpServiceBase.this.onBeforeRemoveByPSDEDQCode(pSDEDQCode2);
                PSDEDQCodeExpServiceBase.this.internalRemoveByPSDEDQCode(pSDEDQCode2);
                PSDEDQCodeExpServiceBase.this.onAfterRemoveByPSDEDQCode(pSDEDQCode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQCode(PSDEDQCode pSDEDQCode) throws Exception {
    }

    protected void internalRemoveByPSDEDQCode(PSDEDQCode pSDEDQCode) throws Exception {
        ArrayList<PSDEDQCodeExp> arrayList = this.selectByPSDEDQCode(pSDEDQCode);
        this.onBeforeRemoveByPSDEDQCode(pSDEDQCode, arrayList);
        for (PSDEDQCodeExp pSDEDQCodeExp : arrayList) {
            this.remove((IEntity)pSDEDQCodeExp);
        }
        this.onAfterRemoveByPSDEDQCode(pSDEDQCode, arrayList);
    }

    protected void onAfterRemoveByPSDEDQCode(PSDEDQCode pSDEDQCode) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQCode(PSDEDQCode pSDEDQCode, ArrayList<PSDEDQCodeExp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQCode(PSDEDQCode pSDEDQCode, ArrayList<PSDEDQCodeExp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDQCodeExp pSDEDQCodeExp) throws Exception {
        super.onBeforeRemove(pSDEDQCodeExp);
    }

    protected void replaceParentInfo(PSDEDQCodeExp pSDEDQCodeExp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEDQCodeExp, cloneSession);
        if (pSDEDQCodeExp.getPSDEDQCodeId() != null && (iEntity = cloneSession.getEntity("PSDEDQCODE", (Object)pSDEDQCodeExp.getPSDEDQCodeId())) != null) {
            this.onFillParentInfo_PSDEDQCode(pSDEDQCodeExp, (PSDEDQCode)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDQCodeExp pSDEDQCodeExp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDQCodeExp, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDQCodeExp pSDEDQCodeExp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ExpCode(bl, pSDEDQCodeExp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDQCodeExp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEDQCodeExp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQCodeExpId(bl, pSDEDQCodeExp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQCodeExpName(bl, pSDEDQCodeExp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQCodeId(bl, pSDEDQCodeExp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDQCodeExp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ExpCode(boolean bl, PSDEDQCodeExp pSDEDQCodeExp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeExp.isExpCodeDirty() && !bl2 : !pSDEDQCodeExp.isExpCodeDirty()) {
            return null;
        }
        String string = pSDEDQCodeExp.getExpCode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPCODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExpCode_Default((IEntity)pSDEDQCodeExp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDQCodeExp pSDEDQCodeExp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeExp.isMemoDirty() : !pSDEDQCodeExp.isMemoDirty()) {
            return null;
        }
        String string = pSDEDQCodeExp.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEDQCodeExp, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEDQCodeExp pSDEDQCodeExp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeExp.isOrderValueDirty() && !bl2 : !pSDEDQCodeExp.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEDQCodeExp.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEDQCodeExp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDQCodeExpId(boolean bl, PSDEDQCodeExp pSDEDQCodeExp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeExp.isPSDEDQCodeExpIdDirty() && !bl2 : !pSDEDQCodeExp.isPSDEDQCodeExpIdDirty()) {
            return null;
        }
        String string = pSDEDQCodeExp.getPSDEDQCodeExpId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODEEXPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQCodeExpId_Default((IEntity)pSDEDQCodeExp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODEEXPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQCodeExpName(boolean bl, PSDEDQCodeExp pSDEDQCodeExp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeExp.isPSDEDQCodeExpNameDirty() && !bl2 : !pSDEDQCodeExp.isPSDEDQCodeExpNameDirty()) {
            return null;
        }
        String string = pSDEDQCodeExp.getPSDEDQCodeExpName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODEEXPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQCodeExpName_Default((IEntity)pSDEDQCodeExp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODEEXPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEDQCODEID";
                String string4 = this.checkFieldDupRule(this.getPSDEDQCodeExpDEModel(), "PSDEDQCODEEXPNAME", string3, pSDEDQCodeExp, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDQCODEEXPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQCodeId(boolean bl, PSDEDQCodeExp pSDEDQCodeExp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCodeExp.isPSDEDQCodeIdDirty() && !bl2 : !pSDEDQCodeExp.isPSDEDQCodeIdDirty()) {
            return null;
        }
        String string = pSDEDQCodeExp.getPSDEDQCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQCodeId_Default((IEntity)pSDEDQCodeExp, bl2, bl3);
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

    protected void onSyncEntity(PSDEDQCodeExp pSDEDQCodeExp, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDQCodeExp, bl);
    }

    protected void onSyncIndexEntities(PSDEDQCodeExp pSDEDQCodeExp, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDQCodeExp, bl);
    }

    public Object getDataContextValue(PSDEDQCodeExp pSDEDQCodeExp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEDQCodeExp, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEDQCode pSDEDQCode = pSDEDQCodeExp.getPSDEDQCode();
        if (pSDEDQCode != null && pSDEDQCode.contains(string)) {
            return pSDEDQCode.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDQCodeExp pSDEDQCodeExp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEDQCodeExp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCODEEXPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCodeExpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCODEEXPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCodeExpName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCodeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ExpCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXPCODE", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDQCodeExpId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQCODEEXPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQCodeExpName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQCODEEXPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEDQCodeExp pSDEDQCodeExp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDQCodeExp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDQCodeExp pSDEDQCodeExp) throws Exception {
        super.onUpdateParent((IEntity)pSDEDQCodeExp);
    }

    @Override
    protected void exportCurXmlModel(PSDEDQCodeExp pSDEDQCodeExp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDQCODEEXP");
        if (!bl) {
            pSDEDQCodeExp.setCreateDate(null);
            pSDEDQCodeExp.setCreateMan(null);
            pSDEDQCodeExp.setPSDEDQCodeExpId(null);
            pSDEDQCodeExp.setUpdateDate(null);
            pSDEDQCodeExp.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDQCodeExp, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEDQCodeExp pSDEDQCodeExp, PSSystem pSSystem) throws Exception {
        PSDEDQCodeExp pSDEDQCodeExp2 = new PSDEDQCodeExp();
        pSDEDQCodeExp2.setPSDEDQCodeId(pSDEDQCodeExp.getPSDEDQCodeId());
        pSDEDQCodeExp2.setPSDEDQCodeExpName(pSDEDQCodeExp.getPSDEDQCodeExpName());
        if (this.selectOne((IEntity)pSDEDQCodeExp2, true)) {
            return pSDEDQCodeExp2.getPSDEDQCodeExpId();
        }
        return super.getEntityFolderKeyValue(pSDEDQCodeExp, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDQCodeExp pSDEDQCodeExp, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDQCodeExp, string);
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
            return "DER1N_PSDEDQCODEEXP_PSDEDQCODE_PSDEDQCODEID";
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
    public String getModelV2Tag(PSDEDQCodeExp pSDEDQCodeExp) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDQCodeExp.getPSDEDQCodeExpName())) {
            return pSDEDQCodeExp.getPSDEDQCodeExpName();
        }
        return super.getModelV2Tag(pSDEDQCodeExp);
    }

    @Override
    public boolean setModelV2Tag(PSDEDQCodeExp pSDEDQCodeExp, String string) {
        pSDEDQCodeExp.setPSDEDQCodeExpName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEDQCODEEXPNAME", "");
        map.put("PSDEDQCODEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDQCodeExp pSDEDQCodeExp, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDQCodeExp.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDQCodeExp, true);
        pSDEDQCodeExp.set("PSDEDQCODEEXPNAME", string);
        if (this.select(pSDEDQCodeExp, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDQCodeExp, true);
        return super.getModelV2Entity(pSDEDQCodeExp, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDQCodeExp pSDEDQCodeExp, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEDQCodeExp, objectNode, string, string2, n);
    }
}

