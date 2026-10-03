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
package net.ibizsys.pscore.srv.dynasys.service;

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
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaSysDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaSysDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaInstServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaSysServiceBase
extends PSCoreSysServiceBase<PSDynaSys> {
    private static final Log log = LogFactory.getLog(PSDynaSysServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_EXPORTDYNAMODEL = "ExportDynaModel";
    public static final String ACTION_INITDYNAMODEL = "InitDynaModel";
    private PSDynaSysDEModel pSDynaSysDEModel;
    private PSDynaSysDAO pSDynaSysDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService";
    }

    public PSDynaSysDEModel getPSDynaSysDEModel() {
        if (this.pSDynaSysDEModel == null) {
            try {
                this.pSDynaSysDEModel = (PSDynaSysDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaSysDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaSysDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaSysDEModel();
    }

    public PSDynaSysDAO getPSDynaSysDAO() {
        if (this.pSDynaSysDAO == null) {
            try {
                this.pSDynaSysDAO = (PSDynaSysDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaSysDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaSysDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaSysDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_EXPORTDYNAMODEL, (boolean)true) == 0) {
            this.exportDynaModel((PSDynaSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_INITDYNAMODEL, (boolean)true) == 0) {
            this.initDynaModel((PSDynaSys)iEntity);
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

    public void exportDynaModel(PSDynaSys pSDynaSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_EXPORTDYNAMODEL, 0, pSDynaSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDynaSys, ACTION_EXPORTDYNAMODEL);
        final PSDynaSys pSDynaSys2 = pSDynaSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDynaSysServiceBase.this.getService(), PSDynaSysServiceBase.ACTION_EXPORTDYNAMODEL, 40, pSDynaSys2, null).getResult() != 1) {
                    PSDynaSysServiceBase.this.onExportDynaModel(pSDynaSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_EXPORTDYNAMODEL, 99, pSDynaSys, null);
        }
    }

    protected void onExportDynaModel(PSDynaSys pSDynaSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ExportDynaModel]");
    }

    public void initDynaModel(PSDynaSys pSDynaSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITDYNAMODEL, 0, pSDynaSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDynaSys, ACTION_INITDYNAMODEL);
        final PSDynaSys pSDynaSys2 = pSDynaSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDynaSysServiceBase.this.getService(), PSDynaSysServiceBase.ACTION_INITDYNAMODEL, 40, pSDynaSys2, null).getResult() != 1) {
                    PSDynaSysServiceBase.this.onInitDynaModel(pSDynaSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITDYNAMODEL, 99, pSDynaSys, null);
        }
    }

    protected void onInitDynaModel(PSDynaSys pSDynaSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitDynaModel]");
    }

    protected void onFillParentInfo(PSDynaSys pSDynaSys, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNASYS_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDynaSys, pSSystem);
            return;
        }
        super.onFillParentInfo(pSDynaSys, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSystem(PSDynaSys pSDynaSys, PSSystem pSSystem) throws Exception {
        pSDynaSys.setPSSystemId(pSSystem.getPSSystemId());
        pSDynaSys.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSDynaSys pSDynaSys, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDynaSys, bl);
        this.onFillEntityFullInfo_PSSystem(pSDynaSys, bl);
    }

    protected void onFillEntityFullInfo_PSSystem(PSDynaSys pSDynaSys, boolean bl) throws Exception {
        if (pSDynaSys.isPSSystemIdDirty()) {
            if (pSDynaSys.getPSSystemId() != null) {
                if (pSDynaSys.getPSSystemId() == null || pSDynaSys.getPSSystemName() == null) {
                    PSSystem pSSystem = pSDynaSys.getPSSystem();
                    pSDynaSys.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSDynaSys.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDynaSys pSDynaSys, boolean bl) throws Exception {
        super.onWriteBackParent(pSDynaSys, bl);
    }

    public ArrayList<PSDynaSys> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDynaSys> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDynaSys> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
        ArrayList<PSDynaSys> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDynaSys pSDynaSys : arrayList) {
            PSDynaSys pSDynaSys2 = (PSDynaSys)this.getDEModel().createEntity();
            pSDynaSys2.setPSDynaSysId(pSDynaSys.getPSDynaSysId());
            pSDynaSys2.setPSSystemId(null);
            this.update(pSDynaSys2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaSysServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDynaSysServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDynaSysServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDynaSys> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDynaSys pSDynaSys : arrayList) {
            this.remove(pSDynaSys);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDynaSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDynaSys> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaSys pSDynaSys) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDynaAppService)ServiceGlobal.getService(PSDynaAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaAppServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaSys(pSDynaSys);
        pSCoreSysServiceBase = (PSDynaCodeListService)ServiceGlobal.getService(PSDynaCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaCodeListServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaSys(pSDynaSys);
        pSCoreSysServiceBase = (PSDynaDEService)ServiceGlobal.getService(PSDynaDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaDEServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaSys(pSDynaSys);
        pSCoreSysServiceBase = (PSDynaInstService)ServiceGlobal.getService(PSDynaInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaSys(pSDynaSys);
        pSCoreSysServiceBase = (PSDynaWFVerService)ServiceGlobal.getService(PSDynaWFVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaWFVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaSys(pSDynaSys);
        pSCoreSysServiceBase = (PSDynaWFService)ServiceGlobal.getService(PSDynaWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaWFServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaSys(pSDynaSys);
        super.onBeforeRemove(pSDynaSys);
    }

    protected void replaceParentInfo(PSDynaSys pSDynaSys, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDynaSys, cloneSession);
        if (pSDynaSys.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDynaSys.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDynaSys, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaSys pSDynaSys, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDynaSys, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaSys pSDynaSys, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogicName(bl, pSDynaSys, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDynaSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaSysId(bl, pSDynaSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaSysName(bl, pSDynaSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDynaSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSDynaSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDynaSys, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDynaSys pSDynaSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaSys.isLogicNameDirty() : !pSDynaSys.isLogicNameDirty()) {
            return null;
        }
        String string = pSDynaSys.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDynaSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaSys pSDynaSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaSys.isMemoDirty() : !pSDynaSys.isMemoDirty()) {
            return null;
        }
        String string = pSDynaSys.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDynaSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaSysId(boolean bl, PSDynaSys pSDynaSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaSys.isPSDynaSysIdDirty() && !bl2 : !pSDynaSys.isPSDynaSysIdDirty()) {
            return null;
        }
        String string = pSDynaSys.getPSDynaSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaSysId_Default(pSDynaSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaSysName(boolean bl, PSDynaSys pSDynaSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaSys.isPSDynaSysNameDirty() && !bl2 : !pSDynaSys.isPSDynaSysNameDirty()) {
            return null;
        }
        String string = pSDynaSys.getPSDynaSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaSysName_Default(pSDynaSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDynaSys pSDynaSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaSys.isPSSystemIdDirty() : !pSDynaSys.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDynaSys.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSDynaSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSDynaSys pSDynaSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaSys.isPSSystemNameDirty() : !pSDynaSys.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSDynaSys.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSDynaSys, bl2, bl3);
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

    protected void onSyncEntity(PSDynaSys pSDynaSys, boolean bl) throws Exception {
        super.onSyncEntity(pSDynaSys, bl);
    }

    protected void onSyncIndexEntities(PSDynaSys pSDynaSys, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDynaSys, bl);
    }

    public Object getDataContextValue(PSDynaSys pSDynaSys, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDynaSys, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaSys pSDynaSys, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDynaSys, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNASYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNASYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDynaSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNASYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNASYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDynaSys pSDynaSys) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDynaSys)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaSys pSDynaSys) throws Exception {
        super.onUpdateParent(pSDynaSys);
    }

    @Override
    protected void exportCurXmlModel(PSDynaSys pSDynaSys, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNASYS");
        if (!bl) {
            pSDynaSys.setCreateDate(null);
            pSDynaSys.setCreateMan(null);
            pSDynaSys.setPSDynaSysId(null);
            pSDynaSys.setUpdateDate(null);
            pSDynaSys.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaSys, xmlNode, bl);
        }
    }
}

