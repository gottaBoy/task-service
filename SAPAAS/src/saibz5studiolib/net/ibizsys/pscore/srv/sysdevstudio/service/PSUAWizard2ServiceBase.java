/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSUAWizard2DAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUAWizard2DEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUAWizard2;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUAWizard2ServiceBase
extends PSCoreSysServiceBase<PSUAWizard2> {
    private static final Log log = LogFactory.getLog(PSUAWizard2ServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_ADDIMPSUBSYSMODELTASK = "X_ADDIMPSUBSYSMODELTASK";
    public static final String ACTION_X_ADDINITAPPMODELTASK = "X_ADDINITAPPMODELTASK";
    public static final String ACTION_X_ADDINITSYSDEDBMODELTASK = "X_ADDINITSYSDEDBMODELTASK";
    public static final String ACTION_X_ADDINITSYSMODELTASK = "X_ADDINITSYSMODELTASK";
    public static final String ACTION_X_ADDSYNCSUBSYSDBMODELTASK = "X_ADDSYNCSUBSYSDBMODELTASK";
    public static final String ACTION_X_CHANGEPWD = "X_CHANGEPWD";
    private PSUAWizard2DEModel pSUAWizard2DEModel;
    private PSUAWizard2DAO pSUAWizard2DAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSUAWizard2Service";
    }

    public PSUAWizard2DEModel getPSUAWizard2DEModel() {
        if (this.pSUAWizard2DEModel == null) {
            try {
                this.pSUAWizard2DEModel = (PSUAWizard2DEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUAWizard2DEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUAWizard2DEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUAWizard2DEModel();
    }

    public PSUAWizard2DAO getPSUAWizard2DAO() {
        if (this.pSUAWizard2DAO == null) {
            try {
                this.pSUAWizard2DAO = (PSUAWizard2DAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSUAWizard2DAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUAWizard2DAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUAWizard2DAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDIMPSUBSYSMODELTASK, (boolean)true) == 0) {
            this.addImpSubSysModelTask((PSUAWizard2)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDINITAPPMODELTASK, (boolean)true) == 0) {
            this.addInitAppModelTask((PSUAWizard2)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDINITSYSDEDBMODELTASK, (boolean)true) == 0) {
            this.addInitSysDEDBModelTask((PSUAWizard2)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDINITSYSMODELTASK, (boolean)true) == 0) {
            this.addInitSysModelTask((PSUAWizard2)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDSYNCSUBSYSDBMODELTASK, (boolean)true) == 0) {
            this.addSyncSubSysDBModelTask((PSUAWizard2)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_CHANGEPWD, (boolean)true) == 0) {
            this.changePwd((PSUAWizard2)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void addImpSubSysModelTask(PSUAWizard2 pSUAWizard2) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDIMPSUBSYSMODELTASK, 0, (IEntity)pSUAWizard2, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSUAWizard2, ACTION_X_ADDIMPSUBSYSMODELTASK);
        final PSUAWizard2 pSUAWizard22 = pSUAWizard2;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSUAWizard2ServiceBase.this.getService(), PSUAWizard2ServiceBase.ACTION_X_ADDIMPSUBSYSMODELTASK, 40, (IEntity)pSUAWizard22, null).getResult() != 1) {
                    PSUAWizard2ServiceBase.this.onAddImpSubSysModelTask(pSUAWizard22);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDIMPSUBSYSMODELTASK, 99, (IEntity)pSUAWizard2, null);
        }
    }

    protected void onAddImpSubSysModelTask(PSUAWizard2 pSUAWizard2) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDIMPSUBSYSMODELTASK]");
    }

    public void addInitAppModelTask(PSUAWizard2 pSUAWizard2) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDINITAPPMODELTASK, 0, (IEntity)pSUAWizard2, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSUAWizard2, ACTION_X_ADDINITAPPMODELTASK);
        final PSUAWizard2 pSUAWizard22 = pSUAWizard2;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSUAWizard2ServiceBase.this.getService(), PSUAWizard2ServiceBase.ACTION_X_ADDINITAPPMODELTASK, 40, (IEntity)pSUAWizard22, null).getResult() != 1) {
                    PSUAWizard2ServiceBase.this.onAddInitAppModelTask(pSUAWizard22);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDINITAPPMODELTASK, 99, (IEntity)pSUAWizard2, null);
        }
    }

    protected void onAddInitAppModelTask(PSUAWizard2 pSUAWizard2) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDINITAPPMODELTASK]");
    }

    public void addInitSysDEDBModelTask(PSUAWizard2 pSUAWizard2) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDINITSYSDEDBMODELTASK, 0, (IEntity)pSUAWizard2, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSUAWizard2, ACTION_X_ADDINITSYSDEDBMODELTASK);
        final PSUAWizard2 pSUAWizard22 = pSUAWizard2;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSUAWizard2ServiceBase.this.getService(), PSUAWizard2ServiceBase.ACTION_X_ADDINITSYSDEDBMODELTASK, 40, (IEntity)pSUAWizard22, null).getResult() != 1) {
                    PSUAWizard2ServiceBase.this.onAddInitSysDEDBModelTask(pSUAWizard22);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDINITSYSDEDBMODELTASK, 99, (IEntity)pSUAWizard2, null);
        }
    }

    protected void onAddInitSysDEDBModelTask(PSUAWizard2 pSUAWizard2) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDINITSYSDEDBMODELTASK]");
    }

    public void addInitSysModelTask(PSUAWizard2 pSUAWizard2) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDINITSYSMODELTASK, 0, (IEntity)pSUAWizard2, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSUAWizard2, ACTION_X_ADDINITSYSMODELTASK);
        final PSUAWizard2 pSUAWizard22 = pSUAWizard2;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSUAWizard2ServiceBase.this.getService(), PSUAWizard2ServiceBase.ACTION_X_ADDINITSYSMODELTASK, 40, (IEntity)pSUAWizard22, null).getResult() != 1) {
                    PSUAWizard2ServiceBase.this.onAddInitSysModelTask(pSUAWizard22);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDINITSYSMODELTASK, 99, (IEntity)pSUAWizard2, null);
        }
    }

    protected void onAddInitSysModelTask(PSUAWizard2 pSUAWizard2) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDINITSYSMODELTASK]");
    }

    public void addSyncSubSysDBModelTask(PSUAWizard2 pSUAWizard2) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCSUBSYSDBMODELTASK, 0, (IEntity)pSUAWizard2, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSUAWizard2, ACTION_X_ADDSYNCSUBSYSDBMODELTASK);
        final PSUAWizard2 pSUAWizard22 = pSUAWizard2;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSUAWizard2ServiceBase.this.getService(), PSUAWizard2ServiceBase.ACTION_X_ADDSYNCSUBSYSDBMODELTASK, 40, (IEntity)pSUAWizard22, null).getResult() != 1) {
                    PSUAWizard2ServiceBase.this.onAddSyncSubSysDBModelTask(pSUAWizard22);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCSUBSYSDBMODELTASK, 99, (IEntity)pSUAWizard2, null);
        }
    }

    protected void onAddSyncSubSysDBModelTask(PSUAWizard2 pSUAWizard2) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDSYNCSUBSYSDBMODELTASK]");
    }

    public void changePwd(PSUAWizard2 pSUAWizard2) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_CHANGEPWD, 0, (IEntity)pSUAWizard2, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSUAWizard2, ACTION_X_CHANGEPWD);
        final PSUAWizard2 pSUAWizard22 = pSUAWizard2;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSUAWizard2ServiceBase.this.getService(), PSUAWizard2ServiceBase.ACTION_X_CHANGEPWD, 40, (IEntity)pSUAWizard22, null).getResult() != 1) {
                    PSUAWizard2ServiceBase.this.onChangePwd(pSUAWizard22);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_CHANGEPWD, 99, (IEntity)pSUAWizard2, null);
        }
    }

    protected void onChangePwd(PSUAWizard2 pSUAWizard2) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_CHANGEPWD]");
    }

    protected void onFillParentInfo(PSUAWizard2 pSUAWizard2, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo((IEntity)pSUAWizard2, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSUAWizard2 pSUAWizard2, boolean bl) throws Exception {
        if (bl && pSUAWizard2.getPSUAWizard2Name() == null) {
            pSUAWizard2.setPSUAWizard2Name((String)this.getDefaultValue(this.getWebContext(), "", "\u5411\u5bfc\u64cd\u4f5c", 25));
        }
        super.onFillEntityFullInfo((IEntity)pSUAWizard2, bl);
    }

    protected void onWriteBackParent(PSUAWizard2 pSUAWizard2, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSUAWizard2, bl);
    }

    @Override
    protected void onBeforeRemove(PSUAWizard2 pSUAWizard2) throws Exception {
        super.onBeforeRemove(pSUAWizard2);
    }

    protected void onRemoveEntityUncopyValues(PSUAWizard2 pSUAWizard2, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSUAWizard2, bl);
    }

    protected void onCheckEntity(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionData(bl, pSUAWizard2, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param5(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param6(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param7(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param8(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSConsoleId(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUAWizard2Id(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUAWizard2Name(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardMode(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam10(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam11(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam12(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam13(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam14(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam15(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam16(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam2(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam3(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam4(bl, pSUAWizard2, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSUAWizard2, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionData(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isActionDataDirty() : !pSUAWizard2.isActionDataDirty()) {
            return null;
        }
        String string = pSUAWizard2.getActionData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionData_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param5(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isParam5Dirty() : !pSUAWizard2.isParam5Dirty()) {
            return null;
        }
        String string = pSUAWizard2.getParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param5_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param6(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isParam6Dirty() : !pSUAWizard2.isParam6Dirty()) {
            return null;
        }
        String string = pSUAWizard2.getParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param6_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param7(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isParam7Dirty() : !pSUAWizard2.isParam7Dirty()) {
            return null;
        }
        String string = pSUAWizard2.getParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param7_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param8(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isParam8Dirty() : !pSUAWizard2.isParam8Dirty()) {
            return null;
        }
        String string = pSUAWizard2.getParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param8_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSConsoleId(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isPSDSConsoleIdDirty() : !pSUAWizard2.isPSDSConsoleIdDirty()) {
            return null;
        }
        String string = pSUAWizard2.getPSDSConsoleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSConsoleId_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSCONSOLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUAWizard2Id(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isPSUAWizard2IdDirty() && !bl2 : !pSUAWizard2.isPSUAWizard2IdDirty()) {
            return null;
        }
        String string = pSUAWizard2.getPSUAWizard2Id();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUAWIZARD2ID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUAWizard2Id_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUAWIZARD2ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUAWizard2Name(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isPSUAWizard2NameDirty() && !bl2 : !pSUAWizard2.isPSUAWizard2NameDirty()) {
            return null;
        }
        String string = pSUAWizard2.getPSUAWizard2Name();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUAWIZARD2NAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUAWizard2Name_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUAWIZARD2NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardMode(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardModeDirty() : !pSUAWizard2.isWizardModeDirty()) {
            return null;
        }
        String string = pSUAWizard2.getWizardMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardMode_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardParamDirty() : !pSUAWizard2.isWizardParamDirty()) {
            return null;
        }
        String string = pSUAWizard2.getWizardParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardParam_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam10(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardParam10Dirty() : !pSUAWizard2.isWizardParam10Dirty()) {
            return null;
        }
        Integer n = pSUAWizard2.getWizardParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WizardParam10_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam11(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardParam11Dirty() : !pSUAWizard2.isWizardParam11Dirty()) {
            return null;
        }
        Integer n = pSUAWizard2.getWizardParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WizardParam11_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam12(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardParam12Dirty() : !pSUAWizard2.isWizardParam12Dirty()) {
            return null;
        }
        Integer n = pSUAWizard2.getWizardParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WizardParam12_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam13(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardParam13Dirty() : !pSUAWizard2.isWizardParam13Dirty()) {
            return null;
        }
        Integer n = pSUAWizard2.getWizardParam13();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WizardParam13_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM13");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam14(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardParam14Dirty() : !pSUAWizard2.isWizardParam14Dirty()) {
            return null;
        }
        Integer n = pSUAWizard2.getWizardParam14();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WizardParam14_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM14");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam15(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardParam15Dirty() : !pSUAWizard2.isWizardParam15Dirty()) {
            return null;
        }
        Timestamp timestamp = pSUAWizard2.getWizardParam15();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WizardParam15_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM15");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam16(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardParam16Dirty() : !pSUAWizard2.isWizardParam16Dirty()) {
            return null;
        }
        Timestamp timestamp = pSUAWizard2.getWizardParam16();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WizardParam16_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM16");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam2(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardParam2Dirty() : !pSUAWizard2.isWizardParam2Dirty()) {
            return null;
        }
        String string = pSUAWizard2.getWizardParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardParam2_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam3(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardParam3Dirty() : !pSUAWizard2.isWizardParam3Dirty()) {
            return null;
        }
        String string = pSUAWizard2.getWizardParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardParam3_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam4(boolean bl, PSUAWizard2 pSUAWizard2, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUAWizard2.isWizardParam4Dirty() : !pSUAWizard2.isWizardParam4Dirty()) {
            return null;
        }
        String string = pSUAWizard2.getWizardParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardParam4_Default((IEntity)pSUAWizard2, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSUAWizard2 pSUAWizard2, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSUAWizard2, bl);
    }

    protected void onSyncIndexEntities(PSUAWizard2 pSUAWizard2, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSUAWizard2, bl);
    }

    public Object getDataContextValue(PSUAWizard2 pSUAWizard2, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSUAWizard2, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSUAWizard2 pSUAWizard2, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSUAWizard2, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSCONSOLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSConsoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUAWIZARD2ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUAWizard2Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUAWIZARD2NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUAWizard2Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM13", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam13_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM14", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam14_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM15", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam15_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM16", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam16_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam4_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONDATA", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_Param5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM5", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM6", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM7", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM8", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDSConsoleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSCONSOLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUAWizard2Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUAWIZARD2ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUAWizard2Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUAWIZARD2NAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_WizardMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIZARDMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WizardParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIZARDPARAM", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WizardParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WizardParam11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WizardParam12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WizardParam13_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WizardParam14_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WizardParam15_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WizardParam16_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WizardParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIZARDPARAM2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WizardParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIZARDPARAM3", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WizardParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIZARDPARAM4", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSUAWizard2 pSUAWizard2) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSUAWizard2)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUAWizard2 pSUAWizard2) throws Exception {
        super.onUpdateParent((IEntity)pSUAWizard2);
    }

    @Override
    protected void exportCurXmlModel(PSUAWizard2 pSUAWizard2, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUAWIZARD2");
        if (!bl) {
            super.exportCurXmlModel(pSUAWizard2, xmlNode, bl);
        }
    }
}

