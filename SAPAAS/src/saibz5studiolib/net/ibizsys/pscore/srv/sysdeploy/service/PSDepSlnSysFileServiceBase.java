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
package net.ibizsys.pscore.srv.sysdeploy.service;

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
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysFileDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysFileDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnFile;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnFileBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysFile;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysFileServiceBase
extends PSCoreSysServiceBase<PSDepSlnSysFile> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysFileServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnSysFileDEModel pSDepSlnSysFileDEModel;
    private PSDepSlnSysFileDAO pSDepSlnSysFileDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysFileService";
    }

    public PSDepSlnSysFileDEModel getPSDepSlnSysFileDEModel() {
        if (this.pSDepSlnSysFileDEModel == null) {
            try {
                this.pSDepSlnSysFileDEModel = (PSDepSlnSysFileDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysFileDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysFileDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnSysFileDEModel();
    }

    public PSDepSlnSysFileDAO getPSDepSlnSysFileDAO() {
        if (this.pSDepSlnSysFileDAO == null) {
            try {
                this.pSDepSlnSysFileDAO = (PSDepSlnSysFileDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysFileDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysFileDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnSysFileDAO();
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

    protected void onFillParentInfo(PSDepSlnSysFile pSDepSlnSysFile, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSFILE_PSDEPSLNFILE_PSDEPSLNFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnFileService", (SessionFactory)this.getSessionFactory());
            PSDepSlnFile pSDepSlnFile = (PSDepSlnFile)iService.getDEModel().createEntity();
            pSDepSlnFile.set("PSDEPSLNFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnFile);
            } else {
                iService.get((IEntity)pSDepSlnFile);
            }
            this.onFillParentInfo_PSDepSlnFile(pSDepSlnSysFile, pSDepSlnFile);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSFILE_PSDEPSLNSYS_PSDEPSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSys pSDepSlnSys = (PSDepSlnSys)iService.getDEModel().createEntity();
            pSDepSlnSys.set("PSDEPSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnSys);
            } else {
                iService.get((IEntity)pSDepSlnSys);
            }
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysFile, pSDepSlnSys);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSlnSysFile, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnFile(PSDepSlnSysFile pSDepSlnSysFile, PSDepSlnFile pSDepSlnFile) throws Exception {
        pSDepSlnSysFile.setPSDepSlnFileId(pSDepSlnFile.getPSDepSlnFileId());
        pSDepSlnSysFile.setPSDepSlnFileName(pSDepSlnFile.getPSDepSlnFileName());
    }

    protected void onFillParentInfo_PSDepSlnSys(PSDepSlnSysFile pSDepSlnSysFile, PSDepSlnSys pSDepSlnSys) throws Exception {
        pSDepSlnSysFile.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
        pSDepSlnSysFile.setPSDepSlnSysName(pSDepSlnSys.getPSDepSlnSysName());
    }

    protected void onFillEntityFullInfo(PSDepSlnSysFile pSDepSlnSysFile, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSlnSysFile, bl);
        this.onFillEntityFullInfo_PSDepSlnFile(pSDepSlnSysFile, bl);
        this.onFillEntityFullInfo_PSDepSlnSys(pSDepSlnSysFile, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnFile(PSDepSlnSysFile pSDepSlnSysFile, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSlnSys(PSDepSlnSysFile pSDepSlnSysFile, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnSysFile pSDepSlnSysFile, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSlnSysFile, bl);
    }

    public ArrayList<PSDepSlnSysFile> selectByPSDepSlnFile(PSDepSlnFileBase pSDepSlnFileBase) throws Exception {
        return this.selectByPSDepSlnFile(pSDepSlnFileBase, "", -1);
    }

    public ArrayList<PSDepSlnSysFile> selectByPSDepSlnFile(PSDepSlnFileBase pSDepSlnFileBase, String string) throws Exception {
        return this.selectByPSDepSlnFile(pSDepSlnFileBase, string, -1);
    }

    public ArrayList<PSDepSlnSysFile> selectByPSDepSlnFile(PSDepSlnFileBase pSDepSlnFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNFILEID", (Object)pSDepSlnFileBase.getPSDepSlnFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnFileCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysFile> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, "", -1);
    }

    public ArrayList<PSDepSlnSysFile> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, string, -1);
    }

    public ArrayList<PSDepSlnSysFile> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNSYSID", (Object)pSDepSlnSysBase.getPSDepSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnFile(PSDepSlnFile pSDepSlnFile) throws Exception {
        ArrayList<PSDepSlnSysFile> arrayList = this.selectByPSDepSlnFile(pSDepSlnFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSFILE_PSDEPSLNFILE_PSDEPSLNFILEID", "", iDataEntityModel.getName(), "PSDEPSLNSYSFILE", iDataEntityModel.getDataInfo((IEntity)pSDepSlnFile), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnFile(PSDepSlnFile pSDepSlnFile) throws Exception {
        ArrayList<PSDepSlnSysFile> arrayList = this.selectByPSDepSlnFile(pSDepSlnFile);
        for (PSDepSlnSysFile pSDepSlnSysFile : arrayList) {
            PSDepSlnSysFile pSDepSlnSysFile2 = (PSDepSlnSysFile)this.getDEModel().createEntity();
            pSDepSlnSysFile2.setPSDepSlnSysFileId(pSDepSlnSysFile.getPSDepSlnSysFileId());
            pSDepSlnSysFile2.setPSDepSlnFileId(null);
            this.update(pSDepSlnSysFile2);
        }
    }

    public void removeByPSDepSlnFile(PSDepSlnFile pSDepSlnFile) throws Exception {
        final PSDepSlnFile pSDepSlnFile2 = pSDepSlnFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysFileServiceBase.this.onBeforeRemoveByPSDepSlnFile(pSDepSlnFile2);
                PSDepSlnSysFileServiceBase.this.internalRemoveByPSDepSlnFile(pSDepSlnFile2);
                PSDepSlnSysFileServiceBase.this.onAfterRemoveByPSDepSlnFile(pSDepSlnFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnFile(PSDepSlnFile pSDepSlnFile) throws Exception {
    }

    protected void internalRemoveByPSDepSlnFile(PSDepSlnFile pSDepSlnFile) throws Exception {
        ArrayList<PSDepSlnSysFile> arrayList = this.selectByPSDepSlnFile(pSDepSlnFile);
        this.onBeforeRemoveByPSDepSlnFile(pSDepSlnFile, arrayList);
        for (PSDepSlnSysFile pSDepSlnSysFile : arrayList) {
            this.remove((IEntity)pSDepSlnSysFile);
        }
        this.onAfterRemoveByPSDepSlnFile(pSDepSlnFile, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnFile(PSDepSlnFile pSDepSlnFile) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnFile(PSDepSlnFile pSDepSlnFile, ArrayList<PSDepSlnSysFile> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnFile(PSDepSlnFile pSDepSlnFile, ArrayList<PSDepSlnSysFile> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    public void resetPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysFile> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        for (PSDepSlnSysFile pSDepSlnSysFile : arrayList) {
            PSDepSlnSysFile pSDepSlnSysFile2 = (PSDepSlnSysFile)this.getDEModel().createEntity();
            pSDepSlnSysFile2.setPSDepSlnSysFileId(pSDepSlnSysFile.getPSDepSlnSysFileId());
            pSDepSlnSysFile2.setPSDepSlnSysId(null);
            this.update(pSDepSlnSysFile2);
        }
    }

    public void removeByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        final PSDepSlnSys pSDepSlnSys2 = pSDepSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysFileServiceBase.this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysFileServiceBase.this.internalRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysFileServiceBase.this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysFile> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
        for (PSDepSlnSysFile pSDepSlnSysFile : arrayList) {
            this.remove((IEntity)pSDepSlnSysFile);
        }
        this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysFile> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysFile> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnSysFile pSDepSlnSysFile) throws Exception {
        super.onBeforeRemove(pSDepSlnSysFile);
    }

    protected void replaceParentInfo(PSDepSlnSysFile pSDepSlnSysFile, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSlnSysFile, cloneSession);
        if (pSDepSlnSysFile.getPSDepSlnFileId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNFILE", (Object)pSDepSlnSysFile.getPSDepSlnFileId())) != null) {
            this.onFillParentInfo_PSDepSlnFile(pSDepSlnSysFile, (PSDepSlnFile)iEntity);
        }
        if (pSDepSlnSysFile.getPSDepSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYS", (Object)pSDepSlnSysFile.getPSDepSlnSysId())) != null) {
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysFile, (PSDepSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnSysFile pSDepSlnSysFile, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSlnSysFile, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnSysFile pSDepSlnSysFile, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDepSlnSysFile, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnFileId(bl, pSDepSlnSysFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysFileId(bl, pSDepSlnSysFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysFileName(bl, pSDepSlnSysFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysId(bl, pSDepSlnSysFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSlnSysFile, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnSysFile pSDepSlnSysFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysFile.isMemoDirty() : !pSDepSlnSysFile.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnSysFile.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSlnSysFile, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnFileId(boolean bl, PSDepSlnSysFile pSDepSlnSysFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysFile.isPSDepSlnFileIdDirty() : !pSDepSlnSysFile.isPSDepSlnFileIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysFile.getPSDepSlnFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnFileId_Default((IEntity)pSDepSlnSysFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysFileId(boolean bl, PSDepSlnSysFile pSDepSlnSysFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysFile.isPSDepSlnSysFileIdDirty() && !bl2 : !pSDepSlnSysFile.isPSDepSlnSysFileIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysFile.getPSDepSlnSysFileId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSFILEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysFileId_Default((IEntity)pSDepSlnSysFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysFileName(boolean bl, PSDepSlnSysFile pSDepSlnSysFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysFile.isPSDepSlnSysFileNameDirty() && !bl2 : !pSDepSlnSysFile.isPSDepSlnSysFileNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysFile.getPSDepSlnSysFileName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSFILENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysFileName_Default((IEntity)pSDepSlnSysFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSFILENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysId(boolean bl, PSDepSlnSysFile pSDepSlnSysFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysFile.isPSDepSlnSysIdDirty() : !pSDepSlnSysFile.isPSDepSlnSysIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysFile.getPSDepSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysId_Default((IEntity)pSDepSlnSysFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnSysFile pSDepSlnSysFile, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSlnSysFile, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnSysFile pSDepSlnSysFile, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSlnSysFile, bl);
    }

    public Object getDataContextValue(PSDepSlnSysFile pSDepSlnSysFile, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSlnSysFile, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnSysFile pSDepSlnSysFile, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSlnSysFile, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEPSLNFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDepSlnFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnSysFile pSDepSlnSysFile) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSlnSysFile)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnSysFile pSDepSlnSysFile) throws Exception {
        super.onUpdateParent((IEntity)pSDepSlnSysFile);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnSysFile pSDepSlnSysFile, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNSYSFILE");
        if (!bl) {
            pSDepSlnSysFile.setCreateDate(null);
            pSDepSlnSysFile.setCreateMan(null);
            pSDepSlnSysFile.setPSDepSlnFileName(null);
            pSDepSlnSysFile.setPSDepSlnSysFileId(null);
            pSDepSlnSysFile.setPSDepSlnSysName(null);
            pSDepSlnSysFile.setUpdateDate(null);
            pSDepSlnSysFile.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnSysFile, xmlNode, bl);
        }
    }
}

