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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEChartDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEChartDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartAxes;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartAxesBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartParamBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysChartTheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysChartThemeBase;
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
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEChartServiceBase
extends PSCoreSysServiceBase<PSDEChart> {
    private static final Log log = LogFactory.getLog(PSDEChartServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_JITPREVIEW = "JITPREVIEW";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEChartDEModel pSDEChartDEModel;
    private PSDEChartDAO pSDEChartDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEChartService";
    }

    public PSDEChartDEModel getPSDEChartDEModel() {
        if (this.pSDEChartDEModel == null) {
            try {
                this.pSDEChartDEModel = (PSDEChartDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEChartDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEChartDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEChartDEModel();
    }

    public PSDEChartDAO getPSDEChartDAO() {
        if (this.pSDEChartDAO == null) {
            try {
                this.pSDEChartDAO = (PSDEChartDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEChartDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEChartDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEChartDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchTempCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSDEChart)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSDEChart)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSDEChart)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDEChart)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_JITPREVIEW, (boolean)true) == 0) {
            this.jITPreview((PSDEChart)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDEChart)iEntity);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void createWithModel(PSDEChart pSDEChart) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, pSDEChart, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEChart, ACTION_CREATEWITHMODEL);
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEChartServiceBase.this.getService(), PSDEChartServiceBase.ACTION_CREATEWITHMODEL, 40, pSDEChart2, null).getResult() != 1) {
                    PSDEChartServiceBase.this.onCreateWithModel(pSDEChart2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, pSDEChart, null);
        }
    }

    protected void onCreateWithModel(PSDEChart pSDEChart) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSDEChart pSDEChart) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, pSDEChart, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEChart, ACTION_GETDRAFTFROMWITHMODEL);
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEChartServiceBase.this.getService(), PSDEChartServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, pSDEChart2, null).getResult() != 1) {
                    PSDEChartServiceBase.this.onGetDraftFromWithModel(pSDEChart2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, pSDEChart, null);
        }
    }

    protected void onGetDraftFromWithModel(PSDEChart pSDEChart) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSDEChart pSDEChart) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, pSDEChart, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEChart, ACTION_GETDRAFTWITHMODEL);
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEChartServiceBase.this.getService(), PSDEChartServiceBase.ACTION_GETDRAFTWITHMODEL, 40, pSDEChart2, null).getResult() != 1) {
                    PSDEChartServiceBase.this.onGetDraftWithModel(pSDEChart2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, pSDEChart, null);
        }
    }

    protected void onGetDraftWithModel(PSDEChart pSDEChart) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSDEChart pSDEChart) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, pSDEChart, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEChart, ACTION_GETWITHMODEL);
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEChartServiceBase.this.getService(), PSDEChartServiceBase.ACTION_GETWITHMODEL, 40, pSDEChart2, null).getResult() != 1) {
                    PSDEChartServiceBase.this.onGetWithModel(pSDEChart2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, pSDEChart, null);
        }
    }

    protected void onGetWithModel(PSDEChart pSDEChart) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void jITPreview(PSDEChart pSDEChart) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 0, pSDEChart, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEChart, ACTION_JITPREVIEW);
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEChartServiceBase.this.getService(), PSDEChartServiceBase.ACTION_JITPREVIEW, 40, pSDEChart2, null).getResult() != 1) {
                    PSDEChartServiceBase.this.onJITPreview(pSDEChart2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 99, pSDEChart, null);
        }
    }

    protected void onJITPreview(PSDEChart pSDEChart) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[JITPREVIEW]");
    }

    public void updateWithModel(PSDEChart pSDEChart) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, pSDEChart, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEChart, ACTION_UPDATEWITHMODEL);
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEChartServiceBase.this.getService(), PSDEChartServiceBase.ACTION_UPDATEWITHMODEL, 40, pSDEChart2, null).getResult() != 1) {
                    PSDEChartServiceBase.this.onUpdateWithModel(pSDEChart2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, pSDEChart, null);
        }
    }

    protected void onUpdateWithModel(PSDEChart pSDEChart) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDEChart pSDEChart, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSACHandler);
            } else {
                iService.get(pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSDEChart, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlLogicGroup);
            } else {
                iService.get(pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEChart, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlMsg);
            } else {
                iService.get(pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSDEChart, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEChart, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSDEChart, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSDEFIELD_MINORSORTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_MinorSortPSDEF(pSDEChart, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSDELOGIC_ADPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_ADPSDELogic(pSDEChart, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSLANGUAGERES_EMPTYTEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_EmptyTextPSLanRes(pSDEChart, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSLANGUAGERES_LNPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_LNPSLanRes(pSDEChart, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSLANGUAGERES_SUBTITLEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_SubTitlePSLanRes(pSDEChart, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSSYSCHARTTHEME_PSSYSCHARTTHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysChartThemeService", (SessionFactory)this.getSessionFactory());
            PSSysChartTheme pSSysChartTheme = (PSSysChartTheme)iService.getDEModel().createEntity();
            pSSysChartTheme.set("PSSYSCHARTTHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysChartTheme);
            } else {
                iService.get(pSSysChartTheme);
            }
            this.onFillParentInfo_PSSysChartTheme(pSDEChart, pSSysChartTheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEChart, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEChart, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEChart, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEChart, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHART_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsgGroup);
            } else {
                iService.get(pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSDEChart, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo(pSDEChart, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSDEChart pSDEChart, PSACHandler pSACHandler) throws Exception {
        pSDEChart.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEChart.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSDEChart pSDEChart, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSDEChart.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSDEChart.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSCtrlMsg(PSDEChart pSDEChart, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSDEChart.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSDEChart.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_PSDE(PSDEChart pSDEChart, PSDataEntity pSDataEntity) throws Exception {
        pSDEChart.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEChart.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDS(PSDEChart pSDEChart, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEChart.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDEChart.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_MinorSortPSDEF(PSDEChart pSDEChart, PSDEField pSDEField) throws Exception {
        pSDEChart.setMinorSortPSDEFId(pSDEField.getPSDEFieldId());
        pSDEChart.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ADPSDELogic(PSDEChart pSDEChart, PSDELogic pSDELogic) throws Exception {
        pSDEChart.setADPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEChart.setADPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_EmptyTextPSLanRes(PSDEChart pSDEChart, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEChart.setEmptyTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEChart.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_LNPSLanRes(PSDEChart pSDEChart, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEChart.setLNPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEChart.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_SubTitlePSLanRes(PSDEChart pSDEChart, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEChart.setSubTitlePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEChart.setSubTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysChartTheme(PSDEChart pSDEChart, PSSysChartTheme pSSysChartTheme) throws Exception {
        pSDEChart.setPSSysChartThemeId(pSSysChartTheme.getPSSysChartThemeId());
        pSDEChart.setPSSysChartThemeName(pSSysChartTheme.getPSSysChartThemeName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEChart pSDEChart, PSSysCss pSSysCss) throws Exception {
        pSDEChart.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEChart.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEChart pSDEChart, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEChart.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEChart.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEChart pSDEChart, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEChart.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEChart.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEChart pSDEChart, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEChart.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEChart.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSDEChart pSDEChart, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSDEChart.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSDEChart.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSDEChart pSDEChart, boolean bl) throws Exception {
        if (bl && pSDEChart.getPSDEChartName() == null) {
            pSDEChart.setPSDEChartName((String)this.getDefaultValue(this.getWebContext(), "USER", "Chart", 25));
        }
        super.onFillEntityFullInfo(pSDEChart, bl);
        this.onFillEntityFullInfo_PSACHandler(pSDEChart, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSDEChart, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSDEChart, bl);
        this.onFillEntityFullInfo_PSDE(pSDEChart, bl);
        this.onFillEntityFullInfo_PSDEDS(pSDEChart, bl);
        this.onFillEntityFullInfo_MinorSortPSDEF(pSDEChart, bl);
        this.onFillEntityFullInfo_ADPSDELogic(pSDEChart, bl);
        this.onFillEntityFullInfo_EmptyTextPSLanRes(pSDEChart, bl);
        this.onFillEntityFullInfo_LNPSLanRes(pSDEChart, bl);
        this.onFillEntityFullInfo_SubTitlePSLanRes(pSDEChart, bl);
        this.onFillEntityFullInfo_PSSysChartTheme(pSDEChart, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEChart, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEChart, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEChart, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEChart, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSDEChart, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSDEChart pSDEChart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSDEChart pSDEChart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSDEChart pSDEChart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDEChart pSDEChart, boolean bl) throws Exception {
        if (pSDEChart.isPSDEIdDirty()) {
            if (pSDEChart.getPSDEId() != null) {
                if (pSDEChart.getPSDEId() == null || pSDEChart.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEChart.getPSDE();
                    pSDEChart.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEChart.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDS(PSDEChart pSDEChart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MinorSortPSDEF(PSDEChart pSDEChart, boolean bl) throws Exception {
        if (pSDEChart.isMinorSortPSDEFIdDirty()) {
            if (pSDEChart.getMinorSortPSDEFId() != null) {
                if (pSDEChart.getMinorSortPSDEFId() == null || pSDEChart.getMinorSortPSDEFName() == null) {
                    PSDEField pSDEField = pSDEChart.getMinorSortPSDEF();
                    pSDEChart.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEChart.setMinorSortPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ADPSDELogic(PSDEChart pSDEChart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmptyTextPSLanRes(PSDEChart pSDEChart, boolean bl) throws Exception {
        if (pSDEChart.isEmptyTextPSLanResIdDirty()) {
            if (pSDEChart.getEmptyTextPSLanResId() != null) {
                if (pSDEChart.getEmptyTextPSLanResId() == null || pSDEChart.getEmptyTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEChart.getEmptyTextPSLanRes();
                    pSDEChart.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEChart.setEmptyTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LNPSLanRes(PSDEChart pSDEChart, boolean bl) throws Exception {
        if (pSDEChart.isLNPSLanResIdDirty()) {
            if (pSDEChart.getLNPSLanResId() != null) {
                if (pSDEChart.getLNPSLanResId() == null || pSDEChart.getLNPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEChart.getLNPSLanRes();
                    pSDEChart.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEChart.setLNPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SubTitlePSLanRes(PSDEChart pSDEChart, boolean bl) throws Exception {
        if (pSDEChart.isSubTitlePSLanResIdDirty()) {
            if (pSDEChart.getSubTitlePSLanResId() != null) {
                if (pSDEChart.getSubTitlePSLanResId() == null || pSDEChart.getSubTitlePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEChart.getSubTitlePSLanRes();
                    pSDEChart.setSubTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEChart.setSubTitlePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysChartTheme(PSDEChart pSDEChart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEChart pSDEChart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEChart pSDEChart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEChart pSDEChart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEChart pSDEChart, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSDEChart pSDEChart, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEChart pSDEChart, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEChart, bl);
    }

    public ArrayList<PSDEChart> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChart> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChart> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChart> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChart> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChart> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORSORTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorSortPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorSortPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChart> selectByADPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChart> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMPTYTEXTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmptyTextPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmptyTextPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChart> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LNPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLNPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLNPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChart> selectBySubTitlePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectBySubTitlePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEChart> selectBySubTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectBySubTitlePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEChart> selectBySubTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SUBTITLEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySubTitlePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySubTitlePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChart> selectByPSSysChartTheme(PSSysChartThemeBase pSSysChartThemeBase) throws Exception {
        return this.selectByPSSysChartTheme(pSSysChartThemeBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByPSSysChartTheme(PSSysChartThemeBase pSSysChartThemeBase, String string) throws Exception {
        return this.selectByPSSysChartTheme(pSSysChartThemeBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByPSSysChartTheme(PSSysChartThemeBase pSSysChartThemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCHARTTHEMEID", (Object)pSSysChartThemeBase.getPSSysChartThemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysChartThemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysChartThemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChart> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChart> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChart> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChart> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChart> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSDEChart> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSDEChart> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
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

    public void testRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setPSACHandlerId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSDEChartServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSDEChartServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setPSCtrlLogicGroupId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEChartServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEChartServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSCTRLMSG_PSCTRLMSGID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSCtrlMsg), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setPSCtrlMsgId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEChartServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEChartServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setPSDEId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEChartServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEChartServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setPSDEDSId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSDEChartServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSDEChartServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByMinorSortPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSDEFIELD_MINORSORTPSDEFID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setMinorSortPSDEFId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByMinorSortPSDEF(pSDEField2);
                PSDEChartServiceBase.this.internalRemoveByMinorSortPSDEF(pSDEField2);
                PSDEChartServiceBase.this.onAfterRemoveByMinorSortPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        this.onBeforeRemoveByMinorSortPSDEF(pSDEField, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByMinorSortPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByADPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSDELOGIC_ADPSDELOGICID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByADPSDELogic(pSDELogic);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setADPSDELogicId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByADPSDELogic(pSDELogic2);
                PSDEChartServiceBase.this.internalRemoveByADPSDELogic(pSDELogic2);
                PSDEChartServiceBase.this.onAfterRemoveByADPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByADPSDELogic(pSDELogic);
        this.onBeforeRemoveByADPSDELogic(pSDELogic, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByADPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSLANGUAGERES_EMPTYTEXTPSLANRESID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setEmptyTextPSLanResId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDEChartServiceBase.this.internalRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDEChartServiceBase.this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByLNPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSLANGUAGERES_LNPSLANRESID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setLNPSLanResId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByLNPSLanRes(pSLanguageRes2);
                PSDEChartServiceBase.this.internalRemoveByLNPSLanRes(pSLanguageRes2);
                PSDEChartServiceBase.this.onAfterRemoveByLNPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByLNPSLanRes(pSLanguageRes, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByLNPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectBySubTitlePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSLANGUAGERES_SUBTITLEPSLANRESID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetSubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectBySubTitlePSLanRes(pSLanguageRes);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setSubTitlePSLanResId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeBySubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveBySubTitlePSLanRes(pSLanguageRes2);
                PSDEChartServiceBase.this.internalRemoveBySubTitlePSLanRes(pSLanguageRes2);
                PSDEChartServiceBase.this.onAfterRemoveBySubTitlePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectBySubTitlePSLanRes(pSLanguageRes);
        this.onBeforeRemoveBySubTitlePSLanRes(pSLanguageRes, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveBySubTitlePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysChartTheme(PSSysChartTheme pSSysChartTheme) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysChartTheme(pSSysChartTheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCHARTTHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysChartTheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSSYSCHARTTHEME_PSSYSCHARTTHEMEID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSSysChartTheme), arrayList.get(0)));
        }
    }

    public void resetPSSysChartTheme(PSSysChartTheme pSSysChartTheme) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysChartTheme(pSSysChartTheme);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setPSSysChartThemeId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByPSSysChartTheme(PSSysChartTheme pSSysChartTheme) throws Exception {
        final PSSysChartTheme pSSysChartTheme2 = pSSysChartTheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByPSSysChartTheme(pSSysChartTheme2);
                PSDEChartServiceBase.this.internalRemoveByPSSysChartTheme(pSSysChartTheme2);
                PSDEChartServiceBase.this.onAfterRemoveByPSSysChartTheme(pSSysChartTheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysChartTheme(PSSysChartTheme pSSysChartTheme) throws Exception {
    }

    protected void internalRemoveByPSSysChartTheme(PSSysChartTheme pSSysChartTheme) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysChartTheme(pSSysChartTheme);
        this.onBeforeRemoveByPSSysChartTheme(pSSysChartTheme, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByPSSysChartTheme(pSSysChartTheme, arrayList);
    }

    protected void onAfterRemoveByPSSysChartTheme(PSSysChartTheme pSSysChartTheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysChartTheme(PSSysChartTheme pSSysChartTheme, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysChartTheme(PSSysChartTheme pSSysChartTheme, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setPSSysCssId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEChartServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEChartServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setPSSysDynaModelId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEChartServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEChartServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setPSSysPFPluginId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEChartServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEChartServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setPSSysReqItemId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEChartServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEChartServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHART_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSDECHART", iDataEntityModel.getDataInfo(pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSDEChart pSDEChart : arrayList) {
            PSDEChart pSDEChart2 = (PSDEChart)this.getDEModel().createEntity();
            pSDEChart2.setPSDEChartId(pSDEChart.getPSDEChartId());
            pSDEChart2.setPSViewMsgGroupId(null);
            this.update(pSDEChart2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEChartServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEChartServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEChart> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSDEChart pSDEChart : arrayList) {
            this.remove(pSDEChart);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEChart> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEChart pSDEChart) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartAxesServiceBase)pSCoreSysServiceBase).testRemoveByPSDEChart(pSDEChart);
        ((PSDEChartAxesServiceBase)pSCoreSysServiceBase).removeByPSDEChart(pSDEChart);
        pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEChart(pSDEChart);
        ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).removeByPSDEChart(pSDEChart);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDEChart(pSDEChart);
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).removeByPSDEChart(pSDEChart);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEChart(pSDEChart);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSDEChart(pSDEChart);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEChart(pSDEChart);
        super.onBeforeRemove(pSDEChart);
    }

    protected void onBeforeRemoveTemp(PSDEChart pSDEChart) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDEChart(pSDEChart);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).removeTempByPSDEChart(pSDEChart);
        pSCoreSysServiceBase = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartAxesServiceBase)pSCoreSysServiceBase).removeTempByPSDEChart(pSDEChart);
        super.onBeforeRemoveTemp(pSDEChart);
    }

    protected void getRelatedDataTempMajor(PSDEChart pSDEChart) throws Exception {
        this.getRelatedDataTempMajor_PSDEChartAxes(pSDEChart);
        this.getRelatedDataTempMajor_PSDEChartParam(pSDEChart);
        this.getRelatedDataTempMajor_PSDEChartLogic(pSDEChart);
        super.getRelatedDataTempMajor(pSDEChart);
    }

    protected void getRelatedDataTempMajor_PSDEChartAxes(PSDEChart pSDEChart) throws Exception {
        PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartAxes> arrayList = null;
        String string = pSDEChart.getPSDEChartId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEChartAxesService.selectByPSDEChart(pSDEChart) : pSDEChartAxesService.selectTempByPSDEChart(pSDEChart);
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            pSDEChartAxesService.getTempMajor(pSDEChartAxes);
        }
    }

    protected void getRelatedDataTempMajor_PSDEChartParam(PSDEChart pSDEChart) throws Exception {
        PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartParam> arrayList = null;
        String string = pSDEChart.getPSDEChartId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEChartParamService.selectByPSDEChart(pSDEChart) : pSDEChartParamService.selectTempByPSDEChart(pSDEChart);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            pSDEChartParamService.getTempMajor(pSDEChartParam);
        }
    }

    protected void getRelatedDataTempMajor_PSDEChartLogic(PSDEChart pSDEChart) throws Exception {
        PSDEChartLogicService pSDEChartLogicService = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartLogic> arrayList = null;
        String string = pSDEChart.getPSDEChartId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEChartLogicService.selectByPSDEChart(pSDEChart) : pSDEChartLogicService.selectTempByPSDEChart(pSDEChart);
        for (PSDEChartLogic pSDEChartLogic : arrayList) {
            pSDEChartLogicService.getTempMajor(pSDEChartLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEChart pSDEChart, PSDEChart pSDEChart2) throws Exception {
        ArrayList<PSDEChartLogic> arrayList = this.updateRelatedDataTempMajor_removePSDEChartLogic(pSDEChart, pSDEChart2);
        ArrayList<PSDEChartParam> arrayList2 = this.updateRelatedDataTempMajor_removePSDEChartParam(pSDEChart, pSDEChart2);
        ArrayList<PSDEChartAxes> arrayList3 = this.updateRelatedDataTempMajor_removePSDEChartAxes(pSDEChart, pSDEChart2);
        this.updateRelatedDataTempMajor_updatePSDEChartAxes(pSDEChart, pSDEChart2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSDEChartParam(pSDEChart, pSDEChart2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEChartLogic(pSDEChart, pSDEChart2, arrayList);
        super.updateRelatedDataTempMajor(pSDEChart, pSDEChart2);
    }

    protected ArrayList<PSDEChartAxes> updateRelatedDataTempMajor_removePSDEChartAxes(PSDEChart pSDEChart, PSDEChart pSDEChart2) throws Exception {
        PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartAxes> arrayList = pSDEChartAxesService.selectTempByPSDEChart(pSDEChart);
        ArrayList<PSDEChartAxes> arrayList2 = pSDEChartAxesService.selectByPSDEChart(pSDEChart2);
        HashMap<String, PSDEChartAxes> hashMap = new HashMap<String, PSDEChartAxes>();
        for (PSDEChartAxes pSDEChartAxes : arrayList2) {
            hashMap.put(pSDEChartAxes.getPSDEChartAxesId(), pSDEChartAxes);
        }
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            Object object = pSDEChartAxes.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEChartAxes pSDEChartAxes : hashMap.values()) {
            pSDEChartAxesService.remove(pSDEChartAxes);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEChartAxes(PSDEChart pSDEChart, PSDEChart pSDEChart2, ArrayList<PSDEChartAxes> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            pSDEChartAxesService.updateTempMajor(pSDEChartAxes);
        }
    }

    protected ArrayList<PSDEChartParam> updateRelatedDataTempMajor_removePSDEChartParam(PSDEChart pSDEChart, PSDEChart pSDEChart2) throws Exception {
        PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartParam> arrayList = pSDEChartParamService.selectTempByPSDEChart(pSDEChart);
        ArrayList<PSDEChartParam> arrayList2 = pSDEChartParamService.selectByPSDEChart(pSDEChart2);
        HashMap<String, PSDEChartParam> hashMap = new HashMap<String, PSDEChartParam>();
        for (PSDEChartParam pSDEChartParam : arrayList2) {
            hashMap.put(pSDEChartParam.getPSDEChartParamId(), pSDEChartParam);
        }
        for (PSDEChartParam pSDEChartParam : arrayList) {
            Object object = pSDEChartParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEChartParam pSDEChartParam : hashMap.values()) {
            pSDEChartParamService.remove(pSDEChartParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEChartParam(PSDEChart pSDEChart, PSDEChart pSDEChart2, ArrayList<PSDEChartParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEChartParam pSDEChartParam : arrayList) {
            pSDEChartParamService.updateTempMajor(pSDEChartParam);
        }
    }

    protected ArrayList<PSDEChartLogic> updateRelatedDataTempMajor_removePSDEChartLogic(PSDEChart pSDEChart, PSDEChart pSDEChart2) throws Exception {
        PSDEChartLogicService pSDEChartLogicService = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartLogic> arrayList = pSDEChartLogicService.selectTempByPSDEChart(pSDEChart);
        ArrayList<PSDEChartLogic> arrayList2 = pSDEChartLogicService.selectByPSDEChart(pSDEChart2);
        HashMap<String, PSDEChartLogic> hashMap = new HashMap<String, PSDEChartLogic>();
        for (PSDEChartLogic pSDEChartLogic : arrayList2) {
            hashMap.put(pSDEChartLogic.getPSDEChartLogicId(), pSDEChartLogic);
        }
        for (PSDEChartLogic pSDEChartLogic : arrayList) {
            Object object = pSDEChartLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEChartLogic pSDEChartLogic : hashMap.values()) {
            pSDEChartLogicService.remove(pSDEChartLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEChartLogic(PSDEChart pSDEChart, PSDEChart pSDEChart2, ArrayList<PSDEChartLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEChartLogicService pSDEChartLogicService = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEChartLogic pSDEChartLogic : arrayList) {
            pSDEChartLogicService.updateTempMajor(pSDEChartLogic);
        }
    }

    protected void replaceParentInfo(PSDEChart pSDEChart, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEChart, cloneSession);
        if (pSDEChart.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEChart.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSDEChart, (PSACHandler)iEntity);
        }
        if (pSDEChart.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSDEChart.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEChart, (PSCtrlLogicGroup)iEntity);
        }
        if (pSDEChart.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSDEChart.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSDEChart, (PSCtrlMsg)iEntity);
        }
        if (pSDEChart.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEChart.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEChart, (PSDataEntity)iEntity);
        }
        if (pSDEChart.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEChart.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSDEChart, (PSDEDataSet)iEntity);
        }
        if (pSDEChart.getMinorSortPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEChart.getMinorSortPSDEFId())) != null) {
            this.onFillParentInfo_MinorSortPSDEF(pSDEChart, (PSDEField)iEntity);
        }
        if (pSDEChart.getADPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEChart.getADPSDELogicId())) != null) {
            this.onFillParentInfo_ADPSDELogic(pSDEChart, (PSDELogic)iEntity);
        }
        if (pSDEChart.getEmptyTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEChart.getEmptyTextPSLanResId())) != null) {
            this.onFillParentInfo_EmptyTextPSLanRes(pSDEChart, (PSLanguageRes)iEntity);
        }
        if (pSDEChart.getLNPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEChart.getLNPSLanResId())) != null) {
            this.onFillParentInfo_LNPSLanRes(pSDEChart, (PSLanguageRes)iEntity);
        }
        if (pSDEChart.getSubTitlePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEChart.getSubTitlePSLanResId())) != null) {
            this.onFillParentInfo_SubTitlePSLanRes(pSDEChart, (PSLanguageRes)iEntity);
        }
        if (pSDEChart.getPSSysChartThemeId() != null && (iEntity = cloneSession.getEntity("PSSYSCHARTTHEME", (Object)pSDEChart.getPSSysChartThemeId())) != null) {
            this.onFillParentInfo_PSSysChartTheme(pSDEChart, (PSSysChartTheme)iEntity);
        }
        if (pSDEChart.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEChart.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEChart, (PSSysCss)iEntity);
        }
        if (pSDEChart.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEChart.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEChart, (PSSysDynaModel)iEntity);
        }
        if (pSDEChart.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEChart.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEChart, (PSSysPFPlugin)iEntity);
        }
        if (pSDEChart.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEChart.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEChart, (PSSysReqItem)iEntity);
        }
        if (pSDEChart.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSDEChart.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSDEChart, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEChart pSDEChart, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEChart, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ADPSDELogicId(bl, pSDEChart, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BusyIndicator(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ChartModel(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ChartTheme(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CoordinateSystem(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataGridPos(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyText(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResName(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LegendPos(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResName(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortDir(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFName(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewHeight(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxHeight(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxWidth(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinHeight(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinWidth(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewPos(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewShowMode(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewWidth(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEChartId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEChartName(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysChartThemeId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowDataGrid(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowLegend(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowTitle(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubTitle(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubTitlePSLanResId(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubTitlePSLanResName(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePos(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEChart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEChart, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ADPSDELogicId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isADPSDELogicIdDirty() : !pSDEChart.isADPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEChart.getADPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ADPSDELogicId_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isBusyIndicatorDirty() : !pSDEChart.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDEChart.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_ChartModel(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isChartModelDirty() : !pSDEChart.isChartModelDirty()) {
            return null;
        }
        String string = pSDEChart.getChartModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChartModel_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHARTMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ChartTheme(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isChartThemeDirty() : !pSDEChart.isChartThemeDirty()) {
            return null;
        }
        String string = pSDEChart.getChartTheme();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChartTheme_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHARTTHEME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isCodeNameDirty() && !bl2 : !pSDEChart.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEChart.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEChart, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEChartDEModel(), "CODENAME", string3, pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_CoordinateSystem(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isCoordinateSystemDirty() : !pSDEChart.isCoordinateSystemDirty()) {
            return null;
        }
        String string = pSDEChart.getCoordinateSystem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CoordinateSystem_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COORDINATESYSTEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isCustomCondDirty() : !pSDEChart.isCustomCondDirty()) {
            return null;
        }
        String string = pSDEChart.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isCustomTypeDirty() : !pSDEChart.isCustomTypeDirty()) {
            return null;
        }
        String string = pSDEChart.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataGridPos(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isDataGridPosDirty() : !pSDEChart.isDataGridPosDirty()) {
            return null;
        }
        String string = pSDEChart.getDataGridPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataGridPos_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAGRIDPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyText(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isEmptyTextDirty() : !pSDEChart.isEmptyTextDirty()) {
            return null;
        }
        String string = pSDEChart.getEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyText_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyTextPSLanResId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isEmptyTextPSLanResIdDirty() : !pSDEChart.isEmptyTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEChart.getEmptyTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResId_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyTextPSLanResName(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isEmptyTextPSLanResNameDirty() : !pSDEChart.isEmptyTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEChart.getEmptyTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResName_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LegendPos(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isLegendPosDirty() : !pSDEChart.isLegendPosDirty()) {
            return null;
        }
        String string = pSDEChart.getLegendPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LegendPos_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEGENDPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isLNPSLanResIdDirty() : !pSDEChart.isLNPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEChart.getLNPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResId_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResName(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isLNPSLanResNameDirty() : !pSDEChart.isLNPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEChart.getLNPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResName_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isLockFlagDirty() : !pSDEChart.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEChart.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isLogicNameDirty() : !pSDEChart.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEChart.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isMemoDirty() : !pSDEChart.isMemoDirty()) {
            return null;
        }
        String string = pSDEChart.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortDir(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isMinorSortDirDirty() : !pSDEChart.isMinorSortDirDirty()) {
            return null;
        }
        String string = pSDEChart.getMinorSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortDir_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortPSDEFId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isMinorSortPSDEFIdDirty() : !pSDEChart.isMinorSortPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEChart.getMinorSortPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFId_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorSortPSDEFName(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isMinorSortPSDEFNameDirty() : !pSDEChart.isMinorSortPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEChart.getMinorSortPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFName_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewHeight(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isNavViewHeightDirty() : !pSDEChart.isNavViewHeightDirty()) {
            return null;
        }
        Double d = pSDEChart.getNavViewHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewHeight_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMaxHeight(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isNavViewMaxHeightDirty() : !pSDEChart.isNavViewMaxHeightDirty()) {
            return null;
        }
        Double d = pSDEChart.getNavViewMaxHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxHeight_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMAXHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMaxWidth(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isNavViewMaxWidthDirty() : !pSDEChart.isNavViewMaxWidthDirty()) {
            return null;
        }
        Double d = pSDEChart.getNavViewMaxWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxWidth_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMAXWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMinHeight(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isNavViewMinHeightDirty() : !pSDEChart.isNavViewMinHeightDirty()) {
            return null;
        }
        Double d = pSDEChart.getNavViewMinHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinHeight_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMINHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMinWidth(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isNavViewMinWidthDirty() : !pSDEChart.isNavViewMinWidthDirty()) {
            return null;
        }
        Double d = pSDEChart.getNavViewMinWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinWidth_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMINWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewPos(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isNavViewPosDirty() : !pSDEChart.isNavViewPosDirty()) {
            return null;
        }
        String string = pSDEChart.getNavViewPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewPos_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewShowMode(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isNavViewShowModeDirty() : !pSDEChart.isNavViewShowModeDirty()) {
            return null;
        }
        Integer n = pSDEChart.getNavViewShowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewShowMode_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWSHOWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewWidth(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isNavViewWidthDirty() : !pSDEChart.isNavViewWidthDirty()) {
            return null;
        }
        Double d = pSDEChart.getNavViewWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewWidth_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSACHandlerIdDirty() : !pSDEChart.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSCtrlLogicGroupIdDirty() : !pSDEChart.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSCtrlMsgIdDirty() : !pSDEChart.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEChartId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSDEChartIdDirty() && !bl2 : !pSDEChart.isPSDEChartIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSDEChartId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEChartId_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEChartName(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSDEChartNameDirty() && !bl2 : !pSDEChart.isPSDEChartNameDirty()) {
            return null;
        }
        String string = pSDEChart.getPSDEChartName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEChartName_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEChartDEModel(), "PSDECHARTNAME", string3, pSDEChart, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDECHARTNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSDEDSIdDirty() : !pSDEChart.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSDEIdDirty() && !bl2 : !pSDEChart.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSDENameDirty() && !bl2 : !pSDEChart.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEChart.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysChartThemeId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSSysChartThemeIdDirty() : !pSDEChart.isPSSysChartThemeIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSSysChartThemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysChartThemeId_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCHARTTHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSSysCssIdDirty() : !pSDEChart.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSSysDynaModelIdDirty() : !pSDEChart.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSSysPFPluginIdDirty() : !pSDEChart.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSSysReqItemIdDirty() : !pSDEChart.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isPSViewMsgGroupIdDirty() : !pSDEChart.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSDEChart.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_ShowDataGrid(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isShowDataGridDirty() : !pSDEChart.isShowDataGridDirty()) {
            return null;
        }
        Integer n = pSDEChart.getShowDataGrid();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowDataGrid_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWDATAGRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowLegend(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isShowLegendDirty() : !pSDEChart.isShowLegendDirty()) {
            return null;
        }
        Integer n = pSDEChart.getShowLegend();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowLegend_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWLEGEND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowTitle(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isShowTitleDirty() : !pSDEChart.isShowTitleDirty()) {
            return null;
        }
        Integer n = pSDEChart.getShowTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowTitle_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWTITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFSysPub(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isSRFSysPubDirty() : !pSDEChart.isSRFSysPubDirty()) {
            return null;
        }
        Integer n = pSDEChart.getSRFSysPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SRFSysPub_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_SubTitle(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isSubTitleDirty() : !pSDEChart.isSubTitleDirty()) {
            return null;
        }
        String string = pSDEChart.getSubTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubTitle_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBTITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubTitlePSLanResId(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isSubTitlePSLanResIdDirty() : !pSDEChart.isSubTitlePSLanResIdDirty()) {
            return null;
        }
        String string = pSDEChart.getSubTitlePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubTitlePSLanResId_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBTITLEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubTitlePSLanResName(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isSubTitlePSLanResNameDirty() : !pSDEChart.isSubTitlePSLanResNameDirty()) {
            return null;
        }
        String string = pSDEChart.getSubTitlePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubTitlePSLanResName_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBTITLEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePos(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isTitlePosDirty() : !pSDEChart.isTitlePosDirty()) {
            return null;
        }
        String string = pSDEChart.getTitlePos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePos_Default(pSDEChart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isToDoTaskDirty() : !pSDEChart.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEChart.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isUserParamsDirty() : !pSDEChart.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEChart.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isUserTagDirty() : !pSDEChart.isUserTagDirty()) {
            return null;
        }
        String string = pSDEChart.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEChart, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEChart pSDEChart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChart.isUserTag2Dirty() : !pSDEChart.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEChart.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEChart, bl2, bl3);
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

    protected void onSyncEntity(PSDEChart pSDEChart, boolean bl) throws Exception {
        super.onSyncEntity(pSDEChart, bl);
    }

    protected void onSyncIndexEntities(PSDEChart pSDEChart, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEChart, bl);
    }

    public Object getDataContextValue(PSDEChart pSDEChart, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEChart, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEChart.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEChart pSDEChart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEChartAxes_PSDEChart(pSDEChart, arrayList, n);
        this.onExportRelatedModel_PSDEChartParam_PSDEChart(pSDEChart, arrayList, n);
        this.onExportRelatedModel_PSDEChartLogic_PSDEChart(pSDEChart, arrayList, n);
        super.onExportRelatedModel(pSDEChart, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEChartAxes_PSDEChart(PSDEChart pSDEChart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartAxes> arrayList2 = pSDEChartAxesService.selectByPSDEChart(pSDEChart);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"3d72284bb25534026ee7a62f173be187");
            jSONObject.put("srfdename", (Object)"PSDECHARTAXES");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDECHARTAXES_PSDECHART_PSDECHARTID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEChart, (String)"PSDECHARTID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEChartAxes pSDEChartAxes : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEChartAxes, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEChartAxesService.exportModel(pSDEChartAxes, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEChartParam_PSDEChart(PSDEChart pSDEChart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartParam> arrayList2 = pSDEChartParamService.selectByPSDEChart(pSDEChart);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"277fb9e091797f156695eb62b1154e31");
            jSONObject.put("srfdename", (Object)"PSDECHARTPARAM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDECHARTPARAM_PSDECHART_PSDECHARTID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEChart, (String)"PSDECHARTID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEChartParam pSDEChartParam : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEChartParam, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEChartParamService.exportModel(pSDEChartParam, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEChartLogic_PSDEChart(PSDEChart pSDEChart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEChartLogicService pSDEChartLogicService = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartLogic> arrayList2 = pSDEChartLogicService.selectByPSDEChart(pSDEChart);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"2e1df01951c758756d36d6afcd4f8863");
            jSONObject.put("srfdename", (Object)"PSDECHARTLOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDECHARTLOGIC_PSDECHART_PSDECHARTID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEChart, (String)"PSDECHARTID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEChartLogic pSDEChartLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEChartLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEChartLogicService.exportModel(pSDEChartLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEChart pSDEChart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_EmptyTextPSLanRes(pSDEChart, arrayList, n);
        this.onExportMajorModel_LNPSLanRes(pSDEChart, arrayList, n);
        this.onExportMajorModel_SubTitlePSLanRes(pSDEChart, arrayList, n);
        super.onExportMajorModel(pSDEChart, arrayList, n);
    }

    protected void onExportMajorModel_EmptyTextPSLanRes(PSDEChart pSDEChart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEChart.getEmptyTextPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEChart.getEmptyTextPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_LNPSLanRes(PSDEChart pSDEChart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEChart.getLNPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEChart.getLNPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_SubTitlePSLanRes(PSDEChart pSDEChart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEChart.getSubTitlePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEChart.getSubTitlePSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUSYINDICATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BusyIndicator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHARTMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ChartModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHARTTHEME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ChartTheme_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COORDINATESYSTEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CoordinateSystem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAGRIDPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataGridPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEGENDPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LegendPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMAXHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMaxHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMAXWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMaxWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMINHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMinHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMINWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMinWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWSHOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewShowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewWidth_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDECHARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCHARTTHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysChartThemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCHARTTHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysChartThemeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SHOWDATAGRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowDataGrid_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWLEGEND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowLegend_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWTITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowTitle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFSYSPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBTITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubTitle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBTITLEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubTitlePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBTITLEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubTitlePSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePos_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_BusyIndicator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ChartModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CHARTMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ChartTheme_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CHARTTHEME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CoordinateSystem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COORDINATESYSTEM", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_CustomCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCOND", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataGridPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAGRIDPOS", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyTextPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyTextPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LegendPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEGENDPOS", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LNPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LNPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_MinorSortPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMaxHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMaxWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMinHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMinWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWPOS", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewShowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEChartId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDECHARTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEChartName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDECHARTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDECHARTNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysChartThemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCHARTTHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysChartThemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCHARTTHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ShowDataGrid_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShowLegend_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShowTitle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SRFSysPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SubTitle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBTITLE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubTitlePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBTITLEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubTitlePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBTITLEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPOS", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEChart pSDEChart) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEChart)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEChart pSDEChart) throws Exception {
        Object object = pSDEChart.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDECHART_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEChart);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEChart pSDEChart, Object object) throws Exception {
        PSDEChart pSDEChart2 = new PSDEChart();
        pSDEChart2.set("PSDECHARTID", object);
        String string = DataObject.getStringValue((Object)pSDEChart.get("PSDECHARTID"));
        super.onCopyDetails(pSDEChart, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEChart pSDEChart, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDECHART");
        if (!bl) {
            super.exportCurXmlModel(pSDEChart, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEChart pSDEChart, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEChartAxes(pSDEChart, xmlNode);
        this.exportRelatedXmlModel_PSDEChartParam(pSDEChart, xmlNode);
        this.exportRelatedXmlModel_PSDEChartLogic(pSDEChart, xmlNode);
        super.onExportRelatedXmlModel(pSDEChart, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEChartAxes(PSDEChart pSDEChart, XmlNode xmlNode) throws Exception {
        PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartAxes> arrayList = null;
        String string = pSDEChart.getPSDEChartId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEChartAxesService.selectByPSDEChart(pSDEChart, "ORDER BY ORDERVALUE ASC") : pSDEChartAxesService.selectTempByPSDEChart(pSDEChart, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDECHARTAXESES");
            xmlNode.addNode(xmlNode2);
            for (PSDEChartAxes pSDEChartAxes : arrayList) {
                pSDEChartAxes.set("ORDERVALUE", null);
                pSDEChartAxesService.exportXmlModel(pSDEChartAxes, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEChartParam(PSDEChart pSDEChart, XmlNode xmlNode) throws Exception {
        PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartParam> arrayList = null;
        String string = pSDEChart.getPSDEChartId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEChartParamService.selectByPSDEChart(pSDEChart, "ORDER BY ORDERVALUE ASC") : pSDEChartParamService.selectTempByPSDEChart(pSDEChart, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDECHARTPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSDEChartParam pSDEChartParam : arrayList) {
                pSDEChartParam.set("ORDERVALUE", null);
                pSDEChartParamService.exportXmlModel(pSDEChartParam, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEChartLogic(PSDEChart pSDEChart, XmlNode xmlNode) throws Exception {
        PSDEChartLogicService pSDEChartLogicService = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartLogic> arrayList = null;
        String string = pSDEChart.getPSDEChartId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEChartLogicService.selectByPSDEChart(pSDEChart, "ORDER BY ORDERVALUE ASC") : pSDEChartLogicService.selectTempByPSDEChart(pSDEChart, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDECHARTLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSDEChartLogic pSDEChartLogic : arrayList) {
                pSDEChartLogic.set("ORDERVALUE", null);
                pSDEChartLogicService.exportXmlModel(pSDEChartLogic, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEChart pSDEChart, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDECHARTAXESES");
        this.importRelatedXmlModel_PSDEChartAxes(pSDEChart, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDECHARTPARAMS");
        this.importRelatedXmlModel_PSDEChartParam(pSDEChart, xmlNode3);
        XmlNode xmlNode4 = xmlNode.getChildNodeByNodeName("PSDECHARTLOGICS");
        this.importRelatedXmlModel_PSDEChartLogic(pSDEChart, xmlNode4);
        super.onImportRelatedXmlModel(pSDEChart, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEChartAxes(PSDEChart pSDEChart, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEChart.getPSDEChartId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEChartAxesService.removeByPSDEChart(pSDEChart);
        } else {
            pSDEChartAxesService.removeTempByPSDEChart(pSDEChart);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEChartAxes pSDEChartAxes = new PSDEChartAxes();
                pSDEChartAxes.setOrderValue(n);
                n += 100;
                pSDEChartAxesService.fillParentInfo(pSDEChartAxes, "DER1N", "DER1N_PSDECHARTAXES_PSDECHART_PSDECHARTID", pSDEChart.getPSDEChartId());
                pSDEChartAxesService.importXmlModel(pSDEChartAxes, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEChartParam(PSDEChart pSDEChart, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEChart.getPSDEChartId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEChartParamService.removeByPSDEChart(pSDEChart);
        } else {
            pSDEChartParamService.removeTempByPSDEChart(pSDEChart);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEChartParam pSDEChartParam = new PSDEChartParam();
                pSDEChartParam.setOrderValue(n);
                n += 100;
                pSDEChartParamService.fillParentInfo(pSDEChartParam, "DER1N", "DER1N_PSDECHARTPARAM_PSDECHART_PSDECHARTID", pSDEChart.getPSDEChartId());
                pSDEChartParamService.importXmlModel(pSDEChartParam, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEChartLogic(PSDEChart pSDEChart, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEChartLogicService pSDEChartLogicService = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEChart.getPSDEChartId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEChartLogicService.removeByPSDEChart(pSDEChart);
        } else {
            pSDEChartLogicService.removeTempByPSDEChart(pSDEChart);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEChartLogic pSDEChartLogic = new PSDEChartLogic();
                pSDEChartLogic.setOrderValue(n);
                n += 100;
                pSDEChartLogicService.fillParentInfo(pSDEChartLogic, "DER1N", "DER1N_PSDECHARTLOGIC_PSDECHART_PSDECHARTID", pSDEChart.getPSDEChartId());
                pSDEChartLogicService.importXmlModel(pSDEChartLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEChart pSDEChart, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEChart, string);
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
            return "DER1N_PSDECHART_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEChart pSDEChart) {
        if (!StringHelper.isNullOrEmpty((String)pSDEChart.getPSDEChartName())) {
            return pSDEChart.getPSDEChartName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEChart.getCodeName())) {
            return pSDEChart.getCodeName();
        }
        return super.getModelV2Tag(pSDEChart);
    }

    @Override
    public boolean setModelV2Tag(PSDEChart pSDEChart, String string) {
        pSDEChart.setPSDEChartName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDECHARTNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDECHARTNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEChart pSDEChart, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEChart.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEChart, true);
        pSDEChart.set("PSDECHARTNAME", string);
        if (this.select(pSDEChart, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEChart, true);
        return super.getModelV2Entity(pSDEChart, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEChart pSDEChart, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEChart, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDECHARTAXES_PSDECHART_PSDECHARTID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDECHARTPARAM_PSDECHART_PSDECHARTID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDECHARTLOGIC_PSDECHART_PSDECHARTID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEChart pSDEChart, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEChart, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEChart pSDEChart, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDECHARTAXES_PSDECHART_PSDECHARTID")) {
            pSCoreSysServiceBase = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDECHART#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDECHARTAXES", (Object)pSDEChart.getPSDEChartId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDECHART#%1$s", (Object)pSDEChart.getPSDEChartId());
                for (PSDEChartAxes axes : ((PSDEChartAxesServiceBase)pSCoreSysServiceBase).selectByPSDEChart(pSDEChart)) {
                    String entityScope = ((PSDEChartAxesServiceBase)pSCoreSysServiceBase).getModelV2ResScope(axes);
                    if (StringHelper.compare((String)scope, (String)entityScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(axes, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode exported = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdechartaxesname")) {
                            string = objectNode.get("psdechartaxesname").asText();
                        }
                        if (objectNode2.has("psdechartaxesname")) {
                            string2 = objectNode2.get("psdechartaxesname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode item : arrayList) {
                    PSDEChartAxes axes = new PSDEChartAxes();
                    PSModelV2Helper.fromJSONObject((IDataObject)axes, item, false);
                    exported.add((JsonNode)pSCoreSysServiceBase.exportModelV2(axes, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDECHARTPARAM_PSDECHART_PSDECHARTID")) {
            pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDECHART#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDECHARTPARAM", (Object)pSDEChart.getPSDEChartId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDECHART#%1$s", (Object)pSDEChart.getPSDEChartId());
                for (PSDEChartParam param : ((PSDEChartParamServiceBase)pSCoreSysServiceBase).selectByPSDEChart(pSDEChart)) {
                    String entityScope = ((PSDEChartParamServiceBase)pSCoreSysServiceBase).getModelV2ResScope(param);
                    if (StringHelper.compare((String)scope, (String)entityScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(param, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode exported = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdechartparamname")) {
                            string = objectNode.get("psdechartparamname").asText();
                        }
                        if (objectNode2.has("psdechartparamname")) {
                            string2 = objectNode2.get("psdechartparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode item : arrayList) {
                    PSDEChartParam param = new PSDEChartParam();
                    PSModelV2Helper.fromJSONObject((IDataObject)param, item, false);
                    exported.add((JsonNode)pSCoreSysServiceBase.exportModelV2(param, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDECHARTLOGIC_PSDECHART_PSDECHARTID")) {
            pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDECHART#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDECHARTLOGIC", (Object)pSDEChart.getPSDEChartId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDECHART#%1$s", (Object)pSDEChart.getPSDEChartId());
                for (PSDEChartLogic logic : ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).selectByPSDEChart(pSDEChart)) {
                    String entityScope = ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(logic);
                    if (StringHelper.compare((String)scope, (String)entityScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(logic, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode exported = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdechartlogicname")) {
                            string = objectNode.get("psdechartlogicname").asText();
                        }
                        if (objectNode2.has("psdechartlogicname")) {
                            string2 = objectNode2.get("psdechartlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode item : arrayList) {
                    PSDEChartLogic logic = new PSDEChartLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)logic, item, false);
                    exported.add((JsonNode)pSCoreSysServiceBase.exportModelV2(logic, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEChart, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEChart pSDEChart) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartAxes> axesList = ((PSDEChartAxesServiceBase)pSCoreSysServiceBase).selectByPSDEChart(pSDEChart);
        String string2 = StringHelper.format((String)"PSDECHART#%1$s", (Object)pSDEChart.getPSDEChartId());
        for (PSDEChartAxes axes : axesList) {
            string = ((PSDEChartAxesServiceBase)pSCoreSysServiceBase).getModelV2ResScope(axes);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(axes);
        }
        SqlParamList params = new SqlParamList();
        params.addString(pSDEChart.getPSDEChartId());
        ((PSDEChartAxesServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEChartAxesServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDECHARTAXES WHERE PSDECHARTID = ?", params);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartParam> chartParams = ((PSDEChartParamServiceBase)pSCoreSysServiceBase).selectByPSDEChart(pSDEChart);
        string2 = StringHelper.format((String)"PSDECHART#%1$s", (Object)pSDEChart.getPSDEChartId());
        for (PSDEChartParam pSDEChartParam : chartParams) {
            string = ((PSDEChartParamServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEChartParam);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEChartParam);
        }
        params = new SqlParamList();
        params.addString(pSDEChart.getPSDEChartId());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDECHARTPARAM WHERE PSDECHARTID = ?", params);
        pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartLogic> logics = ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).selectByPSDEChart(pSDEChart);
        string2 = StringHelper.format((String)"PSDECHART#%1$s", (Object)pSDEChart.getPSDEChartId());
        for (PSDEChartLogic pSDEChartLogic : logics) {
            string = ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEChartLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEChartLogic);
        }
        params = new SqlParamList();
        params.addString(pSDEChart.getPSDEChartId());
        ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDECHARTLOGIC WHERE PSDECHARTID = ?", params);
        super.onEmptyModelV2(pSDEChart);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEChart pSDEChart, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEChartAxes();
        entityBase.set("PSDECHARTID", pSDEChart.getPSDEChartId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEChartParam();
        entityBase.set("PSDECHARTID", pSDEChart.getPSDEChartId());
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEChartLogic();
        entityBase.set("PSDECHARTID", pSDEChart.getPSDEChartId());
        pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEChart, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEChart pSDEChart, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEChartAxesService axesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = axesService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode item = (ObjectNode)arrayNode.get(i);
                PSDEChartAxes axes = new PSDEChartAxes();
                axes.setPSDEChartId(pSDEChart.getPSDEChartId());
                axes.setPSDEChartName(pSDEChart.getPSDEChartName());
                axes.setPSDEId(pSDEChart.getPSDEId());
                axesService.compileModelV2(axes, item, string, null, n);
            }
        } else {
            File directory = new File(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3));
            if (directory.exists()) {
                File[] folders = directory.listFiles();
                if (folders != null) {
                    for (File folder : folders) {
                        if (!folder.isDirectory()) continue;
                        PSDEChartAxes axes = new PSDEChartAxes();
                        axes.setPSDEChartId(pSDEChart.getPSDEChartId());
                        axes.setPSDEChartName(pSDEChart.getPSDEChartName());
                        axes.setPSDEId(pSDEChart.getPSDEId());
                        axesService.compileModelV2(axes, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        PSDEChartParamService paramService = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = paramService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode item = (ObjectNode)arrayNode.get(i);
                PSDEChartParam param = new PSDEChartParam();
                param.setPSDEChartId(pSDEChart.getPSDEChartId());
                param.setPSDEChartName(pSDEChart.getPSDEChartName());
                param.setPSDEId(pSDEChart.getPSDEId());
                paramService.compileModelV2(param, item, string, null, n);
            }
        } else {
            File directory = new File(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3));
            if (directory.exists()) {
                File[] folders = directory.listFiles();
                if (folders != null) {
                    for (File folder : folders) {
                        if (!folder.isDirectory()) continue;
                        PSDEChartParam param = new PSDEChartParam();
                        param.setPSDEChartId(pSDEChart.getPSDEChartId());
                        param.setPSDEChartName(pSDEChart.getPSDEChartName());
                        param.setPSDEId(pSDEChart.getPSDEId());
                        paramService.compileModelV2(param, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        PSDEChartLogicService logicService = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = logicService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode item = (ObjectNode)arrayNode.get(i);
                PSDEChartLogic logic = new PSDEChartLogic();
                logic.setPSDEChartId(pSDEChart.getPSDEChartId());
                logic.setPSDEChartName(pSDEChart.getPSDEChartName());
                logicService.compileModelV2(logic, item, string, null, n);
            }
        } else {
            File directory = new File(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3));
            if (directory.exists()) {
                File[] folders = directory.listFiles();
                if (folders != null) {
                    for (File folder : folders) {
                        if (!folder.isDirectory()) continue;
                        PSDEChartLogic logic = new PSDEChartLogic();
                        logic.setPSDEChartId(pSDEChart.getPSDEChartId());
                        logic.setPSDEChartName(pSDEChart.getPSDEChartName());
                        logicService.compileModelV2(logic, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEChart, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEChart pSDEChart, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDECHARTAXES_PSDECHART_PSDECHARTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEChartAxeses(pSDEChart, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDECHARTPARAM_PSDECHART_PSDECHARTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEChartParams(pSDEChart, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDECHARTLOGIC_PSDECHART_PSDECHARTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEChartLogics(pSDEChart, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEChart, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEChartAxeses(PSDEChart pSDEChart, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDECHARTAXES", true), (boolean)false) == 0) {
            PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
            PSDEChartAxes pSDEChartAxes = new PSDEChartAxes();
            pSDEChartAxes.setPSDEChartAxesId(pSMOSFile.getPSModelId());
            if (!pSDEChartAxesService.get(pSDEChartAxes, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEChartAxes.getPSDEChartId(), (String)pSDEChart.getPSDEChartId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEChartAxesService.exportModelV2(pSDEChartAxes);
            pSDEChartAxes.reset();
            if (!pSDEChartAxesService.setModelV2ResScope(pSDEChartAxes, "PSDECHART", pSDEChart.getPSDEChartId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEChartAxesService.importModelV2(pSDEChartAxes, objectNode);
            SessionFactoryManager.commit();
            return pSDEChartAxesService.getFile(pSDEChartAxes);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEChartParams(PSDEChart pSDEChart, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDECHARTPARAM", true), (boolean)false) == 0) {
            PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
            PSDEChartParam pSDEChartParam = new PSDEChartParam();
            pSDEChartParam.setPSDEChartParamId(pSMOSFile.getPSModelId());
            if (!pSDEChartParamService.get(pSDEChartParam, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEChartParam.getPSDEChartId(), (String)pSDEChart.getPSDEChartId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEChartParamService.exportModelV2(pSDEChartParam);
            pSDEChartParam.reset();
            if (!pSDEChartParamService.setModelV2ResScope(pSDEChartParam, "PSDECHART", pSDEChart.getPSDEChartId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEChartParamService.importModelV2(pSDEChartParam, objectNode);
            SessionFactoryManager.commit();
            return pSDEChartParamService.getFile(pSDEChartParam);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEChartLogics(PSDEChart pSDEChart, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDECHARTLOGIC", true), (boolean)false) == 0) {
            PSDEChartLogicService pSDEChartLogicService = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDEChartLogic pSDEChartLogic = new PSDEChartLogic();
            pSDEChartLogic.setPSDEChartLogicId(pSMOSFile.getPSModelId());
            if (!pSDEChartLogicService.get(pSDEChartLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEChartLogic.getPSDEChartId(), (String)pSDEChart.getPSDEChartId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEChartLogicService.exportModelV2(pSDEChartLogic);
            pSDEChartLogic.reset();
            if (!pSDEChartLogicService.setModelV2ResScope(pSDEChartLogic, "PSDECHART", pSDEChart.getPSDEChartId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEChartLogicService.importModelV2(pSDEChartLogic, objectNode);
            SessionFactoryManager.commit();
            return pSDEChartLogicService.getFile(pSDEChartLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEChart pSDEChart, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEChartAxeses(pSDEChart, list);
        this.onFillPasteHelps_PSDEChartParams(pSDEChart, list);
        this.onFillPasteHelps_PSDEChartLogics(pSDEChart, list);
        super.onFillPasteHelps(pSDEChart, list);
    }

    protected void onFillPasteHelps_PSDEChartAxeses(PSDEChart pSDEChart, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDECHARTAXES");
        pSHelpSection.setSectionParam2("DER1N_PSDECHARTAXES_PSDECHART_PSDECHARTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u56fe\u8868]\u7684[\u5b9e\u4f53\u56fe\u8868\u5750\u6807\u8f74]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEChartParams(PSDEChart pSDEChart, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDECHARTPARAM");
        pSHelpSection.setSectionParam2("DER1N_PSDECHARTPARAM_PSDECHART_PSDECHARTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u56fe\u8868]\u7684[\u5b9e\u4f53\u56fe\u8868\u6570\u636e\u5e8f\u5217]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEChartLogics(PSDEChart pSDEChart, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDECHARTLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDECHARTLOGIC_PSDECHART_PSDECHARTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u56fe\u8868]\u7684[\u5b9e\u4f53\u56fe\u8868\u903b\u8f91]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEChart pSDEChart, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("PSDECHARTNAME", "Chart");
    }
}
