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
import net.ibizsys.pscore.srv.config.dao.PSSFCodeFolderDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFCodeFolderDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStylePrj;
import net.ibizsys.pscore.srv.config.entity.PSSFStylePrjBase;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTypeServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFCodeFolderServiceBase
extends PSCoreSysServiceBase<PSSFCodeFolder> {
    private static final Log log = LogFactory.getLog(PSSFCodeFolderServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFCodeFolderDEModel pSSFCodeFolderDEModel;
    private PSSFCodeFolderDAO pSSFCodeFolderDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFCodeFolderService";
    }

    public PSSFCodeFolderDEModel getPSSFCodeFolderDEModel() {
        if (this.pSSFCodeFolderDEModel == null) {
            try {
                this.pSSFCodeFolderDEModel = (PSSFCodeFolderDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFCodeFolderDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFCodeFolderDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFCodeFolderDEModel();
    }

    public PSSFCodeFolderDAO getPSSFCodeFolderDAO() {
        if (this.pSSFCodeFolderDAO == null) {
            try {
                this.pSSFCodeFolderDAO = (PSSFCodeFolderDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFCodeFolderDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFCodeFolderDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFCodeFolderDAO();
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

    protected void onFillParentInfo(PSSFCodeFolder pSSFCodeFolder, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFCODEFOLDER_PSSFSTYLEPRJ_PSSFSTYLEPRJID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStylePrjService", (SessionFactory)this.getSessionFactory());
            PSSFStylePrj pSSFStylePrj = (PSSFStylePrj)iService.getDEModel().createEntity();
            pSSFStylePrj.set("PSSFSTYLEPRJID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStylePrj);
            } else {
                iService.get((IEntity)pSSFStylePrj);
            }
            this.onFillParentInfo_PSSFStylePrj(pSSFCodeFolder, pSSFStylePrj);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFCODEFOLDER_PSSFSTYLE_PSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStyle);
            } else {
                iService.get((IEntity)pSSFStyle);
            }
            this.onFillParentInfo_PSSFStyle(pSSFCodeFolder, pSSFStyle);
            return;
        }
        super.onFillParentInfo((IEntity)pSSFCodeFolder, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFStylePrj(PSSFCodeFolder pSSFCodeFolder, PSSFStylePrj pSSFStylePrj) throws Exception {
        pSSFCodeFolder.setPSSFStylePrjId(pSSFStylePrj.getPSSFStylePrjId());
        pSSFCodeFolder.setPSSFStylePrjName(pSSFStylePrj.getPSSFStylePrjName());
    }

    protected void onFillParentInfo_PSSFStyle(PSSFCodeFolder pSSFCodeFolder, PSSFStyle pSSFStyle) throws Exception {
        pSSFCodeFolder.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSSFCodeFolder.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillEntityFullInfo(PSSFCodeFolder pSSFCodeFolder, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSFCodeFolder, bl);
        this.onFillEntityFullInfo_PSSFStylePrj(pSSFCodeFolder, bl);
        this.onFillEntityFullInfo_PSSFStyle(pSSFCodeFolder, bl);
    }

    protected void onFillEntityFullInfo_PSSFStylePrj(PSSFCodeFolder pSSFCodeFolder, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSFStyle(PSSFCodeFolder pSSFCodeFolder, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFCodeFolder pSSFCodeFolder, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSFCodeFolder, bl);
    }

    public ArrayList<PSSFCodeFolder> selectByPSSFStylePrj(PSSFStylePrjBase pSSFStylePrjBase) throws Exception {
        return this.selectByPSSFStylePrj(pSSFStylePrjBase, "", -1);
    }

    public ArrayList<PSSFCodeFolder> selectByPSSFStylePrj(PSSFStylePrjBase pSSFStylePrjBase, String string) throws Exception {
        return this.selectByPSSFStylePrj(pSSFStylePrjBase, string, -1);
    }

    public ArrayList<PSSFCodeFolder> selectByPSSFStylePrj(PSSFStylePrjBase pSSFStylePrjBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEPRJID", (Object)pSSFStylePrjBase.getPSSFStylePrjId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStylePrjCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStylePrjCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFCodeFolder> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSFCodeFolder> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSFCodeFolder> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFStylePrj(PSSFStylePrj pSSFStylePrj) throws Exception {
        ArrayList<PSSFCodeFolder> arrayList = this.selectByPSSFStylePrj(pSSFStylePrj, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFSTYLEPRJ");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSFStylePrj);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFCODEFOLDER_PSSFSTYLEPRJ_PSSFSTYLEPRJID", "", iDataEntityModel.getName(), "PSSFCODEFOLDER", iDataEntityModel.getDataInfo((IEntity)pSSFStylePrj), arrayList.get(0)));
        }
    }

    public void resetPSSFStylePrj(PSSFStylePrj pSSFStylePrj) throws Exception {
        ArrayList<PSSFCodeFolder> arrayList = this.selectByPSSFStylePrj(pSSFStylePrj);
        for (PSSFCodeFolder pSSFCodeFolder : arrayList) {
            PSSFCodeFolder pSSFCodeFolder2 = (PSSFCodeFolder)this.getDEModel().createEntity();
            pSSFCodeFolder2.setPSSFCodeFolderId(pSSFCodeFolder.getPSSFCodeFolderId());
            pSSFCodeFolder2.setPSSFStylePrjId(null);
            this.update(pSSFCodeFolder2);
        }
    }

    public void removeByPSSFStylePrj(PSSFStylePrj pSSFStylePrj) throws Exception {
        final PSSFStylePrj pSSFStylePrj2 = pSSFStylePrj;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFCodeFolderServiceBase.this.onBeforeRemoveByPSSFStylePrj(pSSFStylePrj2);
                PSSFCodeFolderServiceBase.this.internalRemoveByPSSFStylePrj(pSSFStylePrj2);
                PSSFCodeFolderServiceBase.this.onAfterRemoveByPSSFStylePrj(pSSFStylePrj2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStylePrj(PSSFStylePrj pSSFStylePrj) throws Exception {
    }

    protected void internalRemoveByPSSFStylePrj(PSSFStylePrj pSSFStylePrj) throws Exception {
        ArrayList<PSSFCodeFolder> arrayList = this.selectByPSSFStylePrj(pSSFStylePrj);
        this.onBeforeRemoveByPSSFStylePrj(pSSFStylePrj, arrayList);
        for (PSSFCodeFolder pSSFCodeFolder : arrayList) {
            this.remove((IEntity)pSSFCodeFolder);
        }
        this.onAfterRemoveByPSSFStylePrj(pSSFStylePrj, arrayList);
    }

    protected void onAfterRemoveByPSSFStylePrj(PSSFStylePrj pSSFStylePrj) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStylePrj(PSSFStylePrj pSSFStylePrj, ArrayList<PSSFCodeFolder> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStylePrj(PSSFStylePrj pSSFStylePrj, ArrayList<PSSFCodeFolder> arrayList) throws Exception {
    }

    public void testRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    public void resetPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFCodeFolder> arrayList = this.selectByPSSFStyle(pSSFStyle);
        for (PSSFCodeFolder pSSFCodeFolder : arrayList) {
            PSSFCodeFolder pSSFCodeFolder2 = (PSSFCodeFolder)this.getDEModel().createEntity();
            pSSFCodeFolder2.setPSSFCodeFolderId(pSSFCodeFolder.getPSSFCodeFolderId());
            pSSFCodeFolder2.setPSSFStyleId(null);
            this.update(pSSFCodeFolder2);
        }
    }

    public void removeByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFCodeFolderServiceBase.this.onBeforeRemoveByPSSFStyle(pSSFStyle2);
                PSSFCodeFolderServiceBase.this.internalRemoveByPSSFStyle(pSSFStyle2);
                PSSFCodeFolderServiceBase.this.onAfterRemoveByPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFCodeFolder> arrayList = this.selectByPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPSSFStyle(pSSFStyle, arrayList);
        for (PSSFCodeFolder pSSFCodeFolder : arrayList) {
            this.remove((IEntity)pSSFCodeFolder);
        }
        this.onAfterRemoveByPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFCodeFolder> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFCodeFolder> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFCodeFolder pSSFCodeFolder) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSFCodeTypeService)ServiceGlobal.getService(PSSFCodeTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFCodeTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSSFCodeFolder(pSSFCodeFolder);
        ((PSSFCodeTypeServiceBase)pSCoreSysServiceBase).removeByPSSFCodeFolder(pSSFCodeFolder);
        pSCoreSysServiceBase = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSFCodeFolder(pSSFCodeFolder);
        super.onBeforeRemove(pSSFCodeFolder);
    }

    protected void replaceParentInfo(PSSFCodeFolder pSSFCodeFolder, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSFCodeFolder, cloneSession);
        if (pSSFCodeFolder.getPSSFStylePrjId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLEPRJ", (Object)pSSFCodeFolder.getPSSFStylePrjId())) != null) {
            this.onFillParentInfo_PSSFStylePrj(pSSFCodeFolder, (PSSFStylePrj)iEntity);
        }
        if (pSSFCodeFolder.getPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSFCodeFolder.getPSSFStyleId())) != null) {
            this.onFillParentInfo_PSSFStyle(pSSFCodeFolder, (PSSFStyle)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFCodeFolder pSSFCodeFolder, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSFCodeFolder, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BottomCode(bl, pSSFCodeFolder, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FolderName(bl, pSSFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderCode(bl, pSSFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelLevel(bl, pSSFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjFolder(bl, pSSFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeFolderId(bl, pSSFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeFolderName(bl, pSSFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSSFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStylePrjId(bl, pSSFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubFlag(bl, pSSFCodeFolder, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSFCodeFolder, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BottomCode(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeFolder.isBottomCodeDirty() : !pSSFCodeFolder.isBottomCodeDirty()) {
            return null;
        }
        String string = pSSFCodeFolder.getBottomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomCode_Default((IEntity)pSSFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FolderName(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeFolder.isFolderNameDirty() && !bl2 : !pSSFCodeFolder.isFolderNameDirty()) {
            return null;
        }
        String string = pSSFCodeFolder.getFolderName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FOLDERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FolderName_Default((IEntity)pSSFCodeFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_HeaderCode(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeFolder.isHeaderCodeDirty() : !pSSFCodeFolder.isHeaderCodeDirty()) {
            return null;
        }
        String string = pSSFCodeFolder.getHeaderCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderCode_Default((IEntity)pSSFCodeFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeFolder.isMemoDirty() : !pSSFCodeFolder.isMemoDirty()) {
            return null;
        }
        String string = pSSFCodeFolder.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSFCodeFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelLevel(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeFolder.isModelLevelDirty() : !pSSFCodeFolder.isModelLevelDirty()) {
            return null;
        }
        Integer n = pSSFCodeFolder.getModelLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelLevel_Default((IEntity)pSSFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrjFolder(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeFolder.isPrjFolderDirty() : !pSSFCodeFolder.isPrjFolderDirty()) {
            return null;
        }
        String string = pSSFCodeFolder.getPrjFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrjFolder_Default((IEntity)pSSFCodeFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFCodeFolderId(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeFolder.isPSSFCodeFolderIdDirty() && !bl2 : !pSSFCodeFolder.isPSSFCodeFolderIdDirty()) {
            return null;
        }
        String string = pSSFCodeFolder.getPSSFCodeFolderId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODEFOLDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeFolderId_Default((IEntity)pSSFCodeFolder, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFCodeFolderName(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeFolder.isPSSFCodeFolderNameDirty() && !bl2 : !pSSFCodeFolder.isPSSFCodeFolderNameDirty()) {
            return null;
        }
        String string = pSSFCodeFolder.getPSSFCodeFolderName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODEFOLDERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeFolderName_Default((IEntity)pSSFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODEFOLDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeFolder.isPSSFStyleIdDirty() && !bl2 : !pSSFCodeFolder.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSFCodeFolder.getPSSFStyleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default((IEntity)pSSFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStylePrjId(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeFolder.isPSSFStylePrjIdDirty() : !pSSFCodeFolder.isPSSFStylePrjIdDirty()) {
            return null;
        }
        String string = pSSFCodeFolder.getPSSFStylePrjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStylePrjId_Default((IEntity)pSSFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEPRJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubFlag(boolean bl, PSSFCodeFolder pSSFCodeFolder, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeFolder.isPubFlagDirty() : !pSSFCodeFolder.isPubFlagDirty()) {
            return null;
        }
        Integer n = pSSFCodeFolder.getPubFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubFlag_Default((IEntity)pSSFCodeFolder, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSFCodeFolder pSSFCodeFolder, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSFCodeFolder, bl);
    }

    protected void onSyncIndexEntities(PSSFCodeFolder pSSFCodeFolder, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSFCodeFolder, bl);
    }

    public Object getDataContextValue(PSSFCodeFolder pSSFCodeFolder, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSFCodeFolder, string, iDataContextParam)) != null) {
            return object;
        }
        PSSFStyle pSSFStyle = pSSFCodeFolder.getPSSFStyle();
        if (pSSFStyle != null && pSSFStyle.contains(string)) {
            return pSSFStyle.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSFCodeFolder pSSFCodeFolder, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSFCodeFolder, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BOTTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FOLDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FolderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRJFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODEFOLDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeFolderId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODEFOLDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeFolderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEPRJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStylePrjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEPRJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStylePrjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BottomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_HeaderCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_ModelLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PrjFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRJFOLDER", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSFStylePrjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEPRJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStylePrjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEPRJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSSFCodeFolder pSSFCodeFolder) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSFCodeFolder)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFCodeFolder pSSFCodeFolder) throws Exception {
        super.onUpdateParent((IEntity)pSSFCodeFolder);
    }

    @Override
    protected void exportCurXmlModel(PSSFCodeFolder pSSFCodeFolder, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFCODEFOLDER");
        if (!bl) {
            pSSFCodeFolder.setCreateDate(null);
            pSSFCodeFolder.setCreateMan(null);
            pSSFCodeFolder.setPSSFCodeFolderId(null);
            pSSFCodeFolder.setUpdateDate(null);
            pSSFCodeFolder.setUpdateMan(null);
            super.exportCurXmlModel(pSSFCodeFolder, xmlNode, bl);
        }
    }
}

