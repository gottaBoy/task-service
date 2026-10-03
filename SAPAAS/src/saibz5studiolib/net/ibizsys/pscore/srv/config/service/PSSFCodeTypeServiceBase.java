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
import net.ibizsys.pscore.srv.config.dao.PSSFCodeTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFCodeTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeFolderBase;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTemplService;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFVerCodeService;
import net.ibizsys.pscore.srv.config.service.PSSFVerCodeServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFCodeTypeServiceBase
extends PSCoreSysServiceBase<PSSFCodeType> {
    private static final Log log = LogFactory.getLog(PSSFCodeTypeServiceBase.class);
    public static final String DATASET_CURSF = "CurSF";
    public static final String DATASET_CURSF2 = "CurSF2";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFCodeTypeDEModel pSSFCodeTypeDEModel;
    private PSSFCodeTypeDAO pSSFCodeTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService";
    }

    public PSSFCodeTypeDEModel getPSSFCodeTypeDEModel() {
        if (this.pSSFCodeTypeDEModel == null) {
            try {
                this.pSSFCodeTypeDEModel = (PSSFCodeTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFCodeTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFCodeTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFCodeTypeDEModel();
    }

    public PSSFCodeTypeDAO getPSSFCodeTypeDAO() {
        if (this.pSSFCodeTypeDAO == null) {
            try {
                this.pSSFCodeTypeDAO = (PSSFCodeTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFCodeTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFCodeTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFCodeTypeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSF, (boolean)true) == 0) {
            return this.fetchCurSF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSF2, (boolean)true) == 0) {
            return this.fetchCurSF2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSF2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSF2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSFCodeType pSSFCodeType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFCODETYPE_PSMODEL_PSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel = (PSModel)iService.getDEModel().createEntity();
            pSModel.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModel);
            } else {
                iService.get(pSModel);
            }
            this.onFillParentInfo_PSModel(pSSFCodeType, pSModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFCODETYPE_PSSFCODEFOLDER_PSSFCODEFOLDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFCodeFolderService", (SessionFactory)this.getSessionFactory());
            PSSFCodeFolder pSSFCodeFolder = (PSSFCodeFolder)iService.getDEModel().createEntity();
            pSSFCodeFolder.set("PSSFCODEFOLDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFCodeFolder);
            } else {
                iService.get(pSSFCodeFolder);
            }
            this.onFillParentInfo_PSSFCodeFolder(pSSFCodeType, pSSFCodeFolder);
            return;
        }
        super.onFillParentInfo(pSSFCodeType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModel(PSSFCodeType pSSFCodeType, PSModel pSModel) throws Exception {
        pSSFCodeType.setPSModelId(pSModel.getPSModelId());
        pSSFCodeType.setPSModelName(pSModel.getPSModelName());
    }

    protected void onFillParentInfo_PSSFCodeFolder(PSSFCodeType pSSFCodeType, PSSFCodeFolder pSSFCodeFolder) throws Exception {
        pSSFCodeType.setPSSFCodeFolderId(pSSFCodeFolder.getPSSFCodeFolderId());
        pSSFCodeType.setPSSFCodeFolderName(pSSFCodeFolder.getPSSFCodeFolderName());
        pSSFCodeType.setPSSFStyleId(pSSFCodeFolder.getPSSFStyleId());
        pSSFCodeType.setPSSFStyleName(pSSFCodeFolder.getPSSFStyleName());
    }

    protected void onFillEntityFullInfo(PSSFCodeType pSSFCodeType, boolean bl) throws Exception {
        if (bl && pSSFCodeType.getValidFlag() == null) {
            pSSFCodeType.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSFCodeType, bl);
        this.onFillEntityFullInfo_PSModel(pSSFCodeType, bl);
        this.onFillEntityFullInfo_PSSFCodeFolder(pSSFCodeType, bl);
    }

    protected void onFillEntityFullInfo_PSModel(PSSFCodeType pSSFCodeType, boolean bl) throws Exception {
        if (pSSFCodeType.isPSModelIdDirty()) {
            if (pSSFCodeType.getPSModelId() != null) {
                if (pSSFCodeType.getPSModelId() == null || pSSFCodeType.getPSModelName() == null) {
                    PSModel pSModel = pSSFCodeType.getPSModel();
                    pSSFCodeType.setPSModelName(pSModel.getPSModelName());
                }
            } else {
                pSSFCodeType.setPSModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFCodeFolder(PSSFCodeType pSSFCodeType, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFCodeType pSSFCodeType, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFCodeType, bl);
    }

    public ArrayList<PSSFCodeType> selectByPSModel(PSModelBase pSModelBase) throws Exception {
        return this.selectByPSModel(pSModelBase, "", -1);
    }

    public ArrayList<PSSFCodeType> selectByPSModel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByPSModel(pSModelBase, string, -1);
    }

    public ArrayList<PSSFCodeType> selectByPSModel(PSModelBase pSModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELID", (Object)pSModelBase.getPSModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFCodeType> selectByPSSFCodeFolder(PSSFCodeFolderBase pSSFCodeFolderBase) throws Exception {
        return this.selectByPSSFCodeFolder(pSSFCodeFolderBase, "", -1);
    }

    public ArrayList<PSSFCodeType> selectByPSSFCodeFolder(PSSFCodeFolderBase pSSFCodeFolderBase, String string) throws Exception {
        return this.selectByPSSFCodeFolder(pSSFCodeFolderBase, string, -1);
    }

    public ArrayList<PSSFCodeType> selectByPSSFCodeFolder(PSSFCodeFolderBase pSSFCodeFolderBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFCODEFOLDERID", (Object)pSSFCodeFolderBase.getPSSFCodeFolderId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCodeFolderCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCodeFolderCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    public void resetPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSSFCodeType> arrayList = this.selectByPSModel(pSModel);
        for (PSSFCodeType pSSFCodeType : arrayList) {
            PSSFCodeType pSSFCodeType2 = (PSSFCodeType)this.getDEModel().createEntity();
            pSSFCodeType2.setPSSFCodeTypeId(pSSFCodeType.getPSSFCodeTypeId());
            pSSFCodeType2.setPSModelId(null);
            this.update(pSSFCodeType2);
        }
    }

    public void removeByPSModel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFCodeTypeServiceBase.this.onBeforeRemoveByPSModel(pSModel2);
                PSSFCodeTypeServiceBase.this.internalRemoveByPSModel(pSModel2);
                PSSFCodeTypeServiceBase.this.onAfterRemoveByPSModel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSSFCodeType> arrayList = this.selectByPSModel(pSModel);
        this.onBeforeRemoveByPSModel(pSModel, arrayList);
        for (PSSFCodeType pSSFCodeType : arrayList) {
            this.remove(pSSFCodeType);
        }
        this.onAfterRemoveByPSModel(pSModel, arrayList);
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel, ArrayList<PSSFCodeType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel, ArrayList<PSSFCodeType> arrayList) throws Exception {
    }

    public void testRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
    }

    public void resetPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
        ArrayList<PSSFCodeType> arrayList = this.selectByPSSFCodeFolder(pSSFCodeFolder);
        for (PSSFCodeType pSSFCodeType : arrayList) {
            PSSFCodeType pSSFCodeType2 = (PSSFCodeType)this.getDEModel().createEntity();
            pSSFCodeType2.setPSSFCodeTypeId(pSSFCodeType.getPSSFCodeTypeId());
            pSSFCodeType2.setPSSFCodeFolderId(null);
            this.update(pSSFCodeType2);
        }
    }

    public void removeByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
        final PSSFCodeFolder pSSFCodeFolder2 = pSSFCodeFolder;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFCodeTypeServiceBase.this.onBeforeRemoveByPSSFCodeFolder(pSSFCodeFolder2);
                PSSFCodeTypeServiceBase.this.internalRemoveByPSSFCodeFolder(pSSFCodeFolder2);
                PSSFCodeTypeServiceBase.this.onAfterRemoveByPSSFCodeFolder(pSSFCodeFolder2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
    }

    protected void internalRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
        ArrayList<PSSFCodeType> arrayList = this.selectByPSSFCodeFolder(pSSFCodeFolder);
        this.onBeforeRemoveByPSSFCodeFolder(pSSFCodeFolder, arrayList);
        for (PSSFCodeType pSSFCodeType : arrayList) {
            this.remove(pSSFCodeType);
        }
        this.onAfterRemoveByPSSFCodeFolder(pSSFCodeFolder, arrayList);
    }

    protected void onAfterRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
    }

    protected void onBeforeRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder, ArrayList<PSSFCodeType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder, ArrayList<PSSFCodeType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFCodeType pSSFCodeType) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSFCodeTemplService)ServiceGlobal.getService(PSSFCodeTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFCodeTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSFCodeType(pSSFCodeType);
        ((PSSFCodeTemplServiceBase)pSCoreSysServiceBase).removeByPSSFCodeType(pSSFCodeType);
        pSCoreSysServiceBase = (PSSFVerCodeService)ServiceGlobal.getService(PSSFVerCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFVerCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSFCodeType(pSSFCodeType);
        pSCoreSysServiceBase = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSFCodeType(pSSFCodeType);
        super.onBeforeRemove(pSSFCodeType);
    }

    protected void replaceParentInfo(PSSFCodeType pSSFCodeType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFCodeType, cloneSession);
        if (pSSFCodeType.getPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSSFCodeType.getPSModelId())) != null) {
            this.onFillParentInfo_PSModel(pSSFCodeType, (PSModel)iEntity);
        }
        if (pSSFCodeType.getPSSFCodeFolderId() != null && (iEntity = cloneSession.getEntity("PSSFCODEFOLDER", (Object)pSSFCodeType.getPSSFCodeFolderId())) != null) {
            this.onFillParentInfo_PSSFCodeFolder(pSSFCodeType, (PSSFCodeFolder)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFCodeType pSSFCodeType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFCodeType, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodePath(bl, pSSFCodeType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeTempl(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DebugMode(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultPub(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileExt(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileName(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullCodeName(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GlobalFlag(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderCode(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelList(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeFolderId(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeTypeId(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeTypeName(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SecurityTempl(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplDesc(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeCode(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSFCodeType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFCodeType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodePath(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isCodePathDirty() : !pSSFCodeType.isCodePathDirty()) {
            return null;
        }
        String string = pSSFCodeType.getCodePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodePath_Default(pSSFCodeType, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeTempl(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isCodeTemplDirty() && !bl2 : !pSSFCodeType.isCodeTemplDirty()) {
            return null;
        }
        String string = pSSFCodeType.getCodeTempl();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODETEMPL");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeTempl_Default(pSSFCodeType, bl2, bl3);
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

    protected EntityFieldError onCheckField_DebugMode(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isDebugModeDirty() : !pSSFCodeType.isDebugModeDirty()) {
            return null;
        }
        Integer n = pSSFCodeType.getDebugMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DebugMode_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEBUGMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultPub(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isDefaultPubDirty() : !pSSFCodeType.isDefaultPubDirty()) {
            return null;
        }
        Integer n = pSSFCodeType.getDefaultPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultPub_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileExt(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isFileExtDirty() && !bl2 : !pSSFCodeType.isFileExtDirty()) {
            return null;
        }
        String string = pSSFCodeType.getFileExt();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILEEXT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileExt_Default(pSSFCodeType, bl2, bl3);
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

    protected EntityFieldError onCheckField_FileName(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isFileNameDirty() : !pSSFCodeType.isFileNameDirty()) {
            return null;
        }
        String string = pSSFCodeType.getFileName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileName_Default(pSSFCodeType, bl2, bl3);
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

    protected EntityFieldError onCheckField_FullCodeName(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isFullCodeNameDirty() : !pSSFCodeType.isFullCodeNameDirty()) {
            return null;
        }
        String string = pSSFCodeType.getFullCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullCodeName_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GlobalFlag(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isGlobalFlagDirty() : !pSSFCodeType.isGlobalFlagDirty()) {
            return null;
        }
        Integer n = pSSFCodeType.getGlobalFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GlobalFlag_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GLOBALFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderCode(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isHeaderCodeDirty() : !pSSFCodeType.isHeaderCodeDirty()) {
            return null;
        }
        String string = pSSFCodeType.getHeaderCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderCode_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isMemoDirty() : !pSSFCodeType.isMemoDirty()) {
            return null;
        }
        String string = pSSFCodeType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFCodeType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelList(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isModelListDirty() : !pSSFCodeType.isModelListDirty()) {
            return null;
        }
        String string = pSSFCodeType.getModelList();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelList_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELLIST");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isOrderValueDirty() : !pSSFCodeType.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSFCodeType.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSFCodeType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isPSModelIdDirty() : !pSSFCodeType.isPSModelIdDirty()) {
            return null;
        }
        String string = pSSFCodeType.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isPSModelNameDirty() : !pSSFCodeType.isPSModelNameDirty()) {
            return null;
        }
        String string = pSSFCodeType.getPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFCodeFolderId(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isPSSFCodeFolderIdDirty() && !bl2 : !pSSFCodeType.isPSSFCodeFolderIdDirty()) {
            return null;
        }
        String string = pSSFCodeType.getPSSFCodeFolderId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODEFOLDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeFolderId_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODEFOLDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFCodeTypeId(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isPSSFCodeTypeIdDirty() && !bl2 : !pSSFCodeType.isPSSFCodeTypeIdDirty()) {
            return null;
        }
        String string = pSSFCodeType.getPSSFCodeTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeTypeId_Default(pSSFCodeType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFCodeTypeName(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isPSSFCodeTypeNameDirty() && !bl2 : !pSSFCodeType.isPSSFCodeTypeNameDirty()) {
            return null;
        }
        String string = pSSFCodeType.getPSSFCodeTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeTypeName_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isPubObjDirty() && !bl2 : !pSSFCodeType.isPubObjDirty()) {
            return null;
        }
        String string = pSSFCodeType.getPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SecurityTempl(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isSecurityTemplDirty() : !pSSFCodeType.isSecurityTemplDirty()) {
            return null;
        }
        Integer n = pSSFCodeType.getSecurityTempl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SecurityTempl_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECURITYTEMPL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isTemplCode2Dirty() : !pSSFCodeType.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSSFCodeType.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default(pSSFCodeType, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplDesc(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isTemplDescDirty() : !pSSFCodeType.isTemplDescDirty()) {
            return null;
        }
        String string = pSSFCodeType.getTemplDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplDesc_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeCode(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isTypeCodeDirty() && !bl2 : !pSSFCodeType.isTypeCodeDirty()) {
            return null;
        }
        String string = pSSFCodeType.getTypeCode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPECODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeCode_Default(pSSFCodeType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPECODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSFSTYLEID";
                String string4 = this.checkFieldDupRule(this.getPSSFCodeTypeDEModel(), "TYPECODE", string3, pSSFCodeType, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("TYPECODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSFCodeType pSSFCodeType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeType.isValidFlagDirty() && !bl2 : !pSSFCodeType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSFCodeType.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSFCodeType, bl2, bl3);
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

    protected void onSyncEntity(PSSFCodeType pSSFCodeType, boolean bl) throws Exception {
        super.onSyncEntity(pSSFCodeType, bl);
    }

    protected void onSyncIndexEntities(PSSFCodeType pSSFCodeType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFCodeType, bl);
    }

    public Object getDataContextValue(PSSFCodeType pSSFCodeType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFCodeType, string, iDataContextParam)) != null) {
            return object;
        }
        PSSFCodeFolder pSSFCodeFolder = pSSFCodeType.getPSSFCodeFolder();
        if (pSSFCodeFolder != null && pSSFCodeFolder.contains(string)) {
            return pSSFCodeFolder.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSFCodeType pSSFCodeType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFCodeType, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DEBUGMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DebugMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILEEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileExt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GLOBALFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GlobalFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELLIST", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelList_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODEFOLDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeFolderId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODEFOLDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeFolderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECURITYTEMPL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SecurityTempl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplDesc_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DebugMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DefaultPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_FullCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLCODENAME", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GlobalFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HeaderCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERCODE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_ModelList_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELLIST", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSFCodeFolderName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODEFOLDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SecurityTempl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_TemplDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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
            if (this.checkFieldStringLengthRule("TYPECODE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("TYPECODE", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected boolean onMergeChild(String string, String string2, PSSFCodeType pSSFCodeType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFCodeType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFCodeType pSSFCodeType) throws Exception {
        super.onUpdateParent(pSSFCodeType);
    }

    @Override
    protected void exportCurXmlModel(PSSFCodeType pSSFCodeType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFCODETYPE");
        if (!bl) {
            pSSFCodeType.setCreateDate(null);
            pSSFCodeType.setCreateMan(null);
            pSSFCodeType.setPSSFCodeTypeId(null);
            pSSFCodeType.setPSSFStyleId(null);
            pSSFCodeType.setUpdateDate(null);
            pSSFCodeType.setUpdateMan(null);
            super.exportCurXmlModel(pSSFCodeType, xmlNode, bl);
        }
    }
}

