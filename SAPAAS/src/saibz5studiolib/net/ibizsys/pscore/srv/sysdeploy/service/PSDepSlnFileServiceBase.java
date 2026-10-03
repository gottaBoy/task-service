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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFileBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnFileDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnFileDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnFile;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysFileService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnFileServiceBase
extends PSCoreSysServiceBase<PSDepSlnFile> {
    private static final Log log = LogFactory.getLog(PSDepSlnFileServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnFileDEModel pSDepSlnFileDEModel;
    private PSDepSlnFileDAO pSDepSlnFileDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnFileService";
    }

    public PSDepSlnFileDEModel getPSDepSlnFileDEModel() {
        if (this.pSDepSlnFileDEModel == null) {
            try {
                this.pSDepSlnFileDEModel = (PSDepSlnFileDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnFileDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnFileDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnFileDEModel();
    }

    public PSDepSlnFileDAO getPSDepSlnFileDAO() {
        if (this.pSDepSlnFileDAO == null) {
            try {
                this.pSDepSlnFileDAO = (PSDepSlnFileDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnFileDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnFileDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnFileDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSlnFile pSDepSlnFile, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNFILE_PSDCFILE_PSDCFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCFileService", (SessionFactory)this.getSessionFactory());
            PSDCFile pSDCFile = (PSDCFile)iService.getDEModel().createEntity();
            pSDCFile.set("PSDCFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCFile);
            } else {
                iService.get(pSDCFile);
            }
            this.onFillParentInfo_PSDCFile(pSDepSlnFile, pSDCFile);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNFILE_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSln);
            } else {
                iService.get(pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnFile, pSDepSln);
            return;
        }
        super.onFillParentInfo(pSDepSlnFile, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCFile(PSDepSlnFile pSDepSlnFile, PSDCFile pSDCFile) throws Exception {
        pSDepSlnFile.setPSDCFileId(pSDCFile.getPSDCFileId());
        pSDepSlnFile.setPSDCFileName(pSDCFile.getPSDCFileName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnFile pSDepSlnFile, PSDepSln pSDepSln) throws Exception {
        pSDepSlnFile.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnFile.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillEntityFullInfo(PSDepSlnFile pSDepSlnFile, boolean bl) throws Exception {
        if (bl && pSDepSlnFile.getValidFlag() == null) {
            pSDepSlnFile.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDepSlnFile, bl);
        this.onFillEntityFullInfo_PSDCFile(pSDepSlnFile, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnFile, bl);
    }

    protected void onFillEntityFullInfo_PSDCFile(PSDepSlnFile pSDepSlnFile, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnFile pSDepSlnFile, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnFile pSDepSlnFile, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnFile, bl);
    }

    public ArrayList<PSDepSlnFile> selectByPSDCFile(PSDCFileBase pSDCFileBase) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, "", -1);
    }

    public ArrayList<PSDepSlnFile> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, string, -1);
    }

    public ArrayList<PSDepSlnFile> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCFILEID", (Object)pSDCFileBase.getPSDCFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCFileCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnFile> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnFile> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnFile> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNID", (Object)pSDepSlnBase.getPSDepSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDepSlnFile> arrayList = this.selectByPSDCFile(pSDCFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNFILE_PSDCFILE_PSDCFILEID", "", iDataEntityModel.getName(), "PSDEPSLNFILE", iDataEntityModel.getDataInfo(pSDCFile), arrayList.get(0)));
        }
    }

    public void resetPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDepSlnFile> arrayList = this.selectByPSDCFile(pSDCFile);
        for (PSDepSlnFile pSDepSlnFile : arrayList) {
            PSDepSlnFile pSDepSlnFile2 = (PSDepSlnFile)this.getDEModel().createEntity();
            pSDepSlnFile2.setPSDepSlnFileId(pSDepSlnFile.getPSDepSlnFileId());
            pSDepSlnFile2.setPSDCFileId(null);
            this.update(pSDepSlnFile2);
        }
    }

    public void removeByPSDCFile(PSDCFile pSDCFile) throws Exception {
        final PSDCFile pSDCFile2 = pSDCFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnFileServiceBase.this.onBeforeRemoveByPSDCFile(pSDCFile2);
                PSDepSlnFileServiceBase.this.internalRemoveByPSDCFile(pSDCFile2);
                PSDepSlnFileServiceBase.this.onAfterRemoveByPSDCFile(pSDCFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void internalRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDepSlnFile> arrayList = this.selectByPSDCFile(pSDCFile);
        this.onBeforeRemoveByPSDCFile(pSDCFile, arrayList);
        for (PSDepSlnFile pSDepSlnFile : arrayList) {
            this.remove(pSDepSlnFile);
        }
        this.onAfterRemoveByPSDCFile(pSDCFile, arrayList);
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDepSlnFile> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDepSlnFile> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnFile> arrayList = this.selectByPSDepSln(pSDepSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNFILE_PSDEPSLN_PSDEPSLNID", "", iDataEntityModel.getName(), "PSDEPSLNFILE", iDataEntityModel.getDataInfo(pSDepSln), arrayList.get(0)));
        }
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnFile> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnFile pSDepSlnFile : arrayList) {
            PSDepSlnFile pSDepSlnFile2 = (PSDepSlnFile)this.getDEModel().createEntity();
            pSDepSlnFile2.setPSDepSlnFileId(pSDepSlnFile.getPSDepSlnFileId());
            pSDepSlnFile2.setPSDepSlnId(null);
            this.update(pSDepSlnFile2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnFileServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnFileServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnFileServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnFile> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnFile pSDepSlnFile : arrayList) {
            this.remove(pSDepSlnFile);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnFile> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnFile> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnFile pSDepSlnFile) throws Exception {
        PSDepSlnSysFileService pSDepSlnSysFileService = (PSDepSlnSysFileService)ServiceGlobal.getService(PSDepSlnSysFileService.class, (SessionFactory)this.getSessionFactory());
        pSDepSlnSysFileService.testRemoveByPSDepSlnFile(pSDepSlnFile);
        super.onBeforeRemove(pSDepSlnFile);
    }

    protected void replaceParentInfo(PSDepSlnFile pSDepSlnFile, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnFile, cloneSession);
        if (pSDepSlnFile.getPSDCFileId() != null && (iEntity = cloneSession.getEntity("PSDCFILE", (Object)pSDepSlnFile.getPSDCFileId())) != null) {
            this.onFillParentInfo_PSDCFile(pSDepSlnFile, (PSDCFile)iEntity);
        }
        if (pSDepSlnFile.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnFile.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnFile, (PSDepSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnFile pSDepSlnFile, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnFile, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnFile pSDepSlnFile, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDepSlnFile, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCFileId(bl, pSDepSlnFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnFileId(bl, pSDepSlnFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnFileName(bl, pSDepSlnFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDepSlnFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnFile, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnFile pSDepSlnFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnFile.isMemoDirty() : !pSDepSlnFile.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnFile.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSlnFile, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCFileId(boolean bl, PSDepSlnFile pSDepSlnFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnFile.isPSDCFileIdDirty() : !pSDepSlnFile.isPSDCFileIdDirty()) {
            return null;
        }
        String string = pSDepSlnFile.getPSDCFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCFileId_Default(pSDepSlnFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnFileId(boolean bl, PSDepSlnFile pSDepSlnFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnFile.isPSDepSlnFileIdDirty() && !bl2 : !pSDepSlnFile.isPSDepSlnFileIdDirty()) {
            return null;
        }
        String string = pSDepSlnFile.getPSDepSlnFileId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNFILEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnFileId_Default(pSDepSlnFile, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnFileName(boolean bl, PSDepSlnFile pSDepSlnFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnFile.isPSDepSlnFileNameDirty() && !bl2 : !pSDepSlnFile.isPSDepSlnFileNameDirty()) {
            return null;
        }
        String string = pSDepSlnFile.getPSDepSlnFileName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNFILENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnFileName_Default(pSDepSlnFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNFILENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnFile pSDepSlnFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnFile.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnFile.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnFile.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default(pSDepSlnFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDepSlnFile pSDepSlnFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnFile.isValidFlagDirty() && !bl2 : !pSDepSlnFile.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDepSlnFile.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDepSlnFile, bl2, bl3);
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

    protected void onSyncEntity(PSDepSlnFile pSDepSlnFile, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnFile, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnFile pSDepSlnFile, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnFile, bl);
    }

    public Object getDataContextValue(PSDepSlnFile pSDepSlnFile, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnFile, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSln pSDepSln = pSDepSlnFile.getPSDepSln();
        if (pSDepSln != null && pSDepSln.contains(string)) {
            return pSDepSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnFile pSDepSlnFile, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnFile, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDepSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnFile pSDepSlnFile) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnFile)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnFile pSDepSlnFile) throws Exception {
        super.onUpdateParent(pSDepSlnFile);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnFile pSDepSlnFile, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNFILE");
        if (!bl) {
            pSDepSlnFile.setCreateDate(null);
            pSDepSlnFile.setCreateMan(null);
            pSDepSlnFile.setPSDCFileName(null);
            pSDepSlnFile.setPSDepSlnFileId(null);
            pSDepSlnFile.setPSDepSlnName(null);
            pSDepSlnFile.setUpdateDate(null);
            pSDepSlnFile.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnFile, xmlNode, bl);
        }
    }
}

