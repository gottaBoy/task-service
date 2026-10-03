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
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewRefService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewRefServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSVTStyle;
import net.ibizsys.pscore.srv.config.entity.PSVTStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSViewEngine;
import net.ibizsys.pscore.srv.config.entity.PSViewEngineBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEViewBaseDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewBaseDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrlBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewEngine;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewEngineBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewRV;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewRVBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRVService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRVServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewGrpDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewGrpDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewServiceService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewServiceServiceBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEViewTempl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEViewTemplBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModule;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModuleBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubViewType;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubViewTypeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemRVService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemRVServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewServiceBase;
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
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewBaseServiceBase
extends PSCoreSysServiceBase<PSDEViewBase> {
    private static final Log log = LogFactory.getLog(PSDEViewBaseServiceBase.class);
    public static final String DATASET_BYTYPE = "ByType";
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURAPPADD = "CurAppAdd";
    public static final String DATASET_CURAPPNOTADD = "CurAppNotAdd";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURDE2 = "CurDE2";
    public static final String DATASET_CURDEMOB = "CurDEMob";
    public static final String DATASET_CURDEWEB = "CurDEWeb";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURWF2 = "CurWF2";
    public static final String DATASET_CURWFVER = "CurWFVer";
    public static final String DATASET_DEPDT = "DEPDT";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    public static final String DATASET_MOB = "Mob";
    public static final String DATASET_WF = "WF";
    public static final String DATASET_WEB = "Web";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_JITPREVIEW = "JITPREVIEW";
    public static final String ACTION_PREVIEWSAVE = "PreviewSave";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSDEViewBaseDEModel pSDEViewBaseDEModel;
    private PSDEViewBaseDAO pSDEViewBaseDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService";
    }

    public PSDEViewBaseDEModel getPSDEViewBaseDEModel() {
        if (this.pSDEViewBaseDEModel == null) {
            try {
                this.pSDEViewBaseDEModel = (PSDEViewBaseDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewBaseDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewBaseDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEViewBaseDEModel();
    }

    public PSDEViewBaseDAO getPSDEViewBaseDAO() {
        if (this.pSDEViewBaseDAO == null) {
            try {
                this.pSDEViewBaseDAO = (PSDEViewBaseDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEViewBaseDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewBaseDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEViewBaseDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_BYTYPE, (boolean)true) == 0) {
            return this.fetchByType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPADD, (boolean)true) == 0) {
            return this.fetchCurAppAdd(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPNOTADD, (boolean)true) == 0) {
            return this.fetchCurAppNotAdd(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE2, (boolean)true) == 0) {
            return this.fetchCurDE2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEMOB, (boolean)true) == 0) {
            return this.fetchCurDEMob(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEWEB, (boolean)true) == 0) {
            return this.fetchCurDEWeb(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURWF2, (boolean)true) == 0) {
            return this.fetchCurWF2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURWFVER, (boolean)true) == 0) {
            return this.fetchCurWFVer(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEPDT, (boolean)true) == 0) {
            return this.fetchDEPDT(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_MOB, (boolean)true) == 0) {
            return this.fetchMob(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_WF, (boolean)true) == 0) {
            return this.fetchWF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_WEB, (boolean)true) == 0) {
            return this.fetchWeb(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_BYTYPE, (boolean)true) == 0) {
            return this.fetchTempByType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchTempCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPADD, (boolean)true) == 0) {
            return this.fetchTempCurAppAdd(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPNOTADD, (boolean)true) == 0) {
            return this.fetchTempCurAppNotAdd(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE2, (boolean)true) == 0) {
            return this.fetchTempCurDE2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEMOB, (boolean)true) == 0) {
            return this.fetchTempCurDEMob(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEWEB, (boolean)true) == 0) {
            return this.fetchTempCurDEWeb(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURWF2, (boolean)true) == 0) {
            return this.fetchTempCurWF2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURWFVER, (boolean)true) == 0) {
            return this.fetchTempCurWFVer(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEPDT, (boolean)true) == 0) {
            return this.fetchTempDEPDT(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchTempFormType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_MOB, (boolean)true) == 0) {
            return this.fetchTempMob(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_WF, (boolean)true) == 0) {
            return this.fetchTempWF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_WEB, (boolean)true) == 0) {
            return this.fetchTempWeb(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSDEViewBase)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSDEViewBase)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSDEViewBase)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDEViewBase)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_JITPREVIEW, (boolean)true) == 0) {
            this.jITPreview((PSDEViewBase)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PREVIEWSAVE, (boolean)true) == 0) {
            this.previewSave((PSDEViewBase)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDEViewBase)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchByType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_BYTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempByType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_BYTYPE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurAppAdd(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPADD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAppAdd(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPADD, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurAppNotAdd(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPNOTADD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAppNotAdd(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPNOTADD, true);
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

    public DBFetchResult fetchCurDE2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE2, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEMob(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEMOB, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEMob(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEMOB, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEWeb(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEWEB, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEWeb(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEWEB, true);
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

    public DBFetchResult fetchCurWF2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWF2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurWF2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWF2, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurWFVer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWFVER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurWFVer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWFVER, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDEPDT(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEPDT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDEPDT(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEPDT, true);
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

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchMob(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_MOB, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempMob(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_MOB, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchWF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_WF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempWF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_WF, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchWeb(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_WEB, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempWeb(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_WEB, true);
        return dBFetchResult;
    }

    public void createWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, pSDEViewBase, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEViewBase, ACTION_CREATEWITHMODEL);
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewBaseServiceBase.this.getService(), PSDEViewBaseServiceBase.ACTION_CREATEWITHMODEL, 40, pSDEViewBase2, null).getResult() != 1) {
                    PSDEViewBaseServiceBase.this.onCreateWithModel(pSDEViewBase2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, pSDEViewBase, null);
        }
    }

    protected void onCreateWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, pSDEViewBase, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEViewBase, ACTION_GETDRAFTFROMWITHMODEL);
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewBaseServiceBase.this.getService(), PSDEViewBaseServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, pSDEViewBase2, null).getResult() != 1) {
                    PSDEViewBaseServiceBase.this.onGetDraftFromWithModel(pSDEViewBase2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, pSDEViewBase, null);
        }
    }

    protected void onGetDraftFromWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, pSDEViewBase, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEViewBase, ACTION_GETDRAFTWITHMODEL);
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewBaseServiceBase.this.getService(), PSDEViewBaseServiceBase.ACTION_GETDRAFTWITHMODEL, 40, pSDEViewBase2, null).getResult() != 1) {
                    PSDEViewBaseServiceBase.this.onGetDraftWithModel(pSDEViewBase2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, pSDEViewBase, null);
        }
    }

    protected void onGetDraftWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, pSDEViewBase, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEViewBase, ACTION_GETWITHMODEL);
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewBaseServiceBase.this.getService(), PSDEViewBaseServiceBase.ACTION_GETWITHMODEL, 40, pSDEViewBase2, null).getResult() != 1) {
                    PSDEViewBaseServiceBase.this.onGetWithModel(pSDEViewBase2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, pSDEViewBase, null);
        }
    }

    protected void onGetWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void jITPreview(PSDEViewBase pSDEViewBase) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 0, pSDEViewBase, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEViewBase, ACTION_JITPREVIEW);
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewBaseServiceBase.this.getService(), PSDEViewBaseServiceBase.ACTION_JITPREVIEW, 40, pSDEViewBase2, null).getResult() != 1) {
                    PSDEViewBaseServiceBase.this.onJITPreview(pSDEViewBase2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 99, pSDEViewBase, null);
        }
    }

    protected void onJITPreview(PSDEViewBase pSDEViewBase) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[JITPREVIEW]");
    }

    public void previewSave(PSDEViewBase pSDEViewBase) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 0, pSDEViewBase, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEViewBase, ACTION_PREVIEWSAVE);
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewBaseServiceBase.this.getService(), PSDEViewBaseServiceBase.ACTION_PREVIEWSAVE, 40, pSDEViewBase2, null).getResult() != 1) {
                    PSDEViewBaseServiceBase.this.onPreviewSave(pSDEViewBase2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 99, pSDEViewBase, null);
        }
    }

    protected void onPreviewSave(PSDEViewBase pSDEViewBase) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PreviewSave]");
    }

    public void updateWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, pSDEViewBase, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEViewBase, ACTION_UPDATEWITHMODEL);
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewBaseServiceBase.this.getService(), PSDEViewBaseServiceBase.ACTION_UPDATEWITHMODEL, 40, pSDEViewBase2, null).getResult() != 1) {
                    PSDEViewBaseServiceBase.this.onUpdateWithModel(pSDEViewBase2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, pSDEViewBase, null);
        }
    }

    protected void onUpdateWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDEViewBase pSDEViewBase, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSACHandler);
            } else {
                iService.get(pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSDEViewBase, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSCODELIST_GROUPPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_GroupPSCodeList(pSDEViewBase, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlLogicGroup);
            } else {
                iService.get(pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEViewBase, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEViewBase, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSDEAWGROUP_PSDEAWGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEAWGroupService", (SessionFactory)this.getSessionFactory());
            PSDEAWGroup pSDEAWGroup = (PSDEAWGroup)iService.getDEModel().createEntity();
            pSDEAWGroup.set("PSDEAWGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAWGroup);
            } else {
                iService.get(pSDEAWGroup);
            }
            this.onFillParentInfo_PSDEAWGroup(pSDEViewBase, pSDEAWGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSDEMAINSTATE_PSDEMAINSTATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService", (SessionFactory)this.getSessionFactory());
            PSDEMainState pSDEMainState = (PSDEMainState)iService.getDEModel().createEntity();
            pSDEMainState.set("PSDEMAINSTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEMainState);
            } else {
                iService.get(pSDEMainState);
            }
            this.onFillParentInfo_PSDEMainState(pSDEViewBase, pSDEMainState);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSDEViewBase, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSDYNADEVIEWTEMPL_PSDYNADEVIEWTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEViewTemplService", (SessionFactory)this.getSessionFactory());
            PSDynaDEViewTempl pSDynaDEViewTempl = (PSDynaDEViewTempl)iService.getDEModel().createEntity();
            pSDynaDEViewTempl.set("PSDYNADEVIEWTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaDEViewTempl);
            } else {
                iService.get(pSDynaDEViewTempl);
            }
            this.onFillParentInfo_PSDynaDEViewTempl(pSDEViewBase, pSDynaDEViewTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSHELPMODULE_PSHELPMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService", (SessionFactory)this.getSessionFactory());
            PSHelpModule pSHelpModule = (PSHelpModule)iService.getDEModel().createEntity();
            pSHelpModule.set("PSHELPMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpModule);
            } else {
                iService.get(pSHelpModule);
            }
            this.onFillParentInfo_PSHelpModule(pSDEViewBase, pSHelpModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEViewBase, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSLANGUAGERES_SUBCAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_SubCapPSLanRes(pSDEViewBase, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSLANGUAGERES_TITLEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_TitlePSLanRes(pSDEViewBase, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSSUBVIEWTYPE_PSSUBVIEWTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeService", (SessionFactory)this.getSessionFactory());
            PSSubViewType pSSubViewType = (PSSubViewType)iService.getDEModel().createEntity();
            pSSubViewType.set("PSSUBVIEWTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubViewType);
            } else {
                iService.get(pSSubViewType);
            }
            this.onFillParentInfo_PSSubViewType(pSDEViewBase, pSSubViewType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCounter);
            } else {
                iService.get(pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSDEViewBase, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEViewBase, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEViewBase, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEViewBase, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEViewBase, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEViewBase, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDEViewBase, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniRes);
            } else {
                iService.get(pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSDEViewBase, pSSysUniRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSDEViewBase, pSSysViewPanel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSVIEWENGINE_PSVIEWENGINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewEngineService", (SessionFactory)this.getSessionFactory());
            PSViewEngine pSViewEngine = (PSViewEngine)iService.getDEModel().createEntity();
            pSViewEngine.set("PSVIEWENGINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewEngine);
            } else {
                iService.get(pSViewEngine);
            }
            this.onFillParentInfo_PSViewEngine(pSDEViewBase, pSViewEngine);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsgGroup);
            } else {
                iService.get(pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSDEViewBase, pSViewMsgGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSVTSTYLE_PSVTSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSVTStyleService", (SessionFactory)this.getSessionFactory());
            PSVTStyle pSVTStyle = (PSVTStyle)iService.getDEModel().createEntity();
            pSVTStyle.set("PSVTSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSVTStyle);
            } else {
                iService.get(pSVTStyle);
            }
            this.onFillParentInfo_PSVTStyle(pSDEViewBase, pSVTStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSWFDE_PSWFDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService", (SessionFactory)this.getSessionFactory());
            PSWFDE pSWFDE = (PSWFDE)iService.getDEModel().createEntity();
            pSWFDE.set("PSWFDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFDE);
            } else {
                iService.get(pSWFDE);
            }
            this.onFillParentInfo_PSWFDE(pSDEViewBase, pSWFDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFVersion);
            } else {
                iService.get(pSWFVersion);
            }
            this.onFillParentInfo_PSWFVersion(pSDEViewBase, pSWFVersion);
            return;
        }
        super.onFillParentInfo(pSDEViewBase, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSDEViewBase pSDEViewBase, PSACHandler pSACHandler) throws Exception {
        pSDEViewBase.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEViewBase.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_GroupPSCodeList(PSDEViewBase pSDEViewBase, PSCodeList pSCodeList) throws Exception {
        pSDEViewBase.setGroupPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEViewBase.setGroupPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSDEViewBase pSDEViewBase, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSDEViewBase.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSDEViewBase.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSDE(PSDEViewBase pSDEViewBase, PSDataEntity pSDataEntity) throws Exception {
        pSDEViewBase.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEViewBase.setPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSSystem() != null) {
            this.onFillParentInfo_PSSystem(pSDEViewBase, pSDataEntity.getPSSystem());
        }
    }

    protected void onFillParentInfo_PSDEAWGroup(PSDEViewBase pSDEViewBase, PSDEAWGroup pSDEAWGroup) throws Exception {
        pSDEViewBase.setPSDEAWGroupId(pSDEAWGroup.getPSDEAWGroupId());
        pSDEViewBase.setPSDEAWGroupName(pSDEAWGroup.getPSDEAWGroupName());
    }

    protected void onFillParentInfo_PSDEMainState(PSDEViewBase pSDEViewBase, PSDEMainState pSDEMainState) throws Exception {
        pSDEViewBase.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
        pSDEViewBase.setPSDEMainStateName(pSDEMainState.getPSDEMainStateName());
    }

    protected void onFillParentInfo_PSDER(PSDEViewBase pSDEViewBase, PSDER pSDER) throws Exception {
        pSDEViewBase.setPSDERId(pSDER.getPSDERId());
        pSDEViewBase.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSDynaDEViewTempl(PSDEViewBase pSDEViewBase, PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
        pSDEViewBase.setPSDynaDEViewTemplId(pSDynaDEViewTempl.getPSDynaDEViewTemplId());
        pSDEViewBase.setPSDynaDEViewTemplName(pSDynaDEViewTempl.getPSDynaDEViewTemplName());
    }

    protected void onFillParentInfo_PSHelpModule(PSDEViewBase pSDEViewBase, PSHelpModule pSHelpModule) throws Exception {
        pSDEViewBase.setPSHelpModuleId(pSHelpModule.getPSHelpModuleId());
        pSDEViewBase.setPSHelpModuleName(pSHelpModule.getPSHelpModuleName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEViewBase pSDEViewBase, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEViewBase.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEViewBase.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_SubCapPSLanRes(PSDEViewBase pSDEViewBase, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEViewBase.setSubCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEViewBase.setSubCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TitlePSLanRes(PSDEViewBase pSDEViewBase, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEViewBase.setTitlePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEViewBase.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSubViewType(PSDEViewBase pSDEViewBase, PSSubViewType pSSubViewType) throws Exception {
        pSDEViewBase.setPSSubViewTypeId(pSSubViewType.getPSSubViewTypeId());
        pSDEViewBase.setPSSubViewTypeName(pSSubViewType.getPSSubViewTypeName());
    }

    protected void onFillParentInfo_PSSysCounter(PSDEViewBase pSDEViewBase, PSSysCounter pSSysCounter) throws Exception {
        pSDEViewBase.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSDEViewBase.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEViewBase pSDEViewBase, PSSysCss pSSysCss) throws Exception {
        pSDEViewBase.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEViewBase.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEViewBase pSDEViewBase, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEViewBase.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEViewBase.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEViewBase pSDEViewBase, PSSysImage pSSysImage) throws Exception {
        pSDEViewBase.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEViewBase.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEViewBase pSDEViewBase, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEViewBase.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEViewBase.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEViewBase pSDEViewBase, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEViewBase.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEViewBase.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSystem(PSDEViewBase pSDEViewBase, PSSystem pSSystem) throws Exception {
        pSDEViewBase.setPSSystemId(pSSystem.getPSSystemId());
        pSDEViewBase.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSDEViewBase pSDEViewBase, PSSysUniRes pSSysUniRes) throws Exception {
        pSDEViewBase.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSDEViewBase.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSDEViewBase pSDEViewBase, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDEViewBase.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDEViewBase.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillParentInfo_PSViewEngine(PSDEViewBase pSDEViewBase, PSViewEngine pSViewEngine) throws Exception {
        pSDEViewBase.setPSViewEngineId(pSViewEngine.getPSViewEngineId());
        pSDEViewBase.setPSViewEngineName(pSViewEngine.getPSViewEngineName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSDEViewBase pSDEViewBase, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSDEViewBase.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSDEViewBase.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillParentInfo_PSVTStyle(PSDEViewBase pSDEViewBase, PSVTStyle pSVTStyle) throws Exception {
        pSDEViewBase.setPSVTStyleId(pSVTStyle.getPSVTStyleId());
        pSDEViewBase.setPSVTStyleName(pSVTStyle.getPSVTStyleName());
    }

    protected void onFillParentInfo_PSWFDE(PSDEViewBase pSDEViewBase, PSWFDE pSWFDE) throws Exception {
        pSDEViewBase.setPSWFDEId(pSWFDE.getPSWFDEId());
        pSDEViewBase.setPSWFDEName(pSWFDE.getPSWFDEName());
        pSDEViewBase.setPSWFId(pSWFDE.getPSWFId());
    }

    protected void onFillParentInfo_PSWFVersion(PSDEViewBase pSDEViewBase, PSWFVersion pSWFVersion) throws Exception {
        pSDEViewBase.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
        pSDEViewBase.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
    }

    protected void onFillEntityFullInfo(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        if (bl) {
            if (pSDEViewBase.getModelState() == null) {
                pSDEViewBase.setModelState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEViewBase.getPSAppViewCnt() == null) {
                pSDEViewBase.setPSAppViewCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEViewBase.getPSAppViewsCnt() == null) {
                pSDEViewBase.setPSAppViewsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEViewBase.getReadOnlyMode() == null) {
                pSDEViewBase.setReadOnlyMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSACHandler(pSDEViewBase, bl);
        this.onFillEntityFullInfo_GroupPSCodeList(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSDE(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSDEAWGroup(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSDEMainState(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSDER(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSDynaDEViewTempl(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSHelpModule(pSDEViewBase, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEViewBase, bl);
        this.onFillEntityFullInfo_SubCapPSLanRes(pSDEViewBase, bl);
        this.onFillEntityFullInfo_TitlePSLanRes(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSSubViewType(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSSystem(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSViewEngine(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSVTStyle(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSWFDE(pSDEViewBase, bl);
        this.onFillEntityFullInfo_PSWFVersion(pSDEViewBase, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSCodeList(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        if (pSDEViewBase.isPSDEIdDirty()) {
            if (pSDEViewBase.getPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSDEViewBase.getPSDEId() == null || pSDEViewBase.getPSDEName() == null) {
                    pSDataEntity = pSDEViewBase.getPSDE();
                    pSDEViewBase.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSDEViewBase.getPSDE()).getPSSystemId(), (Object)pSDEViewBase.getPSSystemId()) != 0L) {
                    pSDEViewBase.setPSSystemId(pSDataEntity.getPSSystemId());
                    this.onFillEntityFullInfo_PSSystem(pSDEViewBase, bl);
                }
            } else {
                pSDEViewBase.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEAWGroup(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEMainState(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDER(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        if (pSDEViewBase.isPSDERIdDirty()) {
            if (pSDEViewBase.getPSDERId() != null) {
                if (pSDEViewBase.getPSDERId() == null || pSDEViewBase.getPSDERName() == null) {
                    PSDER pSDER = pSDEViewBase.getPSDER();
                    pSDEViewBase.setPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDEViewBase.setPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDynaDEViewTempl(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSHelpModule(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        if (pSDEViewBase.isCapPSLanResIdDirty()) {
            if (pSDEViewBase.getCapPSLanResId() != null) {
                if (pSDEViewBase.getCapPSLanResId() == null || pSDEViewBase.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEViewBase.getCapPSLanRes();
                    pSDEViewBase.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEViewBase.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SubCapPSLanRes(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        if (pSDEViewBase.isSubCapPSLanResIdDirty()) {
            if (pSDEViewBase.getSubCapPSLanResId() != null) {
                if (pSDEViewBase.getSubCapPSLanResId() == null || pSDEViewBase.getSubCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEViewBase.getSubCapPSLanRes();
                    pSDEViewBase.setSubCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEViewBase.setSubCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TitlePSLanRes(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        if (pSDEViewBase.isTitlePSLanResIdDirty()) {
            if (pSDEViewBase.getTitlePSLanResId() != null) {
                if (pSDEViewBase.getTitlePSLanResId() == null || pSDEViewBase.getTitlePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEViewBase.getTitlePSLanRes();
                    pSDEViewBase.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEViewBase.setTitlePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSubViewType(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewEngine(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        if (pSDEViewBase.isPSViewEngineIdDirty()) {
            if (pSDEViewBase.getPSViewEngineId() != null) {
                if (pSDEViewBase.getPSViewEngineId() == null || pSDEViewBase.getPSViewEngineName() == null) {
                    PSViewEngine pSViewEngine = pSDEViewBase.getPSViewEngine();
                    pSDEViewBase.setPSViewEngineName(pSViewEngine.getPSViewEngineName());
                }
            } else {
                pSDEViewBase.setPSViewEngineName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSVTStyle(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFDE(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFVersion(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEViewBase, bl);
    }

    public ArrayList<PSDEViewBase> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewBase> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByGroupPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByGroupPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewBase> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewBase> selectByPSDEAWGroup(PSDEAWGroupBase pSDEAWGroupBase) throws Exception {
        return this.selectByPSDEAWGroup(pSDEAWGroupBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSDEAWGroup(PSDEAWGroupBase pSDEAWGroupBase, String string) throws Exception {
        return this.selectByPSDEAWGroup(pSDEAWGroupBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSDEAWGroup(PSDEAWGroupBase pSDEAWGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEAWGROUPID", (Object)pSDEAWGroupBase.getPSDEAWGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEAWGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEAWGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAINSTATEID", (Object)pSDEMainStateBase.getPSDEMainStateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEMainStateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEMainStateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSDynaDEViewTempl(PSDynaDEViewTemplBase pSDynaDEViewTemplBase) throws Exception {
        return this.selectByPSDynaDEViewTempl(pSDynaDEViewTemplBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSDynaDEViewTempl(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, String string) throws Exception {
        return this.selectByPSDynaDEViewTempl(pSDynaDEViewTemplBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSDynaDEViewTempl(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNADEVIEWTEMPLID", (Object)pSDynaDEViewTemplBase.getPSDynaDEViewTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaDEViewTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaDEViewTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSHelpModule(PSHelpModuleBase pSHelpModuleBase) throws Exception {
        return this.selectByPSHelpModule(pSHelpModuleBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSHelpModule(PSHelpModuleBase pSHelpModuleBase, String string) throws Exception {
        return this.selectByPSHelpModule(pSHelpModuleBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSHelpModule(PSHelpModuleBase pSHelpModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPMODULEID", (Object)pSHelpModuleBase.getPSHelpModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectBySubCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectBySubCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectBySubCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectBySubCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectBySubCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SUBCAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySubCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySubCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TITLEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTitlePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTitlePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSSubViewType(PSSubViewTypeBase pSSubViewTypeBase) throws Exception {
        return this.selectByPSSubViewType(pSSubViewTypeBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSubViewType(PSSubViewTypeBase pSSubViewTypeBase, String string) throws Exception {
        return this.selectByPSSubViewType(pSSubViewTypeBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSubViewType(PSSubViewTypeBase pSSubViewTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBVIEWTYPEID", (Object)pSSubViewTypeBase.getPSSubViewTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubViewTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubViewTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewBase> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewBase> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewBase> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSIMAGEID", (Object)pSSysImageBase.getPSSysImageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysImageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysImageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewBase> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewBase> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewBase> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNIRESID", (Object)pSSysUniResBase.getPSSysUniResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUniResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUniResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewPanelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSViewEngine(PSViewEngineBase pSViewEngineBase) throws Exception {
        return this.selectByPSViewEngine(pSViewEngineBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSViewEngine(PSViewEngineBase pSViewEngineBase, String string) throws Exception {
        return this.selectByPSViewEngine(pSViewEngineBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSViewEngine(PSViewEngineBase pSViewEngineBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWENGINEID", (Object)pSViewEngineBase.getPSViewEngineId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewEngineCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewEngineCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewBase> selectByPSVTStyle(PSVTStyleBase pSVTStyleBase) throws Exception {
        return this.selectByPSVTStyle(pSVTStyleBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSVTStyle(PSVTStyleBase pSVTStyleBase, String string) throws Exception {
        return this.selectByPSVTStyle(pSVTStyleBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSVTStyle(PSVTStyleBase pSVTStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVTSTYLEID", (Object)pSVTStyleBase.getPSVTStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSVTStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSVTStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewBase> selectByPSWFDE(PSWFDEBase pSWFDEBase) throws Exception {
        return this.selectByPSWFDE(pSWFDEBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSWFDE(PSWFDEBase pSWFDEBase, String string) throws Exception {
        return this.selectByPSWFDE(pSWFDEBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSWFDE(PSWFDEBase pSWFDEBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewBase> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSDEViewBase> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSDEViewBase> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
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

    public void testRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSACHandlerId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByGroupPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSCODELIST_GROUPPSCODELISTID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByGroupPSCodeList(pSCodeList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setGroupPSCodeListId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByGroupPSCodeList(pSCodeList2);
                PSDEViewBaseServiceBase.this.internalRemoveByGroupPSCodeList(pSCodeList2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByGroupPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByGroupPSCodeList(pSCodeList);
        this.onBeforeRemoveByGroupPSCodeList(pSCodeList, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByGroupPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSCtrlLogicGroupId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSDEId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDEAWGroup(pSDEAWGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEAWGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAWGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSDEAWGROUP_PSDEAWGROUPID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSDEAWGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDEAWGroup(pSDEAWGroup);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSDEAWGroupId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
        final PSDEAWGroup pSDEAWGroup2 = pSDEAWGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSDEAWGroup(pSDEAWGroup2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSDEAWGroup(pSDEAWGroup2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSDEAWGroup(pSDEAWGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
    }

    protected void internalRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDEAWGroup(pSDEAWGroup);
        this.onBeforeRemoveByPSDEAWGroup(pSDEAWGroup, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSDEAWGroup(pSDEAWGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAWGroup(PSDEAWGroup pSDEAWGroup, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDEMainState(pSDEMainState, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEMAINSTATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEMainState);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSDEMAINSTATE_PSDEMAINSTATEID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSDEMainState), arrayList.get(0)));
        }
    }

    public void resetPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDEMainState(pSDEMainState);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSDEMainStateId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSDEMainState(pSDEMainState2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSDEMainState(pSDEMainState2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSDEMainState(pSDEMainState2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void internalRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDEMainState(pSDEMainState);
        this.onBeforeRemoveByPSDEMainState(pSDEMainState, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSDEMainState(pSDEMainState, arrayList);
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDER(pSDER);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSDERId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDynaDEViewTempl(pSDynaDEViewTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNADEVIEWTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaDEViewTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSDYNADEVIEWTEMPL_PSDYNADEVIEWTEMPLID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSDynaDEViewTempl), arrayList.get(0)));
        }
    }

    public void resetPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDynaDEViewTempl(pSDynaDEViewTempl);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSDynaDEViewTemplId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
        final PSDynaDEViewTempl pSDynaDEViewTempl2 = pSDynaDEViewTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSDynaDEViewTempl(pSDynaDEViewTempl2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSDynaDEViewTempl(pSDynaDEViewTempl2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSDynaDEViewTempl(pSDynaDEViewTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
    }

    protected void internalRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSDynaDEViewTempl(pSDynaDEViewTempl);
        this.onBeforeRemoveByPSDynaDEViewTempl(pSDynaDEViewTempl, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSDynaDEViewTempl(pSDynaDEViewTempl, arrayList);
    }

    protected void onAfterRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSHelpModule(pSHelpModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSHELPMODULE_PSHELPMODULEID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSHelpModule), arrayList.get(0)));
        }
    }

    public void resetPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSHelpModule(pSHelpModule);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSHelpModuleId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        final PSHelpModule pSHelpModule2 = pSHelpModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSHelpModule(pSHelpModule2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSHelpModule(pSHelpModule2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSHelpModule(pSHelpModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
    }

    protected void internalRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSHelpModule(pSHelpModule);
        this.onBeforeRemoveByPSHelpModule(pSHelpModule, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSHelpModule(pSHelpModule, arrayList);
    }

    protected void onAfterRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpModule(PSHelpModule pSHelpModule, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpModule(PSHelpModule pSHelpModule, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setCapPSLanResId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEViewBaseServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectBySubCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSLANGUAGERES_SUBCAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetSubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectBySubCapPSLanRes(pSLanguageRes);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setSubCapPSLanResId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeBySubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveBySubCapPSLanRes(pSLanguageRes2);
                PSDEViewBaseServiceBase.this.internalRemoveBySubCapPSLanRes(pSLanguageRes2);
                PSDEViewBaseServiceBase.this.onAfterRemoveBySubCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectBySubCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveBySubCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveBySubCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByTitlePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSLANGUAGERES_TITLEPSLANRESID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setTitlePSLanResId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes2);
                PSDEViewBaseServiceBase.this.internalRemoveByTitlePSLanRes(pSLanguageRes2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByTitlePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
    }

    public void resetPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSubViewType(pSSubViewType);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSSubViewTypeId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
        final PSSubViewType pSSubViewType2 = pSSubViewType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSSubViewType(pSSubViewType2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSSubViewType(pSSubViewType2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSSubViewType(pSSubViewType2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
    }

    protected void internalRemoveByPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSubViewType(pSSubViewType);
        this.onBeforeRemoveByPSSubViewType(pSSubViewType, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSSubViewType(pSSubViewType, arrayList);
    }

    protected void onAfterRemoveByPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
    }

    protected void onBeforeRemoveByPSSubViewType(PSSubViewType pSSubViewType, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubViewType(PSSubViewType pSSubViewType, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSSysCounterId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSSysCssId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSSysDynaModelId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSSysImageId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSSysPFPluginId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSSysReqItemId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSSystemId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSSysUniResId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSSysViewPanelId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
    }

    public void resetPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSViewEngine(pSViewEngine);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSViewEngineId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
        final PSViewEngine pSViewEngine2 = pSViewEngine;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSViewEngine(pSViewEngine2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSViewEngine(pSViewEngine2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSViewEngine(pSViewEngine2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
    }

    protected void internalRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSViewEngine(pSViewEngine);
        this.onBeforeRemoveByPSViewEngine(pSViewEngine, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSViewEngine(pSViewEngine, arrayList);
    }

    protected void onAfterRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
    }

    protected void onBeforeRemoveByPSViewEngine(PSViewEngine pSViewEngine, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewEngine(PSViewEngine pSViewEngine, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSViewMsgGroupId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSVTStyle(PSVTStyle pSVTStyle) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSVTStyle(pSVTStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVTSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSVTStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWBASE_PSVTSTYLE_PSVTSTYLEID", "", iDataEntityModel.getName(), "PSDEVIEWBASE", iDataEntityModel.getDataInfo(pSVTStyle), arrayList.get(0)));
        }
    }

    public void resetPSVTStyle(PSVTStyle pSVTStyle) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSVTStyle(pSVTStyle);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSVTStyleId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSVTStyle(PSVTStyle pSVTStyle) throws Exception {
        final PSVTStyle pSVTStyle2 = pSVTStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSVTStyle(pSVTStyle2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSVTStyle(pSVTStyle2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSVTStyle(pSVTStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSVTStyle(PSVTStyle pSVTStyle) throws Exception {
    }

    protected void internalRemoveByPSVTStyle(PSVTStyle pSVTStyle) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSVTStyle(pSVTStyle);
        this.onBeforeRemoveByPSVTStyle(pSVTStyle, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSVTStyle(pSVTStyle, arrayList);
    }

    protected void onAfterRemoveByPSVTStyle(PSVTStyle pSVTStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSVTStyle(PSVTStyle pSVTStyle, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSVTStyle(PSVTStyle pSVTStyle, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    public void resetPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSWFDE(pSWFDE);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSWFDEId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSWFDE(PSWFDE pSWFDE) throws Exception {
        final PSWFDE pSWFDE2 = pSWFDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSWFDE(pSWFDE2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSWFDE(pSWFDE2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSWFDE(pSWFDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void internalRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSWFDE(pSWFDE);
        this.onBeforeRemoveByPSWFDE(pSWFDE, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSWFDE(pSWFDE, arrayList);
    }

    protected void onAfterRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void onBeforeRemoveByPSWFDE(PSWFDE pSWFDE, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFDE(PSWFDE pSWFDE, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    public void testRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    public void resetPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSWFVersion(pSWFVersion);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            PSDEViewBase pSDEViewBase2 = (PSDEViewBase)this.getDEModel().createEntity();
            pSDEViewBase2.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewBase2.setPSWFVersionId(null);
            this.update(pSDEViewBase2);
        }
    }

    public void removeByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseServiceBase.this.onBeforeRemoveByPSWFVersion(pSWFVersion2);
                PSDEViewBaseServiceBase.this.internalRemoveByPSWFVersion(pSWFVersion2);
                PSDEViewBaseServiceBase.this.onAfterRemoveByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSDEViewBase> arrayList = this.selectByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveByPSWFVersion(pSWFVersion, arrayList);
        for (PSDEViewBase pSDEViewBase : arrayList) {
            this.remove(pSDEViewBase);
        }
        this.onAfterRemoveByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSDEViewBase> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEViewBase pSDEViewBase) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppDEViewRefService)ServiceGlobal.getService(PSAppDEViewRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppDEViewRefServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        ((PSAppDEViewRefServiceBase)pSCoreSysServiceBase).removeByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByLinkPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByMDPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveBySDPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        ((PSAppViewServiceBase)pSCoreSysServiceBase).removeByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByLinkPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByLinkPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByPickupPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataRelationServiceBase)pSCoreSysServiceBase).testRemoveByFormPSDEviewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByNavPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByRefLinkPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByRefMPickupPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByRefPickupPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByLinkPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByOpenPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPickupPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByRefMobMPickupPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByRefMobPickupPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByRefMPickupPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByRefPickupPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByLinkPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPickupPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByNavPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByNavPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByLinkPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByMDPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByMobLinkPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByMobMDPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByMobSDPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByRSPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveBySDPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).testRemoveByOpenPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByLinkPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByPickupPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDETreeNodeRVService)ServiceGlobal.getService(PSDETreeNodeRVService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeRVServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByMobPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).removeByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).removeByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEViewGrpDetailService)ServiceGlobal.getService(PSDEViewGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).removeByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewRVServiceBase)pSCoreSysServiceBase).testRemoveByMajorPSDEView(pSDEViewBase);
        ((PSDEViewRVServiceBase)pSCoreSysServiceBase).removeByMajorPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewRVServiceBase)pSCoreSysServiceBase).testRemoveByMinorPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEViewServiceService)ServiceGlobal.getService(PSDEViewServiceService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewServiceServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMeasureServiceBase)pSCoreSysServiceBase).testRemoveByDrillDetailPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMeasureServiceBase)pSCoreSysServiceBase).testRemoveByDrillDownPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeServiceBase)pSCoreSysServiceBase).testRemoveByDrillDetailPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeServiceBase)pSCoreSysServiceBase).testRemoveByDrillDownPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysCalendarItemRVService)ServiceGlobal.getService(PSSysCalendarItemRVService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemRVServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPDTViewServiceBase)pSCoreSysServiceBase).testRemoveByMobPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPDTViewServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByOpenPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByRefLinkPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByRefPickupPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByActionMobPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByActionPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByMobProxyData2PSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByMobProxyDataPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByProxyData2PSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByProxyDataPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByStartMobPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByStartPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).testRemoveByMobPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByMobPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewBase(pSDEViewBase);
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).resetPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkflowServiceBase)pSCoreSysServiceBase).testRemoveByActionMobPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkflowServiceBase)pSCoreSysServiceBase).testRemoveByActionPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkflowServiceBase)pSCoreSysServiceBase).testRemoveByStartMobPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkflowServiceBase)pSCoreSysServiceBase).testRemoveByStartPSDEView(pSDEViewBase);
        super.onBeforeRemove(pSDEViewBase);
    }

    protected void onBeforeRemoveTemp(PSDEViewBase pSDEViewBase) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).removeTempByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDEViewBase(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewRVServiceBase)pSCoreSysServiceBase).removeTempByMajorPSDEView(pSDEViewBase);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).removeTempByPSDEViewBase(pSDEViewBase);
        super.onBeforeRemoveTemp(pSDEViewBase);
    }

    protected void getRelatedDataTempMajor(PSDEViewBase pSDEViewBase) throws Exception {
        this.getRelatedDataTempMajor_PSDEViewCtrl(pSDEViewBase);
        this.getRelatedDataTempMajor_PSDEViewRV(pSDEViewBase);
        this.getRelatedDataTempMajor_PSDEViewLogic(pSDEViewBase);
        this.getRelatedDataTempMajor_PSDEViewEngine(pSDEViewBase);
        super.getRelatedDataTempMajor(pSDEViewBase);
    }

    protected void getRelatedDataTempMajor_PSDEViewCtrl(PSDEViewBase pSDEViewBase) throws Exception {
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewCtrl> arrayList = null;
        String string = pSDEViewBase.getPSDEViewBaseId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEViewCtrlService.selectByPSDEViewBase(pSDEViewBase) : pSDEViewCtrlService.selectTempByPSDEViewBase(pSDEViewBase);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            pSDEViewCtrlService.getTempMajor(pSDEViewCtrl);
        }
    }

    protected void getRelatedDataTempMajor_PSDEViewRV(PSDEViewBase pSDEViewBase) throws Exception {
        PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewRV> arrayList = null;
        String string = pSDEViewBase.getPSDEViewBaseId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEViewRVService.selectByMajorPSDEView(pSDEViewBase) : pSDEViewRVService.selectTempByMajorPSDEView(pSDEViewBase);
        for (PSDEViewRV pSDEViewRV : arrayList) {
            pSDEViewRVService.getTempMajor(pSDEViewRV);
        }
    }

    protected void getRelatedDataTempMajor_PSDEViewLogic(PSDEViewBase pSDEViewBase) throws Exception {
        PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewLogic> arrayList = null;
        String string = pSDEViewBase.getPSDEViewBaseId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEViewLogicService.selectByPSDEViewBase(pSDEViewBase) : pSDEViewLogicService.selectTempByPSDEViewBase(pSDEViewBase);
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            pSDEViewLogicService.getTempMajor(pSDEViewLogic);
        }
    }

    protected void getRelatedDataTempMajor_PSDEViewEngine(PSDEViewBase pSDEViewBase) throws Exception {
        PSDEViewEngineService pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewEngine> arrayList = null;
        String string = pSDEViewBase.getPSDEViewBaseId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEViewEngineService.selectByPSDEViewBase(pSDEViewBase) : pSDEViewEngineService.selectTempByPSDEViewBase(pSDEViewBase);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            pSDEViewEngineService.getTempMajor(pSDEViewEngine);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEViewBase pSDEViewBase, PSDEViewBase pSDEViewBase2) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.updateRelatedDataTempMajor_removePSDEViewEngine(pSDEViewBase, pSDEViewBase2);
        ArrayList<PSDEViewLogic> arrayList2 = this.updateRelatedDataTempMajor_removePSDEViewLogic(pSDEViewBase, pSDEViewBase2);
        ArrayList<PSDEViewRV> arrayList3 = this.updateRelatedDataTempMajor_removePSDEViewRV(pSDEViewBase, pSDEViewBase2);
        ArrayList<PSDEViewCtrl> arrayList4 = this.updateRelatedDataTempMajor_removePSDEViewCtrl(pSDEViewBase, pSDEViewBase2);
        this.updateRelatedDataTempMajor_updatePSDEViewCtrl(pSDEViewBase, pSDEViewBase2, arrayList4);
        this.updateRelatedDataTempMajor_updatePSDEViewRV(pSDEViewBase, pSDEViewBase2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSDEViewLogic(pSDEViewBase, pSDEViewBase2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEViewEngine(pSDEViewBase, pSDEViewBase2, arrayList);
        super.updateRelatedDataTempMajor(pSDEViewBase, pSDEViewBase2);
    }

    protected ArrayList<PSDEViewCtrl> updateRelatedDataTempMajor_removePSDEViewCtrl(PSDEViewBase pSDEViewBase, PSDEViewBase pSDEViewBase2) throws Exception {
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewCtrl> arrayList = pSDEViewCtrlService.selectTempByPSDEViewBase(pSDEViewBase);
        ArrayList<PSDEViewCtrl> arrayList2 = pSDEViewCtrlService.selectByPSDEViewBase(pSDEViewBase2);
        HashMap<String, PSDEViewCtrl> hashMap = new HashMap<String, PSDEViewCtrl>();
        for (PSDEViewCtrl pSDEViewCtrl : arrayList2) {
            hashMap.put(pSDEViewCtrl.getPSDEViewCtrlId(), pSDEViewCtrl);
        }
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            Object object = pSDEViewCtrl.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEViewCtrl pSDEViewCtrl : hashMap.values()) {
            pSDEViewCtrlService.remove(pSDEViewCtrl);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEViewCtrl(PSDEViewBase pSDEViewBase, PSDEViewBase pSDEViewBase2, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            pSDEViewCtrlService.updateTempMajor(pSDEViewCtrl);
        }
    }

    protected ArrayList<PSDEViewRV> updateRelatedDataTempMajor_removePSDEViewRV(PSDEViewBase pSDEViewBase, PSDEViewBase pSDEViewBase2) throws Exception {
        PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewRV> arrayList = pSDEViewRVService.selectTempByMajorPSDEView(pSDEViewBase);
        ArrayList<PSDEViewRV> arrayList2 = pSDEViewRVService.selectByMajorPSDEView(pSDEViewBase2);
        HashMap<String, PSDEViewRV> hashMap = new HashMap<String, PSDEViewRV>();
        for (PSDEViewRV pSDEViewRV : arrayList2) {
            hashMap.put(pSDEViewRV.getPSDEViewRVId(), pSDEViewRV);
        }
        for (PSDEViewRV pSDEViewRV : arrayList) {
            Object object = pSDEViewRV.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEViewRV pSDEViewRV : hashMap.values()) {
            pSDEViewRVService.remove(pSDEViewRV);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEViewRV(PSDEViewBase pSDEViewBase, PSDEViewBase pSDEViewBase2, ArrayList<PSDEViewRV> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEViewRV pSDEViewRV : arrayList) {
            pSDEViewRVService.updateTempMajor(pSDEViewRV);
        }
    }

    protected ArrayList<PSDEViewLogic> updateRelatedDataTempMajor_removePSDEViewLogic(PSDEViewBase pSDEViewBase, PSDEViewBase pSDEViewBase2) throws Exception {
        PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewLogic> arrayList = pSDEViewLogicService.selectTempByPSDEViewBase(pSDEViewBase);
        ArrayList<PSDEViewLogic> arrayList2 = pSDEViewLogicService.selectByPSDEViewBase(pSDEViewBase2);
        HashMap<String, PSDEViewLogic> hashMap = new HashMap<String, PSDEViewLogic>();
        for (PSDEViewLogic pSDEViewLogic : arrayList2) {
            hashMap.put(pSDEViewLogic.getPSDEViewLogicId(), pSDEViewLogic);
        }
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            Object object = pSDEViewLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEViewLogic pSDEViewLogic : hashMap.values()) {
            pSDEViewLogicService.remove(pSDEViewLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEViewLogic(PSDEViewBase pSDEViewBase, PSDEViewBase pSDEViewBase2, ArrayList<PSDEViewLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEViewLogic pSDEViewLogic : arrayList) {
            pSDEViewLogicService.updateTempMajor(pSDEViewLogic);
        }
    }

    protected ArrayList<PSDEViewEngine> updateRelatedDataTempMajor_removePSDEViewEngine(PSDEViewBase pSDEViewBase, PSDEViewBase pSDEViewBase2) throws Exception {
        PSDEViewEngineService pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewEngine> arrayList = pSDEViewEngineService.selectTempByPSDEViewBase(pSDEViewBase);
        ArrayList<PSDEViewEngine> arrayList2 = pSDEViewEngineService.selectByPSDEViewBase(pSDEViewBase2);
        HashMap<String, PSDEViewEngine> hashMap = new HashMap<String, PSDEViewEngine>();
        for (PSDEViewEngine pSDEViewEngine : arrayList2) {
            hashMap.put(pSDEViewEngine.getPSDEViewEngineId(), pSDEViewEngine);
        }
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            Object object = pSDEViewEngine.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEViewEngine pSDEViewEngine : hashMap.values()) {
            pSDEViewEngineService.remove(pSDEViewEngine);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEViewEngine(PSDEViewBase pSDEViewBase, PSDEViewBase pSDEViewBase2, ArrayList<PSDEViewEngine> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEViewEngineService pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            pSDEViewEngineService.updateTempMajor(pSDEViewEngine);
        }
    }

    protected void replaceParentInfo(PSDEViewBase pSDEViewBase, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEViewBase, cloneSession);
        if (pSDEViewBase.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEViewBase.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSDEViewBase, (PSACHandler)iEntity);
        }
        if (pSDEViewBase.getGroupPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEViewBase.getGroupPSCodeListId())) != null) {
            this.onFillParentInfo_GroupPSCodeList(pSDEViewBase, (PSCodeList)iEntity);
        }
        if (pSDEViewBase.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSDEViewBase.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEViewBase, (PSCtrlLogicGroup)iEntity);
        }
        if (pSDEViewBase.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEViewBase.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEViewBase, (PSDataEntity)iEntity);
        }
        if (pSDEViewBase.getPSDEAWGroupId() != null && (iEntity = cloneSession.getEntity("PSDEAWGROUP", (Object)pSDEViewBase.getPSDEAWGroupId())) != null) {
            this.onFillParentInfo_PSDEAWGroup(pSDEViewBase, (PSDEAWGroup)iEntity);
        }
        if (pSDEViewBase.getPSDEMainStateId() != null && (iEntity = cloneSession.getEntity("PSDEMAINSTATE", (Object)pSDEViewBase.getPSDEMainStateId())) != null) {
            this.onFillParentInfo_PSDEMainState(pSDEViewBase, (PSDEMainState)iEntity);
        }
        if (pSDEViewBase.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEViewBase.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSDEViewBase, (PSDER)iEntity);
        }
        if (pSDEViewBase.getPSDynaDEViewTemplId() != null && (iEntity = cloneSession.getEntity("PSDYNADEVIEWTEMPL", (Object)pSDEViewBase.getPSDynaDEViewTemplId())) != null) {
            this.onFillParentInfo_PSDynaDEViewTempl(pSDEViewBase, (PSDynaDEViewTempl)iEntity);
        }
        if (pSDEViewBase.getPSHelpModuleId() != null && (iEntity = cloneSession.getEntity("PSHELPMODULE", (Object)pSDEViewBase.getPSHelpModuleId())) != null) {
            this.onFillParentInfo_PSHelpModule(pSDEViewBase, (PSHelpModule)iEntity);
        }
        if (pSDEViewBase.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEViewBase.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEViewBase, (PSLanguageRes)iEntity);
        }
        if (pSDEViewBase.getSubCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEViewBase.getSubCapPSLanResId())) != null) {
            this.onFillParentInfo_SubCapPSLanRes(pSDEViewBase, (PSLanguageRes)iEntity);
        }
        if (pSDEViewBase.getTitlePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEViewBase.getTitlePSLanResId())) != null) {
            this.onFillParentInfo_TitlePSLanRes(pSDEViewBase, (PSLanguageRes)iEntity);
        }
        if (pSDEViewBase.getPSSubViewTypeId() != null && (iEntity = cloneSession.getEntity("PSSUBVIEWTYPE", (Object)pSDEViewBase.getPSSubViewTypeId())) != null) {
            this.onFillParentInfo_PSSubViewType(pSDEViewBase, (PSSubViewType)iEntity);
        }
        if (pSDEViewBase.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSDEViewBase.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSDEViewBase, (PSSysCounter)iEntity);
        }
        if (pSDEViewBase.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEViewBase.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEViewBase, (PSSysCss)iEntity);
        }
        if (pSDEViewBase.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEViewBase.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEViewBase, (PSSysDynaModel)iEntity);
        }
        if (pSDEViewBase.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEViewBase.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEViewBase, (PSSysImage)iEntity);
        }
        if (pSDEViewBase.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEViewBase.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEViewBase, (PSSysPFPlugin)iEntity);
        }
        if (pSDEViewBase.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEViewBase.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEViewBase, (PSSysReqItem)iEntity);
        }
        if (pSDEViewBase.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDEViewBase.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDEViewBase, (PSSystem)iEntity);
        }
        if (pSDEViewBase.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSDEViewBase.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSDEViewBase, (PSSysUniRes)iEntity);
        }
        if (pSDEViewBase.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDEViewBase.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSDEViewBase, (PSSysViewPanel)iEntity);
        }
        if (pSDEViewBase.getPSViewEngineId() != null && (iEntity = cloneSession.getEntity("PSVIEWENGINE", (Object)pSDEViewBase.getPSViewEngineId())) != null) {
            this.onFillParentInfo_PSViewEngine(pSDEViewBase, (PSViewEngine)iEntity);
        }
        if (pSDEViewBase.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSDEViewBase.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSDEViewBase, (PSViewMsgGroup)iEntity);
        }
        if (pSDEViewBase.getPSVTStyleId() != null && (iEntity = cloneSession.getEntity("PSVTSTYLE", (Object)pSDEViewBase.getPSVTStyleId())) != null) {
            this.onFillParentInfo_PSVTStyle(pSDEViewBase, (PSVTStyle)iEntity);
        }
        if (pSDEViewBase.getPSWFDEId() != null && (iEntity = cloneSession.getEntity("PSWFDE", (Object)pSDEViewBase.getPSWFDEId())) != null) {
            this.onFillParentInfo_PSWFDE(pSDEViewBase, (PSWFDE)iEntity);
        }
        if (pSDEViewBase.getPSWFVersionId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSDEViewBase.getPSWFVersionId())) != null) {
            this.onFillParentInfo_PSWFVersion(pSDEViewBase, (PSWFVersion)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEViewBase, bl);
        pSDEViewBase.resetCapPSLanResId();
        pSDEViewBase.resetCapPSLanResName();
        pSDEViewBase.resetDEViewTag();
        pSDEViewBase.resetDEViewTag2();
        pSDEViewBase.resetDEViewTag3();
        pSDEViewBase.resetDEViewTag4();
        pSDEViewBase.resetSubCapPSLanResId();
        pSDEViewBase.resetSubCapPSLanResName();
    }

    protected void onCheckEntity(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AccUserMode(bl, pSDEViewBase, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BottomInfo(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEViewTag(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEViewTag2(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEViewTag3(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEViewTag4(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DyncMode(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableViewActions(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSCodeListId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderInfo(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutPanelMode(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LoadDefault(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelState(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenMode(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PDTParamPre(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PDVTParam(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedViewType(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewCnt(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewsCnt(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEAWGroupId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMainStateId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERName(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseName(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseType(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEViewTemplId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpModuleId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubViewTypeId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewEngineId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewEngineName(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVTStyleId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFDEId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReadOnlyMode(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowCaptionBar(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubCapPSLanResId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubCapPSLanResName(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubCaption(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TempMode(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResId(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResName(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewActions(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewModel(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam10(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam11(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam12(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam13(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam14(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam15(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam16(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam17(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam18(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam2(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam3(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam4(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam5(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam6(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam7(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam8(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam9(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParams(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewSN(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam2(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam3(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam4(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSDEViewBase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEViewBase, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AccUserMode(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isAccUserModeDirty() : !pSDEViewBase.isAccUserModeDirty()) {
            return null;
        }
        String string = pSDEViewBase.getAccUserMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AccUserMode_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACCUSERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BottomInfo(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isBottomInfoDirty() : !pSDEViewBase.isBottomInfoDirty()) {
            return null;
        }
        String string = pSDEViewBase.getBottomInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomInfo_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isCapPSLanResIdDirty() : !pSDEViewBase.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isCapPSLanResNameDirty() : !pSDEViewBase.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEViewBase.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isCaptionDirty() : !pSDEViewBase.isCaptionDirty()) {
            return null;
        }
        String string = pSDEViewBase.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isCodeNameDirty() : !pSDEViewBase.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEViewBase.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEViewBase, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEViewBaseDEModel(), "CODENAME", string3, pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_DEViewTag(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isDEViewTagDirty() : !pSDEViewBase.isDEViewTagDirty()) {
            return null;
        }
        String string = pSDEViewBase.getDEViewTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEViewTag_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVIEWTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEViewTag2(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isDEViewTag2Dirty() : !pSDEViewBase.isDEViewTag2Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getDEViewTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEViewTag2_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVIEWTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEViewTag3(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isDEViewTag3Dirty() : !pSDEViewBase.isDEViewTag3Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getDEViewTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEViewTag3_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVIEWTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEViewTag4(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isDEViewTag4Dirty() : !pSDEViewBase.isDEViewTag4Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getDEViewTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEViewTag4_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVIEWTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isDynaModelFlagDirty() : !pSDEViewBase.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_DyncMode(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isDyncModeDirty() : !pSDEViewBase.isDyncModeDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getDyncMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DyncMode_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableViewActions(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isEnableViewActionsDirty() : !pSDEViewBase.isEnableViewActionsDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getEnableViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableViewActions_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEVIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSCodeListId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isGroupPSCodeListIdDirty() : !pSDEViewBase.isGroupPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getGroupPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSCodeListId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderInfo(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isHeaderInfoDirty() : !pSDEViewBase.isHeaderInfoDirty()) {
            return null;
        }
        String string = pSDEViewBase.getHeaderInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderInfo_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Height(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isHeightDirty() : !pSDEViewBase.isHeightDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_LayoutPanelMode(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isLayoutPanelModeDirty() : !pSDEViewBase.isLayoutPanelModeDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getLayoutPanelMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LayoutPanelMode_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LAYOUTPANELMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LoadDefault(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isLoadDefaultDirty() : !pSDEViewBase.isLoadDefaultDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getLoadDefault();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LoadDefault_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOADDEFAULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isLockFlagDirty() : !pSDEViewBase.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isMemoDirty() : !pSDEViewBase.isMemoDirty()) {
            return null;
        }
        String string = pSDEViewBase.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelState(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isModelStateDirty() : !pSDEViewBase.isModelStateDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getModelState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelState_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenMode(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isOpenModeDirty() : !pSDEViewBase.isOpenModeDirty()) {
            return null;
        }
        String string = pSDEViewBase.getOpenMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenMode_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PDTParamPre(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPDTParamPreDirty() : !pSDEViewBase.isPDTParamPreDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPDTParamPre();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PDTParamPre_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PDTPARAMPRE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PDVTParam(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPDVTParamDirty() : !pSDEViewBase.isPDVTParamDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPDVTParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PDVTParam_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PredefinedViewType(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPredefinedViewTypeDirty() : !pSDEViewBase.isPredefinedViewTypeDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPredefinedViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedViewType_Default2(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PredefinedViewType_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSACHandlerIdDirty() : !pSDEViewBase.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppViewCnt(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSAppViewCntDirty() : !pSDEViewBase.isPSAppViewCntDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getPSAppViewCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppViewCnt_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewsCnt(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSAppViewsCntDirty() : !pSDEViewBase.isPSAppViewsCntDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getPSAppViewsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppViewsCnt_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSCtrlLogicGroupIdDirty() : !pSDEViewBase.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEAWGroupId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSDEAWGroupIdDirty() : !pSDEViewBase.isPSDEAWGroupIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSDEAWGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEAWGroupId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSDEIdDirty() && !bl2 : !pSDEViewBase.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEMainStateId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSDEMainStateIdDirty() : !pSDEViewBase.isPSDEMainStateIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSDEMainStateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMainStateId_PSDEMainState(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEMainStateId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSDENameDirty() && !bl2 : !pSDEViewBase.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSDERIdDirty() : !pSDEViewBase.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERName(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSDERNameDirty() : !pSDEViewBase.isPSDERNameDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERName_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSDEViewBaseIdDirty() && !bl2 : !pSDEViewBase.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSDEViewBaseId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseName(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSDEViewBaseNameDirty() && !bl2 : !pSDEViewBase.isPSDEViewBaseNameDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSDEViewBaseName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseName_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewBaseType(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSDEViewBaseTypeDirty() && !bl2 : !pSDEViewBase.isPSDEViewBaseTypeDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSDEViewBaseType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseType_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEViewTemplId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSDynaDEViewTemplIdDirty() : !pSDEViewBase.isPSDynaDEViewTemplIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSDynaDEViewTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEViewTemplId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEVIEWTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSDynaInstIdDirty() : !pSDEViewBase.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpModuleId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSHelpModuleIdDirty() : !pSDEViewBase.isPSHelpModuleIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSHelpModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpModuleId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubViewTypeId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSSubViewTypeIdDirty() : !pSDEViewBase.isPSSubViewTypeIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSSubViewTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubViewTypeId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBVIEWTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSSysCounterIdDirty() : !pSDEViewBase.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSSysCssIdDirty() : !pSDEViewBase.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSSysDynaModelIdDirty() : !pSDEViewBase.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSSysImageIdDirty() : !pSDEViewBase.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSSysPFPluginIdDirty() : !pSDEViewBase.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSSysReqItemIdDirty() : !pSDEViewBase.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSSystemIdDirty() : !pSDEViewBase.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSSysUniResIdDirty() : !pSDEViewBase.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNIRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSSysViewPanelIdDirty() : !pSDEViewBase.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewEngineId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSViewEngineIdDirty() : !pSDEViewBase.isPSViewEngineIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSViewEngineId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewEngineId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWENGINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewEngineName(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSViewEngineNameDirty() : !pSDEViewBase.isPSViewEngineNameDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSViewEngineName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewEngineName_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWENGINENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSViewMsgGroupIdDirty() : !pSDEViewBase.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSVTStyleId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSVTStyleIdDirty() : !pSDEViewBase.isPSVTStyleIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSVTStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVTStyleId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFDEId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSWFDEIdDirty() : !pSDEViewBase.isPSWFDEIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSWFDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFDEId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFVersionId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isPSWFVersionIdDirty() : !pSDEViewBase.isPSWFVersionIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getPSWFVersionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionId_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_ReadOnlyMode(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isReadOnlyModeDirty() : !pSDEViewBase.isReadOnlyModeDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getReadOnlyMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ReadOnlyMode_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READONLYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowCaptionBar(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isShowCaptionBarDirty() : !pSDEViewBase.isShowCaptionBarDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getShowCaptionBar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowCaptionBar_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWCAPTIONBAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFSysPub(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isSRFSysPubDirty() : !pSDEViewBase.isSRFSysPubDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getSRFSysPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SRFSysPub_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_SubCapPSLanResId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isSubCapPSLanResIdDirty() : !pSDEViewBase.isSubCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getSubCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubCapPSLanResId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBCAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubCapPSLanResName(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isSubCapPSLanResNameDirty() : !pSDEViewBase.isSubCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEViewBase.getSubCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubCapPSLanResName_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBCAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubCaption(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isSubCaptionDirty() : !pSDEViewBase.isSubCaptionDirty()) {
            return null;
        }
        String string = pSDEViewBase.getSubCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubCaption_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TempMode(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isTempModeDirty() : !pSDEViewBase.isTempModeDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getTempMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TempMode_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Title(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isTitleDirty() : !pSDEViewBase.isTitleDirty()) {
            return null;
        }
        String string = pSDEViewBase.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSLanResId(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isTitlePSLanResIdDirty() : !pSDEViewBase.isTitlePSLanResIdDirty()) {
            return null;
        }
        String string = pSDEViewBase.getTitlePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResId_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSLanResName(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isTitlePSLanResNameDirty() : !pSDEViewBase.isTitlePSLanResNameDirty()) {
            return null;
        }
        String string = pSDEViewBase.getTitlePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResName_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isToDoTaskDirty() : !pSDEViewBase.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEViewBase.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isUserDataDirty() : !pSDEViewBase.isUserDataDirty()) {
            return null;
        }
        String string = pSDEViewBase.getUserData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData2(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isUserData2Dirty() : !pSDEViewBase.isUserData2Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getUserData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData2_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isUserParamsDirty() : !pSDEViewBase.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEViewBase.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDEViewBase, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewActions(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewActionsDirty() : !pSDEViewBase.isViewActionsDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewActions_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewModel(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewModelDirty() : !pSDEViewBase.isViewModelDirty()) {
            return null;
        }
        String string = pSDEViewBase.getViewModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewModel_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParamDirty() : !pSDEViewBase.isViewParamDirty()) {
            return null;
        }
        String string = pSDEViewBase.getViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam10(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam10Dirty() : !pSDEViewBase.isViewParam10Dirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getViewParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam10_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam11(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam11Dirty() : !pSDEViewBase.isViewParam11Dirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getViewParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam11_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam12(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam12Dirty() : !pSDEViewBase.isViewParam12Dirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getViewParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam12_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam13(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam13Dirty() : !pSDEViewBase.isViewParam13Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getViewParam13();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam13_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM13");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam14(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam14Dirty() : !pSDEViewBase.isViewParam14Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getViewParam14();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam14_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM14");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam15(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam15Dirty() : !pSDEViewBase.isViewParam15Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getViewParam15();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam15_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM15");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam16(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam16Dirty() : !pSDEViewBase.isViewParam16Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getViewParam16();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam16_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM16");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam17(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam17Dirty() : !pSDEViewBase.isViewParam17Dirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getViewParam17();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam17_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM17");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam18(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam18Dirty() : !pSDEViewBase.isViewParam18Dirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getViewParam18();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam18_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM18");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam2(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam2Dirty() : !pSDEViewBase.isViewParam2Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getViewParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam2_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam3(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam3Dirty() : !pSDEViewBase.isViewParam3Dirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getViewParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam3_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam4(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam4Dirty() : !pSDEViewBase.isViewParam4Dirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getViewParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam4_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam5(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam5Dirty() : !pSDEViewBase.isViewParam5Dirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getViewParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam5_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam6(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam6Dirty() : !pSDEViewBase.isViewParam6Dirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getViewParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam6_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam7(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam7Dirty() : !pSDEViewBase.isViewParam7Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getViewParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam7_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam8(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam8Dirty() : !pSDEViewBase.isViewParam8Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getViewParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam8_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam9(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParam9Dirty() : !pSDEViewBase.isViewParam9Dirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getViewParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam9_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParams(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewParamsDirty() : !pSDEViewBase.isViewParamsDirty()) {
            return null;
        }
        String string = pSDEViewBase.getViewParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParams_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewSN(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isViewSNDirty() : !pSDEViewBase.isViewSNDirty()) {
            return null;
        }
        String string = pSDEViewBase.getViewSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewSN_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isWFViewParamDirty() : !pSDEViewBase.isWFViewParamDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getWFViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFViewParam_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam2(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isWFViewParam2Dirty() : !pSDEViewBase.isWFViewParam2Dirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getWFViewParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFViewParam2_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam3(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isWFViewParam3Dirty() : !pSDEViewBase.isWFViewParam3Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getWFViewParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFViewParam3_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam4(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isWFViewParam4Dirty() : !pSDEViewBase.isWFViewParam4Dirty()) {
            return null;
        }
        String string = pSDEViewBase.getWFViewParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFViewParam4_Default(pSDEViewBase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Width(boolean bl, PSDEViewBase pSDEViewBase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewBase.isWidthDirty() : !pSDEViewBase.isWidthDirty()) {
            return null;
        }
        Integer n = pSDEViewBase.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default(pSDEViewBase, bl2, bl3);
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

    protected void onSyncEntity(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        super.onSyncEntity(pSDEViewBase, bl);
    }

    protected void onSyncIndexEntities(PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEViewBase, bl);
    }

    public Object getDataContextValue(PSDEViewBase pSDEViewBase, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEViewBase, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEViewBase.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSSystem pSSystem = pSDEViewBase.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEViewBase pSDEViewBase, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEViewCtrl_PSDEViewBase(pSDEViewBase, arrayList, n);
        this.onExportRelatedModel_PSDEViewRV_MajorPSDEView(pSDEViewBase, arrayList, n);
        super.onExportRelatedModel(pSDEViewBase, arrayList, n);
    }

    /*
     * WARNING - void declaration
     */
    protected void onExportRelatedModel_PSDEViewCtrl_PSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewCtrl> arrayList2 = pSDEViewCtrlService.selectByPSDEViewBase(pSDEViewBase);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"c84a350acbaeea9fde2edfdcd61208c2");
            jSONObject.put("srfdename", (Object)"PSDEVIEWCTRL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEVIEWCTRL_PSDEVIEWBASE_PSDEVIEWBASEID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEViewBase, (String)"PSDEVIEWBASEID", (String)""));
            String object = "";
            for (PSDEViewCtrl pSDEViewCtrl : arrayList2) {
                if (!StringHelper.isNullOrEmpty((String)object)) {
                    object = object + ";";
                }
                object = object + DataObject.getStringValue((IDataObject)pSDEViewCtrl, (String)"PSDEVIEWCTRLID", (String)"");
            }
            jSONObject.put("srfarg2", (Object)object);
            arrayList.add(jSONObject);
        }
        for (PSDEViewCtrl pSDEViewCtrl : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEViewCtrl, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEViewCtrlService.exportModel(pSDEViewCtrl, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEViewRV_MajorPSDEView(PSDEViewBase pSDEViewBase, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewRV> arrayList2 = pSDEViewRVService.selectByMajorPSDEView(pSDEViewBase);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"310b0ee95373cdd6e3449e138e97b6bd");
            jSONObject.put("srfdename", (Object)"PSDEVIEWRV");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEVIEWRV_PSDEVIEWBASE_MAJORPSDEVIEWID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEViewBase, (String)"PSDEVIEWBASEID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEViewRV pSDEViewRV : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEViewRV, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEViewRVService.exportModel(pSDEViewRV, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEViewBase pSDEViewBase, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEViewBase, arrayList, n);
        this.onExportMajorModel_SubCapPSLanRes(pSDEViewBase, arrayList, n);
        this.onExportMajorModel_TitlePSLanRes(pSDEViewBase, arrayList, n);
        super.onExportMajorModel(pSDEViewBase, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEViewBase pSDEViewBase, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEViewBase.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEViewBase.getCapPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_SubCapPSLanRes(PSDEViewBase pSDEViewBase, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEViewBase.getSubCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEViewBase.getSubCapPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_TitlePSLanRes(PSDEViewBase pSDEViewBase, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEViewBase.getTitlePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEViewBase.getTitlePSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACCUSERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AccUserMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOTTOMINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEVIEWTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEViewTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVIEWTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEViewTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVIEWTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEViewTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVIEWTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEViewTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DyncMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTPANELMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutPanelMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOADDEFAULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LoadDefault_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PDTPARAMPRE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PDTParamPre_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PDVTPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT2", (boolean)true) == 0) {
            return this.onTestValueRule_PDVTParam_Default2(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PDVTPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PDVTParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT2", (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedViewType_Default2(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAWGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAWGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAWGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAWGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEMAINSTATE", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateId_PSDEMainState(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEVIEWTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEViewTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEVIEWTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEViewTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubViewTypeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWENGINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewEngineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWENGINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewEngineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVTSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVTStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVTSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVTStyleName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"READONLYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReadOnlyMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWCAPTIONBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowCaptionBar_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFSYSPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBCAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubCapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBCAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubCapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TempMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM13", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam13_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM14", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam14_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM15", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam15_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM16", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam16_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM17", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam17_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM18", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam18_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AccUserMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACCUSERMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BottomInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210)";
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

    protected String onTestValueRule_DEViewTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVIEWTAG", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEViewTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVIEWTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("DEVIEWTAG2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEViewTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVIEWTAG3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEViewTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVIEWTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DyncMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupPSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HeaderInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LayoutPanelMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LoadDefault_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ModelState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OpenMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PDTParamPre_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PDTPARAMPRE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PDVTParam_Default2(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldSimpleRule("PREDEFINEVIEWTYPE", iEntity, bl2, "EQ", null, null, "", true) || this.checkFieldQueryCountRule2("PDVTPARAM", "PDTCNT2", iEntity, bl2, 0, true, 0, true, "\u9884\u7f6e\u89c6\u56fe\u7c7b\u578b\u53c2\u6570\u91cd\u590d", false, true)) {
                return null;
            }
            return "\u9884\u7f6e\u89c6\u56fe\u7c7b\u578b\u53c2\u6570\u91cd\u590d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PredefinedViewType_Default2(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if ((this.checkFieldSimpleRule("PDVTPARAM", iEntity, bl2, "NOTEQ", null, null, "", true) || this.checkFieldQueryCountRule2("PREDEFINEVIEWTYPE", "PDTCNT", iEntity, bl2, 0, true, 0, true, "\u9884\u7f6e\u89c6\u56fe\u7c7b\u578b\u91cd\u590d", true, true)) && (this.checkFieldSimpleRule("PDVTPARAM", iEntity, bl2, "EQ", null, null, "", true) || this.checkFieldQueryCountRule2("PREDEFINEVIEWTYPE", "PDTCNT2", iEntity, bl2, 0, true, 0, true, "\u9884\u7f6e\u89c6\u56fe\u7c7b\u578b\u91cd\u590d", true, true))) {
                return null;
            }
            return "\u9884\u7f6e\u89c6\u56fe\u7c7b\u578b\u91cd\u590d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEVIEWTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_PSAppViewCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppViewsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEAWGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAWGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEAWGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAWGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEMainStateId_PSDEMainState(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEMAINSTATEID", "PSDEMAINSTATE", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u4e3b\u72b6\u6001\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMainStateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMainStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERNAME", iEntity, bl2, null, false, 199, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[199]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[199]";
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

    protected String onTestValueRule_PSDEViewBaseType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASETYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDynaDEViewTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEVIEWTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSHelpModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubViewTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBVIEWTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubViewTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBVIEWTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysImageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysUniResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewEngineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWENGINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewEngineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWENGINENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSVTStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVTSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSVTStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVTSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ReadOnlyMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShowCaptionBar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SRFSysPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SubCapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBCAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubCapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBCAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBCAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TempMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_UserData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam13_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM13", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam14_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM14", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam15_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM15", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam16_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM16", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam17_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam18_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM2", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM7", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM8", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFViewParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFViewParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFVIEWPARAM3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFViewParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFVIEWPARAM4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSDEViewBase pSDEViewBase) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) && this.onMergeChild_PSAppViews(pSDEViewBase)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, pSDEViewBase)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSAppViews(PSDEViewBase pSDEViewBase) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSAPPVIEWCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDEViewBase.getPSDEViewBaseId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEVIEWBASEID", (Object)pSDEViewBase.getPSDEViewBaseId());
        ArrayList<IEntity> arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDEViewBase, false);
        return true;
    }

    protected void onUpdateParent(PSDEViewBase pSDEViewBase) throws Exception {
        IService iService;
        Object object = pSDEViewBase.get("PSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEVIEWBASE_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSDEViewBase.get("PSWFDEID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEVIEWBASE_PSWFDE_PSWFDEID", object);
        }
        super.onUpdateParent(pSDEViewBase);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEViewBase pSDEViewBase, Object object) throws Exception {
        PSDEViewBase pSDEViewBase2 = new PSDEViewBase();
        pSDEViewBase2.set("PSDEVIEWBASEID", object);
        String string = DataObject.getStringValue((Object)pSDEViewBase.get("PSDEVIEWBASEID"));
        super.onCopyDetails(pSDEViewBase, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEViewBase pSDEViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVIEWBASE");
        if (!bl) {
            pSDEViewBase.setCreateDate(null);
            pSDEViewBase.setCreateMan(null);
            pSDEViewBase.setModelState(null);
            pSDEViewBase.setPSAppViewsCnt(null);
            pSDEViewBase.setPSDEViewBaseId(null);
            pSDEViewBase.setPSDEViewBaseType(null);
            pSDEViewBase.setUpdateDate(null);
            pSDEViewBase.setUpdateMan(null);
            super.exportCurXmlModel(pSDEViewBase, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEViewBase pSDEViewBase, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEViewCtrl(pSDEViewBase, xmlNode);
        this.exportRelatedXmlModel_PSDEViewEngine(pSDEViewBase, xmlNode);
        super.onExportRelatedXmlModel(pSDEViewBase, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEViewCtrl(PSDEViewBase pSDEViewBase, XmlNode xmlNode) throws Exception {
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewCtrl> arrayList = null;
        String string = pSDEViewBase.getPSDEViewBaseId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEViewCtrlService.selectByPSDEViewBase(pSDEViewBase, "ORDER BY ORDERVALUE ASC") : pSDEViewCtrlService.selectTempByPSDEViewBase(pSDEViewBase, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEVIEWCTRLS");
            xmlNode.addNode(xmlNode2);
            for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
                pSDEViewCtrl.set("ORDERVALUE", null);
                pSDEViewCtrlService.exportXmlModel(pSDEViewCtrl, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEViewEngine(PSDEViewBase pSDEViewBase, XmlNode xmlNode) throws Exception {
        PSDEViewEngineService pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewEngine> arrayList = null;
        String string = pSDEViewBase.getPSDEViewBaseId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEViewEngineService.selectByPSDEViewBase(pSDEViewBase, "ORDER BY ORDERVALUE ASC") : pSDEViewEngineService.selectTempByPSDEViewBase(pSDEViewBase, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEVIEWENGINES");
            xmlNode.addNode(xmlNode2);
            for (PSDEViewEngine pSDEViewEngine : arrayList) {
                pSDEViewEngine.set("ORDERVALUE", null);
                pSDEViewEngineService.exportXmlModel(pSDEViewEngine, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEViewBase pSDEViewBase, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEVIEWCTRLS");
        this.importRelatedXmlModel_PSDEViewCtrl(pSDEViewBase, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDEVIEWENGINES");
        this.importRelatedXmlModel_PSDEViewEngine(pSDEViewBase, xmlNode3);
        super.onImportRelatedXmlModel(pSDEViewBase, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEViewCtrl(PSDEViewBase pSDEViewBase, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEViewBase.getPSDEViewBaseId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEViewCtrlService.removeByPSDEViewBase(pSDEViewBase);
        } else {
            pSDEViewCtrlService.removeTempByPSDEViewBase(pSDEViewBase);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
                pSDEViewCtrl.setOrderValue(n);
                n += 100;
                pSDEViewCtrlService.fillParentInfo(pSDEViewCtrl, "DER1N", "DER1N_PSDEVIEWCTRL_PSDEVIEWBASE_PSDEVIEWBASEID", pSDEViewBase.getPSDEViewBaseId());
                pSDEViewCtrlService.importXmlModel(pSDEViewCtrl, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEViewEngine(PSDEViewBase pSDEViewBase, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEViewEngineService pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEViewBase.getPSDEViewBaseId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEViewEngineService.removeByPSDEViewBase(pSDEViewBase);
        } else {
            pSDEViewEngineService.removeTempByPSDEViewBase(pSDEViewBase);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEViewEngine pSDEViewEngine = new PSDEViewEngine();
                pSDEViewEngine.setOrderValue(n);
                n += 100;
                pSDEViewEngineService.fillParentInfo(pSDEViewEngine, "DER1N", "DER1N_PSDEVIEWENGINE_PSDEVIEWBASE_PSDEVIEWBASEID", pSDEViewBase.getPSDEViewBaseId());
                pSDEViewEngineService.importXmlModel(pSDEViewEngine, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEViewBase pSDEViewBase, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEViewBase, string);
        objectNode.remove("psappviewscnt");
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
            return "DER1N_PSDEVIEWBASE_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEViewBase pSDEViewBase) {
        if (!StringHelper.isNullOrEmpty((String)pSDEViewBase.getCodeName())) {
            return pSDEViewBase.getCodeName();
        }
        return super.getModelV2Tag(pSDEViewBase);
    }

    @Override
    public boolean setModelV2Tag(PSDEViewBase pSDEViewBase, String string) {
        pSDEViewBase.setCodeName(string);
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
    public boolean getModelV2Entity(PSDEViewBase pSDEViewBase, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEViewBase.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEViewBase, true);
        pSDEViewBase.set("CODENAME", string);
        if (this.select(pSDEViewBase, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEViewBase, true);
        return super.getModelV2Entity(pSDEViewBase, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEViewBase pSDEViewBase, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEViewBase, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEVIEWCTRL_PSDEVIEWBASE_PSDEVIEWBASEID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEVIEWENGINE_PSDEVIEWBASE_PSDEVIEWBASEID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEVIEWLOGIC_PSDEVIEWBASE_PSDEVIEWBASEID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEVIEWRV_PSDEVIEWBASE_MAJORPSDEVIEWID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEViewBase pSDEViewBase, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEViewBase, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEViewBase pSDEViewBase, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEVIEWCTRL_PSDEVIEWBASE_PSDEVIEWBASEID")) {
            pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEVIEWBASE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEVIEWCTRL", (Object)pSDEViewBase.getPSDEViewBaseId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)pSDEViewBase.getPSDEViewBaseId());
                for (PSDEViewCtrl entity : ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).selectByPSDEViewBase(pSDEViewBase)) {
                    String entityScope = ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeviewctrlname")) {
                            string = objectNode.get("psdeviewctrlname").asText();
                        }
                        if (objectNode2.has("psdeviewctrlname")) {
                            string2 = objectNode2.get("psdeviewctrlname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSDEViewCtrl entity = new PSDEViewCtrl();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    related.add(pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEVIEWENGINE_PSDEVIEWBASE_PSDEVIEWBASEID")) {
            pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEVIEWBASE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEVIEWENGINE", (Object)pSDEViewBase.getPSDEViewBaseId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)pSDEViewBase.getPSDEViewBaseId());
                for (PSDEViewEngine entity : ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).selectByPSDEViewBase(pSDEViewBase)) {
                    String entityScope = ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeviewenginename")) {
                            string = objectNode.get("psdeviewenginename").asText();
                        }
                        if (objectNode2.has("psdeviewenginename")) {
                            string2 = objectNode2.get("psdeviewenginename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSDEViewEngine entity = new PSDEViewEngine();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    related.add(pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEVIEWLOGIC_PSDEVIEWBASE_PSDEVIEWBASEID")) {
            pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEVIEWBASE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEVIEWLOGIC", (Object)pSDEViewBase.getPSDEViewBaseId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)pSDEViewBase.getPSDEViewBaseId());
                for (PSDEViewLogic entity : ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).selectByPSDEViewBase(pSDEViewBase)) {
                    String entityScope = ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeviewlogicname")) {
                            string = objectNode.get("psdeviewlogicname").asText();
                        }
                        if (objectNode2.has("psdeviewlogicname")) {
                            string2 = objectNode2.get("psdeviewlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSDEViewLogic entity = new PSDEViewLogic();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    related.add(pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEVIEWRV_PSDEVIEWBASE_MAJORPSDEVIEWID")) {
            pSCoreSysServiceBase = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEVIEWBASE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEVIEWRV", (Object)pSDEViewBase.getPSDEViewBaseId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)pSDEViewBase.getPSDEViewBaseId());
                for (PSDEViewRV entity : ((PSDEViewRVServiceBase)pSCoreSysServiceBase).selectByMajorPSDEView(pSDEViewBase)) {
                    String entityScope = ((PSDEViewRVServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeviewrvname")) {
                            string = objectNode.get("psdeviewrvname").asText();
                        }
                        if (objectNode2.has("psdeviewrvname")) {
                            string2 = objectNode2.get("psdeviewrvname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSDEViewRV entity = new PSDEViewRV();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    related.add(pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEViewBase, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEViewBase pSDEViewBase) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        String string2 = StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)pSDEViewBase.getPSDEViewBaseId());
        for (PSDEViewCtrl entityBase : ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).selectByPSDEViewBase(pSDEViewBase)) {
            string = ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        SqlParamList params = new SqlParamList();
        params.addString(pSDEViewBase.getPSDEViewBaseId());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEVIEWCTRL WHERE PSDEVIEWBASEID = ?", params);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        string2 = StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)pSDEViewBase.getPSDEViewBaseId());
        for (PSDEViewEngine pSDEViewEngine : ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).selectByPSDEViewBase(pSDEViewBase)) {
            string = ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEViewEngine);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEViewEngine);
        }
        params = new SqlParamList();
        params.addString(pSDEViewBase.getPSDEViewBaseId());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEVIEWENGINE WHERE PSDEVIEWBASEID = ?", params);
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        string2 = StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)pSDEViewBase.getPSDEViewBaseId());
        for (PSDEViewLogic pSDEViewLogic : ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).selectByPSDEViewBase(pSDEViewBase)) {
            string = ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEViewLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEViewLogic);
        }
        params = new SqlParamList();
        params.addString(pSDEViewBase.getPSDEViewBaseId());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEVIEWLOGIC WHERE PSDEVIEWBASEID = ?", params);
        pSCoreSysServiceBase = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        string2 = StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)pSDEViewBase.getPSDEViewBaseId());
        for (PSDEViewRV pSDEViewRV : ((PSDEViewRVServiceBase)pSCoreSysServiceBase).selectByMajorPSDEView(pSDEViewBase)) {
            string = ((PSDEViewRVServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEViewRV);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEViewRV);
        }
        params = new SqlParamList();
        params.addString(pSDEViewBase.getPSDEViewBaseId());
        ((PSDEViewRVServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEViewRVServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEVIEWRV WHERE MAJORPSDEVIEWID = ?", params);
        super.onEmptyModelV2(pSDEViewBase);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEViewBase pSDEViewBase, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEViewCtrl();
        entityBase.set("PSDEVIEWBASEID", pSDEViewBase.getPSDEViewBaseId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEViewEngine();
        entityBase.set("PSDEVIEWBASEID", pSDEViewBase.getPSDEViewBaseId());
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEViewLogic();
        entityBase.set("PSDEVIEWBASEID", pSDEViewBase.getPSDEViewBaseId());
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEViewRV();
        entityBase.set("MAJORPSDEVIEWID", pSDEViewBase.getPSDEViewBaseId());
        pSCoreSysServiceBase = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEViewBase, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEViewBase pSDEViewBase, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode model = (ObjectNode)arrayNode.get(i);
                PSDEViewCtrl entity = new PSDEViewCtrl();
                entity.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                entity.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                entity.setPSSystemId(pSDEViewBase.getPSSystemId());
                pSCoreSysServiceBase.compileModelV2(entity, model, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string4);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDEViewCtrl entity = new PSDEViewCtrl();
                    entity.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                    entity.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                    entity.setPSSystemId(pSDEViewBase.getPSSystemId());
                    pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode model = (ObjectNode)arrayNode.get(i);
                PSDEViewEngine entity = new PSDEViewEngine();
                entity.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                entity.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                pSCoreSysServiceBase.compileModelV2(entity, model, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string5);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDEViewEngine entity = new PSDEViewEngine();
                    entity.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                    entity.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                    pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode model = (ObjectNode)arrayNode.get(i);
                PSDEViewLogic entity = new PSDEViewLogic();
                entity.setPSDEId(pSDEViewBase.getPSDEId());
                entity.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                entity.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                pSCoreSysServiceBase.compileModelV2(entity, model, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string6);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDEViewLogic entity = new PSDEViewLogic();
                    entity.setPSDEId(pSDEViewBase.getPSDEId());
                    entity.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                    entity.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                    pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode model = (ObjectNode)arrayNode.get(i);
                PSDEViewRV entity = new PSDEViewRV();
                entity.setMajorPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
                entity.setMajorPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
                entity.setPSSystemId(pSDEViewBase.getPSSystemId());
                pSCoreSysServiceBase.compileModelV2(entity, model, string, null, n);
            }
        } else {
            String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string7);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDEViewRV entity = new PSDEViewRV();
                    entity.setMajorPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
                    entity.setMajorPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
                    entity.setPSSystemId(pSDEViewBase.getPSSystemId());
                    pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEViewBase, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEViewBase pSDEViewBase, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEVIEWCTRL_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEViewCtrls(pSDEViewBase, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEVIEWENGINE_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEViewEngines(pSDEViewBase, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEViewBase, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEViewCtrls(PSDEViewBase pSDEViewBase, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEVIEWCTRL", true), (boolean)false) == 0) {
            PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
            PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
            pSDEViewCtrl.setPSDEViewCtrlId(pSMOSFile.getPSModelId());
            if (!pSDEViewCtrlService.get(pSDEViewCtrl, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEViewCtrl.getPSDEViewBaseId(), (String)pSDEViewBase.getPSDEViewBaseId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEViewCtrlService.exportModelV2(pSDEViewCtrl);
            pSDEViewCtrl.reset();
            if (!pSDEViewCtrlService.setModelV2ResScope(pSDEViewCtrl, "PSDEVIEWBASE", pSDEViewBase.getPSDEViewBaseId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEViewCtrlService.importModelV2(pSDEViewCtrl, objectNode);
            SessionFactoryManager.commit();
            return pSDEViewCtrlService.getFile(pSDEViewCtrl);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEViewEngines(PSDEViewBase pSDEViewBase, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEVIEWENGINE", true), (boolean)false) == 0) {
            PSDEViewEngineService pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
            PSDEViewEngine pSDEViewEngine = new PSDEViewEngine();
            pSDEViewEngine.setPSDEViewEngineId(pSMOSFile.getPSModelId());
            if (!pSDEViewEngineService.get(pSDEViewEngine, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEViewEngine.getPSDEViewBaseId(), (String)pSDEViewBase.getPSDEViewBaseId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEViewEngineService.exportModelV2(pSDEViewEngine);
            pSDEViewEngine.reset();
            if (!pSDEViewEngineService.setModelV2ResScope(pSDEViewEngine, "PSDEVIEWBASE", pSDEViewBase.getPSDEViewBaseId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEViewEngineService.importModelV2(pSDEViewEngine, objectNode);
            SessionFactoryManager.commit();
            return pSDEViewEngineService.getFile(pSDEViewEngine);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEViewBase pSDEViewBase, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEViewCtrls(pSDEViewBase, list);
        this.onFillPasteHelps_PSDEViewEngines(pSDEViewBase, list);
        super.onFillPasteHelps(pSDEViewBase, list);
    }

    protected void onFillPasteHelps_PSDEViewCtrls(PSDEViewBase pSDEViewBase, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEVIEWCTRL");
        pSHelpSection.setSectionParam2("DER1N_PSDEVIEWCTRL_PSDEVIEWBASE_PSDEVIEWBASEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u89c6\u56fe]\u7684[\u5b9e\u4f53\u89c6\u56fe\u90e8\u4ef6]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEViewEngines(PSDEViewBase pSDEViewBase, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEVIEWENGINE");
        pSHelpSection.setSectionParam2("DER1N_PSDEVIEWENGINE_PSDEVIEWBASE_PSDEVIEWBASEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u89c6\u56fe]\u7684[\u5b9e\u4f53\u89c6\u56fe\u754c\u9762\u5f15\u64ce]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSDEViewBase pSDEViewBase) throws Exception {
        return pSDEViewBase.getPSDEViewBaseType();
    }
}
