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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFileBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnPackDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnPackDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPack;
import net.ibizsys.pscore.srv.sysdeploy.service.PSdepSlnDepSessionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnPackServiceBase
extends PSCoreSysServiceBase<PSDepSlnPack> {
    private static final Log log = LogFactory.getLog(PSDepSlnPackServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnPackDEModel pSDepSlnPackDEModel;
    private PSDepSlnPackDAO pSDepSlnPackDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPackService";
    }

    public PSDepSlnPackDEModel getPSDepSlnPackDEModel() {
        if (this.pSDepSlnPackDEModel == null) {
            try {
                this.pSDepSlnPackDEModel = (PSDepSlnPackDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnPackDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnPackDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnPackDEModel();
    }

    public PSDepSlnPackDAO getPSDepSlnPackDAO() {
        if (this.pSDepSlnPackDAO == null) {
            try {
                this.pSDepSlnPackDAO = (PSDepSlnPackDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnPackDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnPackDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnPackDAO();
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

    protected void onFillParentInfo(PSDepSlnPack pSDepSlnPack, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNPACK_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSln);
            } else {
                iService.get((IEntity)pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnPack, pSDepSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNPACK_PSDEVCENTERFILE_PSDEVCENTERFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService", (SessionFactory)this.getSessionFactory());
            PSDevCenterFile pSDevCenterFile = (PSDevCenterFile)iService.getDEModel().createEntity();
            pSDevCenterFile.set("PSDEVCENTERFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterFile);
            } else {
                iService.get((IEntity)pSDevCenterFile);
            }
            this.onFillParentInfo_PSDevCenterFile(pSDepSlnPack, pSDevCenterFile);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSlnPack, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnPack pSDepSlnPack, PSDepSln pSDepSln) throws Exception {
        pSDepSlnPack.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnPack.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillParentInfo_PSDevCenterFile(PSDepSlnPack pSDepSlnPack, PSDevCenterFile pSDevCenterFile) throws Exception {
        pSDepSlnPack.setPSDevCenterFileId(pSDevCenterFile.getPSDevCenterFileId());
        pSDepSlnPack.setPSDevCenterFileName(pSDevCenterFile.getPSDevCenterFileName());
    }

    protected void onFillEntityFullInfo(PSDepSlnPack pSDepSlnPack, boolean bl) throws Exception {
        if (bl && pSDepSlnPack.getPackState() == null) {
            pSDepSlnPack.setPackState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDepSlnPack, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnPack, bl);
        this.onFillEntityFullInfo_PSDevCenterFile(pSDepSlnPack, bl);
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnPack pSDepSlnPack, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterFile(PSDepSlnPack pSDepSlnPack, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnPack pSDepSlnPack, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSlnPack, bl);
    }

    public ArrayList<PSDepSlnPack> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnPack> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnPack> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSlnPack> selectByPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase) throws Exception {
        return this.selectByPSDevCenterFile(pSDevCenterFileBase, "", -1);
    }

    public ArrayList<PSDepSlnPack> selectByPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase, String string) throws Exception {
        return this.selectByPSDevCenterFile(pSDevCenterFileBase, string, -1);
    }

    public ArrayList<PSDepSlnPack> selectByPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERFILEID", (Object)pSDevCenterFileBase.getPSDevCenterFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterFileCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnPack> arrayList = this.selectByPSDepSln(pSDepSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNPACK_PSDEPSLN_PSDEPSLNID", "", iDataEntityModel.getName(), "PSDEPSLNPACK", iDataEntityModel.getDataInfo((IEntity)pSDepSln), arrayList.get(0)));
        }
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnPack> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnPack pSDepSlnPack : arrayList) {
            PSDepSlnPack pSDepSlnPack2 = (PSDepSlnPack)this.getDEModel().createEntity();
            pSDepSlnPack2.setPSDepSlnPackId(pSDepSlnPack.getPSDepSlnPackId());
            pSDepSlnPack2.setPSDepSlnId(null);
            this.update(pSDepSlnPack2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnPackServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnPackServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnPackServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnPack> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnPack pSDepSlnPack : arrayList) {
            this.remove((IEntity)pSDepSlnPack);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnPack> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnPack> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDepSlnPack> arrayList = this.selectByPSDevCenterFile(pSDevCenterFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNPACK_PSDEVCENTERFILE_PSDEVCENTERFILEID", "", iDataEntityModel.getName(), "PSDEPSLNPACK", iDataEntityModel.getDataInfo((IEntity)pSDevCenterFile), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDepSlnPack> arrayList = this.selectByPSDevCenterFile(pSDevCenterFile);
        for (PSDepSlnPack pSDepSlnPack : arrayList) {
            PSDepSlnPack pSDepSlnPack2 = (PSDepSlnPack)this.getDEModel().createEntity();
            pSDepSlnPack2.setPSDepSlnPackId(pSDepSlnPack.getPSDepSlnPackId());
            pSDepSlnPack2.setPSDevCenterFileId(null);
            this.update(pSDepSlnPack2);
        }
    }

    public void removeByPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        final PSDevCenterFile pSDevCenterFile2 = pSDevCenterFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnPackServiceBase.this.onBeforeRemoveByPSDevCenterFile(pSDevCenterFile2);
                PSDepSlnPackServiceBase.this.internalRemoveByPSDevCenterFile(pSDevCenterFile2);
                PSDepSlnPackServiceBase.this.onAfterRemoveByPSDevCenterFile(pSDevCenterFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
    }

    protected void internalRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDepSlnPack> arrayList = this.selectByPSDevCenterFile(pSDevCenterFile);
        this.onBeforeRemoveByPSDevCenterFile(pSDevCenterFile, arrayList);
        for (PSDepSlnPack pSDepSlnPack : arrayList) {
            this.remove((IEntity)pSDepSlnPack);
        }
        this.onAfterRemoveByPSDevCenterFile(pSDevCenterFile, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile, ArrayList<PSDepSlnPack> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile, ArrayList<PSDepSlnPack> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnPack pSDepSlnPack) throws Exception {
        PSdepSlnDepSessionService pSdepSlnDepSessionService = (PSdepSlnDepSessionService)ServiceGlobal.getService(PSdepSlnDepSessionService.class, (SessionFactory)this.getSessionFactory());
        pSdepSlnDepSessionService.testRemoveByPSDepSlnPack(pSDepSlnPack);
        super.onBeforeRemove(pSDepSlnPack);
    }

    protected void replaceParentInfo(PSDepSlnPack pSDepSlnPack, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSlnPack, cloneSession);
        if (pSDepSlnPack.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnPack.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnPack, (PSDepSln)iEntity);
        }
        if (pSDepSlnPack.getPSDevCenterFileId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERFILE", (Object)pSDepSlnPack.getPSDevCenterFileId())) != null) {
            this.onFillParentInfo_PSDevCenterFile(pSDepSlnPack, (PSDevCenterFile)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnPack pSDepSlnPack, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSlnPack, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnPack pSDepSlnPack, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DepToolType(bl, pSDepSlnPack, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSlnPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PackErrorInfo(bl, pSDepSlnPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PackState(bl, pSDepSlnPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnPackId(bl, pSDepSlnPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnPackName(bl, pSDepSlnPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterFileId(bl, pSDepSlnPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSlnPack, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DepToolType(boolean bl, PSDepSlnPack pSDepSlnPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPack.isDepToolTypeDirty() && !bl2 : !pSDepSlnPack.isDepToolTypeDirty()) {
            return null;
        }
        String string = pSDepSlnPack.getDepToolType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPTOOLTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DepToolType_Default((IEntity)pSDepSlnPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPTOOLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnPack pSDepSlnPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPack.isMemoDirty() : !pSDepSlnPack.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnPack.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSlnPack, bl2, bl3);
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

    protected EntityFieldError onCheckField_PackErrorInfo(boolean bl, PSDepSlnPack pSDepSlnPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPack.isPackErrorInfoDirty() : !pSDepSlnPack.isPackErrorInfoDirty()) {
            return null;
        }
        String string = pSDepSlnPack.getPackErrorInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PackErrorInfo_Default((IEntity)pSDepSlnPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PACKERRORINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PackState(boolean bl, PSDepSlnPack pSDepSlnPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPack.isPackStateDirty() && !bl2 : !pSDepSlnPack.isPackStateDirty()) {
            return null;
        }
        Integer n = pSDepSlnPack.getPackState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PACKSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_PackState_Default((IEntity)pSDepSlnPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PACKSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnPack pSDepSlnPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPack.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnPack.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnPack.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default((IEntity)pSDepSlnPack, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnPackId(boolean bl, PSDepSlnPack pSDepSlnPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPack.isPSDepSlnPackIdDirty() && !bl2 : !pSDepSlnPack.isPSDepSlnPackIdDirty()) {
            return null;
        }
        String string = pSDepSlnPack.getPSDepSlnPackId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPACKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnPackId_Default((IEntity)pSDepSlnPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPACKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnPackName(boolean bl, PSDepSlnPack pSDepSlnPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPack.isPSDepSlnPackNameDirty() && !bl2 : !pSDepSlnPack.isPSDepSlnPackNameDirty()) {
            return null;
        }
        String string = pSDepSlnPack.getPSDepSlnPackName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPACKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnPackName_Default((IEntity)pSDepSlnPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPACKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterFileId(boolean bl, PSDepSlnPack pSDepSlnPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPack.isPSDevCenterFileIdDirty() : !pSDepSlnPack.isPSDevCenterFileIdDirty()) {
            return null;
        }
        String string = pSDepSlnPack.getPSDevCenterFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterFileId_Default((IEntity)pSDepSlnPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnPack pSDepSlnPack, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSlnPack, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnPack pSDepSlnPack, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSlnPack, bl);
    }

    public Object getDataContextValue(PSDepSlnPack pSDepSlnPack, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSlnPack, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnPack pSDepSlnPack, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSlnPack, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPTOOLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DepToolType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PACKERRORINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PackErrorInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PACKSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PackState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNPACKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnPackId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNPACKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnPackName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterFileName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DepToolType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPTOOLTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PackErrorInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PACKERRORINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PackState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDepSlnPackId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNPACKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnPackName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNPACKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnPack pSDepSlnPack) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSlnPack)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnPack pSDepSlnPack) throws Exception {
        super.onUpdateParent((IEntity)pSDepSlnPack);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnPack pSDepSlnPack, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNPACK");
        if (!bl) {
            pSDepSlnPack.setCreateDate(null);
            pSDepSlnPack.setCreateMan(null);
            pSDepSlnPack.setPSDepSlnPackId(null);
            pSDepSlnPack.setPSDevCenterFileName(null);
            pSDepSlnPack.setUpdateDate(null);
            pSDepSlnPack.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnPack, xmlNode, bl);
        }
    }
}

