/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.ActionContext
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDELogicModel
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
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDELogicModel;
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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModuleBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEUAWizardDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEUAWizardDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAWizard;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUAWizardServiceBase
extends PSCoreSysServiceBase<PSDEUAWizard> {
    private static final Log log = LogFactory.getLog(PSDEUAWizardServiceBase.class);
    public static final String DATASET_CURDEDEFNAME = "CurDEDEFName";
    public static final String DATASET_CURDEDEFNAME2 = "CurDEDEFName2";
    public static final String DATASET_CURDEDQCONDCONDVALUE = "CurDEDQCondCondValue";
    public static final String DATASET_CURDEFCODENAME = "CurDEFCodeName";
    public static final String DATASET_CURDEFDCONDVALUE = "CurDEFDCondValue";
    public static final String DATASET_CURDELNPARAMORDER = "CurDELNParamOrder";
    public static final String DATASET_CURDELOGICDSTPARAMKEY = "CurDELogicDstParamKey";
    public static final String DATASET_CURDELOGICSRCPARAMKEY = "CurDELogicSrcParamKey";
    public static final String DATASET_CURDEMSSTATE2VALUE = "CurDEMSState2Value";
    public static final String DATASET_CURDEMSSTATE3VALUE = "CurDEMSState3Value";
    public static final String DATASET_CURDEMSSTATEVALUE = "CurDEMSStateValue";
    public static final String DATASET_CURDEVIEWRVMODE = "CurDEViewRVMode";
    public static final String DATASET_CURDEVIEWRVPARAM = "CurDEViewRVParam";
    public static final String DATASET_CURDSTDELNPARAMKEY = "CurDstDELNParamKey";
    public static final String DATASET_CURJITUSER = "CurJITUser";
    public static final String DATASET_CURMODELORDER = "CurModelOrder";
    public static final String DATASET_CURSFEXCEPTION = "CurSFException";
    public static final String DATASET_CURSRCDELNPARAMKEY = "CurSrcDELNParamKey";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_VALUEFMT = "ValueFmt";
    public static final String ACTION_BATADDAPPVIEW = "BatAddAppView";
    public static final String ACTION_GETBATADDAPPVIEWDRAFT = "GetBatAddAppViewDraft";
    public static final String ACTION_GETBATADDAPPVIEWDRAFT2 = "GetBatAddAppViewDraft2";
    public static final String ACTION_GETDEMFCFG = "GetDEMFCfg";
    public static final String ACTION_UPDATEDEMFCFG = "UpdateDEMFCfg";
    private PSDEUAWizardDEModel pSDEUAWizardDEModel;
    private PSDEUAWizardDAO pSDEUAWizardDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEUAWizardService";
    }

    public PSDEUAWizardDEModel getPSDEUAWizardDEModel() {
        if (this.pSDEUAWizardDEModel == null) {
            try {
                this.pSDEUAWizardDEModel = (PSDEUAWizardDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEUAWizardDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUAWizardDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEUAWizardDEModel();
    }

    public PSDEUAWizardDAO getPSDEUAWizardDAO() {
        if (this.pSDEUAWizardDAO == null) {
            try {
                this.pSDEUAWizardDAO = (PSDEUAWizardDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEUAWizardDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUAWizardDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEUAWizardDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEDEFNAME, (boolean)true) == 0) {
            return this.fetchCurDEDEFName(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEDEFNAME2, (boolean)true) == 0) {
            return this.fetchCurDEDEFName2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEDQCONDCONDVALUE, (boolean)true) == 0) {
            return this.fetchCurDEDQCondCondValue(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEFCODENAME, (boolean)true) == 0) {
            return this.fetchCurDEFCodeName(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEFDCONDVALUE, (boolean)true) == 0) {
            return this.fetchCurDEFDCondValue(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDELNPARAMORDER, (boolean)true) == 0) {
            return this.fetchCurDELNParamOrder(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDELOGICDSTPARAMKEY, (boolean)true) == 0) {
            return this.fetchCurDELogicDstParamKey(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDELOGICSRCPARAMKEY, (boolean)true) == 0) {
            return this.fetchCurDELogicSrcParamKey(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEMSSTATE2VALUE, (boolean)true) == 0) {
            return this.fetchCurDEMSState2Value(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEMSSTATE3VALUE, (boolean)true) == 0) {
            return this.fetchCurDEMSState3Value(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEMSSTATEVALUE, (boolean)true) == 0) {
            return this.fetchCurDEMSStateValue(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEVIEWRVMODE, (boolean)true) == 0) {
            return this.fetchCurDEViewRVMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEVIEWRVPARAM, (boolean)true) == 0) {
            return this.fetchCurDEViewRVParam(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDSTDELNPARAMKEY, (boolean)true) == 0) {
            return this.fetchCurDstDELNParamKey(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURJITUSER, (boolean)true) == 0) {
            return this.fetchCurJITUser(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMODELORDER, (boolean)true) == 0) {
            return this.fetchCurModelOrder(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSFEXCEPTION, (boolean)true) == 0) {
            return this.fetchCurSFException(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSRCDELNPARAMKEY, (boolean)true) == 0) {
            return this.fetchCurSrcDELNParamKey(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALUEFMT, (boolean)true) == 0) {
            return this.fetchValueFmt(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_BATADDAPPVIEW, (boolean)true) == 0) {
            this.batAddAppView((PSDEUAWizard)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETBATADDAPPVIEWDRAFT, (boolean)true) == 0) {
            this.getBatAddAppViewDraft((PSDEUAWizard)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETBATADDAPPVIEWDRAFT2, (boolean)true) == 0) {
            this.getBatAddAppViewDraft2((PSDEUAWizard)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDEMFCFG, (boolean)true) == 0) {
            this.getDEMFCfg((PSDEUAWizard)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEDEMFCFG, (boolean)true) == 0) {
            this.updateDEMFCfg((PSDEUAWizard)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDEDEFName(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEDEFNAME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEDEFName2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEDEFNAME2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEDQCondCondValue(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEDQCONDCONDVALUE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEFCodeName(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEFCODENAME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEFDCondValue(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEFDCONDVALUE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDELNParamOrder(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDELNPARAMORDER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDELogicDstParamKey(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDELOGICDSTPARAMKEY, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDELogicSrcParamKey(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDELOGICSRCPARAMKEY, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEMSState2Value(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEMSSTATE2VALUE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEMSState3Value(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEMSSTATE3VALUE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEMSStateValue(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEMSSTATEVALUE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEViewRVMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEVIEWRVMODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEViewRVParam(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEVIEWRVPARAM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDstDELNParamKey(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDSTDELNPARAMKEY, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurJITUser(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURJITUSER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurModelOrder(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMODELORDER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSFException(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSFEXCEPTION, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSrcDELNParamKey(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSRCDELNPARAMKEY, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchValueFmt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALUEFMT, false);
        return dBFetchResult;
    }

    public void batAddAppView(PSDEUAWizard pSDEUAWizard) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_BATADDAPPVIEW, 0, (IEntity)pSDEUAWizard, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEUAWizard, ACTION_BATADDAPPVIEW);
        final PSDEUAWizard pSDEUAWizard2 = pSDEUAWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEUAWizardServiceBase.this.getService(), PSDEUAWizardServiceBase.ACTION_BATADDAPPVIEW, 40, (IEntity)pSDEUAWizard2, null).getResult() != 1) {
                    PSDEUAWizardServiceBase.this.onBatAddAppView(pSDEUAWizard2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_BATADDAPPVIEW, 99, (IEntity)pSDEUAWizard, null);
        }
    }

    protected void onBatAddAppView(PSDEUAWizard pSDEUAWizard) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[BatAddAppView]");
    }

    public void getBatAddAppViewDraft(PSDEUAWizard pSDEUAWizard) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETBATADDAPPVIEWDRAFT, 0, (IEntity)pSDEUAWizard, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEUAWizard, ACTION_GETBATADDAPPVIEWDRAFT);
        final PSDEUAWizard pSDEUAWizard2 = pSDEUAWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEUAWizardServiceBase.this.getService(), PSDEUAWizardServiceBase.ACTION_GETBATADDAPPVIEWDRAFT, 40, (IEntity)pSDEUAWizard2, null).getResult() != 1) {
                    PSDEUAWizardServiceBase.this.onGetBatAddAppViewDraft(pSDEUAWizard2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETBATADDAPPVIEWDRAFT, 99, (IEntity)pSDEUAWizard, null);
        }
    }

    protected void onGetBatAddAppViewDraft(PSDEUAWizard pSDEUAWizard) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetBatAddAppViewDraft]");
    }

    public void getDEMFCfg(PSDEUAWizard pSDEUAWizard) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDEMFCFG, 0, (IEntity)pSDEUAWizard, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEUAWizard, ACTION_GETDEMFCFG);
        final PSDEUAWizard pSDEUAWizard2 = pSDEUAWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEUAWizardServiceBase.this.getService(), PSDEUAWizardServiceBase.ACTION_GETDEMFCFG, 40, (IEntity)pSDEUAWizard2, null).getResult() != 1) {
                    PSDEUAWizardServiceBase.this.onGetDEMFCfg(pSDEUAWizard2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDEMFCFG, 99, (IEntity)pSDEUAWizard, null);
        }
    }

    protected void onGetDEMFCfg(PSDEUAWizard pSDEUAWizard) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDEMFCfg]");
    }

    public void updateDEMFCfg(PSDEUAWizard pSDEUAWizard) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEDEMFCFG, 0, (IEntity)pSDEUAWizard, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEUAWizard, ACTION_UPDATEDEMFCFG);
        final PSDEUAWizard pSDEUAWizard2 = pSDEUAWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEUAWizardServiceBase.this.getService(), PSDEUAWizardServiceBase.ACTION_UPDATEDEMFCFG, 40, (IEntity)pSDEUAWizard2, null).getResult() != 1) {
                    PSDEUAWizardServiceBase.this.onUpdateDEMFCfg(pSDEUAWizard2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEDEMFCFG, 99, (IEntity)pSDEUAWizard, null);
        }
    }

    protected void onUpdateDEMFCfg(PSDEUAWizard pSDEUAWizard) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateDEMFCfg]");
    }

    public void getBatAddAppViewDraft2(PSDEUAWizard pSDEUAWizard) throws Exception {
        final PSDEUAWizard pSDEUAWizard2 = pSDEUAWizard;
        pSDEUAWizard2.setSessionFactory(this.getSessionFactory());
        this.testDEMainStateAction((IEntity)pSDEUAWizard, ACTION_GETBATADDAPPVIEWDRAFT2);
        final IDELogicModel iDELogicModel = (IDELogicModel)this.getPSDEUAWizardDEModel().getDELogic(ACTION_GETBATADDAPPVIEWDRAFT);
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                ActionContext actionContext = new ActionContext(null);
                actionContext.setParam(iDELogicModel.getDefaultParamName(), (Object)pSDEUAWizard2);
                actionContext.setSessionFactory(PSDEUAWizardServiceBase.this.getSessionFactory());
                iDELogicModel.execute((IActionContext)actionContext);
            }
        });
    }

    protected void onFillParentInfo(PSDEUAWizard pSDEUAWizard, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUAWIZARD_PSAPPMODULE_PSAPPMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService", (SessionFactory)this.getSessionFactory());
            PSAppModule pSAppModule = (PSAppModule)iService.getDEModel().createEntity();
            pSAppModule.set("PSAPPMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppModule);
            } else {
                iService.get((IEntity)pSAppModule);
            }
            this.onFillParentInfo_PSAppModule(pSDEUAWizard, pSAppModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUAWIZARD_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSDEUAWizard, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUAWIZARD_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDEUAWizard, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEUAWizard, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppModule(PSDEUAWizard pSDEUAWizard, PSAppModule pSAppModule) throws Exception {
        pSDEUAWizard.setPSAppModuleId(pSAppModule.getPSAppModuleId());
        pSDEUAWizard.setPSAppModuleName(pSAppModule.getPSAppModuleName());
    }

    protected void onFillParentInfo_PSSysApp(PSDEUAWizard pSDEUAWizard, PSSysApp pSSysApp) throws Exception {
        pSDEUAWizard.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSDEUAWizard.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSystem(PSDEUAWizard pSDEUAWizard, PSSystem pSSystem) throws Exception {
        pSDEUAWizard.setPSSystemId(pSSystem.getPSSystemId());
        pSDEUAWizard.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSDEUAWizard pSDEUAWizard, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEUAWizard, bl);
        this.onFillEntityFullInfo_PSAppModule(pSDEUAWizard, bl);
        this.onFillEntityFullInfo_PSSysApp(pSDEUAWizard, bl);
        this.onFillEntityFullInfo_PSSystem(pSDEUAWizard, bl);
    }

    protected void onFillEntityFullInfo_PSAppModule(PSDEUAWizard pSDEUAWizard, boolean bl) throws Exception {
        if (pSDEUAWizard.isPSAppModuleIdDirty()) {
            if (pSDEUAWizard.getPSAppModuleId() != null) {
                if (pSDEUAWizard.getPSAppModuleId() == null || pSDEUAWizard.getPSAppModuleName() == null) {
                    PSAppModule pSAppModule = pSDEUAWizard.getPSAppModule();
                    pSDEUAWizard.setPSAppModuleName(pSAppModule.getPSAppModuleName());
                }
            } else {
                pSDEUAWizard.setPSAppModuleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysApp(PSDEUAWizard pSDEUAWizard, boolean bl) throws Exception {
        if (pSDEUAWizard.isPSSysAppIdDirty()) {
            if (pSDEUAWizard.getPSSysAppId() != null) {
                if (pSDEUAWizard.getPSSysAppId() == null || pSDEUAWizard.getPSSysAppName() == null) {
                    PSSysApp pSSysApp = pSDEUAWizard.getPSSysApp();
                    pSDEUAWizard.setPSSysAppName(pSSysApp.getPSSysAppName());
                }
            } else {
                pSDEUAWizard.setPSSysAppName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSDEUAWizard pSDEUAWizard, boolean bl) throws Exception {
        if (pSDEUAWizard.isPSSystemIdDirty()) {
            if (pSDEUAWizard.getPSSystemId() != null) {
                if (pSDEUAWizard.getPSSystemId() == null || pSDEUAWizard.getPSSystemName() == null) {
                    PSSystem pSSystem = pSDEUAWizard.getPSSystem();
                    pSDEUAWizard.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSDEUAWizard.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEUAWizard pSDEUAWizard, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEUAWizard, bl);
    }

    public ArrayList<PSDEUAWizard> selectByPSAppModule(PSAppModuleBase pSAppModuleBase) throws Exception {
        return this.selectByPSAppModule(pSAppModuleBase, "", -1);
    }

    public ArrayList<PSDEUAWizard> selectByPSAppModule(PSAppModuleBase pSAppModuleBase, String string) throws Exception {
        return this.selectByPSAppModule(pSAppModuleBase, string, -1);
    }

    public ArrayList<PSDEUAWizard> selectByPSAppModule(PSAppModuleBase pSAppModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPMODULEID", (Object)pSAppModuleBase.getPSAppModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUAWizard> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSDEUAWizard> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSDEUAWizard> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUAWizard> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDEUAWizard> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDEUAWizard> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
    }

    public void resetPSAppModule(PSAppModule pSAppModule) throws Exception {
        ArrayList<PSDEUAWizard> arrayList = this.selectByPSAppModule(pSAppModule);
        for (PSDEUAWizard pSDEUAWizard : arrayList) {
            PSDEUAWizard pSDEUAWizard2 = (PSDEUAWizard)this.getDEModel().createEntity();
            pSDEUAWizard2.setPSUAWizardId(pSDEUAWizard.getPSUAWizardId());
            pSDEUAWizard2.setPSAppModuleId(null);
            this.update(pSDEUAWizard2);
        }
    }

    public void removeByPSAppModule(PSAppModule pSAppModule) throws Exception {
        final PSAppModule pSAppModule2 = pSAppModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAWizardServiceBase.this.onBeforeRemoveByPSAppModule(pSAppModule2);
                PSDEUAWizardServiceBase.this.internalRemoveByPSAppModule(pSAppModule2);
                PSDEUAWizardServiceBase.this.onAfterRemoveByPSAppModule(pSAppModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
    }

    protected void internalRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
        ArrayList<PSDEUAWizard> arrayList = this.selectByPSAppModule(pSAppModule);
        this.onBeforeRemoveByPSAppModule(pSAppModule, arrayList);
        for (PSDEUAWizard pSDEUAWizard : arrayList) {
            this.remove((IEntity)pSDEUAWizard);
        }
        this.onAfterRemoveByPSAppModule(pSAppModule, arrayList);
    }

    protected void onAfterRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
    }

    protected void onBeforeRemoveByPSAppModule(PSAppModule pSAppModule, ArrayList<PSDEUAWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppModule(PSAppModule pSAppModule, ArrayList<PSDEUAWizard> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSDEUAWizard> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSDEUAWizard pSDEUAWizard : arrayList) {
            PSDEUAWizard pSDEUAWizard2 = (PSDEUAWizard)this.getDEModel().createEntity();
            pSDEUAWizard2.setPSUAWizardId(pSDEUAWizard.getPSUAWizardId());
            pSDEUAWizard2.setPSSysAppId(null);
            this.update(pSDEUAWizard2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAWizardServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSDEUAWizardServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSDEUAWizardServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSDEUAWizard> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSDEUAWizard pSDEUAWizard : arrayList) {
            this.remove((IEntity)pSDEUAWizard);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSDEUAWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSDEUAWizard> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEUAWizard> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDEUAWizard pSDEUAWizard : arrayList) {
            PSDEUAWizard pSDEUAWizard2 = (PSDEUAWizard)this.getDEModel().createEntity();
            pSDEUAWizard2.setPSUAWizardId(pSDEUAWizard.getPSUAWizardId());
            pSDEUAWizard2.setPSSystemId(null);
            this.update(pSDEUAWizard2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAWizardServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDEUAWizardServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDEUAWizardServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEUAWizard> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDEUAWizard pSDEUAWizard : arrayList) {
            this.remove((IEntity)pSDEUAWizard);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEUAWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEUAWizard> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEUAWizard pSDEUAWizard) throws Exception {
        super.onBeforeRemove(pSDEUAWizard);
    }

    protected void replaceParentInfo(PSDEUAWizard pSDEUAWizard, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEUAWizard, cloneSession);
        if (pSDEUAWizard.getPSAppModuleId() != null && (iEntity = cloneSession.getEntity("PSAPPMODULE", (Object)pSDEUAWizard.getPSAppModuleId())) != null) {
            this.onFillParentInfo_PSAppModule(pSDEUAWizard, (PSAppModule)iEntity);
        }
        if (pSDEUAWizard.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSDEUAWizard.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSDEUAWizard, (PSSysApp)iEntity);
        }
        if (pSDEUAWizard.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDEUAWizard.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDEUAWizard, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEUAWizard pSDEUAWizard, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEUAWizard, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionData(bl, pSDEUAWizard, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionData2(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppModuleId(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppModuleName(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSConsoleId(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppName(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUAWizardId(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUAWizardName(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardMode(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam2(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam3(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam4(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam5(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardParam6(bl, pSDEUAWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEUAWizard, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionData(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isActionDataDirty() : !pSDEUAWizard.isActionDataDirty()) {
            return null;
        }
        String string = pSDEUAWizard.getActionData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionData_Default((IEntity)pSDEUAWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_ActionData2(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isActionData2Dirty() : !pSDEUAWizard.isActionData2Dirty()) {
            return null;
        }
        String string = pSDEUAWizard.getActionData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionData2_Default((IEntity)pSDEUAWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppModuleId(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isPSAppModuleIdDirty() : !pSDEUAWizard.isPSAppModuleIdDirty()) {
            return null;
        }
        String string = pSDEUAWizard.getPSAppModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppModuleId_Default((IEntity)pSDEUAWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppModuleName(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isPSAppModuleNameDirty() : !pSDEUAWizard.isPSAppModuleNameDirty()) {
            return null;
        }
        String string = pSDEUAWizard.getPSAppModuleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppModuleName_Default((IEntity)pSDEUAWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMODULENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSConsoleId(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isPSDSConsoleIdDirty() : !pSDEUAWizard.isPSDSConsoleIdDirty()) {
            return null;
        }
        String string = pSDEUAWizard.getPSDSConsoleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSConsoleId_Default((IEntity)pSDEUAWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isPSSysAppIdDirty() : !pSDEUAWizard.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSDEUAWizard.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSDEUAWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppName(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isPSSysAppNameDirty() : !pSDEUAWizard.isPSSysAppNameDirty()) {
            return null;
        }
        String string = pSDEUAWizard.getPSSysAppName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppName_Default((IEntity)pSDEUAWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isPSSystemIdDirty() : !pSDEUAWizard.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDEUAWizard.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSDEUAWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isPSSystemNameDirty() : !pSDEUAWizard.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSDEUAWizard.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSDEUAWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSUAWizardId(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isPSUAWizardIdDirty() && !bl2 : !pSDEUAWizard.isPSUAWizardIdDirty()) {
            return null;
        }
        String string = pSDEUAWizard.getPSUAWizardId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUAWIZARDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUAWizardId_Default((IEntity)pSDEUAWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUAWIZARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUAWizardName(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isPSUAWizardNameDirty() : !pSDEUAWizard.isPSUAWizardNameDirty()) {
            return null;
        }
        String string = pSDEUAWizard.getPSUAWizardName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUAWizardName_Default((IEntity)pSDEUAWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUAWIZARDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardMode(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isWizardModeDirty() : !pSDEUAWizard.isWizardModeDirty()) {
            return null;
        }
        String string = pSDEUAWizard.getWizardMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardMode_Default((IEntity)pSDEUAWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_WizardParam(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isWizardParamDirty() : !pSDEUAWizard.isWizardParamDirty()) {
            return null;
        }
        Integer n = pSDEUAWizard.getWizardParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WizardParam_Default((IEntity)pSDEUAWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam2(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isWizardParam2Dirty() : !pSDEUAWizard.isWizardParam2Dirty()) {
            return null;
        }
        Integer n = pSDEUAWizard.getWizardParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WizardParam2_Default((IEntity)pSDEUAWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam3(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isWizardParam3Dirty() : !pSDEUAWizard.isWizardParam3Dirty()) {
            return null;
        }
        String string = pSDEUAWizard.getWizardParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardParam3_Default((IEntity)pSDEUAWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_WizardParam4(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isWizardParam4Dirty() : !pSDEUAWizard.isWizardParam4Dirty()) {
            return null;
        }
        String string = pSDEUAWizard.getWizardParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardParam4_Default((IEntity)pSDEUAWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_WizardParam5(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isWizardParam5Dirty() : !pSDEUAWizard.isWizardParam5Dirty()) {
            return null;
        }
        String string = pSDEUAWizard.getWizardParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardParam5_Default((IEntity)pSDEUAWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardParam6(boolean bl, PSDEUAWizard pSDEUAWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAWizard.isWizardParam6Dirty() : !pSDEUAWizard.isWizardParam6Dirty()) {
            return null;
        }
        String string = pSDEUAWizard.getWizardParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardParam6_Default((IEntity)pSDEUAWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEUAWizard pSDEUAWizard, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEUAWizard, bl);
    }

    protected void onSyncIndexEntities(PSDEUAWizard pSDEUAWizard, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEUAWizard, bl);
    }

    public Object getDataContextValue(PSDEUAWizard pSDEUAWizard, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEUAWizard, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEUAWizard pSDEUAWizard, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEUAWizard, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionData2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSCONSOLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSConsoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUAWIZARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUAWizardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUAWIZARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUAWizardName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardParam6_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ActionData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONDATA2", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_PSAppModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSUAWizardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUAWIZARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUAWizardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUAWIZARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("WIZARDMODE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WizardParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WizardParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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
            if (this.checkFieldStringLengthRule("WIZARDPARAM4", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WizardParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIZARDPARAM5", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WizardParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIZARDPARAM6", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDEUAWizard pSDEUAWizard) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEUAWizard)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEUAWizard pSDEUAWizard) throws Exception {
        super.onUpdateParent((IEntity)pSDEUAWizard);
    }

    @Override
    protected void exportCurXmlModel(PSDEUAWizard pSDEUAWizard, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEUAWIZARD");
        if (!bl) {
            super.exportCurXmlModel(pSDEUAWizard, xmlNode, bl);
        }
    }
}

