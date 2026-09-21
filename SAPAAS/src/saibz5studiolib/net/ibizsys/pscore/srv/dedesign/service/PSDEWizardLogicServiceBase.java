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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardLogicDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardLogicDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStep;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStepBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogicBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEWizardLogicServiceBase
extends PSCoreSysServiceBase<PSDEWizardLogic> {
    private static final Log log = LogFactory.getLog(PSDEWizardLogicServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEWizardLogicDEModel pSDEWizardLogicDEModel;
    private PSDEWizardLogicDAO pSDEWizardLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicService";
    }

    public PSDEWizardLogicDEModel getPSDEWizardLogicDEModel() {
        if (this.pSDEWizardLogicDEModel == null) {
            try {
                this.pSDEWizardLogicDEModel = (PSDEWizardLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEWizardLogicDEModel();
    }

    public PSDEWizardLogicDAO getPSDEWizardLogicDAO() {
        if (this.pSDEWizardLogicDAO == null) {
            try {
                this.pSDEWizardLogicDAO = (PSDEWizardLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEWizardLogicDAO();
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

    protected void onFillParentInfo(PSDEWizardLogic pSDEWizardLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDLOGIC_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEWizardLogic, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDLOGIC_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDEWizardLogic, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDLOGIC_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUIAction);
            } else {
                iService.get((IEntity)pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSDEWizardLogic, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDLOGIC_PSDEWIZARDFORM_PSDEWIZARDFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormService", (SessionFactory)this.getSessionFactory());
            PSDEWizardForm pSDEWizardForm = (PSDEWizardForm)iService.getDEModel().createEntity();
            pSDEWizardForm.set("PSDEWIZARDFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEWizardForm);
            } else {
                iService.get((IEntity)pSDEWizardForm);
            }
            this.onFillParentInfo_PSDEWizardForm(pSDEWizardLogic, pSDEWizardForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDLOGIC_PSDEWIZARDSTEP_PSDEWIZARDSTEPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService", (SessionFactory)this.getSessionFactory());
            PSDEWizardStep pSDEWizardStep = (PSDEWizardStep)iService.getDEModel().createEntity();
            pSDEWizardStep.set("PSDEWIZARDSTEPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEWizardStep);
            } else {
                iService.get((IEntity)pSDEWizardStep);
            }
            this.onFillParentInfo_PSDEWizardStep(pSDEWizardLogic, pSDEWizardStep);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDLOGIC_PSDEWIZARD_PSDEWIZARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService", (SessionFactory)this.getSessionFactory());
            PSDEWizard pSDEWizard = (PSDEWizard)iService.getDEModel().createEntity();
            pSDEWizard.set("PSDEWIZARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEWizard);
            } else {
                iService.get((IEntity)pSDEWizard);
            }
            this.onFillParentInfo_PSDEWizard(pSDEWizardLogic, pSDEWizard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEWizardLogic, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewLogic pSSysViewLogic = (PSSysViewLogic)iService.getDEModel().createEntity();
            pSSysViewLogic.set("PSSYSVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewLogic);
            } else {
                iService.get((IEntity)pSSysViewLogic);
            }
            this.onFillParentInfo_PSSysViewLogic(pSDEWizardLogic, pSSysViewLogic);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEWizardLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEWIZARDLOGIC_PSDEWIZARD_PSDEWIZARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService", (SessionFactory)this.getSessionFactory());
            PSDEWizard pSDEWizard = (PSDEWizard)iService.getDEModel().createEntity();
            pSDEWizard.set("PSDEWIZARDID", string2);
            return this.onSyncDER1NData_PSDEWizard(pSDEWizard, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEWizardLogic pSDEWizardLogic, PSDataEntity pSDataEntity) throws Exception {
        pSDEWizardLogic.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEWizardLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDELogic(PSDEWizardLogic pSDEWizardLogic, PSDELogic pSDELogic) throws Exception {
        pSDEWizardLogic.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEWizardLogic.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSDEWizardLogic pSDEWizardLogic, PSDEUIAction pSDEUIAction) throws Exception {
        pSDEWizardLogic.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSDEWizardLogic.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_PSDEWizardForm(PSDEWizardLogic pSDEWizardLogic, PSDEWizardForm pSDEWizardForm) throws Exception {
        pSDEWizardLogic.setPSDEWizardFormId(pSDEWizardForm.getPSDEWizardFormId());
        pSDEWizardLogic.setPSDEWizardFormName(pSDEWizardForm.getPSDEWizardFormName());
    }

    protected void onFillParentInfo_PSDEWizardStep(PSDEWizardLogic pSDEWizardLogic, PSDEWizardStep pSDEWizardStep) throws Exception {
        pSDEWizardLogic.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
        pSDEWizardLogic.setPSDEWizardStepName(pSDEWizardStep.getPSDEWizardStepName());
    }

    protected void onFillParentInfo_PSDEWizard(PSDEWizardLogic pSDEWizardLogic, PSDEWizard pSDEWizard) throws Exception {
        pSDEWizardLogic.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
        pSDEWizardLogic.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
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
            ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEWizard(pSDEWizard);
            for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEWizardLogic, (String)"PSDEWIZARDLOGICID", (String)""))) continue;
                this.remove((IEntity)pSDEWizardLogic);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEWizardLogic pSDEWizardLogic, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEWizardLogic.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEWizardLogic.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysViewLogic(PSDEWizardLogic pSDEWizardLogic, PSSysViewLogic pSSysViewLogic) throws Exception {
        pSDEWizardLogic.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
        pSDEWizardLogic.setPSSysViewLogicName(pSSysViewLogic.getPSSysViewLogicName());
    }

    protected void onFillEntityFullInfo(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
        if (bl && pSDEWizardLogic.getValidFlag() == null) {
            pSDEWizardLogic.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDEWizardLogic, bl);
        this.onFillEntityFullInfo_PSDE(pSDEWizardLogic, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDEWizardLogic, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSDEWizardLogic, bl);
        this.onFillEntityFullInfo_PSDEWizardForm(pSDEWizardLogic, bl);
        this.onFillEntityFullInfo_PSDEWizardStep(pSDEWizardLogic, bl);
        this.onFillEntityFullInfo_PSDEWizard(pSDEWizardLogic, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEWizardLogic, bl);
        this.onFillEntityFullInfo_PSSysViewLogic(pSDEWizardLogic, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
        if (pSDEWizardLogic.isPSDEIdDirty()) {
            if (pSDEWizardLogic.getPSDEId() != null) {
                if (pSDEWizardLogic.getPSDEId() == null || pSDEWizardLogic.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEWizardLogic.getPSDE();
                    pSDEWizardLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEWizardLogic.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEWizardForm(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEWizardStep(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEWizard(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewLogic(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEWizardLogic, bl);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUIACTIONID", (Object)pSDEUIActionBase.getPSDEUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEWizardForm(PSDEWizardFormBase pSDEWizardFormBase) throws Exception {
        return this.selectByPSDEWizardForm(pSDEWizardFormBase, "", -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEWizardForm(PSDEWizardFormBase pSDEWizardFormBase, String string) throws Exception {
        return this.selectByPSDEWizardForm(pSDEWizardFormBase, string, -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEWizardForm(PSDEWizardFormBase pSDEWizardFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEWIZARDFORMID", (Object)pSDEWizardFormBase.getPSDEWizardFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEWizardFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEWizardFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardLogic> selectTempByPSDEWizardForm(PSDEWizardFormBase pSDEWizardFormBase) throws Exception {
        return this.selectTempByPSDEWizardForm(pSDEWizardFormBase, "");
    }

    public ArrayList<PSDEWizardLogic> selectTempByPSDEWizardForm(PSDEWizardFormBase pSDEWizardFormBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEWIZARDFORMID", (Object)pSDEWizardFormBase.getPSDEWizardFormId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEWizardFormCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEWizardFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEWizardStep(PSDEWizardStepBase pSDEWizardStepBase) throws Exception {
        return this.selectByPSDEWizardStep(pSDEWizardStepBase, "", -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEWizardStep(PSDEWizardStepBase pSDEWizardStepBase, String string) throws Exception {
        return this.selectByPSDEWizardStep(pSDEWizardStepBase, string, -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEWizardStep(PSDEWizardStepBase pSDEWizardStepBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEWizardLogic> selectTempByPSDEWizardStep(PSDEWizardStepBase pSDEWizardStepBase) throws Exception {
        return this.selectTempByPSDEWizardStep(pSDEWizardStepBase, "");
    }

    public ArrayList<PSDEWizardLogic> selectTempByPSDEWizardStep(PSDEWizardStepBase pSDEWizardStepBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEWIZARDSTEPID", (Object)pSDEWizardStepBase.getPSDEWizardStepId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEWizardStepCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEWizardStepCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase) throws Exception {
        return this.selectByPSDEWizard(pSDEWizardBase, "", -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string) throws Exception {
        return this.selectByPSDEWizard(pSDEWizardBase, string, -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEWizardLogic> selectTempByPSDEWizard(PSDEWizardBase pSDEWizardBase) throws Exception {
        return this.selectTempByPSDEWizard(pSDEWizardBase, "");
    }

    public ArrayList<PSDEWizardLogic> selectTempByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEWIZARDID", (Object)pSDEWizardBase.getPSDEWizardId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEWizardCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEWizardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, "", -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, string, -1);
    }

    public ArrayList<PSDEWizardLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWLOGICID", (Object)pSSysViewLogicBase.getPSSysViewLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDLOGIC_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDEWIZARDLOGIC", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            PSDEWizardLogic pSDEWizardLogic2 = (PSDEWizardLogic)this.getDEModel().createEntity();
            pSDEWizardLogic2.setPSDEWizardLogicId(pSDEWizardLogic.getPSDEWizardLogicId());
            pSDEWizardLogic2.setPSDEId(null);
            this.update(pSDEWizardLogic2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardLogicServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEWizardLogicServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEWizardLogicServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            this.remove((IEntity)pSDEWizardLogic);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDLOGIC_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSDEWIZARDLOGIC", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            PSDEWizardLogic pSDEWizardLogic2 = (PSDEWizardLogic)this.getDEModel().createEntity();
            pSDEWizardLogic2.setPSDEWizardLogicId(pSDEWizardLogic.getPSDEWizardLogicId());
            pSDEWizardLogic2.setPSDELogicId(null);
            this.update(pSDEWizardLogic2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardLogicServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDEWizardLogicServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDEWizardLogicServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            this.remove((IEntity)pSDEWizardLogic);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDLOGIC_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDEWIZARDLOGIC", iDataEntityModel.getDataInfo((IEntity)pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            PSDEWizardLogic pSDEWizardLogic2 = (PSDEWizardLogic)this.getDEModel().createEntity();
            pSDEWizardLogic2.setPSDEWizardLogicId(pSDEWizardLogic.getPSDEWizardLogicId());
            pSDEWizardLogic2.setPSDEUIActionId(null);
            this.update(pSDEWizardLogic2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardLogicServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEWizardLogicServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEWizardLogicServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            this.remove((IEntity)pSDEWizardLogic);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEWizardForm(PSDEWizardForm pSDEWizardForm) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEWizardForm(pSDEWizardForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEWIZARDFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEWizardForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDLOGIC_PSDEWIZARDFORM_PSDEWIZARDFORMID", "", iDataEntityModel.getName(), "PSDEWIZARDLOGIC", iDataEntityModel.getDataInfo((IEntity)pSDEWizardForm), arrayList.get(0)));
        }
    }

    public void resetPSDEWizardForm(PSDEWizardForm pSDEWizardForm) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEWizardForm(pSDEWizardForm);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            PSDEWizardLogic pSDEWizardLogic2 = (PSDEWizardLogic)this.getDEModel().createEntity();
            pSDEWizardLogic2.setPSDEWizardLogicId(pSDEWizardLogic.getPSDEWizardLogicId());
            pSDEWizardLogic2.setPSDEWizardFormId(null);
            this.update(pSDEWizardLogic2);
        }
    }

    public void resetTempPSDEWizardForm(PSDEWizardForm pSDEWizardForm) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectTempByPSDEWizardForm(pSDEWizardForm);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            PSDEWizardLogic pSDEWizardLogic2 = (PSDEWizardLogic)this.getDEModel().createEntity();
            pSDEWizardLogic2.setPSDEWizardLogicId(pSDEWizardLogic.getPSDEWizardLogicId());
            pSDEWizardLogic2.setPSDEWizardFormId(null);
            this.updateTemp((IEntity)pSDEWizardLogic2);
        }
    }

    public void removeByPSDEWizardForm(PSDEWizardForm pSDEWizardForm) throws Exception {
        final PSDEWizardForm pSDEWizardForm2 = pSDEWizardForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardLogicServiceBase.this.onBeforeRemoveByPSDEWizardForm(pSDEWizardForm2);
                PSDEWizardLogicServiceBase.this.internalRemoveByPSDEWizardForm(pSDEWizardForm2);
                PSDEWizardLogicServiceBase.this.onAfterRemoveByPSDEWizardForm(pSDEWizardForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEWizardForm(PSDEWizardForm pSDEWizardForm) throws Exception {
    }

    protected void internalRemoveByPSDEWizardForm(PSDEWizardForm pSDEWizardForm) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEWizardForm(pSDEWizardForm);
        this.onBeforeRemoveByPSDEWizardForm(pSDEWizardForm, arrayList);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            this.remove((IEntity)pSDEWizardLogic);
        }
        this.onAfterRemoveByPSDEWizardForm(pSDEWizardForm, arrayList);
    }

    protected void onAfterRemoveByPSDEWizardForm(PSDEWizardForm pSDEWizardForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEWizardForm(PSDEWizardForm pSDEWizardForm, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEWizardForm(PSDEWizardForm pSDEWizardForm, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEWizardStep(pSDEWizardStep, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEWIZARDSTEP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEWizardStep);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDLOGIC_PSDEWIZARDSTEP_PSDEWIZARDSTEPID", "", iDataEntityModel.getName(), "PSDEWIZARDLOGIC", iDataEntityModel.getDataInfo((IEntity)pSDEWizardStep), arrayList.get(0)));
        }
    }

    public void resetPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEWizardStep(pSDEWizardStep);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            PSDEWizardLogic pSDEWizardLogic2 = (PSDEWizardLogic)this.getDEModel().createEntity();
            pSDEWizardLogic2.setPSDEWizardLogicId(pSDEWizardLogic.getPSDEWizardLogicId());
            pSDEWizardLogic2.setPSDEWizardStepId(null);
            this.update(pSDEWizardLogic2);
        }
    }

    public void resetTempPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectTempByPSDEWizardStep(pSDEWizardStep);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            PSDEWizardLogic pSDEWizardLogic2 = (PSDEWizardLogic)this.getDEModel().createEntity();
            pSDEWizardLogic2.setPSDEWizardLogicId(pSDEWizardLogic.getPSDEWizardLogicId());
            pSDEWizardLogic2.setPSDEWizardStepId(null);
            this.updateTemp((IEntity)pSDEWizardLogic2);
        }
    }

    public void removeByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        final PSDEWizardStep pSDEWizardStep2 = pSDEWizardStep;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardLogicServiceBase.this.onBeforeRemoveByPSDEWizardStep(pSDEWizardStep2);
                PSDEWizardLogicServiceBase.this.internalRemoveByPSDEWizardStep(pSDEWizardStep2);
                PSDEWizardLogicServiceBase.this.onAfterRemoveByPSDEWizardStep(pSDEWizardStep2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
    }

    protected void internalRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEWizardStep(pSDEWizardStep);
        this.onBeforeRemoveByPSDEWizardStep(pSDEWizardStep, arrayList);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            this.remove((IEntity)pSDEWizardLogic);
        }
        this.onAfterRemoveByPSDEWizardStep(pSDEWizardStep, arrayList);
    }

    protected void onAfterRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
    }

    protected void onBeforeRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEWizardStep(PSDEWizardStep pSDEWizardStep, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    public void resetPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEWizard(pSDEWizard);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            PSDEWizardLogic pSDEWizardLogic2 = (PSDEWizardLogic)this.getDEModel().createEntity();
            pSDEWizardLogic2.setPSDEWizardLogicId(pSDEWizardLogic.getPSDEWizardLogicId());
            pSDEWizardLogic2.setPSDEWizardId(null);
            this.update(pSDEWizardLogic2);
        }
    }

    public void resetTempPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectTempByPSDEWizard(pSDEWizard);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            PSDEWizardLogic pSDEWizardLogic2 = (PSDEWizardLogic)this.getDEModel().createEntity();
            pSDEWizardLogic2.setPSDEWizardLogicId(pSDEWizardLogic.getPSDEWizardLogicId());
            pSDEWizardLogic2.setPSDEWizardId(null);
            this.updateTemp((IEntity)pSDEWizardLogic2);
        }
    }

    public void removeByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        final PSDEWizard pSDEWizard2 = pSDEWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardLogicServiceBase.this.onBeforeRemoveByPSDEWizard(pSDEWizard2);
                PSDEWizardLogicServiceBase.this.internalRemoveByPSDEWizard(pSDEWizard2);
                PSDEWizardLogicServiceBase.this.onAfterRemoveByPSDEWizard(pSDEWizard2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void internalRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSDEWizard(pSDEWizard);
        this.onBeforeRemoveByPSDEWizard(pSDEWizard, arrayList);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            this.remove((IEntity)pSDEWizardLogic);
        }
        this.onAfterRemoveByPSDEWizard(pSDEWizard, arrayList);
    }

    protected void onAfterRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void onBeforeRemoveByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEWIZARDLOGIC", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            PSDEWizardLogic pSDEWizardLogic2 = (PSDEWizardLogic)this.getDEModel().createEntity();
            pSDEWizardLogic2.setPSDEWizardLogicId(pSDEWizardLogic.getPSDEWizardLogicId());
            pSDEWizardLogic2.setPSSysPFPluginId(null);
            this.update(pSDEWizardLogic2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardLogicServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEWizardLogicServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEWizardLogicServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            this.remove((IEntity)pSDEWizardLogic);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", "", iDataEntityModel.getName(), "PSDEWIZARDLOGIC", iDataEntityModel.getDataInfo((IEntity)pSSysViewLogic), arrayList.get(0)));
        }
    }

    public void resetPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            PSDEWizardLogic pSDEWizardLogic2 = (PSDEWizardLogic)this.getDEModel().createEntity();
            pSDEWizardLogic2.setPSDEWizardLogicId(pSDEWizardLogic.getPSDEWizardLogicId());
            pSDEWizardLogic2.setPSSysViewLogicId(null);
            this.update(pSDEWizardLogic2);
        }
    }

    public void removeByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardLogicServiceBase.this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDEWizardLogicServiceBase.this.internalRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDEWizardLogicServiceBase.this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void internalRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            this.remove((IEntity)pSDEWizardLogic);
        }
        this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEWizardLogic pSDEWizardLogic) throws Exception {
        super.onBeforeRemove(pSDEWizardLogic);
    }

    public void removeTempByPSDEWizardForm(PSDEWizardForm pSDEWizardForm) throws Exception {
        final PSDEWizardForm pSDEWizardForm2 = pSDEWizardForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardLogicServiceBase.this.onBeforeRemoveTempByPSDEWizardForm(pSDEWizardForm2);
                PSDEWizardLogicServiceBase.this.internalRemoveTempByPSDEWizardForm(pSDEWizardForm2);
                PSDEWizardLogicServiceBase.this.onAfterRemoveTempByPSDEWizardForm(pSDEWizardForm2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEWizardForm(PSDEWizardForm pSDEWizardForm) throws Exception {
    }

    protected void internalRemoveTempByPSDEWizardForm(PSDEWizardForm pSDEWizardForm) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectTempByPSDEWizardForm(pSDEWizardForm);
        this.onBeforeRemoveTempByPSDEWizardForm(pSDEWizardForm, arrayList);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            this.removeTemp((IEntity)pSDEWizardLogic);
        }
        this.onAfterRemoveTempByPSDEWizardForm(pSDEWizardForm, arrayList);
    }

    protected void onAfterRemoveTempByPSDEWizardForm(PSDEWizardForm pSDEWizardForm) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEWizardForm(PSDEWizardForm pSDEWizardForm, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEWizardForm(PSDEWizardForm pSDEWizardForm, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    public void removeTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        final PSDEWizardStep pSDEWizardStep2 = pSDEWizardStep;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardLogicServiceBase.this.onBeforeRemoveTempByPSDEWizardStep(pSDEWizardStep2);
                PSDEWizardLogicServiceBase.this.internalRemoveTempByPSDEWizardStep(pSDEWizardStep2);
                PSDEWizardLogicServiceBase.this.onAfterRemoveTempByPSDEWizardStep(pSDEWizardStep2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
    }

    protected void internalRemoveTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectTempByPSDEWizardStep(pSDEWizardStep);
        this.onBeforeRemoveTempByPSDEWizardStep(pSDEWizardStep, arrayList);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            this.removeTemp((IEntity)pSDEWizardLogic);
        }
        this.onAfterRemoveTempByPSDEWizardStep(pSDEWizardStep, arrayList);
    }

    protected void onAfterRemoveTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEWizardStep(PSDEWizardStep pSDEWizardStep, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    public void removeTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        final PSDEWizard pSDEWizard2 = pSDEWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardLogicServiceBase.this.onBeforeRemoveTempByPSDEWizard(pSDEWizard2);
                PSDEWizardLogicServiceBase.this.internalRemoveTempByPSDEWizard(pSDEWizard2);
                PSDEWizardLogicServiceBase.this.onAfterRemoveTempByPSDEWizard(pSDEWizard2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void internalRemoveTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.selectTempByPSDEWizard(pSDEWizard);
        this.onBeforeRemoveTempByPSDEWizard(pSDEWizard, arrayList);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            this.removeTemp((IEntity)pSDEWizardLogic);
        }
        this.onAfterRemoveTempByPSDEWizard(pSDEWizard, arrayList);
    }

    protected void onAfterRemoveTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEWizardLogic pSDEWizardLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEWizardLogic, cloneSession);
        if (pSDEWizardLogic.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEWizardLogic.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEWizardLogic, (PSDataEntity)iEntity);
        }
        if (pSDEWizardLogic.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEWizardLogic.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDEWizardLogic, (PSDELogic)iEntity);
        }
        if (pSDEWizardLogic.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDEWizardLogic.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSDEWizardLogic, (PSDEUIAction)iEntity);
        }
        if (pSDEWizardLogic.getPSDEWizardFormId() != null && (iEntity = cloneSession.getEntity("PSDEWIZARDFORM", (Object)pSDEWizardLogic.getPSDEWizardFormId())) != null) {
            this.onFillParentInfo_PSDEWizardForm(pSDEWizardLogic, (PSDEWizardForm)iEntity);
        }
        if (pSDEWizardLogic.getPSDEWizardStepId() != null && (iEntity = cloneSession.getEntity("PSDEWIZARDSTEP", (Object)pSDEWizardLogic.getPSDEWizardStepId())) != null) {
            this.onFillParentInfo_PSDEWizardStep(pSDEWizardLogic, (PSDEWizardStep)iEntity);
        }
        if (pSDEWizardLogic.getPSDEWizardId() != null && (iEntity = cloneSession.getEntity("PSDEWIZARD", (Object)pSDEWizardLogic.getPSDEWizardId())) != null) {
            this.onFillParentInfo_PSDEWizard(pSDEWizardLogic, (PSDEWizard)iEntity);
        }
        if (pSDEWizardLogic.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEWizardLogic.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEWizardLogic, (PSSysPFPlugin)iEntity);
        }
        if (pSDEWizardLogic.getPSSysViewLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWLOGIC", (Object)pSDEWizardLogic.getPSSysViewLogicId())) != null) {
            this.onFillParentInfo_PSSysViewLogic(pSDEWizardLogic, (PSSysViewLogic)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEWizardLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AttrName(bl, pSDEWizardLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstLogicType(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventArg2(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EventNames(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam2(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardFormId(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardId(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardLogicId(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardLogicName(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardStepId(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewLogicId(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Timer(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TriggerType(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEWizardLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEWizardLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AttrName(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isAttrNameDirty() : !pSDEWizardLogic.isAttrNameDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getAttrName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrName_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isCustomCodeDirty() : !pSDEWizardLogic.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstLogicType(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isDstLogicTypeDirty() && !bl2 : !pSDEWizardLogic.isDstLogicTypeDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getDstLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTLOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstLogicType_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTLOGICTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EventArg(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isEventArgDirty() : !pSDEWizardLogic.isEventArgDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getEventArg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTARG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EventArg2(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isEventArg2Dirty() : !pSDEWizardLogic.isEventArg2Dirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getEventArg2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventArg2_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTARG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EventNames(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isEventNamesDirty() : !pSDEWizardLogic.isEventNamesDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getEventNames();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EventNames_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EVENTNAMES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicParam(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isLogicParamDirty() : !pSDEWizardLogic.isLogicParamDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getLogicParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicParam2(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isLogicParam2Dirty() : !pSDEWizardLogic.isLogicParam2Dirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getLogicParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam2_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isMemoDirty() : !pSDEWizardLogic.isMemoDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEWizardLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isOrderValueDirty() : !pSDEWizardLogic.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEWizardLogic.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEWizardLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isPSDEIdDirty() : !pSDEWizardLogic.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isPSDELogicIdDirty() : !pSDEWizardLogic.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isPSDENameDirty() : !pSDEWizardLogic.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isPSDEUIActionIdDirty() : !pSDEWizardLogic.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardFormId(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isPSDEWizardFormIdDirty() : !pSDEWizardLogic.isPSDEWizardFormIdDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getPSDEWizardFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardFormId_Default((IEntity)pSDEWizardLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEWizardId(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isPSDEWizardIdDirty() : !pSDEWizardLogic.isPSDEWizardIdDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getPSDEWizardId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardId_Default((IEntity)pSDEWizardLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEWizardLogicId(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isPSDEWizardLogicIdDirty() && !bl2 : !pSDEWizardLogic.isPSDEWizardLogicIdDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getPSDEWizardLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardLogicId_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardLogicName(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isPSDEWizardLogicNameDirty() && !bl2 : !pSDEWizardLogic.isPSDEWizardLogicNameDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getPSDEWizardLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDLOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardLogicName_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEWIZARDID";
                String string4 = this.checkFieldDupRule(this.getPSDEWizardLogicDEModel(), "PSDEWIZARDLOGICNAME", string3, pSDEWizardLogic, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEWIZARDLOGICNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardStepId(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isPSDEWizardStepIdDirty() : !pSDEWizardLogic.isPSDEWizardStepIdDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getPSDEWizardStepId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardStepId_Default((IEntity)pSDEWizardLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isPSSysPFPluginIdDirty() : !pSDEWizardLogic.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewLogicId(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isPSSysViewLogicIdDirty() : !pSDEWizardLogic.isPSSysViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getPSSysViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewLogicId_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Timer(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isTimerDirty() : !pSDEWizardLogic.isTimerDirty()) {
            return null;
        }
        Integer n = pSDEWizardLogic.getTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Timer_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TriggerType(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isTriggerTypeDirty() && !bl2 : !pSDEWizardLogic.isTriggerTypeDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getTriggerType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRIGGERTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TriggerType_Default((IEntity)pSDEWizardLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRIGGERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isUserCatDirty() : !pSDEWizardLogic.isUserCatDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEWizardLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isUserTagDirty() : !pSDEWizardLogic.isUserTagDirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEWizardLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isUserTag2Dirty() : !pSDEWizardLogic.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEWizardLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isUserTag3Dirty() : !pSDEWizardLogic.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEWizardLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isUserTag4Dirty() : !pSDEWizardLogic.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEWizardLogic.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEWizardLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEWizardLogic pSDEWizardLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardLogic.isValidFlagDirty() && !bl2 : !pSDEWizardLogic.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEWizardLogic.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEWizardLogic, bl2, bl3);
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

    protected void onSyncEntity(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEWizardLogic, bl);
    }

    protected void onSyncIndexEntities(PSDEWizardLogic pSDEWizardLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEWizardLogic, bl);
    }

    public Object getDataContextValue(PSDEWizardLogic pSDEWizardLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEWizardLogic, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEWizard pSDEWizard = pSDEWizardLogic.getPSDEWizard();
        if (pSDEWizard != null && pSDEWizard.contains(string)) {
            return pSDEWizard.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEWizardLogic pSDEWizardLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEWizardLogic, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ATTRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTLOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstLogicType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTARG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventArg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTARG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventArg2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EVENTNAMES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EventNames_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardLogicName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Timer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TRIGGERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TriggerType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AttrName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_CustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstLogicType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTLOGICTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EventArg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTARG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EventArg2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTARG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EventNames_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EVENTNAMES", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEWizardLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDLOGICNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSDEWIZARDLOGICNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Timer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TriggerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TRIGGERTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEWizardLogic pSDEWizardLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEWizardLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEWizardLogic pSDEWizardLogic) throws Exception {
        super.onUpdateParent((IEntity)pSDEWizardLogic);
    }

    @Override
    protected void exportCurXmlModel(PSDEWizardLogic pSDEWizardLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEWIZARDLOGIC");
        if (!bl) {
            pSDEWizardLogic.setCreateDate(null);
            pSDEWizardLogic.setCreateMan(null);
            pSDEWizardLogic.setPSDEWizardLogicId(null);
            pSDEWizardLogic.setUpdateDate(null);
            pSDEWizardLogic.setUpdateMan(null);
            pSDEWizardLogic.setPSDEWizardFormId(null);
            pSDEWizardLogic.setPSDEWizardStepId(null);
            pSDEWizardLogic.setPSDEWizardId(null);
            pSDEWizardLogic.setPSDEWizardName(null);
            super.exportCurXmlModel(pSDEWizardLogic, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEWizardLogic pSDEWizardLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEWizardLogic, string);
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
            return "DER1N_PSDEWIZARDLOGIC_PSDEWIZARD_PSDEWIZARDID";
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
    public String getModelV2Tag(PSDEWizardLogic pSDEWizardLogic) {
        if (!StringHelper.isNullOrEmpty((String)pSDEWizardLogic.getPSDEWizardLogicName())) {
            return pSDEWizardLogic.getPSDEWizardLogicName();
        }
        return super.getModelV2Tag(pSDEWizardLogic);
    }

    @Override
    public boolean setModelV2Tag(PSDEWizardLogic pSDEWizardLogic, String string) {
        pSDEWizardLogic.setPSDEWizardLogicName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEWIZARDLOGICNAME", "");
        map.put("PSDEWIZARDID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEWizardLogic pSDEWizardLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEWizardLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEWizardLogic, true);
        pSDEWizardLogic.set("PSDEWIZARDLOGICNAME", string);
        if (this.select(pSDEWizardLogic, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEWizardLogic, true);
        return super.getModelV2Entity(pSDEWizardLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEWizardLogic pSDEWizardLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEWizardLogic, objectNode, string, string2, n);
    }
}

