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
 *  net.ibizsys.paas.service.IServicePlugin
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
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSys;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSaaSSysDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSaaSSysDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSaaSSys;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSaaSSysServiceBase
extends PSCoreSysServiceBase<PSDepSaaSSys> {
    private static final Log log = LogFactory.getLog(PSDepSaaSSysServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_SYNCSYSVER = "SyncSysVer";
    private PSDepSaaSSysDEModel pSDepSaaSSysDEModel;
    private PSDepSaaSSysDAO pSDepSaaSSysDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSaaSSysService";
    }

    public PSDepSaaSSysDEModel getPSDepSaaSSysDEModel() {
        if (this.pSDepSaaSSysDEModel == null) {
            try {
                this.pSDepSaaSSysDEModel = (PSDepSaaSSysDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSaaSSysDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSaaSSysDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSaaSSysDEModel();
    }

    public PSDepSaaSSysDAO getPSDepSaaSSysDAO() {
        if (this.pSDepSaaSSysDAO == null) {
            try {
                this.pSDepSaaSSysDAO = (PSDepSaaSSysDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSaaSSysDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSaaSSysDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSaaSSysDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_SYNCSYSVER, (boolean)true) == 0) {
            this.syncSysVer((PSDepSaaSSys)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void syncSysVer(PSDepSaaSSys pSDepSaaSSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_SYNCSYSVER, 0, (IEntity)pSDepSaaSSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDepSaaSSys, ACTION_SYNCSYSVER);
        final PSDepSaaSSys pSDepSaaSSys2 = pSDepSaaSSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDepSaaSSysServiceBase.this.getService(), PSDepSaaSSysServiceBase.ACTION_SYNCSYSVER, 40, (IEntity)pSDepSaaSSys2, null).getResult() != 1) {
                    PSDepSaaSSysServiceBase.this.onSyncSysVer(pSDepSaaSSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_SYNCSYSVER, 99, (IEntity)pSDepSaaSSys, null);
        }
    }

    protected void onSyncSysVer(PSDepSaaSSys pSDepSaaSSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[SyncSysVer]");
    }

    protected void onFillParentInfo(PSDepSaaSSys pSDepSaaSSys, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSAASSYS_PSDEVCENTER_FROMDCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_FromDC(pSDepSaaSSys, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSAASSYS_PSSAASSYS_PSSAASSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysService", (SessionFactory)this.getSessionFactory());
            PSSaaSSys pSSaaSSys = (PSSaaSSys)iService.getDEModel().createEntity();
            pSSaaSSys.set("PSSAASSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSaaSSys);
            } else {
                iService.get((IEntity)pSSaaSSys);
            }
            this.onFillParentInfo_PSSaaSSys(pSDepSaaSSys, pSSaaSSys);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSaaSSys, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_FromDC(PSDepSaaSSys pSDepSaaSSys, PSDevCenter pSDevCenter) throws Exception {
        pSDepSaaSSys.setFromDCId(pSDevCenter.getPSDevCenterId());
        pSDepSaaSSys.setFromDCName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSaaSSys(PSDepSaaSSys pSDepSaaSSys, PSSaaSSys pSSaaSSys) throws Exception {
        pSDepSaaSSys.setPSSaaSSysId(pSSaaSSys.getPSSaaSSysId());
        pSDepSaaSSys.setPSSaaSSysName(pSSaaSSys.getPSSaaSSysName());
    }

    protected void onFillEntityFullInfo(PSDepSaaSSys pSDepSaaSSys, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSaaSSys, bl);
        this.onFillEntityFullInfo_FromDC(pSDepSaaSSys, bl);
        this.onFillEntityFullInfo_PSSaaSSys(pSDepSaaSSys, bl);
    }

    protected void onFillEntityFullInfo_FromDC(PSDepSaaSSys pSDepSaaSSys, boolean bl) throws Exception {
        if (pSDepSaaSSys.isFromDCIdDirty()) {
            if (pSDepSaaSSys.getFromDCId() != null) {
                if (pSDepSaaSSys.getFromDCId() == null || pSDepSaaSSys.getFromDCName() == null) {
                    PSDevCenter pSDevCenter = pSDepSaaSSys.getFromDC();
                    pSDepSaaSSys.setFromDCName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDepSaaSSys.setFromDCName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSaaSSys(PSDepSaaSSys pSDepSaaSSys, boolean bl) throws Exception {
        if (pSDepSaaSSys.isPSSaaSSysIdDirty()) {
            if (pSDepSaaSSys.getPSSaaSSysId() != null) {
                if (pSDepSaaSSys.getPSSaaSSysId() == null || pSDepSaaSSys.getPSSaaSSysName() == null) {
                    PSSaaSSys pSSaaSSys = pSDepSaaSSys.getPSSaaSSys();
                    pSDepSaaSSys.setPSSaaSSysName(pSSaaSSys.getPSSaaSSysName());
                }
            } else {
                pSDepSaaSSys.setPSSaaSSysName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDepSaaSSys pSDepSaaSSys, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSaaSSys, bl);
    }

    public ArrayList<PSDepSaaSSys> selectByFromDC(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByFromDC(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDepSaaSSys> selectByFromDC(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByFromDC(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDepSaaSSys> selectByFromDC(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FROMDCID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFromDCCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFromDCCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSaaSSys> selectByPSSaaSSys(PSSaaSSysBase pSSaaSSysBase) throws Exception {
        return this.selectByPSSaaSSys(pSSaaSSysBase, "", -1);
    }

    public ArrayList<PSDepSaaSSys> selectByPSSaaSSys(PSSaaSSysBase pSSaaSSysBase, String string) throws Exception {
        return this.selectByPSSaaSSys(pSSaaSSysBase, string, -1);
    }

    public ArrayList<PSDepSaaSSys> selectByPSSaaSSys(PSSaaSSysBase pSSaaSSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAASSYSID", (Object)pSSaaSSysBase.getPSSaaSSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSaaSSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSaaSSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByFromDC(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetFromDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDepSaaSSys> arrayList = this.selectByFromDC(pSDevCenter);
        for (PSDepSaaSSys pSDepSaaSSys : arrayList) {
            PSDepSaaSSys pSDepSaaSSys2 = (PSDepSaaSSys)this.getDEModel().createEntity();
            pSDepSaaSSys2.setPSDepSaaSSysId(pSDepSaaSSys.getPSDepSaaSSysId());
            pSDepSaaSSys2.setFromDCId(null);
            this.update(pSDepSaaSSys2);
        }
    }

    public void removeByFromDC(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSaaSSysServiceBase.this.onBeforeRemoveByFromDC(pSDevCenter2);
                PSDepSaaSSysServiceBase.this.internalRemoveByFromDC(pSDevCenter2);
                PSDepSaaSSysServiceBase.this.onAfterRemoveByFromDC(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByFromDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByFromDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDepSaaSSys> arrayList = this.selectByFromDC(pSDevCenter);
        this.onBeforeRemoveByFromDC(pSDevCenter, arrayList);
        for (PSDepSaaSSys pSDepSaaSSys : arrayList) {
            this.remove((IEntity)pSDepSaaSSys);
        }
        this.onAfterRemoveByFromDC(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByFromDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByFromDC(PSDevCenter pSDevCenter, ArrayList<PSDepSaaSSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFromDC(PSDevCenter pSDevCenter, ArrayList<PSDepSaaSSys> arrayList) throws Exception {
    }

    public void testRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
    }

    public void resetPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
        ArrayList<PSDepSaaSSys> arrayList = this.selectByPSSaaSSys(pSSaaSSys);
        for (PSDepSaaSSys pSDepSaaSSys : arrayList) {
            PSDepSaaSSys pSDepSaaSSys2 = (PSDepSaaSSys)this.getDEModel().createEntity();
            pSDepSaaSSys2.setPSDepSaaSSysId(pSDepSaaSSys.getPSDepSaaSSysId());
            pSDepSaaSSys2.setPSSaaSSysId(null);
            this.update(pSDepSaaSSys2);
        }
    }

    public void removeByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
        final PSSaaSSys pSSaaSSys2 = pSSaaSSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSaaSSysServiceBase.this.onBeforeRemoveByPSSaaSSys(pSSaaSSys2);
                PSDepSaaSSysServiceBase.this.internalRemoveByPSSaaSSys(pSSaaSSys2);
                PSDepSaaSSysServiceBase.this.onAfterRemoveByPSSaaSSys(pSSaaSSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
    }

    protected void internalRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
        ArrayList<PSDepSaaSSys> arrayList = this.selectByPSSaaSSys(pSSaaSSys);
        this.onBeforeRemoveByPSSaaSSys(pSSaaSSys, arrayList);
        for (PSDepSaaSSys pSDepSaaSSys : arrayList) {
            this.remove((IEntity)pSDepSaaSSys);
        }
        this.onAfterRemoveByPSSaaSSys(pSSaaSSys, arrayList);
    }

    protected void onAfterRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
    }

    protected void onBeforeRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys, ArrayList<PSDepSaaSSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys, ArrayList<PSDepSaaSSys> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSaaSSys pSDepSaaSSys) throws Exception {
        super.onBeforeRemove(pSDepSaaSSys);
    }

    protected void replaceParentInfo(PSDepSaaSSys pSDepSaaSSys, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSaaSSys, cloneSession);
        if (pSDepSaaSSys.getFromDCId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDepSaaSSys.getFromDCId())) != null) {
            this.onFillParentInfo_FromDC(pSDepSaaSSys, (PSDevCenter)iEntity);
        }
        if (pSDepSaaSSys.getPSSaaSSysId() != null && (iEntity = cloneSession.getEntity("PSSAASSYS", (Object)pSDepSaaSSys.getPSSaaSSysId())) != null) {
            this.onFillParentInfo_PSSaaSSys(pSDepSaaSSys, (PSSaaSSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSaaSSys pSDepSaaSSys, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSaaSSys, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSaaSSys pSDepSaaSSys, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_FromDCId(bl, pSDepSaaSSys, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FromDCName(bl, pSDepSaaSSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSaaSSysId(bl, pSDepSaaSSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSaaSSysName(bl, pSDepSaaSSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysId(bl, pSDepSaaSSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysName(bl, pSDepSaaSSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSaaSSys, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_FromDCId(boolean bl, PSDepSaaSSys pSDepSaaSSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSys.isFromDCIdDirty() : !pSDepSaaSSys.isFromDCIdDirty()) {
            return null;
        }
        String string = pSDepSaaSSys.getFromDCId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FromDCId_Default((IEntity)pSDepSaaSSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROMDCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FromDCName(boolean bl, PSDepSaaSSys pSDepSaaSSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSys.isFromDCNameDirty() : !pSDepSaaSSys.isFromDCNameDirty()) {
            return null;
        }
        String string = pSDepSaaSSys.getFromDCName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FromDCName_Default((IEntity)pSDepSaaSSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROMDCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSaaSSysId(boolean bl, PSDepSaaSSys pSDepSaaSSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSys.isPSDepSaaSSysIdDirty() && !bl2 : !pSDepSaaSSys.isPSDepSaaSSysIdDirty()) {
            return null;
        }
        String string = pSDepSaaSSys.getPSDepSaaSSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSaaSSysId_Default((IEntity)pSDepSaaSSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSaaSSysName(boolean bl, PSDepSaaSSys pSDepSaaSSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSys.isPSDepSaaSSysNameDirty() && !bl2 : !pSDepSaaSSys.isPSDepSaaSSysNameDirty()) {
            return null;
        }
        String string = pSDepSaaSSys.getPSDepSaaSSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSaaSSysName_Default((IEntity)pSDepSaaSSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysId(boolean bl, PSDepSaaSSys pSDepSaaSSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSys.isPSSaaSSysIdDirty() && !bl2 : !pSDepSaaSSys.isPSSaaSSysIdDirty()) {
            return null;
        }
        String string = pSDepSaaSSys.getPSSaaSSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysId_Default((IEntity)pSDepSaaSSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysName(boolean bl, PSDepSaaSSys pSDepSaaSSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSys.isPSSaaSSysNameDirty() && !bl2 : !pSDepSaaSSys.isPSSaaSSysNameDirty()) {
            return null;
        }
        String string = pSDepSaaSSys.getPSSaaSSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysName_Default((IEntity)pSDepSaaSSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSaaSSys pSDepSaaSSys, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSaaSSys, bl);
    }

    protected void onSyncIndexEntities(PSDepSaaSSys pSDepSaaSSys, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSaaSSys, bl);
    }

    public Object getDataContextValue(PSDepSaaSSys pSDepSaaSSys, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSaaSSys, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSaaSSys pSDepSaaSSys, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSaaSSys, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMDCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromDCId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMDCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromDCName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSAASSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSaaSSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSAASSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSaaSSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FromDCId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FROMDCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FromDCName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FROMDCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSaaSSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSAASSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSaaSSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSAASSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSaaSSys pSDepSaaSSys) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSaaSSys)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSaaSSys pSDepSaaSSys) throws Exception {
        super.onUpdateParent((IEntity)pSDepSaaSSys);
    }

    @Override
    protected void exportCurXmlModel(PSDepSaaSSys pSDepSaaSSys, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSAASSYS");
        if (!bl) {
            pSDepSaaSSys.setCreateDate(null);
            pSDepSaaSSys.setCreateMan(null);
            pSDepSaaSSys.setPSDepSaaSSysId(null);
            pSDepSaaSSys.setPSSaaSSysId(null);
            pSDepSaaSSys.setPSSaaSSysName(null);
            pSDepSaaSSys.setUpdateDate(null);
            pSDepSaaSSys.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSaaSSys, xmlNode, bl);
        }
    }
}

