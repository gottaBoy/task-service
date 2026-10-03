/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
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
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLanService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLanServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSLanguageDAO;
import net.ibizsys.pscore.srv.config.demodel.PSLanguageDEModel;
import net.ibizsys.pscore.srv.config.entity.PSLanguage;
import net.ibizsys.pscore.srv.config.service.PSSysLanItemService;
import net.ibizsys.pscore.srv.config.service.PSSysLanItemServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSLanguageServiceBase
extends PSCoreSysServiceBase<PSLanguage> {
    private static final Log log = LogFactory.getLog(PSLanguageServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSLanguageDEModel pSLanguageDEModel;
    private PSLanguageDAO pSLanguageDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSLanguageService";
    }

    public PSLanguageDEModel getPSLanguageDEModel() {
        if (this.pSLanguageDEModel == null) {
            try {
                this.pSLanguageDEModel = (PSLanguageDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSLanguageDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSLanguageDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSLanguageDEModel();
    }

    public PSLanguageDAO getPSLanguageDAO() {
        if (this.pSLanguageDAO == null) {
            try {
                this.pSLanguageDAO = (PSLanguageDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSLanguageDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSLanguageDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSLanguageDAO();
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

    protected void onFillParentInfo(PSLanguage pSLanguage, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSLANGUAGE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSLanguage, pSSystem);
            return;
        }
        super.onFillParentInfo(pSLanguage, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSystem(PSLanguage pSLanguage, PSSystem pSSystem) throws Exception {
        pSLanguage.setPSSystemId(pSSystem.getPSSystemId());
        pSLanguage.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSLanguage pSLanguage, boolean bl) throws Exception {
        if (bl && pSLanguage.getValidFlag() == null) {
            pSLanguage.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSLanguage, bl);
        this.onFillEntityFullInfo_PSSystem(pSLanguage, bl);
    }

    protected void onFillEntityFullInfo_PSSystem(PSLanguage pSLanguage, boolean bl) throws Exception {
        if (pSLanguage.isPSSystemIdDirty()) {
            if (pSLanguage.getPSSystemId() != null) {
                if (pSLanguage.getPSSystemId() == null || pSLanguage.getPSSystemName() == null) {
                    PSSystem pSSystem = pSLanguage.getPSSystem();
                    pSLanguage.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSLanguage.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSLanguage pSLanguage, boolean bl) throws Exception {
        super.onWriteBackParent(pSLanguage, bl);
    }

    public ArrayList<PSLanguage> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSLanguage> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSLanguage> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSLanguage> arrayList = this.selectByPSSystem(pSSystem);
        for (PSLanguage pSLanguage : arrayList) {
            PSLanguage pSLanguage2 = (PSLanguage)this.getDEModel().createEntity();
            pSLanguage2.setPSLanguageId(pSLanguage.getPSLanguageId());
            pSLanguage2.setPSSystemId(null);
            this.update(pSLanguage2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSLanguageServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSLanguageServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSLanguageServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSLanguage> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSLanguage pSLanguage : arrayList) {
            this.remove(pSLanguage);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSLanguage> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSLanguage> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSLanguage pSLanguage) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLanServiceBase)pSCoreSysServiceBase).testRemoveByPSLanguage(pSLanguage);
        pSCoreSysServiceBase = (PSLanguageItemService)ServiceGlobal.getService(PSLanguageItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSLanguageItemServiceBase)pSCoreSysServiceBase).testRemoveByPSLanguage(pSLanguage);
        pSCoreSysServiceBase = (PSSysLanItemService)ServiceGlobal.getService(PSSysLanItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysLanItemServiceBase)pSCoreSysServiceBase).testRemoveByPSLanguage(pSLanguage);
        pSCoreSysServiceBase = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSystemServiceBase)pSCoreSysServiceBase).testRemoveByPSLanguage(pSLanguage);
        super.onBeforeRemove(pSLanguage);
    }

    protected void replaceParentInfo(PSLanguage pSLanguage, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSLanguage, cloneSession);
        if (pSLanguage.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSLanguage.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSLanguage, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSLanguage pSLanguage, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSLanguage, bl);
    }

    protected void onCheckEntity(boolean bl, PSLanguage pSLanguage, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSLanguage, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSLanguageId(bl, pSLanguage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSLanguageName(bl, pSLanguage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSLanguage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSLanguage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSLanguage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSLanguage, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSLanguage pSLanguage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguage.isMemoDirty() : !pSLanguage.isMemoDirty()) {
            return null;
        }
        String string = pSLanguage.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSLanguage, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSLanguageId(boolean bl, PSLanguage pSLanguage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguage.isPSLanguageIdDirty() && !bl2 : !pSLanguage.isPSLanguageIdDirty()) {
            return null;
        }
        String string = pSLanguage.getPSLanguageId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSLanguageId_Default(pSLanguage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSLanguageName(boolean bl, PSLanguage pSLanguage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguage.isPSLanguageNameDirty() && !bl2 : !pSLanguage.isPSLanguageNameDirty()) {
            return null;
        }
        String string = pSLanguage.getPSLanguageName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSLanguageName_Default(pSLanguage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSLanguage pSLanguage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguage.isPSSystemIdDirty() : !pSLanguage.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSLanguage.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSLanguage, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSLanguage pSLanguage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguage.isPSSystemNameDirty() : !pSLanguage.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSLanguage.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSLanguage, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSLanguage pSLanguage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguage.isValidFlagDirty() && !bl2 : !pSLanguage.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSLanguage.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSLanguage, bl2, bl3);
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

    protected void onSyncEntity(PSLanguage pSLanguage, boolean bl) throws Exception {
        super.onSyncEntity(pSLanguage, bl);
    }

    protected void onSyncIndexEntities(PSLanguage pSLanguage, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSLanguage, bl);
    }

    public Object getDataContextValue(PSLanguage pSLanguage, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSLanguage, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSLanguage pSLanguage, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSLanguage, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSLANGUAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSLanguageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSLANGUAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSLanguageName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSLanguageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSLANGUAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSLanguageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSLANGUAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSLanguage pSLanguage) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSLanguage)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSLanguage pSLanguage) throws Exception {
        super.onUpdateParent(pSLanguage);
    }

    @Override
    protected void exportCurXmlModel(PSLanguage pSLanguage, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSLANGUAGE");
        if (!bl) {
            pSLanguage.setCreateDate(null);
            pSLanguage.setCreateMan(null);
            pSLanguage.setUpdateDate(null);
            pSLanguage.setUpdateMan(null);
            super.exportCurXmlModel(pSLanguage, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSLanguage pSLanguage, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSLanguage, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSLANGUAGE_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSLanguage pSLanguage) {
        return super.getModelV2Tag(pSLanguage);
    }

    @Override
    public boolean setModelV2Tag(PSLanguage pSLanguage, String string) {
        return super.setModelV2Tag(pSLanguage, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSLanguage pSLanguage, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSLanguage.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSLanguage, true);
        return super.getModelV2Entity(pSLanguage, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSLanguage pSLanguage, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSLanguage, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSLANGUAGEITEM_PSLANGUAGE_PSLANGUAGEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSLanguage pSLanguage, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSLANGUAGEITEM_PSLANGUAGE_PSLANGUAGEID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSLANGUAGE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSLANGUAGEITEM", (Object)pSLanguage.getPSLanguageId()))).exists()) {
            PSLanguageItemService pSLanguageItemService = (PSLanguageItemService)ServiceGlobal.getService(PSLanguageItemService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSLanguageItemService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSLanguageItem pSLanguageItem = new PSLanguageItem();
                PSModelV2Helper.fromJSONObject((IDataObject)pSLanguageItem, objectNode, false);
                String string6 = pSLanguageItemService.getModelV2Tag(pSLanguageItem);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSLANGUAGEITEM", (Object)pSLanguageItem.getPSLanguageItemId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSLanguageItemService.exportModelV2(pSLanguageItem, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSLanguage, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSLanguage pSLanguage, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSLANGUAGEITEM_PSLANGUAGE_PSLANGUAGEID")) {
            PSLanguageItemService pSLanguageItemService = (PSLanguageItemService)ServiceGlobal.getService(PSLanguageItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> items = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSLANGUAGE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSLANGUAGEITEM", (Object)pSLanguage.getPSLanguageId()));
                if (file.exists()) {
                    items = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        items.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                items = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSLANGUAGE#%1$s", (Object)pSLanguage.getPSLanguageId());
                for (PSLanguageItem item : pSLanguageItemService.selectByPSLanguage(pSLanguage)) {
                    if (StringHelper.compare(scope, pSLanguageItemService.getModelV2ResScope(item), false) != 0) continue;
                    items.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (items != null && !items.isEmpty()) {
                ArrayNode children = objectNode.putArray(pSLanguageItemService.getModelV2Name(false).toLowerCase());
                Collections.sort(items, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("pslanguageitemname")) {
                            string = objectNode.get("pslanguageitemname").asText();
                        }
                        if (objectNode2.has("pslanguageitemname")) {
                            string2 = objectNode2.get("pslanguageitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode itemNode : items) {
                    PSLanguageItem item = new PSLanguageItem();
                    PSModelV2Helper.fromJSONObject(item, itemNode, false);
                    children.add(pSLanguageItemService.exportModelV2(item, string));
                }
            }
        }
        super.onExportCurModelV2(pSLanguage, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSLanguage pSLanguage) throws Exception {
        super.onEmptyModelV2(pSLanguage);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSLanguageItemService pSLanguageItemService = (PSLanguageItemService)ServiceGlobal.getService(PSLanguageItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSLanguageItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSLanguage pSLanguage, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSLanguageItem pSLanguageItem = new PSLanguageItem();
        pSLanguageItem.set("PSLANGUAGEID", pSLanguage.getPSLanguageId());
        PSLanguageItemService pSLanguageItemService = (PSLanguageItemService)ServiceGlobal.getService(PSLanguageItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSLanguageItemService.getModelV2Entity(pSLanguageItem, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSLanguage, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSLanguage pSLanguage, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSLanguageServiceBase.isSimpleImportExportMode("")) {
            PSLanguageItemService pSLanguageItemService = (PSLanguageItemService)ServiceGlobal.getService(PSLanguageItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSLanguageItemService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSLanguageItem pSLanguageItem = new PSLanguageItem();
                    pSLanguageItem.setPSLanguageId(pSLanguage.getPSLanguageId());
                    pSLanguageItem.setPSLanguageName(pSLanguage.getPSLanguageName());
                    pSLanguageItemService.compileModelV2(pSLanguageItem, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSLanguageItem pSLanguageItem = new PSLanguageItem();
                        pSLanguageItem.setPSLanguageId(pSLanguage.getPSLanguageId());
                        pSLanguageItem.setPSLanguageName(pSLanguage.getPSLanguageName());
                        pSLanguageItemService.compileModelV2(pSLanguageItem, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSLanguage, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSLanguage pSLanguage, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSLanguage, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSLanguage pSLanguage, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSLanguage, list);
    }
}
