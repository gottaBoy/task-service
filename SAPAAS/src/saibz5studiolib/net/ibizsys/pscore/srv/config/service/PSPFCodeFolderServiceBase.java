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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSPFCodeFolderDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFCodeFolderDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFCodeFolder;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFCodeFolderServiceBase
extends PSCoreSysServiceBase<PSPFCodeFolder> {
    private static final Log log = LogFactory.getLog(PSPFCodeFolderServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFCodeFolderDEModel pSPFCodeFolderDEModel;
    private PSPFCodeFolderDAO pSPFCodeFolderDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFCodeFolderService";
    }

    public PSPFCodeFolderDEModel getPSPFCodeFolderDEModel() {
        if (this.pSPFCodeFolderDEModel == null) {
            try {
                this.pSPFCodeFolderDEModel = (PSPFCodeFolderDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFCodeFolderDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFCodeFolderDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFCodeFolderDEModel();
    }

    public PSPFCodeFolderDAO getPSPFCodeFolderDAO() {
        if (this.pSPFCodeFolderDAO == null) {
            try {
                this.pSPFCodeFolderDAO = (PSPFCodeFolderDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFCodeFolderDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFCodeFolderDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFCodeFolderDAO();
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

    protected void onFillParentInfo(PSPFCodeFolder pSPFCodeFolder, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFCODEFOLDER_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSSF(pSPFCodeFolder, pSPF);
            return;
        }
        super.onFillParentInfo(pSPFCodeFolder, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSF(PSPFCodeFolder pSPFCodeFolder, PSPF pSPF) throws Exception {
        pSPFCodeFolder.setPSPFId(pSPF.getPSPFId());
        pSPFCodeFolder.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillEntityFullInfo(PSPFCodeFolder pSPFCodeFolder, boolean bl) throws Exception {
        if (bl && pSPFCodeFolder.getValidFlag() == null) {
            pSPFCodeFolder.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSPFCodeFolder, bl);
        this.onFillEntityFullInfo_PSSF(pSPFCodeFolder, bl);
    }

    protected void onFillEntityFullInfo_PSSF(PSPFCodeFolder pSPFCodeFolder, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPFCodeFolder pSPFCodeFolder, boolean bl) throws Exception {
        super.onWriteBackParent(pSPFCodeFolder, bl);
    }

    public ArrayList<PSPFCodeFolder> selectByPSSF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSSF(pSPFBase, "", -1);
    }

    public ArrayList<PSPFCodeFolder> selectByPSSF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSSF(pSPFBase, string, -1);
    }

    public ArrayList<PSPFCodeFolder> selectByPSSF(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
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

    public void testRemoveByPSSF(PSPF pSPF) throws Exception {
    }

    public void resetPSSF(PSPF pSPF) throws Exception {
        ArrayList<PSPFCodeFolder> arrayList = this.selectByPSSF(pSPF);
        for (PSPFCodeFolder pSPFCodeFolder : arrayList) {
            PSPFCodeFolder pSPFCodeFolder2 = (PSPFCodeFolder)this.getDEModel().createEntity();
            pSPFCodeFolder2.setPSPFCodeFolderId(pSPFCodeFolder.getPSPFCodeFolderId());
            pSPFCodeFolder2.setPSPFId(null);
            this.update(pSPFCodeFolder2);
        }
    }

    public void removeByPSSF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFCodeFolderServiceBase.this.onBeforeRemoveByPSSF(pSPF2);
                PSPFCodeFolderServiceBase.this.internalRemoveByPSSF(pSPF2);
                PSPFCodeFolderServiceBase.this.onAfterRemoveByPSSF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSPF pSPF) throws Exception {
        ArrayList<PSPFCodeFolder> arrayList = this.selectByPSSF(pSPF);
        this.onBeforeRemoveByPSSF(pSPF, arrayList);
        for (PSPFCodeFolder pSPFCodeFolder : arrayList) {
            this.remove(pSPFCodeFolder);
        }
        this.onAfterRemoveByPSSF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSPF pSPF, ArrayList<PSPFCodeFolder> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSPF pSPF, ArrayList<PSPFCodeFolder> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFCodeFolder pSPFCodeFolder) throws Exception {
        PSPFPubCodeService pSPFPubCodeService = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)this.getSessionFactory());
        pSPFPubCodeService.testRemoveByPSPFCodeFolder(pSPFCodeFolder);
        super.onBeforeRemove(pSPFCodeFolder);
    }

    protected void replaceParentInfo(PSPFCodeFolder pSPFCodeFolder, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPFCodeFolder, cloneSession);
        if (pSPFCodeFolder.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFCodeFolder.getPSPFId())) != null) {
            this.onFillParentInfo_PSSF(pSPFCodeFolder, (PSPF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFCodeFolder pSPFCodeFolder, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPFCodeFolder, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFCodeFolder pSPFCodeFolder, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_FolderName(bl, pSPFCodeFolder, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjFolder(bl, pSPFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjType(bl, pSPFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFCodeFolderId(bl, pSPFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFCodeFolderName(bl, pSPFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSPFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPFCodeFolder, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_FolderName(boolean bl, PSPFCodeFolder pSPFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCodeFolder.isFolderNameDirty() && !bl2 : !pSPFCodeFolder.isFolderNameDirty()) {
            return null;
        }
        String string = pSPFCodeFolder.getFolderName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FOLDERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FolderName_Default(pSPFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FOLDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFCodeFolder pSPFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCodeFolder.isMemoDirty() : !pSPFCodeFolder.isMemoDirty()) {
            return null;
        }
        String string = pSPFCodeFolder.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPFCodeFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_PrjFolder(boolean bl, PSPFCodeFolder pSPFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCodeFolder.isPrjFolderDirty() : !pSPFCodeFolder.isPrjFolderDirty()) {
            return null;
        }
        String string = pSPFCodeFolder.getPrjFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrjFolder_Default(pSPFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrjType(boolean bl, PSPFCodeFolder pSPFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCodeFolder.isPrjTypeDirty() : !pSPFCodeFolder.isPrjTypeDirty()) {
            return null;
        }
        String string = pSPFCodeFolder.getPrjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrjType_Default(pSPFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFCodeFolderId(boolean bl, PSPFCodeFolder pSPFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCodeFolder.isPSPFCodeFolderIdDirty() && !bl2 : !pSPFCodeFolder.isPSPFCodeFolderIdDirty()) {
            return null;
        }
        String string = pSPFCodeFolder.getPSPFCodeFolderId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCODEFOLDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFCodeFolderId_Default(pSPFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCODEFOLDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFCodeFolderName(boolean bl, PSPFCodeFolder pSPFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCodeFolder.isPSPFCodeFolderNameDirty() && !bl2 : !pSPFCodeFolder.isPSPFCodeFolderNameDirty()) {
            return null;
        }
        String string = pSPFCodeFolder.getPSPFCodeFolderName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCODEFOLDERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFCodeFolderName_Default(pSPFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCODEFOLDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFCodeFolder pSPFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCodeFolder.isPSPFIdDirty() && !bl2 : !pSPFCodeFolder.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFCodeFolder.getPSPFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSPFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSPFCodeFolder pSPFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCodeFolder.isValidFlagDirty() : !pSPFCodeFolder.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSPFCodeFolder.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSPFCodeFolder, bl2, bl3);
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

    protected void onSyncEntity(PSPFCodeFolder pSPFCodeFolder, boolean bl) throws Exception {
        super.onSyncEntity(pSPFCodeFolder, bl);
    }

    protected void onSyncIndexEntities(PSPFCodeFolder pSPFCodeFolder, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPFCodeFolder, bl);
    }

    public Object getDataContextValue(PSPFCodeFolder pSPFCodeFolder, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPFCodeFolder, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPFCodeFolder pSPFCodeFolder, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPFCodeFolder, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FOLDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FolderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRJFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFCODEFOLDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFCodeFolderId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFCODEFOLDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFCodeFolderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FolderName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FOLDERNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_PrjFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRJFOLDER", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRJTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFCodeFolderId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFCODEFOLDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFCodeFolderName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFCODEFOLDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPFCodeFolder pSPFCodeFolder) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPFCodeFolder)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFCodeFolder pSPFCodeFolder) throws Exception {
        super.onUpdateParent(pSPFCodeFolder);
    }

    @Override
    protected void exportCurXmlModel(PSPFCodeFolder pSPFCodeFolder, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFCODEFOLDER");
        if (!bl) {
            pSPFCodeFolder.setCreateDate(null);
            pSPFCodeFolder.setCreateMan(null);
            pSPFCodeFolder.setPSPFCodeFolderId(null);
            pSPFCodeFolder.setUpdateDate(null);
            pSPFCodeFolder.setUpdateMan(null);
            super.exportCurXmlModel(pSPFCodeFolder, xmlNode, bl);
        }
    }
}

