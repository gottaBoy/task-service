/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardFormDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardFormDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStep;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStepBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEWizardFormServiceBase
extends PSCoreSysServiceBase<PSDEWizardForm> {
    private static final Log log = LogFactory.getLog(PSDEWizardFormServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_INITNEXTACTION = "InitNextAction";
    public static final String ACTION_INITWIZARDSTEP = "InitWizardStep";
    private PSDEWizardFormDEModel pSDEWizardFormDEModel;
    private PSDEWizardFormDAO pSDEWizardFormDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormService";
    }

    public PSDEWizardFormDEModel getPSDEWizardFormDEModel() {
        if (this.pSDEWizardFormDEModel == null) {
            try {
                this.pSDEWizardFormDEModel = (PSDEWizardFormDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardFormDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardFormDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEWizardFormDEModel();
    }

    public PSDEWizardFormDAO getPSDEWizardFormDAO() {
        if (this.pSDEWizardFormDAO == null) {
            try {
                this.pSDEWizardFormDAO = (PSDEWizardFormDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardFormDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardFormDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEWizardFormDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_INITNEXTACTION, (boolean)true) == 0) {
            this.initNextAction((PSDEWizardForm)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_INITWIZARDSTEP, (boolean)true) == 0) {
            this.initWizardStep((PSDEWizardForm)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void initNextAction(PSDEWizardForm pSDEWizardForm) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITNEXTACTION, 0, pSDEWizardForm, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEWizardForm, ACTION_INITNEXTACTION);
        final PSDEWizardForm pSDEWizardForm2 = pSDEWizardForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEWizardFormServiceBase.this.getService(), PSDEWizardFormServiceBase.ACTION_INITNEXTACTION, 40, pSDEWizardForm2, null).getResult() != 1) {
                    PSDEWizardFormServiceBase.this.onInitNextAction(pSDEWizardForm2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITNEXTACTION, 99, pSDEWizardForm, null);
        }
    }

    protected void onInitNextAction(PSDEWizardForm pSDEWizardForm) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitNextAction]");
    }

    public void initWizardStep(PSDEWizardForm pSDEWizardForm) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITWIZARDSTEP, 0, pSDEWizardForm, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEWizardForm, ACTION_INITWIZARDSTEP);
        final PSDEWizardForm pSDEWizardForm2 = pSDEWizardForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEWizardFormServiceBase.this.getService(), PSDEWizardFormServiceBase.ACTION_INITWIZARDSTEP, 40, pSDEWizardForm2, null).getResult() != 1) {
                    PSDEWizardFormServiceBase.this.onInitWizardStep(pSDEWizardForm2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITWIZARDSTEP, 99, pSDEWizardForm, null);
        }
    }

    protected void onInitWizardStep(PSDEWizardForm pSDEWizardForm) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitWizardStep]");
    }

    protected void onFillParentInfo(PSDEWizardForm pSDEWizardForm, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDFORM_PSDEACTION_LOADPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_LoadPSDEAction(pSDEWizardForm, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDFORM_PSDEACTION_PREVPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PrevPSDEAction(pSDEWizardForm, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDFORM_PSDEACTION_SAVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_SavePSDEAction(pSDEWizardForm, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDFORM_PSDEFORM_MOBPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_MobPSDEForm(pSDEWizardForm, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDFORM_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEWizardForm, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDFORM_PSDEWIZARDSTEP_PSDEWIZARDSTEPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService", (SessionFactory)this.getSessionFactory());
            PSDEWizardStep pSDEWizardStep = (PSDEWizardStep)iService.getDEModel().createEntity();
            pSDEWizardStep.set("PSDEWIZARDSTEPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEWizardStep);
            } else {
                iService.get(pSDEWizardStep);
            }
            this.onFillParentInfo_PSDEWizardStep(pSDEWizardForm, pSDEWizardStep);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDFORM_PSDEWIZARD_PSDEWIZARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService", (SessionFactory)this.getSessionFactory());
            PSDEWizard pSDEWizard = (PSDEWizard)iService.getDEModel().createEntity();
            pSDEWizard.set("PSDEWIZARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEWizard);
            } else {
                iService.get(pSDEWizard);
            }
            this.onFillParentInfo_PSDEWizard(pSDEWizardForm, pSDEWizard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDFORM_PSLANGUAGERES_CMPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CMPSLanRes(pSDEWizardForm, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDFORM_PSLANGUAGERES_CMPSLANRESID2", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CM2PSLanRes(pSDEWizardForm, pSLanguageRes);
            return;
        }
        super.onFillParentInfo(pSDEWizardForm, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEWIZARDFORM_PSDEWIZARD_PSDEWIZARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService", (SessionFactory)this.getSessionFactory());
            PSDEWizard pSDEWizard = (PSDEWizard)iService.getDEModel().createEntity();
            pSDEWizard.set("PSDEWIZARDID", string2);
            return this.onSyncDER1NData_PSDEWizard(pSDEWizard, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_LoadPSDEAction(PSDEWizardForm pSDEWizardForm, PSDEAction pSDEAction) throws Exception {
        pSDEWizardForm.setLoadPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEWizardForm.setLoadPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PrevPSDEAction(PSDEWizardForm pSDEWizardForm, PSDEAction pSDEAction) throws Exception {
        pSDEWizardForm.setPrevPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEWizardForm.setPrevPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_SavePSDEAction(PSDEWizardForm pSDEWizardForm, PSDEAction pSDEAction) throws Exception {
        pSDEWizardForm.setSavePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEWizardForm.setSavePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_MobPSDEForm(PSDEWizardForm pSDEWizardForm, PSDEForm pSDEForm) throws Exception {
        pSDEWizardForm.setMobPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEWizardForm.setMobPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEForm(PSDEWizardForm pSDEWizardForm, PSDEForm pSDEForm) throws Exception {
        pSDEWizardForm.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEWizardForm.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEWizardStep(PSDEWizardForm pSDEWizardForm, PSDEWizardStep pSDEWizardStep) throws Exception {
        pSDEWizardForm.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
        pSDEWizardForm.setPSDEWizardStepName(pSDEWizardStep.getPSDEWizardStepName());
        pSDEWizardForm.setStepOrderValue(pSDEWizardStep.getOrderValue());
    }

    protected void onFillParentInfo_PSDEWizard(PSDEWizardForm pSDEWizardForm, PSDEWizard pSDEWizard) throws Exception {
        pSDEWizardForm.setPSDEId(pSDEWizard.getPSDEId());
        pSDEWizardForm.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
        pSDEWizardForm.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
    }

    protected String onSyncDER1NData_PSDEWizard(PSDEWizard pSDEWizard, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEWizard(pSDEWizard);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEWizardForm> arrayList = this.selectByPSDEWizard(pSDEWizard);
            for (PSDEWizardForm pSDEWizardForm : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEWizardForm, (String)"PSDEWIZARDFORMID", (String)""))) continue;
                this.remove(pSDEWizardForm);
            }
        }
        return null;
    }

    protected void onFillParentInfo_CMPSLanRes(PSDEWizardForm pSDEWizardForm, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEWizardForm.setCMPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEWizardForm.setCMPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_CM2PSLanRes(PSDEWizardForm pSDEWizardForm, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEWizardForm.setCMPSLanResId2(pSLanguageRes.getPSLanguageResId());
        pSDEWizardForm.setCMPSLanResName2(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillEntityFullInfo(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
        if (bl && pSDEWizardForm.getFirstForm() == null) {
            pSDEWizardForm.setFirstForm((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSDEWizardForm, bl);
        this.onFillEntityFullInfo_LoadPSDEAction(pSDEWizardForm, bl);
        this.onFillEntityFullInfo_PrevPSDEAction(pSDEWizardForm, bl);
        this.onFillEntityFullInfo_SavePSDEAction(pSDEWizardForm, bl);
        this.onFillEntityFullInfo_MobPSDEForm(pSDEWizardForm, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEWizardForm, bl);
        this.onFillEntityFullInfo_PSDEWizardStep(pSDEWizardForm, bl);
        this.onFillEntityFullInfo_PSDEWizard(pSDEWizardForm, bl);
        this.onFillEntityFullInfo_CMPSLanRes(pSDEWizardForm, bl);
        this.onFillEntityFullInfo_CM2PSLanRes(pSDEWizardForm, bl);
    }

    protected void onFillEntityFullInfo_LoadPSDEAction(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PrevPSDEAction(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SavePSDEAction(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobPSDEForm(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEWizardStep(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEWizard(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CMPSLanRes(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
        if (pSDEWizardForm.isCMPSLanResIdDirty()) {
            if (pSDEWizardForm.getCMPSLanResId() != null) {
                if (pSDEWizardForm.getCMPSLanResId() == null || pSDEWizardForm.getCMPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEWizardForm.getCMPSLanRes();
                    pSDEWizardForm.setCMPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEWizardForm.setCMPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CM2PSLanRes(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
        if (pSDEWizardForm.isCMPSLanResId2Dirty()) {
            if (pSDEWizardForm.getCMPSLanResId2() != null) {
                if (pSDEWizardForm.getCMPSLanResId2() == null || pSDEWizardForm.getCMPSLanResName2() == null) {
                    PSLanguageRes pSLanguageRes = pSDEWizardForm.getCM2PSLanRes();
                    pSDEWizardForm.setCMPSLanResName2(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEWizardForm.setCMPSLanResName2(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEWizardForm, bl);
    }

    public ArrayList<PSDEWizardForm> selectByLoadPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByLoadPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEWizardForm> selectByLoadPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByLoadPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEWizardForm> selectByLoadPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LOADPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLoadPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLoadPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardForm> selectByPrevPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPrevPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEWizardForm> selectByPrevPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPrevPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEWizardForm> selectByPrevPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PREVPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPrevPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPrevPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardForm> selectBySavePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectBySavePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEWizardForm> selectBySavePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectBySavePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEWizardForm> selectBySavePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SAVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySavePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySavePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardForm> selectByMobPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMobPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEWizardForm> selectByMobPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMobPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEWizardForm> selectByMobPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardForm> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEWizardForm> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEWizardForm> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardForm> selectByPSDEWizardStep(PSDEWizardStepBase pSDEWizardStepBase) throws Exception {
        return this.selectByPSDEWizardStep(pSDEWizardStepBase, "", -1);
    }

    public ArrayList<PSDEWizardForm> selectByPSDEWizardStep(PSDEWizardStepBase pSDEWizardStepBase, String string) throws Exception {
        return this.selectByPSDEWizardStep(pSDEWizardStepBase, string, -1);
    }

    public ArrayList<PSDEWizardForm> selectByPSDEWizardStep(PSDEWizardStepBase pSDEWizardStepBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEWIZARDSTEPID", (Object)pSDEWizardStepBase.getPSDEWizardStepId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEWizardStepCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEWizardStepCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardForm> selectTempByPSDEWizardStep(PSDEWizardStepBase pSDEWizardStepBase) throws Exception {
        return this.selectTempByPSDEWizardStep(pSDEWizardStepBase, "");
    }

    public ArrayList<PSDEWizardForm> selectTempByPSDEWizardStep(PSDEWizardStepBase pSDEWizardStepBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEWIZARDSTEPID", (Object)pSDEWizardStepBase.getPSDEWizardStepId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEWizardStepCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEWizardStepCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardForm> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase) throws Exception {
        return this.selectByPSDEWizard(pSDEWizardBase, "", -1);
    }

    public ArrayList<PSDEWizardForm> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string) throws Exception {
        return this.selectByPSDEWizard(pSDEWizardBase, string, -1);
    }

    public ArrayList<PSDEWizardForm> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEWIZARDID", (Object)pSDEWizardBase.getPSDEWizardId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEWizardCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEWizardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardForm> selectTempByPSDEWizard(PSDEWizardBase pSDEWizardBase) throws Exception {
        return this.selectTempByPSDEWizard(pSDEWizardBase, "");
    }

    public ArrayList<PSDEWizardForm> selectTempByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEWIZARDID", (Object)pSDEWizardBase.getPSDEWizardId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEWizardCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEWizardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardForm> selectByCMPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCMPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEWizardForm> selectByCMPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCMPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEWizardForm> selectByCMPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CMPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCMPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCMPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardForm> selectByCM2PSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCM2PSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEWizardForm> selectByCM2PSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCM2PSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEWizardForm> selectByCM2PSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CMPSLANRESID2", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCM2PSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCM2PSLanResCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByLoadPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByLoadPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDFORM_PSDEACTION_LOADPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEWIZARDFORM", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetLoadPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByLoadPSDEAction(pSDEAction);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            PSDEWizardForm pSDEWizardForm2 = (PSDEWizardForm)this.getDEModel().createEntity();
            pSDEWizardForm2.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
            pSDEWizardForm2.setLoadPSDEActionId(null);
            this.update(pSDEWizardForm2);
        }
    }

    public void removeByLoadPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardFormServiceBase.this.onBeforeRemoveByLoadPSDEAction(pSDEAction2);
                PSDEWizardFormServiceBase.this.internalRemoveByLoadPSDEAction(pSDEAction2);
                PSDEWizardFormServiceBase.this.onAfterRemoveByLoadPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByLoadPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByLoadPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByLoadPSDEAction(pSDEAction);
        this.onBeforeRemoveByLoadPSDEAction(pSDEAction, arrayList);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            this.remove(pSDEWizardForm);
        }
        this.onAfterRemoveByLoadPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByLoadPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByLoadPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLoadPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    public void testRemoveByPrevPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByPrevPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDFORM_PSDEACTION_PREVPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEWIZARDFORM", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPrevPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByPrevPSDEAction(pSDEAction);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            PSDEWizardForm pSDEWizardForm2 = (PSDEWizardForm)this.getDEModel().createEntity();
            pSDEWizardForm2.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
            pSDEWizardForm2.setPrevPSDEActionId(null);
            this.update(pSDEWizardForm2);
        }
    }

    public void removeByPrevPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardFormServiceBase.this.onBeforeRemoveByPrevPSDEAction(pSDEAction2);
                PSDEWizardFormServiceBase.this.internalRemoveByPrevPSDEAction(pSDEAction2);
                PSDEWizardFormServiceBase.this.onAfterRemoveByPrevPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPrevPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPrevPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByPrevPSDEAction(pSDEAction);
        this.onBeforeRemoveByPrevPSDEAction(pSDEAction, arrayList);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            this.remove(pSDEWizardForm);
        }
        this.onAfterRemoveByPrevPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPrevPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPrevPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPrevPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    public void testRemoveBySavePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectBySavePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDFORM_PSDEACTION_SAVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEWIZARDFORM", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetSavePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectBySavePSDEAction(pSDEAction);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            PSDEWizardForm pSDEWizardForm2 = (PSDEWizardForm)this.getDEModel().createEntity();
            pSDEWizardForm2.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
            pSDEWizardForm2.setSavePSDEActionId(null);
            this.update(pSDEWizardForm2);
        }
    }

    public void removeBySavePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardFormServiceBase.this.onBeforeRemoveBySavePSDEAction(pSDEAction2);
                PSDEWizardFormServiceBase.this.internalRemoveBySavePSDEAction(pSDEAction2);
                PSDEWizardFormServiceBase.this.onAfterRemoveBySavePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveBySavePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveBySavePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectBySavePSDEAction(pSDEAction);
        this.onBeforeRemoveBySavePSDEAction(pSDEAction, arrayList);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            this.remove(pSDEWizardForm);
        }
        this.onAfterRemoveBySavePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveBySavePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveBySavePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySavePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    public void testRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByMobPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDFORM_PSDEFORM_MOBPSDEFORMID", "", iDataEntityModel.getName(), "PSDEWIZARDFORM", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByMobPSDEForm(pSDEForm);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            PSDEWizardForm pSDEWizardForm2 = (PSDEWizardForm)this.getDEModel().createEntity();
            pSDEWizardForm2.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
            pSDEWizardForm2.setMobPSDEFormId(null);
            this.update(pSDEWizardForm2);
        }
    }

    public void removeByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardFormServiceBase.this.onBeforeRemoveByMobPSDEForm(pSDEForm2);
                PSDEWizardFormServiceBase.this.internalRemoveByMobPSDEForm(pSDEForm2);
                PSDEWizardFormServiceBase.this.onAfterRemoveByMobPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByMobPSDEForm(pSDEForm);
        this.onBeforeRemoveByMobPSDEForm(pSDEForm, arrayList);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            this.remove(pSDEWizardForm);
        }
        this.onAfterRemoveByMobPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMobPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDFORM_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSDEWIZARDFORM", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            PSDEWizardForm pSDEWizardForm2 = (PSDEWizardForm)this.getDEModel().createEntity();
            pSDEWizardForm2.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
            pSDEWizardForm2.setPSDEFormId(null);
            this.update(pSDEWizardForm2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardFormServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEWizardFormServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEWizardFormServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            this.remove(pSDEWizardForm);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    public void testRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByPSDEWizardStep(pSDEWizardStep, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEWIZARDSTEP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEWizardStep);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDFORM_PSDEWIZARDSTEP_PSDEWIZARDSTEPID", "", iDataEntityModel.getName(), "PSDEWIZARDFORM", iDataEntityModel.getDataInfo(pSDEWizardStep), arrayList.get(0)));
        }
    }

    public void resetPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByPSDEWizardStep(pSDEWizardStep);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            PSDEWizardForm pSDEWizardForm2 = (PSDEWizardForm)this.getDEModel().createEntity();
            pSDEWizardForm2.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
            pSDEWizardForm2.setPSDEWizardStepId(null);
            this.update(pSDEWizardForm2);
        }
    }

    public void resetTempPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectTempByPSDEWizardStep(pSDEWizardStep);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            PSDEWizardForm pSDEWizardForm2 = (PSDEWizardForm)this.getDEModel().createEntity();
            pSDEWizardForm2.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
            pSDEWizardForm2.setPSDEWizardStepId(null);
            this.updateTemp(pSDEWizardForm2);
        }
    }

    public void removeByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        final PSDEWizardStep pSDEWizardStep2 = pSDEWizardStep;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardFormServiceBase.this.onBeforeRemoveByPSDEWizardStep(pSDEWizardStep2);
                PSDEWizardFormServiceBase.this.internalRemoveByPSDEWizardStep(pSDEWizardStep2);
                PSDEWizardFormServiceBase.this.onAfterRemoveByPSDEWizardStep(pSDEWizardStep2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
    }

    protected void internalRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByPSDEWizardStep(pSDEWizardStep);
        this.onBeforeRemoveByPSDEWizardStep(pSDEWizardStep, arrayList);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            this.remove(pSDEWizardForm);
        }
        this.onAfterRemoveByPSDEWizardStep(pSDEWizardStep, arrayList);
    }

    protected void onAfterRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
    }

    protected void onBeforeRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    public void testRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    public void resetPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByPSDEWizard(pSDEWizard);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            PSDEWizardForm pSDEWizardForm2 = (PSDEWizardForm)this.getDEModel().createEntity();
            pSDEWizardForm2.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
            pSDEWizardForm2.setPSDEWizardId(null);
            this.update(pSDEWizardForm2);
        }
    }

    public void resetTempPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectTempByPSDEWizard(pSDEWizard);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            PSDEWizardForm pSDEWizardForm2 = (PSDEWizardForm)this.getDEModel().createEntity();
            pSDEWizardForm2.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
            pSDEWizardForm2.setPSDEWizardId(null);
            this.updateTemp(pSDEWizardForm2);
        }
    }

    public void removeByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        final PSDEWizard pSDEWizard2 = pSDEWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardFormServiceBase.this.onBeforeRemoveByPSDEWizard(pSDEWizard2);
                PSDEWizardFormServiceBase.this.internalRemoveByPSDEWizard(pSDEWizard2);
                PSDEWizardFormServiceBase.this.onAfterRemoveByPSDEWizard(pSDEWizard2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void internalRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByPSDEWizard(pSDEWizard);
        this.onBeforeRemoveByPSDEWizard(pSDEWizard, arrayList);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            this.remove(pSDEWizardForm);
        }
        this.onAfterRemoveByPSDEWizard(pSDEWizard, arrayList);
    }

    protected void onAfterRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void onBeforeRemoveByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    public void testRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByCMPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDFORM_PSLANGUAGERES_CMPSLANRESID", "", iDataEntityModel.getName(), "PSDEWIZARDFORM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByCMPSLanRes(pSLanguageRes);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            PSDEWizardForm pSDEWizardForm2 = (PSDEWizardForm)this.getDEModel().createEntity();
            pSDEWizardForm2.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
            pSDEWizardForm2.setCMPSLanResId(null);
            this.update(pSDEWizardForm2);
        }
    }

    public void removeByCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardFormServiceBase.this.onBeforeRemoveByCMPSLanRes(pSLanguageRes2);
                PSDEWizardFormServiceBase.this.internalRemoveByCMPSLanRes(pSLanguageRes2);
                PSDEWizardFormServiceBase.this.onAfterRemoveByCMPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByCMPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCMPSLanRes(pSLanguageRes, arrayList);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            this.remove(pSDEWizardForm);
        }
        this.onAfterRemoveByCMPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    public void testRemoveByCM2PSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByCM2PSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDFORM_PSLANGUAGERES_CMPSLANRESID2", "", iDataEntityModel.getName(), "PSDEWIZARDFORM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCM2PSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByCM2PSLanRes(pSLanguageRes);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            PSDEWizardForm pSDEWizardForm2 = (PSDEWizardForm)this.getDEModel().createEntity();
            pSDEWizardForm2.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
            pSDEWizardForm2.setCMPSLanResId2(null);
            this.update(pSDEWizardForm2);
        }
    }

    public void removeByCM2PSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardFormServiceBase.this.onBeforeRemoveByCM2PSLanRes(pSLanguageRes2);
                PSDEWizardFormServiceBase.this.internalRemoveByCM2PSLanRes(pSLanguageRes2);
                PSDEWizardFormServiceBase.this.onAfterRemoveByCM2PSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCM2PSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCM2PSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectByCM2PSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCM2PSLanRes(pSLanguageRes, arrayList);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            this.remove(pSDEWizardForm);
        }
        this.onAfterRemoveByCM2PSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCM2PSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCM2PSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCM2PSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEWizardForm pSDEWizardForm) throws Exception {
        PSDEWizardLogicService pSDEWizardLogicService = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        pSDEWizardLogicService.testRemoveByPSDEWizardForm(pSDEWizardForm);
        super.onBeforeRemove(pSDEWizardForm);
    }

    protected void onBeforeRemoveTemp(PSDEWizardForm pSDEWizardForm) throws Exception {
        PSDEWizardLogicService pSDEWizardLogicService = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        pSDEWizardLogicService.resetTempPSDEWizardForm(pSDEWizardForm);
        super.onBeforeRemoveTemp(pSDEWizardForm);
    }

    public void removeTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        final PSDEWizardStep pSDEWizardStep2 = pSDEWizardStep;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardFormServiceBase.this.onBeforeRemoveTempByPSDEWizardStep(pSDEWizardStep2);
                PSDEWizardFormServiceBase.this.internalRemoveTempByPSDEWizardStep(pSDEWizardStep2);
                PSDEWizardFormServiceBase.this.onAfterRemoveTempByPSDEWizardStep(pSDEWizardStep2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
    }

    protected void internalRemoveTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectTempByPSDEWizardStep(pSDEWizardStep);
        this.onBeforeRemoveTempByPSDEWizardStep(pSDEWizardStep, arrayList);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            this.removeTemp(pSDEWizardForm);
        }
        this.onAfterRemoveTempByPSDEWizardStep(pSDEWizardStep, arrayList);
    }

    protected void onAfterRemoveTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    public void removeTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        final PSDEWizard pSDEWizard2 = pSDEWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardFormServiceBase.this.onBeforeRemoveTempByPSDEWizard(pSDEWizard2);
                PSDEWizardFormServiceBase.this.internalRemoveTempByPSDEWizard(pSDEWizard2);
                PSDEWizardFormServiceBase.this.onAfterRemoveTempByPSDEWizard(pSDEWizard2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void internalRemoveTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardForm> arrayList = this.selectTempByPSDEWizard(pSDEWizard);
        this.onBeforeRemoveTempByPSDEWizard(pSDEWizard, arrayList);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            this.removeTemp(pSDEWizardForm);
        }
        this.onAfterRemoveTempByPSDEWizard(pSDEWizard, arrayList);
    }

    protected void onAfterRemoveTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardForm> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEWizardForm pSDEWizardForm) throws Exception {
        super.getRelatedDataTempMajor(pSDEWizardForm);
    }

    protected void updateRelatedDataTempMajor(PSDEWizardForm pSDEWizardForm, PSDEWizardForm pSDEWizardForm2) throws Exception {
        super.updateRelatedDataTempMajor(pSDEWizardForm, pSDEWizardForm2);
    }

    protected void replaceParentInfo(PSDEWizardForm pSDEWizardForm, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEWizardForm, cloneSession);
        if (pSDEWizardForm.getLoadPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEWizardForm.getLoadPSDEActionId())) != null) {
            this.onFillParentInfo_LoadPSDEAction(pSDEWizardForm, (PSDEAction)iEntity);
        }
        if (pSDEWizardForm.getPrevPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEWizardForm.getPrevPSDEActionId())) != null) {
            this.onFillParentInfo_PrevPSDEAction(pSDEWizardForm, (PSDEAction)iEntity);
        }
        if (pSDEWizardForm.getSavePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEWizardForm.getSavePSDEActionId())) != null) {
            this.onFillParentInfo_SavePSDEAction(pSDEWizardForm, (PSDEAction)iEntity);
        }
        if (pSDEWizardForm.getMobPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEWizardForm.getMobPSDEFormId())) != null) {
            this.onFillParentInfo_MobPSDEForm(pSDEWizardForm, (PSDEForm)iEntity);
        }
        if (pSDEWizardForm.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEWizardForm.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEWizardForm, (PSDEForm)iEntity);
        }
        if (pSDEWizardForm.getPSDEWizardStepId() != null && (iEntity = cloneSession.getEntity("PSDEWIZARDSTEP", (Object)pSDEWizardForm.getPSDEWizardStepId())) != null) {
            this.onFillParentInfo_PSDEWizardStep(pSDEWizardForm, (PSDEWizardStep)iEntity);
        }
        if (pSDEWizardForm.getPSDEWizardId() != null && (iEntity = cloneSession.getEntity("PSDEWIZARD", (Object)pSDEWizardForm.getPSDEWizardId())) != null) {
            this.onFillParentInfo_PSDEWizard(pSDEWizardForm, (PSDEWizard)iEntity);
        }
        if (pSDEWizardForm.getCMPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEWizardForm.getCMPSLanResId())) != null) {
            this.onFillParentInfo_CMPSLanRes(pSDEWizardForm, (PSLanguageRes)iEntity);
        }
        if (pSDEWizardForm.getCMPSLanResId2() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEWizardForm.getCMPSLanResId2())) != null) {
            this.onFillParentInfo_CM2PSLanRes(pSDEWizardForm, (PSLanguageRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEWizardForm, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CMPSLanResId(bl, pSDEWizardForm, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CMPSLanResId2(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CMPSLanResName(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CMPSLanResName2(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConfirmInfo(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConfirmInfo2(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FinishEnableLogic(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FirstForm(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormTag(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LoadPSDEActionId(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobPSDEFormId(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NextEnableLogic(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrevEnableLogic(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrevPSDEActionId(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardFormId(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardFormName(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardId(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardStepId(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SavePSDEActionId(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StepActions(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEWizardForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEWizardForm, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CMPSLanResId(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isCMPSLanResIdDirty() : !pSDEWizardForm.isCMPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getCMPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CMPSLanResId_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CMPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CMPSLanResId2(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isCMPSLanResId2Dirty() : !pSDEWizardForm.isCMPSLanResId2Dirty()) {
            return null;
        }
        String string = pSDEWizardForm.getCMPSLanResId2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CMPSLanResId2_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CMPSLANRESID2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CMPSLanResName(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isCMPSLanResNameDirty() : !pSDEWizardForm.isCMPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getCMPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CMPSLanResName_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CMPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CMPSLanResName2(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isCMPSLanResName2Dirty() : !pSDEWizardForm.isCMPSLanResName2Dirty()) {
            return null;
        }
        String string = pSDEWizardForm.getCMPSLanResName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CMPSLanResName2_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CMPSLANRESNAME2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ConfirmInfo(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isConfirmInfoDirty() : !pSDEWizardForm.isConfirmInfoDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getConfirmInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConfirmInfo_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONFIRMINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ConfirmInfo2(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isConfirmInfo2Dirty() : !pSDEWizardForm.isConfirmInfo2Dirty()) {
            return null;
        }
        String string = pSDEWizardForm.getConfirmInfo2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConfirmInfo2_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONFIRMINFO2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FinishEnableLogic(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isFinishEnableLogicDirty() : !pSDEWizardForm.isFinishEnableLogicDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getFinishEnableLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FinishEnableLogic_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHENABLELOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FirstForm(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isFirstFormDirty() && !bl2 : !pSDEWizardForm.isFirstFormDirty()) {
            return null;
        }
        Integer n = pSDEWizardForm.getFirstForm();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIRSTFORM");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_FirstForm_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIRSTFORM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEWIZARDID";
                String string2 = this.checkFieldDupRule(this.getPSDEWizardFormDEModel(), "FIRSTFORM", string, pSDEWizardForm, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("FIRSTFORM");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormTag(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isFormTagDirty() && !bl2 : !pSDEWizardForm.isFormTagDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getFormTag();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMTAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormTag_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEWIZARDID";
                String string4 = this.checkFieldDupRule(this.getPSDEWizardFormDEModel(), "FORMTAG", string3, pSDEWizardForm, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("FORMTAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LoadPSDEActionId(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isLoadPSDEActionIdDirty() : !pSDEWizardForm.isLoadPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getLoadPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LoadPSDEActionId_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOADPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isLogicNameDirty() : !pSDEWizardForm.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDEWizardForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isMemoDirty() : !pSDEWizardForm.isMemoDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEWizardForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobPSDEFormId(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isMobPSDEFormIdDirty() : !pSDEWizardForm.isMobPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getMobPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobPSDEFormId_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBPSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NextEnableLogic(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isNextEnableLogicDirty() : !pSDEWizardForm.isNextEnableLogicDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getNextEnableLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NextEnableLogic_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTENABLELOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrevEnableLogic(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isPrevEnableLogicDirty() : !pSDEWizardForm.isPrevEnableLogicDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getPrevEnableLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrevEnableLogic_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVENABLELOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrevPSDEActionId(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isPrevPSDEActionIdDirty() : !pSDEWizardForm.isPrevPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getPrevPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrevPSDEActionId_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isPSDEFormIdDirty() && !bl2 : !pSDEWizardForm.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getPSDEFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardFormId(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isPSDEWizardFormIdDirty() && !bl2 : !pSDEWizardForm.isPSDEWizardFormIdDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getPSDEWizardFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardFormId_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardFormName(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isPSDEWizardFormNameDirty() && !bl2 : !pSDEWizardForm.isPSDEWizardFormNameDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getPSDEWizardFormName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDFORMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardFormName_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardId(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isPSDEWizardIdDirty() && !bl2 : !pSDEWizardForm.isPSDEWizardIdDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getPSDEWizardId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardId_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardStepId(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isPSDEWizardStepIdDirty() : !pSDEWizardForm.isPSDEWizardStepIdDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getPSDEWizardStepId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardStepId_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDSTEPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SavePSDEActionId(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isSavePSDEActionIdDirty() : !pSDEWizardForm.isSavePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getSavePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SavePSDEActionId_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SAVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StepActions(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isStepActionsDirty() && !bl2 : !pSDEWizardForm.isStepActionsDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getStepActions();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPACTIONS");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_StepActions_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isUserCatDirty() : !pSDEWizardForm.isUserCatDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isUserTagDirty() : !pSDEWizardForm.isUserTagDirty()) {
            return null;
        }
        String string = pSDEWizardForm.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isUserTag2Dirty() : !pSDEWizardForm.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEWizardForm.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isUserTag3Dirty() : !pSDEWizardForm.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEWizardForm.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEWizardForm pSDEWizardForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardForm.isUserTag4Dirty() : !pSDEWizardForm.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEWizardForm.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEWizardForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
        super.onSyncEntity(pSDEWizardForm, bl);
    }

    protected void onSyncIndexEntities(PSDEWizardForm pSDEWizardForm, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEWizardForm, bl);
    }

    public Object getDataContextValue(PSDEWizardForm pSDEWizardForm, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEWizardForm, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEWizard pSDEWizard = pSDEWizardForm.getPSDEWizard();
        if (pSDEWizard != null && pSDEWizard.contains(string)) {
            return pSDEWizard.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEWizardForm pSDEWizardForm, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEWizardForm, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CMPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CMPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CMPSLANRESID2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CMPSLanResId2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CMPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CMPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CMPSLANRESNAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CMPSLanResName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONFIRMINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConfirmInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONFIRMINFO2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConfirmInfo2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHENABLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishEnableLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIRSTFORM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FirstForm_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOADPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LoadPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOADPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LoadPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTENABLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NextEnableLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVENABLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrevEnableLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrevPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrevPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDSTEPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardStepId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDSTEPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardStepName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SAVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SavePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SAVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SavePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StepActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StepOrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CMPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CMPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CMPSLanResId2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CMPSLANRESID2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CMPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CMPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CMPSLanResName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CMPSLANRESNAME2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ConfirmInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONFIRMINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ConfirmInfo2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONFIRMINFO2", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
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

    protected String onTestValueRule_FinishEnableLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHENABLELOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FirstForm_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FormTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMTAG", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("FORMTAG", iEntity, bl2, "[a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LoadPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOADPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LoadPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOADPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_MobPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NextEnableLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTENABLELOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrevEnableLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVENABLELOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrevPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrevPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardStepId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDSTEPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardStepName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDSTEPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SavePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SAVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SavePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SAVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StepActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEPACTIONS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StepOrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEWizardForm pSDEWizardForm) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEWizardForm)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEWizardForm pSDEWizardForm) throws Exception {
        super.onUpdateParent(pSDEWizardForm);
    }

    @Override
    protected void exportCurXmlModel(PSDEWizardForm pSDEWizardForm, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEWIZARDFORM");
        if (!bl) {
            pSDEWizardForm.setCreateDate(null);
            pSDEWizardForm.setCreateMan(null);
            pSDEWizardForm.setPSDEWizardFormId(null);
            pSDEWizardForm.setUpdateDate(null);
            pSDEWizardForm.setUpdateMan(null);
            pSDEWizardForm.setPSDEWizardStepId(null);
            pSDEWizardForm.setStepOrderValue(null);
            pSDEWizardForm.setPSDEId(null);
            pSDEWizardForm.setPSDEWizardId(null);
            pSDEWizardForm.setPSDEWizardName(null);
            super.exportCurXmlModel(pSDEWizardForm, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEWizardForm pSDEWizardForm, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEWizardForm, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEWizardForm pSDEWizardForm, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEWizardForm, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEWizardForm pSDEWizardForm, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEWizardForm, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEWIZARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEWIZARD#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEWIZARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEWIZARDFORM_PSDEWIZARD_PSDEWIZARDID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEWIZARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEWIZARDNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEWIZARD", (boolean)true) == 0) {
            iEntity.set("PSDEWIZARDID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEWIZARDID"};
    }

    @Override
    public String getModelV2Tag(PSDEWizardForm pSDEWizardForm) {
        if (!StringHelper.isNullOrEmpty((String)pSDEWizardForm.getFormTag())) {
            return pSDEWizardForm.getFormTag();
        }
        return super.getModelV2Tag(pSDEWizardForm);
    }

    @Override
    public boolean setModelV2Tag(PSDEWizardForm pSDEWizardForm, String string) {
        pSDEWizardForm.setFormTag(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("FORMTAG", "");
        map.put("PSDEWIZARDID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEWizardForm pSDEWizardForm, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEWizardForm.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEWizardForm, true);
        pSDEWizardForm.set("FORMTAG", string);
        if (this.select(pSDEWizardForm, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEWizardForm, true);
        return super.getModelV2Entity(pSDEWizardForm, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEWizardForm pSDEWizardForm, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEWizardForm, objectNode, string, string2, n);
    }
}

