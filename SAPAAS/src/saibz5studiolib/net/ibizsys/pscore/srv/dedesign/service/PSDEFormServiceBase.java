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
import java.io.Serializable;
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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFormDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFormDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUDetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIVR;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIVRBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormRF;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormRFBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIVRServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormRFService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormRFServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepServiceBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInstBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormTemplService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormTemplServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDEBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFormServiceBase
extends PSCoreSysServiceBase<PSDEForm> {
    private static final Log log = LogFactory.getLog(PSDEFormServiceBase.class);
    public static final String DATASET_CURAPPEDITMODE = "CurAppEditMode";
    public static final String DATASET_CURAPPSEARCHMODE = "CurAppSearchMode";
    public static final String DATASET_CURDEEDITMODE = "CurDEEditMode";
    public static final String DATASET_CURDESEARCHMODE = "CurDESearchMode";
    public static final String DATASET_CURDEWIZARDMODE = "CurDEWizardMode";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYSEDITMODE = "CurSysEditMode";
    public static final String DATASET_CURSYSSEARCHMODE = "CurSysSearchMode";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_EDITMODE = "EditMode";
    public static final String DATASET_FORMTYPE = "FormType";
    public static final String DATASET_SEARCHMODE = "SearchMode";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_JITPREVIEW = "JITPREVIEW";
    public static final String ACTION_PREVIEWSAVE = "PreviewSave";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSDEFormDEModel pSDEFormDEModel;
    private PSDEFormDAO pSDEFormDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFormService";
    }

    public PSDEFormDEModel getPSDEFormDEModel() {
        if (this.pSDEFormDEModel == null) {
            try {
                this.pSDEFormDEModel = (PSDEFormDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFormDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFormDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFormDEModel();
    }

    public PSDEFormDAO getPSDEFormDAO() {
        if (this.pSDEFormDAO == null) {
            try {
                this.pSDEFormDAO = (PSDEFormDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFormDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFormDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFormDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPEDITMODE, (boolean)true) == 0) {
            return this.fetchCurAppEditMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPSEARCHMODE, (boolean)true) == 0) {
            return this.fetchCurAppSearchMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEEDITMODE, (boolean)true) == 0) {
            return this.fetchCurDEEditMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDESEARCHMODE, (boolean)true) == 0) {
            return this.fetchCurDESearchMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEWIZARDMODE, (boolean)true) == 0) {
            return this.fetchCurDEWizardMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSEDITMODE, (boolean)true) == 0) {
            return this.fetchCurSysEditMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSSEARCHMODE, (boolean)true) == 0) {
            return this.fetchCurSysSearchMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_EDITMODE, (boolean)true) == 0) {
            return this.fetchEditMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_SEARCHMODE, (boolean)true) == 0) {
            return this.fetchSearchMode(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPEDITMODE, (boolean)true) == 0) {
            return this.fetchTempCurAppEditMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPSEARCHMODE, (boolean)true) == 0) {
            return this.fetchTempCurAppSearchMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEEDITMODE, (boolean)true) == 0) {
            return this.fetchTempCurDEEditMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDESEARCHMODE, (boolean)true) == 0) {
            return this.fetchTempCurDESearchMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEWIZARDMODE, (boolean)true) == 0) {
            return this.fetchTempCurDEWizardMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchTempCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSEDITMODE, (boolean)true) == 0) {
            return this.fetchTempCurSysEditMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSSEARCHMODE, (boolean)true) == 0) {
            return this.fetchTempCurSysSearchMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_EDITMODE, (boolean)true) == 0) {
            return this.fetchTempEditMode(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchTempFormType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_SEARCHMODE, (boolean)true) == 0) {
            return this.fetchTempSearchMode(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSDEForm)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSDEForm)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSDEForm)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDEForm)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_JITPREVIEW, (boolean)true) == 0) {
            this.jITPreview((PSDEForm)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PREVIEWSAVE, (boolean)true) == 0) {
            this.previewSave((PSDEForm)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDEForm)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurAppEditMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPEDITMODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAppEditMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPEDITMODE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurAppSearchMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPSEARCHMODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAppSearchMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPSEARCHMODE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEEditMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEEDITMODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEEditMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEEDITMODE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDESearchMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDESEARCHMODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDESearchMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDESEARCHMODE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEWizardMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEWIZARDMODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEWizardMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEWIZARDMODE, true);
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

    public DBFetchResult fetchCurSysEditMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSEDITMODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysEditMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSEDITMODE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysSearchMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSSEARCHMODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysSearchMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSSEARCHMODE, true);
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

    public DBFetchResult fetchEditMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_EDITMODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempEditMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_EDITMODE, true);
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

    public DBFetchResult fetchSearchMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_SEARCHMODE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempSearchMode(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_SEARCHMODE, true);
        return dBFetchResult;
    }

    public void createWithModel(PSDEForm pSDEForm) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSDEForm, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEForm, ACTION_CREATEWITHMODEL);
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormServiceBase.this.getService(), PSDEFormServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSDEForm2, null).getResult() != 1) {
                    PSDEFormServiceBase.this.onCreateWithModel(pSDEForm2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSDEForm, null);
        }
    }

    protected void onCreateWithModel(PSDEForm pSDEForm) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSDEForm pSDEForm) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, (IEntity)pSDEForm, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEForm, ACTION_GETDRAFTFROMWITHMODEL);
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormServiceBase.this.getService(), PSDEFormServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, (IEntity)pSDEForm2, null).getResult() != 1) {
                    PSDEFormServiceBase.this.onGetDraftFromWithModel(pSDEForm2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, (IEntity)pSDEForm, null);
        }
    }

    protected void onGetDraftFromWithModel(PSDEForm pSDEForm) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSDEForm pSDEForm) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, (IEntity)pSDEForm, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEForm, ACTION_GETDRAFTWITHMODEL);
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormServiceBase.this.getService(), PSDEFormServiceBase.ACTION_GETDRAFTWITHMODEL, 40, (IEntity)pSDEForm2, null).getResult() != 1) {
                    PSDEFormServiceBase.this.onGetDraftWithModel(pSDEForm2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, (IEntity)pSDEForm, null);
        }
    }

    protected void onGetDraftWithModel(PSDEForm pSDEForm) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSDEForm pSDEForm) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSDEForm, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEForm, ACTION_GETWITHMODEL);
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormServiceBase.this.getService(), PSDEFormServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSDEForm2, null).getResult() != 1) {
                    PSDEFormServiceBase.this.onGetWithModel(pSDEForm2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSDEForm, null);
        }
    }

    protected void onGetWithModel(PSDEForm pSDEForm) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void jITPreview(PSDEForm pSDEForm) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 0, (IEntity)pSDEForm, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEForm, ACTION_JITPREVIEW);
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormServiceBase.this.getService(), PSDEFormServiceBase.ACTION_JITPREVIEW, 40, (IEntity)pSDEForm2, null).getResult() != 1) {
                    PSDEFormServiceBase.this.onJITPreview(pSDEForm2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 99, (IEntity)pSDEForm, null);
        }
    }

    protected void onJITPreview(PSDEForm pSDEForm) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[JITPREVIEW]");
    }

    public void previewSave(PSDEForm pSDEForm) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 0, (IEntity)pSDEForm, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEForm, ACTION_PREVIEWSAVE);
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormServiceBase.this.getService(), PSDEFormServiceBase.ACTION_PREVIEWSAVE, 40, (IEntity)pSDEForm2, null).getResult() != 1) {
                    PSDEFormServiceBase.this.onPreviewSave(pSDEForm2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 99, (IEntity)pSDEForm, null);
        }
    }

    protected void onPreviewSave(PSDEForm pSDEForm) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PreviewSave]");
    }

    public void updateWithModel(PSDEForm pSDEForm) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSDEForm, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEForm, ACTION_UPDATEWITHMODEL);
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormServiceBase.this.getService(), PSDEFormServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSDEForm2, null).getResult() != 1) {
                    PSDEFormServiceBase.this.onUpdateWithModel(pSDEForm2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSDEForm, null);
        }
    }

    protected void onUpdateWithModel(PSDEForm pSDEForm) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDEForm pSDEForm, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSACHandler);
            } else {
                iService.get((IEntity)pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSDEForm, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlLogicGroup);
            } else {
                iService.get((IEntity)pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEForm, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlMsg);
            } else {
                iService.get((IEntity)pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSDEForm, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEForm, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDEACTION_COPYPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_CopyPSDEAction(pSDEForm, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDEACTION_CREATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_CreatePSDEAction(pSDEForm, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDEACTION_GETDRAFTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_GetDraftPSDEAction(pSDEForm, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDEACTION_GETPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_GetPSDEAction(pSDEForm, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDEACTION_REMOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_RemovePSDEAction(pSDEForm, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDEACTION_UPDATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_UpdatePSDEAction(pSDEForm, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDEACTION_USER2PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_User2PSDEAction(pSDEForm, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDEACTION_USERPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_UserPSDEAction(pSDEForm, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDEFINPUTTIPSET_PSDEFINPUTTIPSETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService", (SessionFactory)this.getSessionFactory());
            PSDEFInputTipSet pSDEFInputTipSet = (PSDEFInputTipSet)iService.getDEModel().createEntity();
            pSDEFInputTipSet.set("PSDEFINPUTTIPSETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFInputTipSet);
            } else {
                iService.get((IEntity)pSDEFInputTipSet);
            }
            this.onFillParentInfo_PSDEFInputTipSet(pSDEForm, pSDEFInputTipSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDYNADEFORM_PSDYNADEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService", (SessionFactory)this.getSessionFactory());
            PSDynaDEForm pSDynaDEForm = (PSDynaDEForm)iService.getDEModel().createEntity();
            pSDynaDEForm.set("PSDYNADEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaDEForm);
            } else {
                iService.get((IEntity)pSDynaDEForm);
            }
            this.onFillParentInfo_PSDynaDEForm(pSDEForm, pSDynaDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSDYNAINST_PSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDynaInst pSDynaInst = (PSDynaInst)iService.getDEModel().createEntity();
            pSDynaInst.set("PSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaInst);
            } else {
                iService.get((IEntity)pSDynaInst);
            }
            this.onFillParentInfo_PSDynaInst(pSDEForm, pSDynaInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPF);
            } else {
                iService.get((IEntity)pSPF);
            }
            this.onFillParentInfo_PSPF(pSDEForm, pSPF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCounter);
            } else {
                iService.get((IEntity)pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSDEForm, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSSYSCSS_NAVBARPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_NavBarPSSysCss(pSDEForm, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEForm, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEForm, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEForm, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEForm, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSViewMsgGroup);
            } else {
                iService.get((IEntity)pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSDEForm, pSViewMsgGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORM_PSWFDE_PSWFDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService", (SessionFactory)this.getSessionFactory());
            PSWFDE pSWFDE = (PSWFDE)iService.getDEModel().createEntity();
            pSWFDE.set("PSWFDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFDE);
            } else {
                iService.get((IEntity)pSWFDE);
            }
            this.onFillParentInfo_PSWFDE(pSDEForm, pSWFDE);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEForm, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSDEForm pSDEForm, PSACHandler pSACHandler) throws Exception {
        pSDEForm.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEForm.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSDEForm pSDEForm, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSDEForm.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSDEForm.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSCtrlMsg(PSDEForm pSDEForm, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSDEForm.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSDEForm.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_PSDE(PSDEForm pSDEForm, PSDataEntity pSDataEntity) throws Exception {
        pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEForm.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_CopyPSDEAction(PSDEForm pSDEForm, PSDEAction pSDEAction) throws Exception {
        pSDEForm.setCopyPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEForm.setCopyPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_CreatePSDEAction(PSDEForm pSDEForm, PSDEAction pSDEAction) throws Exception {
        pSDEForm.setCreatePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEForm.setCreatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GetDraftPSDEAction(PSDEForm pSDEForm, PSDEAction pSDEAction) throws Exception {
        pSDEForm.setGetDraftPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEForm.setGetDraftPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GetPSDEAction(PSDEForm pSDEForm, PSDEAction pSDEAction) throws Exception {
        pSDEForm.setGetPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEForm.setGetPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_RemovePSDEAction(PSDEForm pSDEForm, PSDEAction pSDEAction) throws Exception {
        pSDEForm.setRemovePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEForm.setRemovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UpdatePSDEAction(PSDEForm pSDEForm, PSDEAction pSDEAction) throws Exception {
        pSDEForm.setUpdatePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEForm.setUpdatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_User2PSDEAction(PSDEForm pSDEForm, PSDEAction pSDEAction) throws Exception {
        pSDEForm.setUser2PSDEActionId(pSDEAction.getPSDEActionId());
        pSDEForm.setUser2PSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UserPSDEAction(PSDEForm pSDEForm, PSDEAction pSDEAction) throws Exception {
        pSDEForm.setUserPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEForm.setUserPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEFInputTipSet(PSDEForm pSDEForm, PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        pSDEForm.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
        pSDEForm.setPSDEFInputTipSetName(pSDEFInputTipSet.getPSDEFInputTipSetName());
    }

    protected void onFillParentInfo_PSDynaDEForm(PSDEForm pSDEForm, PSDynaDEForm pSDynaDEForm) throws Exception {
        pSDEForm.setPSDynaDEFormId(pSDynaDEForm.getPSDynaDEFormId());
        pSDEForm.setPSDynaDEFormName(pSDynaDEForm.getPSDynaDEName());
    }

    protected void onFillParentInfo_PSDynaInst(PSDEForm pSDEForm, PSDynaInst pSDynaInst) throws Exception {
        pSDEForm.setPSDynaInstId(pSDynaInst.getPSDynaInstId());
        pSDEForm.setPSDynaInstName(pSDynaInst.getPSDynaInstName());
    }

    protected void onFillParentInfo_PSPF(PSDEForm pSDEForm, PSPF pSPF) throws Exception {
        pSDEForm.setPSPFId(pSPF.getPSPFId());
        pSDEForm.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillParentInfo_PSSysCounter(PSDEForm pSDEForm, PSSysCounter pSSysCounter) throws Exception {
        pSDEForm.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSDEForm.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_NavBarPSSysCss(PSDEForm pSDEForm, PSSysCss pSSysCss) throws Exception {
        pSDEForm.setNavBarPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEForm.setNavBarPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEForm pSDEForm, PSSysCss pSSysCss) throws Exception {
        pSDEForm.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEForm.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEForm pSDEForm, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEForm.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEForm.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEForm pSDEForm, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEForm.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEForm.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEForm pSDEForm, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEForm.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEForm.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSDEForm pSDEForm, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSDEForm.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSDEForm.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillParentInfo_PSWFDE(PSDEForm pSDEForm, PSWFDE pSWFDE) throws Exception {
        pSDEForm.setPSWFDEId(pSWFDE.getPSWFDEId());
        pSDEForm.setPSWFDEName(pSWFDE.getPSWFDEName());
        pSDEForm.setPSWFId(pSWFDE.getPSWFId());
        if (pSWFDE.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEForm, pSWFDE.getPSDE());
        }
    }

    protected void onFillEntityFullInfo(PSDEForm pSDEForm, boolean bl) throws Exception {
        if (bl) {
            if (pSDEForm.getDynaSysRefMode() == null) {
                pSDEForm.setDynaSysRefMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEForm.getMobFlag() == null) {
                pSDEForm.setMobFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEForm, bl);
        this.onFillEntityFullInfo_PSACHandler(pSDEForm, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSDEForm, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSDEForm, bl);
        this.onFillEntityFullInfo_PSDE(pSDEForm, bl);
        this.onFillEntityFullInfo_CopyPSDEAction(pSDEForm, bl);
        this.onFillEntityFullInfo_CreatePSDEAction(pSDEForm, bl);
        this.onFillEntityFullInfo_GetDraftPSDEAction(pSDEForm, bl);
        this.onFillEntityFullInfo_GetPSDEAction(pSDEForm, bl);
        this.onFillEntityFullInfo_RemovePSDEAction(pSDEForm, bl);
        this.onFillEntityFullInfo_UpdatePSDEAction(pSDEForm, bl);
        this.onFillEntityFullInfo_User2PSDEAction(pSDEForm, bl);
        this.onFillEntityFullInfo_UserPSDEAction(pSDEForm, bl);
        this.onFillEntityFullInfo_PSDEFInputTipSet(pSDEForm, bl);
        this.onFillEntityFullInfo_PSDynaDEForm(pSDEForm, bl);
        this.onFillEntityFullInfo_PSDynaInst(pSDEForm, bl);
        this.onFillEntityFullInfo_PSPF(pSDEForm, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSDEForm, bl);
        this.onFillEntityFullInfo_NavBarPSSysCss(pSDEForm, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEForm, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEForm, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEForm, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEForm, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSDEForm, bl);
        this.onFillEntityFullInfo_PSWFDE(pSDEForm, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDEForm pSDEForm, boolean bl) throws Exception {
        if (pSDEForm.isPSDEIdDirty()) {
            if (pSDEForm.getPSDEId() != null) {
                if (pSDEForm.getPSDEId() == null || pSDEForm.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEForm.getPSDE();
                    pSDEForm.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEForm.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CopyPSDEAction(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CreatePSDEAction(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GetDraftPSDEAction(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GetPSDEAction(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemovePSDEAction(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UpdatePSDEAction(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_User2PSDEAction(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UserPSDEAction(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFInputTipSet(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaDEForm(PSDEForm pSDEForm, boolean bl) throws Exception {
        if (pSDEForm.isPSDynaDEFormIdDirty()) {
            if (pSDEForm.getPSDynaDEFormId() != null) {
                if (pSDEForm.getPSDynaDEFormId() == null || pSDEForm.getPSDynaDEFormName() == null) {
                    PSDynaDEForm pSDynaDEForm = pSDEForm.getPSDynaDEForm();
                    pSDEForm.setPSDynaDEFormName(pSDynaDEForm.getPSDynaDEName());
                }
            } else {
                pSDEForm.setPSDynaDEFormName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDynaInst(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSDEForm pSDEForm, boolean bl) throws Exception {
        if (pSDEForm.isPSPFIdDirty()) {
            if (pSDEForm.getPSPFId() != null) {
                if (pSDEForm.getPSPFId() == null || pSDEForm.getPSPFName() == null) {
                    PSPF pSPF = pSDEForm.getPSPF();
                    pSDEForm.setPSPFName(pSPF.getPSPFName());
                }
            } else {
                pSDEForm.setPSPFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NavBarPSSysCss(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEForm pSDEForm, boolean bl) throws Exception {
        if (pSDEForm.isPSSysDynaModelIdDirty()) {
            if (pSDEForm.getPSSysDynaModelId() != null) {
                if (pSDEForm.getPSSysDynaModelId() == null || pSDEForm.getPSSysDynaModelName() == null) {
                    PSSysDynaModel pSSysDynaModel = pSDEForm.getPSSysDynaModel();
                    pSDEForm.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
                }
            } else {
                pSDEForm.setPSSysDynaModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFDE(PSDEForm pSDEForm, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEForm pSDEForm, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEForm, bl);
    }

    public ArrayList<PSDEForm> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSACHANDLERID", (Object)pSACHandlerBase.getPSACHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSACHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSACHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEForm> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEForm> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEForm> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCopyPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCopyPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("COPYPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCopyPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCopyPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CREATEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCreatePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCreatePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGetDraftPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGetDraftPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GETDRAFTPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGetDraftPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGetDraftPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByGetPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GETPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGetPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGetPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REMOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRemovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRemovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPDATEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUpdatePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUpdatePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUser2PSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUser2PSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USER2PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUser2PSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUser2PSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByUserPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUserPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByUserPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUserPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByUserPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUserPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUserPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByPSDEFInputTipSet(PSDEFInputTipSetBase pSDEFInputTipSetBase) throws Exception {
        return this.selectByPSDEFInputTipSet(pSDEFInputTipSetBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSDEFInputTipSet(PSDEFInputTipSetBase pSDEFInputTipSetBase, String string) throws Exception {
        return this.selectByPSDEFInputTipSet(pSDEFInputTipSetBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSDEFInputTipSet(PSDEFInputTipSetBase pSDEFInputTipSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFINPUTTIPSETID", (Object)pSDEFInputTipSetBase.getPSDEFInputTipSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFInputTipSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFInputTipSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByPSDynaDEForm(PSDynaDEFormBase pSDynaDEFormBase) throws Exception {
        return this.selectByPSDynaDEForm(pSDynaDEFormBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSDynaDEForm(PSDynaDEFormBase pSDynaDEFormBase, String string) throws Exception {
        return this.selectByPSDynaDEForm(pSDynaDEFormBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSDynaDEForm(PSDynaDEFormBase pSDynaDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNADEFORMID", (Object)pSDynaDEFormBase.getPSDynaDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAINSTID", (Object)pSDynaInstBase.getPSDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCOUNTERID", (Object)pSSysCounterBase.getPSSysCounterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCounterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCounterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByNavBarPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByNavBarPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByNavBarPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByNavBarPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByNavBarPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NAVBARPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNavBarPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNavBarPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEForm> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEForm> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEForm> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEForm> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEForm> selectByPSWFDE(PSWFDEBase pSWFDEBase) throws Exception {
        return this.selectByPSWFDE(pSWFDEBase, "", -1);
    }

    public ArrayList<PSDEForm> selectByPSWFDE(PSWFDEBase pSWFDEBase, String string) throws Exception {
        return this.selectByPSWFDE(pSWFDEBase, string, -1);
    }

    public ArrayList<PSDEForm> selectByPSWFDE(PSWFDEBase pSWFDEBase, String string, int n) throws Exception {
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

    public void testRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSACHandlerId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSDEFormServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSDEFormServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSCtrlLogicGroupId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEFormServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEFormServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSCTRLMSG_PSCTRLMSGID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSCtrlMsg), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSCtrlMsgId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEFormServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEFormServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSDEId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEFormServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEFormServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    public void resetCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByCopyPSDEAction(pSDEAction);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setCopyPSDEActionId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByCopyPSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.internalRemoveByCopyPSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.onAfterRemoveByCopyPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByCopyPSDEAction(pSDEAction);
        this.onBeforeRemoveByCopyPSDEAction(pSDEAction, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByCopyPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCopyPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCopyPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByCreatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSDEACTION_CREATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setCreatePSDEActionId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByCreatePSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.internalRemoveByCreatePSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.onAfterRemoveByCreatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        this.onBeforeRemoveByCreatePSDEAction(pSDEAction, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByCreatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByGetDraftPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSDEACTION_GETDRAFTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByGetDraftPSDEAction(pSDEAction);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setGetDraftPSDEActionId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByGetDraftPSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.internalRemoveByGetDraftPSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.onAfterRemoveByGetDraftPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByGetDraftPSDEAction(pSDEAction);
        this.onBeforeRemoveByGetDraftPSDEAction(pSDEAction, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByGetDraftPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGetDraftPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGetDraftPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByGetPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSDEACTION_GETPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByGetPSDEAction(pSDEAction);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setGetPSDEActionId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByGetPSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.internalRemoveByGetPSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.onAfterRemoveByGetPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByGetPSDEAction(pSDEAction);
        this.onBeforeRemoveByGetPSDEAction(pSDEAction, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByGetPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByRemovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSDEACTION_REMOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setRemovePSDEActionId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByRemovePSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.internalRemoveByRemovePSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.onAfterRemoveByRemovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        this.onBeforeRemoveByRemovePSDEAction(pSDEAction, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByRemovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByUpdatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSDEACTION_UPDATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setUpdatePSDEActionId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByUpdatePSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.internalRemoveByUpdatePSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.onAfterRemoveByUpdatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        this.onBeforeRemoveByUpdatePSDEAction(pSDEAction, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByUpdatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    public void resetUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByUser2PSDEAction(pSDEAction);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setUser2PSDEActionId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByUser2PSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.internalRemoveByUser2PSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.onAfterRemoveByUser2PSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByUser2PSDEAction(pSDEAction);
        this.onBeforeRemoveByUser2PSDEAction(pSDEAction, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByUser2PSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUser2PSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUser2PSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    public void resetUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByUserPSDEAction(pSDEAction);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setUserPSDEActionId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByUserPSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.internalRemoveByUserPSDEAction(pSDEAction2);
                PSDEFormServiceBase.this.onAfterRemoveByUserPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByUserPSDEAction(pSDEAction);
        this.onBeforeRemoveByUserPSDEAction(pSDEAction, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByUserPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUserPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSDEFInputTipSet(pSDEFInputTipSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFINPUTTIPSET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFInputTipSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSDEFINPUTTIPSET_PSDEFINPUTTIPSETID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSDEFInputTipSet), arrayList.get(0)));
        }
    }

    public void resetPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSDEFInputTipSet(pSDEFInputTipSet);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSDEFInputTipSetId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        final PSDEFInputTipSet pSDEFInputTipSet2 = pSDEFInputTipSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSDEFInputTipSet(pSDEFInputTipSet2);
                PSDEFormServiceBase.this.internalRemoveByPSDEFInputTipSet(pSDEFInputTipSet2);
                PSDEFormServiceBase.this.onAfterRemoveByPSDEFInputTipSet(pSDEFInputTipSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
    }

    protected void internalRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSDEFInputTipSet(pSDEFInputTipSet);
        this.onBeforeRemoveByPSDEFInputTipSet(pSDEFInputTipSet, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSDEFInputTipSet(pSDEFInputTipSet, arrayList);
    }

    protected void onAfterRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSDynaDEForm(pSDynaDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNADEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSDYNADEFORM_PSDYNADEFORMID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSDynaDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSDynaDEForm(pSDynaDEForm);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSDynaDEFormId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        final PSDynaDEForm pSDynaDEForm2 = pSDynaDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSDynaDEForm(pSDynaDEForm2);
                PSDEFormServiceBase.this.internalRemoveByPSDynaDEForm(pSDynaDEForm2);
                PSDEFormServiceBase.this.onAfterRemoveByPSDynaDEForm(pSDynaDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
    }

    protected void internalRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSDynaDEForm(pSDynaDEForm);
        this.onBeforeRemoveByPSDynaDEForm(pSDynaDEForm, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSDynaDEForm(pSDynaDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSDynaInst(pSDynaInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSDYNAINST_PSDYNAINSTID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSDynaInst), arrayList.get(0)));
        }
    }

    public void resetPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSDynaInst(pSDynaInst);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSDynaInstId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        final PSDynaInst pSDynaInst2 = pSDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSDynaInst(pSDynaInst2);
                PSDEFormServiceBase.this.internalRemoveByPSDynaInst(pSDynaInst2);
                PSDEFormServiceBase.this.onAfterRemoveByPSDynaInst(pSDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void internalRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSDynaInst(pSDynaInst);
        this.onBeforeRemoveByPSDynaInst(pSDynaInst, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSDynaInst(pSDynaInst, arrayList);
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSPF(pSPF);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSPFId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSDEFormServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSDEFormServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSSysCounterId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSDEFormServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSDEFormServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByNavBarPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSSYSCSS_NAVBARPSSYSCSSID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByNavBarPSSysCss(pSSysCss);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setNavBarPSSysCssId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByNavBarPSSysCss(pSSysCss2);
                PSDEFormServiceBase.this.internalRemoveByNavBarPSSysCss(pSSysCss2);
                PSDEFormServiceBase.this.onAfterRemoveByNavBarPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByNavBarPSSysCss(pSSysCss);
        this.onBeforeRemoveByNavBarPSSysCss(pSSysCss, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByNavBarPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByNavBarPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNavBarPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSSysCssId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEFormServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEFormServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSSysDynaModelId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEFormServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEFormServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSSysPFPluginId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEFormServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEFormServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSSysReqItemId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEFormServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEFormServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSViewMsgGroupId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEFormServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEFormServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    public void testRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSWFDE(pSWFDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWFDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORM_PSWFDE_PSWFDEID", "", iDataEntityModel.getName(), "PSDEFORM", iDataEntityModel.getDataInfo((IEntity)pSWFDE), arrayList.get(0)));
        }
    }

    public void resetPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSWFDE(pSWFDE);
        for (PSDEForm pSDEForm : arrayList) {
            PSDEForm pSDEForm2 = (PSDEForm)this.getDEModel().createEntity();
            pSDEForm2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEForm2.setPSWFDEId(null);
            this.update(pSDEForm2);
        }
    }

    public void removeByPSWFDE(PSWFDE pSWFDE) throws Exception {
        final PSWFDE pSWFDE2 = pSWFDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormServiceBase.this.onBeforeRemoveByPSWFDE(pSWFDE2);
                PSDEFormServiceBase.this.internalRemoveByPSWFDE(pSWFDE2);
                PSDEFormServiceBase.this.onAfterRemoveByPSWFDE(pSWFDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void internalRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDEForm> arrayList = this.selectByPSWFDE(pSWFDE);
        this.onBeforeRemoveByPSWFDE(pSWFDE, arrayList);
        for (PSDEForm pSDEForm : arrayList) {
            this.remove((IEntity)pSDEForm);
        }
        this.onAfterRemoveByPSWFDE(pSWFDE, arrayList);
    }

    protected void onAfterRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void onBeforeRemoveByPSWFDE(PSWFDE pSWFDE, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFDE(PSWFDE pSWFDE, ArrayList<PSDEForm> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEForm pSDEForm) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).removeByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).removeByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIUpdateServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        ((PSDEFIUpdateServiceBase)pSCoreSysServiceBase).removeByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIVRServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        ((PSDEFIVRServiceBase)pSCoreSysServiceBase).removeByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByMDPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).removeByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).removeByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormRFServiceBase)pSCoreSysServiceBase).testRemoveByMajorPSDEForm(pSDEForm);
        ((PSDEFormRFServiceBase)pSCoreSysServiceBase).removeByMajorPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormRFServiceBase)pSCoreSysServiceBase).testRemoveByMinorPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFValueRuleServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateServiceBase)pSCoreSysServiceBase).testRemoveByMobPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateServiceBase)pSCoreSysServiceBase).testRemoveByMobQuickPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateServiceBase)pSCoreSysServiceBase).testRemoveByMobUtilPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateServiceBase)pSCoreSysServiceBase).testRemoveByQuickPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateServiceBase)pSCoreSysServiceBase).testRemoveByUtilPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).testRemoveByMobPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDynaDEFormInstService)ServiceGlobal.getService(PSDynaDEFormInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaDEFormInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDynaDEFormTemplService)ServiceGlobal.getService(PSDynaDEFormTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaDEFormTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDynaDEFormService)ServiceGlobal.getService(PSDynaDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDESearchForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).testRemoveByMobPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByMobPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByMobUtil2PSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByMobUtil3PSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByMobUtil4PSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByMobUtil5PSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByMobUtilPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByUtil2PSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByUtil3PSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByUtil4PSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByUtil5PSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByUtilPSDEForm(pSDEForm);
        super.onBeforeRemove(pSDEForm);
    }

    protected void onBeforeRemoveTemp(PSDEForm pSDEForm) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIVRServiceBase)pSCoreSysServiceBase).removeTempByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).removeTempByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).removeTempByPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormRFServiceBase)pSCoreSysServiceBase).removeTempByMajorPSDEForm(pSDEForm);
        pSCoreSysServiceBase = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIUpdateServiceBase)pSCoreSysServiceBase).removeTempByPSDEForm(pSDEForm);
        super.onBeforeRemoveTemp((IEntity)pSDEForm);
    }

    protected void getRelatedDataTempMajor(PSDEForm pSDEForm) throws Exception {
        this.getRelatedDataTempMajor_PSDEFIUpdate(pSDEForm);
        this.getRelatedDataTempMajor_PSDEFormRF(pSDEForm);
        this.getRelatedDataTempMajor_PSDEFormDetail(pSDEForm);
        this.getRelatedDataTempMajor_PSDEFDLogic(pSDEForm);
        this.getRelatedDataTempMajor_PSDEFIUDetail(pSDEForm);
        this.getRelatedDataTempMajor_PSDEFIVR(pSDEForm);
        this.getRelatedDataTempMajor_PSDEFormLogic(pSDEForm);
        super.getRelatedDataTempMajor((IEntity)pSDEForm);
    }

    protected void getRelatedDataTempMajor_PSDEFIUpdate(PSDEForm pSDEForm) throws Exception {
        PSDEFIUpdateService pSDEFIUpdateService = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIUpdate> arrayList = null;
        String string = pSDEForm.getPSDEFormId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFIUpdateService.selectByPSDEForm(pSDEForm) : pSDEFIUpdateService.selectTempByPSDEForm(pSDEForm);
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            pSDEFIUpdateService.getTempMajor(pSDEFIUpdate);
        }
    }

    protected void getRelatedDataTempMajor_PSDEFormRF(PSDEForm pSDEForm) throws Exception {
        PSDEFormRFService pSDEFormRFService = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormRF> arrayList = null;
        String string = pSDEForm.getPSDEFormId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFormRFService.selectByMajorPSDEForm(pSDEForm) : pSDEFormRFService.selectTempByMajorPSDEForm(pSDEForm);
        for (PSDEFormRF pSDEFormRF : arrayList) {
            pSDEFormRFService.getTempMajor(pSDEFormRF);
        }
    }

    protected void getRelatedDataTempMajor_PSDEFormDetail(PSDEForm pSDEForm) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormDetail> arrayList = null;
        String string = pSDEForm.getPSDEFormId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFormDetailService.selectByPSDEForm(pSDEForm) : pSDEFormDetailService.selectTempByPSDEForm(pSDEForm);
        PSDEFormServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEFORMDETAILID", (String)"PPSDEFORMDETAILID");
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            pSDEFormDetailService.getTempMajor(pSDEFormDetail);
        }
    }

    protected void getRelatedDataTempMajor_PSDEFDLogic(PSDEForm pSDEForm) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFDLogic> arrayList = null;
        String string = pSDEForm.getPSDEFormId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFDLogicService.selectByPSDEForm(pSDEForm) : pSDEFDLogicService.selectTempByPSDEForm(pSDEForm);
        PSDEFormServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEFDLOGICID", (String)"PPSDEFDLOGICID");
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            pSDEFDLogicService.getTempMajor(pSDEFDLogic);
        }
    }

    protected void getRelatedDataTempMajor_PSDEFIUDetail(PSDEForm pSDEForm) throws Exception {
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIUDetail> arrayList = null;
        String string = pSDEForm.getPSDEFormId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFIUDetailService.selectByPSDEForm(pSDEForm) : pSDEFIUDetailService.selectTempByPSDEForm(pSDEForm);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            pSDEFIUDetailService.getTempMajor(pSDEFIUDetail);
        }
    }

    protected void getRelatedDataTempMajor_PSDEFIVR(PSDEForm pSDEForm) throws Exception {
        PSDEFIVRService pSDEFIVRService = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIVR> arrayList = null;
        String string = pSDEForm.getPSDEFormId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFIVRService.selectByPSDEForm(pSDEForm) : pSDEFIVRService.selectTempByPSDEForm(pSDEForm);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            pSDEFIVRService.getTempMajor(pSDEFIVR);
        }
    }

    protected void getRelatedDataTempMajor_PSDEFormLogic(PSDEForm pSDEForm) throws Exception {
        PSDEFormLogicService pSDEFormLogicService = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormLogic> arrayList = null;
        String string = pSDEForm.getPSDEFormId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFormLogicService.selectByPSDEForm(pSDEForm) : pSDEFormLogicService.selectTempByPSDEForm(pSDEForm);
        for (PSDEFormLogic pSDEFormLogic : arrayList) {
            pSDEFormLogicService.getTempMajor(pSDEFormLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEForm pSDEForm, PSDEForm pSDEForm2) throws Exception {
        ArrayList<PSDEFormLogic> arrayList = this.updateRelatedDataTempMajor_removePSDEFormLogic(pSDEForm, pSDEForm2);
        ArrayList<PSDEFIVR> arrayList2 = this.updateRelatedDataTempMajor_removePSDEFIVR(pSDEForm, pSDEForm2);
        ArrayList<PSDEFIUDetail> arrayList3 = this.updateRelatedDataTempMajor_removePSDEFIUDetail(pSDEForm, pSDEForm2);
        ArrayList<PSDEFDLogic> arrayList4 = this.updateRelatedDataTempMajor_removePSDEFDLogic(pSDEForm, pSDEForm2);
        ArrayList<PSDEFormDetail> arrayList5 = this.updateRelatedDataTempMajor_removePSDEFormDetail(pSDEForm, pSDEForm2);
        ArrayList<PSDEFormRF> arrayList6 = this.updateRelatedDataTempMajor_removePSDEFormRF(pSDEForm, pSDEForm2);
        ArrayList<PSDEFIUpdate> arrayList7 = this.updateRelatedDataTempMajor_removePSDEFIUpdate(pSDEForm, pSDEForm2);
        this.updateRelatedDataTempMajor_updatePSDEFIUpdate(pSDEForm, pSDEForm2, arrayList7);
        this.updateRelatedDataTempMajor_updatePSDEFormRF(pSDEForm, pSDEForm2, arrayList6);
        this.updateRelatedDataTempMajor_updatePSDEFormDetail(pSDEForm, pSDEForm2, arrayList5);
        this.updateRelatedDataTempMajor_updatePSDEFDLogic(pSDEForm, pSDEForm2, arrayList4);
        this.updateRelatedDataTempMajor_updatePSDEFIUDetail(pSDEForm, pSDEForm2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSDEFIVR(pSDEForm, pSDEForm2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEFormLogic(pSDEForm, pSDEForm2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDEForm, (IEntity)pSDEForm2);
    }

    protected ArrayList<PSDEFIUpdate> updateRelatedDataTempMajor_removePSDEFIUpdate(PSDEForm pSDEForm, PSDEForm pSDEForm2) throws Exception {
        PSDEFIUpdateService pSDEFIUpdateService = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIUpdate> arrayList = pSDEFIUpdateService.selectTempByPSDEForm(pSDEForm);
        ArrayList<PSDEFIUpdate> arrayList2 = pSDEFIUpdateService.selectByPSDEForm(pSDEForm2);
        HashMap<String, PSDEFIUpdate> hashMap = new HashMap<String, PSDEFIUpdate>();
        for (PSDEFIUpdate pSDEFIUpdate : arrayList2) {
            hashMap.put(pSDEFIUpdate.getPSDEFIUpdateId(), pSDEFIUpdate);
        }
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            Object object = pSDEFIUpdate.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFIUpdate pSDEFIUpdate : hashMap.values()) {
            pSDEFIUpdateService.remove((IEntity)pSDEFIUpdate);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFIUpdate(PSDEForm pSDEForm, PSDEForm pSDEForm2, ArrayList<PSDEFIUpdate> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFIUpdateService pSDEFIUpdateService = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            pSDEFIUpdateService.updateTempMajor(pSDEFIUpdate);
        }
    }

    protected ArrayList<PSDEFormRF> updateRelatedDataTempMajor_removePSDEFormRF(PSDEForm pSDEForm, PSDEForm pSDEForm2) throws Exception {
        PSDEFormRFService pSDEFormRFService = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormRF> arrayList = pSDEFormRFService.selectTempByMajorPSDEForm(pSDEForm);
        ArrayList<PSDEFormRF> arrayList2 = pSDEFormRFService.selectByMajorPSDEForm(pSDEForm2);
        HashMap<String, PSDEFormRF> hashMap = new HashMap<String, PSDEFormRF>();
        for (PSDEFormRF pSDEFormRF : arrayList2) {
            hashMap.put(pSDEFormRF.getPSDEFormRFId(), pSDEFormRF);
        }
        for (PSDEFormRF pSDEFormRF : arrayList) {
            Object object = pSDEFormRF.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFormRF pSDEFormRF : hashMap.values()) {
            pSDEFormRFService.remove((IEntity)pSDEFormRF);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFormRF(PSDEForm pSDEForm, PSDEForm pSDEForm2, ArrayList<PSDEFormRF> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFormRFService pSDEFormRFService = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFormRF pSDEFormRF : arrayList) {
            pSDEFormRFService.updateTempMajor(pSDEFormRF);
        }
    }

    protected ArrayList<PSDEFormDetail> updateRelatedDataTempMajor_removePSDEFormDetail(PSDEForm pSDEForm, PSDEForm pSDEForm2) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.selectTempByPSDEForm(pSDEForm);
        ArrayList<PSDEFormDetail> arrayList2 = pSDEFormDetailService.selectByPSDEForm(pSDEForm2);
        HashMap<String, PSDEFormDetail> hashMap = new HashMap<String, PSDEFormDetail>();
        for (PSDEFormDetail pSDEFormDetail : arrayList2) {
            hashMap.put(pSDEFormDetail.getPSDEFormDetailId(), pSDEFormDetail);
        }
        PSDEFormServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEFORMDETAILID", (String)"PPSDEFORMDETAILID");
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            Object object = pSDEFormDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFormDetail pSDEFormDetail : hashMap.values()) {
            pSDEFormDetailService.remove((IEntity)pSDEFormDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFormDetail(PSDEForm pSDEForm, PSDEForm pSDEForm2, ArrayList<PSDEFormDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            pSDEFormDetailService.updateTempMajor(pSDEFormDetail);
        }
    }

    protected ArrayList<PSDEFDLogic> updateRelatedDataTempMajor_removePSDEFDLogic(PSDEForm pSDEForm, PSDEForm pSDEForm2) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFDLogic> arrayList = pSDEFDLogicService.selectTempByPSDEForm(pSDEForm);
        ArrayList<PSDEFDLogic> arrayList2 = pSDEFDLogicService.selectByPSDEForm(pSDEForm2);
        HashMap<String, PSDEFDLogic> hashMap = new HashMap<String, PSDEFDLogic>();
        for (PSDEFDLogic pSDEFDLogic : arrayList2) {
            hashMap.put(pSDEFDLogic.getPSDEFDLogicId(), pSDEFDLogic);
        }
        PSDEFormServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEFDLOGICID", (String)"PPSDEFDLOGICID");
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            Object object = pSDEFDLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFDLogic pSDEFDLogic : hashMap.values()) {
            pSDEFDLogicService.remove((IEntity)pSDEFDLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFDLogic(PSDEForm pSDEForm, PSDEForm pSDEForm2, ArrayList<PSDEFDLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            pSDEFDLogicService.updateTempMajor(pSDEFDLogic);
        }
    }

    protected ArrayList<PSDEFIUDetail> updateRelatedDataTempMajor_removePSDEFIUDetail(PSDEForm pSDEForm, PSDEForm pSDEForm2) throws Exception {
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIUDetail> arrayList = pSDEFIUDetailService.selectTempByPSDEForm(pSDEForm);
        ArrayList<PSDEFIUDetail> arrayList2 = pSDEFIUDetailService.selectByPSDEForm(pSDEForm2);
        HashMap<String, PSDEFIUDetail> hashMap = new HashMap<String, PSDEFIUDetail>();
        for (PSDEFIUDetail pSDEFIUDetail : arrayList2) {
            hashMap.put(pSDEFIUDetail.getPSDEFIUDetailId(), pSDEFIUDetail);
        }
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            Object object = pSDEFIUDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFIUDetail pSDEFIUDetail : hashMap.values()) {
            pSDEFIUDetailService.remove((IEntity)pSDEFIUDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFIUDetail(PSDEForm pSDEForm, PSDEForm pSDEForm2, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            pSDEFIUDetailService.updateTempMajor(pSDEFIUDetail);
        }
    }

    protected ArrayList<PSDEFIVR> updateRelatedDataTempMajor_removePSDEFIVR(PSDEForm pSDEForm, PSDEForm pSDEForm2) throws Exception {
        PSDEFIVRService pSDEFIVRService = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIVR> arrayList = pSDEFIVRService.selectTempByPSDEForm(pSDEForm);
        ArrayList<PSDEFIVR> arrayList2 = pSDEFIVRService.selectByPSDEForm(pSDEForm2);
        HashMap<String, PSDEFIVR> hashMap = new HashMap<String, PSDEFIVR>();
        for (PSDEFIVR pSDEFIVR : arrayList2) {
            hashMap.put(pSDEFIVR.getPSDEFIVRId(), pSDEFIVR);
        }
        for (PSDEFIVR pSDEFIVR : arrayList) {
            Object object = pSDEFIVR.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFIVR pSDEFIVR : hashMap.values()) {
            pSDEFIVRService.remove((IEntity)pSDEFIVR);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFIVR(PSDEForm pSDEForm, PSDEForm pSDEForm2, ArrayList<PSDEFIVR> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFIVRService pSDEFIVRService = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFIVR pSDEFIVR : arrayList) {
            pSDEFIVRService.updateTempMajor(pSDEFIVR);
        }
    }

    protected ArrayList<PSDEFormLogic> updateRelatedDataTempMajor_removePSDEFormLogic(PSDEForm pSDEForm, PSDEForm pSDEForm2) throws Exception {
        PSDEFormLogicService pSDEFormLogicService = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormLogic> arrayList = pSDEFormLogicService.selectTempByPSDEForm(pSDEForm);
        ArrayList<PSDEFormLogic> arrayList2 = pSDEFormLogicService.selectByPSDEForm(pSDEForm2);
        HashMap<String, PSDEFormLogic> hashMap = new HashMap<String, PSDEFormLogic>();
        for (PSDEFormLogic pSDEFormLogic : arrayList2) {
            hashMap.put(pSDEFormLogic.getPSDEFormLogicId(), pSDEFormLogic);
        }
        for (PSDEFormLogic pSDEFormLogic : arrayList) {
            Object object = pSDEFormLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFormLogic pSDEFormLogic : hashMap.values()) {
            pSDEFormLogicService.remove((IEntity)pSDEFormLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFormLogic(PSDEForm pSDEForm, PSDEForm pSDEForm2, ArrayList<PSDEFormLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFormLogicService pSDEFormLogicService = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFormLogic pSDEFormLogic : arrayList) {
            pSDEFormLogicService.updateTempMajor(pSDEFormLogic);
        }
    }

    protected void replaceParentInfo(PSDEForm pSDEForm, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEForm, cloneSession);
        if (pSDEForm.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEForm.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSDEForm, (PSACHandler)iEntity);
        }
        if (pSDEForm.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSDEForm.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEForm, (PSCtrlLogicGroup)iEntity);
        }
        if (pSDEForm.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSDEForm.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSDEForm, (PSCtrlMsg)iEntity);
        }
        if (pSDEForm.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEForm.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEForm, (PSDataEntity)iEntity);
        }
        if (pSDEForm.getCopyPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEForm.getCopyPSDEActionId())) != null) {
            this.onFillParentInfo_CopyPSDEAction(pSDEForm, (PSDEAction)iEntity);
        }
        if (pSDEForm.getCreatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEForm.getCreatePSDEActionId())) != null) {
            this.onFillParentInfo_CreatePSDEAction(pSDEForm, (PSDEAction)iEntity);
        }
        if (pSDEForm.getGetDraftPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEForm.getGetDraftPSDEActionId())) != null) {
            this.onFillParentInfo_GetDraftPSDEAction(pSDEForm, (PSDEAction)iEntity);
        }
        if (pSDEForm.getGetPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEForm.getGetPSDEActionId())) != null) {
            this.onFillParentInfo_GetPSDEAction(pSDEForm, (PSDEAction)iEntity);
        }
        if (pSDEForm.getRemovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEForm.getRemovePSDEActionId())) != null) {
            this.onFillParentInfo_RemovePSDEAction(pSDEForm, (PSDEAction)iEntity);
        }
        if (pSDEForm.getUpdatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEForm.getUpdatePSDEActionId())) != null) {
            this.onFillParentInfo_UpdatePSDEAction(pSDEForm, (PSDEAction)iEntity);
        }
        if (pSDEForm.getUser2PSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEForm.getUser2PSDEActionId())) != null) {
            this.onFillParentInfo_User2PSDEAction(pSDEForm, (PSDEAction)iEntity);
        }
        if (pSDEForm.getUserPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEForm.getUserPSDEActionId())) != null) {
            this.onFillParentInfo_UserPSDEAction(pSDEForm, (PSDEAction)iEntity);
        }
        if (pSDEForm.getPSDEFInputTipSetId() != null && (iEntity = cloneSession.getEntity("PSDEFINPUTTIPSET", (Object)pSDEForm.getPSDEFInputTipSetId())) != null) {
            this.onFillParentInfo_PSDEFInputTipSet(pSDEForm, (PSDEFInputTipSet)iEntity);
        }
        if (pSDEForm.getPSDynaDEFormId() != null && (iEntity = cloneSession.getEntity("PSDYNADEFORM", (Object)pSDEForm.getPSDynaDEFormId())) != null) {
            this.onFillParentInfo_PSDynaDEForm(pSDEForm, (PSDynaDEForm)iEntity);
        }
        if (pSDEForm.getPSDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDYNAINST", (Object)pSDEForm.getPSDynaInstId())) != null) {
            this.onFillParentInfo_PSDynaInst(pSDEForm, (PSDynaInst)iEntity);
        }
        if (pSDEForm.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSDEForm.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSDEForm, (PSPF)iEntity);
        }
        if (pSDEForm.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSDEForm.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSDEForm, (PSSysCounter)iEntity);
        }
        if (pSDEForm.getNavBarPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEForm.getNavBarPSSysCssId())) != null) {
            this.onFillParentInfo_NavBarPSSysCss(pSDEForm, (PSSysCss)iEntity);
        }
        if (pSDEForm.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEForm.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEForm, (PSSysCss)iEntity);
        }
        if (pSDEForm.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEForm.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEForm, (PSSysDynaModel)iEntity);
        }
        if (pSDEForm.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEForm.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEForm, (PSSysPFPlugin)iEntity);
        }
        if (pSDEForm.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEForm.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEForm, (PSSysReqItem)iEntity);
        }
        if (pSDEForm.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSDEForm.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSDEForm, (PSViewMsgGroup)iEntity);
        }
        if (pSDEForm.getPSWFDEId() != null && (iEntity = cloneSession.getEntity("PSWFDE", (Object)pSDEForm.getPSWFDEId())) != null) {
            this.onFillParentInfo_PSWFDE(pSDEForm, (PSWFDE)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEForm pSDEForm, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEForm, bl);
        pSDEForm.resetCodeName();
        pSDEForm.resetFormTag();
        pSDEForm.resetFormTag2();
        pSDEForm.resetFormTag3();
        pSDEForm.resetFormTag4();
    }

    protected void onCheckEntity(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BusyIndicator(bl, pSDEForm, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CopyPSDEActionId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEActionId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlColSpan(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataType(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailStyle(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaSysRefMode(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAdvSearch(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAutoSave(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCustomized(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableFilterSave(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableItemFilter(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableItemPriv(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormItemStyle(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormModel(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormNavBar(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormSN(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormStyle(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormTag(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormTag2(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormTag3(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormTag4(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormType(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormWidth(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncMode(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetDraftPSDEActionId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetPSDEActionId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InfoFormFlag(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelColSpan(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelColSpan2(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelWidth(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutMode(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobFlag(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavBarHeight(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavBarPos(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavBarPSSysCssId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavBarStyle(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavBarWidth(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PDVTParam(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFInputTipSetId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormName(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormInstId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormInstName(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormName(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFName(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelName(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFDEId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEActionId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchBtnPos(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchBtnStyle(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowTabHeader(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TabHeaderPos(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEActionId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEActionId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEActionId(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEForm, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEForm, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isBusyIndicatorDirty() : !pSDEForm.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDEForm.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isCodeNameDirty() && !bl2 : !pSDEForm.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEForm.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEForm, bl2, bl3);
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEFormDEModel(), "CODENAME", string3, pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_CopyPSDEActionId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isCopyPSDEActionIdDirty() : !pSDEForm.isCopyPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEForm.getCopyPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CopyPSDEActionId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COPYPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreatePSDEActionId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isCreatePSDEActionIdDirty() : !pSDEForm.isCreatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEForm.getCreatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEActionId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlColSpan(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isCtrlColSpanDirty() : !pSDEForm.isCtrlColSpanDirty()) {
            return null;
        }
        Integer n = pSDEForm.getCtrlColSpan();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlColSpan_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLCOLSPAN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataType(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isDataTypeDirty() : !pSDEForm.isDataTypeDirty()) {
            return null;
        }
        String string = pSDEForm.getDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataType_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailStyle(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isDetailStyleDirty() : !pSDEForm.isDetailStyleDirty()) {
            return null;
        }
        String string = pSDEForm.getDetailStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailStyle_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isDynaModelFlagDirty() : !pSDEForm.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEForm.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaSysRefMode(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isDynaSysRefModeDirty() : !pSDEForm.isDynaSysRefModeDirty()) {
            return null;
        }
        Integer n = pSDEForm.getDynaSysRefMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaSysRefMode_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNASYSREFMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableAdvSearch(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isEnableAdvSearchDirty() : !pSDEForm.isEnableAdvSearchDirty()) {
            return null;
        }
        Integer n = pSDEForm.getEnableAdvSearch();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableAdvSearch_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEADVSEARCH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableAutoSave(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isEnableAutoSaveDirty() : !pSDEForm.isEnableAutoSaveDirty()) {
            return null;
        }
        Integer n = pSDEForm.getEnableAutoSave();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableAutoSave_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEAUTOSAVE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCustomized(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isEnableCustomizedDirty() : !pSDEForm.isEnableCustomizedDirty()) {
            return null;
        }
        Integer n = pSDEForm.getEnableCustomized();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCustomized_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECUSTOMIZED");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableFilterSave(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isEnableFilterSaveDirty() : !pSDEForm.isEnableFilterSaveDirty()) {
            return null;
        }
        Integer n = pSDEForm.getEnableFilterSave();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableFilterSave_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEFILTERSAVE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableItemFilter(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isEnableItemFilterDirty() : !pSDEForm.isEnableItemFilterDirty()) {
            return null;
        }
        Integer n = pSDEForm.getEnableItemFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableItemFilter_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEITEMFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableItemPriv(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isEnableItemPrivDirty() : !pSDEForm.isEnableItemPrivDirty()) {
            return null;
        }
        Integer n = pSDEForm.getEnableItemPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableItemPriv_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEITEMPRIV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormItemStyle(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFormItemStyleDirty() : !pSDEForm.isFormItemStyleDirty()) {
            return null;
        }
        String string = pSDEForm.getFormItemStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormItemStyle_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMITEMSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormModel(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFormModelDirty() : !pSDEForm.isFormModelDirty()) {
            return null;
        }
        String string = pSDEForm.getFormModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormModel_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormNavBar(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFormNavBarDirty() : !pSDEForm.isFormNavBarDirty()) {
            return null;
        }
        Integer n = pSDEForm.getFormNavBar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FormNavBar_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMNAVBAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormSN(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFormSNDirty() : !pSDEForm.isFormSNDirty()) {
            return null;
        }
        String string = pSDEForm.getFormSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormSN_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormStyle(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFormStyleDirty() : !pSDEForm.isFormStyleDirty()) {
            return null;
        }
        String string = pSDEForm.getFormStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormStyle_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormTag(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFormTagDirty() : !pSDEForm.isFormTagDirty()) {
            return null;
        }
        String string = pSDEForm.getFormTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormTag_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormTag2(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFormTag2Dirty() : !pSDEForm.isFormTag2Dirty()) {
            return null;
        }
        String string = pSDEForm.getFormTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormTag2_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormTag3(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFormTag3Dirty() : !pSDEForm.isFormTag3Dirty()) {
            return null;
        }
        String string = pSDEForm.getFormTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormTag3_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormTag4(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFormTag4Dirty() : !pSDEForm.isFormTag4Dirty()) {
            return null;
        }
        String string = pSDEForm.getFormTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormTag4_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormType(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFormTypeDirty() && !bl2 : !pSDEForm.isFormTypeDirty()) {
            return null;
        }
        String string = pSDEForm.getFormType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormType_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormWidth(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFormWidthDirty() : !pSDEForm.isFormWidthDirty()) {
            return null;
        }
        Integer n = pSDEForm.getFormWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FormWidth_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncMode(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isFuncModeDirty() : !pSDEForm.isFuncModeDirty()) {
            return null;
        }
        String string = pSDEForm.getFuncMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncMode_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetDraftPSDEActionId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isGetDraftPSDEActionIdDirty() : !pSDEForm.isGetDraftPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEForm.getGetDraftPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetDraftPSDEActionId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GETDRAFTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetPSDEActionId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isGetPSDEActionIdDirty() : !pSDEForm.isGetPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEForm.getGetPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetPSDEActionId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GETPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InfoFormFlag(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isInfoFormFlagDirty() : !pSDEForm.isInfoFormFlagDirty()) {
            return null;
        }
        Integer n = pSDEForm.getInfoFormFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InfoFormFlag_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INFOFORMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelColSpan(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isLabelColSpanDirty() : !pSDEForm.isLabelColSpanDirty()) {
            return null;
        }
        Integer n = pSDEForm.getLabelColSpan();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LabelColSpan_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELCOLSPAN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelColSpan2(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isLabelColSpan2Dirty() : !pSDEForm.isLabelColSpan2Dirty()) {
            return null;
        }
        Integer n = pSDEForm.getLabelColSpan2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LabelColSpan2_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELCOLSPAN2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelWidth(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isLabelWidthDirty() : !pSDEForm.isLabelWidthDirty()) {
            return null;
        }
        Integer n = pSDEForm.getLabelWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LabelWidth_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LayoutMode(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isLayoutModeDirty() : !pSDEForm.isLayoutModeDirty()) {
            return null;
        }
        String string = pSDEForm.getLayoutMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutMode_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LAYOUTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isLockFlagDirty() : !pSDEForm.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEForm.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isMemoDirty() : !pSDEForm.isMemoDirty()) {
            return null;
        }
        String string = pSDEForm.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobFlag(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isMobFlagDirty() : !pSDEForm.isMobFlagDirty()) {
            return null;
        }
        Integer n = pSDEForm.getMobFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MobFlag_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavBarHeight(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isNavBarHeightDirty() : !pSDEForm.isNavBarHeightDirty()) {
            return null;
        }
        Integer n = pSDEForm.getNavBarHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavBarHeight_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVBARHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavBarPos(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isNavBarPosDirty() : !pSDEForm.isNavBarPosDirty()) {
            return null;
        }
        String string = pSDEForm.getNavBarPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavBarPos_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVBARPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavBarPSSysCssId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isNavBarPSSysCssIdDirty() : !pSDEForm.isNavBarPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEForm.getNavBarPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavBarPSSysCssId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVBARPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavBarStyle(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isNavBarStyleDirty() : !pSDEForm.isNavBarStyleDirty()) {
            return null;
        }
        String string = pSDEForm.getNavBarStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavBarStyle_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVBARSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavBarWidth(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isNavBarWidthDirty() : !pSDEForm.isNavBarWidthDirty()) {
            return null;
        }
        Integer n = pSDEForm.getNavBarWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavBarWidth_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVBARWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PDVTParam(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPDVTParamDirty() : !pSDEForm.isPDVTParamDirty()) {
            return null;
        }
        String string = pSDEForm.getPDVTParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PDVTParam_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PDVTPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSACHandlerIdDirty() : !pSDEForm.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSACHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSCtrlLogicGroupIdDirty() : !pSDEForm.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSCtrlMsgIdDirty() : !pSDEForm.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFInputTipSetId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSDEFInputTipSetIdDirty() : !pSDEForm.isPSDEFInputTipSetIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSDEFInputTipSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFInputTipSetId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFINPUTTIPSETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSDEFormIdDirty() && !bl2 : !pSDEForm.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSDEFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFormName(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSDEFormNameDirty() && !bl2 : !pSDEForm.isPSDEFormNameDirty()) {
            return null;
        }
        String string = pSDEForm.getPSDEFormName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormName_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSDEIdDirty() && !bl2 : !pSDEForm.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSDENameDirty() && !bl2 : !pSDEForm.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEForm.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaDEFormId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSDynaDEFormIdDirty() : !pSDEForm.isPSDynaDEFormIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSDynaDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormInstId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSDynaDEFormInstIdDirty() : !pSDEForm.isPSDynaDEFormInstIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSDynaDEFormInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormInstId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormInstName(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSDynaDEFormInstNameDirty() : !pSDEForm.isPSDynaDEFormInstNameDirty()) {
            return null;
        }
        String string = pSDEForm.getPSDynaDEFormInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormInstName_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormName(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSDynaDEFormNameDirty() : !pSDEForm.isPSDynaDEFormNameDirty()) {
            return null;
        }
        String string = pSDEForm.getPSDynaDEFormName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormName_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSDynaInstIdDirty() : !pSDEForm.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSPFIdDirty() : !pSDEForm.isPSPFIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFName(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSPFNameDirty() : !pSDEForm.isPSPFNameDirty()) {
            return null;
        }
        String string = pSDEForm.getPSPFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFName_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSSysCounterIdDirty() : !pSDEForm.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCOUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSSysCssIdDirty() : !pSDEForm.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSSysDynaModelIdDirty() : !pSDEForm.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelName(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSSysDynaModelNameDirty() : !pSDEForm.isPSSysDynaModelNameDirty()) {
            return null;
        }
        String string = pSDEForm.getPSSysDynaModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelName_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSSysPFPluginIdDirty() : !pSDEForm.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSSysReqItemIdDirty() : !pSDEForm.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSViewMsgGroupIdDirty() : !pSDEForm.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFDEId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isPSWFDEIdDirty() : !pSDEForm.isPSWFDEIdDirty()) {
            return null;
        }
        String string = pSDEForm.getPSWFDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFDEId_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_RemovePSDEActionId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isRemovePSDEActionIdDirty() : !pSDEForm.isRemovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEForm.getRemovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEActionId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchBtnPos(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isSearchBtnPosDirty() : !pSDEForm.isSearchBtnPosDirty()) {
            return null;
        }
        String string = pSDEForm.getSearchBtnPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchBtnPos_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHBTNPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchBtnStyle(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isSearchBtnStyleDirty() : !pSDEForm.isSearchBtnStyleDirty()) {
            return null;
        }
        String string = pSDEForm.getSearchBtnStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchBtnStyle_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHBTNSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowTabHeader(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isShowTabHeaderDirty() : !pSDEForm.isShowTabHeaderDirty()) {
            return null;
        }
        Integer n = pSDEForm.getShowTabHeader();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowTabHeader_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWTABHEADER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFSysPub(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isSRFSysPubDirty() : !pSDEForm.isSRFSysPubDirty()) {
            return null;
        }
        Integer n = pSDEForm.getSRFSysPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SRFSysPub_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRFSYSPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TabHeaderPos(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isTabHeaderPosDirty() : !pSDEForm.isTabHeaderPosDirty()) {
            return null;
        }
        String string = pSDEForm.getTabHeaderPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TabHeaderPos_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABHEADERPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isToDoTaskDirty() : !pSDEForm.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEForm.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_UpdatePSDEActionId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isUpdatePSDEActionIdDirty() : !pSDEForm.isUpdatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEForm.getUpdatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEActionId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEActionId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isUser2PSDEActionIdDirty() : !pSDEForm.isUser2PSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEForm.getUser2PSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEActionId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USER2PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isUserParamsDirty() : !pSDEForm.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEForm.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserPSDEActionId(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isUserPSDEActionIdDirty() : !pSDEForm.isUserPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEForm.getUserPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEActionId_Default((IEntity)pSDEForm, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isUserTagDirty() : !pSDEForm.isUserTagDirty()) {
            return null;
        }
        String string = pSDEForm.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEForm pSDEForm, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEForm.isUserTag2Dirty() : !pSDEForm.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEForm.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEForm, bl2, bl3);
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

    protected void onSyncEntity(PSDEForm pSDEForm, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEForm, bl);
    }

    protected void onSyncIndexEntities(PSDEForm pSDEForm, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEForm, bl);
    }

    public Object getDataContextValue(PSDEForm pSDEForm, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEForm, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEForm.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEForm pSDEForm, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEFIUpdate_PSDEForm(pSDEForm, arrayList, n);
        this.onExportRelatedModel_PSDEFIUDetail_PSDEForm(pSDEForm, arrayList, n);
        this.onExportRelatedModel_PSDEFormRF_MajorPSDEForm(pSDEForm, arrayList, n);
        this.onExportRelatedModel_PSDEFormDetail_PSDEForm(pSDEForm, arrayList, n);
        this.onExportRelatedModel_PSDEFDLogic_PSDEForm(pSDEForm, arrayList, n);
        this.onExportRelatedModel_PSDEFIVR_PSDEForm(pSDEForm, arrayList, n);
        this.onExportRelatedModel_PSDEFormLogic_PSDEForm(pSDEForm, arrayList, n);
        super.onExportRelatedModel((IEntity)pSDEForm, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEFIUpdate_PSDEForm(PSDEForm pSDEForm, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEFIUpdateService pSDEFIUpdateService = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIUpdate> arrayList2 = pSDEFIUpdateService.selectByPSDEForm(pSDEForm);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"b382c538bee84b11c5d1067d8f3df173");
            jSONObject.put("srfdename", (Object)"PSDEFIUPDATE");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEFIUPDATE_PSDEFORM_PSDEFORMID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEForm, (String)"PSDEFORMID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEFIUpdate pSDEFIUpdate : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEFIUpdate, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEFIUpdateService.exportModel(pSDEFIUpdate, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEFIUDetail_PSDEForm(PSDEForm pSDEForm, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEFIUDetailService pSDEFIUDetailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIUDetail> arrayList2 = pSDEFIUDetailService.selectByPSDEForm(pSDEForm);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"5f266b2e5d6be2870a75429924a19962");
            jSONObject.put("srfdename", (Object)"PSDEFIUDETAIL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEFIUDETAIL_PSDEFORM_PSDEFORMID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEForm, (String)"PSDEFORMID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEFIUDetail pSDEFIUDetail : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEFIUDetail, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEFIUDetailService.exportModel(pSDEFIUDetail, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEFormRF_MajorPSDEForm(PSDEForm pSDEForm, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEFormRFService pSDEFormRFService = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormRF> arrayList2 = pSDEFormRFService.selectByMajorPSDEForm(pSDEForm);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"d5949861cd1af461326b94d7432f816c");
            jSONObject.put("srfdename", (Object)"PSDEFORMRF");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEFORMRF_PSDEFORM_MAJORPSDEFORMID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEForm, (String)"PSDEFORMID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEFormRF pSDEFormRF : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEFormRF, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEFormRFService.exportModel(pSDEFormRF, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEFormDetail_PSDEForm(PSDEForm pSDEForm, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormDetail> arrayList2 = pSDEFormDetailService.selectByPSDEForm(pSDEForm);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"b8e3b42cac55cdfb2dc0a059d518d0b8");
            jSONObject.put("srfdename", (Object)"PSDEFORMDETAIL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEForm, (String)"PSDEFORMID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEFormDetail pSDEFormDetail : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEFormDetail, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEFormDetailService.exportModel(pSDEFormDetail, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEFDLogic_PSDEForm(PSDEForm pSDEForm, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFDLogic> arrayList2 = pSDEFDLogicService.selectByPSDEForm(pSDEForm);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"c553aa51caf367ac3250ec8897007134");
            jSONObject.put("srfdename", (Object)"PSDEFDLOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEFDLOGIC_PSDEFORM_PSDEFORMID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEForm, (String)"PSDEFORMID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEFDLogic pSDEFDLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEFDLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEFDLogicService.exportModel(pSDEFDLogic, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEFIVR_PSDEForm(PSDEForm pSDEForm, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEFIVRService pSDEFIVRService = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIVR> arrayList2 = pSDEFIVRService.selectByPSDEForm(pSDEForm);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"d40562a838579fe59a29ba74cbb91e27");
            jSONObject.put("srfdename", (Object)"PSDEFIVR");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEFIVR_PSDEFORM_PSDEFORMID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEForm, (String)"PSDEFORMID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEFIVR pSDEFIVR : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEFIVR, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEFIVRService.exportModel(pSDEFIVR, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEFormLogic_PSDEForm(PSDEForm pSDEForm, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEFormLogicService pSDEFormLogicService = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormLogic> arrayList2 = pSDEFormLogicService.selectByPSDEForm(pSDEForm);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"ebfa7e98501c90acb023fb404c690930");
            jSONObject.put("srfdename", (Object)"PSDEFORMLOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEFORMLOGIC_PSDEFORM_PSDEFORMID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEForm, (String)"PSDEFORMID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEFormLogic pSDEFormLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEFormLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEFormLogicService.exportModel(pSDEFormLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEForm pSDEForm, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEForm, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BUSYINDICATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BusyIndicator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COPYPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CopyPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COPYPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CopyPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLCOLSPAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlColSpan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNASYSREFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaSysRefMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEADVSEARCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableAdvSearch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEAUTOSAVE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableAutoSave_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECUSTOMIZED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCustomized_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEFILTERSAVE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableFilterSave_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEITEMFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableItemFilter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEITEMPRIV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableItemPriv_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMITEMSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormItemStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMNAVBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormNavBar_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETDRAFTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetDraftPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETDRAFTPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetDraftPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INFOFORMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InfoFormFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELCOLSPAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelColSpan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELCOLSPAN2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelColSpan2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PDVTPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PDVTParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEFINPUTTIPSETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFInputTipSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFINPUTTIPSETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFInputTipSetName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSWFDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHBTNPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchBtnPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHBTNSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchBtnStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWTABHEADER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowTabHeader_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFSYSPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABHEADERPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TabHeaderPos_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BusyIndicator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldQueryCountRule2("CODENAME", "CountCodeName", iEntity, bl2, 0, true, 0, true, "\u4ee3\u7801\u540d\u79f0\u4e0d\u80fd\u91cd\u590d", false, false) && this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u4ee3\u7801\u540d\u79f0\u4e0d\u80fd\u91cd\u590d \u5e76\u4e14 \u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CopyPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COPYPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CopyPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COPYPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_CreatePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreatePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlColSpan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATATYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILSTYLE", iEntity, bl2, null, false, 16, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaSysRefMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableAdvSearch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableAutoSave_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCustomized_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableFilterSave_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableItemFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableItemPriv_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FormItemStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMITEMSTYLE", iEntity, bl2, null, false, 16, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormNavBar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FormSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMTAG", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMTAG3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMTAG4", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FuncMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetDraftPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETDRAFTPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetDraftPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETDRAFTPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InfoFormFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LabelColSpan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LabelColSpan2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LabelWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LayoutMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LAYOUTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_MobFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavBarHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavBarPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVBARPOS", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavBarPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVBARPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavBarPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVBARPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavBarStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVBARSTYLE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavBarWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PDVTParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PDVTPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSACHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSACHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSACHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSACHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEFInputTipSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFINPUTTIPSETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFInputTipSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFINPUTTIPSETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDynaDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEFormInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEFormInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMINSTNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCounterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RemovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SearchBtnPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEARCHBTNPOS", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SearchBtnStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEARCHBTNSTYLE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShowTabHeader_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SRFSysPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TabHeaderPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABHEADERPOS", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_UpdatePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdatePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_User2PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_User2PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEForm pSDEForm) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEForm)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEForm pSDEForm) throws Exception {
        Object object = pSDEForm.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEFORM_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEForm);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEForm pSDEForm, Object object) throws Exception {
        PSDEForm pSDEForm2 = new PSDEForm();
        pSDEForm2.set("PSDEFORMID", object);
        String string = DataObject.getStringValue((Object)pSDEForm.get("PSDEFORMID"));
        super.onCopyDetails((IEntity)pSDEForm, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEForm pSDEForm, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFORM");
        if (!bl) {
            pSDEForm.setCreateDate(null);
            pSDEForm.setCreateMan(null);
            pSDEForm.setDynaSysRefMode(null);
            pSDEForm.setPSDEFormId(null);
            pSDEForm.setPSDynaDEFormInstId(null);
            pSDEForm.setPSDynaDEFormInstName(null);
            pSDEForm.setPSDynaDEFormName(null);
            pSDEForm.setPSDynaInstId(null);
            pSDEForm.setPSDynaInstName(null);
            pSDEForm.setUpdateDate(null);
            pSDEForm.setUpdateMan(null);
            super.exportCurXmlModel(pSDEForm, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEForm pSDEForm, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEFIUpdate(pSDEForm, xmlNode);
        this.exportRelatedXmlModel_PSDEFormDetail(pSDEForm, xmlNode);
        this.exportRelatedXmlModel_PSDEFormLogic(pSDEForm, xmlNode);
        super.onExportRelatedXmlModel(pSDEForm, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEFIUpdate(PSDEForm pSDEForm, XmlNode xmlNode) throws Exception {
        PSDEFIUpdateService pSDEFIUpdateService = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFIUpdate> arrayList = null;
        String string = pSDEForm.getPSDEFormId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFIUpdateService.selectByPSDEForm(pSDEForm) : pSDEFIUpdateService.selectTempByPSDEForm(pSDEForm);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEFIUPDATES");
            xmlNode.addNode(xmlNode2);
            for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
                pSDEFIUpdateService.exportXmlModel(pSDEFIUpdate, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEFormDetail(PSDEForm pSDEForm, XmlNode xmlNode) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormDetail> arrayList = null;
        String string = pSDEForm.getPSDEFormId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFormDetailService.selectByPSDEForm(pSDEForm, "ORDER BY ORDERVALUE ASC") : pSDEFormDetailService.selectTempByPSDEForm(pSDEForm, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEFORMDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDEFormDetail pSDEFormDetail : arrayList) {
                if (pSDEFormDetail.getPPSDEFormDetailId() != null) continue;
                pSDEFormDetail.set("ORDERVALUE", null);
                pSDEFormDetailService.exportXmlModel(pSDEFormDetail, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEFormLogic(PSDEForm pSDEForm, XmlNode xmlNode) throws Exception {
        PSDEFormLogicService pSDEFormLogicService = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormLogic> arrayList = null;
        String string = pSDEForm.getPSDEFormId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFormLogicService.selectByPSDEForm(pSDEForm, "ORDER BY ORDERVALUE ASC") : pSDEFormLogicService.selectTempByPSDEForm(pSDEForm, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEFORMLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSDEFormLogic pSDEFormLogic : arrayList) {
                pSDEFormLogic.set("ORDERVALUE", null);
                pSDEFormLogicService.exportXmlModel(pSDEFormLogic, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEForm pSDEForm, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEFIUPDATES");
        this.importRelatedXmlModel_PSDEFIUpdate(pSDEForm, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDEFORMDETAILS");
        this.importRelatedXmlModel_PSDEFormDetail(pSDEForm, xmlNode3);
        XmlNode xmlNode4 = xmlNode.getChildNodeByNodeName("PSDEFORMLOGICS");
        this.importRelatedXmlModel_PSDEFormLogic(pSDEForm, xmlNode4);
        super.onImportRelatedXmlModel(pSDEForm, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEFIUpdate(PSDEForm pSDEForm, XmlNode xmlNode) throws Exception {
        PSDEFIUpdateService pSDEFIUpdateService = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEForm.getPSDEFormId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEFIUpdateService.removeByPSDEForm(pSDEForm);
        } else {
            pSDEFIUpdateService.removeTempByPSDEForm(pSDEForm);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEFIUpdate pSDEFIUpdate = new PSDEFIUpdate();
                pSDEFIUpdateService.fillParentInfo((IEntity)pSDEFIUpdate, "DER1N", "DER1N_PSDEFIUPDATE_PSDEFORM_PSDEFORMID", pSDEForm.getPSDEFormId());
                pSDEFIUpdateService.importXmlModel(pSDEFIUpdate, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEFormDetail(PSDEForm pSDEForm, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEForm.getPSDEFormId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEFormDetailService.removeByPSDEForm(pSDEForm);
        } else {
            pSDEFormDetailService.removeTempByPSDEForm(pSDEForm);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setOrderValue(n);
                n += 100;
                pSDEFormDetailService.fillParentInfo((IEntity)pSDEFormDetail, "DER1N", "DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID", pSDEForm.getPSDEFormId());
                pSDEFormDetailService.importXmlModel(pSDEFormDetail, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEFormLogic(PSDEForm pSDEForm, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEFormLogicService pSDEFormLogicService = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEForm.getPSDEFormId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEFormLogicService.removeByPSDEForm(pSDEForm);
        } else {
            pSDEFormLogicService.removeTempByPSDEForm(pSDEForm);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEFormLogic pSDEFormLogic = new PSDEFormLogic();
                pSDEFormLogic.setOrderValue(n);
                n += 100;
                pSDEFormLogicService.fillParentInfo((IEntity)pSDEFormLogic, "DER1N", "DER1N_PSDEFORMLOGIC_PSDEFORM_PSDEFORMID", pSDEForm.getPSDEFormId());
                pSDEFormLogicService.importXmlModel(pSDEFormLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEForm pSDEForm, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEForm, string);
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
            return "DER1N_PSDEFORM_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEForm pSDEForm) {
        if (!StringHelper.isNullOrEmpty((String)pSDEForm.getCodeName())) {
            return pSDEForm.getCodeName();
        }
        return super.getModelV2Tag(pSDEForm);
    }

    @Override
    public boolean setModelV2Tag(PSDEForm pSDEForm, String string) {
        pSDEForm.setCodeName(string);
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
    public boolean getModelV2Entity(PSDEForm pSDEForm, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEForm.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEForm, true);
        pSDEForm.set("CODENAME", string);
        if (this.select(pSDEForm, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEForm, true);
        return super.getModelV2Entity(pSDEForm, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEForm pSDEForm, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEForm, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEFORMRF_PSDEFORM_MAJORPSDEFORMID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEFDLOGIC_PSDEFORM_PSDEFORMID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEFIUDETAIL_PSDEFORM_PSDEFORMID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEFIUPDATE_PSDEFORM_PSDEFORMID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEFIVR_PSDEFORM_PSDEFORMID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEFORMLOGIC_PSDEFORM_PSDEFORMID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEForm pSDEForm, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEForm, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEForm pSDEForm, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSDEFormDetail> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID")) {
            pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFORM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFORMDETAIL", (Object)pSDEForm.getPSDEFormId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEFormDetail)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEFormDetail>();
                object4 = ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
                object3 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEFormDetail)object2.next();
                    object = ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEFormDetail)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("psdeformdetailname")) {
                            string = objectNode.get("psdeformdetailname").asText();
                        }
                        if (objectNode2.has("psdeformdetailname")) {
                            string2 = objectNode2.get("psdeformdetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEFormDetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    ((PSDEFormDetailBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFORMRF_PSDEFORM_MAJORPSDEFORMID")) {
            pSCoreSysServiceBase = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFORM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFORMRF", (Object)pSDEForm.getPSDEFormId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEFormDetail)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEFormRFServiceBase)pSCoreSysServiceBase).selectByMajorPSDEForm(pSDEForm);
                object3 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEFormRF)object2.next();
                    object = ((PSDEFormRFServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEFormDetail)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("psdeformrfname")) {
                            string = objectNode.get("psdeformrfname").asText();
                        }
                        if (objectNode2.has("psdeformrfname")) {
                            string2 = objectNode2.get("psdeformrfname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEFormRF();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFDLOGIC_PSDEFORM_PSDEFORMID")) {
            pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFORM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFDLOGIC", (Object)pSDEForm.getPSDEFormId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEFormDetail)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
                object3 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEFDLogic)object2.next();
                    object = ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEFormDetail)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("psdefdlogicname")) {
                            string = objectNode.get("psdefdlogicname").asText();
                        }
                        if (objectNode2.has("psdefdlogicname")) {
                            string2 = objectNode2.get("psdefdlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEFDLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    ((PSDEFDLogicBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFIUDETAIL_PSDEFORM_PSDEFORMID")) {
            pSCoreSysServiceBase = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFORM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFIUDETAIL", (Object)pSDEForm.getPSDEFormId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEFormDetail)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
                object3 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEFIUDetail)object2.next();
                    object = ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEFormDetail)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("psdeformdetailname")) {
                            string = objectNode.get("psdeformdetailname").asText();
                        }
                        if (objectNode2.has("psdeformdetailname")) {
                            string2 = objectNode2.get("psdeformdetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEFIUDetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFIUPDATE_PSDEFORM_PSDEFORMID")) {
            pSCoreSysServiceBase = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFORM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFIUPDATE", (Object)pSDEForm.getPSDEFormId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEFormDetail)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEFIUpdateServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
                object3 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEFIUpdate)object2.next();
                    object = ((PSDEFIUpdateServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEFormDetail)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("psdefiupdatename")) {
                            string = objectNode.get("psdefiupdatename").asText();
                        }
                        if (objectNode2.has("psdefiupdatename")) {
                            string2 = objectNode2.get("psdefiupdatename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEFIUpdate();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFIVR_PSDEFORM_PSDEFORMID")) {
            pSCoreSysServiceBase = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFORM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFIVR", (Object)pSDEForm.getPSDEFormId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEFormDetail)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEFIVRServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
                object3 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEFIVR)object2.next();
                    object = ((PSDEFIVRServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEFormDetail)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("psdefivrname")) {
                            string = objectNode.get("psdefivrname").asText();
                        }
                        if (objectNode2.has("psdefivrname")) {
                            string2 = objectNode2.get("psdefivrname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEFIVR();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFORMLOGIC_PSDEFORM_PSDEFORMID")) {
            pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFORM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFORMLOGIC", (Object)pSDEForm.getPSDEFormId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEFormDetail)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
                object3 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEFormLogic)object2.next();
                    object = ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEFormDetail)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("psdeformlogicname")) {
                            string = objectNode.get("psdeformlogicname").asText();
                        }
                        if (objectNode2.has("psdeformlogicname")) {
                            string2 = objectNode2.get("psdeformlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEFormLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEForm, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEForm pSDEForm) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
        String string2 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
        for (PSDEFormDetail entityBase : arrayList) {
            string = ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSDEForm.getPSDEFormId());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFORMDETAIL WHERE PSDEFORMID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEFormRFServiceBase)pSCoreSysServiceBase).selectByMajorPSDEForm(pSDEForm);
        string2 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
        for (PSDEFormRF pSDEFormRF : arrayList) {
            string = ((PSDEFormRFServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEFormRF);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEFormRF);
        }
        object = new SqlParamList();
        object.addString(pSDEForm.getPSDEFormId());
        ((PSDEFormRFServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEFormRFServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFORMRF WHERE MAJORPSDEFORMID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
        string2 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            string = ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEFDLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEFDLogic);
        }
        object = new SqlParamList();
        object.addString(pSDEForm.getPSDEFormId());
        ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFDLOGIC WHERE PSDEFORMID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
        string2 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            string = ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEFIUDetail);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEFIUDetail);
        }
        object = new SqlParamList();
        object.addString(pSDEForm.getPSDEFormId());
        ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFIUDETAIL WHERE PSDEFORMID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEFIUpdateServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
        string2 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
        for (PSDEFIUpdate pSDEFIUpdate : arrayList) {
            string = ((PSDEFIUpdateServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEFIUpdate);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEFIUpdate);
        }
        object = new SqlParamList();
        object.addString(pSDEForm.getPSDEFormId());
        ((PSDEFIUpdateServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEFIUpdateServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFIUPDATE WHERE PSDEFORMID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEFIVRServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
        string2 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
        for (PSDEFIVR pSDEFIVR : arrayList) {
            string = ((PSDEFIVRServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEFIVR);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEFIVR);
        }
        object = new SqlParamList();
        object.addString(pSDEForm.getPSDEFormId());
        ((PSDEFIVRServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEFIVRServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFIVR WHERE PSDEFORMID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).selectByPSDEForm(pSDEForm);
        string2 = StringHelper.format((String)"PSDEFORM#%1$s", (Object)pSDEForm.getPSDEFormId());
        for (PSDEFormLogic pSDEFormLogic : arrayList) {
            string = ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEFormLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEFormLogic);
        }
        object = new SqlParamList();
        object.addString(pSDEForm.getPSDEFormId());
        ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFORMLOGIC WHERE PSDEFORMID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSDEForm);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEForm pSDEForm, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEFormDetail();
        entityBase.set("PSDEFORMID", pSDEForm.getPSDEFormId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEFormRF();
        entityBase.set("MAJORPSDEFORMID", pSDEForm.getPSDEFormId());
        pSCoreSysServiceBase = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEFDLogic();
        entityBase.set("PSDEFORMID", pSDEForm.getPSDEFormId());
        pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEFIUDetail();
        entityBase.set("PSDEFORMID", pSDEForm.getPSDEFormId());
        pSCoreSysServiceBase = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEFIUpdate();
        entityBase.set("PSDEFORMID", pSDEForm.getPSDEFormId());
        pSCoreSysServiceBase = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEFIVR();
        entityBase.set("PSDEFORMID", pSDEForm.getPSDEFormId());
        pSCoreSysServiceBase = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEFormLogic();
        entityBase.set("PSDEFORMID", pSDEForm.getPSDEFormId());
        pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEForm, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEForm pSDEForm, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Serializable serializable;
        int n2;
        int n3;
        Object object;
        Object object2;
        Object object3;
        int n4;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        int n5 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n4 = 0; n4 < arrayNode.size(); ++n4) {
                object3 = (ObjectNode)arrayNode.get(n4);
                object2 = new PSDEFormDetail();
                ((PSDEFormDetailBase)object2).setFormType(pSDEForm.getFormType());
                ((PSDEFormDetailBase)object2).setMobFlag(pSDEForm.getMobFlag());
                ((PSDEFormDetailBase)object2).setPSDEFormId(pSDEForm.getPSDEFormId());
                ((PSDEFormDetailBase)object2).setPSDEFormName(pSDEForm.getPSDEFormName());
                ((PSDEFormDetailBase)object2).setPSDEId(pSDEForm.getPSDEId());
                ((PSDEFormDetailBase)object2).setOrderValue(n5 += 10);
                pSCoreSysServiceBase.compileModelV2(object2, (ObjectNode)object3, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object3 = new File(string4);
            if (((File)object3).exists()) {
                object2 = ((File)object3).listFiles();
                object = object2;
                n3 = ((File[])object).length;
                for (n2 = 0; n2 < n3; ++n2) {
                    serializable = object[n2];
                    if (!((File)serializable).isDirectory()) continue;
                    entityBase = new PSDEFormDetail();
                    entityBase.setFormType(pSDEForm.getFormType());
                    entityBase.setMobFlag(pSDEForm.getMobFlag());
                    entityBase.setPSDEFormId(pSDEForm.getPSDEFormId());
                    entityBase.setPSDEFormName(pSDEForm.getPSDEFormName());
                    entityBase.setPSDEId(pSDEForm.getPSDEId());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)serializable).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n5 = 0; n5 < arrayNode.size(); ++n5) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(n5);
                object3 = new PSDEFormRF();
                ((PSDEFormRFBase)object3).setMajorPSDEFormId(pSDEForm.getPSDEFormId());
                ((PSDEFormRFBase)object3).setMajorPSDEFormName(pSDEForm.getPSDEFormName());
                ((PSDEFormRFBase)object3).setPSDEId(pSDEForm.getPSDEId());
                pSCoreSysServiceBase.compileModelV2(object3, objectNode2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string5);
            if (file.exists()) {
                for (File file2 : object3 = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    serializable = new PSDEFormRF();
                    ((PSDEFormRFBase)serializable).setMajorPSDEFormId(pSDEForm.getPSDEFormId());
                    ((PSDEFormRFBase)serializable).setMajorPSDEFormName(pSDEForm.getPSDEFormName());
                    ((PSDEFormRFBase)serializable).setPSDEId(pSDEForm.getPSDEId());
                    pSCoreSysServiceBase.compileModelV2(serializable, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        int n6 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n4 = 0; n4 < arrayNode.size(); ++n4) {
                object3 = (ObjectNode)arrayNode.get(n4);
                object2 = new PSDEFDLogic();
                ((PSDEFDLogicBase)object2).setPSDEFormId(pSDEForm.getPSDEFormId());
                ((PSDEFDLogicBase)object2).setPSDEFormName(pSDEForm.getPSDEFormName());
                ((PSDEFDLogicBase)object2).setOrderValue(n6 += 10);
                pSCoreSysServiceBase.compileModelV2(object2, (ObjectNode)object3, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object3 = new File(string6);
            if (((File)object3).exists()) {
                object2 = ((File)object3).listFiles();
                object = object2;
                n3 = ((File[])object).length;
                for (n2 = 0; n2 < n3; ++n2) {
                    serializable = object[n2];
                    if (!((File)serializable).isDirectory()) continue;
                    entityBase = new PSDEFDLogic();
                    entityBase.setPSDEFormId(pSDEForm.getPSDEFormId());
                    entityBase.setPSDEFormName(pSDEForm.getPSDEFormName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)serializable).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n6 = 0; n6 < arrayNode.size(); ++n6) {
                ObjectNode objectNode3 = (ObjectNode)arrayNode.get(n6);
                object3 = new PSDEFIUDetail();
                ((PSDEFIUDetailBase)object3).setPSDEFormId(pSDEForm.getPSDEFormId());
                ((PSDEFIUDetailBase)object3).setPSDEFormName(pSDEForm.getPSDEFormName());
                pSCoreSysServiceBase.compileModelV2(object3, objectNode3, string, null, n);
            }
        } else {
            String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string7);
            if (file.exists()) {
                for (Object object4 : object3 = file.listFiles()) {
                    if (!((File)object4).isDirectory()) continue;
                    serializable = new PSDEFIUDetail();
                    ((PSDEFIUDetailBase)serializable).setPSDEFormId(pSDEForm.getPSDEFormId());
                    ((PSDEFIUDetailBase)serializable).setPSDEFormName(pSDEForm.getPSDEFormName());
                    pSCoreSysServiceBase.compileModelV2(serializable, null, string, ((File)object4).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode4 = (ObjectNode)arrayNode.get(i);
                object3 = new PSDEFIUpdate();
                ((PSDEFIUpdateBase)object3).setPSDEFormId(pSDEForm.getPSDEFormId());
                ((PSDEFIUpdateBase)object3).setPSDEFormName(pSDEForm.getPSDEFormName());
                ((PSDEFIUpdateBase)object3).setPSDEId(pSDEForm.getPSDEId());
                pSCoreSysServiceBase.compileModelV2(object3, objectNode4, string, null, n);
            }
        } else {
            String string8 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string8);
            if (file.exists()) {
                for (Object object5 : object3 = file.listFiles()) {
                    if (!((File)object5).isDirectory()) continue;
                    serializable = new PSDEFIUpdate();
                    ((PSDEFIUpdateBase)serializable).setPSDEFormId(pSDEForm.getPSDEFormId());
                    ((PSDEFIUpdateBase)serializable).setPSDEFormName(pSDEForm.getPSDEFormName());
                    ((PSDEFIUpdateBase)serializable).setPSDEId(pSDEForm.getPSDEId());
                    pSCoreSysServiceBase.compileModelV2(serializable, null, string, ((File)object5).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode5 = (ObjectNode)arrayNode.get(i);
                object3 = new PSDEFIVR();
                ((PSDEFIVRBase)object3).setPSDEFormId(pSDEForm.getPSDEFormId());
                ((PSDEFIVRBase)object3).setPSDEFormName(pSDEForm.getPSDEFormName());
                pSCoreSysServiceBase.compileModelV2(object3, objectNode5, string, null, n);
            }
        } else {
            String string9 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string9);
            if (file.exists()) {
                for (Object object6 : object3 = file.listFiles()) {
                    if (!((File)object6).isDirectory()) continue;
                    serializable = new PSDEFIVR();
                    ((PSDEFIVRBase)serializable).setPSDEFormId(pSDEForm.getPSDEFormId());
                    ((PSDEFIVRBase)serializable).setPSDEFormName(pSDEForm.getPSDEFormName());
                    pSCoreSysServiceBase.compileModelV2(serializable, null, string, ((File)object6).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode6 = (ObjectNode)arrayNode.get(i);
                object3 = new PSDEFormLogic();
                ((PSDEFormLogicBase)object3).setPSDEFormId(pSDEForm.getPSDEFormId());
                ((PSDEFormLogicBase)object3).setPSDEFormName(pSDEForm.getPSDEFormName());
                pSCoreSysServiceBase.compileModelV2(object3, objectNode6, string, null, n);
            }
        } else {
            String string10 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string10);
            if (file.exists()) {
                for (Object object7 : object3 = file.listFiles()) {
                    if (!((File)object7).isDirectory()) continue;
                    serializable = new PSDEFormLogic();
                    ((PSDEFormLogicBase)serializable).setPSDEFormId(pSDEForm.getPSDEFormId());
                    ((PSDEFormLogicBase)serializable).setPSDEFormName(pSDEForm.getPSDEFormName());
                    pSCoreSysServiceBase.compileModelV2(serializable, null, string, ((File)object7).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEForm, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEForm pSDEForm, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFormDetails(pSDEForm, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFIUPDATE_PSDEFORM_PSDEFORMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFIUpdates(pSDEForm, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFORMLOGIC_PSDEFORM_PSDEFORMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFormLogics(pSDEForm, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEForm, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEFormDetails(PSDEForm pSDEForm, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFORMDETAIL", true), (boolean)false) == 0) {
            PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormDetailId(pSMOSFile.getPSModelId());
            if (!pSDEFormDetailService.get((IEntity)pSDEFormDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFormDetail.getPSDEFormId(), (String)pSDEForm.getPSDEFormId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFormDetailService.exportModelV2(pSDEFormDetail);
            pSDEFormDetail.reset();
            if (!pSDEFormDetailService.setModelV2ResScope((IEntity)pSDEFormDetail, "PSDEFORM", pSDEForm.getPSDEFormId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFormDetailService.importModelV2(pSDEFormDetail, objectNode);
            SessionFactoryManager.commit();
            return pSDEFormDetailService.getFile((IEntity)pSDEFormDetail);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEFIUpdates(PSDEForm pSDEForm, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFIUPDATE", true), (boolean)false) == 0) {
            PSDEFIUpdateService pSDEFIUpdateService = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
            PSDEFIUpdate pSDEFIUpdate = new PSDEFIUpdate();
            pSDEFIUpdate.setPSDEFIUpdateId(pSMOSFile.getPSModelId());
            if (!pSDEFIUpdateService.get((IEntity)pSDEFIUpdate, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFIUpdate.getPSDEFormId(), (String)pSDEForm.getPSDEFormId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFIUpdateService.exportModelV2(pSDEFIUpdate);
            pSDEFIUpdate.reset();
            if (!pSDEFIUpdateService.setModelV2ResScope((IEntity)pSDEFIUpdate, "PSDEFORM", pSDEForm.getPSDEFormId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFIUpdateService.importModelV2(pSDEFIUpdate, objectNode);
            SessionFactoryManager.commit();
            return pSDEFIUpdateService.getFile((IEntity)pSDEFIUpdate);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEFormLogics(PSDEForm pSDEForm, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFORMLOGIC", true), (boolean)false) == 0) {
            PSDEFormLogicService pSDEFormLogicService = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDEFormLogic pSDEFormLogic = new PSDEFormLogic();
            pSDEFormLogic.setPSDEFormLogicId(pSMOSFile.getPSModelId());
            if (!pSDEFormLogicService.get((IEntity)pSDEFormLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFormLogic.getPSDEFormId(), (String)pSDEForm.getPSDEFormId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFormLogicService.exportModelV2(pSDEFormLogic);
            pSDEFormLogic.reset();
            if (!pSDEFormLogicService.setModelV2ResScope((IEntity)pSDEFormLogic, "PSDEFORM", pSDEForm.getPSDEFormId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFormLogicService.importModelV2(pSDEFormLogic, objectNode);
            SessionFactoryManager.commit();
            return pSDEFormLogicService.getFile((IEntity)pSDEFormLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEForm pSDEForm, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEFormDetails(pSDEForm, list);
        this.onFillPasteHelps_PSDEFIUpdates(pSDEForm, list);
        this.onFillPasteHelps_PSDEFormLogics(pSDEForm, list);
        super.onFillPasteHelps(pSDEForm, list);
    }

    protected void onFillPasteHelps_PSDEFormDetails(PSDEForm pSDEForm, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFORMDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u8868\u5355]\u7684[\u8868\u5355\u6210\u5458]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEFIUpdates(PSDEForm pSDEForm, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFIUPDATE");
        pSHelpSection.setSectionParam2("DER1N_PSDEFIUPDATE_PSDEFORM_PSDEFORMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u8868\u5355]\u7684[\u5b9e\u4f53\u8868\u5355\u9879\u66f4\u65b0]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEFormLogics(PSDEForm pSDEForm, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFORMLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDEFORMLOGIC_PSDEFORM_PSDEFORMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u8868\u5355]\u7684[\u5b9e\u4f53\u8868\u5355\u903b\u8f91]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSDEForm pSDEForm) throws Exception {
        return pSDEForm.getFormType();
    }
}

