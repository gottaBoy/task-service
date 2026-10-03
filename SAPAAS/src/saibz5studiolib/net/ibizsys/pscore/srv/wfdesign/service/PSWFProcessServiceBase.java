/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.ActionContext
 *  net.ibizsys.paas.core.IActionContext
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
 *  net.ibizsys.paas.demodel.IDELogicModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
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
package net.ibizsys.pscore.srv.wfdesign.service;

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
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.core.IActionContext;
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
import net.ibizsys.paas.demodel.IDELogicModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTemplBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFProcessDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFProcessDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDEBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcParam;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcParamBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRoleBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcSubWF;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcSubWFBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFWorkTime;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFWorkTimeBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcParamService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcParamServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFProcessServiceBase
extends PSCoreSysServiceBase<PSWFProcess> {
    private static final Log log = LogFactory.getLog(PSWFProcessServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    public static final String DATASET_IA = "IA";
    public static final String ACTION_CALCEMBEDPSDEID = "CalcEmbedPSDEId";
    public static final String ACTION_CALCPSDEID = "CalcPSDEId";
    private PSWFProcessDEModel pSWFProcessDEModel;
    private PSWFProcessDAO pSWFProcessDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService";
    }

    public PSWFProcessDEModel getPSWFProcessDEModel() {
        if (this.pSWFProcessDEModel == null) {
            try {
                this.pSWFProcessDEModel = (PSWFProcessDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFProcessDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFProcessDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFProcessDEModel();
    }

    public PSWFProcessDAO getPSWFProcessDAO() {
        if (this.pSWFProcessDAO == null) {
            try {
                this.pSWFProcessDAO = (PSWFProcessDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFProcessDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFProcessDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFProcessDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_IA, (boolean)true) == 0) {
            return this.fetchIA(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchTempFormType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_IA, (boolean)true) == 0) {
            return this.fetchTempIA(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCEMBEDPSDEID, (boolean)true) == 0) {
            this.calcEmbedPSDEId((PSWFProcess)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CALCPSDEID, (boolean)true) == 0) {
            this.calcPSDEId((PSWFProcess)iEntity);
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

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchIA(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_IA, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempIA(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_IA, true);
        return dBFetchResult;
    }

    public void calcEmbedPSDEId(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        pSWFProcess2.setSessionFactory(this.getSessionFactory());
        this.testDEMainStateAction(pSWFProcess, ACTION_CALCEMBEDPSDEID);
        final IDELogicModel iDELogicModel = (IDELogicModel)this.getPSWFProcessDEModel().getDELogic("CalcEmbedDEIdByEmbedWFDE");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                ActionContext actionContext = new ActionContext(null);
                actionContext.setParam(iDELogicModel.getDefaultParamName(), (Object)pSWFProcess2);
                actionContext.setSessionFactory(PSWFProcessServiceBase.this.getSessionFactory());
                iDELogicModel.execute((IActionContext)actionContext);
            }
        });
    }

    public void calcPSDEId(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        pSWFProcess2.setSessionFactory(this.getSessionFactory());
        this.testDEMainStateAction(pSWFProcess, ACTION_CALCPSDEID);
        final IDELogicModel iDELogicModel = (IDELogicModel)this.getPSWFProcessDEModel().getDELogic("CalcDEIdByWFDE");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                ActionContext actionContext = new ActionContext(null);
                actionContext.setParam(iDELogicModel.getDefaultParamName(), (Object)pSWFProcess2);
                actionContext.setSessionFactory(PSWFProcessServiceBase.this.getSessionFactory());
                iDELogicModel.execute((IActionContext)actionContext);
            }
        });
    }

    protected void onFillParentInfo(PSWFProcess pSWFProcess, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSWFProcess, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEDATASET_EMBEDPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_EmbedPSDEDS(pSWFProcess, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFGROUP_EDITPSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFGroup);
            } else {
                iService.get(pSDEFGroup);
            }
            this.onFillParentInfo_EditPSDEFGroup(pSWFProcess, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFIELD_TIMEOUTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TimeoutPSDEF(pSWFProcess, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_MOBPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_MobPSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_MOBUTIL2PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_MobUtil2PSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_MOBUTIL3PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_MobUtil3PSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_MOBUTIL4PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_MobUtil4PSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_MOBUTIL5PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_MobUtil5PSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_MOBUTILPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_MobUtilPSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_UTIL2PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_Util2PSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_UTIL3PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_Util3PSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_UTIL4PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_Util4PSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_UTIL5PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_Util5PSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEFORM_UTILPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_UtilPSDEForm(pSWFProcess, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEUAGROUP_MOBPSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_MobPSDEUAGroup(pSWFProcess, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSWFProcess, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEVIEWBASE_MOBPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_MobPSDEView(pSWFProcess, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSWFProcess, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSLANGUAGERES_NAMEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_NamePSLanRes(pSWFProcess, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTempl pSSysMsgTempl = (PSSysMsgTempl)iService.getDEModel().createEntity();
            pSSysMsgTempl.set("PSSYSMSGTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysMsgTempl);
            } else {
                iService.get(pSSysMsgTempl);
            }
            this.onFillParentInfo_PSSysMsgTempl(pSWFProcess, pSSysMsgTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSWFDE_EMBEDPSWFDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService", (SessionFactory)this.getSessionFactory());
            PSWFDE pSWFDE = (PSWFDE)iService.getDEModel().createEntity();
            pSWFDE.set("PSWFDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFDE);
            } else {
                iService.get(pSWFDE);
            }
            this.onFillParentInfo_EmbedPSWFDE(pSWFProcess, pSWFDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSWFDE_PSWFDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService", (SessionFactory)this.getSessionFactory());
            PSWFDE pSWFDE = (PSWFDE)iService.getDEModel().createEntity();
            pSWFDE.set("PSWFDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFDE);
            } else {
                iService.get(pSWFDE);
            }
            this.onFillParentInfo_PSWFDE(pSWFProcess, pSWFDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFVersion);
            } else {
                iService.get(pSWFVersion);
            }
            this.onFillParentInfo_PSWFVersion(pSWFProcess, pSWFVersion);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSWFVERSION_REFPSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFVersion);
            } else {
                iService.get(pSWFVersion);
            }
            this.onFillParentInfo_RefPSWFVersion(pSWFProcess, pSWFVersion);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSWFWORKTIME_PSWFWORKTIMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFWorkTimeService", (SessionFactory)this.getSessionFactory());
            PSWFWorkTime pSWFWorkTime = (PSWFWorkTime)iService.getDEModel().createEntity();
            pSWFWorkTime.set("PSWFWORKTIMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFWorkTime);
            } else {
                iService.get(pSWFWorkTime);
            }
            this.onFillParentInfo_PSWFWorktime(pSWFProcess, pSWFWorkTime);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSWORKFLOW_EMBEDPSWFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkflow);
            } else {
                iService.get(pSWorkflow);
            }
            this.onFillParentInfo_EmbedPSWF(pSWFProcess, pSWorkflow);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCESS_PSWORKFLOW_PSWFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkflow);
            } else {
                iService.get(pSWorkflow);
            }
            this.onFillParentInfo_PSWF(pSWFProcess, pSWorkflow);
            return;
        }
        super.onFillParentInfo(pSWFProcess, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSWFPROCESS_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", string2);
            return this.onSyncDER1NData_PSWFVersion(pSWFVersion, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEAction(PSWFProcess pSWFProcess, PSDEAction pSDEAction) throws Exception {
        pSWFProcess.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSWFProcess.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_EmbedPSDEDS(PSWFProcess pSWFProcess, PSDEDataSet pSDEDataSet) throws Exception {
        pSWFProcess.setEmbedPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSWFProcess.setEmbedPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_EditPSDEFGroup(PSWFProcess pSWFProcess, PSDEFGroup pSDEFGroup) throws Exception {
        pSWFProcess.setEditPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSWFProcess.setEditPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_TimeoutPSDEF(PSWFProcess pSWFProcess, PSDEField pSDEField) throws Exception {
        pSWFProcess.setTimeoutPSDEFId(pSDEField.getPSDEFieldId());
        pSWFProcess.setTimeoutPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MobPSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setMobFormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setMobPSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setMobPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_MobUtil2PSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setMobUtil2FormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setMobUtil2PSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setMobUtil2PSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_MobUtil3PSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setMobUtil3FormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setMobUtil3PSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setMobUtil3PSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_MobUtil4PSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setMobUtil4FormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setMobUtil4PSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setMobUtil4PSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_MobUtil5PSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setMobUtil5FormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setMobUtil5PSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setMobUtil5PSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_MobUtilPSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setMobUtilFormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setMobUtilPSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setMobUtilPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setFormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_Util2PSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setUtil2FormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setUtil2PSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setUtil2PSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_Util3PSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setUtil3FormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setUtil3PSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setUtil3PSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_Util4PSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setUtil4FormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setUtil4PSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setUtil4PSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_Util5PSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setUtil5FormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setUtil5PSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setUtil5PSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_UtilPSDEForm(PSWFProcess pSWFProcess, PSDEForm pSDEForm) throws Exception {
        pSWFProcess.setUtilFormCodeName(pSDEForm.getCodeName());
        pSWFProcess.setUtilPSDEFormId(pSDEForm.getPSDEFormId());
        pSWFProcess.setUtilPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_MobPSDEUAGroup(PSWFProcess pSWFProcess, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSWFProcess.setMobPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSWFProcess.setMobPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
        pSWFProcess.setMobUAGroupCodeName(pSDEUAGroup.getCodeName());
    }

    protected void onFillParentInfo_PSDEUAGroup(PSWFProcess pSWFProcess, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSWFProcess.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSWFProcess.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
        pSWFProcess.setUAGroupCodeName(pSDEUAGroup.getCodeName());
    }

    protected void onFillParentInfo_MobPSDEView(PSWFProcess pSWFProcess, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFProcess.setMobPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWFProcess.setMobPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
        pSWFProcess.setMobPSDynaDEViewTemplId(pSDEViewBase.getPSDynaDEViewTemplId());
    }

    protected void onFillParentInfo_PSDEViewBase(PSWFProcess pSWFProcess, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFProcess.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSWFProcess.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
        pSWFProcess.setPSDynaDEViewTemplId(pSDEViewBase.getPSDynaDEViewTemplId());
    }

    protected void onFillParentInfo_NamePSLanRes(PSWFProcess pSWFProcess, PSLanguageRes pSLanguageRes) throws Exception {
        pSWFProcess.setNamePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSWFProcess.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysMsgTempl(PSWFProcess pSWFProcess, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        pSWFProcess.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
        pSWFProcess.setPSSysMsgTemplName(pSSysMsgTempl.getPSSysMsgTemplName());
    }

    protected void onFillParentInfo_EmbedPSWFDE(PSWFProcess pSWFProcess, PSWFDE pSWFDE) throws Exception {
        pSWFProcess.setEmbedPSDEId(pSWFDE.getPSDEId());
        pSWFProcess.setEmbedPSWFDEId(pSWFDE.getPSWFDEId());
        pSWFProcess.setEmbedPSWFDEName(pSWFDE.getPSWFDEName());
    }

    protected void onFillParentInfo_PSWFDE(PSWFProcess pSWFProcess, PSWFDE pSWFDE) throws Exception {
        pSWFProcess.setPSDEId(pSWFDE.getPSDEId());
        pSWFProcess.setPSWFDEId(pSWFDE.getPSWFDEId());
        pSWFProcess.setPSWFDEName(pSWFDE.getPSWFDEName());
    }

    protected void onFillParentInfo_PSWFVersion(PSWFProcess pSWFProcess, PSWFVersion pSWFVersion) throws Exception {
        pSWFProcess.setPSSystemId(pSWFVersion.getPSSystemId());
        pSWFProcess.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
        pSWFProcess.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
        pSWFProcess.setWFEngineType(pSWFVersion.getWFEngineType());
        if (pSWFVersion.getPSWF() != null) {
            this.onFillParentInfo_PSWF(pSWFProcess, pSWFVersion.getPSWF());
        }
    }

    protected String onSyncDER1NData_PSWFVersion(PSWFVersion pSWFVersion, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSWFVersion(pSWFVersion);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSWFProcess> arrayList = this.selectByPSWFVersion(pSWFVersion);
            for (PSWFProcess pSWFProcess : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSWFProcess, (String)"PSWFPROCESSID", (String)""))) continue;
                this.remove(pSWFProcess);
            }
        }
        return null;
    }

    protected void onFillParentInfo_RefPSWFVersion(PSWFProcess pSWFProcess, PSWFVersion pSWFVersion) throws Exception {
        pSWFProcess.setRefPSWFVersionId(pSWFVersion.getPSWFVersionId());
        pSWFProcess.setRefPSWFVersionName(pSWFVersion.getPSWFVersionName());
    }

    protected void onFillParentInfo_PSWFWorktime(PSWFProcess pSWFProcess, PSWFWorkTime pSWFWorkTime) throws Exception {
        pSWFProcess.setPSWFWorkTimeId(pSWFWorkTime.getPSWFWorkTimeId());
        pSWFProcess.setPSWFWorkTimeName(pSWFWorkTime.getPSWFWorkTimeName());
    }

    protected void onFillParentInfo_EmbedPSWF(PSWFProcess pSWFProcess, PSWorkflow pSWorkflow) throws Exception {
        pSWFProcess.setEmbedPSWFId(pSWorkflow.getPSWorkflowId());
        pSWFProcess.setEmbedPSWFName(pSWorkflow.getPSWorkflowName());
    }

    protected void onFillParentInfo_PSWF(PSWFProcess pSWFProcess, PSWorkflow pSWorkflow) throws Exception {
        pSWFProcess.setPSWFId(pSWorkflow.getPSWorkflowId());
        pSWFProcess.setPSWFName(pSWorkflow.getPSWorkflowName());
    }

    protected void onFillEntityFullInfo(PSWFProcess pSWFProcess, boolean bl) throws Exception {
        if (bl) {
            if (pSWFProcess.getAsyncMode() == null) {
                pSWFProcess.setAsyncMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWFProcess.getEnable() == null) {
                pSWFProcess.setEnable((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSWFProcess, bl);
        this.onFillEntityFullInfo_PSDEAction(pSWFProcess, bl);
        this.onFillEntityFullInfo_EmbedPSDEDS(pSWFProcess, bl);
        this.onFillEntityFullInfo_EditPSDEFGroup(pSWFProcess, bl);
        this.onFillEntityFullInfo_TimeoutPSDEF(pSWFProcess, bl);
        this.onFillEntityFullInfo_MobPSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_MobUtil2PSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_MobUtil3PSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_MobUtil4PSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_MobUtil5PSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_MobUtilPSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_PSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_Util2PSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_Util3PSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_Util4PSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_Util5PSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_UtilPSDEForm(pSWFProcess, bl);
        this.onFillEntityFullInfo_MobPSDEUAGroup(pSWFProcess, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSWFProcess, bl);
        this.onFillEntityFullInfo_MobPSDEView(pSWFProcess, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSWFProcess, bl);
        this.onFillEntityFullInfo_NamePSLanRes(pSWFProcess, bl);
        this.onFillEntityFullInfo_PSSysMsgTempl(pSWFProcess, bl);
        this.onFillEntityFullInfo_EmbedPSWFDE(pSWFProcess, bl);
        this.onFillEntityFullInfo_PSWFDE(pSWFProcess, bl);
        this.onFillEntityFullInfo_PSWFVersion(pSWFProcess, bl);
        this.onFillEntityFullInfo_RefPSWFVersion(pSWFProcess, bl);
        this.onFillEntityFullInfo_PSWFWorktime(pSWFProcess, bl);
        this.onFillEntityFullInfo_EmbedPSWF(pSWFProcess, bl);
        this.onFillEntityFullInfo_PSWF(pSWFProcess, bl);
    }

    protected void onFillEntityFullInfo_PSDEAction(PSWFProcess pSWFProcess, boolean bl) throws Exception {
        if (pSWFProcess.isPSDEActionIdDirty()) {
            if (pSWFProcess.getPSDEActionId() != null) {
                if (pSWFProcess.getPSDEActionId() == null || pSWFProcess.getPSDEActionName() == null) {
                    PSDEAction pSDEAction = pSWFProcess.getPSDEAction();
                    pSWFProcess.setPSDEActionName(pSDEAction.getPSDEActionName());
                }
            } else {
                pSWFProcess.setPSDEActionName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_EmbedPSDEDS(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EditPSDEFGroup(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TimeoutPSDEF(PSWFProcess pSWFProcess, boolean bl) throws Exception {
        if (pSWFProcess.isTimeoutPSDEFIdDirty()) {
            if (pSWFProcess.getTimeoutPSDEFId() != null) {
                if (pSWFProcess.getTimeoutPSDEFId() == null || pSWFProcess.getTimeoutPSDEFName() == null) {
                    PSDEField pSDEField = pSWFProcess.getTimeoutPSDEF();
                    pSWFProcess.setTimeoutPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFProcess.setTimeoutPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MobPSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobUtil2PSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobUtil3PSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobUtil4PSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobUtil5PSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobUtilPSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Util2PSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Util3PSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Util4PSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Util5PSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UtilPSDEForm(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobPSDEUAGroup(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobPSDEView(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NamePSLanRes(PSWFProcess pSWFProcess, boolean bl) throws Exception {
        if (pSWFProcess.isNamePSLanResIdDirty()) {
            if (pSWFProcess.getNamePSLanResId() != null) {
                if (pSWFProcess.getNamePSLanResId() == null || pSWFProcess.getNamePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSWFProcess.getNamePSLanRes();
                    pSWFProcess.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSWFProcess.setNamePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysMsgTempl(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmbedPSWFDE(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFDE(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFVersion(PSWFProcess pSWFProcess, boolean bl) throws Exception {
        if (pSWFProcess.isPSWFVersionIdDirty()) {
            if (pSWFProcess.getPSWFVersionId() != null) {
                PSWFVersion pSWFVersion;
                if (pSWFProcess.getPSWFVersionId() == null || pSWFProcess.getPSWFVersionName() == null) {
                    pSWFVersion = pSWFProcess.getPSWFVersion();
                    pSWFProcess.setPSSystemId(pSWFVersion.getPSSystemId());
                    pSWFProcess.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    pSWFProcess.setWFEngineType(pSWFVersion.getWFEngineType());
                }
                pSWFVersion = pSWFProcess.getPSWFVersion();
                if (DataTypeHelper.compare((int)25, (Object)pSWFVersion.getPSWFId(), (Object)pSWFProcess.getPSWFId()) != 0L) {
                    pSWFProcess.setPSWFId(pSWFVersion.getPSWFId());
                    this.onFillEntityFullInfo_PSWF(pSWFProcess, bl);
                }
            } else {
                pSWFProcess.setPSSystemId(null);
                pSWFProcess.setPSWFVersionName(null);
                pSWFProcess.setWFEngineType(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSWFVersion(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFWorktime(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmbedPSWF(PSWFProcess pSWFProcess, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWF(PSWFProcess pSWFProcess, boolean bl) throws Exception {
        if (pSWFProcess.isPSWFIdDirty()) {
            if (pSWFProcess.getPSWFId() != null) {
                if (pSWFProcess.getPSWFId() == null || pSWFProcess.getPSWFName() == null) {
                    PSWorkflow pSWorkflow = pSWFProcess.getPSWF();
                    pSWFProcess.setPSWFName(pSWorkflow.getPSWorkflowName());
                }
            } else {
                pSWFProcess.setPSWFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSWFProcess pSWFProcess, boolean bl) throws Exception {
        super.onWriteBackParent(pSWFProcess, bl);
    }

    public ArrayList<PSWFProcess> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByEmbedPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByEmbedPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByEmbedPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByEmbedPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByEmbedPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMBEDPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmbedPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmbedPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByEditPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByEditPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByEditPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByEditPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByEditPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EDITPSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEditPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEditPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByTimeoutPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTimeoutPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByTimeoutPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTimeoutPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByTimeoutPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIMEOUTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTimeoutPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTimeoutPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByMobPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMobPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByMobPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMobPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByMobPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFProcess> selectByMobUtil2PSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMobUtil2PSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByMobUtil2PSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMobUtil2PSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByMobUtil2PSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBUTIL2PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobUtil2PSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobUtil2PSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByMobUtil3PSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMobUtil3PSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByMobUtil3PSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMobUtil3PSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByMobUtil3PSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBUTIL3PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobUtil3PSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobUtil3PSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByMobUtil4PSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMobUtil4PSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByMobUtil4PSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMobUtil4PSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByMobUtil4PSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBUTIL4PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobUtil4PSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobUtil4PSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByMobUtil5PSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMobUtil5PSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByMobUtil5PSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMobUtil5PSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByMobUtil5PSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBUTIL5PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobUtil5PSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobUtil5PSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByMobUtilPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMobUtilPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByMobUtilPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMobUtilPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByMobUtilPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBUTILPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobUtilPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobUtilPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFProcess> selectByUtil2PSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByUtil2PSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByUtil2PSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByUtil2PSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByUtil2PSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTIL2PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtil2PSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtil2PSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByUtil3PSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByUtil3PSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByUtil3PSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByUtil3PSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByUtil3PSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTIL3PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtil3PSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtil3PSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByUtil4PSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByUtil4PSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByUtil4PSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByUtil4PSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByUtil4PSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTIL4PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtil4PSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtil4PSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByUtil5PSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByUtil5PSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByUtil5PSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByUtil5PSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByUtil5PSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTIL5PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtil5PSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtil5PSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByUtilPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByUtilPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByUtilPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByUtilPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByUtilPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByMobPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByMobPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByMobPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByMobPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByMobPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBPSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMobPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMobPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NAMEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNamePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNamePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMSGTEMPLID", (Object)pSSysMsgTemplBase.getPSSysMsgTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMsgTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMsgTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByEmbedPSWFDE(PSWFDEBase pSWFDEBase) throws Exception {
        return this.selectByEmbedPSWFDE(pSWFDEBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByEmbedPSWFDE(PSWFDEBase pSWFDEBase, String string) throws Exception {
        return this.selectByEmbedPSWFDE(pSWFDEBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByEmbedPSWFDE(PSWFDEBase pSWFDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMBEDPSWFDEID", (Object)pSWFDEBase.getPSWFDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmbedPSWFDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmbedPSWFDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByPSWFDE(PSWFDEBase pSWFDEBase) throws Exception {
        return this.selectByPSWFDE(pSWFDEBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByPSWFDE(PSWFDEBase pSWFDEBase, String string) throws Exception {
        return this.selectByPSWFDE(pSWFDEBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByPSWFDE(PSWFDEBase pSWFDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFDEID", (Object)pSWFDEBase.getPSWFDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFVersionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectTempByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectTempByPSWFVersion(pSWFVersionBase, "");
    }

    public ArrayList<PSWFProcess> selectTempByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSWFVersionCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByRefPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectByRefPSWFVersion(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByRefPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectByRefPSWFVersion(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByRefPSWFVersion(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSWFVersionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByPSWFWorktime(PSWFWorkTimeBase pSWFWorkTimeBase) throws Exception {
        return this.selectByPSWFWorktime(pSWFWorkTimeBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByPSWFWorktime(PSWFWorkTimeBase pSWFWorkTimeBase, String string) throws Exception {
        return this.selectByPSWFWorktime(pSWFWorkTimeBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByPSWFWorktime(PSWFWorkTimeBase pSWFWorkTimeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFWORKTIMEID", (Object)pSWFWorkTimeBase.getPSWFWorkTimeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFWorktimeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFWorktimeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByEmbedPSWF(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByEmbedPSWF(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByEmbedPSWF(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByEmbedPSWF(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByEmbedPSWF(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMBEDPSWFID", (Object)pSWorkflowBase.getPSWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmbedPSWFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmbedPSWFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcess> selectByPSWF(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSWFProcess> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSWFProcess> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFID", (Object)pSWorkflowBase.getPSWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setPSDEActionId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSWFProcessServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSWFProcessServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEmbedPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEDATASET_EMBEDPSDEDSID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEmbedPSDEDS(pSDEDataSet);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setEmbedPSDEDSId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByEmbedPSDEDS(pSDEDataSet2);
                PSWFProcessServiceBase.this.internalRemoveByEmbedPSDEDS(pSDEDataSet2);
                PSWFProcessServiceBase.this.onAfterRemoveByEmbedPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEmbedPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByEmbedPSDEDS(pSDEDataSet, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByEmbedPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByEditPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEditPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFGROUP_EDITPSDEFGROUPID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetEditPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEditPSDEFGroup(pSDEFGroup);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setEditPSDEFGroupId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByEditPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByEditPSDEFGroup(pSDEFGroup2);
                PSWFProcessServiceBase.this.internalRemoveByEditPSDEFGroup(pSDEFGroup2);
                PSWFProcessServiceBase.this.onAfterRemoveByEditPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByEditPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByEditPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEditPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByEditPSDEFGroup(pSDEFGroup, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByEditPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByEditPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByEditPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEditPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByTimeoutPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByTimeoutPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFIELD_TIMEOUTPSDEFID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTimeoutPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByTimeoutPSDEF(pSDEField);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setTimeoutPSDEFId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByTimeoutPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByTimeoutPSDEF(pSDEField2);
                PSWFProcessServiceBase.this.internalRemoveByTimeoutPSDEF(pSDEField2);
                PSWFProcessServiceBase.this.onAfterRemoveByTimeoutPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTimeoutPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTimeoutPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByTimeoutPSDEF(pSDEField);
        this.onBeforeRemoveByTimeoutPSDEF(pSDEField, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByTimeoutPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTimeoutPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTimeoutPSDEF(PSDEField pSDEField, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTimeoutPSDEF(PSDEField pSDEField, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_MOBPSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobPSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setMobPSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByMobPSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByMobPSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByMobPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobPSDEForm(pSDEForm);
        this.onBeforeRemoveByMobPSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByMobPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMobPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByMobUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil2PSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_MOBUTIL2PSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMobUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil2PSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setMobUtil2PSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByMobUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByMobUtil2PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByMobUtil2PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByMobUtil2PSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMobUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMobUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil2PSDEForm(pSDEForm);
        this.onBeforeRemoveByMobUtil2PSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByMobUtil2PSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMobUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMobUtil2PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobUtil2PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByMobUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil3PSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_MOBUTIL3PSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMobUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil3PSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setMobUtil3PSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByMobUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByMobUtil3PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByMobUtil3PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByMobUtil3PSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMobUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMobUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil3PSDEForm(pSDEForm);
        this.onBeforeRemoveByMobUtil3PSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByMobUtil3PSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMobUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMobUtil3PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobUtil3PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByMobUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil4PSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_MOBUTIL4PSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMobUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil4PSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setMobUtil4PSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByMobUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByMobUtil4PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByMobUtil4PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByMobUtil4PSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMobUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMobUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil4PSDEForm(pSDEForm);
        this.onBeforeRemoveByMobUtil4PSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByMobUtil4PSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMobUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMobUtil4PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobUtil4PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByMobUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil5PSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_MOBUTIL5PSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMobUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil5PSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setMobUtil5PSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByMobUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByMobUtil5PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByMobUtil5PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByMobUtil5PSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMobUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMobUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtil5PSDEForm(pSDEForm);
        this.onBeforeRemoveByMobUtil5PSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByMobUtil5PSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMobUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMobUtil5PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobUtil5PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtilPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_MOBUTILPSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtilPSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setMobUtilPSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByMobUtilPSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByMobUtilPSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByMobUtilPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobUtilPSDEForm(pSDEForm);
        this.onBeforeRemoveByMobUtilPSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByMobUtilPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMobUtilPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobUtilPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setPSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil2PSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_UTIL2PSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil2PSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setUtil2PSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByUtil2PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByUtil2PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByUtil2PSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil2PSDEForm(pSDEForm);
        this.onBeforeRemoveByUtil2PSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByUtil2PSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByUtil2PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByUtil2PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtil2PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil3PSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_UTIL3PSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil3PSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setUtil3PSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByUtil3PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByUtil3PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByUtil3PSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil3PSDEForm(pSDEForm);
        this.onBeforeRemoveByUtil3PSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByUtil3PSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByUtil3PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByUtil3PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtil3PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil4PSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_UTIL4PSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil4PSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setUtil4PSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByUtil4PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByUtil4PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByUtil4PSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil4PSDEForm(pSDEForm);
        this.onBeforeRemoveByUtil4PSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByUtil4PSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByUtil4PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByUtil4PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtil4PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil5PSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_UTIL5PSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil5PSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setUtil5PSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByUtil5PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByUtil5PSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByUtil5PSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtil5PSDEForm(pSDEForm);
        this.onBeforeRemoveByUtil5PSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByUtil5PSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByUtil5PSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByUtil5PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtil5PSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtilPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEFORM_UTILPSDEFORMID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtilPSDEForm(pSDEForm);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setUtilPSDEFormId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByUtilPSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.internalRemoveByUtilPSDEForm(pSDEForm2);
                PSWFProcessServiceBase.this.onAfterRemoveByUtilPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByUtilPSDEForm(pSDEForm);
        this.onBeforeRemoveByUtilPSDEForm(pSDEForm, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByUtilPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByMobPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEUAGROUP_MOBPSDEUAGROUPID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetMobPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobPSDEUAGroup(pSDEUAGroup);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setMobPSDEUAGroupId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByMobPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByMobPSDEUAGroup(pSDEUAGroup2);
                PSWFProcessServiceBase.this.internalRemoveByMobPSDEUAGroup(pSDEUAGroup2);
                PSWFProcessServiceBase.this.onAfterRemoveByMobPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByMobPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByMobPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByMobPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByMobPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByMobPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByMobPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setPSDEUAGroupId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSWFProcessServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSWFProcessServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSDEVIEWBASE_MOBPSDEVIEWID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobPSDEView(pSDEViewBase);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setMobPSDEViewId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByMobPSDEView(pSDEViewBase2);
                PSWFProcessServiceBase.this.internalRemoveByMobPSDEView(pSDEViewBase2);
                PSWFProcessServiceBase.this.onAfterRemoveByMobPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByMobPSDEView(pSDEViewBase);
        this.onBeforeRemoveByMobPSDEView(pSDEViewBase, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByMobPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setPSDEViewBaseId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSWFProcessServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSWFProcessServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByNamePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSLANGUAGERES_NAMEPSLANRESID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setNamePSLanResId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByNamePSLanRes(pSLanguageRes2);
                PSWFProcessServiceBase.this.internalRemoveByNamePSLanRes(pSLanguageRes2);
                PSWFProcessServiceBase.this.onAfterRemoveByNamePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByNamePSLanRes(pSLanguageRes, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByNamePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysMsgTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSSysMsgTempl), arrayList.get(0)));
        }
    }

    public void resetPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setPSSysMsgTemplId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        final PSSysMsgTempl pSSysMsgTempl2 = pSSysMsgTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSWFProcessServiceBase.this.internalRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSWFProcessServiceBase.this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void internalRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEmbedPSWFDE(pSWFDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSWFDE_EMBEDPSWFDEID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSWFDE), arrayList.get(0)));
        }
    }

    public void resetEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEmbedPSWFDE(pSWFDE);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setEmbedPSWFDEId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
        final PSWFDE pSWFDE2 = pSWFDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByEmbedPSWFDE(pSWFDE2);
                PSWFProcessServiceBase.this.internalRemoveByEmbedPSWFDE(pSWFDE2);
                PSWFProcessServiceBase.this.onAfterRemoveByEmbedPSWFDE(pSWFDE2);
            }
        });
    }

    protected void onBeforeRemoveByEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void internalRemoveByEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEmbedPSWFDE(pSWFDE);
        this.onBeforeRemoveByEmbedPSWFDE(pSWFDE, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByEmbedPSWFDE(pSWFDE, arrayList);
    }

    protected void onAfterRemoveByEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void onBeforeRemoveByEmbedPSWFDE(PSWFDE pSWFDE, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmbedPSWFDE(PSWFDE pSWFDE, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSWFDE(pSWFDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSWFDE_PSWFDEID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSWFDE), arrayList.get(0)));
        }
    }

    public void resetPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSWFDE(pSWFDE);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setPSWFDEId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByPSWFDE(PSWFDE pSWFDE) throws Exception {
        final PSWFDE pSWFDE2 = pSWFDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByPSWFDE(pSWFDE2);
                PSWFProcessServiceBase.this.internalRemoveByPSWFDE(pSWFDE2);
                PSWFProcessServiceBase.this.onAfterRemoveByPSWFDE(pSWFDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void internalRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSWFDE(pSWFDE);
        this.onBeforeRemoveByPSWFDE(pSWFDE, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByPSWFDE(pSWFDE, arrayList);
    }

    protected void onAfterRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void onBeforeRemoveByPSWFDE(PSWFDE pSWFDE, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFDE(PSWFDE pSWFDE, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    public void resetPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSWFVersion(pSWFVersion);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setPSWFVersionId(null);
            this.update(pSWFProcess2);
        }
    }

    public void resetTempPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectTempByPSWFVersion(pSWFVersion);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setPSWFVersionId(null);
            this.updateTemp(pSWFProcess2);
        }
    }

    public void removeByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByPSWFVersion(pSWFVersion2);
                PSWFProcessServiceBase.this.internalRemoveByPSWFVersion(pSWFVersion2);
                PSWFProcessServiceBase.this.onAfterRemoveByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveByPSWFVersion(pSWFVersion, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByRefPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByRefPSWFVersion(pSWFVersion, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFVERSION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFVersion);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSWFVERSION_REFPSWFVERSIONID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSWFVersion), arrayList.get(0)));
        }
    }

    public void resetRefPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByRefPSWFVersion(pSWFVersion);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setRefPSWFVersionId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByRefPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByRefPSWFVersion(pSWFVersion2);
                PSWFProcessServiceBase.this.internalRemoveByRefPSWFVersion(pSWFVersion2);
                PSWFProcessServiceBase.this.onAfterRemoveByRefPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveByRefPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByRefPSWFVersion(pSWFVersion);
        this.onBeforeRemoveByRefPSWFVersion(pSWFVersion, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByRefPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveByRefPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveByRefPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByPSWFWorktime(PSWFWorkTime pSWFWorkTime) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSWFWorktime(pSWFWorkTime, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFWORKTIME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFWorkTime);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSWFWORKTIME_PSWFWORKTIMEID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSWFWorkTime), arrayList.get(0)));
        }
    }

    public void resetPSWFWorktime(PSWFWorkTime pSWFWorkTime) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSWFWorktime(pSWFWorkTime);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setPSWFWorkTimeId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByPSWFWorktime(PSWFWorkTime pSWFWorkTime) throws Exception {
        final PSWFWorkTime pSWFWorkTime2 = pSWFWorkTime;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByPSWFWorktime(pSWFWorkTime2);
                PSWFProcessServiceBase.this.internalRemoveByPSWFWorktime(pSWFWorkTime2);
                PSWFProcessServiceBase.this.onAfterRemoveByPSWFWorktime(pSWFWorkTime2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFWorktime(PSWFWorkTime pSWFWorkTime) throws Exception {
    }

    protected void internalRemoveByPSWFWorktime(PSWFWorkTime pSWFWorkTime) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSWFWorktime(pSWFWorkTime);
        this.onBeforeRemoveByPSWFWorktime(pSWFWorkTime, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByPSWFWorktime(pSWFWorkTime, arrayList);
    }

    protected void onAfterRemoveByPSWFWorktime(PSWFWorkTime pSWFWorkTime) throws Exception {
    }

    protected void onBeforeRemoveByPSWFWorktime(PSWFWorkTime pSWFWorkTime, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFWorktime(PSWFWorkTime pSWFWorkTime, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEmbedPSWF(pSWorkflow, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKFLOW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWorkflow);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSWORKFLOW_EMBEDPSWFID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSWorkflow), arrayList.get(0)));
        }
    }

    public void resetEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEmbedPSWF(pSWorkflow);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setEmbedPSWFId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByEmbedPSWF(pSWorkflow2);
                PSWFProcessServiceBase.this.internalRemoveByEmbedPSWF(pSWorkflow2);
                PSWFProcessServiceBase.this.onAfterRemoveByEmbedPSWF(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByEmbedPSWF(pSWorkflow);
        this.onBeforeRemoveByEmbedPSWF(pSWorkflow, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByEmbedPSWF(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByEmbedPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmbedPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    public void testRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSWF(pSWorkflow, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKFLOW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWorkflow);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCESS_PSWORKFLOW_PSWFID", "", iDataEntityModel.getName(), "PSWFPROCESS", iDataEntityModel.getDataInfo(pSWorkflow), arrayList.get(0)));
        }
    }

    public void resetPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSWF(pSWorkflow);
        for (PSWFProcess pSWFProcess : arrayList) {
            PSWFProcess pSWFProcess2 = (PSWFProcess)this.getDEModel().createEntity();
            pSWFProcess2.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            pSWFProcess2.setPSWFId(null);
            this.update(pSWFProcess2);
        }
    }

    public void removeByPSWF(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveByPSWF(pSWorkflow2);
                PSWFProcessServiceBase.this.internalRemoveByPSWF(pSWorkflow2);
                PSWFProcessServiceBase.this.onAfterRemoveByPSWF(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectByPSWF(pSWorkflow);
        this.onBeforeRemoveByPSWF(pSWorkflow, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.remove(pSWFProcess);
        }
        this.onAfterRemoveByPSWF(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFProcess pSWFProcess) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).testRemoveByFromPSWFProc(pSWFProcess);
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).removeByFromPSWFProc(pSWFProcess);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).testRemoveByToPSWFProc(pSWFProcess);
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).removeByToPSWFProc(pSWFProcess);
        pSCoreSysServiceBase = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcParamServiceBase)pSCoreSysServiceBase).testRemoveByPSWFProcess(pSWFProcess);
        ((PSWFProcParamServiceBase)pSCoreSysServiceBase).removeByPSWFProcess(pSWFProcess);
        pSCoreSysServiceBase = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSWFProcess(pSWFProcess);
        ((PSWFProcRoleServiceBase)pSCoreSysServiceBase).removeByPSWFProcess(pSWFProcess);
        pSCoreSysServiceBase = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcSubWFServiceBase)pSCoreSysServiceBase).testRemoveByPSWFProcess(pSWFProcess);
        ((PSWFProcSubWFServiceBase)pSCoreSysServiceBase).removeByPSWFProcess(pSWFProcess);
        super.onBeforeRemove(pSWFProcess);
    }

    protected void onBeforeRemoveTemp(PSWFProcess pSWFProcess) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcSubWFServiceBase)pSCoreSysServiceBase).removeTempByPSWFProcess(pSWFProcess);
        pSCoreSysServiceBase = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcParamServiceBase)pSCoreSysServiceBase).removeTempByPSWFProcess(pSWFProcess);
        pSCoreSysServiceBase = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcRoleServiceBase)pSCoreSysServiceBase).removeTempByPSWFProcess(pSWFProcess);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).resetTempToPSWFProc(pSWFProcess);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).resetTempFromPSWFProc(pSWFProcess);
        super.onBeforeRemoveTemp(pSWFProcess);
    }

    public void removeTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcessServiceBase.this.onBeforeRemoveTempByPSWFVersion(pSWFVersion2);
                PSWFProcessServiceBase.this.internalRemoveTempByPSWFVersion(pSWFVersion2);
                PSWFProcessServiceBase.this.onAfterRemoveTempByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcess> arrayList = this.selectTempByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveTempByPSWFVersion(pSWFVersion, arrayList);
        for (PSWFProcess pSWFProcess : arrayList) {
            this.removeTemp(pSWFProcess);
        }
        this.onAfterRemoveTempByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveTempByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFProcess> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSWFProcess pSWFProcess) throws Exception {
        this.getRelatedDataTempMajor_PSWFProcRole(pSWFProcess);
        this.getRelatedDataTempMajor_PSWFProcParam(pSWFProcess);
        this.getRelatedDataTempMajor_PSWFProcSubWF(pSWFProcess);
        super.getRelatedDataTempMajor(pSWFProcess);
    }

    protected void getRelatedDataTempMajor_PSWFProcRole(PSWFProcess pSWFProcess) throws Exception {
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcRole> arrayList = null;
        String string = pSWFProcess.getPSWFProcessId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFProcRoleService.selectByPSWFProcess(pSWFProcess) : pSWFProcRoleService.selectTempByPSWFProcess(pSWFProcess);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            pSWFProcRoleService.getTempMajor(pSWFProcRole);
        }
    }

    protected void getRelatedDataTempMajor_PSWFProcParam(PSWFProcess pSWFProcess) throws Exception {
        PSWFProcParamService pSWFProcParamService = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcParam> arrayList = null;
        String string = pSWFProcess.getPSWFProcessId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFProcParamService.selectByPSWFProcess(pSWFProcess) : pSWFProcParamService.selectTempByPSWFProcess(pSWFProcess);
        for (PSWFProcParam pSWFProcParam : arrayList) {
            pSWFProcParamService.getTempMajor(pSWFProcParam);
        }
    }

    protected void getRelatedDataTempMajor_PSWFProcSubWF(PSWFProcess pSWFProcess) throws Exception {
        PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcSubWF> arrayList = null;
        String string = pSWFProcess.getPSWFProcessId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFProcSubWFService.selectByPSWFProcess(pSWFProcess) : pSWFProcSubWFService.selectTempByPSWFProcess(pSWFProcess);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            pSWFProcSubWFService.getTempMajor(pSWFProcSubWF);
        }
    }

    protected void updateRelatedDataTempMajor(PSWFProcess pSWFProcess, PSWFProcess pSWFProcess2) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.updateRelatedDataTempMajor_removePSWFProcSubWF(pSWFProcess, pSWFProcess2);
        ArrayList<PSWFProcParam> arrayList2 = this.updateRelatedDataTempMajor_removePSWFProcParam(pSWFProcess, pSWFProcess2);
        ArrayList<PSWFProcRole> arrayList3 = this.updateRelatedDataTempMajor_removePSWFProcRole(pSWFProcess, pSWFProcess2);
        this.updateRelatedDataTempMajor_updatePSWFProcRole(pSWFProcess, pSWFProcess2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSWFProcParam(pSWFProcess, pSWFProcess2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSWFProcSubWF(pSWFProcess, pSWFProcess2, arrayList);
        super.updateRelatedDataTempMajor(pSWFProcess, pSWFProcess2);
    }

    protected ArrayList<PSWFProcRole> updateRelatedDataTempMajor_removePSWFProcRole(PSWFProcess pSWFProcess, PSWFProcess pSWFProcess2) throws Exception {
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcRole> arrayList = pSWFProcRoleService.selectTempByPSWFProcess(pSWFProcess);
        ArrayList<PSWFProcRole> arrayList2 = pSWFProcRoleService.selectByPSWFProcess(pSWFProcess2);
        HashMap<String, PSWFProcRole> hashMap = new HashMap<String, PSWFProcRole>();
        for (PSWFProcRole pSWFProcRole : arrayList2) {
            hashMap.put(pSWFProcRole.getPSWFProcRoleId(), pSWFProcRole);
        }
        for (PSWFProcRole pSWFProcRole : arrayList) {
            Object object = pSWFProcRole.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSWFProcRole pSWFProcRole : hashMap.values()) {
            pSWFProcRoleService.remove(pSWFProcRole);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSWFProcRole(PSWFProcess pSWFProcess, PSWFProcess pSWFProcess2, ArrayList<PSWFProcRole> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        for (PSWFProcRole pSWFProcRole : arrayList) {
            pSWFProcRoleService.updateTempMajor(pSWFProcRole);
        }
    }

    protected ArrayList<PSWFProcParam> updateRelatedDataTempMajor_removePSWFProcParam(PSWFProcess pSWFProcess, PSWFProcess pSWFProcess2) throws Exception {
        PSWFProcParamService pSWFProcParamService = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcParam> arrayList = pSWFProcParamService.selectTempByPSWFProcess(pSWFProcess);
        ArrayList<PSWFProcParam> arrayList2 = pSWFProcParamService.selectByPSWFProcess(pSWFProcess2);
        HashMap<String, PSWFProcParam> hashMap = new HashMap<String, PSWFProcParam>();
        for (PSWFProcParam pSWFProcParam : arrayList2) {
            hashMap.put(pSWFProcParam.getPSWFProcParamId(), pSWFProcParam);
        }
        for (PSWFProcParam pSWFProcParam : arrayList) {
            Object object = pSWFProcParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSWFProcParam pSWFProcParam : hashMap.values()) {
            pSWFProcParamService.remove(pSWFProcParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSWFProcParam(PSWFProcess pSWFProcess, PSWFProcess pSWFProcess2, ArrayList<PSWFProcParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSWFProcParamService pSWFProcParamService = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSWFProcParam pSWFProcParam : arrayList) {
            pSWFProcParamService.updateTempMajor(pSWFProcParam);
        }
    }

    protected ArrayList<PSWFProcSubWF> updateRelatedDataTempMajor_removePSWFProcSubWF(PSWFProcess pSWFProcess, PSWFProcess pSWFProcess2) throws Exception {
        PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcSubWF> arrayList = pSWFProcSubWFService.selectTempByPSWFProcess(pSWFProcess);
        ArrayList<PSWFProcSubWF> arrayList2 = pSWFProcSubWFService.selectByPSWFProcess(pSWFProcess2);
        HashMap<String, PSWFProcSubWF> hashMap = new HashMap<String, PSWFProcSubWF>();
        for (PSWFProcSubWF pSWFProcSubWF : arrayList2) {
            hashMap.put(pSWFProcSubWF.getPSWFProcSubWFId(), pSWFProcSubWF);
        }
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            Object object = pSWFProcSubWF.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSWFProcSubWF pSWFProcSubWF : hashMap.values()) {
            pSWFProcSubWFService.remove(pSWFProcSubWF);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSWFProcSubWF(PSWFProcess pSWFProcess, PSWFProcess pSWFProcess2, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            pSWFProcSubWFService.updateTempMajor(pSWFProcSubWF);
        }
    }

    protected void replaceParentInfo(PSWFProcess pSWFProcess, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWFProcess, cloneSession);
        if (pSWFProcess.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSWFProcess.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSWFProcess, (PSDEAction)iEntity);
        }
        if (pSWFProcess.getEmbedPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSWFProcess.getEmbedPSDEDSId())) != null) {
            this.onFillParentInfo_EmbedPSDEDS(pSWFProcess, (PSDEDataSet)iEntity);
        }
        if (pSWFProcess.getEditPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSWFProcess.getEditPSDEFGroupId())) != null) {
            this.onFillParentInfo_EditPSDEFGroup(pSWFProcess, (PSDEFGroup)iEntity);
        }
        if (pSWFProcess.getTimeoutPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFProcess.getTimeoutPSDEFId())) != null) {
            this.onFillParentInfo_TimeoutPSDEF(pSWFProcess, (PSDEField)iEntity);
        }
        if (pSWFProcess.getMobPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getMobPSDEFormId())) != null) {
            this.onFillParentInfo_MobPSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getMobUtil2PSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getMobUtil2PSDEFormId())) != null) {
            this.onFillParentInfo_MobUtil2PSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getMobUtil3PSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getMobUtil3PSDEFormId())) != null) {
            this.onFillParentInfo_MobUtil3PSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getMobUtil4PSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getMobUtil4PSDEFormId())) != null) {
            this.onFillParentInfo_MobUtil4PSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getMobUtil5PSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getMobUtil5PSDEFormId())) != null) {
            this.onFillParentInfo_MobUtil5PSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getMobUtilPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getMobUtilPSDEFormId())) != null) {
            this.onFillParentInfo_MobUtilPSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getUtil2PSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getUtil2PSDEFormId())) != null) {
            this.onFillParentInfo_Util2PSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getUtil3PSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getUtil3PSDEFormId())) != null) {
            this.onFillParentInfo_Util3PSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getUtil4PSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getUtil4PSDEFormId())) != null) {
            this.onFillParentInfo_Util4PSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getUtil5PSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getUtil5PSDEFormId())) != null) {
            this.onFillParentInfo_Util5PSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getUtilPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFProcess.getUtilPSDEFormId())) != null) {
            this.onFillParentInfo_UtilPSDEForm(pSWFProcess, (PSDEForm)iEntity);
        }
        if (pSWFProcess.getMobPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSWFProcess.getMobPSDEUAGroupId())) != null) {
            this.onFillParentInfo_MobPSDEUAGroup(pSWFProcess, (PSDEUAGroup)iEntity);
        }
        if (pSWFProcess.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSWFProcess.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSWFProcess, (PSDEUAGroup)iEntity);
        }
        if (pSWFProcess.getMobPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFProcess.getMobPSDEViewId())) != null) {
            this.onFillParentInfo_MobPSDEView(pSWFProcess, (PSDEViewBase)iEntity);
        }
        if (pSWFProcess.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFProcess.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSWFProcess, (PSDEViewBase)iEntity);
        }
        if (pSWFProcess.getNamePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSWFProcess.getNamePSLanResId())) != null) {
            this.onFillParentInfo_NamePSLanRes(pSWFProcess, (PSLanguageRes)iEntity);
        }
        if (pSWFProcess.getPSSysMsgTemplId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTEMPL", (Object)pSWFProcess.getPSSysMsgTemplId())) != null) {
            this.onFillParentInfo_PSSysMsgTempl(pSWFProcess, (PSSysMsgTempl)iEntity);
        }
        if (pSWFProcess.getEmbedPSWFDEId() != null && (iEntity = cloneSession.getEntity("PSWFDE", (Object)pSWFProcess.getEmbedPSWFDEId())) != null) {
            this.onFillParentInfo_EmbedPSWFDE(pSWFProcess, (PSWFDE)iEntity);
        }
        if (pSWFProcess.getPSWFDEId() != null && (iEntity = cloneSession.getEntity("PSWFDE", (Object)pSWFProcess.getPSWFDEId())) != null) {
            this.onFillParentInfo_PSWFDE(pSWFProcess, (PSWFDE)iEntity);
        }
        if (pSWFProcess.getPSWFVersionId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSWFProcess.getPSWFVersionId())) != null) {
            this.onFillParentInfo_PSWFVersion(pSWFProcess, (PSWFVersion)iEntity);
        }
        if (pSWFProcess.getRefPSWFVersionId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSWFProcess.getRefPSWFVersionId())) != null) {
            this.onFillParentInfo_RefPSWFVersion(pSWFProcess, (PSWFVersion)iEntity);
        }
        if (pSWFProcess.getPSWFWorkTimeId() != null && (iEntity = cloneSession.getEntity("PSWFWORKTIME", (Object)pSWFProcess.getPSWFWorkTimeId())) != null) {
            this.onFillParentInfo_PSWFWorktime(pSWFProcess, (PSWFWorkTime)iEntity);
        }
        if (pSWFProcess.getEmbedPSWFId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSWFProcess.getEmbedPSWFId())) != null) {
            this.onFillParentInfo_EmbedPSWF(pSWFProcess, (PSWorkflow)iEntity);
        }
        if (pSWFProcess.getPSWFId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSWFProcess.getPSWFId())) != null) {
            this.onFillParentInfo_PSWF(pSWFProcess, (PSWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFProcess pSWFProcess, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWFProcess, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AsyncMode(bl, pSWFProcess, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditFields(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditFlag(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditPSDEFGroupId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmbedPSDEDSId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmbedPSWFDEId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmbedPSWFId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Enable(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableMobile(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableTimeout(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExitStateName(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExitStateValue(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPath(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeftPos(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MemoField(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobPSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobPSDEUAGroupId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobPSDEViewId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobUtil2PSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobUtil3PSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobUtil4PSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobUtil5PSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobUtilPSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobWFEditViewType(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgType(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MultiInstMode(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResName(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NormalProcType(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedActions(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionName(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTemplId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFDEId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFName(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcessId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcessName(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionName(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFWorkTimeId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSWFVersionId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SendInform(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeParams(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThreadName(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThreadSN(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Timeout(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimeoutPSDEFId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimeoutPSDEFName(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimeoutType(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TopPos(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Util2PSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Util3PSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Util4PSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Util5PSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDEFormId(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFEditViewType(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFProcessType(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepName(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepValue(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSWFProcess, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWFProcess, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AsyncMode(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isAsyncModeDirty() : !pSWFProcess.isAsyncModeDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getAsyncMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AsyncMode_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASYNCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isCodeNameDirty() : !pSWFProcess.isCodeNameDirty()) {
            return null;
        }
        String string = pSWFProcess.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                string3 = "PSWFVERSIONID";
                String string4 = this.checkFieldDupRule(this.getPSWFProcessDEModel(), "CODENAME", string3, pSWFProcess, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isDynaModelFlagDirty() : !pSWFProcess.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditFields(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isEditFieldsDirty() : !pSWFProcess.isEditFieldsDirty()) {
            return null;
        }
        String string = pSWFProcess.getEditFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditFields_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditFlag(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isEditFlagDirty() : !pSWFProcess.isEditFlagDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getEditFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EditFlag_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditPSDEFGroupId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isEditPSDEFGroupIdDirty() : !pSWFProcess.isEditPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getEditPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditPSDEFGroupId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITPSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmbedPSDEDSId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isEmbedPSDEDSIdDirty() : !pSWFProcess.isEmbedPSDEDSIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getEmbedPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmbedPSDEDSId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMBEDPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmbedPSWFDEId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isEmbedPSWFDEIdDirty() : !pSWFProcess.isEmbedPSWFDEIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getEmbedPSWFDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmbedPSWFDEId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMBEDPSWFDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmbedPSWFId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isEmbedPSWFIdDirty() : !pSWFProcess.isEmbedPSWFIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getEmbedPSWFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmbedPSWFId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMBEDPSWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Enable(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isEnableDirty() && !bl2 : !pSWFProcess.isEnableDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getEnable();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Enable_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableMobile(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isEnableMobileDirty() : !pSWFProcess.isEnableMobileDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getEnableMobile();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableMobile_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEMOBILE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableTimeout(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isEnableTimeoutDirty() : !pSWFProcess.isEnableTimeoutDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getEnableTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableTimeout_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLETIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExitStateName(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isExitStateNameDirty() : !pSWFProcess.isExitStateNameDirty()) {
            return null;
        }
        String string = pSWFProcess.getExitStateName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExitStateName_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXITSTATENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExitStateValue(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isExitStateValueDirty() : !pSWFProcess.isExitStateValueDirty()) {
            return null;
        }
        String string = pSWFProcess.getExitStateValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExitStateValue_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXITSTATEVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Height(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isHeightDirty() : !pSWFProcess.isHeightDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPath(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isIconPathDirty() : !pSWFProcess.isIconPathDirty()) {
            return null;
        }
        String string = pSWFProcess.getIconPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPath_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LeftPos(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isLeftPosDirty() : !pSWFProcess.isLeftPosDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getLeftPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LeftPos_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEFTPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMemoDirty() : !pSWFProcess.isMemoDirty()) {
            return null;
        }
        String string = pSWFProcess.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWFProcess, bl2, bl3);
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

    protected EntityFieldError onCheckField_MemoField(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMemoFieldDirty() : !pSWFProcess.isMemoFieldDirty()) {
            return null;
        }
        String string = pSWFProcess.getMemoField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MemoField_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMOFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobPSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMobPSDEFormIdDirty() : !pSWFProcess.isMobPSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getMobPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobPSDEFormId_Default(pSWFProcess, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobPSDEUAGroupId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMobPSDEUAGroupIdDirty() : !pSWFProcess.isMobPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getMobPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobPSDEUAGroupId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBPSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobPSDEViewId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMobPSDEViewIdDirty() : !pSWFProcess.isMobPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getMobPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobPSDEViewId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobUtil2PSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMobUtil2PSDEFormIdDirty() : !pSWFProcess.isMobUtil2PSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getMobUtil2PSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobUtil2PSDEFormId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBUTIL2PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobUtil3PSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMobUtil3PSDEFormIdDirty() : !pSWFProcess.isMobUtil3PSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getMobUtil3PSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobUtil3PSDEFormId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBUTIL3PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobUtil4PSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMobUtil4PSDEFormIdDirty() : !pSWFProcess.isMobUtil4PSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getMobUtil4PSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobUtil4PSDEFormId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBUTIL4PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobUtil5PSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMobUtil5PSDEFormIdDirty() : !pSWFProcess.isMobUtil5PSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getMobUtil5PSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobUtil5PSDEFormId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBUTIL5PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobUtilPSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMobUtilPSDEFormIdDirty() : !pSWFProcess.isMobUtilPSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getMobUtilPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobUtilPSDEFormId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBUTILPSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobWFEditViewType(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMobWFEditViewTypeDirty() : !pSWFProcess.isMobWFEditViewTypeDirty()) {
            return null;
        }
        String string = pSWFProcess.getMobWFEditViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobWFEditViewType_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBWFEDITVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isModelIdDirty() : !pSWFProcess.isModelIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgType(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMsgTypeDirty() : !pSWFProcess.isMsgTypeDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getMsgType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MsgType_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MultiInstMode(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isMultiInstModeDirty() : !pSWFProcess.isMultiInstModeDirty()) {
            return null;
        }
        String string = pSWFProcess.getMultiInstMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MultiInstMode_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MULTIINSTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NamePSLanResId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isNamePSLanResIdDirty() : !pSWFProcess.isNamePSLanResIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getNamePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NamePSLanResName(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isNamePSLanResNameDirty() : !pSWFProcess.isNamePSLanResNameDirty()) {
            return null;
        }
        String string = pSWFProcess.getNamePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResName_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NormalProcType(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isNormalProcTypeDirty() : !pSWFProcess.isNormalProcTypeDirty()) {
            return null;
        }
        String string = pSWFProcess.getNormalProcType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NormalProcType_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NORMALPROCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedActions(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPredefinedActionsDirty() : !pSWFProcess.isPredefinedActionsDirty()) {
            return null;
        }
        String string = pSWFProcess.getPredefinedActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedActions_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSDEActionIdDirty() : !pSWFProcess.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionName(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSDEActionNameDirty() : !pSWFProcess.isPSDEActionNameDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSDEActionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionName_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSDEFormIdDirty() : !pSWFProcess.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default(pSWFProcess, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSDEUAGroupIdDirty() : !pSWFProcess.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSDEViewBaseIdDirty() : !pSWFProcess.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSDynaInstIdDirty() : !pSWFProcess.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMsgTemplId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSSysMsgTemplIdDirty() : !pSWFProcess.isPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSSysMsgTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTemplId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFDEId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSWFDEIdDirty() : !pSWFProcess.isPSWFDEIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSWFDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFDEId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSWFIdDirty() : !pSWFProcess.isPSWFIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSWFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFName(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSWFNameDirty() : !pSWFProcess.isPSWFNameDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSWFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFName_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcessId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSWFProcessIdDirty() && !bl2 : !pSWFProcess.isPSWFProcessIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSWFProcessId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcessId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcessName(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSWFProcessNameDirty() && !bl2 : !pSWFProcess.isPSWFProcessNameDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSWFProcessName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcessName_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSWFVersionIdDirty() : !pSWFProcess.isPSWFVersionIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSWFVersionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionName(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSWFVersionNameDirty() : !pSWFProcess.isPSWFVersionNameDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSWFVersionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionName_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFWorkTimeId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isPSWFWorkTimeIdDirty() : !pSWFProcess.isPSWFWorkTimeIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getPSWFWorkTimeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFWorkTimeId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFWORKTIMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSWFVersionId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isRefPSWFVersionIdDirty() : !pSWFProcess.isRefPSWFVersionIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getRefPSWFVersionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSWFVersionId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSWFVERSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SendInform(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isSendInformDirty() : !pSWFProcess.isSendInformDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getSendInform();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SendInform_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SENDINFORM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapeParams(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isShapeParamsDirty() : !pSWFProcess.isShapeParamsDirty()) {
            return null;
        }
        String string = pSWFProcess.getShapeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeParams_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThreadName(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isThreadNameDirty() : !pSWFProcess.isThreadNameDirty()) {
            return null;
        }
        String string = pSWFProcess.getThreadName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ThreadName_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THREADNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThreadSN(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isThreadSNDirty() : !pSWFProcess.isThreadSNDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getThreadSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ThreadSN_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THREADSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Timeout(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isTimeoutDirty() : !pSWFProcess.isTimeoutDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Timeout_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimeoutPSDEFId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isTimeoutPSDEFIdDirty() : !pSWFProcess.isTimeoutPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getTimeoutPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimeoutPSDEFId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEOUTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimeoutPSDEFName(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isTimeoutPSDEFNameDirty() : !pSWFProcess.isTimeoutPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFProcess.getTimeoutPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimeoutPSDEFName_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEOUTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimeoutType(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isTimeoutTypeDirty() : !pSWFProcess.isTimeoutTypeDirty()) {
            return null;
        }
        String string = pSWFProcess.getTimeoutType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimeoutType_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEOUTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TopPos(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isTopPosDirty() : !pSWFProcess.isTopPosDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getTopPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TopPos_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOPPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUserCatDirty() : !pSWFProcess.isUserCatDirty()) {
            return null;
        }
        String string = pSWFProcess.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSWFProcess, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUserDataDirty() : !pSWFProcess.isUserDataDirty()) {
            return null;
        }
        String string = pSWFProcess.getUserData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData2(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUserData2Dirty() : !pSWFProcess.isUserData2Dirty()) {
            return null;
        }
        String string = pSWFProcess.getUserData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData2_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUserTagDirty() : !pSWFProcess.isUserTagDirty()) {
            return null;
        }
        String string = pSWFProcess.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSWFProcess, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUserTag2Dirty() : !pSWFProcess.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWFProcess.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSWFProcess, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUserTag3Dirty() : !pSWFProcess.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWFProcess.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSWFProcess, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUserTag4Dirty() : !pSWFProcess.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWFProcess.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSWFProcess, bl2, bl3);
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

    protected EntityFieldError onCheckField_Util2PSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUtil2PSDEFormIdDirty() : !pSWFProcess.isUtil2PSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getUtil2PSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Util2PSDEFormId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTIL2PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Util3PSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUtil3PSDEFormIdDirty() : !pSWFProcess.isUtil3PSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getUtil3PSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Util3PSDEFormId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTIL3PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Util4PSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUtil4PSDEFormIdDirty() : !pSWFProcess.isUtil4PSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getUtil4PSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Util4PSDEFormId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTIL4PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Util5PSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUtil5PSDEFormIdDirty() : !pSWFProcess.isUtil5PSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getUtil5PSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Util5PSDEFormId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTIL5PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDEFormId(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isUtilPSDEFormIdDirty() : !pSWFProcess.isUtilPSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFProcess.getUtilPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDEFormId_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFEditViewType(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isWFEditViewTypeDirty() : !pSWFProcess.isWFEditViewTypeDirty()) {
            return null;
        }
        String string = pSWFProcess.getWFEditViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFEditViewType_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFEDITVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFProcessType(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isWFProcessTypeDirty() && !bl2 : !pSWFProcess.isWFProcessTypeDirty()) {
            return null;
        }
        String string = pSWFProcess.getWFProcessType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFPROCESSTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFProcessType_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFPROCESSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepName(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isWFStepNameDirty() : !pSWFProcess.isWFStepNameDirty()) {
            return null;
        }
        String string = pSWFProcess.getWFStepName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFStepName_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepValue(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isWFStepValueDirty() : !pSWFProcess.isWFStepValueDirty()) {
            return null;
        }
        String string = pSWFProcess.getWFStepValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFStepValue_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPVALUE");
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
                string3 = "PSWFVERSIONID";
                String string4 = this.checkFieldDupRule(this.getPSWFProcessDEModel(), "WFSTEPVALUE", string3, pSWFProcess, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("WFSTEPVALUE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Width(boolean bl, PSWFProcess pSWFProcess, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcess.isWidthDirty() : !pSWFProcess.isWidthDirty()) {
            return null;
        }
        Integer n = pSWFProcess.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default(pSWFProcess, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWFProcess pSWFProcess, boolean bl) throws Exception {
        super.onSyncEntity(pSWFProcess, bl);
    }

    protected void onSyncIndexEntities(PSWFProcess pSWFProcess, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWFProcess, bl);
    }

    public Object getDataContextValue(PSWFProcess pSWFProcess, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSDEDSID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSDEDSNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSWFProcess, "embedpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSWFDE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSWFID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSDEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSWFDEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSWFDENAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSWFProcess, "embedpswfid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue(pSWFProcess, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportRelatedModel(PSWFProcess pSWFProcess, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSWFProcParam_PSWFProcess(pSWFProcess, arrayList, n);
        this.onExportRelatedModel_PSWFProcSubWF_PSWFProcess(pSWFProcess, arrayList, n);
        this.onExportRelatedModel_PSWFProcRole_PSWFProcess(pSWFProcess, arrayList, n);
        super.onExportRelatedModel(pSWFProcess, arrayList, n);
    }

    protected void onExportRelatedModel_PSWFProcParam_PSWFProcess(PSWFProcess pSWFProcess, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSWFProcParamService pSWFProcParamService = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcParam> arrayList2 = pSWFProcParamService.selectByPSWFProcess(pSWFProcess);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"6a0c1fd6273287e14a955cc08ceef389");
            jSONObject.put("srfdename", (Object)"PSWFPROCPARAM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSWFPROCPARAM_PSWFPROCESS_PSWFPROCESSID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSWFProcess, (String)"PSWFPROCESSID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSWFProcParam pSWFProcParam : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSWFProcParam, (String)"srfsyspub", (int)1) == 0) continue;
            pSWFProcParamService.exportModel(pSWFProcParam, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSWFProcSubWF_PSWFProcess(PSWFProcess pSWFProcess, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcSubWF> arrayList2 = pSWFProcSubWFService.selectByPSWFProcess(pSWFProcess);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"bd9a152e9fdcf118dfe6f9f36aee0bc9");
            jSONObject.put("srfdename", (Object)"PSWFPROCSUBWF");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSWFPROCSUBWF_PSWFPROCESS_PSWFPROCESSID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSWFProcess, (String)"PSWFPROCESSID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSWFProcSubWF pSWFProcSubWF : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSWFProcSubWF, (String)"srfsyspub", (int)1) == 0) continue;
            pSWFProcSubWFService.exportModel(pSWFProcSubWF, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSWFProcRole_PSWFProcess(PSWFProcess pSWFProcess, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcRole> arrayList2 = pSWFProcRoleService.selectByPSWFProcess(pSWFProcess);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"6a5dc30fae78a2b090c10bb42e9da864");
            jSONObject.put("srfdename", (Object)"PSWFPROCROLE");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSWFPROCROLE_PSWFPROCESS_PSWFPROCESSID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSWFProcess, (String)"PSWFPROCESSID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSWFProcRole pSWFProcRole : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSWFProcRole, (String)"srfsyspub", (int)1) == 0) continue;
            pSWFProcRoleService.exportModel(pSWFProcRole, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSWFProcess pSWFProcess, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_NamePSLanRes(pSWFProcess, arrayList, n);
        super.onExportMajorModel(pSWFProcess, arrayList, n);
    }

    protected void onExportMajorModel_NamePSLanRes(PSWFProcess pSWFProcess, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSWFProcess.getNamePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSWFProcess.getNamePSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ASYNCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AsyncMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditFields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITPSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditPSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITPSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditPSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSWFDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSWFDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSWFDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSWFDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Enable_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEMOBILE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableMobile_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLETIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXITSTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExitStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXITSTATEVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExitStateValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEFTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMOFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MemoField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBFORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobFormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDYNADEVIEWTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDynaDEViewTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUAGROUPCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUAGroupCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL2FORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil2FormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL2PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil2PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL2PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil2PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL3FORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil3FormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL3PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil3PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL3PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil3PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL4FORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil4FormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL4PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil4PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL4PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil4PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL5FORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil5FormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL5PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil5PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTIL5PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtil5PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTILFORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtilFormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTILPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtilPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTILPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtilPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBWFEDITVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobWFEditViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MULTIINSTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MultiInstMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NamePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NamePSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NORMALPROCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NormalProcType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEVIEWTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEViewTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCESSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcessId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCESSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcessName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFWORKTIMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFWorkTimeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFWORKTIMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFWorkTimeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSWFVERSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSWFVersionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SENDINFORM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SendInform_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THREADNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThreadName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THREADSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThreadSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Timeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEOUTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimeoutPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEOUTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimeoutPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEOUTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimeoutType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOPPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TopPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UAGROUPCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UAGroupCodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"UTIL2FORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util2FormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTIL2PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util2PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTIL2PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util2PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTIL3FORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util3FormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTIL3PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util3PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTIL3PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util3PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTIL4FORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util4FormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTIL4PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util4PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTIL4PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util4PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTIL5FORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util5FormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTIL5PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util5PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTIL5PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Util5PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILFORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilFormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFEDITVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFEditViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFENGINETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFEngineType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFPROCESSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFProcessType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTEPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStepName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTEPVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStepValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AsyncMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EditFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITFIELDS", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EditPSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITPSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditPSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITPSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSWFDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSWFDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSWFDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSWFDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Enable_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableMobile_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExitStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXITSTATENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExitStateValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXITSTATEVALUE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IconPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LeftPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MemoField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMOFIELD", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobFormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBFORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_MobPSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobPSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobPSDynaDEViewTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPSDYNADEVIEWTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUAGroupCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUAGROUPCODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil2FormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL2FORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil2PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL2PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil2PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL2PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil3FormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL3FORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil3PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL3PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil3PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL3PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil4FormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL4FORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil4PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL4PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil4PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL4PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil5FormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL5FORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil5PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL5PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtil5PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTIL5PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtilFormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTILFORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtilPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTILPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtilPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTILPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobWFEditViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBWFEDITVIEWTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELID", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MultiInstMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MULTIINSTMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NamePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NamePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NormalProcType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NORMALPROCTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDACTIONS", iEntity, bl2, null, false, 300, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    protected String onTestValueRule_PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEViewTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEVIEWTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSWFDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcessId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCESSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcessName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCESSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFWorkTimeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFWORKTIMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFWorkTimeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFWORKTIMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSWFVersionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSWFVERSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSWFVersionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSWFVERSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SendInform_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShapeParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ThreadName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("THREADNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ThreadSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Timeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TimeoutPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMEOUTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimeoutPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMEOUTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimeoutType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMEOUTTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TopPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UAGroupCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UAGROUPCODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_UserData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_Util2FormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL2FORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Util2PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL2PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Util2PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL2PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Util3FormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL3FORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Util3PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL3PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Util3PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL3PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Util4FormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL4FORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Util4PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL4PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Util4PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL4PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Util5FormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL5FORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Util5PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL5PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Util5PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTIL5PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilFormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILFORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFEditViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFEDITVIEWTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFEngineType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFENGINETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFProcessType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFPROCESSTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFStepName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFStepValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPVALUE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSWFProcess pSWFProcess) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWFProcess)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFProcess pSWFProcess) throws Exception {
        super.onUpdateParent(pSWFProcess);
    }

    protected void onCopyDetails(PSWFProcess pSWFProcess, Object object) throws Exception {
        PSWFProcess pSWFProcess2 = new PSWFProcess();
        pSWFProcess2.set("PSWFPROCESSID", object);
        String string = DataObject.getStringValue((Object)pSWFProcess.get("PSWFPROCESSID"));
        super.onCopyDetails(pSWFProcess, object);
    }

    @Override
    protected void exportCurXmlModel(PSWFProcess pSWFProcess, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFPROCESS");
        if (!bl) {
            pSWFProcess.setPSSystemId(null);
            pSWFProcess.setPSWFVersionId(null);
            pSWFProcess.setPSWFVersionName(null);
            pSWFProcess.setWFEngineType(null);
            super.exportCurXmlModel(pSWFProcess, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSWFProcess pSWFProcess, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSWFProcRole(pSWFProcess, xmlNode);
        this.exportRelatedXmlModel_PSWFProcParam(pSWFProcess, xmlNode);
        this.exportRelatedXmlModel_PSWFProcSubWF(pSWFProcess, xmlNode);
        super.onExportRelatedXmlModel(pSWFProcess, xmlNode);
    }

    protected void exportRelatedXmlModel_PSWFProcRole(PSWFProcess pSWFProcess, XmlNode xmlNode) throws Exception {
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcRole> arrayList = null;
        String string = pSWFProcess.getPSWFProcessId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFProcRoleService.selectByPSWFProcess(pSWFProcess) : pSWFProcRoleService.selectTempByPSWFProcess(pSWFProcess);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSWFPROCROLES");
            xmlNode.addNode(xmlNode2);
            for (PSWFProcRole pSWFProcRole : arrayList) {
                pSWFProcRoleService.exportXmlModel(pSWFProcRole, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSWFProcParam(PSWFProcess pSWFProcess, XmlNode xmlNode) throws Exception {
        PSWFProcParamService pSWFProcParamService = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcParam> arrayList = null;
        String string = pSWFProcess.getPSWFProcessId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFProcParamService.selectByPSWFProcess(pSWFProcess) : pSWFProcParamService.selectTempByPSWFProcess(pSWFProcess);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSWFPROCPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSWFProcParam pSWFProcParam : arrayList) {
                pSWFProcParamService.exportXmlModel(pSWFProcParam, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSWFProcSubWF(PSWFProcess pSWFProcess, XmlNode xmlNode) throws Exception {
        PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcSubWF> arrayList = null;
        String string = pSWFProcess.getPSWFProcessId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFProcSubWFService.selectByPSWFProcess(pSWFProcess) : pSWFProcSubWFService.selectTempByPSWFProcess(pSWFProcess);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSWFPROCSUBWFS");
            xmlNode.addNode(xmlNode2);
            for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
                pSWFProcSubWFService.exportXmlModel(pSWFProcSubWF, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSWFProcess pSWFProcess, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSWFPROCROLES");
        this.importRelatedXmlModel_PSWFProcRole(pSWFProcess, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSWFPROCPARAMS");
        this.importRelatedXmlModel_PSWFProcParam(pSWFProcess, xmlNode3);
        XmlNode xmlNode4 = xmlNode.getChildNodeByNodeName("PSWFPROCSUBWFS");
        this.importRelatedXmlModel_PSWFProcSubWF(pSWFProcess, xmlNode4);
        super.onImportRelatedXmlModel(pSWFProcess, xmlNode);
    }

    protected void importRelatedXmlModel_PSWFProcRole(PSWFProcess pSWFProcess, XmlNode xmlNode) throws Exception {
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        String string = pSWFProcess.getPSWFProcessId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSWFProcRoleService.removeByPSWFProcess(pSWFProcess);
        } else {
            pSWFProcRoleService.removeTempByPSWFProcess(pSWFProcess);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSWFProcRole pSWFProcRole = new PSWFProcRole();
                pSWFProcRoleService.fillParentInfo(pSWFProcRole, "DER1N", "DER1N_PSWFPROCROLE_PSWFPROCESS_PSWFPROCESSID", pSWFProcess.getPSWFProcessId());
                pSWFProcRoleService.importXmlModel(pSWFProcRole, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSWFProcParam(PSWFProcess pSWFProcess, XmlNode xmlNode) throws Exception {
        PSWFProcParamService pSWFProcParamService = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSWFProcess.getPSWFProcessId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSWFProcParamService.removeByPSWFProcess(pSWFProcess);
        } else {
            pSWFProcParamService.removeTempByPSWFProcess(pSWFProcess);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSWFProcParam pSWFProcParam = new PSWFProcParam();
                pSWFProcParamService.fillParentInfo(pSWFProcParam, "DER1N", "DER1N_PSWFPROCPARAM_PSWFPROCESS_PSWFPROCESSID", pSWFProcess.getPSWFProcessId());
                pSWFProcParamService.importXmlModel(pSWFProcParam, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSWFProcSubWF(PSWFProcess pSWFProcess, XmlNode xmlNode) throws Exception {
        PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        String string = pSWFProcess.getPSWFProcessId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSWFProcSubWFService.removeByPSWFProcess(pSWFProcess);
        } else {
            pSWFProcSubWFService.removeTempByPSWFProcess(pSWFProcess);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSWFProcSubWF pSWFProcSubWF = new PSWFProcSubWF();
                pSWFProcSubWFService.fillParentInfo(pSWFProcSubWF, "DER1N", "DER1N_PSWFPROCSUBWF_PSWFPROCESS_PSWFPROCESSID", pSWFProcess.getPSWFProcessId());
                pSWFProcSubWFService.importXmlModel(pSWFProcSubWF, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWFProcess pSWFProcess, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWFProcess, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWFVERSION#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFPROCESS_PSWFVERSION_PSWFVERSIONID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWFVERSION", (boolean)true) == 0) {
            iEntity.set("PSWFVERSIONID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSWFVERSIONID"};
    }

    @Override
    public String getModelV2Tag(PSWFProcess pSWFProcess) {
        if (!StringHelper.isNullOrEmpty((String)pSWFProcess.getCodeName())) {
            return pSWFProcess.getCodeName();
        }
        return super.getModelV2Tag(pSWFProcess);
    }

    @Override
    public boolean setModelV2Tag(PSWFProcess pSWFProcess, String string) {
        pSWFProcess.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSWFVERSIONID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWFProcess pSWFProcess, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWFProcess.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWFProcess, true);
        pSWFProcess.set("CODENAME", string);
        if (this.select(pSWFProcess, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWFProcess, true);
        return super.getModelV2Entity(pSWFProcess, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWFProcess pSWFProcess, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSWFProcess, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSWFPROCROLE_PSWFPROCESS_PSWFPROCESSID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSWFPROCSUBWF_PSWFPROCESS_PSWFPROCESSID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSWFPROCPARAM_PSWFPROCESS_PSWFPROCESSID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSWFProcess pSWFProcess, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSWFProcess, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSWFProcess pSWFProcess, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFPROCROLE_PSWFPROCESS_PSWFPROCESSID")) {
            PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFPROCESS#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFPROCROLE", (Object)pSWFProcess.getPSWFProcessId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String modelText : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)modelText)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)modelText));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String modelScope = StringHelper.format((String)"PSWFPROCESS#%1$s", (Object)pSWFProcess.getPSWFProcessId());
                for (PSWFProcRole pSWFProcRole : pSWFProcRoleService.selectByPSWFProcess(pSWFProcess)) {
                    if (StringHelper.compare(modelScope, (String)pSWFProcRoleService.getModelV2ResScope(pSWFProcRole), (boolean)false) != 0) continue;
                    arrayList.add((ObjectNode)PSModelV2Helper.toJSONObject(pSWFProcRole, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                String modelName = pSWFProcRoleService.getModelV2Name(false);
                ArrayNode modelArray = objectNode.putArray(modelName.toLowerCase());
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
                        if (objectNode.has("pswfprocrolename")) {
                            string = objectNode.get("pswfprocrolename").asText();
                        }
                        if (objectNode2.has("pswfprocrolename")) {
                            string2 = objectNode2.get("pswfprocrolename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode modelNode : arrayList) {
                    PSWFProcRole pSWFProcRole = new PSWFProcRole();
                    PSModelV2Helper.fromJSONObject((IDataObject)pSWFProcRole, modelNode, false);
                    modelArray.add((JsonNode)pSWFProcRoleService.exportModelV2(pSWFProcRole, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFPROCSUBWF_PSWFPROCESS_PSWFPROCESSID")) {
            PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFPROCESS#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFPROCSUBWF", (Object)pSWFProcess.getPSWFProcessId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String modelText : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)modelText)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)modelText));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String modelScope = StringHelper.format((String)"PSWFPROCESS#%1$s", (Object)pSWFProcess.getPSWFProcessId());
                for (PSWFProcSubWF pSWFProcSubWF : pSWFProcSubWFService.selectByPSWFProcess(pSWFProcess)) {
                    if (StringHelper.compare(modelScope, (String)pSWFProcSubWFService.getModelV2ResScope(pSWFProcSubWF), (boolean)false) != 0) continue;
                    arrayList.add((ObjectNode)PSModelV2Helper.toJSONObject(pSWFProcSubWF, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                String modelName = pSWFProcSubWFService.getModelV2Name(false);
                ArrayNode modelArray = objectNode.putArray(modelName.toLowerCase());
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
                        if (objectNode.has("pswfprocsubwfname")) {
                            string = objectNode.get("pswfprocsubwfname").asText();
                        }
                        if (objectNode2.has("pswfprocsubwfname")) {
                            string2 = objectNode2.get("pswfprocsubwfname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode modelNode : arrayList) {
                    PSWFProcSubWF pSWFProcSubWF = new PSWFProcSubWF();
                    PSModelV2Helper.fromJSONObject((IDataObject)pSWFProcSubWF, modelNode, false);
                    modelArray.add((JsonNode)pSWFProcSubWFService.exportModelV2(pSWFProcSubWF, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFPROCPARAM_PSWFPROCESS_PSWFPROCESSID")) {
            PSWFProcParamService pSWFProcParamService = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFPROCESS#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFPROCPARAM", (Object)pSWFProcess.getPSWFProcessId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String modelText : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)modelText)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)modelText));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String modelScope = StringHelper.format((String)"PSWFPROCESS#%1$s", (Object)pSWFProcess.getPSWFProcessId());
                for (PSWFProcParam pSWFProcParam : pSWFProcParamService.selectByPSWFProcess(pSWFProcess)) {
                    if (StringHelper.compare(modelScope, (String)pSWFProcParamService.getModelV2ResScope(pSWFProcParam), (boolean)false) != 0) continue;
                    arrayList.add((ObjectNode)PSModelV2Helper.toJSONObject(pSWFProcParam, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                String modelName = pSWFProcParamService.getModelV2Name(false);
                ArrayNode modelArray = objectNode.putArray(modelName.toLowerCase());
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
                        if (objectNode.has("pswfprocparamname")) {
                            string = objectNode.get("pswfprocparamname").asText();
                        }
                        if (objectNode2.has("pswfprocparamname")) {
                            string2 = objectNode2.get("pswfprocparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode modelNode : arrayList) {
                    PSWFProcParam pSWFProcParam = new PSWFProcParam();
                    PSModelV2Helper.fromJSONObject((IDataObject)pSWFProcParam, modelNode, false);
                    modelArray.add((JsonNode)pSWFProcParamService.exportModelV2(pSWFProcParam, string));
                }
            }
        }
        super.onExportCurModelV2(pSWFProcess, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSWFProcess pSWFProcess) throws Exception {
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcRole> arrayList = pSWFProcRoleService.selectByPSWFProcess(pSWFProcess);
        String string2 = StringHelper.format((String)"PSWFPROCESS#%1$s", (Object)pSWFProcess.getPSWFProcessId());
        for (PSWFProcRole pSWFProcRole : arrayList) {
            String modelScope = pSWFProcRoleService.getModelV2ResScope(pSWFProcRole);
            if (StringHelper.compare((String)string2, (String)modelScope, (boolean)false) != 0) continue;
            pSWFProcRoleService.emptyModelV2(pSWFProcRole);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSWFProcess.getPSWFProcessId());
        pSWFProcRoleService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSWFProcRoleService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSWFPROCROLE WHERE PSWFPROCESSID = ?", sqlParamList);
        PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcSubWF> subWFList = pSWFProcSubWFService.selectByPSWFProcess(pSWFProcess);
        string2 = StringHelper.format((String)"PSWFPROCESS#%1$s", (Object)pSWFProcess.getPSWFProcessId());
        for (PSWFProcSubWF pSWFProcSubWF : subWFList) {
            String modelScope = pSWFProcSubWFService.getModelV2ResScope(pSWFProcSubWF);
            if (StringHelper.compare((String)string2, (String)modelScope, (boolean)false) != 0) continue;
            pSWFProcSubWFService.emptyModelV2(pSWFProcSubWF);
        }
        sqlParamList = new SqlParamList();
        sqlParamList.addString(pSWFProcess.getPSWFProcessId());
        pSWFProcSubWFService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSWFProcSubWFService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSWFPROCSUBWF WHERE PSWFPROCESSID = ?", sqlParamList);
        PSWFProcParamService pSWFProcParamService = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcParam> paramList = pSWFProcParamService.selectByPSWFProcess(pSWFProcess);
        string2 = StringHelper.format((String)"PSWFPROCESS#%1$s", (Object)pSWFProcess.getPSWFProcessId());
        for (PSWFProcParam pSWFProcParam : paramList) {
            String modelScope = pSWFProcParamService.getModelV2ResScope(pSWFProcParam);
            if (StringHelper.compare((String)string2, (String)modelScope, (boolean)false) != 0) continue;
            pSWFProcParamService.emptyModelV2(pSWFProcParam);
        }
        sqlParamList = new SqlParamList();
        sqlParamList.addString(pSWFProcess.getPSWFProcessId());
        pSWFProcParamService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSWFProcParamService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSWFPROCPARAM WHERE PSWFPROCESSID = ?", sqlParamList);
        super.onEmptyModelV2(pSWFProcess);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSWFProcess pSWFProcess, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSWFProcRole();
        entityBase.set("PSWFPROCESSID", pSWFProcess.getPSWFProcessId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWFProcSubWF();
        entityBase.set("PSWFPROCESSID", pSWFProcess.getPSWFProcessId());
        pSCoreSysServiceBase = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWFProcParam();
        entityBase.set("PSWFPROCESSID", pSWFProcess.getPSWFProcessId());
        pSCoreSysServiceBase = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSWFProcess, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSWFProcess pSWFProcess, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSWFProcRoleService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode modelNode = (ObjectNode)arrayNode.get(i);
                PSWFProcRole pSWFProcRole = new PSWFProcRole();
                pSWFProcRole.setPSSystemId(pSWFProcess.getPSSystemId());
                pSWFProcRole.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
                pSWFProcRole.setPSWFProcessName(pSWFProcess.getPSWFProcessName());
                pSWFProcRoleService.compileModelV2(pSWFProcRole, modelNode, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray = file.listFiles();
                if (fileArray != null) {
                    for (File file2 : fileArray) {
                        if (!file2.isDirectory()) continue;
                        PSWFProcRole pSWFProcRole = new PSWFProcRole();
                        pSWFProcRole.setPSSystemId(pSWFProcess.getPSSystemId());
                        pSWFProcRole.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
                        pSWFProcRole.setPSWFProcessName(pSWFProcess.getPSWFProcessName());
                        pSWFProcRoleService.compileModelV2(pSWFProcRole, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSWFProcSubWFService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode modelNode = (ObjectNode)arrayNode.get(i);
                PSWFProcSubWF pSWFProcSubWF = new PSWFProcSubWF();
                pSWFProcSubWF.setPSSystemId(pSWFProcess.getPSSystemId());
                pSWFProcSubWF.setPSWFId(pSWFProcess.getPSWFId());
                pSWFProcSubWF.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
                pSWFProcSubWF.setPSWFProcessName(pSWFProcess.getPSWFProcessName());
                pSWFProcSubWF.setPSWFVersionId(pSWFProcess.getPSWFVersionId());
                pSWFProcSubWFService.compileModelV2(pSWFProcSubWF, modelNode, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string5);
            if (file.exists()) {
                File[] fileArray = file.listFiles();
                if (fileArray != null) {
                    for (File file2 : fileArray) {
                        if (!file2.isDirectory()) continue;
                        PSWFProcSubWF pSWFProcSubWF = new PSWFProcSubWF();
                        pSWFProcSubWF.setPSSystemId(pSWFProcess.getPSSystemId());
                        pSWFProcSubWF.setPSWFId(pSWFProcess.getPSWFId());
                        pSWFProcSubWF.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
                        pSWFProcSubWF.setPSWFProcessName(pSWFProcess.getPSWFProcessName());
                        pSWFProcSubWF.setPSWFVersionId(pSWFProcess.getPSWFVersionId());
                        pSWFProcSubWFService.compileModelV2(pSWFProcSubWF, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        PSWFProcParamService pSWFProcParamService = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSWFProcParamService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode modelNode = (ObjectNode)arrayNode.get(i);
                PSWFProcParam pSWFProcParam = new PSWFProcParam();
                pSWFProcParam.setPSDEId(pSWFProcess.getPSDEId());
                pSWFProcParam.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
                pSWFProcParam.setPSWFProcessName(pSWFProcess.getPSWFProcessName());
                pSWFProcParam.setPSWFVersionId(pSWFProcess.getPSWFVersionId());
                pSWFProcParamService.compileModelV2(pSWFProcParam, modelNode, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string6);
            if (file.exists()) {
                File[] fileArray = file.listFiles();
                if (fileArray != null) {
                    for (File file2 : fileArray) {
                        if (!file2.isDirectory()) continue;
                        PSWFProcParam pSWFProcParam = new PSWFProcParam();
                        pSWFProcParam.setPSDEId(pSWFProcess.getPSDEId());
                        pSWFProcParam.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
                        pSWFProcParam.setPSWFProcessName(pSWFProcess.getPSWFProcessName());
                        pSWFProcParam.setPSWFVersionId(pSWFProcess.getPSWFVersionId());
                        pSWFProcParamService.compileModelV2(pSWFProcParam, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSWFProcess, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSWFProcess pSWFProcess, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWFPROCROLE_PSWFPROCESS_PSWFPROCESSID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWFProcRoles(pSWFProcess, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWFPROCSUBWF_PSWFPROCESS_PSWFPROCESSID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWFProcSubWFs(pSWFProcess, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWFPROCPARAM_PSWFPROCESS_PSWFPROCESSID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWFProcParams(pSWFProcess, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSWFProcess, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSWFProcRoles(PSWFProcess pSWFProcess, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFPROCROLE", true), (boolean)false) == 0) {
            PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
            PSWFProcRole pSWFProcRole = new PSWFProcRole();
            pSWFProcRole.setPSWFProcRoleId(pSMOSFile.getPSModelId());
            if (!pSWFProcRoleService.get(pSWFProcRole, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWFProcRole.getPSWFProcessId(), (String)pSWFProcess.getPSWFProcessId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWFProcRoleService.exportModelV2(pSWFProcRole);
            pSWFProcRole.reset();
            if (!pSWFProcRoleService.setModelV2ResScope(pSWFProcRole, "PSWFPROCESS", pSWFProcess.getPSWFProcessId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWFProcRoleService.importModelV2(pSWFProcRole, objectNode);
            SessionFactoryManager.commit();
            return pSWFProcRoleService.getFile(pSWFProcRole);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSWFProcSubWFs(PSWFProcess pSWFProcess, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFPROCSUBWF", true), (boolean)false) == 0) {
            PSWFProcSubWFService pSWFProcSubWFService = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
            PSWFProcSubWF pSWFProcSubWF = new PSWFProcSubWF();
            pSWFProcSubWF.setPSWFProcSubWFId(pSMOSFile.getPSModelId());
            if (!pSWFProcSubWFService.get(pSWFProcSubWF, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWFProcSubWF.getPSWFProcessId(), (String)pSWFProcess.getPSWFProcessId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWFProcSubWFService.exportModelV2(pSWFProcSubWF);
            pSWFProcSubWF.reset();
            if (!pSWFProcSubWFService.setModelV2ResScope(pSWFProcSubWF, "PSWFPROCESS", pSWFProcess.getPSWFProcessId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWFProcSubWFService.importModelV2(pSWFProcSubWF, objectNode);
            SessionFactoryManager.commit();
            return pSWFProcSubWFService.getFile(pSWFProcSubWF);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSWFProcParams(PSWFProcess pSWFProcess, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFPROCPARAM", true), (boolean)false) == 0) {
            PSWFProcParamService pSWFProcParamService = (PSWFProcParamService)ServiceGlobal.getService(PSWFProcParamService.class, (SessionFactory)this.getSessionFactory());
            PSWFProcParam pSWFProcParam = new PSWFProcParam();
            pSWFProcParam.setPSWFProcParamId(pSMOSFile.getPSModelId());
            if (!pSWFProcParamService.get(pSWFProcParam, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWFProcParam.getPSWFProcessId(), (String)pSWFProcess.getPSWFProcessId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWFProcParamService.exportModelV2(pSWFProcParam);
            pSWFProcParam.reset();
            if (!pSWFProcParamService.setModelV2ResScope(pSWFProcParam, "PSWFPROCESS", pSWFProcess.getPSWFProcessId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWFProcParamService.importModelV2(pSWFProcParam, objectNode);
            SessionFactoryManager.commit();
            return pSWFProcParamService.getFile(pSWFProcParam);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSWFProcess pSWFProcess, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSWFProcRoles(pSWFProcess, list);
        this.onFillPasteHelps_PSWFProcSubWFs(pSWFProcess, list);
        this.onFillPasteHelps_PSWFProcParams(pSWFProcess, list);
        super.onFillPasteHelps(pSWFProcess, list);
    }

    protected void onFillPasteHelps_PSWFProcRoles(PSWFProcess pSWFProcess, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWFPROCROLE");
        pSHelpSection.setSectionParam2("DER1N_PSWFPROCROLE_PSWFPROCESS_PSWFPROCESSID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6d41\u7a0b\u5904\u7406\u8282\u70b9]\u7684[\u6d41\u7a0b\u5904\u7406\u89d2\u8272]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSWFProcSubWFs(PSWFProcess pSWFProcess, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWFPROCSUBWF");
        pSHelpSection.setSectionParam2("DER1N_PSWFPROCSUBWF_PSWFPROCESS_PSWFPROCESSID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6d41\u7a0b\u5904\u7406\u8282\u70b9]\u7684[\u6d41\u7a0b\u5904\u7406\u5b50\u6d41\u7a0b]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSWFProcParams(PSWFProcess pSWFProcess, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWFPROCPARAM");
        pSHelpSection.setSectionParam2("DER1N_PSWFPROCPARAM_PSWFPROCESS_PSWFPROCESSID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6d41\u7a0b\u5904\u7406\u8282\u70b9]\u7684[\u6d41\u7a0b\u5904\u7406\u53c2\u6570]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSWFProcess pSWFProcess) throws Exception {
        return pSWFProcess.getWFProcessType();
    }
}
