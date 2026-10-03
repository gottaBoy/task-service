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
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppViewTemplDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppViewTemplDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewStyle;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewStyleBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCodeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewTemplServiceBase
extends PSCoreSysServiceBase<PSAppViewTempl> {
    private static final Log log = LogFactory.getLog(PSAppViewTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppViewTemplDEModel pSAppViewTemplDEModel;
    private PSAppViewTemplDAO pSAppViewTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppViewTemplService";
    }

    public PSAppViewTemplDEModel getPSAppViewTemplDEModel() {
        if (this.pSAppViewTemplDEModel == null) {
            try {
                this.pSAppViewTemplDEModel = (PSAppViewTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppViewTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppViewTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppViewTemplDEModel();
    }

    public PSAppViewTemplDAO getPSAppViewTemplDAO() {
        if (this.pSAppViewTemplDAO == null) {
            try {
                this.pSAppViewTemplDAO = (PSAppViewTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppViewTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppViewTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppViewTemplDAO();
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

    protected void onFillParentInfo(PSAppViewTempl pSAppViewTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEWTEMPL_PSAPPVIEWSTYLE_PSAPPVIEWSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewStyleService", (SessionFactory)this.getSessionFactory());
            PSAppViewStyle pSAppViewStyle = (PSAppViewStyle)iService.getDEModel().createEntity();
            pSAppViewStyle.set("PSAPPVIEWSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppViewStyle);
            } else {
                iService.get(pSAppViewStyle);
            }
            this.onFillParentInfo_PSAppViewStyle(pSAppViewTempl, pSAppViewStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEWTEMPL_PSPFPUBCODE_PSPFPUBCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubCodeService", (SessionFactory)this.getSessionFactory());
            PSPFPubCode pSPFPubCode = (PSPFPubCode)iService.getDEModel().createEntity();
            pSPFPubCode.set("PSPFPUBCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPubCode);
            } else {
                iService.get(pSPFPubCode);
            }
            this.onFillParentInfo_PSPFPubCode(pSAppViewTempl, pSPFPubCode);
            return;
        }
        super.onFillParentInfo(pSAppViewTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppViewStyle(PSAppViewTempl pSAppViewTempl, PSAppViewStyle pSAppViewStyle) throws Exception {
        pSAppViewTempl.setPSAppViewStyleId(pSAppViewStyle.getPSAppViewStyleId());
        pSAppViewTempl.setPSAppViewStyleName(pSAppViewStyle.getPSAppViewStyleName());
    }

    protected void onFillParentInfo_PSPFPubCode(PSAppViewTempl pSAppViewTempl, PSPFPubCode pSPFPubCode) throws Exception {
        pSAppViewTempl.setPSPFPubCodeId(pSPFPubCode.getPSPFPubCodeId());
        pSAppViewTempl.setPSPFPubCodeName(pSPFPubCode.getPSPFPubCodeName());
    }

    protected void onFillEntityFullInfo(PSAppViewTempl pSAppViewTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSAppViewTempl, bl);
        this.onFillEntityFullInfo_PSAppViewStyle(pSAppViewTempl, bl);
        this.onFillEntityFullInfo_PSPFPubCode(pSAppViewTempl, bl);
    }

    protected void onFillEntityFullInfo_PSAppViewStyle(PSAppViewTempl pSAppViewTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFPubCode(PSAppViewTempl pSAppViewTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppViewTempl pSAppViewTempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppViewTempl, bl);
    }

    public ArrayList<PSAppViewTempl> selectByPSAppViewStyle(PSAppViewStyleBase pSAppViewStyleBase) throws Exception {
        return this.selectByPSAppViewStyle(pSAppViewStyleBase, "", -1);
    }

    public ArrayList<PSAppViewTempl> selectByPSAppViewStyle(PSAppViewStyleBase pSAppViewStyleBase, String string) throws Exception {
        return this.selectByPSAppViewStyle(pSAppViewStyleBase, string, -1);
    }

    public ArrayList<PSAppViewTempl> selectByPSAppViewStyle(PSAppViewStyleBase pSAppViewStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPVIEWSTYLEID", (Object)pSAppViewStyleBase.getPSAppViewStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppViewStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppViewStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppViewTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, "", -1);
    }

    public ArrayList<PSAppViewTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, string, -1);
    }

    public ArrayList<PSAppViewTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPUBCODEID", (Object)pSPFPubCodeBase.getPSPFPubCodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFPubCodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFPubCodeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
    }

    public void resetPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
        ArrayList<PSAppViewTempl> arrayList = this.selectByPSAppViewStyle(pSAppViewStyle);
        for (PSAppViewTempl pSAppViewTempl : arrayList) {
            PSAppViewTempl pSAppViewTempl2 = (PSAppViewTempl)this.getDEModel().createEntity();
            pSAppViewTempl2.setPSAppViewTemplId(pSAppViewTempl.getPSAppViewTemplId());
            pSAppViewTempl2.setPSAppViewStyleId(null);
            this.update(pSAppViewTempl2);
        }
    }

    public void removeByPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
        final PSAppViewStyle pSAppViewStyle2 = pSAppViewStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewTemplServiceBase.this.onBeforeRemoveByPSAppViewStyle(pSAppViewStyle2);
                PSAppViewTemplServiceBase.this.internalRemoveByPSAppViewStyle(pSAppViewStyle2);
                PSAppViewTemplServiceBase.this.onAfterRemoveByPSAppViewStyle(pSAppViewStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
    }

    protected void internalRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
        ArrayList<PSAppViewTempl> arrayList = this.selectByPSAppViewStyle(pSAppViewStyle);
        this.onBeforeRemoveByPSAppViewStyle(pSAppViewStyle, arrayList);
        for (PSAppViewTempl pSAppViewTempl : arrayList) {
            this.remove(pSAppViewTempl);
        }
        this.onAfterRemoveByPSAppViewStyle(pSAppViewStyle, arrayList);
    }

    protected void onAfterRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle, ArrayList<PSAppViewTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle, ArrayList<PSAppViewTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSAppViewTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPUBCODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFPubCode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEWTEMPL_PSPFPUBCODE_PSPFPUBCODEID", "", iDataEntityModel.getName(), "PSAPPVIEWTEMPL", iDataEntityModel.getDataInfo(pSPFPubCode), arrayList.get(0)));
        }
    }

    public void resetPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSAppViewTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        for (PSAppViewTempl pSAppViewTempl : arrayList) {
            PSAppViewTempl pSAppViewTempl2 = (PSAppViewTempl)this.getDEModel().createEntity();
            pSAppViewTempl2.setPSAppViewTemplId(pSAppViewTempl.getPSAppViewTemplId());
            pSAppViewTempl2.setPSPFPubCodeId(null);
            this.update(pSAppViewTempl2);
        }
    }

    public void removeByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        final PSPFPubCode pSPFPubCode2 = pSPFPubCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewTemplServiceBase.this.onBeforeRemoveByPSPFPubCode(pSPFPubCode2);
                PSAppViewTemplServiceBase.this.internalRemoveByPSPFPubCode(pSPFPubCode2);
                PSAppViewTemplServiceBase.this.onAfterRemoveByPSPFPubCode(pSPFPubCode2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void internalRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSAppViewTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        this.onBeforeRemoveByPSPFPubCode(pSPFPubCode, arrayList);
        for (PSAppViewTempl pSAppViewTempl : arrayList) {
            this.remove(pSAppViewTempl);
        }
        this.onAfterRemoveByPSPFPubCode(pSPFPubCode, arrayList);
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSAppViewTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSAppViewTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppViewTempl pSAppViewTempl) throws Exception {
        super.onBeforeRemove(pSAppViewTempl);
    }

    protected void replaceParentInfo(PSAppViewTempl pSAppViewTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppViewTempl, cloneSession);
        if (pSAppViewTempl.getPSAppViewStyleId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEWSTYLE", (Object)pSAppViewTempl.getPSAppViewStyleId())) != null) {
            this.onFillParentInfo_PSAppViewStyle(pSAppViewTempl, (PSAppViewStyle)iEntity);
        }
        if (pSAppViewTempl.getPSPFPubCodeId() != null && (iEntity = cloneSession.getEntity("PSPFPUBCODE", (Object)pSAppViewTempl.getPSPFPubCodeId())) != null) {
            this.onFillParentInfo_PSPFPubCode(pSAppViewTempl, (PSPFPubCode)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppViewTempl pSAppViewTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppViewTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppViewTempl pSAppViewTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSAppViewTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewStyleId(bl, pSAppViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewTemplId(bl, pSAppViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewTemplName(bl, pSAppViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubCodeId(bl, pSAppViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSAppViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSAppViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSAppViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppViewTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppViewTempl pSAppViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewTempl.isMemoDirty() : !pSAppViewTempl.isMemoDirty()) {
            return null;
        }
        String string = pSAppViewTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppViewTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppViewStyleId(boolean bl, PSAppViewTempl pSAppViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewTempl.isPSAppViewStyleIdDirty() && !bl2 : !pSAppViewTempl.isPSAppViewStyleIdDirty()) {
            return null;
        }
        String string = pSAppViewTempl.getPSAppViewStyleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWSTYLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewStyleId_Default(pSAppViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewTemplId(boolean bl, PSAppViewTempl pSAppViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewTempl.isPSAppViewTemplIdDirty() && !bl2 : !pSAppViewTempl.isPSAppViewTemplIdDirty()) {
            return null;
        }
        String string = pSAppViewTempl.getPSAppViewTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewTemplId_Default(pSAppViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewTemplName(boolean bl, PSAppViewTempl pSAppViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewTempl.isPSAppViewTemplNameDirty() && !bl2 : !pSAppViewTempl.isPSAppViewTemplNameDirty()) {
            return null;
        }
        String string = pSAppViewTempl.getPSAppViewTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewTemplName_Default(pSAppViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubCodeId(boolean bl, PSAppViewTempl pSAppViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewTempl.isPSPFPubCodeIdDirty() && !bl2 : !pSAppViewTempl.isPSPFPubCodeIdDirty()) {
            return null;
        }
        String string = pSAppViewTempl.getPSPFPubCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubCodeId_Default(pSAppViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSAppViewTempl pSAppViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewTempl.isTemplCodeDirty() : !pSAppViewTempl.isTemplCodeDirty()) {
            return null;
        }
        String string = pSAppViewTempl.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default(pSAppViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSAppViewTempl pSAppViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewTempl.isTemplCode2Dirty() : !pSAppViewTempl.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSAppViewTempl.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default(pSAppViewTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSAppViewTempl pSAppViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewTempl.isUserParamsDirty() : !pSAppViewTempl.isUserParamsDirty()) {
            return null;
        }
        String string = pSAppViewTempl.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSAppViewTempl, bl2, bl3);
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

    protected void onSyncEntity(PSAppViewTempl pSAppViewTempl, boolean bl) throws Exception {
        super.onSyncEntity(pSAppViewTempl, bl);
    }

    protected void onSyncIndexEntities(PSAppViewTempl pSAppViewTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppViewTempl, bl);
    }

    public Object getDataContextValue(PSAppViewTempl pSAppViewTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppViewTempl, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSAppViewTempl pSAppViewTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppViewTempl, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSAppViewStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected boolean onMergeChild(String string, String string2, PSAppViewTempl pSAppViewTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppViewTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppViewTempl pSAppViewTempl) throws Exception {
        super.onUpdateParent(pSAppViewTempl);
    }

    @Override
    protected void exportCurXmlModel(PSAppViewTempl pSAppViewTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPVIEWTEMPL");
        if (!bl) {
            pSAppViewTempl.setCreateDate(null);
            pSAppViewTempl.setCreateMan(null);
            pSAppViewTempl.setPSAppViewTemplId(null);
            pSAppViewTempl.setTemplCode(null);
            pSAppViewTempl.setUpdateDate(null);
            pSAppViewTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSAppViewTempl, xmlNode, bl);
        }
    }
}

