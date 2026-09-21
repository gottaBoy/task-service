/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
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
package net.ibizsys.pscore.srv.config.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
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
import net.ibizsys.pscore.srv.config.dao.PSSFVerCodeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFVerCodeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVerBase;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCode;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCodeItem;
import net.ibizsys.pscore.srv.config.service.PSSFVerCodeItemService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFVerCodeServiceBase
extends PSCoreSysServiceBase<PSSFVerCode> {
    private static final Log log = LogFactory.getLog(PSSFVerCodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFVerCodeDEModel pSSFVerCodeDEModel;
    private PSSFVerCodeDAO pSSFVerCodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFVerCodeService";
    }

    public PSSFVerCodeDEModel getPSSFVerCodeDEModel() {
        if (this.pSSFVerCodeDEModel == null) {
            try {
                this.pSSFVerCodeDEModel = (PSSFVerCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFVerCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFVerCodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFVerCodeDEModel();
    }

    public PSSFVerCodeDAO getPSSFVerCodeDAO() {
        if (this.pSSFVerCodeDAO == null) {
            try {
                this.pSSFVerCodeDAO = (PSSFVerCodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFVerCodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFVerCodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFVerCodeDAO();
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

    protected void onFillParentInfo(PSSFVerCode pSSFVerCode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFVERCODE_PSSFCODETYPE_PSSFCODETYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService", (SessionFactory)this.getSessionFactory());
            PSSFCodeType pSSFCodeType = (PSSFCodeType)iService.getDEModel().createEntity();
            pSSFCodeType.set("PSSFCODETYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFCodeType);
            } else {
                iService.get((IEntity)pSSFCodeType);
            }
            this.onFillParentInfo_PSSFCodeType(pSSFVerCode, pSSFCodeType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFVERCODE_PSSFSTYLEVER_PSSFSTYLEVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleVerService", (SessionFactory)this.getSessionFactory());
            PSSFStyleVer pSSFStyleVer = (PSSFStyleVer)iService.getDEModel().createEntity();
            pSSFStyleVer.set("PSSFSTYLEVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStyleVer);
            } else {
                iService.get((IEntity)pSSFStyleVer);
            }
            this.onFillParentInfo_PSSFStyleVer(pSSFVerCode, pSSFStyleVer);
            return;
        }
        super.onFillParentInfo((IEntity)pSSFVerCode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFCodeType(PSSFVerCode pSSFVerCode, PSSFCodeType pSSFCodeType) throws Exception {
        pSSFVerCode.setPSSFCodeFolderId(pSSFCodeType.getPSSFCodeFolderId());
        pSSFVerCode.setPSSFCodeTypeId(pSSFCodeType.getPSSFCodeTypeId());
        pSSFVerCode.setPSSFCodeTypeName(pSSFCodeType.getPSSFCodeTypeName());
        pSSFVerCode.setRealPSSFStyleId(pSSFCodeType.getPSSFStyleId());
        pSSFVerCode.setTypeCode(pSSFCodeType.getTypeCode());
    }

    protected void onFillParentInfo_PSSFStyleVer(PSSFVerCode pSSFVerCode, PSSFStyleVer pSSFStyleVer) throws Exception {
        pSSFVerCode.setPSSFStyleVerId(pSSFStyleVer.getPSSFStyleVerId());
        pSSFVerCode.setPSSFStyleVerName(pSSFStyleVer.getPSSFStyleVerName());
    }

    protected void onFillEntityFullInfo(PSSFVerCode pSSFVerCode, boolean bl) throws Exception {
        if (bl && pSSFVerCode.getValidFlag() == null) {
            pSSFVerCode.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSFVerCode, bl);
        this.onFillEntityFullInfo_PSSFCodeType(pSSFVerCode, bl);
        this.onFillEntityFullInfo_PSSFStyleVer(pSSFVerCode, bl);
    }

    protected void onFillEntityFullInfo_PSSFCodeType(PSSFVerCode pSSFVerCode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSFStyleVer(PSSFVerCode pSSFVerCode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFVerCode pSSFVerCode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSFVerCode, bl);
    }

    public ArrayList<PSSFVerCode> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase) throws Exception {
        return this.selectByPSSFCodeType(pSSFCodeTypeBase, "", -1);
    }

    public ArrayList<PSSFVerCode> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase, String string) throws Exception {
        return this.selectByPSSFCodeType(pSSFCodeTypeBase, string, -1);
    }

    public ArrayList<PSSFVerCode> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFCODETYPEID", (Object)pSSFCodeTypeBase.getPSSFCodeTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCodeTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCodeTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFVerCode> selectByPSSFStyleVer(PSSFStyleVerBase pSSFStyleVerBase) throws Exception {
        return this.selectByPSSFStyleVer(pSSFStyleVerBase, "", -1);
    }

    public ArrayList<PSSFVerCode> selectByPSSFStyleVer(PSSFStyleVerBase pSSFStyleVerBase, String string) throws Exception {
        return this.selectByPSSFStyleVer(pSSFStyleVerBase, string, -1);
    }

    public ArrayList<PSSFVerCode> selectByPSSFStyleVer(PSSFStyleVerBase pSSFStyleVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEVERID", (Object)pSSFStyleVerBase.getPSSFStyleVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStyleVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStyleVerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        ArrayList<PSSFVerCode> arrayList = this.selectByPSSFCodeType(pSSFCodeType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFCODETYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSFCodeType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFVERCODE_PSSFCODETYPE_PSSFCODETYPEID", "", iDataEntityModel.getName(), "PSSFVERCODE", iDataEntityModel.getDataInfo((IEntity)pSSFCodeType), arrayList.get(0)));
        }
    }

    public void resetPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        ArrayList<PSSFVerCode> arrayList = this.selectByPSSFCodeType(pSSFCodeType);
        for (PSSFVerCode pSSFVerCode : arrayList) {
            PSSFVerCode pSSFVerCode2 = (PSSFVerCode)this.getDEModel().createEntity();
            pSSFVerCode2.setPSSFVerCodeId(pSSFVerCode.getPSSFVerCodeId());
            pSSFVerCode2.setPSSFCodeTypeId(null);
            this.update(pSSFVerCode2);
        }
    }

    public void removeByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        final PSSFCodeType pSSFCodeType2 = pSSFCodeType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFVerCodeServiceBase.this.onBeforeRemoveByPSSFCodeType(pSSFCodeType2);
                PSSFVerCodeServiceBase.this.internalRemoveByPSSFCodeType(pSSFCodeType2);
                PSSFVerCodeServiceBase.this.onAfterRemoveByPSSFCodeType(pSSFCodeType2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
    }

    protected void internalRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        ArrayList<PSSFVerCode> arrayList = this.selectByPSSFCodeType(pSSFCodeType);
        this.onBeforeRemoveByPSSFCodeType(pSSFCodeType, arrayList);
        for (PSSFVerCode pSSFVerCode : arrayList) {
            this.remove((IEntity)pSSFVerCode);
        }
        this.onAfterRemoveByPSSFCodeType(pSSFCodeType, arrayList);
    }

    protected void onAfterRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
    }

    protected void onBeforeRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType, ArrayList<PSSFVerCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType, ArrayList<PSSFVerCode> arrayList) throws Exception {
    }

    public void testRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
    }

    public void resetPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        ArrayList<PSSFVerCode> arrayList = this.selectByPSSFStyleVer(pSSFStyleVer);
        for (PSSFVerCode pSSFVerCode : arrayList) {
            PSSFVerCode pSSFVerCode2 = (PSSFVerCode)this.getDEModel().createEntity();
            pSSFVerCode2.setPSSFVerCodeId(pSSFVerCode.getPSSFVerCodeId());
            pSSFVerCode2.setPSSFStyleVerId(null);
            this.update(pSSFVerCode2);
        }
    }

    public void removeByPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        final PSSFStyleVer pSSFStyleVer2 = pSSFStyleVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFVerCodeServiceBase.this.onBeforeRemoveByPSSFStyleVer(pSSFStyleVer2);
                PSSFVerCodeServiceBase.this.internalRemoveByPSSFStyleVer(pSSFStyleVer2);
                PSSFVerCodeServiceBase.this.onAfterRemoveByPSSFStyleVer(pSSFStyleVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
    }

    protected void internalRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        ArrayList<PSSFVerCode> arrayList = this.selectByPSSFStyleVer(pSSFStyleVer);
        this.onBeforeRemoveByPSSFStyleVer(pSSFStyleVer, arrayList);
        for (PSSFVerCode pSSFVerCode : arrayList) {
            this.remove((IEntity)pSSFVerCode);
        }
        this.onAfterRemoveByPSSFStyleVer(pSSFStyleVer, arrayList);
    }

    protected void onAfterRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer, ArrayList<PSSFVerCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyleVer(PSSFStyleVer pSSFStyleVer, ArrayList<PSSFVerCode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFVerCode pSSFVerCode) throws Exception {
        PSSFVerCodeItemService pSSFVerCodeItemService = (PSSFVerCodeItemService)ServiceGlobal.getService(PSSFVerCodeItemService.class, (SessionFactory)this.getSessionFactory());
        pSSFVerCodeItemService.testRemoveByPSSFVerCode(pSSFVerCode);
        pSSFVerCodeItemService.removeByPSSFVerCode(pSSFVerCode);
        super.onBeforeRemove(pSSFVerCode);
    }

    protected void replaceParentInfo(PSSFVerCode pSSFVerCode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSFVerCode, cloneSession);
        if (pSSFVerCode.getPSSFCodeTypeId() != null && (iEntity = cloneSession.getEntity("PSSFCODETYPE", (Object)pSSFVerCode.getPSSFCodeTypeId())) != null) {
            this.onFillParentInfo_PSSFCodeType(pSSFVerCode, (PSSFCodeType)iEntity);
        }
        if (pSSFVerCode.getPSSFStyleVerId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLEVER", (Object)pSSFVerCode.getPSSFStyleVerId())) != null) {
            this.onFillParentInfo_PSSFStyleVer(pSSFVerCode, (PSSFStyleVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFVerCode pSSFVerCode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSFVerCode, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodePath(bl, pSSFVerCode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeTempl(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomTypeCode(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomTypeCodeDesc(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCustomCodePath(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCustomFileName(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCustomTypeCode(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileExt(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileName(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeTypeId(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleVerId(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFVerCodeId(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFVerCodeName(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSFVerCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSFVerCode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodePath(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isCodePathDirty() : !pSSFVerCode.isCodePathDirty()) {
            return null;
        }
        String string = pSSFVerCode.getCodePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodePath_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeTempl(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isCodeTemplDirty() : !pSSFVerCode.isCodeTemplDirty()) {
            return null;
        }
        String string = pSSFVerCode.getCodeTempl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeTempl_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODETEMPL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomTypeCode(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isCustomTypeCodeDirty() : !pSSFVerCode.isCustomTypeCodeDirty()) {
            return null;
        }
        String string = pSSFVerCode.getCustomTypeCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomTypeCode_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMTYPECODE");
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
                string3 = "PSSFSTYLEVERID";
                String string4 = this.checkFieldDupRule(this.getPSSFVerCodeDEModel(), "CUSTOMTYPECODE", string3, pSSFVerCode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CUSTOMTYPECODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomTypeCodeDesc(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isCustomTypeCodeDescDirty() : !pSSFVerCode.isCustomTypeCodeDescDirty()) {
            return null;
        }
        String string = pSSFVerCode.getCustomTypeCodeDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomTypeCodeDesc_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMTYPECODEDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCustomCodePath(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isEnableCustomCodePathDirty() : !pSSFVerCode.isEnableCustomCodePathDirty()) {
            return null;
        }
        Integer n = pSSFVerCode.getEnableCustomCodePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCustomCodePath_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECUSTOMCODEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCustomFileName(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isEnableCustomFileNameDirty() : !pSSFVerCode.isEnableCustomFileNameDirty()) {
            return null;
        }
        Integer n = pSSFVerCode.getEnableCustomFileName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCustomFileName_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECUSTOMFILENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCustomTypeCode(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isEnableCustomTypeCodeDirty() : !pSSFVerCode.isEnableCustomTypeCodeDirty()) {
            return null;
        }
        Integer n = pSSFVerCode.getEnableCustomTypeCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCustomTypeCode_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECUSTOMTYPECODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileExt(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isFileExtDirty() : !pSSFVerCode.isFileExtDirty()) {
            return null;
        }
        String string = pSSFVerCode.getFileExt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileExt_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILEEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileName(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isFileNameDirty() : !pSSFVerCode.isFileNameDirty()) {
            return null;
        }
        String string = pSSFVerCode.getFileName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileName_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isMemoDirty() : !pSSFVerCode.isMemoDirty()) {
            return null;
        }
        String string = pSSFVerCode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSFVerCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFCodeTypeId(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isPSSFCodeTypeIdDirty() && !bl2 : !pSSFVerCode.isPSSFCodeTypeIdDirty()) {
            return null;
        }
        String string = pSSFVerCode.getPSSFCodeTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeTypeId_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleVerId(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isPSSFStyleVerIdDirty() && !bl2 : !pSSFVerCode.isPSSFStyleVerIdDirty()) {
            return null;
        }
        String string = pSSFVerCode.getPSSFStyleVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleVerId_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFVerCodeId(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isPSSFVerCodeIdDirty() && !bl2 : !pSSFVerCode.isPSSFVerCodeIdDirty()) {
            return null;
        }
        String string = pSSFVerCode.getPSSFVerCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVERCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFVerCodeId_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVERCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFVerCodeName(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isPSSFVerCodeNameDirty() && !bl2 : !pSSFVerCode.isPSSFVerCodeNameDirty()) {
            return null;
        }
        String string = pSSFVerCode.getPSSFVerCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVERCODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFVerCodeName_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVERCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isTemplCode2Dirty() : !pSSFVerCode.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSSFVerCode.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSFVerCode pSSFVerCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFVerCode.isValidFlagDirty() && !bl2 : !pSSFVerCode.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSFVerCode.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSFVerCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSFVerCode pSSFVerCode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSFVerCode, bl);
    }

    protected void onSyncIndexEntities(PSSFVerCode pSSFVerCode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSFVerCode, bl);
    }

    public Object getDataContextValue(PSSFVerCode pSSFVerCode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSFVerCode, string, iDataContextParam)) != null) {
            return object;
        }
        PSSFStyleVer pSSFStyleVer = pSSFVerCode.getPSSFStyleVer();
        if (pSSFStyleVer != null && pSSFStyleVer.contains(string)) {
            return pSSFStyleVer.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSFVerCode pSSFVerCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSFVerCode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODETEMPL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeTempl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomTypeCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPECODEDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomTypeCodeDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECUSTOMCODEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCustomCodePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECUSTOMFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCustomFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECUSTOMTYPECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCustomTypeCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILEEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileExt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODEFOLDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeFolderId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFVERCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFVerCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFVERCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFVerCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REALPSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RealPSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeTempl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODETEMPL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_CustomTypeCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMTYPECODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomTypeCodeDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMTYPECODEDESC", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableCustomCodePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCustomFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCustomTypeCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FileExt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILEEXT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILENAME", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
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

    protected String onTestValueRule_PSSFCodeFolderId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODEFOLDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCodeTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODETYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCodeTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODETYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFVerCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFVERCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFVerCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFVERCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RealPSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REALPSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPECODE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSFVerCode pSSFVerCode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSFVerCode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFVerCode pSSFVerCode) throws Exception {
        super.onUpdateParent((IEntity)pSSFVerCode);
    }

    protected void onCopyDetails(PSSFVerCode pSSFVerCode, Object object) throws Exception {
        PSSFVerCode pSSFVerCode2 = new PSSFVerCode();
        pSSFVerCode2.set("PSSFVERCODEID", object);
        String string = DataObject.getStringValue((Object)pSSFVerCode.get("PSSFVERCODEID"));
        PSSFVerCodeItemService pSSFVerCodeItemService = (PSSFVerCodeItemService)ServiceGlobal.getService(PSSFVerCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSFVerCodeItem> arrayList = pSSFVerCodeItemService.selectByPSSFVerCode(pSSFVerCode2);
        for (PSSFVerCodeItem pSSFVerCodeItem : arrayList) {
            Object object2 = pSSFVerCodeItem.get("PSSFVERCODEITEMID");
            pSSFVerCodeItemService.getDraftFrom((IEntity)pSSFVerCodeItem);
            pSSFVerCodeItemService.fillParentInfo((IEntity)pSSFVerCodeItem, "DER1N", "DER1N_PSSFVERCODEITEM_PSSFVERCODE_PSSFVERCODEID", string);
            pSSFVerCodeItemService.create(pSSFVerCodeItem);
            pSSFVerCodeItemService.copyDetails(pSSFVerCodeItem, object2);
        }
        super.onCopyDetails((IEntity)pSSFVerCode, object);
    }

    @Override
    protected void exportCurXmlModel(PSSFVerCode pSSFVerCode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFVERCODE");
        if (!bl) {
            pSSFVerCode.setCodeTempl(null);
            pSSFVerCode.setCreateDate(null);
            pSSFVerCode.setCreateMan(null);
            pSSFVerCode.setPSSFVerCodeId(null);
            pSSFVerCode.setUpdateDate(null);
            pSSFVerCode.setUpdateMan(null);
            super.exportCurXmlModel(pSSFVerCode, xmlNode, bl);
        }
    }
}

