/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
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
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
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
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStep;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStepBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEWizardServiceBase
extends PSCoreSysServiceBase<PSDEWizard> {
    private static final Log log = LogFactory.getLog(PSDEWizardServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURAPPSTATE = "CurAppState";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURDESTATE = "CurDEState";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSSTATE = "CurSysState";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_INITFINISHACTION = "InitFinishAction";
    private PSDEWizardDEModel pSDEWizardDEModel;
    private PSDEWizardDAO pSDEWizardDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService";
    }

    public PSDEWizardDEModel getPSDEWizardDEModel() {
        if (this.pSDEWizardDEModel == null) {
            try {
                this.pSDEWizardDEModel = (PSDEWizardDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEWizardDEModel();
    }

    public PSDEWizardDAO getPSDEWizardDAO() {
        if (this.pSDEWizardDAO == null) {
            try {
                this.pSDEWizardDAO = (PSDEWizardDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEWizardDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPSTATE, (boolean)true) == 0) {
            return this.fetchCurAppState(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDESTATE, (boolean)true) == 0) {
            return this.fetchCurDEState(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSSTATE, (boolean)true) == 0) {
            return this.fetchCurSysState(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchTempCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPSTATE, (boolean)true) == 0) {
            return this.fetchTempCurAppState(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDESTATE, (boolean)true) == 0) {
            return this.fetchTempCurDEState(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchTempCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSSTATE, (boolean)true) == 0) {
            return this.fetchTempCurSysState(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_INITFINISHACTION, (boolean)true) == 0) {
            this.initFinishAction((PSDEWizard)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurAppState(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPSTATE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAppState(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPSTATE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEState(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDESTATE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEState(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDESTATE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysState(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSSTATE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysState(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSSTATE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void initFinishAction(PSDEWizard pSDEWizard) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITFINISHACTION, 0, pSDEWizard, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEWizard, ACTION_INITFINISHACTION);
        final PSDEWizard pSDEWizard2 = pSDEWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEWizardServiceBase.this.getService(), PSDEWizardServiceBase.ACTION_INITFINISHACTION, 40, pSDEWizard2, null).getResult() != 1) {
                    PSDEWizardServiceBase.this.onInitFinishAction(pSDEWizard2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITFINISHACTION, 99, pSDEWizard, null);
        }
    }

    protected void onInitFinishAction(PSDEWizard pSDEWizard) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitFinishAction]");
    }

    protected void onFillParentInfo(PSDEWizard pSDEWizard, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlLogicGroup);
            } else {
                iService.get(pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEWizard, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlMsg);
            } else {
                iService.get(pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSDEWizard, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEWizard, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSDEACTION_FINISHPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_FinishPSDEAction(pSDEWizard, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSDEACTION_INITPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_InitPSDEAction(pSDEWizard, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSDEFIELD_STATEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_StatePSDEF(pSDEWizard, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSDELOGIC_PSDEMSLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDEMSLogic(pSDEWizard, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSLANGUAGERES_FINISHPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_FinishPSLanRes(pSDEWizard, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSLANGUAGERES_NEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_NextPSLanRes(pSDEWizard, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSLANGUAGERES_PREVPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_PrevPSLanRes(pSDEWizard, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEWizard, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEWizard, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEWizard, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARD_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsgGroup);
            } else {
                iService.get(pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSDEWizard, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo(pSDEWizard, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSDEWizard pSDEWizard, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSDEWizard.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSDEWizard.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSCtrlMsg(PSDEWizard pSDEWizard, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSDEWizard.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSDEWizard.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_PSDE(PSDEWizard pSDEWizard, PSDataEntity pSDataEntity) throws Exception {
        pSDEWizard.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEWizard.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_FinishPSDEAction(PSDEWizard pSDEWizard, PSDEAction pSDEAction) throws Exception {
        pSDEWizard.setFinishPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEWizard.setFinishPSDEActionName(pSDEAction.getPSDEActionName());
        if (pSDEAction.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEWizard, pSDEAction.getPSDE());
        }
    }

    protected void onFillParentInfo_InitPSDEAction(PSDEWizard pSDEWizard, PSDEAction pSDEAction) throws Exception {
        pSDEWizard.setInitPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEWizard.setInitPSDEActionName(pSDEAction.getPSDEActionName());
        if (pSDEAction.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEWizard, pSDEAction.getPSDE());
        }
    }

    protected void onFillParentInfo_StatePSDEF(PSDEWizard pSDEWizard, PSDEField pSDEField) throws Exception {
        pSDEWizard.setStatePSDEFId(pSDEField.getPSDEFieldId());
        pSDEWizard.setStatePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEMSLogic(PSDEWizard pSDEWizard, PSDELogic pSDELogic) throws Exception {
        pSDEWizard.setPSDEMSLogicId(pSDELogic.getPSDELogicId());
        pSDEWizard.setPSDEMSLogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_FinishPSLanRes(PSDEWizard pSDEWizard, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEWizard.setFinishPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEWizard.setFinishPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_NextPSLanRes(PSDEWizard pSDEWizard, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEWizard.setNextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEWizard.setNextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PrevPSLanRes(PSDEWizard pSDEWizard, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEWizard.setPrevPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEWizard.setPrevPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEWizard pSDEWizard, PSSysCss pSSysCss) throws Exception {
        pSDEWizard.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEWizard.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEWizard pSDEWizard, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEWizard.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEWizard.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEWizard pSDEWizard, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEWizard.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEWizard.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSDEWizard pSDEWizard, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSDEWizard.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSDEWizard.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSDEWizard pSDEWizard, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDEWizard, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSDEWizard, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSDEWizard, bl);
        this.onFillEntityFullInfo_PSDE(pSDEWizard, bl);
        this.onFillEntityFullInfo_FinishPSDEAction(pSDEWizard, bl);
        this.onFillEntityFullInfo_InitPSDEAction(pSDEWizard, bl);
        this.onFillEntityFullInfo_StatePSDEF(pSDEWizard, bl);
        this.onFillEntityFullInfo_PSDEMSLogic(pSDEWizard, bl);
        this.onFillEntityFullInfo_FinishPSLanRes(pSDEWizard, bl);
        this.onFillEntityFullInfo_NextPSLanRes(pSDEWizard, bl);
        this.onFillEntityFullInfo_PrevPSLanRes(pSDEWizard, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEWizard, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEWizard, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEWizard, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSDEWizard, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSDEWizard pSDEWizard, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSDEWizard pSDEWizard, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDEWizard pSDEWizard, boolean bl) throws Exception {
        if (pSDEWizard.isPSDEIdDirty()) {
            if (pSDEWizard.getPSDEId() != null) {
                if (pSDEWizard.getPSDEId() == null || pSDEWizard.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEWizard.getPSDE();
                    pSDEWizard.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEWizard.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_FinishPSDEAction(PSDEWizard pSDEWizard, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InitPSDEAction(PSDEWizard pSDEWizard, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_StatePSDEF(PSDEWizard pSDEWizard, boolean bl) throws Exception {
        if (pSDEWizard.isStatePSDEFIdDirty()) {
            if (pSDEWizard.getStatePSDEFId() != null) {
                if (pSDEWizard.getStatePSDEFId() == null || pSDEWizard.getStatePSDEFName() == null) {
                    PSDEField pSDEField = pSDEWizard.getStatePSDEF();
                    pSDEWizard.setStatePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEWizard.setStatePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEMSLogic(PSDEWizard pSDEWizard, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_FinishPSLanRes(PSDEWizard pSDEWizard, boolean bl) throws Exception {
        if (pSDEWizard.isFinishPSLanResIdDirty()) {
            if (pSDEWizard.getFinishPSLanResId() != null) {
                if (pSDEWizard.getFinishPSLanResId() == null || pSDEWizard.getFinishPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEWizard.getFinishPSLanRes();
                    pSDEWizard.setFinishPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEWizard.setFinishPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_NextPSLanRes(PSDEWizard pSDEWizard, boolean bl) throws Exception {
        if (pSDEWizard.isNextPSLanResIdDirty()) {
            if (pSDEWizard.getNextPSLanResId() != null) {
                if (pSDEWizard.getNextPSLanResId() == null || pSDEWizard.getNextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEWizard.getNextPSLanRes();
                    pSDEWizard.setNextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEWizard.setNextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PrevPSLanRes(PSDEWizard pSDEWizard, boolean bl) throws Exception {
        if (pSDEWizard.isPrevPSLanResIdDirty()) {
            if (pSDEWizard.getPrevPSLanResId() != null) {
                if (pSDEWizard.getPrevPSLanResId() == null || pSDEWizard.getPrevPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEWizard.getPrevPSLanRes();
                    pSDEWizard.setPrevPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEWizard.setPrevPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEWizard pSDEWizard, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEWizard pSDEWizard, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEWizard pSDEWizard, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSDEWizard pSDEWizard, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEWizard pSDEWizard, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEWizard, bl);
    }

    public ArrayList<PSDEWizard> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLLOGICGROUPID", (Object)pSCtrlLogicGroupBase.getPSCtrlLogicGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlLogicGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlLogicGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizard> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLMSGID", (Object)pSCtrlMsgBase.getPSCtrlMsgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlMsgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlMsgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizard> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEWizard> selectByFinishPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByFinishPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByFinishPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByFinishPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByFinishPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FINISHPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFinishPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFinishPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizard> selectByInitPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByInitPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByInitPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByInitPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByInitPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INITPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInitPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInitPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizard> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByStatePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByStatePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByStatePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByStatePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizard> selectByPSDEMSLogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDEMSLogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByPSDEMSLogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDEMSLogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByPSDEMSLogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMSLOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEMSLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEMSLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizard> selectByFinishPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByFinishPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByFinishPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByFinishPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByFinishPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FINISHPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFinishPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFinishPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizard> selectByNextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByNextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByNextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByNextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByNextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NEXTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNextPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNextPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizard> selectByPrevPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByPrevPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByPrevPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByPrevPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByPrevPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PREVPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPrevPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPrevPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizard> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizard> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEWizard> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSREQITEMID", (Object)pSSysReqItemBase.getPSSysReqItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysReqItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysReqItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizard> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSDEWizard> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSDEWizard> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWMSGGROUPID", (Object)pSViewMsgGroupBase.getPSViewMsgGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewMsgGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewMsgGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setPSCtrlLogicGroupId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEWizardServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEWizardServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSCTRLMSG_PSCTRLMSGID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSCtrlMsg), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setPSCtrlMsgId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEWizardServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEWizardServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setPSDEId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEWizardServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEWizardServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByFinishPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSDEACTION_FINISHPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByFinishPSDEAction(pSDEAction);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setFinishPSDEActionId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByFinishPSDEAction(pSDEAction2);
                PSDEWizardServiceBase.this.internalRemoveByFinishPSDEAction(pSDEAction2);
                PSDEWizardServiceBase.this.onAfterRemoveByFinishPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByFinishPSDEAction(pSDEAction);
        this.onBeforeRemoveByFinishPSDEAction(pSDEAction, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByFinishPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByFinishPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFinishPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByInitPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSDEACTION_INITPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByInitPSDEAction(pSDEAction);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setInitPSDEActionId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByInitPSDEAction(pSDEAction2);
                PSDEWizardServiceBase.this.internalRemoveByInitPSDEAction(pSDEAction2);
                PSDEWizardServiceBase.this.onAfterRemoveByInitPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByInitPSDEAction(pSDEAction);
        this.onBeforeRemoveByInitPSDEAction(pSDEAction, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByInitPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByInitPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInitPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByStatePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSDEFIELD_STATEPSDEFID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByStatePSDEF(pSDEField);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setStatePSDEFId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByStatePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByStatePSDEF(pSDEField2);
                PSDEWizardServiceBase.this.internalRemoveByStatePSDEF(pSDEField2);
                PSDEWizardServiceBase.this.onAfterRemoveByStatePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByStatePSDEF(pSDEField);
        this.onBeforeRemoveByStatePSDEF(pSDEField, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByStatePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByStatePSDEF(PSDEField pSDEField, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByStatePSDEF(PSDEField pSDEField, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSDEMSLogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSDELOGIC_PSDEMSLOGICID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSDEMSLogic(pSDELogic);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setPSDEMSLogicId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByPSDEMSLogic(pSDELogic2);
                PSDEWizardServiceBase.this.internalRemoveByPSDEMSLogic(pSDELogic2);
                PSDEWizardServiceBase.this.onAfterRemoveByPSDEMSLogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSDEMSLogic(pSDELogic);
        this.onBeforeRemoveByPSDEMSLogic(pSDELogic, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByPSDEMSLogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDEMSLogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMSLogic(PSDELogic pSDELogic, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMSLogic(PSDELogic pSDELogic, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByFinishPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByFinishPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSLANGUAGERES_FINISHPSLANRESID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetFinishPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByFinishPSLanRes(pSLanguageRes);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setFinishPSLanResId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByFinishPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByFinishPSLanRes(pSLanguageRes2);
                PSDEWizardServiceBase.this.internalRemoveByFinishPSLanRes(pSLanguageRes2);
                PSDEWizardServiceBase.this.onAfterRemoveByFinishPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByFinishPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByFinishPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByFinishPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByFinishPSLanRes(pSLanguageRes, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByFinishPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByFinishPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByFinishPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFinishPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByNextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByNextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSLANGUAGERES_NEXTPSLANRESID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetNextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByNextPSLanRes(pSLanguageRes);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setNextPSLanResId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByNextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByNextPSLanRes(pSLanguageRes2);
                PSDEWizardServiceBase.this.internalRemoveByNextPSLanRes(pSLanguageRes2);
                PSDEWizardServiceBase.this.onAfterRemoveByNextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByNextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByNextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByNextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByNextPSLanRes(pSLanguageRes, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByNextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByNextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByNextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByPrevPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPrevPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSLANGUAGERES_PREVPSLANRESID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetPrevPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPrevPSLanRes(pSLanguageRes);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setPrevPSLanResId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByPrevPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByPrevPSLanRes(pSLanguageRes2);
                PSDEWizardServiceBase.this.internalRemoveByPrevPSLanRes(pSLanguageRes2);
                PSDEWizardServiceBase.this.onAfterRemoveByPrevPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByPrevPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByPrevPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPrevPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByPrevPSLanRes(pSLanguageRes, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByPrevPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByPrevPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByPrevPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPrevPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setPSSysCssId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEWizardServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEWizardServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setPSSysPFPluginId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEWizardServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEWizardServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setPSSysReqItemId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEWizardServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEWizardServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARD_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSDEWIZARD", iDataEntityModel.getDataInfo(pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSDEWizard pSDEWizard : arrayList) {
            PSDEWizard pSDEWizard2 = (PSDEWizard)this.getDEModel().createEntity();
            pSDEWizard2.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
            pSDEWizard2.setPSViewMsgGroupId(null);
            this.update(pSDEWizard2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEWizardServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEWizardServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEWizard> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSDEWizard pSDEWizard : arrayList) {
            this.remove(pSDEWizard);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEWizard> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEWizard pSDEWizard) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEWizard(pSDEWizard);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEWizard(pSDEWizard);
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).testRemoveByPSDEWizard(pSDEWizard);
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).removeByPSDEWizard(pSDEWizard);
        pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEWizard(pSDEWizard);
        ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).removeByPSDEWizard(pSDEWizard);
        pSCoreSysServiceBase = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDEWizard(pSDEWizard);
        ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).removeByPSDEWizard(pSDEWizard);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEWizard(pSDEWizard);
        super.onBeforeRemove(pSDEWizard);
    }

    protected void onBeforeRemoveTemp(PSDEWizard pSDEWizard) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDEWizard(pSDEWizard);
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).removeTempByPSDEWizard(pSDEWizard);
        pSCoreSysServiceBase = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).removeTempByPSDEWizard(pSDEWizard);
        super.onBeforeRemoveTemp(pSDEWizard);
    }

    protected void getRelatedDataTempMajor(PSDEWizard pSDEWizard) throws Exception {
        this.getRelatedDataTempMajor_PSDEWizardStep(pSDEWizard);
        this.getRelatedDataTempMajor_PSDEWizardForm(pSDEWizard);
        this.getRelatedDataTempMajor_PSDEWizardLogic(pSDEWizard);
        super.getRelatedDataTempMajor(pSDEWizard);
    }

    protected void getRelatedDataTempMajor_PSDEWizardStep(PSDEWizard pSDEWizard) throws Exception {
        PSDEWizardStepService pSDEWizardStepService = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardStep> arrayList = null;
        String string = pSDEWizard.getPSDEWizardId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEWizardStepService.selectByPSDEWizard(pSDEWizard) : pSDEWizardStepService.selectTempByPSDEWizard(pSDEWizard);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            pSDEWizardStepService.getTempMajor(pSDEWizardStep);
        }
    }

    protected void getRelatedDataTempMajor_PSDEWizardForm(PSDEWizard pSDEWizard) throws Exception {
        PSDEWizardFormService pSDEWizardFormService = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardForm> arrayList = null;
        String string = pSDEWizard.getPSDEWizardId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEWizardFormService.selectByPSDEWizard(pSDEWizard) : pSDEWizardFormService.selectTempByPSDEWizard(pSDEWizard);
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            pSDEWizardFormService.getTempMajor(pSDEWizardForm);
        }
    }

    protected void getRelatedDataTempMajor_PSDEWizardLogic(PSDEWizard pSDEWizard) throws Exception {
        PSDEWizardLogicService pSDEWizardLogicService = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardLogic> arrayList = null;
        String string = pSDEWizard.getPSDEWizardId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEWizardLogicService.selectByPSDEWizard(pSDEWizard) : pSDEWizardLogicService.selectTempByPSDEWizard(pSDEWizard);
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            pSDEWizardLogicService.getTempMajor(pSDEWizardLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEWizard pSDEWizard, PSDEWizard pSDEWizard2) throws Exception {
        ArrayList<PSDEWizardLogic> arrayList = this.updateRelatedDataTempMajor_removePSDEWizardLogic(pSDEWizard, pSDEWizard2);
        ArrayList<PSDEWizardForm> arrayList2 = this.updateRelatedDataTempMajor_removePSDEWizardForm(pSDEWizard, pSDEWizard2);
        ArrayList<PSDEWizardStep> arrayList3 = this.updateRelatedDataTempMajor_removePSDEWizardStep(pSDEWizard, pSDEWizard2);
        this.updateRelatedDataTempMajor_updatePSDEWizardStep(pSDEWizard, pSDEWizard2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSDEWizardForm(pSDEWizard, pSDEWizard2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEWizardLogic(pSDEWizard, pSDEWizard2, arrayList);
        super.updateRelatedDataTempMajor(pSDEWizard, pSDEWizard2);
    }

    protected ArrayList<PSDEWizardStep> updateRelatedDataTempMajor_removePSDEWizardStep(PSDEWizard pSDEWizard, PSDEWizard pSDEWizard2) throws Exception {
        PSDEWizardStepService pSDEWizardStepService = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardStep> arrayList = pSDEWizardStepService.selectTempByPSDEWizard(pSDEWizard);
        ArrayList<PSDEWizardStep> arrayList2 = pSDEWizardStepService.selectByPSDEWizard(pSDEWizard2);
        HashMap<String, PSDEWizardStep> hashMap = new HashMap<String, PSDEWizardStep>();
        for (PSDEWizardStep pSDEWizardStep : arrayList2) {
            hashMap.put(pSDEWizardStep.getPSDEWizardStepId(), pSDEWizardStep);
        }
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            Object object = pSDEWizardStep.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEWizardStep pSDEWizardStep : hashMap.values()) {
            pSDEWizardStepService.remove(pSDEWizardStep);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEWizardStep(PSDEWizard pSDEWizard, PSDEWizard pSDEWizard2, ArrayList<PSDEWizardStep> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEWizardStepService pSDEWizardStepService = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            pSDEWizardStepService.updateTempMajor(pSDEWizardStep);
        }
    }

    protected ArrayList<PSDEWizardForm> updateRelatedDataTempMajor_removePSDEWizardForm(PSDEWizard pSDEWizard, PSDEWizard pSDEWizard2) throws Exception {
        PSDEWizardFormService pSDEWizardFormService = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardForm> arrayList = pSDEWizardFormService.selectTempByPSDEWizard(pSDEWizard);
        ArrayList<PSDEWizardForm> arrayList2 = pSDEWizardFormService.selectByPSDEWizard(pSDEWizard2);
        HashMap<String, PSDEWizardForm> hashMap = new HashMap<String, PSDEWizardForm>();
        for (PSDEWizardForm pSDEWizardForm : arrayList2) {
            hashMap.put(pSDEWizardForm.getPSDEWizardFormId(), pSDEWizardForm);
        }
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            Object object = pSDEWizardForm.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEWizardForm pSDEWizardForm : hashMap.values()) {
            pSDEWizardFormService.remove(pSDEWizardForm);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEWizardForm(PSDEWizard pSDEWizard, PSDEWizard pSDEWizard2, ArrayList<PSDEWizardForm> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEWizardFormService pSDEWizardFormService = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEWizardForm pSDEWizardForm : arrayList) {
            pSDEWizardFormService.updateTempMajor(pSDEWizardForm);
        }
    }

    protected ArrayList<PSDEWizardLogic> updateRelatedDataTempMajor_removePSDEWizardLogic(PSDEWizard pSDEWizard, PSDEWizard pSDEWizard2) throws Exception {
        PSDEWizardLogicService pSDEWizardLogicService = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardLogic> arrayList = pSDEWizardLogicService.selectTempByPSDEWizard(pSDEWizard);
        ArrayList<PSDEWizardLogic> arrayList2 = pSDEWizardLogicService.selectByPSDEWizard(pSDEWizard2);
        HashMap<String, PSDEWizardLogic> hashMap = new HashMap<String, PSDEWizardLogic>();
        for (PSDEWizardLogic pSDEWizardLogic : arrayList2) {
            hashMap.put(pSDEWizardLogic.getPSDEWizardLogicId(), pSDEWizardLogic);
        }
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            Object object = pSDEWizardLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEWizardLogic pSDEWizardLogic : hashMap.values()) {
            pSDEWizardLogicService.remove(pSDEWizardLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEWizardLogic(PSDEWizard pSDEWizard, PSDEWizard pSDEWizard2, ArrayList<PSDEWizardLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEWizardLogicService pSDEWizardLogicService = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
            pSDEWizardLogicService.updateTempMajor(pSDEWizardLogic);
        }
    }

    protected void replaceParentInfo(PSDEWizard pSDEWizard, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEWizard, cloneSession);
        if (pSDEWizard.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSDEWizard.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEWizard, (PSCtrlLogicGroup)iEntity);
        }
        if (pSDEWizard.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSDEWizard.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSDEWizard, (PSCtrlMsg)iEntity);
        }
        if (pSDEWizard.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEWizard.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEWizard, (PSDataEntity)iEntity);
        }
        if (pSDEWizard.getFinishPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEWizard.getFinishPSDEActionId())) != null) {
            this.onFillParentInfo_FinishPSDEAction(pSDEWizard, (PSDEAction)iEntity);
        }
        if (pSDEWizard.getInitPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEWizard.getInitPSDEActionId())) != null) {
            this.onFillParentInfo_InitPSDEAction(pSDEWizard, (PSDEAction)iEntity);
        }
        if (pSDEWizard.getStatePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEWizard.getStatePSDEFId())) != null) {
            this.onFillParentInfo_StatePSDEF(pSDEWizard, (PSDEField)iEntity);
        }
        if (pSDEWizard.getPSDEMSLogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEWizard.getPSDEMSLogicId())) != null) {
            this.onFillParentInfo_PSDEMSLogic(pSDEWizard, (PSDELogic)iEntity);
        }
        if (pSDEWizard.getFinishPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEWizard.getFinishPSLanResId())) != null) {
            this.onFillParentInfo_FinishPSLanRes(pSDEWizard, (PSLanguageRes)iEntity);
        }
        if (pSDEWizard.getNextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEWizard.getNextPSLanResId())) != null) {
            this.onFillParentInfo_NextPSLanRes(pSDEWizard, (PSLanguageRes)iEntity);
        }
        if (pSDEWizard.getPrevPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEWizard.getPrevPSLanResId())) != null) {
            this.onFillParentInfo_PrevPSLanRes(pSDEWizard, (PSLanguageRes)iEntity);
        }
        if (pSDEWizard.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEWizard.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEWizard, (PSSysCss)iEntity);
        }
        if (pSDEWizard.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEWizard.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEWizard, (PSSysPFPlugin)iEntity);
        }
        if (pSDEWizard.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEWizard.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEWizard, (PSSysReqItem)iEntity);
        }
        if (pSDEWizard.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSDEWizard.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSDEWizard, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEWizard pSDEWizard, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEWizard, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BusyIndicator(bl, pSDEWizard, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableMSLogic(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FinishCaption(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FinishPSDEActionId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FinishPSLanResId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FinishPSLanResName(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InitPSDEActionId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NextCaption(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NextPSLanResId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NextPSLanResName(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrevCaption(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrevPSLanResId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrevPSLanResName(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMSLogicId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardName(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StatePSDEFId(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StatePSDEFName(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StateWizardFlag(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardStyle(bl, pSDEWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEWizard, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isBusyIndicatorDirty() : !pSDEWizard.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDEWizard.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BUSYINDICATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isCodeNameDirty() && !bl2 : !pSDEWizard.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEWizard.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEWizardDEModel(), "CODENAME", string3, pSDEWizard, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableMSLogic(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isEnableMSLogicDirty() : !pSDEWizard.isEnableMSLogicDirty()) {
            return null;
        }
        Integer n = pSDEWizard.getEnableMSLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableMSLogic_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEMSLOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FinishCaption(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isFinishCaptionDirty() : !pSDEWizard.isFinishCaptionDirty()) {
            return null;
        }
        String string = pSDEWizard.getFinishCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FinishCaption_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FinishPSDEActionId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isFinishPSDEActionIdDirty() : !pSDEWizard.isFinishPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getFinishPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FinishPSDEActionId_FinishPSDEAction(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_FinishPSDEActionId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FinishPSLanResId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isFinishPSLanResIdDirty() : !pSDEWizard.isFinishPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getFinishPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FinishPSLanResId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FinishPSLanResName(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isFinishPSLanResNameDirty() : !pSDEWizard.isFinishPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEWizard.getFinishPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FinishPSLanResName_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InitPSDEActionId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isInitPSDEActionIdDirty() : !pSDEWizard.isInitPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getInitPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InitPSDEActionId_InitPSDEAction(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INITPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_InitPSDEActionId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INITPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isLockFlagDirty() : !pSDEWizard.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEWizard.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isMemoDirty() : !pSDEWizard.isMemoDirty()) {
            return null;
        }
        String string = pSDEWizard.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_NextCaption(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isNextCaptionDirty() : !pSDEWizard.isNextCaptionDirty()) {
            return null;
        }
        String string = pSDEWizard.getNextCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NextCaption_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NextPSLanResId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isNextPSLanResIdDirty() : !pSDEWizard.isNextPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getNextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NextPSLanResId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NextPSLanResName(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isNextPSLanResNameDirty() : !pSDEWizard.isNextPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEWizard.getNextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NextPSLanResName_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrevCaption(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPrevCaptionDirty() : !pSDEWizard.isPrevCaptionDirty()) {
            return null;
        }
        String string = pSDEWizard.getPrevCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrevCaption_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrevPSLanResId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPrevPSLanResIdDirty() : !pSDEWizard.isPrevPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getPrevPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrevPSLanResId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrevPSLanResName(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPrevPSLanResNameDirty() : !pSDEWizard.isPrevPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEWizard.getPrevPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrevPSLanResName_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPSCtrlLogicGroupIdDirty() : !pSDEWizard.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLLOGICGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPSCtrlMsgIdDirty() : !pSDEWizard.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPSDEIdDirty() && !bl2 : !pSDEWizard.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEMSLogicId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPSDEMSLogicIdDirty() : !pSDEWizard.isPSDEMSLogicIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getPSDEMSLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMSLogicId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMSLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPSDENameDirty() && !bl2 : !pSDEWizard.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEWizard.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEWizardId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPSDEWizardIdDirty() && !bl2 : !pSDEWizard.isPSDEWizardIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getPSDEWizardId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardId_Default(pSDEWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEWizardName(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPSDEWizardNameDirty() && !bl2 : !pSDEWizard.isPSDEWizardNameDirty()) {
            return null;
        }
        String string = pSDEWizard.getPSDEWizardName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardName_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPSSysCssIdDirty() : !pSDEWizard.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPSSysPFPluginIdDirty() : !pSDEWizard.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPSSysReqItemIdDirty() : !pSDEWizard.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isPSViewMsgGroupIdDirty() : !pSDEWizard.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StatePSDEFId(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isStatePSDEFIdDirty() : !pSDEWizard.isStatePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEWizard.getStatePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StatePSDEFId_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StatePSDEFName(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isStatePSDEFNameDirty() : !pSDEWizard.isStatePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEWizard.getStatePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StatePSDEFName_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StateWizardFlag(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isStateWizardFlagDirty() : !pSDEWizard.isStateWizardFlagDirty()) {
            return null;
        }
        Integer n = pSDEWizard.getStateWizardFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StateWizardFlag_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEWIZARDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isToDoTaskDirty() : !pSDEWizard.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEWizard.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TODOTASK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isUserCatDirty() : !pSDEWizard.isUserCatDirty()) {
            return null;
        }
        String string = pSDEWizard.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isUserTagDirty() : !pSDEWizard.isUserTagDirty()) {
            return null;
        }
        String string = pSDEWizard.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isUserTag2Dirty() : !pSDEWizard.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEWizard.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isUserTag3Dirty() : !pSDEWizard.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEWizard.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isUserTag4Dirty() : !pSDEWizard.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEWizard.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_WizardStyle(boolean bl, PSDEWizard pSDEWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizard.isWizardStyleDirty() : !pSDEWizard.isWizardStyleDirty()) {
            return null;
        }
        String string = pSDEWizard.getWizardStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardStyle_Default(pSDEWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEWizard pSDEWizard, boolean bl) throws Exception {
        super.onSyncEntity(pSDEWizard, bl);
    }

    protected void onSyncIndexEntities(PSDEWizard pSDEWizard, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEWizard, bl);
    }

    public Object getDataContextValue(PSDEWizard pSDEWizard, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEWizard, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEWizard.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEWizard pSDEWizard, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEWizardStep_PSDEWizard(pSDEWizard, arrayList, n);
        this.onExportRelatedModel_PSDEWizardForm_PSDEWizard(pSDEWizard, arrayList, n);
        this.onExportRelatedModel_PSDEWizardLogic_PSDEWizard(pSDEWizard, arrayList, n);
        super.onExportRelatedModel(pSDEWizard, arrayList, n);
    }

    /*
     * WARNING - void declaration
     */
    protected void onExportRelatedModel_PSDEWizardStep_PSDEWizard(PSDEWizard pSDEWizard, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEWizardStepService pSDEWizardStepService = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardStep> arrayList2 = pSDEWizardStepService.selectByPSDEWizard(pSDEWizard);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"de36ab2e71244cdb3d616ab72b11f029");
            jSONObject.put("srfdename", (Object)"PSDEWIZARDSTEP");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEWIZARDSTEP_PSDEWIZARD_PSDEWIZARDID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEWizard, (String)"PSDEWIZARDID", (String)""));
            String object = "";
            for (PSDEWizardStep pSDEWizardStep : arrayList2) {
                if (!StringHelper.isNullOrEmpty((String)object)) {
                    object = object + ";";
                }
                object = object + DataObject.getStringValue((IDataObject)pSDEWizardStep, (String)"PSDEWIZARDSTEPID", (String)"");
            }
            jSONObject.put("srfarg2", (Object)object);
            arrayList.add(jSONObject);
        }
        for (PSDEWizardStep pSDEWizardStep : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEWizardStep, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEWizardStepService.exportModel(pSDEWizardStep, arrayList, n);
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void onExportRelatedModel_PSDEWizardForm_PSDEWizard(PSDEWizard pSDEWizard, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEWizardFormService pSDEWizardFormService = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardForm> arrayList2 = pSDEWizardFormService.selectByPSDEWizard(pSDEWizard);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"e70a1ccaa49d382ed6d7bfc0f66cfc7b");
            jSONObject.put("srfdename", (Object)"PSDEWIZARDFORM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEWIZARDFORM_PSDEWIZARD_PSDEWIZARDID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEWizard, (String)"PSDEWIZARDID", (String)""));
            String object = "";
            for (PSDEWizardForm pSDEWizardForm : arrayList2) {
                if (!StringHelper.isNullOrEmpty((String)object)) {
                    object = object + ";";
                }
                object = object + DataObject.getStringValue((IDataObject)pSDEWizardForm, (String)"PSDEWIZARDFORMID", (String)"");
            }
            jSONObject.put("srfarg2", (Object)object);
            arrayList.add(jSONObject);
        }
        for (PSDEWizardForm pSDEWizardForm : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEWizardForm, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEWizardFormService.exportModel(pSDEWizardForm, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEWizardLogic_PSDEWizard(PSDEWizard pSDEWizard, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEWizardLogicService pSDEWizardLogicService = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardLogic> arrayList2 = pSDEWizardLogicService.selectByPSDEWizard(pSDEWizard);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"99f2006ca4ef210a559503a282003751");
            jSONObject.put("srfdename", (Object)"PSDEWIZARDLOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEWIZARDLOGIC_PSDEWIZARD_PSDEWIZARDID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEWizard, (String)"PSDEWIZARDID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEWizardLogic pSDEWizardLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEWizardLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEWizardLogicService.exportModel(pSDEWizardLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEWizard pSDEWizard, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_FinishPSLanRes(pSDEWizard, arrayList, n);
        this.onExportMajorModel_NextPSLanRes(pSDEWizard, arrayList, n);
        this.onExportMajorModel_PrevPSLanRes(pSDEWizard, arrayList, n);
        super.onExportMajorModel(pSDEWizard, arrayList, n);
    }

    protected void onExportMajorModel_FinishPSLanRes(PSDEWizard pSDEWizard, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEWizard.getFinishPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEWizard.getFinishPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_NextPSLanRes(PSDEWizard pSDEWizard, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEWizard.getNextPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEWizard.getNextPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_PrevPSLanRes(PSDEWizard pSDEWizard, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEWizard.getPrevPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEWizard.getPrevPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BUSYINDICATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BusyIndicator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEMSLOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableMSLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"FINISHPSDEACTION", (boolean)true) == 0) {
            return this.onTestValueRule_FinishPSDEActionId_FinishPSDEAction(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"INITPSDEACTION", (boolean)true) == 0) {
            return this.onTestValueRule_InitPSDEActionId_InitPSDEAction(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NextCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NextPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NextPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrevCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrevPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrevPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMSLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMSLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMSLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMSLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StatePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StatePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEWIZARDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StateWizardFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WIZARDSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardStyle_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BusyIndicator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_EnableMSLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FinishCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHCAPTION", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishPSDEActionId_FinishPSDEAction(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("FINISHPSDEACTIONID", "PSDEACTION", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b8c\u6210\u64cd\u4f5c\u5b9e\u4f53\u884c\u4e3a\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitPSDEActionId_InitPSDEAction(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("INITPSDEACTIONID", "PSDEACTION", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u521d\u59cb\u5316\u5b9e\u4f53\u884c\u4e3a\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_NextCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTCAPTION", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NextPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NextPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrevCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVCAPTION", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrevPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrevPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlLogicGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlLogicGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEMSLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMSLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMSLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMSLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysReqItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StatePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StatePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StateWizardFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ToDoTask_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TODOTASK", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_WizardStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIZARDSTYLE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEWizard pSDEWizard) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEWizard)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEWizard pSDEWizard) throws Exception {
        Object object = pSDEWizard.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEWIZARD_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEWizard);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEWizard pSDEWizard, Object object) throws Exception {
        PSDEWizard pSDEWizard2 = new PSDEWizard();
        pSDEWizard2.set("PSDEWIZARDID", object);
        String string = DataObject.getStringValue((Object)pSDEWizard.get("PSDEWIZARDID"));
        super.onCopyDetails(pSDEWizard, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEWizard pSDEWizard, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEWIZARD");
        if (!bl) {
            pSDEWizard.setCreateDate(null);
            pSDEWizard.setCreateMan(null);
            pSDEWizard.setPSDEWizardId(null);
            pSDEWizard.setUpdateDate(null);
            pSDEWizard.setUpdateMan(null);
            super.exportCurXmlModel(pSDEWizard, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEWizard pSDEWizard, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEWizardStep(pSDEWizard, xmlNode);
        this.exportRelatedXmlModel_PSDEWizardLogic(pSDEWizard, xmlNode);
        super.onExportRelatedXmlModel(pSDEWizard, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEWizardStep(PSDEWizard pSDEWizard, XmlNode xmlNode) throws Exception {
        PSDEWizardStepService pSDEWizardStepService = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardStep> arrayList = null;
        String string = pSDEWizard.getPSDEWizardId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEWizardStepService.selectByPSDEWizard(pSDEWizard, "ORDER BY ORDERVALUE ASC") : pSDEWizardStepService.selectTempByPSDEWizard(pSDEWizard, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEWIZARDSTEPS");
            xmlNode.addNode(xmlNode2);
            for (PSDEWizardStep pSDEWizardStep : arrayList) {
                pSDEWizardStep.set("ORDERVALUE", null);
                pSDEWizardStepService.exportXmlModel(pSDEWizardStep, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEWizardLogic(PSDEWizard pSDEWizard, XmlNode xmlNode) throws Exception {
        PSDEWizardLogicService pSDEWizardLogicService = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardLogic> arrayList = null;
        String string = pSDEWizard.getPSDEWizardId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEWizardLogicService.selectByPSDEWizard(pSDEWizard, "ORDER BY ORDERVALUE ASC") : pSDEWizardLogicService.selectTempByPSDEWizard(pSDEWizard, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEWIZARDLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSDEWizardLogic pSDEWizardLogic : arrayList) {
                pSDEWizardLogic.set("ORDERVALUE", null);
                pSDEWizardLogicService.exportXmlModel(pSDEWizardLogic, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEWizard pSDEWizard, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEWIZARDSTEPS");
        this.importRelatedXmlModel_PSDEWizardStep(pSDEWizard, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDEWIZARDLOGICS");
        this.importRelatedXmlModel_PSDEWizardLogic(pSDEWizard, xmlNode3);
        super.onImportRelatedXmlModel(pSDEWizard, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEWizardStep(PSDEWizard pSDEWizard, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEWizardStepService pSDEWizardStepService = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEWizard.getPSDEWizardId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEWizardStepService.removeByPSDEWizard(pSDEWizard);
        } else {
            pSDEWizardStepService.removeTempByPSDEWizard(pSDEWizard);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEWizardStep pSDEWizardStep = new PSDEWizardStep();
                pSDEWizardStep.setOrderValue(n);
                n += 100;
                pSDEWizardStepService.fillParentInfo(pSDEWizardStep, "DER1N", "DER1N_PSDEWIZARDSTEP_PSDEWIZARD_PSDEWIZARDID", pSDEWizard.getPSDEWizardId());
                pSDEWizardStepService.importXmlModel(pSDEWizardStep, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEWizardLogic(PSDEWizard pSDEWizard, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEWizardLogicService pSDEWizardLogicService = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEWizard.getPSDEWizardId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEWizardLogicService.removeByPSDEWizard(pSDEWizard);
        } else {
            pSDEWizardLogicService.removeTempByPSDEWizard(pSDEWizard);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEWizardLogic pSDEWizardLogic = new PSDEWizardLogic();
                pSDEWizardLogic.setOrderValue(n);
                n += 100;
                pSDEWizardLogicService.fillParentInfo(pSDEWizardLogic, "DER1N", "DER1N_PSDEWIZARDLOGIC_PSDEWIZARD_PSDEWIZARDID", pSDEWizard.getPSDEWizardId());
                pSDEWizardLogicService.importXmlModel(pSDEWizardLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEWizard pSDEWizard, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEWizard, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEWIZARD_PSDATAENTITY_PSDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDEWizard pSDEWizard) {
        if (!StringHelper.isNullOrEmpty((String)pSDEWizard.getCodeName())) {
            return pSDEWizard.getCodeName();
        }
        return super.getModelV2Tag(pSDEWizard);
    }

    @Override
    public boolean setModelV2Tag(PSDEWizard pSDEWizard, String string) {
        pSDEWizard.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEWizard pSDEWizard, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEWizard.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEWizard, true);
        pSDEWizard.set("CODENAME", string);
        if (this.select(pSDEWizard, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEWizard, true);
        return super.getModelV2Entity(pSDEWizard, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEWizard pSDEWizard, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEWizard, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEWIZARDSTEP_PSDEWIZARD_PSDEWIZARDID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEWIZARDFORM_PSDEWIZARD_PSDEWIZARDID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEWIZARDLOGIC_PSDEWIZARD_PSDEWIZARDID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEWizard pSDEWizard, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEWizard, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEWizard pSDEWizard, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayNode arrayNode;
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEWIZARDSTEP_PSDEWIZARD_PSDEWIZARDID")) {
            pSCoreSysServiceBase = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEWIZARD#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEWIZARDSTEP", (Object)pSDEWizard.getPSDEWizardId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEWIZARD#%1$s", (Object)pSDEWizard.getPSDEWizardId());
                for (PSDEWizardStep model : ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).selectByPSDEWizard(pSDEWizard)) {
                    if (StringHelper.compare(scope, ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).getModelV2ResScope(model), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdewizardstepname")) {
                            string = objectNode.get("psdewizardstepname").asText();
                        }
                        if (objectNode2.has("psdewizardstepname")) {
                            string2 = objectNode2.get("psdewizardstepname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDEWizardStep model = new PSDEWizardStep();
                    PSModelV2Helper.fromJSONObject(model, node, false);
                    arrayNode.add(pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEWIZARDFORM_PSDEWIZARD_PSDEWIZARDID")) {
            pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEWIZARD#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEWIZARDFORM", (Object)pSDEWizard.getPSDEWizardId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEWIZARD#%1$s", (Object)pSDEWizard.getPSDEWizardId());
                for (PSDEWizardForm model : ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).selectByPSDEWizard(pSDEWizard)) {
                    if (StringHelper.compare(scope, ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).getModelV2ResScope(model), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdewizardformname")) {
                            string = objectNode.get("psdewizardformname").asText();
                        }
                        if (objectNode2.has("psdewizardformname")) {
                            string2 = objectNode2.get("psdewizardformname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDEWizardForm model = new PSDEWizardForm();
                    PSModelV2Helper.fromJSONObject(model, node, false);
                    arrayNode.add(pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEWIZARDLOGIC_PSDEWIZARD_PSDEWIZARDID")) {
            pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEWIZARD#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEWIZARDLOGIC", (Object)pSDEWizard.getPSDEWizardId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEWIZARD#%1$s", (Object)pSDEWizard.getPSDEWizardId());
                for (PSDEWizardLogic model : ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).selectByPSDEWizard(pSDEWizard)) {
                    if (StringHelper.compare(scope, ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(model), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdewizardlogicname")) {
                            string = objectNode.get("psdewizardlogicname").asText();
                        }
                        if (objectNode2.has("psdewizardlogicname")) {
                            string2 = objectNode2.get("psdewizardlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDEWizardLogic model = new PSDEWizardLogic();
                    PSModelV2Helper.fromJSONObject(model, node, false);
                    arrayNode.add(pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEWizard, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEWizard pSDEWizard) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardStep> steps = ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).selectByPSDEWizard(pSDEWizard);
        String string2 = StringHelper.format((String)"PSDEWIZARD#%1$s", (Object)pSDEWizard.getPSDEWizardId());
        for (PSDEWizardStep step : steps) {
            string = ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).getModelV2ResScope(step);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(step);
        }
        SqlParamList params = new SqlParamList();
        params.addString(pSDEWizard.getPSDEWizardId());
        ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEWIZARDSTEP WHERE PSDEWIZARDID = ?", params);
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardForm> forms = ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).selectByPSDEWizard(pSDEWizard);
        string2 = StringHelper.format((String)"PSDEWIZARD#%1$s", (Object)pSDEWizard.getPSDEWizardId());
        for (PSDEWizardForm pSDEWizardForm : forms) {
            string = ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEWizardForm);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEWizardForm);
        }
        params = new SqlParamList();
        params.addString(pSDEWizard.getPSDEWizardId());
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEWIZARDFORM WHERE PSDEWIZARDID = ?", params);
        pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEWizardLogic> logics = ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).selectByPSDEWizard(pSDEWizard);
        string2 = StringHelper.format((String)"PSDEWIZARD#%1$s", (Object)pSDEWizard.getPSDEWizardId());
        for (PSDEWizardLogic pSDEWizardLogic : logics) {
            string = ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEWizardLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEWizardLogic);
        }
        params = new SqlParamList();
        params.addString(pSDEWizard.getPSDEWizardId());
        ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEWIZARDLOGIC WHERE PSDEWIZARDID = ?", params);
        super.onEmptyModelV2(pSDEWizard);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEWizard pSDEWizard, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEWizardStep();
        entityBase.set("PSDEWIZARDID", pSDEWizard.getPSDEWizardId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEWizardForm();
        entityBase.set("PSDEWIZARDID", pSDEWizard.getPSDEWizardId());
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEWizardLogic();
        entityBase.set("PSDEWIZARDID", pSDEWizard.getPSDEWizardId());
        pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEWizard, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEWizard pSDEWizard, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                ObjectNode node = (ObjectNode)arrayNode.get(n2);
                PSDEWizardStep model = new PSDEWizardStep();
                model.setPSDEId(pSDEWizard.getPSDEId());
                model.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
                model.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
                pSCoreSysServiceBase.compileModelV2(model, node, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string4);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDEWizardStep model = new PSDEWizardStep();
                    model.setPSDEId(pSDEWizard.getPSDEId());
                    model.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
                    model.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
                    pSCoreSysServiceBase.compileModelV2(model, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                ObjectNode node = (ObjectNode)arrayNode.get(n2);
                PSDEWizardForm model = new PSDEWizardForm();
                model.setPSDEId(pSDEWizard.getPSDEId());
                model.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
                model.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
                pSCoreSysServiceBase.compileModelV2(model, node, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string5);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDEWizardForm model = new PSDEWizardForm();
                    model.setPSDEId(pSDEWizard.getPSDEId());
                    model.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
                    model.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
                    pSCoreSysServiceBase.compileModelV2(model, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode node = (ObjectNode)arrayNode.get(i);
                PSDEWizardLogic model = new PSDEWizardLogic();
                model.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
                model.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
                pSCoreSysServiceBase.compileModelV2(model, node, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string6);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDEWizardLogic model = new PSDEWizardLogic();
                    model.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
                    model.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
                    pSCoreSysServiceBase.compileModelV2(model, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEWizard, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEWizard pSDEWizard, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEWIZARDSTEP_PSDEWIZARD_PSDEWIZARDID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEWizardSteps(pSDEWizard, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEWIZARDLOGIC_PSDEWIZARD_PSDEWIZARDID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEWizardLogics(pSDEWizard, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEWizard, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEWizardSteps(PSDEWizard pSDEWizard, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEWIZARDSTEP", true), (boolean)false) == 0) {
            PSDEWizardStepService pSDEWizardStepService = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
            PSDEWizardStep pSDEWizardStep = new PSDEWizardStep();
            pSDEWizardStep.setPSDEWizardStepId(pSMOSFile.getPSModelId());
            if (!pSDEWizardStepService.get(pSDEWizardStep, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEWizardStep.getPSDEWizardId(), (String)pSDEWizard.getPSDEWizardId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEWizardStepService.exportModelV2(pSDEWizardStep);
            pSDEWizardStep.reset();
            if (!pSDEWizardStepService.setModelV2ResScope(pSDEWizardStep, "PSDEWIZARD", pSDEWizard.getPSDEWizardId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEWizardStepService.importModelV2(pSDEWizardStep, objectNode);
            SessionFactoryManager.commit();
            return pSDEWizardStepService.getFile(pSDEWizardStep);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEWizardLogics(PSDEWizard pSDEWizard, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEWIZARDLOGIC", true), (boolean)false) == 0) {
            PSDEWizardLogicService pSDEWizardLogicService = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDEWizardLogic pSDEWizardLogic = new PSDEWizardLogic();
            pSDEWizardLogic.setPSDEWizardLogicId(pSMOSFile.getPSModelId());
            if (!pSDEWizardLogicService.get(pSDEWizardLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEWizardLogic.getPSDEWizardId(), (String)pSDEWizard.getPSDEWizardId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEWizardLogicService.exportModelV2(pSDEWizardLogic);
            pSDEWizardLogic.reset();
            if (!pSDEWizardLogicService.setModelV2ResScope(pSDEWizardLogic, "PSDEWIZARD", pSDEWizard.getPSDEWizardId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEWizardLogicService.importModelV2(pSDEWizardLogic, objectNode);
            SessionFactoryManager.commit();
            return pSDEWizardLogicService.getFile(pSDEWizardLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEWizard pSDEWizard, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEWizardSteps(pSDEWizard, list);
        this.onFillPasteHelps_PSDEWizardLogics(pSDEWizard, list);
        super.onFillPasteHelps(pSDEWizard, list);
    }

    protected void onFillPasteHelps_PSDEWizardSteps(PSDEWizard pSDEWizard, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEWIZARDSTEP");
        pSHelpSection.setSectionParam2("DER1N_PSDEWIZARDSTEP_PSDEWIZARD_PSDEWIZARDID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5411\u5bfc]\u7684[\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEWizardLogics(PSDEWizard pSDEWizard, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEWIZARDLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDEWIZARDLOGIC_PSDEWIZARD_PSDEWIZARDID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5411\u5bfc]\u7684[\u5b9e\u4f53\u5411\u5bfc\u903b\u8f91]");
        list.add(pSHelpSection);
    }
}
