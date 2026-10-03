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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSubAppService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSubAppServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSSubSysDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSubSysDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSSFPkgService;
import net.ibizsys.pscore.srv.config.service.PSSFPkgServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubAppService;
import net.ibizsys.pscore.srv.config.service.PSSubAppServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubDEService;
import net.ibizsys.pscore.srv.config.service.PSSubDEServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubDEViewService;
import net.ibizsys.pscore.srv.config.service.PSSubDEViewServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubSysDMService;
import net.ibizsys.pscore.srv.config.service.PSSubSysDMServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubSysSFService;
import net.ibizsys.pscore.srv.config.service.PSSubSysSFServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerService;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysServiceBase
extends PSCoreSysServiceBase<PSSubSys> {
    private static final Log log = LogFactory.getLog(PSSubSysServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_SFFW = "SFFW";
    public static final String ACTION_X_ADDUPDATEMODELTASK = "X_ADDUPDATEMODELTASK";
    private PSSubSysDEModel pSSubSysDEModel;
    private PSSubSysDAO pSSubSysDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSubSysService";
    }

    public PSSubSysDEModel getPSSubSysDEModel() {
        if (this.pSSubSysDEModel == null) {
            try {
                this.pSSubSysDEModel = (PSSubSysDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSubSysDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSubSysDEModel();
    }

    public PSSubSysDAO getPSSubSysDAO() {
        if (this.pSSubSysDAO == null) {
            try {
                this.pSSubSysDAO = (PSSubSysDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSubSysDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSubSysDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_SFFW, (boolean)true) == 0) {
            return this.fetchSFFW(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDUPDATEMODELTASK, (boolean)true) == 0) {
            this.addUpdateModelTask((PSSubSys)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchSFFW(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_SFFW, false);
        return dBFetchResult;
    }

    public void addUpdateModelTask(PSSubSys pSSubSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDUPDATEMODELTASK, 0, pSSubSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSubSys, ACTION_X_ADDUPDATEMODELTASK);
        final PSSubSys pSSubSys2 = pSSubSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSubSysServiceBase.this.getService(), PSSubSysServiceBase.ACTION_X_ADDUPDATEMODELTASK, 40, pSSubSys2, null).getResult() != 1) {
                    PSSubSysServiceBase.this.onAddUpdateModelTask(pSSubSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDUPDATEMODELTASK, 99, pSSubSys, null);
        }
    }

    protected void onAddUpdateModelTask(PSSubSys pSSubSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDUPDATEMODELTASK]");
    }

    protected void onFillParentInfo(PSSubSys pSSubSys, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYS_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_PSSF(pSSubSys, pSSF);
            return;
        }
        super.onFillParentInfo(pSSubSys, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSF(PSSubSys pSSubSys, PSSF pSSF) throws Exception {
        pSSubSys.setPSSFId(pSSF.getPSSFId());
        pSSubSys.setPSSFName(pSSF.getPSSFName());
    }

    protected void onFillEntityFullInfo(PSSubSys pSSubSys, boolean bl) throws Exception {
        if (bl && pSSubSys.getValidFlag() == null) {
            pSSubSys.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSubSys, bl);
        this.onFillEntityFullInfo_PSSF(pSSubSys, bl);
    }

    protected void onFillEntityFullInfo_PSSF(PSSubSys pSSubSys, boolean bl) throws Exception {
        if (pSSubSys.isPSSFIdDirty()) {
            if (pSSubSys.getPSSFId() != null) {
                if (pSSubSys.getPSSFId() == null || pSSubSys.getPSSFName() == null) {
                    PSSF pSSF = pSSubSys.getPSSF();
                    pSSubSys.setPSSFName(pSSF.getPSSFName());
                }
            } else {
                pSSubSys.setPSSFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSubSys pSSubSys, boolean bl) throws Exception {
        super.onWriteBackParent(pSSubSys, bl);
    }

    public ArrayList<PSSubSys> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSSubSys> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSSubSys> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
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

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSubSys> arrayList = this.selectByPSSF(pSSF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYS_PSSF_PSSFID", "", iDataEntityModel.getName(), "PSSUBSYS", iDataEntityModel.getDataInfo(pSSF), arrayList.get(0)));
        }
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSubSys> arrayList = this.selectByPSSF(pSSF);
        for (PSSubSys pSSubSys : arrayList) {
            PSSubSys pSSubSys2 = (PSSubSys)this.getDEModel().createEntity();
            pSSubSys2.setPSSubSysId(pSSubSys.getPSSubSysId());
            pSSubSys2.setPSSFId(null);
            this.update(pSSubSys2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSSubSysServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSSubSysServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSubSys> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSSubSys pSSubSys : arrayList) {
            this.remove(pSSubSys);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSSubSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSSubSys> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSubSys pSSubSys) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppSubAppService)ServiceGlobal.getService(PSAppSubAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppSubAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSys(pSSubSys);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveBySFPSSubSys(pSSubSys);
        pSCoreSysServiceBase = (PSSFPkgService)ServiceGlobal.getService(PSSFPkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFPkgServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSys(pSSubSys);
        pSCoreSysServiceBase = (PSSubAppService)ServiceGlobal.getService(PSSubAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSys(pSSubSys);
        ((PSSubAppServiceBase)pSCoreSysServiceBase).removeByPSSubSys(pSSubSys);
        pSCoreSysServiceBase = (PSSubDEViewService)ServiceGlobal.getService(PSSubDEViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubDEViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSys(pSSubSys);
        ((PSSubDEViewServiceBase)pSCoreSysServiceBase).removeByPSSubSys(pSSubSys);
        pSCoreSysServiceBase = (PSSubDEService)ServiceGlobal.getService(PSSubDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSys(pSSubSys);
        ((PSSubDEServiceBase)pSCoreSysServiceBase).removeByPSSubSys(pSSubSys);
        pSCoreSysServiceBase = (PSSubSysDMService)ServiceGlobal.getService(PSSubSysDMService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysDMServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSys(pSSubSys);
        ((PSSubSysDMServiceBase)pSCoreSysServiceBase).removeByPSSubSys(pSSubSys);
        pSCoreSysServiceBase = (PSSubSysSFService)ServiceGlobal.getService(PSSubSysSFService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSFServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSys(pSSubSys);
        ((PSSubSysSFServiceBase)pSCoreSysServiceBase).removeByPSSubSys(pSSubSys);
        pSCoreSysServiceBase = (PSSubSysVerService)ServiceGlobal.getService(PSSubSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSys(pSSubSys);
        ((PSSubSysVerServiceBase)pSCoreSysServiceBase).removeByPSSubSys(pSSubSys);
        pSCoreSysServiceBase = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysRefServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSys(pSSubSys);
        super.onBeforeRemove(pSSubSys);
    }

    protected void replaceParentInfo(PSSubSys pSSubSys, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSubSys, cloneSession);
        if (pSSubSys.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSSubSys.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSSubSys, (PSSF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSubSys pSSubSys, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSubSys, bl);
    }

    protected void onCheckEntity(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DEModels(bl, pSSubSys, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSubSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSSubSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSSubSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFName(bl, pSSubSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysId(bl, pSSubSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysName(bl, pSSubSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSubSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SFFWFlag(bl, pSSubSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSubSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Version(bl, pSSubSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSubSys, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DEModels(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSys.isDEModelsDirty() : !pSSubSys.isDEModelsDirty()) {
            return null;
        }
        String string = pSSubSys.getDEModels();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEModels_Default(pSSubSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEMODELS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSys.isMemoDirty() : !pSSubSys.isMemoDirty()) {
            return null;
        }
        String string = pSSubSys.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSubSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSys.isPSDevSlnSysIdDirty() : !pSSubSys.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSSubSys.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSSubSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSys.isPSSFIdDirty() : !pSSubSys.isPSSFIdDirty()) {
            return null;
        }
        String string = pSSubSys.getPSSFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSSubSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFName(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSys.isPSSFNameDirty() : !pSSubSys.isPSSFNameDirty()) {
            return null;
        }
        String string = pSSubSys.getPSSFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFName_Default(pSSubSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysId(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSys.isPSSubSysIdDirty() && !bl2 : !pSSubSys.isPSSubSysIdDirty()) {
            return null;
        }
        String string = pSSubSys.getPSSubSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysId_Default(pSSubSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysName(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSys.isPSSubSysNameDirty() && !bl2 : !pSSubSys.isPSSubSysNameDirty()) {
            return null;
        }
        String string = pSSubSys.getPSSubSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysName_Default(pSSubSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSys.isPSSystemIdDirty() : !pSSubSys.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSubSys.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSubSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_SFFWFlag(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSys.isSFFWFlagDirty() && !bl2 : !pSSubSys.isSFFWFlagDirty()) {
            return null;
        }
        Integer n = pSSubSys.getSFFWFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SFFWFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_SFFWFlag_Default(pSSubSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SFFWFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSys.isValidFlagDirty() : !pSSubSys.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSubSys.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSubSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_Version(boolean bl, PSSubSys pSSubSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSys.isVersionDirty() : !pSSubSys.isVersionDirty()) {
            return null;
        }
        Integer n = pSSubSys.getVersion();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Version_Default(pSSubSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSubSys pSSubSys, boolean bl) throws Exception {
        super.onSyncEntity(pSSubSys, bl);
    }

    protected void onSyncIndexEntities(PSSubSys pSSubSys, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSubSys, bl);
    }

    public Object getDataContextValue(PSSubSys pSSubSys, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSubSys, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSubSys pSSubSys, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSubSys, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEMODELS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEModels_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SFFWFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SFFWFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VERSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Version_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DEModels_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEMODELS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SFFWFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Version_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSubSys pSSubSys) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSubSys)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSubSys pSSubSys) throws Exception {
        super.onUpdateParent(pSSubSys);
    }

    @Override
    protected void exportCurXmlModel(PSSubSys pSSubSys, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSUBSYS");
        if (!bl) {
            super.exportCurXmlModel(pSSubSys, xmlNode, bl);
        }
    }
}

