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
package net.ibizsys.pscore.srv.sysdevstudio.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSMOSFileDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSMOSFileDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFileBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSMOSFileService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMOSFileServiceBase
extends PSCoreSysServiceBase<PSMOSFile> {
    private static final Log log = LogFactory.getLog(PSMOSFileServiceBase.class);
    public static final String DATASET_CAT = "Cat";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_RT = "RT";
    private PSMOSFileDEModel pSMOSFileDEModel;
    private PSMOSFileDAO pSMOSFileDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSMOSFileService";
    }

    public PSMOSFileDEModel getPSMOSFileDEModel() {
        if (this.pSMOSFileDEModel == null) {
            try {
                this.pSMOSFileDEModel = (PSMOSFileDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSMOSFileDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMOSFileDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSMOSFileDEModel();
    }

    public PSMOSFileDAO getPSMOSFileDAO() {
        if (this.pSMOSFileDAO == null) {
            try {
                this.pSMOSFileDAO = (PSMOSFileDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSMOSFileDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMOSFileDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSMOSFileDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CAT, (boolean)true) == 0) {
            return this.fetchCat(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_RT, (boolean)true) == 0) {
            return this.fetchRT(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCat(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CAT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchRT(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_RT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSMOSFile pSMOSFile, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMOSFILE_PSMOSFILE_PPSMOSFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSMOSFileService", (SessionFactory)this.getSessionFactory());
            PSMOSFile pSMOSFile2 = (PSMOSFile)iService.getDEModel().createEntity();
            pSMOSFile2.set("PSMOSFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSMOSFile2);
            } else {
                iService.get(pSMOSFile2);
            }
            this.onFillParentInfo_PPSMOSFile(pSMOSFile, pSMOSFile2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMOSFILE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSMOSFile, pSSystem);
            return;
        }
        super.onFillParentInfo(pSMOSFile, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSMOSFile(PSMOSFile pSMOSFile, PSMOSFile pSMOSFile2) throws Exception {
        pSMOSFile.setPPSMOSFileId(pSMOSFile2.getPSMOSFileId());
        pSMOSFile.setPPSMOSFileName(pSMOSFile2.getPSMOSFileName());
    }

    protected void onFillParentInfo_PSSystem(PSMOSFile pSMOSFile, PSSystem pSSystem) throws Exception {
        pSMOSFile.setPSSystemId(pSSystem.getPSSystemId());
        pSMOSFile.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSMOSFile pSMOSFile, boolean bl) throws Exception {
        if (bl) {
            if (pSMOSFile.getFolderFlag() == null) {
                pSMOSFile.setFolderFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSMOSFile.getUserFlag() == null) {
                pSMOSFile.setUserFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSMOSFile, bl);
        this.onFillEntityFullInfo_PPSMOSFile(pSMOSFile, bl);
        this.onFillEntityFullInfo_PSSystem(pSMOSFile, bl);
    }

    protected void onFillEntityFullInfo_PPSMOSFile(PSMOSFile pSMOSFile, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSMOSFile pSMOSFile, boolean bl) throws Exception {
        if (pSMOSFile.isPSSystemIdDirty()) {
            if (pSMOSFile.getPSSystemId() != null) {
                if (pSMOSFile.getPSSystemId() == null || pSMOSFile.getPSSystemName() == null) {
                    PSSystem pSSystem = pSMOSFile.getPSSystem();
                    pSMOSFile.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSMOSFile.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSMOSFile pSMOSFile, boolean bl) throws Exception {
        super.onWriteBackParent(pSMOSFile, bl);
    }

    public ArrayList<PSMOSFile> selectByPPSMOSFile(PSMOSFileBase pSMOSFileBase) throws Exception {
        return this.selectByPPSMOSFile(pSMOSFileBase, "", -1);
    }

    public ArrayList<PSMOSFile> selectByPPSMOSFile(PSMOSFileBase pSMOSFileBase, String string) throws Exception {
        return this.selectByPPSMOSFile(pSMOSFileBase, string, -1);
    }

    public ArrayList<PSMOSFile> selectByPPSMOSFile(PSMOSFileBase pSMOSFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSMOSFILEID", (Object)pSMOSFileBase.getPSMOSFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSMOSFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSMOSFileCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSMOSFile> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSMOSFile> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSMOSFile> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPPSMOSFile(PSMOSFile pSMOSFile) throws Exception {
        ArrayList<PSMOSFile> arrayList = this.selectByPPSMOSFile(pSMOSFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMOSFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSMOSFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMOSFILE_PSMOSFILE_PPSMOSFILEID", "", iDataEntityModel.getName(), "PSMOSFILE", iDataEntityModel.getDataInfo(pSMOSFile), arrayList.get(0)));
        }
    }

    public void resetPPSMOSFile(PSMOSFile pSMOSFile) throws Exception {
        ArrayList<PSMOSFile> arrayList = this.selectByPPSMOSFile(pSMOSFile);
        for (PSMOSFile pSMOSFile2 : arrayList) {
            PSMOSFile pSMOSFile3 = (PSMOSFile)this.getDEModel().createEntity();
            pSMOSFile3.setPSMOSFileId(pSMOSFile2.getPSMOSFileId());
            pSMOSFile3.setPPSMOSFileId(null);
            this.update(pSMOSFile3);
        }
    }

    public void removeByPPSMOSFile(PSMOSFile pSMOSFile) throws Exception {
        final PSMOSFile pSMOSFile2 = pSMOSFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMOSFileServiceBase.this.onBeforeRemoveByPPSMOSFile(pSMOSFile2);
                PSMOSFileServiceBase.this.internalRemoveByPPSMOSFile(pSMOSFile2);
                PSMOSFileServiceBase.this.onAfterRemoveByPPSMOSFile(pSMOSFile2);
            }
        });
    }

    protected void onBeforeRemoveByPPSMOSFile(PSMOSFile pSMOSFile) throws Exception {
    }

    protected void internalRemoveByPPSMOSFile(PSMOSFile pSMOSFile) throws Exception {
        ArrayList<PSMOSFile> arrayList = this.selectByPPSMOSFile(pSMOSFile);
        this.onBeforeRemoveByPPSMOSFile(pSMOSFile, arrayList);
        for (PSMOSFile pSMOSFile2 : arrayList) {
            this.remove(pSMOSFile2);
        }
        this.onAfterRemoveByPPSMOSFile(pSMOSFile, arrayList);
    }

    protected void onAfterRemoveByPPSMOSFile(PSMOSFile pSMOSFile) throws Exception {
    }

    protected void onBeforeRemoveByPPSMOSFile(PSMOSFile pSMOSFile, ArrayList<PSMOSFile> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSMOSFile(PSMOSFile pSMOSFile, ArrayList<PSMOSFile> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSMOSFile> arrayList = this.selectByPSSystem(pSSystem);
        for (PSMOSFile pSMOSFile : arrayList) {
            PSMOSFile pSMOSFile2 = (PSMOSFile)this.getDEModel().createEntity();
            pSMOSFile2.setPSMOSFileId(pSMOSFile.getPSMOSFileId());
            pSMOSFile2.setPSSystemId(null);
            this.update(pSMOSFile2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMOSFileServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSMOSFileServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSMOSFileServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSMOSFile> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSMOSFile pSMOSFile : arrayList) {
            this.remove(pSMOSFile);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSMOSFile> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSMOSFile> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSMOSFile pSMOSFile) throws Exception {
        PSMOSFileService pSMOSFileService = (PSMOSFileService)ServiceGlobal.getService(PSMOSFileService.class, (SessionFactory)this.getSessionFactory());
        pSMOSFileService.testRemoveByPPSMOSFile(pSMOSFile);
        super.onBeforeRemove(pSMOSFile);
    }

    protected void replaceParentInfo(PSMOSFile pSMOSFile, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSMOSFile, cloneSession);
        if (pSMOSFile.getPPSMOSFileId() != null && (iEntity = cloneSession.getEntity("PSMOSFILE", (Object)pSMOSFile.getPPSMOSFileId())) != null) {
            this.onFillParentInfo_PPSMOSFile(pSMOSFile, (PSMOSFile)iEntity);
        }
        if (pSMOSFile.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSMOSFile.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSMOSFile, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSMOSFile pSMOSFile, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSMOSFile, bl);
    }

    protected void onCheckEntity(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Color(bl, pSMOSFile, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Css(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileAttr(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileCat(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileCnt(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileTag(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileTag2(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileTag3(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileTag4(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FolderFlag(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullPath(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelV2Tag(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSMOSFileId(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelSubType(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelType(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMOSFileId(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMOSFileName(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tags(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParams(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActions(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserFlag(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSMOSFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSMOSFile, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Color(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isColorDirty() : !pSMOSFile.isColorDirty()) {
            return null;
        }
        String string = pSMOSFile.getColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Color_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Css(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isCssDirty() : !pSMOSFile.isCssDirty()) {
            return null;
        }
        String string = pSMOSFile.getCss();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Css_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isDataDirty() : !pSMOSFile.isDataDirty()) {
            return null;
        }
        String string = pSMOSFile.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileAttr(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isFileAttrDirty() : !pSMOSFile.isFileAttrDirty()) {
            return null;
        }
        Integer n = pSMOSFile.getFileAttr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FileAttr_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILEATTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileCat(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isFileCatDirty() : !pSMOSFile.isFileCatDirty()) {
            return null;
        }
        String string = pSMOSFile.getFileCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileCat_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILECAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileCnt(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isFileCntDirty() : !pSMOSFile.isFileCntDirty()) {
            return null;
        }
        Integer n = pSMOSFile.getFileCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FileCnt_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILECNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileTag(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isFileTagDirty() : !pSMOSFile.isFileTagDirty()) {
            return null;
        }
        String string = pSMOSFile.getFileTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileTag_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileTag2(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isFileTag2Dirty() : !pSMOSFile.isFileTag2Dirty()) {
            return null;
        }
        String string = pSMOSFile.getFileTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileTag2_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileTag3(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isFileTag3Dirty() : !pSMOSFile.isFileTag3Dirty()) {
            return null;
        }
        String string = pSMOSFile.getFileTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileTag3_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILETAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileTag4(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isFileTag4Dirty() : !pSMOSFile.isFileTag4Dirty()) {
            return null;
        }
        String string = pSMOSFile.getFileTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileTag4_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILETAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FolderFlag(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isFolderFlagDirty() && !bl2 : !pSMOSFile.isFolderFlagDirty()) {
            return null;
        }
        Integer n = pSMOSFile.getFolderFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FOLDERFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_FolderFlag_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FOLDERFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FullPath(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isFullPathDirty() : !pSMOSFile.isFullPathDirty()) {
            return null;
        }
        String string = pSMOSFile.getFullPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullPath_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isMemoDirty() : !pSMOSFile.isMemoDirty()) {
            return null;
        }
        String string = pSMOSFile.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSMOSFile, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelV2Tag(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isModelV2TagDirty() : !pSMOSFile.isModelV2TagDirty()) {
            return null;
        }
        String string = pSMOSFile.getModelV2Tag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelV2Tag_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELV2TAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isOrderValueDirty() : !pSMOSFile.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSMOSFile.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSMOSFile, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSMOSFileId(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isPPSMOSFileIdDirty() : !pSMOSFile.isPPSMOSFileIdDirty()) {
            return null;
        }
        String string = pSMOSFile.getPPSMOSFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSMOSFileId_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSMOSFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isPSModelIdDirty() : !pSMOSFile.isPSModelIdDirty()) {
            return null;
        }
        String string = pSMOSFile.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default(pSMOSFile, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelSubType(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isPSModelSubTypeDirty() : !pSMOSFile.isPSModelSubTypeDirty()) {
            return null;
        }
        String string = pSMOSFile.getPSModelSubType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelSubType_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSUBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelType(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isPSModelTypeDirty() : !pSMOSFile.isPSModelTypeDirty()) {
            return null;
        }
        String string = pSMOSFile.getPSModelType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelType_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMOSFileId(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isPSMOSFileIdDirty() && !bl2 : !pSMOSFile.isPSMOSFileIdDirty()) {
            return null;
        }
        String string = pSMOSFile.getPSMOSFileId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOSFILEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMOSFileId_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOSFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMOSFileName(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isPSMOSFileNameDirty() && !bl2 : !pSMOSFile.isPSMOSFileNameDirty()) {
            return null;
        }
        String string = pSMOSFile.getPSMOSFileName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOSFILENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMOSFileName_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOSFILENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isPSSystemIdDirty() : !pSMOSFile.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSMOSFile.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSMOSFile, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isPSSystemNameDirty() : !pSMOSFile.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSMOSFile.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSMOSFile, bl2, bl3);
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

    protected EntityFieldError onCheckField_Tags(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isTagsDirty() : !pSMOSFile.isTagsDirty()) {
            return null;
        }
        String string = pSMOSFile.getTags();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tags_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParams(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isUIActionParamsDirty() : !pSMOSFile.isUIActionParamsDirty()) {
            return null;
        }
        String string = pSMOSFile.getUIActionParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionParams_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActions(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isUIActionsDirty() : !pSMOSFile.isUIActionsDirty()) {
            return null;
        }
        String string = pSMOSFile.getUIActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActions_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserFlag(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isUserFlagDirty() && !bl2 : !pSMOSFile.isUserFlagDirty()) {
            return null;
        }
        Integer n = pSMOSFile.getUserFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_UserFlag_Default(pSMOSFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSMOSFile pSMOSFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMOSFile.isValidFlagDirty() : !pSMOSFile.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSMOSFile.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSMOSFile, bl2, bl3);
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

    protected void onSyncEntity(PSMOSFile pSMOSFile, boolean bl) throws Exception {
        super.onSyncEntity(pSMOSFile, bl);
    }

    protected void onSyncIndexEntities(PSMOSFile pSMOSFile, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSMOSFile, bl);
    }

    public Object getDataContextValue(PSMOSFile pSMOSFile, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSMOSFile, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSMOSFile pSMOSFile, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSMOSFile, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"COLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Color_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Css_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILEATTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileAttr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILECAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILECNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILETAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILETAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FOLDERFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FolderFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELV2TAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelV2Tag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMOSFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSMOSFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMOSFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSMOSFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELSUBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelSubType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOSFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMOSFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOSFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMOSFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tags_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Color_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_Css_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FileAttr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FileCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILECAT", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FileCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FileTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FileTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FileTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILETAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FileTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILETAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FolderFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FullPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLPATH", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_ModelV2Tag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELV2TAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSMOSFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMOSFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSMOSFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMOSFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSModelSubType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELSUBTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMOSFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOSFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMOSFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOSFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_Tags_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActionParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_UserFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSMOSFile pSMOSFile) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSMOSFile)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSMOSFile pSMOSFile) throws Exception {
        super.onUpdateParent(pSMOSFile);
    }

    @Override
    protected void exportCurXmlModel(PSMOSFile pSMOSFile, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMOSFILE");
        if (!bl) {
            pSMOSFile.setCreateDate(null);
            pSMOSFile.setCreateMan(null);
            pSMOSFile.setPSMOSFileId(null);
            pSMOSFile.setUpdateDate(null);
            pSMOSFile.setUpdateMan(null);
            super.exportCurXmlModel(pSMOSFile, xmlNode, bl);
        }
    }
}

