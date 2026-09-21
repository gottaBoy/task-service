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
 *  net.ibizsys.paas.db.ISelectContext
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
import net.ibizsys.paas.db.ISelectContext;
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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineJobService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineJobServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDataSetDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataSetDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSCodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQ;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSGrpParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSGrpParamBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSParamBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImpBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleDataBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAGDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAGDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSCodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSCodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSDQService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSDQServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSGrpParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSGrpParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondServiceBase;
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
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDSServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlDSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlDSServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewServiceService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewServiceServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetailBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTaskBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniStateBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserDR;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserDRBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.service.PSSysTDItemService;
import net.ibizsys.pscore.srv.systest.service.PSSysTDItemServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataSetServiceBase
extends PSCoreSysServiceBase<PSDEDataSet> {
    private static final Log log = LogFactory.getLog(PSDEDataSetServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSNOTSUB = "CurSysNotSub";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEDataSetDEModel pSDEDataSetDEModel;
    private PSDEDataSetDAO pSDEDataSetDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService";
    }

    public PSDEDataSetDEModel getPSDEDataSetDEModel() {
        if (this.pSDEDataSetDEModel == null) {
            try {
                this.pSDEDataSetDEModel = (PSDEDataSetDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataSetDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataSetDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDataSetDEModel();
    }

    public PSDEDataSetDAO getPSDEDataSetDAO() {
        if (this.pSDEDataSetDAO == null) {
            try {
                this.pSDEDataSetDAO = (PSDEDataSetDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDataSetDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataSetDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDataSetDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSNOTSUB, (boolean)true) == 0) {
            return this.fetchCurSysNotSub(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSNOTSUB, (boolean)true) == 0) {
            return this.fetchTempCurSysNotSub(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
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

    public DBFetchResult fetchCurSysNotSub(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSNOTSUB, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysNotSub(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSNOTSUB, true);
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

    protected void onFillParentInfo(PSDEDataSet pSDEDataSet, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSDEDataSet, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEDataSet, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDEDATAIMP_PSDEDATAIMPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService", (SessionFactory)this.getSessionFactory());
            PSDEDataImp pSDEDataImp = (PSDEDataImp)iService.getDEModel().createEntity();
            pSDEDataImp.set("PSDEDATAIMPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataImp);
            } else {
                iService.get((IEntity)pSDEDataImp);
            }
            this.onFillParentInfo_PSDEDataImp(pSDEDataSet, pSDEDataImp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDEFGROUP_INPSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFGroup);
            } else {
                iService.get((IEntity)pSDEFGroup);
            }
            this.onFillParentInfo_InPSDEFGroup(pSDEDataSet, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDEFGROUP_OUTPSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFGroup);
            } else {
                iService.get((IEntity)pSDEFGroup);
            }
            this.onFillParentInfo_OutPSDEFGroup(pSDEDataSet, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDEFIELD_MAJORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_MajorPSDEF(pSDEDataSet, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDEFIELD_MINORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_MinorPSDEF(pSDEDataSet, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDELOGIC_ADPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_ADPSDELogic(pSDEDataSet, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDELOGIC_CACHESTATEPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_CacheStatePSDELogic(pSDEDataSet, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDEDataSet, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDEOPPRIV_PSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEOPPriv);
            } else {
                iService.get((IEntity)pSDEOPPriv);
            }
            this.onFillParentInfo_PSDEOPPriv(pSDEDataSet, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDER_AGGDATAPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_AggDataPSDER(pSDEDataSet, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDESAMPLEDATA_INPSDESAMPLEDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService", (SessionFactory)this.getSessionFactory());
            PSDESampleData pSDESampleData = (PSDESampleData)iService.getDEModel().createEntity();
            pSDESampleData.set("PSDESAMPLEDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDESampleData);
            } else {
                iService.get((IEntity)pSDESampleData);
            }
            this.onFillParentInfo_InPSDESampleData(pSDEDataSet, pSDESampleData);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSDESAMPLEDATA_OUTPSDESAMPLEDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService", (SessionFactory)this.getSessionFactory());
            PSDESampleData pSDESampleData = (PSDESampleData)iService.getDEModel().createEntity();
            pSDESampleData.set("PSDESAMPLEDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDESampleData);
            } else {
                iService.get((IEntity)pSDESampleData);
            }
            this.onFillParentInfo_OutPSDESampleData(pSDEDataSet, pSDESampleData);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADetail pSSubSysSADetail = (PSSubSysSADetail)iService.getDEModel().createEntity();
            pSSubSysSADetail.set("PSSUBSYSSADETAILID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysSADetail);
            } else {
                iService.get((IEntity)pSSubSysSADetail);
            }
            this.onFillParentInfo_PSSubSysSADetail(pSDEDataSet, pSSubSysSADetail);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSSYSDYNAMODEL_INPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_InPSSysDynaModel(pSDEDataSet, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEDataSet, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEDataSet, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEDataSet, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSSYSTASK_PSSYSTASKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService", (SessionFactory)this.getSessionFactory());
            PSSysTask pSSysTask = (PSSysTask)iService.getDEModel().createEntity();
            pSSysTask.set("PSSYSTASKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTask);
            } else {
                iService.get((IEntity)pSSysTask);
            }
            this.onFillParentInfo_PSSysTask(pSDEDataSet, pSSysTask);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSSYSUNISTATE_PSSYSUNISTATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService", (SessionFactory)this.getSessionFactory());
            PSSysUniState pSSysUniState = (PSSysUniState)iService.getDEModel().createEntity();
            pSSysUniState.set("PSSYSUNISTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUniState);
            } else {
                iService.get((IEntity)pSSysUniState);
            }
            this.onFillParentInfo_PSSysUniState(pSDEDataSet, pSSysUniState);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSSYSUSERDR_PSSYSUSERDRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService", (SessionFactory)this.getSessionFactory());
            PSSysUserDR pSSysUserDR = (PSSysUserDR)iService.getDEModel().createEntity();
            pSSysUserDR.set("PSSYSUSERDRID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUserDR);
            } else {
                iService.get((IEntity)pSSysUserDR);
            }
            this.onFillParentInfo_PSSysUserDR(pSDEDataSet, pSSysUserDR);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATASET_PSSYSUSERDR_PSSYSUSERDRID2", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService", (SessionFactory)this.getSessionFactory());
            PSSysUserDR pSSysUserDR = (PSSysUserDR)iService.getDEModel().createEntity();
            pSSysUserDR.set("PSSYSUSERDRID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUserDR);
            } else {
                iService.get((IEntity)pSSysUserDR);
            }
            this.onFillParentInfo_PSSysUserDR2(pSDEDataSet, pSSysUserDR);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEDataSet, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSDEDataSet pSDEDataSet, PSCodeList pSCodeList) throws Exception {
        pSDEDataSet.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEDataSet.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDE(PSDEDataSet pSDEDataSet, PSDataEntity pSDataEntity) throws Exception {
        pSDEDataSet.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDataSet.setPSDEName(pSDataEntity.getPSDataEntityName());
        pSDEDataSet.setPSSubSysSADEId(pSDataEntity.getPSSubSysSADEId());
    }

    protected void onFillParentInfo_PSDEDataImp(PSDEDataSet pSDEDataSet, PSDEDataImp pSDEDataImp) throws Exception {
        pSDEDataSet.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
        pSDEDataSet.setPSDEDataImpName(pSDEDataImp.getPSDEDataImpName());
    }

    protected void onFillParentInfo_InPSDEFGroup(PSDEDataSet pSDEDataSet, PSDEFGroup pSDEFGroup) throws Exception {
        pSDEDataSet.setInPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDEDataSet.setInPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_OutPSDEFGroup(PSDEDataSet pSDEDataSet, PSDEFGroup pSDEFGroup) throws Exception {
        pSDEDataSet.setOutPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDEDataSet.setOutPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_MajorPSDEF(PSDEDataSet pSDEDataSet, PSDEField pSDEField) throws Exception {
        pSDEDataSet.setMajorPSDEFId(pSDEField.getPSDEFieldId());
        pSDEDataSet.setMajorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MinorPSDEF(PSDEDataSet pSDEDataSet, PSDEField pSDEField) throws Exception {
        pSDEDataSet.setMinorPSDEFId(pSDEField.getPSDEFieldId());
        pSDEDataSet.setMinorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ADPSDELogic(PSDEDataSet pSDEDataSet, PSDELogic pSDELogic) throws Exception {
        pSDEDataSet.setADPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEDataSet.setADPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_CacheStatePSDELogic(PSDEDataSet pSDEDataSet, PSDELogic pSDELogic) throws Exception {
        pSDEDataSet.setCacheStatePSDELogicId(pSDELogic.getPSDELogicId());
        pSDEDataSet.setCacheStatePSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDELogic(PSDEDataSet pSDEDataSet, PSDELogic pSDELogic) throws Exception {
        pSDEDataSet.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEDataSet.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEOPPriv(PSDEDataSet pSDEDataSet, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEDataSet.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEDataSet.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_AggDataPSDER(PSDEDataSet pSDEDataSet, PSDER pSDER) throws Exception {
        pSDEDataSet.setAggDataPSDERId(pSDER.getPSDERId());
        pSDEDataSet.setAggDataPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_InPSDESampleData(PSDEDataSet pSDEDataSet, PSDESampleData pSDESampleData) throws Exception {
        pSDEDataSet.setInPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
        pSDEDataSet.setInPSDESampleDataName(pSDESampleData.getPSDESampleDataName());
    }

    protected void onFillParentInfo_OutPSDESampleData(PSDEDataSet pSDEDataSet, PSDESampleData pSDESampleData) throws Exception {
        pSDEDataSet.setOutPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
        pSDEDataSet.setOutPSDESampleDataName(pSDESampleData.getPSDESampleDataName());
    }

    protected void onFillParentInfo_PSSubSysSADetail(PSDEDataSet pSDEDataSet, PSSubSysSADetail pSSubSysSADetail) throws Exception {
        pSDEDataSet.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
        pSDEDataSet.setPSSubSysSADetailName(pSSubSysSADetail.getPSSubSysSADetailName());
    }

    protected void onFillParentInfo_InPSSysDynaModel(PSDEDataSet pSDEDataSet, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEDataSet.setInPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEDataSet.setInPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEDataSet pSDEDataSet, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEDataSet.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEDataSet.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEDataSet pSDEDataSet, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEDataSet.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEDataSet.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEDataSet pSDEDataSet, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEDataSet.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEDataSet.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysTask(PSDEDataSet pSDEDataSet, PSSysTask pSSysTask) throws Exception {
        pSDEDataSet.setFinishFlag(pSSysTask.getFinishFlag());
        pSDEDataSet.setPSSysTaskId(pSSysTask.getPSSysTaskId());
        pSDEDataSet.setPSSysTaskName(pSSysTask.getPSSysTaskName());
    }

    protected void onFillParentInfo_PSSysUniState(PSDEDataSet pSDEDataSet, PSSysUniState pSSysUniState) throws Exception {
        pSDEDataSet.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
        pSDEDataSet.setPSSysUniStateName(pSSysUniState.getPSSysUniStateName());
    }

    protected void onFillParentInfo_PSSysUserDR(PSDEDataSet pSDEDataSet, PSSysUserDR pSSysUserDR) throws Exception {
        pSDEDataSet.setPSSysUserDRId(pSSysUserDR.getPSSysUserDRId());
        pSDEDataSet.setPSSysUserDRName(pSSysUserDR.getPSSysUserDRName());
    }

    protected void onFillParentInfo_PSSysUserDR2(PSDEDataSet pSDEDataSet, PSSysUserDR pSSysUserDR) throws Exception {
        pSDEDataSet.setPSSysUserDRId2(pSSysUserDR.getPSSysUserDRId());
        pSDEDataSet.setPSSysUserDRName2(pSSysUserDR.getPSSysUserDRName());
    }

    protected void onFillEntityFullInfo(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
        if (bl) {
            if (pSDEDataSet.getCodeName() == null) {
                pSDEDataSet.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DataSet", 25));
            }
            if (pSDEDataSet.getLogicName() == null) {
                pSDEDataSet.setLogicName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u6570\u636e\u96c6", 25));
            }
            if (pSDEDataSet.getPSDEDataSetName() == null) {
                pSDEDataSet.setPSDEDataSetName((String)this.getDefaultValue(this.getWebContext(), "USER", "DATASET", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSCodeList(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSDE(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSDEDataImp(pSDEDataSet, bl);
        this.onFillEntityFullInfo_InPSDEFGroup(pSDEDataSet, bl);
        this.onFillEntityFullInfo_OutPSDEFGroup(pSDEDataSet, bl);
        this.onFillEntityFullInfo_MajorPSDEF(pSDEDataSet, bl);
        this.onFillEntityFullInfo_MinorPSDEF(pSDEDataSet, bl);
        this.onFillEntityFullInfo_ADPSDELogic(pSDEDataSet, bl);
        this.onFillEntityFullInfo_CacheStatePSDELogic(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSDEOPPriv(pSDEDataSet, bl);
        this.onFillEntityFullInfo_AggDataPSDER(pSDEDataSet, bl);
        this.onFillEntityFullInfo_InPSDESampleData(pSDEDataSet, bl);
        this.onFillEntityFullInfo_OutPSDESampleData(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSSubSysSADetail(pSDEDataSet, bl);
        this.onFillEntityFullInfo_InPSSysDynaModel(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSSysTask(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSSysUniState(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSSysUserDR(pSDEDataSet, bl);
        this.onFillEntityFullInfo_PSSysUserDR2(pSDEDataSet, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
        if (pSDEDataSet.isPSDEIdDirty()) {
            if (pSDEDataSet.getPSDEId() != null) {
                if (pSDEDataSet.getPSDEId() == null || pSDEDataSet.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEDataSet.getPSDE();
                    pSDEDataSet.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEDataSet.setPSSubSysSADEId(pSDataEntity.getPSSubSysSADEId());
                }
            } else {
                pSDEDataSet.setPSDEName(null);
                pSDEDataSet.setPSSubSysSADEId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDataImp(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InPSDEFGroup(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSDEFGroup(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MajorPSDEF(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
        if (pSDEDataSet.isMajorPSDEFIdDirty()) {
            if (pSDEDataSet.getMajorPSDEFId() != null) {
                if (pSDEDataSet.getMajorPSDEFId() == null || pSDEDataSet.getMajorPSDEFName() == null) {
                    PSDEField pSDEField = pSDEDataSet.getMajorPSDEF();
                    pSDEDataSet.setMajorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEDataSet.setMajorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MinorPSDEF(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
        if (pSDEDataSet.isMinorPSDEFIdDirty()) {
            if (pSDEDataSet.getMinorPSDEFId() != null) {
                if (pSDEDataSet.getMinorPSDEFId() == null || pSDEDataSet.getMinorPSDEFName() == null) {
                    PSDEField pSDEField = pSDEDataSet.getMinorPSDEF();
                    pSDEDataSet.setMinorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEDataSet.setMinorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ADPSDELogic(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CacheStatePSDELogic(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEOPPriv(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AggDataPSDER(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InPSDESampleData(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSDESampleData(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubSysSADetail(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InPSSysDynaModel(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTask(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniState(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUserDR(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUserDR2(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDataSet, bl);
    }

    public ArrayList<PSDEDataSet> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataSet> selectByPSDEDataImp(PSDEDataImpBase pSDEDataImpBase) throws Exception {
        return this.selectByPSDEDataImp(pSDEDataImpBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSDEDataImp(PSDEDataImpBase pSDEDataImpBase, String string) throws Exception {
        return this.selectByPSDEDataImp(pSDEDataImpBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSDEDataImp(PSDEDataImpBase pSDEDataImpBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATAIMPID", (Object)pSDEDataImpBase.getPSDEDataImpId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataImpCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataImpCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByInPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByInPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByInPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByInPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByInPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByOutPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByOutPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByOutPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByOutPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByOutPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByMajorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMajorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByMajorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMajorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByMajorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByMinorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMinorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByMinorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMinorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByMinorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByADPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ADPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByADPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByADPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByCacheStatePSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByCacheStatePSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByCacheStatePSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByCacheStatePSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByCacheStatePSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CACHESTATEPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCacheStatePSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCacheStatePSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataSet> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByAggDataPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByAggDataPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByAggDataPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByAggDataPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByAggDataPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AGGDATAPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAggDataPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAggDataPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByInPSDESampleData(PSDESampleDataBase pSDESampleDataBase) throws Exception {
        return this.selectByInPSDESampleData(pSDESampleDataBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByInPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string) throws Exception {
        return this.selectByInPSDESampleData(pSDESampleDataBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByInPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSDESAMPLEDATAID", (Object)pSDESampleDataBase.getPSDESampleDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSDESampleDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSDESampleDataCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByOutPSDESampleData(PSDESampleDataBase pSDESampleDataBase) throws Exception {
        return this.selectByOutPSDESampleData(pSDESampleDataBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByOutPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string) throws Exception {
        return this.selectByOutPSDESampleData(pSDESampleDataBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByOutPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSDESAMPLEDATAID", (Object)pSDESampleDataBase.getPSDESampleDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSDESampleDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSDESampleDataCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase) throws Exception {
        return this.selectByPSSubSysSADetail(pSSubSysSADetailBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase, String string) throws Exception {
        return this.selectByPSSubSysSADetail(pSSubSysSADetailBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSADETAILID", (Object)pSSubSysSADetailBase.getPSSubSysSADetailId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysSADetailCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysSADetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByInPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByInPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByInPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByInPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByInPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataSet> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataSet> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByPSSysTask(PSSysTaskBase pSSysTaskBase) throws Exception {
        return this.selectByPSSysTask(pSSysTaskBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysTask(PSSysTaskBase pSSysTaskBase, String string) throws Exception {
        return this.selectByPSSysTask(pSSysTaskBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysTask(PSSysTaskBase pSSysTaskBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTASKID", (Object)pSSysTaskBase.getPSSysTaskId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTaskCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTaskCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase) throws Exception {
        return this.selectByPSSysUniState(pSSysUniStateBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase, String string) throws Exception {
        return this.selectByPSSysUniState(pSSysUniStateBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNISTATEID", (Object)pSSysUniStateBase.getPSSysUniStateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUniStateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUniStateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByPSSysUserDR(PSSysUserDRBase pSSysUserDRBase) throws Exception {
        return this.selectByPSSysUserDR(pSSysUserDRBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysUserDR(PSSysUserDRBase pSSysUserDRBase, String string) throws Exception {
        return this.selectByPSSysUserDR(pSSysUserDRBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysUserDR(PSSysUserDRBase pSSysUserDRBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSERDRID", (Object)pSSysUserDRBase.getPSSysUserDRId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUserDRCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUserDRCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataSet> selectByPSSysUserDR2(PSSysUserDRBase pSSysUserDRBase) throws Exception {
        return this.selectByPSSysUserDR2(pSSysUserDRBase, "", -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysUserDR2(PSSysUserDRBase pSSysUserDRBase, String string) throws Exception {
        return this.selectByPSSysUserDR2(pSSysUserDRBase, string, -1);
    }

    public ArrayList<PSDEDataSet> selectByPSSysUserDR2(PSSysUserDRBase pSSysUserDRBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSERDRID2", (Object)pSSysUserDRBase.getPSSysUserDRId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUserDR2Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUserDR2Cond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSCodeListId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSDEDataSetServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSDEId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEDataSetServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSDEDataImp(pSDEDataImp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAIMP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataImp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDEDATAIMP_PSDEDATAIMPID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDEDataImp), arrayList.get(0)));
        }
    }

    public void resetPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSDEDataImp(pSDEDataImp);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSDEDataImpId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        final PSDEDataImp pSDEDataImp2 = pSDEDataImp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSDEDataImp(pSDEDataImp2);
                PSDEDataSetServiceBase.this.internalRemoveByPSDEDataImp(pSDEDataImp2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSDEDataImp(pSDEDataImp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
    }

    protected void internalRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSDEDataImp(pSDEDataImp);
        this.onBeforeRemoveByPSDEDataImp(pSDEDataImp, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSDEDataImp(pSDEDataImp, arrayList);
    }

    protected void onAfterRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByInPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDEFGROUP_INPSDEFGROUPID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByInPSDEFGroup(pSDEFGroup);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setInPSDEFGroupId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByInPSDEFGroup(pSDEFGroup2);
                PSDEDataSetServiceBase.this.internalRemoveByInPSDEFGroup(pSDEFGroup2);
                PSDEDataSetServiceBase.this.onAfterRemoveByInPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByInPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByInPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByInPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByOutPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDEFGROUP_OUTPSDEFGROUPID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByOutPSDEFGroup(pSDEFGroup);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setOutPSDEFGroupId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByOutPSDEFGroup(pSDEFGroup2);
                PSDEDataSetServiceBase.this.internalRemoveByOutPSDEFGroup(pSDEFGroup2);
                PSDEDataSetServiceBase.this.onAfterRemoveByOutPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByOutPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByOutPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByOutPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByMajorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDEFIELD_MAJORPSDEFID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByMajorPSDEF(pSDEField);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setMajorPSDEFId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByMajorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByMajorPSDEF(pSDEField2);
                PSDEDataSetServiceBase.this.internalRemoveByMajorPSDEF(pSDEField2);
                PSDEDataSetServiceBase.this.onAfterRemoveByMajorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByMajorPSDEF(pSDEField);
        this.onBeforeRemoveByMajorPSDEF(pSDEField, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByMajorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMajorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSDEF(PSDEField pSDEField, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSDEF(PSDEField pSDEField, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByMinorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDEFIELD_MINORPSDEFID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByMinorPSDEF(pSDEField);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setMinorPSDEFId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByMinorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByMinorPSDEF(pSDEField2);
                PSDEDataSetServiceBase.this.internalRemoveByMinorPSDEF(pSDEField2);
                PSDEDataSetServiceBase.this.onAfterRemoveByMinorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByMinorPSDEF(pSDEField);
        this.onBeforeRemoveByMinorPSDEF(pSDEField, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByMinorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMinorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSDEF(PSDEField pSDEField, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSDEF(PSDEField pSDEField, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByADPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDELOGIC_ADPSDELOGICID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByADPSDELogic(pSDELogic);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setADPSDELogicId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByADPSDELogic(pSDELogic2);
                PSDEDataSetServiceBase.this.internalRemoveByADPSDELogic(pSDELogic2);
                PSDEDataSetServiceBase.this.onAfterRemoveByADPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByADPSDELogic(pSDELogic);
        this.onBeforeRemoveByADPSDELogic(pSDELogic, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByADPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByCacheStatePSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByCacheStatePSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDELOGIC_CACHESTATEPSDELOGICID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetCacheStatePSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByCacheStatePSDELogic(pSDELogic);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setCacheStatePSDELogicId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByCacheStatePSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByCacheStatePSDELogic(pSDELogic2);
                PSDEDataSetServiceBase.this.internalRemoveByCacheStatePSDELogic(pSDELogic2);
                PSDEDataSetServiceBase.this.onAfterRemoveByCacheStatePSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByCacheStatePSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByCacheStatePSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByCacheStatePSDELogic(pSDELogic);
        this.onBeforeRemoveByCacheStatePSDELogic(pSDELogic, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByCacheStatePSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByCacheStatePSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByCacheStatePSDELogic(PSDELogic pSDELogic, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCacheStatePSDELogic(PSDELogic pSDELogic, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSDELogicId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDEDataSetServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDEOPPRIV_PSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSDEOPPrivId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEDataSetServiceBase.this.internalRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByAggDataPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByAggDataPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDER_AGGDATAPSDERID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetAggDataPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByAggDataPSDER(pSDER);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setAggDataPSDERId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByAggDataPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByAggDataPSDER(pSDER2);
                PSDEDataSetServiceBase.this.internalRemoveByAggDataPSDER(pSDER2);
                PSDEDataSetServiceBase.this.onAfterRemoveByAggDataPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByAggDataPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByAggDataPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByAggDataPSDER(pSDER);
        this.onBeforeRemoveByAggDataPSDER(pSDER, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByAggDataPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByAggDataPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByAggDataPSDER(PSDER pSDER, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAggDataPSDER(PSDER pSDER, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByInPSDESampleData(pSDESampleData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESAMPLEDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDESampleData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDESAMPLEDATA_INPSDESAMPLEDATAID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDESampleData), arrayList.get(0)));
        }
    }

    public void resetInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByInPSDESampleData(pSDESampleData);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setInPSDESampleDataId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        final PSDESampleData pSDESampleData2 = pSDESampleData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByInPSDESampleData(pSDESampleData2);
                PSDEDataSetServiceBase.this.internalRemoveByInPSDESampleData(pSDESampleData2);
                PSDEDataSetServiceBase.this.onAfterRemoveByInPSDESampleData(pSDESampleData2);
            }
        });
    }

    protected void onBeforeRemoveByInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void internalRemoveByInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByInPSDESampleData(pSDESampleData);
        this.onBeforeRemoveByInPSDESampleData(pSDESampleData, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByInPSDESampleData(pSDESampleData, arrayList);
    }

    protected void onAfterRemoveByInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void onBeforeRemoveByInPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByOutPSDESampleData(pSDESampleData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESAMPLEDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDESampleData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSDESAMPLEDATA_OUTPSDESAMPLEDATAID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSDESampleData), arrayList.get(0)));
        }
    }

    public void resetOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByOutPSDESampleData(pSDESampleData);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setOutPSDESampleDataId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        final PSDESampleData pSDESampleData2 = pSDESampleData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByOutPSDESampleData(pSDESampleData2);
                PSDEDataSetServiceBase.this.internalRemoveByOutPSDESampleData(pSDESampleData2);
                PSDEDataSetServiceBase.this.onAfterRemoveByOutPSDESampleData(pSDESampleData2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void internalRemoveByOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByOutPSDESampleData(pSDESampleData);
        this.onBeforeRemoveByOutPSDESampleData(pSDESampleData, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByOutPSDESampleData(pSDESampleData, arrayList);
    }

    protected void onAfterRemoveByOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void onBeforeRemoveByOutPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSubSysSADetail(pSSubSysSADetail, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSADETAIL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysSADetail);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSSubSysSADetail), arrayList.get(0)));
        }
    }

    public void resetPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSubSysSADetail(pSSubSysSADetail);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSSubSysSADetailId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        final PSSubSysSADetail pSSubSysSADetail2 = pSSubSysSADetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSSubSysSADetail(pSSubSysSADetail2);
                PSDEDataSetServiceBase.this.internalRemoveByPSSubSysSADetail(pSSubSysSADetail2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSSubSysSADetail(pSSubSysSADetail2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
    }

    protected void internalRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSubSysSADetail(pSSubSysSADetail);
        this.onBeforeRemoveByPSSubSysSADetail(pSSubSysSADetail, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSSubSysSADetail(pSSubSysSADetail, arrayList);
    }

    protected void onAfterRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByInPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSSYSDYNAMODEL_INPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByInPSSysDynaModel(pSSysDynaModel);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setInPSSysDynaModelId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByInPSSysDynaModel(pSSysDynaModel2);
                PSDEDataSetServiceBase.this.internalRemoveByInPSSysDynaModel(pSSysDynaModel2);
                PSDEDataSetServiceBase.this.onAfterRemoveByInPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByInPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByInPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByInPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSSysPFPluginId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDataSetServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSSysReqItemId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEDataSetServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSSysSFPluginId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEDataSetServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysTask(pSSysTask, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTASK");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysTask);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSSYSTASK_PSSYSTASKID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSSysTask), arrayList.get(0)));
        }
    }

    public void resetPSSysTask(PSSysTask pSSysTask) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysTask(pSSysTask);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSSysTaskId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSSysTask(PSSysTask pSSysTask) throws Exception {
        final PSSysTask pSSysTask2 = pSSysTask;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSSysTask(pSSysTask2);
                PSDEDataSetServiceBase.this.internalRemoveByPSSysTask(pSSysTask2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSSysTask(pSSysTask2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
    }

    protected void internalRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysTask(pSSysTask);
        this.onBeforeRemoveByPSSysTask(pSSysTask, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSSysTask(pSSysTask, arrayList);
    }

    protected void onAfterRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTask(PSSysTask pSSysTask, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTask(PSSysTask pSSysTask, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysUniState(pSSysUniState, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNISTATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUniState);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSSYSUNISTATE_PSSYSUNISTATEID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSSysUniState), arrayList.get(0)));
        }
    }

    public void resetPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysUniState(pSSysUniState);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSSysUniStateId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        final PSSysUniState pSSysUniState2 = pSSysUniState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSSysUniState(pSSysUniState2);
                PSDEDataSetServiceBase.this.internalRemoveByPSSysUniState(pSSysUniState2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSSysUniState(pSSysUniState2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
    }

    protected void internalRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysUniState(pSSysUniState);
        this.onBeforeRemoveByPSSysUniState(pSSysUniState, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSSysUniState(pSSysUniState, arrayList);
    }

    protected void onAfterRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniState(PSSysUniState pSSysUniState, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniState(PSSysUniState pSSysUniState, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysUserDR(pSSysUserDR, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERDR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUserDR);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSSYSUSERDR_PSSYSUSERDRID", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSSysUserDR), arrayList.get(0)));
        }
    }

    public void resetPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysUserDR(pSSysUserDR);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSSysUserDRId(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        final PSSysUserDR pSSysUserDR2 = pSSysUserDR;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSSysUserDR(pSSysUserDR2);
                PSDEDataSetServiceBase.this.internalRemoveByPSSysUserDR(pSSysUserDR2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSSysUserDR(pSSysUserDR2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void internalRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysUserDR(pSSysUserDR);
        this.onBeforeRemoveByPSSysUserDR(pSSysUserDR, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSSysUserDR(pSSysUserDR, arrayList);
    }

    protected void onAfterRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysUserDR2(pSSysUserDR, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERDR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUserDR);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATASET_PSSYSUSERDR_PSSYSUSERDRID2", "", iDataEntityModel.getName(), "PSDEDATASET", iDataEntityModel.getDataInfo((IEntity)pSSysUserDR), arrayList.get(0)));
        }
    }

    public void resetPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysUserDR2(pSSysUserDR);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            PSDEDataSet pSDEDataSet2 = (PSDEDataSet)this.getDEModel().createEntity();
            pSDEDataSet2.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDataSet2.setPSSysUserDRId2(null);
            this.update(pSDEDataSet2);
        }
    }

    public void removeByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        final PSSysUserDR pSSysUserDR2 = pSSysUserDR;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataSetServiceBase.this.onBeforeRemoveByPSSysUserDR2(pSSysUserDR2);
                PSDEDataSetServiceBase.this.internalRemoveByPSSysUserDR2(pSSysUserDR2);
                PSDEDataSetServiceBase.this.onAfterRemoveByPSSysUserDR2(pSSysUserDR2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void internalRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEDataSet> arrayList = this.selectByPSSysUserDR2(pSSysUserDR);
        this.onBeforeRemoveByPSSysUserDR2(pSSysUserDR, arrayList);
        for (PSDEDataSet pSDEDataSet : arrayList) {
            this.remove((IEntity)pSDEDataSet);
        }
        this.onAfterRemoveByPSSysUserDR2(pSSysUserDR, arrayList);
    }

    protected void onAfterRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR, ArrayList<PSDEDataSet> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDataSet pSDEDataSet) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByAWIPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionWizardServiceBase)pSCoreSysServiceBase).testRemoveByAWPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEAGDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEDataExpService)ServiceGlobal.getService(PSDEDataExpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataExpServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEDataSyncService)ServiceGlobal.getService(PSDEDataSyncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSyncServiceBase)pSCoreSysServiceBase).testRemoveByInPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEDataSyncService)ServiceGlobal.getService(PSDEDataSyncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSyncServiceBase)pSCoreSysServiceBase).testRemoveByOutPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByAsyncPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEDSCodeService)ServiceGlobal.getService(PSDEDSCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        ((PSDEDSCodeServiceBase)pSCoreSysServiceBase).removeByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSDQServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        ((PSDEDSDQServiceBase)pSCoreSysServiceBase).removeByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSGrpParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        ((PSDEDSGrpParamServiceBase)pSCoreSysServiceBase).removeByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        ((PSDEDSParamServiceBase)pSCoreSysServiceBase).removeByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEFInputTipSetService)ServiceGlobal.getService(PSDEFInputTipSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFInputTipSetServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFVRCondServiceBase)pSCoreSysServiceBase).testRemoveByMajorPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByAggPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByAsyncPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        ((PSDEGridServiceBase)pSCoreSysServiceBase).resetPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByAsyncPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDSServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEMapDSService)ServiceGlobal.getService(PSDEMapDSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDSServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDENotifyService)ServiceGlobal.getService(PSDENotifyService.class, (SessionFactory)this.getSessionFactory());
        ((PSDENotifyServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEPrintServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEReportServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEReportServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS2(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEReportServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS3(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEReportServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS4(pSDEDataSet);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByMinorPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESADetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByFilterPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEUserRoleService)ServiceGlobal.getService(PSDEUserRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUserRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEViewCtrlDSService)ServiceGlobal.getService(PSDEViewCtrlDSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlDSServiceBase)pSCoreSysServiceBase).testRemoveByPsdedataset(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEViewServiceService)ServiceGlobal.getService(PSDEViewServiceService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewServiceServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysAIPipelineJobService)ServiceGlobal.getService(PSSysAIPipelineJobService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIPipelineJobServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysBackServiceService)ServiceGlobal.getService(PSSysBackServiceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBackServiceServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysBIAggTableService)ServiceGlobal.getService(PSSysBIAggTableService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIAggTableServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByAsyncPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCounterServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByAsyncPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysMsgTargetService)ServiceGlobal.getService(PSSysMsgTargetService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTargetServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysOPPrivService)ServiceGlobal.getService(PSSysOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysOPPrivServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByFilterPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysResourceServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).testRemoveByFilterPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTDItemServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSThresholdGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByEmbedPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcSubWFServiceBase)pSCoreSysServiceBase).testRemoveByEmbedPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSWFRoleService)ServiceGlobal.getService(PSWFRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDS(pSDEDataSet);
        super.onBeforeRemove(pSDEDataSet);
    }

    protected void onBeforeRemoveTemp(PSDEDataSet pSDEDataSet) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSGrpParamServiceBase)pSCoreSysServiceBase).removeTempByPSDEDS(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSDQServiceBase)pSCoreSysServiceBase).removeTempByPSDEDataSet(pSDEDataSet);
        pSCoreSysServiceBase = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSParamServiceBase)pSCoreSysServiceBase).removeTempByPSDEDS(pSDEDataSet);
        super.onBeforeRemoveTemp((IEntity)pSDEDataSet);
    }

    protected void getRelatedDataTempMajor(PSDEDataSet pSDEDataSet) throws Exception {
        this.getRelatedDataTempMajor_PSDEDSParam(pSDEDataSet);
        this.getRelatedDataTempMajor_PSDEDSDQ(pSDEDataSet);
        this.getRelatedDataTempMajor_PSDEDSGrpParam(pSDEDataSet);
        super.getRelatedDataTempMajor((IEntity)pSDEDataSet);
    }

    protected void getRelatedDataTempMajor_PSDEDSParam(PSDEDataSet pSDEDataSet) throws Exception {
        PSDEDSParamService pSDEDSParamService = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDSParam> arrayList = null;
        String string = pSDEDataSet.getPSDEDataSetId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDSParamService.selectByPSDEDS(pSDEDataSet) : pSDEDSParamService.selectTempByPSDEDS(pSDEDataSet);
        for (PSDEDSParam pSDEDSParam : arrayList) {
            pSDEDSParamService.getTempMajor(pSDEDSParam);
        }
    }

    protected void getRelatedDataTempMajor_PSDEDSDQ(PSDEDataSet pSDEDataSet) throws Exception {
        PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDSDQ> arrayList = null;
        String string = pSDEDataSet.getPSDEDataSetId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDSDQService.selectByPSDEDataSet(pSDEDataSet) : pSDEDSDQService.selectTempByPSDEDataSet(pSDEDataSet);
        for (PSDEDSDQ pSDEDSDQ : arrayList) {
            pSDEDSDQService.getTempMajor(pSDEDSDQ);
        }
    }

    protected void getRelatedDataTempMajor_PSDEDSGrpParam(PSDEDataSet pSDEDataSet) throws Exception {
        PSDEDSGrpParamService pSDEDSGrpParamService = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDSGrpParam> arrayList = null;
        String string = pSDEDataSet.getPSDEDataSetId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDSGrpParamService.selectByPSDEDS(pSDEDataSet) : pSDEDSGrpParamService.selectTempByPSDEDS(pSDEDataSet);
        for (PSDEDSGrpParam pSDEDSGrpParam : arrayList) {
            pSDEDSGrpParamService.getTempMajor(pSDEDSGrpParam);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEDataSet pSDEDataSet, PSDEDataSet pSDEDataSet2) throws Exception {
        ArrayList<PSDEDSGrpParam> arrayList = this.updateRelatedDataTempMajor_removePSDEDSGrpParam(pSDEDataSet, pSDEDataSet2);
        ArrayList<PSDEDSDQ> arrayList2 = this.updateRelatedDataTempMajor_removePSDEDSDQ(pSDEDataSet, pSDEDataSet2);
        ArrayList<PSDEDSParam> arrayList3 = this.updateRelatedDataTempMajor_removePSDEDSParam(pSDEDataSet, pSDEDataSet2);
        this.updateRelatedDataTempMajor_updatePSDEDSParam(pSDEDataSet, pSDEDataSet2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSDEDSDQ(pSDEDataSet, pSDEDataSet2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEDSGrpParam(pSDEDataSet, pSDEDataSet2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDEDataSet, (IEntity)pSDEDataSet2);
    }

    protected ArrayList<PSDEDSParam> updateRelatedDataTempMajor_removePSDEDSParam(PSDEDataSet pSDEDataSet, PSDEDataSet pSDEDataSet2) throws Exception {
        PSDEDSParamService pSDEDSParamService = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDSParam> arrayList = pSDEDSParamService.selectTempByPSDEDS(pSDEDataSet);
        ArrayList<PSDEDSParam> arrayList2 = pSDEDSParamService.selectByPSDEDS(pSDEDataSet2);
        HashMap<String, PSDEDSParam> hashMap = new HashMap<String, PSDEDSParam>();
        for (PSDEDSParam pSDEDSParam : arrayList2) {
            hashMap.put(pSDEDSParam.getPSDEDSParamId(), pSDEDSParam);
        }
        for (PSDEDSParam pSDEDSParam : arrayList) {
            Object object = pSDEDSParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEDSParam pSDEDSParam : hashMap.values()) {
            pSDEDSParamService.remove((IEntity)pSDEDSParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEDSParam(PSDEDataSet pSDEDataSet, PSDEDataSet pSDEDataSet2, ArrayList<PSDEDSParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEDSParamService pSDEDSParamService = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEDSParam pSDEDSParam : arrayList) {
            pSDEDSParamService.updateTempMajor(pSDEDSParam);
        }
    }

    protected ArrayList<PSDEDSDQ> updateRelatedDataTempMajor_removePSDEDSDQ(PSDEDataSet pSDEDataSet, PSDEDataSet pSDEDataSet2) throws Exception {
        PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDSDQ> arrayList = pSDEDSDQService.selectTempByPSDEDataSet(pSDEDataSet);
        ArrayList<PSDEDSDQ> arrayList2 = pSDEDSDQService.selectByPSDEDataSet(pSDEDataSet2);
        HashMap<String, PSDEDSDQ> hashMap = new HashMap<String, PSDEDSDQ>();
        for (PSDEDSDQ pSDEDSDQ : arrayList2) {
            hashMap.put(pSDEDSDQ.getPSDEDSDQId(), pSDEDSDQ);
        }
        for (PSDEDSDQ pSDEDSDQ : arrayList) {
            Object object = pSDEDSDQ.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEDSDQ pSDEDSDQ : hashMap.values()) {
            pSDEDSDQService.remove((IEntity)pSDEDSDQ);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEDSDQ(PSDEDataSet pSDEDataSet, PSDEDataSet pSDEDataSet2, ArrayList<PSDEDSDQ> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEDSDQ pSDEDSDQ : arrayList) {
            pSDEDSDQService.updateTempMajor(pSDEDSDQ);
        }
    }

    protected ArrayList<PSDEDSGrpParam> updateRelatedDataTempMajor_removePSDEDSGrpParam(PSDEDataSet pSDEDataSet, PSDEDataSet pSDEDataSet2) throws Exception {
        PSDEDSGrpParamService pSDEDSGrpParamService = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDSGrpParam> arrayList = pSDEDSGrpParamService.selectTempByPSDEDS(pSDEDataSet);
        ArrayList<PSDEDSGrpParam> arrayList2 = pSDEDSGrpParamService.selectByPSDEDS(pSDEDataSet2);
        HashMap<String, PSDEDSGrpParam> hashMap = new HashMap<String, PSDEDSGrpParam>();
        for (PSDEDSGrpParam pSDEDSGrpParam : arrayList2) {
            hashMap.put(pSDEDSGrpParam.getPSDEDSGrpParamId(), pSDEDSGrpParam);
        }
        for (PSDEDSGrpParam pSDEDSGrpParam : arrayList) {
            Object object = pSDEDSGrpParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEDSGrpParam pSDEDSGrpParam : hashMap.values()) {
            pSDEDSGrpParamService.remove((IEntity)pSDEDSGrpParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEDSGrpParam(PSDEDataSet pSDEDataSet, PSDEDataSet pSDEDataSet2, ArrayList<PSDEDSGrpParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEDSGrpParamService pSDEDSGrpParamService = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEDSGrpParam pSDEDSGrpParam : arrayList) {
            pSDEDSGrpParamService.updateTempMajor(pSDEDSGrpParam);
        }
    }

    protected void replaceParentInfo(PSDEDataSet pSDEDataSet, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEDataSet, cloneSession);
        if (pSDEDataSet.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEDataSet.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSDEDataSet, (PSCodeList)iEntity);
        }
        if (pSDEDataSet.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDataSet.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEDataSet, (PSDataEntity)iEntity);
        }
        if (pSDEDataSet.getPSDEDataImpId() != null && (iEntity = cloneSession.getEntity("PSDEDATAIMP", (Object)pSDEDataSet.getPSDEDataImpId())) != null) {
            this.onFillParentInfo_PSDEDataImp(pSDEDataSet, (PSDEDataImp)iEntity);
        }
        if (pSDEDataSet.getInPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDEDataSet.getInPSDEFGroupId())) != null) {
            this.onFillParentInfo_InPSDEFGroup(pSDEDataSet, (PSDEFGroup)iEntity);
        }
        if (pSDEDataSet.getOutPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDEDataSet.getOutPSDEFGroupId())) != null) {
            this.onFillParentInfo_OutPSDEFGroup(pSDEDataSet, (PSDEFGroup)iEntity);
        }
        if (pSDEDataSet.getMajorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDataSet.getMajorPSDEFId())) != null) {
            this.onFillParentInfo_MajorPSDEF(pSDEDataSet, (PSDEField)iEntity);
        }
        if (pSDEDataSet.getMinorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDataSet.getMinorPSDEFId())) != null) {
            this.onFillParentInfo_MinorPSDEF(pSDEDataSet, (PSDEField)iEntity);
        }
        if (pSDEDataSet.getADPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEDataSet.getADPSDELogicId())) != null) {
            this.onFillParentInfo_ADPSDELogic(pSDEDataSet, (PSDELogic)iEntity);
        }
        if (pSDEDataSet.getCacheStatePSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEDataSet.getCacheStatePSDELogicId())) != null) {
            this.onFillParentInfo_CacheStatePSDELogic(pSDEDataSet, (PSDELogic)iEntity);
        }
        if (pSDEDataSet.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEDataSet.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDEDataSet, (PSDELogic)iEntity);
        }
        if (pSDEDataSet.getPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEDataSet.getPSDEOPPrivId())) != null) {
            this.onFillParentInfo_PSDEOPPriv(pSDEDataSet, (PSDEOPPriv)iEntity);
        }
        if (pSDEDataSet.getAggDataPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEDataSet.getAggDataPSDERId())) != null) {
            this.onFillParentInfo_AggDataPSDER(pSDEDataSet, (PSDER)iEntity);
        }
        if (pSDEDataSet.getInPSDESampleDataId() != null && (iEntity = cloneSession.getEntity("PSDESAMPLEDATA", (Object)pSDEDataSet.getInPSDESampleDataId())) != null) {
            this.onFillParentInfo_InPSDESampleData(pSDEDataSet, (PSDESampleData)iEntity);
        }
        if (pSDEDataSet.getOutPSDESampleDataId() != null && (iEntity = cloneSession.getEntity("PSDESAMPLEDATA", (Object)pSDEDataSet.getOutPSDESampleDataId())) != null) {
            this.onFillParentInfo_OutPSDESampleData(pSDEDataSet, (PSDESampleData)iEntity);
        }
        if (pSDEDataSet.getPSSubSysSADetailId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADETAIL", (Object)pSDEDataSet.getPSSubSysSADetailId())) != null) {
            this.onFillParentInfo_PSSubSysSADetail(pSDEDataSet, (PSSubSysSADetail)iEntity);
        }
        if (pSDEDataSet.getInPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEDataSet.getInPSSysDynaModelId())) != null) {
            this.onFillParentInfo_InPSSysDynaModel(pSDEDataSet, (PSSysDynaModel)iEntity);
        }
        if (pSDEDataSet.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEDataSet.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEDataSet, (PSSysPFPlugin)iEntity);
        }
        if (pSDEDataSet.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEDataSet.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEDataSet, (PSSysReqItem)iEntity);
        }
        if (pSDEDataSet.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEDataSet.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEDataSet, (PSSysSFPlugin)iEntity);
        }
        if (pSDEDataSet.getPSSysTaskId() != null && (iEntity = cloneSession.getEntity("PSSYSTASK", (Object)pSDEDataSet.getPSSysTaskId())) != null) {
            this.onFillParentInfo_PSSysTask(pSDEDataSet, (PSSysTask)iEntity);
        }
        if (pSDEDataSet.getPSSysUniStateId() != null && (iEntity = cloneSession.getEntity("PSSYSUNISTATE", (Object)pSDEDataSet.getPSSysUniStateId())) != null) {
            this.onFillParentInfo_PSSysUniState(pSDEDataSet, (PSSysUniState)iEntity);
        }
        if (pSDEDataSet.getPSSysUserDRId() != null && (iEntity = cloneSession.getEntity("PSSYSUSERDR", (Object)pSDEDataSet.getPSSysUserDRId())) != null) {
            this.onFillParentInfo_PSSysUserDR(pSDEDataSet, (PSSysUserDR)iEntity);
        }
        if (pSDEDataSet.getPSSysUserDRId2() != null && (iEntity = cloneSession.getEntity("PSSYSUSERDR", (Object)pSDEDataSet.getPSSysUserDRId2())) != null) {
            this.onFillParentInfo_PSSysUserDR2(pSDEDataSet, (PSSysUserDR)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDataSet, bl);
        pSDEDataSet.resetDSTag();
        pSDEDataSet.resetDSTag2();
        pSDEDataSet.resetDSTag3();
        pSDEDataSet.resetDSTag4();
    }

    protected void onCheckEntity(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionHolder(bl, pSDEDataSet, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ADPSDELogicId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AfterCode(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AggDataPSDERId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeforeCode(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheCat(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheCheckState(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheScope(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheStatePSDELogicId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTag(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTimeout(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataSetParams(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataSetSN(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultMode(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSOption(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSTag(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSTag2(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSTag3(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSTag4(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAudit(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCache(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableGroup(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableOrgDR(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSecBC(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSecDR(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableTempData(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableUserDR(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendMode(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FilterModel(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSDEFGroupId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSDESampleDataId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSSysDynaModelId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDEFId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDEFName(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorSortDir(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEFId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEFName(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortDir(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrgDR(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSDEFGroupId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSDESampleDataId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageSize(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_POTime(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedTypeParam(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefineType(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataImpId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetName(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADetailId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTaskId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniStateId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserDRId(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserDRId2(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubMode(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawServiceMethod(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawServiceUrl(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestMethod(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestPath(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RetValType(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SecBC(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SecDR(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubSysSADetailMode(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysUserDR2Param(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysUserDRParam(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UnionMode(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewColLevel(bl, pSDEDataSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDataSet, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionHolder(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isActionHolderDirty() : !pSDEDataSet.isActionHolderDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getActionHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ActionHolder_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ADPSDELogicId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isADPSDELogicIdDirty() : !pSDEDataSet.isADPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getADPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ADPSDELogicId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AfterCode(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isAfterCodeDirty() : !pSDEDataSet.isAfterCodeDirty()) {
            return null;
        }
        String string = pSDEDataSet.getAfterCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AfterCode_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AFTERCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AggDataPSDERId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isAggDataPSDERIdDirty() : !pSDEDataSet.isAggDataPSDERIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getAggDataPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggDataPSDERId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGDATAPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeforeCode(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isBeforeCodeDirty() : !pSDEDataSet.isBeforeCodeDirty()) {
            return null;
        }
        String string = pSDEDataSet.getBeforeCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeforeCode_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEFORECODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheCat(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isCacheCatDirty() : !pSDEDataSet.isCacheCatDirty()) {
            return null;
        }
        String string = pSDEDataSet.getCacheCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheCat_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHECAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheCheckState(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isCacheCheckStateDirty() : !pSDEDataSet.isCacheCheckStateDirty()) {
            return null;
        }
        String string = pSDEDataSet.getCacheCheckState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheCheckState_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHECHECKSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheScope(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isCacheScopeDirty() : !pSDEDataSet.isCacheScopeDirty()) {
            return null;
        }
        String string = pSDEDataSet.getCacheScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheScope_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHESCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheStatePSDELogicId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isCacheStatePSDELogicIdDirty() : !pSDEDataSet.isCacheStatePSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getCacheStatePSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheStatePSDELogicId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHESTATEPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTag(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isCacheTagDirty() : !pSDEDataSet.isCacheTagDirty()) {
            return null;
        }
        String string = pSDEDataSet.getCacheTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheTag_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTimeout(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isCacheTimeoutDirty() : !pSDEDataSet.isCacheTimeoutDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getCacheTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CacheTimeout_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isCodeNameDirty() : !pSDEDataSet.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEDataSet.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEDataSet, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEDataSetDEModel(), "CODENAME", string3, pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isCustomCodeDirty() : !pSDEDataSet.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEDataSet.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isCustomModeDirty() : !pSDEDataSet.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataSetParams(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isDataSetParamsDirty() : !pSDEDataSet.isDataSetParamsDirty()) {
            return null;
        }
        String string = pSDEDataSet.getDataSetParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataSetParams_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATASETPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataSetSN(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isDataSetSNDirty() : !pSDEDataSet.isDataSetSNDirty()) {
            return null;
        }
        String string = pSDEDataSet.getDataSetSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataSetSN_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATASETSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultMode(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isDefaultModeDirty() : !pSDEDataSet.isDefaultModeDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getDefaultMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultMode_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEID";
                String string2 = this.checkFieldDupRule(this.getPSDEDataSetDEModel(), "DEFAULTMODE", string, pSDEDataSet, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTMODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSOption(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isDSOptionDirty() : !pSDEDataSet.isDSOptionDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getDSOption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DSOption_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSOPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSTag(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isDSTagDirty() : !pSDEDataSet.isDSTagDirty()) {
            return null;
        }
        String string = pSDEDataSet.getDSTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSTag_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSTag2(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isDSTag2Dirty() : !pSDEDataSet.isDSTag2Dirty()) {
            return null;
        }
        String string = pSDEDataSet.getDSTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSTag2_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSTag3(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isDSTag3Dirty() : !pSDEDataSet.isDSTag3Dirty()) {
            return null;
        }
        String string = pSDEDataSet.getDSTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSTag3_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSTag4(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isDSTag4Dirty() : !pSDEDataSet.isDSTag4Dirty()) {
            return null;
        }
        String string = pSDEDataSet.getDSTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSTag4_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isDynaModelFlagDirty() : !pSDEDataSet.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableAudit(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isEnableAuditDirty() : !pSDEDataSet.isEnableAuditDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getEnableAudit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableAudit_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEAUDIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCache(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isEnableCacheDirty() : !pSDEDataSet.isEnableCacheDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getEnableCache();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCache_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECACHE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableGroup(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isEnableGroupDirty() : !pSDEDataSet.isEnableGroupDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getEnableGroup();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableGroup_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEGROUP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableOrgDR(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isEnableOrgDRDirty() : !pSDEDataSet.isEnableOrgDRDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getEnableOrgDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableOrgDR_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEORGDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableSecBC(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isEnableSecBCDirty() : !pSDEDataSet.isEnableSecBCDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getEnableSecBC();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSecBC_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESECBC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableSecDR(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isEnableSecDRDirty() : !pSDEDataSet.isEnableSecDRDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getEnableSecDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSecDR_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESECDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableTempData(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isEnableTempDataDirty() : !pSDEDataSet.isEnableTempDataDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getEnableTempData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableTempData_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLETEMPDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableUserDR(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isEnableUserDRDirty() : !pSDEDataSet.isEnableUserDRDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getEnableUserDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableUserDR_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEUSERDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtendMode(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isExtendModeDirty() : !pSDEDataSet.isExtendModeDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getExtendMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendMode_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTENDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FilterModel(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isFilterModelDirty() : !pSDEDataSet.isFilterModelDirty()) {
            return null;
        }
        String string = pSDEDataSet.getFilterModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FilterModel_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILTERMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSDEFGroupId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isInPSDEFGroupIdDirty() : !pSDEDataSet.isInPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getInPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSDEFGroupId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSDESampleDataId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isInPSDESampleDataIdDirty() : !pSDEDataSet.isInPSDESampleDataIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getInPSDESampleDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSDESampleDataId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSDESAMPLEDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSSysDynaModelId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isInPSSysDynaModelIdDirty() : !pSDEDataSet.isInPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getInPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSSysDynaModelId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isLockFlagDirty() : !pSDEDataSet.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isLogicNameDirty() : !pSDEDataSet.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEDataSet.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_MajorPSDEFId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isMajorPSDEFIdDirty() : !pSDEDataSet.isMajorPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getMajorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEFId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDEFName(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isMajorPSDEFNameDirty() : !pSDEDataSet.isMajorPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDataSet.getMajorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEFName_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorSortDir(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isMajorSortDirDirty() : !pSDEDataSet.isMajorSortDirDirty()) {
            return null;
        }
        String string = pSDEDataSet.getMajorSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorSortDir_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORSORTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isMemoDirty() : !pSDEDataSet.isMemoDirty()) {
            return null;
        }
        String string = pSDEDataSet.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorPSDEFId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isMinorPSDEFIdDirty() : !pSDEDataSet.isMinorPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getMinorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEFId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorPSDEFName(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isMinorPSDEFNameDirty() : !pSDEDataSet.isMinorPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDataSet.getMinorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEFName_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorSortDir(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isMinorSortDirDirty() : !pSDEDataSet.isMinorSortDirDirty()) {
            return null;
        }
        String string = pSDEDataSet.getMinorSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortDir_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isOrderValueDirty() : !pSDEDataSet.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrgDR(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isOrgDRDirty() : !pSDEDataSet.isOrgDRDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getOrgDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrgDR_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORGDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutPSDEFGroupId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isOutPSDEFGroupIdDirty() : !pSDEDataSet.isOutPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getOutPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSDEFGroupId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutPSDESampleDataId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isOutPSDESampleDataIdDirty() : !pSDEDataSet.isOutPSDESampleDataIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getOutPSDESampleDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSDESampleDataId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSDESAMPLEDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageSize(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPageSizeDirty() : !pSDEDataSet.isPageSizeDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getPageSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PageSize_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGESIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isParamTypeDirty() : !pSDEDataSet.isParamTypeDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getParamType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ParamType_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_POTime(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPOTimeDirty() : !pSDEDataSet.isPOTimeDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getPOTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_POTime_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedTypeParam(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPredefinedTypeParamDirty() : !pSDEDataSet.isPredefinedTypeParamDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPredefinedTypeParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedTypeParam_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefineType(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPredefineTypeDirty() : !pSDEDataSet.isPredefineTypeDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPredefineType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefineType_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSCodeListIdDirty() : !pSDEDataSet.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataImpId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSDEDataImpIdDirty() : !pSDEDataSet.isPSDEDataImpIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSDEDataImpId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataImpId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAIMPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSDEDataSetIdDirty() && !bl2 : !pSDEDataSet.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSDEDataSetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetName(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSDEDataSetNameDirty() && !bl2 : !pSDEDataSet.isPSDEDataSetNameDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSDEDataSetName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetName_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEDataSetDEModel(), "PSDEDATASETNAME", string3, pSDEDataSet, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDATASETNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSDEIdDirty() && !bl2 : !pSDEDataSet.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSDELogicIdDirty() : !pSDEDataSet.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSDENameDirty() && !bl2 : !pSDEDataSet.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEOPPrivId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSDEOPPrivIdDirty() : !pSDEDataSet.isPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSDynaInstIdDirty() : !pSDEDataSet.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysSADetailId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSSubSysSADetailIdDirty() : !pSDEDataSet.isPSSubSysSADetailIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSSubSysSADetailId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADetailId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSSysPFPluginIdDirty() : !pSDEDataSet.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSSysReqItemIdDirty() : !pSDEDataSet.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSSysSFPluginIdDirty() : !pSDEDataSet.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTaskId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSSysTaskIdDirty() : !pSDEDataSet.isPSSysTaskIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSSysTaskId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTaskId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTASKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUniStateId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSSysUniStateIdDirty() : !pSDEDataSet.isPSSysUniStateIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSSysUniStateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniStateId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNISTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserDRId(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSSysUserDRIdDirty() : !pSDEDataSet.isPSSysUserDRIdDirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSSysUserDRId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserDRId_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERDRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserDRId2(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPSSysUserDRId2Dirty() : !pSDEDataSet.isPSSysUserDRId2Dirty()) {
            return null;
        }
        String string = pSDEDataSet.getPSSysUserDRId2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserDRId2_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERDRID2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubMode(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isPubModeDirty() : !pSDEDataSet.isPubModeDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getPubMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubMode_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawServiceMethod(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isRawServiceMethodDirty() : !pSDEDataSet.isRawServiceMethodDirty()) {
            return null;
        }
        String string = pSDEDataSet.getRawServiceMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawServiceMethod_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWSERVICEMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawServiceUrl(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isRawServiceUrlDirty() : !pSDEDataSet.isRawServiceUrlDirty()) {
            return null;
        }
        String string = pSDEDataSet.getRawServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawServiceUrl_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWSERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RequestMethod(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isRequestMethodDirty() : !pSDEDataSet.isRequestMethodDirty()) {
            return null;
        }
        String string = pSDEDataSet.getRequestMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestMethod_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQUESTMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RequestPath(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isRequestPathDirty() : !pSDEDataSet.isRequestPathDirty()) {
            return null;
        }
        String string = pSDEDataSet.getRequestPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestPath_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQUESTPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RetValType(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isRetValTypeDirty() : !pSDEDataSet.isRetValTypeDirty()) {
            return null;
        }
        String string = pSDEDataSet.getRetValType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RetValType_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RETVALTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SecBC(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isSecBCDirty() : !pSDEDataSet.isSecBCDirty()) {
            return null;
        }
        String string = pSDEDataSet.getSecBC();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SecBC_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECBC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SecDR(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isSecDRDirty() : !pSDEDataSet.isSecDRDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getSecDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SecDR_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isServiceCodeNameDirty() : !pSDEDataSet.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSDEDataSet.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICECODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubSysSADetailMode(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isSubSysSADetailModeDirty() : !pSDEDataSet.isSubSysSADetailModeDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getSubSysSADetailMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SubSysSADetailMode_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBSYSSADETAILMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysUserDR2Param(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isSysUserDR2ParamDirty() : !pSDEDataSet.isSysUserDR2ParamDirty()) {
            return null;
        }
        String string = pSDEDataSet.getSysUserDR2Param();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysUserDR2Param_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSUSERDR2PARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysUserDRParam(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isSysUserDRParamDirty() : !pSDEDataSet.isSysUserDRParamDirty()) {
            return null;
        }
        String string = pSDEDataSet.getSysUserDRParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysUserDRParam_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSUSERDRPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isToDoTaskDirty() : !pSDEDataSet.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEDataSet.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UnionMode(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isUnionModeDirty() : !pSDEDataSet.isUnionModeDirty()) {
            return null;
        }
        String string = pSDEDataSet.getUnionMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UnionMode_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIONMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isUserCatDirty() : !pSDEDataSet.isUserCatDirty()) {
            return null;
        }
        String string = pSDEDataSet.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isUserParamsDirty() : !pSDEDataSet.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEDataSet.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isUserTagDirty() : !pSDEDataSet.isUserTagDirty()) {
            return null;
        }
        String string = pSDEDataSet.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isUserTag2Dirty() : !pSDEDataSet.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEDataSet.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isUserTag3Dirty() : !pSDEDataSet.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEDataSet.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isUserTag4Dirty() : !pSDEDataSet.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEDataSet.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isValidFlagDirty() : !pSDEDataSet.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEDataSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewColLevel(boolean bl, PSDEDataSet pSDEDataSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataSet.isViewColLevelDirty() : !pSDEDataSet.isViewColLevelDirty()) {
            return null;
        }
        Integer n = pSDEDataSet.getViewColLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewColLevel_Default((IEntity)pSDEDataSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWCOLLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDataSet, bl);
    }

    protected void onSyncIndexEntities(PSDEDataSet pSDEDataSet, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDataSet, bl);
    }

    public Object getDataContextValue(PSDEDataSet pSDEDataSet, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDER", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"MAJORPSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AGGDATAPSDERID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AGGDATAPSDERNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEDataSet, "psdeid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue((IEntity)pSDEDataSet, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEDataSet.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEDataSet pSDEDataSet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEDSParam_PSDEDS(pSDEDataSet, arrayList, n);
        this.onExportRelatedModel_PSDEDSDQ_PSDEDataSet(pSDEDataSet, arrayList, n);
        this.onExportRelatedModel_PSDEDSGrpParam_PSDEDS(pSDEDataSet, arrayList, n);
        super.onExportRelatedModel((IEntity)pSDEDataSet, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEDSParam_PSDEDS(PSDEDataSet pSDEDataSet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDSParamService pSDEDSParamService = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDSParam> arrayList2 = pSDEDSParamService.selectByPSDEDS(pSDEDataSet);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"b8b5705d921898bf915a3123f570fb57");
            jSONObject.put("srfdename", (Object)"PSDEDSPARAM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEDSPARAM_PSDEDATASET_PSDEDSID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDataSet, (String)"PSDEDATASETID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEDSParam pSDEDSParam : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDSParam, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDSParamService.exportModel(pSDEDSParam, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEDSDQ_PSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDSDQ> arrayList2 = pSDEDSDQService.selectByPSDEDataSet(pSDEDataSet);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"349ed753b7f6303cc412d1f5bde24665");
            jSONObject.put("srfdename", (Object)"PSDEDSDQ");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDataSet, (String)"PSDEDATASETID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEDSDQ pSDEDSDQ : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDSDQ, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDSDQService.exportModel(pSDEDSDQ, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEDSGrpParam_PSDEDS(PSDEDataSet pSDEDataSet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDSGrpParamService pSDEDSGrpParamService = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDSGrpParam> arrayList2 = pSDEDSGrpParamService.selectByPSDEDS(pSDEDataSet);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"daf9d930ca6e3b9822541aa318b1e5ba");
            jSONObject.put("srfdename", (Object)"PSDEDSGRPPARAM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEDSGRPPARAM_PSDEDATASET_PSDEDSID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDataSet, (String)"PSDEDATASETID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEDSGrpParam pSDEDSGrpParam : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDSGrpParam, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDSGrpParamService.exportModel(pSDEDSGrpParam, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEDataSet pSDEDataSet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEDataSet, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AFTERCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AfterCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGDATAPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggDataPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGDATAPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggDataPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEFORECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeforeCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHECAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHECHECKSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheCheckState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHESCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheScope_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHESTATEPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheStatePSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHESTATEPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheStatePSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTimeout_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATASETPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataSetParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATASETSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataSetSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSOPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSOption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEAUDIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableAudit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECACHE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCache_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEGROUP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableGroup_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEORGDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableOrgDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESECBC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSecBC_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESECDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSecDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLETEMPDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableTempData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEUSERDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableUserDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILTERMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilterModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDESAMPLEDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDESampleDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDESAMPLEDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDESampleDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORSORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorSortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORGDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrgDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDESAMPLEDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDESampleDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDESAMPLEDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDESampleDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGESIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_POTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefineType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAIMPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataImpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAIMPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataImpName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTASKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTaskId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTASKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTaskName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNISTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNISTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRID2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRId2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRNAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWSERVICEMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawServiceMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWSERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawServiceUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQUESTMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RequestMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQUESTPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RequestPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RETVALTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RetValType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECBC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SecBC_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SecDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBSYSSADETAILMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubSysSADetailMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSUSERDR2PARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysUserDR2Param_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSUSERDRPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysUserDRParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNIONMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UnionMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWCOLLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewColLevel_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ADPSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ADPSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AfterCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AFTERCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggDataPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGDATAPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggDataPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGDATAPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeforeCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEFORECODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHECAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheCheckState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHECHECKSTATE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHESCOPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheStatePSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHESTATEPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheStatePSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHESTATEPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_CustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DataSetParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATASETPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataSetSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATASETSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DSOption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DSTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTAG", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DSTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DSTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTAG3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DSTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTAG4", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_EnableAudit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCache_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableGroup_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableOrgDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSecBC_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSecDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableTempData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableUserDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtendMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FilterModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILTERMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InPSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDESampleDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDESAMPLEDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDESampleDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDESAMPLEDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorSortDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORSORTDIR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected String onTestValueRule_MinorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTDIR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrgDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OutPSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSDESampleDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDESAMPLEDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSDESampleDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDESAMPLEDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PageSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ParamType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_POTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PredefinedTypeParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPEPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedTypeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefineType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINETYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataImpId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAIMPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataImpName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAIMPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDEDATASETNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTaskId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTASKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTaskName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTASKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniStateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNISTATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNISTATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRId2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRID2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRNAME2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RawServiceMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWSERVICEMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWSERVICEURL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RequestMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQUESTMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RequestPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQUESTPATH", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RetValType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RETVALTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SecBC_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SECBC", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SecDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICECODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubSysSADetailMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysUserDR2Param_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSUSERDR2PARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysUserDRParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSUSERDRPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_UnionMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNIONMODE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected String onTestValueRule_ViewColLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEDataSet pSDEDataSet) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDataSet)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDataSet pSDEDataSet) throws Exception {
        Object object = pSDEDataSet.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEDATASET_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEDataSet);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEDataSet pSDEDataSet, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDATASET");
        if (!bl) {
            pSDEDataSet.setCreateDate(null);
            pSDEDataSet.setCreateMan(null);
            pSDEDataSet.setPSDEDataSetId(null);
            pSDEDataSet.setPSSysUniStateName(null);
            pSDEDataSet.setUpdateDate(null);
            pSDEDataSet.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDataSet, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEDataSet pSDEDataSet, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEDSParam(pSDEDataSet, xmlNode);
        this.exportRelatedXmlModel_PSDEDSDQ(pSDEDataSet, xmlNode);
        super.onExportRelatedXmlModel(pSDEDataSet, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEDSParam(PSDEDataSet pSDEDataSet, XmlNode xmlNode) throws Exception {
        PSDEDSParamService pSDEDSParamService = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDSParam> arrayList = null;
        String string = pSDEDataSet.getPSDEDataSetId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDSParamService.selectByPSDEDS(pSDEDataSet, "ORDER BY ORDERVALUE ASC") : pSDEDSParamService.selectTempByPSDEDS(pSDEDataSet, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEDSPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSDEDSParam pSDEDSParam : arrayList) {
                pSDEDSParam.set("ORDERVALUE", null);
                pSDEDSParamService.exportXmlModel(pSDEDSParam, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEDSDQ(PSDEDataSet pSDEDataSet, XmlNode xmlNode) throws Exception {
        PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDSDQ> arrayList = null;
        String string = pSDEDataSet.getPSDEDataSetId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDSDQService.selectByPSDEDataSet(pSDEDataSet, "ORDER BY ORDERVALUE ASC") : pSDEDSDQService.selectTempByPSDEDataSet(pSDEDataSet, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEDSDQS");
            xmlNode.addNode(xmlNode2);
            for (PSDEDSDQ pSDEDSDQ : arrayList) {
                pSDEDSDQ.set("ORDERVALUE", null);
                pSDEDSDQService.exportXmlModel(pSDEDSDQ, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEDataSet pSDEDataSet, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEDSPARAMS");
        this.importRelatedXmlModel_PSDEDSParam(pSDEDataSet, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDEDSDQS");
        this.importRelatedXmlModel_PSDEDSDQ(pSDEDataSet, xmlNode3);
        super.onImportRelatedXmlModel(pSDEDataSet, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEDSParam(PSDEDataSet pSDEDataSet, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEDSParamService pSDEDSParamService = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEDataSet.getPSDEDataSetId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEDSParamService.removeByPSDEDS(pSDEDataSet);
        } else {
            pSDEDSParamService.removeTempByPSDEDS(pSDEDataSet);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEDSParam pSDEDSParam = new PSDEDSParam();
                pSDEDSParam.setOrderValue(n);
                n += 100;
                pSDEDSParamService.fillParentInfo((IEntity)pSDEDSParam, "DER1N", "DER1N_PSDEDSPARAM_PSDEDATASET_PSDEDSID", pSDEDataSet.getPSDEDataSetId());
                pSDEDSParamService.importXmlModel(pSDEDSParam, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEDSDQ(PSDEDataSet pSDEDataSet, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEDataSet.getPSDEDataSetId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEDSDQService.removeByPSDEDataSet(pSDEDataSet);
        } else {
            pSDEDSDQService.removeTempByPSDEDataSet(pSDEDataSet);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEDSDQ pSDEDSDQ = new PSDEDSDQ();
                pSDEDSDQ.setOrderValue(n);
                n += 100;
                pSDEDSDQService.fillParentInfo((IEntity)pSDEDSDQ, "DER1N", "DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID", pSDEDataSet.getPSDEDataSetId());
                pSDEDSDQService.importXmlModel(pSDEDSDQ, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDataSet pSDEDataSet, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDataSet, string);
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
            return "DER1N_PSDEDATASET_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEDataSet pSDEDataSet) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDataSet.getPSDEDataSetName())) {
            return pSDEDataSet.getPSDEDataSetName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEDataSet.getCodeName())) {
            return pSDEDataSet.getCodeName();
        }
        return super.getModelV2Tag(pSDEDataSet);
    }

    @Override
    public boolean setModelV2Tag(PSDEDataSet pSDEDataSet, String string) {
        pSDEDataSet.setPSDEDataSetName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEDATASETNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEDATASETNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDataSet pSDEDataSet, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDataSet.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDataSet, true);
        pSDEDataSet.set("PSDEDATASETNAME", string);
        if (this.select(pSDEDataSet, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDataSet, true);
        return super.getModelV2Entity(pSDEDataSet, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDataSet pSDEDataSet, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDataSet, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEDSPARAM_PSDEDATASET_PSDEDSID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEDSCODE_PSDEDATASET_PSDEDATASETID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEDSGRPPARAM_PSDEDATASET_PSDEDSID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEDataSet pSDEDataSet, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSDEDSCODE_PSDEDATASET_PSDEDATASETID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATASET#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEDSCODE", (Object)pSDEDataSet.getPSDEDataSetId()))).exists()) {
            PSDEDSCodeService pSDEDSCodeService = (PSDEDSCodeService)ServiceGlobal.getService(PSDEDSCodeService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSDEDSCodeService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSDEDSCode pSDEDSCode = new PSDEDSCode();
                PSModelV2Helper.fromJSONObject((IDataObject)pSDEDSCode, objectNode, false);
                String string6 = pSDEDSCodeService.getModelV2Tag(pSDEDSCode);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEDSCODE", (Object)pSDEDSCode.getPSDEDSCodeId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSDEDSCodeService.exportModelV2(pSDEDSCode, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSDEDataSet, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEDataSet pSDEDataSet, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSDEDSParam> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDSPARAM_PSDEDATASET_PSDEDSID")) {
            pSCoreSysServiceBase = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATASET#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDSPARAM", (Object)pSDEDataSet.getPSDEDataSetId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEDSParam)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEDSParam>();
                object4 = ((PSDEDSParamServiceBase)pSCoreSysServiceBase).selectByPSDEDS(pSDEDataSet);
                object3 = StringHelper.format((String)"PSDEDATASET#%1$s", (Object)pSDEDataSet.getPSDEDataSetId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEDSParam)object2.next();
                    object = ((PSDEDSParamServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEDSParam)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdedsparamname")) {
                            string = objectNode.get("psdedsparamname").asText();
                        }
                        if (objectNode2.has("psdedsparamname")) {
                            string2 = objectNode2.get("psdedsparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEDSParam();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDSCODE_PSDEDATASET_PSDEDATASETID")) {
            pSCoreSysServiceBase = (PSDEDSCodeService)ServiceGlobal.getService(PSDEDSCodeService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATASET#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDSCODE", (Object)pSDEDataSet.getPSDEDataSetId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEDSParam)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEDSCodeServiceBase)pSCoreSysServiceBase).selectByPSDEDataSet(pSDEDataSet);
                object3 = StringHelper.format((String)"PSDEDATASET#%1$s", (Object)pSDEDataSet.getPSDEDataSetId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEDSCode)object2.next();
                    object = ((PSDEDSCodeServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEDSParam)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdedscodename")) {
                            string = objectNode.get("psdedscodename").asText();
                        }
                        if (objectNode2.has("psdedscodename")) {
                            string2 = objectNode2.get("psdedscodename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEDSCode();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID")) {
            pSCoreSysServiceBase = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATASET#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDSDQ", (Object)pSDEDataSet.getPSDEDataSetId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEDSParam)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEDSDQServiceBase)pSCoreSysServiceBase).selectByPSDEDataSet(pSDEDataSet);
                object3 = StringHelper.format((String)"PSDEDATASET#%1$s", (Object)pSDEDataSet.getPSDEDataSetId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEDSDQ)object2.next();
                    object = ((PSDEDSDQServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEDSParam)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdedsdqname")) {
                            string = objectNode.get("psdedsdqname").asText();
                        }
                        if (objectNode2.has("psdedsdqname")) {
                            string2 = objectNode2.get("psdedsdqname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEDSDQ();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDSGRPPARAM_PSDEDATASET_PSDEDSID")) {
            pSCoreSysServiceBase = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATASET#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDSGRPPARAM", (Object)pSDEDataSet.getPSDEDataSetId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEDSParam)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEDSGrpParamServiceBase)pSCoreSysServiceBase).selectByPSDEDS(pSDEDataSet);
                object3 = StringHelper.format((String)"PSDEDATASET#%1$s", (Object)pSDEDataSet.getPSDEDataSetId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEDSGrpParam)object2.next();
                    object = ((PSDEDSGrpParamServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEDSParam)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdedsgrpparamname")) {
                            string = objectNode.get("psdedsgrpparamname").asText();
                        }
                        if (objectNode2.has("psdedsgrpparamname")) {
                            string2 = objectNode2.get("psdedsgrpparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEDSGrpParam();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEDataSet, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEDataSet pSDEDataSet) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSDEDSParamServiceBase)pSCoreSysServiceBase).selectByPSDEDS(pSDEDataSet);
        String string2 = StringHelper.format((String)"PSDEDATASET#%1$s", (Object)pSDEDataSet.getPSDEDataSetId());
        for (PSDEDSParam entityBase : arrayList) {
            string = ((PSDEDSParamServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSDEDataSet.getPSDEDataSetId());
        ((PSDEDSParamServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEDSParamServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDSPARAM WHERE PSDEDSID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEDSDQServiceBase)pSCoreSysServiceBase).selectByPSDEDataSet(pSDEDataSet);
        string2 = StringHelper.format((String)"PSDEDATASET#%1$s", (Object)pSDEDataSet.getPSDEDataSetId());
        for (PSDEDSDQ pSDEDSDQ : arrayList) {
            string = ((PSDEDSDQServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEDSDQ);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEDSDQ);
        }
        object = new SqlParamList();
        object.addString(pSDEDataSet.getPSDEDataSetId());
        ((PSDEDSDQServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEDSDQServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDSDQ WHERE PSDEDATASETID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEDSGrpParamServiceBase)pSCoreSysServiceBase).selectByPSDEDS(pSDEDataSet);
        string2 = StringHelper.format((String)"PSDEDATASET#%1$s", (Object)pSDEDataSet.getPSDEDataSetId());
        for (PSDEDSGrpParam pSDEDSGrpParam : arrayList) {
            string = ((PSDEDSGrpParamServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEDSGrpParam);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEDSGrpParam);
        }
        object = new SqlParamList();
        object.addString(pSDEDataSet.getPSDEDataSetId());
        ((PSDEDSGrpParamServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEDSGrpParamServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDSGRPPARAM WHERE PSDEDSID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSDEDataSet);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEDSCodeService)ServiceGlobal.getService(PSDEDSCodeService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEDataSet pSDEDataSet, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEDSParam();
        entityBase.set("PSDEDSID", pSDEDataSet.getPSDEDataSetId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEDSCode();
        entityBase.set("PSDEDATASETID", pSDEDataSet.getPSDEDataSetId());
        pSCoreSysServiceBase = (PSDEDSCodeService)ServiceGlobal.getService(PSDEDSCodeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEDSDQ();
        entityBase.set("PSDEDATASETID", pSDEDataSet.getPSDEDataSetId());
        pSCoreSysServiceBase = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEDSGrpParam();
        entityBase.set("PSDEDSID", pSDEDataSet.getPSDEDataSetId());
        pSCoreSysServiceBase = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEDataSet, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEDataSet pSDEDataSet, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSDEDSParam();
                ((PSDEDSParamBase)object).setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
                ((PSDEDSParamBase)object).setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
                ((PSDEDSParamBase)object).setPSDEId(pSDEDataSet.getPSDEId());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                for (Object object3 : object) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEDSParam();
                    entityBase.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
                    entityBase.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
                    entityBase.setPSDEId(pSDEDataSet.getPSDEId());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        if (!PSDEDataSetServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEDSCodeService)ServiceGlobal.getService(PSDEDSCodeService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSDEDSCode();
                    ((PSDEDSCodeBase)object).setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
                    ((PSDEDSCodeBase)object).setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEDSCode();
                        entityBase.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
                        entityBase.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        pSCoreSysServiceBase = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object2 = (ObjectNode)arrayNode.get(i);
                object = new PSDEDSDQ();
                ((PSDEDSDQBase)object).setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
                ((PSDEDSDQBase)object).setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
                ((PSDEDSDQBase)object).setPSDEId(pSDEDataSet.getPSDEId());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string6);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEDSDQ();
                    entityBase.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
                    entityBase.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
                    entityBase.setPSDEId(pSDEDataSet.getPSDEId());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEDSGrpParamService)ServiceGlobal.getService(PSDEDSGrpParamService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object2 = (ObjectNode)arrayNode.get(i);
                object = new PSDEDSGrpParam();
                ((PSDEDSGrpParamBase)object).setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
                ((PSDEDSGrpParamBase)object).setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
                ((PSDEDSGrpParamBase)object).setPSDEId(pSDEDataSet.getPSDEId());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string7);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEDSGrpParam();
                    entityBase.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
                    entityBase.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
                    entityBase.setPSDEId(pSDEDataSet.getPSDEId());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEDataSet, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEDataSet pSDEDataSet, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEDSPARAM_PSDEDATASET_PSDEDSID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEDSParams(pSDEDataSet, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEDSDQs(pSDEDataSet, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEDataSet, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEDSParams(PSDEDataSet pSDEDataSet, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEDSPARAM", true), (boolean)false) == 0) {
            PSDEDSParamService pSDEDSParamService = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
            PSDEDSParam pSDEDSParam = new PSDEDSParam();
            pSDEDSParam.setPSDEDSParamId(pSMOSFile.getPSModelId());
            if (!pSDEDSParamService.get((IEntity)pSDEDSParam, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEDSParam.getPSDEDSId(), (String)pSDEDataSet.getPSDEDataSetId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEDSParamService.exportModelV2(pSDEDSParam);
            pSDEDSParam.reset();
            if (!pSDEDSParamService.setModelV2ResScope((IEntity)pSDEDSParam, "PSDEDATASET", pSDEDataSet.getPSDEDataSetId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEDSParamService.importModelV2(pSDEDSParam, objectNode);
            SessionFactoryManager.commit();
            return pSDEDSParamService.getFile((IEntity)pSDEDSParam);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEDSDQs(PSDEDataSet pSDEDataSet, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEDSDQ", true), (boolean)false) == 0) {
            PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
            PSDEDSDQ pSDEDSDQ = new PSDEDSDQ();
            pSDEDSDQ.setPSDEDSDQId(pSMOSFile.getPSModelId());
            if (!pSDEDSDQService.get((IEntity)pSDEDSDQ, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEDSDQ.getPSDEDataSetId(), (String)pSDEDataSet.getPSDEDataSetId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEDSDQService.exportModelV2(pSDEDSDQ);
            pSDEDSDQ.reset();
            if (!pSDEDSDQService.setModelV2ResScope((IEntity)pSDEDSDQ, "PSDEDATASET", pSDEDataSet.getPSDEDataSetId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEDSDQService.importModelV2(pSDEDSDQ, objectNode);
            SessionFactoryManager.commit();
            return pSDEDSDQService.getFile((IEntity)pSDEDSDQ);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEDATAQUERY", true), (boolean)false) == 0) {
            PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
            pSDEDataQuery.setPSDEDataQueryId(pSMOSFile.getPSModelId());
            if (!pSDEDataQueryService.get((IEntity)pSDEDataQuery, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
            PSDEDSDQ pSDEDSDQ = new PSDEDSDQ();
            pSDEDSDQ.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
            pSDEDSDQ.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
            this.fillPasteEntity((IEntity)pSDEDSDQ, "PASTETAG");
            pSDEDSDQService.create(pSDEDSDQ);
            if (StringHelper.compare((String)pSDEDataQuery.getPSDEId(), (String)pSDEDSDQ.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[PSDEID]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEDSDQService.getFile((IEntity)pSDEDSDQ);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEDataSet pSDEDataSet, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEDSParams(pSDEDataSet, list);
        this.onFillPasteHelps_PSDEDSDQs(pSDEDataSet, list);
        super.onFillPasteHelps(pSDEDataSet, list);
    }

    protected void onFillPasteHelps_PSDEDSParams(PSDEDataSet pSDEDataSet, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEDSPARAM");
        pSHelpSection.setSectionParam2("DER1N_PSDEDSPARAM_PSDEDATASET_PSDEDSID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u6570\u636e\u96c6\u5408]\u7684[\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u53c2\u6570]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEDSDQs(PSDEDataSet pSDEDataSet, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEDSDQ");
        pSHelpSection.setSectionParam2("DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u6570\u636e\u96c6\u5408]\u7684[\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u67e5\u8be2]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEDSDQ");
        pSHelpSection.setSectionParam2("DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID");
        pSHelpSection.setUserTag("DER1N_PSDEDSDQ_PSDEDATAQUERY_PSDEDQID");
        pSHelpSection.setContent("\u7c98\u8d34[\u5b9e\u4f53\u6570\u636e\u67e5\u8be2]\u6784\u5efa[\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u67e5\u8be2]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u67e5\u8be2\u9879>", "DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID", "PSDEDATASETID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSDEDataSetServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u67e5\u8be2\u9879>");
            } else if (PSDEDataSetServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdedsdqs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID|PSDEDATASETID");
            pSMOSFile2.setFileTag3("PSDEDSDQ");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID", "PSDEDATASETID", pSMOSFile.getPSModelId(), "", "")) {
                PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEDSDQService, "DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID", "PSDEDATASETID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSDEDSDQService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEDataSetServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSDEDataSetServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u67e5\u8be2\u9879>", (boolean)false) == 0 || PSDEDataSetServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEDSDQs", (boolean)true) == 0) {
            PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEDSDQService, "DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID", "PSDEDATASETID", pSMOSFile.getPSModelId(), "", "");
            ArrayList arrayList2 = pSDEDSDQService.selectEx((ISelectContext)selectContext);
            for (PSDEDSDQ pSDEDSDQ : arrayList2) {
                PSMOSFile pSMOSFile2 = pSDEDSDQService.getFile(pSMOSFile, (IEntity)pSDEDSDQ, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDSDQ_PSDEDATASET_PSDEDATASETID", (boolean)false) == 0) {
            if (PSDEDataSetServiceBase.getMOSVer() == 1) {
                return "<\u67e5\u8be2\u9879>";
            }
            if (PSDEDataSetServiceBase.getMOSVer() == 2) {
                return "psdedsdqs";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEDataSet pSDEDataSet, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DataSet");
        defaultValueMap.put("LOGICNAME", "\u6570\u636e\u96c6");
        defaultValueMap.put("PSDEDATASETNAME", "DATASET");
    }
}

